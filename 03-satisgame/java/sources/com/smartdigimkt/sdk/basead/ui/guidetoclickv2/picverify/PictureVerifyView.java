package com.smartdigimkt.sdk.basead.ui.guidetoclickv2.picverify;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import com.smartdigimkt.b2.e;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;
import com.smartdigimkt.y1.o0;
import com.smartdigimkt.z1.a;
import com.smartdigimkt.z1.b;
import com.smartdigimkt.z1.c;
import com.smartdigimkt.z1.d;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: classes3.dex */
public class PictureVerifyView extends RoundImageView {
    public int c;
    public d d;
    public d e;
    public Bitmap f;
    public Path g;
    public final Paint h;
    public final Paint i;
    public final Paint j;
    public int k;
    public c l;
    public a m;
    public int n;

    public PictureVerifyView(Context context) {
        this(context, null);
    }

    public void callback(c cVar) {
        this.l = cVar;
    }

    public void down(int i) {
        if (this.e != null) {
            System.currentTimeMillis();
            this.c = 1;
            d dVar = this.e;
            int width = getWidth() - this.k;
            int i2 = this.e.c;
            dVar.a = (int) (((i / 100.0f) * (width - (i2 * 2))) + i2);
            postInvalidate();
        }
    }

    public void loose() {
        d dVar;
        e eVar;
        this.c = 3;
        System.currentTimeMillis();
        d dVar2 = this.e;
        if (dVar2 == null || (dVar = this.d) == null || Math.abs(dVar2.a - dVar.a) >= 20 || Math.abs(this.e.b - this.d.b) >= 20) {
            this.c = 6;
            postInvalidate();
        } else {
            this.c = 5;
            postInvalidate();
            c cVar = this.l;
            if (cVar != null && (eVar = ((o0) cVar).a.e) != null) {
                eVar.a(11, 16);
            }
        }
        postInvalidate();
    }

    public void move(int i) {
        d dVar;
        if (this.n == i || (dVar = this.e) == null) {
            return;
        }
        this.n = i;
        this.c = 2;
        int width = getWidth() - this.k;
        int i2 = this.e.c;
        dVar.a = (int) (((i / 100.0f) * (width - (i2 * 2))) + i2);
        postInvalidate();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x012b  */
    @Override // com.smartdigimkt.sdk.basead.ui.component.RoundImageView, com.smartdigimkt.sdk.core.common.res.image.RecycleImageView, android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        d dVar;
        Bitmap bitmapCreateBitmap;
        if (getDrawable() != null && getWidth() > 0 && getHeight() >= 0) {
            if (this.d == null) {
                a aVar = this.m;
                int width = getWidth();
                int height = getHeight();
                int i = this.k;
                ((b) aVar).getClass();
                this.d = new d((width - i) - ((int) (((double) width) * 0.15d)), (int) ((((double) height) / 2.0d) - (((double) i) * 1.5d)));
            }
            if (this.e == null) {
                a aVar2 = this.m;
                int width2 = getWidth();
                int height2 = getHeight();
                int i2 = this.k;
                ((b) aVar2).getClass();
                this.e = new d((int) (((double) width2) * 0.15d), (int) ((((double) height2) / 2.0d) - (((double) i2) * 1.5d)));
            }
            if (this.g == null) {
                a aVar3 = this.m;
                int i3 = this.k;
                ((b) aVar3).getClass();
                Path path = new Path();
                path.moveTo(0.0f, 0.0f);
                float f = i3;
                path.rLineTo(f, 0.0f);
                path.rLineTo(0.0f, f);
                float f2 = -i3;
                path.rLineTo(f2, 0.0f);
                path.rLineTo(0.0f, f2);
                path.close();
                this.g = path;
                d dVar2 = this.d;
                path.offset(dVar2.a, dVar2.b);
            }
            if (this.f == null) {
                if (getDrawable() != null) {
                    Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                    getDrawable().setBounds(0, 0, getWidth(), getHeight());
                    canvas2.clipPath(this.g);
                    getDrawable().draw(canvas2);
                    a aVar4 = this.m;
                    Context context = getContext();
                    Path path2 = this.g;
                    ((b) aVar4).getClass();
                    Paint paint = new Paint();
                    paint.setColor(Color.parseColor("#FFFFFF"));
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(k.a(context, 2.0f));
                    paint.setPathEffect(new DashPathEffect(new float[]{20.0f, 20.0f}, 10.0f));
                    canvas2.drawPath(new Path(path2), paint);
                    d dVar3 = this.d;
                    if (dVar3 != null) {
                        int i4 = dVar3.a;
                        int i5 = dVar3.b;
                        int i6 = this.k;
                        bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap2, i4, i5, i6, i6);
                        bitmapCreateBitmap2.recycle();
                    } else {
                        bitmapCreateBitmap = null;
                    }
                } else {
                    bitmapCreateBitmap = null;
                }
                this.f = bitmapCreateBitmap;
            }
        }
        if (getDrawable() == null) {
            return;
        }
        if (this.c != 5 && this.d != null) {
            canvas.drawPath(this.g, this.i);
            d dVar4 = this.d;
            int i7 = dVar4.a;
            int i8 = dVar4.b;
            int i9 = this.k;
            canvas.drawRect(i7, i8, i7 + i9, i8 + i9, this.j);
        }
        int i10 = this.c;
        if ((i10 == 2 || i10 == 4 || i10 == 1 || i10 == 6) && (dVar = this.e) != null) {
            canvas.drawBitmap(this.f, dVar.a, dVar.b, this.h);
        }
    }

    public void setBitmap(Bitmap bitmap) {
        this.g = null;
        this.e = null;
        this.d = null;
        this.f.recycle();
        this.f = null;
        setImageBitmap(bitmap);
    }

    public void setBlockSize(int i) {
        this.k = i;
        this.g = null;
        this.e = null;
        this.d = null;
        this.f = null;
        postInvalidate();
    }

    public void setCaptchaStrategy(a aVar) {
        this.m = aVar;
    }

    public void setTouchEnable(boolean z) {
    }

    public PictureVerifyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PictureVerifyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 4;
        this.k = 50;
        this.n = -1;
        this.m = new b();
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#000000"));
        paint.setAlpha(WorkQueueKt.MASK);
        this.i = paint;
        Paint paint2 = new Paint();
        this.j = paint2;
        paint2.setColor(Color.parseColor("#B5B5B5"));
        paint2.setStrokeWidth(k.a(getContext(), 1.0f));
        paint2.setStyle(Paint.Style.STROKE);
        ((b) this.m).getClass();
        this.h = new Paint();
    }
}
