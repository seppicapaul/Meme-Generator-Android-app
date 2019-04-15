package ssu.softwarednd.spring19.androidlab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OneImageTop extends AppCompatActivity {

    private Button back_button, generate_button, background_button, text_button, color_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_image_top);

        back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent back = new Intent(OneImageTop.this, MainActivity.class);
                startActivity(back);
            }
        });

        generate_button = findViewById(R.id.generate_button);
        generate_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent generate = new Intent(OneImageTop.this, GenerateButton.class);
                startActivity(generate);
            }
        });

        background_button = findViewById(R.id.background_button);
        background_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent background = new Intent(OneImageTop.this, BackgroundImage.class);
                startActivity(background);
            }
        });


        text_button = findViewById(R.id.text_button);
        text_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(OneImageTop.this, TextButton.class);
                startActivity(intent);
            }
        });

        color_button = findViewById(R.id.color_button);
        color_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(OneImageTop.this, ColorButton.class);
                startActivity(intent);
            }
        });
    }
}
