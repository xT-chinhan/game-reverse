package com.byazt.rc;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.byazt.hb.fs;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_BUFFER_LIMIT, 19})
public class n {
    public int fs;
    public com.byazt.hb.n.C0188n l;
    public com.byazt.hb.n.C0188n n;
    public int q;
    public com.byazt.hb.n.C0188n qg;
    public qg rv;
    public int s;
    public float w;
    public float x;

    public void n(String str) {
        if (com.byazt.hb.n.s(str)) {
            this.n = com.byazt.hb.n.qg(str);
        }
    }

    public void qg(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("gradient", null);
            if (strOptString == null || !com.byazt.hb.n.s(strOptString)) {
                return;
            }
            this.qg = com.byazt.hb.n.qg(strOptString);
            this.s = jSONObject.optInt(MediationConstant.EXTRA_DURATION, 2200);
            this.q = jSONObject.optInt("playCount", -1);
        } catch (JSONException unused) {
        }
    }

    public void n(String str, Context context) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("gradient", null);
            if (strOptString == null || !com.byazt.hb.n.s(strOptString)) {
                return;
            }
            this.l = com.byazt.hb.n.qg(strOptString);
            this.w = fs.n(context, (float) jSONObject.optDouble("width", 76.0d));
            this.x = (float) jSONObject.optDouble("opacity", 0.9d);
            this.fs = jSONObject.optInt("steps", 24);
        } catch (JSONException unused) {
        }
    }

    public boolean n() {
        return (this.n == null && this.qg == null) ? false : true;
    }

    public boolean qg() {
        return (this.n == null && this.qg == null && this.l == null) ? false : true;
    }

    public void n(View view, Drawable drawable, float f, float[] fArr) {
        int[] iArr;
        float[] fArr2;
        int[] iArr2;
        float[] fArr3;
        boolean z = n() && f > 0.0f;
        boolean z2 = this.l != null;
        if (!z && !z2) {
            this.rv = null;
            view.setBackground(drawable);
            return;
        }
        if (z) {
            com.byazt.hb.n.C0188n c0188n = this.qg;
            if (c0188n != null) {
                iArr2 = c0188n.qg;
                fArr3 = this.qg.s;
            } else {
                iArr2 = this.n.qg;
                fArr3 = this.n.s;
            }
            iArr = iArr2;
            fArr2 = fArr3;
        } else {
            iArr = null;
            fArr2 = null;
        }
        qg qgVar = new qg(drawable, iArr, fArr2, f, fArr, this.qg != null, this.s, this.q, z2, this.w, this.x, this.fs, z2 ? this.l.qg : null, z2 ? this.l.s : null);
        this.rv = qgVar;
        view.setBackground(qgVar);
    }

    public void s() {
        qg qgVar = this.rv;
        if (qgVar == null || !qgVar.s()) {
            return;
        }
        this.rv.n();
    }

    public void q() {
        qg qgVar = this.rv;
        if (qgVar != null) {
            qgVar.qg();
        }
    }
}
