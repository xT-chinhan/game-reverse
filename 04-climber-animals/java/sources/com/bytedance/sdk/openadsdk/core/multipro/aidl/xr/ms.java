package com.bytedance.sdk.openadsdk.core.multipro.aidl.xr;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.zb;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends zb.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Handler f2918ms = new Handler(Looper.getMainLooper());
    private com.bytedance.sdk.openadsdk.core.jw.c.ms xr;

    public ms(com.bytedance.sdk.openadsdk.core.jw.c.ms msVar) {
        this.xr = msVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.zb
    public void ms() throws RemoteException {
        ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.ms.1
            @Override // java.lang.Runnable
            public void run() {
                if (ms.this.xr != null) {
                    ms.this.xr.ms();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.zb
    public void xr() throws RemoteException {
        ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.ms.2
            @Override // java.lang.Runnable
            public void run() {
                if (ms.this.xr != null) {
                    ms.this.xr.xr();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.zb
    public void ah() throws RemoteException {
        ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.ms.3
            @Override // java.lang.Runnable
            public void run() {
                if (ms.this.xr != null) {
                    ms.this.xr.ah();
                }
            }
        });
    }

    private void ms(Runnable runnable) {
        this.f2918ms.post(runnable);
    }
}
