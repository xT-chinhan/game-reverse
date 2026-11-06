package com.byazt.rm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2349, 20})
public class hn {
    public final byte[] pr = new byte[2];
    public final byte[] hw = new byte[4];

    public int pr(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.hw);
        return hw(this.hw);
    }

    public int hw(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.pr);
        return pr(this.pr);
    }

    public void pr(RandomAccessFile randomAccessFile, int i) throws IOException {
        pr(this.pr, i);
        randomAccessFile.write(this.pr);
    }

    public void pr(ByteArrayOutputStream byteArrayOutputStream, int i) throws IOException {
        pr(this.pr, i);
        byteArrayOutputStream.write(this.pr);
    }

    public void pr(OutputStream outputStream, int i) throws IOException {
        hw(this.hw, i);
        outputStream.write(this.hw);
    }

    private int pr(byte[] bArr) {
        return ((bArr[1] & UByte.MAX_VALUE) << 8) | (bArr[0] & UByte.MAX_VALUE);
    }

    private int hw(byte[] bArr) {
        return ((((bArr[3] & UByte.MAX_VALUE) << 8) | (bArr[2] & UByte.MAX_VALUE)) << 16) | (bArr[0] & UByte.MAX_VALUE) | ((bArr[1] & UByte.MAX_VALUE) << 8);
    }

    private void pr(byte[] bArr, int i) {
        bArr[1] = (byte) (i >>> 8);
        bArr[0] = (byte) (i & 255);
    }

    private void hw(byte[] bArr, int i) {
        bArr[3] = (byte) (i >>> 24);
        bArr[2] = (byte) (i >>> 16);
        bArr[1] = (byte) (i >>> 8);
        bArr[0] = (byte) (i & 255);
    }
}
