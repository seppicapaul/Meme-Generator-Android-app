package ssu.softwarednd.spring19.androidlab2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TwoImage extends AppCompatActivity {

    private Button generate_button, background_button, color_button, foreground_button;
    private EditText text_button, second_text_button;
    private int red, green, blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_image);

        generate_button = findViewById(R.id.generate_button);
        generate_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String topText = text_button.getText().toString();
                String bottomText = second_text_button.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("TOP_TEXT", topText);
                bundle.putString("BOTTOM_TEXT", bottomText);
                bundle.putInt("RED", red);
                bundle.putInt("GREEN", green);
                bundle.putInt("BLUE", blue);

                Intent generate = new Intent(TwoImage.this, GenerateButton.class);
                generate.putExtras(bundle);
                startActivity(generate);
            }
        });

        background_button = findViewById(R.id.background_button);
        background_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent background = new Intent(TwoImage.this, BackgroundImage.class);
                startActivity(background);
            }
        });

        text_button = findViewById(R.id.text_button);

        second_text_button = findViewById(R.id.second_text_button);

        color_button = findViewById(R.id.color_button);
        color_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(TwoImage.this, ColorButton.class);
                startActivityForResult(intent, 1);

            }
        });

        foreground_button = findViewById(R.id.foreground_button);
        foreground_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent foreground = new Intent(TwoImage.this, ForegroundImage.class);
                startActivity(foreground);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                red = data.getIntExtra("red", 0);
                green = data.getIntExtra("green", 0);
                blue = data.getIntExtra("blue", 0);
                color_button.setTextColor(Color.rgb(red,green,blue));
                //color_button.setBackgroundColor(Color.rgb(red, green, blue));
                //color_button.setText("");
            }
        }
    }
}
