package com.byazt.su;

import com.anythink.core.common.f.k;
import com.byazt.rz.oa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.smartdigimkt.sdk.api.SDMAdConst;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 726, 18})
public class l {
    public long cp;
    public String d;
    public String fs;
    public String k;
    public int l = 15;
    public boolean n;
    public String oa;
    public int q;
    public n qg;
    public int rv;
    public int s;
    public qg sz;
    public String tj;
    public int w;
    public String x;

    public void n(boolean z) {
        this.n = z;
    }

    public void n(n nVar) {
        this.qg = nVar;
    }

    public void n(int i) {
        this.s = i;
    }

    public void qg(int i) {
        this.q = i;
    }

    public void s(int i) {
        this.l = i;
    }

    public void q(int i) {
        this.w = i;
    }

    public void n(String str) {
        this.x = str;
    }

    public void qg(String str) {
        this.fs = str;
    }

    public int n() {
        return this.rv;
    }

    public void l(int i) {
        this.rv = i;
    }

    public void s(String str) {
        this.tj = str;
    }

    public void n(long j) {
        this.cp = j;
    }

    public void n(qg qgVar) {
        this.sz = qgVar;
    }

    public void q(String str) {
        this.k = str;
    }

    public void l(String str) {
        this.d = str;
    }

    public String qg() {
        return this.oa;
    }

    public void w(String str) {
        this.oa = str;
    }

    @com.byazt.cp.n(n = {0, 1, 726, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public static class n {
        public String cp;
        public String d;
        public String fs;
        public String l;
        public String n;
        public long q;
        public String qg;
        public String rv;
        public long s;
        public String tj;
        public String w;
        public List<C0344n> x;

        public void n(String str) {
            this.n = str;
        }

        public void qg(String str) {
            this.qg = str;
        }

        public void n(long j) {
            this.s = j;
        }

        public void qg(long j) {
            this.q = j;
        }

        public void s(String str) {
            this.l = str;
        }

        public void q(String str) {
            this.w = str;
        }

        public void l(String str) {
            this.fs = str;
        }

        public void n(List<C0344n> list) {
            this.x = list;
        }

        public void w(String str) {
            this.rv = str;
        }

        public void x(String str) {
            this.tj = str;
        }

        public void fs(String str) {
            this.cp = str;
        }

        public void rv(String str) {
            this.d = str;
        }

        /* JADX INFO: renamed from: com.byazt.su.l$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, 726, MediaPlayer.MEDIA_PLAYER_OPTION_SUB_FIRST_LOAD_TIME})
        public static class C0344n {
            public String n;
            public String qg;

            public void n(String str) {
                this.n = str;
            }

            public void qg(String str) {
                this.qg = str;
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, 726, 120})
    public static class qg {
        public int n;
        public String qg;

        public void n(int i) {
            this.n = i;
        }

        public void n(String str) {
            this.qg = str;
        }
    }

    public String toString() {
        return n(this);
    }

    public static String n(l lVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_auth", Integer.valueOf(lVar.n ? 1 : 0));
            jSONObject.putOpt("download_permit", Integer.valueOf(lVar.s));
            jSONObject.putOpt("appstore_permit", Integer.valueOf(lVar.q));
            jSONObject.putOpt("market_online_status", Integer.valueOf(lVar.l));
            jSONObject.putOpt("hijack_permit", Integer.valueOf(lVar.w));
            jSONObject.putOpt("package_name", lVar.x);
            jSONObject.putOpt("hijack_url", lVar.fs);
            jSONObject.putOpt("code", Integer.valueOf(lVar.rv));
            jSONObject.putOpt("message", lVar.tj);
            jSONObject.putOpt("request_duration", Long.valueOf(lVar.cp));
            jSONObject.putOpt("auth_info", qg(lVar.qg));
            jSONObject.putOpt("status", qg(lVar.sz));
            jSONObject.putOpt("back_web_url", lVar.k);
            jSONObject.putOpt("hw_app_id", lVar.d);
            jSONObject.putOpt("deep_link", lVar.oa);
        } catch (JSONException e) {
            com.byazt.ch.s.n().n(e, "ComplianceResult toJson");
        }
        return jSONObject.toString();
    }

    public static l x(String str) {
        l lVar = new l();
        try {
            JSONObject jSONObject = new JSONObject(str);
            n nVarN = n(jSONObject);
            qg qgVarQg = qg(jSONObject);
            lVar.n(nVarN);
            lVar.n(qgVarQg);
            lVar.n(jSONObject.optInt("show_auth", 0) == 1);
            lVar.n(jSONObject.optInt("download_permit"));
            lVar.qg(jSONObject.optInt("appstore_permit"));
            lVar.s(jSONObject.optInt("market_online_status", 15));
            lVar.q(jSONObject.optInt("hijack_permit"));
            lVar.n(jSONObject.optString("package_name"));
            lVar.qg(jSONObject.optString("hijack_url"));
            lVar.l(jSONObject.optInt("code"));
            lVar.s(jSONObject.optString("message"));
            lVar.n(jSONObject.optLong("request_duration", 0L));
            lVar.q(jSONObject.optString("back_web_url"));
            lVar.l(jSONObject.optString("hw_app_id"));
            lVar.w(jSONObject.optString("deep_link"));
        } catch (Exception e) {
            com.byazt.ch.s.n().n(e, "ComplianceResult fromJson");
        }
        return lVar;
    }

    private static n n(JSONObject jSONObject) {
        n nVar = new n();
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("auth_info");
            if (jSONObjectOptJSONObject != null) {
                nVar.n(jSONObjectOptJSONObject.optString("app_name"));
                nVar.qg(jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME));
                nVar.n(oa.n(jSONObjectOptJSONObject, k.a.g));
                nVar.qg(oa.n(jSONObjectOptJSONObject, "size"));
                nVar.s(jSONObjectOptJSONObject.optString("developer_name"));
                nVar.q(jSONObjectOptJSONObject.optString("package_name"));
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("permissions");
                if (jSONArrayOptJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    n(jSONArrayOptJSONArray, arrayList);
                    nVar.n(arrayList);
                }
                nVar.l(jSONObjectOptJSONObject.optString("permission_classify_url"));
                nVar.w(jSONObjectOptJSONObject.optString("policy_url"));
                nVar.x(jSONObjectOptJSONObject.optString(SDMAdConst.NETWORK_CUSTOM_KEY.ICON_URL));
                nVar.fs(jSONObjectOptJSONObject.optString(SDMAdConst.NETWORK_CUSTOM_KEY.DOWNLOAD_URL));
                nVar.rv(jSONObjectOptJSONObject.optString("desc_url"));
            }
        } catch (Exception e) {
            com.byazt.ch.s.n().n(e, "ComplianceResult getAuthInfo");
        }
        return nVar;
    }

    private static JSONObject qg(n nVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (nVar != null) {
            jSONObject.putOpt("app_name", nVar.n);
            jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, nVar.qg);
            jSONObject.putOpt(k.a.g, Long.valueOf(nVar.s));
            jSONObject.putOpt("size", Long.valueOf(nVar.q));
            jSONObject.putOpt("developer_name", nVar.l);
            jSONObject.putOpt("policy_url", nVar.rv);
            jSONObject.putOpt(SDMAdConst.NETWORK_CUSTOM_KEY.ICON_URL, nVar.tj);
            jSONObject.putOpt(SDMAdConst.NETWORK_CUSTOM_KEY.DOWNLOAD_URL, nVar.cp);
            jSONObject.putOpt("permissions", s(nVar));
            jSONObject.putOpt("permission_classify_url", nVar.fs);
            jSONObject.putOpt("desc_url", nVar.d);
        }
        return jSONObject;
    }

    private static qg qg(JSONObject jSONObject) {
        qg qgVar = new qg();
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("status");
            if (jSONObjectOptJSONObject != null) {
                qgVar.n(jSONObjectOptJSONObject.optInt("status"));
                qgVar.n(jSONObjectOptJSONObject.optString("message"));
            }
        } catch (Exception e) {
            com.byazt.ch.s.n().n(e, "ComplianceResult getStatus");
        }
        return qgVar;
    }

    private static JSONObject qg(qg qgVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (qgVar != null) {
            jSONObject.putOpt("status", Integer.valueOf(qgVar.n));
            jSONObject.putOpt("message", qgVar.qg);
        }
        return jSONObject;
    }

    private static void n(JSONArray jSONArray, List<n.C0344n> list) {
        if (jSONArray == null || list == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                n.C0344n c0344n = new n.C0344n();
                c0344n.n(jSONObjectOptJSONObject.optString("permission_name"));
                c0344n.qg(jSONObjectOptJSONObject.optString("permission_desc"));
                list.add(c0344n);
            }
        }
    }

    private static JSONArray s(n nVar) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        List<n.C0344n> list = nVar.x;
        if (list != null && list.size() > 0) {
            for (n.C0344n c0344n : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("permission_name", c0344n.n);
                jSONObject.putOpt("permission_desc", c0344n.qg);
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }
}
