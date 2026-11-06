package com.byazt.pg;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 90, 402})
public class PlayableEndcardFrameLayout extends FrameLayout {
    public int hw;
    public pr pr;

    public interface pr {
        void pr();
    }

    public PlayableEndcardFrameLayout(Context context) {
        super(context);
    }

    public void pr(pr prVar) {
        this.pr = prVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.hw = y;
                break;
            case 2:
                if (Math.abs(this.hw - y) > 100) {
                    pr();
                    this.hw = y;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void pr() {
        pr prVar = this.pr;
        if (prVar != null) {
            prVar.pr();
        }
    }
}
