package ssu.softwarednd.spring19.androidlab2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;

public class GenerateButton extends AppCompatActivity {

    private Button generate, back_button;
    private View content;
    private File save_location;
    private Bitmap bitmap;
    private ImageView display;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_button);

        back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });

        display = findViewById(R.id.display);
        content = findViewById(R.id.relativeLayout);

        generate = findViewById(R.id.generate);
        generate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                content.setDrawingCacheEnabled(true);
                bitmap = content.getDrawingCache();
                save_location = new File(getFilesDir(), "temp_name");
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
                display.setImageBitmap(bitmap);
            }
        });

    }
}
