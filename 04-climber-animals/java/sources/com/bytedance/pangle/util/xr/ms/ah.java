package com.bytedance.pangle.util.xr.ms;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final byte[] f704ms = new byte[2];
    private final byte[] xr = new byte[4];

    public int ms(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.xr);
        return xr(this.xr);
    }

    public int xr(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.f704ms);
        return ms(this.f704ms);
    }

    public void ms(RandomAccessFile randomAccessFile, int i) throws IOException {
        ms(this.f704ms, i);
        randomAccessFile.write(this.f704ms);
    }

    public void ms(ByteArrayOutputStream byteArrayOutputStream, int i) throws IOException {
        ms(this.f704ms, i);
        byteArrayOutputStream.write(this.f704ms);
    }

    public void ms(OutputStream outputStream, int i) throws IOException {
        xr(this.xr, i);
        outputStream.write(this.xr);
    }

    private int ms(byte[] bArr) {
        return ((bArr[1] & UByte.MAX_VALUE) << 8) | (bArr[0] & UByte.MAX_VALUE);
    }

    private int xr(byte[] bArr) {
        return ((((bArr[3] & UByte.MAX_VALUE) << 8) | (bArr[2] & UByte.MAX_VALUE)) << 16) | (bArr[0] & UByte.MAX_VALUE) | ((bArr[1] & UByte.MAX_VALUE) << 8);
    }

    private void ms(byte[] bArr, int i) {
        bArr[1] = (byte) (i >>> 8);
        bArr[0] = (byte) (i & 255);
    }

    private void xr(byte[] bArr, int i) {
        bArr[3] = (byte) (i >>> 24);
        bArr[2] = (byte) (i >>> 16);
        bArr[1] = (byte) (i >>> 8);
        bArr[0] = (byte) (i & 255);
    }
}
