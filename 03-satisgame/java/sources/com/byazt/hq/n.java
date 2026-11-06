package com.byazt.hq;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.byazt.yw.tj;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2463, 19})
public abstract class n<T> {
    public final String n = "_id";
    public final String qg;

    public abstract ContentValues n(T t);

    public abstract HashMap<String, String> n();

    public n(String str) {
        this.qg = str;
    }

    public void n(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ").append(this.qg).append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            HashMap<String, String> mapN = n();
            if (mapN != null) {
                for (String str : mapN.keySet()) {
                    sb.append(str).append(" ").append(mapN.get(str)).append(",");
                }
                sb.delete(sb.length() - 1, sb.length());
                sb.append(")");
                sQLiteDatabase.execSQL(sb.toString());
            }
        } catch (Exception unused) {
        }
    }

    public void insert(SQLiteDatabase sQLiteDatabase, T t) {
        if (sQLiteDatabase == null || t == null) {
            return;
        }
        try {
            sQLiteDatabase.insert(this.qg, null, n(t));
        } catch (Exception e) {
            tj.qg(e);
        }
    }
}
