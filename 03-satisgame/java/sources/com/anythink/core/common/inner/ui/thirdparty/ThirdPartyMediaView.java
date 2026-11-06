package com.anythink.core.common.inner.ui.thirdparty;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class ThirdPartyMediaView extends FrameLayout {
    private boolean a;

    public ThirdPartyMediaView(Context context) {
        this(context, null);
    }

    public ThirdPartyMediaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThirdPartyMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0 || action == 1 || action == 2) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.a;
    }

    public void setInterceptTouchEvent(boolean z) {
        this.a = z;
    }
}
