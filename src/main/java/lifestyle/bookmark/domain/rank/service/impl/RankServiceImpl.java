package lifestyle.bookmark.domain.rank.service.impl;

import lifestyle.bookmark.domain.member.domain.repository.MemberRepository;
import lifestyle.bookmark.domain.rank.domain.repository.RankRepository;
import lifestyle.bookmark.domain.rank.service.RankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RankServiceImpl implements RankService {

    private final MemberRepository memberRepository;
    private final RankRepository rankRepository;

    @Override
    public void createPageRank() {

    }

    @Override
    public void createBookRank() {

    }
}
