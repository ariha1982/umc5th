package umc.study.web.dto;

import lombok.Getter;
import umc.study.validation.annotaion.ExistCategories;
import umc.study.validation.annotaion.ExistMember;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDTO {
        @NotBlank
        String name;
        @NotBlank
        String gender;
        @NotNull
        LocalDate birthdate;
        @NotNull
        Integer age;
        @Size(min = 5, max = 12)
        String address;
        @Size(min = 5, max = 12)
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
    }

    @Getter
    public static class AddMissionDTO {
        @ExistMember
        Long memberId;
        //@CheckMissionStatus
        Long missionId;
    }
}
