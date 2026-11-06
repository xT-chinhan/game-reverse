package com.smartdigimkt.q2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends BroadcastReceiver {
    public final /* synthetic */ SDKContext a;

    public f(SDKContext sDKContext) {
        this.a = sDKContext;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        SDKContext sDKContext = this.a;
        e eVar = new e(context);
        sDKContext.getClass();
        com.smartdigimkt.q3.f.a().a(eVar, 0L, 7);
        try {
            com.smartdigimkt.w2.b bVarE = this.a.e();
            if (bVarE != null) {
                bVarE.resetSSID();
            }
        } catch (Throwable unused) {
        }
    }
}
