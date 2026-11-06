package com.smartdigimkt.x;

import android.content.Context;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Runnable {
    public final /* synthetic */ j a;

    public g(j jVar) {
        this.a = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            String str = this.a.a;
            com.smartdigimkt.m1.d dVarA = com.smartdigimkt.m1.d.a();
            Context context = this.a.g;
            dVarA.b();
            com.smartdigimkt.m1.d dVarA2 = com.smartdigimkt.m1.d.a();
            Context context2 = this.a.g;
            if (dVarA2.b()) {
                SDKContext sDKContext = SDKContext.getInstance();
                f fVar = new f(this);
                sDKContext.getClass();
                com.smartdigimkt.q3.f.a().a(fVar, 0L, 7);
            }
        } catch (Throwable th) {
            j jVar = this.a;
            th.getMessage();
            jVar.a(false);
        }
    }
}
