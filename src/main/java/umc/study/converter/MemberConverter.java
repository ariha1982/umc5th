package umc.study.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.enums.Gender;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@RequiredArgsConstructor
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

    public static MemberResponseDTO.MemberReviewPreViewDTO memberReviewPreViewDTO(Review review){
        return MemberResponseDTO.MemberReviewPreViewDTO.builder()
                .reviewerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }
    public static MemberResponseDTO.MemberReviewPreViewListDTO memberReviewPreViewListDTO(Page<Review> reviewList){

        List<MemberResponseDTO.MemberReviewPreViewDTO> memberReviewPreViewDTOList = reviewList.stream()
                .map(MemberConverter::memberReviewPreViewDTO).collect(Collectors.toList());

        return MemberResponseDTO.MemberReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(memberReviewPreViewDTOList.size())
                .reviewList(memberReviewPreViewDTOList)
                .build();
    }

    public static MemberResponseDTO.MemberMissionPreViewDTO memberMissionPreViewDTO(MemberMission memberMission){
        return MemberResponseDTO.MemberMissionPreViewDTO.builder()
                .storeName(memberMission.getMission().getStore().getName())
                .reward(memberMission.getMission().getReward())
                .createdAt(memberMission.getCreatedAt().toLocalDate())
                .deadline(memberMission.getMission().getDeadline())
                .missionSpec(memberMission.getMission().getMission_spec())
                .build();
    }
    public static MemberResponseDTO.MemberMissionPreViewListDTO memberMissionPreViewListDTO(Page<MemberMission> memberMissionList){

        List<MemberResponseDTO.MemberMissionPreViewDTO> memberMissionPreViewDTOList = memberMissionList.stream()
                .map(MemberConverter::memberMissionPreViewDTO).collect(Collectors.toList());

        return MemberResponseDTO.MemberMissionPreViewListDTO.builder()
                .isLast(memberMissionList.isLast())
                .isFirst(memberMissionList.isFirst())
                .totalPage(memberMissionList.getTotalPages())
                .totalElements(memberMissionList.getTotalElements())
                .listSize(memberMissionPreViewDTOList.size())
                .missionList(memberMissionPreViewDTOList)
                .build();
    }
}
