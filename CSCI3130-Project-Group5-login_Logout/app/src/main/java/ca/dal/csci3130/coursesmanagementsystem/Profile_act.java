package ca.dal.csci3130.coursesmanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Profile_act extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth firebaseAuth;
    private TextView textViewUserEmail;
    private Button buttonLogout;
    private DatabaseReference databaseReference;
    private Spinner spinnerFaculty;

    private EditText editTextName;

    private Button buttonAddInformation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_act);

        firebaseAuth = firebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this, Login.class));
        }
        databaseReference = FirebaseDatabase.getInstance().getReference("User");
        editTextName = (EditText)findViewById(R.id.editTextName);

        buttonAddInformation = (Button)findViewById(R.id.buttonAddInformation);
        spinnerFaculty = (Spinner)findViewById(R.id.spinnerFaculty);
        FirebaseUser user = firebaseAuth.getCurrentUser();
        textViewUserEmail= (TextView) findViewById(R.id.textViewUserEmail);

        textViewUserEmail.setText("Welcome to use Courese Management System");
        buttonLogout= (Button)findViewById(R.id.buttonLogout);
        buttonLogout.setOnClickListener(this);
        buttonAddInformation.setOnClickListener(this);

    }
    private void uploadUserInformaiton(){
        FirebaseUser user = firebaseAuth.getCurrentUser();
        String name = editTextName.getText().toString().trim();
        String faculty = spinnerFaculty.getSelectedItem().toString();
        String id = user.getUid();
        String mailAddress = user.getEmail();
        int count =1;
        UserInformation userInformation = new UserInformation(id,name,faculty,mailAddress);

        databaseReference.child(id).setValue(userInformation);
        Toast.makeText(this, "Uploading", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onClick(View v) {
    if(v == buttonLogout){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(this, Login.class));
    }
    if(v==buttonAddInformation){
        uploadUserInformaiton();
    }
    }
}
