package com.bytedance.sdk.component.x.xr.ms.ms.ms;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.sdk.component.x.ms.c;
import com.bytedance.sdk.component.x.xr.ms.ms.xr.ab;
import com.bytedance.sdk.component.x.xr.ms.ms.xr.d;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final Context f1566ms;
    private c xr;

    public ms(Context context, c cVar) {
        super(new com.bytedance.sdk.openadsdk.api.plugin.ms(context), "ttadlog.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.f1566ms = context;
        this.xr = cVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            ms(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    private void ms(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.x.xr.ms.ms.xr.c.d(this.xr.xr()));
        sQLiteDatabase.execSQL(d.xr(this.xr.ms()));
        sQLiteDatabase.execSQL(ab.d(this.xr.d()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.x.xr.ms.ms.xr.ms.xr(this.xr.ka()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.x.xr.c.c.xr());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            if (i > i2) {
                xr(sQLiteDatabase);
                ms(sQLiteDatabase);
            } else {
                ms(sQLiteDatabase);
            }
        } catch (Throwable unused) {
        }
    }

    private void xr(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayListAh = ah(sQLiteDatabase);
        if (arrayListAh == null || arrayListAh.size() <= 0) {
            return;
        }
        Iterator<String> it = arrayListAh.iterator();
        while (it.hasNext()) {
            sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
        }
    }

    private ArrayList<String> ah(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
            if (cursorRawQuery != null) {
                while (cursorRawQuery.moveToNext()) {
                    String string = cursorRawQuery.getString(0);
                    if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
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
