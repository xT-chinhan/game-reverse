package com.smartdigimkt.g0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.smartdigimkt.h0.c;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static a b;
    public final Context a;

    public a(Context context) {
        this.a = context;
    }

    public final synchronized void a(c cVar) {
        synchronized (this) {
            if (cVar == null) {
                return;
            }
            try {
                if (b.a(this.a).getWritableDatabase() == null) {
                    return;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("offer_id", cVar.a);
                contentValues.put("show_num", Integer.valueOf(cVar.d));
                contentValues.put("show_time", Long.valueOf(cVar.e));
                contentValues.put("record_date", cVar.f);
                contentValues.put("offer_cap", Integer.valueOf(cVar.b));
                contentValues.put("offer_pacing", Long.valueOf(cVar.c));
                if (!a(cVar.a)) {
                    b.a(this.a).getWritableDatabase().insert("my_offer_cap_pacing", null, contentValues);
                } else {
                    b.a(this.a).getWritableDatabase().update("my_offer_cap_pacing", contentValues, "offer_id = '" + cVar.a + "'", null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final synchronized boolean a(String str) {
        Cursor cursorQuery = b.a(this.a).getReadableDatabase().query("my_offer_cap_pacing", new String[]{"offer_id"}, "offer_id = ?", new String[]{str}, null, null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.close();
            return true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return false;
    }
}
