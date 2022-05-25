package com.example.blood_donation;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DonorAdapter.ItemSelected {
    TextView dtxt_Name;
    TextView dtxt_Bgroup;
    TextView dtxt_Phone;
    TextView dtxt_Loc;
    ImageView img_phon;
    ImageView img_loc;

    Button addonor;
    Button searchbtn;
    Button btnf_B_group;
    list_frag listFrag;
    FragmentManager manager;
    final int addDonor_key=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Init();
        onItemClicked(0);

        addonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this,Add_Doner.class),addDonor_key);
            }
        });
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , Find_Donor_by_Name.class);
                startActivity(intent);
            }
        });
        btnf_B_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this ,Find_by_B_Group.class);
                startActivity(intent);
            }
        });
        img_phon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +dtxt_Phone.getText().toString().trim()));
                startActivity(intent);
            }
        });
        img_loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + dtxt_Loc.getText().toString().trim()) );
                startActivity(intent);
            }
        });

        if(findViewById(R.id.layout_portraite) != null)
        {
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.f_deatil))
                    .show(manager.findFragmentById(R.id.f_list))
                    .hide(manager.findFragmentById(R.id.f_AddSearch))
                    .commit();
        }
        if(findViewById(R.id.layout_Landscap) != null)
        {
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.f_deatil))
                    .show(manager.findFragmentById(R.id.f_list))
                    .show(manager.findFragmentById(R.id.f_AddSearch))
                    .commit();
        }



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == addDonor_key)
        {
            if(resultCode == RESULT_OK)
            {
                dtxt_Name.setText(data.getStringExtra("name"));
                dtxt_Bgroup.setText(data.getStringExtra("group"));
                dtxt_Phone.setText(data.getStringExtra("number"));
                dtxt_Loc .setText(data.getStringExtra("location"));
                myApplication.people.add(new Person(dtxt_Name.getText().toString().trim(),dtxt_Bgroup.getText().toString().trim(),dtxt_Phone.getText().toString().trim(),dtxt_Loc.getText().toString().trim()));
                listFrag.dataChanged();
                onItemClicked(0);
            }
            else if(resultCode == RESULT_CANCELED)
            {
                Toast.makeText(MainActivity.this, "User Pressed the Cancel button", Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public void onItemClicked(int index) {
        dtxt_Name.setText(myApplication.people.get(index).getD_Name());
        dtxt_Bgroup.setText(myApplication.people.get(index).getD_bgroup());
        dtxt_Phone.setText(myApplication.people.get(index).getD_dphon());
        dtxt_Loc.setText(myApplication.people.get(index).getD_dloc());


        if(findViewById(R.id.layout_portraite) != null)
        {
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.f_deatil))
                    .hide(manager.findFragmentById(R.id.f_list))
                    .hide(manager.findFragmentById(R.id.f_AddSearch))
                    .addToBackStack(null)
                    .commit();
        }

        if(findViewById(R.id.layout_Landscap) != null)
        {
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.f_deatil))
                    .show(manager.findFragmentById(R.id.f_list))
                    .show(manager.findFragmentById(R.id.f_AddSearch))
                    .commit();
        }

    }


    public  void  Init()
    {
        addonor = findViewById(R.id.bttn_Add_donor);
        searchbtn = findViewById(R.id.btn_Search_Donor);

        manager = this.getSupportFragmentManager();
        listFrag = (list_frag) manager.findFragmentById(R.id.f_list);

        dtxt_Name = findViewById(R.id.dtxt_Name);
        dtxt_Bgroup = findViewById(R.id.dtxt_Bgroup);
        dtxt_Phone = findViewById(R.id.dtxt_Phone);
        dtxt_Loc = findViewById(R.id.dtxt_Loc);
        img_phon = findViewById(R.id.img_phon);
        img_loc = findViewById(R.id.img_loc);
        btnf_B_group = findViewById(R.id.btnf_B_group);
    }
}