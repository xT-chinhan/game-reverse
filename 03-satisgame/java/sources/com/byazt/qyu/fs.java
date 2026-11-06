package com.byazt.qyu;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.anythink.core.common.d.i;
import com.anythink.core.common.l.f;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.JProtect;
import com.qq.e.comm.pi.ACTD;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1178, 101})
public class fs implements Runnable {
    public final Context n;
    public final Map<String, String> q = w.qg();
    public String qg;
    public String s;

    public fs(Context context) {
        this.n = context;
    }

    public void n() throws Throwable {
        if (com.byazt.eh.l.n(this.n)) {
            run();
        }
    }

    @Override // java.lang.Runnable
    @JProtect
    public void run() throws Throwable {
        l.n("plugin_download", "start run");
        String strN = com.byazt.jn.s.n().n(true, "https://api-access.pangolin-sdk-toutiao.com/api/ad/union/sdk/settings/plugins", com.byazt.eh.qg.n(qg()).toString().getBytes());
        if (strN == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strN);
            if (jSONObject.optInt("cypher") == 3) {
                String strQg = com.byazt.eh.qg.qg(jSONObject.optString("message"));
                if (TextUtils.isEmpty(strQg)) {
                    return;
                }
                s.n(this.n).n(n(new JSONObject(strQg).optJSONArray("plugins")));
            }
        } catch (JSONException e) {
            l.n("plugin_download", "failed:".concat(String.valueOf(e)));
        }
    }

    @JProtect
    private JSONObject qg() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("conn_type", com.byazt.eh.l.qg(this.n));
            jSONObject.put(TapEventParamConstants.PARAM_SUB_OS, 1);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("sdk_version", "7.8.1.4");
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.8.1.4");
            jSONObject.put("app_version", q());
            jSONObject.put("package_name", this.s);
            jSONObject.put("vendor", Build.MANUFACTURER);
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            String str = this.q.get(ACTD.APPID_KEY);
            jSONObject.put("ts", jCurrentTimeMillis);
            jSONObject.put("app_id", str);
            jSONObject.put("req_sign", com.byazt.eh.q.n(str != null ? str.concat(String.valueOf(jCurrentTimeMillis)).concat("7.8.1.4") : ""));
            jSONObject.put("channel", "main");
            jSONObject.put("imei", this.q.get("imei"));
            jSONObject.put("source", 0);
            jSONObject.put("device_abi", com.byazt.zi.qg.n());
            jSONObject.put("pl_update_type", com.byazt.eh.s.qg() ? 2 : 1);
            jSONObject.put("plugins", s());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONObject s() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("app_id", this.q.get(ACTD.APPID_KEY));
        jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, "7.8.1.4");
        jSONObject2.put("sdk_version", "7.8.1.4");
        jSONObject2.put("plugin_update_network", "2");
        jSONObject.put("com.byted.pangle", jSONObject2);
        return jSONObject;
    }

    private String q() {
        Context context;
        if (TextUtils.isEmpty(this.qg) && (context = this.n) != null) {
            try {
                this.s = context.getPackageName();
                this.qg = this.n.getPackageManager().getPackageInfo(this.s, 0).versionName;
            } catch (Throwable unused) {
            }
        }
        return this.qg;
    }

    private List<n> n(JSONArray jSONArray) {
        l.n("plugin_download", "parse start");
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                n nVar = new n();
                nVar.n = jSONObjectOptJSONObject.optString("package_name");
                nVar.qg = jSONObjectOptJSONObject.optInt("version_code");
                nVar.s = jSONObjectOptJSONObject.optString(SDMAdConst.NETWORK_CUSTOM_KEY.DOWNLOAD_URL);
                nVar.q = jSONObjectOptJSONObject.optString(f.Y);
                nVar.w = n(jSONObjectOptJSONObject.optString("min_version"));
                nVar.x = n(jSONObjectOptJSONObject.optString("max_version"));
                nVar.fs = jSONObjectOptJSONObject.optInt("plugin_update_network");
                arrayList.add(nVar);
                l.n("plugin_download", "parse " + i + " : " + nVar);
            }
        }
        return arrayList;
    }

    private int n(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Integer.parseInt(str.replace(i.E, ""));
            }
        } catch (NumberFormatException unused) {
        }
        return 0;
    }

    @com.byazt.cp.n(n = {0, 1, 1178, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO})
    static final class n {
        public int fs;
        public String l;
        public String n;
        public String q;
        public int qg;
        public String rv;
        public String s;
        public boolean tj;
        public int w;
        public int x;

        public String toString() {
            try {
                return new JSONObject().put("package_name", this.n).put("version_code", this.qg).put(f.Y, this.q).put("max_version", this.x).put("min_version", this.w).put("is_revert", this.tj).put("md5", this.l).put("plugin_file", this.rv).toString();
            } catch (JSONException unused) {
                return "";
            }
        }
    }
}
