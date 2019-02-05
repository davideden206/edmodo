package android.course.edmodo_203898309_305186108.Fmessages;

import android.graphics.Bitmap;

public class ListUsers {
    private Bitmap idImg;
    private String name;

    public ListUsers(Bitmap idImg, String name) {
        this.idImg = idImg;
        this.name = name;
    }

    public Bitmap getIdImg() {
        return idImg;
    }

    public void setIdImg(Bitmap idImg) {
        this.idImg = idImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
