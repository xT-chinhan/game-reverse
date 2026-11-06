package com.byazt.bhm;

import android.view.MotionEvent;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_MPD_REFRESH, 18})
public class l implements View.OnTouchListener {
    public int fs;
    public float l;
    public float q;
    public boolean rv;
    public boolean w;
    public com.byazt.jmk.fs x;
    public Map<Integer, Float> n = new HashMap();
    public Map<Integer, Float> qg = new HashMap();
    public Map<Integer, Boolean> s = new HashMap();

    public l(com.byazt.jmk.fs fsVar, int i, boolean z) {
        this.x = fsVar;
        this.fs = i;
        this.rv = z;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006b  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d2  */
    private boolean n(MotionEvent motionEvent) {
        Boolean bool;
        com.byazt.jmk.fs fsVar;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                bool = this.s.get(Integer.valueOf(pointerId));
                if (bool != null || !bool.booleanValue()) {
                    n(pointerId);
                    return false;
                }
                Float f = this.n.get(Integer.valueOf(pointerId));
                Float f2 = this.qg.get(Integer.valueOf(pointerId));
                if (f != null && f2 != null) {
                    int iQg = com.byazt.cq.fs.qg(com.byazt.twc.q.getContext(), Math.abs(f2.floatValue() - f.floatValue()));
                    if (f2.floatValue() - f.floatValue() < 0.0f && iQg > this.fs && (fsVar = this.x) != null) {
                        fsVar.n();
                    }
                }
                n(pointerId);
            } else if (actionMasked == 2) {
                for (int i = 0; i < motionEvent.getPointerCount(); i++) {
                    int pointerId2 = motionEvent.getPointerId(i);
                    float y = motionEvent.getY(i);
                    Float f3 = this.n.get(Integer.valueOf(pointerId2));
                    if (f3 != null) {
                        this.qg.put(Integer.valueOf(pointerId2), Float.valueOf(y));
                        if (Math.abs(y - f3.floatValue()) > 10.0f) {
                            this.s.put(Integer.valueOf(pointerId2), Boolean.TRUE);
                        }
                    }
                }
            } else if (actionMasked == 3) {
                n();
            } else if (actionMasked == 5) {
                this.n.put(Integer.valueOf(pointerId), Float.valueOf(motionEvent.getY(actionIndex)));
                this.s.put(Integer.valueOf(pointerId), Boolean.FALSE);
            } else if (actionMasked == 6) {
                bool = this.s.get(Integer.valueOf(pointerId));
                if (bool != null) {
                }
                n(pointerId);
                return false;
            }
        } else {
            this.n.put(Integer.valueOf(pointerId), Float.valueOf(motionEvent.getY(actionIndex)));
            this.s.put(Integer.valueOf(pointerId), Boolean.FALSE);
        }
        return true;
    }

    private boolean qg(MotionEvent motionEvent) {
        com.byazt.jmk.fs fsVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.q = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.l = y;
                if (Math.abs(y - this.q) > 10.0f) {
                    this.w = true;
                }
            }
        } else {
            if (!this.w) {
                return false;
            }
            int iQg = com.byazt.cq.fs.qg(com.byazt.twc.q.getContext(), Math.abs(this.l - this.q));
            if (this.l - this.q < 0.0f && iQg > this.fs && (fsVar = this.x) != null) {
                fsVar.n();
                this.q = 0.0f;
                this.l = 0.0f;
                this.w = false;
            }
        }
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.rv) {
            return n(motionEvent);
        }
        return qg(motionEvent);
    }

    private void n(int i) {
        this.n.remove(Integer.valueOf(i));
        this.qg.remove(Integer.valueOf(i));
        this.s.remove(Integer.valueOf(i));
    }

    private void n() {
        this.n.clear();
        this.qg.clear();
        this.s.clear();
    }
}
