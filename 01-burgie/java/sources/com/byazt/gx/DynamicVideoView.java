package com.byazt.gx;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.rk.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_CONNECT_TIME})
public class DynamicVideoView extends DynamicBaseWidgetImp implements com.byazt.imd.c {
    public boolean a;
    public FrameLayout hw;
    public TextView pr;

    public DynamicVideoView(Context context, DynamicRootView dynamicRootView, zo zoVar) {
        super(context, dynamicRootView, zoVar);
        this.a = false;
        this.ho = new View(context);
        this.ho.setTag(Integer.valueOf(getClickArea()));
        this.pr = new TextView(context);
        this.hw = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.byazt.js.zo.pr(context, 40.0f), (int) com.byazt.js.zo.pr(context, 15.0f));
        layoutParams.gravity = 8388693;
        layoutParams.rightMargin = 20;
        layoutParams.bottomMargin = 20;
        this.pr.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(25.0f);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.pr.setBackground(gradientDrawable);
        this.pr.setTextSize(10.0f);
        this.pr.setGravity(17);
        this.pr.setTextColor(-1);
        this.pr.setVisibility(8);
        if (com.byazt.dj.x.pr()) {
            addView(this.hw, new FrameLayout.LayoutParams(-1, -1));
        }
        addView(this.pr);
        addView(this.ho, getWidgetLayoutParams());
        if (!com.byazt.dj.x.pr()) {
            addView(this.hw, getWidgetLayoutParams());
        }
        dynamicRootView.hn = this.hw;
        dynamicRootView.setVideoListener(this);
    }

    @Override // com.byazt.gx.DynamicBaseWidgetImp, com.byazt.gx.x
    public boolean zo() {
        super.zo();
        double dC = 0.0d;
        double dX = 0.0d;
        for (zo zoVarK = this.m; zoVarK != null; zoVarK = zoVarK.k()) {
            double dUc = dX + ((double) zoVarK.uc());
            double dFw = dC + ((double) zoVarK.fw());
            dX = dUc - ((double) zoVarK.x());
            dC = dFw - ((double) zoVarK.c());
        }
        try {
            float f = (float) dX;
            int iPr = (int) com.byazt.js.zo.pr(getContext(), f);
            int iPr2 = (int) com.byazt.js.zo.pr(getContext(), f + this.c);
            if (com.byazt.js.hn.pr(getContext())) {
                DynamicRoot dynamicRoot = (DynamicRoot) this.g.getChildAt(0);
                int dynamicWidth = dynamicRoot.getDynamicWidth();
                int i = dynamicWidth - iPr2;
                iPr2 = dynamicWidth - iPr;
                iPr = i;
            }
            if (!"open_ad".equals(this.g.getRenderRequest().uc())) {
                DynamicRoot dynamicRoot2 = (DynamicRoot) this.g.getChildAt(0);
                float f2 = (float) dC;
                dynamicRoot2.pr.update(iPr, (int) com.byazt.js.zo.pr(getContext(), f2), iPr2, (int) com.byazt.js.zo.pr(getContext(), f2 + this.uc));
            } else {
                this.g.hn = this.hw;
            }
        } catch (Exception e) {
        }
        this.g.pr(dX, dC, this.c, this.uc, this.k.ho());
        return true;
    }

    @Override // com.byazt.gx.DynamicBaseWidget
    public boolean x() {
        return true;
    }

    @Override // com.byazt.imd.c
    public void setTimeUpdate(int i) {
        String str;
        String str2;
        if (this.m.vk().c().sx() && i > 0 && !this.a) {
            if (i < 60) {
                str = "00";
            } else {
                str = "0" + (i / 60);
            }
            String str3 = str + ":";
            int i2 = i % 60;
            if (i2 <= 9) {
                str2 = str3 + "0" + i2;
            } else {
                str2 = str3 + i2;
            }
            this.pr.setText(str2);
            this.pr.setVisibility(0);
            return;
        }
        this.a = true;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            hn(getChildAt(i3));
        }
        this.pr.setVisibility(8);
    }

    private void hn(View view) {
        if (view == this.pr || view == this.qa) {
            return;
        }
        try {
            if (((Integer) view.getTag(com.byazt.imd.pr.uc)).intValue() == 1) {
                return;
            }
        } catch (Throwable th) {
        }
        int i = 0;
        view.setVisibility(0);
        if (!(view instanceof ViewGroup)) {
            return;
        }
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i < viewGroup.getChildCount()) {
                hn(viewGroup.getChildAt(i));
                i++;
            } else {
                return;
            }
        }
    }
}
