package com.byazt.uq;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.hg.nt;
import com.byazt.hg.of;
import com.byazt.wt.er;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 209, 1560})
public class EasyPlayableContainer extends FrameLayout {
    public com.byazt.hg.m c;
    public final of hn;
    public final nt hw;
    public final fw pr;
    public int x;

    public EasyPlayableContainer(Context context, fw fwVar, nt ntVar, of ofVar, com.byazt.hg.m mVar) {
        super(context);
        this.x = 0;
        this.pr = fwVar;
        this.hw = ntVar;
        this.hn = ofVar;
        this.c = mVar;
    }

    public void setIfStayTop(int i) {
        this.x = i;
    }

    public boolean pr() {
        return this.x == 1;
    }

    public static void pr(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EasyPlayableContainer) {
                EasyPlayableContainer easyPlayableContainer = (EasyPlayableContainer) childAt;
                if (easyPlayableContainer.pr()) {
                    easyPlayableContainer.bringToFront();
                    z = true;
                }
            }
        }
        if (z) {
            viewGroup.invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.hw != null) {
            float fX = er.x(getContext(), motionEvent.getX());
            float fX2 = er.x(getContext(), motionEvent.getY());
            if (this.hw.pr(fX, fX2)) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            if (motionEvent.getAction() == 0) {
                new com.byazt.fq.pr(this.hn, this.c).pr(this.hn, fX, fX2, 1);
            }
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hw != null) {
            if (this.hw.pr(er.x(getContext(), motionEvent.getX()), er.x(getContext(), motionEvent.getY()))) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fw fwVar = this.pr;
        if (fwVar != null) {
            fwVar.hw();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fw fwVar = this.pr;
        if (fwVar != null) {
            fwVar.hn();
        }
    }
}
