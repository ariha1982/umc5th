package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDTO.CreateMissionResultDTO toCreateResultDTO(Mission mission){
        return MissionResponseDTO.CreateMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.CreateMissionDTO request, Store store){
        return Mission.builder()
                .deadline(request.getDeadline())
                .mission_spec(request.getMission_spec())
                .reward(request.getReward())
                .store(store)
                .build();
    }
}
