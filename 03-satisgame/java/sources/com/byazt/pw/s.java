package com.byazt.pw;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.view.View;
import com.byazt.tk.k;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1113, 8})
public class s extends n {
    public Matrix cp;
    public Paint fs;
    public float l;
    public float q;
    public PorterDuffXfermode rv;
    public String s;
    public LinearGradient tj;
    public View w;
    public Paint x;

    public s(com.byazt.ih.s sVar, JSONObject jSONObject) {
        super(sVar, jSONObject);
        this.w = this.qg.rv();
        Paint paint = new Paint();
        this.x = paint;
        paint.setAntiAlias(true);
        this.w.setLayerType(2, null);
        this.rv = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.fs = new Paint();
        this.cp = new Matrix();
    }

    @Override // com.byazt.pw.n
    public void qg() {
        this.s = this.n.optString("direction", "left");
    }

    @Override // com.byazt.pw.n
    public void n(Canvas canvas) {
        s(canvas);
    }

    @Override // com.byazt.pw.n
    public void qg(Canvas canvas) {
        s(canvas);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x005d  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void s(Canvas canvas) {
        byte b;
        try {
            if (this.qg.dh() > 0.0f) {
                int iDh = (int) (this.q * this.qg.dh());
                int iDh2 = (int) (this.l * this.qg.dh());
                this.x.setXfermode(this.rv);
                String str = this.s;
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
                    float f = iDh;
                    canvas.drawRect(f, 0.0f, this.q, this.l, this.x);
                    this.cp.setTranslate(f, this.l);
                    this.tj.setLocalMatrix(this.cp);
                    this.fs.setShader(this.tj);
                    if (this.qg.dh() <= 1.0f && this.qg.dh() > 0.9f) {
                        this.fs.setAlpha((int) (255.0f - (this.qg.dh() * 255.0f)));
                    }
                    canvas.drawRect(0.0f, 0.0f, f, this.l, this.fs);
                    return;
                }
                if (b == 1) {
                    float f2 = iDh;
                    canvas.drawRect(0.0f, 0.0f, this.q - f2, this.l, this.x);
                    this.cp.setTranslate(this.q - f2, 0.0f);
                    this.tj.setLocalMatrix(this.cp);
                    this.fs.setShader(this.tj);
                    if (this.qg.dh() <= 1.0f && this.qg.dh() > 0.9f) {
                        this.fs.setAlpha((int) (255.0f - (this.qg.dh() * 255.0f)));
                    }
                    float f3 = this.q;
                    canvas.drawRect(f3, this.l, f3 - f2, 0.0f, this.fs);
                    return;
                }
                if (b == 2) {
                    float f4 = iDh2;
                    canvas.drawRect(0.0f, f4, this.q, this.l, this.x);
                    this.cp.setTranslate(0.0f, f4);
                    this.tj.setLocalMatrix(this.cp);
                    this.fs.setShader(this.tj);
                    if (this.qg.dh() <= 1.0f && this.qg.dh() > 0.9f) {
                        this.fs.setAlpha((int) (255.0f - (this.qg.dh() * 255.0f)));
                    }
                    canvas.drawRect(0.0f, 0.0f, this.q, f4, this.fs);
                    return;
                }
                if (b != 3) {
                    return;
                }
                float f5 = iDh2;
                canvas.drawRect(0.0f, 0.0f, this.q, this.l - f5, this.x);
                this.cp.setTranslate(0.0f, this.l - f5);
                this.tj.setLocalMatrix(this.cp);
                this.fs.setShader(this.tj);
                if (this.qg.dh() <= 1.0f && this.qg.dh() > 0.9f) {
                    this.fs.setAlpha((int) (255.0f - (this.qg.dh() * 255.0f)));
                }
                float f6 = this.q;
                float f7 = this.l;
                canvas.drawRect(f6, f7, 0.0f, f7 - f5, this.fs);
                return;
            }
            this.x.setXfermode(this.rv);
            canvas.drawRect(0.0f, 0.0f, this.q, this.l, this.x);
        } catch (Throwable th) {
            k.qg("BaseEffectWrapper", th.getMessage());
        }
    }

    @Override // com.byazt.pw.n
    public void n(int i, int i2) {
        this.q = i;
        this.l = i2;
        String str = this.s;
        str.hashCode();
        switch (str) {
            case "bottom":
                this.tj = new LinearGradient(0.0f, -this.l, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "top":
                this.tj = new LinearGradient(0.0f, this.l, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "left":
                this.tj = new LinearGradient(this.q, 0.0f, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "right":
                this.tj = new LinearGradient(-this.q, 0.0f, 0.0f, this.l, 0, -1, Shader.TileMode.CLAMP);
                break;
        }
    }

    @Override // com.byazt.pw.n
    public List<PropertyValuesHolder> s() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PropertyValuesHolder.ofFloat("rubIn", 0.0f, 1.0f));
        arrayList.add(PropertyValuesHolder.ofFloat(com.byazt.kg.l.ALPHA.qg(), 0.0f, 1.0f));
        return arrayList;
    }
}
