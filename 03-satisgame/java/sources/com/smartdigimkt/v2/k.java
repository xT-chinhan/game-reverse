package com.smartdigimkt.v2;

import android.content.Context;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements Runnable {
    public final /* synthetic */ List a;

    public k(ArrayList arrayList) {
        this.a = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Context contextD = SDKContext.getInstance().d();
            if (contextD != null) {
                com.smartdigimkt.z2.k.a(com.smartdigimkt.z2.d.a(contextD)).a(this.a);
            }
        } catch (Throwable unused) {
        }
    }
}
