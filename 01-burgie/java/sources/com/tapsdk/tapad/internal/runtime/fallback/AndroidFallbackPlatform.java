package com.tapsdk.tapad.internal.runtime.fallback;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes3.dex */
public final class AndroidFallbackPlatform {
    private AndroidFallbackPlatform() {
    }

    static /* synthetic */ void lambda$mainDispatcher$0(Handler handler, Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else if (!handler.post(runnable)) {
            throw new IllegalStateException("fallback main dispatcher is unavailable");
        }
    }

    static /* synthetic */ FallbackPresentationController.Cancellable lambda$mainScheduler$2(final Handler handler, final Runnable runnable, long j) {
        if (j < 0 || !handler.postDelayed(runnable, j)) {
            throw new IllegalStateException("fallback watchdog cannot be armed");
        }
        return new FallbackPresentationController.Cancellable() { // from class: com.tapsdk.tapad.internal.runtime.fallback.AndroidFallbackPlatform$$ExternalSyntheticLambda1
            @Override // com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController.Cancellable
            public final void cancel() {
                handler.removeCallbacks(runnable);
            }
        };
    }

    public static FallbackPresentationController.MainDispatcher mainDispatcher() {
        final Handler handler = new Handler(Looper.getMainLooper());
        return new FallbackPresentationController.MainDispatcher() { // from class: com.tapsdk.tapad.internal.runtime.fallback.AndroidFallbackPlatform$$ExternalSyntheticLambda2
            @Override // com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController.MainDispatcher
            public final void post(Runnable runnable) {
                AndroidFallbackPlatform.lambda$mainDispatcher$0(handler, runnable);
            }
        };
    }

    public static FallbackPresentationController.Scheduler mainScheduler() {
        final Handler handler = new Handler(Looper.getMainLooper());
        return new FallbackPresentationController.Scheduler() { // from class: com.tapsdk.tapad.internal.runtime.fallback.AndroidFallbackPlatform$$ExternalSyntheticLambda0
            @Override // com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController.Scheduler
            public final FallbackPresentationController.Cancellable schedule(Runnable runnable, long j) {
                return AndroidFallbackPlatform.lambda$mainScheduler$2(handler, runnable, j);
            }
        };
    }

    public static FallbackPresentationController.Clock systemClock() {
        return new FallbackPresentationController.Clock() { // from class: com.tapsdk.tapad.internal.runtime.fallback.AndroidFallbackPlatform.1
            @Override // com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController.Clock
            public long currentTimeMillis() {
                return System.currentTimeMillis();
            }

            @Override // com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController.Clock
            public long elapsedRealtimeMillis() {
                return SystemClock.elapsedRealtime();
            }
        };
    }
}
