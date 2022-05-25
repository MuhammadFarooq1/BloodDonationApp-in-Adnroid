package com.example.blood_donation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Doner extends AppCompatActivity {

    EditText eName;
    EditText eGroup;
    EditText eLocation;
    EditText eNumber;
    Button addbtn;
    Button cancelbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__doner);
        Init();

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = eName.getText().toString().trim();
                String Group = eGroup.getText().toString().trim();
                String Location = eLocation.getText().toString().trim();
                String Number = eNumber.getText().toString().trim();
                hideKeybaord(v);
                if(Name.isEmpty() || Group.isEmpty() || Location.isEmpty() || Number.isEmpty() )
                {
                    Toast.makeText(Add_Doner.this, "Please ! Enter all data", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent();
                    intent.putExtra("name",Name);
                    intent.putExtra("group",Group);
                    intent.putExtra("number",Number);
                    intent.putExtra("location",Location);
                    setResult(RESULT_OK,intent);
                    Add_Doner.this.finish();
                }
            }
        });
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                setResult(RESULT_CANCELED);
                Add_Doner.this.finish();
            }
        });
    }
    private void hideKeybaord(View v) {
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
    }
  public  void Init()
  {
      eName = findViewById(R.id.eName);
      eGroup = findViewById(R.id.eGroup);
      eLocation = findViewById(R.id.eLocation);
      eNumber = findViewById(R.id.eNumber);
      addbtn = findViewById(R.id.addbtn);
      cancelbtn = findViewById(R.id.cancelbtn);
  }
}