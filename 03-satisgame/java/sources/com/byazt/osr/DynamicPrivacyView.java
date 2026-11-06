package com.byazt.osr;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.lh.fs;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 2098})
public class DynamicPrivacyView extends DynamicBaseWidgetImp {
    public TextView a;
    public TextView n;
    public TextView ou;
    public TextView py;
    public TextView qg;
    public LinearLayout wm;

    public DynamicPrivacyView(Context context, DynamicRootView dynamicRootView, fs fsVar) {
        super(context, dynamicRootView, fsVar);
        this.n = new TextView(this.cp);
        this.qg = new TextView(this.cp);
        this.a = new TextView(this.cp);
        this.wm = new LinearLayout(this.cp);
        this.py = new TextView(this.cp);
        this.ou = new TextView(this.cp);
        this.n.setTag(9);
        this.qg.setTag(10);
        this.a.setTag(12);
        this.wm.addView(this.a);
        this.wm.addView(this.ou);
        this.wm.addView(this.qg);
        this.wm.addView(this.py);
        this.wm.addView(this.n);
        addView(this.wm, getWidgetLayoutParams());
    }

    @Override // com.byazt.osr.DynamicBaseWidget
    public boolean s() {
        this.n.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.n.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.qg.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.qg.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.a.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.a.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        return true;
    }

    @Override // com.byazt.osr.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.x, this.fs);
    }

    @Override // com.byazt.osr.DynamicBaseWidgetImp, com.byazt.osr.q
    public boolean fs() {
        this.a.setText("功能");
        this.qg.setText("权限");
        this.py.setText(" | ");
        this.ou.setText(" | ");
        this.n.setText("隐私");
        if (this.d != null) {
            this.a.setTextColor(this.d.x());
            this.a.setTextSize(this.d.l());
            this.qg.setTextColor(this.d.x());
            this.qg.setTextSize(this.d.l());
            this.py.setTextColor(this.d.x());
            this.ou.setTextColor(this.d.x());
            this.n.setTextColor(this.d.x());
            this.n.setTextSize(this.d.l());
            return false;
        }
        this.a.setTextColor(-1);
        this.a.setTextSize(12.0f);
        this.qg.setTextColor(-1);
        this.qg.setTextSize(12.0f);
        this.py.setTextColor(-1);
        this.ou.setTextColor(-1);
        this.n.setTextColor(-1);
        this.n.setTextSize(12.0f);
        return false;
    }
}
