package com.byazt.rg;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.gct.cy;
import com.byazt.gct.oa;
import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 1485})
public class EasyPlayableContainer extends FrameLayout {
    public oa l;
    public final l n;
    public int q;
    public final cy qg;
    public final pk s;

    public EasyPlayableContainer(Context context, l lVar, cy cyVar, pk pkVar, oa oaVar) {
        super(context);
        this.q = 0;
        this.n = lVar;
        this.qg = cyVar;
        this.s = pkVar;
        this.l = oaVar;
    }

    public void setIfStayTop(int i) {
        this.q = i;
    }

    public boolean n() {
        return this.q == 1;
    }

    public static void n(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EasyPlayableContainer) {
                EasyPlayableContainer easyPlayableContainer = (EasyPlayableContainer) childAt;
                if (easyPlayableContainer.n()) {
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
        if (this.qg != null) {
            float fQ = com.byazt.okk.s.q(getContext(), motionEvent.getX());
            float fQ2 = com.byazt.okk.s.q(getContext(), motionEvent.getY());
            if (this.qg.n(fQ, fQ2)) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            if (motionEvent.getAction() == 0) {
                new com.byazt.whi.n(this.s, this.l).n(this.s, fQ, fQ2, 1);
            }
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.qg != null) {
            if (this.qg.n(com.byazt.okk.s.q(getContext(), motionEvent.getX()), com.byazt.okk.s.q(getContext(), motionEvent.getY()))) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        l lVar = this.n;
        if (lVar != null) {
            lVar.qg();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l lVar = this.n;
        if (lVar != null) {
            lVar.s();
        }
    }
}
