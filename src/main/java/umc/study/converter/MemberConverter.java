package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.enums.Gender;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResult(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDTO request) {
        Gender gender = null;

        switch (request.getGender()){
            case "F":
                gender = Gender.F;
                break;
            case "M":
                gender = Gender.M;
                break;
            case "U":
                gender = Gender.U;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .spec_address(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .birthdate(request.getBirthdate())
                .age(request.getAge())
                .memberPreferList(new ArrayList<>())
                .build();
    }
}
