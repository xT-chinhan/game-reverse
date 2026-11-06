package com.byazt.vf;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import com.mar.sdk.MARCode;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1181, 37})
public abstract class pr {
    public String hn;
    public com.byazt.ik.hn hw;
    public JSONObject pr;

    public abstract List<PropertyValuesHolder> hn();

    public abstract void hw();

    public abstract void hw(Canvas canvas);

    public abstract void pr(int i, int i2);

    public abstract void pr(Canvas canvas);

    public pr(com.byazt.ik.hn hnVar, JSONObject jSONObject) {
        this.pr = jSONObject;
        this.hw = hnVar;
        pr();
    }

    public void pr() {
        this.hn = this.pr.optString("type");
        hw();
    }

    public String x() {
        return this.hn;
    }

    /* JADX INFO: renamed from: com.byazt.vf.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 1181, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public static class C0211pr {
        public static pr pr(com.byazt.ik.hn hnVar, JSONObject jSONObject) {
            if (hnVar == null || jSONObject == null) {
                return null;
            }
            switch (jSONObject.optString("type")) {
                case "ripple":
                    return new hw(hnVar, jSONObject);
                case "shine":
                    return new x(hnVar, jSONObject);
                case "stretch":
                    return new c(hnVar, jSONObject);
                case "rub_in":
                    return new hn(hnVar, jSONObject);
                default:
                    return null;
            }
        }
    }
}
