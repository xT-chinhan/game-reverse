package com.byazt.qi;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, 37})
public class pr {
    public String pr = "GesThrough_";
    public List<MotionEvent> hw = new ArrayList();
    public Set<String> hn = Collections.synchronizedSet(new HashSet());

    public void pr(com.byazt.ik.hn hnVar, MotionEvent motionEvent) {
        if (hnVar == null || motionEvent == null || this.hw == null) {
            return;
        }
        pr(hnVar.aj(), hnVar.ww(), motionEvent);
    }

    public void pr(View view, String str, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || this.hw == null) {
            return;
        }
        this.pr = "GesThrough_".concat(String.valueOf(str));
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        if (motionEvent.getAction() == 0) {
            pr();
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(i, i2);
        this.hw.add(motionEventObtain);
    }

    public boolean pr(MotionEvent motionEvent) {
        if (motionEvent == null || this.hn == null) {
            return false;
        }
        return this.hn.contains(motionEvent.getDownTime() + "_" + motionEvent.getPointerId(motionEvent.getActionIndex()));
    }

    public void pr(com.byazt.ik.hn hnVar) {
        if (this.hw.isEmpty() || this.hn == null || hnVar == null || hnVar.aj() == null || hnVar.aj().getRootView() == null) {
            return;
        }
        pr(hnVar.aj());
    }

    public void pr(View view) {
        if (this.hw.isEmpty() || this.hn == null || view == null || view.getRootView() == null) {
            return;
        }
        final View rootView = view.getRootView();
        this.hw.size();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.byazt.qi.pr.1
            @Override // java.lang.Runnable
            public void run() {
                for (MotionEvent motionEvent : pr.this.hw) {
                    if (motionEvent != null) {
                        pr.this.hn.add(motionEvent.getDownTime() + "_" + motionEvent.getPointerId(motionEvent.getActionIndex()));
                        rootView.dispatchTouchEvent(motionEvent);
                        motionEvent.recycle();
                    }
                }
                pr.this.pr();
            }
        }, 300L);
    }

    public void pr() {
        List<MotionEvent> list = this.hw;
        if (list != null) {
            list.clear();
        }
    }
}
