package com.construction.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.construction.entity.User;
import com.construction.service.UserService;

@Component
public class UserValidator implements Validator {

	private UserService userService;
	
	@Autowired
	public UserValidator(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
		User foundUserByEmail = userService.getByEmail(user.getEmail());
		if (foundUserByEmail != null && !foundUserByEmail.getId().equals(user.getId())) {
            errors.rejectValue("email", "Duplicate.userForm.email");
        }
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "personalInfo.addressLine1", "NotEmpty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "personalInfo.city", "NotEmpty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "personalInfo.postalCode", "NotEmpty");
		if (user.getPersonalInfo().getPostalCode().length() != 5) {
            errors.rejectValue("personalInfo.postalCode", "Size.userForm.postalCode");
        }
		
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        User foundUserByUsername = userService.getByUsername(user.getUsername());
        if (foundUserByUsername != null && !foundUserByUsername.getId().equals(user.getId())) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }
        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "Diff.userForm.confirmPassword");
        }
        
	}

}
