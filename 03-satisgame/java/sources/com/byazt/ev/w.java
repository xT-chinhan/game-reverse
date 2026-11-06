package com.byazt.ev;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.io.DataInput;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, 13})
public abstract class w implements DataInput {
    public final rv n;

    public w(rv rvVar) {
        this.n = rvVar;
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) throws IOException {
        return this.n.skipBytes(i);
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        return this.n.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        return this.n.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        return this.n.readUTF();
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        return this.n.readShort();
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        return this.n.readLong();
    }

    @Override // java.io.DataInput
    public String readLine() throws IOException {
        return this.n.readLine();
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        return this.n.readInt();
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        this.n.readFully(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        this.n.readFully(bArr);
    }

    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        return this.n.readFloat();
    }

    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        return this.n.readDouble();
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        return this.n.readChar();
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        return this.n.readByte();
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        return this.n.readBoolean();
    }
}
