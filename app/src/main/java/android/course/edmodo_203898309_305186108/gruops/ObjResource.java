package android.course.edmodo_203898309_305186108.gruops;

import android.graphics.Bitmap;

public class ObjResource {
    private int id;
    private String name;
    private Bitmap image;
    private String link;
    private int classesId;

    public ObjResource() {
    }

    public ObjResource(String name, Bitmap image, String link, int classesId) {

        this.name = name;
        this.image = image;
        this.link = link;
        this.classesId = classesId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getClassesId() {
        return classesId;
    }

    public void setClassesId(int classesId) {
        this.classesId = classesId;
    }
}
