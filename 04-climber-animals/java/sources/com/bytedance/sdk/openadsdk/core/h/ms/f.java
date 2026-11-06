package com.bytedance.sdk.openadsdk.core.h.ms;

import com.bytedance.sdk.component.widget.SSWebView;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class f extends com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.pc ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private SSWebView f2534ms;
    private String xr;

    public static void ms(com.bytedance.sdk.component.ms.h hVar, SSWebView sSWebView, com.bytedance.sdk.openadsdk.core.pc pcVar) {
        hVar.ms("closeWebview", (com.bytedance.sdk.component.ms.ka<?, ?>) new f(sSWebView, "closeWebview", pcVar));
        hVar.ms("makeVisible", (com.bytedance.sdk.component.ms.ka<?, ?>) new f(sSWebView, "makeVisible", pcVar));
        hVar.ms("getCurrentVisibleState", (com.bytedance.sdk.component.ms.ka<?, ?>) new f(sSWebView, "getCurrentVisibleState", pcVar));
        hVar.ms("changeSize", (com.bytedance.sdk.component.ms.ka<?, ?>) new f(sSWebView, "changeSize", pcVar));
        hVar.ms("changeFrame", (com.bytedance.sdk.component.ms.ka<?, ?>) new f(sSWebView, "changeFrame", pcVar));
    }

    public f(SSWebView sSWebView, String str, com.bytedance.sdk.openadsdk.core.pc pcVar) {
        this.f2534ms = sSWebView;
        this.xr = str;
        this.ah = pcVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.sdk.component.ms.ka
    public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        int iOptInt;
        int iOptInt2;
        int iOptInt3;
        JSONObject jSONObject2 = new JSONObject();
        String str = this.xr;
        str.hashCode();
        switch (str) {
            case "changeSize":
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("size");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() == 2) {
                    int iOptInt4 = jSONArrayOptJSONArray.optInt(0);
                    int iOptInt5 = jSONArrayOptJSONArray.optInt(1);
                    com.bytedance.sdk.openadsdk.core.pc pcVar = this.ah;
                    if (pcVar != null) {
                        pcVar.ms(iOptInt4, iOptInt5);
                    }
                }
                return jSONObject2;
            case "changeFrame":
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("point");
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("size");
                int iOptInt6 = Integer.MAX_VALUE;
                if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() != 2) {
                    iOptInt = Integer.MAX_VALUE;
                    iOptInt2 = Integer.MAX_VALUE;
                } else {
                    iOptInt2 = jSONArrayOptJSONArray2.optInt(0);
                    iOptInt = jSONArrayOptJSONArray2.optInt(1);
                }
                if (jSONArrayOptJSONArray3 == null || jSONArrayOptJSONArray3.length() != 2) {
                    iOptInt3 = Integer.MAX_VALUE;
                } else {
                    iOptInt6 = jSONArrayOptJSONArray3.optInt(0);
                    iOptInt3 = jSONArrayOptJSONArray3.optInt(1);
                }
                com.bytedance.sdk.openadsdk.core.pc pcVar2 = this.ah;
                if (pcVar2 != null) {
                    pcVar2.ms(iOptInt2, iOptInt, iOptInt6, iOptInt3);
                }
                return jSONObject2;
            case "getCurrentVisibleState":
                jSONObject2.put("visibleState", !com.bytedance.sdk.openadsdk.core.f.xr(this.f2534ms, 50, 5) ? 1 : 0);
                return jSONObject2;
            case "closeWebview":
                com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.h.ms.f.1
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.f2534ms.setVisibility(8);
                    }
                });
                com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ny nyVarAh = this.ah.ah();
                if (nyVarAh != null) {
                    nyVarAh.xr();
                    jSONObject2.put("success", true);
                } else {
                    jSONObject2.put("success", false);
                }
                return jSONObject2;
            case "makeVisible":
                if (this.f2534ms != null) {
                    jSONObject2.put("success", true);
                    com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.h.ms.f.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.f2534ms != null) {
                                f.this.f2534ms.setVisibility(0);
                            }
                            com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ny nyVarAh2 = f.this.ah.ah();
                            if (nyVarAh2 != null) {
                                nyVarAh2.G_();
                            }
                        }
                    });
                } else {
                    jSONObject2.put("success", false);
                }
                return jSONObject2;
            default:
                return jSONObject2;
        }
    }
}
