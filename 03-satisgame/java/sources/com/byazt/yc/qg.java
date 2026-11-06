package com.byazt.yc;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 965, 26})
public class qg {
    public static void n(Context context, com.byazt.pch.n nVar, com.byazt.ap.w wVar, boolean z) {
        com.byazt.pch.qg qgVarUr;
        if (nVar != null && (qgVarUr = nVar.ur()) != null && qgVarUr.tj() == null) {
            com.byazt.rb.qg.q("TMe", "使用聚合信息流广告自渲染模版混用场景时，需设置MediationNativeToBannerListener监听回调否则会影响相关功能使用，具体可以参考接入文档，若不能及时设置，建议修改瀑布流配置为模版信息流广告暂不进行混用。");
        }
        new com.byazt.ux.l(context, nVar, wVar, z).n();
    }

    public static void n(Context context, com.byazt.pch.n nVar, com.byazt.ap.s sVar, boolean z) {
        new com.byazt.ux.w(context, nVar, sVar, z).n();
    }

    public static void n(Context context, com.byazt.pch.n nVar, com.byazt.ap.qg qgVar) {
        new com.byazt.xr.s(context, nVar, qgVar).n();
    }

    public static void n(Context context, com.byazt.pch.n nVar, com.byazt.ap.x xVar) {
        new com.byazt.vo.s(context, nVar, xVar).n();
    }

    public static void qg(Context context, com.byazt.pch.n nVar, com.byazt.ap.w wVar, boolean z) {
        new com.byazt.ck.s(context, nVar, wVar, z).n();
    }

    public static void n(Context context, com.byazt.pch.n nVar, com.byazt.zr.n nVar2, com.byazt.ap.n nVar3, boolean z) {
        com.byazt.as.s sVar = new com.byazt.as.s(context, nVar, nVar3, z);
        if (nVar2 != null && nVar2.rv() != 0) {
            sVar.n(nVar2.rv());
        } else {
            sVar.n();
        }
    }

    public static void n(Context context, com.byazt.pch.n nVar, com.byazt.ap.q qVar) {
        new com.byazt.xm.s(context, nVar, qVar).n();
    }

    public static void qg(Context context, com.byazt.pch.n nVar, com.byazt.ap.q qVar) {
        new com.byazt.xm.x(context, nVar, qVar).n();
    }
}
