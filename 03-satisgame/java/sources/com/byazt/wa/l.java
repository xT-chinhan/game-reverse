package com.byazt.wa;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public interface l extends um, ReadableByteChannel {
    short cp() throws IOException;

    String cy() throws IOException;

    int d() throws IOException;

    byte fs() throws IOException;

    void fs(long j) throws IOException;

    byte[] hd() throws IOException;

    String l(long j) throws IOException;

    boolean l() throws IOException;

    long n(byte b) throws IOException;

    String n(Charset charset) throws IOException;

    void n(long j) throws IOException;

    void n(byte[] bArr) throws IOException;

    boolean n(long j, w wVar) throws IOException;

    long oa() throws IOException;

    short rv() throws IOException;

    @Deprecated
    s s();

    w s(long j) throws IOException;

    int tj() throws IOException;

    InputStream w();

    byte[] x(long j) throws IOException;
}
