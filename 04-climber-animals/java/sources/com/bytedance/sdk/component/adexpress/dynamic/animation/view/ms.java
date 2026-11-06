package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

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
import com.bytedance.sdk.component.adexpress.d.x;
import com.bytedance.sdk.component.adexpress.dynamic.ah.ab;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private int c;
    private int d;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    Paint f782ms;
    Path xr = new Path();
    Path ah = new Path();

    public ms() {
        Paint paint = new Paint();
        this.f782ms = paint;
        paint.setAntiAlias(true);
    }

    public void ms(Canvas canvas, xr xrVar, View view) {
        int iIntValue;
        int iIntValue2;
        String str;
        float[] fArrXr;
        if (xrVar.getRippleValue() != 0.0f) {
            if (com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah() != null) {
                try {
                    str = (String) view.getTag(2097610712);
                    try {
                        fArrXr = ab.xr(str);
                    } catch (Exception unused) {
                        fArrXr = null;
                    }
                } catch (Exception unused2) {
                    str = "";
                }
                if (str.startsWith("#")) {
                    this.f782ms.setColor(Color.parseColor(str));
                    this.f782ms.setAlpha(90);
                } else if (fArrXr != null) {
                    this.f782ms.setColor(x.ms(fArrXr[3] * (1.0f - xrVar.getRippleValue()), fArrXr[0] / 256.0f, fArrXr[1] / 256.0f, fArrXr[2] / 256.0f));
                }
            }
            ((ViewGroup) view.getParent()).setClipChildren(true);
            int i = this.d;
            int i2 = this.ka;
            canvas.drawCircle(i, i2, Math.min(i, i2) * 2 * xrVar.getRippleValue(), this.f782ms);
        }
        if (xrVar.getShineValue() != 0.0f) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).setClipChildren(true);
            }
            if (view.getParent().getParent() != null) {
                ((ViewGroup) view.getParent().getParent()).setClipChildren(true);
            }
            this.xr.reset();
            try {
                iIntValue2 = ((Integer) view.getTag(2097610711)).intValue();
            } catch (Exception unused3) {
                iIntValue2 = 0;
            }
            if (iIntValue2 >= 0) {
                int shineValue = ((int) ((((this.d * 4) + (iIntValue2 * 2)) + (this.ka * 2)) * xrVar.getShineValue())) - ((this.ka * 2) + iIntValue2);
                float f = shineValue;
                int i3 = this.ka;
                this.f782ms.setShader(new LinearGradient(f, 0.0f, ((iIntValue2 + i3) / 2) + shineValue, i3 / 2, new int[]{Color.parseColor("#20ffffff"), Color.parseColor("#60ffffff"), Color.parseColor("#65ffffff")}, (float[]) null, Shader.TileMode.MIRROR));
                this.f782ms.setStrokeWidth(this.d * 2);
                Path path = this.ah;
                if (path != null) {
                    canvas.clipPath(path, Region.Op.INTERSECT);
                }
                int i4 = shineValue + iIntValue2;
                int i5 = this.ka;
                canvas.drawLine(f, 0.0f, i4 + i5, i5, this.f782ms);
            }
        }
        if (xrVar.getMarqueeValue() != 0.0f) {
            try {
                iIntValue = ((Integer) view.getTag(2097610709)).intValue();
            } catch (Exception unused4) {
                iIntValue = 0;
            }
            if (iIntValue >= 0) {
                this.xr.reset();
                this.xr.moveTo(0.0f, 0.0f);
                this.xr.lineTo(this.d * 2, 0.0f);
                this.xr.lineTo(this.d * 2, this.ka * 2);
                this.xr.lineTo(0.0f, this.ka * 2);
                this.xr.lineTo(0.0f, 0.0f);
                this.f782ms.setShader(new LinearGradient(0.0f, 0.0f, this.d * 2, this.ka * 2, new int[]{(int) (xrVar.getMarqueeValue() * (-65536.0f)), (int) ((1.0f - xrVar.getMarqueeValue()) * (-65536.0f))}, (float[]) null, Shader.TileMode.CLAMP));
                this.f782ms.setColor(SupportMenu.CATEGORY_MASK);
                this.f782ms.setStyle(Paint.Style.STROKE);
                this.f782ms.setStrokeWidth(iIntValue);
                canvas.drawPath(this.xr, this.f782ms);
            }
        }
    }

    public void ms(View view, float f) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) (this.c * f);
        view.setTranslationX((this.c - layoutParams.width) / 2);
        if (view instanceof DynamicImageView) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                viewGroup.getChildAt(i).setTranslationX((-(this.c - layoutParams.width)) / 2);
                i++;
            }
        }
        view.setLayoutParams(layoutParams);
    }

    public void ms(View view, int i, int i2) {
        String str;
        this.d = i / 2;
        this.ka = i2 / 2;
        if (this.c == 0 && view.getLayoutParams().width > 0) {
            this.c = view.getLayoutParams().width;
        }
        try {
            str = (String) view.getTag(2097610710);
            try {
                this.ah.addRoundRect(new RectF(0.0f, 0.0f, i, i2), i2 / 2, i2 / 2, Path.Direction.CW);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str = "";
        }
        if ("right".equals(str)) {
            view.setPivotX(this.d * 2);
            view.setPivotY(this.ka);
        } else if ("left".equals(str)) {
            view.setPivotX(0.0f);
            view.setPivotY(this.ka);
        } else {
            view.setPivotX(this.d);
            view.setPivotY(this.ka);
        }
    }
}
