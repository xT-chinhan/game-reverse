package com.bytedance.sdk.openadsdk.core.playable;

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
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.re;

/* JADX INFO: loaded from: classes2.dex */
public class PlayableVideoContainer extends FrameLayout {
    private long ab;
    private float ah;
    private View c;
    private FrameLayout d;
    private View ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Paint f3277ms;
    private View.OnClickListener x;
    private float xr;

    public PlayableVideoContainer(Context context) {
        super(context);
        this.f3277ms = new Paint();
        this.ab = 0L;
        xr();
    }

    private void xr() {
        int iAh = ul.ah(getContext(), 2.0f);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setPadding(iAh, iAh, iAh, iAh);
        addView(frameLayout, -1, -1);
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        this.d = frameLayout2;
        frameLayout.addView(frameLayout2);
        this.ka = ah();
        frameLayout.addView(this.ka, new ViewGroup.MarginLayoutParams(-1, -1));
        this.c = d();
        frameLayout.addView(this.c, new ViewGroup.MarginLayoutParams(-1, -1));
        setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), ul.ah(re.getContext(), 12.0f));
            }
        });
        setClipToOutline(true);
    }

    public void ms() {
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.2
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup.LayoutParams layoutParams = PlayableVideoContainer.this.getLayoutParams();
                layoutParams.width = ul.ah(PlayableVideoContainer.this.getContext(), 94.0f);
                layoutParams.height = ul.ah(PlayableVideoContainer.this.getContext(), 167.0f);
                PlayableVideoContainer.this.setLayoutParams(layoutParams);
            }
        });
    }

    private View ah() {
        int iAh = ul.ah(getContext(), 8.0f);
        int iAh2 = ul.ah(getContext(), 7.0f);
        int iAh3 = ul.ah(getContext(), 5.0f);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setBackgroundColor(Color.parseColor("#77000000"));
        TextView textView = new TextView(getContext());
        textView.setId(2114387599);
        textView.setText("可以\n拖动");
        textView.setTextColor(-1);
        textView.setTextSize(2, 12.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(textView, layoutParams);
        ImageView imageView = new ImageView(getContext());
        t.ms(getContext(), "tt_arrow_up", imageView);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iAh2, iAh3);
        layoutParams2.setMargins(iAh, iAh, iAh, iAh);
        layoutParams2.addRule(14);
        layoutParams2.addRule(2, textView.getId());
        relativeLayout.addView(imageView, layoutParams2);
        ImageView imageView2 = new ImageView(getContext());
        t.ms(getContext(), "tt_arrow_down", imageView2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iAh2, iAh3);
        layoutParams3.setMargins(iAh, iAh, iAh, iAh);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, textView.getId());
        relativeLayout.addView(imageView2, layoutParams3);
        ImageView imageView3 = new ImageView(getContext());
        t.ms(getContext(), "tt_arrow_left", imageView3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iAh3, iAh2);
        layoutParams4.setMargins(iAh, iAh, iAh, iAh);
        layoutParams4.addRule(15);
        layoutParams4.addRule(0, textView.getId());
        relativeLayout.addView(imageView3, layoutParams4);
        ImageView imageView4 = new ImageView(getContext());
        t.ms(getContext(), "tt_arrow_right", imageView4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(iAh3, iAh2);
        layoutParams5.setMargins(iAh, iAh, iAh, iAh);
        layoutParams5.addRule(15);
        layoutParams5.addRule(1, textView.getId());
        relativeLayout.addView(imageView4, layoutParams5);
        relativeLayout.setVisibility(8);
        return relativeLayout;
    }

    private View d() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setBackgroundColor(Color.parseColor("#77000000"));
        TextView textView = new TextView(getContext());
        textView.setId(2114387599);
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
        return this.d;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.xr = motionEvent.getX();
            this.ah = motionEvent.getY();
            this.ab = SystemClock.elapsedRealtime();
        } else {
            if (action == 1) {
                float fAbs = Math.abs(motionEvent.getX() - this.xr);
                float fAbs2 = Math.abs(motionEvent.getY() - this.ah);
                long jElapsedRealtime = SystemClock.elapsedRealtime() - this.ab;
                if (fAbs < 10.0f && fAbs2 < 10.0f && jElapsedRealtime < 200) {
                    ka();
                    return true;
                }
            } else if (action == 2) {
                float x = motionEvent.getX() - this.xr;
                float y = motionEvent.getY() - this.ah;
                if (x != 0.0f && y != 0.0f) {
                    int left = (int) (getLeft() + x);
                    int width = getWidth() + left;
                    int top = (int) (getTop() + y);
                    ms(left, top, width, getHeight() + top);
                }
            } else if (action == 3) {
            }
            c();
            setPressed(false);
        }
        return true;
    }

    private void ka() {
        View.OnClickListener onClickListener = this.x;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    private void c() {
        int height;
        final int height2;
        final int width;
        int width2;
        int iD = ul.d(getContext());
        int iKa = ul.ka(getContext());
        final int left = getLeft();
        final int top = getTop();
        int left2 = getLeft();
        int right = iD - getRight();
        int top2 = getTop();
        int bottom = iKa - getBottom();
        int iAh = ul.ah(getContext(), 20.0f);
        int iMin = Math.min(Math.min(left2, right), Math.min(top2, bottom));
        if (left2 == iMin) {
            getWidth();
            int top3 = getTop();
            int bottom2 = getBottom();
            if (top3 < 0) {
                bottom2 = iAh + getHeight();
                top3 = iAh;
            }
            height2 = bottom2 > iKa ? (iKa - iAh) - getHeight() : top3;
            width = iAh;
        } else if (right == iMin) {
            width2 = (iD - iAh) - getWidth();
            int top4 = getTop();
            int bottom3 = getBottom();
            if (top4 < 0) {
                bottom3 = iAh + getHeight();
                top4 = iAh;
            }
            if (bottom3 > iKa) {
                height = (iKa - iAh) - getHeight();
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
                right2 = iAh + getWidth();
                left3 = iAh;
            }
            width = right2 > iD ? (iD - iAh) - getWidth() : left3;
            height2 = iAh;
        } else {
            int left4 = getLeft();
            int right3 = getRight();
            height = (iKa - iAh) - getHeight();
            if (left4 < 0) {
                right3 = iAh + getWidth();
                left4 = iAh;
            }
            if (right3 > iD) {
                width2 = (iD - iAh) - getWidth();
                width = width2;
                height2 = height;
            } else {
                height2 = height;
                width = left4;
            }
        }
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                int i = left;
                int i2 = (int) (i + ((width - i) * animatedFraction));
                int i3 = top;
                int i4 = (int) (i3 + ((height2 - i3) * animatedFraction));
                PlayableVideoContainer.this.ms(i2, i4, PlayableVideoContainer.this.getWidth() + i2, PlayableVideoContainer.this.getHeight() + i4);
            }
        });
        duration.start();
    }

    public void ms(boolean z) {
        if (z) {
            ul.ms(this.c, 0);
            ul.ms(this.ka, 8);
        } else {
            ul.ms(this.c, 8);
        }
    }

    public void xr(boolean z) {
        if (z) {
            ul.ms(this.ka, 0);
            ul.ms(this.c, 8);
        } else {
            ul.ms(this.ka, 8);
        }
    }

    public void ms(int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.topMargin = i2;
        layoutParams.gravity = 0;
        layout(i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean zDrawChild = super.drawChild(canvas, view, j);
        this.f3277ms.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredHeight(), new int[]{Color.parseColor("#FFDD42"), Color.parseColor("#FFB744") * 1}, (float[]) null, Shader.TileMode.CLAMP));
        this.f3277ms.setColor(SupportMenu.CATEGORY_MASK);
        this.f3277ms.setStyle(Paint.Style.STROKE);
        this.f3277ms.setAntiAlias(true);
        this.f3277ms.setStrokeWidth(ul.ah(getContext(), 4.0f));
        canvas.drawRoundRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), ul.ah(getContext(), 12.0f), ul.ah(getContext(), 12.0f), this.f3277ms);
        return zDrawChild;
    }

    public void setCustomClickListener(View.OnClickListener onClickListener) {
        this.x = onClickListener;
    }
}
