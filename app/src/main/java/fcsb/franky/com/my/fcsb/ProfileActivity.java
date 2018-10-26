

/*
 * Copyright (c) 2018. This project begin with the difficulty of using hard copy form. As years has passed, many of
 * wasted form were dump into the store. In order to solve the problem. I decide to build an Android app for operating
 * hour and vehicle millage. This app is only used within the company community.
 */

package fcsb.franky.com.my.fcsb;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import com.squareup.picasso.Picasso;

import auth.FirebaseAuthHelper;
import de.hdodenhof.circleimageview.CircleImageView;
import utility.PhotoUtility;
import utility.ValidationUtility;

public class ProfileActivity extends AppCompatActivity {

    private final int RC_GALLERY = 112;
    private final int RC_CAMERA = 113;

    private CircleImageView profileImage;
    private TextInputLayout emailLayout, nameLayout, passwordLayout, confirmPwdLayout;
    private TextInputEditText emailInput, nameInput, passwordInput, confirmPwdInput;

    private Uri filePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Sign Up");
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        profileImage = findViewById(R.id.profile_input);

        emailLayout = findViewById(R.id.email_input_layout);
        emailInput = findViewById(R.id.email_input);

        nameLayout = findViewById(R.id.username_input_layout);
        nameInput = findViewById(R.id.username_input);

        passwordLayout = findViewById(R.id.password_signup_layout);
        passwordInput = findViewById(R.id.password_signup_input);

        confirmPwdLayout = findViewById(R.id.confirm_signup_layout);
        confirmPwdInput = findViewById(R.id.confirm_input);

        Button next = findViewById(R.id.profile_next_btn);
        next.setOnClickListener(v -> {

            if(validateInput()){

                String name = nameInput.getText().toString().trim();
                String email = emailInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();

                FirebaseAuthHelper.createUserWithEmailAndPassword(this,email,password,name,filePath);
            }
        });

        FloatingActionButton addProfileBtn = findViewById(R.id.profile_input_btn);
        addProfileBtn.setOnClickListener(v2->{
            //TODO: select profile image dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
            builder.setTitle("Select Action");
            String[] pictureDialogItems = {
                    "Select photo from gallery",
                    "Capture photo from camera"
            };

            builder.setItems(pictureDialogItems, (dialog, which) -> {
                switch (which){

                    case 0:
                        startActivityForResult(PhotoUtility.takeFromGallery(),RC_GALLERY);
                        break;

                    case 1:

                        startActivityForResult(PhotoUtility.takeFromCamera(),RC_CAMERA);
                        break;
                }
            });

            builder.show();


        });


    }


    private boolean validateInput(){

        boolean isValid = true;

        if(!ValidationUtility.validateEmail(emailInput, emailLayout)){
            isValid = false;
        }

        if(!ValidationUtility.validateSignUpPassword(passwordLayout,passwordInput,confirmPwdLayout,confirmPwdInput)){
            isValid = false;
        }

        if(!ValidationUtility.validateUsername(nameInput,nameLayout)){
            isValid = false;
        }

        return isValid;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RC_GALLERY || requestCode == RC_CAMERA && data!=null){

            filePath = data.getData();

            Picasso.get()
                    .load(filePath)
                    .fit()
                    .placeholder(R.drawable.ic_account_circle_black_156dp)
                    .into(profileImage);
        }
    }

}
