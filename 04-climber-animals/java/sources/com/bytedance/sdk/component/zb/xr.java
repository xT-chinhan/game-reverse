package com.bytedance.sdk.component.zb;

import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public interface xr {

    public interface ms {
        Pair<Boolean, Boolean> ms(View view, MotionEvent motionEvent);
    }

    void setTag(int i, Object obj);

    void setTouchEventListener(ms msVar);
}
