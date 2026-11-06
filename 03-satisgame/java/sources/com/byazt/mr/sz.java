package com.byazt.mr;

import android.view.MotionEvent;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, 110})
public class sz {
    public boolean cp;
    public float l;
    public final n n;
    public float q;
    public int w;
    public int x;
    public boolean qg = false;
    public boolean s = false;
    public boolean fs = true;
    public boolean rv = false;
    public final View.OnTouchListener tj = new View.OnTouchListener() { // from class: com.byazt.mr.sz.1
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (sz.this.n.l()) {
                return sz.this.qg || !sz.this.s;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                sz szVar = sz.this;
                szVar.cp = szVar.n(motionEvent);
                sz.this.q = x;
                sz.this.l = y;
                sz.this.w = (int) x;
                sz.this.x = (int) y;
                sz.this.fs = true;
                if (sz.this.n != null && sz.this.s && !sz.this.qg) {
                    sz.this.n.n(view, true);
                }
            } else if (action == 1) {
                if (Math.abs(x - sz.this.w) > 20.0f || Math.abs(y - sz.this.x) > 20.0f) {
                    sz.this.fs = false;
                }
                if (!sz.this.qg) {
                    sz.this.fs = true;
                }
                sz.this.rv = false;
                sz.this.q = 0.0f;
                sz.this.l = 0.0f;
                sz.this.w = 0;
                if (sz.this.n != null) {
                    sz.this.n.n(view, sz.this.fs);
                }
                sz.this.cp = false;
            } else if (action != 2) {
                if (action == 3) {
                    sz.this.cp = false;
                }
            } else if (sz.this.qg && !sz.this.cp) {
                float f = x - sz.this.q;
                float f2 = y - sz.this.l;
                float fAbs = Math.abs(f);
                float fAbs2 = Math.abs(f2);
                if (!sz.this.rv) {
                    if (fAbs <= 20.0f && fAbs2 <= 20.0f) {
                        return true;
                    }
                    sz.this.rv = true;
                }
                if (sz.this.n != null) {
                    sz.this.n.q();
                }
                sz.this.q = x;
                sz.this.l = y;
            }
            return sz.this.qg || !sz.this.s;
        }
    };

    public interface n {
        boolean l();

        void n(View view, boolean z);

        void q();
    }

    public sz(n nVar) {
        this.n = nVar;
    }

    public void n(View view) {
        if (view != null) {
            view.setOnTouchListener(this.tj);
        }
    }

    public void n(boolean z) {
        this.s = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        int iL = com.byazt.okk.s.l(com.byazt.nf.rv.getContext().getApplicationContext());
        int iW = com.byazt.okk.s.w(com.byazt.nf.rv.getContext().getApplicationContext());
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float f = iL;
        if (rawX <= f * 0.01f || rawX >= f * 0.99f) {
            return true;
        }
        float f2 = iW;
        return rawY <= 0.01f * f2 || rawY >= f2 * 0.99f;
    }
}
