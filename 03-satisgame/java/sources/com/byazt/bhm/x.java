package com.byazt.bhm;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_MPD_REFRESH, 21})
public class x implements View.OnTouchListener {
    public static int s = 10;
    public int l;
    public float n;
    public com.byazt.jmk.fs q;
    public float qg;
    public RectF w = new RectF();
    public long x = 0;
    public final int fs = 200;
    public final int rv = 3;
    public SoftReference<View> tj = new SoftReference<>(null);

    public x(com.byazt.jmk.fs fsVar, int i, final ViewGroup viewGroup) {
        this.l = s;
        this.q = fsVar;
        if (i > 0) {
            this.l = i;
        }
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.byazt.bhm.x.1
                @Override // java.lang.Runnable
                public void run() {
                    View viewFindViewById = viewGroup.findViewById(2097610746);
                    x.this.tj = new SoftReference(viewFindViewById);
                }
            });
        }
    }

    private RectF n(View view) {
        if (view == null) {
            return new RectF();
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        return new RectF(i, iArr[1], i + view.getWidth(), iArr[1] + view.getHeight());
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.byazt.jmk.fs fsVar;
        com.byazt.jmk.fs fsVar2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.w = n(this.tj.get());
            this.n = motionEvent.getRawX();
            this.qg = motionEvent.getRawY();
            this.x = System.currentTimeMillis();
        } else if (action == 1) {
            RectF rectF = this.w;
            if (rectF != null && !rectF.contains(this.n, this.qg)) {
                return false;
            }
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float fAbs = Math.abs(rawX - this.n);
            float fAbs2 = Math.abs(rawY - this.qg);
            int iQg = com.byazt.cq.fs.qg(com.byazt.twc.q.getContext(), Math.abs(rawX - this.n));
            int i = s;
            if (fAbs < i || fAbs2 < i) {
                if ((System.currentTimeMillis() - this.x < 200 || (fAbs < 3.0f && fAbs2 < 3.0f)) && (fsVar = this.q) != null) {
                    fsVar.n();
                }
            } else if (rawX > this.n && iQg > this.l && (fsVar2 = this.q) != null) {
                fsVar2.n();
            }
        }
        return true;
    }
}
