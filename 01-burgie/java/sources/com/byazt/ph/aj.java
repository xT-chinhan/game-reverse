package com.byazt.ph;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID, 61})
public final class aj extends FilterInputStream implements DataInput {
    public aj(c cVar) {
        super(cVar);
    }

    @Override // java.io.DataInput
    public String readLine() {
        throw new UnsupportedOperationException("readLine is not supported");
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        x.pr(this, bArr);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        x.pr(this, bArr, i, i2);
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) throws IOException {
        return (int) this.in.skip(i);
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        int i = this.in.read();
        if (i < 0) {
            throw new EOFException();
        }
        return i;
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        return pr((byte) 0, (byte) 0, hw(), hw());
    }

    public static int pr(byte b, byte b2, byte b3, byte b4) {
        return (b << 24) | ((b2 & UByte.MAX_VALUE) << 16) | ((b3 & UByte.MAX_VALUE) << 8) | (b4 & UByte.MAX_VALUE);
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        byte bHw = hw();
        byte bHw2 = hw();
        return pr(hw(), hw(), bHw2, bHw);
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        byte bHw = hw();
        byte bHw2 = hw();
        byte bHw3 = hw();
        byte bHw4 = hw();
        byte bHw5 = hw();
        byte bHw6 = hw();
        return pr(hw(), hw(), bHw6, bHw5, bHw4, bHw3, bHw2, bHw);
    }

    public static long pr(byte b, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8) {
        return ((((long) b2) & 255) << 48) | ((((long) b) & 255) << 56) | ((((long) b3) & 255) << 40) | ((((long) b4) & 255) << 32) | ((((long) b5) & 255) << 24) | ((((long) b6) & 255) << 16) | ((((long) b7) & 255) << 8) | (((long) b8) & 255);
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

    private byte hw() throws IOException {
        int i = this.in.read();
        if (-1 == i) {
            throw new EOFException();
        }
        return (byte) i;
    }

    public c pr() {
        return (c) this.in;
    }
}
