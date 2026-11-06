package com.smartdigimkt.j3;

import android.content.Context;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {
    public final /* synthetic */ b a;

    public a(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.a;
        bVar.getClass();
        Context contextD = SDKContext.getInstance().d();
        if (contextD != null) {
            bVar.a(contextD);
        }
    }
}
