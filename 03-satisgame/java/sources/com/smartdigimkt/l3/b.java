package com.smartdigimkt.l3;

import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.text.TextUtils;
import com.smartdigimkt.d0.u;
import com.smartdigimkt.d0.w;
import com.smartdigimkt.d0.x;
import com.smartdigimkt.h0.g;
import com.smartdigimkt.h0.m;
import com.smartdigimkt.i3.n;
import com.smartdigimkt.n3.k;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.r4.i;
import com.smartdigimkt.t2.y;
import com.smartdigimkt.t2.z;
import com.smartdigimkt.z.s;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.smartdigimkt.k3.d {
    public int A;
    public final c k;
    public final ArrayList l;
    public x m;
    public int n;
    public int o;
    public long p;
    public long q;
    public boolean r;
    public boolean s;
    public String t;
    public volatile boolean u;
    public boolean v;
    public boolean w;
    public long x;
    public MediaMetadataRetriever y;
    public final Object z;

    public b(String str) {
        super(str);
        this.z = new Object();
        this.A = -1;
        this.l = new ArrayList();
        this.k = new c();
        this.o = 0;
        this.p = 0L;
        this.u = false;
        this.q = 0L;
        this.r = false;
        this.s = false;
        this.x = 0L;
        this.n = 0;
    }

    public final void a(c cVar) {
        synchronized (this.z) {
            int i = cVar.a;
            int i2 = cVar.b;
            long j = cVar.d;
            int i3 = cVar.c;
            c cVar2 = this.k;
            if (cVar2.a < i) {
                cVar2.a = i;
            }
            if (j > this.x) {
                this.x = j;
            }
            cVar2.c = i3;
            if (Build.VERSION.SDK_INT <= 24) {
                cVar2.b = 1;
            } else if (cVar2.b != 1) {
                cVar2.b = i2;
            }
        }
    }

    public final boolean b(int i) {
        synchronized (this.z) {
            if (this.u) {
                return true;
            }
            if (this.f < 512000) {
                return true;
            }
            c cVar = this.k;
            if (cVar == null) {
                return true;
            }
            if (cVar.c == 1) {
                return true;
            }
            int i2 = cVar.b;
            if (i2 == 2 && i >= cVar.a) {
                return false;
            }
            if (i2 == 1) {
                return true;
            }
            ArrayList arrayList = this.l;
            return arrayList == null || arrayList.size() != 0;
        }
    }

    public final boolean d() {
        int i = this.o;
        if (i != 100) {
            return this.n == 0 && i < 100;
        }
        a(i, this.p);
        int i2 = this.o;
        long j = this.p;
        if (i2 == 100) {
            z zVarA = z.a();
            String str = this.b;
            String str2 = this.t;
            long j2 = this.f;
            zVarA.c.put(str, Integer.valueOf(i2));
            f.a().a(new y(zVarA, str, str2, j2, j, i2), 0L, 13);
            x xVar = this.m;
            if (xVar != null) {
                s.a(30, xVar.a, new m());
            }
        }
        return false;
    }

    public final synchronized void e() {
        this.l.clear();
    }

    public final void f() {
        String strB = n.a().b(4);
        if (TextUtils.isEmpty(strB)) {
            a("", "without saveDirectory");
        } else {
            File file = new File(strB);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.t = n.a().b(4, i.b(this.b));
            File file2 = new File(this.t);
            if (file2.exists()) {
                this.p = file2.length();
            }
        }
        this.s = this.p > 0;
        this.v = false;
        this.w = false;
        this.n = 1;
        c();
    }

    public final void g() {
        long j;
        if (this.x > 0 && this.y == null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            this.y = mediaMetadataRetriever;
            int i = this.k.a;
            try {
                mediaMetadataRetriever.setDataSource(this.t);
                j = Long.parseLong(this.y.extractMetadata(9));
                if (j > 0) {
                    try {
                        int i2 = (int) (((this.x + 500) * 100) / j);
                        i = 100;
                        if (i2 <= 100) {
                            i = i2;
                        }
                        c cVar = this.k;
                        if (cVar.a < i) {
                            cVar.a = i;
                        }
                    } catch (Throwable unused) {
                    }
                }
            } catch (Throwable unused2) {
                j = -1;
            }
            try {
                this.y.release();
            } catch (Throwable unused3) {
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            long j2 = this.x;
            a aVar = new a(j2, j, jCurrentTimeMillis2, i);
            synchronized (this) {
                Iterator it = this.l.iterator();
                while (it.hasNext()) {
                    com.smartdigimkt.d0.y yVar = ((w) it.next()).c;
                    yVar.e = aVar;
                    long j3 = yVar.d;
                    if (j3 > 0 && j3 == aVar.a) {
                        yVar.b.S = aVar.d;
                    }
                }
            }
            int i3 = this.k.a;
        }
    }

    public final synchronized void a(boolean z) {
        this.n = 0;
        this.v = false;
        boolean z2 = z && this.w;
        this.w = false;
        if (z2 && d()) {
            f();
        }
    }

    public final synchronized void a(int i, long j) {
        j = j;
        synchronized (this) {
            if (this.A != i) {
                this.A = i;
            }
            z.a().c.put(this.b, Integer.valueOf(i));
            Iterator it = this.l.iterator();
            if (this.f > 512000 || i == 100) {
                boolean z = false;
                while (it.hasNext()) {
                    w wVar = (w) it.next();
                    long j2 = this.f;
                    com.smartdigimkt.d0.y yVar = wVar.c;
                    if (i >= yVar.b.S) {
                        com.smartdigimkt.d0.y.a(yVar, j);
                        wVar.c.getClass();
                        if (wVar.c.e != null) {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            com.smartdigimkt.d0.y yVar2 = wVar.c;
                            long j3 = jCurrentTimeMillis - yVar2.f;
                            a aVar = yVar2.e;
                            k.a(wVar.a, wVar.b, true, "", j2, j, j3, aVar.b, aVar.c, aVar.d);
                        } else {
                            k.a(wVar.a, wVar.b, true, "", j2, j, System.currentTimeMillis() - wVar.c.f, 0L, 0L, 0);
                        }
                        u.a().a(i, wVar.c.a);
                        z = i != 100;
                        it.remove();
                    }
                }
                if (z) {
                    z zVarA = z.a();
                    String str = this.b;
                    String str2 = this.t;
                    long j4 = this.f;
                    zVarA.getClass();
                    f.a().a(new y(zVarA, str, str2, j4, j, i), 0L, 13);
                }
            }
        }
    }

    @Override // com.smartdigimkt.k3.d
    public final Map b() {
        this.q = 0L;
        this.r = false;
        if (!this.s) {
            return null;
        }
        long j = this.p;
        if (j <= 0) {
            return null;
        }
        this.q = j;
        HashMap map = new HashMap();
        map.put("Range", "bytes=" + this.q + "-");
        map.put("Accept-Encoding", "identity");
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r8v3, types: [int] */
    @Override // com.smartdigimkt.k3.d
    public final boolean a(InputStream inputStream) {
        ?? r8;
        FileOutputStream fileOutputStream;
        boolean z = false;
        if (!TextUtils.isEmpty(this.t)) {
            try {
                long j = this.p;
                r8 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (r8 > 0) {
                    long j2 = this.f;
                    if (j2 > 0 && j > j2) {
                        new File(this.t).delete();
                        this.p = 0L;
                        this.o = 0;
                        throw new Exception("cached video file larger than total size, deleted");
                    }
                }
                try {
                    if (r8 > 0) {
                        fileOutputStream = new FileOutputStream(this.t, true);
                        if (!this.r) {
                            if (this.p != inputStream.skip(this.p)) {
                                throw new Exception("continue download video failed with skip error");
                            }
                        }
                        long j3 = this.f;
                        if (j3 > 0) {
                            this.o = (int) (((this.p * 1.0d) / j3) * 100.0d);
                        }
                        a(this.o, this.p);
                    } else {
                        fileOutputStream = new FileOutputStream(this.t);
                        this.o = 0;
                    }
                    FileOutputStream fileOutputStream2 = fileOutputStream;
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i == -1 || !b(this.o)) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, i);
                        long j4 = this.p + ((long) i);
                        this.p = j4;
                        long j5 = this.f;
                        if (j5 > 0) {
                            this.o = (int) (((j4 * 1.0d) / j5) * 100.0d);
                        }
                        if (this.o >= 5) {
                            g();
                        }
                        a(this.o, this.p);
                    }
                    fileOutputStream2.close();
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable unused) {
                    }
                    z = true;
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.getMessage();
                        if (r8 != 0) {
                            try {
                                r8.close();
                            } catch (Throwable unused2) {
                            }
                        }
                    } catch (Throwable th2) {
                        if (r8 != 0) {
                            try {
                                r8.close();
                                throw th2;
                            } catch (Throwable unused3) {
                                throw th2;
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                r8 = 0;
            }
        }
        int i2 = this.o;
        long j6 = this.p;
        if (i2 == 100) {
            z zVarA = z.a();
            String str = this.b;
            String str2 = this.t;
            long j7 = this.f;
            zVarA.c.put(str, Integer.valueOf(i2));
            f.a().a(new y(zVarA, str, str2, j7, j6, i2), 0L, 13);
            x xVar = this.m;
            if (xVar != null) {
                s.a(30, xVar.a, new m());
            }
        }
        return z;
    }

    @Override // com.smartdigimkt.k3.d
    public final boolean a(int i) {
        long j = this.q;
        if (j <= 0 || i != 416) {
            return i == 200 || (j > 0 && i == 206);
        }
        if (!TextUtils.isEmpty(this.t)) {
            new File(this.t).delete();
        }
        this.p = 0L;
        this.o = 0;
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0049  */
    @Override // com.smartdigimkt.k3.d
    public final void a(HttpURLConnection httpURLConnection, int i) {
        long jMax;
        if (this.q > 0 && i == 206) {
            this.r = true;
            String headerField = httpURLConnection.getHeaderField("Content-Range");
            if (TextUtils.isEmpty(headerField)) {
                jMax = -1;
            } else {
                try {
                    int iLastIndexOf = headerField.lastIndexOf(47);
                    if (iLastIndexOf < 0 || iLastIndexOf >= headerField.length() - 1) {
                        jMax = -1;
                    } else {
                        String strTrim = headerField.substring(iLastIndexOf + 1).trim();
                        if (TextUtils.isEmpty(strTrim) || TextUtils.equals(strTrim, "*")) {
                            jMax = -1;
                        } else {
                            jMax = Long.parseLong(strTrim);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            long contentLength = httpURLConnection.getContentLength();
            if (jMax <= 0) {
                jMax = this.q + Math.max(contentLength, 0L);
            }
            this.f = jMax;
            return;
        }
        this.f = httpURLConnection.getContentLength();
    }

    @Override // com.smartdigimkt.k3.d
    public final void a(com.smartdigimkt.k3.c cVar) {
        f.a().a(cVar, 20);
    }

    @Override // com.smartdigimkt.k3.d
    public final void a() {
        a(true);
    }

    @Override // com.smartdigimkt.k3.d
    public final void a(String str) {
        a(com.anythink.core.common.res.image.c.a, str);
    }

    public final synchronized void a(String str, String str2) {
        a(false);
        for (w wVar : this.l) {
            wVar.c.getClass();
            k.a(wVar.a, wVar.b, false, str2, 0.0d, 0.0d, 0L, 0L, 0L, 0);
        }
        e();
        x xVar = this.m;
        if (xVar != null) {
            xVar.b.getClass();
            u.a().a(xVar.b.a, new g(str, str2));
        }
    }
}
