package com.smartdigimkt.r3;

import android.content.Context;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.v3.e;
import com.smartdigimkt.v3.f;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ b b;

    public a(b bVar, Context context) {
        this.b = bVar;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c cVar = this.b.a;
        if (cVar.e != 0 || cVar.g) {
            return;
        }
        cVar.f = true;
        f fVarA = f.a();
        Context context = this.a;
        fVarA.getClass();
        com.smartdigimkt.q3.f.a().c(new e(fVarA, context, false));
        SDKContext.getInstance().l = false;
    }
}
