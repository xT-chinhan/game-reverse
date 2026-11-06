package com.bytedance.sdk.component.ah.ms;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.UByte;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public final class ah implements d, ka, Cloneable, ByteChannel {
    private static final byte[] ah = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    ub f1003ms;
    long xr;

    @Override // com.bytedance.sdk.component.ah.ms.d, com.bytedance.sdk.component.ah.ms.ka
    public ah ah() {
        return this;
    }

    @Override // com.bytedance.sdk.component.ah.ms.qv, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.bytedance.sdk.component.ah.ms.d
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ah nw() {
        return this;
    }

    @Override // com.bytedance.sdk.component.ah.ms.d, com.bytedance.sdk.component.ah.ms.qv, java.io.Flushable
    public void flush() {
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final long xr() {
        return this.xr;
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public boolean ka() {
        return this.xr == 0;
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public void ms(long j) throws EOFException {
        if (this.xr < j) {
            throw new EOFException();
        }
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public InputStream c() {
        return new InputStream() { // from class: com.bytedance.sdk.component.ah.ms.ah.1
            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (ah.this.xr > 0) {
                    return ah.this.x() & UByte.MAX_VALUE;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return ah.this.ms(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(ah.this.xr, 2147483647L);
            }

            public String toString() {
                return ah.this + ".inputStream()";
            }
        };
    }

    public final ah ms(ah ahVar, long j, long j2) {
        if (ahVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        nw.ms(this.xr, j, j2);
        if (j2 == 0) {
            return this;
        }
        ahVar.xr += j2;
        ub ubVar = this.f1003ms;
        while (j >= ubVar.ah - ubVar.xr) {
            j -= (long) (ubVar.ah - ubVar.xr);
            ubVar = ubVar.c;
        }
        while (j2 > 0) {
            ub ubVarMs = ubVar.ms();
            ubVarMs.xr = (int) (((long) ubVarMs.xr) + j);
            ubVarMs.ah = Math.min(ubVarMs.xr + ((int) j2), ubVarMs.ah);
            ub ubVar2 = ahVar.f1003ms;
            if (ubVar2 == null) {
                ubVarMs.ab = ubVarMs;
                ubVarMs.c = ubVarMs;
                ahVar.f1003ms = ubVarMs;
            } else {
                ubVar2.ab.ms(ubVarMs);
            }
            j2 -= (long) (ubVarMs.ah - ubVarMs.xr);
            ubVar = ubVar.c;
            j = 0;
        }
        return this;
    }

    public final long ab() {
        long j = this.xr;
        if (j == 0) {
            return 0L;
        }
        ub ubVar = this.f1003ms.ab;
        return (ubVar.ah >= 8192 || !ubVar.ka) ? j : j - ((long) (ubVar.ah - ubVar.xr));
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public byte x() {
        if (this.xr == 0) {
            throw new IllegalStateException("size == 0");
        }
        ub ubVar = this.f1003ms;
        int i = ubVar.xr;
        int i2 = ubVar.ah;
        int i3 = i + 1;
        byte b = ubVar.f1020ms[i];
        this.xr--;
        if (i3 == i2) {
            this.f1003ms = ubVar.xr();
            ao.ms(ubVar);
        } else {
            ubVar.xr = i3;
        }
        return b;
    }

    public final byte xr(long j) {
        nw.ms(this.xr, j, 1L);
        long j2 = this.xr;
        if (j2 - j > j) {
            ub ubVar = this.f1003ms;
            while (true) {
                long j3 = ubVar.ah - ubVar.xr;
                if (j >= j3) {
                    j -= j3;
                    ubVar = ubVar.c;
                } else {
                    return ubVar.f1020ms[ubVar.xr + ((int) j)];
                }
            }
        } else {
            long j4 = j - j2;
            try {
                ub ubVar2 = this.f1003ms;
                do {
                    ubVar2 = ubVar2.ab;
                    j4 += (long) (ubVar2.ah - ubVar2.xr);
                } while (j4 < 0);
                return ubVar2.f1020ms[ubVar2.xr + ((int) j4)];
            } catch (NullPointerException unused) {
                return (byte) 0;
            }
        }
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public short ny() {
        if (this.xr < 2) {
            throw new IllegalStateException("size < 2: " + this.xr);
        }
        ub ubVar = this.f1003ms;
        int i = ubVar.xr;
        int i2 = ubVar.ah;
        if (i2 - i < 2) {
            return (short) (((x() & UByte.MAX_VALUE) << 8) | (x() & UByte.MAX_VALUE));
        }
        byte[] bArr = ubVar.f1020ms;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & UByte.MAX_VALUE) << 8) | (bArr[i3] & UByte.MAX_VALUE);
        this.xr -= 2;
        if (i4 == i2) {
            this.f1003ms = ubVar.xr();
            ao.ms(ubVar);
        } else {
            ubVar.xr = i4;
        }
        return (short) i5;
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public int ch() {
        if (this.xr < 4) {
            throw new IllegalStateException("size < 4: " + this.xr);
        }
        ub ubVar = this.f1003ms;
        int i = ubVar.xr;
        int i2 = ubVar.ah;
        if (i2 - i < 4) {
            return ((x() & UByte.MAX_VALUE) << 24) | ((x() & UByte.MAX_VALUE) << 16) | ((x() & UByte.MAX_VALUE) << 8) | (x() & UByte.MAX_VALUE);
        }
        byte[] bArr = ubVar.f1020ms;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i3] & UByte.MAX_VALUE) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & UByte.MAX_VALUE) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & UByte.MAX_VALUE);
        this.xr -= 4;
        if (i8 == i2) {
            this.f1003ms = ubVar.xr();
            ao.ms(ubVar);
        } else {
            ubVar.xr = i8;
        }
        return i9;
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public short hi() {
        return nw.ms(ny());
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public int sl() {
        return nw.ms(ch());
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public long zb() {
        int i;
        int i2;
        if (this.xr == 0) {
            throw new IllegalStateException("size == 0");
        }
        int i3 = 0;
        boolean z = false;
        long j = 0;
        do {
            ub ubVar = this.f1003ms;
            byte[] bArr = ubVar.f1020ms;
            int i4 = ubVar.xr;
            int i5 = ubVar.ah;
            while (i4 < i5) {
                byte b = bArr[i4];
                if (b < 48 || b > 57) {
                    if (b >= 97 && b <= 102) {
                        i = b - 97;
                    } else {
                        if (b < 65 || b > 70) {
                            if (i3 == 0) {
                                throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b));
                            }
                            z = true;
                            break;
                        }
                        i = b - 65;
                    }
                    i2 = i + 10;
                } else {
                    i2 = b - 48;
                }
                if (((-1152921504606846976L) & j) != 0) {
                    throw new NumberFormatException("Number too large: " + new ah().hi(j).ny((int) b).ub());
                }
                j = (j << 4) | ((long) i2);
                i4++;
                i3++;
            }
            if (i4 == i5) {
                this.f1003ms = ubVar.xr();
                ao.ms(ubVar);
            } else {
                ubVar.xr = i4;
            }
            if (z) {
                break;
            }
        } while (this.f1003ms != null);
        this.xr -= (long) i3;
        return j;
    }

    public c u() throws EOFException {
        return new c(h());
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public c ah(long j) throws EOFException {
        return new c(ab(j));
    }

    public String ub() {
        try {
            return ms(this.xr, nw.f1012ms);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String d(long j) throws EOFException {
        return ms(j, nw.f1012ms);
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public String ms(Charset charset) {
        try {
            return ms(this.xr, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String ms(long j, Charset charset) throws EOFException {
        nw.ms(this.xr, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return "";
        }
        ub ubVar = this.f1003ms;
        if (((long) ubVar.xr) + j > ubVar.ah) {
            return new String(ab(j), charset);
        }
        String str = new String(ubVar.f1020ms, ubVar.xr, (int) j, charset);
        ubVar.xr = (int) (((long) ubVar.xr) + j);
        this.xr -= j;
        if (ubVar.xr == ubVar.ah) {
            this.f1003ms = ubVar.xr();
            ao.ms(ubVar);
        }
        return str;
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public String ao() throws EOFException {
        return ka(Long.MAX_VALUE);
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public String ka(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(j)));
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long jMs = ms((byte) 10, 0L, j2);
        if (jMs != -1) {
            return c(jMs);
        }
        if (j2 < xr() && xr(j2 - 1) == 13 && xr(j2) == 10) {
            return c(j2);
        }
        ah ahVar = new ah();
        ms(ahVar, 0L, Math.min(32L, xr()));
        throw new EOFException("\\n not found: limit=" + Math.min(xr(), j) + " content=" + ahVar.u().ka() + Typography.ellipsis);
    }

    String c(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (xr(j2) == 13) {
                String strD = d(j2);
                x(2L);
                return strD;
            }
        }
        String strD2 = d(j);
        x(1L);
        return strD2;
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public byte[] h() throws EOFException {
        try {
            return ab(this.xr);
        } catch (EOFException e) {
            throw e;
        }
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public byte[] ab(long j) throws EOFException {
        nw.ms(this.xr, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        byte[] bArr = new byte[(int) j];
        ms(bArr);
        return bArr;
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
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
        nw.ms(bArr.length, i, i2);
        ub ubVar = this.f1003ms;
        if (ubVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, ubVar.ah - ubVar.xr);
        System.arraycopy(ubVar.f1020ms, ubVar.xr, bArr, i, iMin);
        ubVar.xr += iMin;
        this.xr -= (long) iMin;
        if (ubVar.xr == ubVar.ah) {
            this.f1003ms = ubVar.xr();
            ao.ms(ubVar);
        }
        return iMin;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        ub ubVar = this.f1003ms;
        if (ubVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), ubVar.ah - ubVar.xr);
        byteBuffer.put(ubVar.f1020ms, ubVar.xr, iMin);
        ubVar.xr += iMin;
        this.xr -= (long) iMin;
        if (ubVar.xr == ubVar.ah) {
            this.f1003ms = ubVar.xr();
            ao.ms(ubVar);
        }
        return iMin;
    }

    public final void qv() {
        try {
            x(this.xr);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public void x(long j) throws EOFException {
        ub ubVar;
        while (j > 0 && (ubVar = this.f1003ms) != null) {
            int iMin = (int) Math.min(j, ubVar.ah - this.f1003ms.xr);
            long j2 = iMin;
            this.xr -= j2;
            j -= j2;
            this.f1003ms.xr += iMin;
            if (this.f1003ms.xr == this.f1003ms.ah) {
                ub ubVar2 = this.f1003ms;
                this.f1003ms = ubVar2.xr();
                ao.ms(ubVar2);
            }
        }
    }

    @Override // com.bytedance.sdk.component.ah.ms.d
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public ah xr(c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        cVar.ms(this);
        return this;
    }

    @Override // com.bytedance.sdk.component.ah.ms.d
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public ah xr(String str) {
        return ms(str, 0, str.length());
    }

    public ah ms(String str, int i, int i2) {
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
                ub ubVarKa = ka(1);
                byte[] bArr = ubVarKa.f1020ms;
                int i3 = ubVarKa.ah - i;
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
                int i5 = (i3 + i) - ubVarKa.ah;
                ubVarKa.ah += i5;
                this.xr += (long) i5;
            } else {
                if (cCharAt2 < 2048) {
                    ny((cCharAt2 >> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
                    ny((cCharAt2 & '?') | 128);
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    ny((cCharAt2 >> '\f') | 224);
                    ny(((cCharAt2 >> 6) & 63) | 128);
                    ny((cCharAt2 & '?') | 128);
                } else {
                    int i6 = i + 1;
                    char cCharAt3 = i6 < i2 ? str.charAt(i6) : (char) 0;
                    if (cCharAt2 > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                        ny(63);
                        i = i6;
                    } else {
                        int i7 = (((cCharAt2 & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                        ny((i7 >> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                        ny(((i7 >> 12) & 63) | 128);
                        ny(((i7 >> 6) & 63) | 128);
                        ny((i7 & 63) | 128);
                        i += 2;
                    }
                }
                i++;
            }
        }
        return this;
    }

    public ah ms(int i) {
        if (i < 128) {
            ny(i);
        } else if (i < 2048) {
            ny((i >> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
            ny((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                ny(63);
            } else {
                ny((i >> 12) | 224);
                ny(((i >> 6) & 63) | 128);
                ny((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            ny((i >> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
            ny(((i >> 12) & 63) | 128);
            ny(((i >> 6) & 63) | 128);
            ny((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public ah ms(String str, int i, int i2, Charset charset) {
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
        if (charset.equals(nw.f1012ms)) {
            return ms(str, i, i2);
        }
        byte[] bytes = str.substring(i, i2).getBytes(charset);
        return ah(bytes, 0, bytes.length);
    }

    @Override // com.bytedance.sdk.component.ah.ms.d
    /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
    public ah ah(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        return ah(bArr, 0, bArr.length);
    }

    @Override // com.bytedance.sdk.component.ah.ms.d
    /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
    public ah ah(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        nw.ms(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            ub ubVarKa = ka(1);
            int iMin = Math.min(i3 - i, 8192 - ubVarKa.ah);
            System.arraycopy(bArr, i, ubVarKa.f1020ms, ubVarKa.ah, iMin);
            i += iMin;
            ubVarKa.ah += iMin;
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
            ub ubVarKa = ka(1);
            int iMin = Math.min(i, 8192 - ubVarKa.ah);
            byteBuffer.get(ubVarKa.f1020ms, ubVarKa.ah, iMin);
            i -= iMin;
            ubVarKa.ah += iMin;
        }
        this.xr += (long) iRemaining;
        return iRemaining;
    }

    public long ms(y yVar) throws IOException {
        if (yVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long jMs = yVar.ms(this, 8192L);
            if (jMs == -1) {
                return j;
            }
            j += jMs;
        }
    }

    @Override // com.bytedance.sdk.component.ah.ms.d
    /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
    public ah ny(int i) {
        ub ubVarKa = ka(1);
        byte[] bArr = ubVarKa.f1020ms;
        int i2 = ubVarKa.ah;
        ubVarKa.ah = i2 + 1;
        bArr[i2] = (byte) i;
        this.xr++;
        return this;
    }

    @Override // com.bytedance.sdk.component.ah.ms.d
    /* JADX INFO: renamed from: ah, reason: merged with bridge method [inline-methods] */
    public ah x(int i) {
        ub ubVarKa = ka(2);
        byte[] bArr = ubVarKa.f1020ms;
        int i2 = ubVarKa.ah;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        ubVarKa.ah = i3 + 1;
        this.xr += 2;
        return this;
    }

    @Override // com.bytedance.sdk.component.ah.ms.d
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ah ab(int i) {
        ub ubVarKa = ka(4);
        byte[] bArr = ubVarKa.f1020ms;
        int i2 = ubVarKa.ah;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        ubVarKa.ah = i5 + 1;
        this.xr += 4;
        return this;
    }

    @Override // com.bytedance.sdk.component.ah.ms.d
    /* JADX INFO: renamed from: ny, reason: merged with bridge method [inline-methods] */
    public ah sl(long j) {
        boolean z;
        if (j == 0) {
            return ny(48);
        }
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return xr("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
        }
        if (j < 100000000) {
            if (j < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                if (j >= 100) {
                    i = j < 1000 ? 3 : 4;
                } else if (j >= 10) {
                    i = 2;
                }
            } else if (j < 1000000) {
                i = j < 100000 ? 5 : 6;
            } else {
                i = j < 10000000 ? 7 : 8;
            }
        } else if (j < 1000000000000L) {
            if (j < 10000000000L) {
                i = j < 1000000000 ? 9 : 10;
            } else {
                i = j < 100000000000L ? 11 : 12;
            }
        } else if (j < 1000000000000000L) {
            if (j < 10000000000000L) {
                i = 13;
            } else {
                i = j < 100000000000000L ? 14 : 15;
            }
        } else if (j < 100000000000000000L) {
            i = j < 10000000000000000L ? 16 : 17;
        } else {
            i = j < 1000000000000000000L ? 18 : 19;
        }
        if (z) {
            i++;
        }
        ub ubVarKa = ka(i);
        byte[] bArr = ubVarKa.f1020ms;
        int i2 = ubVarKa.ah + i;
        while (j != 0) {
            i2--;
            bArr[i2] = ah[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        ubVarKa.ah += i;
        this.xr += (long) i;
        return this;
    }

    @Override // com.bytedance.sdk.component.ah.ms.d
    /* JADX INFO: renamed from: ch, reason: merged with bridge method [inline-methods] */
    public ah hi(long j) {
        if (j == 0) {
            return ny(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        ub ubVarKa = ka(iNumberOfTrailingZeros);
        byte[] bArr = ubVarKa.f1020ms;
        int i = ubVarKa.ah;
        for (int i2 = (ubVarKa.ah + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = ah[(int) (15 & j)];
            j >>>= 4;
        }
        ubVarKa.ah += iNumberOfTrailingZeros;
        this.xr += (long) iNumberOfTrailingZeros;
        return this;
    }

    ub ka(int i) {
        if (i <= 0 || i > 8192) {
            throw new IllegalArgumentException();
        }
        ub ubVar = this.f1003ms;
        if (ubVar == null) {
            ub ubVarMs = ao.ms();
            this.f1003ms = ubVarMs;
            ubVarMs.ab = ubVarMs;
            ubVarMs.c = ubVarMs;
            return ubVarMs;
        }
        ub ubVar2 = ubVar.ab;
        return (ubVar2.ah + i > 8192 || !ubVar2.ka) ? ubVar2.ms(ao.ms()) : ubVar2;
    }

    @Override // com.bytedance.sdk.component.ah.ms.qv
    public void a_(ah ahVar, long j) {
        ub ubVar;
        if (ahVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (ahVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        nw.ms(ahVar.xr, 0L, j);
        while (j > 0 && (ubVar = ahVar.f1003ms) != null) {
            if (j < ubVar.ah - ubVar.xr) {
                ub ubVar2 = this.f1003ms;
                ub ubVar3 = ubVar2 != null ? ubVar2.ab : null;
                if (ubVar3 != null && ubVar3.ka) {
                    if ((((long) ubVar3.ah) + j) - ((long) (ubVar3.d ? 0 : ubVar3.xr)) <= 8192) {
                        ahVar.f1003ms.ms(ubVar3, (int) j);
                        ahVar.xr -= j;
                        this.xr += j;
                        return;
                    }
                }
                ahVar.f1003ms = ahVar.f1003ms.ms((int) j);
            }
            ub ubVar4 = ahVar.f1003ms;
            long j2 = ubVar4.ah - ubVar4.xr;
            ahVar.f1003ms = ubVar4.xr();
            ub ubVar5 = this.f1003ms;
            if (ubVar5 == null) {
                this.f1003ms = ubVar4;
                ubVar4.ab = ubVar4;
                ubVar4.c = ubVar4;
            } else {
                ubVar5.ab.ms(ubVar4).ah();
            }
            ahVar.xr -= j2;
            this.xr += j2;
            j -= j2;
        }
    }

    @Override // com.bytedance.sdk.component.ah.ms.y
    public long ms(ah ahVar, long j) {
        if (ahVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        long j2 = this.xr;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        ahVar.a_(this, j);
        return j;
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public long ms(byte b) {
        return ms(b, 0L, Long.MAX_VALUE);
    }

    public long ms(byte b, long j, long j2) {
        ub ubVar;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.xr), Long.valueOf(j), Long.valueOf(j2)));
        }
        long j4 = this.xr;
        long j5 = j2 > j4 ? j4 : j2;
        if (j == j5 || (ubVar = this.f1003ms) == null) {
            return -1L;
        }
        if (j4 - j < j) {
            while (j4 > j) {
                ubVar = ubVar.ab;
                j4 -= (long) (ubVar.ah - ubVar.xr);
            }
        } else {
            while (true) {
                long j6 = ((long) (ubVar.ah - ubVar.xr)) + j3;
                if (j6 >= j) {
                    break;
                }
                ubVar = ubVar.c;
                j3 = j6;
            }
            j4 = j3;
        }
        long j7 = j;
        while (j4 < j5) {
            byte[] bArr = ubVar.f1020ms;
            int iMin = (int) Math.min(ubVar.ah, (((long) ubVar.xr) + j5) - j4);
            for (int i = (int) ((((long) ubVar.xr) + j7) - j4); i < iMin; i++) {
                if (bArr[i] == b) {
                    return ((long) (i - ubVar.xr)) + j4;
                }
            }
            j4 += (long) (ubVar.ah - ubVar.xr);
            ubVar = ubVar.c;
            j7 = j4;
        }
        return -1L;
    }

    @Override // com.bytedance.sdk.component.ah.ms.ka
    public boolean ms(long j, c cVar) {
        return ms(j, cVar, 0, cVar.ab());
    }

    public boolean ms(long j, c cVar, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.xr - j < i2 || cVar.ab() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (xr(((long) i3) + j) != cVar.ms(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.ah.ms.qv
    public t ms() {
        return t.ah;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ah)) {
            return false;
        }
        ah ahVar = (ah) obj;
        long j = this.xr;
        if (j != ahVar.xr) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        ub ubVar = this.f1003ms;
        ub ubVar2 = ahVar.f1003ms;
        int i = ubVar.xr;
        int i2 = ubVar2.xr;
        while (j2 < this.xr) {
            long jMin = Math.min(ubVar.ah - i, ubVar2.ah - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (ubVar.f1020ms[i] != ubVar2.f1020ms[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == ubVar.ah) {
                ubVar = ubVar.c;
                i = ubVar.xr;
            }
            if (i2 == ubVar2.ah) {
                ubVar2 = ubVar2.c;
                i2 = ubVar2.xr;
            }
            j2 += jMin;
        }
        return true;
    }

    public int hashCode() {
        ub ubVar = this.f1003ms;
        if (ubVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = ubVar.ah;
            for (int i3 = ubVar.xr; i3 < i2; i3++) {
                i = (i * 31) + ubVar.f1020ms[i3];
            }
            ubVar = ubVar.c;
        } while (ubVar != this.f1003ms);
        return i;
    }

    public String toString() {
        return t().toString();
    }

    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public ah clone() {
        ah ahVar = new ah();
        if (this.xr == 0) {
            return ahVar;
        }
        ub ubVarMs = this.f1003ms.ms();
        ahVar.f1003ms = ubVarMs;
        ubVarMs.ab = ubVarMs;
        ubVarMs.c = ubVarMs;
        ub ubVar = this.f1003ms;
        while (true) {
            ubVar = ubVar.c;
            if (ubVar != this.f1003ms) {
                ahVar.f1003ms.ab.ms(ubVar.ms());
            } else {
                ahVar.xr = this.xr;
                return ahVar;
            }
        }
    }

    public final c t() {
        long j = this.xr;
        if (j > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.xr);
        }
        return c((int) j);
    }

    public final c c(int i) {
        if (i == 0) {
            return c.xr;
        }
        return new h(this, i);
    }
}
