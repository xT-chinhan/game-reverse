package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;

/* JADX INFO: loaded from: classes2.dex */
public class RewardFullBaseLayout extends FrameLayout {
    private FrameLayout ab;
    float ah;
    private int ao;
    private FrameLayout c;
    private FrameLayout ch;
    long d;
    private int h;
    private FrameLayout hi;
    ms ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected TTProgressBar f2193ms;
    private FrameLayout ny;
    private FrameLayout sl;
    private int u;
    private int ub;
    private FrameLayout x;
    protected TTProgressBar xr;
    private FrameLayout zb;

    public interface ms {
        void ms();
    }

    public RewardFullBaseLayout(Context context) {
        super(context);
    }

    public void ms(com.bytedance.sdk.openadsdk.core.component.reward.d.ms msVar) {
        FrameLayout frameLayoutKa = ka();
        this.c = frameLayoutKa;
        frameLayoutKa.setPadding(this.u, this.ub, this.ao, this.h);
        this.c.setClipChildren(false);
        this.c.addView(xr());
        this.c.addView(ah());
        this.c.addView(d());
        addView(this.c);
        this.ab.addView(msVar.ny());
        this.ny.addView(msVar.ch());
        this.ch.addView(msVar.hi());
    }

    private FrameLayout xr() {
        this.zb = ka();
        FrameLayout frameLayoutKa = ka();
        this.sl = frameLayoutKa;
        this.zb.addView(frameLayoutKa);
        FrameLayout frameLayoutKa2 = ka();
        this.ab = frameLayoutKa2;
        frameLayoutKa2.setVisibility(8);
        this.sl.addView(this.ab);
        FrameLayout frameLayoutKa3 = ka();
        this.x = frameLayoutKa3;
        frameLayoutKa3.setVisibility(8);
        this.sl.addView(this.x);
        this.hi = ka();
        return this.zb;
    }

    private FrameLayout ah() {
        FrameLayout frameLayoutKa = ka();
        this.ny = frameLayoutKa;
        return frameLayoutKa;
    }

    private FrameLayout d() {
        FrameLayout frameLayoutKa = ka();
        this.ch = frameLayoutKa;
        return frameLayoutKa;
    }

    private FrameLayout ka() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    public FrameLayout getExpressFrameContainer() {
        return this.x;
    }

    public FrameLayout getEndCardFrameContainer() {
        return this.ny;
    }

    public FrameLayout getWidgetFrameContainer() {
        return this.ab;
    }

    public FrameLayout getTopFrameContainer() {
        return this.ch;
    }

    public FrameLayout getSceneFrame() {
        return this.sl;
    }

    public FrameLayout getSceneFrameContainer() {
        return this.zb;
    }

    public FrameLayout getEasyPlayableContainer() {
        return this.hi;
    }

    public void ms(int i) {
        if (this.f2193ms == null) {
            this.f2193ms = new TTProgressBar(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(120, 120);
            layoutParams.gravity = 17;
            this.f2193ms.setLayoutParams(layoutParams);
            try {
                this.f2193ms.setIndeterminateDrawable(t.ah(getContext(), "tt_video_loading_progress_bar"));
            } catch (Throwable unused) {
            }
            addView(this.f2193ms);
        }
        this.f2193ms.setVisibility(i);
    }

    public void ms(int i, TTProgressBar tTProgressBar) {
        TTProgressBar tTProgressBar2 = this.xr;
        if (tTProgressBar2 != null) {
            tTProgressBar2.setVisibility(8);
            removeView(this.xr);
        }
        if (tTProgressBar == null) {
            return;
        }
        this.xr = tTProgressBar;
        addView(tTProgressBar);
        this.xr.setVisibility(i);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.ka == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.ah = motionEvent.getY();
            this.d = System.currentTimeMillis();
        } else if (action == 1) {
            float y = motionEvent.getY();
            float f = this.ah;
            if (y < f && Math.abs(y - f) > ul.ah(getContext(), 30.0f)) {
                this.ka.ms();
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void ms(ms msVar) {
        this.ka = msVar;
    }

    public void ms() {
        this.ka = null;
    }

    public void ms(int i, int i2, int i3, int i4) {
        this.u = i;
        this.ub = i2;
        this.ao = i3;
        this.h = i4;
    }
}
