package com.byazt.qb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.byazt.ca.ho;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2279, 20})
public abstract class hn extends SQLiteOpenHelper {
    public final String hw;
    public final Context pr;

    public hn(Context context, String str, int i) {
        super(new com.byazt.mg.pr(context), str, (SQLiteDatabase.CursorFactory) null, i);
        this.hw = "CSJSQLiteOpenHelper";
        this.pr = context;
    }

    public void pr(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public void pr(SQLiteDatabase sQLiteDatabase, Context context) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            pr(sQLiteDatabase, this.pr);
        } catch (Throwable th) {
            ho.hw("CSJSQLiteOpenHelper", th.getMessage());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i > i2) {
            try {
                pr(sQLiteDatabase);
            } catch (Throwable th) {
                ho.hw("CSJSQLiteOpenHelper", th.getMessage());
                return;
            }
        }
        pr(sQLiteDatabase, this.pr);
        pr(sQLiteDatabase, i, i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i > i2) {
            pr(sQLiteDatabase);
            pr(sQLiteDatabase, this.pr);
        }
    }

    public void pr(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayListHw = hw(sQLiteDatabase);
        if (arrayListHw != null && arrayListHw.size() > 0) {
            Iterator<String> it = arrayListHw.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
            }
        }
    }

    private ArrayList<String> hw(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
            if (cursorRawQuery != null) {
                while (cursorRawQuery.moveToNext()) {
                    String string = cursorRawQuery.getString(0);
                    if (!TextUtils.equals(string, "android_metadata") && !TextUtils.equals(string, "sqlite_sequence")) {
                        arrayList.add(string);
                    }
                }
                cursorRawQuery.close();
            }
        } catch (Exception e) {
        }
        return arrayList;
    }
}
