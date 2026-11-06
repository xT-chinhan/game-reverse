package com.bytedance.pangle.res.ms;

import java.io.DataInput;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements DataInput {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final ny f676ms;

    public c(ny nyVar) {
        this.f676ms = nyVar;
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) throws IOException {
        return this.f676ms.skipBytes(i);
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        return this.f676ms.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        return this.f676ms.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        return this.f676ms.readUTF();
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        return this.f676ms.readShort();
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        return this.f676ms.readLong();
    }

    @Override // java.io.DataInput
    public String readLine() throws IOException {
        return this.f676ms.readLine();
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        return this.f676ms.readInt();
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        this.f676ms.readFully(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        this.f676ms.readFully(bArr);
    }

    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        return this.f676ms.readFloat();
    }

    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        return this.f676ms.readDouble();
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        return this.f676ms.readChar();
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        return this.f676ms.readByte();
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        return this.f676ms.readBoolean();
    }
}
