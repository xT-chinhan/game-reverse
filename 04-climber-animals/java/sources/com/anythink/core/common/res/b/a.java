package com.anythink.core.common.res.b;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.anythink.core.common.d.t;
import com.anythink.core.common.res.d;
import com.anythink.core.common.v.o;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.anythink.core.common.res.image.b {
    final String a;
    public com.anythink.core.common.res.b.b b;
    public List<b> c;
    public c k;
    int l;
    private final int m;
    private final int n;
    private int o;
    private int p;
    private long q;
    private String r;
    private boolean s;
    private final long t;
    private long u;
    private MediaMetadataRetriever v;
    private Object w;

    public static abstract class b {
        public abstract void a(C0098a c0098a);

        public abstract void a(String str, String str2);

        public abstract boolean a(int i, long j, long j2);
    }

    public static abstract class c {
        public abstract void a();

        public abstract void a(String str, String str2);
    }

    @Override // com.anythink.core.common.res.image.b
    protected final Map<String, String> a() {
        return null;
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void b() {
    }

    public a(String str) {
        super(str);
        this.a = "a";
        this.m = 0;
        this.n = 1;
        this.t = 512000L;
        this.w = new Object();
        this.l = -1;
        this.c = new ArrayList();
        this.b = new com.anythink.core.common.res.b.b();
        this.p = 0;
        this.q = 0L;
        this.s = false;
        this.u = 0L;
        this.o = 0;
    }

    public final void a(com.anythink.core.common.res.b.b bVar) {
        synchronized (this.w) {
            String str = this.d;
            int i = bVar.a;
            int i2 = bVar.c;
            long j = bVar.d;
            if (this.b.a < bVar.a) {
                this.b.a = bVar.a;
            }
            if (bVar.d > this.u) {
                this.u = bVar.d;
            }
            if (this.b.c != 1) {
                this.b.c = bVar.c;
            }
        }
    }

    public final synchronized void a(b bVar) {
        if (!this.c.contains(bVar)) {
            this.c.add(bVar);
        }
    }

    private void a(c cVar) {
        this.k = cVar;
    }

    private void a(int i) {
        this.o = i;
    }

    private int h() {
        return this.o;
    }

    public final void e() {
        String str = this.d;
        j();
        if (j()) {
            i();
            this.o = 1;
            d();
        }
    }

    public final void f() {
        String str = this.d;
        j();
        this.s = true;
        if (j()) {
            i();
            this.o = 1;
            d();
        }
    }

    public final void g() {
        String str = this.d;
        this.s = false;
        this.o = 0;
    }

    private void i() {
        String strA = d.a(t.b().g()).a(4);
        if (TextUtils.isEmpty(strA)) {
            b("", "without saveDirectory");
            return;
        }
        File file = new File(strA);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.r = d.a(t.b().g()).c(4, o.a(this.d));
        File file2 = new File(this.r);
        if (file2.exists()) {
            this.q = file2.length();
        }
    }

    private boolean j() {
        int i = this.p;
        if (i != 100) {
            return this.o == 0 && i < 100;
        }
        a(i, this.q);
        b(this.p, this.q);
        return false;
    }

    private boolean b(int i) {
        synchronized (this.w) {
            if (this.s) {
                return true;
            }
            if (this.j < 512000) {
                return true;
            }
            if (this.b.c == 2 && i >= this.b.a) {
                return false;
            }
            if (this.b.c == 1) {
                return true;
            }
            List<b> list = this.c;
            return list == null || list.size() != 0;
        }
    }

    private synchronized void a(int i, long j) {
        if (this.l != i) {
            String str = this.d;
            this.l = i;
        }
        com.anythink.core.common.a.o.a().a(this.d, this.r, this.j, j, i, false);
        Iterator<b> it = this.c.iterator();
        boolean z = false;
        if (this.j > 512000 || i == 100) {
            boolean z2 = false;
            while (it.hasNext()) {
                if (it.next().a(i, j, this.j)) {
                    z2 = i != 100;
                    it.remove();
                }
            }
            z = z2;
        }
        if (z) {
            com.anythink.core.common.a.o.a().a(this.d, this.r, this.j, j, i);
        }
    }

    private void b(int i, long j) {
        String str = this.d;
        if (i == 100) {
            com.anythink.core.common.a.o.a().a(this.d, this.r, this.j, j, i, true);
            c cVar = this.k;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.res.b.a$a, reason: collision with other inner class name */
    public class C0098a {
        long a;
        long b;
        long c;
        int d;

        public C0098a(long j, long j2, long j3, int i) {
            this.a = j;
            this.b = j2;
            this.c = j3;
            this.d = i;
        }

        public final long a() {
            return this.a;
        }

        public final long b() {
            return this.b;
        }

        public final long c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }
    }

    @Override // com.anythink.core.common.res.image.b
    protected final boolean a(InputStream inputStream) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        byte[] bArr;
        int i;
        long j;
        MediaMetadataRetriever mediaMetadataRetriever;
        boolean z = false;
        int i2 = 0;
        if (!TextUtils.isEmpty(this.r)) {
            FileOutputStream fileOutputStream3 = null;
            try {
                long j2 = this.q;
                long j3 = 0;
                double d = 100.0d;
                boolean z2 = true;
                if (j2 > 0) {
                    long jSkip = inputStream.skip(j2);
                    FileOutputStream fileOutputStream4 = new FileOutputStream(this.r, true);
                    try {
                        int i3 = (int) (((this.q * 1.0d) / this.j) * 100.0d);
                        this.p = i3;
                        long j4 = this.q;
                        if (j4 != jSkip) {
                            throw new Exception("countinu download video fail with skip error");
                        }
                        a(i3, j4);
                        fileOutputStream = fileOutputStream4;
                        try {
                            bArr = new byte[2048];
                            while (true) {
                                i = inputStream.read(bArr);
                                if (i == -1 || !b(this.p)) {
                                    break;
                                }
                                fileOutputStream.write(bArr, i2, i);
                                long j5 = this.q + ((long) i);
                                this.q = j5;
                                int i4 = (int) (((j5 * 1.0d) / this.j) * d);
                                this.p = i4;
                                if (i4 < 5 || this.u <= j3 || this.v != null) {
                                    fileOutputStream2 = fileOutputStream;
                                } else {
                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                    this.v = new MediaMetadataRetriever();
                                    int i5 = this.b.a;
                                    try {
                                        this.v.setDataSource(this.r);
                                        j = Long.parseLong(this.v.extractMetadata(9));
                                        if (j > j3) {
                                            try {
                                                i5 = (int) (((this.u + 500) * 100) / j);
                                                if (i5 > 100) {
                                                    i5 = 100;
                                                }
                                                if (this.b.a < i5) {
                                                    this.b.a = i5;
                                                }
                                            } catch (Throwable unused) {
                                                mediaMetadataRetriever = this.v;
                                            }
                                        }
                                        try {
                                            mediaMetadataRetriever = this.v;
                                        } catch (Throwable unused2) {
                                        }
                                    } catch (Throwable unused3) {
                                        j = -1;
                                    }
                                    mediaMetadataRetriever.release();
                                    long j6 = j;
                                    fileOutputStream2 = fileOutputStream;
                                    try {
                                        a(new C0098a(this.u, j6, System.currentTimeMillis() - jCurrentTimeMillis, i5));
                                        new StringBuilder().append(this.d).append(" tryToResetSplashVideoReadyRateByDuration: mSplashCountDownTime:").append(this.u).append(",videoDuration:").append(j6).append(",after reset readyRate:").append(this.b.a).append(",useTime:");
                                    } catch (Throwable th) {
                                        th = th;
                                    }
                                }
                                a(this.p, this.q);
                                bArr = bArr;
                                z2 = z2;
                                fileOutputStream = fileOutputStream2;
                                i2 = 0;
                                j3 = 0;
                                d = 100.0d;
                                th = th;
                                fileOutputStream3 = fileOutputStream2;
                                try {
                                    th.printStackTrace();
                                    if (fileOutputStream3 != null) {
                                        try {
                                            fileOutputStream3.close();
                                        } catch (Throwable unused4) {
                                        }
                                    }
                                    z = false;
                                } catch (Throwable th2) {
                                    if (fileOutputStream3 != null) {
                                        try {
                                            fileOutputStream3.close();
                                            throw th2;
                                        } catch (Throwable unused5) {
                                            throw th2;
                                        }
                                    }
                                    throw th2;
                                }
                            }
                            fileOutputStream2 = fileOutputStream;
                            boolean z3 = z2;
                            fileOutputStream2.close();
                            try {
                                fileOutputStream2.close();
                            } catch (Throwable unused6) {
                            }
                            z = z3;
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream2 = fileOutputStream;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream3 = fileOutputStream4;
                    }
                } else {
                    FileOutputStream fileOutputStream5 = new FileOutputStream(this.r);
                    try {
                        this.p = 0;
                        fileOutputStream = fileOutputStream5;
                        bArr = new byte[2048];
                        while (true) {
                            i = inputStream.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            break;
                            break;
                            a(this.p, this.q);
                            bArr = bArr;
                            z2 = z2;
                            fileOutputStream = fileOutputStream2;
                            i2 = 0;
                            j3 = 0;
                            d = 100.0d;
                        }
                        fileOutputStream2 = fileOutputStream;
                        boolean z4 = z2;
                        fileOutputStream2.close();
                        fileOutputStream2.close();
                        z = z4;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream3 = fileOutputStream5;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        b(this.p, this.q);
        return z;
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void a(com.anythink.core.common.v.b.d dVar) {
        com.anythink.core.common.v.b.b.a().a(dVar, 4);
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void a(String str, String str2) {
        b(str, str2);
    }

    private synchronized void b(String str, String str2) {
        String str3 = this.d;
        this.o = 0;
        Iterator<b> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a(str, str2);
        }
        k();
        c cVar = this.k;
        if (cVar != null) {
            cVar.a(str, str2);
        }
    }

    private synchronized void a(C0098a c0098a) {
        String str = this.d;
        long j = c0098a.b;
        int i = c0098a.d;
        Iterator<b> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a(c0098a);
        }
    }

    private synchronized void k() {
        this.c.clear();
    }

    private void l() {
        long j;
        MediaMetadataRetriever mediaMetadataRetriever;
        if (this.u > 0 && this.v == null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.v = new MediaMetadataRetriever();
            int i = this.b.a;
            try {
                try {
                    this.v.setDataSource(this.r);
                    j = Long.parseLong(this.v.extractMetadata(9));
                    if (j > 0) {
                        try {
                            int i2 = (int) (((this.u + 500) * 100) / j);
                            i = i2 > 100 ? 100 : i2;
                            if (this.b.a < i) {
                                this.b.a = i;
                            }
                        } catch (Throwable unused) {
                            mediaMetadataRetriever = this.v;
                        }
                    }
                    mediaMetadataRetriever = this.v;
                } catch (Throwable unused2) {
                    j = -1;
                }
                mediaMetadataRetriever.release();
            } catch (Throwable unused3) {
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            a(new C0098a(this.u, j, jCurrentTimeMillis2, i));
            String str = this.d;
            int i3 = this.b.a;
        }
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void c() {
        this.o = 0;
    }
}
