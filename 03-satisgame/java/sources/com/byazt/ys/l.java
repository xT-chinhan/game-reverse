package com.byazt.ys;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.byazt.gct.tj;
import com.byazt.gct.wm;
import com.byazt.nf.rv;
import com.byazt.vf.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 122, 18})
public abstract class l implements View.OnClickListener, View.OnTouchListener {
    public static long l = 0;
    public static float n = 0.0f;
    public static float q = 0.0f;
    public static float qg = 0.0f;
    public static int rv = 8;
    public static float s;
    public final Context w;
    public tj x = new tj();
    public final com.byazt.dj.q fs = new com.byazt.dj.q();

    public void l(int i) {
    }

    public abstract void n(View view, tj tjVar);

    public void n(wm wmVar) {
    }

    public void q() {
    }

    public void s() {
    }

    static {
        try {
            if (ViewConfiguration.get(rv.getContext()) != null) {
                rv = ViewConfiguration.get(rv.getContext()).getScaledTouchSlop();
            }
        } catch (Exception unused) {
        }
    }

    public l(Context context) {
        if (context == null) {
            this.w = rv.getContext();
        } else {
            this.w = context;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.byazt.ivn.l.n()) {
            n(view, this.x);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(final View view, MotionEvent motionEvent) {
        int i;
        this.x.s(motionEvent.getDeviceId());
        this.x.qg(motionEvent.getToolType(0));
        this.x.q(motionEvent.getSource());
        int actionMasked = motionEvent.getActionMasked();
        int i2 = 1;
        if (actionMasked != 0) {
            i = 3;
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    s += Math.abs(motionEvent.getX() - n);
                    q += Math.abs(motionEvent.getY() - qg);
                    n = motionEvent.getX();
                    qg = motionEvent.getY();
                    long jCurrentTimeMillis = System.currentTimeMillis() - l;
                    this.x.s(motionEvent.getRawX());
                    this.x.q(motionEvent.getRawY());
                    if (Math.abs(this.x.a() - this.x.d()) >= rv || Math.abs(this.x.py() - this.x.oa()) >= rv) {
                        this.x.qg(false);
                    }
                    if (jCurrentTimeMillis > 200) {
                        float f = s;
                        int i3 = rv;
                        if (f > i3 || qg > i3) {
                        }
                    }
                    i = 2;
                } else if (actionMasked != 3) {
                    i2 = -1;
                } else {
                    if (com.byazt.ii.n.n(view) && com.byazt.ii.n.qg(view)) {
                        view.post(new Runnable() { // from class: com.byazt.ys.l.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (view.isShown()) {
                                    l lVar = l.this;
                                    lVar.n(view, lVar.x);
                                }
                            }
                        });
                        return true;
                    }
                    i2 = 4;
                }
                i = i2;
            } else {
                this.x.s(motionEvent.getRawX());
                this.x.q(motionEvent.getRawY());
                if (Math.abs(this.x.a() - this.x.d()) >= rv || Math.abs(this.x.py() - this.x.oa()) >= rv) {
                    this.x.qg(false);
                }
                this.x.qg(System.currentTimeMillis());
                Context context = this.w;
                if (context == null) {
                    context = rv.getContext();
                }
                com.byazt.dj.qg qgVar = (com.byazt.dj.qg) n(com.byazt.dj.qg.class);
                if (qgVar != null) {
                    qgVar.n(this.x);
                }
                if (com.byazt.ii.n.n(view)) {
                    if (com.byazt.ii.n.n(view, this.x.a(), this.x.py(), this.x.d(), this.x.oa())) {
                        return false;
                    }
                    if (com.byazt.ii.n.qg(view)) {
                        n(view, this.x);
                    }
                    return true;
                }
                if (qgVar != null) {
                    Point point = new Point((int) this.x.a(), (int) this.x.py());
                    if (view != null && !qgVar.n(view, context) && qgVar.n((View) view.getParent(), point)) {
                        return true;
                    }
                }
            }
        } else {
            this.x.l((int) motionEvent.getRawX());
            this.x.w((int) motionEvent.getRawY());
            this.x.n(motionEvent.getRawX());
            this.x.qg(motionEvent.getRawY());
            this.x.n(System.currentTimeMillis());
            this.x.qg(motionEvent.getToolType(0));
            this.x.s(motionEvent.getDeviceId());
            this.x.q(motionEvent.getSource());
            l = System.currentTimeMillis();
            this.x.qg(true);
            x xVar = (x) com.byazt.qp.q.n("armor_service");
            if (xVar != null) {
                xVar.n(motionEvent);
            }
            i = 0;
        }
        this.x.sz().put(motionEvent.getActionMasked(), new n(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        return false;
    }

    public <T extends com.byazt.dj.n> T n(Class<T> cls) {
        return (T) this.fs.n(cls);
    }

    @com.byazt.cp.n(n = {0, 1, 122, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public static class n {
        public int n;
        public long q;
        public double qg;
        public double s;

        public n(int i, double d, double d2, long j) {
            this.n = i;
            this.qg = d;
            this.s = d2;
            this.q = j;
        }
    }
}
