package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.ao;
import com.bytedance.sdk.openadsdk.core.nw.lm;

/* JADX INFO: loaded from: classes2.dex */
public class EasyPlayableContainer extends FrameLayout {
    private final lm ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ab f3434ms;
    private final ao xr;

    public EasyPlayableContainer(Context context, ab abVar, ao aoVar, lm lmVar) {
        super(context);
        this.f3434ms = abVar;
        this.xr = aoVar;
        this.ah = lmVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.xr != null) {
            float fD = ul.d(getContext(), motionEvent.getX());
            float fD2 = ul.d(getContext(), motionEvent.getY());
            if (this.xr.ms(fD, fD2)) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            if (motionEvent.getAction() == 0) {
                com.bytedance.sdk.openadsdk.core.b.xr.ms(this.ah, fD, fD2, 1);
            }
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.xr != null) {
            if (this.xr.ms(ul.d(getContext(), motionEvent.getX()), ul.d(getContext(), motionEvent.getY()))) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ab abVar = this.f3434ms;
        if (abVar != null) {
            abVar.xr();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ab abVar = this.f3434ms;
        if (abVar != null) {
            abVar.ah();
        }
    }
}
