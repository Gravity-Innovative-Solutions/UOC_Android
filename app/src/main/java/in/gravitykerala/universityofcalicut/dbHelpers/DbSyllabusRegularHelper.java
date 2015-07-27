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

public class DbSyllabusRegularHelper extends SQLiteOpenHelper {

    // The Android's default system path of your application database.
    private static String DB_PATH = "/data/data/com.gravity.easysyllabi/databases/"; // Just
    // a
    // placeholder
    // will
    // be
    // updated
    // automatically
    // based
    // on
    // packagename

    private static String DB_NAME = "syllabus_regular.db";

    // Labels table name
    private static final String TABLE_SYLLABUS_DATA = "syllabus_data";
//	private static final String TABLE_USER_PREFERENCE = "userpreference";

    // Labels Table Columns names
    private static final String KEY_ID = "_id";
    private static final String KEY_DEPARTMENT = "department";
    private static final String KEY_COURSE = "course";
    private static final String KEY_BRANCH = "branch";
    private static final String KEY_SCHEME = "scheme";
    private static final String KEY_YEAR = "year";
    private static final String KEY_URL = "url";

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
    public DbSyllabusRegularHelper(Context context) {
        super(context, DB_NAME, null, 1);

        this.myContext = context;
        String appDataPath = context.getApplicationInfo().dataDir;
        DB_PATH = appDataPath + "/databases/";
        Log.d("CURRENT_DB_DIR", DB_PATH);

        createDataBase();
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


    public List<String> getDepartments() {
        List<String> resultArrayList = new ArrayList<String>();
        resultArrayList.add("Select Your Department");

        // Select All Query
        String selectQuery = "SELECT DISTINCT " + KEY_DEPARTMENT + " FROM " + TABLE_SYLLABUS_DATA + " ORDER BY " + KEY_DEPARTMENT;
        Log.d("getDepartments_Query", selectQuery);

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

    public List<String> getCourses(String department) {
        List<String> resultArrayList = new ArrayList<String>();
        resultArrayList.add("Select Your course");
        // Select All Query
        String selectQuery = "SELECT DISTINCT " + KEY_COURSE + " FROM " + TABLE_SYLLABUS_DATA + " WHERE " + KEY_DEPARTMENT + " = '"
                + department + "' ORDER BY " + KEY_COURSE;
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

    public List<String> getBranches(String department, String course) {
        List<String> resultArrayList = new ArrayList<String>();
        resultArrayList.add("Select your branch");
        // Select All Query
        String selectQuery = "SELECT DISTINCT " + KEY_BRANCH + " FROM " + TABLE_SYLLABUS_DATA + " WHERE " + KEY_DEPARTMENT + " = '"
                + department + "' AND " + KEY_COURSE + " = '" + course + "' ORDER BY " + KEY_BRANCH;
        Log.d("getBranches_Query", selectQuery);

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

    public List<String> getSchemes(String department, String course, String branch) {
        List<String> resultArrayList = new ArrayList<String>();
        resultArrayList.add("Select your branch");
        // Select All Query
        String selectQuery = "SELECT DISTINCT " + KEY_SCHEME + " FROM " + TABLE_SYLLABUS_DATA + " WHERE " + KEY_DEPARTMENT + " = '"
                + department + "' AND " + KEY_COURSE + " = '" + course + "' AND " + KEY_BRANCH + " = '" + branch + "' ORDER BY " + KEY_SCHEME;
        Log.d("getSchemes_Query", selectQuery);

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

    public List<String> getYears(String department, String course, String branch, String scheme) {
        List<String> resultArrayList = new ArrayList<String>();
        resultArrayList.add("Select your branch");
        // Select All Query
        String selectQuery = "SELECT DISTINCT " + KEY_YEAR + " FROM " + TABLE_SYLLABUS_DATA + " WHERE " + KEY_DEPARTMENT + " = '"
                + department + "' AND " + KEY_COURSE + " = '" + course + "' AND " + KEY_BRANCH + " = '" + branch + "' AND " + KEY_SCHEME + " = '" + scheme + "' ORDER BY " + KEY_YEAR;
        Log.d("getSchemes_Query", selectQuery);

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

    public String getURL(String department, String course, String branch, String scheme, String year) {

        String resultFileName = null;
        // Select All Query
        String selectQuery = "SELECT " + KEY_URL + " FROM " + TABLE_SYLLABUS_DATA + " WHERE " + KEY_DEPARTMENT + " = '"
                + department + "' AND " + KEY_COURSE + " = '" + course + "' AND " + KEY_BRANCH + " = '" + branch + "' AND " + KEY_SCHEME + " = '" + scheme + "' AND " + KEY_YEAR + " = '" + year + "';";
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

    ////////////////////////////----OLD----////////////////////////////////////////
//
//	public List<String> getCourses() {
//		List<String> resultArrayList = new ArrayList<String>();
//		resultArrayList.add("Select Your Course");
//
//		// Select All Query
//		String selectQuery = "SELECT DISTINCT " + KEY_COURSE + " FROM " + TABLE_SYLLABUS_DATA + " ORDER BY " + KEY_COURSE;
//		Log.d("GetCourses_Query", selectQuery);
//
//		SQLiteDatabase db = this.getReadableDatabase();
//		Cursor cursor = db.rawQuery(selectQuery, null);
//
//		// looping through all rows and adding to list
//		if (cursor.moveToFirst()) {
//			do {
//				resultArrayList.add(cursor.getString(0));
//			} while (cursor.moveToNext());
//		}
//
//		// closing connection
//		cursor.close();
//		db.close();
//
//		// returning lables
//		return resultArrayList;
//	}
//
//	public List<String> getYears(String course) {
//		List<String> resultArrayList = new ArrayList<String>();
//		resultArrayList.add("Select Your syllabus year");
//		// Select All Query
//		String selectQuery = "SELECT DISTINCT " + KEY_YEAR + " FROM " + TABLE_SYLLABUS_DATA + " WHERE " + KEY_COURSE + " = '"
//				+ course + "' ORDER BY " + KEY_YEAR;
//		Log.d("GetYears_Query", selectQuery);
//
//		SQLiteDatabase db = this.getReadableDatabase();
//		Cursor cursor = db.rawQuery(selectQuery, null);
//
//		// looping through all rows and adding to list
//		if (cursor.moveToFirst()) {
//			do {
//				resultArrayList.add(cursor.getString(0));
//			} while (cursor.moveToNext());
//		}
//
//		// closing connection
//		cursor.close();
//		db.close();
//
//		// returning lables
//		return resultArrayList;
//	}
//
//	public List<String> getStreams(String course, String year) {
//		List<String> resultArrayList = new ArrayList<String>();
//		resultArrayList.add("Select your stream");
//		// Select All Query
//		String selectQuery = "SELECT DISTINCT " + KEY_STREAM + " FROM " + TABLE_SYLLABUS_DATA + " WHERE " + KEY_COURSE + " = '"
//				+ course + "' AND " + KEY_YEAR + " = '" + year + "' ORDER BY " + KEY_STREAM;
//		Log.d("GetStreams_Query", selectQuery);
//
//		SQLiteDatabase db = this.getReadableDatabase();
//		Cursor cursor = db.rawQuery(selectQuery, null);
//
//		// looping through all rows and adding to list
//		if (cursor.moveToFirst()) {
//			do {
//				resultArrayList.add(cursor.getString(0));
//			} while (cursor.moveToNext());
//		}
//
//		// closing connection
//		cursor.close();
//		db.close();
//
//		// returning lables
//		return resultArrayList;
//	}
//
//	public List<String> getSemesters(String course, String year, String stream) {
//		List<String> resultArrayList = new ArrayList<String>();
//		resultArrayList.add("Select your semester");
//		// Select All Query
//		String selectQuery = "SELECT DISTINCT " + KEY_SEMESTER + " FROM " + TABLE_SYLLABUS_DATA + " WHERE " + KEY_COURSE + " = '"
//				+ course + "' AND " + KEY_YEAR + " = '" + year + "' AND " + KEY_STREAM + " = '" + stream + "' ORDER BY "
//				+ KEY_SEMESTER;
//		Log.d("GetSemesters_Query", selectQuery);
//
//		SQLiteDatabase db = this.getReadableDatabase();
//		Cursor cursor = db.rawQuery(selectQuery, null);
//
//		// looping through all rows and adding to list
//		if (cursor.moveToFirst()) {
//			do {
//				resultArrayList.add(cursor.getString(0));
//			} while (cursor.moveToNext());
//		}
//
//		// closing connection
//		cursor.close();
//		db.close();
//
//		// returning lables
//		return resultArrayList;
//	}
//
//	public List<String> getSubjects(String course, String year, String stream, String semester) {
//		List<String> resultArrayList = new ArrayList<String>();
//		resultArrayList.add("Select your subject");
//		// Select All Query
//		String selectQuery = "SELECT DISTINCT " + KEY_SUBJECT + " FROM " + TABLE_SYLLABUS_DATA + " WHERE " + KEY_COURSE + " = '"
//				+ course + "' AND " + KEY_YEAR + " = '" + year + "' AND " + KEY_STREAM + " = '" + stream + "' AND "
//				+ KEY_SEMESTER + " = '" + semester + "' ORDER BY " + KEY_SUBJECT;
//		Log.d("GetSubjects_Query", selectQuery);
//
//		SQLiteDatabase db = this.getReadableDatabase();
//		Cursor cursor = db.rawQuery(selectQuery, null);
//
//		// looping through all rows and adding to list
//		if (cursor.moveToFirst()) {
//			do {
//				resultArrayList.add(cursor.getString(0));
//			} while (cursor.moveToNext());
//		}
//
//		// closing connection
//		cursor.close();
//		db.close();
//
//		// returning lables
//		return resultArrayList;
//	}
//
//	public String getFileName(String course, String year, String stream, String semester, String subject) {
//
//		String resultFileName = null;
//		// Select All Query
//		String selectQuery = "SELECT " + KEY_URL + " FROM " + TABLE_SYLLABUS_DATA + " WHERE " + KEY_COURSE + " = '" + course
//				+ "' AND " + KEY_YEAR + " = '" + year + "' AND " + KEY_STREAM + " = '" + stream + "' AND " + KEY_SEMESTER
//				+ " = '" + semester + "' AND " + KEY_SUBJECT + " = '" + subject + "';";
//		Log.d("GetFileName_Query", selectQuery);
//
//		SQLiteDatabase db = this.getReadableDatabase();
//		Cursor cursor = db.rawQuery(selectQuery, null);
//
//		// looping through all rows and adding to list
//		cursor.moveToFirst();
//		resultFileName = cursor.getString(0);
//
//		// closing connection
//		cursor.close();
//		db.close();
//
//		// returning lables
//		return resultFileName;
//	}
//
//	public String getPrefCourse() {
//
//		String resultPrefCourse = null;
//		// Select All Query
//		String getPrefCourseQuery = "SELECT " + KEY_PREF_COURSE + " FROM " + TABLE_USER_PREFERENCE + " WHERE " + KEY_ID + " = 1;";
//		Log.d("GetPrefCourse_Query:", getPrefCourseQuery);
//
//		SQLiteDatabase db = this.getReadableDatabase();
//		Cursor cursor = db.rawQuery(getPrefCourseQuery, null);
//
//		// looping through all rows and adding to list
//		cursor.moveToFirst();
//		resultPrefCourse = cursor.getString(0);
//
//		// closing connection
//		cursor.close();
//		db.close();
//
//		// returning lables
//		return resultPrefCourse;
//	}
//
//	public String getPrefYear() {
//
//		String resultPrefYear = null;
//		// Select All Query
//		String getPrefYearQuery = "SELECT " + KEY_PREF_YEAR + " FROM " + TABLE_USER_PREFERENCE + " WHERE " + KEY_ID + " = 1;";
//		Log.d("GetPrefYear_Query:", getPrefYearQuery);
//
//		SQLiteDatabase db = this.getReadableDatabase();
//		Cursor cursor = db.rawQuery(getPrefYearQuery, null);
//
//		// looping through all rows and adding to list
//		cursor.moveToFirst();
//		resultPrefYear = cursor.getString(0);
//
//		// closing connection
//		cursor.close();
//		db.close();
//
//		// returning lables
//		return resultPrefYear;
//	}
//
//	public String getPrefStream() {
//
//		String resultPrefStream = null;
//		// Select All Query
//		String getPrefStreamQuery = "SELECT " + KEY_PREF_STREAM + " FROM " + TABLE_USER_PREFERENCE + " WHERE " + KEY_ID + " = 1;";
//		Log.d("GetPrefStream_Query:", getPrefStreamQuery);
//
//		SQLiteDatabase db = this.getReadableDatabase();
//		Cursor cursor = db.rawQuery(getPrefStreamQuery, null);
//
//		// looping through all rows and adding to list
//		cursor.moveToFirst();
//		resultPrefStream = cursor.getString(0);
//
//		// closing connection
//		cursor.close();
//		db.close();
//
//		// returning lables
//		return resultPrefStream;
//	}
//
//	public void setPreference(String selectedCourse, String selectedYear, String selectedStream) {
//
//		// Select All Query
//		String setPreferenceQuery = "UPDATE " + TABLE_USER_PREFERENCE + " SET " + KEY_PREF_COURSE + " = '" + selectedCourse + "', " + KEY_PREF_YEAR + " = '" + selectedYear + "', " + KEY_PREF_STREAM + " = '" + selectedStream + "' WHERE " + KEY_ID + " = 1;";
//		Log.d("SetPreference_Query:", setPreferenceQuery);
//
//		SQLiteDatabase db = this.getReadableDatabase();
//		db.execSQL(setPreferenceQuery);
//
//		// closing connection
//		db.close();
//
//	}
}
