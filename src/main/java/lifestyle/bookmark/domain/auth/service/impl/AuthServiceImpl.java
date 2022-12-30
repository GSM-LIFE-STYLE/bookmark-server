package lifestyle.bookmark.domain.auth.service.impl;

import lifestyle.bookmark.domain.auth.exception.EmailExistsException;
import lifestyle.bookmark.domain.member.domain.repository.MemberRepository;
import lifestyle.bookmark.domain.member.facade.MemberFacade;
import lifestyle.bookmark.domain.auth.presentation.dto.request.SignUpMemberRequest;
import lifestyle.bookmark.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final MemberRepository memberRepository;
    private final MemberFacade memberFacade;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void signUp(SignUpMemberRequest request) {
        if(memberRepository.existsByEmail(request.getEmail()))
            throw new EmailExistsException("이메일이 이미 존재합니다.");

        memberRepository.save(request.toEntity());
    }
}
