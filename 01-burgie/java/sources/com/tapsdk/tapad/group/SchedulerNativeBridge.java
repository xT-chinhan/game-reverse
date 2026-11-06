package com.tapsdk.tapad.group;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.tapsdk.tapad.group.ads.DirichletAd;
import com.tapsdk.tapad.internal.runtime.CoreMediationTelemetryBridge;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class SchedulerNativeBridge {
    private static final int CANCEL_REASON_PUBLIC_TERMINAL = 1;
    private static final int MAX_ADMISSION_FAILURES_PER_WAKE = 64;
    private static final int MAX_ASYNC_CANDIDATES = 1024;
    private static final int MAX_ASYNC_INGRESS_BYTES = 1056000;
    private static final int MAX_EXECUTORS = 4096;
    private static final int MAX_READY_DRAIN_BATCHES = 4096;
    static final int RESULT_FAILED = 3;
    static final int RESULT_NO_FILL = 2;
    static final int RESULT_SUCCEEDED = 1;
    static final int RESULT_TIMEOUT = 4;
    private static boolean drainingReady;
    private static long scheduledAdmissionDeadlineMs;
    private static final Map<Long, SchedulerMechanicalAdapterExecutor> EXECUTORS = new HashMap();
    private static final Runnable ADMISSION_WAKE = new Runnable() { // from class: com.tapsdk.tapad.group.SchedulerNativeBridge.1
        @Override // java.lang.Runnable
        public void run() {
            long unused = SchedulerNativeBridge.scheduledAdmissionDeadlineMs = 0L;
            try {
                SchedulerNativeBridge.nativeAdmissionTick(SystemClock.uptimeMillis());
            } catch (Throwable th) {
            }
            SchedulerNativeBridge.drainAdmissionFailures();
            SchedulerNativeBridge.drainReady();
            SchedulerNativeBridge.scheduleAdmissionWake();
        }
    };
    private static final Runnable CONTINUE_READY_DRAIN = new Runnable() { // from class: com.tapsdk.tapad.group.SchedulerNativeBridge.2
        @Override // java.lang.Runnable
        public void run() {
            SchedulerNativeBridge.drainReady();
            SchedulerNativeBridge.scheduleAdmissionWake();
        }
    };

    /* JADX INFO: renamed from: com.tapsdk.tapad.group.SchedulerNativeBridge$4, reason: invalid class name */
    public class AnonymousClass4 implements Runnable {
        final /* synthetic */ long val$attemptId;
        final /* synthetic */ long val$nowMs;
        final /* synthetic */ long val$requestId;
        final /* synthetic */ FrozenLoadResult val$result;
        final /* synthetic */ SchedulerResultGate val$resultGate;
        final /* synthetic */ int val$resultKind;
        final /* synthetic */ int val$routeKey;

        public AnonymousClass4(SchedulerResultGate schedulerResultGate, long j, long j2, int i, FrozenLoadResult frozenLoadResult, int i2, long j3) {
            this.val$resultGate = schedulerResultGate;
            this.val$requestId = j;
            this.val$attemptId = j2;
            this.val$routeKey = i;
            this.val$result = frozenLoadResult;
            this.val$resultKind = i2;
            this.val$nowMs = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            byte[] bArr;
            try {
                try {
                    SchedulerResultGate schedulerResultGate = this.val$resultGate;
                    long j = this.val$requestId;
                    long j2 = this.val$attemptId;
                    int i = this.val$routeKey;
                    final FrozenLoadResult frozenLoadResult = this.val$result;
                    if (schedulerResultGate.discardIfClosed(j, j2, i, new Runnable() { // from class: com.tapsdk.tapad.group.SchedulerNativeBridge$4$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            SchedulerNativeBridge.destroyCandidates(frozenLoadResult.candidates);
                        }
                    })) {
                        return;
                    }
                    FrozenLoadResult frozenLoadResult2 = this.val$result;
                    byte[] bArr2 = frozenLoadResult2.pricingIngress;
                    if (frozenLoadResult2.candidates.isEmpty()) {
                        bArr = bArr2;
                    } else {
                        SchedulerMechanicalAdapterExecutor schedulerMechanicalAdapterExecutor = (SchedulerMechanicalAdapterExecutor) SchedulerNativeBridge.EXECUTORS.get(Long.valueOf(this.val$requestId));
                        if (schedulerMechanicalAdapterExecutor == null) {
                            SchedulerNativeBridge.destroyCandidates(this.val$result.candidates);
                            SchedulerNativeBridge.failRequest(this.val$requestId, "missing_executor");
                            return;
                        }
                        byte[] bArrRegisterCandidates = schedulerMechanicalAdapterExecutor.registerCandidates(this.val$routeKey, this.val$result.candidates, bArr2);
                        if (bArrRegisterCandidates == null) {
                            SchedulerNativeBridge.destroyCandidates(this.val$result.candidates);
                            SchedulerNativeBridge.failRequest(this.val$requestId, "candidate_registration_failed");
                            return;
                        }
                        bArr = bArrRegisterCandidates;
                    }
                    long j3 = this.val$requestId;
                    SchedulerNativeBridge.acceptBatch(j3, SchedulerNativeBridge.nativeAdapterLoadFact(j3, this.val$attemptId, this.val$resultKind, this.val$result.candidates.size(), this.val$nowMs, bArr));
                    SchedulerNativeBridge.drainReady();
                    SchedulerNativeBridge.scheduleAdmissionWake();
                } catch (RuntimeException e) {
                    SchedulerNativeBridge.destroyCandidates(this.val$result.candidates);
                    throw e;
                }
            } catch (Throwable th) {
                SchedulerNativeBridge.failRequest(this.val$requestId, SchedulerMechanicalAdapterExecutor.describeFailure("load_fact_failed", th));
            }
        }
    }

    public static final class FrozenLoadResult {
        final List<DirichletAd> candidates;
        final byte[] pricingIngress;

        public FrozenLoadResult(List<DirichletAd> list, byte[] bArr) {
            this.candidates = list;
            this.pricingIngress = bArr;
        }
    }

    public static final class QueueHolder {
        static final Handler HANDLER = create();

        private QueueHolder() {
        }

        private static Handler create() {
            HandlerThread handlerThread = new HandlerThread("dirichlet_scheduler", 10);
            handlerThread.start();
            return new Handler(handlerThread.getLooper());
        }
    }

    private SchedulerNativeBridge() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean acceptBatch(long j, byte[] bArr) {
        SchedulerMechanicalAdapterExecutor schedulerMechanicalAdapterExecutor = EXECUTORS.get(Long.valueOf(j));
        if (schedulerMechanicalAdapterExecutor != null) {
            return schedulerMechanicalAdapterExecutor.execute(bArr);
        }
        failRequest(j, "missing_executor");
        return false;
    }

    public static void acceptOwnedLoadFact(long j, long j2, int i, int i2, List<DirichletAd> list, byte[] bArr, SchedulerResultGate schedulerResultGate) {
        if (j == 0 || j2 <= 0 || i <= 0) {
            invalidateAsync(j);
            return;
        }
        FrozenLoadResult frozenLoadResultFreezeLoadResult = freezeLoadResult(j, i2, list, bArr);
        if (frozenLoadResultFreezeLoadResult == null || post(new AnonymousClass4(schedulerResultGate, j, j2, i, frozenLoadResultFreezeLoadResult, i2, SystemClock.uptimeMillis()))) {
            return;
        }
        destroyCandidates(frozenLoadResultFreezeLoadResult.candidates);
    }

    public static long begin(byte[] bArr) {
        if (bArr != null && bArr.length != 0 && bArr.length <= 65536) {
            try {
                return nativeBegin(bArr);
            } catch (Throwable th) {
            }
        }
        return 0L;
    }

    public static void cancelWake(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            QueueHolder.HANDLER.removeCallbacks(runnable);
        } catch (Throwable th) {
        }
    }

    public static int claimExecution(long j, byte[] bArr) {
        return nativeClaimExecution(j, bArr);
    }

    public static void close(final long j) {
        if (j == 0) {
            return;
        }
        final long jUptimeMillis = SystemClock.uptimeMillis();
        if (post(new Runnable() { // from class: com.tapsdk.tapad.group.SchedulerNativeBridge.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    long j2 = j;
                    SchedulerNativeBridge.acceptBatch(j2, SchedulerNativeBridge.nativeCancel(j2, 1, jUptimeMillis));
                    SchedulerNativeBridge.drainReady();
                } catch (Throwable th) {
                    SchedulerNativeBridge.failRequest(j, SchedulerMechanicalAdapterExecutor.describeFailure("cancel_failed", th));
                }
                SchedulerMechanicalAdapterExecutor schedulerMechanicalAdapterExecutor = (SchedulerMechanicalAdapterExecutor) SchedulerNativeBridge.EXECUTORS.get(Long.valueOf(j));
                SchedulerMechanicalAdapterExecutor.CandidateSummary candidateSummary = schedulerMechanicalAdapterExecutor == null ? new SchedulerMechanicalAdapterExecutor.CandidateSummary(0, 0) : schedulerMechanicalAdapterExecutor.closeCandidates();
                try {
                    SchedulerNativeBridge.nativeConfirmCandidateHandles(j, candidateSummary.registered, candidateSummary.live);
                } catch (Throwable th2) {
                }
                try {
                    CoreMediationTelemetryBridge.report(SchedulerNativeBridge.nativeFinish(j, 1, jUptimeMillis));
                } catch (Throwable th3) {
                }
                SchedulerNativeBridge.EXECUTORS.remove(Long.valueOf(j));
                SchedulerNativeBridge.drainReady();
                SchedulerNativeBridge.scheduleAdmissionWake();
            }
        })) {
            return;
        }
        try {
            nativeRelease(j);
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void destroyCandidates(List<DirichletAd> list) {
        for (DirichletAd dirichletAd : list) {
            if (dirichletAd != null) {
                dirichletAd.destroy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void drainAdmissionFailures() {
        for (int i = 0; i < 64; i++) {
            try {
                long jNativeTakeAdmissionFailure = nativeTakeAdmissionFailure();
                if (jNativeTakeAdmissionFailure == 0) {
                    return;
                }
                failRequest(jNativeTakeAdmissionFailure, "admission_failed");
            } catch (Throwable th) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void drainReady() {
        if (drainingReady) {
            return;
        }
        boolean z = true;
        drainingReady = true;
        for (int i = 0; i < 4096; i++) {
            try {
                long jNativeNextReadyRequest = nativeNextReadyRequest();
                if (jNativeNextReadyRequest == 0) {
                    drainingReady = false;
                    return;
                }
                if (EXECUTORS.get(Long.valueOf(jNativeNextReadyRequest)) == null) {
                    drainingReady = false;
                    return;
                }
                byte[] bArrNativeTakeReadyBatch = nativeTakeReadyBatch(jNativeNextReadyRequest);
                if (bArrNativeTakeReadyBatch == null || !acceptBatch(jNativeNextReadyRequest, bArrNativeTakeReadyBatch)) {
                    drainingReady = false;
                    return;
                }
            } catch (Throwable th) {
                z = false;
            }
        }
        if (nativeNextReadyRequest() == 0) {
            z = false;
        }
        drainingReady = false;
        if (z) {
            post(CONTINUE_READY_DRAIN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void failRequest(long j, String str) {
        SchedulerMechanicalAdapterExecutor schedulerMechanicalAdapterExecutor = EXECUTORS.get(Long.valueOf(j));
        if (schedulerMechanicalAdapterExecutor != null) {
            schedulerMechanicalAdapterExecutor.fail(str);
        }
    }

    private static FrozenLoadResult freezeLoadResult(long j, int i, List<DirichletAd> list, byte[] bArr) {
        int size;
        if (list == null) {
            size = 0;
        } else {
            try {
                size = list.size();
            } catch (Throwable th) {
                invalidateAsync(j);
                return null;
            }
        }
        if (i < 1 || i > 4 || size < 0 || size > 1024 || (bArr != null && bArr.length > MAX_ASYNC_INGRESS_BYTES)) {
            invalidateAsync(j);
            return null;
        }
        try {
            List listUnmodifiableList = list == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(new ArrayList(list));
            byte[] bArr2 = bArr == null ? new byte[0] : (byte[]) bArr.clone();
            if (listUnmodifiableList.size() == size && listUnmodifiableList.size() <= 1024) {
                return new FrozenLoadResult(listUnmodifiableList, bArr2);
            }
            invalidateAsync(j);
            return null;
        } catch (Throwable th2) {
            invalidateAsync(j);
            return null;
        }
    }

    private static void invalidateAsync(final long j) {
        if (j == 0) {
            return;
        }
        post(new Runnable() { // from class: com.tapsdk.tapad.group.SchedulerNativeBridge.6
            @Override // java.lang.Runnable
            public void run() {
                SchedulerNativeBridge.failRequest(j, "invalid_load_fact");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native byte[] nativeAdapterLoadFact(long j, long j2, int i, int i2, long j3, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean nativeAdmissionTick(long j);

    private static native long nativeBegin(byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native byte[] nativeCancel(long j, int i, long j2);

    private static native int nativeClaimExecution(long j, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean nativeConfirmCandidateHandles(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native byte[] nativeFinish(long j, int i, long j2);

    private static native long nativeNextAdmissionDeadline();

    private static native long nativeNextReadyRequest();

    private static native boolean nativeRelease(long j);

    private static native boolean nativeSettleExecution(long j, byte[] bArr, int i, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public static native byte[] nativeStart(long j, long j2);

    private static native long nativeTakeAdmissionFailure();

    private static native byte[] nativeTakeReadyBatch(long j);

    private static boolean post(Runnable runnable) {
        try {
            return QueueHolder.HANDLER.post(runnable);
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void scheduleAdmissionWake() {
        long jNativeNextAdmissionDeadline;
        try {
            jNativeNextAdmissionDeadline = nativeNextAdmissionDeadline();
        } catch (Throwable th) {
            jNativeNextAdmissionDeadline = 0;
        }
        if (jNativeNextAdmissionDeadline == scheduledAdmissionDeadlineMs) {
            return;
        }
        try {
            Handler handler = QueueHolder.HANDLER;
            Runnable runnable = ADMISSION_WAKE;
            handler.removeCallbacks(runnable);
            scheduledAdmissionDeadlineMs = 0L;
            if (jNativeNextAdmissionDeadline > 0) {
                scheduledAdmissionDeadlineMs = jNativeNextAdmissionDeadline;
                handler.postAtTime(runnable, Math.max(jNativeNextAdmissionDeadline, SystemClock.uptimeMillis()));
            }
        } catch (Throwable th2) {
            scheduledAdmissionDeadlineMs = 0L;
        }
    }

    public static Runnable scheduleWakeAt(long j, Runnable runnable) {
        if (j > 0 && runnable != null) {
            try {
                if (QueueHolder.HANDLER.postAtTime(runnable, Math.max(j, SystemClock.uptimeMillis()))) {
                    return runnable;
                }
                return null;
            } catch (Throwable th) {
            }
        }
        return null;
    }

    public static boolean settleExecution(long j, byte[] bArr, int i, boolean z) {
        return nativeSettleExecution(j, bArr, i, z);
    }

    public static boolean start(final long j, List<? extends SchedulerMechanicalAdapterExecutor.Route> list, SchedulerMechanicalAdapterExecutor.TerminalActions terminalActions) {
        if (j != 0 && list != null && !list.isEmpty() && list.size() <= 256 && terminalActions != null) {
            try {
                final SchedulerMechanicalAdapterExecutor schedulerMechanicalAdapterExecutor = new SchedulerMechanicalAdapterExecutor(j, Collections.unmodifiableList(new ArrayList(list)), terminalActions);
                if (schedulerMechanicalAdapterExecutor.isValid()) {
                    return post(new Runnable() { // from class: com.tapsdk.tapad.group.SchedulerNativeBridge.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SchedulerNativeBridge.EXECUTORS.size() >= 4096 || SchedulerNativeBridge.EXECUTORS.containsKey(Long.valueOf(j))) {
                                schedulerMechanicalAdapterExecutor.fail("executor_conflict");
                                return;
                            }
                            SchedulerNativeBridge.EXECUTORS.put(Long.valueOf(j), schedulerMechanicalAdapterExecutor);
                            try {
                                long j2 = j;
                                SchedulerNativeBridge.acceptBatch(j2, SchedulerNativeBridge.nativeStart(j2, SystemClock.uptimeMillis()));
                                SchedulerNativeBridge.drainReady();
                                SchedulerNativeBridge.scheduleAdmissionWake();
                            } catch (Throwable th) {
                                SchedulerNativeBridge.failRequest(j, SchedulerMechanicalAdapterExecutor.describeFailure("native_start_failed", th));
                            }
                        }
                    });
                }
                return false;
            } catch (Throwable th) {
            }
        }
        return false;
    }
}
