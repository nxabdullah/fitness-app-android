package com.example.fitappa.Profile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fitappa.R;


/**
 * This class is a view class meant to open the activity_setting
 * <p>
 * The method in the class updated a users extra information
 *
 * @author Souren
 * @since 0.1
 */


public class ViewSettingsActivity extends AppCompatActivity implements SettingPresenter.View {
    private TextView weightText;
    private EditText weightInput;
    private TextView heightText;
    private EditText heightInput;
    private TextView firstText;
    private EditText firstInput;
    private TextView lastText;
    private EditText lastInput;
    private Profile myProfile;
    private SettingPresenter presenter;

    /**
     * This method is called when the activity starts.
     *
     * @param savedInstanceState contains the data it was most recently supplied with by onSaveInstanceState
     */
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Intent retrieveIntent = getIntent();
        this.myProfile = (Profile) retrieveIntent.getSerializableExtra("my_Profile");
        presenter = new SettingPresenter(this, myProfile);


        weightText = findViewById(R.id.weightSetting);
        weightInput = findViewById(R.id.weightChangeInput);
        weightText.setText("Your weight is:" + presenter.retrieveWeight());

        heightText = findViewById(R.id.heightSetting);
        heightInput = findViewById(R.id.heightChangeInput);
        heightText.setText("Your height is:" + presenter.retrieveHeight());

        firstText = findViewById(R.id.firstNameSetting);
        firstInput = findViewById(R.id.firstChangeInput);
        firstText.setText("Your first name is:" + presenter.retrieveFirstName());

        lastText = findViewById(R.id.lastNameSetting);
        lastInput = findViewById(R.id.lastChangeInput);
        lastText.setText("Your last name is:" + presenter.retrieveLastName());

        TextView submit = findViewById(R.id.submitSettings);
        TextView back = findViewById(R.id.back);

        submit.setOnClickListener(v -> presenter.changeSettings(weightInput.getText().toString(),
                heightInput.getText().toString(), firstInput.getText().toString(), lastInput.getText().toString()));
        back.setOnClickListener(v -> toProfile());

    }

    /**
     * Display the changes the user made to their settings
     */
    @SuppressLint("SetTextI18n")
    @Override
    public void update() {
        weightText.setText("Your weight is:" + presenter.retrieveWeight());
        heightText.setText("Your height is:" + presenter.retrieveHeight());
        firstText.setText("Your first name is:" + presenter.retrieveFirstName());
        lastText.setText("Your last name is:" + presenter.retrieveLastName());
    }

    /**
     * return to profile after changes made
     */
    @Override
    public void toProfile() {
        Intent home = new Intent(this, ViewProfileActivity.class);
        home.putExtra("my_Profile", myProfile);
        home.putExtra("persons_Profile", myProfile);
        startActivity(home);

    }
}