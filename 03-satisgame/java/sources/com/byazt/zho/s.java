package com.byazt.zho;

import com.anythink.china.a.c;
import com.anythink.core.common.d.i;
import com.byazt.pq.ln;
import com.byazt.pq.py;
import com.byazt.pq.t;
import com.byazt.wa.l;
import com.byazt.wa.um;
import com.byazt.wa.w;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import kotlin.UByte;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1548, 8})
public final class s {
    public static final byte[] n;
    public static final t q;
    public static final ln s;
    public static final String[] qg = new String[0];
    public static final w rv = w.qg("efbbbf");
    public static final w tj = w.qg("feff");
    public static final w cp = w.qg("fffe");
    public static final w d = w.qg("0000ffff");
    public static final w oa = w.qg("ffff0000");
    public static final Charset l = Charset.forName("UTF-8");
    public static final Charset w = Charset.forName("ISO-8859-1");
    public static final Charset sz = Charset.forName("UTF-16BE");
    public static final Charset k = Charset.forName("UTF-16LE");
    public static final Charset cy = Charset.forName("UTF-32BE");
    public static final Charset hd = Charset.forName("UTF-32LE");
    public static final TimeZone x = TimeZone.getTimeZone("GMT");
    public static final Comparator<String> fs = new Comparator<String>() { // from class: com.byazt.zho.s.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    };
    public static final Pattern cd = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static int n(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    static {
        byte[] bArr = new byte[0];
        n = bArr;
        s = ln.n(null, bArr);
        q = t.n((py) null, bArr);
    }

    public static void n(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean n(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void n(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static void n(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!n(e)) {
                    throw e;
                }
            } catch (RuntimeException unused) {
            } catch (Exception unused2) {
            }
        }
    }

    public static boolean n(um umVar, int i, TimeUnit timeUnit) {
        try {
            return qg(umVar, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean qg(um umVar, int i, TimeUnit timeUnit) throws IOException {
        long jNanoTime = System.nanoTime();
        long jO_ = umVar.n().s() ? umVar.n().o_() - jNanoTime : Long.MAX_VALUE;
        umVar.n().n(Math.min(jO_, timeUnit.toNanos(i)) + jNanoTime);
        try {
            com.byazt.wa.s sVar = new com.byazt.wa.s();
            while (umVar.n(sVar, c.n) != -1) {
                sVar.cd();
            }
            if (jO_ == LongCompanionObject.MAX_VALUE) {
                umVar.n().w();
                return true;
            }
            umVar.n().n(jNanoTime + jO_);
            return true;
        } catch (InterruptedIOException unused) {
            if (jO_ == LongCompanionObject.MAX_VALUE) {
                umVar.n().w();
                return false;
            }
            umVar.n().n(jNanoTime + jO_);
            return false;
        } catch (Throwable th) {
            if (jO_ == LongCompanionObject.MAX_VALUE) {
                umVar.n().w();
            } else {
                umVar.n().n(jNanoTime + jO_);
            }
            throw th;
        }
    }

    public static <T> List<T> n(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> n(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory n(final String str, final boolean z) {
        return new ThreadFactory() { // from class: com.byazt.zho.s.2
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                com.byazt.xis.s sVar = new com.byazt.xis.s(runnable, "csj_" + str);
                sVar.setDaemon(z);
                sVar.setPriority(10);
                return sVar;
            }
        };
    }

    public static String[] n(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            for (String str2 : strArr2) {
                if (comparator.compare(str, str2) == 0) {
                    arrayList.add(str);
                    break;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean qg(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static String n(com.byazt.pq.um umVar, boolean z) {
        String strW;
        if (umVar.w().contains(":")) {
            strW = "[" + umVar.w() + "]";
        } else {
            strW = umVar.w();
        }
        return (z || umVar.x() != com.byazt.pq.um.n(umVar.qg())) ? strW + ":" + umVar.x() : strW;
    }

    public static boolean n(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static int n(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static String[] n(String[] strArr, String str) {
        int length = strArr.length + 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length - 1] = str;
        return strArr2;
    }

    public static int n(String str, int i, int i2) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int qg(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            char cCharAt = str.charAt(i3);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i3 + 1;
            }
        }
        return i;
    }

    public static String s(String str, int i, int i2) {
        int iN = n(str, i, i2);
        return str.substring(iN, qg(str, iN, i2));
    }

    public static int n(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int n(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static String n(String str) {
        InetAddress inetAddressQ;
        if (str.contains(":")) {
            if (str.startsWith("[") && str.endsWith("]")) {
                inetAddressQ = q(str, 1, str.length() - 1);
            } else {
                inetAddressQ = q(str, 0, str.length());
            }
            if (inetAddressQ == null) {
                return null;
            }
            byte[] address = inetAddressQ.getAddress();
            if (address.length == 16) {
                return n(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            if (!str.contains("toutiao") && !str.contains("bytedance")) {
                str = IDN.toASCII(str);
            }
            String lowerCase = str.toLowerCase(Locale.US);
            if (lowerCase.isEmpty() || q(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private static boolean q(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int qg(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127) {
                return i;
            }
        }
        return -1;
    }

    public static boolean s(String str) {
        return cd.matcher(str).matches();
    }

    public static String n(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Charset n(l lVar, Charset charset) throws IOException {
        w wVar = rv;
        if (lVar.n(0L, wVar)) {
            lVar.fs(wVar.x());
            return l;
        }
        w wVar2 = tj;
        if (lVar.n(0L, wVar2)) {
            lVar.fs(wVar2.x());
            return sz;
        }
        w wVar3 = cp;
        if (lVar.n(0L, wVar3)) {
            lVar.fs(wVar3.x());
            return k;
        }
        w wVar4 = d;
        if (lVar.n(0L, wVar4)) {
            lVar.fs(wVar4.x());
            return cy;
        }
        w wVar5 = oa;
        if (!lVar.n(0L, wVar5)) {
            return charset;
        }
        lVar.fs(wVar5.x());
        return hd;
    }

    public static int n(String str, long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException(str + " < 0");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        long millis = timeUnit.toMillis(j);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException(str + " too large.");
        }
        if (millis != 0 || j <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(str + " too small.");
    }

    public static AssertionError n(String str, Exception exc) {
        return (AssertionError) new AssertionError(str).initCause(exc);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x004f  */
    /* JADX WARN: Code duplicated, block: B:33:0x0059 A[LOOP:1: B:30:0x004d->B:33:0x0059, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:58:0x005f A[EDGE_INSN: B:58:0x005f->B:34:0x005f BREAK  A[LOOP:1: B:30:0x004d->B:33:0x0059], SYNTHETIC] */
    private static InetAddress q(String str, int i, int i2) {
        int i3;
        int i4;
        int iN;
        byte[] bArr = new byte[16];
        int i5 = 0;
        int i6 = -1;
        int i7 = -1;
        while (i < i2) {
            if (i5 == 16) {
                return null;
            }
            int i8 = i + 2;
            if (i8 <= i2 && str.regionMatches(i, "::", 0, 2)) {
                if (i6 != -1) {
                    return null;
                }
                i5 += 2;
                i6 = i5;
                if (i8 == i2) {
                    break;
                }
                i7 = i8;
                i3 = 0;
                i = i7;
                while (i < i2) {
                    iN = n(str.charAt(i));
                    if (iN != -1) {
                        break;
                        break;
                    }
                    i3 = (i3 << 4) + iN;
                    i++;
                }
                i4 = i - i7;
                if (i4 != 0) {
                }
                return null;
            }
            if (i5 != 0) {
                if (!str.regionMatches(i, ":", 0, 1)) {
                    if (!str.regionMatches(i, i.E, 0, 1) || !n(str, i7, i2, bArr, i5 - 2)) {
                        return null;
                    }
                    i5 += 2;
                    break;
                }
                i++;
            }
            i7 = i;
            i3 = 0;
            i = i7;
            while (i < i2) {
                iN = n(str.charAt(i));
                if (iN != -1) {
                    break;
                }
                i3 = (i3 << 4) + iN;
                i++;
            }
            i4 = i - i7;
            if (i4 != 0 || i4 > 4) {
                return null;
            }
            int i9 = i5 + 1;
            bArr[i5] = (byte) ((i3 >>> 8) & 255);
            i5 = i9 + 1;
            bArr[i9] = (byte) (i3 & 255);
        }
        if (i5 != 16) {
            if (i6 == -1) {
                return null;
            }
            int i10 = i5 - i6;
            System.arraycopy(bArr, i6, bArr, 16 - i10, i10);
            Arrays.fill(bArr, i6, (16 - i5) + i6, (byte) 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    private static boolean n(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char cCharAt = str.charAt(i5);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i5++;
            }
            if (i5 - i == 0) {
                return false;
            }
            bArr[i4] = (byte) i6;
            i4++;
            i = i5;
        }
        return i4 == i3 + 4;
    }

    private static String n(byte[] bArr) {
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i5 = i3;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        com.byazt.wa.s sVar = new com.byazt.wa.s();
        while (i2 < bArr.length) {
            if (i2 == i) {
                sVar.rv(58);
                i2 += i4;
                if (i2 == 16) {
                    sVar.rv(58);
                }
            } else {
                if (i2 > 0) {
                    sVar.rv(58);
                }
                sVar.cp(((bArr[i2] & UByte.MAX_VALUE) << 8) | (bArr[i2 + 1] & UByte.MAX_VALUE));
                i2 += 2;
            }
        }
        return sVar.k();
    }
}
