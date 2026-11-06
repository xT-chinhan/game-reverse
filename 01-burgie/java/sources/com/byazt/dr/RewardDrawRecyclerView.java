package com.byazt.dr;

import android.content.Context;
import android.view.MotionEvent;
import com.byazt.ca.ho;
import com.byazt.hr.RecyclerView;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1091, AVMDLDataLoader.KeyIsIsGetChecksumInfo})
public class RewardDrawRecyclerView extends RecyclerView {
    public RewardDrawRecyclerView(Context context) {
        super(context);
    }

    @Override // com.byazt.hr.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.byazt.hr.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ho.hw("lfz", motionEvent.toString());
        return false;
    }
}
