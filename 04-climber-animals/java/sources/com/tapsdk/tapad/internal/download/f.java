package com.tapsdk.tapad.internal.download;

import android.net.Uri;
import android.util.SparseArray;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public class f extends com.tapsdk.tapad.internal.download.m.a implements Comparable<f> {
    private final File A;
    private File B;
    private String C;
    private final int c;
    private final String d;
    private final Uri e;
    private final Map<String, List<String>> f;
    private com.tapsdk.tapad.internal.download.core.breakpoint.c g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;
    private final Integer m;
    private final Boolean n;
    private final boolean o;
    private final boolean p;
    private final int q;
    private volatile com.tapsdk.tapad.internal.download.c r;
    private volatile SparseArray<Object> s;
    private Object t;
    private final boolean u;
    private final AtomicLong v = new AtomicLong();
    private final boolean w;
    private boolean x;
    private final com.tapsdk.tapad.internal.download.m.e.g.a y;
    private final File z;

    public static class a {
        public static final int r = 4096;
        public static final int s = 16384;
        public static final int t = 65536;
        public static final int u = 2000;
        public static final boolean v = true;
        public static final int w = 3000;
        public static final boolean x = true;
        public static final boolean y = false;
        final String a;
        final Uri b;
        private volatile Map<String, List<String>> c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private boolean i;
        private int j;
        private String k;
        private boolean l;
        private boolean m;
        private Boolean n;
        private Integer o;
        private Boolean p;
        private Boolean q;

        public a(String str, Uri uri) {
            this.e = 4096;
            this.f = 16384;
            this.g = 65536;
            this.h = 2000;
            this.i = true;
            this.j = 3000;
            this.l = true;
            this.m = false;
            this.a = str;
            this.b = uri;
            if (com.tapsdk.tapad.internal.download.m.c.c(uri)) {
                this.k = com.tapsdk.tapad.internal.download.m.c.a(uri);
            }
        }

        public a(String str, File file) {
            this.e = 4096;
            this.f = 16384;
            this.g = 65536;
            this.h = 2000;
            this.i = true;
            this.j = 3000;
            this.l = true;
            this.m = false;
            this.a = str;
            this.b = Uri.fromFile(file);
        }

        public a(String str, String str2, String str3) {
            this(str, Uri.fromFile(new File(str2)));
            if (com.tapsdk.tapad.internal.download.m.c.a((CharSequence) str3)) {
                this.n = Boolean.TRUE;
            } else {
                this.k = str3;
            }
        }

        public a a(int i) {
            this.o = Integer.valueOf(i);
            return this;
        }

        public a a(Boolean bool) {
            if (!com.tapsdk.tapad.internal.download.m.c.d(this.b)) {
                throw new IllegalArgumentException("Uri isn't file scheme we can't let filename from response");
            }
            this.n = bool;
            return this;
        }

        public a a(String str) {
            this.k = str;
            return this;
        }

        public a a(Map<String, List<String>> map) {
            this.c = map;
            return this;
        }

        public a a(boolean z) {
            this.i = z;
            return this;
        }

        public f a() {
            return new f(this.a, this.b, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.c, this.k, this.l, this.m, this.n, this.o, this.p, this.q);
        }

        public synchronized void a(String str, String str2) {
            if (this.c == null) {
                this.c = new HashMap();
            }
            List<String> arrayList = this.c.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.c.put(str, arrayList);
            }
            arrayList.add(str2);
        }

        public a b(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Value must be positive!");
            }
            this.f = i;
            return this;
        }

        public a b(boolean z) {
            this.q = Boolean.valueOf(z);
            return this;
        }

        public a c(int i) {
            this.j = i;
            return this;
        }

        public a c(boolean z) {
            this.l = z;
            return this;
        }

        public a d(int i) {
            this.d = i;
            return this;
        }

        public a d(boolean z) {
            this.p = Boolean.valueOf(z);
            return this;
        }

        public a e(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Value must be positive!");
            }
            this.e = i;
            return this;
        }

        public a e(boolean z) {
            this.m = z;
            return this;
        }

        public a f(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Value must be positive!");
            }
            this.h = i;
            return this;
        }

        public a g(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Value must be positive!");
            }
            this.g = i;
            return this;
        }
    }

    public static class b extends com.tapsdk.tapad.internal.download.m.a {
        final int c;
        final String d;
        final File e;
        final String f;
        final File g;

        public b(int i) {
            this.c = i;
            this.d = "";
            File file = com.tapsdk.tapad.internal.download.m.a.b;
            this.e = file;
            this.f = null;
            this.g = file;
        }

        public b(int i, f fVar) {
            this.c = i;
            this.d = fVar.d;
            this.g = fVar.c();
            this.e = fVar.z;
            this.f = fVar.a();
        }

        @Override // com.tapsdk.tapad.internal.download.m.a
        public String a() {
            return this.f;
        }

        @Override // com.tapsdk.tapad.internal.download.m.a
        public int b() {
            return this.c;
        }

        @Override // com.tapsdk.tapad.internal.download.m.a
        public File c() {
            return this.g;
        }

        @Override // com.tapsdk.tapad.internal.download.m.a
        protected File d() {
            return this.e;
        }

        @Override // com.tapsdk.tapad.internal.download.m.a
        public String e() {
            return this.d;
        }
    }

    public static class c {
        public static long a(f fVar) {
            return fVar.m();
        }

        public static void a(f fVar, long j) {
            fVar.a(j);
        }

        public static void a(f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) {
            fVar.a(cVar);
        }
    }

    public f(String str, Uri uri, int i, int i2, int i3, int i4, int i5, boolean z, int i6, Map<String, List<String>> map, String str2, boolean z2, boolean z3, Boolean bool, Integer num, Boolean bool2, Boolean bool3) {
        Boolean bool4;
        String name = str2;
        this.d = str;
        this.e = uri;
        this.h = i;
        this.i = i2;
        this.j = i3;
        this.k = i4;
        this.l = i5;
        this.p = z;
        this.q = i6;
        this.f = map;
        this.o = z2;
        this.u = z3;
        this.m = num;
        this.n = bool2;
        this.x = bool3.booleanValue();
        if (com.tapsdk.tapad.internal.download.m.c.d(uri)) {
            File file = new File(uri.getPath());
            if (bool != null) {
                if (bool.booleanValue()) {
                    if (file.exists() && file.isFile()) {
                        throw new IllegalArgumentException("If you want filename from response please make sure you provide path is directory " + file.getPath());
                    }
                    if (!com.tapsdk.tapad.internal.download.m.c.a((CharSequence) str2)) {
                        com.tapsdk.tapad.internal.download.m.c.c("DownloadTask", "Discard filename[" + name + "] because you set filenameFromResponse=true");
                        name = null;
                    }
                } else {
                    if (file.exists() && file.isDirectory() && com.tapsdk.tapad.internal.download.m.c.a((CharSequence) str2)) {
                        throw new IllegalArgumentException("If you don't want filename from response please make sure you have already provided valid filename or not directory path " + file.getPath());
                    }
                    if (com.tapsdk.tapad.internal.download.m.c.a((CharSequence) str2)) {
                        bool4 = bool;
                        name = file.getName();
                        file = com.tapsdk.tapad.internal.download.m.c.a(file);
                    }
                }
                bool4 = bool;
            } else if (file.exists() && file.isDirectory()) {
                bool4 = Boolean.TRUE;
            } else {
                bool4 = Boolean.FALSE;
                if (file.exists()) {
                    if (!com.tapsdk.tapad.internal.download.m.c.a((CharSequence) str2) && !file.getName().equals(name)) {
                        throw new IllegalArgumentException("Uri already provided filename!");
                    }
                } else if (com.tapsdk.tapad.internal.download.m.c.a((CharSequence) str2)) {
                }
                name = file.getName();
                file = com.tapsdk.tapad.internal.download.m.c.a(file);
            }
            this.A = file;
            this.w = bool4.booleanValue();
        } else {
            this.w = false;
            this.A = new File(uri.getPath());
        }
        if (com.tapsdk.tapad.internal.download.m.c.a((CharSequence) name)) {
            this.y = new com.tapsdk.tapad.internal.download.m.e.g.a();
            this.z = this.A;
        } else {
            this.y = new com.tapsdk.tapad.internal.download.m.e.g.a(name);
            File file2 = new File(this.A, name);
            this.B = file2;
            this.z = file2;
        }
        this.c = i.j().a().b(this);
    }

    public static void a(f[] fVarArr) {
        i.j().e().a((com.tapsdk.tapad.internal.download.m.a[]) fVarArr);
    }

    public static void a(f[] fVarArr, com.tapsdk.tapad.internal.download.c cVar) {
        for (f fVar : fVarArr) {
            fVar.r = cVar;
        }
        i.j().e().a(fVarArr);
    }

    public static b c(int i) {
        return new b(i);
    }

    public boolean A() {
        return this.o;
    }

    public boolean B() {
        return this.x;
    }

    public boolean C() {
        return this.u;
    }

    public synchronized void D() {
        this.t = null;
    }

    public a E() {
        return a(this.d, this.e);
    }

    public a a(String str, Uri uri) {
        a aVarC = new a(str, uri).d(this.h).e(this.i).b(this.j).g(this.k).f(this.l).a(this.p).c(this.q).a(this.f).c(this.o);
        if (com.tapsdk.tapad.internal.download.m.c.d(uri) && !new File(uri.getPath()).isFile() && com.tapsdk.tapad.internal.download.m.c.d(this.e) && this.y.a() != null && !new File(this.e.getPath()).getName().equals(this.y.a())) {
            aVarC.a(this.y.a());
        }
        return aVarC;
    }

    public synchronized f a(int i, Object obj) {
        if (this.s == null) {
            synchronized (this) {
                if (this.s == null) {
                    this.s = new SparseArray<>();
                }
            }
        }
        this.s.put(i, obj);
        return this;
    }

    public Object a(int i) {
        if (this.s == null) {
            return null;
        }
        return this.s.get(i);
    }

    @Override // com.tapsdk.tapad.internal.download.m.a
    public String a() {
        return this.y.a();
    }

    void a(long j) {
        this.v.set(j);
    }

    public void a(com.tapsdk.tapad.internal.download.c cVar) {
        this.r = cVar;
        i.j().e().a(this);
    }

    void a(com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) {
        this.g = cVar;
    }

    public void a(Object obj) {
        this.t = obj;
    }

    public void a(String str) {
        this.C = str;
    }

    @Override // com.tapsdk.tapad.internal.download.m.a
    public int b() {
        return this.c;
    }

    public b b(int i) {
        return new b(i, this);
    }

    public void b(com.tapsdk.tapad.internal.download.c cVar) {
        this.r = cVar;
        i.j().e().d(this);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        return fVar.p() - p();
    }

    @Override // com.tapsdk.tapad.internal.download.m.a
    public File c() {
        return this.A;
    }

    public void c(com.tapsdk.tapad.internal.download.c cVar) {
        this.r = cVar;
    }

    @Override // com.tapsdk.tapad.internal.download.m.a
    protected File d() {
        return this.z;
    }

    public synchronized void d(int i) {
        if (this.s != null) {
            this.s.remove(i);
        }
    }

    public void d(f fVar) {
        this.t = fVar.t;
        this.s = fVar.s;
    }

    @Override // com.tapsdk.tapad.internal.download.m.a
    public String e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (w() != null && fVar.w() != null) {
            return w().equals(fVar.w());
        }
        if (fVar.c == this.c) {
            return true;
        }
        return a((com.tapsdk.tapad.internal.download.m.a) fVar);
    }

    public void f() {
        i.j().e().a((com.tapsdk.tapad.internal.download.m.a) this);
    }

    public int g() {
        com.tapsdk.tapad.internal.download.core.breakpoint.c cVar = this.g;
        if (cVar == null) {
            return 0;
        }
        return cVar.b();
    }

    public File h() {
        String strA = this.y.a();
        if (strA == null) {
            return null;
        }
        if (this.B == null) {
            this.B = new File(this.A, strA);
        }
        return this.B;
    }

    public int hashCode() {
        return (this.d + this.z.toString() + this.y.a()).hashCode();
    }

    public com.tapsdk.tapad.internal.download.m.e.g.a i() {
        return this.y;
    }

    public int j() {
        return this.j;
    }

    public Map<String, List<String>> k() {
        return this.f;
    }

    public com.tapsdk.tapad.internal.download.core.breakpoint.c l() {
        if (this.g == null) {
            this.g = i.j().a().get(this.c);
        }
        return this.g;
    }

    long m() {
        return this.v.get();
    }

    public com.tapsdk.tapad.internal.download.c n() {
        return this.r;
    }

    public int o() {
        return this.q;
    }

    public int p() {
        return this.h;
    }

    public int q() {
        return this.i;
    }

    public String r() {
        return this.C;
    }

    public Integer s() {
        return this.m;
    }

    public Boolean t() {
        return this.n;
    }

    public String toString() {
        return super.toString() + "@" + this.c + "@" + this.d + "@" + this.A.toString() + "/" + this.y.a();
    }

    public int u() {
        return this.l;
    }

    public int v() {
        return this.k;
    }

    public Object w() {
        return this.t;
    }

    public Uri x() {
        return this.e;
    }

    public boolean y() {
        return this.p;
    }

    public boolean z() {
        return this.w;
    }
}
