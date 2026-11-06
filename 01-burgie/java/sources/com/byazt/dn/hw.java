package com.byazt.dn;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.byazt.wf.vk;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1987, 13})
public class hw extends pr<com.byazt.yf.pr> {
    public hw() {
        super("duplicatelog");
    }

    public boolean pr(SQLiteDatabase sQLiteDatabase, String str) {
        int count;
        if (sQLiteDatabase == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Cursor cursorQuery = sQLiteDatabase.query(this.hw, null, "path=?", new String[]{str}, null, null, null);
            count = cursorQuery.getCount();
            try {
                cursorQuery.close();
            } catch (Exception e) {
                e = e;
                vk.hw(e);
            }
        } catch (Exception e2) {
            e = e2;
            count = 0;
        }
        if (count <= 0) {
            return false;
        }
        return true;
    }

    @Override // com.byazt.dn.pr
    public void insert(SQLiteDatabase sQLiteDatabase, com.byazt.yf.pr prVar) {
        if (prVar == null || pr(sQLiteDatabase, prVar.pr)) {
            return;
        }
        super.insert(sQLiteDatabase, prVar);
        try {
            sQLiteDatabase.execSQL("delete from " + this.hw + " where _id in (select _id from " + this.hw + " order by insert_time desc limit 1000 offset 500)");
        } catch (Exception e) {
            vk.hw(e);
        }
    }

    @Override // com.byazt.dn.pr
    public HashMap<String, String> pr() {
        HashMap<String, String> map = new HashMap<>();
        map.put("path", "TEXT");
        map.put("insert_time", "INTEGER");
        map.put("ext1", "TEXT");
        map.put("ext2", "TEXT");
        return map;
    }

    @Override // com.byazt.dn.pr
    public ContentValues pr(com.byazt.yf.pr prVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("path", prVar.pr);
        contentValues.put("insert_time", Long.valueOf(prVar.hw));
        return contentValues;
    }
}
