package android.course.edmodo_203898309_305186108;

public class ObjPost {
    private int id;
    private int profileId;
    private int classesId;
    private String textPost;

    public ObjPost() {
    }

    public ObjPost(int profileId, int classesId, String textPost) {
        this.profileId = profileId;
        this.classesId = classesId;
        this.textPost = textPost;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public int getClassesId() {
        return classesId;
    }

    public void setClassesId(int classesId) {
        this.classesId = classesId;
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
