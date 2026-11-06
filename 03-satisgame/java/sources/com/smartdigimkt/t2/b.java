package com.smartdigimkt.t2;

import android.content.ContentValues;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ e c;

    public b(e eVar, String str, String str2, String str3, String str4) {
        this.c = eVar;
        this.a = str3;
        this.b = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.z2.q qVar = this.c.a;
        String str = this.a;
        String str2 = this.b;
        synchronized (qVar) {
            if (qVar.b() == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(com.anythink.core.common.f.i.a.g, str2);
                if (qVar.a(str)) {
                    qVar.b().update(com.anythink.core.common.f.i.a.a, contentValues, "bid_id = ? ", new String[]{str});
                }
            } catch (Exception unused) {
            }
        }
    }
}
