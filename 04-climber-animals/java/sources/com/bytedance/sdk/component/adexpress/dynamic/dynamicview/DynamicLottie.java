package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.ah.c;
import com.bytedance.sdk.component.adexpress.dynamic.ah.x;
import com.bytedance.sdk.component.adexpress.widget.DynamicLottieView;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicLottie extends DynamicBaseWidgetImp {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    String f824ms;
    x xr;

    public DynamicLottie(Context context, DynamicRootView dynamicRootView, x xVar, String str) {
        super(context, dynamicRootView, xVar);
        this.f824ms = str;
        this.xr = xVar;
        DynamicLottieView lottieView = getLottieView();
        if (lottieView != null) {
            addView(lottieView, getWidgetLayoutParams());
        }
    }

    private DynamicLottieView getLottieView() {
        if (this.zb == null || this.zb.ch() == null || this.hi == null || TextUtils.isEmpty(this.f824ms)) {
            return null;
        }
        c cVarKa = this.zb.ch().ka();
        String strVy = cVarKa != null ? cVarKa.vy() : "";
        if (TextUtils.isEmpty(strVy)) {
            return null;
        }
        String str = this.f824ms + "static/lotties/" + strVy + ".json";
        DynamicLottieView dynamicLottieView = new DynamicLottieView(this.hi);
        dynamicLottieView.setImageLottieTosPath(str);
        dynamicLottieView.ny();
        return dynamicLottieView;
    }
}
