package ssu.softwarednd.spring19.androidlab2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OneImage extends AppCompatActivity {

    private Button generate_button, background_button, color_button;
    private EditText text_button, second_text_button;
    private int red, blue, green;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_image);

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

                Intent generate = new Intent(OneImage.this, GenerateButton.class);
                generate.putExtras(bundle);
                startActivity(generate);
            }
        });

        background_button = findViewById(R.id.background_button);
        background_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent background = new Intent(OneImage.this, BackgroundImage.class);
                startActivityForResult(background, 2);
            }
        });


        text_button = findViewById(R.id.text_button);

        second_text_button = findViewById(R.id.second_text_button);


        color_button = findViewById(R.id.color_button);
        color_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(OneImage.this, ColorButton.class);
                startActivityForResult(intent, 1);

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
                color_button.setBackgroundColor(Color.rgb(red, green, blue));
                color_button.setText("");
            }
        }
        else if (requestCode == 2){
            if (resultCode == RESULT_OK) {
                String url = data.getStringExtra(BackgroundImage.imgurl);
                Toast.makeText(this, url, Toast.LENGTH_LONG).show();
            }
        }
    }
}
