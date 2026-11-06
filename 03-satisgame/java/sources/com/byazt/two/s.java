package com.byazt.two;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.vf.ae;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 802, 8})
public class s {
    public static final Object q = new Object();
    public q fs;
    public int l;
    public Context n;
    public qg qg = new qg();
    public boolean s;
    public volatile com.byazt.gwu.s w;
    public final w x;

    public s(boolean z, com.byazt.xl.s sVar, q qVar) {
        this.s = true;
        this.n = sVar.getContext();
        this.s = z;
        this.l = sVar.n();
        this.x = new w(sVar);
        this.fs = qVar;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0094  */
    /* JADX WARN: Code duplicated, block: B:84:0x012c A[Catch: all -> 0x013c, FINALLY_INSNS, TryCatch #2 {, blocks: (B:82:0x0126, B:84:0x012c, B:85:0x0131, B:86:0x013a), top: B:93:0x0126 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0126 A[EXC_TOP_SPLITTER, FINALLY_INSNS, SYNTHETIC] */
    public void n(JSONObject jSONObject) {
        q qVar;
        com.byazt.gwu.s sVarQ;
        Object obj;
        JSONObject jSONObject2;
        if (this.s && (qVar = this.fs) != null) {
            qVar.s();
            try {
                try {
                    boolean z = jSONObject.optInt("ttnet_url_dispatcher_enabled", 0) > 0;
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ttnet_dispatch_actions");
                    if (this.fs.qg() && z && jSONArrayOptJSONArray != null) {
                        ArrayList<JSONObject> arrayList = new ArrayList();
                        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                            JSONObject jSONObject3 = ((JSONObject) jSONArrayOptJSONArray.get(i)).getJSONObject("param");
                            if ("idc_selection".equals(jSONObject3.optString("service_name", ""))) {
                                arrayList.add(jSONObject3.getJSONObject("strategy_info"));
                            }
                        }
                        if (arrayList.isEmpty()) {
                            jSONObject2 = null;
                        } else {
                            jSONObject2 = new JSONObject();
                            for (JSONObject jSONObject4 : arrayList) {
                                Iterator<String> itKeys = jSONObject4.keys();
                                while (itKeys.hasNext()) {
                                    String next = itKeys.next();
                                    jSONObject2.put(next, jSONObject4.getString(next));
                                }
                            }
                        }
                    } else {
                        jSONObject2 = null;
                    }
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("tnc_config");
                    if (jSONObjectOptJSONObject == null && jSONObject2 == null) {
                        com.byazt.nx.qg.n("TNCConfigHandler", " tnc host_replace_map config is null");
                    } else if (jSONObjectOptJSONObject == null) {
                        jSONObjectOptJSONObject = new JSONObject();
                        jSONObjectOptJSONObject.put("host_replace_map", jSONObject2);
                    } else if (jSONObject2 != null) {
                        jSONObjectOptJSONObject.put("host_replace_map", jSONObject2);
                    }
                    qg qgVarQg = qg(jSONObjectOptJSONObject);
                    if (qgVarQg == null) {
                        synchronized (q) {
                            com.byazt.gwu.s sVarQ2 = q();
                            if (sVarQ2 != null) {
                                sVarQ2.n("tnc_config_str", "");
                            }
                            this.x.n(this.n, 1, "", this.l);
                        }
                        return;
                    }
                    this.qg = qgVarQg;
                    String string = jSONObjectOptJSONObject.toString();
                    synchronized (q) {
                        com.byazt.gwu.s sVarQ3 = q();
                        if (sVarQ3 != null) {
                            sVarQ3.n("tnc_config_str", string);
                        }
                        this.x.n(this.n, 1, string, this.l);
                    }
                    return;
                } finally {
                    synchronized (q) {
                        sVarQ = q();
                        if (sVarQ != null) {
                            sVarQ.n("tnc_config_str", "");
                        }
                        this.x.n(this.n, 1, "", this.l);
                    }
                }
            } catch (Throwable unused) {
                this.qg = new qg();
                synchronized (obj) {
                    return;
                }
            }
            synchronized (q) {
                sVarQ = q();
                if (sVarQ != null) {
                    sVarQ.n("tnc_config_str", "");
                }
                this.x.n(this.n, 1, "", this.l);
            }
        }
    }

    public void n() {
        if (this.s && this.fs != null) {
            com.byazt.gwu.s sVarQ = q();
            String string = sVarQ != null ? sVarQ.getString("tnc_config_str", null) : null;
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                qg qgVarQg = qg(new JSONObject(string));
                if (qgVarQg != null) {
                    this.qg = qgVarQg;
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    public void qg() {
        qg qgVarQg;
        try {
            String strN = this.x.n(this.n, 1, this.l);
            if (TextUtils.isEmpty(strN) || (qgVarQg = qg(new JSONObject(strN))) == null) {
                return;
            }
            this.qg = qgVarQg;
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public qg s() {
        return this.qg;
    }

    private com.byazt.gwu.s q() {
        if (this.w == null) {
            com.byazt.vf.n nVarQg = com.byazt.qp.q.qg(null);
            ae aeVar = (ae) com.byazt.qp.q.n("storage_service");
            if (aeVar != null) {
                this.w = aeVar.qg(nVarQg, this.fs.n(), 0, com.byazt.p001if.n.n());
            }
        }
        return this.w;
    }

    private qg qg(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            qg qgVar = new qg();
            if (jSONObject.has("local_enable")) {
                qgVar.n = jSONObject.getInt("local_enable") != 0;
            }
            if (jSONObject.has("probe_enable")) {
                qgVar.qg = jSONObject.getInt("probe_enable") != 0;
            }
            if (jSONObject.has("local_host_filter")) {
                JSONArray jSONArray = jSONObject.getJSONArray("local_host_filter");
                HashMap map = new HashMap();
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string)) {
                            map.put(string, 0);
                        }
                    }
                }
                qgVar.s = map;
            } else {
                qgVar.s = null;
            }
            if (jSONObject.has("host_replace_map")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("host_replace_map");
                HashMap map2 = new HashMap();
                if (jSONObject2.length() > 0) {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        String string2 = jSONObject2.getString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2)) {
                            map2.put(next, string2);
                        }
                    }
                }
                qgVar.q = map2;
            } else {
                qgVar.q = null;
            }
            qgVar.l = jSONObject.optInt("req_to_cnt", qgVar.l);
            qgVar.w = jSONObject.optInt("req_to_api_cnt", qgVar.w);
            qgVar.x = jSONObject.optInt("req_to_ip_cnt", qgVar.x);
            qgVar.fs = jSONObject.optInt("req_err_cnt", qgVar.fs);
            qgVar.rv = jSONObject.optInt("req_err_api_cnt", qgVar.rv);
            qgVar.tj = jSONObject.optInt("req_err_ip_cnt", qgVar.tj);
            qgVar.cp = jSONObject.optInt("update_interval", qgVar.cp);
            qgVar.d = jSONObject.optInt("update_random_range", qgVar.d);
            qgVar.oa = jSONObject.optString("http_code_black", qgVar.oa);
            return qgVar;
        } catch (Throwable unused) {
            return null;
        }
    }
}
