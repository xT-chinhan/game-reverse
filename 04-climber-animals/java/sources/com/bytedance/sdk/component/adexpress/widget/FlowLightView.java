package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.view.View;
import com.bytedance.sdk.component.utils.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FlowLightView extends View {
    private int ab;
    private int ah;
    private int c;
    private Bitmap ch;
    private int d;
    private Paint hi;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    Rect f934ms;
    private int[] ny;
    private Xfermode sl;
    private LinearGradient u;
    private final List<ms> ub;
    private int x;
    Rect xr;
    private PorterDuff.Mode zb;

    public FlowLightView(Context context) {
        super(context);
        this.zb = PorterDuff.Mode.DST_IN;
        this.ub = new ArrayList();
        ms();
    }

    private void ms() {
        this.ah = t.ka(getContext(), "tt_splash_unlock_image_arrow");
        this.d = Color.parseColor("#00ffffff");
        this.ka = Color.parseColor("#ffffffff");
        int color = Color.parseColor("#00ffffff");
        this.c = color;
        this.ab = 10;
        this.x = 40;
        this.ny = new int[]{this.d, this.ka, color};
        setLayerType(1, null);
        this.hi = new Paint(1);
        this.ch = BitmapFactory.decodeResource(getResources(), this.ah);
        this.sl = new PorterDuffXfermode(this.zb);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.ch, this.f934ms, this.xr, this.hi);
        canvas.save();
        Iterator<ms> it = this.ub.iterator();
        while (it.hasNext()) {
            ms next = it.next();
            this.u = new LinearGradient(next.xr, 0.0f, next.xr + this.x, this.ab, this.ny, (float[]) null, Shader.TileMode.CLAMP);
            this.hi.setColor(-1);
            this.hi.setShader(this.u);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.hi);
            this.hi.setShader(null);
            next.ms();
            if (next.xr > getWidth()) {
                it.remove();
            }
        }
        this.hi.setXfermode(this.sl);
        canvas.drawBitmap(this.ch, this.f934ms, this.xr, this.hi);
        this.hi.setXfermode(null);
        canvas.restore();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.ch == null) {
            return;
        }
        this.f934ms = new Rect(0, 0, this.ch.getWidth(), this.ch.getHeight());
        this.xr = new Rect(0, 0, getWidth(), getHeight());
    }

    public void ms(int i) {
        this.ub.add(new ms(i));
        postInvalidate();
    }

    public static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final int f935ms;
        private int xr = 0;

        public ms(int i) {
            this.f935ms = i;
        }

        public void ms() {
            this.xr += this.f935ms;
        }
    }
}
