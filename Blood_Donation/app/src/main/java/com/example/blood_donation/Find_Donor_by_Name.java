package com.example.blood_donation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Find_Donor_by_Name extends AppCompatActivity {
    EditText searchby_id;
    Button Submbtn;
    Button btn_Cancel;
    TextView list;

    myApplication object = new myApplication();
    String find = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find__donor_by__name);
        Init();

        Submbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String get_name_to_search = searchby_id.getText().toString().trim();
                   object.people.get(0).getD_Name() ;
                   hideKeybaord(v);

                int size = object.people.size();
               // Toast.makeText(Find_Donor_by_Name.this, "Size of Array: "+size, Toast.LENGTH_SHORT).show();
              //  Toast.makeText(Find_Donor_by_Name.this, "Entered Data: "+get_name_to_search, Toast.LENGTH_SHORT).show();

                for(int i=0; i<size; i++) {

                    if (get_name_to_search.equals(object.people.get(i).getD_Name())) {

                        find =    "    Donor Name                 : " + object.people.get(i).getD_Name()
                                + "\n  Donor BloodGroup   :  " + object.people.get(i).getD_bgroup()
                                + "\n  Donor Cell No.          :  " + object.people.get(i).getD_dphon()
                                + "\n  Donor Location         :  " + object.people.get(i).getD_dloc();
                         Toast.makeText(Find_Donor_by_Name.this, " Entered Data : " + find, Toast.LENGTH_LONG).show();
                        list.setText(find);

                    }
                }
                    if (find == null || get_name_to_search.isEmpty()) {
                        Toast.makeText(Find_Donor_by_Name.this, " Please enter correct name  || Either you have  enter notinhg : ", Toast.LENGTH_LONG).show();
                        searchby_id.setText("");
                    }
            }
        });
        btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   setResult(RESULT_CANCELED);
                Find_Donor_by_Name.this.finish();
                Toast.makeText(Find_Donor_by_Name.this, " User has press Back button : ", Toast.LENGTH_LONG).show();
            }
        });

    }
    private void hideKeybaord(View v) {
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
    }
    public  void Init()
    {
        searchby_id = findViewById(R.id.Seach_b_group);
        Submbtn = findViewById(R.id.btn_submit);
        btn_Cancel = findViewById(R.id.btn_Cancel);
        list = findViewById(R.id.list_ofname);
    }
}