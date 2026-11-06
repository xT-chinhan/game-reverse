package com.byazt.wa;

import com.anythink.china.a.c;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.UByte;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, 8})
public final class s implements l, q, Cloneable, ByteChannel {
    public static final byte[] s = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    public k n;
    public long qg;

    @Override // com.byazt.wa.um, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.byazt.wa.q, com.byazt.wa.cd, java.io.Flushable
    public void flush() {
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // com.byazt.wa.q
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public s py() {
        return this;
    }

    @Override // com.byazt.wa.l, com.byazt.wa.q
    public s s() {
        return this;
    }

    public final long qg() {
        return this.qg;
    }

    @Override // com.byazt.wa.l
    public boolean l() {
        return this.qg == 0;
    }

    @Override // com.byazt.wa.l
    public void n(long j) throws EOFException {
        if (this.qg < j) {
            throw new EOFException();
        }
    }

    @Override // com.byazt.wa.l
    public InputStream w() {
        return new InputStream() { // from class: com.byazt.wa.s.1
            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (s.this.qg > 0) {
                    return s.this.fs() & UByte.MAX_VALUE;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return s.this.n(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(s.this.qg, 2147483647L);
            }

            public String toString() {
                return s.this + ".inputStream()";
            }
        };
    }

    public final s n(s sVar, long j, long j2) {
        if (sVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        py.n(this.qg, j, j2);
        if (j2 == 0) {
            return this;
        }
        sVar.qg += j2;
        k kVar = this.n;
        while (j >= kVar.s - kVar.qg) {
            j -= (long) (kVar.s - kVar.qg);
            kVar = kVar.w;
        }
        while (j2 > 0) {
            k kVarN = kVar.n();
            kVarN.qg = (int) (((long) kVarN.qg) + j);
            kVarN.s = Math.min(kVarN.qg + ((int) j2), kVarN.s);
            k kVar2 = sVar.n;
            if (kVar2 == null) {
                kVarN.x = kVarN;
                kVarN.w = kVarN;
                sVar.n = kVarN;
            } else {
                kVar2.x.n(kVarN);
            }
            j2 -= (long) (kVarN.s - kVarN.qg);
            kVar = kVar.w;
            j = 0;
        }
        return this;
    }

    public final long x() {
        long j = this.qg;
        if (j == 0) {
            return 0L;
        }
        k kVar = this.n.x;
        return (kVar.s >= 8192 || !kVar.l) ? j : j - ((long) (kVar.s - kVar.qg));
    }

    @Override // com.byazt.wa.l
    public byte fs() {
        if (this.qg == 0) {
            throw new IllegalStateException("size == 0");
        }
        k kVar = this.n;
        int i = kVar.qg;
        int i2 = kVar.s;
        int i3 = i + 1;
        byte b = kVar.n[i];
        this.qg--;
        if (i3 == i2) {
            this.n = kVar.qg();
            cy.n(kVar);
        } else {
            kVar.qg = i3;
        }
        return b;
    }

    public final byte qg(long j) {
        py.n(this.qg, j, 1L);
        long j2 = this.qg;
        if (j2 - j > j) {
            k kVar = this.n;
            while (true) {
                long j3 = kVar.s - kVar.qg;
                if (j >= j3) {
                    j -= j3;
                    kVar = kVar.w;
                } else {
                    return kVar.n[kVar.qg + ((int) j)];
                }
            }
        } else {
            long j4 = j - j2;
            try {
                k kVar2 = this.n;
                do {
                    kVar2 = kVar2.x;
                    j4 += (long) (kVar2.s - kVar2.qg);
                } while (j4 < 0);
                return kVar2.n[kVar2.qg + ((int) j4)];
            } catch (NullPointerException unused) {
                return (byte) 0;
            }
        }
    }

    @Override // com.byazt.wa.l
    public short rv() {
        if (this.qg < 2) {
            throw new IllegalStateException("size < 2: " + this.qg);
        }
        k kVar = this.n;
        int i = kVar.qg;
        int i2 = kVar.s;
        if (i2 - i < 2) {
            return (short) (((fs() & UByte.MAX_VALUE) << 8) | (fs() & UByte.MAX_VALUE));
        }
        byte[] bArr = kVar.n;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & UByte.MAX_VALUE) << 8) | (bArr[i3] & UByte.MAX_VALUE);
        this.qg -= 2;
        if (i4 == i2) {
            this.n = kVar.qg();
            cy.n(kVar);
        } else {
            kVar.qg = i4;
        }
        return (short) i5;
    }

    @Override // com.byazt.wa.l
    public int tj() {
        if (this.qg < 4) {
            throw new IllegalStateException("size < 4: " + this.qg);
        }
        k kVar = this.n;
        int i = kVar.qg;
        int i2 = kVar.s;
        if (i2 - i < 4) {
            return ((fs() & UByte.MAX_VALUE) << 24) | ((fs() & UByte.MAX_VALUE) << 16) | ((fs() & UByte.MAX_VALUE) << 8) | (fs() & UByte.MAX_VALUE);
        }
        byte[] bArr = kVar.n;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i3] & UByte.MAX_VALUE) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & UByte.MAX_VALUE) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & UByte.MAX_VALUE);
        this.qg -= 4;
        if (i8 == i2) {
            this.n = kVar.qg();
            cy.n(kVar);
        } else {
            kVar.qg = i8;
        }
        return i9;
    }

    @Override // com.byazt.wa.l
    public short cp() {
        return py.n(rv());
    }

    @Override // com.byazt.wa.l
    public int d() {
        return py.n(tj());
    }

    @Override // com.byazt.wa.l
    public long oa() {
        int i;
        int i2;
        if (this.qg == 0) {
            throw new IllegalStateException("size == 0");
        }
        int i3 = 0;
        boolean z = false;
        long j = 0;
        do {
            k kVar = this.n;
            byte[] bArr = kVar.n;
            int i4 = kVar.qg;
            int i5 = kVar.s;
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
                    throw new NumberFormatException("Number too large: " + new s().cp(j).rv((int) b).k());
                }
                j = (j << 4) | ((long) i2);
                i4++;
                i3++;
            }
            if (i4 == i5) {
                this.n = kVar.qg();
                cy.n(kVar);
            } else {
                kVar.qg = i4;
            }
            if (z) {
                break;
            }
        } while (this.n != null);
        this.qg -= (long) i3;
        return j;
    }

    public w sz() throws EOFException {
        return new w(hd());
    }

    @Override // com.byazt.wa.l
    public w s(long j) throws EOFException {
        return new w(x(j));
    }

    public String k() {
        try {
            return n(this.qg, py.n);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String q(long j) throws EOFException {
        return n(j, py.n);
    }

    @Override // com.byazt.wa.l
    public String n(Charset charset) {
        try {
            return n(this.qg, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String n(long j, Charset charset) throws EOFException {
        py.n(this.qg, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return "";
        }
        k kVar = this.n;
        if (((long) kVar.qg) + j > kVar.s) {
            return new String(x(j), charset);
        }
        String str = new String(kVar.n, kVar.qg, (int) j, charset);
        kVar.qg = (int) (((long) kVar.qg) + j);
        this.qg -= j;
        if (kVar.qg == kVar.s) {
            this.n = kVar.qg();
            cy.n(kVar);
        }
        return str;
    }

    @Override // com.byazt.wa.l
    public String cy() throws EOFException {
        return l(LongCompanionObject.MAX_VALUE);
    }

    @Override // com.byazt.wa.l
    public String l(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(j)));
        }
        long j2 = LongCompanionObject.MAX_VALUE;
        if (j != LongCompanionObject.MAX_VALUE) {
            j2 = j + 1;
        }
        long jN = n((byte) 10, 0L, j2);
        if (jN != -1) {
            return w(jN);
        }
        if (j2 < qg() && qg(j2 - 1) == 13 && qg(j2) == 10) {
            return w(j2);
        }
        s sVar = new s();
        n(sVar, 0L, Math.min(32L, qg()));
        throw new EOFException("\\n not found: limit=" + Math.min(qg(), j) + " content=" + sVar.sz().l() + Typography.ellipsis);
    }

    public String w(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (qg(j2) == 13) {
                String strQ = q(j2);
                fs(2L);
                return strQ;
            }
        }
        String strQ2 = q(j);
        fs(1L);
        return strQ2;
    }

    @Override // com.byazt.wa.l
    public byte[] hd() throws EOFException {
        try {
            return x(this.qg);
        } catch (EOFException e) {
            throw e;
        }
    }

    @Override // com.byazt.wa.l
    public byte[] x(long j) throws EOFException {
        py.n(this.qg, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        byte[] bArr = new byte[(int) j];
        n(bArr);
        return bArr;
    }

    @Override // com.byazt.wa.l
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
        py.n(bArr.length, i, i2);
        k kVar = this.n;
        if (kVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, kVar.s - kVar.qg);
        System.arraycopy(kVar.n, kVar.qg, bArr, i, iMin);
        kVar.qg += iMin;
        this.qg -= (long) iMin;
        if (kVar.qg == kVar.s) {
            this.n = kVar.qg();
            cy.n(kVar);
        }
        return iMin;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        k kVar = this.n;
        if (kVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), kVar.s - kVar.qg);
        byteBuffer.put(kVar.n, kVar.qg, iMin);
        kVar.qg += iMin;
        this.qg -= (long) iMin;
        if (kVar.qg == kVar.s) {
            this.n = kVar.qg();
            cy.n(kVar);
        }
        return iMin;
    }

    public final void cd() {
        try {
            fs(this.qg);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.byazt.wa.l
    public void fs(long j) throws EOFException {
        k kVar;
        while (j > 0 && (kVar = this.n) != null) {
            int iMin = (int) Math.min(j, kVar.s - this.n.qg);
            long j2 = iMin;
            this.qg -= j2;
            j -= j2;
            this.n.qg += iMin;
            if (this.n.qg == this.n.s) {
                k kVar2 = this.n;
                this.n = kVar2.qg();
                cy.n(kVar2);
            }
        }
    }

    @Override // com.byazt.wa.q
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public s qg(w wVar) {
        if (wVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        wVar.n(this);
        return this;
    }

    @Override // com.byazt.wa.q
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public s qg(String str) {
        return n(str, 0, str.length());
    }

    public s n(String str, int i, int i2) {
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
                k kVarL = l(1);
                byte[] bArr = kVarL.n;
                int i3 = kVarL.s - i;
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
                int i5 = (i3 + i) - kVarL.s;
                kVarL.s += i5;
                this.qg += (long) i5;
            } else {
                if (cCharAt2 < 2048) {
                    rv((cCharAt2 >> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
                    rv((cCharAt2 & '?') | 128);
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    rv((cCharAt2 >> '\f') | 224);
                    rv(((cCharAt2 >> 6) & 63) | 128);
                    rv((cCharAt2 & '?') | 128);
                } else {
                    int i6 = i + 1;
                    char cCharAt3 = i6 < i2 ? str.charAt(i6) : (char) 0;
                    if (cCharAt2 > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                        rv(63);
                        i = i6;
                    } else {
                        int i7 = (((cCharAt2 & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                        rv((i7 >> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                        rv(((i7 >> 12) & 63) | 128);
                        rv(((i7 >> 6) & 63) | 128);
                        rv((i7 & 63) | 128);
                        i += 2;
                    }
                }
                i++;
            }
        }
        return this;
    }

    public s n(int i) {
        if (i < 128) {
            rv(i);
        } else if (i < 2048) {
            rv((i >> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
            rv((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                rv(63);
            } else {
                rv((i >> 12) | 224);
                rv(((i >> 6) & 63) | 128);
                rv((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            rv((i >> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
            rv(((i >> 12) & 63) | 128);
            rv(((i >> 6) & 63) | 128);
            rv((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public s n(String str, int i, int i2, Charset charset) {
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
        if (charset.equals(py.n)) {
            return n(str, i, i2);
        }
        byte[] bytes = str.substring(i, i2).getBytes(charset);
        return s(bytes, 0, bytes.length);
    }

    @Override // com.byazt.wa.q
    /* JADX INFO: renamed from: qg, reason: merged with bridge method [inline-methods] */
    public s s(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        return s(bArr, 0, bArr.length);
    }

    @Override // com.byazt.wa.q
    /* JADX INFO: renamed from: qg, reason: merged with bridge method [inline-methods] */
    public s s(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        py.n(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            k kVarL = l(1);
            int iMin = Math.min(i3 - i, 8192 - kVarL.s);
            System.arraycopy(bArr, i, kVarL.n, kVarL.s, iMin);
            i += iMin;
            kVarL.s += iMin;
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
            k kVarL = l(1);
            int iMin = Math.min(i, 8192 - kVarL.s);
            byteBuffer.get(kVarL.n, kVarL.s, iMin);
            i -= iMin;
            kVarL.s += iMin;
        }
        this.qg += (long) iRemaining;
        return iRemaining;
    }

    public long n(um umVar) throws IOException {
        if (umVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long jN = umVar.n(this, c.n);
            if (jN == -1) {
                return j;
            }
            j += jN;
        }
    }

    @Override // com.byazt.wa.q
    /* JADX INFO: renamed from: qg, reason: merged with bridge method [inline-methods] */
    public s rv(int i) {
        k kVarL = l(1);
        byte[] bArr = kVarL.n;
        int i2 = kVarL.s;
        kVarL.s = i2 + 1;
        bArr[i2] = (byte) i;
        this.qg++;
        return this;
    }

    @Override // com.byazt.wa.q
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public s fs(int i) {
        k kVarL = l(2);
        byte[] bArr = kVarL.n;
        int i2 = kVarL.s;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        kVarL.s = i3 + 1;
        this.qg += 2;
        return this;
    }

    @Override // com.byazt.wa.q
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public s x(int i) {
        k kVarL = l(4);
        byte[] bArr = kVarL.n;
        int i2 = kVarL.s;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        kVarL.s = i5 + 1;
        this.qg += 4;
        return this;
    }

    @Override // com.byazt.wa.q
    /* JADX INFO: renamed from: rv, reason: merged with bridge method [inline-methods] */
    public s d(long j) {
        boolean z;
        if (j == 0) {
            return rv(48);
        }
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return qg("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
        }
        if (j < 100000000) {
            if (j < 10000) {
                if (j >= 100) {
                    i = j < 1000 ? 3 : 4;
                } else if (j >= 10) {
                    i = 2;
                }
            } else if (j < C.MICROS_PER_SECOND) {
                i = j < 100000 ? 5 : 6;
            } else {
                i = j < 10000000 ? 7 : 8;
            }
        } else if (j < 1000000000000L) {
            if (j < 10000000000L) {
                i = j < C.NANOS_PER_SECOND ? 9 : 10;
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
        k kVarL = l(i);
        byte[] bArr = kVarL.n;
        int i2 = kVarL.s + i;
        while (j != 0) {
            i2--;
            bArr[i2] = s[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        kVarL.s += i;
        this.qg += (long) i;
        return this;
    }

    @Override // com.byazt.wa.q
    /* JADX INFO: renamed from: tj, reason: merged with bridge method [inline-methods] */
    public s cp(long j) {
        if (j == 0) {
            return rv(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        k kVarL = l(iNumberOfTrailingZeros);
        byte[] bArr = kVarL.n;
        int i = kVarL.s;
        for (int i2 = (kVarL.s + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = s[(int) (15 & j)];
            j >>>= 4;
        }
        kVarL.s += iNumberOfTrailingZeros;
        this.qg += (long) iNumberOfTrailingZeros;
        return this;
    }

    public k l(int i) {
        if (i <= 0 || i > 8192) {
            throw new IllegalArgumentException();
        }
        k kVar = this.n;
        if (kVar == null) {
            k kVarN = cy.n();
            this.n = kVarN;
            kVarN.x = kVarN;
            kVarN.w = kVarN;
            return kVarN;
        }
        k kVar2 = kVar.x;
        return (kVar2.s + i > 8192 || !kVar2.l) ? kVar2.n(cy.n()) : kVar2;
    }

    @Override // com.byazt.wa.cd
    public void a_(s sVar, long j) {
        k kVar;
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (sVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        py.n(sVar.qg, 0L, j);
        while (j > 0 && (kVar = sVar.n) != null) {
            if (j < kVar.s - kVar.qg) {
                k kVar2 = this.n;
                k kVar3 = kVar2 != null ? kVar2.x : null;
                if (kVar3 != null && kVar3.l) {
                    if ((((long) kVar3.s) + j) - ((long) (kVar3.q ? 0 : kVar3.qg)) <= c.n) {
                        sVar.n.n(kVar3, (int) j);
                        sVar.qg -= j;
                        this.qg += j;
                        return;
                    }
                }
                sVar.n = sVar.n.n((int) j);
            }
            k kVar4 = sVar.n;
            long j2 = kVar4.s - kVar4.qg;
            sVar.n = kVar4.qg();
            k kVar5 = this.n;
            if (kVar5 == null) {
                this.n = kVar4;
                kVar4.x = kVar4;
                kVar4.w = kVar4;
            } else {
                kVar5.x.n(kVar4).s();
            }
            sVar.qg -= j2;
            this.qg += j2;
            j -= j2;
        }
    }

    @Override // com.byazt.wa.um
    public long n(s sVar, long j) {
        if (sVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        long j2 = this.qg;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        sVar.a_(this, j);
        return j;
    }

    @Override // com.byazt.wa.l
    public long n(byte b) {
        return n(b, 0L, LongCompanionObject.MAX_VALUE);
    }

    public long n(byte b, long j, long j2) {
        k kVar;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.qg), Long.valueOf(j), Long.valueOf(j2)));
        }
        long j4 = this.qg;
        long j5 = j2 > j4 ? j4 : j2;
        if (j == j5 || (kVar = this.n) == null) {
            return -1L;
        }
        if (j4 - j < j) {
            while (j4 > j) {
                kVar = kVar.x;
                j4 -= (long) (kVar.s - kVar.qg);
            }
        } else {
            while (true) {
                long j6 = ((long) (kVar.s - kVar.qg)) + j3;
                if (j6 >= j) {
                    break;
                }
                kVar = kVar.w;
                j3 = j6;
            }
            j4 = j3;
        }
        long j7 = j;
        while (j4 < j5) {
            byte[] bArr = kVar.n;
            int iMin = (int) Math.min(kVar.s, (((long) kVar.qg) + j5) - j4);
            for (int i = (int) ((((long) kVar.qg) + j7) - j4); i < iMin; i++) {
                if (bArr[i] == b) {
                    return ((long) (i - kVar.qg)) + j4;
                }
            }
            j4 += (long) (kVar.s - kVar.qg);
            kVar = kVar.w;
            j7 = j4;
        }
        return -1L;
    }

    @Override // com.byazt.wa.l
    public boolean n(long j, w wVar) {
        return n(j, wVar, 0, wVar.x());
    }

    public boolean n(long j, w wVar, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.qg - j < i2 || wVar.x() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (qg(((long) i3) + j) != wVar.n(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.byazt.wa.um
    public a n() {
        return a.s;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        long j = this.qg;
        if (j != sVar.qg) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        k kVar = this.n;
        k kVar2 = sVar.n;
        int i = kVar.qg;
        int i2 = kVar2.qg;
        while (j2 < this.qg) {
            long jMin = Math.min(kVar.s - i, kVar2.s - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (kVar.n[i] != kVar2.n[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == kVar.s) {
                kVar = kVar.w;
                i = kVar.qg;
            }
            if (i2 == kVar2.s) {
                kVar2 = kVar2.w;
                i2 = kVar2.qg;
            }
            j2 += jMin;
        }
        return true;
    }

    public int hashCode() {
        k kVar = this.n;
        if (kVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = kVar.s;
            for (int i3 = kVar.qg; i3 < i2; i3++) {
                i = (i * 31) + kVar.n[i3];
            }
            kVar = kVar.w;
        } while (kVar != this.n);
        return i;
    }

    public String toString() {
        return a().toString();
    }

    /* JADX INFO: renamed from: um, reason: merged with bridge method [inline-methods] */
    public s clone() {
        s sVar = new s();
        if (this.qg == 0) {
            return sVar;
        }
        k kVarN = this.n.n();
        sVar.n = kVarN;
        kVarN.x = kVarN;
        kVarN.w = kVarN;
        k kVar = this.n;
        while (true) {
            kVar = kVar.w;
            if (kVar != this.n) {
                sVar.n.x.n(kVar.n());
            } else {
                sVar.qg = this.qg;
                return sVar;
            }
        }
    }

    public final w a() {
        long j = this.qg;
        if (j > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.qg);
        }
        return w((int) j);
    }

    public final w w(int i) {
        if (i == 0) {
            return w.qg;
        }
        return new hd(this, i);
    }
}
