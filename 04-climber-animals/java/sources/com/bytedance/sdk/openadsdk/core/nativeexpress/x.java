package com.bytedance.sdk.openadsdk.core.nativeexpress;

import com.bytedance.sdk.openadsdk.core.pc;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class x {
    public static void ms(NativeExpressView nativeExpressView) {
        if (nativeExpressView == null) {
            return;
        }
        pc jsObject = nativeExpressView.getJsObject();
        if (jsObject != null) {
            jsObject.ms("notifyAdClicked", (JSONObject) null);
        }
        com.bytedance.sdk.openadsdk.core.ugeno.express.c uGenV3Render = nativeExpressView.getUGenV3Render();
        if (uGenV3Render != null) {
            uGenV3Render.ms("notifyAdClicked", (Map<String, String>) null);
        }
    }
}
