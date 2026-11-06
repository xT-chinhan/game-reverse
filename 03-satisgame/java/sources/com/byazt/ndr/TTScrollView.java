package com.byazt.ndr;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, 2452})
public class TTScrollView extends ScrollView {
    public int n;
    public boolean q;
    public boolean qg;
    public n s;

    public interface n {
        void n(boolean z);
    }

    public TTScrollView(Context context) {
        super(context);
        this.qg = false;
        this.q = false;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.qg) {
            return;
        }
        try {
            this.qg = true;
            View childAt = ((ViewGroup) getChildAt(0)).getChildAt(1);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.height = getHeight();
            childAt.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            k.qg("TTScrollView", "onLayout error" + th.toString());
        }
    }

    public void setListener(n nVar) {
        this.s = nVar;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        n nVar;
        boolean z = true;
        if (motionEvent.getAction() == 1 && getScrollY() < this.n) {
            if (getScrollY() > this.n / 2) {
                post(new Runnable() { // from class: com.byazt.ndr.TTScrollView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TTScrollView tTScrollView = TTScrollView.this;
                        tTScrollView.smoothScrollTo(0, tTScrollView.n);
                    }
                });
            } else {
                if (getScrollY() > 0) {
                    post(new Runnable() { // from class: com.byazt.ndr.TTScrollView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            TTScrollView.this.smoothScrollTo(0, 0);
                        }
                    });
                } else if (getScrollY() != 0) {
                }
                nVar = this.s;
                if (nVar != null && z != this.q) {
                    nVar.n(z);
                }
                this.q = z;
            }
            z = false;
            nVar = this.s;
            if (nVar != null) {
                nVar.n(z);
            }
            this.q = z;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.n = getChildAt(0).getMeasuredHeight();
        post(new Runnable() { // from class: com.byazt.ndr.TTScrollView.3
            @Override // java.lang.Runnable
            public void run() {
                TTScrollView tTScrollView = TTScrollView.this;
                tTScrollView.smoothScrollTo(0, tTScrollView.n);
            }
        });
    }

    public boolean n() {
        return this.q;
    }
}
