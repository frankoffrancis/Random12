package apollo.custom.annotations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserNameValidator implements ConstraintValidator <UserNameConstraint, String>{

	public static final Pattern VALID_USERNAME_REGEX =Pattern
			.compile("[a-zA-Z0-9\\._\\-]{3,}");
	
	public static boolean validate(String userName) {
		Matcher matcher = VALID_USERNAME_REGEX.matcher(userName);
		return matcher.find();
	}
	@Override
	public void initialize(UserNameConstraint constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return (validate(arg0)
				&& (arg0.length()>3));
	}

}
