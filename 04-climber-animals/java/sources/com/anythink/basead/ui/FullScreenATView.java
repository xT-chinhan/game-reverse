package com.anythink.basead.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.anythink.basead.b.e;
import com.anythink.basead.ui.animplayerview.BasePlayerView;
import com.anythink.basead.ui.f.d;
import com.anythink.basead.ui.improveclick.g;
import com.anythink.core.api.IOfferClickHandler;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.ui.component.RoundImageView;
import com.anythink.core.common.v.q;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class FullScreenATView extends BaseScreenATView {
    public static final String TAG = "FullScreenATView";
    LinearLayout ah;
    TextView ai;
    ImageView aj;
    private CountDownCloseView ak;
    private CloseHeaderView al;
    private PanelView am;
    private d an;
    private FullScreenHeaderPanelView ao;
    private long ap;
    private long aq;

    @Override // com.anythink.basead.ui.BaseATView
    protected final int r() {
        return 1;
    }

    public FullScreenATView(Context context) {
        super(context);
    }

    public FullScreenATView(Context context, x xVar, w wVar, String str, int i, int i2) {
        super(context, xVar, wVar, str, i, i2);
        setId(q.a(getContext(), "myoffer_full_screen_view_id", "id"));
        if (xVar != null) {
            this.an = new d(wVar, xVar.o);
        }
        this.ap = -1L;
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected void a() {
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_full_screen", "layout"), this);
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected void b() {
        super.b();
        d dVar = this.an;
        if (dVar != null) {
            dVar.a(this.E == 8 ? d.b : -100).a(new com.anythink.basead.ui.d.a() { // from class: com.anythink.basead.ui.FullScreenATView.1
                @Override // com.anythink.basead.ui.d.a
                public final void a(int i, int i2) {
                    FullScreenATView.this.a(i, i2);
                }
            }).a(getContext(), this);
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected void c() {
        super.c();
        this.ak = (CountDownCloseView) findViewById(q.a(getContext(), "myoffer_btn_countdown_close_id", "id"));
        this.al = (CloseHeaderView) findViewById(q.a(getContext(), "myoffer_btn_close_header_view_id", "id"));
        this.am = (PanelView) findViewById(q.a(getContext(), "myoffer_banner_view_for_anim_player_id", "id"));
        FullScreenHeaderPanelView fullScreenHeaderPanelView = (FullScreenHeaderPanelView) findViewById(q.a(getContext(), "myoffer_header_panel_view_id", "id"));
        this.ao = fullScreenHeaderPanelView;
        if (fullScreenHeaderPanelView != null && e.a(this.g)) {
            this.ao.initSetting(this.g, this.f, new FullScreenHeaderPanelView.a() { // from class: com.anythink.basead.ui.FullScreenATView.2
                @Override // com.anythink.basead.ui.FullScreenHeaderPanelView.a
                public final void a() {
                    FullScreenATView.this.a(1, 23);
                }
            });
            this.T = this.ao;
        }
        this.ah = (LinearLayout) findViewById(q.a(getContext(), "myoffer_tv_reward_tips_ll_id", "id"));
        this.ai = (TextView) findViewById(q.a(getContext(), "myoffer_tv_reward_tips_id", "id"));
        this.aj = (ImageView) findViewById(q.a(getContext(), "myoffer_tv_reward_tips_icon_id", "id"));
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void L() {
        super.L();
        if (ai()) {
            if (this.F == 101) {
                CloseHeaderView closeHeaderView = this.al;
                if (closeHeaderView != null) {
                    closeHeaderView.setVisibility(0);
                    if (this.al.getCloseImageView() != null) {
                        this.al.getCloseImageView().setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            }
            CountDownCloseView countDownCloseView = this.ak;
            if (countDownCloseView != null) {
                countDownCloseView.setVisibility(0);
            }
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void O() {
        super.O();
        if (ai()) {
            S();
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void d() {
        super.d();
        if (this.r == null || !ai()) {
            return;
        }
        if (this.s != null) {
            HashMap map = new HashMap();
            map.put(g.a.j, Integer.valueOf(this.F));
            this.s.a(map);
        }
        a(125);
        this.r.e(this.F);
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void P() {
        super.P();
        if (this.F != 100) {
            d(8);
        }
        al();
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected boolean b(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 5 || i == 6) {
            return e.a(this.g);
        }
        return i == 8;
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void H() {
        PanelView panelView = this.am;
        if (panelView != null) {
            panelView.setVisibility(4);
            this.am.init(this.g, this.f, this.b, n(), new PanelView.a() { // from class: com.anythink.basead.ui.FullScreenATView.3
                @Override // com.anythink.basead.ui.PanelView.a
                public final void a(int i, int i2) {
                    FullScreenATView.this.a(i, i2);
                }

                @Override // com.anythink.basead.ui.PanelView.a
                public final boolean a() {
                    if (!FullScreenATView.this.J()) {
                        return false;
                    }
                    FullScreenATView.this.a(4, 5);
                    return true;
                }
            });
        }
        super.H();
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected void I() {
        super.I();
        if (!e.a(this.g)) {
            this.E = 8;
        } else {
            this.E = 0;
        }
        if (this.N != null) {
            this.N.setLayoutType(this.E);
            if (this.E == 8 && this.f.o.H() == 0) {
                this.N.getCTAButton().setVisibility(8);
            }
        }
        PanelView panelView = this.am;
        if (panelView != null) {
            panelView.setLayoutType(this.E);
            if (this.E == 8 && this.f.o.H() == 0) {
                this.am.getCTAButton().setVisibility(8);
            }
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected void V() {
        super.V();
        if (this.a == 1 && this.J) {
            RoundImageView roundImageView = new RoundImageView(getContext().getApplicationContext());
            roundImageView.setImageResource(q.a(getContext(), "myoffer_reward_icon", "drawable"));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(q.a(getContext(), 60.0f), q.a(getContext(), 60.0f));
            int iIndexOfChild = 2;
            if (b(this.E)) {
                int i = this.E;
                if (i == 2 || i == 6) {
                    layoutParams.leftMargin = this.c - q.a(getContext(), 330.0f);
                    layoutParams.topMargin = q.a(getContext(), 22.0f);
                } else {
                    layoutParams.leftMargin = q.a(getContext(), 12.0f);
                    layoutParams.topMargin = q.a(getContext(), 12.0f);
                }
            } else {
                layoutParams.leftMargin = q.a(getContext(), 12.0f);
                layoutParams.topMargin = q.a(getContext(), 12.0f);
            }
            roundImageView.setLayoutParams(layoutParams);
            try {
                iIndexOfChild = this.M.indexOfChild(this.N) + 1;
            } catch (Throwable unused) {
            }
            this.M.addView(roundImageView, iIndexOfChild);
        }
        LinearLayout linearLayout = this.ah;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        if (o()) {
            if (this.N != null) {
                this.N.setVisibility(8);
            }
            PanelView panelView = this.am;
            if (panelView != null) {
                panelView.setVisibility(8);
            }
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected int y() {
        if (this.E == 8) {
            return this.E;
        }
        if (this.c < this.d) {
            return this.af >= this.ag ? 1 : 5;
        }
        if (e.a(this.g, this.f) && this.U != null) {
            this.U.a();
        }
        return this.af < this.ag ? 2 : 6;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0099  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b8  */
    @Override // com.anythink.basead.ui.BaseScreenATView
    protected void U() {
        int iA;
        int iA2;
        RelativeLayout.LayoutParams layoutParams;
        if (this.M == null || this.O == null || this.O.getParent() != null) {
            return;
        }
        if (!e.a(this.g, this.f)) {
            af();
            return;
        }
        this.O.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        if (!o() && b(this.E)) {
            PanelView panelViewAa = aa();
            int i = this.E;
            if (i == 1) {
                this.M.setBackgroundColor(-1);
                int i2 = (int) (this.d * 0.5f);
                if (TextUtils.isEmpty(this.g.z())) {
                    iA = this.d - i2;
                } else {
                    iA = (this.d - i2) + q.a(getContext(), 50.0f);
                }
                this.O.setLayoutParams(new RelativeLayout.LayoutParams(-1, i2));
                this.O.setNeedArc(true);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) panelViewAa.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = this.c;
                    layoutParams2.height = iA;
                    panelViewAa.setLayoutParams(layoutParams2);
                    panelViewAa.removeAllViews();
                    panelViewAa.setLayoutType(this.E);
                }
            } else if (i == 2) {
                iA2 = q.a(getContext(), 300.0f);
                this.O.setLayoutParams(new RelativeLayout.LayoutParams(this.c - iA2, -1));
                layoutParams = (RelativeLayout.LayoutParams) panelViewAa.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = iA2;
                    layoutParams.height = -1;
                    panelViewAa.setLayoutParams(layoutParams);
                    panelViewAa.removeAllViews();
                    panelViewAa.setLayoutType(this.E);
                }
            } else if (i == 5) {
                int i3 = (int) (this.d * 0.5f);
                this.O.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.d - i3));
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) panelViewAa.getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.width = this.c;
                    layoutParams3.height = i3;
                    panelViewAa.setLayoutParams(layoutParams3);
                    panelViewAa.removeAllViews();
                    panelViewAa.setLayoutType(this.E);
                }
            } else if (i == 6) {
                iA2 = q.a(getContext(), 300.0f);
                this.O.setLayoutParams(new RelativeLayout.LayoutParams(this.c - iA2, -1));
                layoutParams = (RelativeLayout.LayoutParams) panelViewAa.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = iA2;
                    layoutParams.height = -1;
                    panelViewAa.setLayoutParams(layoutParams);
                    panelViewAa.removeAllViews();
                    panelViewAa.setLayoutType(this.E);
                }
            } else if (this.f.o.H() != 0) {
                View shakeView = panelViewAa.getShakeView();
                if (n()) {
                    if (shakeView != null) {
                        shakeView.setVisibility(0);
                    }
                } else if (shakeView != null) {
                    shakeView.setVisibility(8);
                }
            }
        }
        this.M.addView(this.O, 0);
    }

    protected final void af() {
        this.O.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        if (o()) {
            this.M.addView(this.O, 0);
        } else {
            aa().setVisibility(0);
            this.M.addView(this.O, 0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0087  */
    /* JADX WARN: Code duplicated, block: B:29:0x00a6  */
    private void ag() {
        int iA;
        int iA2;
        RelativeLayout.LayoutParams layoutParams;
        this.O.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        if (o()) {
            this.M.addView(this.O, 0);
            return;
        }
        if (b(this.E)) {
            PanelView panelViewAa = aa();
            int i = this.E;
            if (i == 1) {
                this.M.setBackgroundColor(-1);
                int i2 = (int) (this.d * 0.5f);
                if (TextUtils.isEmpty(this.g.z())) {
                    iA = this.d - i2;
                } else {
                    iA = (this.d - i2) + q.a(getContext(), 50.0f);
                }
                this.O.setLayoutParams(new RelativeLayout.LayoutParams(-1, i2));
                this.O.setNeedArc(true);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) panelViewAa.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = this.c;
                    layoutParams2.height = iA;
                    panelViewAa.setLayoutParams(layoutParams2);
                    panelViewAa.removeAllViews();
                    panelViewAa.setLayoutType(this.E);
                }
            } else if (i == 2) {
                iA2 = q.a(getContext(), 300.0f);
                this.O.setLayoutParams(new RelativeLayout.LayoutParams(this.c - iA2, -1));
                layoutParams = (RelativeLayout.LayoutParams) panelViewAa.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = iA2;
                    layoutParams.height = -1;
                    panelViewAa.setLayoutParams(layoutParams);
                    panelViewAa.removeAllViews();
                    panelViewAa.setLayoutType(this.E);
                }
            } else if (i == 5) {
                int i3 = (int) (this.d * 0.5f);
                this.O.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.d - i3));
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) panelViewAa.getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.width = this.c;
                    layoutParams3.height = i3;
                    panelViewAa.setLayoutParams(layoutParams3);
                    panelViewAa.removeAllViews();
                    panelViewAa.setLayoutType(this.E);
                }
            } else if (i == 6) {
                iA2 = q.a(getContext(), 300.0f);
                this.O.setLayoutParams(new RelativeLayout.LayoutParams(this.c - iA2, -1));
                layoutParams = (RelativeLayout.LayoutParams) panelViewAa.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = iA2;
                    layoutParams.height = -1;
                    panelViewAa.setLayoutParams(layoutParams);
                    panelViewAa.removeAllViews();
                    panelViewAa.setLayoutType(this.E);
                }
            } else if (this.f.o.H() != 0) {
                View shakeView = panelViewAa.getShakeView();
                if (n()) {
                    if (shakeView != null) {
                        shakeView.setVisibility(0);
                    }
                } else if (shakeView != null) {
                    shakeView.setVisibility(8);
                }
            }
        }
        this.M.addView(this.O, 0);
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void M() {
        int iAA = this.f.o.aA();
        int i = this.a;
        if (i != 1) {
            if (i == 3) {
                if (this.I) {
                    c(1);
                    return;
                }
                N();
                if (iAA == 1 || iAA == 2) {
                    c(1);
                    return;
                }
                if (p()) {
                    this.p = true;
                }
                x();
                return;
            }
            c(1);
            return;
        }
        if (this.p) {
            c(1);
            return;
        }
        if (this.J) {
            if (iAA == 1 || iAA == 3) {
                N();
                c(1);
                return;
            } else {
                N();
                if (p()) {
                    this.p = true;
                }
                x();
                return;
            }
        }
        if (iAA == 1 || iAA == 2) {
            try {
                Toast.makeText(getContext().getApplicationContext(), getContext().getString(q.a(getContext(), "myoffer_reward_exit_tips_msg", "string")), 0).show();
            } catch (Throwable unused) {
            }
            N();
            c(1);
            return;
        }
        double dCeil = Math.ceil(this.H / 1000.0d);
        if (this.r != null) {
            double dCeil2 = Math.ceil(this.r.h() / 1000.0d);
            if (dCeil > dCeil2) {
                dCeil = dCeil2;
            }
        }
        RewardExitConfirmDialogActivity.a(getContext(), String.valueOf((int) dCeil), new Runnable() { // from class: com.anythink.basead.ui.FullScreenATView.4
            @Override // java.lang.Runnable
            public final void run() {
                FullScreenATView.this.N();
                FullScreenATView.this.c(1);
            }
        }, ai() ? 2 : 1);
    }

    private void ah() {
        if (this.a == 1 && this.J) {
            RoundImageView roundImageView = new RoundImageView(getContext().getApplicationContext());
            roundImageView.setImageResource(q.a(getContext(), "myoffer_reward_icon", "drawable"));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(q.a(getContext(), 60.0f), q.a(getContext(), 60.0f));
            int iIndexOfChild = 2;
            if (b(this.E)) {
                int i = this.E;
                if (i == 2 || i == 6) {
                    layoutParams.leftMargin = this.c - q.a(getContext(), 330.0f);
                    layoutParams.topMargin = q.a(getContext(), 22.0f);
                } else {
                    layoutParams.leftMargin = q.a(getContext(), 12.0f);
                    layoutParams.topMargin = q.a(getContext(), 12.0f);
                }
            } else {
                layoutParams.leftMargin = q.a(getContext(), 12.0f);
                layoutParams.topMargin = q.a(getContext(), 12.0f);
            }
            roundImageView.setLayoutParams(layoutParams);
            try {
                iIndexOfChild = this.M.indexOfChild(this.N) + 1;
            } catch (Throwable unused) {
            }
            this.M.addView(roundImageView, iIndexOfChild);
        }
        LinearLayout linearLayout = this.ah;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void e(int i) {
        if (ai()) {
            this.Q.setVisibility(8);
            if (this.V != null) {
                this.V.a(8);
                return;
            }
            return;
        }
        super.e(i);
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void b(long j) {
        if (ai()) {
            CloseHeaderView closeHeaderView = this.al;
            if (closeHeaderView != null && closeHeaderView.getVisibility() == 0) {
                this.al.refresh(j);
            }
            CountDownCloseView countDownCloseView = this.ak;
            if (countDownCloseView != null && countDownCloseView.getVisibility() == 0) {
                this.ak.refresh(j);
            }
        } else {
            super.b(j);
        }
        long j2 = this.ap;
        if (j2 < 0 || j < j2) {
            return;
        }
        LinearLayout linearLayout = this.ah;
        if (linearLayout != null && linearLayout.getVisibility() != 0) {
            this.ah.setVisibility(0);
        }
        TextView textView = this.ai;
        if (textView == null || this.aq <= j - this.ap) {
            return;
        }
        textView.setText(String.format(getContext().getString(q.a(getContext(), "myoffer_reward_tips", "string")), Integer.valueOf((((int) (this.aq - (j - this.ap))) / 1000) + 1)));
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void c(long j) {
        if (ai()) {
            CloseHeaderView closeHeaderView = this.al;
            if (closeHeaderView != null && closeHeaderView.getVisibility() == 0) {
                this.al.setDuration(j);
            }
            CountDownCloseView countDownCloseView = this.ak;
            if (countDownCloseView == null || countDownCloseView.getVisibility() != 0) {
                return;
            }
            this.ak.setDuration(j);
            return;
        }
        super.c(j);
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final CloseImageView X() {
        if (ai()) {
            if (this.F == 101) {
                CloseHeaderView closeHeaderView = this.al;
                if (closeHeaderView != null && closeHeaderView.getCloseImageView() != null) {
                    return this.al.getCloseImageView();
                }
            } else {
                CountDownCloseView countDownCloseView = this.ak;
                if (countDownCloseView != null) {
                    return countDownCloseView;
                }
            }
        }
        return super.X();
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final ViewGroup Z() {
        CloseHeaderView closeHeaderView = this.al;
        if (closeHeaderView != null && closeHeaderView.getVisibility() == 0 && this.al.getFeedbackButton() != null) {
            return this.al.getFeedbackButton();
        }
        return super.Z();
    }

    private boolean ai() {
        return this.a == 1 && this.F != 100;
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final boolean a(String str, IOfferClickHandler iOfferClickHandler) {
        if (Y()) {
            this.I = true;
            boolean z = this.r != null && this.r.a(str, iOfferClickHandler);
            if (z) {
                a(105);
                d dVar = this.an;
                if (dVar != null) {
                    dVar.a();
                }
            }
            return z;
        }
        return super.a(str, iOfferClickHandler);
    }

    private boolean aj() {
        if (this.a == 1) {
            return this.F == 1 || this.F == 101;
        }
        return false;
    }

    private boolean ak() {
        return Y();
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final PanelView aa() {
        PanelView panelView;
        PanelView panelView2;
        if (e.a(this.g, this.f) || (panelView2 = this.am) == null) {
            return (this.I || this.F == 1 || (panelView = this.am) == null) ? super.aa() : panelView;
        }
        return panelView2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void ab() {
        PanelView panelView;
        if (Y()) {
            return;
        }
        if (this.a == 1 && this.F != 100) {
            if (this.r == null || !this.r.a()) {
                return;
            }
            final BasePlayerView basePlayerViewL = this.r.l();
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, -getMeasuredWidth(), 0.0f, 0.0f);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.4f);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.setFillAfter(true);
            animationSet.addAnimation(translateAnimation);
            animationSet.addAnimation(alphaAnimation);
            animationSet.setDuration(300L);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.anythink.basead.ui.FullScreenATView.5
                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation) {
                    View view = basePlayerViewL;
                    if (view != null) {
                        view.post(new Runnable() { // from class: com.anythink.basead.ui.FullScreenATView.5.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                FullScreenATView.super.ab();
                                if (FullScreenATView.this.am != null) {
                                    FullScreenATView.this.am.setVisibility(8);
                                }
                            }
                        });
                    }
                }
            });
            basePlayerViewL.startAnimation(animationSet);
            PanelView panelView2 = this.am;
            if (panelView2 == null || panelView2.getVisibility() != 0) {
                return;
            }
            this.am.startAnimation(animationSet);
            return;
        }
        super.ab();
        if (!p() || (panelView = this.am) == null) {
            return;
        }
        panelView.setVisibility(8);
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected void Q() {
        super.Q();
        d dVar = this.an;
        if (dVar != null) {
            dVar.a();
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void R() {
        super.R();
        d dVar = this.an;
        if (dVar != null) {
            dVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void ad() {
        super.ad();
        TextView textView = this.ai;
        if (textView != null) {
            textView.setText(getContext().getString(q.a(getContext(), "myoffer_reward_tips_rewarded", "string")));
        }
        ImageView imageView = this.aj;
        if (imageView != null) {
            imageView.setImageResource(q.a(getContext(), "reward_tips_icon_check", "drawable"));
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final com.anythink.basead.ui.improveclick.c.a s() {
        return new com.anythink.basead.ui.improveclick.c.b() { // from class: com.anythink.basead.ui.FullScreenATView.6
            @Override // com.anythink.basead.ui.improveclick.c.b
            public final void a() {
                FullScreenATView.this.C();
            }

            @Override // com.anythink.basead.ui.improveclick.c.b
            public final void b() {
                FullScreenATView.this.E();
            }

            @Override // com.anythink.basead.ui.improveclick.c.b
            public final void a(long j) {
                if (j > 0) {
                    FullScreenATView fullScreenATView = FullScreenATView.this;
                    fullScreenATView.H = Math.max(0L, fullScreenATView.H - j);
                    if (FullScreenATView.this.J) {
                        return;
                    }
                    FullScreenATView.this.al();
                    if (FullScreenATView.this.H <= 0) {
                        FullScreenATView.this.ad();
                        return;
                    }
                    if (FullScreenATView.this.r != null) {
                        long jI = FullScreenATView.this.r.i();
                        if (jI > 0) {
                            if (jI >= FullScreenATView.this.H) {
                                FullScreenATView.this.ad();
                                return;
                            } else {
                                FullScreenATView fullScreenATView2 = FullScreenATView.this;
                                fullScreenATView2.b(fullScreenATView2.r.i());
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                FullScreenATView.this.ad();
                FullScreenATView.this.c(1);
            }

            @Override // com.anythink.basead.ui.improveclick.c.a
            public final void a(int i, int i2) {
                FullScreenATView.this.a(i, i2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al() {
        if (Y() || this.a != 1 || this.f.o.bh() <= 0) {
            return;
        }
        long jMin = Math.min(this.H, this.G);
        this.ap = Math.max(0L, jMin - this.f.o.bh());
        this.aq = Math.min(jMin, this.f.o.bh());
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void a(long j) {
        boolean z = true;
        if (this.a != 1 || (this.F != 1 && this.F != 101)) {
            z = false;
        }
        if (z) {
            return;
        }
        super.a(j);
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void x() {
        if (Y()) {
            return;
        }
        super.x();
    }
}
