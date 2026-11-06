package com.bytedance.pangle.res.ms;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public final class ny extends FilterInputStream implements DataInput {
    public static int ms(byte b, byte b2, byte b3, byte b4) {
        return (b << 24) | ((b2 & UByte.MAX_VALUE) << 16) | ((b3 & UByte.MAX_VALUE) << 8) | (b4 & UByte.MAX_VALUE);
    }

    public static long ms(byte b, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8) {
        return ((((long) b2) & 255) << 48) | ((((long) b) & 255) << 56) | ((((long) b3) & 255) << 40) | ((((long) b4) & 255) << 32) | ((((long) b5) & 255) << 24) | ((((long) b6) & 255) << 16) | ((((long) b7) & 255) << 8) | (((long) b8) & 255);
    }

    public ny(ka kaVar) {
        super(kaVar);
    }

    @Override // java.io.DataInput
    public String readLine() {
        throw new UnsupportedOperationException("readLine is not supported");
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        d.ms(this, bArr);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        d.ms(this, bArr, i, i2);
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) throws IOException {
        return (int) this.in.skip(i);
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        int i = this.in.read();
        if (i >= 0) {
            return i;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        return ms((byte) 0, (byte) 0, xr(), xr());
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        byte bXr = xr();
        byte bXr2 = xr();
        return ms(xr(), xr(), bXr2, bXr);
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        byte bXr = xr();
        byte bXr2 = xr();
        byte bXr3 = xr();
        byte bXr4 = xr();
        byte bXr5 = xr();
        byte bXr6 = xr();
        return ms(xr(), xr(), bXr6, bXr5, bXr4, bXr3, bXr2, bXr);
    }

    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        return new DataInputStream(this.in).readUTF();
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        return (short) readUnsignedShort();
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        return (char) readUnsignedShort();
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        return (byte) readUnsignedByte();
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        return readUnsignedByte() != 0;
    }

    private byte xr() throws IOException {
        int i = this.in.read();
        if (-1 != i) {
            return (byte) i;
        }
        throw new EOFException();
    }

    public ka ms() {
        return (ka) this.in;
    }
}
