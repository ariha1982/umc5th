package umc.study.converter;

import lombok.RequiredArgsConstructor;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

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
}
