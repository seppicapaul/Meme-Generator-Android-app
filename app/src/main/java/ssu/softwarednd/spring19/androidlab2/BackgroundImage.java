package ssu.softwarednd.spring19.androidlab2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import ssu.softwarednd.spring19.androidlab2.background.ImgurViewAdapter;
import ssu.softwarednd.spring19.androidlab2.models.ImgurModel;
import ssu.softwarednd.spring19.androidlab2.search.ImgurSearchAsyncTask;


public class BackgroundImage extends AppCompatActivity {

    private EditText searchEditText;
    private Button searchButton;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_image);
        searchEditText = findViewById(R.id.search_edit_text);
        searchButton = findViewById(R.id.image_search_button);
        recyclerView = findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(layoutManager);


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImgurSearchAsyncTask task = new ImgurSearchAsyncTask();
                task.setImgurListener(new ImgurSearchAsyncTask.IMListener() {
                    @Override
                    public void onIMCallback(List<ImgurModel> models) {
                        ImgurViewAdapter adapter = new ImgurViewAdapter(models);
                        recyclerView.setAdapter(adapter);

                }
                });
                task.execute(searchEditText.getText().toString());
            }
        });
    }
}



