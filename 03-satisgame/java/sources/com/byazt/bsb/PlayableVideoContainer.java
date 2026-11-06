package com.byazt.bsb;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.byazt.nf.rv;
import com.byazt.okk.s;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ASYNC_INIT_CODEC, 2460})
public class PlayableVideoContainer extends FrameLayout {
    public View.OnClickListener fs;
    public View l;
    public final Paint n;
    public FrameLayout q;
    public float qg;
    public float s;
    public View w;
    public long x;

    public PlayableVideoContainer(Context context) {
        super(context);
        this.n = new Paint();
        this.x = 0L;
        qg();
    }

    private void qg() {
        int iS = s.s(getContext(), 2.0f);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setPadding(iS, iS, iS, iS);
        addView(frameLayout, -1, -1);
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        this.q = frameLayout2;
        frameLayout.addView(frameLayout2);
        this.l = s();
        frameLayout.addView(this.l, new ViewGroup.MarginLayoutParams(-1, -1));
        this.w = q();
        frameLayout.addView(this.w, new ViewGroup.MarginLayoutParams(-1, -1));
        setOutlineProvider(new ViewOutlineProvider() { // from class: com.byazt.bsb.PlayableVideoContainer.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), s.s(rv.getContext(), 12.0f));
            }
        });
        setClipToOutline(true);
    }

    public void n() {
        post(new Runnable() { // from class: com.byazt.bsb.PlayableVideoContainer.2
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup.LayoutParams layoutParams = PlayableVideoContainer.this.getLayoutParams();
                layoutParams.width = s.s(PlayableVideoContainer.this.getContext(), 94.0f);
                layoutParams.height = s.s(PlayableVideoContainer.this.getContext(), 167.0f);
                PlayableVideoContainer.this.setLayoutParams(layoutParams);
            }
        });
    }

    private View s() {
        int iS = s.s(getContext(), 8.0f);
        int iS2 = s.s(getContext(), 7.0f);
        int iS3 = s.s(getContext(), 5.0f);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setBackgroundColor(Color.parseColor("#77000000"));
        TextView textView = new TextView(getContext());
        textView.setId(2114387593);
        textView.setText("可以\n拖动");
        textView.setTextColor(-1);
        textView.setTextSize(2, 12.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(textView, layoutParams);
        ImageView imageView = new ImageView(getContext());
        sz.n(getContext(), "tt_arrow_up", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iS2, iS3);
        layoutParams2.setMargins(iS, iS, iS, iS);
        layoutParams2.addRule(14);
        layoutParams2.addRule(2, textView.getId());
        relativeLayout.addView(imageView, layoutParams2);
        ImageView imageView2 = new ImageView(getContext());
        sz.n(getContext(), "tt_arrow_down", imageView2, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iS2, iS3);
        layoutParams3.setMargins(iS, iS, iS, iS);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, textView.getId());
        relativeLayout.addView(imageView2, layoutParams3);
        ImageView imageView3 = new ImageView(getContext());
        sz.n(getContext(), "tt_arrow_left", imageView3, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iS3, iS2);
        layoutParams4.setMargins(iS, iS, iS, iS);
        layoutParams4.addRule(15);
        layoutParams4.addRule(0, textView.getId());
        relativeLayout.addView(imageView3, layoutParams4);
        ImageView imageView4 = new ImageView(getContext());
        sz.n(getContext(), "tt_arrow_right", imageView4, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(iS3, iS2);
        layoutParams5.setMargins(iS, iS, iS, iS);
        layoutParams5.addRule(15);
        layoutParams5.addRule(1, textView.getId());
        relativeLayout.addView(imageView4, layoutParams5);
        relativeLayout.setVisibility(8);
        return relativeLayout;
    }

    private View q() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setBackgroundColor(Color.parseColor("#77000000"));
        TextView textView = new TextView(getContext());
        textView.setId(2114387593);
        textView.setText("视频异常\n无法播放");
        textView.setTextColor(-1);
        textView.setTextSize(2, 12.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(textView, layoutParams);
        relativeLayout.setVisibility(8);
        return relativeLayout;
    }

    public FrameLayout getVideoContainer() {
        return this.q;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.qg = motionEvent.getX();
            this.s = motionEvent.getY();
            this.x = SystemClock.elapsedRealtime();
        } else {
            if (action == 1) {
                float fAbs = Math.abs(motionEvent.getX() - this.qg);
                float fAbs2 = Math.abs(motionEvent.getY() - this.s);
                long jElapsedRealtime = SystemClock.elapsedRealtime() - this.x;
                if (fAbs < 10.0f && fAbs2 < 10.0f && jElapsedRealtime < 200) {
                    l();
                    return true;
                }
            } else if (action == 2) {
                float x = motionEvent.getX() - this.qg;
                float y = motionEvent.getY() - this.s;
                if (x != 0.0f && y != 0.0f) {
                    int left = (int) (getLeft() + x);
                    int width = getWidth() + left;
                    int top = (int) (getTop() + y);
                    n(left, top, width, getHeight() + top);
                }
            } else if (action == 3) {
            }
            w();
            setPressed(false);
        }
        return true;
    }

    private void l() {
        View.OnClickListener onClickListener = this.fs;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    private void w() {
        int height;
        final int height2;
        final int width;
        int width2;
        int iL = s.l(getContext());
        int iW = s.w(getContext());
        final int left = getLeft();
        final int top = getTop();
        int left2 = getLeft();
        int right = iL - getRight();
        int top2 = getTop();
        int bottom = iW - getBottom();
        int iS = s.s(getContext(), 20.0f);
        int iMin = Math.min(Math.min(left2, right), Math.min(top2, bottom));
        if (left2 == iMin) {
            getWidth();
            int top3 = getTop();
            int bottom2 = getBottom();
            if (top3 < 0) {
                bottom2 = iS + getHeight();
                top3 = iS;
            }
            height2 = bottom2 > iW ? (iW - iS) - getHeight() : top3;
            width = iS;
        } else if (right == iMin) {
            width2 = (iL - iS) - getWidth();
            int top4 = getTop();
            int bottom3 = getBottom();
            if (top4 < 0) {
                bottom3 = iS + getHeight();
                top4 = iS;
            }
            if (bottom3 > iW) {
                height = (iW - iS) - getHeight();
                width = width2;
                height2 = height;
            } else {
                width = width2;
                height2 = top4;
            }
        } else if (top2 == iMin) {
            int left3 = getLeft();
            int right2 = getRight();
            getHeight();
            if (left3 < 0) {
                right2 = iS + getWidth();
                left3 = iS;
            }
            width = right2 > iL ? (iL - iS) - getWidth() : left3;
            height2 = iS;
        } else {
            int left4 = getLeft();
            int right3 = getRight();
            height = (iW - iS) - getHeight();
            if (left4 < 0) {
                right3 = iS + getWidth();
                left4 = iS;
            }
            if (right3 > iL) {
                width2 = (iL - iS) - getWidth();
                width = width2;
                height2 = height;
            } else {
                height2 = height;
                width = left4;
            }
        }
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.bsb.PlayableVideoContainer.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                int i = left;
                int i2 = (int) (i + ((width - i) * animatedFraction));
                int i3 = top;
                int i4 = (int) (i3 + ((height2 - i3) * animatedFraction));
                PlayableVideoContainer.this.n(i2, i4, PlayableVideoContainer.this.getWidth() + i2, PlayableVideoContainer.this.getHeight() + i4);
            }
        });
        duration.start();
    }

    public void n(boolean z) {
        if (z) {
            s.n(this.w, 0);
            s.n(this.l, 8);
        } else {
            s.n(this.w, 8);
        }
    }

    public void qg(boolean z) {
        if (z) {
            s.n(this.l, 0);
            s.n(this.w, 8);
        } else {
            s.n(this.l, 8);
        }
    }

    public void n(int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.topMargin = i2;
        layoutParams.gravity = 0;
        layout(i, i2, i3, i4);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean zDrawChild = super.drawChild(canvas, view, j);
        this.n.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredHeight(), new int[]{Color.parseColor("#FFDD42"), Color.parseColor("#FFB744") * 1}, (float[]) null, Shader.TileMode.CLAMP));
        this.n.setColor(SupportMenu.CATEGORY_MASK);
        this.n.setStyle(Paint.Style.STROKE);
        this.n.setAntiAlias(true);
        this.n.setStrokeWidth(s.s(getContext(), 4.0f));
        canvas.drawRoundRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), s.s(getContext(), 12.0f), s.s(getContext(), 12.0f), this.n);
        return zDrawChild;
    }

    public void setCustomClickListener(View.OnClickListener onClickListener) {
        this.fs = onClickListener;
    }
}
