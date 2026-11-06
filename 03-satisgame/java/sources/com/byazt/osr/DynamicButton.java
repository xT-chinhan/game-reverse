package com.byazt.osr;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.lh.fs;
import com.byazt.zw.AnimationButton;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 2162})
public class DynamicButton extends DynamicBaseWidgetImp {
    public DynamicButton(Context context, DynamicRootView dynamicRootView, fs fsVar) {
        super(context, dynamicRootView, fsVar);
        this.k = new AnimationButton(context);
        this.k.setTag(Integer.valueOf(getClickArea()));
        addView(this.k, getWidgetLayoutParams());
    }

    @Override // com.byazt.osr.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        if (com.byazt.twc.q.n() && "fillButton".equals(this.oa.tj().getType())) {
            ((TextView) this.k).setEllipsize(TextUtils.TruncateAt.END);
            ((TextView) this.k).setMaxLines(1);
            FrameLayout.LayoutParams widgetLayoutParams = super.getWidgetLayoutParams();
            widgetLayoutParams.width -= this.d.cd() * 2;
            widgetLayoutParams.height -= this.d.cd() * 2;
            widgetLayoutParams.topMargin += this.d.cd();
            widgetLayoutParams.leftMargin += this.d.cd();
            widgetLayoutParams.setMarginStart(widgetLayoutParams.leftMargin);
            widgetLayoutParams.setMarginEnd(widgetLayoutParams.rightMargin);
            return widgetLayoutParams;
        }
        return super.getWidgetLayoutParams();
    }

    @Override // com.byazt.osr.DynamicBaseWidgetImp, com.byazt.osr.q
    public boolean fs() {
        super.fs();
        if (TextUtils.equals("download-progress-button", this.oa.tj().getType()) && TextUtils.isEmpty(this.d.tj())) {
            this.k.setVisibility(4);
            return true;
        }
        this.k.setTextAlignment(this.d.fs());
        ((TextView) this.k).setText(this.d.tj());
        ((TextView) this.k).setTextColor(this.d.x());
        ((TextView) this.k).setTextSize(this.d.l());
        ((TextView) this.k).setGravity(17);
        ((TextView) this.k).setIncludeFontPadding(false);
        if ("fillButton".equals(this.oa.tj().getType())) {
            this.k.setPadding(0, 0, 0, 0);
        } else {
            this.k.setPadding(this.d.s(), this.d.qg(), this.d.q(), this.d.n());
        }
        return true;
    }
}
