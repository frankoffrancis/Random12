package apollo.custom.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = UserNameValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME) 
public @interface UserNameConstraint {

	String message() default "Can not be empty and must be at least 3 characters";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default {};
}
