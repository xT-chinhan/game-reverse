package com.anythink.core.common.l.e.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATSDK;
import com.anythink.core.common.l.c.h;
import com.anythink.core.common.l.e.i;
import com.anythink.core.common.u.p;
import com.byazt.ho.BaseConstants;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    private static final int c = 0;
    private static final int d = 1;
    private static final int e = 7;
    private static final int m = 5242880;
    protected Socket b;
    private String f;
    private int g;
    private String h;
    private long i;
    private final String a = getClass().getSimpleName();
    private byte[] j = null;
    private final byte[] k = new byte[1];
    private final AtomicBoolean l = new AtomicBoolean(false);

    private static boolean a(long j, long j2, long j3) {
        return j3 > 0 && j > 0 && j2 >= j && j2 - j >= j3;
    }

    protected abstract void a(i iVar, i.a aVar);

    protected boolean a() {
        return false;
    }

    protected boolean b() {
        return false;
    }

    protected boolean c() {
        return false;
    }

    protected int d() {
        return BaseConstants.Time.MINUTE;
    }

    protected long e() {
        return 0L;
    }

    public final boolean f() {
        return this.l.compareAndSet(false, true);
    }

    private void g() {
        this.l.set(false);
    }

    private void a(i iVar, h hVar, long j) {
        synchronized (this) {
            if (this.b == null) {
                Socket socket = new Socket();
                this.b = socket;
                socket.setSoTimeout(a(d(), j));
            }
            if (hVar != null) {
                this.f = hVar.a();
                this.g = hVar.b();
                com.anythink.core.common.l.c.a aVar = new com.anythink.core.common.l.c.a();
                aVar.d(iVar.getClass().getName());
                aVar.e(this.f + ":" + this.g);
                aVar.f(2);
                try {
                    InetSocketAddress inetSocketAddressA = a(this.f, this.g, aVar, j);
                    InetAddress address = inetSocketAddressA.getAddress();
                    this.h = address != null ? address.getHostAddress() : null;
                    try {
                        int iA = a(30000, j);
                        this.b.setSoTimeout(a(d(), j));
                        this.b.connect(inetSocketAddressA, iA);
                        k();
                        aVar.b(1);
                        try {
                            com.anythink.core.common.t.f.a(aVar);
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable th) {
                        try {
                            aVar.b(0);
                            aVar.c(th.getClass().getSimpleName() + ": " + th.getMessage());
                            throw th;
                        } catch (Throwable th2) {
                            try {
                                com.anythink.core.common.t.f.a(aVar);
                            } catch (Throwable unused2) {
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    aVar.b(0);
                    aVar.c(th3.getClass().getSimpleName() + ": " + th3.getMessage());
                    try {
                        com.anythink.core.common.t.f.a(aVar);
                    } catch (Throwable unused3) {
                    }
                    throw th3;
                }
            } else {
                throw new IllegalArgumentException("The domain must not can be null or empty.");
            }
        }
    }

    private com.anythink.core.common.l.c.a a(i iVar) {
        com.anythink.core.common.l.c.a aVar = new com.anythink.core.common.l.c.a();
        aVar.d(iVar.getClass().getName());
        aVar.e(this.f + ":" + this.g);
        aVar.f(2);
        return aVar;
    }

    private static InetSocketAddress a(String str, int i, com.anythink.core.common.l.c.a aVar, long j) throws SocketTimeoutException {
        if (j > 0 && j <= SystemClock.elapsedRealtime()) {
            throw new SocketTimeoutException("TCP DNS deadline exceeded before lookup");
        }
        try {
            List<InetAddress> listA = com.anythink.core.common.l.a.a.h.a(str, !ATSDK.isCnSDK(), aVar, j);
            if (listA != null && !listA.isEmpty()) {
                return new InetSocketAddress(listA.get(0), i);
            }
        } catch (Throwable th) {
            if (j > 0) {
                throw new SocketTimeoutException("TCP DNS deadline exceeded: " + th.getMessage());
            }
        }
        if (j > 0) {
            throw new SocketTimeoutException("TCP DNS resolution failed within deadline");
        }
        return new InetSocketAddress(str, i);
    }

    private void h() {
        synchronized (this) {
            try {
                Socket socket = this.b;
                if (socket != null) {
                    socket.close();
                    this.b = null;
                }
            } catch (Exception unused) {
            } finally {
                this.i = 0L;
            }
        }
    }

    private boolean i() {
        Socket socket = this.b;
        return (socket == null || !socket.isConnected() || this.b.isClosed()) ? false : true;
    }

    private boolean j() {
        long j = this.i;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jE = e();
        return jE > 0 && j > 0 && jElapsedRealtime >= j && jElapsedRealtime - j >= jE;
    }

    private static int a(int i, long j) throws SocketTimeoutException {
        if (j <= 0) {
            return i;
        }
        long jElapsedRealtime = j - SystemClock.elapsedRealtime();
        if (jElapsedRealtime <= 0) {
            throw new SocketTimeoutException("TCP endpoint attempt deadline exceeded");
        }
        return (int) Math.max(1L, Math.min(i, Math.min(jElapsedRealtime, 2147483647L)));
    }

    private void k() {
        if (e() > 0) {
            this.i = SystemClock.elapsedRealtime();
        }
    }

    public final void c(final i iVar, final i.a aVar) {
        RejectedExecutionException rejectedExecutionException;
        boolean zD;
        com.anythink.core.common.u.b.d dVar = new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cO + "_" + iVar.a(), new Runnable() { // from class: com.anythink.core.common.l.e.a.e$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.f(iVar, aVar);
            }
        });
        if (b()) {
            try {
                zD = com.anythink.core.common.u.b.c.a().d(dVar);
                rejectedExecutionException = null;
            } catch (Throwable th) {
                rejectedExecutionException = th;
                zD = false;
            }
            if (zD) {
                return;
            }
            g();
            if (rejectedExecutionException == null) {
                rejectedExecutionException = new RejectedExecutionException("TCP-first executor is saturated");
            }
            a(aVar, rejectedExecutionException);
            return;
        }
        com.anythink.core.common.u.b.c.a().c(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(i iVar, i.a aVar) {
        Throwable thD;
        try {
            if (a()) {
                synchronized (this) {
                    thD = d(iVar, aVar);
                }
            } else {
                thD = d(iVar, aVar);
            }
            if (thD != null) {
                a(aVar, thD);
            }
            g();
        } catch (Throwable th) {
            g();
            throw th;
        }
    }

    private Throwable d(i iVar, i.a aVar) {
        long j;
        if (!iVar.i()) {
            return e(iVar, aVar);
        }
        try {
            h hVarA_ = iVar.a_();
            long j2 = iVar.j();
            if (j2 <= 0) {
                j = 0;
            } else {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j3 = j2 - jElapsedRealtime;
                if (j3 > 0) {
                    jElapsedRealtime += Math.max(1L, j3 / 2);
                }
                j = jElapsedRealtime;
            }
            Throwable thA = a(iVar, aVar, hVarA_, j, "main");
            if (thA == null) {
                return null;
            }
            h hVarH = iVar.h();
            boolean z = false;
            if (hVarH != null && !TextUtils.isEmpty(hVarH.a()) && hVarH.b() > 0 && (hVarA_ == null || !TextUtils.equals(hVarA_.a(), hVarH.a()) || hVarA_.b() != hVarH.b())) {
                z = true;
            }
            if (!z) {
                return thA;
            }
            if (j2 > 0 && j2 <= SystemClock.elapsedRealtime()) {
                return thA;
            }
            h();
            Throwable thA2 = a(iVar, aVar, hVarH, j2, LiveConfigKey.BACKUP);
            if (thA2 == null) {
                return null;
            }
            return thA2;
        } catch (Throwable th) {
            a(th);
            return th;
        }
    }

    private Throwable e(i iVar, i.a aVar) {
        long j = iVar.j();
        try {
            b(iVar, null, j);
            if (b(iVar, aVar)) {
                l();
            }
            return null;
        } catch (SocketException unused) {
            m();
            h();
            try {
                b(iVar, null, j);
                if (b(iVar, aVar)) {
                    l();
                }
                return null;
            } catch (Throwable th) {
                th = th;
                a(th);
                return th;
            }
        } catch (Throwable th2) {
            th = th2;
            a(th);
            return th;
        }
    }

    private Throwable a(i iVar, i.a aVar, h hVar, long j, String str) {
        if (hVar == null || TextUtils.isEmpty(hVar.a()) || hVar.b() <= 0) {
            return new IllegalArgumentException("TCP " + str + " endpoint is empty");
        }
        try {
            a(iVar, aVar, hVar, j);
            return null;
        } catch (SocketException unused) {
            m();
            h();
            try {
                a(iVar, aVar, hVar, j);
                return null;
            } catch (Throwable th) {
                a(th);
                return th;
            }
        } catch (Throwable th2) {
            a(th2);
            return th2;
        }
    }

    private void a(i iVar, i.a aVar, h hVar, long j) {
        b(iVar, hVar, j);
        if (b(iVar, aVar)) {
            l();
        }
    }

    private static long a(long j) {
        if (j <= 0) {
            return 0L;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = j - jElapsedRealtime;
        return j2 <= 0 ? jElapsedRealtime : jElapsedRealtime + Math.max(1L, j2 / 2);
    }

    private static boolean a(h hVar, h hVar2) {
        if (hVar2 == null || TextUtils.isEmpty(hVar2.a()) || hVar2.b() <= 0) {
            return false;
        }
        return (hVar != null && TextUtils.equals(hVar.a(), hVar2.a()) && hVar.b() == hVar2.b()) ? false : true;
    }

    private static void a(i.a aVar, Throwable th) {
        if (th != null) {
            th.getMessage();
            p.a(th.getStackTrace());
        }
        if (aVar != null) {
            aVar.a(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:0x0027  */
    /* JADX WARN: Code duplicated, block: B:16:0x002a A[Catch: all -> 0x01eb, TryCatch #4 {, blocks: (B:4:0x0003, B:5:0x0006, B:11:0x0020, B:16:0x002a, B:18:0x002f, B:20:0x0035, B:22:0x003b, B:25:0x0043, B:27:0x0049, B:29:0x0055, B:31:0x005d, B:32:0x0060, B:38:0x006d, B:39:0x0071, B:69:0x0167, B:70:0x0168, B:71:0x0169, B:73:0x016d, B:74:0x0178, B:76:0x017e, B:81:0x0186, B:83:0x018a, B:86:0x0191, B:91:0x01a5, B:90:0x01a1, B:85:0x018d, B:40:0x0072, B:42:0x0076, B:44:0x008a, B:46:0x00cf, B:48:0x00d5, B:50:0x00db, B:54:0x00fe, B:61:0x012f, B:63:0x0131, B:65:0x015d, B:66:0x015e, B:67:0x0165, B:52:0x00df, B:45:0x00c7, B:57:0x0101, B:58:0x012a), top: B:109:0x0003, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x003a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0067 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0069  */
    /* JADX WARN: Code duplicated, block: B:36:0x006a  */
    /* JADX WARN: Code duplicated, block: B:38:0x006d A[Catch: all -> 0x01eb, TryCatch #4 {, blocks: (B:4:0x0003, B:5:0x0006, B:11:0x0020, B:16:0x002a, B:18:0x002f, B:20:0x0035, B:22:0x003b, B:25:0x0043, B:27:0x0049, B:29:0x0055, B:31:0x005d, B:32:0x0060, B:38:0x006d, B:39:0x0071, B:69:0x0167, B:70:0x0168, B:71:0x0169, B:73:0x016d, B:74:0x0178, B:76:0x017e, B:81:0x0186, B:83:0x018a, B:86:0x0191, B:91:0x01a5, B:90:0x01a1, B:85:0x018d, B:40:0x0072, B:42:0x0076, B:44:0x008a, B:46:0x00cf, B:48:0x00d5, B:50:0x00db, B:54:0x00fe, B:61:0x012f, B:63:0x0131, B:65:0x015d, B:66:0x015e, B:67:0x0165, B:52:0x00df, B:45:0x00c7, B:57:0x0101, B:58:0x012a), top: B:109:0x0003, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0076 A[Catch: all -> 0x0166, TryCatch #2 {, blocks: (B:40:0x0072, B:42:0x0076, B:44:0x008a, B:46:0x00cf, B:48:0x00d5, B:50:0x00db, B:54:0x00fe, B:61:0x012f, B:63:0x0131, B:65:0x015d, B:66:0x015e, B:67:0x0165, B:52:0x00df, B:45:0x00c7, B:57:0x0101, B:58:0x012a), top: B:106:0x0072, outer: #4, inners: #0, #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x008a A[Catch: all -> 0x0166, TRY_LEAVE, TryCatch #2 {, blocks: (B:40:0x0072, B:42:0x0076, B:44:0x008a, B:46:0x00cf, B:48:0x00d5, B:50:0x00db, B:54:0x00fe, B:61:0x012f, B:63:0x0131, B:65:0x015d, B:66:0x015e, B:67:0x0165, B:52:0x00df, B:45:0x00c7, B:57:0x0101, B:58:0x012a), top: B:106:0x0072, outer: #4, inners: #0, #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00d5 A[Catch: all -> 0x0166, TryCatch #2 {, blocks: (B:40:0x0072, B:42:0x0076, B:44:0x008a, B:46:0x00cf, B:48:0x00d5, B:50:0x00db, B:54:0x00fe, B:61:0x012f, B:63:0x0131, B:65:0x015d, B:66:0x015e, B:67:0x0165, B:52:0x00df, B:45:0x00c7, B:57:0x0101, B:58:0x012a), top: B:106:0x0072, outer: #4, inners: #0, #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00da  */
    /* JADX WARN: Code duplicated, block: B:66:0x015e A[Catch: all -> 0x0166, TryCatch #2 {, blocks: (B:40:0x0072, B:42:0x0076, B:44:0x008a, B:46:0x00cf, B:48:0x00d5, B:50:0x00db, B:54:0x00fe, B:61:0x012f, B:63:0x0131, B:65:0x015d, B:66:0x015e, B:67:0x0165, B:52:0x00df, B:45:0x00c7, B:57:0x0101, B:58:0x012a), top: B:106:0x0072, outer: #4, inners: #0, #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x016d A[Catch: all -> 0x01eb, TryCatch #4 {, blocks: (B:4:0x0003, B:5:0x0006, B:11:0x0020, B:16:0x002a, B:18:0x002f, B:20:0x0035, B:22:0x003b, B:25:0x0043, B:27:0x0049, B:29:0x0055, B:31:0x005d, B:32:0x0060, B:38:0x006d, B:39:0x0071, B:69:0x0167, B:70:0x0168, B:71:0x0169, B:73:0x016d, B:74:0x0178, B:76:0x017e, B:81:0x0186, B:83:0x018a, B:86:0x0191, B:91:0x01a5, B:90:0x01a1, B:85:0x018d, B:40:0x0072, B:42:0x0076, B:44:0x008a, B:46:0x00cf, B:48:0x00d5, B:50:0x00db, B:54:0x00fe, B:61:0x012f, B:63:0x0131, B:65:0x015d, B:66:0x015e, B:67:0x0165, B:52:0x00df, B:45:0x00c7, B:57:0x0101, B:58:0x012a), top: B:109:0x0003, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x017e A[Catch: all -> 0x01eb, TRY_LEAVE, TryCatch #4 {, blocks: (B:4:0x0003, B:5:0x0006, B:11:0x0020, B:16:0x002a, B:18:0x002f, B:20:0x0035, B:22:0x003b, B:25:0x0043, B:27:0x0049, B:29:0x0055, B:31:0x005d, B:32:0x0060, B:38:0x006d, B:39:0x0071, B:69:0x0167, B:70:0x0168, B:71:0x0169, B:73:0x016d, B:74:0x0178, B:76:0x017e, B:81:0x0186, B:83:0x018a, B:86:0x0191, B:91:0x01a5, B:90:0x01a1, B:85:0x018d, B:40:0x0072, B:42:0x0076, B:44:0x008a, B:46:0x00cf, B:48:0x00d5, B:50:0x00db, B:54:0x00fe, B:61:0x012f, B:63:0x0131, B:65:0x015d, B:66:0x015e, B:67:0x0165, B:52:0x00df, B:45:0x00c7, B:57:0x0101, B:58:0x012a), top: B:109:0x0003, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0182 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:80:0x0184  */
    /* JADX WARN: Code duplicated, block: B:85:0x018d A[Catch: all -> 0x01eb, TryCatch #4 {, blocks: (B:4:0x0003, B:5:0x0006, B:11:0x0020, B:16:0x002a, B:18:0x002f, B:20:0x0035, B:22:0x003b, B:25:0x0043, B:27:0x0049, B:29:0x0055, B:31:0x005d, B:32:0x0060, B:38:0x006d, B:39:0x0071, B:69:0x0167, B:70:0x0168, B:71:0x0169, B:73:0x016d, B:74:0x0178, B:76:0x017e, B:81:0x0186, B:83:0x018a, B:86:0x0191, B:91:0x01a5, B:90:0x01a1, B:85:0x018d, B:40:0x0072, B:42:0x0076, B:44:0x008a, B:46:0x00cf, B:48:0x00d5, B:50:0x00db, B:54:0x00fe, B:61:0x012f, B:63:0x0131, B:65:0x015d, B:66:0x015e, B:67:0x0165, B:52:0x00df, B:45:0x00c7, B:57:0x0101, B:58:0x012a), top: B:109:0x0003, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x01a1 A[Catch: all -> 0x01eb, TryCatch #4 {, blocks: (B:4:0x0003, B:5:0x0006, B:11:0x0020, B:16:0x002a, B:18:0x002f, B:20:0x0035, B:22:0x003b, B:25:0x0043, B:27:0x0049, B:29:0x0055, B:31:0x005d, B:32:0x0060, B:38:0x006d, B:39:0x0071, B:69:0x0167, B:70:0x0168, B:71:0x0169, B:73:0x016d, B:74:0x0178, B:76:0x017e, B:81:0x0186, B:83:0x018a, B:86:0x0191, B:91:0x01a5, B:90:0x01a1, B:85:0x018d, B:40:0x0072, B:42:0x0076, B:44:0x008a, B:46:0x00cf, B:48:0x00d5, B:50:0x00db, B:54:0x00fe, B:61:0x012f, B:63:0x0131, B:65:0x015d, B:66:0x015e, B:67:0x0165, B:52:0x00df, B:45:0x00c7, B:57:0x0101, B:58:0x012a), top: B:109:0x0003, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x01e9 A[DONT_GENERATE] */
    /* JADX WARN: Instruction removed from duplicated block: B:78:0x0182, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:94:0x01e9, please report this as an issue */
    private synchronized void b(i iVar, h hVar, long j) {
        long jE;
        boolean z;
        h hVarA_;
        Socket socket;
        byte[] bArrC;
        int length;
        int i;
        byte[] bArr;
        int iA;
        com.anythink.core.common.l.c.a aVar;
        InetAddress address;
        String hostAddress;
        if (hVar != null) {
            iVar.a(hVar);
            long j2 = this.i;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            jE = e();
            if (jE > 0 || j2 <= 0 || jElapsedRealtime < j2 || jElapsedRealtime - j2 < jE) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                h();
            }
            if (hVar == null || !c()) {
                hVarA_ = hVar;
            } else {
                hVarA_ = iVar.a_();
            }
            if (c() && hVarA_ != null && i() && (!TextUtils.equals(this.f, hVarA_.a()) || this.g != hVarA_.b())) {
                h();
            }
            if (!i()) {
                if (hVar != null) {
                    hVar = hVarA_;
                }
                if (hVar == null) {
                    hVar = iVar.a_();
                }
                synchronized (this) {
                    if (this.b == null) {
                        Socket socket2 = new Socket();
                        this.b = socket2;
                        socket2.setSoTimeout(a(d(), j));
                    }
                    if (hVar != null) {
                        this.f = hVar.a();
                        this.g = hVar.b();
                        aVar = new com.anythink.core.common.l.c.a();
                        aVar.d(iVar.getClass().getName());
                        aVar.e(this.f + ":" + this.g);
                        aVar.f(2);
                        try {
                            InetSocketAddress inetSocketAddressA = a(this.f, this.g, aVar, j);
                            address = inetSocketAddressA.getAddress();
                            if (address != null) {
                                hostAddress = address.getHostAddress();
                            } else {
                                hostAddress = null;
                            }
                            this.h = hostAddress;
                            try {
                                int iA2 = a(30000, j);
                                this.b.setSoTimeout(a(d(), j));
                                this.b.connect(inetSocketAddressA, iA2);
                                k();
                                aVar.b(1);
                                try {
                                    com.anythink.core.common.t.f.a(aVar);
                                } catch (Throwable unused) {
                                }
                            } catch (Throwable th) {
                                try {
                                    aVar.b(0);
                                    aVar.c(th.getClass().getSimpleName() + ": " + th.getMessage());
                                    throw th;
                                } catch (Throwable th2) {
                                    try {
                                        com.anythink.core.common.t.f.a(aVar);
                                    } catch (Throwable unused2) {
                                    }
                                    throw th2;
                                }
                            }
                        } catch (Throwable th3) {
                            aVar.b(0);
                            aVar.c(th3.getClass().getSimpleName() + ": " + th3.getMessage());
                            try {
                                com.anythink.core.common.t.f.a(aVar);
                            } catch (Throwable unused3) {
                            }
                            throw th3;
                        }
                    } else {
                        throw new IllegalArgumentException("The domain must not can be null or empty.");
                    }
                }
            }
            socket = this.b;
            if (socket != null) {
                socket.setSoTimeout(a(d(), j));
            }
            bArrC = iVar.c();
            if (bArrC != null) {
                length = bArrC.length;
                if (bArrC.length == 0) {
                    return;
                }
                i = length + 7;
                bArr = this.j;
                if (bArr != null || bArr.length < i) {
                    this.j = new byte[i];
                }
                this.j[0] = 0;
                iA = iVar.a();
                if (iA != 12 || iA == 13) {
                    this.j[0] = 1;
                }
                byte[] bArr2 = this.j;
                bArr2[1] = 3;
                bArr2[2] = (byte) iVar.a();
                byte[] bArr3 = this.j;
                bArr3[3] = (byte) ((length >>> 24) & 255);
                bArr3[4] = (byte) ((length >>> 16) & 255);
                bArr3[5] = (byte) ((length >>> 8) & 255);
                bArr3[6] = (byte) ((length >>> 0) & 255);
                System.arraycopy(bArrC, 0, bArr3, 7, bArrC.length);
                OutputStream outputStream = this.b.getOutputStream();
                outputStream.write(this.j, 0, i);
                outputStream.flush();
                k();
                return;
            }
            return;
        }
        long j3 = this.i;
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        jE = e();
        if (jE > 0) {
            z = false;
        } else {
            z = false;
        }
        if (z) {
            h();
        }
        if (hVar == null) {
            hVarA_ = hVar;
        } else {
            hVarA_ = hVar;
        }
        if (c()) {
            h();
        }
        if (!i()) {
            if (hVar != null) {
                hVar = hVarA_;
            }
            if (hVar == null) {
                hVar = iVar.a_();
            }
            synchronized (this) {
                if (this.b == null) {
                    Socket socket3 = new Socket();
                    this.b = socket3;
                    socket3.setSoTimeout(a(d(), j));
                }
                if (hVar != null) {
                    this.f = hVar.a();
                    this.g = hVar.b();
                    aVar = new com.anythink.core.common.l.c.a();
                    aVar.d(iVar.getClass().getName());
                    aVar.e(this.f + ":" + this.g);
                    aVar.f(2);
                    InetSocketAddress inetSocketAddressA2 = a(this.f, this.g, aVar, j);
                    address = inetSocketAddressA2.getAddress();
                    if (address != null) {
                        hostAddress = address.getHostAddress();
                    } else {
                        hostAddress = null;
                    }
                    this.h = hostAddress;
                    int iA3 = a(30000, j);
                    this.b.setSoTimeout(a(d(), j));
                    this.b.connect(inetSocketAddressA2, iA3);
                    k();
                    aVar.b(1);
                    com.anythink.core.common.t.f.a(aVar);
                } else {
                    throw new IllegalArgumentException("The domain must not can be null or empty.");
                }
            }
        }
        socket = this.b;
        if (socket != null) {
            socket.setSoTimeout(a(d(), j));
        }
        bArrC = iVar.c();
        if (bArrC != null) {
            length = bArrC.length;
            if (bArrC.length == 0) {
                return;
            }
            i = length + 7;
            bArr = this.j;
            if (bArr != null) {
                this.j = new byte[i];
            } else {
                this.j = new byte[i];
            }
            this.j[0] = 0;
            iA = iVar.a();
            if (iA != 12) {
                this.j[0] = 1;
            } else {
                this.j[0] = 1;
            }
            byte[] bArr4 = this.j;
            bArr4[1] = 3;
            bArr4[2] = (byte) iVar.a();
            byte[] bArr5 = this.j;
            bArr5[3] = (byte) ((length >>> 24) & 255);
            bArr5[4] = (byte) ((length >>> 16) & 255);
            bArr5[5] = (byte) ((length >>> 8) & 255);
            bArr5[6] = (byte) ((length >>> 0) & 255);
            System.arraycopy(bArrC, 0, bArr5, 7, bArrC.length);
            OutputStream outputStream2 = this.b.getOutputStream();
            outputStream2.write(this.j, 0, i);
            outputStream2.flush();
            k();
            return;
        }
        return;
        throw th;
    }

    protected final int a(InputStream inputStream) throws SocketException {
        if (inputStream.read(this.k, 0, 1) == -1) {
            throw new SocketException("Socket.InputStream read length = -1!");
        }
        byte[] bArr = this.k;
        byte b = bArr[0];
        bArr[0] = 0;
        return b;
    }

    protected boolean b(i iVar, i.a aVar) {
        a(iVar, aVar);
        return false;
    }

    private void l() {
        String strO = o();
        if (TextUtils.isEmpty(this.f) || TextUtils.isEmpty(strO)) {
            return;
        }
        com.anythink.core.common.l.b.b.a().a(this.f, strO);
    }

    private void m() {
        String strO = o();
        if (TextUtils.isEmpty(this.f) || TextUtils.isEmpty(strO)) {
            return;
        }
        com.anythink.core.common.l.b.b.a().b(this.f, strO);
    }

    private void a(Throwable th) {
        if (b(th)) {
            try {
                m();
            } finally {
                h();
            }
        }
    }

    private void n() {
        h();
    }

    private static boolean b(Throwable th) {
        return (th instanceof SocketException) || (th instanceof SocketTimeoutException) || (th instanceof EOFException);
    }

    private String o() {
        try {
            Socket socket = this.b;
            InetAddress inetAddress = socket != null ? socket.getInetAddress() : null;
            return inetAddress != null ? inetAddress.getHostAddress() : this.h;
        } catch (Throwable unused) {
            return this.h;
        }
    }

    protected final void a(i.a aVar) throws IOException {
        b(aVar);
    }

    protected final boolean b(i.a aVar) throws IOException {
        boolean z;
        InputStream inputStream = this.b.getInputStream();
        a(inputStream, new byte[1], 1);
        int iA = a(inputStream);
        if (iA == 2) {
            z = false;
        } else {
            if (iA != 3) {
                if (aVar != null) {
                    aVar.a((Object) null);
                }
                return false;
            }
            z = true;
        }
        a(inputStream, new byte[1], 1);
        byte[] bArr = new byte[4];
        a(inputStream, bArr, 4);
        int i = ByteBuffer.wrap(bArr).getInt();
        if (i <= 0 || i > 5242880) {
            if (aVar != null) {
                aVar.a((Object) null);
            }
            return false;
        }
        byte[] bArrA = new byte[i];
        a(inputStream, bArrA, i);
        if (z) {
            bArrA = a(bArrA);
        }
        if (bArrA == null) {
            if (aVar != null) {
                aVar.a((Object) null);
            }
            return false;
        }
        String str = new String(bArrA, "UTF-8");
        if (aVar != null) {
            aVar.a(str);
        }
        return true;
    }

    protected static void a(InputStream inputStream, byte[] bArr, int i) throws IOException {
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, i2, i - i2);
            if (i3 < 0) {
                throw new EOFException("stream closed before reading " + i + " bytes");
            }
            i2 += i3;
        }
    }

    private static byte[] a(byte[] bArr) {
        if (bArr.length == 0) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 2);
        try {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int i = gZIPInputStream.read(bArr2);
                    if (i <= 0) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        gZIPInputStream.close();
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr2, 0, i);
                    return null;
                }
            } catch (Throwable th) {
                try {
                    gZIPInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable unused) {
            return null;
        }
    }
}
