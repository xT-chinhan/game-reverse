package com.smartdigimkt.v2;

import com.smartdigimkt.sdk.core.SDKContext;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Runnable {
    public final /* synthetic */ p a;

    public g(p pVar) {
        this.a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p pVar = this.a;
        String str = pVar.a;
        synchronized (pVar.f) {
            if (!this.a.i) {
                com.smartdigimkt.z2.k kVarA = com.smartdigimkt.z2.k.a(com.smartdigimkt.z2.d.a(SDKContext.getInstance().d()));
                String str2 = this.a.a;
                kVarA.c();
                ArrayList<com.smartdigimkt.a3.b> arrayListD = kVarA.d();
                if (arrayListD != null) {
                    for (com.smartdigimkt.a3.b bVar : arrayListD) {
                        if (!this.a.e.containsKey(bVar.a)) {
                            this.a.e.put(bVar.a, new b(com.smartdigimkt.r4.e.a(bVar.b), bVar.a, false, bVar.d, bVar.c == 1, null));
                            String str3 = this.a.a;
                            Thread.currentThread().getName();
                            ((b) this.a.e.get(bVar.a)).toString();
                        }
                    }
                }
            }
            p pVar2 = this.a;
            pVar2.m = true;
            pVar2.f();
        }
    }
}
