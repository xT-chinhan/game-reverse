package com.bytedance.sdk.openadsdk.core.p.xr;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.hi;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.p.d;
import com.bytedance.sdk.openadsdk.core.p.x;
import com.bytedance.sdk.openadsdk.core.p.xr;
import com.bytedance.sdk.openadsdk.op.ab;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private boolean ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private SSWebView f3253ms;
    private Context xr;

    public ms(SSWebView sSWebView, Context context, boolean z) {
        this.f3253ms = sSWebView;
        this.xr = context;
        this.ah = z;
    }

    @JavascriptInterface
    public String sendNetworkSwitch(final String str) {
        sl.ms("transmit_TTWifiObject", "send_switch PhoneNumStatus:" + this.ah + "  params:" + str);
        if (!this.ah) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", "没有wifi网络下获取手机号权限");
            } catch (JSONException unused) {
            }
            SSWebView sSWebView = this.f3253ms;
            if (sSWebView != null) {
                hi.ms(sSWebView, "javascript:receiveNetworkSwitch(" + jSONObject + ")");
            }
            return "";
        }
        ab.ms(new ny("send_network_switch") { // from class: com.bytedance.sdk.openadsdk.core.p.xr.ms.1
            @Override // java.lang.Runnable
            public void run() {
                if (ms.this.xr == null) {
                    return;
                }
                new x(ms.this.xr, new xr()).ms(str, new d() { // from class: com.bytedance.sdk.openadsdk.core.p.xr.ms.1.1
                    @Override // com.bytedance.sdk.openadsdk.core.p.d
                    public void ms(int i, Map<String, List<String>> map, String str2) {
                        sl.ms("transmit_TTWifiObject", "TransmitBusiness_onResponse code:" + i + "  body:" + str2);
                        if (TextUtils.isEmpty(str2)) {
                            sl.ms("transmit_TTWifiObject", "TransmitBusiness_onResponse body is null and code:".concat(String.valueOf(i)));
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        if (str2 == null) {
                            str2 = "";
                        }
                        try {
                            jSONObject2.put("data", str2);
                        } catch (JSONException unused2) {
                        }
                        if (ms.this.f3253ms != null) {
                            hi.ms(ms.this.f3253ms, "javascript:receiveNetworkSwitch(" + jSONObject2 + ")");
                        }
                    }
                });
            }
        });
        return "";
    }
}
