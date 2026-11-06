package com.byazt.nrq;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.byazt.ehw.l;
import com.byazt.nf.rv;
import com.byazt.qyu.PluginConstants;
import com.byazt.tbt.tj;
import com.byazt.tk.hd;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DANGER_BUFFER_THRESHOLD, 19})
public abstract class n {
    public com.byazt.lew.n n;
    public String qg;
    public String s;
    public JSONObject w;
    public String x;
    public AtomicBoolean q = new AtomicBoolean(false);
    public AtomicBoolean l = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.byazt.nrq.n$n, reason: collision with other inner class name */
    public interface InterfaceC0272n {
        void n(boolean z, Map<String, Object> map);
    }

    public abstract void n();

    public abstract void n(Context context, String str, com.byazt.lew.qg qgVar, WebResourceResponse webResourceResponse, tj tjVar, Map<String, Object> map);

    public abstract void n(com.byazt.lew.qg qgVar, WebResourceResponse webResourceResponse, tj tjVar, InterfaceC0272n interfaceC0272n);

    public abstract void n(String str);

    public abstract void n(String str, String str2);

    public abstract void n(JSONObject jSONObject, String str, tj tjVar, String str2, String str3, Map<String, String> map, Map<String, Object> map2);

    public abstract boolean n(WebView webView);

    public abstract boolean n(tj tjVar);

    public abstract void qg(Context context, String str, com.byazt.lew.qg qgVar, WebResourceResponse webResourceResponse, tj tjVar, Map<String, Object> map);

    public abstract void s();

    public void qg() {
        n();
    }

    public n(com.byazt.lew.n nVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        this.n = nVar;
        this.qg = str;
        this.x = str4;
        this.s = str2;
        JSONObject jSONObject2 = new JSONObject();
        this.w = jSONObject2;
        try {
            if (this instanceof qg) {
                jSONObject2.putOpt("log_extra", str3);
                this.w.putOpt("resource_type", "union");
                this.w.putOpt("ts", Long.valueOf(System.currentTimeMillis() / 1000));
            } else if (this instanceof s) {
                jSONObject2.putOpt(TapEventParamConstants.PARAM_SUB_TIMESTAMP, Long.valueOf(System.currentTimeMillis() / 1000));
                this.w.putOpt(MediationConstant.EXTRA_ADID, jSONObject.optString(MediationConstant.EXTRA_ADID));
                this.w.putOpt("customer_id", jSONObject.optString("customer_id"));
            }
            this.w.putOpt("cid", str);
            this.w.putOpt("ac", Integer.valueOf(hd.s(rv.getContext())));
            this.w.putOpt("app_name", com.byazt.vyf.s.cy().wm());
            this.w.putOpt("app_id", com.byazt.vyf.s.cy().ou());
            this.w.putOpt("app_version", com.byazt.ges.qg.l());
            this.w.putOpt("sdk_version", com.byazt.nf.tj.w);
            this.w.putOpt(PluginConstants.KEY_PLUGIN_VERSION, "7.8.1.4");
            this.w.putOpt("platform", "Android");
            this.w.putOpt(TapEventParamConstants.PARAM_DEVICE_ID, l.n());
            this.w.putOpt("web_url", str4);
        } catch (JSONException unused) {
        }
        n(str, str2);
    }
}
