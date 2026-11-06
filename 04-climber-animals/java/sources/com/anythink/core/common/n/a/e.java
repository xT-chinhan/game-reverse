package com.anythink.core.common.n.a;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.net.IDN;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
final class e extends com.anythink.core.common.n.a.a {
    private long i;
    private int j;
    private String k;
    private com.anythink.core.common.n.a.b l;
    private byte[] m;
    private int n;
    private int o;
    private List<l> p;
    private List<l> q;
    private List<l> r;

    e(String str, com.anythink.core.common.n.a.b bVar, byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            throw new IOException("response data is empty");
        }
        this.k = str;
        this.j = 4;
        this.l = bVar;
        this.m = bArr;
        this.i = new Date().getTime() / 1000;
        if (this.m.length < 12) {
            throw new IOException("response data too small");
        }
        byte b2 = 0;
        this.e = c(0);
        if (this.e != this.l.e) {
            throw new IOException("question id error");
        }
        int iB = b(2);
        if ((b(2) & 128) == 0) {
            throw new IOException("not a response data");
        }
        this.f = (iB >> 3) & 7;
        this.n = (iB >> 2) & 1;
        this.g = iB & 1;
        int iB2 = b(3);
        this.h = (iB2 >> 7) & 1;
        this.o = iB2 & 15;
        int iD = d();
        b bVar2 = new b("answer", c(6), iD, b2);
        a(bVar2);
        this.p = bVar2.e;
        int i = iD + bVar2.d;
        b bVar3 = new b("authority", c(8), i, b2);
        a(bVar3);
        this.q = bVar3.e;
        String str2 = "additional";
        b bVar4 = new b(str2, c(10), i + bVar3.d, b2);
        a(bVar4);
        this.r = bVar4.e;
    }

    private void b() throws IOException {
        if (this.m.length < 12) {
            throw new IOException("response data too small");
        }
        byte b2 = 0;
        this.e = c(0);
        if (this.e != this.l.e) {
            throw new IOException("question id error");
        }
        int iB = b(2);
        if ((b(2) & 128) == 0) {
            throw new IOException("not a response data");
        }
        this.f = (iB >> 3) & 7;
        this.n = (iB >> 2) & 1;
        this.g = iB & 1;
        int iB2 = b(3);
        this.h = (iB2 >> 7) & 1;
        this.o = iB2 & 15;
        int iD = d();
        b bVar = new b("answer", c(6), iD, b2);
        a(bVar);
        this.p = bVar.e;
        int i = iD + bVar.d;
        b bVar2 = new b("authority", c(8), i, b2);
        a(bVar2);
        this.q = bVar2.e;
        String str = "additional";
        b bVar3 = new b(str, c(10), i + bVar2.d, b2);
        a(bVar3);
        this.r = bVar3.e;
    }

    private void c() throws IOException {
        this.e = c(0);
        if (this.e != this.l.e) {
            throw new IOException("question id error");
        }
        int iB = b(2);
        if ((b(2) & 128) == 0) {
            throw new IOException("not a response data");
        }
        this.f = (iB >> 3) & 7;
        this.n = (iB >> 2) & 1;
        this.g = iB & 1;
        int iB2 = b(3);
        this.h = (iB2 >> 7) & 1;
        this.o = iB2 & 15;
    }

    private int d() throws IOException {
        int i = 12;
        for (int iC = c(4); iC > 0; iC--) {
            a aVarA = a(i);
            if (aVarA == null) {
                throw new IOException("read Question error");
            }
            i += aVarA.a + 4;
        }
        return i;
    }

    private void a(b bVar) throws IOException {
        int i = bVar.c;
        for (int i2 = bVar.b; i2 > 0; i2--) {
            a aVarA = a(i);
            if (aVarA == null) {
                throw new IOException("read " + bVar.a + " error");
            }
            int i3 = i + aVarA.a;
            short sC = c(i3);
            int i4 = i3 + 2;
            short sC2 = c(i4);
            int i5 = i4 + 2;
            int i6 = i5 + 3;
            byte[] bArr = this.m;
            if (i6 >= bArr.length) {
                throw new IOException("read response data out of range");
            }
            int i7 = ((bArr[i5] & UByte.MAX_VALUE) << 24) + ((bArr[i5 + 1] & UByte.MAX_VALUE) << 16) + ((bArr[i5 + 2] & UByte.MAX_VALUE) << 8) + (bArr[i6] & UByte.MAX_VALUE);
            int i8 = i5 + 4;
            short sC3 = c(i8);
            int i9 = i8 + 2;
            String strA = a(sC, i9, sC3);
            if (sC2 == 1 && (sC == 5 || sC == this.l.a())) {
                b.a(bVar, new l(strA, sC, i7, this.i, this.j, this.k));
            }
            i = i9 + sC3;
        }
        bVar.d = i - bVar.c;
    }

    private a a(int i) throws IOException {
        StringBuilder sb = new StringBuilder();
        a aVar = new a((byte) 0);
        int i2 = 128;
        int iB = i;
        do {
            int iB2 = b(iB);
            int i3 = iB2 & MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT;
            if (i3 == 192) {
                if (aVar.a <= 0) {
                    aVar.a = (iB + 2) - i;
                }
                iB = b(iB + 1) | ((iB2 & 63) << 8);
            } else {
                if (i3 > 0) {
                    return null;
                }
                iB++;
                if (iB2 > 0) {
                    if (sb.length() > 0) {
                        sb.append(com.anythink.core.common.d.j.z);
                    }
                    int i4 = iB + iB2;
                    sb.append(IDN.toUnicode(new String(Arrays.copyOfRange(this.m, iB, i4))));
                    iB = i4;
                }
            }
            if (iB2 <= 0) {
                break;
            }
            i2--;
        } while (i2 > 0);
        aVar.b = sb.toString();
        if (aVar.a <= 0) {
            aVar.a = iB - i;
        }
        return aVar;
    }

    private String a(int i, int i2, int i3) {
        if (i != 1) {
            if (i != 5) {
                if (i != 16) {
                    if (i == 28 && i3 == 16) {
                        StringBuilder sb = new StringBuilder();
                        int i4 = 0;
                        while (i4 < 16) {
                            sb.append(i4 > 0 ? ":" : "");
                            int i5 = i2 + i4;
                            sb.append(b(i5));
                            sb.append(b(i5 + 1));
                            i4 += 2;
                        }
                        return sb.toString();
                    }
                } else if (i3 > 0) {
                    int i6 = i3 + i2;
                    byte[] bArr = this.m;
                    if (i6 < bArr.length) {
                        return IDN.toUnicode(new String(Arrays.copyOfRange(bArr, i2, i6)));
                    }
                }
            } else if (i3 > 1) {
                return a(i2).b;
            }
        } else if (i3 == 4) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b(i2));
            for (int i7 = 1; i7 < 4; i7++) {
                sb2.append(com.anythink.core.common.d.j.z);
                sb2.append(b(i2 + i7));
            }
            return sb2.toString();
        }
        return null;
    }

    private int b(int i) throws IOException {
        byte[] bArr = this.m;
        if (i >= bArr.length) {
            throw new IOException("read response data out of range");
        }
        return bArr[i] & UByte.MAX_VALUE;
    }

    private short c(int i) throws IOException {
        int i2 = i + 1;
        byte[] bArr = this.m;
        if (i2 >= bArr.length) {
            throw new IOException("read response data out of range");
        }
        return (short) (((bArr[i] & UByte.MAX_VALUE) << 8) + (bArr[i2] & UByte.MAX_VALUE));
    }

    private int d(int i) throws IOException {
        int i2 = i + 3;
        byte[] bArr = this.m;
        if (i2 >= bArr.length) {
            throw new IOException("read response data out of range");
        }
        int i3 = (bArr[i] & UByte.MAX_VALUE) << 24;
        int i4 = (bArr[i + 1] & UByte.MAX_VALUE) << 16;
        return i3 + i4 + ((bArr[i + 2] & UByte.MAX_VALUE) << 8) + (bArr[i2] & UByte.MAX_VALUE);
    }

    private int e() {
        return this.n;
    }

    private int f() {
        return this.o;
    }

    final List<l> a() {
        return this.p;
    }

    private List<l> g() {
        return this.r;
    }

    private List<l> h() {
        return this.q;
    }

    public final String toString() {
        return String.format(Locale.getDefault(), "{messageId:%d, rd:%d, ra:%d, aa:%d, rCode:%d, server:%s, request:%s, answerArray:%s, authorityArray:%s, additionalArray:%s}", Short.valueOf(this.e), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.n), Integer.valueOf(this.o), this.k, this.l, this.p, this.q, this.r);
    }

    private static class b {
        private final String a;
        private final int b;
        private final int c;
        private int d;
        private final List<l> e;

        /* synthetic */ b(String str, int i, int i2, byte b) {
            this(str, i, i2);
        }

        private b(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = 0;
            this.e = new ArrayList();
        }

        private void a(l lVar) {
            if (lVar != null) {
                this.e.add(lVar);
            }
        }

        static /* synthetic */ void a(b bVar, l lVar) {
            bVar.e.add(lVar);
        }
    }

    private static class a {
        private int a;
        private String b;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }
}
