package com.byazt.qm;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2253, 37})
public final class pr implements hn, hw, Cloneable, ByteChannel {
    public static final byte[] hn = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    public long hw;
    public uc pr;

    public boolean pr() {
        return this.hw == 0;
    }

    public byte hw() {
        if (this.hw == 0) {
            throw new IllegalStateException("size == 0");
        }
        uc ucVar = this.pr;
        int i = ucVar.hw;
        int i2 = ucVar.hn;
        int i3 = i + 1;
        byte b = ucVar.pr[i];
        this.hw--;
        if (i3 == i2) {
            this.pr = ucVar.hw();
            fw.pr(ucVar);
        } else {
            ucVar.hw = i3;
        }
        return b;
    }

    public String hn() {
        try {
            return pr(this.hw, vk.pr);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String pr(long j, Charset charset) throws EOFException {
        vk.pr(this.hw, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return "";
        }
        uc ucVar = this.pr;
        if (((long) ucVar.hw) + j > ucVar.hn) {
            return new String(pr(j), charset);
        }
        String str = new String(ucVar.pr, ucVar.hw, (int) j, charset);
        ucVar.hw = (int) (((long) ucVar.hw) + j);
        this.hw -= j;
        if (ucVar.hw == ucVar.hn) {
            this.pr = ucVar.hw();
            fw.pr(ucVar);
        }
        return str;
    }

    public byte[] pr(long j) throws EOFException {
        vk.pr(this.hw, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        byte[] bArr = new byte[(int) j];
        pr(bArr);
        return bArr;
    }

    public void pr(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int iPr = pr(bArr, i, bArr.length - i);
            if (iPr == -1) {
                throw new EOFException();
            }
            i += iPr;
        }
    }

    public int pr(byte[] bArr, int i, int i2) {
        vk.pr(bArr.length, i, i2);
        uc ucVar = this.pr;
        if (ucVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, ucVar.hn - ucVar.hw);
        System.arraycopy(ucVar.pr, ucVar.hw, bArr, i, iMin);
        ucVar.hw += iMin;
        this.hw -= (long) iMin;
        if (ucVar.hw == ucVar.hn) {
            this.pr = ucVar.hw();
            fw.pr(ucVar);
        }
        return iMin;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        uc ucVar = this.pr;
        if (ucVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), ucVar.hn - ucVar.hw);
        byteBuffer.put(ucVar.pr, ucVar.hw, iMin);
        ucVar.hw += iMin;
        this.hw -= (long) iMin;
        if (ucVar.hw == ucVar.hn) {
            this.pr = ucVar.hw();
            fw.pr(ucVar);
        }
        return iMin;
    }

    public pr pr(String str) {
        return pr(str, 0, str.length());
    }

    public pr pr(String str, int i, int i2) {
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
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                uc ucVarHn = hn(1);
                byte[] bArr = ucVarHn.pr;
                int i3 = ucVarHn.hn - i;
                int iMin = Math.min(i2, 8192 - i3);
                bArr[i + i3] = (byte) cCharAt;
                i++;
                while (i < iMin) {
                    char cCharAt2 = str.charAt(i);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i + i3] = (byte) cCharAt2;
                    i++;
                }
                int i4 = (i3 + i) - ucVarHn.hn;
                ucVarHn.hn += i4;
                this.hw += (long) i4;
            } else if (cCharAt < 2048) {
                hw((cCharAt >> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
                hw((cCharAt & '?') | 128);
                i++;
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                hw((cCharAt >> '\f') | 224);
                hw(((cCharAt >> 6) & 63) | 128);
                hw((cCharAt & '?') | 128);
                i++;
            } else {
                int i5 = i + 1;
                char cCharAt3 = i5 < i2 ? str.charAt(i5) : (char) 0;
                if (cCharAt > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                    hw(63);
                    i = i5;
                } else {
                    int i6 = (((cCharAt & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                    hw((i6 >> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                    hw(((i6 >> 12) & 63) | 128);
                    hw(((i6 >> 6) & 63) | 128);
                    hw((i6 & 63) | 128);
                    i += 2;
                }
            }
        }
        return this;
    }

    public pr pr(int i) {
        if (i < 128) {
            hw(i);
        } else if (i < 2048) {
            hw((i >> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
            hw((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                hw(63);
            } else {
                hw((i >> 12) | 224);
                hw(((i >> 6) & 63) | 128);
                hw((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            hw((i >> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
            hw(((i >> 12) & 63) | 128);
            hw(((i >> 6) & 63) | 128);
            hw((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public pr pr(String str, int i, int i2, Charset charset) {
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
        if (charset.equals(vk.pr)) {
            return pr(str, i, i2);
        }
        byte[] bytes = str.substring(i, i2).getBytes(charset);
        return hw(bytes, 0, bytes.length);
    }

    public pr hw(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        vk.pr(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            uc ucVarHn = hn(1);
            int iMin = Math.min(i3 - i, 8192 - ucVarHn.hn);
            System.arraycopy(bArr, i, ucVarHn.pr, ucVarHn.hn, iMin);
            i += iMin;
            ucVarHn.hn += iMin;
        }
        this.hw += j;
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
            uc ucVarHn = hn(1);
            int iMin = Math.min(i, 8192 - ucVarHn.hn);
            byteBuffer.get(ucVarHn.pr, ucVarHn.hn, iMin);
            i -= iMin;
            ucVarHn.hn += iMin;
        }
        this.hw += (long) iRemaining;
        return iRemaining;
    }

    public pr hw(int i) {
        uc ucVarHn = hn(1);
        byte[] bArr = ucVarHn.pr;
        int i2 = ucVarHn.hn;
        ucVarHn.hn = i2 + 1;
        bArr[i2] = (byte) i;
        this.hw++;
        return this;
    }

    public pr hw(long j) {
        if (j == 0) {
            return hw(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        uc ucVarHn = hn(iNumberOfTrailingZeros);
        byte[] bArr = ucVarHn.pr;
        int i = ucVarHn.hn;
        for (int i2 = (ucVarHn.hn + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = hn[(int) (15 & j)];
            j >>>= 4;
        }
        ucVarHn.hn += iNumberOfTrailingZeros;
        this.hw += (long) iNumberOfTrailingZeros;
        return this;
    }

    public uc hn(int i) {
        if (i <= 0 || i > 8192) {
            throw new IllegalArgumentException();
        }
        uc ucVar = this.pr;
        if (ucVar == null) {
            uc ucVarPr = fw.pr();
            this.pr = ucVarPr;
            ucVarPr.fw = ucVarPr;
            ucVarPr.uc = ucVarPr;
            return ucVarPr;
        }
        uc ucVar2 = ucVar.fw;
        if (ucVar2.hn + i > 8192 || !ucVar2.c) {
            return ucVar2.pr(fw.pr());
        }
        return ucVar2;
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof pr)) {
            return false;
        }
        pr prVar = (pr) obj;
        long j = this.hw;
        if (j != prVar.hw) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        uc ucVar = this.pr;
        uc ucVar2 = prVar.pr;
        int i = ucVar.hw;
        int i2 = ucVar2.hw;
        while (j2 < this.hw) {
            long jMin = Math.min(ucVar.hn - i, ucVar2.hn - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (ucVar.pr[i] != ucVar2.pr[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == ucVar.hn) {
                ucVar = ucVar.uc;
                i = ucVar.hw;
            }
            if (i2 == ucVar2.hn) {
                ucVar2 = ucVar2.uc;
                i2 = ucVar2.hw;
            }
            j2 += jMin;
        }
        return true;
    }

    public int hashCode() {
        uc ucVar = this.pr;
        if (ucVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = ucVar.hn;
            for (int i3 = ucVar.hw; i3 < i2; i3++) {
                i = (i * 31) + ucVar.pr[i3];
            }
            ucVar = ucVar.uc;
        } while (ucVar != this.pr);
        return i;
    }

    public String toString() {
        return c().toString();
    }

    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public pr clone() {
        pr prVar = new pr();
        if (this.hw == 0) {
            return prVar;
        }
        uc ucVarPr = this.pr.pr();
        prVar.pr = ucVarPr;
        ucVarPr.fw = ucVarPr;
        ucVarPr.uc = ucVarPr;
        uc ucVar = this.pr;
        while (true) {
            ucVar = ucVar.uc;
            if (ucVar != this.pr) {
                prVar.pr.fw.pr(ucVar.pr());
            } else {
                prVar.hw = this.hw;
                return prVar;
            }
        }
    }

    public final x c() {
        long j = this.hw;
        if (j > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.hw);
        }
        return x((int) j);
    }

    public final x x(int i) {
        return i == 0 ? x.hn : new zo(this, i);
    }
}
