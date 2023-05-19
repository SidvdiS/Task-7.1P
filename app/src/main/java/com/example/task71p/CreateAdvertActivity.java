package com.example.task71p;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.task71p.data.AdvertDatabaseHelper;
import com.example.task71p.model.Advert;

public class CreateAdvertActivity extends AppCompatActivity {
    EditText name, phone, desc, date, location;
    RadioGroup type;
    Button save;

    RadioButton defaultCheckedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_advert);

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone_number);
        desc = findViewById(R.id.desc);
        date = findViewById(R.id.date);
        location = findViewById(R.id.location);
        type = findViewById(R.id.type);
        save = findViewById(R.id.save_btn);
        defaultCheckedButton =  findViewById(type.getCheckedRadioButtonId());

        type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                defaultCheckedButton = findViewById(i);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Advert advert = new Advert(name.getText().toString(),
                        phone.getText().toString(), desc.getText().toString(),
                        date.getText().toString(), location.getText().toString(),
                        defaultCheckedButton.getText().toString());
                if(TextUtils.isEmpty(advert.getName())){
                    showToast("Enter item name");
                    name.setError("Enter item name");
                    return;
                } else if (TextUtils.isEmpty(advert.getPhoneNumber())) {
                    showToast("Enter phone number");
                    phone.setError("Enter phone number");
                    return;
                } else if (TextUtils.isEmpty(advert.getDescription())) {
                    showToast("Enter item description");
                    desc.setError("Enter item description");
                    return;
                } else if(TextUtils.isEmpty(advert.getLocation())){
                    showToast("Enter location");
                    location.setError("Enter location");
                    return;
                } else if(TextUtils.isEmpty(advert.getDate())){
                    showToast("Enter date");
                    date.setError("Enter date");
                    return;
                }

                AdvertDatabaseHelper advertDatabaseHelper = new AdvertDatabaseHelper(CreateAdvertActivity.this);
                long insert = advertDatabaseHelper.insertAdvert(advert);
                if(insert>0){
                    showToast("Advert created successfully");
                    finish();
                } else {
                    showToast("Sorry! Cannot create advert. Please try again");
                }

            }
        });
    }

    public void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}