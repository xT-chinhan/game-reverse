package com.byazt.osr;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.lh.fs;
import com.byazt.lh.w;
import com.byazt.stl.DynamicLottieView;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 1406})
public class DynamicLottie extends DynamicBaseWidgetImp {
    public String n;
    public fs qg;

    public DynamicLottie(Context context, DynamicRootView dynamicRootView, fs fsVar, String str) {
        super(context, dynamicRootView, fsVar);
        this.n = str;
        this.qg = fsVar;
        DynamicLottieView lottieView = getLottieView();
        if (lottieView != null) {
            addView(lottieView, getWidgetLayoutParams());
        }
    }

    private DynamicLottieView getLottieView() {
        if (this.oa == null || this.oa.tj() == null || this.cp == null || TextUtils.isEmpty(this.n)) {
            return null;
        }
        w wVarL = this.oa.tj().l();
        String strHf = wVarL != null ? wVarL.hf() : "";
        if (TextUtils.isEmpty(strHf)) {
            return null;
        }
        String str = this.n + "static/lotties/" + strHf + ".json";
        DynamicLottieView dynamicLottieView = new DynamicLottieView(this.cp);
        dynamicLottieView.setImageLottieTosPath(str);
        dynamicLottieView.fs();
        return dynamicLottieView;
    }
}
