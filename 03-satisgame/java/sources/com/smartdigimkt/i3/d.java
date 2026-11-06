package com.smartdigimkt.i3;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public final String a;
    public final long[] b;
    public boolean c;
    public c d;
    public final /* synthetic */ f e;

    public d(f fVar, String str) {
        this.e = fVar;
        this.a = str;
        this.b = new long[fVar.f];
    }

    public final File a(int i) {
        return new File(this.e.a, this.a + com.anythink.core.common.d.i.E + i);
    }

    public final File b(int i) {
        return new File(this.e.a, this.a + com.anythink.core.common.d.i.E + i + ".tmp");
    }
}
