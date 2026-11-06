package com.byazt.wfe;

import android.content.ContentValues;
import android.database.Cursor;
import com.anythink.core.e.i;
import com.byazt.ag.qg;
import com.byazt.gct.ou;
import com.byazt.nf.rv;
import com.byazt.qit.x;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1042, 19})
public class n {
    public static JSONObject n() {
        int i;
        int i2;
        if (ou.n() <= 0 || ou.qg() <= 0) {
            return new JSONObject();
        }
        int iN = ou.n();
        int i3 = 0;
        Cursor cursorQuery = com.byazt.xp.n.query(rv.getContext(), "dpl_status_record", null, "create_time >= ?", new String[]{String.valueOf(System.currentTimeMillis() - (((long) iN) * 60000))}, null, null, null);
        if (cursorQuery == null || !cursorQuery.moveToFirst()) {
            i = 0;
            i2 = 0;
        } else {
            i = 0;
            i2 = 0;
            do {
                int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
                if (i4 == 1) {
                    i3++;
                } else if (i4 == 2) {
                    i++;
                } else if (i4 == 3) {
                    i2++;
                }
            } while (cursorQuery.moveToNext());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("minute", iN);
            jSONObject.put("trigger_count", i3);
            jSONObject.put("dialog_count", i);
            jSONObject.put("reject_count", i2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static void n(final int i) {
        if (ou.n() <= 0 || ou.qg() <= 0) {
            return;
        }
        qg.n(new x("recordStatus") { // from class: com.byazt.wfe.n.1
            @Override // java.lang.Runnable
            public void run() {
                ContentValues contentValues = new ContentValues();
                contentValues.put("create_time", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("status", Integer.valueOf(i));
                com.byazt.xp.n.insert(rv.getContext(), "dpl_status_record", contentValues);
            }
        });
    }

    public static void qg() {
        try {
            com.byazt.xp.n.delete(rv.getContext(), "dpl_status_record", "create_time < ?", new String[]{String.valueOf(System.currentTimeMillis() - i.f)});
        } catch (Throwable unused) {
        }
    }

    public static void n(JSONObject jSONObject) {
        if (ou.n() <= 0 || ou.qg() <= 0) {
            return;
        }
        try {
            jSONObject.put("dpl_status_counter", n());
        } catch (JSONException unused) {
        }
    }
}
