package com.bytedance.sdk.openadsdk.core.w;

import android.content.Context;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bytedance.sdk.openadsdk.ats.ATSApi;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@ATSApi("pitaya")
public interface ah {
    @ATSMethod(2)
    boolean ah();

    @ATSMethod(3)
    boolean d();

    @ATSMethod(1)
    void ms(Context context, EventListener eventListener);

    @ATSMethod(6)
    void ms(String str, EventListener eventListener);

    @ATSMethod(5)
    void ms(String str, com.bytedance.sdk.component.x.ms.xr xrVar);

    @ATSMethod(4)
    void ms(String str, JSONObject jSONObject, EventListener eventListener);
}
