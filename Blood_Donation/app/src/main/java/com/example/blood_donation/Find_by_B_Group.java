package com.example.blood_donation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Find_by_B_Group extends AppCompatActivity {
    EditText Seach_b_group;
    Button btn_search_b;
    Button btn_can;
    TextView list_of_Bgroup;

    myApplication object_myap = new myApplication();
    String find_gr = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_by__b__group);
        Init();

        btn_search_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String get_Bgroup_to_search = Seach_b_group.getText().toString().trim();
                object_myap.people.get(0).getD_bgroup() ;
                hideKeybaord(v);

                int size = object_myap.people.size();
                // Toast.makeText(Find_Donor_by_Name.this, "Size of Array: "+size, Toast.LENGTH_SHORT).show();
                //  Toast.makeText(Find_Donor_by_Name.this, "Entered Data: "+get_name_to_search, Toast.LENGTH_SHORT).show();

                for(int i=0; i<size; i++) {

                    if (get_Bgroup_to_search.equals(object_myap.people.get(i).getD_bgroup())) {

                        find_gr =    "    Donor Name                 : " + object_myap.people.get(i).getD_Name()
                                + "\n  Donor BloodGroup   :  " + object_myap.people.get(i).getD_bgroup()
                                + "\n  Donor Cell No.          :  " + object_myap.people.get(i).getD_dphon()
                                + "\n  Donor Location         :  " + object_myap.people.get(i).getD_dloc();
                        Toast.makeText(Find_by_B_Group.this, " Entered Blood_Group is : " +Seach_b_group.getText().toString().trim()+ find_gr, Toast.LENGTH_LONG).show();
                        list_of_Bgroup.setText(find_gr);
                    }
                }
                if (find_gr == null || get_Bgroup_to_search.isEmpty()) {
                    Toast.makeText(Find_by_B_Group.this, " Please enter correct Blood_Group  || Either you have  enter notinhg : ", Toast.LENGTH_LONG).show();
                    Seach_b_group.setText("");
                }
            }
        });
        btn_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   setResult(RESULT_CANCELED);
                Find_by_B_Group.this.finish();
                Toast.makeText(Find_by_B_Group.this, " User has press Back button : ", Toast.LENGTH_LONG).show();
            }
        });

    }
    private void hideKeybaord(View v) {
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
    }
    public  void Init()
    {
        Seach_b_group = findViewById(R.id.Seach_b_group);
        btn_search_b = findViewById(R.id.btn_search_b);
        btn_can = findViewById(R.id.btn_can);
        list_of_Bgroup = findViewById(R.id.list_of_Bgroup);
    }
}