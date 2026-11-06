package com.byazt.yn;

import android.content.Context;
import android.util.SparseArray;
import com.byazt.ap.l;
import com.byazt.ap.s;
import com.byazt.ap.x;
import com.byazt.hi.w;
import com.byazt.nf.rv;
import com.byazt.pj.q;
import com.byazt.tk.k;
import com.byazt.yy.fs;
import com.byazt.zq.qg;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1115, 19})
public class n implements Function<SparseArray<Object>, Object> {
    public static final String GET_CONFIG_TIME_OUT_MSG = "配置未加载完成，请稍后2-5秒请求广告（修改建议：适当将请求非开屏类型广告的时机往后移）";
    public static final String NOT_INIT_TIPS_MSG = "please exec TTAdSdk.init and TTAdSdk.start before load ad";
    public static final String UNKNOWN_ERR_MSG = "未知异常";
    public volatile Context n;

    public n(Context context) {
        this.n = (context == null ? rv.getContext() : context).getApplicationContext();
    }

    public void n(qg qgVar, s sVar) {
        com.byazt.be.n.q().n(5, qgVar, sVar);
    }

    public void qg(qg qgVar, s sVar) {
        com.byazt.hrr.n.q().n(6, qgVar, sVar);
    }

    public void n(qg qgVar, com.byazt.ap.qg qgVar2) {
        com.byazt.vgo.n.q().n(9, qgVar, qgVar2);
    }

    public void n(int i, qg qgVar, l lVar) {
        com.byazt.nk.n.q().n(i, qgVar, lVar);
    }

    public void n(qg qgVar, com.byazt.ap.n nVar, int i) {
        w.n(getContext()).n(qgVar, nVar, i);
    }

    public void n(qg qgVar, x xVar) {
        com.byazt.pj.x.n().n(qgVar, new q(xVar));
    }

    public void n(qg qgVar, com.byazt.ap.q qVar) {
        com.byazt.pj.qg.n().n(qgVar, new q(qVar));
    }

    public void n(qg qgVar, com.byazt.ap.w wVar) {
        com.byazt.be.n.q().n(5, qgVar, wVar);
    }

    public void qg(qg qgVar, com.byazt.ap.w wVar) {
        com.byazt.vgo.n.q().n(9, qgVar, wVar);
    }

    public void s(qg qgVar, com.byazt.ap.w wVar) {
        com.byazt.nk.n.q().n(1, qgVar, wVar);
    }

    public static boolean n(qg qgVar, boolean z) {
        if (qgVar == null) {
            return false;
        }
        return (z && !rv.qg().rv(qgVar.q())) || qgVar.fs() > 0.0f;
    }

    public static boolean n() {
        return com.byazt.bfv.n.qg();
    }

    public static void n(com.byazt.qit.x xVar, int i) {
        if (n()) {
            com.byazt.qit.l.q(xVar);
        } else {
            com.byazt.qit.rv.qg.oa().execute(xVar);
        }
    }

    private Context getContext() {
        if (this.n == null) {
            this.n = rv.getContext();
        }
        return this.n;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            k.n("apply->load with null ->SparseArray");
            return null;
        }
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        int iIntValue = pluginValueSetQg.intValue(-99999982);
        Function<SparseArray<Object>, Object> function = (Function) pluginValueSetQg.objectValue(1, Function.class);
        if (function == null) {
            k.n("apply->load with null callback");
            return null;
        }
        n(iIntValue, pluginValueSetQg, function);
        return null;
    }

    public void n(int i, PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        com.byazt.qvu.n nVarN = com.byazt.qvu.n.n(pluginValueSet);
        nVarN.n(1, 0);
        PluginValueSet pluginValueSetQg = nVarN.qg();
        if (i == 1) {
            boolean zBooleanValue = pluginValueSetQg.booleanValue(2);
            qg qgVarN = com.byazt.vgx.q.n(i, pluginValueSetQg);
            if (zBooleanValue) {
                s(qgVarN, new fs(function));
                return;
            } else {
                n(i, qgVarN, new com.byazt.yy.x(function));
                return;
            }
        }
        if (i == 3) {
            n(com.byazt.vgx.q.n(3, pluginValueSetQg), new com.byazt.yy.s(function), pluginValueSetQg.intValue(3));
            return;
        }
        switch (i) {
            case 5:
                boolean zBooleanValue2 = pluginValueSetQg.booleanValue(2);
                qg qgVarN2 = com.byazt.vgx.q.n(i, pluginValueSetQg);
                if (zBooleanValue2) {
                    n(qgVarN2, new fs(function));
                } else {
                    n(qgVarN2, new com.byazt.yy.l(function));
                }
                break;
            case 6:
                qg(com.byazt.vgx.q.n(6, pluginValueSetQg), new com.byazt.yy.l(function));
                break;
            case 7:
                n(com.byazt.vgx.q.n(7, pluginValueSetQg), new com.byazt.yy.rv(function));
                break;
            case 8:
                n(com.byazt.vgx.q.n(8, pluginValueSetQg), new com.byazt.yy.w(function));
                break;
            case 9:
                boolean zBooleanValue3 = pluginValueSetQg.booleanValue(2);
                qg qgVarN3 = com.byazt.vgx.q.n(9, pluginValueSetQg);
                if (zBooleanValue3) {
                    qg(qgVarN3, new fs(function));
                } else {
                    n(qgVarN3, new com.byazt.yy.q(function));
                }
                break;
        }
    }
}
