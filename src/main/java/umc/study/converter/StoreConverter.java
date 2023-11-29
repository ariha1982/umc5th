package umc.study.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Region;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class StoreConverter {

    public static StoreResponseDTO.CreateResultDTO toCreateResultDTO(Store store) {
        return StoreResponseDTO.CreateResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.CreateDTO request, Region region) {
        Float score = 0.0F;
        return Store.builder()
                .address(request.getAddress())
                .name(request.getName())
                .score(score)
                .region(region)
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static StoreResponseDTO.StoreMissionPreViewDTO storeMissionPreViewDTO(Mission mission){
        return StoreResponseDTO.StoreMissionPreViewDTO.builder()
                .ownerNickname(mission.getStore().getName())
                .reward(mission.getReward())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMission_spec())
                .build();
    }
    public static StoreResponseDTO.StoreMissionPreViewListDTO storeMissionPreViewListDTO(Page<Mission> missionList){

        List<StoreResponseDTO.StoreMissionPreViewDTO> storeMissionPreViewDTOList = missionList.stream()
                .map(StoreConverter::storeMissionPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.StoreMissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(storeMissionPreViewDTOList.size())
                .missionList(storeMissionPreViewDTOList)
                .build();
    }
}
