package com.bytedance.sdk.openadsdk.core.multipro.aidl.xr;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.y;

/* JADX INFO: loaded from: classes2.dex */
public class c extends y.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private volatile com.bytedance.sdk.openadsdk.core.hi.xr.ms f2900ms;
    private Handler xr = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ms(com.bytedance.sdk.openadsdk.core.hi.xr.ms msVar) {
        return msVar != null;
    }

    private Handler d() {
        Handler handler = this.xr;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.xr = handler2;
        return handler2;
    }

    public c(com.bytedance.sdk.openadsdk.core.hi.xr.ms msVar) {
        this.f2900ms = msVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.y
    public void ms() throws RemoteException {
        if (this.f2900ms != null) {
            d().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.c.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.hi.xr.ms msVar = c.this.f2900ms;
                    if (c.this.ms(msVar)) {
                        msVar.ms();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.y
    public void ms(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.f2900ms != null) {
            d().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.c.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.hi.xr.ms msVar = c.this.f2900ms;
                    if (c.this.ms(msVar)) {
                        msVar.ms(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.y
    public void xr(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.f2900ms != null) {
            d().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.c.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.hi.xr.ms msVar = c.this.f2900ms;
                    if (c.this.ms(msVar)) {
                        msVar.xr(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.y
    public void ah(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.f2900ms != null) {
            d().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.c.4
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.hi.xr.ms msVar = c.this.f2900ms;
                    if (c.this.ms(msVar)) {
                        msVar.ah(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.y
    public void ms(final long j, final String str, final String str2) throws RemoteException {
        if (this.f2900ms != null) {
            d().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.c.5
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.hi.xr.ms msVar = c.this.f2900ms;
                    if (c.this.ms(msVar)) {
                        msVar.ms(j, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.y
    public void ms(final String str, final String str2) throws RemoteException {
        if (this.f2900ms != null) {
            d().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.c.6
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.hi.xr.ms msVar = c.this.f2900ms;
                    if (c.this.ms(msVar)) {
                        String str3 = str;
                        if (str3 == null) {
                            str3 = "";
                        }
                        String str4 = str2;
                        msVar.ms(str3, str4 != null ? str4 : "");
                    }
                }
            });
        }
    }

    public void ah() {
        this.f2900ms = null;
        this.xr = null;
    }
}
