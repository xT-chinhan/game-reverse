package com.mcto.sspsdk.ssp.taskpage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import com.mcto.sspsdk.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class QyEnergyProgressBar extends View {
    private Paint a;
    private Paint b;
    private Paint c;
    private Paint d;
    private final RectF e;
    private float f;
    private final int g;
    private final int h;
    private final float i;
    private final float j;
    private float[] k;
    private String[] l;
    private Drawable m;

    public QyEnergyProgressBar(Context context) {
        super(context);
        this.e = new RectF();
        this.f = 0.0f;
        this.g = Color.parseColor("#FFD98C");
        this.h = Color.parseColor("#663800");
        this.i = 20.0f;
        this.j = 24.0f;
        this.k = new float[]{0.3f, 0.7f};
        this.l = new String[]{"+4%", "+8%"};
        a();
    }

    private void a() {
        setLayerType(1, null);
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setColor(this.g);
        Paint paint2 = this.a;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        this.a.setShadowLayer(6.0f, 0.0f, 2.0f, 855638016);
        Paint paint3 = new Paint(1);
        this.b = paint3;
        paint3.setColor(this.h);
        this.b.setStyle(style);
        this.c = new Paint(1);
        Paint paint4 = new Paint(1);
        this.d = paint4;
        paint4.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.d.setTextAlign(Paint.Align.CENTER);
        this.d.setTextSize(this.j);
        this.m = ContextCompat.getDrawable(getContext(), R.drawable.qy_lg_rocket_2x);
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = getWidth();
        float f = 2.0f;
        float height = getHeight() / 2.0f;
        float f2 = this.i;
        int i = (int) (1.2f * f2);
        float f3 = f2 / 2.0f;
        this.e.set(0.0f, height - f3, width, f3 + height);
        Path path = new Path();
        float f4 = this.i / 2.0f;
        float[] fArr = {f4, f4, 0.0f, 0.0f, 0.0f, 0.0f, f4, f4};
        RectF rectF = this.e;
        Path.Direction direction = Path.Direction.CW;
        path.addRoundRect(rectF, fArr, direction);
        canvas.drawPath(path, this.a);
        RectF rectF2 = this.e;
        float f5 = this.i / 2.0f;
        rectF2.set(0.0f, height - f5, this.f * width, f5 + height);
        Path path2 = new Path();
        float fMin = Math.min(this.f * width, this.i / 2.0f);
        path2.addRoundRect(this.e, this.f != 1.0f ? new float[]{fMin, fMin, fMin, fMin, fMin, fMin, fMin, fMin} : new float[]{fMin, fMin, 0.0f, 0.0f, 0.0f, 0.0f, fMin, fMin}, direction);
        canvas.drawPath(path2, this.b);
        int i2 = 0;
        while (true) {
            float[] fArr2 = this.k;
            if (i2 >= fArr2.length) {
                return;
            }
            float f6 = fArr2[i2];
            float f7 = f6 * width;
            boolean z = this.f >= f6;
            this.c.setColor(z ? this.h : this.g);
            canvas.drawCircle(f7, height, f2, this.c);
            Drawable drawable = this.m;
            if (drawable != null) {
                float f8 = i / f;
                int i3 = (int) (f7 - f8);
                int i4 = (int) (height - f8);
                drawable.setBounds(i3, i4, i3 + i, i4 + i);
                this.m.draw(canvas);
            }
            canvas.drawText(z ? this.l[i2] : "惊喜掉落", f7, (1.5f * f2) + height + this.j, this.d);
            i2++;
            f = 2.0f;
        }
    }

    public QyEnergyProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new RectF();
        this.f = 0.0f;
        this.g = Color.parseColor("#FFD98C");
        this.h = Color.parseColor("#663800");
        this.i = 20.0f;
        this.j = 24.0f;
        this.k = new float[]{0.3f, 0.7f};
        this.l = new String[]{"+4%", "+8%"};
        a();
    }

    public final void a(int i) {
        this.f = Math.max(0.0f, Math.min(100.0f, i)) / 100.0f;
        invalidate();
    }

    public final void a(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        String[] strArrSplit = str.split(";");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str2 : strArrSplit) {
            String[] strArrSplit2 = str2.split(":");
            if (strArrSplit2.length == 2) {
                try {
                    float f = Float.parseFloat(strArrSplit2[0].trim()) / 100.0f;
                    String str3 = "+" + strArrSplit2[1].trim() + "%";
                    arrayList.add(Float.valueOf(f));
                    arrayList2.add(str3);
                } catch (NumberFormatException e) {
                }
            }
        }
        this.k = new float[arrayList.size()];
        this.l = new String[arrayList2.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            this.k[i] = ((Float) arrayList.get(i)).floatValue();
            this.l[i] = (String) arrayList2.get(i);
        }
    }
}
