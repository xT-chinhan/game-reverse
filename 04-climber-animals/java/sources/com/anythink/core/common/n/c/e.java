package com.anythink.core.common.n.c;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public interface e extends w, ReadableByteChannel {
    int a(o oVar);

    int a(byte[] bArr);

    int a(byte[] bArr, int i, int i2);

    long a(byte b);

    long a(byte b, long j);

    long a(byte b, long j, long j2);

    long a(f fVar, long j);

    long a(v vVar);

    String a(long j, Charset charset);

    String a(Charset charset);

    void a(long j);

    boolean a(long j, f fVar);

    boolean a(long j, f fVar, int i);

    long b(f fVar);

    long b(f fVar, long j);

    void b(c cVar, long j);

    void b(byte[] bArr);

    boolean b(long j);

    long c(f fVar);

    @Deprecated
    c c();

    c d();

    f d(long j);

    String e(long j);

    String f(long j);

    boolean g();

    e h();

    byte[] h(long j);

    InputStream i();

    void i(long j);

    byte k();

    short l();

    int m();

    long n();

    short o();

    int p();

    long q();

    long r();

    long s();

    f t();

    String u();

    String v();

    String w();

    int x();

    byte[] y();
}
