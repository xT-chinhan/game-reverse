package com.bytedance.sdk.openadsdk.sl.ms;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.xr.ms.ch;
import com.bytedance.sdk.openadsdk.core.t.u;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends ms {
    private String x;

    @Override // com.bytedance.sdk.openadsdk.sl.ms.ms
    public void ms(Context context, String str, com.bytedance.sdk.openadsdk.sl.xr xrVar, WebResourceResponse webResourceResponse, ch chVar, Map<String, Object> map) {
    }

    @Override // com.bytedance.sdk.openadsdk.sl.ms.ms
    public void ms(String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.sl.ms.ms
    protected void ms(JSONObject jSONObject, String str, ch chVar, String str2, String str3, Map<String, String> map, Map<String, Object> map2) {
    }

    @Override // com.bytedance.sdk.openadsdk.sl.ms.ms
    public boolean ms(WebView webView) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.sl.ms.ms
    public boolean ms(ch chVar) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.sl.ms.ms
    public void xr(Context context, String str, com.bytedance.sdk.openadsdk.sl.xr xrVar, WebResourceResponse webResourceResponse, ch chVar, Map<String, Object> map) {
    }

    @Override // com.bytedance.sdk.openadsdk.sl.ms.ms
    public void ms() {
        try {
            this.c.putOpt("req_id", this.ah);
            this.c.put(this.x, new JSONArray());
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    public ah(com.bytedance.sdk.openadsdk.sl.ms msVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        super(msVar, str, str2, jSONObject, str3, str4);
        this.x = "inspect_data";
    }

    @Override // com.bytedance.sdk.openadsdk.sl.ms.ms
    public void ah() {
        this.f4101ms.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.sl.ms.ah.1
            @Override // java.lang.Runnable
            public void run() {
                ah.this.d();
            }
        });
    }

    public void d() {
        if (this.c == null) {
            return;
        }
        u.ms().ah(this.c.toString(), this.c.optString("req_id"));
    }

    @Override // com.bytedance.sdk.openadsdk.sl.ms.ms
    public void ms(String str) {
        int i = this.f4101ms.xr().get();
        JSONArray jSONArrayOptJSONArray = this.c.optJSONArray(this.x);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("jump_number", i);
            jSONObject.put("jump_url", str);
            jSONArrayOptJSONArray.put(jSONObject);
            this.c.put("inspect_data", jSONArrayOptJSONArray);
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.sl.ms.ms
    public void ms(com.bytedance.sdk.openadsdk.sl.xr xrVar, WebResourceResponse webResourceResponse, ch chVar, ms.InterfaceC0337ms interfaceC0337ms) {
        Uri uriMs = xrVar.ms();
        if (uriMs != null) {
            try {
                String string = uriMs.toString();
                String lowerCase = "unknown";
                if (chVar != null && chVar.xr() != null) {
                    lowerCase = chVar.xr().trim().toLowerCase();
                }
                JSONObject jSONObjectKa = ka();
                if (jSONObjectKa != null) {
                    JSONArray jSONArrayOptJSONArray = jSONObjectKa.optJSONArray(lowerCase);
                    if (jSONArrayOptJSONArray == null) {
                        jSONArrayOptJSONArray = new JSONArray();
                    }
                    jSONArrayOptJSONArray.put(string);
                    jSONObjectKa.putOpt(lowerCase, jSONArrayOptJSONArray);
                } else {
                    sl.d("weblp", "error pageCountJson is null");
                }
            } catch (Exception e) {
                sl.ms(e);
                sl.ah("weblp", "error", e);
            }
        }
        interfaceC0337ms.ms(false, null);
    }

    public JSONObject ka() {
        try {
            int i = this.f4101ms.xr().get();
            JSONArray jSONArrayOptJSONArray = this.c.optJSONArray(this.x);
            if (jSONArrayOptJSONArray == null) {
                return null;
            }
            int length = jSONArrayOptJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i2);
                int iOptInt = jSONObject.optInt("jump_number", -1);
                if (iOptInt != -1 && iOptInt == i) {
                    return jSONObject;
                }
            }
        } catch (Exception e) {
            sl.ms(e);
        }
        return null;
    }
}
