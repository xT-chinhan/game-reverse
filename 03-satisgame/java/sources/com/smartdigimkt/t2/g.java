package com.smartdigimkt.t2;

import android.content.ContentValues;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Runnable {
    public final /* synthetic */ com.smartdigimkt.b3.b a;
    public final /* synthetic */ j b;

    public g(j jVar, com.smartdigimkt.b3.b bVar) {
        this.b = jVar;
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.b3.b bVar = this.a;
        String str = bVar.c0;
        String str2 = bVar.d0;
        int i = bVar.e0;
        com.smartdigimkt.z2.i iVar = this.b.b;
        synchronized (iVar) {
            if (iVar.b() != null) {
                if (i <= 0) {
                    return;
                }
                t tVarA = iVar.a(str, str2);
                if (tVarA != null) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("dsp_id", str);
                        contentValues.put("dsp_offer_id", str2);
                        contentValues.put("show_limit", Integer.valueOf(i));
                        contentValues.put("show_count", Integer.valueOf(tVarA.c + 1));
                        contentValues.put("last_update_time", Long.valueOf(System.currentTimeMillis()));
                        iVar.b().update("dsp_offer_show_record", contentValues, "dsp_id = ? and dsp_offer_id = ? ", new String[]{str, str2});
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }
}
