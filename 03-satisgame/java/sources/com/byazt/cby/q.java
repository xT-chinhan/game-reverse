package com.byazt.cby;

import android.text.TextUtils;
import com.byazt.ws.tj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_VERSION, 5})
public class q {
    public static final Map<String, com.byazt.ws.qg> n = new ConcurrentHashMap();

    public static void n(int i, String str, int i2, double d) {
        com.byazt.ws.qg qgVarN;
        com.byazt.ws.q qVarL;
        if (com.byazt.qt.qg.n().ci() && (qgVarN = com.byazt.qt.qg.n().n(str, i2, 101)) != null) {
            if (qgVarN.rv() == 1 && i == 1) {
                l.q().n(i2, d);
                return;
            }
            if (qgVarN.rv() != 2 || (qVarL = com.byazt.qt.qg.n().l(str)) == null) {
                return;
            }
            if (i == 2 && qVarL.s() == 2) {
                qg.q().n(str, 2, d);
            } else {
                if (i != 1 || qVarL.s() == 2) {
                    return;
                }
                qg.q().n(str, qVarL.s(), d);
            }
        }
    }

    public static void n(com.byazt.ws.qg qgVar, double d, String str, int i) {
        if (!com.byazt.qt.qg.n().ci() || qgVar == null) {
            return;
        }
        if (qgVar.rv() == 2) {
            n(2, str, i, d);
        } else if (qgVar.rv() == 3 || qgVar.rv() == 4) {
            qg.q().n(qgVar.f(), "_last_load_cpm_", qgVar.an(), d);
        }
    }

    public static void n(String str, String str2, int i, JSONObject jSONObject) {
        com.byazt.ws.qg qgVarN;
        if (com.byazt.qt.qg.n().ci() && (qgVarN = com.byazt.ir.q.n().n(str, i, 101)) != null) {
            if ("mediation_request".equals(str2)) {
                if (qgVarN.rv() == 1) {
                    l.q().n(String.valueOf(i), jSONObject, qgVarN.fs());
                    return;
                } else {
                    if (qgVarN.rv() == 2) {
                        qg.q().n(String.valueOf(i), jSONObject, qgVarN.fs());
                        return;
                    }
                    return;
                }
            }
            if (qgVarN.rv() != 2 || "sdk_init".equals(str2) || "sdk_init_end".equals(str2) || "get_config_start".equals(str2) || "get_config_final".equals(str2)) {
                return;
            }
            qg.q().s(String.valueOf(i), jSONObject, qgVarN.fs());
        }
    }

    public static com.byazt.ws.qg n(com.byazt.ws.qg qgVar, int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (qgVar != null && com.byazt.qt.qg.n().ci()) {
            if (i == 101) {
                return n.get(qgVar.f());
            }
            if (i == 100 && (qgVar.rv() == 2 || qgVar.rv() == 3 || qgVar.rv() == 4)) {
                List<tj> listN = s.n(qgVar, qgVar.f());
                Object obj = qgVar.fs().get("rule_in_use");
                int iIntValue = obj != null ? ((Integer) obj).intValue() : -1;
                qgVar.fs().put("cost_time", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                if (listN == null || iIntValue == 0) {
                    return qgVar;
                }
                com.byazt.ws.qg qgVarClone = qgVar.clone();
                if (qgVarClone.sz()) {
                    qgVarClone.qg(listN);
                } else {
                    qgVarClone.n(listN);
                }
                Object obj2 = qgVarClone.fs().get("max_ecpm");
                Object obj3 = qgVarClone.fs().get("min_ecpm");
                if (obj2 != null) {
                    qgVarClone.q(((Double) obj2).doubleValue());
                }
                if (obj3 != null) {
                    qgVarClone.l(((Double) obj3).doubleValue());
                }
                n.put(qgVar.f(), qgVarClone);
                qgVarClone.fs().put("cost_time", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                return qgVarClone;
            }
        }
        return null;
    }

    public static int n(String str, int i, Map<String, Object> map) {
        com.byazt.ws.q qVarL;
        int iN;
        if (!TextUtils.isEmpty(str) && i == 1 && (qVarL = com.byazt.qt.qg.n().l(str)) != null) {
            int iS = qVarL.s();
            String strQ = qVarL.q();
            if (iS > 0 && !TextUtils.isEmpty(strQ)) {
                double dN = qg.q().n(3, str, iS);
                List<com.byazt.ws.s> listW = com.byazt.qt.qg.n().w(String.valueOf(i));
                if (listW != null && listW.size() > 0) {
                    Iterator<com.byazt.ws.s> it = listW.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            iN = 0;
                            break;
                        }
                        com.byazt.ws.s next = it.next();
                        if (dN > next.w() && dN <= next.l()) {
                            iN = qVarL.n(String.valueOf(next.s()));
                            map.put("refresh_time", Integer.valueOf(iN));
                            break;
                        }
                    }
                } else {
                    iN = 0;
                    break;
                }
                if (iN >= 10000 && iN <= 180000) {
                    return iN;
                }
            }
        }
        return 0;
    }

    public static void n(int i, String str, JSONObject jSONObject) {
        com.byazt.ws.q qVarL;
        if (com.byazt.qt.qg.n().ci() && i == 2 && (qVarL = com.byazt.qt.qg.n().l(str)) != null) {
            try {
                jSONObject.putOpt("dynamic_rule_id", qVarL.q());
            } catch (JSONException unused) {
            }
        }
    }

    public static void n(List<com.byazt.sg.s> list, com.byazt.ws.qg qgVar) {
        Object obj;
        if (!com.byazt.qt.qg.n().ci() || list == null || qgVar == null) {
            return;
        }
        for (com.byazt.sg.s sVar : list) {
            if (sVar != null) {
                if (qgVar.rv() == 1) {
                    sVar.bb().put(MediationConstant.KEY_GM_USB, l.s(qgVar.fi()));
                } else if (qgVar.rv() == 2 && (obj = qgVar.fs().get("user_label_value")) != null) {
                    sVar.bb().put(MediationConstant.KEY_GM_USB, ((com.byazt.ws.s) obj).n());
                }
            }
        }
    }

    public static void n(boolean z, com.byazt.gp.qg qgVar, JSONObject jSONObject, Map<String, Object> map) {
        if (qgVar == null || !com.byazt.qt.qg.n().ci()) {
            return;
        }
        l.q().n(z, qgVar, jSONObject, map);
    }

    public static void n(int i, List<tj> list, Map<String, Object> map) {
        if (list == null || list.size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (tj tjVar : list) {
            if (tjVar != null && tjVar.um() == 0) {
                jSONArray.put(tjVar.cd());
            }
        }
        if (map != null) {
            map.put("rit_ids", jSONArray);
        }
    }
}
