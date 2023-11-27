package umc.study.web.dto;

import lombok.Getter;
import umc.study.validation.annotaion.ExistRegion;

import javax.validation.constraints.NotBlank;

public class StoreRequestDTO {

    @Getter
    public static class CreateDTO {
        @NotBlank
        String address;
        @NotBlank
        String name;
        @ExistRegion
        Long regionId;
    }
}
