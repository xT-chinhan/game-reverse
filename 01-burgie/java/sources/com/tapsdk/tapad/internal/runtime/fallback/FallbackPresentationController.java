package com.tapsdk.tapad.internal.runtime.fallback;

/* JADX INFO: loaded from: classes3.dex */
public final class FallbackPresentationController {
    private final Clock clock;
    private final int instanceId;
    private final MainDispatcher mainDispatcher;
    private long presentedAtElapsedMs;
    private final Renderer renderer;
    private boolean rendererDestroyed;
    private final RuntimePort runtime;
    private boolean rustSessionReleased;
    private final Scheduler scheduler;
    private volatile State state;
    private final int surfaceId;
    private boolean terminalDelivered;
    private final TerminalListener terminalListener;
    private Cancellable watchdog;
    private long watchdogGeneration;

    public interface Cancellable {
        void cancel();
    }

    public interface Clock {
        long currentTimeMillis();

        long elapsedRealtimeMillis();
    }

    public interface MainDispatcher {
        void post(Runnable runnable);
    }

    public static final class NativeRuntimePort implements RuntimePort {
        static final NativeRuntimePort INSTANCE = new NativeRuntimePort();

        private NativeRuntimePort() {
        }

        @Override // com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController.RuntimePort
        public FallbackPresentationRuntime.EffectBatch close(int i, int i2, int i3) {
            return FallbackPresentationRuntime.close(i, i2, i3);
        }

        @Override // com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController.RuntimePort
        public FallbackPresentationRuntime.EffectBatch destroy(int i, int i2) {
            return FallbackPresentationRuntime.destroy(i, i2);
        }

        @Override // com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController.RuntimePort
        public FallbackPresentationRuntime.EffectBatch rendererFailed(int i, int i2) {
            return FallbackPresentationRuntime.rendererFailed(i, i2);
        }

        @Override // com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController.RuntimePort
        public FallbackPresentationRuntime.EffectBatch start(int i, int i2, long j, byte[] bArr) {
            return FallbackPresentationRuntime.start(i, i2, j, bArr);
        }

        @Override // com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController.RuntimePort
        public FallbackPresentationRuntime.EffectBatch watchdog(int i, int i2) {
            return FallbackPresentationRuntime.watchdog(i, i2);
        }
    }

    public interface RenderListener {
        void onClose();

        void onFailed();
    }

    public interface Renderer {
        void destroy();

        void render(int i, RenderListener renderListener);
    }

    public interface RuntimeCall {
        FallbackPresentationRuntime.EffectBatch call();
    }

    public interface RuntimePort {
        FallbackPresentationRuntime.EffectBatch close(int i, int i2, int i3);

        FallbackPresentationRuntime.EffectBatch destroy(int i, int i2);

        FallbackPresentationRuntime.EffectBatch rendererFailed(int i, int i2);

        FallbackPresentationRuntime.EffectBatch start(int i, int i2, long j, byte[] bArr);

        FallbackPresentationRuntime.EffectBatch watchdog(int i, int i2);
    }

    public interface Scheduler {
        Cancellable schedule(Runnable runnable, long j);
    }

    public enum State {
        IDLE,
        PRESENTING,
        TERMINAL;

        public static State fromRust(int i) {
            if (i == 0) {
                return IDLE;
            }
            if (i == 1) {
                return PRESENTING;
            }
            if (i == 2) {
                return TERMINAL;
            }
            return null;
        }
    }

    public interface TerminalListener {
        void onTerminal(TerminalResult terminalResult);
    }

    public enum TerminalReason {
        CLOSED(1),
        WATCHDOG(2),
        INVALID_SPEC(3),
        ASSET_UNAVAILABLE(4),
        RENDERER_FAILED(5),
        DESTROYED(6);

        private final int stableCode;

        TerminalReason(int i) {
            this.stableCode = i;
        }

        public static TerminalReason fromStableCode(int i) {
            for (TerminalReason terminalReason : values()) {
                if (terminalReason.stableCode == i) {
                    return terminalReason;
                }
            }
            return null;
        }

        public int getStableCode() {
            return this.stableCode;
        }
    }

    public static final class TerminalResult {
        private final TerminalReason reason;

        public TerminalResult(TerminalReason terminalReason) {
            this.reason = terminalReason == null ? TerminalReason.RENDERER_FAILED : terminalReason;
        }

        public TerminalReason getReason() {
            return this.reason;
        }
    }

    public FallbackPresentationController(int i, int i2, Renderer renderer, TerminalListener terminalListener, Clock clock, MainDispatcher mainDispatcher, Scheduler scheduler) {
        this(i, i2, NativeRuntimePort.INSTANCE, renderer, terminalListener, clock, mainDispatcher, scheduler);
    }

    private void apply(FallbackPresentationRuntime.EffectBatch effectBatch) {
        State stateFromRust = State.fromRust(effectBatch.state);
        if (stateFromRust == null) {
            failOpen(TerminalReason.RENDERER_FAILED);
            return;
        }
        this.state = stateFromRust;
        for (FallbackPresentationRuntime.Effect effect : effectBatch.effects) {
            int i = effect.opcode;
            if (i == 1) {
                armWatchdog(effect.value);
            } else if (i == 2) {
                render(effect.value);
            } else {
                if (i != 3) {
                    failOpen(TerminalReason.RENDERER_FAILED);
                    return;
                }
                terminate(TerminalReason.fromStableCode(effect.value));
            }
            if (this.terminalDelivered) {
                return;
            }
        }
    }

    private void armWatchdog(int i) {
        cancelWatchdog();
        final long j = this.watchdogGeneration + 1;
        this.watchdogGeneration = j;
        try {
            Cancellable cancellableSchedule = this.scheduler.schedule(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m277lambda$armWatchdog$9$comtapsdktapadinternalruntimefallbackFallbackPresentationController(j);
                }
            }, i);
            this.watchdog = cancellableSchedule;
            if (cancellableSchedule != null) {
            } else {
                throw new IllegalStateException("fallback scheduler returned null");
            }
        } catch (RuntimeException e) {
            rendererFailed();
        }
    }

    private void cancelWatchdog() {
        this.watchdogGeneration++;
        Cancellable cancellable = this.watchdog;
        this.watchdog = null;
        if (cancellable != null) {
            try {
                cancellable.cancel();
            } catch (RuntimeException e) {
            }
        }
    }

    private void destroyRenderer() {
        if (this.rendererDestroyed) {
            return;
        }
        this.rendererDestroyed = true;
        try {
            this.renderer.destroy();
        } catch (RuntimeException e) {
        }
    }

    private void dispatch(RuntimeCall runtimeCall) {
        try {
            apply(runtimeCall.call());
        } catch (FallbackPresentationRuntime.DispatchException e) {
            failOpen(TerminalReason.RENDERER_FAILED);
        }
    }

    private void failOpen(TerminalReason terminalReason) {
        if (terminalReason == null) {
            terminalReason = TerminalReason.RENDERER_FAILED;
        }
        terminate(terminalReason);
    }

    private void postToMain(Runnable runnable) {
        try {
            this.mainDispatcher.post(runnable);
        } catch (RuntimeException e) {
        }
    }

    private void releaseRustSession() {
        if (this.rustSessionReleased) {
            return;
        }
        this.rustSessionReleased = true;
        try {
            this.runtime.destroy(this.instanceId, this.surfaceId);
        } catch (FallbackPresentationRuntime.DispatchException e) {
        }
    }

    private void render(int i) {
        this.presentedAtElapsedMs = this.clock.elapsedRealtimeMillis();
        try {
            this.renderer.render(i, new RenderListener() { // from class: com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController.1
                @Override // com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController.RenderListener
                public void onClose() {
                    FallbackPresentationController.this.close();
                }

                @Override // com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController.RenderListener
                public void onFailed() {
                    FallbackPresentationController.this.rendererFailed();
                }
            });
        } catch (RuntimeException e) {
            rendererFailed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rendererFailed() {
        postToMain(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m283lambda$rendererFailed$6$comtapsdktapadinternalruntimefallbackFallbackPresentationController();
            }
        });
    }

    private void terminate(TerminalReason terminalReason) {
        if (this.terminalDelivered) {
            return;
        }
        this.terminalDelivered = true;
        this.state = State.TERMINAL;
        cancelWatchdog();
        destroyRenderer();
        if (terminalReason == TerminalReason.DESTROYED) {
            this.rustSessionReleased = true;
        } else {
            releaseRustSession();
        }
        try {
            this.terminalListener.onTerminal(new TerminalResult(terminalReason));
        } catch (RuntimeException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: watchdog, reason: merged with bridge method [inline-methods] */
    public void m276lambda$armWatchdog$8$comtapsdktapadinternalruntimefallbackFallbackPresentationController(long j) {
        if (j != this.watchdogGeneration || this.terminalDelivered) {
            return;
        }
        dispatch(new RuntimeCall() { // from class: com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController$$ExternalSyntheticLambda3
            @Override // com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController.RuntimeCall
            public final FallbackPresentationRuntime.EffectBatch call() {
                return this.f$0.m285lambda$watchdog$7$comtapsdktapadinternalruntimefallbackFallbackPresentationController();
            }
        });
    }

    public void close() {
        postToMain(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m279lambda$close$2$comtapsdktapadinternalruntimefallbackFallbackPresentationController();
            }
        });
    }

    public void destroy() {
        postToMain(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m281lambda$destroy$4$comtapsdktapadinternalruntimefallbackFallbackPresentationController();
            }
        });
    }

    public State getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: lambda$armWatchdog$9$com-tapsdk-tapad-internal-runtime-fallback-FallbackPresentationController, reason: not valid java name */
    /* synthetic */ void m277lambda$armWatchdog$9$comtapsdktapadinternalruntimefallbackFallbackPresentationController(final long j) {
        postToMain(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m276lambda$armWatchdog$8$comtapsdktapadinternalruntimefallbackFallbackPresentationController(j);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$close$1$com-tapsdk-tapad-internal-runtime-fallback-FallbackPresentationController, reason: not valid java name */
    /* synthetic */ FallbackPresentationRuntime.EffectBatch m278lambda$close$1$comtapsdktapadinternalruntimefallbackFallbackPresentationController(int i) {
        return this.runtime.close(this.instanceId, this.surfaceId, i);
    }

    /* JADX INFO: renamed from: lambda$close$2$com-tapsdk-tapad-internal-runtime-fallback-FallbackPresentationController, reason: not valid java name */
    /* synthetic */ void m279lambda$close$2$comtapsdktapadinternalruntimefallbackFallbackPresentationController() {
        if (this.state != State.PRESENTING || this.terminalDelivered) {
            return;
        }
        long jElapsedRealtimeMillis = this.clock.elapsedRealtimeMillis();
        long j = this.presentedAtElapsedMs;
        long j2 = jElapsedRealtimeMillis >= j ? jElapsedRealtimeMillis - j : 0L;
        final int i = j2 > 2147483647L ? Integer.MAX_VALUE : (int) j2;
        dispatch(new RuntimeCall() { // from class: com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController$$ExternalSyntheticLambda9
            @Override // com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController.RuntimeCall
            public final FallbackPresentationRuntime.EffectBatch call() {
                return this.f$0.m278lambda$close$1$comtapsdktapadinternalruntimefallbackFallbackPresentationController(i);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$destroy$3$com-tapsdk-tapad-internal-runtime-fallback-FallbackPresentationController, reason: not valid java name */
    /* synthetic */ FallbackPresentationRuntime.EffectBatch m280lambda$destroy$3$comtapsdktapadinternalruntimefallbackFallbackPresentationController() {
        return this.runtime.destroy(this.instanceId, this.surfaceId);
    }

    /* JADX INFO: renamed from: lambda$destroy$4$com-tapsdk-tapad-internal-runtime-fallback-FallbackPresentationController, reason: not valid java name */
    /* synthetic */ void m281lambda$destroy$4$comtapsdktapadinternalruntimefallbackFallbackPresentationController() {
        if (this.terminalDelivered) {
            releaseRustSession();
            destroyRenderer();
        } else if (this.state == State.IDLE) {
            failOpen(TerminalReason.DESTROYED);
        } else {
            dispatch(new RuntimeCall() { // from class: com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController$$ExternalSyntheticLambda7
                @Override // com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController.RuntimeCall
                public final FallbackPresentationRuntime.EffectBatch call() {
                    return this.f$0.m280lambda$destroy$3$comtapsdktapadinternalruntimefallbackFallbackPresentationController();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$rendererFailed$5$com-tapsdk-tapad-internal-runtime-fallback-FallbackPresentationController, reason: not valid java name */
    /* synthetic */ FallbackPresentationRuntime.EffectBatch m282lambda$rendererFailed$5$comtapsdktapadinternalruntimefallbackFallbackPresentationController() {
        return this.runtime.rendererFailed(this.instanceId, this.surfaceId);
    }

    /* JADX INFO: renamed from: lambda$rendererFailed$6$com-tapsdk-tapad-internal-runtime-fallback-FallbackPresentationController, reason: not valid java name */
    /* synthetic */ void m283lambda$rendererFailed$6$comtapsdktapadinternalruntimefallbackFallbackPresentationController() {
        if (this.state != State.PRESENTING || this.terminalDelivered) {
            return;
        }
        dispatch(new RuntimeCall() { // from class: com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController$$ExternalSyntheticLambda2
            @Override // com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController.RuntimeCall
            public final FallbackPresentationRuntime.EffectBatch call() {
                return this.f$0.m282lambda$rendererFailed$5$comtapsdktapadinternalruntimefallbackFallbackPresentationController();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$start$0$com-tapsdk-tapad-internal-runtime-fallback-FallbackPresentationController, reason: not valid java name */
    /* synthetic */ void m284lambda$start$0$comtapsdktapadinternalruntimefallbackFallbackPresentationController(byte[] bArr) {
        if (this.state != State.IDLE || this.terminalDelivered) {
            return;
        }
        try {
            FallbackPresentationRuntime.EffectBatch effectBatchStart = this.runtime.start(this.instanceId, this.surfaceId, this.clock.currentTimeMillis(), bArr);
            if (FallbackPresentationRuntime.validStartBatch(effectBatchStart)) {
                apply(effectBatchStart);
            } else {
                failOpen(TerminalReason.RENDERER_FAILED);
            }
        } catch (FallbackPresentationRuntime.DispatchException e) {
            failOpen(TerminalReason.RENDERER_FAILED);
        }
    }

    /* JADX INFO: renamed from: lambda$watchdog$7$com-tapsdk-tapad-internal-runtime-fallback-FallbackPresentationController, reason: not valid java name */
    /* synthetic */ FallbackPresentationRuntime.EffectBatch m285lambda$watchdog$7$comtapsdktapadinternalruntimefallbackFallbackPresentationController() {
        return this.runtime.watchdog(this.instanceId, this.surfaceId);
    }

    public void pause() {
    }

    public void resume() {
    }

    public void start(byte[] bArr) {
        final byte[] bArr2 = bArr == null ? null : (byte[]) bArr.clone();
        postToMain(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.fallback.FallbackPresentationController$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m284lambda$start$0$comtapsdktapadinternalruntimefallbackFallbackPresentationController(bArr2);
            }
        });
    }

    public FallbackPresentationController(int i, int i2, RuntimePort runtimePort, Renderer renderer, TerminalListener terminalListener, Clock clock, MainDispatcher mainDispatcher, Scheduler scheduler) {
        this.state = State.IDLE;
        if (i <= 0 || i2 <= 0 || runtimePort == null || renderer == null || terminalListener == null || clock == null || mainDispatcher == null || scheduler == null) {
            throw new IllegalArgumentException("invalid fallback dependencies");
        }
        this.instanceId = i;
        this.surfaceId = i2;
        this.runtime = runtimePort;
        this.renderer = renderer;
        this.terminalListener = terminalListener;
        this.clock = clock;
        this.mainDispatcher = mainDispatcher;
        this.scheduler = scheduler;
    }
}
