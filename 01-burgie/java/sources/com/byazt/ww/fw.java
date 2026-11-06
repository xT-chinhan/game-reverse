package com.byazt.ww;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 576, 62})
public class fw implements View.OnTouchListener {
    public static int hn = 10;
    public int c;
    public float hw;
    public float pr;
    public com.byazt.yhm.zo x;
    public RectF uc = new RectF();
    public long fw = 0;
    public final int zo = 200;
    public final int aj = 3;
    public SoftReference<View> vk = new SoftReference<>(null);

    public fw(com.byazt.yhm.zo zoVar, int i, final ViewGroup viewGroup) {
        this.c = hn;
        this.x = zoVar;
        if (i > 0) {
            this.c = i;
        }
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.byazt.ww.fw.1
                @Override // java.lang.Runnable
                public void run() {
                    View viewFindViewById = viewGroup.findViewById(2097610746);
                    fw.this.vk = new SoftReference(viewFindViewById);
                }
            });
        }
    }

    private RectF pr(View view) {
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
        com.byazt.yhm.zo zoVar;
        com.byazt.yhm.zo zoVar2;
        switch (motionEvent.getAction()) {
            case 0:
                this.uc = pr(this.vk.get());
                this.pr = motionEvent.getRawX();
                this.hw = motionEvent.getRawY();
                this.fw = System.currentTimeMillis();
                return true;
            case 1:
                RectF rectF = this.uc;
                if (rectF != null && !rectF.contains(this.pr, this.hw)) {
                    return false;
                }
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float fAbs = Math.abs(rawX - this.pr);
                float fAbs2 = Math.abs(rawY - this.hw);
                int iHw = com.byazt.js.zo.hw(com.byazt.dj.x.getContext(), Math.abs(rawX - this.pr));
                int i = hn;
                if (fAbs >= i && fAbs2 >= i) {
                    if (rawX > this.pr && iHw > this.c && (zoVar2 = this.x) != null) {
                        zoVar2.pr();
                        return true;
                    }
                    return true;
                }
                if ((System.currentTimeMillis() - this.fw < 200 || (fAbs < 3.0f && fAbs2 < 3.0f)) && (zoVar = this.x) != null) {
                    zoVar.pr();
                    return true;
                }
                return true;
            default:
                return true;
        }
    }
}
