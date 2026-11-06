package com.byazt.gc;

import android.os.Build;
import android.text.TextUtils;
import com.byazt.ca.yb;
import com.byazt.hcx.aj;
import com.byazt.hcx.m;
import com.byazt.mg.PluginConstants;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.sd.zo;
import com.byazt.vkw.g;
import com.byazt.vkw.nt;
import com.byazt.wt.DeviceUtils;
import com.byazt.wt.ls;
import com.byazt.wt.rc;
import com.byazt.xlm.c;
import com.byazt.xlm.fw;
import com.byazt.zs.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEBUG_UI_NOTIFY, 13})
public class hw extends fw {
    private hw() {
        super("PluginSettingsFetchTask");
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEBUG_UI_NOTIFY, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    private static class pr {
        public static final hw pr = new hw();
    }

    public static hw hw() {
        return pr.pr;
    }

    public void hn() {
        if (yb.pr(a.getContext())) {
            c.hw(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        aj ajVarX = com.byazt.tf.hn.x(ls.aj("/api/ad/union/sdk/settings/plugins"));
        ajVarX.pr("User-Agent", ((g) uc.pr("device_info_new")).hw(false));
        JSONObject jSONObjectX = x();
        ajVarX.pr(rc.pr(jSONObjectX == null ? null : jSONObjectX.toString()));
        ajVarX.pr(new com.byazt.hcx.fw() { // from class: com.byazt.gc.hw.1
            @Override // com.byazt.hcx.fw
            public void pr(m mVar) {
                if (mVar != null && mVar.fw()) {
                    try {
                        JSONObject jSONObjectC = mVar.c();
                        if (jSONObjectC.optInt("cypher") == 3) {
                            String strX = ((nt) uc.pr("encrypt_service")).x(jSONObjectC.optString("message"));
                            if (!TextUtils.isEmpty(strX)) {
                                hn.pr().pr(new JSONObject(strX).optJSONArray("plugins"));
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }

            @Override // com.byazt.hcx.fw
            public void pr(int i, String str, Throwable th) {
                try {
                    Iterator<String> itKeys = zo.nt().e().keys();
                    while (itKeys.hasNext()) {
                        hn.pr().pr(itKeys.next(), 1007);
                    }
                } catch (Throwable th2) {
                }
            }
        });
    }

    private JSONObject x() {
        JSONObject jSONObject = new JSONObject();
        try {
            uc.pr("device_info_new");
            jSONObject.put("oaid", ((com.byazt.vkw.hn) uc.pr("embed_applog")).pr(false));
            jSONObject.put("conn_type", yb.hw(a.getContext()));
            jSONObject.put("os", 1);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("sdk_version", iu.c);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.7.1.4");
            jSONObject.put("package_name", ls.zo());
            jSONObject.put("app_version", ls.vk());
            jSONObject.put("app_code", ls.aj());
            jSONObject.put("vendor", Build.MANUFACTURER);
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            String strNy = zo.nt().ny();
            jSONObject.put("ts", jCurrentTimeMillis);
            jSONObject.put(PluginConstants.KEY_APP_ID, strNy);
            String strConcat = "";
            if (strNy != null) {
                strConcat = strNy.concat(String.valueOf(jCurrentTimeMillis)).concat(iu.c);
            }
            jSONObject.put("req_sign", com.byazt.ca.c.hw(strConcat));
            jSONObject.put("channel", iu.zo);
            jSONObject.put("applog_did", com.byazt.sd.uc.pr().hw());
            jSONObject.put("imei", DeviceUtils.pr((Boolean) null));
            jSONObject.put("source", 1);
            if (Build.VERSION.SDK_INT >= 21) {
                jSONObject.put("device_abi", com.byazt.sp.hw.pr());
            }
            jSONObject.put("plugins", c());
            jSONObject.put("csj_type", zo.nt().v() ? 1 : 0);
        } catch (Throwable th) {
        }
        return jSONObject;
    }

    private JSONObject c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectE = zo.nt().e();
        boolean zOb = a.hw().ob();
        if (jSONObjectE != null) {
            Iterator<String> itKeys = jSONObjectE.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!TextUtils.isEmpty(next)) {
                    JSONObject jSONObjectOptJSONObject = jSONObjectE.optJSONObject(next);
                    if (jSONObjectOptJSONObject != null) {
                        jSONObjectOptJSONObject.put("plugin_update_network", zo.nt().b().pr(next));
                    }
                    if (zOb && next.equals("com.byted.live.lite")) {
                        jSONObject.putOpt(hn.hw(), jSONObjectOptJSONObject);
                    } else {
                        jSONObject.putOpt(next, jSONObjectOptJSONObject);
                    }
                }
            }
        }
        return jSONObject;
    }
}
