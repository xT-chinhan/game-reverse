package com.byazt.ry;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 21, 121})
public class x {
    public static final Object x = new Object();
    public int c;
    public boolean hn;
    public hn hw = new hn();
    public Context pr;

    public x(Context context, boolean z, int i) {
        this.hn = true;
        this.pr = context;
        this.hn = z;
        this.c = i;
    }

    public void pr(JSONObject jSONObject) {
        if (this.hn) {
            fw.pr().pr(this.c).c();
            try {
                boolean z = jSONObject.optInt("ttnet_url_dispatcher_enabled", 0) > 0;
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ttnet_dispatch_actions");
                JSONObject jSONObject2 = null;
                if (fw.pr().pr(this.c).hn() && z && jSONArrayOptJSONArray != null) {
                    ArrayList<JSONObject> arrayList = new ArrayList();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObject3 = ((JSONObject) jSONArrayOptJSONArray.get(i)).getJSONObject("param");
                        if ("idc_selection".equals(jSONObject3.optString("service_name", ""))) {
                            arrayList.add(jSONObject3.getJSONObject("strategy_info"));
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        jSONObject2 = new JSONObject();
                        for (JSONObject jSONObject4 : arrayList) {
                            Iterator<String> itKeys = jSONObject4.keys();
                            while (itKeys.hasNext()) {
                                String next = itKeys.next();
                                jSONObject2.put(next, jSONObject4.getString(next));
                            }
                        }
                    }
                }
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("tnc_config");
                if (jSONObjectOptJSONObject == null && jSONObject2 == null) {
                    com.byazt.am.hw.pr("TNCConfigHandler", " tnc host_replace_map config is null");
                } else if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                    jSONObjectOptJSONObject.put("host_replace_map", jSONObject2);
                } else if (jSONObject2 != null) {
                    jSONObjectOptJSONObject.put("host_replace_map", jSONObject2);
                }
                hn hnVarHw = hw(jSONObjectOptJSONObject);
                if (hnVarHw == null) {
                    synchronized (x) {
                        com.byazt.mg.hw.hw(this.pr, fw.pr().pr(this.c).pr(), 0).edit().putString("tnc_config_str", "").apply();
                        com.byazt.am.hn.pr(this.pr, 1, "", this.c);
                    }
                } else {
                    this.hw = hnVarHw;
                    String string = jSONObjectOptJSONObject.toString();
                    synchronized (x) {
                        com.byazt.mg.hw.hw(this.pr, fw.pr().pr(this.c).pr(), 0).edit().putString("tnc_config_str", string).apply();
                        com.byazt.am.hn.pr(this.pr, 1, string, this.c);
                    }
                }
            } catch (Throwable th) {
                try {
                    this.hw = new hn();
                } finally {
                    synchronized (x) {
                        com.byazt.mg.hw.hw(this.pr, fw.pr().pr(this.c).pr(), 0).edit().putString("tnc_config_str", "").apply();
                        com.byazt.am.hn.pr(this.pr, 1, "", this.c);
                    }
                }
            }
        }
    }

    public void pr() {
        if (!this.hn) {
            return;
        }
        String string = com.byazt.mg.hw.hw(this.pr, fw.pr().pr(this.c).pr(), 0).getString("tnc_config_str", null);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            hn hnVarHw = hw(new JSONObject(string));
            if (hnVarHw != null) {
                this.hw = hnVarHw;
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void hw() {
        hn hnVarHw;
        try {
            String strPr = com.byazt.am.hn.pr(this.pr, 1, this.c);
            if (!TextUtils.isEmpty(strPr) && (hnVarHw = hw(new JSONObject(strPr))) != null) {
                this.hw = hnVarHw;
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public hn hn() {
        return this.hw;
    }

    private hn hw(JSONObject jSONObject) {
        try {
            hn hnVar = new hn();
            if (jSONObject.has("local_enable")) {
                hnVar.pr = jSONObject.getInt("local_enable") != 0;
            }
            if (jSONObject.has("probe_enable")) {
                hnVar.hw = jSONObject.getInt("probe_enable") != 0;
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
                hnVar.hn = map;
            } else {
                hnVar.hn = null;
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
                hnVar.x = map2;
            } else {
                hnVar.x = null;
            }
            hnVar.c = jSONObject.optInt("req_to_cnt", hnVar.c);
            hnVar.uc = jSONObject.optInt("req_to_api_cnt", hnVar.uc);
            hnVar.fw = jSONObject.optInt("req_to_ip_cnt", hnVar.fw);
            hnVar.zo = jSONObject.optInt("req_err_cnt", hnVar.zo);
            hnVar.aj = jSONObject.optInt("req_err_api_cnt", hnVar.aj);
            hnVar.vk = jSONObject.optInt("req_err_ip_cnt", hnVar.vk);
            hnVar.w = jSONObject.optInt("update_interval", hnVar.w);
            hnVar.k = jSONObject.optInt("update_random_range", hnVar.k);
            hnVar.m = jSONObject.optString("http_code_black", hnVar.m);
            return hnVar;
        } catch (Throwable th) {
            return null;
        }
    }
}
