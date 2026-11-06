package com.byazt.vf;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.text.TextUtils;
import com.byazt.aa.zo;
import com.tapsdk.tapad.internal.runtime.view.LinearContainerViewManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1181, 121})
public class x extends pr {
    public static final float g;
    public static final float ho;
    public static final float nt;
    public static final float yb;
    public float aj;
    public Path c;
    public int fw;
    public int hn;
    public boolean k;
    public float lb;
    public Path m;
    public com.byazt.aa.pr.C0005pr uc;
    public int vk;
    public int w;
    public Paint x;
    public int zo;

    static {
        float radians = (float) Math.toRadians(30.0d);
        g = radians;
        ho = (float) Math.tan(radians);
        nt = (float) Math.cos(radians);
        yb = (float) Math.sin(radians);
    }

    public x(com.byazt.ik.hn hnVar, JSONObject jSONObject) {
        super(hnVar, jSONObject);
        this.k = true;
        Paint paint = new Paint();
        this.x = paint;
        paint.setAntiAlias(true);
        this.c = new Path();
        this.aj = this.hw.cz();
        this.m = new Path();
    }

    @Override // com.byazt.vf.pr
    public void hw() {
        this.hn = (int) zo.pr(this.hw.aj().getContext(), this.pr.optInt("shineWidth", 30));
        String strOptString = this.pr.optString("backgroundColor", "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))");
        String str = TextUtils.isEmpty(strOptString) ? "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))" : strOptString;
        if (str.startsWith(LinearContainerViewManager.NAME)) {
            this.uc = com.byazt.aa.pr.hw(str);
        } else {
            int iPr = com.byazt.aa.pr.pr(str);
            this.fw = iPr;
            this.zo = com.byazt.aa.pr.pr(iPr, 32);
            this.k = false;
        }
        this.lb = nt * this.hn;
    }

    @Override // com.byazt.vf.pr
    public void pr(Canvas canvas) {
        hn(canvas);
    }

    @Override // com.byazt.vf.pr
    public void hw(Canvas canvas) {
        hn(canvas);
    }

    private void hn(Canvas canvas) {
        LinearGradient linearGradient;
        try {
            if (this.hw.hs() > 0.0f) {
                int i = this.vk;
                float f = ho;
                float fHs = (i + (i * f)) * this.hw.hs();
                this.m.reset();
                this.m.moveTo(fHs, 0.0f);
                int i2 = this.w;
                float f2 = fHs - (i2 * f);
                this.m.lineTo(f2, i2);
                this.m.lineTo(f2 + this.hn, this.w);
                this.m.lineTo(this.hn + fHs, 0.0f);
                this.m.close();
                float f3 = this.lb;
                float f4 = nt * f3;
                float f5 = f3 * yb;
                if (this.k && this.uc != null) {
                    linearGradient = new LinearGradient(fHs, 0.0f, fHs + f4, f5, this.uc.hw, (float[]) null, Shader.TileMode.CLAMP);
                } else {
                    int i3 = this.zo;
                    linearGradient = new LinearGradient(fHs, 0.0f, fHs + f4, f5, new int[]{i3, this.fw, i3}, (float[]) null, Shader.TileMode.CLAMP);
                }
                this.x.setShader(linearGradient);
                Path path = this.c;
                if (path != null) {
                    canvas.clipPath(path, Region.Op.INTERSECT);
                }
                canvas.drawPath(this.m, this.x);
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.vf.pr
    public void pr(int i, int i2) {
        this.vk = i;
        this.w = i2;
        try {
            RectF rectF = new RectF(0.0f, 0.0f, i, i2);
            Path path = this.c;
            float f = this.aj;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.vf.pr
    public List<PropertyValuesHolder> hn() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(x(), 0.0f, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}
