package com.smartdigimkt.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            intent.getAction();
            int intExtra = intent.getIntExtra(com.anythink.core.common.s.a, -1);
            int intExtra2 = intent.getIntExtra("a", 0);
            String stringExtra = intent.getStringExtra(com.anythink.core.e.d.a);
            Bundle bundleExtra = intent.getBundleExtra("b");
            Objects.toString(bundleExtra);
            switch (intExtra2) {
                case 1:
                    h hVarA = h.a();
                    if (!hVarA.l) {
                        hVarA.l = intExtra == 2;
                    }
                    if (context != null && !hVarA.c.get()) {
                        hVarA.c.set(true);
                        hVarA.k = intExtra;
                        com.smartdigimkt.q3.f.a().a(new c(hVarA, context), 0L, 7);
                        return;
                    }
                    return;
                case 2:
                    h.a().a(context, intExtra, stringExtra);
                    return;
                case 3:
                    h hVarA2 = h.a();
                    hVarA2.getClass();
                    if (TextUtils.isEmpty(stringExtra)) {
                        return;
                    }
                    int i = hVarA2.k;
                    if (intExtra == i || i == 0) {
                        synchronized (hVarA2.f) {
                            try {
                                String strB = com.smartdigimkt.r4.e.b(stringExtra);
                                hVarA2.h = strB;
                                hVarA2.i.put("cp2", strB);
                                break;
                            } catch (Throwable unused) {
                            }
                            hVarA2.a(context);
                            break;
                        }
                        return;
                    }
                    return;
                case 4:
                    boolean zEquals = TextUtils.equals(stringExtra, "1");
                    h hVarA3 = h.a();
                    hVarA3.m = zEquals;
                    com.smartdigimkt.q3.f.a().c(new d(hVarA3, zEquals));
                    return;
                case 5:
                case 6:
                case 7:
                    h hVarA4 = h.a();
                    hVarA4.getClass();
                    com.smartdigimkt.q3.f.a().c(new e(hVarA4, intExtra2, bundleExtra));
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            Log.getStackTraceString(th);
        }
        Log.getStackTraceString(th);
    }
}
