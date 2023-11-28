package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;

public class MemberMissionConverter {

    public static MemberResponseDTO.AddMissionResultDTO toAddMissionResult(MemberMission memberMission) {
        return MemberResponseDTO.AddMissionResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .cratedAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toMemberMission(MemberRequestDTO.AddMissionDTO request, Member member, Mission mission){
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .build();
    }
}
