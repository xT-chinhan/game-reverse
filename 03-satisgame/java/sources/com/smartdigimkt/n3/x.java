package com.smartdigimkt.n3;

import android.content.ContentValues;
import android.database.Cursor;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ a0 f;

    public x(a0 a0Var, int i, String str, String str2, String str3, String str4) {
        this.f = a0Var;
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Cursor cursorQuery;
        int i = this.a;
        String str = this.b;
        String str2 = this.c;
        String str3 = this.d;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strB = com.smartdigimkt.r4.i.b(new StringBuilder().append(this.b).append(jCurrentTimeMillis).append(this.d).toString() != null ? this.d : "");
        String str4 = this.e;
        String str5 = this.f.a;
        com.smartdigimkt.z2.j jVarA = com.smartdigimkt.z2.j.a(com.smartdigimkt.z2.d.a(SDKContext.getInstance().d()));
        synchronized (jVarA) {
            if (jVarA.b() == null) {
                return;
            }
            Cursor cursor = null;
            try {
                cursorQuery = jVarA.a().query("request_info", null, null, null, null, null, null);
                try {
                    if (cursorQuery.getCount() >= 1000) {
                        jVarA.c();
                    }
                } catch (Exception unused) {
                    if (cursorQuery != null) {
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("id", strB);
                    contentValues.put(com.anythink.core.common.f.h.b.c, Integer.valueOf(i));
                    contentValues.put(com.anythink.core.common.f.h.b.d, str);
                    contentValues.put(com.anythink.core.common.f.h.b.e, str2);
                    contentValues.put("req_content", str3);
                    contentValues.put("time", Long.valueOf(jCurrentTimeMillis));
                    contentValues.put("extra", str4);
                    jVarA.b().insert("request_info", null, contentValues);
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused3) {
                cursorQuery = null;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                cursorQuery.close();
            } catch (Exception unused4) {
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("id", strB);
                contentValues2.put(com.anythink.core.common.f.h.b.c, Integer.valueOf(i));
                contentValues2.put(com.anythink.core.common.f.h.b.d, str);
                contentValues2.put(com.anythink.core.common.f.h.b.e, str2);
                contentValues2.put("req_content", str3);
                contentValues2.put("time", Long.valueOf(jCurrentTimeMillis));
                contentValues2.put("extra", str4);
                jVarA.b().insert("request_info", null, contentValues2);
            } catch (Exception unused5) {
            }
        }
    }
}
