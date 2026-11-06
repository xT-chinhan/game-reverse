package com.byazt.hs;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.byazt.tk.k;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 983, 8})
public abstract class s extends SQLiteOpenHelper {
    public final Context n;
    public final String qg;

    public void n(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public void n(SQLiteDatabase sQLiteDatabase, Context context) {
    }

    public s(Context context, String str, int i) {
        super(new com.byazt.qyu.n(context), str, (SQLiteDatabase.CursorFactory) null, i);
        this.qg = "CSJSQLiteOpenHelper";
        this.n = context;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            n(sQLiteDatabase, this.n);
        } catch (Throwable th) {
            k.qg("CSJSQLiteOpenHelper", th.getMessage());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i > i2) {
            try {
                n(sQLiteDatabase);
            } catch (Throwable th) {
                k.qg("CSJSQLiteOpenHelper", th.getMessage());
                return;
            }
        }
        n(sQLiteDatabase, this.n);
        n(sQLiteDatabase, i, i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i > i2) {
            n(sQLiteDatabase);
            n(sQLiteDatabase, this.n);
        }
    }

    public void n(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayListQg = qg(sQLiteDatabase);
        if (arrayListQg == null || arrayListQg.size() <= 0) {
            return;
        }
        Iterator<String> it = arrayListQg.iterator();
        while (it.hasNext()) {
            sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
        }
    }

    private ArrayList<String> qg(SQLiteDatabase sQLiteDatabase) {
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
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
