package com.byazt.mf;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.byazt.eld.k;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1493, 20})
public class hn {
    public static volatile hn hw;
    public SQLiteDatabase pr;

    public static hn pr() {
        if (hw == null) {
            synchronized (hn.class) {
                if (hw == null) {
                    hw = new hn();
                }
            }
        }
        return hw;
    }

    private hn() {
        try {
            this.pr = new hw(k.getContext()).getWritableDatabase();
        } catch (Throwable th) {
            com.byazt.vi.hn.pr().pr(th, "ClickEventHelper");
        }
    }

    public boolean hw() {
        return com.byazt.ew.pr.hn().pr("click_event_switch", 0) == 1;
    }

    public boolean hn() {
        return com.byazt.ew.pr.hn().pr("click_event_switch", 0) == 2;
    }

    public void pr(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.pr;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strOptString = new JSONObject(str).optString("req_id");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(MediationConstant.EXTRA_ADID, Long.valueOf(j));
            contentValues.put("req_id", strOptString);
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            this.pr.insert("click_event", null, contentValues);
        } catch (Exception e) {
        }
        hn(j, str);
    }

    public boolean hw(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.pr;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursorQuery = null;
        try {
            String strOptString = new JSONObject(str).optString("req_id");
            if (TextUtils.isEmpty(strOptString)) {
                return false;
            }
            cursorQuery = this.pr.query("click_event", hw.pr, "time > ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), strOptString}, null, null, null, null);
            boolean z = cursorQuery.getCount() > 0;
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return z;
        } catch (Exception e) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return false;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    private void hn(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.pr;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strOptString = new JSONObject(str).optString("req_id");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            this.pr.delete("click_event", "time < ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), strOptString});
        } catch (Exception e) {
        }
    }
}
