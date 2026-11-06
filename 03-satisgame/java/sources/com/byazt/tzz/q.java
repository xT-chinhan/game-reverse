package com.byazt.tzz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.byazt.vf.k;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 444, 5})
public class q implements com.byazt.lcx.qg {
    public com.byazt.vr.qg n;
    public Context qg;

    public static String q() {
        return "ALTER TABLE trackurl ADD COLUMN encrypt INTEGER default 0";
    }

    public static String qg() {
        return "CREATE TABLE IF NOT EXISTS trackurl (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,url TEXT ,replaceholder INTEGER default 0,retry INTEGER default 0,extra TEXT ,encrypt INTEGER default 0)";
    }

    public static String s() {
        return "ALTER TABLE trackurl ADD COLUMN extra TEXT";
    }

    public q(Context context, com.byazt.vr.qg qgVar) {
        this.qg = context;
        this.n = qgVar;
    }

    @Override // com.byazt.lcx.qg
    public List<s> n() {
        JSONObject jSONObject;
        LinkedList linkedList = new LinkedList();
        Cursor cursorQuery = com.byazt.er.qg.query(this.qg, "trackurl", null, null, null, null, null, null, this.n);
        if (cursorQuery != null) {
            try {
                k kVar = (k) com.byazt.qp.q.n("encrypt_service");
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(ImagesContract.URL));
                    boolean z = cursorQuery.getInt(cursorQuery.getColumnIndex("replaceholder")) > 0;
                    int i = cursorQuery.getInt(cursorQuery.getColumnIndex("retry"));
                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("extra"));
                    int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("encrypt"));
                    if (i2 > 0) {
                        string3 = kVar.q(string3);
                    }
                    try {
                        jSONObject = new JSONObject(string3);
                    } catch (Exception unused) {
                        jSONObject = null;
                    }
                    linkedList.add(new s(string, string2, z, i, jSONObject, i2));
                }
                if (cursorQuery != null) {
                }
            } catch (Throwable unused2) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                        cursorQuery = null;
                    } finally {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                }
            }
        }
        return linkedList;
    }

    @Override // com.byazt.lcx.qg
    public void insert(s sVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", sVar.qg());
        contentValues.put(ImagesContract.URL, sVar.s());
        contentValues.put("replaceholder", Integer.valueOf(sVar.q() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(sVar.l()));
        contentValues.put("extra", ((k) com.byazt.qp.q.n("encrypt_service")).s(sVar.n().toString()));
        contentValues.put("encrypt", (Integer) 1);
        com.byazt.er.qg.insert(this.qg, "trackurl", contentValues, this.n);
    }

    @Override // com.byazt.lcx.qg
    public void update(s sVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", sVar.qg());
        contentValues.put(ImagesContract.URL, sVar.s());
        contentValues.put("replaceholder", Integer.valueOf(sVar.q() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(sVar.l()));
        contentValues.put("extra", ((k) com.byazt.qp.q.n("encrypt_service")).s(sVar.n().toString()));
        contentValues.put("encrypt", (Integer) 1);
        com.byazt.er.qg.update(this.qg, "trackurl", contentValues, "id=?", new String[]{sVar.qg()}, this.n);
    }

    @Override // com.byazt.lcx.qg
    public void delete(s sVar) {
        com.byazt.er.qg.delete(this.qg, "trackurl", "id=?", new String[]{sVar.qg()}, this.n);
    }
}
