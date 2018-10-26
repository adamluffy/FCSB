/*
 * Copyright (c) 2018. This project begin with the difficulty of using hard copy form. As years has passed, many of
 * wasted form were dump into the store. In order to solve the problem. I decide to build an Android app for operating
 * hour and vehicle millage. This app is only used within the company community.
 */

package fcsb.franky.com.my.fcsb;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.Task;
import com.shobhitpuri.custombuttons.GoogleSignInButton;

import auth.FirebaseAuthHelper;
import utility.ValidationUtility;

public class LoginFragment extends Fragment {

    private final int RC_SIGN_IN = 1002;

    private TextInputLayout emailLayout, passwordLayout;
    private TextInputEditText emailEditText, passwordEditText;

    GoogleSignInOptions gso;
    GoogleSignInClient mClient;

    ProgressBar loader;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.login_fragment,container,false);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        if(getActivity() instanceof LoginActivity){

            mClient = GoogleSignIn.getClient(this.getActivity(),gso);
            loader = getActivity().findViewById(R.id.login_progress);
        }

        emailLayout = v.findViewById(R.id.email_login_layout);
        emailEditText = v.findViewById(R.id.email_login_input);



        passwordLayout = v.findViewById(R.id.password_input_layout);
        passwordEditText = v.findViewById(R.id.password_login_input);

        TextView forgetPwd = v.findViewById(R.id.forgot_password_btn);
        forgetPwd.setOnClickListener(view-> startActivity(new Intent(getActivity(),ForgotPasswordActivity.class)));

        TextView signUpBtn = v.findViewById(R.id.sign_up_btn);
        signUpBtn.setOnClickListener(v2-> startActivity(new Intent(getActivity(),ProfileActivity.class)));

        Button loginBtn = v.findViewById(R.id.email_login_button);
        loginBtn.setOnClickListener(view2->{

            if(validateInput() && getActivity() instanceof LoginActivity){

                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                FirebaseAuthHelper.signInWithEmailAndPassword(getActivity(),email,password);
            }

        });

        GoogleSignInButton googleSignInButton = v.findViewById(R.id.google_sign_in);
        googleSignInButton.setOnClickListener(view3->{

            Intent signInIntent = mClient.getSignInIntent();
            startActivityForResult(signInIntent,RC_SIGN_IN);

        });

        return v;
    }


    private boolean validateInput(){

        boolean isValid = true;

        if(ValidationUtility.validateEmail(emailEditText, emailLayout)){
            isValid = false;
        }

        if(!ValidationUtility.validateLoginPassword(passwordLayout,passwordEditText)) {
            isValid = false;
        }

        return isValid;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RC_SIGN_IN){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try{
                GoogleSignInAccount acc = task.getResult();
                if(getActivity() instanceof LoginActivity && acc!=null) {
                    FirebaseAuthHelper.signInWithGoogle(getActivity(),acc);
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }



}
