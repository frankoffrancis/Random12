package apollo.custom.annotations;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import java.util.regex.Matcher;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {

	public static final Pattern VALID_PASSWORD_REGEX =Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{5,}$",Pattern.CASE_INSENSITIVE);
	
	public static boolean validate(String passwordString) {
		Matcher matcher = VALID_PASSWORD_REGEX.matcher(passwordString);
		return matcher.find();
	}
	@Override
	public void initialize(PasswordConstraint constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext context) {
		return (validate(arg0)
				&& (arg0.length()>=5));
	}
	
}
