package com.byazt.yc;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.anythink.core.api.ATAdConst;
import com.byazt.vy.ou;
import com.byazt.ws.rv;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 965, 8})
public class s {
    public static com.byazt.nw.n n(com.byazt.dd.qg qgVar, com.byazt.qn.qg qgVar2, com.byazt.nw.qg qgVar3) {
        com.byazt.ws.n nVarN;
        com.byazt.or.n nVarN2;
        if (qgVar == null || qgVar2 == null) {
            return null;
        }
        qgVar.n(n(qgVar2, qgVar));
        qgVar.qg(qgVar2.a());
        if (!qgVar.tj()) {
            if (qgVar.cp()) {
                return com.byazt.ua.q.n(qgVar, qgVar3);
            }
            if (com.byazt.sq.s.n(qgVar.fs())) {
                return new com.byazt.ua.s(qgVar3);
            }
            return null;
        }
        com.byazt.it.qg.n(com.byazt.qt.qg.getContext(), qgVar != null ? qgVar.oa() : "");
        if (com.byazt.ya.n.n(qgVar.oa()) == null || (nVarN = com.byazt.ir.s.n().n(qgVar.oa())) == null || nVarN.q() == null || (nVarN2 = nVarN.q().n(qgVar.h(), qgVar.k())) == null || !n(nVarN2)) {
            return null;
        }
        return com.byazt.ua.q.n(nVarN2.n(), qgVar, qgVar3);
    }

    public static String n(com.byazt.qn.qg qgVar, com.byazt.dd.qg qgVar2) {
        if (qgVar == null || qgVar2 == null) {
            return null;
        }
        String strN = TextUtils.isEmpty(qgVar.n()) ? null : qgVar.n();
        if (TextUtils.isEmpty(qgVar2.d())) {
            return strN;
        }
        return (strN + "_") + qgVar2.d();
    }

    public static boolean n(com.byazt.or.n nVar) {
        if (nVar == null) {
            return false;
        }
        Function<SparseArray<Object>, Object> functionL = com.byazt.zs.n.n().l();
        if (functionL != null) {
            if (!TextUtils.isEmpty(nVar.n())) {
                com.byazt.qvu.n nVarN = com.byazt.qvu.n.n();
                nVarN.n(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, nVar.n());
                com.byazt.rb.qg.qg("TMe", "custom className is " + nVar.n());
                nVarN.n(-99999987, 8229);
                nVarN.n(-99999985, Boolean.class);
                return ((Boolean) functionL.apply(nVarN.qg().sparseArray())).booleanValue();
            }
            com.byazt.rb.qg.qg("TMe", "custom className is empty");
        } else {
            com.byazt.rb.qg.qg(MediationConstant.TAG, "load ad check custom name class loader is null ");
        }
        return false;
    }

    public static Map<String, Object> n(com.byazt.dd.qg qgVar, com.byazt.qn.qg qgVar2, Map<String, Object> map) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (qgVar != null && qgVar2 != null) {
            com.byazt.ws.n nVarN = com.byazt.qt.qg.n().n(qgVar.oa());
            if (nVarN != null) {
                concurrentHashMap.put("tt_ad_network_config_appid", nVarN.qg());
                concurrentHashMap.put("tt_ad_network_config_appKey", nVarN.s());
            }
            concurrentHashMap.put("tt_ad_origin_type", Integer.valueOf(qgVar.sz()));
            concurrentHashMap.put("tt_ad_sub_type", Integer.valueOf(qgVar.k()));
            if (qgVar2 != null) {
                Map<String, Object> mapAn = qgVar2.an();
                if (mapAn != null && mapAn.size() > 0) {
                    for (Map.Entry<String, Object> entry : mapAn.entrySet()) {
                        if (entry.getKey() != null && entry.getValue() != null) {
                            concurrentHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                int iOu = qgVar2.ou();
                int iWm = qgVar2.wm();
                if (iOu < 0) {
                    iOu = 0;
                }
                if (iWm < 0) {
                    iWm = 0;
                }
                concurrentHashMap.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_HEIGHT, Integer.valueOf(iWm));
                concurrentHashMap.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_WIDTH, Integer.valueOf(iOu));
                concurrentHashMap.put("ad_type", Integer.valueOf(qgVar2.um()));
            }
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, Object> entry2 : map.entrySet()) {
                    if (entry2.getKey() != null && entry2.getValue() != null) {
                        concurrentHashMap.put(entry2.getKey(), entry2.getValue());
                    }
                }
            }
        }
        return concurrentHashMap;
    }

    public static void n(com.byazt.sg.s sVar, com.byazt.qn.qg qgVar, com.byazt.dd.qg qgVar2, rv rvVar, String str) {
        if (sVar == null || qgVar2 == null || qgVar == null) {
            return;
        }
        if ((qgVar2.um() == 0 || qgVar2.um() == 100) && qgVar2.ur() != 0.0d) {
            sVar.n(qgVar2.ur());
        }
        if (qgVar2.wm()) {
            sVar.qg(qgVar2.bb());
            sVar.s(qgVar2.ln());
            if (qgVar2.lh() != null) {
                sVar.l(qgVar2.lh().s());
                sVar.w(qgVar2.lh().q());
                sVar.s(qgVar2.lh().fs());
                sVar.q(qgVar2.lh().rv());
                sVar.q(qgVar2.lh().n());
            }
        }
        sVar.k(qgVar2.um());
        sVar.hd(qgVar2.a());
        sVar.cy(qgVar2.py());
        if (str == null) {
            str = "";
        }
        sVar.cd(str);
        sVar.cy(qgVar2.oa());
        sVar.hd(qgVar2.fs() != null ? qgVar2.fs().cy() : "");
        sVar.k(qgVar2.v());
        sVar.t(qgVar2.fs() != null ? qgVar2.fs().wm() : null);
        sVar.n(SystemClock.elapsedRealtime());
        sVar.a(qgVar2.d());
        sVar.um(qgVar2.qg());
        sVar.oa(com.byazt.sg.n.qg(qgVar2.oa()));
        sVar.x(qgVar2.x());
        sVar.fs(qgVar2.w());
        sVar.x(qgVar.n());
        sVar.rv(qgVar2.x());
        sVar.tj(qgVar2.w());
        sVar.w(qgVar2.sz());
        sVar.l(qgVar2.k());
        sVar.sz(qgVar.um());
        sVar.s(qgVar2.j());
        sVar.n(qgVar2.t());
        ou.n(sVar, qgVar2.fs(), qgVar, false);
        if (rvVar != null) {
            sVar.qg("if_test", Integer.valueOf(rvVar.qg == 1 ? rvVar.qg : 0));
            sVar.qg("server_bidding_extra", rvVar.n);
            int iFs = sVar.fs(qgVar != null ? qgVar.n() : null);
            if (iFs == 1 || iFs == 2) {
                sVar.s(rvVar.l);
            }
        }
        if (qgVar2.lh() != null && qgVar2.lh() != null) {
            sVar.n("extra_data_and_no_parse", qgVar2.lh().qg());
        }
        sVar.cp(qgVar2.fi());
    }
}
