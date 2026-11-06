package com.byazt.pw;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1113, 19})
public abstract class n {
    public JSONObject n;
    public com.byazt.ih.s qg;
    public String s;

    public abstract void n(int i, int i2);

    public abstract void n(Canvas canvas);

    public abstract void qg();

    public abstract void qg(Canvas canvas);

    public abstract List<PropertyValuesHolder> s();

    public n(com.byazt.ih.s sVar, JSONObject jSONObject) {
        this.n = jSONObject;
        this.qg = sVar;
        n();
    }

    public void n() {
        this.s = this.n.optString("type");
        qg();
    }

    public String q() {
        return this.s;
    }

    /* JADX INFO: renamed from: com.byazt.pw.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1113, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static class C0307n {
        public static n n(com.byazt.ih.s sVar, JSONObject jSONObject) {
            if (sVar == null || jSONObject == null) {
                return null;
            }
            String strOptString = jSONObject.optString("type");
            strOptString.hashCode();
            switch (strOptString) {
                case "stretch":
                    return new l(sVar, jSONObject);
                case "ripple":
                    return new qg(sVar, jSONObject);
                case "rub_in":
                    return new s(sVar, jSONObject);
                case "shine":
                    return new q(sVar, jSONObject);
                default:
                    return null;
            }
        }
    }
}
