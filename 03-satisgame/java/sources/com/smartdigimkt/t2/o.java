package com.smartdigimkt.t2;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.Calendar;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public static volatile o f;
    public final com.smartdigimkt.z2.a b;
    public final ConcurrentHashMap c;
    public long d;
    public final String a = o.class.getName();
    public final Object e = new Object();

    public o() {
        this.d = 0L;
        if (SDKContext.getInstance().d() != null) {
            com.smartdigimkt.z2.d dVarA = com.smartdigimkt.z2.d.a(SDKContext.getInstance().d());
            if (com.smartdigimkt.z2.a.b == null) {
                synchronized (com.smartdigimkt.z2.a.class) {
                    if (com.smartdigimkt.z2.a.b == null) {
                        com.smartdigimkt.z2.a.b = new com.smartdigimkt.z2.a(dVarA);
                    }
                }
            }
            this.b = com.smartdigimkt.z2.a.b;
            this.c = new ConcurrentHashMap();
            this.d = c();
            com.smartdigimkt.q3.f.a().c(new l(this));
        }
    }

    public static void a(o oVar, int i, String str, com.smartdigimkt.b3.c cVar) {
        oVar.getClass();
        if (TextUtils.isEmpty(str) || !(cVar instanceof com.smartdigimkt.b3.b)) {
            return;
        }
        String str2 = ((com.smartdigimkt.b3.b) cVar).c0;
        String str3 = cVar.a;
        com.smartdigimkt.z2.a aVar = oVar.b;
        synchronized (aVar) {
            if (aVar.b() != null) {
                try {
                    ContentValues contentValues = new ContentValues();
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    contentValues.put("placement_id", str);
                    contentValues.put("dsp_id", TextUtils.isEmpty(str2) ? "" : str2);
                    contentValues.put("offer_id", TextUtils.isEmpty(str3) ? "" : str3);
                    contentValues.put("tk_type", Integer.valueOf(i));
                    TextUtils.isEmpty("");
                    contentValues.put("extra_info", "");
                    contentValues.put("create_time", Long.valueOf(System.currentTimeMillis()));
                    TextUtils.isEmpty(str2);
                    TextUtils.isEmpty(str3);
                    aVar.b().insert("adx_offer_tracking", null, contentValues);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static o b() {
        if (f == null) {
            synchronized (o.class) {
                if (f == null) {
                    f = new o();
                }
            }
        }
        return f;
    }

    public static long c() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTimeInMillis();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public final void a() {
        SQLiteDatabase sQLiteDatabaseB;
        com.smartdigimkt.z2.a aVar = this.b;
        StringBuilder sb = new StringBuilder("create_time < ");
        aVar.getClass();
        String string = sb.append(com.smartdigimkt.z2.a.c()).toString();
        synchronized (aVar) {
            sQLiteDatabaseB = aVar.a.b();
        }
        if (sQLiteDatabaseB == null) {
            return;
        }
        try {
            sQLiteDatabaseB.delete("adx_offer_tracking", string, null);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
