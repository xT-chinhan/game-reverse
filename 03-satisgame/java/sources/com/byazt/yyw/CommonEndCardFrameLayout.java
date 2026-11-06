package com.byazt.yyw;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.byazt.cd.s;
import com.byazt.cp.n;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.kfh.SSWebView;
import com.byazt.nf.rv;
import com.byazt.uz.RewardLpBottomView;
import com.byazt.xk.PlayableEndcardFrameLayout;
import com.byazt.ys.qg;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 1, 1298, 1697})
public class CommonEndCardFrameLayout extends AbstractEndCardFrameLayout {
    public FrameLayout l;
    public SSWebView q;
    public SSWebView s;
    public RewardLpBottomView w;
    public PlayableEndcardFrameLayout x;

    @Override // com.byazt.yyw.AbstractEndCardFrameLayout
    public void setClickListener(qg qgVar) {
    }

    public CommonEndCardFrameLayout(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar) {
        super(tTBaseVideoActivity, pkVar);
    }

    private void s() {
        SSWebView sSWebView = new SSWebView(this.n);
        sSWebView.setMaterialMeta(s.n(this.qg));
        sSWebView.setId(2114387697);
        sSWebView.setLayerType(2, null);
        sSWebView.setVisibility(4);
        this.s = sSWebView;
        addView(sSWebView, 0, new FrameLayout.LayoutParams(-1, -1));
    }

    private void q() {
        SSWebView sSWebView = new SSWebView(this.n);
        sSWebView.setMaterialMeta(s.n(this.qg));
        sSWebView.setId(2114387859);
        sSWebView.setLayerType(2, null);
        sSWebView.setVisibility(4);
        this.q = sSWebView;
        this.x.addView(sSWebView, 0, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.byazt.yyw.AbstractEndCardFrameLayout
    public void n() {
        setId(2114387542);
        if (!TextUtils.isEmpty(ta.rv(this.qg)) && !rv.qg().vu()) {
            s();
        }
        LinearLayout linearLayout = new LinearLayout(this.n);
        linearLayout.setId(2114387541);
        linearLayout.setOrientation(1);
        PlayableEndcardFrameLayout playableEndcardFrameLayout = new PlayableEndcardFrameLayout(this.n);
        this.x = playableEndcardFrameLayout;
        playableEndcardFrameLayout.setId(2114387675);
        if (com.byazt.qq.qg.qg(this.qg)) {
            q();
        }
        FrameLayout frameLayout = new FrameLayout(this.n);
        frameLayout.setId(2114387919);
        frameLayout.setVisibility(8);
        this.x.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        LinearLayout linearLayoutQg = com.byazt.cb.qg.qg(this.n);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-2236963, -1});
        gradientDrawable.setShape(0);
        linearLayoutQg.setBackground(gradientDrawable);
        this.x.addView(linearLayoutQg, new FrameLayout.LayoutParams(-1, -1));
        RewardLpBottomView rewardLpBottomView = new RewardLpBottomView(this.n);
        rewardLpBottomView.setId(2114387824);
        rewardLpBottomView.setVisibility(8);
        this.w = rewardLpBottomView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.x.addView(rewardLpBottomView, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 1.0f;
        linearLayout.addView(this.x, layoutParams2);
        addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(this.n);
        frameLayout2.setId(2114387798);
        frameLayout2.setBackgroundColor(0);
        frameLayout2.setVisibility(8);
        addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        this.l = frameLayout2;
    }

    @Override // com.byazt.yyw.AbstractEndCardFrameLayout
    public SSWebView getEndCardWebView() {
        if (this.s == null) {
            s();
        }
        return this.s;
    }

    @Override // com.byazt.yyw.AbstractEndCardFrameLayout
    public SSWebView getPlayableWebView() {
        if (this.q == null) {
            q();
        }
        return this.q;
    }

    @Override // com.byazt.yyw.AbstractEndCardFrameLayout
    public FrameLayout getVideoArea() {
        return this.l;
    }

    @Override // com.byazt.yyw.AbstractEndCardFrameLayout
    public void qg() {
        super.qg();
        RewardLpBottomView rewardLpBottomView = this.w;
        if (rewardLpBottomView != null) {
            rewardLpBottomView.qg();
        }
    }
}
