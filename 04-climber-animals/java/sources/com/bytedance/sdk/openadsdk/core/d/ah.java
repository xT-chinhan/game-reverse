package com.bytedance.sdk.openadsdk.core.d;

import com.bytedance.sdk.component.adexpress.ka.ka;
import com.bytedance.sdk.component.panglearmor.c;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.jw.ch;

/* JADX INFO: loaded from: classes2.dex */
public class ah {
    public static void ms() {
        x.ms().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.d.ah.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.x.xr.ms().xr(0.0d);
                    ah.unregisterReceiver();
                    ka.ms().xr();
                } catch (Throwable unused) {
                }
            }
        }, 20000L);
        c.ms();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void unregisterReceiver() {
        ch.ka();
        ch.zb();
    }
}
