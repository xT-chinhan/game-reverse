package com.tapsdk.tapad.internal;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tapsdk.tapad.internal.ionia.IoniaAdWindowTracker;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class AndroidInterstitialFallback {
    private static final long AUTO_CLOSE_MS = 3000;
    private static final long VALID_DELAY_MS = 800;

    public interface Listener {
        void onClose();

        void onShow();

        void onValidShow();
    }

    public static final class Session {
        private final Dialog dialog;
        private final IoniaAdWindowTracker ioniaTracker;
        private final Listener listener;
        private final AtomicBoolean terminal = new AtomicBoolean(false);
        private boolean callbacksEnabled = true;
        private final Handler handler = new Handler(Looper.getMainLooper());
        private final Runnable validRunnable = new Runnable() { // from class: com.tapsdk.tapad.internal.AndroidInterstitialFallback$Session$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m102lambda$new$0$comtapsdktapadinternalAndroidInterstitialFallback$Session();
            }
        };
        private final Runnable closeRunnable = new Runnable() { // from class: com.tapsdk.tapad.internal.AndroidInterstitialFallback$Session$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.close();
            }
        };

        public Session(Activity activity, Listener listener, IoniaAdWindowTracker ioniaAdWindowTracker) {
            this.listener = listener;
            this.ioniaTracker = ioniaAdWindowTracker;
            this.dialog = new Dialog(activity, R.style.Theme.Black.NoTitleBar.Fullscreen) { // from class: com.tapsdk.tapad.internal.AndroidInterstitialFallback.Session.1
                @Override // android.app.Dialog, android.view.Window.Callback
                public void onWindowFocusChanged(boolean z) {
                    super.onWindowFocusChanged(z);
                    if (Session.this.ioniaTracker == null || Session.this.terminal.get()) {
                        return;
                    }
                    if (z) {
                        Session.this.ioniaTracker.onShown();
                    } else {
                        Session.this.ioniaTracker.onHidden();
                    }
                }
            };
            configureDialog(activity);
        }

        private void configureDialog(Activity activity) {
            FrameLayout frameLayout = new FrameLayout(activity) { // from class: com.tapsdk.tapad.internal.AndroidInterstitialFallback.Session.2
                @Override // android.view.ViewGroup, android.view.View
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    if (Session.this.ioniaTracker != null) {
                        Session.this.ioniaTracker.onTouchEvent(motionEvent);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                }
            };
            frameLayout.setBackgroundColor(Color.rgb(18, 18, 18));
            ImageView imageView = new ImageView(activity);
            imageView.setImageResource(com.tapsdk.tapad.R.drawable.tapad_default_lava);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
            TextView textView = new TextView(activity);
            textView.setText("广告");
            textView.setTextColor(-1);
            textView.setTextSize(12.0f);
            textView.setGravity(17);
            textView.setBackgroundColor(1711276032);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(AndroidInterstitialFallback.dp(activity, 44), AndroidInterstitialFallback.dp(activity, 26), 83);
            layoutParams.leftMargin = AndroidInterstitialFallback.dp(activity, 16);
            layoutParams.bottomMargin = AndroidInterstitialFallback.dp(activity, 24);
            frameLayout.addView(textView, layoutParams);
            TextView textView2 = new TextView(activity);
            textView2.setText("关闭");
            textView2.setTextColor(-1);
            textView2.setTextSize(14.0f);
            textView2.setGravity(17);
            textView2.setBackgroundColor(-2013265920);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tapsdk.tapad.internal.AndroidInterstitialFallback$Session$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m101lambda$configureDialog$1$comtapsdktapadinternalAndroidInterstitialFallback$Session(view);
                }
            });
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(AndroidInterstitialFallback.dp(activity, 56), AndroidInterstitialFallback.dp(activity, 36), 53);
            layoutParams2.rightMargin = AndroidInterstitialFallback.dp(activity, 16);
            layoutParams2.topMargin = AndroidInterstitialFallback.dp(activity, 24);
            frameLayout.addView(textView2, layoutParams2);
            this.dialog.setContentView(frameLayout);
            this.dialog.setCancelable(false);
            Window window = this.dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(ViewCompat.MEASURED_STATE_MASK));
                window.setLayout(-1, -1);
                window.addFlags(128);
            }
        }

        public void close() {
            Listener listener;
            if (this.terminal.compareAndSet(false, true)) {
                this.handler.removeCallbacks(this.validRunnable);
                this.handler.removeCallbacks(this.closeRunnable);
                IoniaAdWindowTracker ioniaAdWindowTracker = this.ioniaTracker;
                if (ioniaAdWindowTracker != null) {
                    ioniaAdWindowTracker.onHidden();
                }
                if (this.dialog.isShowing()) {
                    this.dialog.dismiss();
                }
                if (!this.callbacksEnabled || (listener = this.listener) == null) {
                    return;
                }
                listener.onClose();
            }
        }

        /* JADX INFO: renamed from: lambda$configureDialog$1$com-tapsdk-tapad-internal-AndroidInterstitialFallback$Session, reason: not valid java name */
        /* synthetic */ void m101lambda$configureDialog$1$comtapsdktapadinternalAndroidInterstitialFallback$Session(View view) {
            close();
        }

        /* JADX INFO: renamed from: lambda$new$0$com-tapsdk-tapad-internal-AndroidInterstitialFallback$Session, reason: not valid java name */
        /* synthetic */ void m102lambda$new$0$comtapsdktapadinternalAndroidInterstitialFallback$Session() {
            Listener listener;
            if (this.terminal.get() || !this.callbacksEnabled || (listener = this.listener) == null) {
                return;
            }
            listener.onValidShow();
        }

        public void release() {
            this.callbacksEnabled = false;
            if (this.terminal.compareAndSet(false, true)) {
                this.handler.removeCallbacks(this.validRunnable);
                this.handler.removeCallbacks(this.closeRunnable);
                IoniaAdWindowTracker ioniaAdWindowTracker = this.ioniaTracker;
                if (ioniaAdWindowTracker != null) {
                    ioniaAdWindowTracker.onHidden();
                }
                if (this.dialog.isShowing()) {
                    this.dialog.dismiss();
                }
            }
        }

        public void show() {
            if (this.terminal.get()) {
                return;
            }
            this.dialog.show();
            Window window = this.dialog.getWindow();
            if (window != null) {
                window.setLayout(-1, -1);
            }
            Listener listener = this.listener;
            if (listener != null) {
                listener.onShow();
            }
            IoniaAdWindowTracker ioniaAdWindowTracker = this.ioniaTracker;
            if (ioniaAdWindowTracker != null) {
                ioniaAdWindowTracker.onShown();
            }
            this.handler.postDelayed(this.validRunnable, AndroidInterstitialFallback.VALID_DELAY_MS);
            this.handler.postDelayed(this.closeRunnable, AndroidInterstitialFallback.AUTO_CLOSE_MS);
        }
    }

    private AndroidInterstitialFallback() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int dp(Activity activity, int i) {
        return Math.round(i * activity.getResources().getDisplayMetrics().density);
    }

    public static Session show(Activity activity, Listener listener) {
        return show(activity, listener, null);
    }

    public static Session show(Activity activity, Listener listener, IoniaAdWindowTracker ioniaAdWindowTracker) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Interstitial fallback must start on main thread");
        }
        Session session = new Session(activity, listener, ioniaAdWindowTracker);
        try {
            session.show();
            return session;
        } catch (RuntimeException e) {
            session.release();
            throw e;
        }
    }
}
