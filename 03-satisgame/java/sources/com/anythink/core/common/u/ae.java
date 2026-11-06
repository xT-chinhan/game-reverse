package com.anythink.core.common.u;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.util.SparseBooleanArray;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ae {
    private static final int a = 1;
    private static final int b = 2;
    private static final int c = 3;
    private static volatile ae e;
    private final SparseBooleanArray d = new SparseBooleanArray(3);

    public static ae a() {
        if (e == null) {
            synchronized (ae.class) {
                if (e == null) {
                    e = new ae();
                }
            }
        }
        return e;
    }

    public final synchronized boolean a(Context context) {
        if (this.d.indexOfKey(1) >= 0) {
            return this.d.get(1);
        }
        boolean z = false;
        try {
            ab abVar = new ab(context);
            ab.a aVarA = abVar.a("com.huawei.hwid");
            String strB = abVar.b("com.huawei.hwid");
            if (aVarA == ab.a.ENABLED && "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05".equalsIgnoreCase(strB)) {
                z = true;
            }
        } catch (Exception unused) {
        }
        this.d.put(1, z);
        return z;
    }

    public final synchronized boolean b(Context context) {
        if (this.d.indexOfKey(2) >= 0) {
            return this.d.get(2);
        }
        boolean z = false;
        try {
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
                z = true;
            }
        } catch (Exception unused) {
        }
        this.d.put(2, z);
        return z;
    }

    public final synchronized boolean b() {
        boolean z;
        if (this.d.indexOfKey(3) >= 0) {
            return this.d.get(3);
        }
        try {
            Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory");
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        this.d.put(3, z);
        return z;
    }
}
