package kr.ac.gachon.Project201533745.Sqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DbOpenHelper extends SQLiteOpenHelper {
    public DbOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DbOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public DbOpenHelper(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table card (" +
                "number varchar(45)," +
                "month int," +
                "year int," +
                "cvv int," +
                "name varchar(45))";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void newCard(SQLiteDatabase db, String number, int month, int year, int cvv, String name) {
        String removeQuery="delete from card";

        String query="insert into card values(" +
                "'"+number+"', "+
                month+", "+
                year+", "+
                cvv+", "+
                "'"+name+"')";
        db.beginTransaction();

        try {
            db.execSQL(removeQuery);
            db.execSQL(query);
            db.setTransactionSuccessful();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }
}
