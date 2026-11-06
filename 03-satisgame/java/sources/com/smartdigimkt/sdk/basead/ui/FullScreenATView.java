package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.b3.g;
import com.smartdigimkt.b3.h;
import com.smartdigimkt.b3.l;
import com.smartdigimkt.i2.p;
import com.smartdigimkt.i2.q;
import com.smartdigimkt.i2.r;
import com.smartdigimkt.j1.v;
import com.smartdigimkt.n1.a3;
import com.smartdigimkt.n1.e0;
import com.smartdigimkt.n1.o4;
import com.smartdigimkt.n1.p4;
import com.smartdigimkt.n1.u2;
import com.smartdigimkt.n1.x2;
import com.smartdigimkt.n1.y2;
import com.smartdigimkt.n1.z2;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.api.IOfferClickHandler;
import com.smartdigimkt.sdk.api.format.SDMAdDeepRewardResult;
import com.smartdigimkt.sdk.basead.ui.animplayerview.AlbumScaleAnimPlayerView;
import com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView;
import com.smartdigimkt.sdk.basead.ui.animplayerview.EmptyAnimPlayer;
import com.smartdigimkt.sdk.basead.ui.animplayerview.GuideToClickAnimPlayerView;
import com.smartdigimkt.sdk.basead.ui.animplayerview.RedPacketAnimPlayerView;
import com.smartdigimkt.sdk.basead.ui.animplayerview.ViewPagerAnimPlayerView;
import com.smartdigimkt.sdk.basead.ui.animplayerview.WebLandpagePlayerView;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;
import com.smartdigimkt.u1.d;
import com.smartdigimkt.z.c0;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class FullScreenATView extends BaseScreenATView {
    public static final String TAG = "FullScreenATView";
    public CountDownCloseView B0;
    public CloseHeaderView C0;
    public PanelView D0;
    public FullScreenHeaderPanelView E0;
    public boolean F0;
    public long G0;
    public long H0;
    public LinearLayout I0;
    public TextView J0;
    public ImageView K0;
    public boolean L0;
    public boolean M0;
    public boolean N0;

    public FullScreenATView(Context context) {
        super(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00cd, code lost:
    
        if ((!(com.smartdigimkt.b3.p.a(r0).c == 1)) == false) goto L53;
     */
    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A() {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smartdigimkt.sdk.basead.ui.FullScreenATView.A():void");
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public void C() {
        int iIndexOfChild;
        super.C();
        if (this.D == 1 && this.W) {
            RoundImageView roundImageView = new RoundImageView(getContext().getApplicationContext());
            roundImageView.setImageResource(k.a(getContext(), "myoffer_reward_icon", "drawable"));
            float f = 60;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(k.a(getContext(), f), k.a(getContext(), f));
            if (b(this.O)) {
                int i = this.O;
                if (i == 102 || i == 106) {
                    PanelView panelView = getPanelView();
                    layoutParams.topMargin = k.a(getContext(), 22.0f);
                    if (panelView != null) {
                        layoutParams.addRule(0, panelView.getId());
                        layoutParams.rightMargin = k.a(getContext(), -(f / 2.0f));
                    } else {
                        layoutParams.rightMargin = k.a(getContext(), 374.0f);
                        layoutParams.addRule(11);
                    }
                } else {
                    layoutParams.leftMargin = k.a(getContext(), 12.0f);
                    layoutParams.topMargin = k.a(getContext(), 12.0f);
                }
            } else {
                layoutParams.leftMargin = k.a(getContext(), 12.0f);
                layoutParams.topMargin = k.a(getContext(), 12.0f);
            }
            roundImageView.setLayoutParams(layoutParams);
            try {
                iIndexOfChild = this.f0.indexOfChild(this.g0) + 1;
            } catch (Throwable unused) {
                iIndexOfChild = 2;
            }
            this.f0.addView(roundImageView, iIndexOfChild);
        }
        LinearLayout linearLayout = this.I0;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public void E() {
        EndCardView endCardView;
        if (this.f0 == null || (endCardView = this.h0) == null || endCardView.getParent() != null) {
            return;
        }
        if (c0.h(this.c, this.b)) {
            b(true);
            this.f0.addView(this.h0, 0);
            return;
        }
        this.h0.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        PanelView panelView = getPanelView();
        if (panelView != null) {
            panelView.setVisibility(0);
        }
        this.f0.addView(this.h0, 0);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void F() {
        PanelView panelView;
        BasePlayerView basePlayerView;
        if (y()) {
            return;
        }
        if (this.D != 1 || this.P == 100) {
            super.F();
            if (!c0.h(this.c, this.b) || (panelView = this.D0) == null) {
                return;
            }
            panelView.setVisibility(8);
            return;
        }
        d dVar = this.n;
        if (dVar == null || (basePlayerView = dVar.h) == null || basePlayerView.getParent() == null || !(dVar.h.getParent() instanceof ViewGroup)) {
            return;
        }
        BasePlayerView basePlayerView2 = this.n.h;
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, -getMeasuredWidth(), 0.0f, 0.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.4f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setFillAfter(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(300L);
        animationSet.setAnimationListener(new x2(this, basePlayerView2));
        basePlayerView2.startAnimation(animationSet);
        PanelView panelView2 = this.D0;
        if (panelView2 == null || panelView2.getVisibility() != 0) {
            return;
        }
        this.D0.startAnimation(animationSet);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void G() {
        if (this.F0) {
            return;
        }
        this.F0 = true;
        FullScreenHeaderPanelView fullScreenHeaderPanelView = (FullScreenHeaderPanelView) findViewById(k.a(getContext(), "myoffer_header_panel_view_id", "id"));
        this.E0 = fullScreenHeaderPanelView;
        if (fullScreenHeaderPanelView == null || !c0.a(this.c)) {
            return;
        }
        this.E0.initSetting(this.c, this.b, new a3(this));
        this.o0 = this.E0;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void H() {
        r rVar = this.s0;
        if (rVar != null) {
            rVar.c = this.O == 108 ? -101 : -100;
            rVar.l = new z2(this);
            rVar.a(getContext(), this);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void I() {
        BasePlayerView webLandpagePlayerView;
        if (this.n == null || !Q()) {
            return;
        }
        if (this.o != null) {
            HashMap map = new HashMap();
            map.put("video_reset_player_view_type", Integer.valueOf(this.P));
            this.o.a(map);
        }
        a(125);
        d dVar = this.n;
        int i = this.P;
        if (dVar.h != null) {
            Context context = dVar.b;
            if (i == 101) {
                webLandpagePlayerView = new WebLandpagePlayerView(context);
            } else if (i == 1) {
                webLandpagePlayerView = new EmptyAnimPlayer(context);
            } else if (i == 2) {
                webLandpagePlayerView = new GuideToClickAnimPlayerView(context);
            } else if (i == 3) {
                webLandpagePlayerView = new RedPacketAnimPlayerView(context);
            } else if (i != 4) {
                webLandpagePlayerView = i != 5 ? new EmptyAnimPlayer(context) : new AlbumScaleAnimPlayerView(context);
            } else {
                webLandpagePlayerView = new ViewPagerAnimPlayerView(context);
            }
            webLandpagePlayerView.setVisibility(8);
            ViewGroup viewGroup = (ViewGroup) dVar.h.getParent();
            viewGroup.addView(webLandpagePlayerView, viewGroup.indexOfChild(dVar.h), dVar.h.getLayoutParams());
            viewGroup.removeView(dVar.h);
            dVar.h = webLandpagePlayerView;
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void K() {
        if (y()) {
            return;
        }
        super.K();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public void L() {
        super.L();
        r rVar = this.s0;
        if (rVar != null) {
            rVar.getClass();
            f.a().a(new p(rVar));
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void N() {
        MuteImageView muteImageView;
        super.N();
        if (this.P != 100 && (muteImageView = this.n0) != null && muteImageView.getVisibility() != 8) {
            this.n0.setVisibility(8);
        }
        P();
    }

    public final void P() {
        if (y() || this.D != 1 || this.b.s.a1 <= 0) {
            return;
        }
        long jMin = Math.min(this.T, this.S);
        this.G0 = Math.max(0L, jMin - this.b.s.a1);
        this.H0 = Math.min(jMin, this.b.s.a1);
    }

    public final boolean Q() {
        return this.D == 1 && this.P != 100;
    }

    public final boolean R() {
        a aVar;
        e eVar;
        if (this.D != 1 || (aVar = this.b) == null || (eVar = aVar.s) == null || !h.a(eVar.R1)) {
            return false;
        }
        return !(!isRvDeepRewardListenerRegistered() ? true : com.smartdigimkt.b2.k.a(getContext(), this.c));
    }

    public final void S() {
        a aVar = this.b;
        if (aVar == null || this.c == null || aVar.s == null || !R()) {
            return;
        }
        com.smartdigimkt.n3.k.b(1, (this.l || this.V) ? 62 : 61, this.b, this.c, null, false);
    }

    public final boolean T() {
        e eVar;
        com.smartdigimkt.b2.p pVarA;
        if (R()) {
            return true;
        }
        a aVar = this.b;
        if (aVar == null || (eVar = aVar.s) == null || !h.a(eVar.R1)) {
            return false;
        }
        e0 e0Var = this.o;
        return (e0Var == null || (pVarA = e0Var.a()) == null || !pVarA.f()) ? false : true;
    }

    public final void U() {
        a aVar;
        e eVar;
        if (this.N0 || this.f || (aVar = this.b) == null || (eVar = aVar.s) == null || !h.a(eVar.R1)) {
            return;
        }
        this.N0 = true;
        c cVar = this.c;
        if (cVar instanceof l) {
            l lVar = (l) cVar;
            lVar.getClass();
            lVar.h0.put(SDMAdDeepRewardResult.KEY_TASK_TYPE, 1);
        }
    }

    public final boolean V() {
        e0 e0Var;
        com.smartdigimkt.b2.p pVarA;
        String string;
        String string2;
        if (!R() || (e0Var = this.o) == null || (pVarA = e0Var.a()) == null || !pVarA.f()) {
            return false;
        }
        final com.smartdigimkt.b3.d dVar = this.b.s.R1;
        Runnable runnable = new Runnable() { // from class: com.smartdigimkt.sdk.basead.ui.FullScreenATView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(dVar);
            }
        };
        if (dVar == null || !h.a(dVar)) {
            runnable.run();
        } else {
            Context context = getContext();
            String strBuildRewardExitConfirmSecondsString = buildRewardExitConfirmSecondsString();
            int rewardExitConfirmWarnTextTypeForDialog = getRewardExitConfirmWarnTextTypeForDialog();
            a aVar = this.b;
            c cVar = this.c;
            if (context != null) {
                if (strBuildRewardExitConfirmSecondsString == null) {
                    strBuildRewardExitConfirmSecondsString = "0";
                }
                String string3 = context.getString(k.a(context, "myoffer_reward_exit_confirm_give_up", "string"));
                if (rewardExitConfirmWarnTextTypeForDialog != 2) {
                    string = context.getString(k.a(context, "myoffer_reward_exit_confirm_msg", "string"), strBuildRewardExitConfirmSecondsString);
                    string2 = context.getString(k.a(context, "myoffer_reward_exit_confirm_continue", "string"));
                } else {
                    string = context.getString(k.a(context, "myoffer_anim_reward_exit_confirm_msg", "string"), strBuildRewardExitConfirmSecondsString);
                    string2 = context.getString(k.a(context, "myoffer_anim_reward_exit_confirm_continue", "string"));
                }
                p4.a(context, string, string2, string3, runnable, aVar, cVar, o4.PLAYER_CLOSE);
            }
        }
        return true;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public boolean b(int i) {
        switch (i) {
            case 100:
            case 101:
            case 102:
            case 105:
            case 106:
                return c0.a(this.c);
            case 103:
            case 104:
            case 107:
            default:
                return false;
            case 108:
                return true;
        }
    }

    public String buildRewardExitConfirmSecondsString() {
        double dCeil = Math.ceil(this.T / 1000.0d);
        d dVar = this.n;
        if (dVar != null) {
            BasePlayerView basePlayerView = dVar.h;
            double dCeil2 = Math.ceil((basePlayerView != null ? basePlayerView.getVideoLength() : 0L) / 1000.0d);
            if (dCeil > dCeil2) {
                dCeil = dCeil2;
            }
        }
        return String.valueOf((int) dCeil);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void d(int i) {
        if (!Q()) {
            super.d(i);
            return;
        }
        this.l0.setVisibility(8);
        com.smartdigimkt.u1.e eVar = this.r0;
        if (eVar != null) {
            eVar.a(8);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public void f() {
        LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_full_screen", "layout"), this);
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public int getATViewType() {
        return 1;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public CloseImageView getCloseView() {
        if (Q()) {
            if (this.P == 101) {
                CloseHeaderView closeHeaderView = this.C0;
                if (closeHeaderView != null && closeHeaderView.getCloseImageView() != null) {
                    return this.C0.getCloseImageView();
                }
            } else {
                CountDownCloseView countDownCloseView = this.B0;
                if (countDownCloseView != null) {
                    return countDownCloseView;
                }
            }
        }
        return super.getCloseView();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public ViewGroup getFeedbackButton() {
        CloseHeaderView closeHeaderView = this.C0;
        return (closeHeaderView == null || closeHeaderView.getVisibility() != 0 || this.C0.getFeedbackButton() == null) ? super.getFeedbackButton() : this.C0.getFeedbackButton();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public com.smartdigimkt.b2.e getImproveClickCallback() {
        return new y2(this);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public PanelView getPanelView() {
        PanelView panelView;
        PanelView panelView2;
        if (c0.h(this.c, this.b) || (panelView2 = this.D0) == null) {
            return (this.V || this.P == 1 || (panelView = this.D0) == null) ? super.getPanelView() : panelView;
        }
        return panelView2;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public int getPanelViewTypeForShowEndCard() {
        int i = this.O;
        if (i == 108) {
            return i;
        }
        if (this.F < this.G) {
            return this.z0 >= this.A0 ? 101 : 105;
        }
        return this.z0 < this.A0 ? 102 : 106;
    }

    public int getRewardExitConfirmWarnTextTypeForDialog() {
        return Q() ? 2 : 1;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void j() {
        EndCardView endCardView = this.h0;
        if (endCardView != null && endCardView.getParent() != null && (this.l || (this.V && c0.h(this.c, this.b)))) {
            int i = this.O;
            int panelViewTypeForShowEndCard = getPanelViewTypeForShowEndCard();
            this.O = panelViewTypeForShowEndCard;
            b(i != panelViewTypeForShowEndCard);
        }
        requestLayout();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final boolean p() {
        if (!T()) {
            return false;
        }
        if (this.M0) {
            return true;
        }
        z();
        return true;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final boolean q() {
        if (!T()) {
            return false;
        }
        if (this.M0) {
            return true;
        }
        z();
        return true;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void r() {
        super.r();
        r rVar = this.s0;
        if (rVar != null) {
            rVar.getClass();
            f.a().a(new q(rVar));
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public void s() {
        super.s();
        this.B0 = (CountDownCloseView) findViewById(k.a(getContext(), "myoffer_btn_countdown_close_id", "id"));
        this.C0 = (CloseHeaderView) findViewById(k.a(getContext(), "myoffer_btn_close_header_view_id", "id"));
        this.D0 = (PanelView) findViewById(k.a(getContext(), "myoffer_banner_view_for_anim_player_id", "id"));
        this.I0 = (LinearLayout) findViewById(k.a(getContext(), "myoffer_tv_reward_tips_ll_id", "id"));
        this.J0 = (TextView) findViewById(k.a(getContext(), "myoffer_tv_reward_tips_id", "id"));
        this.K0 = (ImageView) findViewById(k.a(getContext(), "myoffer_tv_reward_tips_icon_id", "id"));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public void setCountDownDuration(long j) {
        if (!Q()) {
            super.setCountDownDuration(j);
            return;
        }
        CloseHeaderView closeHeaderView = this.C0;
        if (closeHeaderView != null && closeHeaderView.getVisibility() == 0) {
            this.C0.setDuration(j);
        }
        CountDownCloseView countDownCloseView = this.B0;
        if (countDownCloseView == null || countDownCloseView.getVisibility() != 0) {
            return;
        }
        this.B0.setDuration(j);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void t() {
        super.t();
        if (Q()) {
            if (this.P != 101) {
                CountDownCloseView countDownCloseView = this.B0;
                if (countDownCloseView != null) {
                    countDownCloseView.setVisibility(0);
                    return;
                }
                return;
            }
            CloseHeaderView closeHeaderView = this.C0;
            if (closeHeaderView != null) {
                closeHeaderView.setVisibility(0);
                if (this.C0.getCloseImageView() != null) {
                    this.C0.getCloseImageView().setVisibility(0);
                }
            }
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void u() {
        super.u();
        if (!Q() || getFeedbackButton() == null || getFeedbackButton().getVisibility() == 0) {
            return;
        }
        getFeedbackButton().setVisibility(0);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public void v() {
        if (c0.a(this.c)) {
            this.O = 100;
        } else {
            this.O = 108;
        }
        PanelView panelView = this.g0;
        if (panelView != null) {
            panelView.setLayoutType(this.O);
            if (this.O == 108 && this.b.s.e == 0) {
                this.g0.getCTAButton().setVisibility(8);
            }
        }
        PanelView panelView2 = this.D0;
        if (panelView2 != null) {
            panelView2.setLayoutType(this.O);
            if (this.O == 108 && this.b.s.e == 0) {
                this.D0.getCTAButton().setVisibility(8);
            }
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void w() {
        PanelView panelView = this.D0;
        if (panelView != null) {
            panelView.setVisibility(4);
            PanelView panelView2 = this.D0;
            c cVar = this.c;
            a aVar = this.b;
            panelView2.init(cVar, aVar, this.E, c0.d(aVar), new u2(this));
        }
        super.w();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public void x() {
        super.x();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void z() {
        v vVar;
        if (!T()) {
            super.z();
            TextView textView = this.J0;
            if (textView != null) {
                textView.setText(getContext().getString(k.a(getContext(), "myoffer_reward_tips_rewarded", "string")));
            }
            ImageView imageView = this.K0;
            if (imageView != null) {
                imageView.setImageResource(k.a(getContext(), "reward_tips_icon_check", "drawable"));
                return;
            }
            return;
        }
        boolean z = this.M0;
        if (z) {
            return;
        }
        if (!z && T()) {
            com.smartdigimkt.n3.k.b(16, 60, this.b, this.c, g.a(2), true);
            this.M0 = true;
            J();
            if (!this.f && (vVar = this.t0) != null) {
                vVar.b();
            }
            this.W = true;
        }
        TextView textView2 = this.J0;
        if (textView2 != null) {
            textView2.setText(getContext().getString(k.a(getContext(), "myoffer_reward_tips_rewarded", "string")));
        }
        ImageView imageView2 = this.K0;
        if (imageView2 != null) {
            imageView2.setImageResource(k.a(getContext(), "reward_tips_icon_check", "drawable"));
        }
    }

    public FullScreenATView(Context context, a aVar, c cVar, String str, int i, int i2) {
        super(context, aVar, cVar, str, i, i2);
        setId(k.a(getContext(), "myoffer_full_screen_view_id", "id"));
        this.G0 = -1L;
        this.F0 = false;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final boolean a(String str, IOfferClickHandler iOfferClickHandler) {
        BasePlayerView basePlayerView;
        boolean z = false;
        com.smartdigimkt.j2.d.d = false;
        if (y()) {
            this.V = true;
            d dVar = this.n;
            if (dVar != null && (basePlayerView = dVar.h) != null && (basePlayerView instanceof WebLandpagePlayerView) && ((WebLandpagePlayerView) basePlayerView).openInternalWebView(str, iOfferClickHandler)) {
                z = true;
            }
            if (z) {
                com.smartdigimkt.j2.d.d = true;
                a(105);
                r rVar = this.s0;
                if (rVar != null) {
                    f.a().a(new p(rVar));
                }
            }
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x008a  */
    /* JADX WARN: Code duplicated, block: B:29:0x00be  */
    /* JADX WARN: Code duplicated, block: B:31:0x00c7  */
    public final void b(boolean z) {
        int iMin;
        RelativeLayout.LayoutParams layoutParams;
        this.h0.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.h0.setNeedArc(false);
        if (b(this.O)) {
            PanelView panelView = getPanelView();
            if (panelView != null) {
                int i = this.O;
                if (i == 101) {
                    this.f0.setBackgroundColor(-1);
                    int i2 = (int) (this.G * 0.5f);
                    int iA = TextUtils.isEmpty(this.c.e) ? this.G - i2 : (this.G - i2) + k.a(getContext(), 50.0f);
                    this.h0.setLayoutParams(new RelativeLayout.LayoutParams(-1, i2));
                    this.h0.setNeedArc(true);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) panelView.getLayoutParams();
                    if (layoutParams2 != null) {
                        layoutParams2.width = this.F;
                        layoutParams2.height = iA;
                        panelView.setLayoutParams(layoutParams2);
                        if (z) {
                            panelView.removeAllViews();
                            panelView.setLayoutType(this.O);
                        }
                    }
                } else if (i == 102) {
                    this.f0.setBackgroundColor(-1);
                    iMin = Math.min(k.a(getContext(), 344.0f), Math.max(1, this.F / 2));
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams3.addRule(0, panelView.getId());
                    this.h0.setLayoutParams(layoutParams3);
                    layoutParams = (RelativeLayout.LayoutParams) panelView.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = iMin;
                        layoutParams.height = -1;
                        panelView.setLayoutParams(layoutParams);
                        if (z) {
                            panelView.removeAllViews();
                            panelView.setLayoutType(this.O);
                        }
                    }
                } else if (i == 105) {
                    this.f0.setBackgroundColor(-1);
                    int i3 = this.G;
                    int i4 = (int) (i3 * 0.5f);
                    this.h0.setLayoutParams(new RelativeLayout.LayoutParams(-1, i3 - i4));
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) panelView.getLayoutParams();
                    if (layoutParams4 != null) {
                        layoutParams4.width = this.F;
                        layoutParams4.height = i4;
                        panelView.setLayoutParams(layoutParams4);
                        if (z) {
                            panelView.removeAllViews();
                            panelView.setLayoutType(this.O);
                        }
                    }
                } else if (i == 106) {
                    this.f0.setBackgroundColor(-1);
                    iMin = Math.min(k.a(getContext(), 344.0f), Math.max(1, this.F / 2));
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams5.addRule(0, panelView.getId());
                    this.h0.setLayoutParams(layoutParams5);
                    layoutParams = (RelativeLayout.LayoutParams) panelView.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = iMin;
                        layoutParams.height = -1;
                        panelView.setLayoutParams(layoutParams);
                        if (z) {
                            panelView.removeAllViews();
                            panelView.setLayoutType(this.O);
                        }
                    }
                } else if (this.b.s.e != 0) {
                    View shakeView = panelView.getShakeView();
                    if (c0.d(this.b)) {
                        if (shakeView != null) {
                            shakeView.setVisibility(0);
                        }
                    } else if (shakeView != null) {
                        shakeView.setVisibility(8);
                    }
                }
            } else {
                this.h0.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            }
        }
        a(b(this.O) ? getPanelView() : null);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void a(long j) {
        int i;
        if (this.D == 1 && ((i = this.P) == 1 || i == 101)) {
            return;
        }
        super.a(j);
    }

    public final void a(com.smartdigimkt.b3.d dVar) {
        com.smartdigimkt.b2.p pVarA;
        e eVar;
        a aVar = this.b;
        int i = (aVar == null || (eVar = aVar.s) == null) ? 1 : eVar.G0;
        if (i != 3 && i != 4) {
            if (com.smartdigimkt.b3.p.a(dVar).b == 2) {
                O();
                c(1);
                return;
            }
            e0 e0Var = this.o;
            if (e0Var != null && (pVarA = e0Var.a()) != null && pVarA.j != null) {
                com.smartdigimkt.b2.p pVarA2 = this.o.a();
                if (pVarA2 != null) {
                    pVarA2.b();
                    return;
                }
                return;
            }
            O();
            c(1);
            return;
        }
        O();
        c(1);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void a() {
        U();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void b(long j) {
        if (Q()) {
            CloseHeaderView closeHeaderView = this.C0;
            if (closeHeaderView != null && closeHeaderView.getVisibility() == 0) {
                this.C0.refresh(j);
            }
            CountDownCloseView countDownCloseView = this.B0;
            if (countDownCloseView != null && countDownCloseView.getVisibility() == 0) {
                this.B0.refresh(j);
            }
        } else {
            super.b(j);
        }
        long j2 = this.G0;
        if (j2 < 0 || j < j2) {
            return;
        }
        LinearLayout linearLayout = this.I0;
        if (linearLayout != null && linearLayout.getVisibility() != 0) {
            this.I0.setVisibility(0);
        }
        TextView textView = this.J0;
        if (textView == null || this.H0 <= j - this.G0) {
            return;
        }
        textView.setText(String.format(getContext().getString(k.a(getContext(), "myoffer_reward_tips", "string")), Integer.valueOf((((int) (this.H0 - (j - this.G0))) / 1000) + 1)));
    }
}
