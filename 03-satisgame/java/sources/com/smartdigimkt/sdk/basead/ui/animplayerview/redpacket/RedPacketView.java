package com.smartdigimkt.sdk.basead.ui.animplayerview.redpacket;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.smartdigimkt.r1.c;
import com.smartdigimkt.r4.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public class RedPacketView extends View {
    public static final String TAG = "RedPacketView";
    public double a;
    public double b;
    public final Matrix c;
    public final ArrayList d;
    public final HashMap e;
    public ArrayList f;
    public final Paint g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public Bitmap m;
    public boolean n;
    public final Random o;

    public RedPacketView(Context context) {
        this(context, null);
    }

    public final void a(c cVar, int i) {
        int i2;
        Object obj;
        int i3 = cVar.b;
        if (i3 <= 0 || (i2 = cVar.c) <= 0) {
            return;
        }
        int i4 = i % 4;
        if (i4 == 0) {
            i4 = (i / 4) * 9;
        } else if (i4 == 1) {
            i4 = ((i / 4) * 9) + 2;
        } else if (i4 == 2) {
            i4 = ((i / 4) * 9) + 4;
        } else if (i4 == 3) {
            i4 = ((i / 4) * 9) + 8;
        }
        int i5 = this.i;
        int i6 = i4 / i5;
        int i7 = i4 % i5;
        int i8 = this.k / i5;
        int i9 = this.l / this.j;
        cVar.e = (i7 * i8) + ((i8 - i3) >> 1);
        int iNextInt = this.o.nextInt(21) - 10;
        int i10 = i2 / 3;
        int iNextInt2 = this.o.nextInt(i10) + i10;
        if (i6 > 0 && (obj = this.e.get(Integer.valueOf(i4 - this.i))) != null) {
            float fFloatValue = ((Float) obj).floatValue() + iNextInt2 + iNextInt;
            cVar.f = fFloatValue;
            if ((this.l - fFloatValue) - k.a(getContext(), 5) < i2) {
                if (this.f == null) {
                    this.f = new ArrayList();
                }
                this.f.add(Integer.valueOf(i));
            }
        }
        if (cVar.f == 0.0f) {
            cVar.f = (i6 * i9) + iNextInt2 + iNextInt;
        }
        float f = i2;
        float f2 = cVar.f + f;
        int i11 = this.l;
        if (f2 > i11) {
            cVar.f = (i11 - i2) - k.a(getContext(), 5);
        }
        if (cVar.f < 0.0f) {
            cVar.f = i2 >> 1;
        }
        this.e.put(Integer.valueOf(i4), Float.valueOf(cVar.f + f));
    }

    public int getRedPacketScaleBaseWidth() {
        return this.k;
    }

    public void initRedPacketList(Bitmap bitmap) {
        Bitmap bitmap2;
        this.m = bitmap;
        if ((bitmap == null || !bitmap.isRecycled()) && !this.n) {
            this.n = true;
            try {
                if (this.m == null) {
                    this.m = BitmapFactory.decodeResource(getResources(), k.a(getContext(), "myoffer_icon_red_packet", "drawable"));
                }
                Bitmap bitmap3 = this.m;
                if (bitmap3 == null) {
                    return;
                }
                int redPacketScaleBaseWidth = getRedPacketScaleBaseWidth();
                if (redPacketScaleBaseWidth <= 0) {
                    redPacketScaleBaseWidth = this.k;
                }
                int height = (int) (((double) this.l) / (((((double) redPacketScaleBaseWidth) * this.b) * ((double) bitmap3.getHeight())) / ((double) bitmap3.getWidth())));
                this.j = height;
                this.i = 3;
                int i = (height * 12) / 9;
                this.h = i;
                if (i <= 0 || height <= 0) {
                    return;
                }
                this.d.clear();
                for (int i2 = 0; i2 < this.h; i2++) {
                    Bitmap bitmap4 = this.m;
                    int redPacketScaleBaseWidth2 = getRedPacketScaleBaseWidth();
                    if (redPacketScaleBaseWidth2 <= 0) {
                        redPacketScaleBaseWidth2 = this.k;
                    }
                    c cVar = new c(getContext(), bitmap4, this.a, this.b, redPacketScaleBaseWidth2);
                    a(cVar, i2);
                    this.d.add(cVar);
                }
                ArrayList arrayList = this.f;
                if (arrayList != null && arrayList.size() > 0) {
                    Iterator it = this.f.iterator();
                    while (it.hasNext()) {
                        int iIntValue = ((Integer) it.next()).intValue();
                        if (iIntValue >= 0 && iIntValue < this.d.size()) {
                            c cVar2 = (c) this.d.get(iIntValue);
                            if (cVar2 != null && (bitmap2 = cVar2.a) != null && !bitmap2.isRecycled()) {
                                cVar2.a.recycle();
                                cVar2.a = null;
                            }
                            this.d.remove(iIntValue);
                        }
                    }
                }
            } catch (Exception e) {
                e.getMessage();
            }
            invalidate();
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        c cVar;
        Bitmap bitmap;
        super.onDraw(canvas);
        Iterator it = this.d.iterator();
        while (it.hasNext() && (bitmap = (cVar = (c) it.next()).a) != null) {
            this.c.setTranslate((-cVar.b) >> 1, (-cVar.c) >> 1);
            this.c.postRotate(cVar.d);
            this.c.postTranslate((cVar.b >> 1) + cVar.e, (cVar.c >> 1) + cVar.f);
            canvas.drawBitmap(bitmap, this.c, this.g);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.k = getMeasuredWidth();
        this.l = getMeasuredHeight();
    }

    public void release() {
        this.n = false;
        try {
            Bitmap bitmap = this.m;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.m.recycle();
            }
            for (c cVar : this.d) {
                Bitmap bitmap2 = cVar.a;
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    cVar.a.recycle();
                    cVar.a = null;
                }
            }
            this.d.clear();
            HashMap map = this.e;
            if (map != null) {
                map.clear();
            }
            ArrayList arrayList = this.f;
            if (arrayList != null) {
                arrayList.clear();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public RedPacketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RedPacketView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0.15d;
        this.b = 0.2d;
        this.c = new Matrix();
        this.d = new ArrayList();
        this.e = new HashMap();
        Paint paint = new Paint();
        this.g = paint;
        paint.setFilterBitmap(true);
        paint.setDither(true);
        paint.setAntiAlias(true);
        setLayerType(2, null);
        this.o = new Random(System.currentTimeMillis());
    }
}
