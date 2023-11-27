package umc.study.web.dto;

import lombok.Getter;
import umc.study.validation.annotaion.ExistStore;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ReviewRequestDTO {

    @Getter
    public static class PostDTO {
        //@ExistMember
        Long memberId;
        @ExistStore
        Long storeId;
        @Size(min = 5, max = 200)
        String body;
        @NotNull
        Float score;
    }
}
