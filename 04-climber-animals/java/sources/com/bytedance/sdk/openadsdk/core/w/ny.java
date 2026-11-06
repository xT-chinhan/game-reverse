package com.bytedance.sdk.openadsdk.core.w;

import android.content.Context;
import com.anythink.core.common.m.e;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.bytedance.sdk.openadsdk.core.t.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ny {
    public abstract void ms(int i, x xVar);

    public abstract JSONObject xr(Context context);

    public abstract boolean xr();

    public void ms(Context context) {
        ah ahVar;
        if (xr() && (ahVar = (ah) AutoService.ms(ah.class)) != null && ahVar.ah()) {
            final JSONObject jSONObjectXr = xr(context);
            ahVar.ms(e.Y, jSONObjectXr, new EventListener() { // from class: com.bytedance.sdk.openadsdk.core.w.ny.1
                @Override // com.bykv.vk.openvk.api.proto.EventListener
                public ValueSet onEvent(int i, Result result) {
                    u.ms();
                    u.ms(result, jSONObjectXr);
                    ny.this.ms(i, new x(result, i));
                    return null;
                }
            });
        }
    }
}
