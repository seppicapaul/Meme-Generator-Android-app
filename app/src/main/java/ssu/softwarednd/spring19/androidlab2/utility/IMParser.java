package ssu.softwarednd.spring19.androidlab2.utility;


import com.google.gson.Gson;

import java.util.List;

import ssu.softwarednd.spring19.androidlab2.models.ImgurModel;
import ssu.softwarednd.spring19.androidlab2.models.ImgurResponse;

public class IMParser {

    private static final String TAG = "IMParser";

    public static List<ImgurModel> getmatch(String json) {

        Gson gson = new Gson();

        ImgurResponse response = gson.fromJson(json, ImgurResponse.class);

       /* List<ImgurModel> imList = new ArrayList<>();

         try {
            JSONObject response = new JSONObject(json);
            JSONArray matches = response.getJSONArray("data");
            JSONObject image = matches.getJSONObject(0);
            String imName = image.getString("link");

            ImgurModel model = new ImgurModel();
            model.setImgurName(imName);

            imList.add(model);

        }catch (JSONException e) {
            Log.e(TAG, "getMatches: error parsing JSON", e);
        }*/

        return response.getData();
    }
}
