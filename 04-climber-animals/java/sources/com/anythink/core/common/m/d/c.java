package com.anythink.core.common.m.d;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class c extends d {
    String a;
    int c;
    private final String l = getClass().getSimpleName();
    boolean b = true;

    @Override // com.anythink.core.common.m.d.d
    public final void a(String str, String str2, String str3, int i) {
    }

    @Override // com.anythink.core.common.m.d.d
    public final int d() {
        return 3;
    }

    public c(String str, int i) {
        this.c = 1;
        this.a = str;
        if (i == 1000) {
            this.c = 1;
        } else if (i == 1001) {
            this.c = 2;
        }
    }

    @Override // com.anythink.core.common.m.d.d
    public final int c() {
        return this.c;
    }

    @Override // com.anythink.core.common.m.d.d
    public final byte[] e() {
        return !TextUtils.isEmpty(this.a) ? a(this.a) : new byte[0];
    }

    @Override // com.anythink.core.common.m.d.d
    public final boolean f() {
        return this.b;
    }
}
