package com.anythink.core.common.l.e;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class h extends i {
    String a;
    int c;
    private final String q = getClass().getSimpleName();
    boolean b = true;

    @Override // com.anythink.core.common.l.e.i
    public final int b() {
        return 3;
    }

    @Override // com.anythink.core.common.l.e.i
    public final void e() {
    }

    private h(String str, int i) {
        this.c = 1;
        this.a = str;
        if (i == 1000) {
            this.c = 1;
        } else if (i == 1001) {
            this.c = 2;
        }
    }

    @Override // com.anythink.core.common.l.e.i
    public final int a() {
        return this.c;
    }

    @Override // com.anythink.core.common.l.e.i
    public final byte[] c() {
        return !TextUtils.isEmpty(this.a) ? a(this.a) : new byte[0];
    }

    @Override // com.anythink.core.common.l.e.i
    public final boolean d() {
        return this.b;
    }
}
