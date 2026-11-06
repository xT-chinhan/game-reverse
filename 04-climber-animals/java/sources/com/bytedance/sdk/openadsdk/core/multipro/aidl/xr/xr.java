package com.bytedance.sdk.openadsdk.core.multipro.aidl.xr;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.jw.ab;
import com.bytedance.sdk.openadsdk.core.u;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends u.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Handler f2922ms = new Handler(Looper.getMainLooper());
    private ab.ms xr;

    public xr(ab.ms msVar) {
        this.xr = msVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.u
    public void ms() throws RemoteException {
        ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.xr.1
            @Override // java.lang.Runnable
            public void run() {
                if (xr.this.xr != null) {
                    xr.this.xr.ms();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.u
    public void ms(final String str) throws RemoteException {
        ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.xr.2
            @Override // java.lang.Runnable
            public void run() {
                if (xr.this.xr != null) {
                    xr.this.xr.ms(str);
                }
            }
        });
    }

    private void ms(Runnable runnable) {
        if (this.f2922ms == null) {
            this.f2922ms = new Handler(Looper.getMainLooper());
        }
        this.f2922ms.post(runnable);
    }
}
