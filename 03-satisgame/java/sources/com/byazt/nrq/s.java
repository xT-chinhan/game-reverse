package com.byazt.nrq;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.byazt.tbt.tj;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DANGER_BUFFER_THRESHOLD, 8})
public class s extends n {
    public String fs;

    @Override // com.byazt.nrq.n
    public void n(Context context, String str, com.byazt.lew.qg qgVar, WebResourceResponse webResourceResponse, tj tjVar, Map<String, Object> map) {
    }

    @Override // com.byazt.nrq.n
    public void n(String str, String str2) {
    }

    @Override // com.byazt.nrq.n
    public void n(JSONObject jSONObject, String str, tj tjVar, String str2, String str3, Map<String, String> map, Map<String, Object> map2) {
    }

    @Override // com.byazt.nrq.n
    public boolean n(WebView webView) {
        return true;
    }

    @Override // com.byazt.nrq.n
    public boolean n(tj tjVar) {
        return true;
    }

    @Override // com.byazt.nrq.n
    public void qg(Context context, String str, com.byazt.lew.qg qgVar, WebResourceResponse webResourceResponse, tj tjVar, Map<String, Object> map) {
    }

    @Override // com.byazt.nrq.n
    public void n() {
        try {
            this.w.putOpt("req_id", this.s);
            this.w.put(this.fs, new JSONArray());
        } catch (Exception unused) {
        }
    }

    public s(com.byazt.lew.n nVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        super(nVar, str, str2, jSONObject, str3, str4);
        this.fs = "inspect_data";
    }

    @Override // com.byazt.nrq.n
    public void s() {
        this.n.n(new Runnable() { // from class: com.byazt.nrq.s.1
            @Override // java.lang.Runnable
            public void run() {
                s.this.q();
            }
        });
    }

    public void q() {
        if (this.w == null) {
            return;
        }
        com.byazt.eji.s.n().n(this.w, this.w.optString("req_id"));
    }

    @Override // com.byazt.nrq.n
    public void n(String str) {
        int i = this.n.qg().get();
        JSONArray jSONArrayOptJSONArray = this.w.optJSONArray(this.fs);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("jump_number", i);
            jSONObject.put("jump_url", str);
            jSONArrayOptJSONArray.put(jSONObject);
            this.w.put("inspect_data", jSONArrayOptJSONArray);
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.nrq.n
    public void n(com.byazt.lew.qg qgVar, WebResourceResponse webResourceResponse, tj tjVar, n.InterfaceC0272n interfaceC0272n) {
        Uri uriN = qgVar.n();
        if (uriN != null) {
            try {
                String string = uriN.toString();
                String lowerCase = "unknown";
                if (tjVar != null && tjVar.qg() != null) {
                    lowerCase = tjVar.qg().trim().toLowerCase();
                }
                JSONObject jSONObjectL = l();
                if (jSONObjectL != null) {
                    JSONArray jSONArrayOptJSONArray = jSONObjectL.optJSONArray(lowerCase);
                    if (jSONArrayOptJSONArray == null) {
                        jSONArrayOptJSONArray = new JSONArray();
                    }
                    jSONArrayOptJSONArray.put(string);
                    jSONObjectL.putOpt(lowerCase, jSONArrayOptJSONArray);
                } else {
                    k.qg("weblp", "error pageCountJson is null");
                }
            } catch (Exception e) {
                k.n("weblp", "error", e);
            }
        }
        interfaceC0272n.n(false, null);
    }

    public JSONObject l() {
        try {
            int i = this.n.qg().get();
            JSONArray jSONArrayOptJSONArray = this.w.optJSONArray(this.fs);
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
        } catch (Exception unused) {
        }
        return null;
    }
}
