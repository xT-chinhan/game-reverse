package com.byazt.gx;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.jt.DynamicLottieView;
import com.byazt.rk.uc;
import com.byazt.rk.zo;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, 1269})
public class DynamicLottie extends DynamicBaseWidgetImp {
    public zo hw;
    public String pr;

    public DynamicLottie(Context context, DynamicRootView dynamicRootView, zo zoVar, String str) {
        super(context, dynamicRootView, zoVar);
        this.pr = str;
        this.hw = zoVar;
        DynamicLottieView lottieView = getLottieView();
        if (lottieView != null) {
            addView(lottieView, getWidgetLayoutParams());
        }
    }

    private DynamicLottieView getLottieView() {
        String strGu;
        if (this.m == null || this.m.vk() == null || this.w == null || TextUtils.isEmpty(this.pr)) {
            return null;
        }
        uc ucVarC = this.m.vk().c();
        if (ucVarC == null) {
            strGu = "";
        } else {
            strGu = ucVarC.gu();
        }
        if (TextUtils.isEmpty(strGu)) {
            return null;
        }
        String str = this.pr + "static/lotties/" + strGu + ".json";
        DynamicLottieView dynamicLottieView = new DynamicLottieView(this.w);
        dynamicLottieView.setImageLottieTosPath(str);
        dynamicLottieView.zo();
        return dynamicLottieView;
    }
}
