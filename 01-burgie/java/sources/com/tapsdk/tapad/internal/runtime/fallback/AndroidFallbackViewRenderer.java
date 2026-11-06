package com.tapsdk.tapad.internal.runtime.fallback;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.R;

/* JADX INFO: loaded from: classes3.dex */
public final class AndroidFallbackViewRenderer implements FallbackPresentationController.Renderer {
    private boolean closeEnabled;
    private TextView closeView;
    private final ViewGroup container;
    private Runnable enableClose;
    private int generation;
    private ImageView imageView;
    private FallbackPresentationController.RenderListener listener;
    private FrameLayout root;

    public AndroidFallbackViewRenderer(ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("missing fallback container");
        }
        this.container = viewGroup;
    }

    private void addCloseControl(Context context, int i, final int i2) {
        TextView textView = new TextView(context);
        this.closeView = textView;
        textView.setText("×");
        this.closeView.setTextColor(-1);
        this.closeView.setTextSize(2, 30.0f);
        this.closeView.setGravity(17);
        this.closeView.setContentDescription("关闭页面");
        this.closeView.setClickable(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-1728053248);
        this.closeView.setBackground(gradientDrawable);
        boolean z = i == 0;
        this.closeEnabled = z;
        this.closeView.setAlpha(z ? 1.0f : 0.5f);
        this.closeView.setOnClickListener(new View.OnClickListener() { // from class: com.tapsdk.tapad.internal.runtime.fallback.AndroidFallbackViewRenderer$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m273lambda$addCloseControl$1$comtapsdktapadinternalruntimefallbackAndroidFallbackViewRenderer(i2, view);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dp(context, 44), dp(context, 44), 8388661);
        layoutParams.topMargin = dp(context, 16);
        layoutParams.rightMargin = dp(context, 16);
        this.root.addView(this.closeView, layoutParams);
        if (this.closeEnabled) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.fallback.AndroidFallbackViewRenderer$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m274lambda$addCloseControl$2$comtapsdktapadinternalruntimefallbackAndroidFallbackViewRenderer(i2);
            }
        };
        this.enableClose = runnable;
        this.root.postDelayed(runnable, i);
    }

    private static int dp(Context context, int i) {
        return Math.round(i * context.getResources().getDisplayMetrics().density);
    }

    private boolean isCurrent(int i) {
        return (this.root == null || this.listener == null || this.generation != i) ? false : true;
    }

    private static FrameLayout.LayoutParams matchParent() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    private void notifyClose(int i) {
        if (isCurrent(i)) {
            this.listener.onClose();
        }
    }

    private static void requireMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("fallback renderer must run on the main thread");
        }
    }

    @Override // com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController.Renderer
    public void destroy() {
        Runnable runnable;
        requireMainThread();
        this.generation++;
        this.closeEnabled = false;
        FrameLayout frameLayout = this.root;
        if (frameLayout != null && (runnable = this.enableClose) != null) {
            frameLayout.removeCallbacks(runnable);
        }
        this.enableClose = null;
        ImageView imageView = this.imageView;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        TextView textView = this.closeView;
        if (textView != null) {
            textView.setOnClickListener(null);
        }
        FrameLayout frameLayout2 = this.root;
        if (frameLayout2 != null) {
            frameLayout2.setOnKeyListener(null);
            ViewGroup viewGroup = (ViewGroup) this.root.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.root);
            }
            this.root.removeAllViews();
        }
        this.root = null;
        this.imageView = null;
        this.closeView = null;
        this.listener = null;
    }

    /* JADX INFO: renamed from: lambda$addCloseControl$1$com-tapsdk-tapad-internal-runtime-fallback-AndroidFallbackViewRenderer, reason: not valid java name */
    /* synthetic */ void m273lambda$addCloseControl$1$comtapsdktapadinternalruntimefallbackAndroidFallbackViewRenderer(int i, View view) {
        if (this.closeEnabled) {
            notifyClose(i);
        }
    }

    /* JADX INFO: renamed from: lambda$addCloseControl$2$com-tapsdk-tapad-internal-runtime-fallback-AndroidFallbackViewRenderer, reason: not valid java name */
    /* synthetic */ void m274lambda$addCloseControl$2$comtapsdktapadinternalruntimefallbackAndroidFallbackViewRenderer(int i) {
        TextView textView;
        if (!isCurrent(i) || (textView = this.closeView) == null) {
            return;
        }
        this.closeEnabled = true;
        textView.setAlpha(1.0f);
    }

    /* JADX INFO: renamed from: lambda$render$0$com-tapsdk-tapad-internal-runtime-fallback-AndroidFallbackViewRenderer, reason: not valid java name */
    /* synthetic */ boolean m275lambda$render$0$comtapsdktapadinternalruntimefallbackAndroidFallbackViewRenderer(int i, View view, int i2, KeyEvent keyEvent) {
        if (i2 != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        notifyClose(i);
        return true;
    }

    @Override // com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController.Renderer
    public void render(int i, FallbackPresentationController.RenderListener renderListener) {
        requireMainThread();
        if (i < 0 || renderListener == null) {
            throw new IllegalArgumentException("invalid fallback render input");
        }
        destroy();
        this.listener = renderListener;
        final int i2 = this.generation + 1;
        this.generation = i2;
        Context context = this.container.getContext();
        this.root = new FrameLayout(context);
        this.root.setBackground(new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{-15394525, -14538184, -15723750}));
        this.root.setFitsSystemWindows(true);
        this.root.setFocusable(true);
        this.root.setFocusableInTouchMode(true);
        this.root.setContentDescription("内容页面");
        this.root.setOnKeyListener(new View.OnKeyListener() { // from class: com.tapsdk.tapad.internal.runtime.fallback.AndroidFallbackViewRenderer$$ExternalSyntheticLambda0
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
                return this.f$0.m275lambda$render$0$comtapsdktapadinternalruntimefallbackAndroidFallbackViewRenderer(i2, view, i3, keyEvent);
            }
        });
        ImageView imageView = new ImageView(context);
        this.imageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.imageView.setImageResource(R.drawable.tapad_bubble_default);
        this.imageView.setContentDescription("内容图片");
        this.root.addView(this.imageView, new FrameLayout.LayoutParams(dp(context, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD), dp(context, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD), 17));
        addCloseControl(context, i, i2);
        this.container.addView(this.root, matchParent());
        this.root.requestFocus();
    }
}
