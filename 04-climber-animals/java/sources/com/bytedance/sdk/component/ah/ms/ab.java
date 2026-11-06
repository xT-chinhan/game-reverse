package com.bytedance.sdk.component.ah.ms;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ab implements qv {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final qv f1002ms;

    public ab(qv qvVar) {
        if (qvVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f1002ms = qvVar;
    }

    @Override // com.bytedance.sdk.component.ah.ms.qv
    public void a_(ah ahVar, long j) throws IOException {
        this.f1002ms.a_(ahVar, j);
    }

    @Override // com.bytedance.sdk.component.ah.ms.qv, java.io.Flushable
    public void flush() throws IOException {
        this.f1002ms.flush();
    }

    @Override // com.bytedance.sdk.component.ah.ms.qv
    public t ms() {
        return this.f1002ms.ms();
    }

    @Override // com.bytedance.sdk.component.ah.ms.qv, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f1002ms.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f1002ms.toString() + ")";
    }
}
