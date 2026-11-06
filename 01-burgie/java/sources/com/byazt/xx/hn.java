package com.byazt.xx;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bumptech.glide.load.Key;
import com.byazt.du.c;
import com.byazt.du.qa;
import com.byazt.du.uc;
import com.byazt.jv.cz;
import com.byazt.jv.iu;
import com.byazt.jv.nl;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_MAX_AV_POS_GAP, 20})
public final class hn {
    public static final nl hn;
    public static final byte[] pr;
    public static final iu x;
    public static final String[] hw = new String[0];
    public static final uc aj = uc.hw("efbbbf");
    public static final uc vk = uc.hw("feff");
    public static final uc w = uc.hw("fffe");
    public static final uc k = uc.hw("0000ffff");
    public static final uc m = uc.hw("ffff0000");
    public static final Charset c = Charset.forName(Key.STRING_CHARSET_NAME);
    public static final Charset uc = Charset.forName("ISO-8859-1");
    public static final Charset g = Charset.forName("UTF-16BE");
    public static final Charset ho = Charset.forName("UTF-16LE");
    public static final Charset nt = Charset.forName("UTF-32BE");
    public static final Charset yb = Charset.forName("UTF-32LE");
    public static final TimeZone fw = TimeZone.getTimeZone("GMT");
    public static final Comparator<String> zo = new Comparator<String>() { // from class: com.byazt.xx.hn.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    };
    public static final Pattern lb = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    static {
        byte[] bArr = new byte[0];
        pr = bArr;
        hn = nl.pr(null, bArr);
        x = iu.pr((cz) null, bArr);
    }

    public static void pr(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean pr(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void pr(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static void pr(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!pr(e)) {
                    throw e;
                }
            } catch (RuntimeException e2) {
            } catch (Exception e3) {
            }
        }
    }

    public static boolean pr(qa qaVar, int i, TimeUnit timeUnit) {
        try {
            return hw(qaVar, i, timeUnit);
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean hw(qa qaVar, int i, TimeUnit timeUnit) throws IOException {
        long jNanoTime = System.nanoTime();
        long jG_ = qaVar.pr().hn() ? qaVar.pr().g_() - jNanoTime : Long.MAX_VALUE;
        qaVar.pr().pr(Math.min(jG_, timeUnit.toNanos(i)) + jNanoTime);
        try {
            com.byazt.du.hn hnVar = new com.byazt.du.hn();
            while (qaVar.pr(hnVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                hnVar.lb();
            }
            if (jG_ == LongCompanionObject.MAX_VALUE) {
                qaVar.pr().uc();
                return true;
            }
            qaVar.pr().pr(jNanoTime + jG_);
            return true;
        } catch (InterruptedIOException e) {
            if (jG_ == LongCompanionObject.MAX_VALUE) {
                qaVar.pr().uc();
                return false;
            }
            qaVar.pr().pr(jNanoTime + jG_);
            return false;
        } catch (Throwable th) {
            if (jG_ == LongCompanionObject.MAX_VALUE) {
                qaVar.pr().uc();
            } else {
                qaVar.pr().pr(jNanoTime + jG_);
            }
            throw th;
        }
    }

    public static <T> List<T> pr(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> pr(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory pr(final String str, final boolean z) {
        return new ThreadFactory() { // from class: com.byazt.xx.hn.2
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                com.byazt.fr.hn hnVar = new com.byazt.fr.hn(runnable, "csj_" + str);
                hnVar.setDaemon(z);
                hnVar.setPriority(10);
                return hnVar;
            }
        };
    }

    public static String[] pr(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
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

    public static boolean hw(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0) {
            return false;
        }
        for (String str : strArr) {
            for (String str2 : strArr2) {
                if (comparator.compare(str, str2) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String pr(com.byazt.jv.qa qaVar, boolean z) {
        String strUc;
        if (qaVar.uc().contains(":")) {
            strUc = "[" + qaVar.uc() + "]";
        } else {
            strUc = qaVar.uc();
        }
        return (z || qaVar.fw() != com.byazt.jv.qa.pr(qaVar.hw())) ? strUc + ":" + qaVar.fw() : strUc;
    }

    public static boolean pr(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static int pr(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static String[] pr(String[] strArr, String str) {
        int length = strArr.length + 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length - 1] = str;
        return strArr2;
    }

    public static int pr(String str, int i, int i2) {
        while (i < i2) {
            switch (str.charAt(i)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    i++;
                    break;
                default:
                    return i;
            }
        }
        return i2;
    }

    public static int hw(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            switch (str.charAt(i3)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    break;
                default:
                    return i3 + 1;
            }
        }
        return i;
    }

    public static String hn(String str, int i, int i2) {
        int iPr = pr(str, i, i2);
        return str.substring(iPr, hw(str, iPr, i2));
    }

    public static int pr(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int pr(String str, int i, int i2, char c2) {
        while (i < i2) {
            if (str.charAt(i) == c2) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static String pr(String str) {
        InetAddress inetAddressX;
        if (str.contains(":")) {
            if (str.startsWith("[") && str.endsWith("]")) {
                inetAddressX = x(str, 1, str.length() - 1);
            } else {
                inetAddressX = x(str, 0, str.length());
            }
            if (inetAddressX == null) {
                return null;
            }
            byte[] address = inetAddressX.getAddress();
            if (address.length == 16) {
                return pr(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            if (!str.contains("toutiao") && !str.contains("bytedance")) {
                str = IDN.toASCII(str);
            }
            String lowerCase = str.toLowerCase(Locale.US);
            if (lowerCase.isEmpty() || x(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private static boolean x(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int hw(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127) {
                return i;
            }
        }
        return -1;
    }

    public static boolean hn(String str) {
        return lb.matcher(str).matches();
    }

    public static String pr(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Charset pr(c cVar, Charset charset) throws IOException {
        uc ucVar = aj;
        if (cVar.pr(0L, ucVar)) {
            cVar.zo(ucVar.fw());
            return c;
        }
        uc ucVar2 = vk;
        if (cVar.pr(0L, ucVar2)) {
            cVar.zo(ucVar2.fw());
            return g;
        }
        uc ucVar3 = w;
        if (cVar.pr(0L, ucVar3)) {
            cVar.zo(ucVar3.fw());
            return ho;
        }
        uc ucVar4 = k;
        if (cVar.pr(0L, ucVar4)) {
            cVar.zo(ucVar4.fw());
            return nt;
        }
        uc ucVar5 = m;
        if (cVar.pr(0L, ucVar5)) {
            cVar.zo(ucVar5.fw());
            return yb;
        }
        return charset;
    }

    public static int pr(String str, long j, TimeUnit timeUnit) {
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

    public static AssertionError pr(String str, Exception exc) {
        return (AssertionError) new AssertionError(str).initCause(exc);
    }

    public static int pr(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        if (c2 >= 'a' && c2 <= 'f') {
            return (c2 - 'a') + 10;
        }
        if (c2 >= 'A' && c2 <= 'F') {
            return (c2 - 'A') + 10;
        }
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0055  */
    /* JADX WARN: Code duplicated, block: B:33:0x005f A[LOOP:1: B:30:0x0053->B:33:0x005f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:59:0x0065 A[EDGE_INSN: B:59:0x0065->B:34:0x0065 BREAK  A[LOOP:1: B:30:0x0053->B:33:0x005f], SYNTHETIC] */
    private static InetAddress x(String str, int i, int i2) {
        int i3;
        int i4;
        int iPr;
        byte[] bArr = new byte[16];
        int i5 = -1;
        int i6 = -1;
        int i7 = 0;
        while (i < i2) {
            if (i7 == 16) {
                return null;
            }
            int i8 = i + 2;
            if (i8 <= i2 && str.regionMatches(i, "::", 0, 2)) {
                if (i5 != -1) {
                    return null;
                }
                i7 += 2;
                i5 = i7;
                if (i8 == i2) {
                    break;
                }
                i6 = i8;
                i3 = 0;
                i = i6;
                while (i < i2) {
                    iPr = pr(str.charAt(i));
                    if (iPr != -1) {
                        break;
                        break;
                    }
                    i3 = (i3 << 4) + iPr;
                    i++;
                }
                i4 = i - i6;
                if (i4 != 0) {
                }
                return null;
            }
            if (i7 == 0) {
                i6 = i;
            } else if (str.regionMatches(i, ":", 0, 1)) {
                i6 = i + 1;
            } else {
                if (!str.regionMatches(i, ".", 0, 1) || !pr(str, i6, i2, bArr, i7 - 2)) {
                    return null;
                }
                i7 += 2;
                break;
            }
            i3 = 0;
            i = i6;
            while (i < i2) {
                iPr = pr(str.charAt(i));
                if (iPr != -1) {
                    break;
                }
                i3 = (i3 << 4) + iPr;
                i++;
            }
            i4 = i - i6;
            if (i4 != 0 || i4 > 4) {
                return null;
            }
            int i9 = i7 + 1;
            bArr[i7] = (byte) ((i3 >>> 8) & 255);
            i7 = i9 + 1;
            bArr[i9] = (byte) (i3 & 255);
        }
        if (i7 != 16) {
            if (i5 == -1) {
                return null;
            }
            int i10 = i7 - i5;
            System.arraycopy(bArr, i5, bArr, 16 - i10, i10);
            Arrays.fill(bArr, i5, (16 - i7) + i5, (byte) 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e) {
            throw new AssertionError();
        }
    }

    private static boolean pr(String str, int i, int i2, byte[] bArr, int i3) {
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
        if (i4 != i3 + 4) {
            return false;
        }
        return true;
    }

    private static String pr(byte[] bArr) {
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i5 = i3;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i2 = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        com.byazt.du.hn hnVar = new com.byazt.du.hn();
        while (i < bArr.length) {
            if (i == i2) {
                hnVar.aj(58);
                i += i4;
                if (i == 16) {
                    hnVar.aj(58);
                }
            } else {
                if (i > 0) {
                    hnVar.aj(58);
                }
                hnVar.w(((bArr[i] & UByte.MAX_VALUE) << 8) | (bArr[i + 1] & UByte.MAX_VALUE));
                i += 2;
            }
        }
        return hnVar.ho();
    }
}
