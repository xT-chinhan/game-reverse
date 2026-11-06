package com.byazt.oz;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.byazt.rb.qg;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_MODULE_NAME, MediaPlayer.MEDIA_PLAYER_OPTION_LICENSE_DIR})
public class RefreshableBannerView extends FrameLayout {
    public final ViewTreeObserver.OnScrollChangedListener l;
    public boolean n;
    public final Rect q;
    public boolean qg;
    public boolean s;
    public n w;

    public interface n {
        void n(boolean z);
    }

    public RefreshableBannerView(Context context) {
        super(context);
        this.n = true;
        this.qg = true;
        this.s = true;
        this.q = new Rect();
        this.l = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.byazt.oz.RefreshableBannerView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                RefreshableBannerView refreshableBannerView = RefreshableBannerView.this;
                refreshableBannerView.qg = refreshableBannerView.getGlobalVisibleRect(refreshableBannerView.q);
                RefreshableBannerView refreshableBannerView2 = RefreshableBannerView.this;
                refreshableBannerView2.n(refreshableBannerView2.qg);
            }
        };
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnScrollChangedListener(this.l);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnScrollChangedListener(this.l);
    }

    public void n(View view) {
        view.setTranslationX(getWidth());
        addView(view);
        ObjectAnimator.ofFloat(view, "translationX", 0.0f).setDuration(250L).start();
        if (getChildCount() > 1) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(getChildAt(0), "translationX", -getWidth()).setDuration(250L);
            duration.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.oz.RefreshableBannerView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (RefreshableBannerView.this.getChildCount() > 1) {
                        RefreshableBannerView.this.removeViewAt(0);
                        qg.n("TMe", "--==-- after remove, view count: " + RefreshableBannerView.this.getChildCount());
                    }
                }
            });
            duration.start();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        boolean z = i == 0;
        this.n = z;
        n(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z) {
        boolean z2 = this.n && this.qg;
        if (z) {
            if (!z2 || this.s) {
                return;
            }
            this.s = true;
            n nVar = this.w;
            if (nVar != null) {
                nVar.n(true);
                return;
            }
            return;
        }
        if (z2 || !this.s) {
            return;
        }
        this.s = false;
        n nVar2 = this.w;
        if (nVar2 != null) {
            nVar2.n(false);
        }
    }

    public void setVisibilityChangeListener(n nVar) {
        this.w = nVar;
    }
}
