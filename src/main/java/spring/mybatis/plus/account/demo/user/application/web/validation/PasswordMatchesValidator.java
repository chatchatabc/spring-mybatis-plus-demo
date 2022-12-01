package spring.mybatis.plus.account.demo.user.application.web.validation;

import spring.mybatis.plus.account.demo.user.application.commons.dto.UserRegisDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UserRegisDto user = (UserRegisDto) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
