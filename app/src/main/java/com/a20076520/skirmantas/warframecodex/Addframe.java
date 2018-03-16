package com.a20076520.skirmantas.warframecodex;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Addframe extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName,editHealth,editEnergy ,editTextId, editArmor;
    Button btnAddData;
    Button btnviewAll;
    Button btnDelete;

    Button btnviewUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addframe);
        myDb = new DatabaseHelper(this);

        editName = (EditText)findViewById(R.id.editText_name);
        editHealth = (EditText)findViewById(R.id.editText_health);
        editEnergy = (EditText)findViewById(R.id.editText_Energy);
        editArmor =(EditText)findViewById(R.id.editText_Armor);
        editTextId = (EditText)findViewById(R.id.editText_id);
        btnAddData = (Button)findViewById(R.id.button_add);
        btnviewAll = (Button)findViewById(R.id.button_viewAll);
        btnviewUpdate= (Button)findViewById(R.id.button_update);
        btnDelete= (Button)findViewById(R.id.button_delete);
        AddData();
        viewAll();
        UpdateData();
        DeleteData();
    }
    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(editTextId.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(Addframe.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Addframe.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(
                                editTextId.getText().toString(),
                                editName.getText().toString(),
                                editHealth.getText().toString(),
                                editEnergy.getText().toString(),
                                editArmor.getText().toString() );
                        if(isUpdate == true)
                            Toast.makeText(Addframe.this,"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Addframe.this,"Data not Updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(
                                editName.getText().toString(),
                                editHealth.getText().toString(),
                                editEnergy.getText().toString(),
                                editArmor.getText().toString() );
                        if(isInserted == true)
                            Toast.makeText(Addframe.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Addframe.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Name :"+ res.getString(1)+"\n");
                            buffer.append("Health :"+ res.getString(2)+"\n");
                            buffer.append("Energy :"+ res.getString(3)+"\n");
                            buffer.append("Armor  :"+ res.getString(4)+"\n\n");
                        }
                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_addframe, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.action_frameslist : startActivity(new Intent(this, Addframe.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}