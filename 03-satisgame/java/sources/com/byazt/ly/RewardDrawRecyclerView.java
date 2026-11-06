package com.byazt.ly;

import android.content.Context;
import android.view.MotionEvent;
import com.byazt.prf.RecyclerView;
import com.byazt.tk.k;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 119, 1639})
public class RewardDrawRecyclerView extends RecyclerView {
    @Override // com.byazt.prf.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public RewardDrawRecyclerView(Context context) {
        super(context);
    }

    @Override // com.byazt.prf.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        k.qg("lfz", motionEvent.toString());
        return false;
    }
}
