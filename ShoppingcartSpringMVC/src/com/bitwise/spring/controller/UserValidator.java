package com.bitwise.spring.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> obj) {
		return UserBean.class.equals(obj.getClass());
	}

	@Override
	public void validate(Object obj, Errors errors) {
		UserBean user = (UserBean) obj;
		Users vuser=new Users();
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "errors.username", "Username is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "errors.password", "Password is required");
		
		String vusername=user.getUsername();
		String vpasswrd=user.getPassword();
		
		boolean isNotValidLength = user.getUsername().length() < 3;
		
		boolean isValidUser = vuser.getUsers().containsKey(vusername);
		boolean isValidPasswrd = vuser.getUsers().containsValue(vpasswrd);
		
		if (isNotValidLength)
			errors.rejectValue("username", "insufficient", "Username must be atleast 3 chars long");
		String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=*])(?=\\S+$).{6,}$";
		boolean isValidPasswordForm = user.getPassword().matches(regex);

		String errorMessage = "Password should be atleast 6 chars \n" 
				+ "It should include one or more digits\n"
				+ "it should include one or more upper case charracter\n"
				+ "it should include one or more lower case charracter\n"
				+ "It should include any one special character from the following(!,@,#,$,%,^,&,*)\n";

		if (!isValidPasswordForm)
			errors.rejectValue("password", "invalidPassword", errorMessage);
		if(!isValidUser)
			errors.rejectValue("username", "invalid user", " Not a valid user");
		if(!isValidPasswrd)
			errors.rejectValue("password", "invalid password", " Not a valid password");

	}

}