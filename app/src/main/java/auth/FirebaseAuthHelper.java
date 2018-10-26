
/*
 * Copyright (c) 2018. This project begin with the difficulty of using hard copy form. As years has passed, many of
 * wasted form were dump into the store. In order to solve the problem. I decide to build an Android app for operating
 * hour and vehicle millage. This app is only used within the company community.
 */

package auth;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.UserProfileChangeRequest;

import fcsb.franky.com.my.fcsb.HomeActivity;

/**
 * Firebase authentication helper class.
 */

public class FirebaseAuthHelper {

    private static FirebaseAuth mAuth = FirebaseAuth.getInstance();


    /**
     * Create user for password authentication. If the task is successful,
     * it will send a email verification to the user. This prevent a fake
     * email to register in the app.
     *
     * @param activity Activity from the main class. It must not be null.
     * @param email User email address.
     * @param password User password for Firebase Authentication.
     * @param username User username for Firebase Authentication.
     * @param imageUrl url of the image for user profile.
     */
    public static void createUserWithEmailAndPassword(@NonNull FragmentActivity activity, String email, String password, String username, Uri imageUrl){

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(task -> {
                    FirebaseUser user = mAuth.getCurrentUser(); //get the sign in user

                    //if the process is successful
                    if(task.isSuccessful() && user!=null) {

                        UserProfileChangeRequest.Builder profile = new UserProfileChangeRequest.Builder();
                        profile.setDisplayName(username); //set the username

                        if(imageUrl!=null){
                            profile.setPhotoUri(imageUrl); //set a profile image
                        }

                        user.updateProfile(profile.build()); //update the current user profile
                        sendEmailVerification(activity,user); //verify
                    }else{

                        getException(task);
                    }
                })
                .addOnFailureListener(e-> Toast.makeText(activity,"Failed to create user: "+e.getMessage(),Toast.LENGTH_SHORT).show());
    }


    /**
     *  Login to the app with email and password method.
     *
     * @param activity Activity from the main class. It must not be null.
     * @param email user email address.
     * @param password user password.
     */
    public static void signInWithEmailAndPassword(@NonNull FragmentActivity activity, String email, String password){

        AuthCredential credential = EmailAuthProvider.getCredential(email,password);
        login(activity,credential);
    }

    /**
     *  Login to the app with google account.
     *
     * @param activity Activity from the main class. It must not be null.
     * @param acc Google account from the activity class
     */
    public static void signInWithGoogle(@NonNull FragmentActivity activity ,GoogleSignInAccount acc){

        AuthCredential credential = GoogleAuthProvider.getCredential(acc.getIdToken(),null);
        login(activity,credential);
    }

    /**
     *  Login to the app with auth credential.
     *
     * @param activity Activity from the main class. It must not be null.
     * @param credential Authentication credential from the auth provider
     */
    private static void login(@NonNull FragmentActivity activity, AuthCredential credential){

        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(task -> {

                    if(task.isSuccessful()){

                        FirebaseUser user= mAuth.getCurrentUser();

                        if(user!=null && !user.isEmailVerified()){
                            sendEmailVerification(activity,user);
                            Toast.makeText(activity,"Verification email has been send to "+user.getProviderId(),Toast.LENGTH_SHORT).show();
                        }else if(user!=null && user.isEmailVerified()) {
                            activity.startActivity(new Intent(activity, HomeActivity.class));
                            activity.finish();
                        }

                    }else{

                        getException(task);
                    }
                });

    }

    /**
     * Send a verification email for the user after user
     * successfully register to the app
     *
     * @param activity Activity from the main class. It must not be null.
     * @param user Firebase user object
     */
    private static void sendEmailVerification(@NonNull FragmentActivity activity, FirebaseUser user){

        if(!user.isEmailVerified()){

            user.sendEmailVerification()
                    .addOnCompleteListener(task -> {
                         Toast.makeText(activity,"Verification email has been send to "+user.getEmail(),Toast.LENGTH_SHORT).show();
                         activity.finish();
                    })
                    .addOnFailureListener(e->
                            Log.d("tag","failed")
                    );
        }
    }


    private static void getException(@NonNull Task task) {

        try{
            if(task.getException()!=null){
                throw task.getException();
            }
        }catch (FirebaseAuthException e){

            Log.d("tag",e.getErrorCode());

        }catch (Exception e){

            e.printStackTrace();

        }
    }
}
