package com.bytedance.sdk.openadsdk.core.ny.ms.xr;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.umeng.analytics.pro.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.hi.xr.xr(ms = "SINGLETON")
public class ch implements com.bytedance.sdk.component.hi.ms.ms.ah {

    @com.bytedance.sdk.component.hi.xr.ms(ms = "convert_from_landing_page")
    private boolean ab;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "url")
    private String ah;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "is_open_web_page")
    private boolean c;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "interaction_type")
    private int d;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "activity_type")
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    @com.bytedance.sdk.component.hi.xr.ms(ms = "material_meta")
    private lm f3160ms;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "pip_controller")
    private com.bytedance.sdk.openadsdk.core.video.xr.xr x;

    @com.bytedance.sdk.component.hi.xr.ms(ms = g.X)
    private Context xr;

    @Override // com.bytedance.sdk.component.hi.ms.ms.ah
    public boolean ms(Map<String, Object> map, final Map<String, Object> map2, final com.bytedance.sdk.component.hi.ms.ms msVar) {
        if (this.c) {
            return true;
        }
        if (this.ab) {
            msVar.xr(map2);
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ext", this.f3160ms.lx());
            jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.f3160ms.ku()));
            jSONObject.putOpt("req_id", this.f3160ms.eu());
            jSONObject.putOpt("uchain", Boolean.TRUE);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.core.t.u.ms().ms("landing_page", "native", 0, jSONObject);
        if (this.d == 2) {
            boolean zMs = ms();
            if (zMs) {
                msVar.ms(map2);
            } else {
                msVar.xr(map2);
            }
            return zMs;
        }
        if (this.x != null && new com.bytedance.sdk.openadsdk.core.ny.ms.ms.xr.xr(this.x).ms(new HashMap())) {
            msVar.ms(map2);
            return true;
        }
        Intent intent = new Intent(this.xr, (Class<?>) f.c(this.ka));
        if (!(this.xr instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        intent.putExtra("is_outer_click", true);
        lm lmVar = this.f3160ms;
        if (lmVar != null) {
            intent.putExtra("has_phone_num_status", lmVar.ah());
        }
        if (map == null) {
            com.bytedance.sdk.component.utils.sl.d("UChain_LP", "param == null");
            msVar.xr(map2);
        }
        map.putAll(map2);
        map.remove(g.X);
        map.remove("activity_type");
        Object objRemove = map.remove("source");
        f.ms(map, this.f3160ms);
        int i = -1;
        if (!(objRemove == null || TextUtils.isEmpty(objRemove.toString()))) {
            try {
                i = Integer.parseInt(objRemove.toString());
            } catch (Exception unused2) {
            }
        }
        intent.putExtra("source", i);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                intent.putExtra(entry.getKey(), value.toString());
            }
        }
        com.bytedance.sdk.component.utils.xr.ms(this.xr, intent, new com.bytedance.sdk.component.utils.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.xr.ch.1
            @Override // com.bytedance.sdk.component.utils.xr.ms
            public void ms() {
                msVar.ms(map2);
                map2.put("is_open_web_page", Boolean.TRUE);
            }

            @Override // com.bytedance.sdk.component.utils.xr.ms
            public void ms(Throwable th) {
                msVar.xr(map2);
            }
        });
        return true;
    }

    private boolean ms() {
        if (!com.bytedance.sdk.component.utils.u.ms(this.ah)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(this.ah));
            if (!(this.xr instanceof Activity)) {
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
            }
            com.bytedance.sdk.component.utils.xr.ms(this.xr, intent, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
