package com.byazt.az;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.byazt.hg.fo;
import com.byazt.hg.vk;
import com.byazt.is.aj;
import com.byazt.sd.a;
import com.byazt.wt.rc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 513, 121})
public abstract class x implements View.OnClickListener, View.OnTouchListener {
    public static int aj;
    public final Context uc;
    public static float pr = 0.0f;
    public static float hw = 0.0f;
    public static float hn = 0.0f;
    public static float x = 0.0f;
    public static long c = 0;
    public vk fw = new vk();
    public final com.byazt.ln.x zo = new com.byazt.ln.x();

    public abstract void pr(View view, vk vkVar);

    static {
        aj = 8;
        try {
            if (ViewConfiguration.get(a.getContext()) != null) {
                aj = ViewConfiguration.get(a.getContext()).getScaledTouchSlop();
            }
        } catch (Exception e) {
        }
    }

    public x(Context context) {
        if (context == null) {
            this.uc = a.getContext();
        } else {
            this.uc = context;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!aj.pr()) {
            return;
        }
        pr(view, this.fw);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00d7  */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(final View view, MotionEvent motionEvent) {
        int i;
        this.fw.hn(motionEvent.getDeviceId());
        this.fw.hw(motionEvent.getToolType(0));
        this.fw.x(motionEvent.getSource());
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.fw.c((int) motionEvent.getRawX());
                this.fw.uc((int) motionEvent.getRawY());
                this.fw.pr(motionEvent.getRawX());
                this.fw.hw(motionEvent.getRawY());
                this.fw.pr(System.currentTimeMillis());
                this.fw.hw(motionEvent.getToolType(0));
                this.fw.hn(motionEvent.getDeviceId());
                this.fw.x(motionEvent.getSource());
                c = System.currentTimeMillis();
                this.fw.hw(true);
                rc.pr(motionEvent);
                i = 0;
                break;
            case 1:
                this.fw.hn(motionEvent.getRawX());
                this.fw.x(motionEvent.getRawY());
                if (Math.abs(this.fw.a() - this.fw.k()) >= aj || Math.abs(this.fw.cz() - this.fw.m()) >= aj) {
                    this.fw.hw(false);
                }
                this.fw.hw(System.currentTimeMillis());
                Context context = this.uc;
                if (context == null) {
                    context = a.getContext();
                }
                com.byazt.ln.hw hwVar = (com.byazt.ln.hw) pr(com.byazt.ln.hw.class);
                if (hwVar != null) {
                    hwVar.pr(this.fw);
                }
                if (com.byazt.we.pr.pr(view)) {
                    if (com.byazt.we.pr.pr(view, this.fw.a(), this.fw.cz(), this.fw.k(), this.fw.m())) {
                        return false;
                    }
                    if (!com.byazt.we.pr.hw(view)) {
                        return true;
                    }
                    pr(view, this.fw);
                    return true;
                }
                if (hwVar != null) {
                    Point point = new Point((int) this.fw.a(), (int) this.fw.cz());
                    if (view != null && !hwVar.pr(view, context) && hwVar.pr((View) view.getParent(), point)) {
                        return true;
                    }
                }
                i = 3;
                break;
                break;
            case 2:
                hn += Math.abs(motionEvent.getX() - pr);
                x += Math.abs(motionEvent.getY() - hw);
                pr = motionEvent.getX();
                hw = motionEvent.getY();
                long jCurrentTimeMillis = System.currentTimeMillis() - c;
                this.fw.hn(motionEvent.getRawX());
                this.fw.x(motionEvent.getRawY());
                if (Math.abs(this.fw.a() - this.fw.k()) >= aj || Math.abs(this.fw.cz() - this.fw.m()) >= aj) {
                    this.fw.hw(false);
                }
                if (jCurrentTimeMillis <= 200) {
                    i = 2;
                } else {
                    float f = hn;
                    int i2 = aj;
                    if (f > i2 || hw > i2) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                }
                break;
            case 3:
                if (com.byazt.we.pr.pr(view) && com.byazt.we.pr.hw(view)) {
                    view.post(new Runnable() { // from class: com.byazt.az.x.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (view.isShown()) {
                                x xVar = x.this;
                                xVar.pr(view, xVar.fw);
                            }
                        }
                    });
                    return true;
                }
                i = 4;
                break;
                break;
            default:
                i = -1;
                break;
        }
        this.fw.g().put(motionEvent.getActionMasked(), new pr(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        return false;
    }

    public void hn() {
    }

    public void x() {
    }

    public void pr(fo foVar) {
    }

    public void c(int i) {
    }

    public <T extends com.byazt.ln.pr> T pr(Class<T> cls) {
        return (T) this.zo.pr(cls);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 513, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    public static class pr {
        public double hn;
        public double hw;
        public int pr;
        public long x;

        public pr(int i, double d, double d2, long j) {
            this.pr = -1;
            this.hw = -1.0d;
            this.hn = -1.0d;
            this.x = -1L;
            this.pr = i;
            this.hw = d;
            this.hn = d2;
            this.x = j;
        }
    }
}
