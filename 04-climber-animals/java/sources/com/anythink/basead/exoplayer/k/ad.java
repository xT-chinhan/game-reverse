package com.anythink.basead.exoplayer.k;

import android.os.Trace;

/* JADX INFO: loaded from: classes.dex */
public final class ad {
    private ad() {
    }

    public static void a(String str) {
        if (af.a >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void a() {
        if (af.a >= 18) {
            Trace.endSection();
        }
    }

    private static void b(String str) {
        Trace.beginSection(str);
    }

    private static void b() {
        Trace.endSection();
    }
}
