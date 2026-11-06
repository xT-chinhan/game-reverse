package com.byazt.son;

import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public interface hn {

    public interface pr {
        Pair<Boolean, Boolean> pr(View view, MotionEvent motionEvent);
    }

    void setTag(int i, Object obj);

    void setTouchEventListener(pr prVar);
}
