package com.byazt.jt;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Shader;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, 1680})
public class BookPageView extends View {
    public Point c;
    public Point fw;
    public Point hn;
    public Paint hw;
    public Paint pr;
    public Point uc;
    public Point x;

    public BookPageView(Context context) {
        super(context);
        this.pr = new Paint();
        this.hw = new Paint();
        this.hn = new Point();
        this.x = new Point();
        this.c = new Point();
        this.uc = new Point();
        this.fw = new Point();
        this.pr.setColor(-16711936);
        this.pr.setTextSize(25.0f);
        post(new Runnable() { // from class: com.byazt.jt.BookPageView.1
            @Override // java.lang.Runnable
            public void run() {
                BookPageView.this.hn.x = BookPageView.this.getWidth() - 10;
                BookPageView.this.hn.y = BookPageView.this.getHeight() - 10;
                BookPageView.this.hw.setShader(new LinearGradient(0.0f, 0.0f, BookPageView.this.getWidth(), BookPageView.this.getHeight(), -7829368, -12303292, Shader.TileMode.MIRROR));
                BookPageView.this.hw.setStyle(Paint.Style.FILL_AND_STROKE);
                BookPageView.this.hw.setStrokeWidth(6.0f);
                BookPageView.this.hw.setShadowLayer(10.0f, 5.0f, 5.0f, -1);
            }
        });
    }

    public void pr(Point point) {
        this.hn.x = point.x;
        this.hn.y = point.y;
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        pr();
        Path path = new Path();
        path.moveTo(this.uc.x, this.uc.y);
        path.lineTo(this.hn.x, this.hn.y);
        path.lineTo(this.fw.x, this.fw.y);
        path.close();
        canvas.drawPath(path, this.hw);
    }

    private void pr() {
        this.x.x = getWidth();
        this.x.y = getHeight();
        this.c.x = (this.hn.x + this.x.x) / 2;
        this.c.y = (this.hn.y + this.x.y) / 2;
        this.uc.x = this.c.x - (((this.x.y - this.c.y) * (this.x.y - this.c.y)) / (this.x.x - this.c.x));
        this.uc.y = this.x.y;
        this.fw.x = this.x.x;
        this.fw.y = this.c.y - (((this.x.x - this.c.x) * (this.x.x - this.c.x)) / (this.x.y - this.c.y));
    }

    public Path getFilterAreaPath() {
        Path path = new Path();
        path.moveTo(this.x.x, this.x.y);
        path.lineTo(this.uc.x, this.uc.y);
        path.lineTo(this.fw.x, this.fw.y);
        path.close();
        return path;
    }
}
