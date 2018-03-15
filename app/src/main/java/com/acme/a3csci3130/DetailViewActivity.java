package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailViewActivity extends Activity {

    private EditText nameField, addressField, businessNumField, primaryBusinessField,provinceField;
    Contact receivedPersonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        nameField = (EditText) findViewById(R.id.name);
        addressField = (EditText) findViewById(R.id.address);
        businessNumField = (EditText) findViewById(R.id.businessNum);
        primaryBusinessField = (EditText) findViewById(R.id.primaryBusiness);
        provinceField = (EditText) findViewById(R.id.province);


        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            addressField.setText(receivedPersonInfo.address);
            businessNumField.setText(receivedPersonInfo.businessNum);
            primaryBusinessField.setText(receivedPersonInfo.primaryBusiness);
            provinceField.setText(receivedPersonInfo.province);

        }
    }

    public void updateContact(View v){
        //TODO: Update contact funcionality
        final MyApplicationData appState;
        appState =((MyApplicationData) getApplicationContext());

        Button button = (Button) findViewById(R.id.updateButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String personID=receivedPersonInfo.uid;

                appState.firebaseReference.child(personID).child("name").setValue(nameField.getText().toString());
                appState.firebaseReference.child(personID).child("address").setValue(addressField.getText().toString());
                appState.firebaseReference.child(personID).child("business number").setValue(businessNumField.getText().toString());
                appState.firebaseReference.child(personID).child("primary business").setValue(primaryBusinessField.getText().toString());
                appState.firebaseReference.child(personID).child("province").setValue(provinceField.getText().toString());
                finish();

            }
        });


    }

    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
        final MyApplicationData appState;
        appState =((MyApplicationData) getApplicationContext());

        Button button = (Button) findViewById(R.id.deleteButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String personID=receivedPersonInfo.uid;

                appState.firebaseReference.child(personID).child("name").removeValue();
                appState.firebaseReference.child(personID).child("address").removeValue();
                appState.firebaseReference.child(personID).child("business number").removeValue();
                appState.firebaseReference.child(personID).child("primary business").removeValue();
                appState.firebaseReference.child(personID).child("province").removeValue();

                finish();

            }
        });


    }
}
