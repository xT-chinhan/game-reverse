package com.byazt.vy;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1431, 21})
public class x {
    public static com.byazt.mj.s n(com.byazt.qn.qg qgVar, com.byazt.sg.s sVar, boolean z) {
        if (sVar == null || qgVar == null) {
            return null;
        }
        com.byazt.mj.s sVar2 = new com.byazt.mj.s();
        sVar2.n(sVar.he());
        sVar2.fs(sVar.lq());
        sVar2.rv(sVar.ic());
        sVar2.tj(sVar.el());
        sVar2.oa(sVar.ri());
        if (z) {
            if (!n() && (sVar.dm() || sVar.o() || sVar.nk())) {
                sVar2.cp("-3");
            } else {
                sVar2.cp(sVar.sq());
            }
        } else if (!qg() && sVar.dm()) {
            sVar2.cp("-3");
        } else {
            sVar2.cp(sVar.ei());
        }
        sVar2.k(sVar.di());
        sVar2.qg(sVar.bz());
        sVar2.sz(sVar.b());
        sVar2.n(qg(qgVar));
        sVar2.qg(n(sVar));
        sVar2.x(qgVar != null ? qgVar.py() : null);
        sVar2.w(n(qgVar));
        sVar2.s(new StringBuilder().append(qgVar.rf()).toString());
        com.byazt.jp.w wVarPy = com.byazt.qt.n.d().py();
        sVar2.q(wVarPy != null ? wVarPy.s() : null);
        sVar2.l(wVarPy != null ? wVarPy.q() : null);
        Map<String, Object> mapAn = qgVar != null ? qgVar.an() : null;
        if (mapAn != null && !mapAn.isEmpty()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, Object> entry : mapAn.entrySet()) {
                Object value = entry.getValue();
                map.put(entry.getKey(), value == null ? null : value.toString());
            }
            sVar2.n(map);
        }
        sVar2.d(sVar.wv());
        return sVar2;
    }

    private static String n(com.byazt.qn.qg qgVar) {
        com.byazt.ws.qg qgVarN;
        if (qgVar == null || com.byazt.ir.qg.n().tj() != 1 || (qgVarN = com.byazt.ir.q.n().n(qgVar.a(), qgVar.um(), 102)) == null || qgVarN.s() == 1) {
            return null;
        }
        String strY = qgVar.y();
        if (TextUtils.isEmpty(strY)) {
            return null;
        }
        try {
            return new JSONObject(strY).optString("experiment_detail_id");
        } catch (JSONException unused) {
            return null;
        }
    }

    private static String qg(com.byazt.qn.qg qgVar) {
        if (qgVar == null) {
            return null;
        }
        switch (qgVar.um()) {
            case 1:
                return MediationConstant.RIT_TYPE_BANNER;
            case 2:
                return MediationConstant.RIT_TYPE_INTERSTITIAL;
            case 3:
                return MediationConstant.RIT_TYPE_SPLASH;
            case 4:
            case 6:
            default:
                return null;
            case 5:
                return MediationConstant.RIT_TYPE_FEED;
            case 7:
                return MediationConstant.RIT_TYPE_REWARD_VIDEO;
            case 8:
                return MediationConstant.RIT_TYPE_FULL_VIDEO;
            case 9:
                return MediationConstant.RIT_TYPE_DRAW;
            case 10:
                return MediationConstant.RIT_TYPE_INTERSTITIAL_FULL;
        }
    }

    private static String n(com.byazt.sg.s sVar) {
        if (sVar == null) {
            return null;
        }
        switch (sVar.dg()) {
            case 1:
            case 8:
                return MediationConstant.RIT_TYPE_INTERSTITIAL;
            case 2:
            case 7:
                return MediationConstant.RIT_TYPE_FULL_VIDEO;
            case 3:
                return MediationConstant.RIT_TYPE_BANNER;
            case 4:
                return MediationConstant.RIT_TYPE_FEED;
            case 5:
                return MediationConstant.RIT_TYPE_DRAW;
            case 6:
                return MediationConstant.RIT_TYPE_REWARD_VIDEO;
            default:
                int iCt = sVar.ct();
                if (iCt == 1) {
                    return MediationConstant.RIT_TYPE_BANNER;
                }
                if (iCt == 5) {
                    return MediationConstant.RIT_TYPE_FEED;
                }
                if (iCt != 7) {
                    return null;
                }
                return MediationConstant.RIT_TYPE_REWARD_VIDEO;
        }
    }

    private static boolean n() {
        return com.byazt.qt.qg.n().f();
    }

    private static boolean qg() {
        return com.byazt.qt.qg.n().df();
    }

    public static boolean n(List<com.byazt.sg.s> list, List<com.byazt.sg.s> list2, List<com.byazt.sg.s> list3, com.byazt.qn.qg qgVar, boolean z, String str, int i, List<com.byazt.ws.tj> list4) {
        int iQg = com.byazt.np.qg.qg(str);
        com.byazt.gp.s.n(list, list2, list3, qgVar, iQg);
        if (z || iQg != 0) {
            return false;
        }
        if (list.size() > 0) {
            for (com.byazt.sg.s sVar : list) {
                if (sVar != null) {
                    com.byazt.rb.qg.n(MediationConstant.TAG, com.byazt.rb.q.qg(str, sVar.el()) + "isReady-》广告类型：" + com.byazt.sg.n.n(sVar.he()) + ",是否已准备好？isReady()：" + sVar.ae(str));
                    if (sVar.ae(str) && !sVar.nf()) {
                        return true;
                    }
                }
            }
        }
        if (list3 != null && list3.size() > 0) {
            for (com.byazt.sg.s sVar2 : list3) {
                if (sVar2 != null) {
                    com.byazt.rb.qg.n(MediationConstant.TAG, com.byazt.rb.q.qg(str, sVar2.el()) + "isReady-》广告类型：" + com.byazt.sg.n.n(sVar2.he()) + ",是否已准备好？isReady()：" + sVar2.ae(str));
                    if (sVar2.ae(str) && !sVar2.nf()) {
                        return true;
                    }
                }
            }
        }
        if (list2 != null && list2.size() > 0) {
            for (com.byazt.sg.s sVar3 : list2) {
                if (sVar3 != null) {
                    com.byazt.rb.qg.n(MediationConstant.TAG, com.byazt.rb.q.qg(str, sVar3.el()) + "isReady--->biding-->广告类型：" + com.byazt.sg.n.n(sVar3.he()) + ",是否已准备好？isReady()：" + sVar3.ae(str));
                    if (sVar3.ae(str) && !sVar3.nf()) {
                        return true;
                    }
                }
            }
        }
        if (list4 != null && list4.size() > 0) {
            for (com.byazt.ws.tj tjVar : list4) {
                String strCd = tjVar.cd();
                if (tjVar.a() && com.byazt.ra.n.n().q(str, strCd, i) && com.byazt.ra.n.n().n(strCd, qgVar, false) == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean n(Map<String, Object> map) {
        if (map == null) {
            return false;
        }
        Object obj = map.get("show_adn_load_error_detail");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static com.byazt.mj.n n(com.byazt.qn.qg qgVar, com.byazt.mj.n nVar, List<com.byazt.mj.qg> list) {
        if (nVar == null || qgVar == null || list == null || list.size() == 0 || !n(qgVar.an())) {
            return nVar;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.byazt.mj.qg qgVar2 : list) {
            if (qgVar2 != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(MediationConstant.EXTRA_ADN_NAME, TextUtils.isEmpty(qgVar2.s()) ? qgVar2.q() : qgVar2.s());
                    jSONObject.put("mediation_rit", qgVar2.qg());
                    jSONObject.put("ad_type", qgVar2.n());
                    jSONObject.put("error_code", qgVar2.l());
                    jSONObject.put("error_msg", qgVar2.w());
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        nVar.qg = jSONArray.toString();
        return nVar;
    }
}
