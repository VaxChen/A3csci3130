package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText nameField, addressField, businessNumField, primaryBusinessField,provinceField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        nameField = (EditText) findViewById(R.id.name);
        addressField = (EditText) findViewById(R.id.address);
        businessNumField = (EditText) findViewById(R.id.businessNum);
        primaryBusinessField = (EditText) findViewById(R.id.primaryBusiness);
        provinceField = (EditText) findViewById(R.id.province);
    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
        String name = nameField.getText().toString();
        String address = addressField.getText().toString();
        String businessNum = businessNumField.getText().toString();
        String primaryBusiness = primaryBusinessField.getText().toString();
        String province = provinceField.getText().toString();

        Contact person = new Contact(personID, name, address,businessNum,primaryBusiness,province);

        appState.firebaseReference.child(personID).setValue(person);

        finish();

    }
}
