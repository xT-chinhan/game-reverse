package com.smartdigimkt.r;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 implements ServiceConnection {
    public final /* synthetic */ e0 a;

    public d0(e0 e0Var) {
        this.a = e0Var;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        h0 f0Var;
        e0 e0Var = this.a;
        int i = g0.a;
        if (iBinder == null) {
            f0Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.oplus.stdid.IStdID");
            f0Var = iInterfaceQueryLocalInterface instanceof h0 ? (h0) iInterfaceQueryLocalInterface : new f0(iBinder);
        }
        e0Var.b = f0Var;
        e0 e0Var2 = this.a;
        e0Var2.getClass();
        try {
            Context context = e0Var2.a;
            if (context == null) {
                com.smartdigimkt.q.a aVar = e0Var2.c;
                if (aVar != null) {
                    aVar.a("context is null.");
                }
            } else if (e0Var2.b == null) {
                com.smartdigimkt.q.a aVar2 = e0Var2.c;
                if (aVar2 != null) {
                    aVar2.a("realmeOaidInterface is null.");
                }
            } else {
                String packageName = context.getPackageName();
                if (e0Var2.d == null) {
                    byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(e0Var2.a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
                    StringBuilder sb = new StringBuilder();
                    for (byte b : bArrDigest) {
                        sb.append(Integer.toHexString((b & UByte.MAX_VALUE) | 256).substring(1, 3));
                    }
                    e0Var2.d = sb.toString();
                }
                String strA = ((f0) e0Var2.b).a(packageName, e0Var2.d);
                com.smartdigimkt.q.a aVar3 = e0Var2.c;
                if (aVar3 != null) {
                    aVar3.a(strA, false);
                }
            }
        } catch (Throwable th) {
            try {
                com.smartdigimkt.q.a aVar4 = e0Var2.c;
                if (aVar4 != null) {
                    aVar4.a("realme get oaid failed: " + th.getMessage());
                }
            } finally {
                e0Var2.a();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.a.b = null;
    }
}
