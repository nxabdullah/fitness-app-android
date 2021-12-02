package com.example.fitappa.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.Profile.Profile;
import com.example.fitappa.Profile.ViewSetupActivity;
import com.example.fitappa.R;

import java.util.Objects;

/**
 * This activity is activated when the user selects signup from the MainActivity and wants to sign up with a new account
 */
public class SignUpActivity extends AppCompatActivity implements OpensActivityWithProfile {
    private EditText usernameText;
    private EditText passwordText;
    private EditText emailText;

    /**
     * This method is called when the activity starts.
     *
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Objects.requireNonNull(getSupportActionBar()).hide();

        usernameText = findViewById(R.id.userName1);
        passwordText = findViewById(R.id.password);
        emailText = findViewById(R.id.email);
        Button enter = findViewById(R.id.submit);

        SignUpPresenter presenter = new SignUpPresenter(this);

        enter.setOnClickListener(v -> presenter.trySignUp(emailText, usernameText, passwordText));
    }

    /**
     * This method opens the SetUpActivity View while passing in the profile
     *
     * @param profile represents the Profile that was created
     */
    @Override
    public void openActivityWith(Profile profile) {
        Intent setup = new Intent(this, ViewSetupActivity.class);
        setup.putExtra("profile", profile);
        startActivity(setup);
    }

    /**
     * Display an error message given a message
     *
     * @param message String message to be displayed as error on call
     */
    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}