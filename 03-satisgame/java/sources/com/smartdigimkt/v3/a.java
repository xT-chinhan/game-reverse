package com.smartdigimkt.v3;

import android.content.Context;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ f b;

    public a(f fVar, Context context) {
        this.b = fVar;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            com.smartdigimkt.w2.b bVarE = SDKContext.getInstance().e();
            if (bVarE != null) {
                this.b.e.set(bVarE.initPlugin(this.a));
                f fVar = this.b;
                Context context = this.a;
                fVar.getClass();
                com.smartdigimkt.q3.f.a().c(new b(fVar, context));
            }
        } catch (Throwable unused) {
        }
    }
}
