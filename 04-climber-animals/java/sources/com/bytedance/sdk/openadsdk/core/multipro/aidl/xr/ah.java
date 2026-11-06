package com.bytedance.sdk.openadsdk.core.multipro.aidl.xr;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.ub;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends ub.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.re.ms.xr.ms.ms f2894ms;
    private Handler xr = new Handler(Looper.getMainLooper());

    public ah(com.bytedance.sdk.openadsdk.re.ms.xr.ms.ms msVar) {
        this.f2894ms = msVar;
    }

    private void x() {
        this.f2894ms = null;
        this.xr = null;
    }

    private Handler ny() {
        Handler handler = this.xr;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.xr = handler2;
        return handler2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ub
    public void ms() throws RemoteException {
        x();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ub
    public void xr() throws RemoteException {
        ny().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.ah.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.re.ms.xr.ms.ms msVar = ah.this.f2894ms;
                if (msVar != null) {
                    msVar.ms();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.ub
    public void ah() throws RemoteException {
        ny().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.ah.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.re.ms.xr.ms.ms msVar = ah.this.f2894ms;
                if (msVar != null) {
                    msVar.xr();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.ub
    public void d() throws RemoteException {
        ny().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.ah.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.re.ms.xr.ms.ms msVar = ah.this.f2894ms;
                if (msVar != null) {
                    msVar.ah();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.ub
    public void ka() throws RemoteException {
        ny().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.ah.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.re.ms.xr.ms.ms msVar = ah.this.f2894ms;
                if (msVar != null) {
                    msVar.d();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.ub
    public void c() throws RemoteException {
        ny().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.ah.5
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.re.ms.xr.ms.ms msVar = ah.this.f2894ms;
                if (msVar != null) {
                    msVar.ka();
                }
            }
        });
    }
}
