package com.byazt.qi;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.byazt.aa.zo;
import com.byazt.ch.lb;
import com.byazt.ch.nt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public nt aj;
    public boolean g;
    public boolean ho;
    public Context k;
    public boolean m;
    public pr nt;
    public nt vk;
    public String w;
    public int pr = 0;
    public int hw = Integer.MAX_VALUE;
    public int hn = Integer.MAX_VALUE;
    public AtomicBoolean x = new AtomicBoolean(true);
    public float c = Float.MIN_VALUE;
    public float uc = Float.MIN_VALUE;
    public Map<Integer, Float> fw = new HashMap();
    public Map<Integer, Float> zo = new HashMap();

    public c(Context context, nt ntVar, boolean z, boolean z2, boolean z3) {
        this.k = context;
        this.aj = ntVar;
        this.m = z;
        this.g = z2;
        this.ho = z3;
        hn();
    }

    public c(Context context, nt ntVar, nt ntVar2, boolean z, boolean z2, boolean z3) {
        this.k = context;
        this.aj = ntVar;
        this.vk = ntVar2;
        this.m = z;
        this.g = z2;
        this.ho = z3;
        hn();
    }

    private void hn() {
        if (this.g) {
            this.nt = new pr();
        }
        nt ntVar = this.aj;
        if (ntVar == null) {
            return;
        }
        this.pr = ntVar.hn().optInt("slideThreshold");
        this.w = this.aj.hn().optString("slideDirection");
        this.hw = this.aj.hn().optInt("frequency", Integer.MAX_VALUE);
        this.hn = this.aj.hn().optInt("effectiveDuration", Integer.MAX_VALUE);
        this.x.get();
    }

    public void pr() {
        if (this.hn == Integer.MAX_VALUE) {
            return;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.byazt.qi.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.x.set(false);
            }
        }, this.hn);
    }

    public void hw() {
        this.c = Float.MIN_VALUE;
        this.uc = Float.MIN_VALUE;
        this.fw.clear();
        this.zo.clear();
    }

    private void pr(int i) {
        this.fw.remove(Integer.valueOf(i));
        this.zo.remove(Integer.valueOf(i));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean hw(lb lbVar, com.byazt.ik.hn hnVar, MotionEvent motionEvent, boolean z) {
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        switch (actionMasked) {
            case 0:
            case 5:
                this.fw.put(Integer.valueOf(pointerId), Float.valueOf(motionEvent.getX(actionIndex)));
                this.zo.put(Integer.valueOf(pointerId), Float.valueOf(motionEvent.getY(actionIndex)));
                new StringBuilder("ACTION_DOWN/POINTER_DOWN for pointer ").append(pointerId).append(" at (").append(this.fw.get(Integer.valueOf(pointerId))).append(", ").append(this.zo.get(Integer.valueOf(pointerId))).append(")");
                return true;
            case 1:
            case 6:
                if (!this.fw.containsKey(Integer.valueOf(pointerId)) || !this.zo.containsKey(Integer.valueOf(pointerId))) {
                    return false;
                }
                float fFloatValue = this.fw.get(Integer.valueOf(pointerId)).floatValue();
                float fFloatValue2 = this.zo.get(Integer.valueOf(pointerId)).floatValue();
                float x = motionEvent.getX(actionIndex);
                float y = motionEvent.getY(actionIndex);
                if (this.m && Math.abs(x - fFloatValue) <= 10.0f && Math.abs(y - fFloatValue2) <= 10.0f && lbVar != null) {
                    pr(pointerId);
                    lbVar.pr(this.vk, hnVar, hnVar);
                    return true;
                }
                if (this.pr == 0 && lbVar != null) {
                    pr(pointerId);
                    pr(lbVar, this.aj, hnVar);
                    return true;
                }
                int iHw = zo.hw(this.k, x - fFloatValue);
                int iHw2 = zo.hw(this.k, y - fFloatValue2);
                if (TextUtils.equals(this.w, "up")) {
                    iHw = -iHw2;
                } else if (TextUtils.equals(this.w, "down")) {
                    iHw = iHw2;
                } else if (TextUtils.equals(this.w, "left")) {
                    iHw = -iHw;
                } else if (!TextUtils.equals(this.w, "right")) {
                    iHw = (int) Math.abs(Math.sqrt(Math.pow(iHw, 2.0d) + Math.pow(iHw2, 2.0d)));
                }
                if (iHw >= this.pr) {
                    if (lbVar != null) {
                        pr(pointerId);
                        pr(lbVar, this.aj, hnVar);
                        return true;
                    }
                    return true;
                }
                pr(pointerId);
                pr(hnVar);
                return false;
            case 2:
            case 4:
            default:
                return true;
            case 3:
                for (int i = 0; i < motionEvent.getPointerCount(); i++) {
                    int pointerId2 = motionEvent.getPointerId(i);
                    if (this.fw.containsKey(Integer.valueOf(pointerId2)) && this.zo.containsKey(Integer.valueOf(pointerId2))) {
                        pr(pointerId2);
                    }
                }
                return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x002e  */
    /* JADX WARN: Code duplicated, block: B:33:0x008a  */
    /* JADX WARN: Code duplicated, block: B:34:0x008c  */
    /* JADX WARN: Code duplicated, block: B:36:0x0096  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d8  */
    private boolean hn(lb lbVar, com.byazt.ik.hn hnVar, MotionEvent motionEvent, boolean z) {
        float x;
        float y;
        int iHw;
        int iHw2;
        switch (motionEvent.getAction()) {
            case 0:
                this.c = motionEvent.getX();
                this.uc = motionEvent.getY();
                return true;
            case 1:
                x = motionEvent.getX();
                y = motionEvent.getY();
                if (!this.m && Math.abs(x - this.c) <= 10.0f && Math.abs(y - this.uc) <= 10.0f && lbVar != null) {
                    hw();
                    lbVar.pr(this.vk, hnVar, hnVar);
                    return true;
                }
                if (this.pr != 0 && lbVar != null) {
                    hw();
                    pr(lbVar, this.aj, hnVar);
                    return true;
                }
                iHw = zo.hw(this.k, x - this.c);
                iHw2 = zo.hw(this.k, y - this.uc);
                if (TextUtils.equals(this.w, "up")) {
                    iHw = -iHw2;
                } else if (!TextUtils.equals(this.w, "down")) {
                    iHw = iHw2;
                } else if (TextUtils.equals(this.w, "left")) {
                    iHw = -iHw;
                } else if (!TextUtils.equals(this.w, "right")) {
                    iHw = (int) Math.abs(Math.sqrt(Math.pow(iHw, 2.0d) + Math.pow(iHw2, 2.0d)));
                }
                if (iHw >= this.pr) {
                    if (lbVar != null) {
                        hw();
                        pr(lbVar, this.aj, hnVar);
                        return true;
                    }
                    hw();
                    return true;
                }
                hw();
                pr(hnVar);
                return false;
            case 2:
            default:
                return true;
            case 3:
                if (this.c == Float.MIN_VALUE || this.uc == Float.MIN_VALUE) {
                    return false;
                }
                float rawX = motionEvent.getRawX();
                if (motionEvent.getRawY() != 0.0f || rawX != 0.0f) {
                    x = motionEvent.getX();
                    y = motionEvent.getY();
                    if (!this.m) {
                    }
                    if (this.pr != 0) {
                    }
                    iHw = zo.hw(this.k, x - this.c);
                    iHw2 = zo.hw(this.k, y - this.uc);
                    if (TextUtils.equals(this.w, "up")) {
                        iHw = -iHw2;
                    } else if (!TextUtils.equals(this.w, "down")) {
                        iHw = iHw2;
                    } else if (TextUtils.equals(this.w, "left")) {
                        iHw = -iHw;
                    } else if (!TextUtils.equals(this.w, "right")) {
                        iHw = (int) Math.abs(Math.sqrt(Math.pow(iHw, 2.0d) + Math.pow(iHw2, 2.0d)));
                    }
                    if (iHw >= this.pr) {
                        if (lbVar != null) {
                            hw();
                            pr(lbVar, this.aj, hnVar);
                            return true;
                        }
                        hw();
                    } else {
                        hw();
                        pr(hnVar);
                        return false;
                    }
                    break;
                }
                return true;
        }
    }

    public boolean pr(lb lbVar, com.byazt.ik.hn hnVar, MotionEvent motionEvent, boolean z) {
        pr prVar = this.nt;
        if (prVar != null) {
            if (prVar.pr(motionEvent)) {
                return false;
            }
            this.nt.pr(hnVar, motionEvent);
        }
        if (this.ho) {
            return hw(lbVar, hnVar, motionEvent, z);
        }
        return hn(lbVar, hnVar, motionEvent, z);
    }

    private void pr(com.byazt.ik.hn hnVar) {
        pr prVar = this.nt;
        if (prVar != null) {
            prVar.pr(hnVar);
        }
    }

    private void pr(lb lbVar, nt ntVar, com.byazt.ik.hn hnVar) {
        if (this.hw <= 0) {
            pr(hnVar);
            return;
        }
        if (!this.x.get()) {
            pr(hnVar);
            return;
        }
        lbVar.pr(ntVar, hnVar, hnVar);
        int i = this.hw;
        if (i != Integer.MAX_VALUE) {
            this.hw = i - 1;
        }
    }
}
