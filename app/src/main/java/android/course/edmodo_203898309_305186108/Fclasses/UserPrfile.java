package android.course.edmodo_203898309_305186108.Fclasses;

import android.graphics.Bitmap;

import java.util.List;

public class UserPrfile {

    private int id;
    private String type;
    private Bitmap id_ImageProfile;
    private String name;

    public UserPrfile() {
    }

    public UserPrfile( String type, String name,Bitmap id_ImageProfile) {

        this.type = type;
        this.id_ImageProfile = id_ImageProfile;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Bitmap getId_ImageProfile() {
        return id_ImageProfile;
    }

    public void setId_ImageProfile(Bitmap id_ImageProfile) {
        this.id_ImageProfile = id_ImageProfile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        return this.getName() == ((UserPrfile) obj).getName();
    }
}
