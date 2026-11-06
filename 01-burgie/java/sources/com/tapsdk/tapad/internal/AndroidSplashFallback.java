package com.tapsdk.tapad.internal;

import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.internal.runtime.RustResolvedAsset;
import com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class AndroidSplashFallback {
    private static final long CLOSE_DELAY_MS = 5000;
    private static final long VALID_DELAY_MS = 1000;

    public interface Listener {
        void onFinished(boolean z);

        void onShow(long j);

        void onValidShow();
    }

    public static final class Session {
        private final Runnable complete;
        private final AtomicBoolean finished;
        private final Handler handler;
        private ImageView imageView;
        private final Listener listener;
        private final FrameLayout root;
        private final Runnable valid;

        private int dp(int i) {
            float f = this.root.getResources().getDisplayMetrics().density;
            float f2 = i;
            if (f <= 0.0f) {
                f = 1.0f;
            }
            return Math.round(f2 * f);
        }

        private void finish(boolean z) {
            if (this.finished.compareAndSet(false, true)) {
                this.handler.removeCallbacks(this.valid);
                this.handler.removeCallbacks(this.complete);
                this.listener.onFinished(z);
            }
        }

        static /* synthetic */ void lambda$render$2(ImageView imageView, MechanicalImageLoader.Request request, Bitmap bitmap, Exception exc) {
            if (exc == null) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }

        private TextView pill(String str, float f) {
            TextView textView = new TextView(this.root.getContext());
            textView.setText(str);
            textView.setTextColor(-1);
            textView.setTextSize(f);
            textView.setGravity(17);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1728053248);
            gradientDrawable.setCornerRadius(dp(18));
            textView.setBackground(gradientDrawable);
            return textView;
        }

        private void render(String str) {
            this.root.removeAllViews();
            this.root.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            final ImageView imageView = new ImageView(this.root.getContext());
            this.imageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setBackgroundColor(-15723494);
            this.root.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
            if (RustResolvedAsset.isLocalFileUri(str)) {
                MechanicalImageLoader.load(imageView, str, MechanicalImageLoader.Options.builder().placeholderResId(R.drawable.tapad_default_lava).errorResId(R.drawable.tapad_default_lava).build(), new MechanicalImageLoader.BitmapCallback() { // from class: com.tapsdk.tapad.internal.AndroidSplashFallback$Session$$ExternalSyntheticLambda2
                    @Override // com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader.BitmapCallback
                    public final void onResult(MechanicalImageLoader.Request request, Bitmap bitmap, Exception exc) {
                        AndroidSplashFallback.Session.lambda$render$2(imageView, request, bitmap, exc);
                    }
                });
            } else {
                imageView.setImageResource(R.drawable.tapad_default_lava);
            }
            TextView textViewPill = pill("广告", 12.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dp(48), dp(28), 83);
            layoutParams.leftMargin = dp(16);
            layoutParams.bottomMargin = dp(16);
            this.root.addView(textViewPill, layoutParams);
            TextView textViewPill2 = pill("跳过", 14.0f);
            textViewPill2.setOnClickListener(new View.OnClickListener() { // from class: com.tapsdk.tapad.internal.AndroidSplashFallback$Session$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m105lambda$render$3$comtapsdktapadinternalAndroidSplashFallback$Session(view);
                }
            });
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dp(72), dp(36), 53);
            layoutParams2.rightMargin = dp(16);
            layoutParams2.topMargin = dp(16);
            this.root.addView(textViewPill2, layoutParams2);
        }

        /* JADX INFO: renamed from: lambda$new$0$com-tapsdk-tapad-internal-AndroidSplashFallback$Session, reason: not valid java name */
        /* synthetic */ void m103lambda$new$0$comtapsdktapadinternalAndroidSplashFallback$Session() {
            if (this.finished.get()) {
                return;
            }
            this.listener.onValidShow();
        }

        /* JADX INFO: renamed from: lambda$new$1$com-tapsdk-tapad-internal-AndroidSplashFallback$Session, reason: not valid java name */
        /* synthetic */ void m104lambda$new$1$comtapsdktapadinternalAndroidSplashFallback$Session() {
            finish(false);
        }

        /* JADX INFO: renamed from: lambda$render$3$com-tapsdk-tapad-internal-AndroidSplashFallback$Session, reason: not valid java name */
        /* synthetic */ void m105lambda$render$3$comtapsdktapadinternalAndroidSplashFallback$Session(View view) {
            finish(true);
        }

        public void release() {
            if (this.finished.compareAndSet(false, true)) {
                this.handler.removeCallbacks(this.valid);
                this.handler.removeCallbacks(this.complete);
                MechanicalImageLoader.clear(this.imageView);
                this.root.removeAllViews();
            }
        }

        private Session(FrameLayout frameLayout, String str, Listener listener) {
            Handler handler = new Handler(Looper.getMainLooper());
            this.handler = handler;
            this.finished = new AtomicBoolean(false);
            this.root = frameLayout;
            this.listener = listener;
            Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.AndroidSplashFallback$Session$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m103lambda$new$0$comtapsdktapadinternalAndroidSplashFallback$Session();
                }
            };
            this.valid = runnable;
            Runnable runnable2 = new Runnable() { // from class: com.tapsdk.tapad.internal.AndroidSplashFallback$Session$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m104lambda$new$1$comtapsdktapadinternalAndroidSplashFallback$Session();
                }
            };
            this.complete = runnable2;
            render(str);
            listener.onShow(5000L);
            handler.postDelayed(runnable, 1000L);
            handler.postDelayed(runnable2, 5000L);
        }
    }

    private AndroidSplashFallback() {
    }

    public static Session show(FrameLayout frameLayout, String str, Listener listener) {
        if (frameLayout == null || listener == null || Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Splash fallback must start on the main thread");
        }
        return new Session(frameLayout, str, listener);
    }
}
