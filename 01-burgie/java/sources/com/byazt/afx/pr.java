package com.byazt.afx;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.byazt.aa.zo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1253, 37})
public class pr {
    public hw aj;
    public com.byazt.aa.pr.C0005pr c;
    public float fw;
    public int hn;
    public com.byazt.aa.pr.C0005pr hw;
    public com.byazt.aa.pr.C0005pr pr;
    public float uc;
    public int x;
    public int zo;

    public void pr(String str) {
        if (com.byazt.aa.pr.hn(str)) {
            this.pr = com.byazt.aa.pr.hw(str);
        }
    }

    public void hw(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("gradient", null);
            if (strOptString != null && com.byazt.aa.pr.hn(strOptString)) {
                this.hw = com.byazt.aa.pr.hw(strOptString);
                this.hn = jSONObject.optInt("duration", 2200);
                this.x = jSONObject.optInt("playCount", -1);
            }
        } catch (JSONException e) {
        }
    }

    public void pr(String str, Context context) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("gradient", null);
            if (strOptString != null && com.byazt.aa.pr.hn(strOptString)) {
                this.c = com.byazt.aa.pr.hw(strOptString);
                this.uc = zo.pr(context, (float) jSONObject.optDouble("width", 76.0d));
                this.fw = (float) jSONObject.optDouble("opacity", 0.9d);
                this.zo = jSONObject.optInt("steps", 24);
            }
        } catch (JSONException e) {
        }
    }

    public boolean pr() {
        return (this.pr == null && this.hw == null) ? false : true;
    }

    public boolean hw() {
        return (this.pr == null && this.hw == null && this.c == null) ? false : true;
    }

    public void pr(View view, Drawable drawable, float f, float[] fArr) {
        int[] iArr;
        float[] fArr2;
        int[] iArr2;
        float[] fArr3;
        boolean z = pr() && f > 0.0f;
        boolean z2 = this.c != null;
        if (!z && !z2) {
            this.aj = null;
            view.setBackground(drawable);
            return;
        }
        if (!z) {
            iArr = null;
            fArr2 = null;
        } else {
            com.byazt.aa.pr.C0005pr c0005pr = this.hw;
            if (c0005pr != null) {
                iArr = c0005pr.hw;
                fArr2 = this.hw.hn;
            } else {
                iArr = this.pr.hw;
                fArr2 = this.pr.hn;
            }
        }
        if (z2) {
            iArr2 = this.c.hw;
        } else {
            iArr2 = null;
        }
        if (z2) {
            fArr3 = this.c.hn;
        } else {
            fArr3 = null;
        }
        hw hwVar = new hw(drawable, iArr, fArr2, f, fArr, this.hw != null, this.hn, this.x, z2, this.uc, this.fw, this.zo, iArr2, fArr3);
        this.aj = hwVar;
        view.setBackground(hwVar);
    }

    public void hn() {
        hw hwVar = this.aj;
        if (hwVar != null && hwVar.hn()) {
            this.aj.pr();
        }
    }

    public void x() {
        hw hwVar = this.aj;
        if (hwVar != null) {
            hwVar.hw();
        }
    }
}
