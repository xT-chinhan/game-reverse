package com.tapsdk.tapad.internal.ui.views;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public class HotZoneFrameLayout extends FrameLayout {
    public HotZoneFrameLayout(Context context) {
        super(context);
        a();
    }

    public HotZoneFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public HotZoneFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public HotZoneFrameLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a();
    }

    private void a() {
        setBackgroundColor(getResources().getColor(R.color.transparent));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
