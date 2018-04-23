package com.a20076520.skirmantas.warframecodex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Frontpage extends AppCompatActivity {
private Button framelistbutton;
private Button addframebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontpage);

        framelistbutton = findViewById(R.id.Framebutton);
        framelistbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFramelist();
            }
        });
        addframebutton = findViewById(R.id.Createframebutton);
        addframebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openAddFrame();
            }
        });
    }

    public void openFramelist() {
        Intent intent = new Intent(this, Warframelist.class);
        startActivity(intent);
    }

    public void openAddFrame() {
        Intent intent = new Intent(this, Addframe.class);
        startActivity(intent);
    }
}
