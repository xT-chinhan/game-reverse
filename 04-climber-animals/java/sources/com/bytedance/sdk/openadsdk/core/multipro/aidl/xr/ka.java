package com.bytedance.sdk.openadsdk.core.multipro.aidl.xr;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.qv;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends qv.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.yu.ms.xr.ms.ms f2909ms;
    private Handler xr = new Handler(Looper.getMainLooper());

    public ka(com.bytedance.sdk.openadsdk.yu.ms.xr.ms.ms msVar) {
        this.f2909ms = msVar;
    }

    private void ny() {
        this.f2909ms = null;
        this.xr = null;
    }

    private Handler ch() {
        Handler handler = this.xr;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.xr = handler2;
        return handler2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv
    public void ms() throws RemoteException {
        ny();
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv
    public void xr() throws RemoteException {
        ch().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.ka.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.yu.ms.xr.ms.ms msVar = ka.this.f2909ms;
                if (msVar != null) {
                    msVar.ms();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv
    public void ah() throws RemoteException {
        ch().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.ka.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.yu.ms.xr.ms.ms msVar = ka.this.f2909ms;
                if (msVar != null) {
                    msVar.xr();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv
    public void d() throws RemoteException {
        ch().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.ka.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.yu.ms.xr.ms.ms msVar = ka.this.f2909ms;
                if (msVar != null) {
                    msVar.ah();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv
    public void ka() throws RemoteException {
        ch().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.ka.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.yu.ms.xr.ms.ms msVar = ka.this.f2909ms;
                if (msVar != null) {
                    msVar.d();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv
    public void c() throws RemoteException {
        ch().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.ka.5
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.yu.ms.xr.ms.ms msVar = ka.this.f2909ms;
                if (msVar != null) {
                    msVar.ka();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv
    public void ab() throws RemoteException {
        ch().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.ka.6
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.yu.ms.xr.ms.ms msVar = ka.this.f2909ms;
                if (msVar != null) {
                    msVar.c();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv
    public void ms(final boolean z, final int i, final String str, final int i2, final String str2) throws RemoteException {
        ch().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.ka.7
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.yu.ms.xr.ms.ms msVar = ka.this.f2909ms;
                if (msVar != null) {
                    msVar.ms(z, i, str, i2, str2);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv
    public void ms(final boolean z, final int i, final Bundle bundle) {
        ch().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.ka.8
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.yu.ms.xr.ms.ms msVar = ka.this.f2909ms;
                if (msVar == null || g.xr < 4400) {
                    return;
                }
                try {
                    msVar.ms(z, i, bundle);
                } catch (AbstractMethodError unused) {
                    sl.d("RewardVideoListenerImpl", "onRewardArrived 未实现！");
                }
            }
        });
    }
}
