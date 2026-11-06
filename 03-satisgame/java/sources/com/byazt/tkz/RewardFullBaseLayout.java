package com.byazt.tkz;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.byazt.kfh.TTProgressBar;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 403, 1188})
public class RewardFullBaseLayout extends FrameLayout {
    public FrameLayout cp;
    public int cy;
    public FrameLayout d;
    public FrameLayout fs;
    public int hd;
    public int k;
    public n l;
    public TTProgressBar n;
    public FrameLayout oa;
    public long q;
    public TTProgressBar qg;
    public FrameLayout rv;
    public float s;
    public int sz;
    public FrameLayout tj;
    public FrameLayout w;
    public FrameLayout x;

    public interface n {
        void n();
    }

    public RewardFullBaseLayout(Context context) {
        super(context);
    }

    public void n(com.byazt.has.n nVar) {
        FrameLayout frameLayoutL = l();
        this.w = frameLayoutL;
        frameLayoutL.setPadding(this.sz, this.k, this.cy, this.hd);
        this.w.setClipChildren(false);
        this.w.addView(qg());
        this.w.addView(s());
        this.w.addView(q());
        addView(this.w);
        this.x.addView(nVar.rv());
        this.rv.addView(nVar.tj());
        this.tj.addView(nVar.cp());
    }

    private FrameLayout qg() {
        this.oa = l();
        FrameLayout frameLayoutL = l();
        this.d = frameLayoutL;
        this.oa.addView(frameLayoutL);
        FrameLayout frameLayoutL2 = l();
        this.x = frameLayoutL2;
        frameLayoutL2.setVisibility(8);
        this.d.addView(this.x);
        FrameLayout frameLayoutL3 = l();
        this.fs = frameLayoutL3;
        frameLayoutL3.setVisibility(8);
        this.d.addView(this.fs);
        this.cp = l();
        return this.oa;
    }

    private FrameLayout s() {
        FrameLayout frameLayoutL = l();
        this.rv = frameLayoutL;
        return frameLayoutL;
    }

    private FrameLayout q() {
        FrameLayout frameLayoutL = l();
        this.tj = frameLayoutL;
        return frameLayoutL;
    }

    private FrameLayout l() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    public FrameLayout getExpressFrameContainer() {
        return this.fs;
    }

    public FrameLayout getEndCardFrameContainer() {
        return this.rv;
    }

    public FrameLayout getWidgetFrameContainer() {
        return this.x;
    }

    public FrameLayout getTopFrameContainer() {
        return this.tj;
    }

    public FrameLayout getSceneFrame() {
        return this.d;
    }

    public FrameLayout getSceneFrameContainer() {
        return this.oa;
    }

    public FrameLayout getEasyPlayableContainer() {
        return this.cp;
    }

    public void n(int i) {
        if (this.n == null) {
            this.n = new TTProgressBar(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(120, 120);
            layoutParams.gravity = 17;
            this.n.setLayoutParams(layoutParams);
            try {
                sz.n(getContext(), "tt_normalscreen_loading", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.tkz.RewardFullBaseLayout.1
                    @Override // com.byazt.qyj.n
                    public void n(Bitmap bitmap) {
                        RewardFullBaseLayout.this.n.setIndeterminateDrawable(TTProgressBar.n(RewardFullBaseLayout.this.getContext(), new BitmapDrawable(RewardFullBaseLayout.this.getContext().getResources(), bitmap), 0, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 0.5f, 0.5f));
                    }
                }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            } catch (Throwable unused) {
            }
            addView(this.n);
        }
        this.n.setVisibility(i);
    }

    public void n(int i, TTProgressBar tTProgressBar) {
        TTProgressBar tTProgressBar2 = this.qg;
        if (tTProgressBar2 != null) {
            tTProgressBar2.setVisibility(8);
            removeView(this.qg);
        }
        if (tTProgressBar == null) {
            return;
        }
        this.qg = tTProgressBar;
        addView(tTProgressBar);
        this.qg.setVisibility(i);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.l == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.s = motionEvent.getY();
            this.q = System.currentTimeMillis();
        } else if (action == 1) {
            float y = motionEvent.getY();
            float f = this.s;
            if (y < f && Math.abs(y - f) > com.byazt.okk.s.s(getContext(), 30.0f)) {
                this.l.n();
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void n(n nVar) {
        this.l = nVar;
    }

    public void n() {
        this.l = null;
    }

    public void n(int i, int i2, int i3, int i4) {
        this.sz = i;
        this.k = i2;
        this.cy = i3;
        this.hd = i4;
    }
}
