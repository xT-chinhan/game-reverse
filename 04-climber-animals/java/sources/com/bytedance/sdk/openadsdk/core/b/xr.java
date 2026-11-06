package com.bytedance.sdk.openadsdk.core.b;

import android.content.Context;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.op;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ch;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    private ah ah;
    private final Context d = re.getContext();
    private lm ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.i.ms.xr.ms.xr f2010ms;
    private JSONObject xr;

    public xr(lm lmVar) {
        this.ka = lmVar;
    }

    public void ms(com.bytedance.sdk.openadsdk.i.ms.xr.ms.xr xrVar) {
        this.f2010ms = xrVar;
    }

    public void ms(ah ahVar) {
        this.ah = ahVar;
    }

    public lm ms() {
        return this.ka;
    }

    public Context getContext() {
        return this.d;
    }

    public void ms(lm lmVar) {
        if (this.f2010ms != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("style_category", String.valueOf(op.d(lmVar)));
            } catch (JSONException e) {
                sl.ms(e);
            }
            this.f2010ms.ms(jSONObject);
        }
    }

    public JSONObject xr() {
        JSONObject jSONObject = new JSONObject();
        if (!op.ms()) {
            return jSONObject;
        }
        try {
            com.bytedance.sdk.openadsdk.i.ms.xr.ms.xr xrVar = this.f2010ms;
            if (xrVar != null) {
                JSONObject jSONObjectMs = xrVar.ms();
                this.xr = jSONObjectMs;
                return jSONObjectMs;
            }
        } catch (Exception e) {
            sl.xr("xeasy", e.getMessage());
        }
        return jSONObject;
    }

    public void ms(boolean z, JSONObject jSONObject) {
        if (op.ms()) {
            sl.ms("xeasy", "er:".concat(String.valueOf(z)));
            com.bytedance.sdk.openadsdk.i.ms.xr.ms.xr xrVar = this.f2010ms;
            if (xrVar != null) {
                if (z) {
                    xrVar.xr(jSONObject);
                    return;
                }
                HashMap map = new HashMap();
                map.put("success", 0);
                map.put("estimatedArea", this.xr);
                map.put("realArea", this.ah.getMaxRectJson());
                map.put("exceedAreaRate", Double.valueOf(this.ah.getExceedAreaRate()));
                map.put("widgetArea", this.ah.getActualRectJson());
                ch.ms(this.ka, false, op.ah(this.ka), 2, (Map<String, Object>) map);
                this.f2010ms.ah(jSONObject);
            }
        }
    }

    public void ah() {
        if (op.ms()) {
            sl.ms("xeasy", "oc");
            com.bytedance.sdk.openadsdk.i.ms.xr.ms.xr xrVar = this.f2010ms;
            if (xrVar != null) {
                xrVar.xr();
            }
        }
    }

    public static void ms(lm lmVar, float f, float f2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("convert", 0);
            jSONObject.put("down_x", f);
            jSONObject.put("down_y", f2);
        } catch (Exception e) {
            sl.ms("xeasy", "e:" + e.getMessage());
        }
        ch.ms(lmVar, false, op.ah(lmVar), i, jSONObject);
    }
}
