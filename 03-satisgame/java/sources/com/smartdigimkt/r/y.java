package com.smartdigimkt.r;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.SystemClock;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements ServiceConnection {
    public final /* synthetic */ z a;

    public y(z zVar) {
        this.a = zVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        c0 a0Var;
        Context context;
        y yVar;
        z zVar = this.a;
        int i = b0.a;
        if (iBinder == null) {
            a0Var = null;
        } else {
            try {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
                a0Var = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c0)) ? new a0(iBinder) : (c0) iInterfaceQueryLocalInterface;
            } catch (Throwable unused) {
                a0Var = null;
            }
        }
        zVar.c = a0Var;
        z zVar2 = this.a;
        zVar2.getClass();
        try {
            try {
                if (zVar2.c != null) {
                    String strA = zVar2.a();
                    if (!TextUtils.isEmpty(strA)) {
                        zVar2.a(strA, "");
                        context = zVar2.a;
                        if (context != null) {
                            yVar = zVar2.d;
                            context.unbindService(yVar);
                        }
                        return;
                    }
                    try {
                        SystemClock.sleep(3000L);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    zVar2.a(zVar2.a(), "");
                } else {
                    zVar2.a("", "get oaid failed: oppoOaidInterface is null.");
                }
                context = zVar2.a;
                if (context != null) {
                    yVar = zVar2.d;
                    context.unbindService(yVar);
                }
            } catch (Throwable unused2) {
            }
        } catch (Throwable th2) {
            try {
                zVar2.a("", "get oaid failed: " + th2.getMessage());
                context = zVar2.a;
                if (context == null) {
                } else {
                    yVar = zVar2.d;
                }
            } catch (Throwable th3) {
                Context context2 = zVar2.a;
                if (context2 != null) {
                    try {
                        context2.unbindService(zVar2.d);
                    } catch (Throwable unused3) {
                    }
                }
                throw th3;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.a.c = null;
    }
}
