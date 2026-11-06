package com.anythink.core.common.m.b.a;

import com.anythink.core.common.d.i;
import com.anythink.core.common.m.b.ae;
import com.anythink.core.common.m.b.ag;
import com.anythink.core.common.m.b.u;
import com.anythink.core.common.m.b.v;
import com.anythink.core.common.m.b.x;
import com.anythink.core.common.m.c.e;
import com.anythink.core.common.m.c.f;
import com.anythink.core.common.m.c.o;
import com.anythink.core.common.m.c.w;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.AccessControlException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.UByte;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final byte[] a;
    public static final ag d;
    public static final ae e;
    private static final Method k;
    private static final Pattern l;
    public static final String[] b = new String[0];
    public static final u c = u.a(new String[0]);
    private static final o h = o.a(f.c("efbbbf"), f.c("feff"), f.c("fffe"), f.c("0000ffff"), f.c("ffff0000"));
    private static final Charset i = Charset.forName("UTF-32BE");
    private static final Charset j = Charset.forName("UTF-32LE");
    public static final TimeZone f = TimeZone.getTimeZone("GMT");
    public static final Comparator<String> g = new Comparator<String>() { // from class: com.anythink.core.common.m.b.a.c.1
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(String str, String str2) {
            return str.compareTo(str2);
        }

        private static int a(String str, String str2) {
            return str.compareTo(str2);
        }
    };

    public static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    static {
        byte[] bArr = new byte[0];
        a = bArr;
        Method declaredMethod = null;
        d = ag.a((x) null, bArr);
        e = ae.a((x) null, bArr);
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
        }
        k = declaredMethod;
        l = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static void a(Throwable th, Throwable th2) {
        Method method = k;
        if (method != null) {
            try {
                method.invoke(th, th2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    private c() {
    }

    public static void a(long j2, long j3) {
        if ((j3 | 0) < 0 || 0 > j2 || j2 - 0 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e2) {
                if (!a(e2)) {
                    throw e2;
                }
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused) {
            }
        }
    }

    private static void a(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(w wVar, TimeUnit timeUnit) {
        try {
            return a(wVar, 100, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean a(w wVar, int i2, TimeUnit timeUnit) {
        long jNanoTime = System.nanoTime();
        long jC_ = wVar.a().b_() ? wVar.a().c_() - jNanoTime : Long.MAX_VALUE;
        wVar.a().a(Math.min(jC_, timeUnit.toNanos(i2)) + jNanoTime);
        try {
            com.anythink.core.common.m.c.c cVar = new com.anythink.core.common.m.c.c();
            while (wVar.a_(cVar, com.anythink.china.a.c.n) != -1) {
                cVar.z();
            }
            if (jC_ == LongCompanionObject.MAX_VALUE) {
                wVar.a().f();
                return true;
            }
            wVar.a().a(jNanoTime + jC_);
            return true;
        } catch (InterruptedIOException unused) {
            if (jC_ == LongCompanionObject.MAX_VALUE) {
                wVar.a().f();
                return false;
            }
            wVar.a().a(jNanoTime + jC_);
            return false;
        } catch (Throwable th) {
            if (jC_ == LongCompanionObject.MAX_VALUE) {
                wVar.a().f();
            } else {
                wVar.a().a(jNanoTime + jC_);
            }
            throw th;
        }
    }

    public static <T> List<T> a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <K, V> Map<K, V> a(Map<K, V> map) {
        if (map.isEmpty()) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    @SafeVarargs
    public static <T> List<T> a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory a(final String str, final boolean z) {
        return new ThreadFactory() { // from class: com.anythink.core.common.m.b.a.c.2
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    public static String[] a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
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

    public static boolean b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
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

    public static String a(v vVar, boolean z) {
        String strF;
        if (vVar.f().contains(":")) {
            strF = "[" + vVar.f() + "]";
        } else {
            strF = vVar.f();
        }
        return (z || vVar.g() != v.a(vVar.b())) ? strF + ":" + vVar.g() : strF;
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static int a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (comparator.compare(strArr[i2], str) == 0) {
                return i2;
            }
        }
        return -1;
    }

    public static String[] a(String[] strArr, String str) {
        int length = strArr.length + 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length - 1] = str;
        return strArr2;
    }

    public static int a(String str, int i2, int i3) {
        while (i2 < i3) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int b(String str, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            char cCharAt = str.charAt(i4);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i4 + 1;
            }
        }
        return i2;
    }

    public static String c(String str, int i2, int i3) {
        int iA = a(str, i2, i3);
        return str.substring(iA, b(str, iA, i3));
    }

    public static int a(String str, int i2, int i3, String str2) {
        while (i2 < i3) {
            if (str2.indexOf(str.charAt(i2)) != -1) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int a(String str, int i2, int i3, char c2) {
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static String a(String str) {
        InetAddress inetAddressD;
        if (str.contains(":")) {
            int i2 = 0;
            if (str.startsWith("[") && str.endsWith("]")) {
                inetAddressD = d(str, 1, str.length() - 1);
            } else {
                inetAddressD = d(str, 0, str.length());
            }
            if (inetAddressD == null) {
                return null;
            }
            byte[] address = inetAddressD.getAddress();
            if (address.length != 16) {
                if (address.length == 4) {
                    return inetAddressD.getHostAddress();
                }
                throw new AssertionError("Invalid IPv6 address: '" + str + "'");
            }
            int i3 = -1;
            int i4 = 0;
            int i5 = 0;
            while (i4 < address.length) {
                int i6 = i4;
                while (i6 < 16 && address[i6] == 0 && address[i6 + 1] == 0) {
                    i6 += 2;
                }
                int i7 = i6 - i4;
                if (i7 > i5 && i7 >= 4) {
                    i3 = i4;
                    i5 = i7;
                }
                i4 = i6 + 2;
            }
            com.anythink.core.common.m.c.c cVar = new com.anythink.core.common.m.c.c();
            while (i2 < address.length) {
                if (i2 == i3) {
                    cVar.l(58);
                    i2 += i5;
                    if (i2 == 16) {
                        cVar.l(58);
                    }
                } else {
                    if (i2 > 0) {
                        cVar.l(58);
                    }
                    cVar.n(((address[i2] & UByte.MAX_VALUE) << 8) | (address[i2 + 1] & UByte.MAX_VALUE));
                    i2 += 2;
                }
            }
            return cVar.u();
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty() || d(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private static boolean d(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int b(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127) {
                return i2;
            }
        }
        return -1;
    }

    public static boolean c(String str) {
        return l.matcher(str).matches();
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Charset a(e eVar, Charset charset) {
        int iA = eVar.a(h);
        if (iA == -1) {
            return charset;
        }
        if (iA == 0) {
            return StandardCharsets.UTF_8;
        }
        if (iA == 1) {
            return StandardCharsets.UTF_16BE;
        }
        if (iA == 2) {
            return StandardCharsets.UTF_16LE;
        }
        if (iA == 3) {
            return i;
        }
        if (iA == 4) {
            return j;
        }
        throw new AssertionError();
    }

    public static int a(String str, long j2, TimeUnit timeUnit) {
        if (j2 < 0) {
            throw new IllegalArgumentException(str + " < 0");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        long millis = timeUnit.toMillis(j2);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException(str + " too large.");
        }
        if (millis != 0 || j2 <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(str + " too small.");
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b5 A[LOOP:1: B:59:0x00a8->B:62:0x00b5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:89:0x00bb A[EDGE_INSN: B:89:0x00bb->B:63:0x00bb BREAK  A[LOOP:1: B:59:0x00a8->B:62:0x00b5], SYNTHETIC] */
    private static InetAddress d(String str, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int iA;
        int i8 = 16;
        byte[] bArr = new byte[16];
        int i9 = 0;
        int i10 = -1;
        int i11 = i2;
        int i12 = 0;
        int i13 = -1;
        int i14 = -1;
        while (true) {
            if (i11 >= i3) {
                i4 = i8;
                break;
            }
            if (i12 == i8) {
                return null;
            }
            int i15 = i11 + 2;
            if (i15 <= i3 && str.regionMatches(i11, "::", i9, 2)) {
                if (i13 != i10) {
                    return null;
                }
                i12 += 2;
                if (i15 == i3) {
                    i4 = i8;
                    i13 = i12;
                    break;
                }
                i13 = i12;
                i14 = i15;
                i11 = i14;
                i6 = 0;
                while (i11 < i3) {
                    iA = a(str.charAt(i11));
                    if (iA != -1) {
                        break;
                        break;
                    }
                    i6 = (i6 << 4) + iA;
                    i11++;
                }
                i7 = i11 - i14;
                if (i7 != 0) {
                }
                return null;
            }
            if (i12 != 0) {
                if (!str.regionMatches(i11, ":", i9, 1)) {
                    if (!str.regionMatches(i11, i.E, i9, 1)) {
                        return null;
                    }
                    int i16 = i12 - 2;
                    int i17 = i16;
                    loop2: while (true) {
                        if (i14 >= i3) {
                            if (i17 == i16 + 4) {
                                i5 = 1;
                                break;
                            }
                            i5 = 0;
                            break loop2;
                        }
                        if (i17 != i8) {
                            if (i17 != i16) {
                                if (str.charAt(i14) == '.') {
                                    i14++;
                                }
                            }
                            int i18 = i9;
                            int i19 = i14;
                            while (true) {
                                if (i19 < i3) {
                                    char cCharAt = str.charAt(i19);
                                    if (cCharAt >= '0' && cCharAt <= '9') {
                                        if ((i18 != 0 || i14 == i19) && (i18 = ((i18 * 10) + cCharAt) - 48) <= 255) {
                                            i19++;
                                        }
                                    }
                                    i5 = 0;
                                    break loop2;
                                }
                                if (i19 - i14 == 0) {
                                    i5 = 0;
                                    break loop2;
                                }
                                bArr[i17] = (byte) i18;
                                i17++;
                                i14 = i19;
                                i8 = 16;
                                i9 = 0;
                            }
                        }
                        i5 = i9;
                        break;
                    }
                    if (i5 != 0) {
                        i12 += 2;
                        i4 = 16;
                        break;
                    }
                    return null;
                }
                i11++;
            }
            i14 = i11;
            i11 = i14;
            i6 = 0;
            while (i11 < i3) {
                iA = a(str.charAt(i11));
                if (iA != -1) {
                    break;
                }
                i6 = (i6 << 4) + iA;
                i11++;
            }
            i7 = i11 - i14;
            if (i7 != 0 || i7 > 4) {
                return null;
            }
            int i20 = i12 + 1;
            bArr[i12] = (byte) ((i6 >>> 8) & 255);
            i12 = i20 + 1;
            bArr[i20] = (byte) (i6 & 255);
            i8 = 16;
            i9 = 0;
            i10 = -1;
        }
        if (i12 != i4) {
            if (i13 == -1) {
                return null;
            }
            int i21 = i12 - i13;
            System.arraycopy(bArr, i13, bArr, 16 - i21, i21);
            Arrays.fill(bArr, i13, (16 - i12) + i13, (byte) 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    private static boolean a(String str, int i2, int i3, byte[] bArr, int i4) {
        int i5 = i4;
        while (i2 < i3) {
            if (i5 == 16) {
                return false;
            }
            if (i5 != i4) {
                if (str.charAt(i2) != '.') {
                    return false;
                }
                i2++;
            }
            int i6 = i2;
            int i7 = 0;
            while (i6 < i3) {
                char cCharAt = str.charAt(i6);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                if ((i7 == 0 && i2 != i6) || (i7 = ((i7 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i6++;
            }
            if (i6 - i2 == 0) {
                return false;
            }
            bArr[i5] = (byte) i7;
            i5++;
            i2 = i6;
        }
        return i5 == i4 + 4;
    }

    private static String a(byte[] bArr) {
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < bArr.length) {
            int i6 = i4;
            while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                i6 += 2;
            }
            int i7 = i6 - i4;
            if (i7 > i5 && i7 >= 4) {
                i2 = i4;
                i5 = i7;
            }
            i4 = i6 + 2;
        }
        com.anythink.core.common.m.c.c cVar = new com.anythink.core.common.m.c.c();
        while (i3 < bArr.length) {
            if (i3 == i2) {
                cVar.l(58);
                i3 += i5;
                if (i3 == 16) {
                    cVar.l(58);
                }
            } else {
                if (i3 > 0) {
                    cVar.l(58);
                }
                cVar.n(((bArr[i3] & UByte.MAX_VALUE) << 8) | (bArr[i3 + 1] & UByte.MAX_VALUE));
                i3 += 2;
            }
        }
        return cVar.u();
    }

    public static X509TrustManager a() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e2) {
            throw new AssertionError("No System TLS", e2);
        }
    }

    public static u b(List<com.anythink.core.common.m.b.a.e.c> list) {
        u.a aVar = new u.a();
        for (com.anythink.core.common.m.b.a.e.c cVar : list) {
            a.a.a(aVar, cVar.l.a(), cVar.m.a());
        }
        return aVar.a();
    }

    public static List<com.anythink.core.common.m.b.a.e.c> a(u uVar) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < uVar.a(); i2++) {
            arrayList.add(new com.anythink.core.common.m.b.a.e.c(uVar.a(i2), uVar.b(i2)));
        }
        return arrayList;
    }

    public static String a(String str, String str2) {
        try {
            String property = System.getProperty(str);
            return property != null ? property : str2;
        } catch (AccessControlException unused) {
        }
    }

    public static boolean a(v vVar, v vVar2) {
        return vVar.f().equals(vVar2.f()) && vVar.g() == vVar2.g() && vVar.b().equals(vVar2.b());
    }
}
