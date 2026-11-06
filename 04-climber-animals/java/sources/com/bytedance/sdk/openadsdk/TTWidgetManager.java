package com.bytedance.sdk.openadsdk;

import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.ao.ms.ms.ub;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TTWidgetManager {
    public abstract boolean updateWidgetWithType(int i, JSONObject jSONObject);

    public static TTWidgetManager create(View view) {
        if (view == null) {
            return null;
        }
        Bridge bridge = view.getTag() instanceof Bridge ? (Bridge) view.getTag() : null;
        if (bridge == null) {
            return null;
        }
        return new ub(bridge);
    }
}
