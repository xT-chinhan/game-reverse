package com.bytedance.adsdk.ugeno.ms.ms;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.view.View;
import com.bytedance.sdk.component.utils.sl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends ms {
    private Paint ab;
    private String ah;
    private View c;
    private LinearGradient ch;
    private float d;
    private Matrix hi;
    private float ka;
    private PorterDuffXfermode ny;
    private Paint x;

    public ah(com.bytedance.adsdk.ugeno.xr.ah ahVar, JSONObject jSONObject) {
        super(ahVar, jSONObject);
        this.c = this.xr.ny();
        Paint paint = new Paint();
        this.ab = paint;
        paint.setAntiAlias(true);
        this.c.setLayerType(2, null);
        this.ny = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.x = new Paint();
        this.hi = new Matrix();
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ms.ms
    public void xr() {
        this.ah = this.f383ms.optString("direction", "left");
    }

    /* JADX WARN: Code duplicated, block: B:20:0x005d  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.bytedance.adsdk.ugeno.ms.ms.ms
    public void ms(Canvas canvas) {
        byte b;
        try {
            if (this.xr.il() > 0.0f) {
                int iIl = (int) (this.d * this.xr.il());
                int iIl2 = (int) (this.ka * this.xr.il());
                this.ab.setXfermode(this.ny);
                String str = this.ah;
                switch (str.hashCode()) {
                    case -1383228885:
                        if (!str.equals("bottom")) {
                            b = -1;
                        } else {
                            b = 2;
                        }
                        break;
                    case 115029:
                        if (!str.equals("top")) {
                            b = -1;
                        } else {
                            b = 3;
                        }
                        break;
                    case 3317767:
                        if (!str.equals("left")) {
                            b = -1;
                        } else {
                            b = 1;
                        }
                        break;
                    case 108511772:
                        if (!str.equals("right")) {
                            b = -1;
                        } else {
                            b = 0;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                if (b == 0) {
                    float f = iIl;
                    canvas.drawRect(f, 0.0f, this.d, this.ka, this.ab);
                    this.hi.setTranslate(f, this.ka);
                    this.ch.setLocalMatrix(this.hi);
                    this.x.setShader(this.ch);
                    if (this.xr.il() <= 1.0f && this.xr.il() > 0.9f) {
                        this.x.setAlpha((int) (255.0f - (this.xr.il() * 255.0f)));
                    }
                    canvas.drawRect(0.0f, 0.0f, f, this.ka, this.x);
                    return;
                }
                if (b == 1) {
                    float f2 = iIl;
                    canvas.drawRect(0.0f, 0.0f, this.d - f2, this.ka, this.ab);
                    this.hi.setTranslate(this.d - f2, 0.0f);
                    this.ch.setLocalMatrix(this.hi);
                    this.x.setShader(this.ch);
                    if (this.xr.il() <= 1.0f && this.xr.il() > 0.9f) {
                        this.x.setAlpha((int) (255.0f - (this.xr.il() * 255.0f)));
                    }
                    float f3 = this.d;
                    canvas.drawRect(f3, this.ka, f3 - f2, 0.0f, this.x);
                    return;
                }
                if (b == 2) {
                    float f4 = iIl2;
                    canvas.drawRect(0.0f, f4, this.d, this.ka, this.ab);
                    this.hi.setTranslate(0.0f, f4);
                    this.ch.setLocalMatrix(this.hi);
                    this.x.setShader(this.ch);
                    if (this.xr.il() <= 1.0f && this.xr.il() > 0.9f) {
                        this.x.setAlpha((int) (255.0f - (this.xr.il() * 255.0f)));
                    }
                    canvas.drawRect(0.0f, 0.0f, this.d, f4, this.x);
                    return;
                }
                if (b != 3) {
                    return;
                }
                float f5 = iIl2;
                canvas.drawRect(0.0f, 0.0f, this.d, this.ka - f5, this.ab);
                this.hi.setTranslate(0.0f, this.ka - f5);
                this.ch.setLocalMatrix(this.hi);
                this.x.setShader(this.ch);
                if (this.xr.il() <= 1.0f && this.xr.il() > 0.9f) {
                    this.x.setAlpha((int) (255.0f - (this.xr.il() * 255.0f)));
                }
                float f6 = this.d;
                float f7 = this.ka;
                canvas.drawRect(f6, f7, 0.0f, f7 - f5, this.x);
            }
        } catch (Throwable th) {
            sl.d("BaseEffectWrapper", th.getMessage());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ms.ms
    public void ms(int i, int i2) {
        this.d = i;
        this.ka = i2;
        String str = this.ah;
        str.hashCode();
        switch (str) {
            case "bottom":
                this.ch = new LinearGradient(0.0f, -this.ka, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "top":
                this.ch = new LinearGradient(0.0f, this.ka, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "left":
                this.ch = new LinearGradient(this.d, 0.0f, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "right":
                this.ch = new LinearGradient(-this.d, 0.0f, 0.0f, this.ka, 0, -1, Shader.TileMode.CLAMP);
                break;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ms.ms
    public List<PropertyValuesHolder> ah() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PropertyValuesHolder.ofFloat("rubIn", 0.0f, 1.0f));
        arrayList.add(PropertyValuesHolder.ofFloat(com.bytedance.adsdk.ugeno.ms.d.ALPHA.xr(), 0.0f, 1.0f));
        return arrayList;
    }
}
