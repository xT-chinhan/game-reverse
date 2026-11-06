package com.byazt.vf;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.view.View;
import com.byazt.ca.ho;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1181, 20})
public class hn extends pr {
    public PorterDuffXfermode aj;
    public float c;
    public Paint fw;
    public String hn;
    public View uc;
    public LinearGradient vk;
    public Matrix w;
    public float x;
    public Paint zo;

    public hn(com.byazt.ik.hn hnVar, JSONObject jSONObject) {
        super(hnVar, jSONObject);
        this.uc = this.hw.aj();
        Paint paint = new Paint();
        this.fw = paint;
        paint.setAntiAlias(true);
        this.uc.setLayerType(2, null);
        this.aj = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.zo = new Paint();
        this.w = new Matrix();
    }

    @Override // com.byazt.vf.pr
    public void hw() {
        this.hn = this.pr.optString("direction", "left");
    }

    @Override // com.byazt.vf.pr
    public void pr(Canvas canvas) {
        hn(canvas);
    }

    @Override // com.byazt.vf.pr
    public void hw(Canvas canvas) {
        hn(canvas);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0032  */
    private void hn(Canvas canvas) {
        try {
            if (this.hw.ie() > 0.0f) {
                int iIe = (int) (this.x * this.hw.ie());
                int iIe2 = (int) (this.c * this.hw.ie());
                this.fw.setXfermode(this.aj);
                switch (this.hn) {
                    case "right":
                        float f = iIe;
                        canvas.drawRect(f, 0.0f, this.x, this.c, this.fw);
                        this.w.setTranslate(f, this.c);
                        this.vk.setLocalMatrix(this.w);
                        this.zo.setShader(this.vk);
                        if (this.hw.ie() <= 1.0f && this.hw.ie() > 0.9f) {
                            this.zo.setAlpha((int) (255.0f - (this.hw.ie() * 255.0f)));
                        }
                        canvas.drawRect(0.0f, 0.0f, f, this.c, this.zo);
                        break;
                    case "left":
                        float f2 = iIe;
                        canvas.drawRect(0.0f, 0.0f, this.x - f2, this.c, this.fw);
                        this.w.setTranslate(this.x - f2, 0.0f);
                        this.vk.setLocalMatrix(this.w);
                        this.zo.setShader(this.vk);
                        if (this.hw.ie() <= 1.0f && this.hw.ie() > 0.9f) {
                            this.zo.setAlpha((int) (255.0f - (this.hw.ie() * 255.0f)));
                        }
                        float f3 = this.x;
                        canvas.drawRect(f3, this.c, f3 - f2, 0.0f, this.zo);
                        break;
                    case "bottom":
                        float f4 = iIe2;
                        canvas.drawRect(0.0f, f4, this.x, this.c, this.fw);
                        this.w.setTranslate(0.0f, f4);
                        this.vk.setLocalMatrix(this.w);
                        this.zo.setShader(this.vk);
                        if (this.hw.ie() <= 1.0f && this.hw.ie() > 0.9f) {
                            this.zo.setAlpha((int) (255.0f - (this.hw.ie() * 255.0f)));
                        }
                        canvas.drawRect(0.0f, 0.0f, this.x, f4, this.zo);
                        break;
                    case "top":
                        float f5 = iIe2;
                        canvas.drawRect(0.0f, 0.0f, this.x, this.c - f5, this.fw);
                        this.w.setTranslate(0.0f, this.c - f5);
                        this.vk.setLocalMatrix(this.w);
                        this.zo.setShader(this.vk);
                        if (this.hw.ie() <= 1.0f && this.hw.ie() > 0.9f) {
                            this.zo.setAlpha((int) (255.0f - (this.hw.ie() * 255.0f)));
                        }
                        float f6 = this.x;
                        float f7 = this.c;
                        canvas.drawRect(f6, f7, 0.0f, f7 - f5, this.zo);
                        break;
                }
                return;
            }
            this.fw.setXfermode(this.aj);
            canvas.drawRect(0.0f, 0.0f, this.x, this.c, this.fw);
        } catch (Throwable th) {
            ho.hw("BaseEffectWrapper", th.getMessage());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x003e  */
    @Override // com.byazt.vf.pr
    public void pr(int i, int i2) {
        this.x = i;
        this.c = i2;
        switch (this.hn) {
            case "right":
                this.vk = new LinearGradient(-this.x, 0.0f, 0.0f, this.c, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "left":
                this.vk = new LinearGradient(this.x, 0.0f, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "bottom":
                this.vk = new LinearGradient(0.0f, -this.c, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "top":
                this.vk = new LinearGradient(0.0f, this.c, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
        }
    }

    @Override // com.byazt.vf.pr
    public List<PropertyValuesHolder> hn() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PropertyValuesHolder.ofFloat("rubIn", 0.0f, 1.0f));
        arrayList.add(PropertyValuesHolder.ofFloat(com.byazt.iza.c.ALPHA.hw(), 0.0f, 1.0f));
        return arrayList;
    }
}
