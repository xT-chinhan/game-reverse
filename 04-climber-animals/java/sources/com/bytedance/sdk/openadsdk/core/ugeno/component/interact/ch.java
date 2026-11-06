package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.view.View;
import com.anythink.core.common.m.e;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.i;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ch {
    private static boolean ms(int i, int i2, int i3, int i4, float f, float f2) {
        return f >= ((float) i) && f <= ((float) (i3 + i)) && f2 >= ((float) i2) && f2 <= ((float) (i4 + i2));
    }

    public static boolean ms(View view, com.bytedance.sdk.component.adexpress.ah ahVar) {
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int width = view.getWidth();
            int height = view.getHeight();
            if (ahVar instanceof i) {
                i iVar = (i) ahVar;
                return ms(i, i2, width, height, iVar.f3057ms, iVar.xr);
            }
        }
        return false;
    }

    public static String ms(com.bytedance.sdk.component.adexpress.ah ahVar) {
        JSONObject jSONObjectMs;
        if (!(ahVar instanceof i) || (jSONObjectMs = ((i) ahVar).ms()) == null) {
            return null;
        }
        return jSONObjectMs.optString("ugen_id");
    }

    public static void ms(lm lmVar, boolean z, String str, int i, Map<String, Object> map) {
        JSONObject jSONObjectMs = f.ms(map);
        if (jSONObjectMs == null) {
            jSONObjectMs = new JSONObject();
        }
        try {
            jSONObjectMs.put("success", z ? 1 : 0);
            jSONObjectMs.put("style_type", i);
            jSONObjectMs.put("style_id", str);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVar, "easy_play_show", jSONObjectMs);
    }

    public static void ms(lm lmVar, boolean z, String str, int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put(e.ac, z ? 1 : 2);
            jSONObject.put("style_type", i);
            jSONObject.put("style_id", str);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVar, "easy_play_click", jSONObject);
    }
}
