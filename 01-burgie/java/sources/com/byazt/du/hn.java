package com.byazt.du;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bykv.vk.component.ttvideo.ILivePlayer;
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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW, 20})
public final class hn implements c, x, Cloneable, ByteChannel {
    public static final byte[] hn = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    public long hw;
    public ho pr;

    public final long hw() {
        return this.hw;
    }

    @Override // com.byazt.du.c
    public hn hn() {
        return this;
    }

    @Override // com.byazt.du.x
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public hn cz() {
        return this;
    }

    @Override // com.byazt.du.c
    public boolean c() {
        return this.hw == 0;
    }

    @Override // com.byazt.du.c
    public void pr(long j) throws EOFException {
        if (this.hw < j) {
            throw new EOFException();
        }
    }

    @Override // com.byazt.du.c
    public InputStream uc() {
        return new InputStream() { // from class: com.byazt.du.hn.1
            @Override // java.io.InputStream
            public int read() {
                if (hn.this.hw > 0) {
                    return hn.this.zo() & UByte.MAX_VALUE;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return hn.this.pr(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(hn.this.hw, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            public String toString() {
                return hn.this + ".inputStream()";
            }
        };
    }

    public final hn pr(hn hnVar, long j, long j2) {
        if (hnVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        cz.pr(this.hw, j, j2);
        if (j2 == 0) {
            return this;
        }
        hnVar.hw += j2;
        ho hoVar = this.pr;
        while (j >= hoVar.hn - hoVar.hw) {
            j -= (long) (hoVar.hn - hoVar.hw);
            hoVar = hoVar.uc;
        }
        while (j2 > 0) {
            ho hoVarPr = hoVar.pr();
            hoVarPr.hw = (int) (((long) hoVarPr.hw) + j);
            hoVarPr.hn = Math.min(hoVarPr.hw + ((int) j2), hoVarPr.hn);
            ho hoVar2 = hnVar.pr;
            if (hoVar2 == null) {
                hoVarPr.fw = hoVarPr;
                hoVarPr.uc = hoVarPr;
                hnVar.pr = hoVarPr;
            } else {
                hoVar2.fw.pr(hoVarPr);
            }
            j2 -= (long) (hoVarPr.hn - hoVarPr.hw);
            hoVar = hoVar.uc;
            j = 0;
        }
        return this;
    }

    public final long fw() {
        long j = this.hw;
        if (j == 0) {
            return 0L;
        }
        ho hoVar = this.pr.fw;
        if (hoVar.hn < 8192 && hoVar.c) {
            return j - ((long) (hoVar.hn - hoVar.hw));
        }
        return j;
    }

    @Override // com.byazt.du.c
    public byte zo() {
        if (this.hw == 0) {
            throw new IllegalStateException("size == 0");
        }
        ho hoVar = this.pr;
        int i = hoVar.hw;
        int i2 = hoVar.hn;
        int i3 = i + 1;
        byte b = hoVar.pr[i];
        this.hw--;
        if (i3 == i2) {
            this.pr = hoVar.hw();
            nt.pr(hoVar);
        } else {
            hoVar.hw = i3;
        }
        return b;
    }

    public final byte hw(long j) {
        cz.pr(this.hw, j, 1L);
        long j2 = this.hw;
        if (j2 - j > j) {
            ho hoVar = this.pr;
            while (true) {
                long j3 = hoVar.hn - hoVar.hw;
                if (j < j3) {
                    return hoVar.pr[hoVar.hw + ((int) j)];
                }
                j -= j3;
                hoVar = hoVar.uc;
            }
        } else {
            long j4 = j - j2;
            try {
                ho hoVar2 = this.pr.fw;
                while (true) {
                    j4 += (long) (hoVar2.hn - hoVar2.hw);
                    if (j4 >= 0) {
                        return hoVar2.pr[hoVar2.hw + ((int) j4)];
                    }
                    hoVar2 = hoVar2.fw;
                }
            } catch (NullPointerException e) {
                return (byte) 0;
            }
        }
    }

    @Override // com.byazt.du.c
    public short aj() {
        if (this.hw < 2) {
            throw new IllegalStateException("size < 2: " + this.hw);
        }
        ho hoVar = this.pr;
        int i = hoVar.hw;
        int i2 = hoVar.hn;
        if (i2 - i < 2) {
            return (short) (((zo() & UByte.MAX_VALUE) << 8) | (zo() & UByte.MAX_VALUE));
        }
        byte[] bArr = hoVar.pr;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & UByte.MAX_VALUE) << 8) | (bArr[i3] & UByte.MAX_VALUE);
        this.hw -= 2;
        if (i4 == i2) {
            this.pr = hoVar.hw();
            nt.pr(hoVar);
        } else {
            hoVar.hw = i4;
        }
        return (short) i5;
    }

    @Override // com.byazt.du.c
    public int vk() {
        if (this.hw < 4) {
            throw new IllegalStateException("size < 4: " + this.hw);
        }
        ho hoVar = this.pr;
        int i = hoVar.hw;
        int i2 = hoVar.hn;
        if (i2 - i < 4) {
            return ((zo() & UByte.MAX_VALUE) << 24) | ((zo() & UByte.MAX_VALUE) << 16) | ((zo() & UByte.MAX_VALUE) << 8) | (zo() & UByte.MAX_VALUE);
        }
        byte[] bArr = hoVar.pr;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i3] & UByte.MAX_VALUE) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & UByte.MAX_VALUE) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & UByte.MAX_VALUE);
        this.hw -= 4;
        if (i8 == i2) {
            this.pr = hoVar.hw();
            nt.pr(hoVar);
        } else {
            hoVar.hw = i8;
        }
        return i9;
    }

    @Override // com.byazt.du.c
    public short w() {
        return cz.pr(aj());
    }

    @Override // com.byazt.du.c
    public int k() {
        return cz.pr(vk());
    }

    @Override // com.byazt.du.c
    public long m() {
        int i;
        if (this.hw == 0) {
            throw new IllegalStateException("size == 0");
        }
        int i2 = 0;
        boolean z = false;
        long j = 0;
        do {
            ho hoVar = this.pr;
            byte[] bArr = hoVar.pr;
            int i3 = hoVar.hw;
            int i4 = hoVar.hn;
            while (i3 < i4) {
                byte b = bArr[i3];
                if (b >= 48 && b <= 57) {
                    i = b - 48;
                } else if (b >= 97 && b <= 102) {
                    i = (b - 97) + 10;
                } else if (b >= 65 && b <= 70) {
                    i = (b - 65) + 10;
                } else {
                    if (i2 == 0) {
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b));
                    }
                    z = true;
                    break;
                }
                if (((-1152921504606846976L) & j) != 0) {
                    throw new NumberFormatException("Number too large: " + new hn().w(j).aj((int) b).ho());
                }
                j = (j << 4) | ((long) i);
                i3++;
                i2++;
            }
            if (i3 == i4) {
                this.pr = hoVar.hw();
                nt.pr(hoVar);
            } else {
                hoVar.hw = i3;
            }
            if (z) {
                break;
            }
        } while (this.pr != null);
        this.hw -= (long) i2;
        return j;
    }

    public uc g() throws EOFException {
        return new uc(yb());
    }

    @Override // com.byazt.du.c
    public uc hn(long j) throws EOFException {
        return new uc(fw(j));
    }

    public String ho() {
        try {
            return pr(this.hw, cz.pr);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String x(long j) throws EOFException {
        return pr(j, cz.pr);
    }

    @Override // com.byazt.du.c
    public String pr(Charset charset) {
        try {
            return pr(this.hw, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String pr(long j, Charset charset) throws EOFException {
        cz.pr(this.hw, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return "";
        }
        ho hoVar = this.pr;
        if (((long) hoVar.hw) + j > hoVar.hn) {
            return new String(fw(j), charset);
        }
        String str = new String(hoVar.pr, hoVar.hw, (int) j, charset);
        hoVar.hw = (int) (((long) hoVar.hw) + j);
        this.hw -= j;
        if (hoVar.hw == hoVar.hn) {
            this.pr = hoVar.hw();
            nt.pr(hoVar);
        }
        return str;
    }

    @Override // com.byazt.du.c
    public String nt() throws EOFException {
        return c(LongCompanionObject.MAX_VALUE);
    }

    @Override // com.byazt.du.c
    public String c(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(j)));
        }
        long j2 = LongCompanionObject.MAX_VALUE;
        if (j != LongCompanionObject.MAX_VALUE) {
            j2 = j + 1;
        }
        long jPr = pr((byte) 10, 0L, j2);
        if (jPr != -1) {
            return uc(jPr);
        }
        if (j2 < hw() && hw(j2 - 1) == 13 && hw(j2) == 10) {
            return uc(j2);
        }
        hn hnVar = new hn();
        pr(hnVar, 0L, Math.min(32L, hw()));
        throw new EOFException("\\n not found: limit=" + Math.min(hw(), j) + " content=" + hnVar.g().c() + Typography.ellipsis);
    }

    public String uc(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (hw(j2) == 13) {
                String strX = x(j2);
                zo(2L);
                return strX;
            }
        }
        String strX2 = x(j);
        zo(1L);
        return strX2;
    }

    @Override // com.byazt.du.c
    public byte[] yb() throws EOFException {
        try {
            return fw(this.hw);
        } catch (EOFException e) {
            throw e;
        }
    }

    @Override // com.byazt.du.c
    public byte[] fw(long j) throws EOFException {
        cz.pr(this.hw, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        byte[] bArr = new byte[(int) j];
        pr(bArr);
        return bArr;
    }

    @Override // com.byazt.du.c
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
        cz.pr(bArr.length, i, i2);
        ho hoVar = this.pr;
        if (hoVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, hoVar.hn - hoVar.hw);
        System.arraycopy(hoVar.pr, hoVar.hw, bArr, i, iMin);
        hoVar.hw += iMin;
        this.hw -= (long) iMin;
        if (hoVar.hw == hoVar.hn) {
            this.pr = hoVar.hw();
            nt.pr(hoVar);
        }
        return iMin;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        ho hoVar = this.pr;
        if (hoVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), hoVar.hn - hoVar.hw);
        byteBuffer.put(hoVar.pr, hoVar.hw, iMin);
        hoVar.hw += iMin;
        this.hw -= (long) iMin;
        if (hoVar.hw == hoVar.hn) {
            this.pr = hoVar.hw();
            nt.pr(hoVar);
        }
        return iMin;
    }

    public final void lb() {
        try {
            zo(this.hw);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.byazt.du.c
    public void zo(long j) throws EOFException {
        ho hoVar;
        while (j > 0 && (hoVar = this.pr) != null) {
            int iMin = (int) Math.min(j, hoVar.hn - this.pr.hw);
            long j2 = iMin;
            this.hw -= j2;
            j -= j2;
            this.pr.hw += iMin;
            if (this.pr.hw == this.pr.hn) {
                ho hoVar2 = this.pr;
                this.pr = hoVar2.hw();
                nt.pr(hoVar2);
            }
        }
    }

    @Override // com.byazt.du.x
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public hn hw(uc ucVar) {
        if (ucVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        ucVar.pr(this);
        return this;
    }

    @Override // com.byazt.du.x
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public hn hw(String str) {
        return pr(str, 0, str.length());
    }

    public hn pr(String str, int i, int i2) {
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
                ho hoVarC = c(1);
                byte[] bArr = hoVarC.pr;
                int i3 = hoVarC.hn - i;
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
                int i4 = (i3 + i) - hoVarC.hn;
                hoVarC.hn += i4;
                this.hw += (long) i4;
            } else if (cCharAt < 2048) {
                aj((cCharAt >> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
                aj((cCharAt & '?') | 128);
                i++;
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                aj((cCharAt >> '\f') | 224);
                aj(((cCharAt >> 6) & 63) | 128);
                aj((cCharAt & '?') | 128);
                i++;
            } else {
                int i5 = i + 1;
                char cCharAt3 = i5 < i2 ? str.charAt(i5) : (char) 0;
                if (cCharAt > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                    aj(63);
                    i = i5;
                } else {
                    int i6 = (((cCharAt & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                    aj((i6 >> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                    aj(((i6 >> 12) & 63) | 128);
                    aj(((i6 >> 6) & 63) | 128);
                    aj((i6 & 63) | 128);
                    i += 2;
                }
            }
        }
        return this;
    }

    public hn pr(int i) {
        if (i < 128) {
            aj(i);
        } else if (i < 2048) {
            aj((i >> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
            aj((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                aj(63);
            } else {
                aj((i >> 12) | 224);
                aj(((i >> 6) & 63) | 128);
                aj((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            aj((i >> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
            aj(((i >> 12) & 63) | 128);
            aj(((i >> 6) & 63) | 128);
            aj((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public hn pr(String str, int i, int i2, Charset charset) {
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
        if (charset.equals(cz.pr)) {
            return pr(str, i, i2);
        }
        byte[] bytes = str.substring(i, i2).getBytes(charset);
        return hn(bytes, 0, bytes.length);
    }

    @Override // com.byazt.du.x
    /* JADX INFO: renamed from: hw, reason: merged with bridge method [inline-methods] */
    public hn hn(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        return hn(bArr, 0, bArr.length);
    }

    @Override // com.byazt.du.x
    /* JADX INFO: renamed from: hw, reason: merged with bridge method [inline-methods] */
    public hn hn(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        cz.pr(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            ho hoVarC = c(1);
            int iMin = Math.min(i3 - i, 8192 - hoVarC.hn);
            System.arraycopy(bArr, i, hoVarC.pr, hoVarC.hn, iMin);
            i += iMin;
            hoVarC.hn += iMin;
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
            ho hoVarC = c(1);
            int iMin = Math.min(i, 8192 - hoVarC.hn);
            byteBuffer.get(hoVarC.pr, hoVarC.hn, iMin);
            i -= iMin;
            hoVarC.hn += iMin;
        }
        this.hw += (long) iRemaining;
        return iRemaining;
    }

    public long pr(qa qaVar) throws IOException {
        if (qaVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long jPr = qaVar.pr(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (jPr != -1) {
                j += jPr;
            } else {
                return j;
            }
        }
    }

    @Override // com.byazt.du.x
    /* JADX INFO: renamed from: hw, reason: merged with bridge method [inline-methods] */
    public hn aj(int i) {
        ho hoVarC = c(1);
        byte[] bArr = hoVarC.pr;
        int i2 = hoVarC.hn;
        hoVarC.hn = i2 + 1;
        bArr[i2] = (byte) i;
        this.hw++;
        return this;
    }

    @Override // com.byazt.du.x
    /* JADX INFO: renamed from: hn, reason: merged with bridge method [inline-methods] */
    public hn zo(int i) {
        ho hoVarC = c(2);
        byte[] bArr = hoVarC.pr;
        int i2 = hoVarC.hn;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        hoVarC.hn = i3 + 1;
        this.hw += 2;
        return this;
    }

    @Override // com.byazt.du.x
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public hn fw(int i) {
        ho hoVarC = c(4);
        byte[] bArr = hoVarC.pr;
        int i2 = hoVarC.hn;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        hoVarC.hn = i5 + 1;
        this.hw += 4;
        return this;
    }

    @Override // com.byazt.du.x
    /* JADX INFO: renamed from: aj, reason: merged with bridge method [inline-methods] */
    public hn k(long j) {
        if (j == 0) {
            return aj(48);
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return hw("-9223372036854775808");
            }
            z = true;
        }
        if (j < 100000000) {
            if (j < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
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
        ho hoVarC = c(i);
        byte[] bArr = hoVarC.pr;
        int i2 = hoVarC.hn + i;
        while (j != 0) {
            i2--;
            bArr[i2] = hn[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        hoVarC.hn += i;
        this.hw += (long) i;
        return this;
    }

    @Override // com.byazt.du.x
    /* JADX INFO: renamed from: vk, reason: merged with bridge method [inline-methods] */
    public hn w(long j) {
        if (j == 0) {
            return aj(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        ho hoVarC = c(iNumberOfTrailingZeros);
        byte[] bArr = hoVarC.pr;
        int i = hoVarC.hn;
        for (int i2 = (hoVarC.hn + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = hn[(int) (15 & j)];
            j >>>= 4;
        }
        hoVarC.hn += iNumberOfTrailingZeros;
        this.hw += (long) iNumberOfTrailingZeros;
        return this;
    }

    public ho c(int i) {
        if (i <= 0 || i > 8192) {
            throw new IllegalArgumentException();
        }
        ho hoVar = this.pr;
        if (hoVar == null) {
            ho hoVarPr = nt.pr();
            this.pr = hoVarPr;
            hoVarPr.fw = hoVarPr;
            hoVarPr.uc = hoVarPr;
            return hoVarPr;
        }
        ho hoVar2 = hoVar.fw;
        if (hoVar2.hn + i > 8192 || !hoVar2.c) {
            return hoVar2.pr(nt.pr());
        }
        return hoVar2;
    }

    @Override // com.byazt.du.lb
    public void a_(hn hnVar, long j) {
        ho hoVar;
        if (hnVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (hnVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        cz.pr(hnVar.hw, 0L, j);
        while (j > 0 && (hoVar = hnVar.pr) != null) {
            if (j < hoVar.hn - hoVar.hw) {
                ho hoVar2 = this.pr;
                ho hoVar3 = hoVar2 != null ? hoVar2.fw : null;
                if (hoVar3 != null && hoVar3.c) {
                    if ((((long) hoVar3.hn) + j) - ((long) (hoVar3.x ? 0 : hoVar3.hw)) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                        hnVar.pr.pr(hoVar3, (int) j);
                        hnVar.hw -= j;
                        this.hw += j;
                        return;
                    }
                }
                hnVar.pr = hnVar.pr.pr((int) j);
            }
            ho hoVar4 = hnVar.pr;
            long j2 = hoVar4.hn - hoVar4.hw;
            hnVar.pr = hoVar4.hw();
            ho hoVar5 = this.pr;
            if (hoVar5 == null) {
                this.pr = hoVar4;
                hoVar4.fw = hoVar4;
                hoVar4.uc = hoVar4;
            } else {
                hoVar5.fw.pr(hoVar4).hn();
            }
            hnVar.hw -= j2;
            this.hw += j2;
            j -= j2;
        }
    }

    @Override // com.byazt.du.qa
    public long pr(hn hnVar, long j) {
        if (hnVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        long j2 = this.hw;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        hnVar.a_(this, j);
        return j;
    }

    @Override // com.byazt.du.c
    public long pr(byte b) {
        return pr(b, 0L, LongCompanionObject.MAX_VALUE);
    }

    public long pr(byte b, long j, long j2) {
        ho hoVar;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.hw), Long.valueOf(j), Long.valueOf(j2)));
        }
        long j4 = this.hw;
        long j5 = j2 > j4 ? j4 : j2;
        if (j == j5 || (hoVar = this.pr) == null) {
            return -1L;
        }
        if (j4 - j < j) {
            while (j4 > j) {
                hoVar = hoVar.fw;
                j4 -= (long) (hoVar.hn - hoVar.hw);
            }
        } else {
            while (true) {
                long j6 = ((long) (hoVar.hn - hoVar.hw)) + j3;
                if (j6 >= j) {
                    break;
                }
                hoVar = hoVar.uc;
                j3 = j6;
            }
            j4 = j3;
        }
        while (j4 < j5) {
            byte[] bArr = hoVar.pr;
            int iMin = (int) Math.min(hoVar.hn, (((long) hoVar.hw) + j5) - j4);
            for (int i = (int) ((((long) hoVar.hw) + j) - j4); i < iMin; i++) {
                if (bArr[i] == b) {
                    return ((long) (i - hoVar.hw)) + j4;
                }
            }
            j4 += (long) (hoVar.hn - hoVar.hw);
            hoVar = hoVar.uc;
            j = j4;
        }
        return -1L;
    }

    @Override // com.byazt.du.c
    public boolean pr(long j, uc ucVar) {
        return pr(j, ucVar, 0, ucVar.fw());
    }

    public boolean pr(long j, uc ucVar, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.hw - j < i2 || ucVar.fw() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (hw(((long) i3) + j) != ucVar.pr(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.byazt.du.x, com.byazt.du.lb, java.io.Flushable
    public void flush() {
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // com.byazt.du.qa, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.byazt.du.qa
    public a pr() {
        return a.hn;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hn)) {
            return false;
        }
        hn hnVar = (hn) obj;
        long j = this.hw;
        if (j != hnVar.hw) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        ho hoVar = this.pr;
        ho hoVar2 = hnVar.pr;
        int i = hoVar.hw;
        int i2 = hoVar2.hw;
        while (j2 < this.hw) {
            long jMin = Math.min(hoVar.hn - i, hoVar2.hn - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (hoVar.pr[i] != hoVar2.pr[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == hoVar.hn) {
                hoVar = hoVar.uc;
                i = hoVar.hw;
            }
            if (i2 == hoVar2.hn) {
                hoVar2 = hoVar2.uc;
                i2 = hoVar2.hw;
            }
            j2 += jMin;
        }
        return true;
    }

    public int hashCode() {
        ho hoVar = this.pr;
        if (hoVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = hoVar.hn;
            for (int i3 = hoVar.hw; i3 < i2; i3++) {
                i = (i * 31) + hoVar.pr[i3];
            }
            hoVar = hoVar.uc;
        } while (hoVar != this.pr);
        return i;
    }

    public String toString() {
        return a().toString();
    }

    /* JADX INFO: renamed from: qa, reason: merged with bridge method [inline-methods] */
    public hn clone() {
        hn hnVar = new hn();
        if (this.hw == 0) {
            return hnVar;
        }
        ho hoVarPr = this.pr.pr();
        hnVar.pr = hoVarPr;
        hoVarPr.fw = hoVarPr;
        hoVarPr.uc = hoVarPr;
        ho hoVar = this.pr;
        while (true) {
            hoVar = hoVar.uc;
            if (hoVar != this.pr) {
                hnVar.pr.fw.pr(hoVar.pr());
            } else {
                hnVar.hw = this.hw;
                return hnVar;
            }
        }
    }

    public final uc a() {
        long j = this.hw;
        if (j > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.hw);
        }
        return uc((int) j);
    }

    public final uc uc(int i) {
        return i == 0 ? uc.hw : new yb(this, i);
    }
}
