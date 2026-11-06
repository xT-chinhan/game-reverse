package com.byazt.du;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public interface c extends qa, ReadableByteChannel {
    short aj() throws IOException;

    String c(long j) throws IOException;

    boolean c() throws IOException;

    byte[] fw(long j) throws IOException;

    @Deprecated
    hn hn();

    uc hn(long j) throws IOException;

    int k() throws IOException;

    long m() throws IOException;

    String nt() throws IOException;

    long pr(byte b) throws IOException;

    String pr(Charset charset) throws IOException;

    void pr(long j) throws IOException;

    void pr(byte[] bArr) throws IOException;

    boolean pr(long j, uc ucVar) throws IOException;

    InputStream uc();

    int vk() throws IOException;

    short w() throws IOException;

    byte[] yb() throws IOException;

    byte zo() throws IOException;

    void zo(long j) throws IOException;
}
