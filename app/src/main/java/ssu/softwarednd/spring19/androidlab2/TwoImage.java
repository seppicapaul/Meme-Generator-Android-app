package ssu.softwarednd.spring19.androidlab2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TwoImage extends AppCompatActivity {

    private Button generate_button, background_button, color_button_1, color_button_2, foreground_button;
    private EditText text_button, second_text_button;
    private int red1, green1, blue1, red2, green2, blue2;
    private String burl;
    private String furl;
    private static final int color_return_one = 1;
    private static final int color_return_two = 5;
    private static final int bimage_return = 2;
    private static final int fimage_return = 3;

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
                bundle.putInt("RED1", red1);
                bundle.putInt("GREEN1", green1);
                bundle.putInt("BLUE1", blue1);
                bundle.putInt("RED2", red2);
                bundle.putInt("GREEN2", green2);
                bundle.putInt("BLUE2", blue2);
                bundle.putString("URL1", burl);
                bundle.putString("URL2", furl);

                Intent generate = new Intent(TwoImage.this, GenerateButton.class);
                generate.putExtras(bundle);
                startActivity(generate);
            }
        });

        background_button = findViewById(R.id.background_button);
        background_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent background = new Intent(TwoImage.this, Image.class);
                startActivityForResult(background, bimage_return);
            }
        });

        text_button = findViewById(R.id.text_button);

        second_text_button = findViewById(R.id.second_text_button);


        color_button_1 = findViewById(R.id.color_button_1);
        color_button_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(TwoImage.this, ColorButton.class);
                startActivityForResult(intent, color_return_one);
            }
        });

        color_button_2 = findViewById(R.id.color_button_2);
        color_button_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(TwoImage.this, ColorButton.class);
                startActivityForResult(intent, color_return_two);
            }
        });

        foreground_button = findViewById(R.id.foreground_button);
        foreground_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent foreground = new Intent(TwoImage.this, Image.class);
                startActivityForResult(foreground, fimage_return);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == color_return_one) {
            if (resultCode == RESULT_OK) {
                red1 = data.getIntExtra("red", 0);
                green1 = data.getIntExtra("green", 0);
                blue1 = data.getIntExtra("blue", 0);
                color_button_1.setTextColor(Color.rgb(red1,green1,blue1));
            }
        }
        else if (requestCode == color_return_two) {
            if (resultCode == RESULT_OK) {
                red2 = data.getIntExtra("red", 0);
                green2 = data.getIntExtra("green", 0);
                blue2 = data.getIntExtra("blue", 0);
                color_button_2.setTextColor(Color.rgb(red2,green2,blue2));
            }
        }
        else if (requestCode == bimage_return) {
            if (resultCode == RESULT_OK) {
                burl = data.getStringExtra(Image.imgurl);
                Toast.makeText(this, burl, Toast.LENGTH_LONG).show();
            }
            background_button.setBackgroundResource(R.drawable.selected);
        }
        else if (requestCode == fimage_return) {
            if (resultCode == RESULT_OK) {
                furl = data.getStringExtra(Image.imgurl);
                Toast.makeText(this, furl, Toast.LENGTH_LONG).show();
            }
            foreground_button.setBackgroundResource(R.drawable.selected);
        }
    }
}
