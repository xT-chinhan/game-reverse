package com.byazt.vry;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.support.v4.internal.view.SupportMenu;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.gx.DynamicImageView;
import com.byazt.js.zo;
import com.byazt.rk.fw;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_MDAT_POS, 37})
public class pr {
    public int c;
    public Paint pr;
    public int uc;
    public int x;
    public Path hw = new Path();
    public Path hn = new Path();

    public pr() {
        Paint paint = new Paint();
        this.pr = paint;
        paint.setAntiAlias(true);
    }

    public void pr(Canvas canvas, hw hwVar, View view) {
        int iIntValue;
        int iIntValue2;
        String str;
        if (hwVar.getRippleValue() != 0.0f) {
            if (com.byazt.bg.pr.pr().hn() != null) {
                float[] fArrHw = null;
                try {
                    str = (String) view.getTag(2097610712);
                    try {
                        fArrHw = fw.hw(str);
                    } catch (Exception e) {
                    }
                } catch (Exception e2) {
                    str = "";
                }
                if (str.startsWith("#")) {
                    this.pr.setColor(Color.parseColor(str));
                    this.pr.setAlpha(90);
                } else if (fArrHw != null) {
                    this.pr.setColor(zo.pr(fArrHw[3] * (1.0f - hwVar.getRippleValue()), fArrHw[0] / 256.0f, fArrHw[1] / 256.0f, fArrHw[2] / 256.0f));
                }
            }
            ((ViewGroup) view.getParent()).setClipChildren(true);
            int i = this.x;
            int i2 = this.c;
            canvas.drawCircle(i, i2, Math.min(i, i2) * 2 * hwVar.getRippleValue(), this.pr);
        }
        if (hwVar.getShineValue() != 0.0f) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).setClipChildren(true);
            }
            if (view.getParent().getParent() != null) {
                ((ViewGroup) view.getParent().getParent()).setClipChildren(true);
            }
            this.hw.reset();
            try {
                iIntValue2 = ((Integer) view.getTag(2097610711)).intValue();
            } catch (Exception e3) {
                iIntValue2 = 0;
            }
            if (iIntValue2 >= 0) {
                int shineValue = ((int) ((((this.x * 4) + (iIntValue2 * 2)) + (this.c * 2)) * hwVar.getShineValue())) - ((this.c * 2) + iIntValue2);
                float f = shineValue;
                int i3 = this.c;
                this.pr.setShader(new LinearGradient(f, 0.0f, ((iIntValue2 + i3) / 2) + shineValue, i3 / 2, new int[]{Color.parseColor("#20ffffff"), Color.parseColor("#60ffffff"), Color.parseColor("#65ffffff")}, (float[]) null, Shader.TileMode.MIRROR));
                this.pr.setStrokeWidth(this.x * 2);
                Path path = this.hn;
                if (path != null) {
                    canvas.clipPath(path, Region.Op.INTERSECT);
                }
                int i4 = shineValue + iIntValue2;
                int i5 = this.c;
                canvas.drawLine(f, 0.0f, i4 + i5, i5, this.pr);
            }
        }
        if (hwVar.getMarqueeValue() != 0.0f) {
            try {
                iIntValue = ((Integer) view.getTag(2097610709)).intValue();
            } catch (Exception e4) {
                iIntValue = 0;
            }
            if (iIntValue >= 0) {
                this.hw.reset();
                this.hw.moveTo(0.0f, 0.0f);
                this.hw.lineTo(this.x * 2, 0.0f);
                this.hw.lineTo(this.x * 2, this.c * 2);
                this.hw.lineTo(0.0f, this.c * 2);
                this.hw.lineTo(0.0f, 0.0f);
                this.pr.setShader(new LinearGradient(0.0f, 0.0f, this.x * 2, this.c * 2, new int[]{(int) (hwVar.getMarqueeValue() * (-65536.0f)), (int) ((1.0f - hwVar.getMarqueeValue()) * (-65536.0f))}, (float[]) null, Shader.TileMode.CLAMP));
                this.pr.setColor(SupportMenu.CATEGORY_MASK);
                this.pr.setStyle(Paint.Style.STROKE);
                this.pr.setStrokeWidth(iIntValue);
                canvas.drawPath(this.hw, this.pr);
            }
        }
    }

    public void pr(View view, float f) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) (this.uc * f);
        view.setTranslationX((this.uc - layoutParams.width) / 2);
        if (view instanceof DynamicImageView) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                viewGroup.getChildAt(i).setTranslationX((-(this.uc - layoutParams.width)) / 2);
                i++;
            }
        }
        view.setLayoutParams(layoutParams);
    }

    public void pr(View view, int i, int i2) {
        String str;
        this.x = i / 2;
        this.c = i2 / 2;
        if (this.uc == 0 && view.getLayoutParams().width > 0) {
            this.uc = view.getLayoutParams().width;
        }
        try {
            str = (String) view.getTag(2097610710);
            try {
                this.hn.addRoundRect(new RectF(0.0f, 0.0f, i, i2), i2 / 2, i2 / 2, Path.Direction.CW);
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            str = "";
        }
        if ("right".equals(str)) {
            view.setPivotX(this.x * 2);
            view.setPivotY(this.c);
        } else if ("left".equals(str)) {
            view.setPivotX(0.0f);
            view.setPivotY(this.c);
        } else {
            view.setPivotX(this.x);
            view.setPivotY(this.c);
        }
    }
}
