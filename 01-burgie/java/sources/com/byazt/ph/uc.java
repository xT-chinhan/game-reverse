package com.byazt.ph;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.DataInput;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID, 5})
public abstract class uc implements DataInput {
    public final aj pr;

    public uc(aj ajVar) {
        this.pr = ajVar;
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) throws IOException {
        return this.pr.skipBytes(i);
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        return this.pr.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        return this.pr.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        return this.pr.readUTF();
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        return this.pr.readShort();
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        return this.pr.readLong();
    }

    @Override // java.io.DataInput
    public String readLine() throws IOException {
        return this.pr.readLine();
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        return this.pr.readInt();
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        this.pr.readFully(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        this.pr.readFully(bArr);
    }

    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        return this.pr.readFloat();
    }

    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        return this.pr.readDouble();
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        return this.pr.readChar();
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        return this.pr.readByte();
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        return this.pr.readBoolean();
    }
}
