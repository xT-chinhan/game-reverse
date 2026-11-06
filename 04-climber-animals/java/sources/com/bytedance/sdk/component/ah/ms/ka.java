package com.bytedance.sdk.component.ah.ms;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public interface ka extends y, ReadableByteChannel {
    byte[] ab(long j) throws IOException;

    @Deprecated
    ah ah();

    c ah(long j) throws IOException;

    String ao() throws IOException;

    InputStream c();

    int ch() throws IOException;

    byte[] h() throws IOException;

    short hi() throws IOException;

    String ka(long j) throws IOException;

    boolean ka() throws IOException;

    long ms(byte b) throws IOException;

    String ms(Charset charset) throws IOException;

    void ms(long j) throws IOException;

    void ms(byte[] bArr) throws IOException;

    boolean ms(long j, c cVar) throws IOException;

    short ny() throws IOException;

    int sl() throws IOException;

    byte x() throws IOException;

    void x(long j) throws IOException;

    long zb() throws IOException;
}
