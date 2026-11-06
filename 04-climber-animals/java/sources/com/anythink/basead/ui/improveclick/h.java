package com.anythink.basead.ui.improveclick;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.anythink.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView;
import com.anythink.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView;
import com.anythink.basead.ui.improveclick.incentivetask.QAIncentiveTaskView;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.am;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class h extends c {
    com.anythink.core.common.t.c a;
    BaseIncentiveTaskView b;
    private long n;
    private long o;
    private boolean p;
    private int q;
    private final int c = 1;
    private final int l = 2;
    private final int m = 3;
    private int r = 3;

    static /* synthetic */ boolean g(h hVar) {
        hVar.p = true;
        return true;
    }

    @Override // com.anythink.basead.ui.improveclick.c
    public final void a(Context context, w wVar, x xVar, ViewGroup viewGroup, RelativeLayout relativeLayout, View view, int i, c.a aVar) {
        super.a(context, wVar, xVar, viewGroup, relativeLayout, view, i, aVar);
    }

    @Override // com.anythink.basead.ui.improveclick.c
    final void a(int i, Map<String, Object> map) {
        if (i != 107 && i != 108) {
            if (i == 114) {
                if (this.a == null) {
                    this.a = new com.anythink.core.common.t.c(this.f.o.bp(), new Runnable() { // from class: com.anythink.basead.ui.improveclick.h.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            h.a(h.this);
                        }
                    }, true);
                }
                Object obj = map.get(g.a.d);
                if (obj != null && (obj instanceof Long)) {
                    this.n = ((Long) obj).longValue();
                }
                com.anythink.core.common.t.c cVar = this.a;
                if (cVar != null) {
                    cVar.a();
                    return;
                }
                return;
            }
            if (i != 120) {
                switch (i) {
                    case 110:
                        com.anythink.core.common.t.c cVar2 = this.a;
                        if (cVar2 != null) {
                            cVar2.a();
                        }
                        BaseIncentiveTaskView baseIncentiveTaskView = this.b;
                        if (baseIncentiveTaskView != null) {
                            baseIncentiveTaskView.onResume();
                        }
                        break;
                    case 111:
                        com.anythink.core.common.t.c cVar3 = this.a;
                        if (cVar3 != null) {
                            cVar3.b();
                        }
                        BaseIncentiveTaskView baseIncentiveTaskView2 = this.b;
                        if (baseIncentiveTaskView2 != null) {
                            baseIncentiveTaskView2.onPause();
                        }
                        break;
                }
                return;
            }
        }
        a();
    }

    @Override // com.anythink.basead.ui.improveclick.c
    final void a() {
        com.anythink.core.common.t.c cVar = this.a;
        if (cVar != null) {
            cVar.c();
            this.a = null;
        }
        c();
    }

    private void b() {
        int iBo = this.f.o.bo();
        this.q = iBo;
        if (iBo == 2) {
            this.b = new QAIncentiveTaskView(this.d);
        } else if (iBo == 3) {
            this.b = new CountDownSkipIncentiveTaskView(this.d);
        }
        if (this.b != null) {
            this.o = System.currentTimeMillis();
            this.b.initSetting(this.e, this.f.o, this.n, new AnonymousClass2());
            if (this.i != null) {
                this.i.addView(this.b, new RelativeLayout.LayoutParams(-1, -1));
                if (this.k instanceof c.b) {
                    ((c.b) this.k).b();
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.improveclick.h$2, reason: invalid class name */
    final class AnonymousClass2 implements BaseIncentiveTaskView.a {
        AnonymousClass2() {
        }

        @Override // com.anythink.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView.a
        public final void a() {
            com.anythink.core.common.u.e.a(h.this.f, h.this.e, h.this.o, h.this.p, h.this.n, h.this.r);
            h.this.c();
        }

        @Override // com.anythink.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView.a
        public final void a(long j) {
            if (h.this.k instanceof c.b) {
                ((c.b) h.this.k).a(j);
            }
        }

        @Override // com.anythink.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView.a
        public final void b() {
            h.g(h.this);
            if (h.this.k != null) {
                h.this.k.a(16, h.this.q == 3 ? 42 : 13);
            }
        }

        @Override // com.anythink.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView.a
        public final void a(int i) {
            h.this.r = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        BaseIncentiveTaskView baseIncentiveTaskView = this.b;
        if (baseIncentiveTaskView != null) {
            am.a(baseIncentiveTaskView);
            if (this.k instanceof c.b) {
                ((c.b) this.k).a();
            }
            this.b.release();
            this.b = null;
        }
    }

    static /* synthetic */ void a(h hVar) {
        int iBo = hVar.f.o.bo();
        hVar.q = iBo;
        if (iBo == 2) {
            hVar.b = new QAIncentiveTaskView(hVar.d);
        } else if (iBo == 3) {
            hVar.b = new CountDownSkipIncentiveTaskView(hVar.d);
        }
        if (hVar.b != null) {
            hVar.o = System.currentTimeMillis();
            hVar.b.initSetting(hVar.e, hVar.f.o, hVar.n, hVar.new AnonymousClass2());
            if (hVar.i != null) {
                hVar.i.addView(hVar.b, new RelativeLayout.LayoutParams(-1, -1));
                if (hVar.k instanceof c.b) {
                    ((c.b) hVar.k).b();
                }
            }
        }
    }
}
