package com.bytedance.adsdk.ugeno.ms.ms;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms {
    private String ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected JSONObject f383ms;
    protected com.bytedance.adsdk.ugeno.xr.ah xr;

    public abstract List<PropertyValuesHolder> ah();

    public abstract void ms(int i, int i2);

    public abstract void ms(Canvas canvas);

    public abstract void xr();

    public ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, JSONObject jSONObject) {
        this.f383ms = jSONObject;
        this.xr = ahVar;
        ms();
    }

    public void ms() {
        this.ah = this.f383ms.optString("type");
        xr();
    }

    public String d() {
        return this.ah;
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.ms.ms.ms$ms, reason: collision with other inner class name */
    public static class C0197ms {
        public static ms ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, JSONObject jSONObject) {
            if (ahVar == null || jSONObject == null) {
                return null;
            }
            String strOptString = jSONObject.optString("type");
            strOptString.hashCode();
            switch (strOptString) {
                case "stretch":
                    return new ka(ahVar, jSONObject);
                case "ripple":
                    return new xr(ahVar, jSONObject);
                case "rub_in":
                    return new ah(ahVar, jSONObject);
                case "shine":
                    return new d(ahVar, jSONObject);
                default:
                    return null;
            }
        }
    }
}
