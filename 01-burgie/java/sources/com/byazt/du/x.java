package com.byazt.du;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes.dex */
public interface x extends lb, WritableByteChannel {
    x aj(int i) throws IOException;

    x cz() throws IOException;

    @Override // com.byazt.du.lb, java.io.Flushable
    void flush() throws IOException;

    x fw(int i) throws IOException;

    hn hn();

    x hn(byte[] bArr) throws IOException;

    x hn(byte[] bArr, int i, int i2) throws IOException;

    x hw(uc ucVar) throws IOException;

    x hw(String str) throws IOException;

    x k(long j) throws IOException;

    x w(long j) throws IOException;

    x zo(int i) throws IOException;
}
