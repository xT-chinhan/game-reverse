package com.ss.android.downloadlib.addownload.compliance;

import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.ss.android.downloadlib.ab.zb;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ka {
    private String ab;
    private int ah;
    private int c;
    private String ch;
    private int d;
    private long hi;
    private int ka = 15;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f4380ms;
    private int ny;
    private String sl;
    private xr u;
    private String ub;
    private String x;
    private ms xr;
    private String zb;

    public void ms(boolean z) {
        this.f4380ms = z;
    }

    public void ms(ms msVar) {
        this.xr = msVar;
    }

    public void ms(int i) {
        this.ah = i;
    }

    public void xr(int i) {
        this.d = i;
    }

    public void ah(int i) {
        this.ka = i;
    }

    public void d(int i) {
        this.c = i;
    }

    public void ms(String str) {
        this.ab = str;
    }

    public void xr(String str) {
        this.x = str;
    }

    public int ms() {
        return this.ny;
    }

    public void ka(int i) {
        this.ny = i;
    }

    public void ah(String str) {
        this.ch = str;
    }

    public void ms(long j) {
        this.hi = j;
    }

    public void ms(xr xrVar) {
        this.u = xrVar;
    }

    public void d(String str) {
        this.ub = str;
    }

    public void ka(String str) {
        this.sl = str;
    }

    public String xr() {
        return this.zb;
    }

    public void c(String str) {
        this.zb = str;
    }

    public static class ms {
        private List<C0534ms> ab;
        private long ah;
        private String c;
        private String ch;
        private long d;
        private String hi;
        private String ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private String f4381ms;
        private String ny;
        private String sl;
        private String x;
        private String xr;

        public void ms(String str) {
            this.f4381ms = str;
        }

        public void xr(String str) {
            this.xr = str;
        }

        public void ms(long j) {
            this.ah = j;
        }

        public void xr(long j) {
            this.d = j;
        }

        public void ah(String str) {
            this.ka = str;
        }

        public void d(String str) {
            this.c = str;
        }

        public void ka(String str) {
            this.x = str;
        }

        public void ms(List<C0534ms> list) {
            this.ab = list;
        }

        public void c(String str) {
            this.ny = str;
        }

        public void ab(String str) {
            this.ch = str;
        }

        public void x(String str) {
            this.hi = str;
        }

        public void ny(String str) {
            this.sl = str;
        }

        /* JADX INFO: renamed from: com.ss.android.downloadlib.addownload.compliance.ka$ms$ms, reason: collision with other inner class name */
        public static class C0534ms {

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            private String f4382ms;
            private String xr;

            public void ms(String str) {
                this.f4382ms = str;
            }

            public void xr(String str) {
                this.xr = str;
            }
        }
    }

    public static class xr {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private int f4383ms;
        private String xr;

        public void ms(int i) {
            this.f4383ms = i;
        }

        public void ms(String str) {
            this.xr = str;
        }
    }

    public String toString() {
        return ms(this);
    }

    public static String ms(ka kaVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_auth", Integer.valueOf(kaVar.f4380ms ? 1 : 0));
            jSONObject.putOpt("download_permit", Integer.valueOf(kaVar.ah));
            jSONObject.putOpt("appstore_permit", Integer.valueOf(kaVar.d));
            jSONObject.putOpt("market_online_status", Integer.valueOf(kaVar.ka));
            jSONObject.putOpt("hijack_permit", Integer.valueOf(kaVar.c));
            jSONObject.putOpt("package_name", kaVar.ab);
            jSONObject.putOpt("hijack_url", kaVar.x);
            jSONObject.putOpt("code", Integer.valueOf(kaVar.ny));
            jSONObject.putOpt("message", kaVar.ch);
            jSONObject.putOpt("request_duration", Long.valueOf(kaVar.hi));
            jSONObject.putOpt("auth_info", xr(kaVar.xr));
            jSONObject.putOpt("status", xr(kaVar.u));
            jSONObject.putOpt("back_web_url", kaVar.ub);
            jSONObject.putOpt("hw_app_id", kaVar.sl);
            jSONObject.putOpt("deep_link", kaVar.zb);
        } catch (JSONException e) {
            com.ss.android.downloadlib.ka.ah.ms().ms(e, "ComplianceResult toJson");
        }
        return jSONObject.toString();
    }

    public static ka ab(String str) {
        ka kaVar = new ka();
        try {
            JSONObject jSONObject = new JSONObject(str);
            ms msVarMs = ms(jSONObject);
            xr xrVarXr = xr(jSONObject);
            kaVar.ms(msVarMs);
            kaVar.ms(xrVarXr);
            kaVar.ms(jSONObject.optInt("show_auth", 0) == 1);
            kaVar.ms(jSONObject.optInt("download_permit"));
            kaVar.xr(jSONObject.optInt("appstore_permit"));
            kaVar.ah(jSONObject.optInt("market_online_status", 15));
            kaVar.d(jSONObject.optInt("hijack_permit"));
            kaVar.ms(jSONObject.optString("package_name"));
            kaVar.xr(jSONObject.optString("hijack_url"));
            kaVar.ka(jSONObject.optInt("code"));
            kaVar.ah(jSONObject.optString("message"));
            kaVar.ms(jSONObject.optLong("request_duration", 0L));
            kaVar.d(jSONObject.optString("back_web_url"));
            kaVar.ka(jSONObject.optString("hw_app_id"));
            kaVar.c(jSONObject.optString("deep_link"));
        } catch (Exception e) {
            com.ss.android.downloadlib.ka.ah.ms().ms(e, "ComplianceResult fromJson");
        }
        return kaVar;
    }

    private static ms ms(JSONObject jSONObject) {
        ms msVar = new ms();
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("auth_info");
            if (jSONObjectOptJSONObject != null) {
                msVar.ms(jSONObjectOptJSONObject.optString("app_name"));
                msVar.xr(jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME));
                msVar.ms(zb.ms(jSONObjectOptJSONObject, "update_time"));
                msVar.xr(zb.ms(jSONObjectOptJSONObject, "size"));
                msVar.ah(jSONObjectOptJSONObject.optString("developer_name"));
                msVar.d(jSONObjectOptJSONObject.optString("package_name"));
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("permissions");
                if (jSONArrayOptJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    ms(jSONArrayOptJSONArray, arrayList);
                    msVar.ms(arrayList);
                }
                msVar.ka(jSONObjectOptJSONObject.optString("permission_classify_url"));
                msVar.c(jSONObjectOptJSONObject.optString("policy_url"));
                msVar.ab(jSONObjectOptJSONObject.optString("icon_url"));
                msVar.x(jSONObjectOptJSONObject.optString("download_url"));
                msVar.ny(jSONObjectOptJSONObject.optString("desc_url"));
            }
        } catch (Exception e) {
            com.ss.android.downloadlib.ka.ah.ms().ms(e, "ComplianceResult getAuthInfo");
        }
        return msVar;
    }

    private static JSONObject xr(ms msVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (msVar != null) {
            jSONObject.putOpt("app_name", msVar.f4381ms);
            jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, msVar.xr);
            jSONObject.putOpt("update_time", Long.valueOf(msVar.ah));
            jSONObject.putOpt("size", Long.valueOf(msVar.d));
            jSONObject.putOpt("developer_name", msVar.ka);
            jSONObject.putOpt("policy_url", msVar.ny);
            jSONObject.putOpt("icon_url", msVar.ch);
            jSONObject.putOpt("download_url", msVar.hi);
            jSONObject.putOpt("permissions", ah(msVar));
            jSONObject.putOpt("permission_classify_url", msVar.x);
            jSONObject.putOpt("desc_url", msVar.sl);
        }
        return jSONObject;
    }

    private static xr xr(JSONObject jSONObject) {
        xr xrVar = new xr();
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("status");
            if (jSONObjectOptJSONObject != null) {
                xrVar.ms(jSONObjectOptJSONObject.optInt("status"));
                xrVar.ms(jSONObjectOptJSONObject.optString("message"));
            }
        } catch (Exception e) {
            com.ss.android.downloadlib.ka.ah.ms().ms(e, "ComplianceResult getStatus");
        }
        return xrVar;
    }

    private static JSONObject xr(xr xrVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (xrVar != null) {
            jSONObject.putOpt("status", Integer.valueOf(xrVar.f4383ms));
            jSONObject.putOpt("message", xrVar.xr);
        }
        return jSONObject;
    }

    private static void ms(JSONArray jSONArray, List<ms.C0534ms> list) {
        if (jSONArray == null || list == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                ms.C0534ms c0534ms = new ms.C0534ms();
                c0534ms.ms(jSONObjectOptJSONObject.optString("permission_name"));
                c0534ms.xr(jSONObjectOptJSONObject.optString("permission_desc"));
                list.add(c0534ms);
            }
        }
    }

    private static JSONArray ah(ms msVar) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        List<ms.C0534ms> list = msVar.ab;
        if (list != null && list.size() > 0) {
            for (ms.C0534ms c0534ms : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("permission_name", c0534ms.f4382ms);
                jSONObject.putOpt("permission_desc", c0534ms.xr);
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }
}
