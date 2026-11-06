package com.byazt.osr;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.lh.fs;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 574})
public class DynamicVideoView extends DynamicBaseWidgetImp implements com.byazt.tq.l {
    public boolean a;
    public TextView n;
    public FrameLayout qg;

    @Override // com.byazt.osr.DynamicBaseWidget
    public boolean q() {
        return true;
    }

    public DynamicVideoView(Context context, DynamicRootView dynamicRootView, fs fsVar) {
        super(context, dynamicRootView, fsVar);
        this.a = false;
        this.k = new View(context);
        this.k.setTag(Integer.valueOf(getClickArea()));
        this.n = new TextView(context);
        this.qg = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.byazt.cq.fs.n(context, 40.0f), (int) com.byazt.cq.fs.n(context, 15.0f));
        layoutParams.gravity = 8388693;
        layoutParams.rightMargin = 20;
        layoutParams.bottomMargin = 20;
        this.n.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(25.0f);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.n.setBackground(gradientDrawable);
        this.n.setTextSize(10.0f);
        this.n.setGravity(17);
        this.n.setTextColor(-1);
        this.n.setVisibility(8);
        if (com.byazt.twc.q.n()) {
            addView(this.qg, new FrameLayout.LayoutParams(-1, -1));
        }
        addView(this.n);
        addView(this.k, getWidgetLayoutParams());
        if (!com.byazt.twc.q.n()) {
            addView(this.qg, getWidgetLayoutParams());
        }
        dynamicRootView.s = this.qg;
        dynamicRootView.setVideoListener(this);
    }

    @Override // com.byazt.osr.DynamicBaseWidgetImp, com.byazt.osr.q
    public boolean fs() {
        super.fs();
        double dL = 0.0d;
        double dQ = 0.0d;
        for (fs fsVarD = this.oa; fsVarD != null; fsVarD = fsVarD.d()) {
            double dW = dQ + ((double) fsVarD.w());
            double dX = dL + ((double) fsVarD.x());
            dQ = dW - ((double) fsVarD.q());
            dL = dX - ((double) fsVarD.l());
        }
        try {
            float f = (float) dQ;
            int iN = (int) com.byazt.cq.fs.n(getContext(), f);
            int iN2 = (int) com.byazt.cq.fs.n(getContext(), f + this.l);
            if (com.byazt.cq.s.n(getContext())) {
                DynamicRoot dynamicRoot = (DynamicRoot) this.sz.getChildAt(0);
                int dynamicWidth = dynamicRoot.getDynamicWidth();
                int i = dynamicWidth - iN2;
                iN2 = dynamicWidth - iN;
                iN = i;
            }
            if (!"open_ad".equals(this.sz.getRenderRequest().w())) {
                DynamicRoot dynamicRoot2 = (DynamicRoot) this.sz.getChildAt(0);
                float f2 = (float) dL;
                dynamicRoot2.n.update(iN, (int) com.byazt.cq.fs.n(getContext(), f2), iN2, (int) com.byazt.cq.fs.n(getContext(), f2 + this.w));
            } else {
                this.sz.s = this.qg;
            }
        } catch (Exception unused) {
        }
        this.sz.n(dQ, dL, this.l, this.w, this.d.k());
        return true;
    }

    @Override // com.byazt.tq.l
    public void setTimeUpdate(int i) {
        String str;
        if (this.oa.tj().l().la() && i > 0 && !this.a) {
            String str2 = (i >= 60 ? "0" + (i / 60) : "00") + ":";
            int i2 = i % 60;
            if (i2 > 9) {
                str = str2 + i2;
            } else {
                str = str2 + "0" + i2;
            }
            this.n.setText(str);
            this.n.setVisibility(0);
            return;
        }
        this.a = true;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            s(getChildAt(i3));
        }
        this.n.setVisibility(8);
    }

    private void s(View view) {
        if (view == this.n || view == this.um) {
            return;
        }
        try {
            if (((Integer) view.getTag(com.byazt.tq.n.w)).intValue() == 1) {
                return;
            }
        } catch (Throwable unused) {
        }
        int i = 0;
        view.setVisibility(0);
        if (!(view instanceof ViewGroup)) {
            return;
        }
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return;
            }
            s(viewGroup.getChildAt(i));
            i++;
        }
    }
}
