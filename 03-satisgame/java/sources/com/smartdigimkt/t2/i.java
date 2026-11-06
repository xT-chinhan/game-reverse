package com.smartdigimkt.t2;

import android.content.ContentValues;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements Runnable {
    public final /* synthetic */ com.smartdigimkt.b3.b a;
    public final /* synthetic */ j b;

    public i(j jVar, com.smartdigimkt.b3.b bVar) {
        this.b = jVar;
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.b;
        String str = jVar.a;
        com.smartdigimkt.b3.b bVar = this.a;
        String str2 = bVar.d0;
        String str3 = bVar.c0;
        String str4 = bVar.m;
        com.smartdigimkt.z2.h hVar = jVar.c;
        synchronized (hVar) {
            if (hVar.b() != null) {
                if (!hVar.a(str3, str2)) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("dsp_id", str3);
                        contentValues.put("dsp_offer_id", str2);
                        contentValues.put("package_name", str4);
                        contentValues.put("last_update_time", Long.valueOf(System.currentTimeMillis()));
                        hVar.b().insert("dsp_offer_install_record", null, contentValues);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }
}
