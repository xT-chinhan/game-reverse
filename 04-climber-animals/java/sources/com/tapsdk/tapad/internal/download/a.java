package com.tapsdk.tapad.internal.download;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tapsdk.tapad.internal.download.core.cause.EndCause;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static final String f = "DownloadContext";
    private static final Executor g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new SynchronousQueue(), com.tapsdk.tapad.internal.download.m.c.a("OkDownload Serial", false));
    private final com.tapsdk.tapad.internal.download.f[] a;
    volatile boolean b;
    final com.tapsdk.tapad.internal.download.b c;
    private final f d;
    private Handler e;

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.download.a$a, reason: collision with other inner class name */
    class RunnableC0604a implements Runnable {
        final /* synthetic */ List a;
        final /* synthetic */ com.tapsdk.tapad.internal.download.c b;

        RunnableC0604a(List list, com.tapsdk.tapad.internal.download.c cVar) {
            this.a = list;
            this.b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (com.tapsdk.tapad.internal.download.f fVar : this.a) {
                if (!a.this.c()) {
                    a.this.a(fVar.y());
                    return;
                }
                fVar.b(this.b);
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.c.a(aVar);
        }
    }

    public static class c {
        private final a a;

        c(a aVar) {
            this.a = aVar;
        }

        public c a(com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.f fVar2) {
            com.tapsdk.tapad.internal.download.f[] fVarArr = this.a.a;
            for (int i = 0; i < fVarArr.length; i++) {
                if (fVarArr[i] == fVar) {
                    fVarArr[i] = fVar2;
                }
            }
            return this;
        }
    }

    public static class d {
        final ArrayList<com.tapsdk.tapad.internal.download.f> a;
        private final f b;
        private com.tapsdk.tapad.internal.download.b c;

        public d() {
            this(new f());
        }

        public d(f fVar) {
            this(fVar, new ArrayList());
        }

        public d(f fVar, ArrayList<com.tapsdk.tapad.internal.download.f> arrayList) {
            this.b = fVar;
            this.a = arrayList;
        }

        public d a(com.tapsdk.tapad.internal.download.b bVar) {
            this.c = bVar;
            return this;
        }

        public d a(com.tapsdk.tapad.internal.download.f fVar) {
            int iIndexOf = this.a.indexOf(fVar);
            if (iIndexOf >= 0) {
                this.a.set(iIndexOf, fVar);
            } else {
                this.a.add(fVar);
            }
            return this;
        }

        public a a() {
            return new a((com.tapsdk.tapad.internal.download.f[]) this.a.toArray(new com.tapsdk.tapad.internal.download.f[this.a.size()]), this.c, this.b);
        }

        public com.tapsdk.tapad.internal.download.f a(com.tapsdk.tapad.internal.download.f.a aVar) {
            if (this.b.a != null) {
                aVar.a(this.b.a);
            }
            if (this.b.c != null) {
                aVar.e(this.b.c.intValue());
            }
            if (this.b.d != null) {
                aVar.b(this.b.d.intValue());
            }
            if (this.b.e != null) {
                aVar.g(this.b.e.intValue());
            }
            if (this.b.j != null) {
                aVar.e(this.b.j.booleanValue());
            }
            if (this.b.f != null) {
                aVar.f(this.b.f.intValue());
            }
            if (this.b.g != null) {
                aVar.a(this.b.g.booleanValue());
            }
            if (this.b.h != null) {
                aVar.c(this.b.h.intValue());
            }
            if (this.b.i != null) {
                aVar.c(this.b.i.booleanValue());
            }
            com.tapsdk.tapad.internal.download.f fVarA = aVar.a();
            if (this.b.k != null) {
                fVarA.a(this.b.k);
            }
            this.a.add(fVarA);
            return fVarA;
        }

        public com.tapsdk.tapad.internal.download.f a(String str) {
            if (this.b.b != null) {
                return a(new com.tapsdk.tapad.internal.download.f.a(str, this.b.b).a(Boolean.TRUE));
            }
            throw new IllegalArgumentException("If you want to bind only with url, you have to provide parentPath on QueueSet!");
        }

        public void a(int i) {
            for (com.tapsdk.tapad.internal.download.f fVar : (List) this.a.clone()) {
                if (fVar.b() == i) {
                    this.a.remove(fVar);
                }
            }
        }

        public void b(com.tapsdk.tapad.internal.download.f fVar) {
            this.a.remove(fVar);
        }
    }

    static class e extends com.tapsdk.tapad.internal.download.m.i.b {
        private final AtomicInteger a;
        private final com.tapsdk.tapad.internal.download.b b;
        private final a c;

        e(a aVar, com.tapsdk.tapad.internal.download.b bVar, int i) {
            this.a = new AtomicInteger(i);
            this.b = bVar;
            this.c = aVar;
        }

        @Override // com.tapsdk.tapad.internal.download.c
        public void a(com.tapsdk.tapad.internal.download.f fVar) {
        }

        @Override // com.tapsdk.tapad.internal.download.c
        public void a(com.tapsdk.tapad.internal.download.f fVar, EndCause endCause, Exception exc) {
            int iDecrementAndGet = this.a.decrementAndGet();
            this.b.a(this.c, fVar, endCause, exc, iDecrementAndGet);
            if (iDecrementAndGet <= 0) {
                this.b.a(this.c);
                com.tapsdk.tapad.internal.download.m.c.a(a.f, "taskEnd and remainCount " + iDecrementAndGet);
            }
        }
    }

    public static class f {
        private Map<String, List<String>> a;
        private Uri b;
        private Integer c;
        private Integer d;
        private Integer e;
        private Integer f;
        private Boolean g;
        private Integer h;
        private Boolean i;
        private Boolean j;
        private Object k;

        public d a() {
            return new d(this);
        }

        public f a(int i) {
            this.d = Integer.valueOf(i);
            return this;
        }

        public f a(Uri uri) {
            this.b = uri;
            return this;
        }

        public f a(File file) {
            if (file.isFile()) {
                throw new IllegalArgumentException("parent path only accept directory path");
            }
            this.b = Uri.fromFile(file);
            return this;
        }

        public f a(Boolean bool) {
            this.g = bool;
            return this;
        }

        public f a(Integer num) {
            this.h = num;
            return this;
        }

        public f a(Object obj) {
            this.k = obj;
            return this;
        }

        public f a(String str) {
            return a(new File(str));
        }

        public f a(boolean z) {
            this.i = Boolean.valueOf(z);
            return this;
        }

        public void a(Map<String, List<String>> map) {
            this.a = map;
        }

        public Uri b() {
            return this.b;
        }

        public f b(int i) {
            this.c = Integer.valueOf(i);
            return this;
        }

        public f b(Boolean bool) {
            this.j = bool;
            return this;
        }

        public int c() {
            Integer num = this.d;
            if (num == null) {
                return 16384;
            }
            return num.intValue();
        }

        public f c(int i) {
            this.f = Integer.valueOf(i);
            return this;
        }

        public f d(int i) {
            this.e = Integer.valueOf(i);
            return this;
        }

        public Map<String, List<String>> d() {
            return this.a;
        }

        public int e() {
            Integer num = this.h;
            if (num == null) {
                return 3000;
            }
            return num.intValue();
        }

        public int f() {
            Integer num = this.c;
            if (num == null) {
                return 4096;
            }
            return num.intValue();
        }

        public int g() {
            Integer num = this.f;
            if (num == null) {
                return 2000;
            }
            return num.intValue();
        }

        public int h() {
            Integer num = this.e;
            if (num == null) {
                return 65536;
            }
            return num.intValue();
        }

        public Object i() {
            return this.k;
        }

        public boolean j() {
            Boolean bool = this.g;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }

        public boolean k() {
            Boolean bool = this.i;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }

        public boolean l() {
            Boolean bool = this.j;
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }
    }

    a(com.tapsdk.tapad.internal.download.f[] fVarArr, com.tapsdk.tapad.internal.download.b bVar, f fVar) {
        this.b = false;
        this.a = fVarArr;
        this.c = bVar;
        this.d = fVar;
    }

    a(com.tapsdk.tapad.internal.download.f[] fVarArr, com.tapsdk.tapad.internal.download.b bVar, f fVar, Handler handler) {
        this(fVarArr, bVar, fVar);
        this.e = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        com.tapsdk.tapad.internal.download.b bVar = this.c;
        if (bVar == null) {
            return;
        }
        if (!z) {
            bVar.a(this);
            return;
        }
        if (this.e == null) {
            this.e = new Handler(Looper.getMainLooper());
        }
        this.e.post(new b());
    }

    public c a() {
        return new c(this);
    }

    public void a(com.tapsdk.tapad.internal.download.c cVar) {
        a(cVar, false);
    }

    public void a(com.tapsdk.tapad.internal.download.c cVar, boolean z) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        com.tapsdk.tapad.internal.download.m.c.a(f, "start " + z);
        this.b = true;
        if (this.c != null) {
            cVar = new com.tapsdk.tapad.internal.download.m.i.f.a().a(cVar).a(new e(this, this.c, this.a.length)).a();
        }
        if (z) {
            ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, this.a);
            Collections.sort(arrayList);
            a(new RunnableC0604a(arrayList, cVar));
        } else {
            com.tapsdk.tapad.internal.download.f.a(this.a, cVar);
        }
        com.tapsdk.tapad.internal.download.m.c.a(f, "start finish " + z + " " + (SystemClock.uptimeMillis() - jUptimeMillis) + "ms");
    }

    void a(Runnable runnable) {
        g.execute(runnable);
    }

    public void b(com.tapsdk.tapad.internal.download.c cVar) {
        a(cVar, true);
    }

    public com.tapsdk.tapad.internal.download.f[] b() {
        return this.a;
    }

    public boolean c() {
        return this.b;
    }

    public void d() {
        if (this.b) {
            i.j().e().a((com.tapsdk.tapad.internal.download.m.a[]) this.a);
        }
        this.b = false;
    }

    public d e() {
        return new d(this.d, new ArrayList(Arrays.asList(this.a))).a(this.c);
    }
}
