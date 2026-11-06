package com.anythink.basead.f;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.d.j;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.bi;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.bk;
import com.anythink.core.common.h.r;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.q;
import com.anythink.core.common.v.z;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    protected Context a;
    protected x b;
    protected d c;
    protected bj d;
    protected com.anythink.basead.g.a e;
    protected String f;
    protected com.anythink.basead.f.c.d g;
    protected com.anythink.basead.f.b.c h;
    private b i;
    private boolean j = false;
    private Map<String, Object> k;

    public interface a {
        void onAdCacheLoaded();
    }

    public enum b {
        ADX_OFFER_REQUEST_TYPE,
        ONLINE_API_OFFER_REQUEST_TYPE;

        private static /* synthetic */ b[] a() {
            return new b[]{ADX_OFFER_REQUEST_TYPE, ONLINE_API_OFFER_REQUEST_TYPE};
        }
    }

    static /* synthetic */ boolean a(c cVar) {
        cVar.j = true;
        return true;
    }

    /* JADX INFO: renamed from: com.anythink.basead.f.c$c, reason: collision with other inner class name */
    public class C0042c {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final int f = 6;

        private C0042c() {
        }
    }

    public c(Context context, b bVar, x xVar) {
        this.a = context.getApplicationContext();
        this.i = bVar;
        this.b = xVar;
    }

    public final void a(String str) {
        this.f = str;
    }

    public final void a(d dVar) {
        this.c = dVar;
        if (this.b.o instanceof bk) {
            bk bkVar = (bk) this.b.o;
            d dVar2 = this.c;
            boolean z = this.b.f == 66;
            if (bkVar == null || dVar2 == null) {
                return;
            }
            bkVar.x(dVar2.a());
            if (!z) {
                bkVar.y(dVar2.b());
            }
            bkVar.e(dVar2.d());
            bkVar.r(dVar2.c());
            bkVar.q(dVar2.e());
            bkVar.b(dVar2.f());
            bkVar.p(dVar2.g());
            bkVar.c(dVar2.h());
            bkVar.d(dVar2.i());
            bkVar.f(dVar2.j());
            bkVar.f(dVar2.k());
            bkVar.aD(dVar2.l());
        }
    }

    public final void a(com.anythink.basead.g.a aVar) {
        this.e = aVar;
        com.anythink.basead.f.b.c cVar = this.h;
        if (cVar != null) {
            cVar.a(aVar);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.f.c$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.ADX_OFFER_REQUEST_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.ONLINE_API_OFFER_REQUEST_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public final boolean c() {
        bj bjVar;
        int i = AnonymousClass4.a[this.i.ordinal()];
        if (i == 1) {
            if (this.d == null) {
                this.d = com.anythink.basead.f.a.a.a(this.a).a(this.b);
            }
            bj bjVar2 = this.d;
            if (bjVar2 == null || bjVar2.ax()) {
                return false;
            }
            if (this.h == null) {
                this.h = a(this.d, this.b, null);
            }
            if (this.j) {
                return true;
            }
            com.anythink.basead.f.b.c cVar = this.h;
            if (cVar == null || !cVar.a()) {
                return false;
            }
            this.j = true;
            return true;
        }
        if (i != 2 || (bjVar = this.d) == null || !(bjVar instanceof bi) || bjVar.ax()) {
            return false;
        }
        if (this.j) {
            return true;
        }
        if (com.anythink.basead.b.c.d.a(this.d, this.b)) {
            this.j = true;
            return true;
        }
        return false;
    }

    public final void a(com.anythink.basead.g.c cVar) {
        int i = AnonymousClass4.a[this.i.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            try {
                com.anythink.basead.f.e.a.a(this.a).a(this.b, this.f, new AnonymousClass3(cVar));
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                cVar.onAdLoadFailed(com.anythink.basead.d.g.a("-9999", th.getMessage()));
                return;
            }
        }
        try {
            x xVar = this.b;
            if (xVar != null && !TextUtils.isEmpty(xVar.b) && !TextUtils.isEmpty(this.b.a)) {
                com.anythink.core.common.u.b.a();
                String strA = com.anythink.core.common.u.b.a(this.b);
                com.anythink.core.common.u.b.a().a(strA).a = System.currentTimeMillis();
                com.anythink.basead.f.a.a.a(this.a).a(this.b, new AnonymousClass2(strA, cVar));
                return;
            }
            cVar.onAdLoadFailed(com.anythink.basead.d.g.a(com.anythink.basead.d.g.i, com.anythink.basead.d.g.B));
        } catch (Throwable th2) {
            th2.printStackTrace();
            cVar.onAdLoadFailed(com.anythink.basead.d.g.a("-9999", th2.getMessage()));
        }
    }

    private void a() {
        a((a) null);
    }

    public final void a(final a aVar) {
        if (AnonymousClass4.a[this.i.ordinal()] != 1) {
            return;
        }
        if (c()) {
            com.anythink.basead.f.f.a.a(this.b, this.d);
            if (aVar != null) {
                aVar.onAdCacheLoaded();
                return;
            }
            return;
        }
        if (this.b != null) {
            com.anythink.basead.f.a.a.a(this.a).a(this.d, this.b, new com.anythink.basead.f.a.a.InterfaceC0040a() { // from class: com.anythink.basead.f.c.1
                @Override // com.anythink.basead.f.a.a.InterfaceC0040a
                public final void a(r rVar) {
                }

                @Override // com.anythink.basead.f.a.a.InterfaceC0040a
                public final void a(r rVar, com.anythink.basead.d.f fVar) {
                }

                @Override // com.anythink.basead.f.a.a.InterfaceC0040a
                public final void a(com.anythink.basead.f.b.d dVar) {
                    c.a(c.this, dVar);
                }

                @Override // com.anythink.basead.f.a.a.InterfaceC0040a
                public final void a(r rVar, com.anythink.basead.f.b.d dVar) {
                    com.anythink.basead.f.f.a.a(c.this.b, c.this.d);
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.onAdCacheLoaded();
                    }
                }
            });
        }
    }

    protected final String a(bj bjVar) {
        return this.b.b + this.b.c + this.b.f + bjVar.v() + System.currentTimeMillis();
    }

    private void b(com.anythink.basead.g.c cVar) {
        try {
            x xVar = this.b;
            if (xVar != null && !TextUtils.isEmpty(xVar.b) && !TextUtils.isEmpty(this.b.a)) {
                com.anythink.core.common.u.b.a();
                String strA = com.anythink.core.common.u.b.a(this.b);
                com.anythink.core.common.u.b.a().a(strA).a = System.currentTimeMillis();
                com.anythink.basead.f.a.a.a(this.a).a(this.b, new AnonymousClass2(strA, cVar));
                return;
            }
            if (cVar != null) {
                cVar.onAdLoadFailed(com.anythink.basead.d.g.a(com.anythink.basead.d.g.i, com.anythink.basead.d.g.B));
            }
        } catch (Throwable th) {
            th.printStackTrace();
            if (cVar != null) {
                cVar.onAdLoadFailed(com.anythink.basead.d.g.a("-9999", th.getMessage()));
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.f.c$2, reason: invalid class name */
    final class AnonymousClass2 implements com.anythink.basead.f.a.a.InterfaceC0040a {
        final /* synthetic */ String a;
        final /* synthetic */ com.anythink.basead.g.c b;

        @Override // com.anythink.basead.f.a.a.InterfaceC0040a
        public final void a(com.anythink.basead.f.b.d dVar) {
        }

        AnonymousClass2(String str, com.anythink.basead.g.c cVar) {
            this.a = str;
            this.b = cVar;
        }

        @Override // com.anythink.basead.f.a.a.InterfaceC0040a
        public final void a(r rVar) {
            com.anythink.core.common.u.b.a().a(this.a).c = System.currentTimeMillis();
            c.this.a(rVar);
            com.anythink.basead.g.c cVar = this.b;
            if (cVar != null) {
                cVar.onAdDataLoaded();
            }
            if (!TextUtils.isEmpty(rVar.ad())) {
                z.a().a(t.b().g(), rVar.ad());
            }
            if (TextUtils.isEmpty(rVar.at())) {
                return;
            }
            com.anythink.basead.b.e.a.a().a(t.b().g(), rVar.at());
        }

        @Override // com.anythink.basead.f.a.a.InterfaceC0040a
        public final void a(r rVar, com.anythink.basead.f.b.d dVar) {
            c.this.d = rVar;
            c.a(c.this, dVar);
            c cVar = c.this;
            cVar.h = cVar.a(rVar, cVar.b, dVar);
            String str = "";
            com.anythink.basead.b.b.a(33, rVar, new j(c.this.b, ""));
            com.anythink.core.common.u.b.a().a(this.a, System.currentTimeMillis());
            if (TextUtils.equals(String.valueOf(c.this.b.j), "0")) {
                str = (c.this.b.p || dVar != null) ? "1" : "0";
            }
            com.anythink.core.common.u.e.a(rVar, c.this.b, str, com.anythink.core.common.u.b.a().a(this.a), true, com.anythink.basead.b.e.d(rVar, c.this.b));
            com.anythink.core.common.u.b.a().b(this.a);
            c.a(c.this);
            com.anythink.basead.g.c cVar2 = this.b;
            if (cVar2 != null) {
                cVar2.onAdCacheLoaded();
            }
        }

        @Override // com.anythink.basead.f.a.a.InterfaceC0040a
        public final void a(r rVar, com.anythink.basead.d.f fVar) {
            com.anythink.core.common.u.b.a().a(this.a, System.currentTimeMillis());
            String str = "0";
            if (!TextUtils.equals(String.valueOf(c.this.b.j), "0")) {
                str = "";
            } else if (c.this.b.p) {
                str = "1";
            }
            com.anythink.core.common.u.e.a(rVar, c.this.b, str, com.anythink.core.common.u.b.a().a(this.a), false, com.anythink.basead.b.e.d(rVar, c.this.b));
            com.anythink.core.common.u.b.a().b(this.a);
            c.a(c.this, rVar, fVar, this.b, true);
        }
    }

    private void a(com.anythink.basead.f.b.d dVar) {
        if (dVar == null || !(dVar instanceof com.anythink.basead.f.c.c)) {
            return;
        }
        this.g = com.anythink.basead.f.c.a.a() ? com.anythink.basead.f.c.a.b().a(this.a, this.b, this.d, (com.anythink.basead.f.c.c) dVar) : null;
    }

    /* JADX INFO: renamed from: com.anythink.basead.f.c$3, reason: invalid class name */
    final class AnonymousClass3 implements com.anythink.basead.f.e.a.InterfaceC0043a {
        final /* synthetic */ com.anythink.basead.g.c a;

        AnonymousClass3(com.anythink.basead.g.c cVar) {
            this.a = cVar;
        }

        @Override // com.anythink.basead.f.e.a.InterfaceC0043a
        public final void a() {
            com.anythink.basead.g.c cVar = this.a;
            if (cVar != null) {
                cVar.onAdDataLoaded();
            }
        }

        @Override // com.anythink.basead.f.e.a.InterfaceC0043a
        public final void a(bi biVar) {
            c.this.d = biVar;
            com.anythink.basead.b.b.a(33, c.this.d, new j(c.this.b, ""));
            c.a(c.this);
            com.anythink.basead.g.c cVar = this.a;
            if (cVar != null) {
                cVar.onAdCacheLoaded();
            }
        }

        @Override // com.anythink.basead.f.e.a.InterfaceC0043a
        public final void a(bi biVar, com.anythink.basead.d.f fVar) {
            c.a(c.this, biVar, fVar, this.a, false);
        }
    }

    private void c(com.anythink.basead.g.c cVar) {
        try {
            com.anythink.basead.f.e.a.a(this.a).a(this.b, this.f, new AnonymousClass3(cVar));
        } catch (Throwable th) {
            th.printStackTrace();
            if (cVar != null) {
                cVar.onAdLoadFailed(com.anythink.basead.d.g.a("-9999", th.getMessage()));
            }
        }
    }

    private void a(w wVar, com.anythink.basead.d.f fVar, com.anythink.basead.g.c cVar, boolean z) {
        if (wVar != null) {
            com.anythink.basead.b.b.a(34, wVar, new j(this.b, ""));
        }
        if (wVar instanceof bi) {
            com.anythink.core.basead.b.a();
            Context contextG = t.b().g();
            com.anythink.core.basead.b.a();
            com.anythink.core.basead.b.b(contextG, com.anythink.core.basead.b.a(this.b));
        }
        if (z) {
            try {
                com.anythink.core.common.a.a.a().b(t.b().g(), this.b.a);
            } catch (Throwable unused) {
            }
        }
        if (cVar != null) {
            cVar.onAdLoadFailed(fVar);
        }
    }

    public final w d() {
        return this.d;
    }

    public void b() {
        com.anythink.basead.f.b.c cVar = this.h;
        if (cVar != null) {
            cVar.b();
        }
        this.d = null;
    }

    protected final void a(r rVar) {
        if (rVar.f() == 1) {
            com.anythink.core.common.a.d.a().b();
            if (q.a(this.a, rVar.I())) {
                rVar.aD();
                rVar.I();
                com.anythink.core.common.a.d.a().c(rVar);
            } else {
                rVar.aD();
                rVar.I();
                com.anythink.core.common.a.d.a().a(rVar);
            }
        }
    }

    protected final void a(Map<String, Object> map) {
        this.k = map;
    }

    public final Map<String, Object> e() {
        return this.k;
    }

    public final int f() {
        return com.anythink.basead.b.e.d(this.d, this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.anythink.basead.f.b.c a(bj bjVar, x xVar, com.anythink.basead.f.b.d dVar) {
        if (!TextUtils.isEmpty(((r) this.d).d())) {
            if (this.g != null) {
                return new com.anythink.basead.f.b.b(this.g);
            }
        } else if (TextUtils.equals(bjVar.aC(), com.anythink.basead.f.d.b.a)) {
            if (dVar instanceof com.anythink.basead.f.b.c) {
                return (com.anythink.basead.f.b.c) dVar;
            }
        } else {
            return new com.anythink.basead.f.b.a(bjVar, xVar);
        }
        return null;
    }

    public final boolean g() {
        x xVar = this.b;
        return xVar == null || xVar.o == null || this.b.o.bF() <= 0;
    }

    static /* synthetic */ void a(c cVar, com.anythink.basead.f.b.d dVar) {
        if (dVar == null || !(dVar instanceof com.anythink.basead.f.c.c)) {
            return;
        }
        cVar.g = com.anythink.basead.f.c.a.a() ? com.anythink.basead.f.c.a.b().a(cVar.a, cVar.b, cVar.d, (com.anythink.basead.f.c.c) dVar) : null;
    }

    static /* synthetic */ void a(c cVar, w wVar, com.anythink.basead.d.f fVar, com.anythink.basead.g.c cVar2, boolean z) {
        if (wVar != null) {
            com.anythink.basead.b.b.a(34, wVar, new j(cVar.b, ""));
        }
        if (wVar instanceof bi) {
            com.anythink.core.basead.b.a();
            Context contextG = t.b().g();
            com.anythink.core.basead.b.a();
            com.anythink.core.basead.b.b(contextG, com.anythink.core.basead.b.a(cVar.b));
        }
        if (z) {
            try {
                com.anythink.core.common.a.a.a().b(t.b().g(), cVar.b.a);
            } catch (Throwable unused) {
            }
        }
        if (cVar2 != null) {
            cVar2.onAdLoadFailed(fVar);
        }
    }
}
