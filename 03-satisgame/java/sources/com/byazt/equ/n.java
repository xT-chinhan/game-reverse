package com.byazt.equ;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 777, 19})
public final class n implements qg, s, Cloneable, ByteChannel {
    public static final byte[] s = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    public w n;
    public long qg;

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

    public boolean n() {
        return this.qg == 0;
    }

    public byte qg() {
        if (this.qg == 0) {
            throw new IllegalStateException("size == 0");
        }
        w wVar = this.n;
        int i = wVar.qg;
        int i2 = wVar.s;
        int i3 = i + 1;
        byte b = wVar.n[i];
        this.qg--;
        if (i3 == i2) {
            this.n = wVar.qg();
            x.n(wVar);
        } else {
            wVar.qg = i3;
        }
        return b;
    }

    public String s() {
        try {
            return n(this.qg, tj.n);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String n(long j, Charset charset) throws EOFException {
        tj.n(this.qg, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return "";
        }
        w wVar = this.n;
        if (((long) wVar.qg) + j > wVar.s) {
            return new String(n(j), charset);
        }
        String str = new String(wVar.n, wVar.qg, (int) j, charset);
        wVar.qg = (int) (((long) wVar.qg) + j);
        this.qg -= j;
        if (wVar.qg == wVar.s) {
            this.n = wVar.qg();
            x.n(wVar);
        }
        return str;
    }

    public byte[] n(long j) throws EOFException {
        tj.n(this.qg, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        byte[] bArr = new byte[(int) j];
        n(bArr);
        return bArr;
    }

    public void n(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int iN = n(bArr, i, bArr.length - i);
            if (iN == -1) {
                throw new EOFException();
            }
            i += iN;
        }
    }

    public int n(byte[] bArr, int i, int i2) {
        tj.n(bArr.length, i, i2);
        w wVar = this.n;
        if (wVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, wVar.s - wVar.qg);
        System.arraycopy(wVar.n, wVar.qg, bArr, i, iMin);
        wVar.qg += iMin;
        this.qg -= (long) iMin;
        if (wVar.qg == wVar.s) {
            this.n = wVar.qg();
            x.n(wVar);
        }
        return iMin;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        w wVar = this.n;
        if (wVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), wVar.s - wVar.qg);
        byteBuffer.put(wVar.n, wVar.qg, iMin);
        wVar.qg += iMin;
        this.qg -= (long) iMin;
        if (wVar.qg == wVar.s) {
            this.n = wVar.qg();
            x.n(wVar);
        }
        return iMin;
    }

    public n n(String str) {
        return n(str, 0, str.length());
    }

    public n n(String str, int i, int i2) {
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
                w wVarS = s(1);
                byte[] bArr = wVarS.n;
                int i3 = wVarS.s - i;
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
                int i5 = (i3 + i) - wVarS.s;
                wVarS.s += i5;
                this.qg += (long) i5;
            } else {
                if (cCharAt2 < 2048) {
                    qg((cCharAt2 >> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
                    qg((cCharAt2 & '?') | 128);
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    qg((cCharAt2 >> '\f') | 224);
                    qg(((cCharAt2 >> 6) & 63) | 128);
                    qg((cCharAt2 & '?') | 128);
                } else {
                    int i6 = i + 1;
                    char cCharAt3 = i6 < i2 ? str.charAt(i6) : (char) 0;
                    if (cCharAt2 > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                        qg(63);
                        i = i6;
                    } else {
                        int i7 = (((cCharAt2 & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                        qg((i7 >> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                        qg(((i7 >> 12) & 63) | 128);
                        qg(((i7 >> 6) & 63) | 128);
                        qg((i7 & 63) | 128);
                        i += 2;
                    }
                }
                i++;
            }
        }
        return this;
    }

    public n n(int i) {
        if (i < 128) {
            qg(i);
        } else if (i < 2048) {
            qg((i >> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
            qg((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                qg(63);
            } else {
                qg((i >> 12) | 224);
                qg(((i >> 6) & 63) | 128);
                qg((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            qg((i >> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
            qg(((i >> 12) & 63) | 128);
            qg(((i >> 6) & 63) | 128);
            qg((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public n n(String str, int i, int i2, Charset charset) {
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
        if (charset.equals(tj.n)) {
            return n(str, i, i2);
        }
        byte[] bytes = str.substring(i, i2).getBytes(charset);
        return qg(bytes, 0, bytes.length);
    }

    public n qg(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        tj.n(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            w wVarS = s(1);
            int iMin = Math.min(i3 - i, 8192 - wVarS.s);
            System.arraycopy(bArr, i, wVarS.n, wVarS.s, iMin);
            i += iMin;
            wVarS.s += iMin;
        }
        this.qg += j;
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
            w wVarS = s(1);
            int iMin = Math.min(i, 8192 - wVarS.s);
            byteBuffer.get(wVarS.n, wVarS.s, iMin);
            i -= iMin;
            wVarS.s += iMin;
        }
        this.qg += (long) iRemaining;
        return iRemaining;
    }

    public n qg(int i) {
        w wVarS = s(1);
        byte[] bArr = wVarS.n;
        int i2 = wVarS.s;
        wVarS.s = i2 + 1;
        bArr[i2] = (byte) i;
        this.qg++;
        return this;
    }

    public n qg(long j) {
        if (j == 0) {
            return qg(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        w wVarS = s(iNumberOfTrailingZeros);
        byte[] bArr = wVarS.n;
        int i = wVarS.s;
        for (int i2 = (wVarS.s + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = s[(int) (15 & j)];
            j >>>= 4;
        }
        wVarS.s += iNumberOfTrailingZeros;
        this.qg += (long) iNumberOfTrailingZeros;
        return this;
    }

    public w s(int i) {
        if (i <= 0 || i > 8192) {
            throw new IllegalArgumentException();
        }
        w wVar = this.n;
        if (wVar == null) {
            w wVarN = x.n();
            this.n = wVarN;
            wVarN.x = wVarN;
            wVarN.w = wVarN;
            return wVarN;
        }
        w wVar2 = wVar.x;
        return (wVar2.s + i > 8192 || !wVar2.l) ? wVar2.n(x.n()) : wVar2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        long j = this.qg;
        if (j != nVar.qg) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        w wVar = this.n;
        w wVar2 = nVar.n;
        int i = wVar.qg;
        int i2 = wVar2.qg;
        while (j2 < this.qg) {
            long jMin = Math.min(wVar.s - i, wVar2.s - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (wVar.n[i] != wVar2.n[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == wVar.s) {
                wVar = wVar.w;
                i = wVar.qg;
            }
            if (i2 == wVar2.s) {
                wVar2 = wVar2.w;
                i2 = wVar2.qg;
            }
            j2 += jMin;
        }
        return true;
    }

    public int hashCode() {
        w wVar = this.n;
        if (wVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = wVar.s;
            for (int i3 = wVar.qg; i3 < i2; i3++) {
                i = (i * 31) + wVar.n[i3];
            }
            wVar = wVar.w;
        } while (wVar != this.n);
        return i;
    }

    public String toString() {
        return l().toString();
    }

    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public n clone() {
        n nVar = new n();
        if (this.qg == 0) {
            return nVar;
        }
        w wVarN = this.n.n();
        nVar.n = wVarN;
        wVarN.x = wVarN;
        wVarN.w = wVarN;
        w wVar = this.n;
        while (true) {
            wVar = wVar.w;
            if (wVar != this.n) {
                nVar.n.x.n(wVar.n());
            } else {
                nVar.qg = this.qg;
                return nVar;
            }
        }
    }

    public final q l() {
        long j = this.qg;
        if (j > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.qg);
        }
        return q((int) j);
    }

    public final q q(int i) {
        if (i == 0) {
            return q.s;
        }
        return new fs(this, i);
    }
}
