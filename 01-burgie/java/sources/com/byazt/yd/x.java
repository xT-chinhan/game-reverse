package com.byazt.yd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.byazt.vkw.nt;
import com.byazt.zs.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIACODEC_DROP_NONREF, 121})
public class x implements com.byazt.aq.hw {
    public Context hw;
    public com.byazt.hh.hw pr;

    public x(Context context, com.byazt.hh.hw hwVar) {
        this.hw = context;
        this.pr = hwVar;
    }

    @Override // com.byazt.aq.hw
    public List<hn> pr() {
        JSONObject jSONObject;
        LinkedList linkedList = new LinkedList();
        Cursor cursorQuery = com.byazt.ya.hw.query(this.hw, "trackurl", null, null, null, null, null, null, this.pr);
        if (cursorQuery != null) {
            try {
                nt ntVar = (nt) uc.pr("encrypt_service");
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(BreakpointSQLiteKey.URL));
                    boolean z = cursorQuery.getInt(cursorQuery.getColumnIndex("replaceholder")) > 0;
                    int i = cursorQuery.getInt(cursorQuery.getColumnIndex("retry"));
                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("extra"));
                    int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("encrypt"));
                    if (i2 > 0) {
                        string3 = ntVar.x(string3);
                    }
                    try {
                        jSONObject = new JSONObject(string3);
                    } catch (Exception e) {
                        jSONObject = null;
                    }
                    linkedList.add(new hn(string, string2, z, i, jSONObject, i2));
                }
                if (cursorQuery != null) {
                }
            } catch (Throwable th) {
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

    @Override // com.byazt.aq.hw
    public void insert(hn hnVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", hnVar.hw());
        contentValues.put(BreakpointSQLiteKey.URL, hnVar.hn());
        contentValues.put("replaceholder", Integer.valueOf(hnVar.x() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(hnVar.c()));
        contentValues.put("extra", ((nt) uc.pr("encrypt_service")).hn(hnVar.pr().toString()));
        contentValues.put("encrypt", (Integer) 1);
        com.byazt.ya.hw.insert(this.hw, "trackurl", contentValues, this.pr);
    }

    @Override // com.byazt.aq.hw
    public void update(hn hnVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", hnVar.hw());
        contentValues.put(BreakpointSQLiteKey.URL, hnVar.hn());
        contentValues.put("replaceholder", Integer.valueOf(hnVar.x() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(hnVar.c()));
        contentValues.put("extra", ((nt) uc.pr("encrypt_service")).hn(hnVar.pr().toString()));
        contentValues.put("encrypt", (Integer) 1);
        com.byazt.ya.hw.update(this.hw, "trackurl", contentValues, "id=?", new String[]{hnVar.hw()}, this.pr);
    }

    @Override // com.byazt.aq.hw
    public void delete(hn hnVar) {
        com.byazt.ya.hw.delete(this.hw, "trackurl", "id=?", new String[]{hnVar.hw()}, this.pr);
    }

    public static String hw() {
        return new StringBuilder("CREATE TABLE IF NOT EXISTS trackurl (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,url TEXT ,replaceholder INTEGER default 0,retry INTEGER default 0,extra TEXT ,encrypt INTEGER default 0)").toString();
    }

    public static String hn() {
        return "ALTER TABLE trackurl ADD COLUMN extra TEXT";
    }

    public static String x() {
        return "ALTER TABLE trackurl ADD COLUMN encrypt INTEGER default 0";
    }
}
