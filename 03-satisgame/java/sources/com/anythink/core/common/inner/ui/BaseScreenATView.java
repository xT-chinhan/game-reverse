package com.anythink.core.common.inner.ui;

import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.anythink.core.basead.ui.web.WebProgressBarView;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.inner.e.d;
import com.anythink.core.common.inner.e.e;
import com.anythink.core.common.inner.mixad.e.c;
import com.anythink.core.common.u.p;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseScreenATView extends BaseATView {
    public static final int FORMAT_INTERSTITIAL = 3;
    public static final int FORMAT_REWARD_VIDEO = 1;
    public static final String TAG = "BaseScreenATView";
    protected ViewGroup A;
    protected MuteImageView B;
    com.anythink.core.common.inner.ui.e.a C;
    protected com.anythink.core.common.inner.ui.component.a D;
    protected d E;
    protected boolean F;
    protected int G;
    protected int H;
    protected int I;
    protected int J;
    private long K;
    private long L;
    private long M;
    private CountDownView N;
    private WebProgressBarView O;
    protected int a;
    protected int b;
    protected int c;
    protected int d;
    public boolean hasClick;
    protected int l;
    protected int m;
    protected int n;
    public int nativeTemplateRatio;
    protected boolean o;
    protected int p;
    protected long q;
    protected int r;
    public int ranDom;
    protected boolean s;
    protected boolean t;
    protected boolean u;
    protected RelativeLayout v;
    protected PanelView w;
    protected BaseEndCardView x;
    protected CloseImageView y;
    protected CloseShadeView z;

    private static void B() {
    }

    protected abstract boolean a(int i);

    protected void c() {
    }

    protected abstract int g();

    protected void h() {
    }

    public void handleFullScreenClick(ViewGroup viewGroup) {
    }

    protected void i() {
    }

    protected void j() {
    }

    protected void k() {
    }

    protected abstract void l();

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    protected abstract void q();

    protected void r() {
    }

    public BaseScreenATView(Context context) {
        super(context);
        this.hasClick = false;
        this.nativeTemplateRatio = 1;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x006d  */
    public BaseScreenATView(Context context, x xVar, w wVar, String str, int i, int i2) {
        super(context, xVar, wVar, str);
        this.hasClick = false;
        this.nativeTemplateRatio = 1;
        this.a = i;
        this.b = i2;
        this.F = false;
        this.ranDom = new Random().nextInt(100) + 1;
        this.K = this.f.t.o() > 0 ? this.f.t.o() * 1000 : this.f.t.o();
        long jP = this.f.t.p() > 0 ? this.f.t.p() * 1000 : this.f.t.p();
        this.L = jP;
        if (jP > 0) {
            long j = this.K;
            if (j >= 0) {
                this.M = j + jP;
            } else {
                this.M = jP;
            }
        } else {
            this.M = jP;
        }
        this.n = this.f.t.s() * 1000;
        this.r = this.f.t.a();
        this.u = this.f.t.r() == 0;
        int i3 = this.f.j;
        if (i3 == 34 || i3 == 58 || i3 == 2 || i3 == 39) {
            this.r = -1;
        }
        if (this.f.t instanceof c) {
            this.nativeTemplateRatio = ((c) this.f.t).ai();
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0050  */
    private void y() {
        this.K = this.f.t.o() > 0 ? this.f.t.o() * 1000 : this.f.t.o();
        long jP = this.f.t.p() > 0 ? this.f.t.p() * 1000 : this.f.t.p();
        this.L = jP;
        if (jP > 0) {
            long j = this.K;
            if (j >= 0) {
                this.M = j + jP;
            } else {
                this.M = jP;
            }
        } else {
            this.M = jP;
        }
        this.n = this.f.t.s() * 1000;
        this.r = this.f.t.a();
        this.u = this.f.t.r() == 0;
        int i = this.f.j;
        if (i == 34 || i == 58 || i == 2 || i == 39) {
            this.r = -1;
        }
        if (this.f.t instanceof c) {
            this.nativeTemplateRatio = ((c) this.f.t).ai();
        }
    }

    public void setListener(d dVar) {
        this.E = dVar;
    }

    public boolean isShowEndCard() {
        return this.s;
    }

    public void setIsShowEndCard(boolean z) {
        this.s = z;
    }

    public boolean hasReward() {
        return this.t;
    }

    public void setHasReward(boolean z) {
        this.t = z;
    }

    public boolean isVideoMute() {
        return this.u;
    }

    public void setVideoMute(boolean z) {
        this.u = z;
    }

    public long getShowBannerTime() {
        return this.K;
    }

    public void setShowBannerTime(long j) {
        this.K = j;
    }

    public long getHideBannerTime() {
        return this.M;
    }

    public void setHideBannerTime(long j) {
        this.M = j;
    }

    public void init() {
        b();
    }

    protected void b() {
        this.v = (RelativeLayout) findViewById(p.a(getContext(), "myoffer_rl_root", "id"));
        this.y = (CloseImageView) findViewById(p.a(getContext(), "myoffer_btn_close_id", "id"));
        this.z = (CloseShadeView) findViewById(p.a(getContext(), "myoffer_btn_close_shade_id", "id"));
        this.w = (PanelView) findViewById(p.a(getContext(), "myoffer_banner_view_id", "id"));
        this.N = (CountDownView) findViewById(p.a(getContext(), "myoffer_count_down_view_id", "id"));
        this.B = (MuteImageView) findViewById(p.a(getContext(), "myoffer_btn_mute_id", "id"));
        this.A = (ViewGroup) findViewById(p.a(getContext(), "myoffer_feedback_ll_id", "id"));
        this.O = (WebProgressBarView) findViewById(p.a(getContext(), "myoffer_player_view_progress_bar_id", "id"));
        this.D = new com.anythink.core.common.inner.ui.component.a(this.f.t, this.N, this.O);
        com.anythink.core.common.inner.ui.e.a aVar = new com.anythink.core.common.inner.ui.e.a(this.g, this.f);
        this.C = aVar;
        aVar.b(this);
        b(4);
        k();
        CloseImageView closeImageView = this.y;
        if (closeImageView != null) {
            closeImageView.setVisibility(8);
            this.y.setOnClickListener(new AnonymousClass2());
        }
        i();
        j();
        this.o = a(this.p);
    }

    private void z() {
        com.anythink.core.common.inner.ui.e.a aVar = new com.anythink.core.common.inner.ui.e.a(this.g, this.f);
        this.C = aVar;
        aVar.b(this);
    }

    private void A() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.c = displayMetrics.widthPixels;
        int i = displayMetrics.heightPixels;
        this.d = i;
        this.G = this.c;
        this.H = i;
    }

    protected void f() {
        this.s = true;
        this.p = g();
        EndCardView endCardView = new EndCardView(getContext(), this.g, this.f);
        endCardView.setSize(this.c, this.d);
        endCardView.init(false, false, new AnonymousClass1());
        this.x = endCardView;
        q();
        endCardView.load();
        if (a(this.p)) {
            o();
        }
        r();
    }

    private void C() {
        this.p = g();
        EndCardView endCardView = new EndCardView(getContext(), this.g, this.f);
        endCardView.setSize(this.c, this.d);
        endCardView.init(false, false, new AnonymousClass1());
        this.x = endCardView;
        q();
        endCardView.load();
        if (a(this.p)) {
            o();
        }
        r();
    }

    /* JADX INFO: renamed from: com.anythink.core.common.inner.ui.BaseScreenATView$1, reason: invalid class name */
    final class AnonymousClass1 implements BaseEndCardView.a {
        @Override // com.anythink.core.common.inner.ui.BaseEndCardView.a
        public final void a() {
        }

        @Override // com.anythink.core.common.inner.ui.BaseEndCardView.a
        public final void b() {
        }

        AnonymousClass1() {
        }
    }

    protected final void a(com.anythink.core.common.inner.b.a aVar) {
        d dVar = this.E;
        if (dVar != null) {
            dVar.a(aVar);
        }
    }

    @Override // com.anythink.core.common.inner.ui.BaseATView
    protected final void e() {
        d dVar = this.E;
        if (dVar != null) {
            dVar.a(new e());
        }
    }

    @Override // com.anythink.core.common.inner.ui.BaseATView
    protected final void a(e eVar) {
        d dVar = this.E;
        if (dVar != null) {
            dVar.b(eVar);
        }
    }

    @Override // com.anythink.core.common.inner.ui.BaseATView
    protected final void a(boolean z) {
        d dVar = this.E;
        if (dVar != null) {
            dVar.a(z);
        }
    }

    private void D() {
        destroy();
    }

    @Override // com.anythink.core.common.inner.ui.BaseATView
    public void destroy() {
        super.destroy();
        this.E = null;
    }

    private void E() {
        b(4);
    }

    /* JADX INFO: renamed from: com.anythink.core.common.inner.ui.BaseScreenATView$2, reason: invalid class name */
    final class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            BaseScreenATView.this.l();
        }
    }

    protected final void m() {
        d dVar = this.E;
        if (dVar != null) {
            dVar.d();
        }
    }

    protected void n() {
        b(0);
        MuteImageView muteImageView = this.B;
        if (muteImageView == null || muteImageView.getVisibility() == 0) {
            return;
        }
        this.B.setVisibility(0);
    }

    private void G() {
        MuteImageView muteImageView = this.B;
        if (muteImageView == null || muteImageView.getVisibility() == 0) {
            return;
        }
        this.B.setVisibility(0);
    }

    protected final void b(int i) {
        com.anythink.core.common.inner.ui.component.a aVar = this.D;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    protected final void a(long j) {
        com.anythink.core.common.inner.ui.component.a aVar = this.D;
        if (aVar != null) {
            aVar.b(j);
        }
    }

    private void H() {
        com.anythink.core.common.inner.ui.component.a aVar = this.D;
        if (aVar != null) {
            aVar.a();
        }
    }

    protected final void b(long j) {
        com.anythink.core.common.inner.ui.component.a aVar = this.D;
        if (aVar != null) {
            aVar.a(j);
        }
    }

    protected final CloseImageView s() {
        return this.y;
    }

    protected final PanelView t() {
        return this.w;
    }

    private void I() {
        if (1 == this.a) {
            p();
            if (this.t) {
                return;
            }
            this.t = true;
            d dVar = this.E;
            if (dVar != null) {
                dVar.c();
            }
        }
    }

    protected final boolean u() {
        return this.f != null && this.f.j == 59;
    }

    protected final boolean v() {
        return this.f != null && this.f.j == 2;
    }

    protected final boolean w() {
        return this.f != null && this.f.j == 39;
    }

    protected final boolean x() {
        return (this.f == null || this.f.t == null || this.f.t.q() == 0) ? false : true;
    }

    @Override // com.anythink.core.common.inner.ui.BaseATView
    protected void d() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.c = displayMetrics.widthPixels;
        int i = displayMetrics.heightPixels;
        this.d = i;
        this.G = this.c;
        this.H = i;
        h();
    }

    private void F() {
        CloseImageView closeImageView = this.y;
        if (closeImageView != null) {
            closeImageView.setVisibility(8);
            this.y.setOnClickListener(new AnonymousClass2());
        }
    }

    protected final void o() {
        PanelView panelView = this.w;
        if (panelView != null) {
            if (panelView.getVisibility() != 0) {
                panelView.setVisibility(0);
            }
            if (panelView.getCTAButton() == null || panelView.getCTAButton().getVisibility() != 0) {
                return;
            }
            if (this.k == null || !this.k.equals(panelView.getCTAButton())) {
                this.k = (ScanningAnimButton) panelView.getCTAButton();
            }
        }
    }

    protected void p() {
        CloseImageView closeImageView = this.y;
        if (closeImageView == null || closeImageView.getVisibility() == 0) {
            return;
        }
        this.y.setVisibility(0);
    }
}
