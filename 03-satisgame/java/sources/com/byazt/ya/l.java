package com.byazt.ya;

import android.util.SparseArray;
import com.byazt.nf.tj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 935, 18})
public class l {
    public static void n(com.byazt.of.qg qgVar) {
        com.byazt.zq.n nVar = new com.byazt.zq.n(com.byazt.qt.n.d().an().sparseArray());
        qgVar.n(8475, com.byazt.hn.s.n(n(nVar.cp())));
        qgVar.n(8457, com.byazt.hn.s.n(n(nVar.k())));
        qgVar.n(1, Boolean.valueOf(com.byazt.ir.qg.n().rv()));
    }

    public static void n(com.byazt.of.qg qgVar, com.byazt.of.qg qgVar2) {
        qgVar.n(8424, com.byazt.hn.s.n(qgVar2.qg()));
    }

    public static SparseArray<Object> n(com.byazt.xmw.n nVar) {
        if (nVar == null) {
            return null;
        }
        com.byazt.of.qg qgVarN = com.byazt.of.qg.n();
        qgVarN.n(8458, Boolean.valueOf(nVar.l()));
        qgVarN.n(8459, nVar.cp());
        qgVarN.n(8460, nVar.n());
        qgVarN.n(8461, Boolean.valueOf(nVar.qg()));
        qgVarN.n(8310, new fs(nVar.s()));
        qgVarN.n(8462, nVar.q());
        qgVarN.n(8463, nVar.w());
        qgVarN.n(8464, nVar.x());
        qgVarN.n(8465, Boolean.valueOf(nVar.fs()));
        qgVarN.n(8466, Boolean.valueOf(nVar.rv()));
        qgVarN.n(8467, Boolean.valueOf(nVar.tj()));
        return qgVarN.qg();
    }

    private static SparseArray<Object> qg(com.byazt.zq.q qVar) {
        com.byazt.of.qg qgVarN = com.byazt.of.qg.n();
        if (qVar != null) {
            qgVarN.n(8311, new n(qVar.cy()));
            qgVarN.n(8023, Boolean.valueOf(qVar.q()));
            qgVarN.n(8024, Boolean.valueOf(qVar.n()));
            qgVarN.n(8025, Boolean.valueOf(qVar.fs()));
            qgVarN.n(8026, Boolean.valueOf(qVar.s()));
            qgVarN.n(8480, Boolean.valueOf(qVar.w()));
            qgVarN.n(8479, Boolean.valueOf(qVar.tj()));
            qgVarN.n(8312, qVar.qg() != null ? new w(qVar.qg()) : null);
            qgVarN.n(8483, qVar.qg());
            qgVarN.n(8484, qVar.l());
            qgVarN.n(8485, qVar.cp());
            qgVarN.n(8486, qVar.rv());
            qgVarN.n(8487, qVar.x());
            qgVarN.n(8554, qVar.d());
            qgVarN.n(8549, Boolean.valueOf(qVar.sz()));
        } else {
            qgVarN.n(8311, new n(null));
            qgVarN.n(8023, Boolean.TRUE);
            qgVarN.n(8024, Boolean.TRUE);
            qgVarN.n(8025, Boolean.TRUE);
            qgVarN.n(8026, Boolean.TRUE);
            qgVarN.n(8480, Boolean.TRUE);
            qgVarN.n(8479, Boolean.TRUE);
            qgVarN.n(8312, new w(null));
            qgVarN.n(8483, null);
            qgVarN.n(8484, "");
            qgVarN.n(8485, "");
            qgVarN.n(8486, "");
            qgVarN.n(8487, "");
            qgVarN.n(8549, Boolean.TRUE);
        }
        return qgVarN.qg();
    }

    public static SparseArray<Object> n(com.byazt.zq.q qVar) {
        return qg(qVar);
    }

    @com.byazt.cp.n(n = {0, 1, 935, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    private static class n extends x {
        public n(com.byazt.xmw.qg qgVar) {
            super(qgVar);
        }

        @Override // com.byazt.ya.x
        public boolean n() {
            int iHe = com.byazt.qt.qg.n().he();
            if (iHe > 0) {
                return true;
            }
            if (iHe < 0) {
                return false;
            }
            return super.n();
        }

        @Override // com.byazt.ya.x
        public boolean qg() {
            int iEl = com.byazt.qt.qg.n().el();
            if (iEl > 0) {
                return false;
            }
            if (iEl < 0) {
                return true;
            }
            return super.qg();
        }
    }

    public static JSONObject n() {
        try {
            JSONObject jSONObject = new JSONObject();
            Map<String, com.byazt.ju.q> mapQg = qg.n().qg();
            if (mapQg != null && mapQg.size() > 0) {
                for (Map.Entry<String, com.byazt.ju.q> entry : mapQg.entrySet()) {
                    String key = entry.getKey();
                    com.byazt.ju.q value = entry.getValue();
                    long jL = value.l();
                    int iW = value.w();
                    if (jL != 0) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("status", iW);
                        jSONObject2.put(MediationConstant.EXTRA_DURATION, jL);
                        jSONObject.put(key, jSONObject2);
                        value.x();
                    }
                }
            }
            if (com.byazt.zo.x.n > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("status", 1);
                jSONObject3.put(MediationConstant.EXTRA_DURATION, com.byazt.zo.x.n);
                jSONObject3.put("plugin", tj.qg() ? 1 : 0);
                jSONObject3.put("layer_real_cost_time", com.byazt.zo.x.s);
                jSONObject.put(MediationConstant.ADN_PANGLE, jSONObject3);
                com.byazt.zo.x.n = 0L;
            }
            if (com.byazt.zo.x.qg > 0) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("status", 1);
                jSONObject4.put(MediationConstant.EXTRA_DURATION, com.byazt.zo.x.qg);
                jSONObject4.put("plugin", tj.qg() ? 1 : 0);
                jSONObject4.put("layer_real_cost_time", com.byazt.zo.x.q);
                jSONObject.put("fusion", jSONObject4);
                com.byazt.zo.x.qg = 0L;
            }
            if (com.byazt.ya.n.q() != null && com.byazt.ya.n.q().n() != null && com.byazt.ya.n.q().n().size() > 0) {
                for (Map.Entry<String, com.byazt.sbw.n> entry2 : com.byazt.ya.n.q().n().entrySet()) {
                    String key2 = entry2.getKey();
                    com.byazt.sbw.n value2 = entry2.getValue();
                    long jL2 = value2.l();
                    int iW2 = value2.w();
                    if (jL2 != 0) {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("status", iW2);
                        jSONObject5.put(MediationConstant.EXTRA_DURATION, jL2);
                        jSONObject.put(key2, jSONObject5);
                        value2.x();
                    }
                }
            }
            if (jSONObject.length() == 0) {
                return null;
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}
