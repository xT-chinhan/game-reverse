package com.byazt.pcc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import com.byazt.gu.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_VIDEO_STACK_SIZE, 673})
public class UgenGridView extends FrameLayout {
    public int l;
    public l n;
    public final LinearLayout q;
    public NestedScrollView qg;
    public HorizontalScrollView s;
    public int w;
    public String x;

    public UgenGridView(Context context) {
        this(context, null);
    }

    public UgenGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UgenGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.x = "column";
        this.q = new LinearLayout(context);
        setClipToPadding(false);
    }

    public void n(l lVar) {
        this.n = lVar;
    }

    public void setGridDirection(String str) {
        this.x = "row".equals(str) ? "row" : "column";
        qg();
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(0, 0, 0, 0);
        this.q.setPadding(i, i2, i3, i4);
    }

    public void setHorizontalSpacing(int i) {
        this.l = Math.max(i, 0);
    }

    public void setVerticalSpacing(int i) {
        this.w = Math.max(i, 0);
    }

    public void n() {
        this.q.removeAllViews();
    }

    public void n(View view, int i, boolean z, boolean z2, int i2, int i3) {
        if (view == null) {
            return;
        }
        LinearLayout linearLayoutN = n(i, z2);
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i3);
        if ("row".equals(this.x)) {
            layoutParams.bottomMargin = z ? 0 : this.w;
        } else {
            layoutParams.rightMargin = z ? 0 : this.l;
        }
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
        frameLayout.addView(view);
        linearLayoutN.addView(frameLayout, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        l lVar = this.n;
        if (lVar != null) {
            lVar.l();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l lVar = this.n;
        if (lVar != null) {
            lVar.w();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        l lVar = this.n;
        if (lVar != null) {
            lVar.n(z);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        l lVar = this.n;
        if (lVar != null) {
            lVar.qg(i, i2, i3, i4);
        }
    }

    private void qg() {
        View orCreateActiveScrollView = getOrCreateActiveScrollView();
        if (getChildCount() != 1 || getChildAt(0) != orCreateActiveScrollView) {
            removeAllViews();
            addView(orCreateActiveScrollView);
        }
        ViewParent parent = this.q.getParent();
        if ((parent instanceof ViewGroup) && parent != orCreateActiveScrollView) {
            ((ViewGroup) parent).removeView(this.q);
        }
        if (this.q.getParent() != orCreateActiveScrollView) {
            if ("row".equals(this.x)) {
                this.s.addView(this.q, new FrameLayout.LayoutParams(-2, -1));
            } else {
                this.qg.addView(this.q, new FrameLayout.LayoutParams(-1, -2));
            }
        }
        this.q.setOrientation(!"row".equals(this.x) ? 1 : 0);
    }

    private View getOrCreateActiveScrollView() {
        if ("row".equals(this.x)) {
            if (this.s == null) {
                HorizontalScrollView horizontalScrollView = new HorizontalScrollView(getContext());
                this.s = horizontalScrollView;
                horizontalScrollView.setFillViewport(false);
                this.s.setHorizontalScrollBarEnabled(true);
                this.s.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            }
            return this.s;
        }
        if (this.qg == null) {
            n nVar = new n(getContext());
            this.qg = nVar;
            nVar.setFillViewport(false);
            this.qg.setVerticalScrollBarEnabled(true);
            this.qg.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        return this.qg;
    }

    private LinearLayout n(int i, boolean z) {
        View childAt = (i < 0 || i >= this.q.getChildCount()) ? null : this.q.getChildAt(i);
        if (childAt instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) childAt;
            n(linearLayout, z);
            return linearLayout;
        }
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation("row".equals(this.x) ? 1 : 0);
        n(linearLayout2, z);
        this.q.addView(linearLayout2);
        return linearLayout2;
    }

    private void n(LinearLayout linearLayout, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        if (linearLayout == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = linearLayout.getLayoutParams();
        if (layoutParams2 instanceof LinearLayout.LayoutParams) {
            layoutParams = (LinearLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.width = -2;
        layoutParams.height = -2;
        if ("row".equals(this.x)) {
            layoutParams.rightMargin = z ? 0 : this.l;
            layoutParams.bottomMargin = 0;
        } else {
            layoutParams.bottomMargin = z ? 0 : this.w;
            layoutParams.rightMargin = 0;
        }
        linearLayout.setLayoutParams(layoutParams);
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_VIDEO_STACK_SIZE, MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_AUDIO_QUEUE_SIZE})
    private static class n extends NestedScrollView {
        public n(Context context) {
            super(context);
        }
    }
}
