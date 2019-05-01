package ssu.softwarednd.spring19.androidlab2.models;

public class ImgurModel {

        private String title;

        private String link;

        private boolean is_album;
        private String cover;



        public String getImgurName() {
            return title;
        }

        public String getLink() {
            if (is_album) {
                String string = "http://imgur.com/" + cover;
                return string;
            } else {
                return link;
            }
        }

}
