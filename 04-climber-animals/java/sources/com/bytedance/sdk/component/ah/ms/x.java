package com.bytedance.sdk.component.ah.ms;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class x implements y {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final y f1021ms;

    public x(y yVar) {
        if (yVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f1021ms = yVar;
    }

    public final y xr() {
        return this.f1021ms;
    }

    @Override // com.bytedance.sdk.component.ah.ms.y
    public long ms(ah ahVar, long j) throws IOException {
        return this.f1021ms.ms(ahVar, j);
    }

    @Override // com.bytedance.sdk.component.ah.ms.y
    public t ms() {
        return this.f1021ms.ms();
    }

    @Override // com.bytedance.sdk.component.ah.ms.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f1021ms.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f1021ms.toString() + ")";
    }
}
