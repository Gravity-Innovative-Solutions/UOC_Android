package in.gravitykerala.universityofcalicut.dbHelpers;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DbQuestionPaperHelper extends SQLiteOpenHelper {
    // The Android's default system path of your application database.
    private static String DB_PATH = null; //"/data/data/com.gravity.easysyllabi/databases/"; // Just
    // a
    // placeholder
    // will
    // be
    // updated
    // automatically
    // based
    // on
    // packagename

    private static String DB_NAME = "question_paper.db";

    public static final String TABLE_QP_2011 = "qp_2011";
    public static final String TABLE_QP_2014 = "qp_2014";
    public static final String TABLE_SM_2011 = "sm_2011";
    public static final String TABLE_SM_2014 = "sm_2014";


    // Labels table name
    private String TABLE_CURRENT; // = "qp_2011";
//	private static final String TABLE_USER_PREFERENCE = "userpreference";

    // Labels Table Columns names
    private final String KEY_ID = "_id";
    private final String KEY_COURSE = "course";
    private final String KEY_SUBJECT = "subject";
    private final String KEY_URL = "url";

//	private static final String KEY_PREF_COURSE = "prefcourse";
//	private static final String KEY_PREF_YEAR = "prefyear";
//	private static final String KEY_PREF_STREAM = "prefstream";

    private SQLiteDatabase myDataBase;

    private final Context myContext;

    /**
     * Constructor Takes and keeps a reference of the passed context in order to
     * access to the application assets and resources.
     *
     * @param context
     */
    public DbQuestionPaperHelper(Context context) {
        super(context, DB_NAME, null, 1);

        this.myContext = context;
        String appDataPath = context.getApplicationInfo().dataDir;
        DB_PATH = appDataPath + "/databases/";
        Log.d("CURRENT_DB_DIR", DB_PATH);

        createDataBase();
    }

    /**
     * Table to access question paper must be set before accssing any table info
     *
     * @param table
     */
    public void setTable(String table) {
        TABLE_CURRENT = table;
    }

    /**
     * Creates a empty database on the system and rewrites it with your own
     * database.
     */
    public void createDataBase() {

        boolean dbExist = checkDataBase();

        if (dbExist) {
            // do nothing - database already exist
        } else {

            // By calling this method and empty database will be created into
            // the default system path
            // of your application so we are gonna be able to overwrite that
            // database with our database.
            this.getReadableDatabase();

            copyDataBase();
        }

    }

    /**
     * Check if the database already exist to avoid re-copying the file each
     * time you open the application.
     *
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase() {

        SQLiteDatabase checkDB = null;

        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        } catch (SQLiteException e) {

            // database does't exist yet.

        }

        if (checkDB != null) {

            checkDB.close();

        }

        return checkDB != null ? true : false;
    }

    /**
     * Copies your database from your local assets-folder to the just created
     * empty database in the system folder, from where it can be accessed and
     * handled. This is done by transfering bytestream.
     */
    private void copyDataBase() {
        try {
            // Open your local db as the input stream
            InputStream myInput;
            myInput = myContext.getAssets().open(DB_NAME);

            // Path to the just created empty db
            String outFileName = DB_PATH + DB_NAME;

            // Open the empty db as the output stream
            OutputStream myOutput = new FileOutputStream(outFileName);

            // transfer bytes from the inputfile to the outputfile
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            // Close the streams
            myOutput.flush();
            myOutput.close();
            myInput.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void openDataBase() throws SQLException {

        // Open the database
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {

        if (myDataBase != null)
            myDataBase.close();

        super.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // Add your public helper methods to access and get content from the
    // database.
    // You could return cursors by doing "return myDataBase.query(....)" so it'd
    // be easy
    // to you to create adapters for your views.


    public List<String> getCourses() {
        List<String> resultArrayList = new ArrayList<String>();
        resultArrayList.add("Select Your Course");

        // Select All Query
        String selectQuery = "SELECT DISTINCT " + KEY_COURSE + " FROM " + TABLE_CURRENT + " ORDER BY " + KEY_COURSE;
        Log.d("getCourses_Query", selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                resultArrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return resultArrayList;
    }

    public List<String> getSubjects(String course) {
        List<String> resultArrayList = new ArrayList<String>();
        resultArrayList.add("Select Your course");
        // Select All Query
        String selectQuery = "SELECT DISTINCT " + KEY_SUBJECT + " FROM " + TABLE_CURRENT + " WHERE " + KEY_COURSE + " = '"
                + course + "' ORDER BY " + KEY_SUBJECT;
        Log.d("getSubjects_Query", selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                resultArrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return resultArrayList;
    }


    public String getURL(String course, String subject) {

        String resultFileName = null;
        // Select All Query
        String selectQuery = "SELECT " + KEY_URL + " FROM " + TABLE_CURRENT + " WHERE " + KEY_COURSE + " = '"
                + course + "' AND " + KEY_SUBJECT + " = '" + subject + "';";
        Log.d("GetFileName_Query", selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        cursor.moveToFirst();
        resultFileName = cursor.getString(0);

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return resultFileName;
    }

}
