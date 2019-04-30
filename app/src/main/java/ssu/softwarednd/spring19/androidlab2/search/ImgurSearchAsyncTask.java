package ssu.softwarednd.spring19.androidlab2.search;

import android.os.AsyncTask;

import java.util.List;

import ssu.softwarednd.spring19.androidlab2.models.ImgurModel;
import ssu.softwarednd.spring19.androidlab2.utility.IMParser;

public class ImgurSearchAsyncTask extends AsyncTask<String, Void, List<ImgurModel>> {

    private IMListener listener;


    public interface IMListener {
        void onIMCallback(List<ImgurModel> models);
    }

    @Override
    protected List<ImgurModel> doInBackground(String... params) {

        String searchTerm = params[0];
        String responseJson = imgurSearch.searchIM(searchTerm);


        if (responseJson != null) {
            List<ImgurModel> models = IMParser.getmatch(responseJson);
            return models;
        }

        return null;
    }


    @Override
    protected void onPostExecute(List<ImgurModel> imgurModels) {

        super.onPostExecute(imgurModels);

        listener.onIMCallback(imgurModels);
    }


    public void setImgurListener(IMListener listener) {

        this.listener = listener;
    }
}