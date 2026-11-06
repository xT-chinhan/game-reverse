package com.bytedance.sdk.openadsdk.core.w;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.bytedance.sdk.openadsdk.core.jw;
import com.bytedance.sdk.openadsdk.core.re;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ch {
    public static boolean ms() {
        JSONObject jSONObjectCe = re.xr().ce();
        return jSONObjectCe != null && jSONObjectCe.optInt("video_cache", 0) == 1;
    }

    public static boolean xr() {
        JSONObject jSONObjectCe = re.xr().ce();
        return jSONObjectCe != null && jSONObjectCe.optInt("pre_drop", 0) == 1;
    }

    public static boolean ah() {
        return com.bytedance.sdk.openadsdk.core.ah.ka.ms().ub() == 1;
    }

    public static void ms(final EventListener eventListener) {
        ah ahVar;
        Bridge bridgeAm = com.bytedance.sdk.openadsdk.core.ch.ub().am();
        if (re.xr().w()) {
            ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(1).ms(0, "com.byted.csj.ext").xr();
            if (((Boolean) bridgeAm.call(6, valueSetXr, Boolean.class)).booleanValue()) {
                if ((((Boolean) bridgeAm.call(7, valueSetXr, Boolean.class)).booleanValue() || jw.ms().ms(bridgeAm, false)) && (ahVar = (ah) AutoService.ms(ah.class)) != null) {
                    ahVar.ms(re.getContext(), new EventListener() { // from class: com.bytedance.sdk.openadsdk.core.w.ch.1
                        @Override // com.bykv.vk.openvk.api.proto.EventListener
                        public ValueSet onEvent(int i, Result result) {
                            EventListener eventListener2 = eventListener;
                            if (eventListener2 == null) {
                                return null;
                            }
                            eventListener2.onEvent(i, result);
                            return null;
                        }
                    });
                }
            }
        }
    }
}
