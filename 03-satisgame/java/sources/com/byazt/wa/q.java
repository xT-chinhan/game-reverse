package com.byazt.wa;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes2.dex */
public interface q extends cd, WritableByteChannel {
    q cp(long j) throws IOException;

    q d(long j) throws IOException;

    @Override // com.byazt.wa.cd, java.io.Flushable
    void flush() throws IOException;

    q fs(int i) throws IOException;

    q py() throws IOException;

    q qg(w wVar) throws IOException;

    q qg(String str) throws IOException;

    q rv(int i) throws IOException;

    q s(byte[] bArr) throws IOException;

    q s(byte[] bArr, int i, int i2) throws IOException;

    s s();

    q x(int i) throws IOException;
}
