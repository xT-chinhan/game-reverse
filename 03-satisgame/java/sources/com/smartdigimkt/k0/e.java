package com.smartdigimkt.k0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes3.dex */
public interface e {
    public static final ByteBuffer a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    ByteBuffer a();

    void a(ByteBuffer byteBuffer);

    boolean a(int i, int i2, int i3);

    boolean b();

    int c();

    int d();

    void e();

    int f();

    void flush();

    boolean g();

    void h();
}
