package com.smartdigimkt.i3;

import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends FilterOutputStream {
    public final /* synthetic */ c a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, FileOutputStream fileOutputStream) {
        super(fileOutputStream);
        this.a = cVar;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            ((FilterOutputStream) this).out.close();
        } catch (IOException unused) {
            this.a.b = true;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public final void flush() {
        try {
            ((FilterOutputStream) this).out.flush();
        } catch (IOException unused) {
            this.a.b = true;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int i) {
        try {
            ((FilterOutputStream) this).out.write(i);
        } catch (IOException unused) {
            this.a.b = true;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        try {
            ((FilterOutputStream) this).out.write(bArr, i, i2);
        } catch (IOException unused) {
            this.a.b = true;
        }
    }
}
