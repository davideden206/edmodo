package android.course.edmodo_203898309_305186108;

import android.course.edmodo_203898309_305186108.Fclasses.UserPrfile;

public class ObjFinalPost {
    private int id;
    private UserPrfile userPrfile;
    private String textPost;

    public ObjFinalPost(int id,UserPrfile userPrfile, String textPost) {
        this.id = id;
        this.userPrfile = userPrfile;
        this.textPost = textPost;
    }

    public UserPrfile getUserPrfile() {
        return userPrfile;
    }

    public void setUserPrfile(UserPrfile userPrfile) {
        this.userPrfile = userPrfile;
    }

    public String getTextPost() {
        return textPost;
    }

    public void setTextPost(String textPost) {
        this.textPost = textPost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
