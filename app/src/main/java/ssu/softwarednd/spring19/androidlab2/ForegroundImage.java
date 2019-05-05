package ssu.softwarednd.spring19.androidlab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import ssu.softwarednd.spring19.androidlab2.background.ImgurViewAdapter;
import ssu.softwarednd.spring19.androidlab2.models.ImgurModel;
import ssu.softwarednd.spring19.androidlab2.search.ImgurSearchAsyncTask;

public class ForegroundImage extends AppCompatActivity {

    private EditText searchEditText;
    private Button searchButton;

    private RecyclerView recyclerView;
    static final String imgurl = "URL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreground_image);
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
                        ImgurViewAdapter adapter = new ImgurViewAdapter(models, new ImgurViewAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(ImgurModel item) {
                                Intent imintent = new Intent();
                                imintent.putExtra(imgurl, item.getLink());
                                setResult(RESULT_OK, imintent);
                                finish();
                            }
                        });
                        recyclerView.setAdapter(adapter);

                    }
                });
                task.execute(searchEditText.getText().toString());
            }
        });
    }
}



