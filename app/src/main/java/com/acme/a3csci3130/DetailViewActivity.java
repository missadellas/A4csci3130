package com.acme.a3csci3130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetailViewActivity extends Activity {
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
   private EditText nameField, businessNumberField, addressField, primaryBusinessField, provinceField;

    Business receivedPersonInfo;
    private MyApplicationData appState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Business)getIntent().getSerializableExtra("Business");

        businessNumberField = (EditText) findViewById(R.id.businessNumber);
        nameField = (EditText) findViewById(R.id.name);
        primaryBusinessField = (EditText) findViewById(R.id.primaryBusiness);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            primaryBusinessField.setText(receivedPersonInfo.primaryBusiness);
            businessNumberField.setText(receivedPersonInfo.businessNumber);
            addressField.setText(receivedPersonInfo.address);
            provinceField.setText(receivedPersonInfo.province);
        }
    }

    public void updateBusiness(View v){
        //TODO: Update Business funcionality


        String businessNumber = businessNumberField.getText().toString();



        ref.child("Business").orderByChild("businessNumber").equalTo(businessNumber).addListenerForSingleValueEvent(

                new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {
                    String businessID = childSnapshot.getKey();

                    String businessNumber = businessNumberField.getText().toString();
                    String name = nameField.getText().toString();
                    Log.i("nameField",name);
                    String primaryBusiness = primaryBusinessField.getText().toString();
                    String address = addressField.getText().toString();
                    String province = provinceField.getText().toString();
                    ref.child("Business").child(businessID).child("businessNumber").setValue(businessNumber);
                    ref.child("Business").child(businessID).child("name").setValue(name);
                    ref.child("Business").child(businessID).child("primaryBusiness").setValue(primaryBusiness);
                    ref.child("Business").child(businessID).child("address").setValue(address);
                    ref.child("Business").child(businessID).child("province").setValue(province);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("TodoApp", "getUser:onCancelled", databaseError.toException());
            }
        });
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void eraseBusiness(View v)
    {
        //TODO: Erase Business functionality
        String businessNumber = businessNumberField.getText().toString();

        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);

       ref.child("Business").orderByChild("businessNumber").equalTo(businessNumber).addListenerForSingleValueEvent(

                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot child: dataSnapshot.getChildren()) {
                            child.getRef().removeValue();
                        }
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w("TodoApp", "getUser:onCancelled", databaseError.toException());
                    }
                });

    }
}
