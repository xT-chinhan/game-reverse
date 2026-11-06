package com.bytedance.sdk.component.xr.ms.xr;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class ms implements ah, xr, Cloneable, ByteChannel {
    private static final byte[] ah = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    c f1629ms;
    long xr;

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public boolean ms() {
        return this.xr == 0;
    }

    public byte xr() {
        if (this.xr == 0) {
            throw new IllegalStateException("size == 0");
        }
        c cVar = this.f1629ms;
        int i = cVar.xr;
        int i2 = cVar.ah;
        int i3 = i + 1;
        byte b = cVar.f1626ms[i];
        this.xr--;
        if (i3 == i2) {
            this.f1629ms = cVar.xr();
            ab.ms(cVar);
        } else {
            cVar.xr = i3;
        }
        return b;
    }

    public String ah() {
        try {
            return ms(this.xr, ch.f1627ms);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String ms(long j, Charset charset) throws EOFException {
        ch.ms(this.xr, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return "";
        }
        c cVar = this.f1629ms;
        if (((long) cVar.xr) + j > cVar.ah) {
            return new String(ms(j), charset);
        }
        String str = new String(cVar.f1626ms, cVar.xr, (int) j, charset);
        cVar.xr = (int) (((long) cVar.xr) + j);
        this.xr -= j;
        if (cVar.xr == cVar.ah) {
            this.f1629ms = cVar.xr();
            ab.ms(cVar);
        }
        return str;
    }

    public byte[] ms(long j) throws EOFException {
        ch.ms(this.xr, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        byte[] bArr = new byte[(int) j];
        ms(bArr);
        return bArr;
    }

    public void ms(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int iMs = ms(bArr, i, bArr.length - i);
            if (iMs == -1) {
                throw new EOFException();
            }
            i += iMs;
        }
    }

    public int ms(byte[] bArr, int i, int i2) {
        ch.ms(bArr.length, i, i2);
        c cVar = this.f1629ms;
        if (cVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, cVar.ah - cVar.xr);
        System.arraycopy(cVar.f1626ms, cVar.xr, bArr, i, iMin);
        cVar.xr += iMin;
        this.xr -= (long) iMin;
        if (cVar.xr == cVar.ah) {
            this.f1629ms = cVar.xr();
            ab.ms(cVar);
        }
        return iMin;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        c cVar = this.f1629ms;
        if (cVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), cVar.ah - cVar.xr);
        byteBuffer.put(cVar.f1626ms, cVar.xr, iMin);
        cVar.xr += iMin;
        this.xr -= (long) iMin;
        if (cVar.xr == cVar.ah) {
            this.f1629ms = cVar.xr();
            ab.ms(cVar);
        }
        return iMin;
    }

    public ms ms(String str) {
        return ms(str, 0, str.length());
    }

    public ms ms(String str, int i, int i2) {
        char cCharAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: ".concat(String.valueOf(i)));
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        while (i < i2) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 128) {
                c cVarAh = ah(1);
                byte[] bArr = cVarAh.f1626ms;
                int i3 = cVarAh.ah - i;
                int iMin = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) cCharAt2;
                while (true) {
                    i = i4;
                    if (i >= iMin || (cCharAt = str.charAt(i)) >= 128) {
                        break;
                    }
                    i4 = i + 1;
                    bArr[i + i3] = (byte) cCharAt;
                }
                int i5 = (i3 + i) - cVarAh.ah;
                cVarAh.ah += i5;
                this.xr += (long) i5;
            } else {
                if (cCharAt2 < 2048) {
                    xr((cCharAt2 >> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
                    xr((cCharAt2 & '?') | 128);
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    xr((cCharAt2 >> '\f') | 224);
                    xr(((cCharAt2 >> 6) & 63) | 128);
                    xr((cCharAt2 & '?') | 128);
                } else {
                    int i6 = i + 1;
                    char cCharAt3 = i6 < i2 ? str.charAt(i6) : (char) 0;
                    if (cCharAt2 > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                        xr(63);
                        i = i6;
                    } else {
                        int i7 = (((cCharAt2 & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                        xr((i7 >> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                        xr(((i7 >> 12) & 63) | 128);
                        xr(((i7 >> 6) & 63) | 128);
                        xr((i7 & 63) | 128);
                        i += 2;
                    }
                }
                i++;
            }
        }
        return this;
    }

    public ms ms(int i) {
        if (i < 128) {
            xr(i);
        } else if (i < 2048) {
            xr((i >> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
            xr((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                xr(63);
            } else {
                xr((i >> 12) | 224);
                xr(((i >> 6) & 63) | 128);
                xr((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            xr((i >> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
            xr(((i >> 12) & 63) | 128);
            xr(((i >> 6) & 63) | 128);
            xr((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public ms ms(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: ".concat(String.valueOf(i)));
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (charset.equals(ch.f1627ms)) {
            return ms(str, i, i2);
        }
        byte[] bytes = str.substring(i, i2).getBytes(charset);
        return xr(bytes, 0, bytes.length);
    }

    public ms xr(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        ch.ms(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            c cVarAh = ah(1);
            int iMin = Math.min(i3 - i, 8192 - cVarAh.ah);
            System.arraycopy(bArr, i, cVarAh.f1626ms, cVarAh.ah, iMin);
            i += iMin;
            cVarAh.ah += iMin;
        }
        this.xr += j;
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            c cVarAh = ah(1);
            int iMin = Math.min(i, 8192 - cVarAh.ah);
            byteBuffer.get(cVarAh.f1626ms, cVarAh.ah, iMin);
            i -= iMin;
            cVarAh.ah += iMin;
        }
        this.xr += (long) iRemaining;
        return iRemaining;
    }

    public ms xr(int i) {
        c cVarAh = ah(1);
        byte[] bArr = cVarAh.f1626ms;
        int i2 = cVarAh.ah;
        cVarAh.ah = i2 + 1;
        bArr[i2] = (byte) i;
        this.xr++;
        return this;
    }

    public ms xr(long j) {
        if (j == 0) {
            return xr(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        c cVarAh = ah(iNumberOfTrailingZeros);
        byte[] bArr = cVarAh.f1626ms;
        int i = cVarAh.ah;
        for (int i2 = (cVarAh.ah + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = ah[(int) (15 & j)];
            j >>>= 4;
        }
        cVarAh.ah += iNumberOfTrailingZeros;
        this.xr += (long) iNumberOfTrailingZeros;
        return this;
    }

    c ah(int i) {
        if (i <= 0 || i > 8192) {
            throw new IllegalArgumentException();
        }
        c cVar = this.f1629ms;
        if (cVar == null) {
            c cVarMs = ab.ms();
            this.f1629ms = cVarMs;
            cVarMs.ab = cVarMs;
            cVarMs.c = cVarMs;
            return cVarMs;
        }
        c cVar2 = cVar.ab;
        return (cVar2.ah + i > 8192 || !cVar2.ka) ? cVar2.ms(ab.ms()) : cVar2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ms)) {
            return false;
        }
        ms msVar = (ms) obj;
        long j = this.xr;
        if (j != msVar.xr) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        c cVar = this.f1629ms;
        c cVar2 = msVar.f1629ms;
        int i = cVar.xr;
        int i2 = cVar2.xr;
        while (j2 < this.xr) {
            long jMin = Math.min(cVar.ah - i, cVar2.ah - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (cVar.f1626ms[i] != cVar2.f1626ms[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == cVar.ah) {
                cVar = cVar.c;
                i = cVar.xr;
            }
            if (i2 == cVar2.ah) {
                cVar2 = cVar2.c;
                i2 = cVar2.xr;
            }
            j2 += jMin;
        }
        return true;
    }

    public int hashCode() {
        c cVar = this.f1629ms;
        if (cVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = cVar.ah;
            for (int i3 = cVar.xr; i3 < i2; i3++) {
                i = (i * 31) + cVar.f1626ms[i3];
            }
            cVar = cVar.c;
        } while (cVar != this.f1629ms);
        return i;
    }

    public String toString() {
        return ka().toString();
    }

    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ms clone() {
        ms msVar = new ms();
        if (this.xr == 0) {
            return msVar;
        }
        c cVarMs = this.f1629ms.ms();
        msVar.f1629ms = cVarMs;
        cVarMs.ab = cVarMs;
        cVarMs.c = cVarMs;
        c cVar = this.f1629ms;
        while (true) {
            cVar = cVar.c;
            if (cVar != this.f1629ms) {
                msVar.f1629ms.ab.ms(cVar.ms());
            } else {
                msVar.xr = this.xr;
                return msVar;
            }
        }
    }

    public final d ka() {
        long j = this.xr;
        if (j > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.xr);
        }
        return d((int) j);
    }

    public final d d(int i) {
        if (i == 0) {
            return d.ah;
        }
        return new x(this, i);
    }
}
