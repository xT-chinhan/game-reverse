package com.smartdigimkt.z0;

import android.os.Trace;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s {
    public static void a(String str) {
        if (u.a >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void a() {
        if (u.a >= 18) {
            Trace.endSection();
        }
    }
}
