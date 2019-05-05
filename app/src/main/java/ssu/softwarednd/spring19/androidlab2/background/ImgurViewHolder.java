package ssu.softwarednd.spring19.androidlab2.background;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import ssu.softwarednd.spring19.androidlab2.R;

import ssu.softwarednd.spring19.androidlab2.models.ImgurModel;

public class ImgurViewHolder extends RecyclerView.ViewHolder {

    private TextView ImageNameTextView;
    private ImageView ImageURLTextView;
    //private TextView imageurl;

    public ImgurViewHolder(View itemView) {
        super(itemView);

        ImageNameTextView = itemView.findViewById(R.id.image_name);
        ImageURLTextView = itemView.findViewById(R.id.image_url);
        //imageurl = itemView.findViewById(R.id.imageurl);

    }

    public void bindView(final ImgurModel model, final ImgurViewAdapter.OnItemClickListener listener) {

        //ImageNameTextView.setText(model.getImgurName());
        Picasso.get().load(String.format("%s.jpg", model.getLink())).resize(1000, 1000)
                .centerCrop().into(ImageURLTextView);
        //imageurl.setText(model.getLink());
        ImageURLTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(model);
            }
        });


    }
}

