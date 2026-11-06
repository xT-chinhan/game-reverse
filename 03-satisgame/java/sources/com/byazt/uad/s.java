package com.byazt.uad;

import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public interface s {

    public interface n {
        Pair<Boolean, Boolean> n(View view, MotionEvent motionEvent);
    }

    void setTag(int i, Object obj);

    void setTouchEventListener(n nVar);
}
