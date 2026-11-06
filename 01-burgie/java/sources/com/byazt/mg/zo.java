package com.byazt.mg;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.JProtect;
import com.qq.e.comm.pi.ACTD;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 860, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo implements Runnable {
    public String hn;
    public String hw;
    public final Context pr;
    public final Map<String, String> x = uc.hw();

    public zo(Context context) {
        this.pr = context;
    }

    public void pr() throws Throwable {
        if (com.byazt.ud.c.pr(this.pr)) {
            run();
        }
    }

    @Override // java.lang.Runnable
    @JProtect
    public void run() throws Throwable {
        c.pr("plugin_download", "start run");
        String strPr = com.byazt.bj.hn.pr().pr(true, "https://api-access.pangolin-sdk-toutiao.com/api/ad/union/sdk/settings/plugins", com.byazt.ud.hw.pr(hw()).toString().getBytes());
        if (strPr == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strPr);
            if (jSONObject.optInt("cypher") == 3) {
                String strHw = com.byazt.ud.hw.hw(jSONObject.optString("message"));
                if (!TextUtils.isEmpty(strHw)) {
                    hn.pr(this.pr).pr(pr(new JSONObject(strHw).optJSONArray("plugins")));
                }
            }
        } catch (JSONException e) {
            c.pr("plugin_download", "failed:".concat(String.valueOf(e)));
        }
    }

    @JProtect
    private JSONObject hw() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("conn_type", com.byazt.ud.c.hw(this.pr));
            jSONObject.put("os", 1);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("sdk_version", "7.7.1.4");
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.7.1.4");
            jSONObject.put("app_version", x());
            jSONObject.put("package_name", this.hn);
            jSONObject.put("vendor", Build.MANUFACTURER);
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            String str = this.x.get(ACTD.APPID_KEY);
            jSONObject.put("ts", jCurrentTimeMillis);
            jSONObject.put(PluginConstants.KEY_APP_ID, str);
            String strConcat = "";
            if (str != null) {
                strConcat = str.concat(String.valueOf(jCurrentTimeMillis)).concat("7.7.1.4");
            }
            jSONObject.put("req_sign", com.byazt.ud.x.pr(strConcat));
            jSONObject.put("channel", "main");
            jSONObject.put("imei", this.x.get("imei"));
            jSONObject.put("source", 0);
            if (Build.VERSION.SDK_INT >= 21) {
                jSONObject.put("device_abi", com.byazt.wo.hw.pr());
            }
            jSONObject.put("pl_update_type", com.byazt.ud.hn.hw() ? 2 : 1);
            jSONObject.put("plugins", hn());
        } catch (Exception e) {
        }
        return jSONObject;
    }

    private JSONObject hn() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(PluginConstants.KEY_APP_ID, this.x.get(ACTD.APPID_KEY));
        jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, "7.7.1.4");
        jSONObject2.put("sdk_version", "7.7.1.4");
        jSONObject2.put("plugin_update_network", "2");
        jSONObject.put("com.byted.pangle", jSONObject2);
        return jSONObject;
    }

    private String x() {
        Context context;
        if (TextUtils.isEmpty(this.hw) && (context = this.pr) != null) {
            try {
                this.hn = context.getPackageName();
                this.hw = this.pr.getPackageManager().getPackageInfo(this.hn, 0).versionName;
            } catch (Throwable th) {
            }
        }
        return this.hw;
    }

    private List<pr> pr(JSONArray jSONArray) {
        c.pr("plugin_download", "parse start");
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                pr prVar = new pr();
                prVar.pr = jSONObjectOptJSONObject.optString("package_name");
                prVar.hw = jSONObjectOptJSONObject.optInt("version_code");
                prVar.hn = jSONObjectOptJSONObject.optString("download_url");
                prVar.x = jSONObjectOptJSONObject.optString("sign");
                prVar.uc = pr(jSONObjectOptJSONObject.optString("min_version"));
                prVar.fw = pr(jSONObjectOptJSONObject.optString("max_version"));
                prVar.zo = jSONObjectOptJSONObject.optInt("plugin_update_network");
                arrayList.add(prVar);
                c.pr("plugin_download", "parse " + i + " : " + prVar);
            }
        }
        return arrayList;
    }

    private int pr(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            return Integer.parseInt(str.replace(".", ""));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 860, 673})
    static final class pr {
        public String aj;
        public String c;
        public int fw;
        public String hn;
        public int hw;
        public String pr;
        public int uc;
        public boolean vk;
        public String x;
        public int zo;

        public String toString() {
            try {
                return new JSONObject().put("package_name", this.pr).put("version_code", this.hw).put("sign", this.x).put("max_version", this.fw).put("min_version", this.uc).put("is_revert", this.vk).put("md5", this.c).put("plugin_file", this.aj).toString();
            } catch (JSONException e) {
                return "";
            }
        }
    }
}
