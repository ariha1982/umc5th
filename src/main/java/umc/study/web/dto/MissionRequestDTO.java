package umc.study.web.dto;

import lombok.Getter;
import umc.study.validation.annotaion.ExistStore;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class CreateMissionDTO {
        @NotNull
        LocalDate deadline;
        @Size(min=  5, max = 200)
        String mission_spec;
        @NotNull
        Integer reward;
        @ExistStore
        Long store_id;
    }
}
