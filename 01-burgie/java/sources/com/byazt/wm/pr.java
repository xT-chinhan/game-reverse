package com.byazt.wm;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v4.app.NotificationCompat;
import com.byazt.hg.ny;
import com.byazt.sd.a;
import com.byazt.xlm.fw;
import com.byazt.zp.zo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 832, 37})
public class pr {
    public static JSONObject pr() {
        int i;
        int i2;
        if (ny.pr() <= 0 || ny.hw() <= 0) {
            return new JSONObject();
        }
        int iPr = ny.pr();
        int i3 = 0;
        Cursor cursorQuery = com.byazt.ad.pr.query(a.getContext(), "dpl_status_record", null, "create_time >= ?", new String[]{String.valueOf(System.currentTimeMillis() - (((long) iPr) * 60000))}, null, null, null);
        if (cursorQuery != null && cursorQuery.moveToFirst()) {
            i = 0;
            i2 = 0;
            do {
                int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex(NotificationCompat.CATEGORY_STATUS));
                if (i4 == 1) {
                    i3++;
                } else if (i4 == 2) {
                    i++;
                } else if (i4 == 3) {
                    i2++;
                }
            } while (cursorQuery.moveToNext());
        } else {
            i = 0;
            i2 = 0;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("minute", iPr);
            jSONObject.put("trigger_count", i3);
            jSONObject.put("dialog_count", i);
            jSONObject.put("reject_count", i2);
            return jSONObject;
        } catch (Exception e) {
            return jSONObject;
        }
    }

    public static void pr(final int i) {
        if (ny.pr() <= 0 || ny.hw() <= 0) {
            return;
        }
        zo.pr(new fw("recordStatus") { // from class: com.byazt.wm.pr.1
            @Override // java.lang.Runnable
            public void run() {
                ContentValues contentValues = new ContentValues();
                contentValues.put("create_time", Long.valueOf(System.currentTimeMillis()));
                contentValues.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(i));
                com.byazt.ad.pr.insert(a.getContext(), "dpl_status_record", contentValues);
            }
        });
    }

    public static void hw() {
        try {
            com.byazt.ad.pr.delete(a.getContext(), "dpl_status_record", "create_time < ?", new String[]{String.valueOf(System.currentTimeMillis() - 604800000)});
        } catch (Throwable th) {
        }
    }

    public static void pr(JSONObject jSONObject) {
        if (ny.pr() <= 0 || ny.hw() <= 0) {
            return;
        }
        try {
            jSONObject.put("dpl_status_counter", pr());
        } catch (JSONException e) {
        }
    }
}
