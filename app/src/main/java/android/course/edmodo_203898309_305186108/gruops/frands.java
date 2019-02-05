package android.course.edmodo_203898309_305186108.gruops;


import android.course.edmodo_203898309_305186108.Fclasses.UserPrfile;
import android.graphics.Bitmap;

public class frands {
    private UserPrfile userPrfile;
    String nicname;

    public frands(UserPrfile userPrfile, String nicname) {
        this.userPrfile = userPrfile;
        this.nicname = nicname;
    }

    public UserPrfile getUserPrfile() {
        return userPrfile;
    }

    public void setUserPrfile(UserPrfile userPrfile) {
        this.userPrfile = userPrfile;
    }

    public String getNicname() {
        return nicname;
    }

    public void setNicname(String nicname) {
        this.nicname = nicname;
    }
}
