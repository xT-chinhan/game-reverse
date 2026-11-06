package com.bytedance.ms.xr.xr.xr;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.ms.xr.x.ch;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends ms<com.bytedance.ms.xr.xr.ms.ms> {
    public xr() {
        super("duplicatelog");
    }

    public boolean ms(SQLiteDatabase sQLiteDatabase, String str) {
        int count;
        if (sQLiteDatabase != null && !TextUtils.isEmpty(str)) {
            try {
                Cursor cursorQuery = sQLiteDatabase.query(this.xr, null, "path=?", new String[]{str}, null, null, null);
                count = cursorQuery.getCount();
                try {
                    cursorQuery.close();
                } catch (Exception e) {
                    e = e;
                    ch.xr(e);
                }
            } catch (Exception e2) {
                e = e2;
                count = 0;
            }
            if (count > 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.ms.xr.xr.xr.ms
    public void insert(SQLiteDatabase sQLiteDatabase, com.bytedance.ms.xr.xr.ms.ms msVar) {
        if (msVar == null || ms(sQLiteDatabase, msVar.f600ms)) {
            return;
        }
        super.insert(sQLiteDatabase, msVar);
        try {
            sQLiteDatabase.execSQL("delete from " + this.xr + " where _id in (select _id from " + this.xr + " order by insert_time desc limit 1000 offset 500)");
        } catch (Exception e) {
            ch.xr(e);
        }
    }

    @Override // com.bytedance.ms.xr.xr.xr.ms
    protected HashMap<String, String> ms() {
        HashMap<String, String> map = new HashMap<>();
        map.put("path", "TEXT");
        map.put("insert_time", "INTEGER");
        map.put("ext1", "TEXT");
        map.put("ext2", "TEXT");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.ms.xr.xr.xr.ms
    public ContentValues ms(com.bytedance.ms.xr.xr.ms.ms msVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("path", msVar.f600ms);
        contentValues.put("insert_time", Long.valueOf(msVar.xr));
        return contentValues;
    }
}
