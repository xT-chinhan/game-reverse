package com.byazt.gx;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.rk.zo;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, 435})
public class DynamicLeisureWidget extends DynamicBaseWidgetImp {
    public DynamicLeisureWidget(Context context, DynamicRootView dynamicRootView, zo zoVar) {
        super(context, dynamicRootView, zoVar);
    }

    @Override // com.byazt.gx.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        this.fw = 0;
        this.zo = 0;
        return super.getWidgetLayoutParams();
    }
}
