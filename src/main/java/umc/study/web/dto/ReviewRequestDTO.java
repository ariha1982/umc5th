package umc.study.web.dto;

import lombok.Getter;
import umc.study.domain.Member;
import umc.study.domain.Store;
import umc.study.validation.annotaion.ExistStore;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ReviewRequestDTO {

    @Getter
    public static class PostDTO {
        @NotNull
        Long memberId;
        @NotNull
        @ExistStore
        Long storeId;
        @Size(min = 5, max = 200)
        String body;
        @NotNull
        Float score;
    }
}
