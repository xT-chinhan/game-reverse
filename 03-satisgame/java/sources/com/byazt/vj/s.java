package com.byazt.vj;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.byazt.ug.d;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1034, 8})
public class s {
    public static volatile s qg;
    public SQLiteDatabase n;

    public static s n() {
        if (qg == null) {
            synchronized (s.class) {
                if (qg == null) {
                    qg = new s();
                }
            }
        }
        return qg;
    }

    private s() {
        try {
            this.n = new qg(d.getContext()).getWritableDatabase();
        } catch (Throwable th) {
            com.byazt.ch.s.n().n(th, "ClickEventHelper");
        }
    }

    public boolean qg() {
        return com.byazt.f.n.s().n("click_event_switch", 0) == 1;
    }

    public boolean s() {
        return com.byazt.f.n.s().n("click_event_switch", 0) == 2;
    }

    public void n(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.n;
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
            this.n.insert("click_event", null, contentValues);
        } catch (Exception unused) {
        }
        s(j, str);
    }

    public boolean qg(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.n;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen() && j > 0 && !TextUtils.isEmpty(str)) {
            Cursor cursorQuery = null;
            try {
                String strOptString = new JSONObject(str).optString("req_id");
                if (TextUtils.isEmpty(strOptString)) {
                    return false;
                }
                cursorQuery = this.n.query("click_event", qg.n, "time > ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), strOptString}, null, null, null, null);
                boolean z = cursorQuery.getCount() > 0;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return z;
            } catch (Exception unused) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        }
        return false;
    }

    private void s(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.n;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strOptString = new JSONObject(str).optString("req_id");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            this.n.delete("click_event", "time < ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), strOptString});
        } catch (Exception unused) {
        }
    }
}
