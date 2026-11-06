package com.anythink.core.common.s.a;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class d implements com.anythink.core.common.s.a.a.c {
    private static final String a = "FastKV";

    d() {
    }

    @Override // com.anythink.core.common.s.a.a.c
    public final void a(String str, String str2) {
        Log.i(a, str + " " + str2);
    }

    @Override // com.anythink.core.common.s.a.a.c
    public final void a(String str, Exception exc) {
        Log.w(a, str, exc);
    }

    @Override // com.anythink.core.common.s.a.a.c
    public final void b(String str, Exception exc) {
        Log.e(a, str, exc);
    }
}
