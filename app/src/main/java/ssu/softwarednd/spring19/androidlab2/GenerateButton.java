package ssu.softwarednd.spring19.androidlab2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;


public class GenerateButton extends AppCompatActivity {

    private Button generate;
    private View content;
    private File save_location;
    private Bitmap bitmap;
    private ImageView display;
    private TextView topText;
    private TextView bottomText;
    private Button save_button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_button);


        //       display = findViewById(R.id.display);
        content = findViewById(R.id.relativeLayout);

        generate = findViewById(R.id.generate);
        generate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                content.setDrawingCacheEnabled(true);
                bitmap = content.getDrawingCache();
                save_location = new File(getFilesDir(), "temp_name"); //change this to date:time
                try {
                    FileOutputStream ostream = new FileOutputStream(save_location);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 10, ostream);
                    ostream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    content.setDrawingCacheEnabled(false);
                }
                generate.setText("Done");

                save_location = new File(getFilesDir(), fileList()[0]);
                bitmap = BitmapFactory.decodeFile(save_location.getAbsolutePath());
                //     display.setImageBitmap(bitmap);
            }
        });

/*
        save_button = findViewById(R.id.save_button);
        topText = findViewById(R.id.topText);
        bottomText = findViewById(R.id.bottomText);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent save = new Intent(GenerateButton.this, MainActivity.class);
                startActivity(save);
            }
        });*/

        Bundle bundle = getIntent().getExtras();

        String top_text = bundle.getString("TOP_TEXT", "");
        String bottom_text = bundle.getString("BOTTOM_TEXT", "");
        int red = bundle.getInt("RED", 0);
        int green = bundle.getInt("GREEN", 255);
        int blue = bundle.getInt("BLUE", 0);
        String url = bundle.getString("URL");

        topText = findViewById(R.id.topText);
        bottomText = findViewById(R.id.bottomText);

        topText.setTypeface(Typeface.createFromAsset(getAssets(),"impact.ttf"));
        bottomText.setTypeface(Typeface.createFromAsset(getAssets(),"impact.ttf"));

        topText.setText(top_text);

        bottomText.setText(bottom_text);
        topText.setTextColor(Color.rgb(red, green, blue));
        bottomText.setTextColor(Color.rgb(red, green, blue));
        Picasso.get().load(url).resize(1000, 1000)
                .centerCrop().into(display);



    }
}