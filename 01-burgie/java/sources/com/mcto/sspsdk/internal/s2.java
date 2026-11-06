package com.mcto.sspsdk.internal;

import android.view.MotionEvent;
import android.view.View;
import com.mcto.sspsdk.R;

/* JADX INFO: loaded from: classes2.dex */
public final class s2 implements View.OnTouchListener {
    public final /* synthetic */ y2 a;

    public s2(y2 y2Var) {
        this.a = y2Var;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() != R.id.qy_banner_view) {
            return false;
        }
        this.a.onClick(view);
        return true;
    }
}
