package com.byazt.osr;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.cq.x;
import com.byazt.hkc.cp;
import com.byazt.lh.fs;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 2453})
public class DynamicTimeOuter extends DynamicButton implements com.byazt.tq.s {
    public boolean a;
    public boolean n;
    public boolean qg;

    public DynamicTimeOuter(Context context, DynamicRootView dynamicRootView, fs fsVar) {
        super(context, dynamicRootView, fsVar);
        dynamicRootView.setTimeOutListener(this);
        if ("timedown".equals(fsVar.tj().getType())) {
            dynamicRootView.setTimedown(this.fs);
        }
    }

    @Override // com.byazt.osr.DynamicButton, com.byazt.osr.DynamicBaseWidgetImp, com.byazt.osr.q
    public boolean fs() {
        super.fs();
        if (x.qg(this.sz.getRenderRequest().w())) {
            setVisibility(8);
        }
        if ("timedown".equals(this.oa.tj().getType())) {
            ((TextView) this.k).setText(String.valueOf((int) Double.parseDouble(this.d.tj())));
            return true;
        }
        ((TextView) this.k).setText(((int) Double.parseDouble(this.d.tj())) + com.anythink.core.common.s.a);
        return true;
    }

    @Override // com.byazt.osr.DynamicBaseWidget
    public void l() {
        if (TextUtils.equals("skip-with-countdowns-video-countdown", this.oa.tj().getType()) || TextUtils.equals("skip-with-time-countdown", this.oa.tj().getType())) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.x, this.fs);
            layoutParams.gravity = 8388627;
            if (com.byazt.twc.q.n()) {
                layoutParams.leftMargin = this.rv;
            }
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
            setLayoutParams(layoutParams);
            return;
        }
        super.l();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.k).getText())) {
            setMeasuredDimension(0, this.fs);
        }
    }

    @Override // com.byazt.tq.s
    public void n(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (z2 || this.a) {
            ((TextView) this.k).setText("");
            setVisibility(8);
            return;
        }
        try {
            if (Integer.parseInt((String) charSequence) <= 0) {
                setVisibility(8);
                return;
            }
        } catch (Exception unused) {
        }
        setVisibility(0);
        if (!z && this.sz.getRenderRequest().s() && x.qg(this.sz.getRenderRequest().w())) {
            ((TextView) this.k).setText(i + com.anythink.core.common.s.a);
            this.n = true;
            return;
        }
        if (com.byazt.twc.q.n() && !"open_ad".equals(this.sz.getRenderRequest().w()) && this.sz.getRenderRequest().s()) {
            this.a = true;
            setVisibility(8);
            return;
        }
        if ("timedown".equals(this.oa.tj().getType())) {
            ((TextView) this.k).setText(charSequence);
            return;
        }
        ((TextView) this.k).setText(((Object) charSequence) + com.anythink.core.common.s.a);
        this.qg = true;
        if (this.n) {
            CharSequence text = ((TextView) this.k).getText();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (cp.qg(text != null ? text.toString() : "", this.d.l(), true)[0] + com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), this.d.s() + this.d.q())), this.fs);
            layoutParams.gravity = 8388629;
            this.k.setLayoutParams(layoutParams);
            this.n = false;
            requestLayout();
        }
    }
}
