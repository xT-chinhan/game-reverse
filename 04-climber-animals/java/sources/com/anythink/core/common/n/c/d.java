package com.anythink.core.common.n.c;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public interface d extends v, WritableByteChannel {
    d A();

    long a(w wVar);

    d a(w wVar, long j);

    d b(String str);

    d b(String str, int i, int i2);

    d b(String str, int i, int i2, Charset charset);

    d b(String str, Charset charset);

    c c();

    d c(byte[] bArr, int i, int i2);

    d d(f fVar);

    d d(byte[] bArr);

    OutputStream e();

    d f();

    @Override // com.anythink.core.common.n.c.v, java.io.Flushable
    void flush();

    d h(int i);

    d i(int i);

    d j(int i);

    d k(int i);

    d l(int i);

    d m(int i);

    d n(long j);

    d o(long j);

    d p(long j);

    d q(long j);
}
