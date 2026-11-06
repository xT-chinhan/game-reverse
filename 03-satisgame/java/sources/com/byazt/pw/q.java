package com.byazt.pw;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.text.TextUtils;
import com.byazt.hb.fs;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1113, 5})
public class q extends n {
    public static final float cy;
    public static final float hd;
    public static final float k;
    public static final float sz;
    public float cd;
    public int cp;
    public boolean d;
    public int fs;
    public Path l;
    public Path oa;
    public Paint q;
    public float rv;
    public int s;
    public int tj;
    public com.byazt.hb.n.C0188n w;
    public int x;

    static {
        float radians = (float) Math.toRadians(30.0d);
        sz = radians;
        k = (float) Math.tan(radians);
        cy = (float) Math.cos(radians);
        hd = (float) Math.sin(radians);
    }

    public q(com.byazt.ih.s sVar, JSONObject jSONObject) {
        super(sVar, jSONObject);
        this.d = true;
        Paint paint = new Paint();
        this.q = paint;
        paint.setAntiAlias(true);
        this.l = new Path();
        this.rv = this.qg.py();
        this.oa = new Path();
    }

    @Override // com.byazt.pw.n
    public void qg() {
        this.s = (int) fs.n(this.qg.rv().getContext(), this.n.optInt("shineWidth", 30));
        String strOptString = this.n.optString("backgroundColor", "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))");
        String str = TextUtils.isEmpty(strOptString) ? "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))" : strOptString;
        if (str.startsWith("linear")) {
            this.w = com.byazt.hb.n.qg(str);
        } else {
            int iN = com.byazt.hb.n.n(str);
            this.x = iN;
            this.fs = com.byazt.hb.n.n(iN, 32);
            this.d = false;
        }
        this.cd = cy * this.s;
    }

    @Override // com.byazt.pw.n
    public void n(Canvas canvas) {
        s(canvas);
    }

    @Override // com.byazt.pw.n
    public void qg(Canvas canvas) {
        s(canvas);
    }

    private void s(Canvas canvas) {
        LinearGradient linearGradient;
        try {
            if (this.qg.y() > 0.0f) {
                int i = this.tj;
                float f = k;
                float fY = (i + (i * f)) * this.qg.y();
                this.oa.reset();
                this.oa.moveTo(fY, 0.0f);
                int i2 = this.cp;
                float f2 = fY - (i2 * f);
                this.oa.lineTo(f2, i2);
                this.oa.lineTo(f2 + this.s, this.cp);
                this.oa.lineTo(this.s + fY, 0.0f);
                this.oa.close();
                float f3 = this.cd;
                float f4 = cy * f3;
                float f5 = f3 * hd;
                if (this.d && this.w != null) {
                    linearGradient = new LinearGradient(fY, 0.0f, fY + f4, f5, this.w.qg, (float[]) null, Shader.TileMode.CLAMP);
                } else {
                    float f6 = fY + f4;
                    int i3 = this.fs;
                    linearGradient = new LinearGradient(fY, 0.0f, f6, f5, new int[]{i3, this.x, i3}, (float[]) null, Shader.TileMode.CLAMP);
                }
                this.q.setShader(linearGradient);
                Path path = this.l;
                if (path != null) {
                    canvas.clipPath(path, Region.Op.INTERSECT);
                }
                canvas.drawPath(this.oa, this.q);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.pw.n
    public void n(int i, int i2) {
        this.tj = i;
        this.cp = i2;
        try {
            RectF rectF = new RectF(0.0f, 0.0f, i, i2);
            Path path = this.l;
            float f = this.rv;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.pw.n
    public List<PropertyValuesHolder> s() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(q(), 0.0f, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}
