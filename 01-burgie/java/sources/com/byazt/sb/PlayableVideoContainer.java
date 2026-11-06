package com.byazt.sb;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Build;
import android.os.SystemClock;
import android.support.v4.internal.view.SupportMenu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.ca.g;
import com.byazt.sd.a;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 765, 1798})
public class PlayableVideoContainer extends FrameLayout {
    public View c;
    public long fw;
    public float hn;
    public float hw;
    public final Paint pr;
    public View uc;
    public FrameLayout x;
    public View.OnClickListener zo;

    public PlayableVideoContainer(Context context) {
        super(context);
        this.pr = new Paint();
        this.fw = 0L;
        hw();
    }

    private void hw() {
        int iHn = er.hn(getContext(), 2.0f);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setPadding(iHn, iHn, iHn, iHn);
        addView(frameLayout, -1, -1);
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        this.x = frameLayout2;
        frameLayout.addView(frameLayout2);
        this.c = hn();
        frameLayout.addView(this.c, new ViewGroup.MarginLayoutParams(-1, -1));
        this.uc = x();
        frameLayout.addView(this.uc, new ViewGroup.MarginLayoutParams(-1, -1));
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new ViewOutlineProvider() { // from class: com.byazt.sb.PlayableVideoContainer.1
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    if (outline == null) {
                        return;
                    }
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), er.hn(a.getContext(), 12.0f));
                }
            });
            setClipToOutline(true);
        }
    }

    public void pr() {
        post(new Runnable() { // from class: com.byazt.sb.PlayableVideoContainer.2
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup.LayoutParams layoutParams = PlayableVideoContainer.this.getLayoutParams();
                layoutParams.width = er.hn(PlayableVideoContainer.this.getContext(), 94.0f);
                layoutParams.height = er.hn(PlayableVideoContainer.this.getContext(), 167.0f);
                PlayableVideoContainer.this.setLayoutParams(layoutParams);
            }
        });
    }

    private View hn() {
        int iHn = er.hn(getContext(), 8.0f);
        int iHn2 = er.hn(getContext(), 7.0f);
        int iHn3 = er.hn(getContext(), 5.0f);
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
        g.pr(getContext(), "tt_arrow_up", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iHn2, iHn3);
        layoutParams2.setMargins(iHn, iHn, iHn, iHn);
        layoutParams2.addRule(14);
        layoutParams2.addRule(2, textView.getId());
        relativeLayout.addView(imageView, layoutParams2);
        ImageView imageView2 = new ImageView(getContext());
        g.pr(getContext(), "tt_arrow_down", imageView2, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iHn2, iHn3);
        layoutParams3.setMargins(iHn, iHn, iHn, iHn);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, textView.getId());
        relativeLayout.addView(imageView2, layoutParams3);
        ImageView imageView3 = new ImageView(getContext());
        g.pr(getContext(), "tt_arrow_left", imageView3, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iHn3, iHn2);
        layoutParams4.setMargins(iHn, iHn, iHn, iHn);
        layoutParams4.addRule(15);
        layoutParams4.addRule(0, textView.getId());
        relativeLayout.addView(imageView3, layoutParams4);
        ImageView imageView4 = new ImageView(getContext());
        g.pr(getContext(), "tt_arrow_right", imageView4, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(iHn3, iHn2);
        layoutParams5.setMargins(iHn, iHn, iHn, iHn);
        layoutParams5.addRule(15);
        layoutParams5.addRule(1, textView.getId());
        relativeLayout.addView(imageView4, layoutParams5);
        relativeLayout.setVisibility(8);
        return relativeLayout;
    }

    private View x() {
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
        return this.x;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                this.hw = motionEvent.getX();
                this.hn = motionEvent.getY();
                this.fw = SystemClock.elapsedRealtime();
                break;
            case 1:
                float fAbs = Math.abs(motionEvent.getX() - this.hw);
                float fAbs2 = Math.abs(motionEvent.getY() - this.hn);
                long jElapsedRealtime = SystemClock.elapsedRealtime() - this.fw;
                if (fAbs < 10.0f && fAbs2 < 10.0f && jElapsedRealtime < 200) {
                    c();
                }
                uc();
                setPressed(false);
                break;
            case 2:
                float x = motionEvent.getX() - this.hw;
                float y = motionEvent.getY() - this.hn;
                if (x != 0.0f && y != 0.0f) {
                    int left = (int) (getLeft() + x);
                    int width = getWidth() + left;
                    int top = (int) (getTop() + y);
                    pr(left, top, width, getHeight() + top);
                }
                break;
            case 3:
                uc();
                setPressed(false);
                break;
        }
        return true;
    }

    private void c() {
        View.OnClickListener onClickListener = this.zo;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    private void uc() {
        final int height;
        final int width;
        int iC = er.c(getContext());
        int iUc = er.uc(getContext());
        final int left = getLeft();
        final int top = getTop();
        int left2 = getLeft();
        int right = iC - getRight();
        int top2 = getTop();
        int bottom = iUc - getBottom();
        int iHn = er.hn(getContext(), 20.0f);
        int iMin = Math.min(Math.min(left2, right), Math.min(top2, bottom));
        if (left2 == iMin) {
            getWidth();
            int top3 = getTop();
            int bottom2 = getBottom();
            if (top3 < 0) {
                bottom2 = iHn + getHeight();
                top3 = iHn;
            }
            if (bottom2 <= iUc) {
                height = top3;
                width = iHn;
            } else {
                height = (iUc - iHn) - getHeight();
                width = iHn;
            }
        } else if (right == iMin) {
            int width2 = (iC - iHn) - getWidth();
            int top4 = getTop();
            int bottom3 = getBottom();
            if (top4 < 0) {
                bottom3 = iHn + getHeight();
                top4 = iHn;
            }
            if (bottom3 <= iUc) {
                width = width2;
                height = top4;
            } else {
                width = width2;
                height = (iUc - iHn) - getHeight();
            }
        } else if (top2 == iMin) {
            int left3 = getLeft();
            int right2 = getRight();
            getHeight();
            if (left3 < 0) {
                right2 = iHn + getWidth();
                left3 = iHn;
            }
            if (right2 <= iC) {
                width = left3;
                height = iHn;
            } else {
                width = (iC - iHn) - getWidth();
                height = iHn;
            }
        } else {
            int left4 = getLeft();
            int right3 = getRight();
            int height2 = (iUc - iHn) - getHeight();
            if (left4 < 0) {
                right3 = iHn + getWidth();
                left4 = iHn;
            }
            if (right3 <= iC) {
                height = height2;
                width = left4;
            } else {
                width = (iC - iHn) - getWidth();
                height = height2;
            }
        }
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.sb.PlayableVideoContainer.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                int i = left;
                int i2 = (int) (i + ((width - i) * animatedFraction));
                int i3 = top;
                int i4 = (int) (i3 + ((height - i3) * animatedFraction));
                PlayableVideoContainer.this.pr(i2, i4, PlayableVideoContainer.this.getWidth() + i2, PlayableVideoContainer.this.getHeight() + i4);
            }
        });
        duration.start();
    }

    public void pr(boolean z) {
        if (!z) {
            er.pr(this.uc, 8);
        } else {
            er.pr(this.uc, 0);
            er.pr(this.c, 8);
        }
    }

    public void hw(boolean z) {
        if (!z) {
            er.pr(this.c, 8);
        } else {
            er.pr(this.c, 0);
            er.pr(this.uc, 8);
        }
    }

    public void pr(int i, int i2, int i3, int i4) {
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
        this.pr.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredHeight(), new int[]{Color.parseColor("#FFDD42"), Color.parseColor("#FFB744") * 1}, (float[]) null, Shader.TileMode.CLAMP));
        this.pr.setColor(SupportMenu.CATEGORY_MASK);
        this.pr.setStyle(Paint.Style.STROKE);
        this.pr.setAntiAlias(true);
        this.pr.setStrokeWidth(er.hn(getContext(), 4.0f));
        if (Build.VERSION.SDK_INT >= 21) {
            canvas.drawRoundRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), er.hn(getContext(), 12.0f), er.hn(getContext(), 12.0f), this.pr);
        }
        return zDrawChild;
    }

    public void setCustomClickListener(View.OnClickListener onClickListener) {
        this.zo = onClickListener;
    }
}
