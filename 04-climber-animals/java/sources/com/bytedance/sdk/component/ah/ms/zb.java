package com.bytedance.sdk.component.ah.ms;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
final class zb implements d {
    boolean ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final ah f1023ms = new ah();
    public final qv xr;

    zb(qv qvVar) {
        if (qvVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.xr = qvVar;
    }

    @Override // com.bytedance.sdk.component.ah.ms.d, com.bytedance.sdk.component.ah.ms.ka
    public ah ah() {
        return this.f1023ms;
    }

    @Override // com.bytedance.sdk.component.ah.ms.qv
    public void a_(ah ahVar, long j) throws IOException {
        if (this.ah) {
            throw new IllegalStateException("closed");
        }
        this.f1023ms.a_(ahVar, j);
        nw();
    }

    @Override // com.bytedance.sdk.component.ah.ms.d
    public d xr(c cVar) throws IOException {
        if (this.ah) {
            throw new IllegalStateException("closed");
        }
        this.f1023ms.xr(cVar);
        return nw();
    }

    @Override // com.bytedance.sdk.component.ah.ms.d
    public d xr(String str) throws IOException {
        if (this.ah) {
            throw new IllegalStateException("closed");
        }
        this.f1023ms.xr(str);
        return nw();
    }

    @Override // com.bytedance.sdk.component.ah.ms.d
    public d ah(byte[] bArr) throws IOException {
        if (this.ah) {
            throw new IllegalStateException("closed");
        }
        this.f1023ms.ah(bArr);
        return nw();
    }

    @Override // com.bytedance.sdk.component.ah.ms.d
    public d ah(byte[] bArr, int i, int i2) throws IOException {
        if (this.ah) {
            throw new IllegalStateException("closed");
        }
        this.f1023ms.ah(bArr, i, i2);
        return nw();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (this.ah) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.f1023ms.write(byteBuffer);
        nw();
        return iWrite;
    }

    @Override // com.bytedance.sdk.component.ah.ms.d
    public d ny(int i) throws IOException {
        if (this.ah) {
            throw new IllegalStateException("closed");
        }
        this.f1023ms.ny(i);
        return nw();
    }

    @Override // com.bytedance.sdk.component.ah.ms.d
    public d x(int i) throws IOException {
        if (this.ah) {
            throw new IllegalStateException("closed");
        }
        this.f1023ms.x(i);
        return nw();
    }

    @Override // com.bytedance.sdk.component.ah.ms.d
    public d ab(int i) throws IOException {
        if (this.ah) {
            throw new IllegalStateException("closed");
        }
        this.f1023ms.ab(i);
        return nw();
    }

    @Override // com.bytedance.sdk.component.ah.ms.d
    public d sl(long j) throws IOException {
        if (this.ah) {
            throw new IllegalStateException("closed");
        }
        this.f1023ms.sl(j);
        return nw();
    }

    @Override // com.bytedance.sdk.component.ah.ms.d
    public d hi(long j) throws IOException {
        if (this.ah) {
            throw new IllegalStateException("closed");
        }
        this.f1023ms.hi(j);
        return nw();
    }

    @Override // com.bytedance.sdk.component.ah.ms.d
    public d nw() throws IOException {
        if (this.ah) {
            throw new IllegalStateException("closed");
        }
        long jAb = this.f1023ms.ab();
        if (jAb > 0) {
            this.xr.a_(this.f1023ms, jAb);
        }
        return this;
    }

    @Override // com.bytedance.sdk.component.ah.ms.d, com.bytedance.sdk.component.ah.ms.qv, java.io.Flushable
    public void flush() throws IOException {
        if (this.ah) {
            throw new IllegalStateException("closed");
        }
        if (this.f1023ms.xr > 0) {
            qv qvVar = this.xr;
            ah ahVar = this.f1023ms;
            qvVar.a_(ahVar, ahVar.xr);
        }
        this.xr.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.ah;
    }

    @Override // com.bytedance.sdk.component.ah.ms.qv, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.ah) {
            return;
        }
        if (this.f1023ms.xr > 0) {
            qv qvVar = this.xr;
            ah ahVar = this.f1023ms;
            qvVar.a_(ahVar, ahVar.xr);
        }
        th = null;
        try {
            this.xr.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        this.ah = true;
        if (th != null) {
            nw.ms(th);
        }
    }

    @Override // com.bytedance.sdk.component.ah.ms.qv
    public t ms() {
        return this.xr.ms();
    }

    public String toString() {
        return "buffer(" + this.xr + ")";
    }
}
