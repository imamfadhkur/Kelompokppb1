package com.ppb.kelompok;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox cbEdu, cbLife, cbTech;
    private Button btSubmit, btnToWebview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setCheckBoxListener();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu1:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        this);
                alertDialogBuilder.setTitle("Keluar dari aplikasi?");
                alertDialogBuilder
                        .setMessage("Klik Ya untuk keluar!")
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(false)
                        .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                MainActivity.this.finish();
                            }
                        })
                        .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();
                
                alertDialog.show();
        }
                return true;
        }

    private void setCheckBoxListener() {
        cbEdu = (CheckBox) findViewById(R.id.cb_education);
        cbLife = (CheckBox) findViewById(R.id.cb_lifestyle);
        cbTech = (CheckBox) findViewById(R.id.cb_technology);
        btSubmit = (Button) findViewById(R.id.bt_submit);
        btnToWebview = (Button) findViewById(R.id.btn_webview);

        cbEdu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CheckBox) view).isChecked()) {
                    Toast.makeText(MainActivity.this,
                            "Anda memilih Education", Toast.LENGTH_LONG).show(); }
            }});
        cbLife.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (((CheckBox) view).isChecked()) {
                            Toast.makeText(MainActivity.this,
                                    "Anda memilih Lifestyle", Toast.LENGTH_LONG).show();
                        }
            }
        });
        cbTech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CheckBox) view).isChecked()) {
                    Toast.makeText(MainActivity.this,
                            "Anda memilih Technology", Toast.LENGTH_LONG).show();}}});
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = "";
                if (cbEdu.isChecked() && cbLife.isChecked() && cbTech.isChecked()){
                    query = "education lifestyle technology";
                }
                else if (cbEdu.isChecked() && cbLife.isChecked()){
                    query = "education lifestyle";
                }
                else if (cbEdu.isChecked() && cbTech.isChecked()){
                    query = "education technology";
                }
                else if (cbTech.isChecked() && cbLife.isChecked()){
                    query = "technology lifestyle";
                }
                else if (cbLife.isChecked()){
                    query = "lifestyle";
                }
                else if (cbTech.isChecked()){
                    query = "technology";
                }
                else{
                    query = "education";
                }
                Intent dialPhoneIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query=" + query));
                startActivity(dialPhoneIntent);
            }
        });
        btnToWebview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveIntent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(moveIntent);
            }
        });
    }}