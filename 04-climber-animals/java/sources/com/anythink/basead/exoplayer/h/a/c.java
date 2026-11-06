package com.anythink.basead.exoplayer.h.a;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.anythink.basead.exoplayer.ae;
import com.anythink.basead.exoplayer.h.f;
import com.anythink.basead.exoplayer.h.l;
import com.anythink.basead.exoplayer.h.o;
import com.anythink.basead.exoplayer.h.r;
import com.anythink.basead.exoplayer.h.s;
import com.anythink.basead.exoplayer.j.h;
import com.anythink.basead.exoplayer.j.k;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class c extends f<s.a> {
    private static final String a = "AdsMediaSource";
    private final s b;
    private final e c;
    private final com.anythink.basead.exoplayer.h.a.b d;
    private final ViewGroup e;
    private final Handler f;
    private final d g;
    private final Handler h;
    private final Map<s, List<l>> i;
    private final ae.a j;
    private C0030c k;
    private ae l;
    private Object m;
    private com.anythink.basead.exoplayer.h.a.a n;
    private s[][] o;
    private long[][] p;

    @Deprecated
    public interface d {
        void a();

        void b();

        void c();

        void d();
    }

    public interface e {
        int[] a();

        s b(Uri uri);
    }

    @Override // com.anythink.basead.exoplayer.h.f
    protected final /* bridge */ /* synthetic */ s.a a(s.a aVar, s.a aVar2) {
        s.a aVar3 = aVar;
        return aVar3.a() ? aVar3 : aVar2;
    }

    @Override // com.anythink.basead.exoplayer.h.f
    protected final /* synthetic */ void a(s.a aVar, s sVar, ae aeVar, Object obj) {
        s.a aVar2 = aVar;
        if (aVar2.a()) {
            int i = aVar2.b;
            int i2 = aVar2.c;
            com.anythink.basead.exoplayer.k.a.a(aeVar.c() == 1);
            this.p[i][i2] = aeVar.a(0, this.j, false).d;
            if (this.i.containsKey(sVar)) {
                List<l> list = this.i.get(sVar);
                for (int i3 = 0; i3 < list.size(); i3++) {
                    list.get(i3).f();
                }
                this.i.remove(sVar);
            }
            c();
            return;
        }
        this.l = aeVar;
        this.m = obj;
        c();
    }

    public static final class a extends IOException {
        public static final int a = 0;
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        public final int e;

        /* JADX INFO: renamed from: com.anythink.basead.exoplayer.h.a.c$a$a, reason: collision with other inner class name */
        @Retention(RetentionPolicy.SOURCE)
        public @interface InterfaceC0029a {
        }

        public static a a(Exception exc) {
            return new a(0, exc);
        }

        private static a a(Exception exc, int i) {
            return new a(1, new IOException("Failed to load ad group ".concat(String.valueOf(i)), exc));
        }

        private static a b(Exception exc) {
            return new a(2, exc);
        }

        private static a a(RuntimeException runtimeException) {
            return new a(3, runtimeException);
        }

        private a(int i, Exception exc) {
            super(exc);
            this.e = i;
        }

        private RuntimeException a() {
            com.anythink.basead.exoplayer.k.a.b(this.e == 3);
            return (RuntimeException) getCause();
        }
    }

    private c(s sVar, h.a aVar, com.anythink.basead.exoplayer.h.a.b bVar, ViewGroup viewGroup) {
        this(sVar, new o.c(aVar), bVar, viewGroup, (Handler) null, (d) null);
    }

    private c(s sVar, e eVar, com.anythink.basead.exoplayer.h.a.b bVar, ViewGroup viewGroup) {
        this(sVar, eVar, bVar, viewGroup, (Handler) null, (d) null);
    }

    @Deprecated
    private c(s sVar, h.a aVar, com.anythink.basead.exoplayer.h.a.b bVar, ViewGroup viewGroup, Handler handler, d dVar) {
        this(sVar, new o.c(aVar), bVar, viewGroup, handler, dVar);
    }

    @Deprecated
    private c(s sVar, e eVar, com.anythink.basead.exoplayer.h.a.b bVar, ViewGroup viewGroup, Handler handler, d dVar) {
        this.b = sVar;
        this.c = eVar;
        this.d = bVar;
        this.e = viewGroup;
        this.f = handler;
        this.g = dVar;
        this.h = new Handler(Looper.getMainLooper());
        this.i = new HashMap();
        this.j = new ae.a();
        this.o = new s[0][];
        this.p = new long[0][];
    }

    @Override // com.anythink.basead.exoplayer.h.f, com.anythink.basead.exoplayer.h.c
    public final void a(final com.anythink.basead.exoplayer.h hVar, boolean z) {
        super.a(hVar, z);
        com.anythink.basead.exoplayer.k.a.a(z);
        final C0030c c0030c = new C0030c();
        this.k = c0030c;
        a(new s.a(0), this.b);
        this.h.post(new Runnable() { // from class: com.anythink.basead.exoplayer.h.a.c.1
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.basead.exoplayer.h.a.b unused = c.this.d;
                ViewGroup unused2 = c.this.e;
            }
        });
    }

    @Override // com.anythink.basead.exoplayer.h.s
    public final r a(s.a aVar, com.anythink.basead.exoplayer.j.b bVar) {
        if (this.n.g > 0 && aVar.a()) {
            int i = aVar.b;
            int i2 = aVar.c;
            Uri uri = this.n.i[i].b[i2];
            if (this.o[i].length <= i2) {
                s sVarB = this.c.b(uri);
                s[][] sVarArr = this.o;
                s[] sVarArr2 = sVarArr[i];
                int length = sVarArr2.length;
                if (i2 >= length) {
                    int i3 = i2 + 1;
                    sVarArr[i] = (s[]) Arrays.copyOf(sVarArr2, i3);
                    long[][] jArr = this.p;
                    jArr[i] = Arrays.copyOf(jArr[i], i3);
                    Arrays.fill(this.p[i], length, i3, -9223372036854775807L);
                }
                this.o[i][i2] = sVarB;
                this.i.put(sVarB, new ArrayList());
                a(aVar, sVarB);
            }
            s sVar = this.o[i][i2];
            l lVar = new l(sVar, new s.a(0, aVar.d), bVar);
            lVar.a(new b(uri, i, i2));
            List<l> list = this.i.get(sVar);
            if (list == null) {
                lVar.f();
            } else {
                list.add(lVar);
            }
            return lVar;
        }
        l lVar2 = new l(this.b, aVar, bVar);
        lVar2.f();
        return lVar2;
    }

    @Override // com.anythink.basead.exoplayer.h.s
    public final void a(r rVar) {
        l lVar = (l) rVar;
        List<l> list = this.i.get(lVar.a);
        if (list != null) {
            list.remove(lVar);
        }
        lVar.g();
    }

    @Override // com.anythink.basead.exoplayer.h.f, com.anythink.basead.exoplayer.h.c
    public final void a() {
        super.a();
        this.k.c();
        this.k = null;
        this.i.clear();
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = new s[0][];
        this.p = new long[0][];
        this.h.post(new Runnable() { // from class: com.anythink.basead.exoplayer.h.a.c.2
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.basead.exoplayer.h.a.b unused = c.this.d;
            }
        });
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    private void a2(s.a aVar, s sVar, ae aeVar, Object obj) {
        if (aVar.a()) {
            int i = aVar.b;
            int i2 = aVar.c;
            com.anythink.basead.exoplayer.k.a.a(aeVar.c() == 1);
            this.p[i][i2] = aeVar.a(0, this.j, false).d;
            if (this.i.containsKey(sVar)) {
                List<l> list = this.i.get(sVar);
                for (int i3 = 0; i3 < list.size(); i3++) {
                    list.get(i3).f();
                }
                this.i.remove(sVar);
            }
            c();
            return;
        }
        this.l = aeVar;
        this.m = obj;
        c();
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    private static s.a a2(s.a aVar, s.a aVar2) {
        return aVar.a() ? aVar : aVar2;
    }

    private void a(com.anythink.basead.exoplayer.h.a.a aVar) {
        if (this.n == null) {
            s[][] sVarArr = new s[aVar.g][];
            this.o = sVarArr;
            Arrays.fill(sVarArr, new s[0]);
            long[][] jArr = new long[aVar.g][];
            this.p = jArr;
            Arrays.fill(jArr, new long[0]);
        }
        this.n = aVar;
        c();
    }

    private void b(ae aeVar, Object obj) {
        this.l = aeVar;
        this.m = obj;
        c();
    }

    private void a(s sVar, int i, int i2, ae aeVar) {
        com.anythink.basead.exoplayer.k.a.a(aeVar.c() == 1);
        this.p[i][i2] = aeVar.a(0, this.j, false).d;
        if (this.i.containsKey(sVar)) {
            List<l> list = this.i.get(sVar);
            for (int i3 = 0; i3 < list.size(); i3++) {
                list.get(i3).f();
            }
            this.i.remove(sVar);
        }
        c();
    }

    private void c() {
        ae dVar;
        com.anythink.basead.exoplayer.h.a.a aVar = this.n;
        if (aVar == null || this.l == null) {
            return;
        }
        com.anythink.basead.exoplayer.h.a.a aVarA = aVar.a(this.p);
        this.n = aVarA;
        if (aVarA.g == 0) {
            dVar = this.l;
        } else {
            dVar = new com.anythink.basead.exoplayer.h.a.d(this.l, this.n);
        }
        a(dVar, this.m);
    }

    /* JADX INFO: renamed from: com.anythink.basead.exoplayer.h.a.c$c, reason: collision with other inner class name */
    private final class C0030c implements com.anythink.basead.exoplayer.h.a.b.a {
        private final Handler b = new Handler();
        private volatile boolean c;

        public C0030c() {
        }

        public final void c() {
            this.c = true;
            this.b.removeCallbacksAndMessages(null);
        }

        @Override // com.anythink.basead.exoplayer.h.a.b.a
        public final void a(final com.anythink.basead.exoplayer.h.a.a aVar) {
            if (this.c) {
                return;
            }
            this.b.post(new Runnable() { // from class: com.anythink.basead.exoplayer.h.a.c.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (C0030c.this.c) {
                        return;
                    }
                    c.a(c.this, aVar);
                }
            });
        }

        @Override // com.anythink.basead.exoplayer.h.a.b.a
        public final void a() {
            if (this.c || c.this.f == null || c.this.g == null) {
                return;
            }
            c.this.f.post(new Runnable() { // from class: com.anythink.basead.exoplayer.h.a.c.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (C0030c.this.c) {
                        return;
                    }
                    d unused = c.this.g;
                }
            });
        }

        @Override // com.anythink.basead.exoplayer.h.a.b.a
        public final void b() {
            if (this.c || c.this.f == null || c.this.g == null) {
                return;
            }
            c.this.f.post(new Runnable() { // from class: com.anythink.basead.exoplayer.h.a.c.c.3
                @Override // java.lang.Runnable
                public final void run() {
                    if (C0030c.this.c) {
                        return;
                    }
                    d unused = c.this.g;
                }
            });
        }

        @Override // com.anythink.basead.exoplayer.h.a.b.a
        public final void a(final a aVar, k kVar) {
            if (this.c) {
                return;
            }
            c.this.a((s.a) null).a(kVar, aVar);
            if (c.this.f == null || c.this.g == null) {
                return;
            }
            c.this.f.post(new Runnable() { // from class: com.anythink.basead.exoplayer.h.a.c.c.4
                @Override // java.lang.Runnable
                public final void run() {
                    if (C0030c.this.c) {
                        return;
                    }
                    if (aVar.e == 3) {
                        d unused = c.this.g;
                        a aVar2 = aVar;
                        com.anythink.basead.exoplayer.k.a.b(aVar2.e == 3);
                        aVar2.getCause();
                        return;
                    }
                    d unused2 = c.this.g;
                }
            });
        }
    }

    private final class b implements l.a {
        private final Uri b;
        private final int c;
        private final int d;

        public b(Uri uri, int i, int i2) {
            this.b = uri;
            this.c = i;
            this.d = i2;
        }

        @Override // com.anythink.basead.exoplayer.h.l.a
        public final void a(s.a aVar, final IOException iOException) {
            c.this.a(aVar).a(new k(this.b), a.a(iOException));
            c.this.h.post(new Runnable() { // from class: com.anythink.basead.exoplayer.h.a.c.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.anythink.basead.exoplayer.h.a.b unused = c.this.d;
                    int unused2 = b.this.c;
                    int unused3 = b.this.d;
                }
            });
        }
    }

    static /* synthetic */ void a(c cVar, com.anythink.basead.exoplayer.h.a.a aVar) {
        if (cVar.n == null) {
            s[][] sVarArr = new s[aVar.g][];
            cVar.o = sVarArr;
            Arrays.fill(sVarArr, new s[0]);
            long[][] jArr = new long[aVar.g][];
            cVar.p = jArr;
            Arrays.fill(jArr, new long[0]);
        }
        cVar.n = aVar;
        cVar.c();
    }
}
