package com.byazt.gx;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.rk.zo;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, 1920})
public class DynamicPrivacyView extends DynamicBaseWidgetImp {
    public TextView a;
    public TextView cz;
    public LinearLayout fo;
    public TextView hw;
    public TextView ny;
    public TextView pr;

    public DynamicPrivacyView(Context context, DynamicRootView dynamicRootView, zo zoVar) {
        super(context, dynamicRootView, zoVar);
        this.pr = new TextView(this.w);
        this.hw = new TextView(this.w);
        this.a = new TextView(this.w);
        this.fo = new LinearLayout(this.w);
        this.cz = new TextView(this.w);
        this.ny = new TextView(this.w);
        this.pr.setTag(9);
        this.hw.setTag(10);
        this.a.setTag(12);
        this.fo.addView(this.a);
        this.fo.addView(this.ny);
        this.fo.addView(this.hw);
        this.fo.addView(this.cz);
        this.fo.addView(this.pr);
        addView(this.fo, getWidgetLayoutParams());
    }

    @Override // com.byazt.gx.DynamicBaseWidget
    public boolean hn() {
        this.pr.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.pr.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.hw.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.hw.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.a.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.a.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        return true;
    }

    @Override // com.byazt.gx.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.fw, this.zo);
    }

    @Override // com.byazt.gx.DynamicBaseWidgetImp, com.byazt.gx.x
    public boolean zo() {
        this.a.setText("功能");
        this.hw.setText("权限");
        this.cz.setText(" | ");
        this.ny.setText(" | ");
        this.pr.setText("隐私");
        if (this.k != null) {
            this.a.setTextColor(this.k.fw());
            this.a.setTextSize(this.k.c());
            this.hw.setTextColor(this.k.fw());
            this.hw.setTextSize(this.k.c());
            this.cz.setTextColor(this.k.fw());
            this.ny.setTextColor(this.k.fw());
            this.pr.setTextColor(this.k.fw());
            this.pr.setTextSize(this.k.c());
            return false;
        }
        this.a.setTextColor(-1);
        this.a.setTextSize(12.0f);
        this.hw.setTextColor(-1);
        this.hw.setTextSize(12.0f);
        this.cz.setTextColor(-1);
        this.ny.setTextColor(-1);
        this.pr.setTextColor(-1);
        this.pr.setTextSize(12.0f);
        return false;
    }
}
