package com.byazt.ww;

import android.view.MotionEvent;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 576, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements View.OnTouchListener {
    public boolean aj;
    public float c;
    public com.byazt.yhm.zo fw;
    public boolean uc;
    public float x;
    public int zo;
    public Map<Integer, Float> pr = new HashMap();
    public Map<Integer, Float> hw = new HashMap();
    public Map<Integer, Boolean> hn = new HashMap();

    public c(com.byazt.yhm.zo zoVar, int i, boolean z) {
        this.aj = false;
        this.fw = zoVar;
        this.zo = i;
        this.aj = z;
    }

    private boolean pr(MotionEvent motionEvent) {
        com.byazt.yhm.zo zoVar;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        switch (actionMasked) {
            case 0:
            case 5:
                this.pr.put(Integer.valueOf(pointerId), Float.valueOf(motionEvent.getY(actionIndex)));
                this.hn.put(Integer.valueOf(pointerId), Boolean.FALSE);
                return true;
            case 1:
            case 6:
                Boolean bool = this.hn.get(Integer.valueOf(pointerId));
                if (bool == null || !bool.booleanValue()) {
                    pr(pointerId);
                    return false;
                }
                Float f = this.pr.get(Integer.valueOf(pointerId));
                Float f2 = this.hw.get(Integer.valueOf(pointerId));
                if (f != null && f2 != null) {
                    int iHw = com.byazt.js.zo.hw(com.byazt.dj.x.getContext(), Math.abs(f2.floatValue() - f.floatValue()));
                    if (f2.floatValue() - f.floatValue() < 0.0f && iHw > this.zo && (zoVar = this.fw) != null) {
                        zoVar.pr();
                    }
                }
                pr(pointerId);
                return true;
            case 2:
                break;
            case 3:
                pr();
                return true;
            case 4:
            default:
                return true;
        }
        for (int i = 0; i < motionEvent.getPointerCount(); i++) {
            int pointerId2 = motionEvent.getPointerId(i);
            float y = motionEvent.getY(i);
            Float f3 = this.pr.get(Integer.valueOf(pointerId2));
            if (f3 != null) {
                this.hw.put(Integer.valueOf(pointerId2), Float.valueOf(y));
                if (Math.abs(y - f3.floatValue()) > 10.0f) {
                    this.hn.put(Integer.valueOf(pointerId2), Boolean.TRUE);
                }
            }
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean hw(MotionEvent motionEvent) {
        com.byazt.yhm.zo zoVar;
        switch (motionEvent.getAction()) {
            case 0:
                this.x = motionEvent.getY();
                return true;
            case 1:
                if (!this.uc) {
                    return false;
                }
                int iHw = com.byazt.js.zo.hw(com.byazt.dj.x.getContext(), Math.abs(this.c - this.x));
                if (this.c - this.x < 0.0f && iHw > this.zo && (zoVar = this.fw) != null) {
                    zoVar.pr();
                    this.x = 0.0f;
                    this.c = 0.0f;
                    this.uc = false;
                }
                return true;
            case 2:
                float y = motionEvent.getY();
                this.c = y;
                if (Math.abs(y - this.x) > 10.0f) {
                    this.uc = true;
                }
                return true;
            default:
                return true;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.aj) {
            return pr(motionEvent);
        }
        return hw(motionEvent);
    }

    private void pr(int i) {
        this.pr.remove(Integer.valueOf(i));
        this.hw.remove(Integer.valueOf(i));
        this.hn.remove(Integer.valueOf(i));
    }

    private void pr() {
        this.pr.clear();
        this.hw.clear();
        this.hn.clear();
    }
}
