package android.course.edmodo_203898309_305186108;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.course.edmodo_203898309_305186108.Fclasses.MyClassesFragment;
import android.course.edmodo_203898309_305186108.Fclasses.ObjMyClasses;
import android.course.edmodo_203898309_305186108.Fclasses.UserPrfile;
import android.course.edmodo_203898309_305186108.Fmessages.ObjMeesage;
import android.course.edmodo_203898309_305186108.Notification.ObjNotification;
import android.course.edmodo_203898309_305186108.ObjPost;
import android.course.edmodo_203898309_305186108.gruops.ObjResource;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;

public class MyEdmodoDB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "EdmodoDB";

    //profile table
    private static final String TABLE_PROFILE_USERS = "profileUsers";
    private static final String PROFILE_USERS_COLUMN_ID = "id";
    private static final String PROFILE_USERS_COLUMN_TYPE = "type";
    private static final String PROFILE_USERS_COLUMN_NAME = "name";
    private static final String PROFILE_USERS_COLUMN_IMAGE = "image";
    private static final String[] TABLE_PROFILE_USERS_COLUM = {PROFILE_USERS_COLUMN_ID, PROFILE_USERS_COLUMN_TYPE,
            PROFILE_USERS_COLUMN_NAME, PROFILE_USERS_COLUMN_IMAGE};

    //classes table
    private static final String TABLE_CLASSES = "classes";
    private static final String CLASSES_COLUMN_ID = "id";
    private static final String CLASSES_COLUMN_NAME = "name";
    private static final String[] TABLE_CLASSES_COLUM = {CLASSES_COLUMN_ID, CLASSES_COLUMN_NAME};

    //profile in classes connect tables
    private static final String TABLE_PROFILE_IN_CLASSES = "profileInClasses";
    private static final String PROFILE_IN_CLASSES_COLUMN_ID_PROFILE = "idProfile";
    private static final String PROFILE_IN_CLASSES_COLUMN_ID_CLASSES = "idClasses";
    private static final String[] TABLE_PROFILE_IN_CLASSES_COLUM = {PROFILE_IN_CLASSES_COLUMN_ID_PROFILE, PROFILE_IN_CLASSES_COLUMN_ID_CLASSES};

    //post table
    private static final String TABLE_POST = "post";
    private static final String POST_COLUMN_ID_PROFILE = "idProfile";
    private static final String POST_COLUMN_TEXT = "text";
    private static final String POST_COLUMN_CLASSES_ID = "classesId";
    private static final String POST_COLUMN_ID = "idPost";
    private static final String[] TABLE_POST_COLUM = {POST_COLUMN_ID_PROFILE, POST_COLUMN_TEXT, POST_COLUMN_CLASSES_ID, POST_COLUMN_ID};

    //resource table
    private static final String TABLE_RESOURCE = "resource";
    private static final String RESOURCE_COLUMN_RESOURCE_ID = "resourceID";
    private static final String RESOURCE_COLUMN_CLASSES_ID = "classesID";
    private static final String RESOURCE_COLUMN_NAME = "name";
    private static final String RESOURCE_COLUMN_IMAGE = "image";
    private static final String RESOURCE_COLUMN_LINK = "link";
    private static final String[] TABLE_RESOURCE_COLUM = {RESOURCE_COLUMN_RESOURCE_ID,
            RESOURCE_COLUMN_CLASSES_ID, RESOURCE_COLUMN_NAME, RESOURCE_COLUMN_IMAGE, RESOURCE_COLUMN_LINK};

    //message table
    private static final String TABLE_MESSAGE = "message";
    private static final String MESSAGE_COLUMN_ID_MASSAGE = "idMessage";
    private static final String MESSAGE_COLUMN_ID_PROFILE = "idProfileFrom";
    private static final String MESSAGE_COLUMN_ID_PROFILE2 = "idProfileTo";
    private static final String MESSAGE_COLUMN_TEXT_MESSAGE = "textMessage";
    //private static final String MESSAGE_COLUMN_TIME = "time";
    private static final String[] TABLE_MESSAGE_COLUM = {MESSAGE_COLUMN_ID_MASSAGE,
            MESSAGE_COLUMN_ID_PROFILE, MESSAGE_COLUMN_ID_PROFILE2, MESSAGE_COLUMN_TEXT_MESSAGE};

    private static final String TABLE_NOTIFICATIN = "notification";
    private static final String NOTIFICATIN_COLUMN_ID = "id";
    private static final String NOTIFICATIN_COLUMN_HOW = "how";
    private static final String NOTIFICATIN_COLUMN_CLASS_ID = "classId";
    private static final String NOTIFICATIN_COLUMN_POST_ID = "postId";
    private static final String[] TABLE_NOTIFICATIN_COLUM = {NOTIFICATIN_COLUMN_ID,
            NOTIFICATIN_COLUMN_HOW, NOTIFICATIN_COLUMN_CLASS_ID,NOTIFICATIN_COLUMN_POST_ID};

    private SQLiteDatabase db = null;

    public MyEdmodoDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            String CREATE_PROFILE_TABLE = "create table if not exists " + TABLE_PROFILE_USERS + " ( "
                    + PROFILE_USERS_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + PROFILE_USERS_COLUMN_TYPE + " TEXT, "
                    + PROFILE_USERS_COLUMN_NAME + " TEXT, "
                    + PROFILE_USERS_COLUMN_IMAGE + " BLOB" + ")";
            db.execSQL(CREATE_PROFILE_TABLE);

            String CREATE_CLASSES_TABLE = "create table if not exists " + TABLE_CLASSES + " ( "
                    + CLASSES_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + CLASSES_COLUMN_NAME + " TEXT " + ")";
            db.execSQL(CREATE_CLASSES_TABLE);

            String CREATE_PROFILE_IN_CLASSES_TABLE = "create table if not exists " + TABLE_PROFILE_IN_CLASSES + " ( "
                    + PROFILE_IN_CLASSES_COLUMN_ID_PROFILE + " INTEGER , "
                    + PROFILE_IN_CLASSES_COLUMN_ID_CLASSES + " INTEGER ,"
                    + "FOREIGN KEY" + "(" + PROFILE_IN_CLASSES_COLUMN_ID_PROFILE + ")" + "REFERENCES " + TABLE_PROFILE_USERS + "(" + PROFILE_USERS_COLUMN_ID + "),"
                    + "FOREIGN KEY" + "(" + PROFILE_IN_CLASSES_COLUMN_ID_CLASSES + ")" + "REFERENCES " + TABLE_CLASSES + "(" + CLASSES_COLUMN_ID + "))";
            db.execSQL(CREATE_PROFILE_IN_CLASSES_TABLE);

            String CREATE_POST_TABLE = "create table if not exists " + TABLE_POST + " ( "
                    + POST_COLUMN_ID_PROFILE + " INTEGER, "
                    + POST_COLUMN_TEXT + " TEXT, "
                    + POST_COLUMN_CLASSES_ID + " INTEGER,"
                    + POST_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "FOREIGN KEY" + "(" + POST_COLUMN_ID_PROFILE + ")" + "REFERENCES " + TABLE_PROFILE_USERS + "(" + PROFILE_USERS_COLUMN_ID + "),"
                    + "FOREIGN KEY" + "(" + POST_COLUMN_CLASSES_ID + ")" + "REFERENCES " + TABLE_CLASSES + "(" + CLASSES_COLUMN_ID + "))";

            db.execSQL(CREATE_POST_TABLE);

            String CREATE_RESOURCE_TABLE = "create table if not exists " + TABLE_RESOURCE + " ( "
                    + RESOURCE_COLUMN_RESOURCE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + RESOURCE_COLUMN_CLASSES_ID + " INTEGER, "
                    + RESOURCE_COLUMN_NAME + " TEXT, "
                    + RESOURCE_COLUMN_IMAGE + " BLOB,"
                    + RESOURCE_COLUMN_LINK + " TEXT ,"
                    + "FOREIGN KEY" + "(" + RESOURCE_COLUMN_CLASSES_ID + ")" + "REFERENCES " + TABLE_CLASSES + "(" + CLASSES_COLUMN_ID + "))";
            db.execSQL(CREATE_RESOURCE_TABLE);

            String CREATE_MESSAGE_TABLE = "create table if not exists " + TABLE_MESSAGE + " ( "
                    + MESSAGE_COLUMN_ID_MASSAGE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + MESSAGE_COLUMN_ID_PROFILE + " INTEGER, "
                    + MESSAGE_COLUMN_ID_PROFILE2 + " INTEGER, "
                    + MESSAGE_COLUMN_TEXT_MESSAGE + " TEXT,"
                    //+ MESSAGE_COLUMN_TIME + " DATE, "
                    + "FOREIGN KEY" + "(" + MESSAGE_COLUMN_ID_PROFILE + ")" + "REFERENCES " + TABLE_PROFILE_USERS + "(" + PROFILE_USERS_COLUMN_ID + "),"
                    + "FOREIGN KEY" + "(" + MESSAGE_COLUMN_ID_PROFILE + ")" + "REFERENCES " + TABLE_PROFILE_USERS + "(" + PROFILE_USERS_COLUMN_ID + "))";
            db.execSQL(CREATE_MESSAGE_TABLE);


            String CREATE_NOTIFICATIN_TABLE = "create table if not exists " + TABLE_NOTIFICATIN + " ( "
                    + NOTIFICATIN_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + NOTIFICATIN_COLUMN_HOW + " INTEGER, "
                    + NOTIFICATIN_COLUMN_CLASS_ID + " INTEGER,"
                    + NOTIFICATIN_COLUMN_POST_ID + " INTEGER, "
                    + "FOREIGN KEY" + "(" + NOTIFICATIN_COLUMN_CLASS_ID + ")" + "REFERENCES " + TABLE_CLASSES + "(" + CLASSES_COLUMN_ID + "),"
                    + "FOREIGN KEY" + "(" + NOTIFICATIN_COLUMN_HOW + ")" + "REFERENCES " + TABLE_PROFILE_USERS + "(" + PROFILE_USERS_COLUMN_NAME + "),"
                    + "FOREIGN KEY" + "(" + NOTIFICATIN_COLUMN_POST_ID + ")" + "REFERENCES " + TABLE_POST + "(" + POST_COLUMN_ID + "))";
            db.execSQL(CREATE_NOTIFICATIN_TABLE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL("DROP TABLE IF EXISTS profileUsers");
            db.execSQL("DROP TABLE IF EXISTS classes");
            db.execSQL("DROP TABLE IF EXISTS profileInClasses");
            db.execSQL("DROP TABLE IF EXISTS post");
            db.execSQL("DROP TABLE IF EXISTS resource");
            db.execSQL("DROP TABLE IF EXISTS message");
            db.execSQL("DROP TABLE IF EXISTS notification");
        } catch (Throwable t) {
            t.printStackTrace();
        }
        onCreate(db);
    }


    public void addProfile(UserPrfile userPrfile) {
        try {
            ContentValues values = new ContentValues();
            //values.put(PROFILE_USERS_COLUMN_ID, userPrfile.getId());
            values.put(PROFILE_USERS_COLUMN_TYPE, userPrfile.getType());
            values.put(PROFILE_USERS_COLUMN_NAME, userPrfile.getName());
            Bitmap image1 = userPrfile.getId_ImageProfile();
            if (image1 != null) {
                byte[] data = getBitmapAsByteArray(image1);
                if (data != null && data.length > 0) {
                    values.put(PROFILE_USERS_COLUMN_IMAGE, data);
                }
            }
            db.insert(TABLE_PROFILE_USERS, null, values);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int addClasses(ObjMyClasses objMyClasses) {
        ObjMyClasses class1 = null;
        try {
            ContentValues values = new ContentValues();
            //values.put(CLASSES_COLUMN_ID, objMyClasses.getId());
            values.put(CLASSES_COLUMN_NAME, objMyClasses.getName());
            db.insert(TABLE_CLASSES, null, values);

            Cursor cursor = null;

            /// get reference of the itemDB database

            // get  query
            cursor = db
                    .query(TABLE_CLASSES,
                            TABLE_CLASSES_COLUM, CLASSES_COLUMN_NAME + " = ?",
                            new String[]{String.valueOf(objMyClasses.getName())}, null, null,
                            null, null);


            // if results !=null, parse the first one
            if (cursor != null && cursor.getCount() > 0) {

                cursor.moveToFirst();
                class1 = new ObjMyClasses();
                class1.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(PROFILE_USERS_COLUMN_ID))));
                class1.setName(cursor.getString(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return class1.getId();
    }

    public void addPost(ObjPost objPost) {
        try {
            ContentValues values = new ContentValues();
            values.put(POST_COLUMN_ID_PROFILE, objPost.getProfileId());
            values.put(POST_COLUMN_TEXT, objPost.getTextPost());
            values.put(POST_COLUMN_CLASSES_ID, objPost.getClassesId());
            db.insert(TABLE_POST, null, values);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addResource(ObjResource objResource) {
        try {
            ContentValues values = new ContentValues();
            // values.put(RESOURCE_COLUMN_RESOURCE_ID, objResource.getId());
            values.put(RESOURCE_COLUMN_CLASSES_ID, objResource.getClassesId());
            values.put(RESOURCE_COLUMN_NAME, objResource.getName());
            Bitmap image1 = objResource.getImage();
            if (image1 != null) {
                byte[] data = getBitmapAsByteArray(image1);
                if (data != null && data.length > 0) {
                    values.put(RESOURCE_COLUMN_IMAGE, data);
                }

            }
            values.put(RESOURCE_COLUMN_LINK, objResource.getLink());
            db.insert(TABLE_RESOURCE, null, values);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addMessage(ObjMeesage objMeesage) {
        try {
            ContentValues values = new ContentValues();
            //values.put(MESSAGE_COLUMN_ID_MASSAGE, objMeesage.getId());
            values.put(MESSAGE_COLUMN_ID_PROFILE, objMeesage.getIdProfileFrom());
            values.put(MESSAGE_COLUMN_ID_PROFILE2, objMeesage.getIdProfileTo());
            values.put(MESSAGE_COLUMN_TEXT_MESSAGE, objMeesage.getTextMessage());
            //values.put(MESSAGE_COLUMN_TIME, objMeesage.getDate().toString());

            db.insert(TABLE_MESSAGE, null, values);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private byte[] getBitmapAsByteArray(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        return outputStream.toByteArray();
    }


    public void addProfileInClasses(int userPrfileid, int objMyClassesid) {
        ContentValues values = new ContentValues();

        values.put(PROFILE_IN_CLASSES_COLUMN_ID_PROFILE, userPrfileid);
        values.put(PROFILE_IN_CLASSES_COLUMN_ID_CLASSES, objMyClassesid);

        db.insert(TABLE_PROFILE_IN_CLASSES, null, values);

    }


    public ArrayList<UserPrfile> frindsInClass(int idClass) {
        ArrayList<UserPrfile> usersProfileArray = new ArrayList<>();

        String MY_QUERY = "SELECT pu.* FROM " + TABLE_PROFILE_IN_CLASSES + " pc INNER JOIN " + TABLE_PROFILE_USERS + " pu ON pc.idProfile=pu.id WHERE pc.idClasses=?";


        Cursor cursor = null;
        try {
            cursor = db.rawQuery(MY_QUERY, new String[]{String.valueOf(idClass)});
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                UserPrfile userPrfile1;
                userPrfile1 = new UserPrfile();
                userPrfile1.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(PROFILE_USERS_COLUMN_ID))));
                userPrfile1.setType(cursor.getString(1));
                userPrfile1.setName(cursor.getString(2));
                byte[] img1Byte = cursor.getBlob(3);
                if (img1Byte != null && img1Byte.length > 0) {
                    Bitmap image1 = BitmapFactory.decodeByteArray(img1Byte, 0, img1Byte.length);
                    if (image1 != null) {
                        userPrfile1.setId_ImageProfile(image1);
                    }
                }

                usersProfileArray.add(userPrfile1);
                cursor.moveToNext();
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return usersProfileArray;
    }

    public ArrayList<ObjMyClasses> allClassInProfile(int idProfile1) {
        ArrayList<ObjMyClasses> usersClassArray = new ArrayList<ObjMyClasses>();

        String MY_QUERY = "SELECT c.* FROM " + TABLE_CLASSES + " c JOIN " + TABLE_PROFILE_IN_CLASSES + " pc on " +
                "c.id = pc.idClasses where pc.idProfile = ?";


        Cursor cursor = null;


        try {

            cursor = db.rawQuery(MY_QUERY, new String[]{String.valueOf(idProfile1)});
            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {
                ObjMyClasses objMyClasses = new ObjMyClasses();
                objMyClasses.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(CLASSES_COLUMN_ID))));
                objMyClasses.setName(cursor.getString(1));
                usersClassArray.add(objMyClasses);
                cursor.moveToNext();
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return usersClassArray;
    }


    public void createNewClasses(String name, int idTeacher) {
        ObjMyClasses objMyClasses = new ObjMyClasses();
        objMyClasses.setName(name);
        int idclass = addClasses(objMyClasses);
        addProfileInClasses(idTeacher, idclass);
        // updateProfileInClasses(idclass, idTeacher);

    }

    public ArrayList<ObjResource> allResourceInClass(int idClass) {
        ArrayList<ObjResource> ResourceInClassArray = new ArrayList<>();

        Cursor cursor = null;

        cursor = db
                .query(TABLE_RESOURCE,
                        TABLE_RESOURCE_COLUM, RESOURCE_COLUMN_CLASSES_ID + " = ?",
                        new String[]{String.valueOf(idClass)}, null, null,
                        null, null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                ObjResource objResource = new ObjResource();
                objResource.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(RESOURCE_COLUMN_RESOURCE_ID))));
                objResource.setClassesId(Integer.parseInt(cursor.getString(1)));
                objResource.setName(cursor.getString(2));
                byte[] img1Byte = cursor.getBlob(3);
                if (img1Byte != null && img1Byte.length > 0) {
                    Bitmap image1 = BitmapFactory.decodeByteArray(img1Byte, 0, img1Byte.length);
                    if (image1 != null) {
                        objResource.setImage(image1);
                    }
                }
                objResource.setLink(cursor.getString(4));

                ResourceInClassArray.add(objResource);
                cursor.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return ResourceInClassArray;
    }


    public ArrayList<ObjMeesage> displayMeesageFromAndTo(int profileFrom, int profileTo) {
        ArrayList<ObjMeesage> messageBettwen2Pepole = new ArrayList<>();
        Cursor cursor = null;

        String MY_QUERY = "SELECT m.* FROM " + TABLE_MESSAGE + " m WHERE (m.idProfileFrom=" + profileFrom + " and m.idProfileTo=" + profileTo + ") or" +
                "(m.idProfileFrom=" + profileTo + " and m.idProfileTo=" + profileFrom + ") ";

        try {
            //String[] args = {String.valueOf(profileFrom), String.valueOf(profileTo)};
            cursor = db.rawQuery(MY_QUERY, null);
            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {
                ObjMeesage objMeesage;
                objMeesage = new ObjMeesage();
                objMeesage.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(MESSAGE_COLUMN_ID_MASSAGE))));
                objMeesage.setIdProfileFrom(cursor.getInt(1));
                objMeesage.setIdProfileTo(cursor.getInt(2));
                objMeesage.setTextMessage(cursor.getString(3));
                //objMeesage.setDate(java.sql.Date.valueOf(cursor.getString(4)));

                messageBettwen2Pepole.add(objMeesage);
                cursor.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return messageBettwen2Pepole;
    }


    public ArrayList<ObjPost> displayPostByClass(int idClass) {
        ArrayList<ObjPost> postArray = new ArrayList<>();
        Cursor cursor = null;
        String MY_QUERY = "SELECT tb.* FROM " + TABLE_POST + " tb WHERE tb.classesId=?";
        try {

            cursor = db.rawQuery(MY_QUERY, new String[]{String.valueOf(idClass)});
            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {
                ObjPost objPost;
                objPost = new ObjPost();
                objPost.setProfileId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(POST_COLUMN_ID_PROFILE))));
                objPost.setTextPost(cursor.getString(1));
                objPost.setClassesId(cursor.getInt(2));
                objPost.setId(cursor.getInt(3));
                postArray.add(objPost);
                cursor.moveToNext();


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return postArray;
    }

    public void open() {
        try {
            db = getWritableDatabase();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public void close() {
        try {
            db.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public UserPrfile readuser(int id) {
        UserPrfile user = null;
        Cursor cursor = null;
        try {
            /// get reference of the itemDB database

            // get  query
            cursor = db
                    .query(TABLE_PROFILE_USERS,
                            TABLE_PROFILE_USERS_COLUM, PROFILE_USERS_COLUMN_ID + " = ?",
                            new String[]{String.valueOf(id)}, null, null,
                            null, null);


            // if results !=null, parse the first one
            if (cursor != null && cursor.getCount() > 0) {

                cursor.moveToFirst();

                user = new UserPrfile();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(PROFILE_USERS_COLUMN_ID))));
                user.setType(cursor.getString(1));
                user.setName(cursor.getString(2));

                //images
                byte[] img1Byte = cursor.getBlob(3);
                if (img1Byte != null && img1Byte.length > 0) {
                    Bitmap image1 = BitmapFactory.decodeByteArray(img1Byte, 0, img1Byte.length);
                    if (image1 != null) {
                        user.setId_ImageProfile(image1);
                    }
                }


            }
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return user;
    }

    public ObjMyClasses getClass(int code) {
        ObjMyClasses class1 = null;
        Cursor cursor = null;
        try {
            /// get reference of the itemDB database

            // get  query
            cursor = db
                    .query(TABLE_CLASSES,
                            TABLE_CLASSES_COLUM, CLASSES_COLUMN_ID + " = ?",
                            new String[]{String.valueOf(code)}, null, null,
                            null, null);


            // if results !=null, parse the first one
            if (cursor != null && cursor.getCount() > 0) {

                cursor.moveToFirst();
                class1 = new ObjMyClasses();
                class1.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(PROFILE_USERS_COLUMN_ID))));
                class1.setName(cursor.getString(1));
            }
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return class1;
    }


    public void deletePost(int Idpost) {

        try {

            // delete item
            db.delete(TABLE_POST, POST_COLUMN_ID + " = ?",
                    new String[]{String.valueOf(Idpost)});
        } catch (Throwable t) {
            t.printStackTrace();
        }

    }

    public void deleteClass(ObjMyClasses objMyClasses) {

        try {

            // delete item
            db.delete(TABLE_CLASSES, CLASSES_COLUMN_ID + " = ?",
                    new String[]{String.valueOf(objMyClasses.getId())});
        } catch (Throwable t) {
            t.printStackTrace();
        }

    }

    public void deleteProfileInClasses(int userPrfileid, int objMyClassesid) {
        try {

            // delete item
            db.delete(TABLE_PROFILE_IN_CLASSES, "idProfile=? and idClasses=?", new String[]{String.valueOf(userPrfileid), String.valueOf(objMyClassesid)});
        } catch (Throwable t) {
            t.printStackTrace();
        }

    }

    public void deleteTecherProfileInClasses(int objMyClassesid) {
        try {
            // delete item
            db.delete(TABLE_PROFILE_IN_CLASSES, "idClasses=?", new String[]{String.valueOf(objMyClassesid)});

        } catch (Throwable t) {
            t.printStackTrace();
        }

    }

    public void deleteMessage(ObjMeesage objMeesage) {

        try {

            // delete item
            db.delete(TABLE_MESSAGE, MESSAGE_COLUMN_ID_MASSAGE + " = ?",
                    new String[]{String.valueOf(objMeesage.getId())});
        } catch (Throwable t) {
            t.printStackTrace();
        }

    }

    public void updatePost(ObjPost post) {

        try {

            // make values to be inserted
            ContentValues values = new ContentValues();
            values.put(POST_COLUMN_ID_PROFILE, post.getProfileId());
            values.put(POST_COLUMN_TEXT, post.getTextPost());
            values.put(POST_COLUMN_CLASSES_ID, post.getClassesId());
            values.put(POST_COLUMN_ID, post.getId());
            // update
            db.update(TABLE_POST, values, POST_COLUMN_ID + " = ?",
                    new String[]{String.valueOf(post.getId())});
        } catch (Throwable t) {
            t.printStackTrace();
        }

    }

    public ObjPost redPostById(int idPost) {
        ObjPost objPost = null;
        Cursor cursor = null;
        try {
            cursor = db
                    .query(TABLE_POST,
                            TABLE_POST_COLUM, POST_COLUMN_ID + " = ?",
                            new String[]{String.valueOf(idPost)}, null, null,
                            null, null);


            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                objPost = new ObjPost();
                objPost.setProfileId(cursor.getInt(cursor.getColumnIndex(POST_COLUMN_ID_PROFILE)));
                objPost.setTextPost(cursor.getString(1));
                objPost.setClassesId(cursor.getInt(2));
                objPost.setId(cursor.getInt(3));
            }

        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();

            }

        }
        return objPost;
    }


    public boolean haveMessage(int profileId) {
        Cursor cursor = null;
        try {
            //cursor = db.query(TABLE_MESSAGE,
                   // TABLE_MESSAGE_COLUM, MESSAGE_COLUMN_ID_PROFILE + " = ? or " + MESSAGE_COLUMN_ID_PROFILE2


            String MY_QUERY = "SELECT tb.* FROM " + TABLE_MESSAGE + " tb WHERE tb.idProfileFrom=? or tb.idProfileTo =?";


                cursor = db.rawQuery(MY_QUERY, new String[]{String.valueOf(profileId)});           //  + " = ? ", new String[]{String.valueOf(profileId), String.valueOf(profileId)}, null, null, null);


            if (cursor != null && cursor.getCount() > 0) {
                return true;
            }

        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();

            }
        }return false;
    }






}