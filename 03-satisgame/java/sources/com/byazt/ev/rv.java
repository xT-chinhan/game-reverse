package com.byazt.ev;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public final class rv extends FilterInputStream implements DataInput {
    public static int n(byte b, byte b2, byte b3, byte b4) {
        return (b << 24) | ((b2 & UByte.MAX_VALUE) << 16) | ((b3 & UByte.MAX_VALUE) << 8) | (b4 & UByte.MAX_VALUE);
    }

    public static long n(byte b, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8) {
        return ((((long) b2) & 255) << 48) | ((((long) b) & 255) << 56) | ((((long) b3) & 255) << 40) | ((((long) b4) & 255) << 32) | ((((long) b5) & 255) << 24) | ((((long) b6) & 255) << 16) | ((((long) b7) & 255) << 8) | (((long) b8) & 255);
    }

    public rv(l lVar) {
        super(lVar);
    }

    @Override // java.io.DataInput
    public String readLine() {
        throw new UnsupportedOperationException("readLine is not supported");
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        q.n(this, bArr);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        q.n(this, bArr, i, i2);
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
        return n((byte) 0, (byte) 0, qg(), qg());
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        byte bQg = qg();
        byte bQg2 = qg();
        return n(qg(), qg(), bQg2, bQg);
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        byte bQg = qg();
        byte bQg2 = qg();
        byte bQg3 = qg();
        byte bQg4 = qg();
        byte bQg5 = qg();
        byte bQg6 = qg();
        return n(qg(), qg(), bQg6, bQg5, bQg4, bQg3, bQg2, bQg);
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

    private byte qg() throws IOException {
        int i = this.in.read();
        if (-1 != i) {
            return (byte) i;
        }
        throw new EOFException();
    }

    public l n() {
        return (l) this.in;
    }
}
