package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.ah.x;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicPrivacyView extends DynamicBaseWidgetImp {
    private TextView b;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private TextView f825ms;
    private TextView nw;
    private LinearLayout re;
    private TextView t;
    private TextView xr;

    public DynamicPrivacyView(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        this.f825ms = new TextView(this.hi);
        this.xr = new TextView(this.hi);
        this.t = new TextView(this.hi);
        this.re = new LinearLayout(this.hi);
        this.nw = new TextView(this.hi);
        this.b = new TextView(this.hi);
        this.f825ms.setTag(9);
        this.xr.setTag(10);
        this.t.setTag(12);
        this.re.addView(this.t);
        this.re.addView(this.b);
        this.re.addView(this.xr);
        this.re.addView(this.nw);
        this.re.addView(this.f825ms);
        addView(this.re, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    protected boolean ah() {
        this.f825ms.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.f825ms.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.xr.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.xr.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.t.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.t.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.ab, this.x);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean x() {
        this.t.setText("功能");
        this.xr.setText("权限");
        this.nw.setText(" | ");
        this.b.setText(" | ");
        this.f825ms.setText("隐私");
        if (this.sl != null) {
            this.t.setTextColor(this.sl.ab());
            this.t.setTextSize(this.sl.ka());
            this.xr.setTextColor(this.sl.ab());
            this.xr.setTextSize(this.sl.ka());
            this.nw.setTextColor(this.sl.ab());
            this.b.setTextColor(this.sl.ab());
            this.f825ms.setTextColor(this.sl.ab());
            this.f825ms.setTextSize(this.sl.ka());
            return false;
        }
        this.t.setTextColor(-1);
        this.t.setTextSize(12.0f);
        this.xr.setTextColor(-1);
        this.xr.setTextSize(12.0f);
        this.nw.setTextColor(-1);
        this.b.setTextColor(-1);
        this.f825ms.setTextColor(-1);
        this.f825ms.setTextSize(12.0f);
        return false;
    }
}
