package com.example.collegeapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.razzaghimahdi78.dotsloading.circle.LoadingCircleFady;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    EditText signUpUserName, signUpEmail, signUpPassword;
    TextView alreadyAccount, invalidText;
    Button registerBtn, googleRegisterBtn;
    String username, email, password;
    FirebaseAuth mAuth;     //firebase auth object which can used to check authentication
    GoogleSignInClient googleClient;
    GoogleSignInOptions gso;
    LoadingCircleFady loadingBar;

    private final int REQ_ONE_TAP = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        signUpUserName = findViewById(R.id.signUpUsername);
        signUpEmail = findViewById(R.id.signUpEmail);
        signUpPassword = findViewById(R.id.signUpPassword);
        alreadyAccount = findViewById(R.id.alreadyAccountText);
        invalidText = findViewById(R.id.invalidRegisterText);
        registerBtn = findViewById(R.id.registerBtn);
        googleRegisterBtn = findViewById(R.id.googleRegisterBtn);
        loadingBar = findViewById(R.id.registerLoading);

        //google authentication
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        googleClient = GoogleSignIn.getClient(this, gso);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get all the registered data
                username = signUpUserName.getText().toString();
                email = signUpEmail.getText().toString();
                password = signUpPassword.getText().toString();

                //default set the invalid text as hide and show loading
                invalidText.setVisibility(View.GONE);
                loadingBar.setVisibility(View.VISIBLE);

                if (!username.equals("") && !email.equals("") && !password.equals("")) {
                    if (isValidPassword(password) && isValidEmail(email)) {

                        mAuth.createUserWithEmailAndPassword(email, password)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            //If user is member then go to mainActivity
                                            loadingBar.setVisibility(View.GONE);
                                            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                                            finish();
                                        }
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        loadingBar.setVisibility(View.GONE);
                                        Toast.makeText(RegisterActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                    else {
                        //set the invalid text visible and show loading
                        invalidText.setVisibility(View.VISIBLE);
                        loadingBar.setVisibility(View.GONE);
//                        Toast.makeText(RegisterActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    loadingBar.setVisibility(View.GONE);
                    Toast.makeText(RegisterActivity.this, "Enter valid credential", Toast.LENGTH_SHORT).show();
                }
            }
        });

        alreadyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        googleRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    public void signUp() {
        Intent intent = googleClient.getSignInIntent();
        startActivityForResult(intent, REQ_ONE_TAP);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //current user check if already authenticated then send to main page
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {

            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_ONE_TAP) {
            loadingBar.setVisibility(View.VISIBLE);
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {

                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (Exception e) {
                loadingBar.setVisibility(View.GONE);
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(i);
                            loadingBar.setVisibility(View.GONE);
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(RegisterActivity.this, "Register failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#\\$%^&*+=~]).{8,}");
        return pattern.matcher(password).matches();
    }

    private Boolean isValidEmail(String email){
        //It used default email address validation
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}