package com.smartdigimkt.y0;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 {
    public final ExecutorService a;
    public w b;
    public IOException c;

    public a0() {
        int i = com.smartdigimkt.z0.u.a;
        this.a = Executors.newSingleThreadExecutor(new com.smartdigimkt.z0.t());
    }
}
