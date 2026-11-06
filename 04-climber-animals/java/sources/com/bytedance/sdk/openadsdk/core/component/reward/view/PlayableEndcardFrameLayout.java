package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public class PlayableEndcardFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ms f2263ms;
    private int xr;

    public interface ms {
        void ms();
    }

    public PlayableEndcardFrameLayout(Context context) {
        super(context);
    }

    public void ms(ms msVar) {
        this.f2263ms = msVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && Math.abs(this.xr - y) > 100) {
                ms();
                this.xr = y;
            }
        } else {
            this.xr = y;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void ms() {
        ms msVar = this.f2263ms;
        if (msVar != null) {
            msVar.ms();
        }
    }
}
