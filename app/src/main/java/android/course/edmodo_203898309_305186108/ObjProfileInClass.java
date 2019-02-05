package android.course.edmodo_203898309_305186108;

import android.course.edmodo_203898309_305186108.Fclasses.ObjMyClasses;
import android.course.edmodo_203898309_305186108.Fclasses.UserPrfile;

public class ObjProfileInClass {
    private UserPrfile userPrfile;
    private ObjMyClasses objMyClasses;

    public ObjProfileInClass(UserPrfile userPrfile, ObjMyClasses objMyClasses) {
        this.userPrfile = userPrfile;
        this.objMyClasses = objMyClasses;
    }

    public UserPrfile getUserPrfile() {
        return userPrfile;
    }

    public void setUserPrfile(UserPrfile userPrfile) {
        this.userPrfile = userPrfile;
    }

    public ObjMyClasses getObjMyClasses() {
        return objMyClasses;
    }

    public void setObjMyClasses(ObjMyClasses objMyClasses) {
        this.objMyClasses = objMyClasses;
    }
}
