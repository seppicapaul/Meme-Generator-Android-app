package ssu.softwarednd.spring19.androidlab2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TwoImageTop extends AppCompatActivity {

    private Button back_button, generate_button, background_button, foreground_button, color_button;
    private EditText text_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_image_top);

        back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent back = new Intent(TwoImageTop.this, MainActivity.class);
                startActivity(back);
            }
        });

        generate_button = findViewById(R.id.generate_button);
        generate_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                    Intent generate = new Intent(TwoImageTop.this, TwoImageTop.class);
                    startActivity(generate);
            }
        });

        background_button = findViewById(R.id.background_button);
        background_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent background = new Intent(TwoImageTop.this, BackgroundImage.class);
                startActivity(background);
            }
        });

        foreground_button = findViewById(R.id.foreground_button);
        foreground_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent foreground = new Intent(TwoImageTop.this, ForegroundImage.class);
                startActivity(foreground);
            }
        });

        text_button = findViewById(R.id.text_button);

        color_button = findViewById(R.id.color_button);
        color_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(TwoImageTop.this, ColorButton.class);
                startActivityForResult(intent, 1);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                int red = data.getIntExtra("red", 0);
                int green = data.getIntExtra("green", 0);
                int blue = data.getIntExtra("blue", 0);
                color_button.setBackgroundColor(Color.rgb(red, green, blue));
                color_button.setText("");
            }
        }
    }
}
