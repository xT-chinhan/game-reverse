package com.bytedance.sdk.component.widget.recycler.ms.ms;

import android.os.Trace;

/* JADX INFO: loaded from: classes2.dex */
public final class ms {
    public static void ms(String str) {
        Trace.beginSection(str);
    }

    public static void ms() {
        Trace.endSection();
    }
}
