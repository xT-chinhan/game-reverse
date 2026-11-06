package com.anythink.basead.h;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.anythink.basead.g.j;
import com.anythink.basead.ui.improveclick.i;
import com.anythink.core.api.IOfferClickHandler;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e extends c {
    com.anythink.basead.g.a a;
    com.anythink.core.common.v.a.c k;
    com.anythink.basead.b.c l;
    View m;
    volatile boolean n;
    View o;
    View.OnClickListener p;
    View.OnClickListener q;
    com.anythink.basead.ui.improveclick.a r;
    private final String s;

    public static View l() {
        return null;
    }

    @Override // com.anythink.basead.h.a
    public final void a(Activity activity, Map<String, Object> map) {
    }

    final void a(View view, boolean z) {
        View view2 = this.o;
        if (view2 != null && view == view2) {
            a(1, 1, z);
            return;
        }
        View view3 = this.m;
        if (view3 != null && view == view3) {
            a(1, 3, z);
        } else {
            a(1, 2, z);
        }
    }

    private void a(int i, int i2) {
        a(i, i2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i, final int i2, boolean z) {
        s();
        if (this.l == null) {
            this.l = new com.anythink.basead.b.c(this.c, this.d, this.g, this.m);
        }
        if (this.l.a()) {
            return;
        }
        this.l.a(new com.anythink.basead.b.c.a() { // from class: com.anythink.basead.h.e.3
            @Override // com.anythink.basead.b.c.a
            public final boolean a(String str, IOfferClickHandler iOfferClickHandler) {
                return false;
            }

            @Override // com.anythink.basead.b.c.a
            public final void b() {
            }

            @Override // com.anythink.basead.b.c.a
            public final void a() {
                if (e.this.a != null) {
                    e.this.a.onAdClick(new j().a(i, i2));
                }
            }

            @Override // com.anythink.basead.b.c.a
            public final void c() {
                i.a().b();
            }

            @Override // com.anythink.basead.b.c.a
            public final void a(boolean z2) {
                if (e.this.a != null) {
                    e.this.a.onDeeplinkCallback(z2);
                }
            }
        });
        com.anythink.basead.d.j jVar = new com.anythink.basead.d.j(this.d, "");
        if (z) {
            jVar.m = true;
        }
        this.l.a(jVar);
        a(113);
    }

    private void a(View view, View[] viewArr) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i), viewArr);
            }
            return;
        }
        if ((view instanceof Button) || (view instanceof TextView)) {
            String string = ((TextView) view).getText().toString();
            if (TextUtils.isEmpty(string) || !TextUtils.equals(string, h())) {
                return;
            }
            viewArr[0] = view;
        }
    }

    public e(Context context, x xVar, String str, boolean z) {
        super(context, xVar, str, z);
        this.s = getClass().getSimpleName();
        this.p = new View.OnClickListener() { // from class: com.anythink.basead.h.e.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.this.a(view, false);
            }
        };
        this.q = new View.OnClickListener() { // from class: com.anythink.basead.h.e.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.this.a(view, true);
            }
        };
    }

    public final String b() {
        return this.g != null ? this.g.x() : "";
    }

    public final String g() {
        return this.g != null ? this.g.y() : "";
    }

    public final String h() {
        return this.g != null ? this.g.D() : "";
    }

    public final String i() {
        return this.g != null ? this.g.z() : "";
    }

    public final String j() {
        return this.g != null ? this.g.B() : "";
    }

    public final String k() {
        return this.g != null ? this.g.C() : "";
    }

    public final int m() {
        if (this.g != null) {
            return this.g.ab();
        }
        return 0;
    }

    public final int n() {
        if (this.g != null) {
            return this.g.ac();
        }
        return 0;
    }

    public final void a(com.anythink.basead.g.a aVar) {
        this.a = aVar;
    }

    private void a(View view, View.OnClickListener onClickListener) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i), onClickListener);
            }
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    public final void o() {
        com.anythink.core.common.v.a.c cVar = this.k;
        if (cVar != null) {
            cVar.a();
        }
    }

    private void a(View view) {
        this.m = view;
        if (view != null && (view instanceof ViewGroup) && this.g != null && this.d != null) {
            this.r = new AnonymousClass6((ViewGroup) this.m, this.g, this.d, new AnonymousClass5());
        }
        AnonymousClass4 anonymousClass4 = new AnonymousClass4();
        if (this.k == null) {
            view.getContext();
            this.k = new com.anythink.core.common.v.a.c(1);
        }
        this.k.a(view, anonymousClass4);
    }

    /* JADX INFO: renamed from: com.anythink.basead.h.e$4, reason: invalid class name */
    final class AnonymousClass4 extends com.anythink.core.common.v.a.a {
        AnonymousClass4() {
        }

        @Override // com.anythink.core.common.v.a.a, com.anythink.core.common.v.a.b
        public final void recordImpression(View view) {
            e.this.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.n) {
            return;
        }
        a(114);
        this.n = true;
        com.anythink.basead.h.a.b.a(this.c).a(this.g);
        com.anythink.basead.b.b.a(8, this.g, new com.anythink.basead.d.j(this.d, ""));
        com.anythink.basead.g.a aVar = this.a;
        if (aVar != null) {
            aVar.onAdShow(new j());
        }
    }

    public final void p() {
        o();
        a(112);
        this.a = null;
        com.anythink.basead.b.c cVar = this.l;
        if (cVar != null) {
            cVar.d();
            this.l = null;
        }
        com.anythink.core.common.v.a.c cVar2 = this.k;
        if (cVar2 != null) {
            cVar2.b();
            this.k = null;
        }
    }

    private void t() {
        View view = this.m;
        if (view == null || !(view instanceof ViewGroup) || this.g == null || this.d == null) {
            return;
        }
        this.r = new AnonymousClass6((ViewGroup) this.m, this.g, this.d, new AnonymousClass5());
    }

    /* JADX INFO: renamed from: com.anythink.basead.h.e$5, reason: invalid class name */
    final class AnonymousClass5 implements com.anythink.basead.ui.improveclick.c.a {
        AnonymousClass5() {
        }

        @Override // com.anythink.basead.ui.improveclick.c.a
        public final void a(int i, int i2) {
            e.this.a(i, i2, false);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.h.e$6, reason: invalid class name */
    final class AnonymousClass6 extends com.anythink.basead.ui.improveclick.a {
        AnonymousClass6(ViewGroup viewGroup, w wVar, x xVar, com.anythink.basead.ui.improveclick.c.a aVar) {
            super(viewGroup, wVar, xVar, 5, aVar);
        }

        @Override // com.anythink.basead.ui.improveclick.a
        public final ViewGroup.LayoutParams a() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (e.this.m != null) {
                layoutParams.gravity = 81;
                layoutParams.setMargins(0, 0, 0, 0);
            }
            return layoutParams;
        }
    }

    private void a(int i) {
        com.anythink.basead.ui.improveclick.a aVar = this.r;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    private int u() {
        if (this.g != null) {
            return this.g.ab();
        }
        return 0;
    }

    private int v() {
        if (this.g != null) {
            return this.g.ac();
        }
        return 0;
    }

    public final int q() {
        if (this.g != null) {
            return this.g.K();
        }
        return 0;
    }

    public final int r() {
        if (this.g != null) {
            return this.g.aa();
        }
        return 0;
    }

    public final void a(View view, List<View> list, List<View> list2) {
        this.m = view;
        if (view != null && (view instanceof ViewGroup) && this.g != null && this.d != null) {
            this.r = new AnonymousClass6((ViewGroup) this.m, this.g, this.d, new AnonymousClass5());
        }
        AnonymousClass4 anonymousClass4 = new AnonymousClass4();
        if (this.k == null) {
            view.getContext();
            this.k = new com.anythink.core.common.v.a.c(1);
        }
        this.k.a(view, anonymousClass4);
        if (list != null && list.size() > 0) {
            View[] viewArr = new View[1];
            a(view, viewArr);
            View view2 = viewArr[0];
            if (view2 != null) {
                this.o = view2;
            }
            for (View view3 : list) {
                if (view3 != null) {
                    view3.setOnClickListener(this.p);
                }
            }
        } else {
            a(view, this.p);
        }
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        for (View view4 : list2) {
            if (view4 != null) {
                view4.setOnClickListener(this.q);
            }
        }
    }
}
