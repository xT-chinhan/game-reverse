package com.byazt.kq;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1391, 8})
public class s {
    public final byte[] n = new byte[2];
    public final byte[] qg = new byte[4];

    public int n(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.qg);
        return qg(this.qg);
    }

    public int qg(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.n);
        return n(this.n);
    }

    public void n(RandomAccessFile randomAccessFile, int i) throws IOException {
        n(this.n, i);
        randomAccessFile.write(this.n);
    }

    public void n(ByteArrayOutputStream byteArrayOutputStream, int i) throws IOException {
        n(this.n, i);
        byteArrayOutputStream.write(this.n);
    }

    public void n(OutputStream outputStream, int i) throws IOException {
        qg(this.qg, i);
        outputStream.write(this.qg);
    }

    private int n(byte[] bArr) {
        return ((bArr[1] & UByte.MAX_VALUE) << 8) | (bArr[0] & UByte.MAX_VALUE);
    }

    private int qg(byte[] bArr) {
        return ((((bArr[3] & UByte.MAX_VALUE) << 8) | (bArr[2] & UByte.MAX_VALUE)) << 16) | (bArr[0] & UByte.MAX_VALUE) | ((bArr[1] & UByte.MAX_VALUE) << 8);
    }

    private void n(byte[] bArr, int i) {
        bArr[1] = (byte) (i >>> 8);
        bArr[0] = (byte) (i & 255);
    }

    private void qg(byte[] bArr, int i) {
        bArr[3] = (byte) (i >>> 24);
        bArr[2] = (byte) (i >>> 16);
        bArr[1] = (byte) (i >>> 8);
        bArr[0] = (byte) (i & 255);
    }
}
