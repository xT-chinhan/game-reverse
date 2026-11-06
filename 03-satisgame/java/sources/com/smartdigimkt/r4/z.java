package com.smartdigimkt.r4;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.SparseBooleanArray;

/* JADX INFO: loaded from: classes3.dex */
public final class z {
    public static volatile z b;
    public final SparseBooleanArray a = new SparseBooleanArray(3);

    public static z a() {
        if (b == null) {
            synchronized (z.class) {
                if (b == null) {
                    b = new z();
                }
            }
        }
        return b;
    }

    public final synchronized boolean a(Context context) {
        char c;
        if (this.a.indexOfKey(1) >= 0) {
            return this.a.get(1);
        }
        boolean z = false;
        try {
            x xVar = new x(context);
            if (TextUtils.isEmpty("com.huawei.hwid")) {
                c = 3;
            } else {
                try {
                    c = xVar.a.getApplicationInfo("com.huawei.hwid", 0).enabled ? (char) 1 : (char) 2;
                } catch (PackageManager.NameNotFoundException unused) {
                    c = 3;
                }
            }
            String strA = xVar.a();
            if (c == 1 && "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05".equalsIgnoreCase(strA)) {
                z = true;
            }
        } catch (Exception unused2) {
        }
        this.a.put(1, z);
        return z;
    }
}
