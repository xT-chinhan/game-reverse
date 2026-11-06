package com.ss.android.downloadlib.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.ab;
import com.ss.android.downloadlib.addownload.hi;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ah {
    private static volatile ah xr;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private SQLiteDatabase f4493ms;

    public static ah ms() {
        if (xr == null) {
            synchronized (ah.class) {
                if (xr == null) {
                    xr = new ah();
                }
            }
        }
        return xr;
    }

    private ah() {
        try {
            this.f4493ms = new xr(hi.getContext()).getWritableDatabase();
        } catch (Throwable th) {
            com.ss.android.downloadlib.ka.ah.ms().ms(th, "ClickEventHelper");
        }
    }

    public boolean xr() {
        return com.ss.android.socialbase.downloader.ab.ms.ah().ms("click_event_switch", 0) == 1;
    }

    public boolean ah() {
        return com.ss.android.socialbase.downloader.ab.ms.ah().ms("click_event_switch", 0) == 2;
    }

    public void ms(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.f4493ms;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strOptString = new JSONObject(str).optString("req_id");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("ad_id", Long.valueOf(j));
            contentValues.put("req_id", strOptString);
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            this.f4493ms.insert("click_event", null, contentValues);
        } catch (Exception e) {
            ab.ms(e);
        }
        ah(j, str);
    }

    public boolean xr(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.f4493ms;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursorQuery = null;
        try {
            try {
                String strOptString = new JSONObject(str).optString("req_id");
                if (TextUtils.isEmpty(strOptString)) {
                    return false;
                }
                cursorQuery = this.f4493ms.query("click_event", xr.f4495ms, "time > ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), strOptString}, null, null, null, null);
                boolean z = cursorQuery.getCount() > 0;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return z;
            } catch (Exception e) {
                ab.ms(e);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    private void ah(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.f4493ms;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strOptString = new JSONObject(str).optString("req_id");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            this.f4493ms.delete("click_event", "time < ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), strOptString});
        } catch (Exception e) {
            ab.ms(e);
        }
    }
}
