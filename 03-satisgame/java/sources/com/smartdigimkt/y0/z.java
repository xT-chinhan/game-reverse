package com.smartdigimkt.y0;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class z extends IOException {
    public z(Throwable th) {
        super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
    }
}
