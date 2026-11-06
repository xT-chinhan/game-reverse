package com.bytedance.sdk.openadsdk.core;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.core.nw.ce;
import com.bytedance.sdk.openadsdk.core.nw.e;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface yu<T> {

    public interface ah<T> {
        void ms(int i, String str);

        void ms(T t);
    }

    public interface d {
        void ms(int i, String str);

        void ms(op.ah ahVar);
    }

    public interface ka {
        void ms(int i, String str);

        void ms(op.d dVar);
    }

    public interface ms {
        void ms(boolean z, long j, long j2);
    }

    public interface xr {
        void ms(int i, String str, com.bytedance.sdk.openadsdk.core.nw.xr xrVar);

        void ms(com.bytedance.sdk.openadsdk.core.nw.ms msVar, com.bytedance.sdk.openadsdk.core.nw.xr xrVar);
    }

    void ah(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, e eVar, int i, xr xrVar2);

    com.bytedance.sdk.component.adexpress.ms.ah.ms ms(int i);

    com.bytedance.sdk.openadsdk.core.nw.d ms(lm lmVar, String str);

    String ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar);

    String ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, boolean z, int i);

    void ms(Bridge bridge);

    void ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, e eVar, int i, xr xrVar2);

    void ms(com.bytedance.sdk.openadsdk.core.dislike.ah.xr xrVar, List<com.bytedance.sdk.openadsdk.ao.xr.xr.c> list);

    void ms(ce ceVar, String str, String str2, ah ahVar, int i, long j);

    void ms(String str);

    void ms(String str, String str2, ms msVar);

    void ms(List<com.bytedance.sdk.openadsdk.core.ka.xr.d> list, com.bytedance.sdk.openadsdk.core.ka.xr.xr xrVar);

    void ms(Map<String, Object> map, Bridge bridge);

    void ms(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.ka.xr.xr xrVar);

    void ms(JSONObject jSONObject, ah<com.bytedance.sdk.component.ny.xr> ahVar);

    void ms(JSONObject jSONObject, d dVar);

    void ms(JSONObject jSONObject, ka kaVar);

    void xr(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, e eVar, int i, xr xrVar2);
}
