package umc.study.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository;
import umc.study.validation.annotaion.CheckMissionStatus;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MissionStatusCheckValidator implements ConstraintValidator<CheckMissionStatus, Long> {
    private final MemberMissionRepository memberMissionRepository;
    @Override
    public void initialize(CheckMissionStatus constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = true;
        List<MemberMission> isExist = memberMissionRepository.findByMissionId(value); //에러남

        //해당 미션이 존재하며 상태가 진행중일 때
        /*if (isExist.isPresent() && Objects.equals(isExist.get().getStatus().toString(), "ING")) {
            isValid = false;
        }*/

        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_ING.getMessage()).addConstraintViolation();
        }

        return isValid;
    }
}
