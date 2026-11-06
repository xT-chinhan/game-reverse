package com.anythink.core.common.n.b.a.b;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class h extends RuntimeException {
    private IOException a;
    private IOException b;

    h(IOException iOException) {
        super(iOException);
        this.a = iOException;
        this.b = iOException;
    }

    public final IOException a() {
        return this.a;
    }

    public final IOException b() {
        return this.b;
    }

    final void a(IOException iOException) {
        com.anythink.core.common.n.b.a.c.a(this.a, iOException);
        this.b = iOException;
    }
}
