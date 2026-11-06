package com.tapsdk.tapad.internal.ionia;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes2.dex */
public final class IoniaAdWindowTracker {
    public static final long BANNER_WINDOW_IDLE_TIMEOUT_MS = 15000;
    private final Handler closeHandler;
    private final IoniaIdentityManager identityManager = IoniaIdentityManager.getInstance();
    private final Runnable idleCloseRunnable = new Runnable() { // from class: com.tapsdk.tapad.internal.ionia.IoniaAdWindowTracker$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.closeWindow();
        }
    };
    private final long idleTimeoutMs;
    private boolean shown;
    private final String triggerCorrelationId;
    private final String windowKey;
    private boolean windowOpen;

    private IoniaAdWindowTracker(String str, String str2, long j) {
        this.windowKey = safe(str);
        this.triggerCorrelationId = safe(str2);
        this.idleTimeoutMs = j;
        this.closeHandler = j > 0 ? new Handler(Looper.getMainLooper()) : null;
    }

    private void armIdleClose() {
        Handler handler = this.closeHandler;
        if (handler == null || this.idleTimeoutMs <= 0) {
            return;
        }
        handler.removeCallbacks(this.idleCloseRunnable);
        this.closeHandler.postDelayed(this.idleCloseRunnable, this.idleTimeoutMs);
    }

    private void cancelIdleClose() {
        Handler handler = this.closeHandler;
        if (handler != null) {
            handler.removeCallbacks(this.idleCloseRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void closeWindow() {
        cancelIdleClose();
        if (this.windowOpen) {
            this.windowOpen = false;
            this.identityManager.onAdPlaybackCloseAsync(this.windowKey, this.triggerCorrelationId);
        }
    }

    public static IoniaAdWindowTracker forBanner(String str, String str2) {
        return new IoniaAdWindowTracker(str, str2, BANNER_WINDOW_IDLE_TIMEOUT_MS);
    }

    public static IoniaAdWindowTracker forFullscreen(String str, String str2) {
        return new IoniaAdWindowTracker(str, str2, 0L);
    }

    private boolean hasServerIdentity() {
        return (TextUtils.isEmpty(this.windowKey) || TextUtils.isEmpty(this.triggerCorrelationId)) ? false : true;
    }

    private void openWindow() {
        if (this.windowOpen) {
            return;
        }
        this.windowOpen = true;
        this.identityManager.onAdPlaybackShowAsync(this.windowKey, this.triggerCorrelationId);
    }

    private static String safe(String str) {
        return str == null ? "" : str;
    }

    public synchronized void onDeclaredClick(int i) {
        if (this.shown && hasServerIdentity()) {
            this.identityManager.recordAdClickMarkerAsync(this.windowKey, this.triggerCorrelationId, i);
            armIdleClose();
        }
    }

    public synchronized void onHidden() {
        if (this.shown || this.windowOpen) {
            this.shown = false;
            cancelIdleClose();
            closeWindow();
        }
    }

    public synchronized void onShown() {
        if (!this.shown && hasServerIdentity()) {
            this.shown = true;
            openWindow();
            armIdleClose();
        }
    }

    public synchronized void onTouchEvent(MotionEvent motionEvent) {
        if (this.shown && motionEvent != null && hasServerIdentity()) {
            openWindow();
            this.identityManager.recordAdPlaybackMotionEventAsync(this.windowKey, this.triggerCorrelationId, motionEvent);
            armIdleClose();
        }
    }
}
