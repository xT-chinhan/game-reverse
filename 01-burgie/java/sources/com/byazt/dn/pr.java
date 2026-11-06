package com.byazt.dn;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.byazt.wf.vk;
import com.umeng.analytics.pro.ar;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1987, 37})
public abstract class pr<T> {
    public final String hw;
    public final String pr = ar.d;

    public abstract ContentValues pr(T t);

    public abstract HashMap<String, String> pr();

    public pr(String str) {
        this.hw = str;
    }

    public void pr(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ").append(this.hw).append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            HashMap<String, String> mapPr = pr();
            if (mapPr != null) {
                for (String str : mapPr.keySet()) {
                    sb.append(str).append(" ").append(mapPr.get(str)).append(",");
                }
                sb.delete(sb.length() - 1, sb.length());
                sb.append(")");
                sQLiteDatabase.execSQL(sb.toString());
            }
        } catch (Exception e) {
        }
    }

    public void insert(SQLiteDatabase sQLiteDatabase, T t) {
        if (sQLiteDatabase != null && t != null) {
            try {
                sQLiteDatabase.insert(this.hw, null, pr(t));
            } catch (Exception e) {
                vk.hw(e);
            }
        }
    }
}
