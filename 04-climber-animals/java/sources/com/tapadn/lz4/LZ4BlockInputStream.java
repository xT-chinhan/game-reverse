package com.tapadn.lz4;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapadn.util.SafeUtils;
import com.tapadn.xxhash.XXHashFactory;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Checksum;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public class LZ4BlockInputStream extends FilterInputStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private byte[] buffer;
    private final Checksum checksum;
    private byte[] compressedBuffer;
    private final LZ4FastDecompressor decompressor;
    private boolean finished;
    private int o;
    private int originalLen;
    private final boolean stopOnEmptyBlock;

    public LZ4BlockInputStream(InputStream inputStream) {
        this(inputStream, LZ4Factory.fastestInstance().fastDecompressor());
    }

    public LZ4BlockInputStream(InputStream inputStream, LZ4FastDecompressor lZ4FastDecompressor) {
        this(inputStream, lZ4FastDecompressor, XXHashFactory.fastestInstance().newStreamingHash32(-1756908916).asChecksum(), true);
    }

    public LZ4BlockInputStream(InputStream inputStream, LZ4FastDecompressor lZ4FastDecompressor, Checksum checksum) {
        this(inputStream, lZ4FastDecompressor, checksum, true);
    }

    public LZ4BlockInputStream(InputStream inputStream, LZ4FastDecompressor lZ4FastDecompressor, Checksum checksum, boolean z) {
        super(inputStream);
        this.decompressor = lZ4FastDecompressor;
        this.checksum = checksum;
        this.stopOnEmptyBlock = z;
        this.buffer = new byte[0];
        this.compressedBuffer = new byte[LZ4BlockOutputStream.HEADER_LENGTH];
        this.originalLen = 0;
        this.o = 0;
        this.finished = false;
    }

    public LZ4BlockInputStream(InputStream inputStream, boolean z) {
        this(inputStream, LZ4Factory.fastestInstance().fastDecompressor(), XXHashFactory.fastestInstance().newStreamingHash32(-1756908916).asChecksum(), z);
    }

    private void readFully(byte[] bArr, int i) throws IOException {
        if (!tryReadFully(bArr, i)) {
            throw new EOFException("Stream ended prematurely");
        }
    }

    private void refill() throws IOException {
        if (!tryReadFully(this.compressedBuffer, LZ4BlockOutputStream.HEADER_LENGTH)) {
            if (this.stopOnEmptyBlock) {
                throw new EOFException("Stream ended prematurely");
            }
            this.finished = true;
            return;
        }
        int i = 0;
        while (true) {
            int i2 = LZ4BlockOutputStream.MAGIC_LENGTH;
            if (i >= i2) {
                byte[] bArr = this.compressedBuffer;
                int i3 = bArr[i2] & UByte.MAX_VALUE;
                int i4 = i3 & MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA;
                int i5 = (i3 & 15) + 10;
                if (i4 != 16 && i4 != 32) {
                    throw new IOException("Stream is corrupted");
                }
                int intLE = SafeUtils.readIntLE(bArr, LZ4BlockOutputStream.MAGIC_LENGTH + 1);
                this.originalLen = SafeUtils.readIntLE(this.compressedBuffer, LZ4BlockOutputStream.MAGIC_LENGTH + 5);
                int intLE2 = SafeUtils.readIntLE(this.compressedBuffer, LZ4BlockOutputStream.MAGIC_LENGTH + 9);
                int i6 = this.originalLen;
                if (i6 > (1 << i5) || i6 < 0 || intLE < 0 || ((i6 == 0 && intLE != 0) || ((i6 != 0 && intLE == 0) || (i4 == 16 && i6 != intLE)))) {
                    throw new IOException("Stream is corrupted");
                }
                if (i6 == 0 && intLE == 0) {
                    if (intLE2 != 0) {
                        throw new IOException("Stream is corrupted");
                    }
                    if (this.stopOnEmptyBlock) {
                        this.finished = true;
                        return;
                    } else {
                        refill();
                        return;
                    }
                }
                byte[] bArr2 = this.buffer;
                if (bArr2.length < i6) {
                    this.buffer = new byte[Math.max(i6, (bArr2.length * 3) / 2)];
                }
                if (i4 == 16) {
                    readFully(this.buffer, this.originalLen);
                } else {
                    if (i4 != 32) {
                        throw new AssertionError();
                    }
                    byte[] bArr3 = this.compressedBuffer;
                    if (bArr3.length < intLE) {
                        this.compressedBuffer = new byte[Math.max(intLE, (bArr3.length * 3) / 2)];
                    }
                    readFully(this.compressedBuffer, intLE);
                    try {
                        if (intLE != this.decompressor.decompress(this.compressedBuffer, 0, this.buffer, 0, this.originalLen)) {
                            throw new IOException("Stream is corrupted");
                        }
                    } catch (LZ4Exception e) {
                        throw new IOException("Stream is corrupted", e);
                    }
                }
                this.checksum.reset();
                this.checksum.update(this.buffer, 0, this.originalLen);
                if (((int) this.checksum.getValue()) != intLE2) {
                    throw new IOException("Stream is corrupted");
                }
                this.o = 0;
                return;
            }
            if (this.compressedBuffer[i] != LZ4BlockOutputStream.MAGIC[i]) {
                throw new IOException("Stream is corrupted");
            }
            i++;
        }
    }

    private boolean tryReadFully(byte[] bArr, int i) throws IOException {
        int i2 = 0;
        while (i2 < i) {
            int i3 = ((FilterInputStream) this).in.read(bArr, i2, i - i2);
            if (i3 < 0) {
                return false;
            }
            i2 += i3;
        }
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return this.originalLen - this.o;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.finished) {
            return -1;
        }
        if (this.o == this.originalLen) {
            refill();
        }
        if (this.finished) {
            return -1;
        }
        byte[] bArr = this.buffer;
        int i = this.o;
        this.o = i + 1;
        return bArr[i] & UByte.MAX_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        SafeUtils.checkRange(bArr, i, i2);
        if (this.finished) {
            return -1;
        }
        if (this.o == this.originalLen) {
            refill();
        }
        if (this.finished) {
            return -1;
        }
        int iMin = Math.min(i2, this.originalLen - this.o);
        System.arraycopy(this.buffer, this.o, bArr, i, iMin);
        this.o += iMin;
        return iMin;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new IOException("mark/reset not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        if (j <= 0 || this.finished) {
            return 0L;
        }
        if (this.o == this.originalLen) {
            refill();
        }
        if (this.finished) {
            return 0L;
        }
        int iMin = (int) Math.min(j, this.originalLen - this.o);
        this.o += iMin;
        return iMin;
    }

    public String toString() {
        return "LZ4BlockInputStream(in=" + ((FilterInputStream) this).in + ", decompressor=" + this.decompressor + ", checksum=" + this.checksum + ")";
    }
}
