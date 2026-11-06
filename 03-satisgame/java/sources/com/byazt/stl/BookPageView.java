package com.byazt.stl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Shader;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 1841})
public class BookPageView extends View {
    public Point l;
    public Paint n;
    public Point q;
    public Paint qg;
    public Point s;
    public Point w;
    public Point x;

    public BookPageView(Context context) {
        super(context);
        this.n = new Paint();
        this.qg = new Paint();
        this.s = new Point();
        this.q = new Point();
        this.l = new Point();
        this.w = new Point();
        this.x = new Point();
        this.n.setColor(-16711936);
        this.n.setTextSize(25.0f);
        post(new Runnable() { // from class: com.byazt.stl.BookPageView.1
            @Override // java.lang.Runnable
            public void run() {
                BookPageView.this.s.x = BookPageView.this.getWidth() - 10;
                BookPageView.this.s.y = BookPageView.this.getHeight() - 10;
                BookPageView.this.qg.setShader(new LinearGradient(0.0f, 0.0f, BookPageView.this.getWidth(), BookPageView.this.getHeight(), -7829368, -12303292, Shader.TileMode.MIRROR));
                BookPageView.this.qg.setStyle(Paint.Style.FILL_AND_STROKE);
                BookPageView.this.qg.setStrokeWidth(6.0f);
                BookPageView.this.qg.setShadowLayer(10.0f, 5.0f, 5.0f, -1);
            }
        });
    }

    public void n(Point point) {
        this.s.x = point.x;
        this.s.y = point.y;
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        n();
        Path path = new Path();
        path.moveTo(this.w.x, this.w.y);
        path.lineTo(this.s.x, this.s.y);
        path.lineTo(this.x.x, this.x.y);
        path.close();
        canvas.drawPath(path, this.qg);
    }

    private void n() {
        this.q.x = getWidth();
        this.q.y = getHeight();
        this.l.x = (this.s.x + this.q.x) / 2;
        this.l.y = (this.s.y + this.q.y) / 2;
        this.w.x = this.l.x - (((this.q.y - this.l.y) * (this.q.y - this.l.y)) / (this.q.x - this.l.x));
        this.w.y = this.q.y;
        this.x.x = this.q.x;
        this.x.y = this.l.y - (((this.q.x - this.l.x) * (this.q.x - this.l.x)) / (this.q.y - this.l.y));
    }

    public Path getFilterAreaPath() {
        Path path = new Path();
        path.moveTo(this.q.x, this.q.y);
        path.lineTo(this.w.x, this.w.y);
        path.lineTo(this.x.x, this.x.y);
        path.close();
        return path;
    }
}
