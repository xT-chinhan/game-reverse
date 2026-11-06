package com.byazt.xm;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.byazt.ca.ho;
import com.byazt.nzn.vk;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1371, 20})
public class hn extends pr {
    public String zo;

    @Override // com.byazt.xm.pr
    public void pr() {
        try {
            this.uc.putOpt("req_id", this.hn);
            this.uc.put(this.zo, new JSONArray());
        } catch (Exception e) {
        }
    }

    public hn(com.byazt.mv.pr prVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        super(prVar, str, str2, jSONObject, str3, str4);
        this.zo = "inspect_data";
    }

    @Override // com.byazt.xm.pr
    public void pr(String str, String str2) {
    }

    @Override // com.byazt.xm.pr
    public boolean pr(WebView webView) {
        return true;
    }

    @Override // com.byazt.xm.pr
    public void pr(Context context, String str, com.byazt.mv.hw hwVar, WebResourceResponse webResourceResponse, vk vkVar, Map<String, Object> map) {
    }

    @Override // com.byazt.xm.pr
    public void hw(Context context, String str, com.byazt.mv.hw hwVar, WebResourceResponse webResourceResponse, vk vkVar, Map<String, Object> map) {
    }

    @Override // com.byazt.xm.pr
    public void pr(JSONObject jSONObject, String str, vk vkVar, String str2, String str3, Map<String, String> map, Map<String, Object> map2) {
    }

    @Override // com.byazt.xm.pr
    public void hn() {
        this.pr.pr(new Runnable() { // from class: com.byazt.xm.hn.1
            @Override // java.lang.Runnable
            public void run() {
                hn.this.x();
            }
        });
    }

    public void x() {
        if (this.uc == null) {
            return;
        }
        com.byazt.xk.hw.pr().pr(this.uc, this.uc.optString("req_id"));
    }

    @Override // com.byazt.xm.pr
    public boolean pr(vk vkVar) {
        return true;
    }

    @Override // com.byazt.xm.pr
    public void pr(String str) {
        int i = this.pr.hw().get();
        JSONArray jSONArrayOptJSONArray = this.uc.optJSONArray(this.zo);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("jump_number", i);
            jSONObject.put("jump_url", str);
            jSONArrayOptJSONArray.put(jSONObject);
            this.uc.put("inspect_data", jSONArrayOptJSONArray);
        } catch (Exception e) {
        }
    }

    @Override // com.byazt.xm.pr
    public void pr(com.byazt.mv.hw hwVar, WebResourceResponse webResourceResponse, vk vkVar, pr.InterfaceC0235pr interfaceC0235pr) {
        Uri uriPr = hwVar.pr();
        if (uriPr != null) {
            try {
                String string = uriPr.toString();
                String lowerCase = "unknown";
                if (vkVar != null && vkVar.hw() != null) {
                    lowerCase = vkVar.hw().trim().toLowerCase();
                }
                JSONObject jSONObjectC = c();
                if (jSONObjectC == null) {
                    ho.hw("weblp", "error pageCountJson is null");
                } else {
                    JSONArray jSONArrayOptJSONArray = jSONObjectC.optJSONArray(lowerCase);
                    if (jSONArrayOptJSONArray == null) {
                        jSONArrayOptJSONArray = new JSONArray();
                    }
                    jSONArrayOptJSONArray.put(string);
                    jSONObjectC.putOpt(lowerCase, jSONArrayOptJSONArray);
                }
            } catch (Exception e) {
                ho.pr("weblp", "error", e);
            }
        }
        interfaceC0235pr.pr(false, null);
    }

    public JSONObject c() {
        try {
            int i = this.pr.hw().get();
            JSONArray jSONArrayOptJSONArray = this.uc.optJSONArray(this.zo);
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
        }
        return null;
    }
}
