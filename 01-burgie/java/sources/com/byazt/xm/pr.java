package com.byazt.xm;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.byazt.ca.yb;
import com.byazt.mg.PluginConstants;
import com.byazt.nzn.vk;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.sd.zo;
import com.byazt.wt.nt;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1371, 37})
public abstract class pr {
    public String fw;
    public String hn;
    public String hw;
    public com.byazt.mv.pr pr;
    public JSONObject uc;
    public AtomicBoolean x = new AtomicBoolean(false);
    public AtomicBoolean c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.byazt.xm.pr$pr, reason: collision with other inner class name */
    public interface InterfaceC0235pr {
        void pr(boolean z, Map<String, Object> map);
    }

    public abstract void hn();

    public abstract void hw(Context context, String str, com.byazt.mv.hw hwVar, WebResourceResponse webResourceResponse, vk vkVar, Map<String, Object> map);

    public abstract void pr();

    public abstract void pr(Context context, String str, com.byazt.mv.hw hwVar, WebResourceResponse webResourceResponse, vk vkVar, Map<String, Object> map);

    public abstract void pr(com.byazt.mv.hw hwVar, WebResourceResponse webResourceResponse, vk vkVar, InterfaceC0235pr interfaceC0235pr);

    public abstract void pr(String str);

    public abstract void pr(String str, String str2);

    public abstract void pr(JSONObject jSONObject, String str, vk vkVar, String str2, String str3, Map<String, String> map, Map<String, Object> map2);

    public abstract boolean pr(WebView webView);

    public abstract boolean pr(vk vkVar);

    public void hw() {
        pr();
    }

    public pr(com.byazt.mv.pr prVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        this.fw = "";
        this.pr = prVar;
        this.hw = str;
        this.fw = str4;
        this.hn = str2;
        JSONObject jSONObject2 = new JSONObject();
        this.uc = jSONObject2;
        try {
            if (this instanceof hw) {
                jSONObject2.putOpt("log_extra", str3);
                this.uc.putOpt("resource_type", "union");
                this.uc.putOpt("ts", Long.valueOf(System.currentTimeMillis() / 1000));
            } else if (this instanceof hn) {
                jSONObject2.putOpt("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
                this.uc.putOpt(MediationConstant.EXTRA_ADID, jSONObject.optString(MediationConstant.EXTRA_ADID));
                this.uc.putOpt("customer_id", jSONObject.optString("customer_id"));
            }
            this.uc.putOpt("cid", str);
            this.uc.putOpt("ac", Integer.valueOf(yb.hn(a.getContext())));
            this.uc.putOpt(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, zo.nt().fo());
            this.uc.putOpt(PluginConstants.KEY_APP_ID, zo.nt().ny());
            this.uc.putOpt("app_version", com.byazt.hb.pr.c());
            this.uc.putOpt("sdk_version", iu.c);
            this.uc.putOpt(PluginConstants.KEY_PLUGIN_VERSION, "7.7.1.4");
            this.uc.putOpt("platform", "Android");
            this.uc.putOpt("device_id", nt.pr());
            this.uc.putOpt("web_url", str4);
        } catch (JSONException e) {
        }
        pr(str, str2);
    }
}
