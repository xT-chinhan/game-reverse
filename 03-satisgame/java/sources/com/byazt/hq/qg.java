package com.byazt.hq;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.byazt.yw.tj;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2463, 26})
public class qg extends n<com.byazt.da.n> {
    public qg() {
        super("duplicatelog");
    }

    public boolean n(SQLiteDatabase sQLiteDatabase, String str) {
        int count;
        if (sQLiteDatabase != null && !TextUtils.isEmpty(str)) {
            try {
                Cursor cursorQuery = sQLiteDatabase.query(this.qg, null, "path=?", new String[]{str}, null, null, null);
                count = cursorQuery.getCount();
                try {
                    cursorQuery.close();
                } catch (Exception e) {
                    e = e;
                    tj.qg(e);
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

    @Override // com.byazt.hq.n
    public void insert(SQLiteDatabase sQLiteDatabase, com.byazt.da.n nVar) {
        if (nVar == null || n(sQLiteDatabase, nVar.n)) {
            return;
        }
        super.insert(sQLiteDatabase, nVar);
        try {
            sQLiteDatabase.execSQL("delete from " + this.qg + " where _id in (select _id from " + this.qg + " order by insert_time desc limit 1000 offset 500)");
        } catch (Exception e) {
            tj.qg(e);
        }
    }

    @Override // com.byazt.hq.n
    public HashMap<String, String> n() {
        HashMap<String, String> map = new HashMap<>();
        map.put("path", "TEXT");
        map.put("insert_time", "INTEGER");
        map.put("ext1", "TEXT");
        map.put("ext2", "TEXT");
        return map;
    }

    @Override // com.byazt.hq.n
    public ContentValues n(com.byazt.da.n nVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("path", nVar.n);
        contentValues.put("insert_time", Long.valueOf(nVar.qg));
        return contentValues;
    }
}
