package com.smartdigimkt.z;

import android.content.Context;
import android.widget.Toast;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        Context contextD = SDKContext.getInstance().d();
        if (contextD != null) {
            Context applicationContext = contextD.getApplicationContext();
            try {
                Toast.makeText(applicationContext.getApplicationContext(), com.smartdigimkt.r4.k.a(applicationContext, "myoffer_click_no_response", "string"), 0).show();
            } catch (Throwable unused) {
            }
        }
    }
}
