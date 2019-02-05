package android.course.edmodo_203898309_305186108;

import android.content.Context;
import android.course.edmodo_203898309_305186108.Fclasses.ObjMyClasses;
import android.course.edmodo_203898309_305186108.Fclasses.UserPrfile;
import android.course.edmodo_203898309_305186108.Fmessages.ObjMeesage;
import android.course.edmodo_203898309_305186108.gruops.ObjResource;

import java.util.ArrayList;
import java.util.List;

public class MyEdmodoDBManager {

    private static MyEdmodoDBManager instance = null;
    private Context context = null;
    private MyEdmodoDB db = null;
    private UserPrfile selectUserPrfile = null;
    private ObjMyClasses selectObjMyClasses = null;
    private ObjResource selectObjResource = null;
    private ObjMeesage selectObjMeesage = null;
    private ObjPost selectObjPost = null;

    public MyEdmodoDB getDb() {
        return db;
    }

    public static MyEdmodoDBManager getInstance() {
        if (instance == null) {
            instance = new MyEdmodoDBManager();
        }
        return instance;
    }

    public static void releaseInstance() {
        if (instance != null) {
            instance.clean();
            instance = null;
        }
    }

    private void clean() {

    }


    public Context getContext() {
        return context;

    }

    public void openDataBase(Context context) {
        this.context = context;
        if (context != null) {
            db = new MyEdmodoDB(context);
            db.open();
        }
    }
    public void closeDataBase() {
        if(db!=null){
            db.close();
        }
    }

    public void addProfile(UserPrfile userPrfile) {
        if (db != null) {
            db.addProfile(userPrfile);
        }
    }

    public int addClasses(ObjMyClasses objMyClasses) {
        int classId = 0;
        if (db != null) {
            classId = db.addClasses(objMyClasses);
        }
        return classId;
    }
    public ObjMyClasses getClass( int code) {
        ObjMyClasses class1 = null;
        if (db != null) {
            class1= db.getClass(code);
        }
        return class1;
    }

    public void addPost(ObjPost objPost) {
        if (db != null) {
            db.addPost(objPost);
        }
    }

    public void addResource(ObjResource objResource) {
        if (db != null) {
            db.addResource(objResource);
        }
    }

    public void addMessage(ObjMeesage objMeesage) {
        if (db != null) {
            db.addMessage(objMeesage);
        }
    }

    public void addProfileInClasses(int userPrfileid, int objMyClassesid) {
        if (db != null) {
            db.addProfileInClasses(userPrfileid,objMyClassesid);
        }
    }

   /* public void updateProfileInClasses(int classId, int profileId) {
        //ObjProfileInClass objProfileInClass = null;
        if (db != null) {
            db.updateProfileInClasses(classId,profileId);
        }

    }*/

    public ArrayList<UserPrfile> frindsInClass(int idClass) {
        ArrayList<UserPrfile> usersProfileArray =null;
        if (db != null) {
            usersProfileArray = db.frindsInClass(idClass);
        }
        return usersProfileArray;
    }

    public ArrayList<ObjMyClasses> allClassInProfile(int idProfile) {
        ArrayList<ObjMyClasses> usersClassArray = new ArrayList<ObjMyClasses>();;
        if (db != null) {
            usersClassArray =  db.allClassInProfile(idProfile);
        }
        return usersClassArray;
    }

    public void createNewClasses(String name,int idTeacher) {
        if (db != null) {
            db.createNewClasses(name,idTeacher);
        }
    }

    public ArrayList<ObjResource> allResourceInClass(int idClass) {
        ArrayList<ObjResource> ResourceInClassArray = new ArrayList<>();
        if (db != null) {
            ResourceInClassArray = db.allResourceInClass(idClass);
        }
        return ResourceInClassArray;
    }


    public ArrayList<ObjMeesage> displayMeesageFromAndTo(int profileFrom,int profileTo) {
        ArrayList<ObjMeesage> messageBettwen2Pepole = new ArrayList<>();
        if (db != null) {
            messageBettwen2Pepole =  db.displayMeesageFromAndTo(profileFrom,profileTo);
        }
        return messageBettwen2Pepole;
    }

    public ArrayList<ObjPost> displayPostByClass(int idClass){
        ArrayList<ObjPost> postArray = new ArrayList<>();
        if (db != null) {
            postArray = db.displayPostByClass(idClass);
        }
        return postArray;
    }

    public UserPrfile getSelectUserPrfile() {
        return selectUserPrfile;
    }

    public void setSelectUserPrfile(UserPrfile selectUserPrfile) {
        this.selectUserPrfile = selectUserPrfile;
    }

    public ObjMyClasses getSelectObjMyClasses() {
        return selectObjMyClasses;
    }

    public void setSelectObjMyClasses(ObjMyClasses selectObjMyClasses) {
        this.selectObjMyClasses = selectObjMyClasses;
    }

    public ObjResource getSelectObjResource() {
        return selectObjResource;
    }

    public void setSelectObjResource(ObjResource selectObjResource) {
        this.selectObjResource = selectObjResource;
    }

    public ObjMeesage getSelectObjMeesage() {
        return selectObjMeesage;
    }

    public void setSelectObjMeesage(ObjMeesage selectObjMeesage) {
        this.selectObjMeesage = selectObjMeesage;
    }

    public ObjPost getSelectObjPost() {
        return selectObjPost;
    }

    public void setSelectObjPost(ObjPost selectObjPost) {
        this.selectObjPost = selectObjPost;
    }

    public UserPrfile readuser(int id) {
        UserPrfile userPrfile = null;
        if (db != null) {
            userPrfile = db.readuser(id);
        }
        return userPrfile;
    }

    public void deletePost(int Idpost) {
        if (db != null) {
            db.deletePost(Idpost);
        }
    }

    public void deleteClass(ObjMyClasses objMyClasses) {
        if (db != null) {
            db.deleteClass(objMyClasses);
        }
    }

    public void deleteProfileInClasses(int userPrfileid, int objMyClassesid) {
        if (db != null) {
            db.deleteProfileInClasses(userPrfileid,objMyClassesid);
        }
    }

    public void deleteTecherProfileInClasses( int objMyClassesid) {
        if (db != null) {
            db.deleteTecherProfileInClasses(objMyClassesid);
        }
    }

    public void deleteMessage(ObjMeesage objMeesage) {
        if (db != null) {
            db.deleteMessage(objMeesage);
        }
    }

    public void updatePost(ObjPost post) {
        if (db != null && post != null) {
            db.updatePost(post);
        }
    }

    public ObjPost redPostById(int idPost) {
        ObjPost objPost=null;
        if(db!=null){
            objPost = db.redPostById(idPost);
        }
        return objPost;
    }

    public boolean haveMessage(int profileId){
        boolean flag = false;
        if(db!=null){
            flag =  db.haveMessage(profileId);
        }return flag;
    }
}
