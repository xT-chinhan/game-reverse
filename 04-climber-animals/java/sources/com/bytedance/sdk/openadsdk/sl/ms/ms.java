package com.bytedance.sdk.openadsdk.sl.ms;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.component.xr.ms.ch;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms {
    protected String ab;
    protected String ah;
    protected JSONObject c;
    public AtomicBoolean d = new AtomicBoolean(false);
    public AtomicBoolean ka = new AtomicBoolean(false);

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.sl.ms f4101ms;
    protected String xr;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.sl.ms.ms$ms, reason: collision with other inner class name */
    public interface InterfaceC0337ms {
        void ms(boolean z, Map<String, Object> map);
    }

    public abstract void ah();

    public abstract void ms();

    public abstract void ms(Context context, String str, com.bytedance.sdk.openadsdk.sl.xr xrVar, WebResourceResponse webResourceResponse, ch chVar, Map<String, Object> map);

    public abstract void ms(com.bytedance.sdk.openadsdk.sl.xr xrVar, WebResourceResponse webResourceResponse, ch chVar, InterfaceC0337ms interfaceC0337ms);

    public abstract void ms(String str);

    public abstract void ms(String str, String str2);

    protected abstract void ms(JSONObject jSONObject, String str, ch chVar, String str2, String str3, Map<String, String> map, Map<String, Object> map2);

    public abstract boolean ms(WebView webView);

    public abstract boolean ms(ch chVar);

    public abstract void xr(Context context, String str, com.bytedance.sdk.openadsdk.sl.xr xrVar, WebResourceResponse webResourceResponse, ch chVar, Map<String, Object> map);

    public void xr() {
        ms();
    }

    public ms(com.bytedance.sdk.openadsdk.sl.ms msVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        this.f4101ms = msVar;
        this.xr = str;
        this.ab = str4;
        this.ah = str2;
        JSONObject jSONObject2 = new JSONObject();
        this.c = jSONObject2;
        try {
            if (this instanceof xr) {
                jSONObject2.putOpt("log_extra", str3);
                this.c.putOpt("resource_type", "union");
                this.c.putOpt("ts", Long.valueOf(System.currentTimeMillis() / 1000));
            } else if (this instanceof ah) {
                jSONObject2.putOpt("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
                this.c.putOpt("ad_id", jSONObject.optString("ad_id"));
                this.c.putOpt("customer_id", jSONObject.optString("customer_id"));
            }
            this.c.putOpt("cid", str);
            this.c.putOpt("ac", Integer.valueOf(u.ah(re.getContext())));
            this.c.putOpt("app_name", com.bytedance.sdk.openadsdk.core.ch.ub().nw());
            this.c.putOpt("app_id", com.bytedance.sdk.openadsdk.core.ch.ub().t());
            this.c.putOpt("app_version", com.bytedance.sdk.openadsdk.core.x.ms.d());
            this.c.putOpt("sdk_version", g.ah);
            this.c.putOpt(PluginConstants.KEY_PLUGIN_VERSION, "6.9.2.3");
            this.c.putOpt("platform", "Android");
            this.c.putOpt("device_id", t.ah());
            this.c.putOpt("web_url", str4);
        } catch (JSONException e) {
            sl.ms(e);
        }
        ms(str, str2);
    }
}
