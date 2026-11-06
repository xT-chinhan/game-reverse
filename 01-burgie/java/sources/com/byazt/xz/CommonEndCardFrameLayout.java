package com.byazt.xz;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.byazt.ar.RewardLpBottomView;
import com.byazt.az.hw;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.fj.SSWebView;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.pg.PlayableEndcardFrameLayout;
import com.byazt.sd.a;
import com.byazt.sdv.c;
import com.byazt.vzx.pr;
import com.byazt.wt.e;
import com.byazt.wt.ny;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 1, 1173, 1558})
public class CommonEndCardFrameLayout extends AbstractEndCardFrameLayout {
    public FrameLayout c;
    public PlayableEndcardFrameLayout fw;
    public SSWebView hn;
    public RewardLpBottomView uc;
    public SSWebView x;

    public CommonEndCardFrameLayout(TTBaseVideoActivity tTBaseVideoActivity, of ofVar) {
        super(tTBaseVideoActivity, ofVar);
    }

    private void hn() {
        SSWebView sSWebView = new SSWebView(this.pr);
        sSWebView.setMaterialMeta(e.pr(this.hw));
        sSWebView.setId(2114387697);
        sSWebView.setLayerType(2, null);
        sSWebView.setVisibility(4);
        this.hn = sSWebView;
        addView(sSWebView, 0, new FrameLayout.LayoutParams(-1, -1));
    }

    private void x() {
        SSWebView sSWebView = new SSWebView(this.pr);
        sSWebView.setMaterialMeta(e.pr(this.hw));
        sSWebView.setId(2114387859);
        sSWebView.setLayerType(2, null);
        sSWebView.setVisibility(4);
        this.x = sSWebView;
        this.fw.addView(sSWebView, 0, new FrameLayout.LayoutParams(-1, -1));
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
    @Override // com.byazt.xz.AbstractEndCardFrameLayout
    public void pr() {
        setId(2114387542);
        if (!TextUtils.isEmpty(qv.aj(this.hw)) && !a.hw().li()) {
            hn();
        }
        LinearLayout linearLayout = new LinearLayout(this.pr);
        linearLayout.setId(2114387541);
        linearLayout.setOrientation(1);
        PlayableEndcardFrameLayout playableEndcardFrameLayout = new PlayableEndcardFrameLayout(this.pr);
        this.fw = playableEndcardFrameLayout;
        playableEndcardFrameLayout.setId(2114387675);
        if (ny.hw(this.hw)) {
            x();
        }
        FrameLayout frameLayout = new FrameLayout(this.pr);
        frameLayout.setId(2114387919);
        frameLayout.setVisibility(8);
        this.fw.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        LinearLayout linearLayoutHw = c.hw(this.pr);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-2236963, -1});
        gradientDrawable.setShape(0);
        linearLayoutHw.setBackground(gradientDrawable);
        this.fw.addView(linearLayoutHw, new FrameLayout.LayoutParams(-1, -1));
        RewardLpBottomView rewardLpBottomView = new RewardLpBottomView(this.pr);
        rewardLpBottomView.setId(2114387824);
        rewardLpBottomView.setVisibility(8);
        this.uc = rewardLpBottomView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.fw.addView(rewardLpBottomView, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 1.0f;
        linearLayout.addView(this.fw, layoutParams2);
        addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(this.pr);
        frameLayout2.setId(2114387798);
        frameLayout2.setBackgroundColor(0);
        frameLayout2.setVisibility(8);
        addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        this.c = frameLayout2;
    }

    @Override // com.byazt.xz.AbstractEndCardFrameLayout
    public SSWebView getEndCardWebView() {
        if (this.hn == null) {
            hn();
        }
        return this.hn;
    }

    @Override // com.byazt.xz.AbstractEndCardFrameLayout
    public SSWebView getPlayableWebView() {
        if (this.x == null) {
            x();
        }
        return this.x;
    }

    @Override // com.byazt.xz.AbstractEndCardFrameLayout
    public FrameLayout getVideoArea() {
        return this.c;
    }

    @Override // com.byazt.xz.AbstractEndCardFrameLayout
    public void setClickListener(hw hwVar) {
    }

    @Override // com.byazt.xz.AbstractEndCardFrameLayout
    public void hw() {
        super.hw();
        RewardLpBottomView rewardLpBottomView = this.uc;
        if (rewardLpBottomView != null) {
            rewardLpBottomView.hw();
        }
    }
}
