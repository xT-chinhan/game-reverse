package com.bytedance.adsdk.ugeno.ms.ms;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.c.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d extends ms {
    private static final float ao;
    private static final float h;
    private static final float u;
    private static final float ub;
    private int ab;
    private int ah;
    private com.bytedance.adsdk.ugeno.c.ms.C0192ms c;
    private int ch;
    private Paint d;
    private int hi;
    private Path ka;
    private float ny;
    private float qv;
    private boolean sl;
    private int x;
    private Path zb;

    static {
        float radians = (float) Math.toRadians(30.0d);
        u = radians;
        ub = (float) Math.tan(radians);
        ao = (float) Math.cos(radians);
        h = (float) Math.sin(radians);
    }

    public d(com.bytedance.adsdk.ugeno.xr.ah ahVar, JSONObject jSONObject) {
        super(ahVar, jSONObject);
        this.sl = true;
        Paint paint = new Paint();
        this.d = paint;
        paint.setAntiAlias(true);
        this.ka = new Path();
        this.ny = this.xr.nw();
        this.zb = new Path();
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ms.ms
    public void xr() {
        this.ah = (int) x.ms(this.xr.ny().getContext(), this.f383ms.optInt("shineWidth", 30));
        String strOptString = this.f383ms.optString("backgroundColor", "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))");
        String str = TextUtils.isEmpty(strOptString) ? "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))" : strOptString;
        if (str.startsWith("linear")) {
            this.c = com.bytedance.adsdk.ugeno.c.ms.xr(str);
        } else {
            int iMs = com.bytedance.adsdk.ugeno.c.ms.ms(str);
            this.ab = iMs;
            this.x = com.bytedance.adsdk.ugeno.c.ms.ms(iMs, 32);
            this.sl = false;
        }
        this.qv = ao * this.ah;
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ms.ms
    public void ms(Canvas canvas) {
        LinearGradient linearGradient;
        try {
            if (this.xr.fm() > 0.0f) {
                int i = this.ch;
                float f = ub;
                float fFm = (i + (i * f)) * this.xr.fm();
                this.zb.reset();
                this.zb.moveTo(fFm, 0.0f);
                int i2 = this.hi;
                float f2 = fFm - (i2 * f);
                this.zb.lineTo(f2, i2);
                this.zb.lineTo(f2 + this.ah, this.hi);
                this.zb.lineTo(this.ah + fFm, 0.0f);
                this.zb.close();
                float f3 = this.qv;
                float f4 = ao * f3;
                float f5 = f3 * h;
                if (this.sl && this.c != null) {
                    linearGradient = new LinearGradient(fFm, 0.0f, fFm + f4, f5, this.c.xr, (float[]) null, Shader.TileMode.CLAMP);
                } else {
                    float f6 = fFm + f4;
                    int i3 = this.x;
                    linearGradient = new LinearGradient(fFm, 0.0f, f6, f5, new int[]{i3, this.ab, i3}, (float[]) null, Shader.TileMode.CLAMP);
                }
                this.d.setShader(linearGradient);
                Path path = this.ka;
                if (path != null) {
                    canvas.clipPath(path, Region.Op.INTERSECT);
                }
                canvas.drawPath(this.zb, this.d);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ms.ms
    public void ms(int i, int i2) {
        this.ch = i;
        this.hi = i2;
        try {
            RectF rectF = new RectF(0.0f, 0.0f, i, i2);
            Path path = this.ka;
            float f = this.ny;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ms.ms
    public List<PropertyValuesHolder> ah() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(d(), 0.0f, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}
