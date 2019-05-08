package ssu.softwarednd.spring19.androidlab2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class SavedActivity extends AppCompatActivity {

    private Button ToMain;
    private Button Display_button;
    private int i = 0, max;
    private File save_location;
    private Bitmap bitmap;
    private Drawable background;
    private TextView number;
    private Button next, previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

        number = findViewById(R.id.number);
        Display_button = findViewById(R.id.saved_image);
        next = findViewById(R.id.next);
        previous = findViewById(R.id.previous);
        ToMain = findViewById(R.id.saved_button);

        previous.setText("<- Prev");

        max = fileList().length;
        number.setText((i+1) + "/" + max);


        if (i < max) {
            save_location = new File(getFilesDir(), fileList()[0]);
            bitmap = BitmapFactory.decodeFile(save_location.getAbsolutePath());
            background = new BitmapDrawable(getResources(), bitmap);
            Display_button.setBackground(background);
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i < max - 1)
                    i = i + 1;
                else
                    i = 0;
                save_location = new File(getFilesDir(), fileList()[i]);
                bitmap = BitmapFactory.decodeFile(save_location.getAbsolutePath());
                background = new BitmapDrawable(getResources(), bitmap);
                Display_button.setBackground(background);
                number.setText((i+1) + "/" + max);
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i > 0)
                    i = i - 1;
                else
                    i = max - 1;
                save_location = new File(getFilesDir(), fileList()[i]);
                bitmap = BitmapFactory.decodeFile(save_location.getAbsolutePath());
                background = new BitmapDrawable(getResources(), bitmap);
                Display_button.setBackground(background);
                number.setText((i+1) + "/" + max);
            }
        });

        ToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SavedActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
