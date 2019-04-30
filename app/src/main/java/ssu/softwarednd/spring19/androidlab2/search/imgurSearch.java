package ssu.softwarednd.spring19.androidlab2.search;

import android.util.Log;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class imgurSearch {
    private static final String TAG = "imgurSearch";

    private static final String baseApiUrl = "https://api.imgur.com/3/gallery/search/top";
    private static final String ClientId = "b94fedace2c3763";

    public static String searchIM(String input) {
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseApiUrl).newBuilder();
        urlBuilder.addQueryParameter("q", input);

        String url = urlBuilder.build().toString();


        Request request = new Request.Builder()
                .url(url)
                .header("Authorization","Client-ID b94fedace2c3763")
                .build();

        try {

            Response response = client.newCall(request).execute();
            if (response != null) {
                return response.body().string();
            }
        }catch (IOException e) {
            // log the error to the console window (logcat)
            Log.e(TAG, "Images: ", e);
        }
        return null;
    }
}
