package com.anythink.core.common.n.b.a.e;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class n extends IOException {
    public final b a;

    public n(b bVar) {
        super("stream was reset: ".concat(String.valueOf(bVar)));
        this.a = bVar;
    }
}
