package com.byazt.zw;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.internal.view.SupportMenu;
import com.byazt.cq.fs;
import com.byazt.lh.x;
import com.byazt.osr.DynamicImageView;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 731, 19})
public class n {
    public int l;
    public Paint n;
    public int q;
    public Path qg = new Path();
    public Path s = new Path();
    public int w;

    public n() {
        Paint paint = new Paint();
        this.n = paint;
        paint.setAntiAlias(true);
    }

    public void n(Canvas canvas, qg qgVar, View view) {
        int iIntValue;
        int iIntValue2;
        String str;
        float[] fArrQg;
        if (qgVar.getRippleValue() != 0.0f) {
            if (com.byazt.gkj.n.n().s() != null) {
                try {
                    str = (String) view.getTag(2097610712);
                    try {
                        fArrQg = x.qg(str);
                    } catch (Exception unused) {
                        fArrQg = null;
                    }
                } catch (Exception unused2) {
                    str = "";
                }
                if (str.startsWith("#")) {
                    this.n.setColor(Color.parseColor(str));
                    this.n.setAlpha(90);
                } else if (fArrQg != null) {
                    this.n.setColor(fs.n(fArrQg[3] * (1.0f - qgVar.getRippleValue()), fArrQg[0] / 256.0f, fArrQg[1] / 256.0f, fArrQg[2] / 256.0f));
                }
            }
            ((ViewGroup) view.getParent()).setClipChildren(true);
            int i = this.q;
            int i2 = this.l;
            canvas.drawCircle(i, i2, Math.min(i, i2) * 2 * qgVar.getRippleValue(), this.n);
        }
        if (qgVar.getShineValue() != 0.0f) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).setClipChildren(true);
            }
            if (view.getParent().getParent() != null) {
                ((ViewGroup) view.getParent().getParent()).setClipChildren(true);
            }
            this.qg.reset();
            try {
                iIntValue2 = ((Integer) view.getTag(2097610711)).intValue();
            } catch (Exception unused3) {
                iIntValue2 = 0;
            }
            if (iIntValue2 >= 0) {
                int shineValue = ((int) ((((this.q * 4) + (iIntValue2 * 2)) + (this.l * 2)) * qgVar.getShineValue())) - ((this.l * 2) + iIntValue2);
                float f = shineValue;
                int i3 = this.l;
                this.n.setShader(new LinearGradient(f, 0.0f, ((iIntValue2 + i3) / 2) + shineValue, i3 / 2, new int[]{Color.parseColor("#20ffffff"), Color.parseColor("#60ffffff"), Color.parseColor("#65ffffff")}, (float[]) null, Shader.TileMode.MIRROR));
                this.n.setStrokeWidth(this.q * 2);
                Path path = this.s;
                if (path != null) {
                    canvas.clipPath(path, Region.Op.INTERSECT);
                }
                int i4 = shineValue + iIntValue2;
                int i5 = this.l;
                canvas.drawLine(f, 0.0f, i4 + i5, i5, this.n);
            }
        }
        if (qgVar.getMarqueeValue() != 0.0f) {
            try {
                iIntValue = ((Integer) view.getTag(2097610709)).intValue();
            } catch (Exception unused4) {
                iIntValue = 0;
            }
            if (iIntValue >= 0) {
                this.qg.reset();
                this.qg.moveTo(0.0f, 0.0f);
                this.qg.lineTo(this.q * 2, 0.0f);
                this.qg.lineTo(this.q * 2, this.l * 2);
                this.qg.lineTo(0.0f, this.l * 2);
                this.qg.lineTo(0.0f, 0.0f);
                this.n.setShader(new LinearGradient(0.0f, 0.0f, this.q * 2, this.l * 2, new int[]{(int) (qgVar.getMarqueeValue() * (-65536.0f)), (int) ((1.0f - qgVar.getMarqueeValue()) * (-65536.0f))}, (float[]) null, Shader.TileMode.CLAMP));
                this.n.setColor(SupportMenu.CATEGORY_MASK);
                this.n.setStyle(Paint.Style.STROKE);
                this.n.setStrokeWidth(iIntValue);
                canvas.drawPath(this.qg, this.n);
            }
        }
    }

    public void n(View view, float f) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) (this.w * f);
        view.setTranslationX((this.w - layoutParams.width) / 2);
        if (view instanceof DynamicImageView) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                viewGroup.getChildAt(i).setTranslationX((-(this.w - layoutParams.width)) / 2);
                i++;
            }
        }
        view.setLayoutParams(layoutParams);
    }

    public void n(View view, int i, int i2) {
        String str;
        this.q = i / 2;
        this.l = i2 / 2;
        if (this.w == 0 && view.getLayoutParams().width > 0) {
            this.w = view.getLayoutParams().width;
        }
        try {
            str = (String) view.getTag(2097610710);
            try {
                this.s.addRoundRect(new RectF(0.0f, 0.0f, i, i2), i2 / 2, i2 / 2, Path.Direction.CW);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str = "";
        }
        if ("right".equals(str)) {
            view.setPivotX(this.q * 2);
            view.setPivotY(this.l);
        } else if ("left".equals(str)) {
            view.setPivotX(0.0f);
            view.setPivotY(this.l);
        } else {
            view.setPivotX(this.q);
            view.setPivotY(this.l);
        }
    }
}
