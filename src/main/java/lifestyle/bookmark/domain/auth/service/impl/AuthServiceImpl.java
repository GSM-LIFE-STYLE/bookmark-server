package lifestyle.bookmark.domain.auth.service.impl;

import lifestyle.bookmark.domain.auth.exception.EmailExistsException;
import lifestyle.bookmark.domain.auth.exception.LoginIdExistsException;
import lifestyle.bookmark.domain.auth.presentation.dto.request.LoginMemberRequest;
import lifestyle.bookmark.domain.auth.presentation.dto.response.TokenResponse;
import lifestyle.bookmark.domain.member.domain.Member;
import lifestyle.bookmark.domain.member.domain.repository.MemberRepository;
import lifestyle.bookmark.domain.member.exception.MemberNotFoundException;
import lifestyle.bookmark.domain.member.facade.MemberFacade;
import lifestyle.bookmark.domain.auth.presentation.dto.request.SignUpMemberRequest;
import lifestyle.bookmark.domain.auth.service.AuthService;
import lifestyle.bookmark.global.role.Role;
import lifestyle.bookmark.global.security.jwt.JwtTokenProvider;
import lifestyle.bookmark.global.security.jwt.properties.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final MemberRepository memberRepository;
    private final MemberFacade memberFacade;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void signUp(SignUpMemberRequest request) {

        verifyMember(request);

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
                .expireAt(jwtTokenProvider.getExpiredAtToken(accessToken, jwtProperties.getAccessSecret()))
                .build();
    }

    private void verifyMember(SignUpMemberRequest request) {

        if(memberRepository.existsByEmail(request.getEmail()))
            throw new EmailExistsException("이메일이 이미 존재합니다.");

        if(memberRepository.existsByLoginId(request.getLoginId()))
            throw new LoginIdExistsException("아이디가 이미 존재합니다.");

    }
}
