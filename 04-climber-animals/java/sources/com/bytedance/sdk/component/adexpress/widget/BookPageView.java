package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Shader;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class BookPageView extends View {
    Point ab;
    Point ah;
    Point c;
    Point d;
    Point ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    Paint f912ms;
    Paint xr;

    public BookPageView(Context context) {
        super(context);
        this.f912ms = new Paint();
        this.xr = new Paint();
        this.ah = new Point();
        this.d = new Point();
        this.ka = new Point();
        this.c = new Point();
        this.ab = new Point();
        this.f912ms.setColor(-16711936);
        this.f912ms.setTextSize(25.0f);
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.BookPageView.1
            @Override // java.lang.Runnable
            public void run() {
                BookPageView.this.ah.x = BookPageView.this.getWidth() - 10;
                BookPageView.this.ah.y = BookPageView.this.getHeight() - 10;
                BookPageView.this.xr.setShader(new LinearGradient(0.0f, 0.0f, BookPageView.this.getWidth(), BookPageView.this.getHeight(), -7829368, -12303292, Shader.TileMode.MIRROR));
                BookPageView.this.xr.setStyle(Paint.Style.FILL_AND_STROKE);
                BookPageView.this.xr.setStrokeWidth(6.0f);
                BookPageView.this.xr.setShadowLayer(10.0f, 5.0f, 5.0f, -1);
            }
        });
    }

    public void ms(Point point) {
        this.ah.x = point.x;
        this.ah.y = point.y;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ms();
        Path path = new Path();
        path.moveTo(this.c.x, this.c.y);
        path.lineTo(this.ah.x, this.ah.y);
        path.lineTo(this.ab.x, this.ab.y);
        path.close();
        canvas.drawPath(path, this.xr);
    }

    private void ms() {
        this.d.x = getWidth();
        this.d.y = getHeight();
        this.ka.x = (this.ah.x + this.d.x) / 2;
        this.ka.y = (this.ah.y + this.d.y) / 2;
        this.c.x = this.ka.x - (((this.d.y - this.ka.y) * (this.d.y - this.ka.y)) / (this.d.x - this.ka.x));
        this.c.y = this.d.y;
        this.ab.x = this.d.x;
        this.ab.y = this.ka.y - (((this.d.x - this.ka.x) * (this.d.x - this.ka.x)) / (this.d.y - this.ka.y));
    }

    public Path getFilterAreaPath() {
        Path path = new Path();
        path.moveTo(this.d.x, this.d.y);
        path.lineTo(this.c.x, this.c.y);
        path.lineTo(this.ab.x, this.ab.y);
        path.close();
        return path;
    }
}
