package com.byazt.xt;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.byazt.ca.g;
import com.byazt.fj.TTProgressBar;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME, 1115})
public class RewardFullBaseLayout extends FrameLayout {
    public FrameLayout aj;
    public pr c;
    public FrameLayout fw;
    public int g;
    public float hn;
    public int ho;
    public TTProgressBar hw;
    public FrameLayout k;
    public FrameLayout m;
    public int nt;
    public TTProgressBar pr;
    public FrameLayout uc;
    public FrameLayout vk;
    public FrameLayout w;
    public long x;
    public int yb;
    public FrameLayout zo;

    public interface pr {
        void pr();
    }

    public RewardFullBaseLayout(Context context) {
        super(context);
    }

    public void pr(com.byazt.lu.pr prVar) {
        FrameLayout frameLayoutC = c();
        this.uc = frameLayoutC;
        frameLayoutC.setPadding(this.g, this.ho, this.nt, this.yb);
        this.uc.setClipChildren(false);
        this.uc.addView(hw());
        this.uc.addView(hn());
        this.uc.addView(x());
        addView(this.uc);
        this.fw.addView(prVar.aj());
        this.aj.addView(prVar.vk());
        this.vk.addView(prVar.w());
    }

    private FrameLayout hw() {
        this.m = c();
        FrameLayout frameLayoutC = c();
        this.k = frameLayoutC;
        this.m.addView(frameLayoutC);
        FrameLayout frameLayoutC2 = c();
        this.fw = frameLayoutC2;
        frameLayoutC2.setVisibility(8);
        this.k.addView(this.fw);
        FrameLayout frameLayoutC3 = c();
        this.zo = frameLayoutC3;
        frameLayoutC3.setVisibility(8);
        this.k.addView(this.zo);
        this.w = c();
        return this.m;
    }

    private FrameLayout hn() {
        FrameLayout frameLayoutC = c();
        this.aj = frameLayoutC;
        return frameLayoutC;
    }

    private FrameLayout x() {
        FrameLayout frameLayoutC = c();
        this.vk = frameLayoutC;
        return frameLayoutC;
    }

    private FrameLayout c() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    public FrameLayout getExpressFrameContainer() {
        return this.zo;
    }

    public FrameLayout getEndCardFrameContainer() {
        return this.aj;
    }

    public FrameLayout getWidgetFrameContainer() {
        return this.fw;
    }

    public FrameLayout getTopFrameContainer() {
        return this.vk;
    }

    public FrameLayout getSceneFrame() {
        return this.k;
    }

    public FrameLayout getSceneFrameContainer() {
        return this.m;
    }

    public FrameLayout getEasyPlayableContainer() {
        return this.w;
    }

    public void pr(int i) {
        if (this.pr == null) {
            this.pr = new TTProgressBar(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(120, 120);
            layoutParams.gravity = 17;
            this.pr.setLayoutParams(layoutParams);
            try {
                g.pr(getContext(), "tt_normalscreen_loading", new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.xt.RewardFullBaseLayout.1
                    @Override // com.byazt.ezf.pr
                    public void pr(Bitmap bitmap) {
                        RewardFullBaseLayout.this.pr.setIndeterminateDrawable(TTProgressBar.pr(RewardFullBaseLayout.this.getContext(), new BitmapDrawable(RewardFullBaseLayout.this.getContext().getResources(), bitmap), 0, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 0.5f, 0.5f));
                    }
                }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            } catch (Throwable th) {
            }
            addView(this.pr);
        }
        this.pr.setVisibility(i);
    }

    public void pr(int i, TTProgressBar tTProgressBar) {
        TTProgressBar tTProgressBar2 = this.hw;
        if (tTProgressBar2 != null) {
            tTProgressBar2.setVisibility(8);
            removeView(this.hw);
        }
        if (tTProgressBar == null) {
            return;
        }
        this.hw = tTProgressBar;
        addView(tTProgressBar);
        this.hw.setVisibility(i);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.c == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.hn = motionEvent.getY();
                this.x = System.currentTimeMillis();
                break;
            case 1:
                float y = motionEvent.getY();
                float f = this.hn;
                if (y < f && Math.abs(y - f) > er.hn(getContext(), 30.0f)) {
                    this.c.pr();
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void pr(pr prVar) {
        this.c = prVar;
    }

    public void pr() {
        this.c = null;
    }

    public void pr(int i, int i2, int i3, int i4) {
        this.g = i;
        this.ho = i2;
        this.nt = i3;
        this.yb = i4;
    }
}
