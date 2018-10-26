
/*
 * Copyright (c) 2018. This project begin with the difficulty of using hard copy form. As years has passed, many of
 * wasted form were dump into the store. In order to solve the problem. I decide to build an Android app for operating
 * hour and vehicle millage. This app is only used within the company community.
 */

package utility;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.widget.AutoCompleteTextView;

import java.util.regex.Pattern;

import model.site.Site;

/**
 *
 * This class contain static method entirely. It contain classes that return
 * the validation of each field
 * @author Adam
 * @since 19/10/2018
 */

public class ValidationUtility {



    /**
     * To validate email input text field. The email must not be empty.
     * Return true if the email is valid, else return false
     * @param emailEditText TextInputEditText for email
     * @param emailLayout TextInputLayout for email
     * @return true is the email is valid , else return false
     */
    public static boolean validateEmail(TextInputEditText emailEditText, TextInputLayout emailLayout){

        String email = emailEditText.getText().toString();

        if(email.isEmpty()){
            emailLayout.setError("Please input your email");
            return false;
        }else if(!Pattern.matches("^(.+)@(.+)$",email)){
            emailLayout.setError("Please input a valid email");
            return false;
        }else{
            emailLayout.setErrorEnabled(false);
        }

        return true;
    }

    /**
     * Validate the username input text field. The username input must not be empty,
     * otherwise it return false
     * @param nameInput TextInputEditText for username
     * @param nameLayout TextInputLayout for username
     * @return true if the username is valid, else return false
     */
    public static boolean validateUsername(TextInputEditText nameInput, TextInputLayout nameLayout){

        String username = nameInput.getText().toString().trim();

        if(username.isEmpty()){
            nameLayout.setError("Please input your username");
            return false;
        }else{
            nameLayout.setErrorEnabled(false);
        }
        return true;
    }

    /**
     * Validate date input field. The date input must not be empty,
     * otherwise it return false
     * @param dateInput TextInputEditText for date field
     * @param dateLayout TextInputLayout for date field
     * @return true if the date is not empty and valid date
     */
    public static boolean validateDate(TextInputEditText dateInput,TextInputLayout dateLayout){

        if(dateInput.getText().toString().isEmpty()){
            dateLayout.setError("Please input your date");
            return false;
        }else if(Pattern.matches("\\d{2}/\\d{2}/\\d{4}",dateInput.getText().toString())){
            dateLayout.setError("Please input a valid date format");
            return false;
        }

        return true;

    }

    /**
     * Validate start meter hour and end meter hour. Both input must not be empty.
     * Check whether the end meter is greater than start meter.
     * @param startMeterLayout TextInputLayout for start meter
     * @param startMeterInput  TextInputEditText for start meter
     * @param endMeterLayout   TextInputLayout for end meter
     * @param endMeterInput    TextInputEditText for end meter
     * @return true if both start and end meter is numerical value,
     * not empty and end meter must greater than start meter
     */
    public static boolean validateMeterHour(TextInputLayout startMeterLayout, TextInputEditText startMeterInput
            , TextInputLayout endMeterLayout, TextInputEditText endMeterInput) {

            String startMeter = startMeterInput.getText().toString();
            String endMeter = endMeterInput.getText().toString();

            if(startMeter.isEmpty()){
                startMeterLayout.setError("Please input start meter");
                return false;
            }else if(!Pattern.matches("\\d+",startMeter)){
                startMeterLayout.setError("Invalid start meter");
                return false;
            }else{
                startMeterLayout.setErrorEnabled(false);
            }

            if(endMeter.isEmpty()){
                endMeterLayout.setError("Please input end meter");
                return false;
            }else if(!Pattern.matches("\\d+",endMeter)){
                endMeterLayout.setError("Invalid end meter");
                return false;
            }else{
                endMeterLayout.setErrorEnabled(false);
            }

            if(Integer.parseInt(startMeter)>Integer.parseInt(endMeter)){
                endMeterLayout.setError("End meter must be greater than start meter");
                return false;
            }else{
                endMeterLayout.setErrorEnabled(false);
            }

        return true;
    }

    /**
     * Validate password input from the login activity. The password field must
     * not be empty
     *
     * @param pwdLayout TextInputLayout for password field
     * @param pwdInput  TextInputEditText for password field
     * @return true if password is not empty
     */
    public static boolean validateLoginPassword(TextInputLayout pwdLayout, TextInputEditText pwdInput){

        String password = pwdInput.getText().toString();

        if(password.isEmpty()){
            pwdLayout.setError("Please input your password");
            return false;
        }else{
            pwdLayout.setErrorEnabled(false);
        }

        return true;
    }

    /**
     * Validate password input during sign up process. The password and confirm password
     * field must not be empty. Strong password is require as it must have combination of
     * at least one lowercase , one uppercase, one number, minimum 8 character. Return true
     * if the password input meet the requirement.
     *
     * @param pwdLayout TextInputLayout for password field
     * @param pwdInput TextInputEditText for password field
     * @param confirmPwdLayout TextInputLayout for confirmation password field
     * @param confirmPwdInput TextInputEditText for confirmation password field
     * @return true if the sign up password is valid
     */
    public static boolean validateSignUpPassword(TextInputLayout pwdLayout, TextInputEditText pwdInput,
                                                 TextInputLayout confirmPwdLayout, TextInputEditText confirmPwdInput) {

        String password = pwdInput.getText().toString().trim();
        String confirm = confirmPwdInput.getText().toString().trim();

        if(password.isEmpty()){
            pwdLayout.setError("Please input your password");
            return false;
        }else if(!Pattern.matches("((?=.*[a-z])(?=.*d)(?=.*[A-Z]).{8,24})",password)) {
            pwdLayout.setError("Password must at least one uppercase, one lowercase, one numeric, mininum 8 character");
            return false;
        }else{
            pwdLayout.setErrorEnabled(false);
        }

        if(confirm.isEmpty()){
            confirmPwdLayout.setError("Please input confirm password");
            return false;
        }else{
            confirmPwdLayout.setErrorEnabled(false);
        }

        if(!password.equals(confirm)){
            confirmPwdLayout.setError("Your password and confirm password not match");
            return false;
        }else{
            confirmPwdLayout.setErrorEnabled(false);
        }

        return true;
    }

}
