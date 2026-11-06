package com.smartdigimkt.m1;

import android.content.Context;
import com.smartdigimkt.r4.y;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ d b;

    public a(d dVar, Context context) {
        this.b = dVar;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d dVar = this.b;
        Context contextD = this.a;
        synchronized (dVar) {
            if (contextD == null) {
                contextD = SDKContext.getInstance().d();
            }
            dVar.h = y.c(contextD, "sdm_adx_rp_sdk", "adx_optional_res_url");
        }
        d dVar2 = this.b;
        dVar2.g = dVar2.c();
    }
}
