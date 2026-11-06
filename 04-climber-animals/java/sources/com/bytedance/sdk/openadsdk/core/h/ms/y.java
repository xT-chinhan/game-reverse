package com.bytedance.sdk.openadsdk.core.h.ms;

import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class y extends com.bytedance.sdk.component.ms.d<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private WeakReference<com.bytedance.sdk.openadsdk.core.pc> f2563ms;

    public y(com.bytedance.sdk.openadsdk.core.pc pcVar) {
        this.f2563ms = new WeakReference<>(pcVar);
    }

    public static void ms(com.bytedance.sdk.component.ms.h hVar, final com.bytedance.sdk.openadsdk.core.pc pcVar) {
        hVar.ms("mallTopbarClick", new com.bytedance.sdk.component.ms.d.xr() { // from class: com.bytedance.sdk.openadsdk.core.h.ms.y.1
            @Override // com.bytedance.sdk.component.ms.d.xr
            public com.bytedance.sdk.component.ms.d ms() {
                return new y(pcVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.ms.d
    public void ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.ch.ub().fm();
        WeakReference<com.bytedance.sdk.openadsdk.core.pc> weakReference = this.f2563ms;
        if (weakReference == null) {
            return;
        }
        if (weakReference.get() == null || jSONObject == null) {
            ah();
            return;
        }
        String strOptString = jSONObject.optString("schema");
        if (strOptString.isEmpty()) {
            ah();
        } else {
            ms(strOptString, jSONObject.optBoolean("sync_auth", false));
        }
    }

    private void ms(final String str, boolean z) throws JSONException {
        final JSONObject jSONObject = new JSONObject();
        if (2 == com.bytedance.sdk.openadsdk.core.live.xr.ms().ka()) {
            ms(str, jSONObject);
            return;
        }
        int iMs = com.bytedance.sdk.openadsdk.core.live.xr.ms().ms(new com.bytedance.sdk.openadsdk.core.live.xr.xr() { // from class: com.bytedance.sdk.openadsdk.core.h.ms.y.2
            @Override // com.bytedance.sdk.openadsdk.core.live.xr.xr
            protected void ms(Object obj) {
                if (obj instanceof Map) {
                    Map map = (Map) obj;
                    if (map.containsKey("code")) {
                        Object obj2 = map.get("code");
                        if (obj2 instanceof String) {
                            try {
                                int i = Integer.parseInt((String) obj2);
                                if (i == 1) {
                                    y.this.ms(str, jSONObject);
                                    return;
                                }
                                try {
                                    jSONObject.putOpt("code", Integer.valueOf(i));
                                } catch (JSONException unused) {
                                }
                                y.this.ms(i, "授权失败");
                                y.this.ms(jSONObject);
                                return;
                            } catch (NumberFormatException unused2) {
                            }
                        }
                    }
                }
                try {
                    jSONObject.putOpt("code", -1);
                } catch (JSONException unused3) {
                }
                y.this.ms(-1, "授权失败");
                y.this.ms(jSONObject);
            }
        }, z);
        jSONObject.putOpt("code", Integer.valueOf(iMs));
        if (iMs != 1) {
            ms(iMs, "执行授权失败");
            ms(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(String str, JSONObject jSONObject) {
        int iMs = com.bytedance.sdk.openadsdk.core.live.xr.ms().ms(str);
        try {
            jSONObject.putOpt("code", Integer.valueOf(iMs));
        } catch (JSONException unused) {
        }
        if (iMs != 1) {
            ms(iMs, "schema 解析失败");
        }
        ms(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i, String str) {
        com.bytedance.sdk.component.utils.sl.xr("MallTopBarClickMethod", "code = " + i + ", msg = " + str);
        com.bytedance.sdk.component.utils.op.ms(com.bytedance.sdk.openadsdk.core.re.getContext(), "努力加载中，请稍后再试", 1);
    }

    @Override // com.bytedance.sdk.component.ms.d
    protected void d() {
        this.f2563ms = null;
    }
}
