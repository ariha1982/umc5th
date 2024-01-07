package umc.study.validation.annotaion;

import umc.study.validation.validator.PageCheckValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageCheckValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER } )
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {
    String message() default "page에는 1 이상의 값을 넣어주세요";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
