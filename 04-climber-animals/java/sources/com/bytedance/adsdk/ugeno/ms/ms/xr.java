package com.bytedance.adsdk.ugeno.ms.ms;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends ms {
    private static final int ab = Color.parseColor("#7ed321");
    private int ah;
    private Paint c;
    private int d;
    private int ka;

    public xr(com.bytedance.adsdk.ugeno.xr.ah ahVar, JSONObject jSONObject) {
        super(ahVar, jSONObject);
        Paint paint = new Paint();
        this.c = paint;
        paint.setAntiAlias(true);
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ms.ms
    public void xr() {
        this.ah = com.bytedance.adsdk.ugeno.c.ms.ms(this.f383ms.optString("backgroundColor"), ab);
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ms.ms
    public void ms(Canvas canvas) {
        try {
            if (this.xr.eg() > 0.0f) {
                this.c.setColor(this.ah);
                this.c.setAlpha((int) ((1.0f - this.xr.eg()) * 255.0f));
                ((ViewGroup) this.xr.ny().getParent()).setClipChildren(true);
                int i = this.d;
                int i2 = this.ka;
                canvas.drawCircle(i, i2, Math.min(i, i2) * 2 * this.xr.eg(), this.c);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ms.ms
    public void ms(int i, int i2) {
        this.d = i / 2;
        this.ka = i2 / 2;
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ms.ms
    public List<PropertyValuesHolder> ah() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(d(), 0.0f, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}
