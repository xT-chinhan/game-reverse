package com.bytedance.adsdk.ugeno.ms.ms;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends ms {
    private String ab;
    private float ah;
    private float c;
    private Path ch;
    private float d;
    private Path hi;
    private Paint ka;
    private boolean ny;
    private Path sl;
    private boolean x;
    private PorterDuffXfermode zb;

    public ka(com.bytedance.adsdk.ugeno.xr.ah ahVar, JSONObject jSONObject) {
        super(ahVar, jSONObject);
        this.x = true;
        this.ny = true;
        Paint paint = new Paint();
        this.ka = paint;
        paint.setAntiAlias(true);
        this.xr.ny().setLayerType(2, null);
        this.zb = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.ch = new Path();
        this.hi = new Path();
        this.sl = new Path();
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ms.ms
    public void xr() {
        this.c = (float) this.f383ms.optDouble("start", 0.0d);
        this.ab = this.f383ms.optString("direction", "center");
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ms.ms
    public void ms(Canvas canvas) {
        if (this.xr.xn() > 0.0f) {
            int iXn = (int) (this.ah * this.xr.xn());
            int iXn2 = (int) (this.d * this.xr.xn());
            this.ka.setXfermode(this.zb);
            String str = this.ab;
            str.hashCode();
            switch (str) {
                case "bottom":
                    canvas.drawRect(0.0f, iXn2, this.ah, this.d, this.ka);
                    break;
                case "center":
                    this.ch.reset();
                    this.hi.reset();
                    this.sl.reset();
                    this.ch.addCircle(this.ah / 2.0f, this.d / 2.0f, iXn, Path.Direction.CW);
                    Path path = this.hi;
                    float f = this.ah;
                    path.addRect(f / 2.0f, 0.0f, f, this.d, Path.Direction.CW);
                    this.hi.op(this.ch, Path.Op.DIFFERENCE);
                    this.sl.addRect(0.0f, 0.0f, this.ah / 2.0f, this.d, Path.Direction.CW);
                    this.sl.op(this.ch, Path.Op.DIFFERENCE);
                    canvas.drawPath(this.hi, this.ka);
                    canvas.drawPath(this.sl, this.ka);
                    break;
                case "top":
                    canvas.drawRect(0.0f, 0.0f, this.ah, this.d - iXn2, this.ka);
                    break;
                case "left":
                    canvas.drawRect(0.0f, 0.0f, this.ah - iXn, this.d, this.ka);
                    break;
                case "right":
                    canvas.drawRect(iXn, 0.0f, this.ah, this.d, this.ka);
                    break;
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ms.ms
    public void ms(int i, int i2) {
        if (i > 0 && this.x) {
            this.ah = i;
            this.x = false;
        }
        if (i2 <= 0 || !this.ny) {
            return;
        }
        this.d = i2;
        this.ny = false;
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ms.ms
    public List<PropertyValuesHolder> ah() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(d(), this.c, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}
