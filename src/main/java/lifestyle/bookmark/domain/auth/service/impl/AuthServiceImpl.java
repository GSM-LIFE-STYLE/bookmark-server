package lifestyle.bookmark.domain.auth.service.impl;

import lifestyle.bookmark.domain.auth.domain.RefreshToken;
import lifestyle.bookmark.domain.auth.domain.repository.RefreshTokenRepository;
import lifestyle.bookmark.domain.auth.exception.EmailExistsException;
import lifestyle.bookmark.domain.auth.exception.LoginIdExistsException;
import lifestyle.bookmark.domain.auth.exception.RefreshTokenNotFoundException;
import lifestyle.bookmark.domain.auth.presentation.dto.request.LoginMemberRequest;
import lifestyle.bookmark.domain.auth.presentation.dto.response.TokenResponse;
import lifestyle.bookmark.domain.email.domain.EmailAuth;
import lifestyle.bookmark.domain.email.domain.repository.EmailAuthRepository;
import lifestyle.bookmark.domain.email.exception.NotVerifyEmailException;
import lifestyle.bookmark.domain.member.domain.Member;
import lifestyle.bookmark.domain.member.domain.repository.MemberRepository;
import lifestyle.bookmark.domain.member.exception.MemberNotFoundException;
import lifestyle.bookmark.domain.member.facade.MemberFacade;
import lifestyle.bookmark.domain.auth.presentation.dto.request.SignUpMemberRequest;
import lifestyle.bookmark.domain.auth.service.AuthService;
import lifestyle.bookmark.global.role.Role;
import lifestyle.bookmark.global.security.exception.TokenNotValidException;
import lifestyle.bookmark.global.security.jwt.JwtTokenProvider;
import lifestyle.bookmark.global.security.jwt.properties.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final MemberRepository memberRepository;
    private final MemberFacade memberFacade;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;
    private final EmailAuthRepository emailAuthRepository;
    private final RefreshTokenRepository refreshTokenRepository;

    private void verifyMember(SignUpMemberRequest request) {

        if(memberRepository.existsByEmail(request.getEmail()))
            throw new EmailExistsException("이메일이 이미 존재합니다.");

        if(memberRepository.existsByLoginId(request.getLoginId()))
            throw new LoginIdExistsException("아이디가 이미 존재합니다.");

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void signUp(SignUpMemberRequest request) {

        verifyMember(request);

        EmailAuth emailAuth = emailAuthRepository.findById(request.getEmail())
                .orElseThrow(() -> new NotVerifyEmailException("인증되지 않은 이메일입니다."));

        if(!emailAuth.getAuthentication()){
            throw new NotVerifyEmailException("인증되지 않은 이메일입니다.");
        }

        Member member = Member.builder()
                .loginId(request.getLoginId())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .email(request.getEmail())
                .role(Role.ADMIN)
                .build();

        memberRepository.save(member);
    }

    @Override
    public TokenResponse login(LoginMemberRequest request) {
        Member member = memberRepository.findByLoginId(request.getLoginId())
                .orElseThrow(() -> new MemberNotFoundException("존재하지 않는 회원입니다."));

        memberFacade.checkPassword(member, request.getPassword());

        String accessToken = jwtTokenProvider.generatedAccessToken(member.getEmail());
        String refreshToken = jwtTokenProvider.generatedRefreshToken(member.getEmail());

        return TokenResponse.builder()
                .accessToken(accessToken).refreshToken(refreshToken)
                .expiredAt(jwtTokenProvider.getExpiredAtToken(accessToken, jwtProperties.getAccessSecret()))
                .build();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TokenResponse reissue(String requestToken) {
        String email = jwtTokenProvider.getUserEmail(requestToken, jwtProperties.getRefreshSecret());
        RefreshToken token = refreshTokenRepository.findById(email)
                .orElseThrow(() -> new RefreshTokenNotFoundException("리프레시 토큰을 찾을 수 없습니다."));

        if(!token.getToken().equals(requestToken)) {
            throw new TokenNotValidException("검증되지 않은 토큰입니다.");
        }

        String accessToken = jwtTokenProvider.generatedAccessToken(email);
        String refreshToken = jwtTokenProvider.generatedRefreshToken(email);
        ZonedDateTime expiredAt = jwtTokenProvider.getExpiredAtToken(accessToken, jwtProperties.getAccessSecret());
        token.exchangeRefreshToken(refreshToken);
        refreshTokenRepository.save(token);

        return TokenResponse
                .builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .expiredAt(expiredAt)
                .build();
    }
}
