package com.bytedance.sdk.component.ah.xr.ms.ms;

import com.bytedance.sdk.component.ah.ms.ab;
import com.bytedance.sdk.component.ah.ms.qv;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class ka extends ab {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f1115ms;

    protected void ms(IOException iOException) {
    }

    ka(qv qvVar) {
        super(qvVar);
    }

    @Override // com.bytedance.sdk.component.ah.ms.ab, com.bytedance.sdk.component.ah.ms.qv
    public void a_(com.bytedance.sdk.component.ah.ms.ah ahVar, long j) throws IOException {
        if (this.f1115ms) {
            ahVar.x(j);
            return;
        }
        try {
            super.a_(ahVar, j);
        } catch (IOException e) {
            this.f1115ms = true;
            ms(e);
        }
    }

    @Override // com.bytedance.sdk.component.ah.ms.ab, com.bytedance.sdk.component.ah.ms.qv, java.io.Flushable
    public void flush() throws IOException {
        if (this.f1115ms) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e) {
            this.f1115ms = true;
            ms(e);
        }
    }

    @Override // com.bytedance.sdk.component.ah.ms.ab, com.bytedance.sdk.component.ah.ms.qv, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f1115ms) {
            return;
        }
        try {
            super.close();
        } catch (IOException e) {
            this.f1115ms = true;
            ms(e);
        }
    }
}
