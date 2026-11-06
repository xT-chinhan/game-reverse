package com.bytedance.sdk.component.x.xr.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c implements ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.component.x.ms.ka f1550ms;
    private Context xr;

    public static String ah() {
        return "ALTER TABLE trackurl ADD COLUMN extra TEXT";
    }

    public static String d() {
        return "ALTER TABLE trackurl ADD COLUMN encrypt INTEGER default 0";
    }

    public static String xr() {
        return "CREATE TABLE IF NOT EXISTS trackurl (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,url TEXT ,replaceholder INTEGER default 0,retry INTEGER default 0,extra TEXT ,encrypt INTEGER default 0)";
    }

    public c(com.bytedance.sdk.component.x.ms.ka kaVar) {
        this.xr = kaVar.getContext();
        this.f1550ms = kaVar;
    }

    @Override // com.bytedance.sdk.component.x.xr.c.ka
    public List<d> ms() {
        JSONObject jSONObject;
        LinkedList linkedList = new LinkedList();
        Cursor cursorQuery = com.bytedance.sdk.component.x.xr.ms.ms.xr.query(this.xr, "trackurl", null, null, null, null, null, null, this.f1550ms);
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                try {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                    boolean z = cursorQuery.getInt(cursorQuery.getColumnIndex("replaceholder")) > 0;
                    int i = cursorQuery.getInt(cursorQuery.getColumnIndex("retry"));
                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("extra"));
                    int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("encrypt"));
                    if (i2 > 0) {
                        string3 = com.bytedance.sdk.component.utils.ms.ah(string3);
                    }
                    try {
                        jSONObject = new JSONObject(string3);
                    } catch (Exception unused) {
                        jSONObject = null;
                    }
                    linkedList.add(new d(string, string2, z, i, jSONObject, i2));
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
            if (cursorQuery != null) {
            }
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.component.x.xr.c.ka
    public void insert(d dVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", dVar.xr());
        contentValues.put("url", dVar.ah());
        contentValues.put("replaceholder", Integer.valueOf(dVar.d() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(dVar.ka()));
        contentValues.put("extra", com.bytedance.sdk.component.utils.ms.xr(dVar.ms().toString()));
        contentValues.put("encrypt", (Integer) 1);
        com.bytedance.sdk.component.x.xr.ms.ms.xr.insert(this.xr, "trackurl", contentValues, this.f1550ms);
    }

    @Override // com.bytedance.sdk.component.x.xr.c.ka
    public void update(d dVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", dVar.xr());
        contentValues.put("url", dVar.ah());
        contentValues.put("replaceholder", Integer.valueOf(dVar.d() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(dVar.ka()));
        contentValues.put("extra", com.bytedance.sdk.component.utils.ms.xr(dVar.ms().toString()));
        contentValues.put("encrypt", (Integer) 1);
        com.bytedance.sdk.component.x.xr.ms.ms.xr.update(this.xr, "trackurl", contentValues, "id=?", new String[]{dVar.xr()}, this.f1550ms);
    }

    @Override // com.bytedance.sdk.component.x.xr.c.ka
    public void delete(d dVar) {
        com.bytedance.sdk.component.x.xr.ms.ms.xr.delete(this.xr, "trackurl", "id=?", new String[]{dVar.xr()}, this.f1550ms);
    }
}
