package com.tapsdk.tapad.group.ads;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterAdSession;
import com.tapsdk.tapad.internal.ionia.IoniaAdWindowTracker;
import com.tapsdk.tapad.internal.ionia.IoniaIdentityManager;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
abstract class AdapterAdCandidate<S extends AdapterAdSession> extends DirichletAd implements AdapterAdEventSink {
    private static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());
    private volatile IoniaAdWindowTracker ioniaWindow;
    private boolean ioniaWindowCloseStarted;
    private final S session;
    private final AtomicBoolean destroyed = new AtomicBoolean(false);
    private final AtomicBoolean sessionReleased = new AtomicBoolean(false);
    private final Runnable delayedIoniaWindowEnd = new Runnable() { // from class: com.tapsdk.tapad.group.ads.AdapterAdCandidate$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.endIoniaWindow();
        }
    };

    public AdapterAdCandidate(S s) {
        if (s == null) {
            throw new IllegalArgumentException("missing adapter session");
        }
        this.session = s;
        s.setEventSink(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyOnOwner() {
        if (markCandidateDestroyed()) {
            onSessionDestroyRequested();
        }
    }

    public static void dispatchCallback(Runnable runnable) {
        if (runnable != null) {
            MAIN_HANDLER.post(runnable);
        }
    }

    private boolean markCandidateDestroyed() {
        if (!this.destroyed.compareAndSet(false, true)) {
            return false;
        }
        IoniaProviderTouchObserver.get().end(this);
        endIoniaWindow();
        super.destroy();
        return true;
    }

    public synchronized void beginIoniaWindow() {
        if (!this.ioniaWindowCloseStarted && this.ioniaWindow == null && IoniaIdentityManager.getInstance().isProviderSensorWindowEnabled()) {
            String trackId = getTrackId();
            String requestId = getRequestId();
            if (!TextUtils.isEmpty(trackId) && !TextUtils.isEmpty(requestId)) {
                IoniaAdWindowTracker ioniaAdWindowTrackerForFullscreen = IoniaAdWindowTracker.forFullscreen(trackId, requestId);
                this.ioniaWindow = ioniaAdWindowTrackerForFullscreen;
                ioniaAdWindowTrackerForFullscreen.onShown();
            }
        }
    }

    @Override // com.tapsdk.tapad.group.ads.DirichletAd
    public final void destroy() {
        dispatchDestroyOnMain(new Runnable() { // from class: com.tapsdk.tapad.group.ads.AdapterAdCandidate$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.destroyOnOwner();
            }
        });
    }

    public final void dispatchCloseEffects() {
        effects().onClose(this);
        IoniaProviderTouchObserver.get().end(this);
    }

    public void dispatchDestroyOnMain(Runnable runnable) {
        runnable.run();
    }

    public synchronized void endIoniaWindow() {
        MAIN_HANDLER.removeCallbacks(this.delayedIoniaWindowEnd);
        this.ioniaWindowCloseStarted = true;
        IoniaAdWindowTracker ioniaAdWindowTracker = this.ioniaWindow;
        if (ioniaAdWindowTracker == null) {
            return;
        }
        this.ioniaWindow = null;
        ioniaAdWindowTracker.onHidden();
    }

    public final void finishSessionDestroy() {
        markCandidateDestroyed();
        if (this.sessionReleased.compareAndSet(false, true)) {
            onBeforeSessionDestroy();
            this.session.setEventSink(null);
            this.session.destroy();
        }
    }

    @Override // com.tapsdk.tapad.group.ads.DirichletAd
    public final Map<String, Object> getMediaExtraInfo() {
        Map<String, Object> metadata = this.session.getMetadata();
        return metadata == null ? Collections.EMPTY_MAP : metadata;
    }

    public final S getSession() {
        return this.session;
    }

    @Override // com.tapsdk.tapad.group.ads.DirichletAd
    public final void innerLoss(long j, String str, String str2) {
        this.session.sendLoss(j, str, str2);
    }

    @Override // com.tapsdk.tapad.group.ads.DirichletAd
    public final void innerWin(long j, long j2, String str) {
        this.session.sendWin(j, j2, str);
    }

    public final boolean isCandidateDestroyed() {
        return this.destroyed.get();
    }

    public final boolean isProviderSessionReleased() {
        return this.sessionReleased.get();
    }

    @Override // com.tapsdk.tapad.group.ads.DirichletAd
    public final boolean isValid() {
        return !this.destroyed.get() && this.session.isValid();
    }

    public final synchronized void markIoniaDeclaredClick(int i) {
        IoniaAdWindowTracker ioniaAdWindowTracker = this.ioniaWindow;
        if (ioniaAdWindowTracker != null) {
            ioniaAdWindowTracker.onDeclaredClick(i);
        }
    }

    public void onBeforeSessionDestroy() {
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onClick(View view) {
        effects().onClick(this, view);
        markIoniaDeclaredClick(1);
        if (this instanceof MediationNativeFeedSession) {
            effects().onItemClick(this, view);
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onClose() {
        dispatchCloseEffects();
        endIoniaWindow();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onCreativeClick(View view) {
        effects().onCreativeClick(this, view);
        markIoniaDeclaredClick(2);
        if (this instanceof MediationNativeFeedSession) {
            effects().onItemClick(this, view);
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onDownloadComplete(long j, long j2, String str, String str2) {
        effects().onDownloadComplete(this, j, j2, str, str2);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onDownloadFailure(long j, long j2, long j3, String str, String str2, int i, String str3) {
        effects().onDownloadError(this, j, j2, j3, str, str2, i, str3);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onDownloadPause(long j, long j2, long j3, String str, String str2) {
        effects().onDownloadPause(this, j, j2, j3, str, str2);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onDownloadProgress(long j, long j2, long j3, String str, String str2) {
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onDownloadStart(long j, String str, String str2) {
        effects().onDownloadStart(this, j, str, str2);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onDownloadWindowConfirm() {
        effects().onDownloadWindowConfirm(this);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onInstalled(long j, String str, String str2) {
        effects().onInstalled(this, j, str, str2);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onInvalidShow(View view, String str, Object obj) {
        effects().onInvalidShow(this, view, str, obj);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onItemElseClick(View view) {
        effects().onItemElseClick(this, view);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onRenderFailure(View view, int i, String str) {
        effects().onRenderFail(this, view, i, str);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onRenderSuccess(View view, float f, float f2) {
        effects().onRenderSuccess(this, view);
    }

    public void onSessionDestroyRequested() {
        finishSessionDestroy();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onShow(View view) {
        effects().onShow(this, view);
        if (this instanceof MediationNativeFeedSession) {
            effects().onItemShow(this, view);
        }
        if (usesProviderFullscreenSurface()) {
            beginIoniaWindow();
            IoniaProviderTouchObserver.get().begin(this);
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onSkip() {
        effects().onSkip(this);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onTimeOver() {
        effects().onAdTimeOver(this);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onVideoComplete(long j) {
        effects().onVideoComplete(this, j);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onVideoFailure(int i, String str) {
        effects().onVideoError(this, i, str);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onVideoPause() {
        effects().onVideoPause(this);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onVideoPrepared() {
        effects().onVideoPrepared(this);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onVideoResume() {
        effects().onVideoResume(this);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onVideoStart() {
        effects().onVideoStart(this);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public final void onViewAcquired(View view) {
        effects().codebitGetView(this, view);
    }

    @Override // com.tapsdk.tapad.group.ads.DirichletAd
    public final long readProviderPrice() {
        return this.session.getPrice();
    }

    public final synchronized void scheduleIoniaWindowEnd(long j) {
        if (!this.ioniaWindowCloseStarted) {
            this.ioniaWindowCloseStarted = true;
            if (this.ioniaWindow != null) {
                MAIN_HANDLER.postDelayed(this.delayedIoniaWindowEnd, Math.max(0L, j));
            }
        }
    }

    public boolean usesProviderFullscreenSurface() {
        return false;
    }
}
