package com.byazt.nc;

import android.view.MotionEvent;
import android.view.View;
import com.byazt.sd.a;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 52, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public class g {
    public float c;
    public int fw;
    public final pr pr;
    public int uc;
    public boolean w;
    public float x;
    public boolean hw = false;
    public boolean hn = false;
    public boolean zo = true;
    public boolean aj = false;
    public final View.OnTouchListener vk = new View.OnTouchListener() { // from class: com.byazt.nc.g.1
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (g.this.pr.ho()) {
                return g.this.hw || !g.this.hn;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    g gVar = g.this;
                    gVar.w = gVar.pr(motionEvent);
                    g.this.x = x;
                    g.this.c = y;
                    g.this.uc = (int) x;
                    g.this.fw = (int) y;
                    g.this.zo = true;
                    if (g.this.pr != null && g.this.hn && !g.this.hw) {
                        g.this.pr.pr(view, true);
                    }
                    break;
                case 1:
                    if (Math.abs(x - g.this.uc) > 20.0f || Math.abs(y - g.this.fw) > 20.0f) {
                        g.this.zo = false;
                    }
                    if (!g.this.hw) {
                        g.this.zo = true;
                    }
                    g.this.aj = false;
                    g.this.x = 0.0f;
                    g.this.c = 0.0f;
                    g.this.uc = 0;
                    if (g.this.pr != null) {
                        g.this.pr.pr(view, g.this.zo);
                    }
                    g.this.w = false;
                    break;
                case 2:
                    if (g.this.hw && !g.this.w) {
                        float f = x - g.this.x;
                        float f2 = y - g.this.c;
                        float fAbs = Math.abs(f);
                        float fAbs2 = Math.abs(f2);
                        if (!g.this.aj) {
                            if (fAbs <= 20.0f && fAbs2 <= 20.0f) {
                                return true;
                            }
                            g.this.aj = true;
                        }
                        if (g.this.pr != null) {
                            g.this.pr.g();
                        }
                        g.this.x = x;
                        g.this.c = y;
                    }
                    break;
                case 3:
                    g.this.w = false;
                    break;
            }
            return g.this.hw || !g.this.hn;
        }
    };

    public interface pr {
        void g();

        boolean ho();

        void pr(View view, boolean z);
    }

    public g(pr prVar) {
        this.pr = prVar;
    }

    public void pr(View view) {
        if (view != null) {
            view.setOnTouchListener(this.vk);
        }
    }

    public void pr(boolean z) {
        this.hn = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pr(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        int iC = er.c(a.getContext().getApplicationContext());
        int iUc = er.uc(a.getContext().getApplicationContext());
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float f = iC;
        if (rawX <= f * 0.01f || rawX >= f * 0.99f) {
            return true;
        }
        float f2 = iUc;
        return rawY <= 0.01f * f2 || rawY >= f2 * 0.99f;
    }
}
