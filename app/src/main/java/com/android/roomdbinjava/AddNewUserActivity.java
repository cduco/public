package com.android.roomdbinjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.roomdbinjava.db.AppDatabase;
import com.android.roomdbinjava.db.User;

public class AddNewUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        final EditText itemNameInput =  findViewById(R.id.firstNameInput);
        final EditText amountInput =  findViewById(R.id.lastNameInput);
        Button saveButton =  findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveNewUser(itemNameInput.getText().toString(), Integer.parseInt(amountInput.getText().toString()));
            }
        });
    }

    private void saveNewUser(String itemName, int amount) {
        AppDatabase db  = AppDatabase.getDbInstance(this.getApplicationContext());

        User item = new User();
        item.itemName = itemName;
        item.amount = amount;
        db.userDao().insertUser(item);

        finish();

    }
}