package com.byazt.sd;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 23, 672})
public class gz implements Function<SparseArray<Object>, Object> {
    public static final String GET_CONFIG_TIME_OUT_MSG = "配置未加载完成，请稍后2-5秒请求广告（修改建议：适当将请求非开屏类型广告的时机往后移）";
    public static final String NOT_INIT_TIPS_MSG = "please exec TTAdSdk.init and TTAdSdk.start before load ad";
    public static final String UNKNOWN_ERR_MSG = "未知异常";
    public volatile Context pr;

    public gz(Context context) {
        this.pr = (context == null ? a.getContext() : context).getApplicationContext();
    }

    public void pr(com.byazt.qe.hw hwVar, com.byazt.pis.hn hnVar) {
        com.byazt.yb.pr.x().pr(5, hwVar, hnVar);
    }

    public void hw(com.byazt.qe.hw hwVar, com.byazt.pis.hn hnVar) {
        com.byazt.si.pr.x().pr(6, hwVar, hnVar);
    }

    public void pr(com.byazt.qe.hw hwVar, com.byazt.pis.hw hwVar2) {
        com.byazt.ju.pr.x().pr(9, hwVar, hwVar2);
    }

    public void pr(int i, com.byazt.qe.hw hwVar, com.byazt.pis.c cVar) {
        com.byazt.om.pr.x().pr(i, hwVar, cVar);
    }

    public void pr(com.byazt.qe.hw hwVar, com.byazt.pis.pr prVar, int i) {
        com.byazt.jm.uc.pr(getContext()).pr(hwVar, prVar, i);
    }

    public void pr(com.byazt.qe.hw hwVar, com.byazt.pis.fw fwVar) {
        com.byazt.vh.fw.pr().pr(hwVar, new com.byazt.vh.x(fwVar));
    }

    public void pr(com.byazt.qe.hw hwVar, com.byazt.pis.x xVar) {
        com.byazt.vh.hw.pr().pr(hwVar, new com.byazt.vh.x(xVar));
    }

    public void pr(com.byazt.qe.hw hwVar, com.byazt.pis.uc ucVar) {
        com.byazt.yb.pr.x().pr(5, hwVar, ucVar);
    }

    public void hw(com.byazt.qe.hw hwVar, com.byazt.pis.uc ucVar) {
        com.byazt.ju.pr.x().pr(9, hwVar, ucVar);
    }

    public void hn(com.byazt.qe.hw hwVar, com.byazt.pis.uc ucVar) {
        com.byazt.om.pr.x().pr(1, hwVar, ucVar);
    }

    public static boolean pr(com.byazt.qe.hw hwVar, boolean z) {
        if (hwVar == null) {
            return false;
        }
        if ((!z || a.hw().aj(hwVar.x())) && hwVar.zo() <= 0.0f) {
            return false;
        }
        return true;
    }

    public static boolean pr() {
        return com.byazt.b.pr.hw();
    }

    public static void pr(com.byazt.xlm.fw fwVar, int i) {
        if (pr()) {
            com.byazt.xlm.c.x(fwVar);
        } else {
            com.byazt.xlm.aj.hw.k().execute(fwVar);
        }
    }

    private Context getContext() {
        if (this.pr == null) {
            this.pr = a.getContext();
        }
        return this.pr;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            com.byazt.ca.ho.pr("apply->load with null ->SparseArray");
            return null;
        }
        PluginValueSet pluginValueSetHw = com.byazt.ij.pr.pr(sparseArray).hw();
        int iIntValue = pluginValueSetHw.intValue(-99999982);
        Function<SparseArray<Object>, Object> function = (Function) pluginValueSetHw.objectValue(1, Function.class);
        if (function == null) {
            com.byazt.ca.ho.pr("apply->load with null callback");
            return null;
        }
        pr(iIntValue, pluginValueSetHw, function);
        return null;
    }

    public void pr(int i, PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        com.byazt.ij.pr prVarPr = com.byazt.ij.pr.pr(pluginValueSet);
        prVarPr.pr(1, 0);
        PluginValueSet pluginValueSetHw = prVarPr.hw();
        switch (i) {
            case 1:
                boolean zBooleanValue = pluginValueSetHw.booleanValue(2);
                com.byazt.qe.hw hwVarPr = com.byazt.wt.ve.pr(i, pluginValueSetHw);
                if (zBooleanValue) {
                    hn(hwVarPr, new com.byazt.cv.zo(function));
                } else {
                    pr(i, hwVarPr, new com.byazt.cv.fw(function));
                }
                break;
            case 3:
                pr(com.byazt.wt.ve.pr(3, pluginValueSetHw), new com.byazt.cv.hn(function), pluginValueSetHw.intValue(3));
                break;
            case 5:
                boolean zBooleanValue2 = pluginValueSetHw.booleanValue(2);
                com.byazt.qe.hw hwVarPr2 = com.byazt.wt.ve.pr(i, pluginValueSetHw);
                if (zBooleanValue2) {
                    pr(hwVarPr2, new com.byazt.cv.zo(function));
                } else {
                    pr(hwVarPr2, new com.byazt.cv.c(function));
                }
                break;
            case 6:
                hw(com.byazt.wt.ve.pr(6, pluginValueSetHw), new com.byazt.cv.c(function));
                break;
            case 7:
                pr(com.byazt.wt.ve.pr(7, pluginValueSetHw), new com.byazt.cv.aj(function));
                break;
            case 8:
                pr(com.byazt.wt.ve.pr(8, pluginValueSetHw), new com.byazt.cv.uc(function));
                break;
            case 9:
                boolean zBooleanValue3 = pluginValueSetHw.booleanValue(2);
                com.byazt.qe.hw hwVarPr3 = com.byazt.wt.ve.pr(9, pluginValueSetHw);
                if (zBooleanValue3) {
                    hw(hwVarPr3, new com.byazt.cv.zo(function));
                } else {
                    pr(hwVarPr3, new com.byazt.cv.x(function));
                }
                break;
        }
    }
}
