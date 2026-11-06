package com.byazt.xqu;

import android.support.v4.app.NotificationCompat;
import com.byazt.mg.PluginConstants;
import com.byazt.uk.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 432, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public int aj;
    public int c = 15;
    public String fw;
    public hw g;
    public int hn;
    public String ho;
    public pr hw;
    public String k;
    public String m;
    public boolean pr;
    public int uc;
    public String vk;
    public long w;
    public int x;
    public String zo;

    public void pr(boolean z) {
        this.pr = z;
    }

    public void pr(pr prVar) {
        this.hw = prVar;
    }

    public void pr(int i) {
        this.hn = i;
    }

    public void hw(int i) {
        this.x = i;
    }

    public void hn(int i) {
        this.c = i;
    }

    public void x(int i) {
        this.uc = i;
    }

    public void pr(String str) {
        this.fw = str;
    }

    public void hw(String str) {
        this.zo = str;
    }

    public int pr() {
        return this.aj;
    }

    public void c(int i) {
        this.aj = i;
    }

    public void hn(String str) {
        this.vk = str;
    }

    public void pr(long j) {
        this.w = j;
    }

    public void pr(hw hwVar) {
        this.g = hwVar;
    }

    public void x(String str) {
        this.ho = str;
    }

    public void c(String str) {
        this.k = str;
    }

    public String hw() {
        return this.m;
    }

    public void uc(String str) {
        this.m = str;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 432, 169})
    public static class pr {
        public String aj;
        public String c;
        public List<C0236pr> fw;
        public long hn;
        public String hw;
        public String k;
        public String pr;
        public String uc;
        public String vk;
        public String w;
        public long x;
        public String zo;

        public void pr(String str) {
            this.pr = str;
        }

        public void hw(String str) {
            this.hw = str;
        }

        public void pr(long j) {
            this.hn = j;
        }

        public void hw(long j) {
            this.x = j;
        }

        public void hn(String str) {
            this.c = str;
        }

        public void x(String str) {
            this.uc = str;
        }

        public void c(String str) {
            this.zo = str;
        }

        public void pr(List<C0236pr> list) {
            this.fw = list;
        }

        public void uc(String str) {
            this.aj = str;
        }

        public void fw(String str) {
            this.vk = str;
        }

        public void zo(String str) {
            this.w = str;
        }

        public void aj(String str) {
            this.k = str;
        }

        /* JADX INFO: renamed from: com.byazt.xqu.c$pr$pr, reason: collision with other inner class name */
        @com.byazt.vzx.pr(pr = {0, 1, 432, 935})
        public static class C0236pr {
            public String hw;
            public String pr;

            public void pr(String str) {
                this.pr = str;
            }

            public void hw(String str) {
                this.hw = str;
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 432, 401})
    public static class hw {
        public String hw;
        public int pr;

        public void pr(int i) {
            this.pr = i;
        }

        public void pr(String str) {
            this.hw = str;
        }
    }

    public String toString() {
        return pr(this);
    }

    public static String pr(c cVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_auth", Integer.valueOf(cVar.pr ? 1 : 0));
            jSONObject.putOpt("download_permit", Integer.valueOf(cVar.hn));
            jSONObject.putOpt("appstore_permit", Integer.valueOf(cVar.x));
            jSONObject.putOpt("market_online_status", Integer.valueOf(cVar.c));
            jSONObject.putOpt("hijack_permit", Integer.valueOf(cVar.uc));
            jSONObject.putOpt("package_name", cVar.fw);
            jSONObject.putOpt("hijack_url", cVar.zo);
            jSONObject.putOpt(PluginConstants.KEY_ERROR_CODE, Integer.valueOf(cVar.aj));
            jSONObject.putOpt("message", cVar.vk);
            jSONObject.putOpt("request_duration", Long.valueOf(cVar.w));
            jSONObject.putOpt("auth_info", hw(cVar.hw));
            jSONObject.putOpt(NotificationCompat.CATEGORY_STATUS, hw(cVar.g));
            jSONObject.putOpt("back_web_url", cVar.ho);
            jSONObject.putOpt("hw_app_id", cVar.k);
            jSONObject.putOpt("deep_link", cVar.m);
        } catch (JSONException e) {
            com.byazt.vi.hn.pr().pr(e, "ComplianceResult toJson");
        }
        return jSONObject.toString();
    }

    public static c fw(String str) {
        c cVar = new c();
        try {
            JSONObject jSONObject = new JSONObject(str);
            pr prVarPr = pr(jSONObject);
            hw hwVarHw = hw(jSONObject);
            cVar.pr(prVarPr);
            cVar.pr(hwVarHw);
            cVar.pr(jSONObject.optInt("show_auth", 0) == 1);
            cVar.pr(jSONObject.optInt("download_permit"));
            cVar.hw(jSONObject.optInt("appstore_permit"));
            cVar.hn(jSONObject.optInt("market_online_status", 15));
            cVar.x(jSONObject.optInt("hijack_permit"));
            cVar.pr(jSONObject.optString("package_name"));
            cVar.hw(jSONObject.optString("hijack_url"));
            cVar.c(jSONObject.optInt(PluginConstants.KEY_ERROR_CODE));
            cVar.hn(jSONObject.optString("message"));
            cVar.pr(jSONObject.optLong("request_duration", 0L));
            cVar.x(jSONObject.optString("back_web_url"));
            cVar.c(jSONObject.optString("hw_app_id"));
            cVar.uc(jSONObject.optString("deep_link"));
        } catch (Exception e) {
            com.byazt.vi.hn.pr().pr(e, "ComplianceResult fromJson");
        }
        return cVar;
    }

    private static pr pr(JSONObject jSONObject) {
        pr prVar = new pr();
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("auth_info");
            if (jSONObjectOptJSONObject != null) {
                prVar.pr(jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME));
                prVar.hw(jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME));
                prVar.pr(m.pr(jSONObjectOptJSONObject, "update_time"));
                prVar.hw(m.pr(jSONObjectOptJSONObject, "size"));
                prVar.hn(jSONObjectOptJSONObject.optString("developer_name"));
                prVar.x(jSONObjectOptJSONObject.optString("package_name"));
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("permissions");
                if (jSONArrayOptJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    pr(jSONArrayOptJSONArray, arrayList);
                    prVar.pr(arrayList);
                }
                prVar.c(jSONObjectOptJSONObject.optString("permission_classify_url"));
                prVar.uc(jSONObjectOptJSONObject.optString("policy_url"));
                prVar.fw(jSONObjectOptJSONObject.optString("icon_url"));
                prVar.zo(jSONObjectOptJSONObject.optString("download_url"));
                prVar.aj(jSONObjectOptJSONObject.optString("desc_url"));
            }
        } catch (Exception e) {
            com.byazt.vi.hn.pr().pr(e, "ComplianceResult getAuthInfo");
        }
        return prVar;
    }

    private static JSONObject hw(pr prVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (prVar != null) {
            jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, prVar.pr);
            jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, prVar.hw);
            jSONObject.putOpt("update_time", Long.valueOf(prVar.hn));
            jSONObject.putOpt("size", Long.valueOf(prVar.x));
            jSONObject.putOpt("developer_name", prVar.c);
            jSONObject.putOpt("policy_url", prVar.aj);
            jSONObject.putOpt("icon_url", prVar.vk);
            jSONObject.putOpt("download_url", prVar.w);
            jSONObject.putOpt("permissions", hn(prVar));
            jSONObject.putOpt("permission_classify_url", prVar.zo);
            jSONObject.putOpt("desc_url", prVar.k);
        }
        return jSONObject;
    }

    private static hw hw(JSONObject jSONObject) {
        hw hwVar = new hw();
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_STATUS);
            if (jSONObjectOptJSONObject != null) {
                hwVar.pr(jSONObjectOptJSONObject.optInt(NotificationCompat.CATEGORY_STATUS));
                hwVar.pr(jSONObjectOptJSONObject.optString("message"));
            }
        } catch (Exception e) {
            com.byazt.vi.hn.pr().pr(e, "ComplianceResult getStatus");
        }
        return hwVar;
    }

    private static JSONObject hw(hw hwVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (hwVar != null) {
            jSONObject.putOpt(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(hwVar.pr));
            jSONObject.putOpt("message", hwVar.hw);
        }
        return jSONObject;
    }

    private static void pr(JSONArray jSONArray, List<pr.C0236pr> list) {
        if (jSONArray == null || list == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                pr.C0236pr c0236pr = new pr.C0236pr();
                c0236pr.pr(jSONObjectOptJSONObject.optString("permission_name"));
                c0236pr.hw(jSONObjectOptJSONObject.optString("permission_desc"));
                list.add(c0236pr);
            }
        }
    }

    private static JSONArray hn(pr prVar) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        List<pr.C0236pr> list = prVar.fw;
        if (list != null && list.size() > 0) {
            for (pr.C0236pr c0236pr : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("permission_name", c0236pr.pr);
                jSONObject.putOpt("permission_desc", c0236pr.hw);
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }
}
