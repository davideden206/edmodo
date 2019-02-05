package android.course.edmodo_203898309_305186108.Notification;

import android.graphics.Bitmap;

public class ObjNotification {
    private int idNotification;
    private int idProfile;
    private int idClass;
    private int idPost;
    private Bitmap imageProfile;

    public ObjNotification(int idProfile, int idClass, int idPost, Bitmap imageProfile) {
        this.idProfile = idProfile;
        this.idClass = idClass;
        this.idPost = idPost;
        this.imageProfile = imageProfile;
    }

    public int getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(int idNotification) {
        this.idNotification = idNotification;
    }

    public int getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(int idProfile) {
        this.idProfile = idProfile;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public Bitmap getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(Bitmap imageProfile) {
        this.imageProfile = imageProfile;
    }
}
