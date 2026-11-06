package com.smartdigimkt.t;

import android.content.Context;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        Context contextD = SDKContext.getInstance().d();
        if (contextD != null) {
            com.smartdigimkt.q.e.a(contextD, new c(contextD));
        }
    }
}
