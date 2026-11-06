package com.byazt.cby;

import android.text.TextUtils;
import com.byazt.qa.x;
import com.byazt.vy.wm;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_VERSION, 18})
public class l extends n {
    public static volatile l l;
    public final Map<String, double[]> q;
    public final Map<String, String> s;

    private l() {
        super("gm_label_v_v_s");
        this.s = new ConcurrentHashMap();
        this.q = new ConcurrentHashMap();
        qg();
    }

    public static l q() {
        if (l == null) {
            synchronized (l.class) {
                if (l == null) {
                    l = new l();
                }
            }
        }
        return l;
    }

    public void n(int i, double d) {
        if (com.byazt.qt.qg.n().ci()) {
            n(2, String.valueOf(i), 1, d);
        }
    }

    private void q(int i) {
        if (i == 2) {
            this.q.clear();
            return;
        }
        this.s.clear();
        if (this.qg != null) {
            this.qg.n();
        }
    }

    public Map<String, JSONObject> qg(int i) {
        if (!com.byazt.qt.qg.n().ci()) {
            return new HashMap();
        }
        HashMap map = new HashMap();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = null;
        for (Map.Entry<String, double[]> entry : (i == 2 ? this.q : qg(this.s)).entrySet()) {
            String key = entry.getKey();
            double[] value = entry.getValue();
            try {
                if (!TextUtils.isEmpty(key)) {
                    Map<String, JSONObject> mapN = n(key, value);
                    JSONObject jSONObject3 = mapN.get("config_req_label_value");
                    JSONObject jSONObject4 = mapN.get("event_label_value");
                    if (jSONObject4 != null) {
                        jSONObject.putOpt(key, jSONObject4);
                    }
                    if (jSONObject3 != null) {
                        if (jSONObject2 == null) {
                            jSONObject2 = new JSONObject();
                        }
                        jSONObject2.putOpt(key, jSONObject3);
                    }
                }
            } catch (Exception unused) {
            }
        }
        map.put("event_label_value_root", jSONObject);
        if (jSONObject2 != null) {
            map.put("config_req_label_value_root", jSONObject2);
        }
        q(i);
        return map;
    }

    private Map<String, double[]> qg(Map<String, String> map) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (map != null && map.size() != 0) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    String value = it.next().getValue();
                    if (!TextUtils.isEmpty(value)) {
                        String[] strArrSplit = value.split("_");
                        String str = strArrSplit[0];
                        String str2 = strArrSplit[1];
                        String str3 = strArrSplit[2];
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                            if (com.byazt.qt.qg.n().n(System.currentTimeMillis() - Long.parseLong(strArrSplit[2]))) {
                                double[] dArr = (double[]) concurrentHashMap.get(str);
                                if (dArr == null) {
                                    dArr = new double[2];
                                }
                                dArr[0] = dArr[0] + 1.0d;
                                dArr[1] = dArr[1] + Double.parseDouble(str2);
                                concurrentHashMap.put(str, dArr);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        return concurrentHashMap;
    }

    private Map<String, JSONObject> n(String str, double[] dArr) {
        HashMap map = new HashMap();
        String strN = n(dArr);
        JSONObject jSONObject = null;
        try {
            if (!strN.equals("-1")) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.putOpt("input", qg(strN));
                    jSONObject2.putOpt(TapEventParamConstants.PARAM_SUB_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
                } catch (JSONException unused) {
                }
                jSONObject = jSONObject2;
            }
        } catch (JSONException unused2) {
        }
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject4.putOpt("ecpm", strN);
            jSONObject4.putOpt(TapEventParamConstants.PARAM_SUB_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
            jSONObject3.putOpt("ecpm_info", jSONObject4);
        } catch (JSONException unused3) {
        }
        map.put("config_req_label_value", jSONObject);
        map.put("event_label_value", jSONObject3);
        return map;
    }

    public void n(JSONObject jSONObject, JSONObject jSONObject2) {
        if (com.byazt.qt.qg.n().ci() && jSONObject2 != null) {
            try {
                jSONObject.putOpt("label_inputs", jSONObject2);
            } catch (JSONException unused) {
            }
        }
    }

    public void n(JSONObject jSONObject) {
        if (com.byazt.qt.qg.n().ci()) {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, com.byazt.ws.s> entry : com.byazt.qt.qg.n().cx().entrySet()) {
                String key = entry.getKey();
                com.byazt.ws.s value = entry.getValue();
                if (value != null) {
                    try {
                        jSONObject2.putOpt(key, n(value));
                    } catch (JSONException unused) {
                    }
                }
            }
            if (jSONObject != null) {
                jSONObject2.length();
            }
            try {
                jSONObject.putOpt("last_label_outputs", jSONObject2);
            } catch (JSONException unused2) {
            }
        }
    }

    private void qg(JSONObject jSONObject) {
        Map<String, com.byazt.ws.s> mapCx = com.byazt.qt.qg.n().cx();
        if (mapCx.size() > 0 && jSONObject == null) {
            jSONObject = new JSONObject();
        }
        for (Map.Entry<String, com.byazt.ws.s> entry : mapCx.entrySet()) {
            String key = entry.getKey();
            com.byazt.ws.s value = entry.getValue();
            if (value != null) {
                try {
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(String.valueOf(key));
                    if (jSONObjectOptJSONObject == null) {
                        jSONObjectOptJSONObject = new JSONObject();
                        jSONObject.put(String.valueOf(key), jSONObjectOptJSONObject);
                        jSONObjectOptJSONObject.put("ecpm_info", new JSONObject());
                    }
                    jSONObjectOptJSONObject.putOpt("label_info", n(value));
                    jSONObjectOptJSONObject.putOpt("ecpm_ttl", Integer.valueOf(com.byazt.qt.qg.n().hf()));
                } catch (JSONException unused) {
                }
            }
        }
    }

    @Override // com.byazt.cby.n
    public boolean qg(String str, JSONObject jSONObject, Map<String, Object> map) {
        com.byazt.ws.s sVar = com.byazt.qt.qg.n().cx().get(str);
        if (sVar == null) {
            return false;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(str, jSONObject2);
            jSONObject2.putOpt("label_info", n(sVar));
            jSONObject2.putOpt("ecpm_ttl", Integer.valueOf(com.byazt.qt.qg.n().hf()));
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public void n(boolean z, com.byazt.gp.qg qgVar, JSONObject jSONObject, Map<String, Object> map) {
        qgVar.n(MediationConstant.KEY_REASON, Integer.valueOf(!z ? 1 : 0));
        if (map != null) {
            qg(jSONObject);
            if (jSONObject != null) {
                map.put("label", jSONObject);
            }
        }
    }

    @Override // com.byazt.cby.n
    public JSONObject n(com.byazt.ws.s sVar) {
        if (sVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("label_name", sVar.n());
            jSONObject.putOpt("label_id", Integer.valueOf(sVar.s()));
            jSONObject.putOpt("label_version", sVar.q());
            jSONObject.putOpt("upper_bound", Double.valueOf(sVar.l()));
            jSONObject.putOpt("lower_bound", Double.valueOf(sVar.w()));
            jSONObject.putOpt(TapEventParamConstants.PARAM_SUB_TIMESTAMP, sVar.qg());
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static String l() {
        if (!com.byazt.qt.qg.n().ci()) {
            return null;
        }
        Set<Map.Entry<String, com.byazt.ws.s>> setEntrySet = com.byazt.qt.qg.n().cx().entrySet();
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, com.byazt.ws.s> entry : setEntrySet) {
            String key = entry.getKey();
            com.byazt.ws.s value = entry.getValue();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("label_name", value.n());
                jSONObject2.putOpt(TapEventParamConstants.PARAM_SUB_TIMESTAMP, value.qg());
                jSONObject2.putOpt("lower_bound", Double.valueOf(value.w()));
                jSONObject2.putOpt("upper_bound", Double.valueOf(value.l()));
                jSONObject.putOpt(n(Integer.parseInt(key)), jSONObject2);
            } catch (Exception unused) {
            }
        }
        return jSONObject.toString();
    }

    public static String s(int i) {
        com.byazt.ws.s sVar;
        if (com.byazt.qt.qg.n().ci() && (sVar = com.byazt.qt.qg.n().cx().get(String.valueOf(i))) != null) {
            return sVar.n();
        }
        return null;
    }

    public void n(Map<String, ConcurrentHashMap<String, List<x>>> map) {
        int iCt;
        ConcurrentHashMap<String, List<x>> value;
        if (!com.byazt.qt.qg.n().ci() || map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, ConcurrentHashMap<String, List<x>>> entry : map.entrySet()) {
            String key = entry.getKey();
            ConcurrentHashMap<String, List<x>> value2 = entry.getValue();
            if (value2 == null) {
                iCt = 0;
                break;
            }
            Iterator<Map.Entry<String, List<x>>> it = value2.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    iCt = 0;
                    break;
                }
                List<x> value3 = it.next().getValue();
                if (value3 != null && !value3.isEmpty() && value3.get(0) != null && value3.get(0).n != null) {
                    iCt = value3.get(0).n.ct();
                    break;
                }
            }
            com.byazt.ws.qg qgVarN = com.byazt.ir.q.n().n(key, iCt, 101);
            if (qgVarN != null && qgVarN.rv() == 1 && (value = entry.getValue()) != null) {
                Iterator<Map.Entry<String, List<x>>> it2 = value.entrySet().iterator();
                while (it2.hasNext()) {
                    List<x> value4 = it2.next().getValue();
                    if (value4 != null && !value4.isEmpty() && value4.get(0) != null && value4.get(0).n != null) {
                        wm.n(value4);
                        x xVar = value4.get(0);
                        qg(xVar.n.ct(), xVar.n.ta());
                    }
                }
            }
        }
        com.byazt.ng.q.n(com.byazt.qt.qg.n()).n(2, (JSONObject) null);
    }

    public void qg(int i, double d) {
        if (com.byazt.qt.qg.n().ci()) {
            String strValueOf = String.valueOf(i);
            double[] dArr = this.q.get(strValueOf);
            if (dArr == null) {
                dArr = new double[2];
            }
            dArr[0] = dArr[0] + 1.0d;
            dArr[1] = dArr[1] + d;
            this.q.put(strValueOf, dArr);
        }
    }

    @Override // com.byazt.cby.n
    public void n(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.startsWith("cpm_key_")) {
            return;
        }
        this.s.put(str, str2);
    }

    @Override // com.byazt.cby.n
    public Map<String, String> n() {
        return this.s;
    }

    @Override // com.byazt.cby.n
    public void n(String str, int i, String str2) {
        if (i == 2) {
            this.s.put(str, str2);
        }
    }
}
