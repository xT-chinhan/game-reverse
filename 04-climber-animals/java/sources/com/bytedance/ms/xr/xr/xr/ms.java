package com.bytedance.ms.xr.xr.xr;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.ms.xr.x.ch;
import com.bytedance.sdk.component.utils.sl;
import com.umeng.analytics.pro.bz;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms<T> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected final String f601ms = bz.d;
    protected final String xr;

    protected abstract ContentValues ms(T t);

    protected abstract HashMap<String, String> ms();

    protected ms(String str) {
        this.xr = str;
    }

    public void ms(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ").append(this.xr).append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            HashMap<String, String> mapMs = ms();
            if (mapMs != null) {
                for (String str : mapMs.keySet()) {
                    sb.append(str).append(" ").append(mapMs.get(str)).append(",");
                }
                sb.delete(sb.length() - 1, sb.length());
                sb.append(")");
                sQLiteDatabase.execSQL(sb.toString());
            }
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    public void insert(SQLiteDatabase sQLiteDatabase, T t) {
        if (sQLiteDatabase == null || t == null) {
            return;
        }
        try {
            sQLiteDatabase.insert(this.xr, null, ms(t));
        } catch (Exception e) {
            ch.xr(e);
        }
    }
}
