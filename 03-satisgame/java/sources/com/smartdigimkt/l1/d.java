package com.smartdigimkt.l1;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Runnable {
    public final /* synthetic */ com.smartdigimkt.h0.c a;
    public final /* synthetic */ e b;

    public d(e eVar, com.smartdigimkt.h0.c cVar) {
        this.b = eVar;
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.b.a;
        if (com.smartdigimkt.g0.a.b == null) {
            com.smartdigimkt.g0.a.b = new com.smartdigimkt.g0.a(context);
        }
        com.smartdigimkt.g0.a aVar = com.smartdigimkt.g0.a.b;
        String str = this.a.f;
        synchronized (aVar) {
            synchronized (aVar) {
                try {
                    String str2 = "record_date != '" + str + "'";
                    if (com.smartdigimkt.g0.b.a(aVar.a).getWritableDatabase() != null) {
                        com.smartdigimkt.g0.b.a(aVar.a).getWritableDatabase().delete("my_offer_cap_pacing", str2, null);
                    }
                } catch (Exception unused) {
                }
            }
        }
        Context context2 = this.b.a;
        if (com.smartdigimkt.g0.a.b == null) {
            com.smartdigimkt.g0.a.b = new com.smartdigimkt.g0.a(context2);
        }
        com.smartdigimkt.g0.a.b.a(this.a);
    }
}
