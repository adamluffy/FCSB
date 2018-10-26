
/*
 * Copyright (c) 2018. This project begin with the difficulty of using hard copy form. As years has passed, many of
 * wasted form were dump into the store. In order to solve the problem. I decide to build an Android app for operating
 * hour and vehicle millage. This app is only used within the company community.
 */

package fcsb.franky.com.my.fcsb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import utility.FragmentUtility;

/**
 *
 */
public class LoginActivity extends AppCompatActivity{

    /**
     *
     */
    FirebaseAuth auth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FragmentUtility.setFragment(this,R.id.auth_fragment,new LoginFragment());
    }


    /**
     *
     */
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = auth.getCurrentUser();
        if(currentUser!=null && currentUser.isEmailVerified()){
            startActivity(new Intent(this,HomeActivity.class));
            finish();
        }
    }


}
