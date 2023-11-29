package umc.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.enums.MStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.ReviewRepository;

import java.util.Optional;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final MemberMissionRepository memberMissionRepository;
    @Override
    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Page<Review> getMemberReviewList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();
        Page<Review> MemberPage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
        return MemberPage;
    }

    @Override
    public Page<MemberMission> getMemberMissionList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();

        Page<MemberMission> MissionPage = memberMissionRepository.findAllByMemberAndStatus(member, MStatus.ING, PageRequest.of(page, 10));
        return MissionPage;
    }
}
