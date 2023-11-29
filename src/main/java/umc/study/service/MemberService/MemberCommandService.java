package umc.study.service.MemberService;

import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Member;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDTO request);

    @Transactional
    MemberMission addMemberMission(MemberRequestDTO.AddMissionDTO request);
}
