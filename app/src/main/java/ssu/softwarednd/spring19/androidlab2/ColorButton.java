package ssu.softwarednd.spring19.androidlab2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class ColorButton extends AppCompatActivity {


    private TextView sample_text;
    private TextView red_progress;
    private TextView green_progress;
    private TextView blue_progress;

    private SeekBar black_color;
    private SeekBar red_color;
    private SeekBar green_color;
    private SeekBar blue_color;

    private Button choose;

    private int red = 0;
    private int green = 0;
    private int blue = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_button);

        black_color = findViewById(R.id.black_seekBar);
        red_color = findViewById(R.id.red_seekBar);
        green_color = findViewById(R.id.green_seekBar);
        blue_color = findViewById(R.id.blue_seekBar);

        sample_text = findViewById(R.id.sample_text);
        red_progress = findViewById(R.id.red_progress);
        green_progress = findViewById(R.id.green_progress);
        blue_progress = findViewById(R.id.blue_progress);

        choose = findViewById(R.id.choose_button);

        sample_text.setTypeface(Typeface.createFromAsset(getAssets(),"impact.ttf"));

        black_color.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                red = progress;
                green = progress;
                blue = progress;
                red_color.setProgress(progress);
                green_color.setProgress(progress);
                blue_color.setProgress(progress);
                sample_text.setTextColor(Color.rgb(red, green, blue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }

        });


        red_color.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                red = progress;
                sample_text.setTextColor(Color.rgb(red, green, blue));
                red_progress.setText(String.valueOf(red));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }

        });

        green_color.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                green = progress;
                sample_text.setTextColor(Color.rgb(red, green, blue));
                green_progress.setText(String.valueOf(green));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }

        });

        blue_color.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blue = progress;
                sample_text.setTextColor(Color.rgb(red, green, blue));
                blue_progress.setText(String.valueOf(blue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }

        });

        choose.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent resultIntent = new Intent();
                resultIntent.putExtra("red", red);
                resultIntent.putExtra("green", green);
                resultIntent.putExtra("blue", blue);

                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
