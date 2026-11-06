package com.anythink.basead.b.b;

import android.text.TextUtils;
import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class d extends a {
    WeakReference<View> h;
    private com.anythink.core.common.v.a.c i;
    private long j;
    private final long k;
    private c l;

    public d(a.C0008a c0008a) {
        super(c0008a);
        this.j = 0L;
        this.k = 5000L;
    }

    public final void a(WeakReference<View> weakReference) {
        this.h = weakReference;
    }

    public final void a(c cVar) {
        this.l = cVar;
    }

    @Override // com.anythink.basead.b.b.a, com.anythink.basead.b.b.m
    public final n a() {
        if (this.e == null) {
            return n.a(false, "DeeplinkClickAction empty mOfferClickReportNotify");
        }
        com.anythink.basead.d.j jVarA = this.e.a();
        if (jVarA == null) {
            return n.a(false, "DeeplinkClickAction empty mOfferClickReportNotify");
        }
        jVarA.k = new com.anythink.basead.d.b();
        com.anythink.basead.d.e eVarB = b();
        jVarA.k.a = eVarB != null ? eVarB.c : "";
        com.anythink.basead.b.b.a(23, this.c, jVarA);
        if (!TextUtils.isEmpty(this.c.G())) {
            String strReplaceAll = this.c.G().replaceAll("\\{req_id\\}", this.d.d != null ? this.d.d : "");
            com.anythink.core.common.o.a().a(this.c);
            com.anythink.core.basead.a.d dVarB = com.anythink.core.basead.a.e.b(this.b, strReplaceAll, this.c, this.d);
            int iA = dVarB.a();
            if (iA == 0) {
                jVarA.k.b = 1;
            } else if (iA == 1) {
                jVarA.k.b = 2;
            } else {
                jVarA.k.b = 3;
            }
            if (dVarB.a() == 0) {
                if (jVarA.i != null) {
                    jVarA.i.i = true;
                }
                if (this.e != null) {
                    this.e.b();
                }
                new f(this.c, this.d, strReplaceAll, jVarA.i).a();
                com.anythink.core.common.u.e.a(this.d, this.c, strReplaceAll, "1", 0, 0, dVarB.b());
                if (this.f != null) {
                    this.f.b();
                    this.f.a();
                    this.f.a(true);
                    this.f.c();
                }
                com.anythink.basead.c.a().a(new com.anythink.basead.b.a.b() { // from class: com.anythink.basead.b.b.d.1
                    @Override // com.anythink.basead.b.a.b
                    public final void a(long j) {
                        com.anythink.core.common.u.e.a(d.this.d, d.this.d.j, d.this.c, j, System.currentTimeMillis());
                    }
                });
                com.anythink.basead.b.b.a(24, this.c, jVarA);
                if (com.anythink.basead.b.e.f(this.c, this.d) != 1) {
                    String strH = this.c.H();
                    int iK = this.c.K();
                    this.j = System.currentTimeMillis();
                    com.anythink.basead.c.a().a(new AnonymousClass2(strH, strReplaceAll, iK));
                }
                return n.a(true, "DeeplinkClickAction execute success");
            }
            com.anythink.core.common.o.a().b(this.c);
            if (com.anythink.basead.b.b.a(this.b, this.c.I())) {
                com.anythink.basead.b.b.a(28, this.c, jVarA);
            } else {
                com.anythink.basead.b.b.a(29, this.c, jVarA);
            }
            com.anythink.core.common.u.e.a(this.d, this.c, strReplaceAll, "0", 0, dVarB.a(), dVarB.b());
        }
        return n.a(false, "DeeplinkClickAction execute fail");
    }

    private void a(String str) {
        String strH = this.c.H();
        int iK = this.c.K();
        this.j = System.currentTimeMillis();
        com.anythink.basead.c.a().a(new AnonymousClass2(strH, str, iK));
    }

    /* JADX INFO: renamed from: com.anythink.basead.b.b.d$2, reason: invalid class name */
    final class AnonymousClass2 implements com.anythink.basead.b.a.c {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ int c;

        AnonymousClass2(String str, String str2, int i) {
            this.a = str;
            this.b = str2;
            this.c = i;
        }

        @Override // com.anythink.basead.b.a.c
        public final void a(boolean z) {
            if (z) {
                View view = d.this.h != null ? d.this.h.get() : null;
                if (view != null) {
                    if (d.this.i != null) {
                        d.this.i.b();
                        d.this.i = null;
                    }
                    com.anythink.core.common.v.a.a aVar = new com.anythink.core.common.v.a.a() { // from class: com.anythink.basead.b.b.d.2.1
                        @Override // com.anythink.core.common.v.a.a, com.anythink.core.common.v.a.b
                        public final int getImpressionMinPercentageViewed() {
                            return 50;
                        }

                        @Override // com.anythink.core.common.v.a.a, com.anythink.core.common.v.a.b
                        public final void recordImpression(View view2) {
                            if (TextUtils.isEmpty(AnonymousClass2.this.a) || AnonymousClass2.this.b.equals(AnonymousClass2.this.a)) {
                                com.anythink.core.common.u.e.b(d.this.d, d.this.c, AnonymousClass2.this.b, AnonymousClass2.this.a, 1);
                                return;
                            }
                            if (AnonymousClass2.this.c != 2 && AnonymousClass2.this.c != 3) {
                                int i = AnonymousClass2.this.c;
                                com.anythink.core.common.u.e.b(d.this.d, d.this.c, AnonymousClass2.this.b, AnonymousClass2.this.a, 2);
                            } else {
                                if (System.currentTimeMillis() - d.this.j > 5000) {
                                    return;
                                }
                                com.anythink.core.common.u.e.b(d.this.d, d.this.c, AnonymousClass2.this.b, AnonymousClass2.this.a, 0);
                                if (d.this.d.o.bl() == 1 && d.this.l != null) {
                                    d.this.l.a(d.this.l.d(), e.HANDLE_DEEPLINK_REFUSE);
                                }
                            }
                        }
                    };
                    int iBL = (d.this.c == null || d.this.c.r() == null) ? 1 : d.this.c.r().bL();
                    d dVar = d.this;
                    view.getContext();
                    dVar.i = new com.anythink.core.common.v.a.c(iBL, 0);
                    d.this.i.a(view, aVar);
                    return;
                }
                return;
            }
            com.anythink.core.common.u.e.b(d.this.d, d.this.c, this.b, this.a, 3);
        }
    }

    @Override // com.anythink.basead.b.b.a, com.anythink.basead.b.b.m
    public final void c() {
        super.c();
        com.anythink.core.common.v.a.c cVar = this.i;
        if (cVar != null) {
            cVar.b();
            this.i = null;
        }
    }
}
