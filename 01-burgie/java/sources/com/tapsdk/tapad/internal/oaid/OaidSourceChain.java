package com.tapsdk.tapad.internal.oaid;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class OaidSourceChain {
    private static final ScheduledExecutorService COMPLETION_WATCHDOG = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: com.tapsdk.tapad.internal.oaid.OaidSourceChain$$ExternalSyntheticLambda2
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return OaidSourceChain.lambda$static$0(runnable);
        }
    });
    private static final long DEFAULT_COMPLETION_TIMEOUT_MS = 15000;
    private static final String TAG = "OaidSourceChain";
    private final List<OaidSource> sources;

    public static final class Builder {
        private final List<OaidSource> sources = new ArrayList();

        public Builder addSource(OaidSource oaidSource) {
            this.sources.add(oaidSource);
            return this;
        }

        public OaidSourceChain build() {
            return new OaidSourceChain(this.sources);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void completeSource(AtomicBoolean atomicBoolean, AtomicInteger atomicInteger, AtomicBoolean atomicBoolean2, ScheduledFuture<?> scheduledFuture, Runnable runnable) {
        if (atomicBoolean.compareAndSet(false, true) && atomicInteger.decrementAndGet() == 0 && runnable != null) {
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            if (atomicBoolean2.compareAndSet(false, true)) {
                runnable.run();
            }
        }
    }

    static /* synthetic */ void lambda$prefetchAll$1(AtomicBoolean atomicBoolean, AtomicInteger atomicInteger, Runnable runnable) {
        if (atomicBoolean.compareAndSet(false, true)) {
            atomicInteger.get();
            runnable.run();
        }
    }

    static /* synthetic */ Thread lambda$static$0(Runnable runnable) {
        Thread thread = new Thread(runnable, "TapAd-OaidCompletion");
        thread.setDaemon(true);
        return thread;
    }

    public String getBestAvailable() {
        for (OaidSource oaidSource : this.sources) {
            String cached = oaidSource.getCached();
            if (!TextUtils.isEmpty(cached)) {
                oaidSource.getName();
                return cached;
            }
        }
        return "";
    }

    public void prefetchAll(Context context) {
        prefetchAll(context, null);
    }

    private OaidSourceChain(List<OaidSource> list) {
        this.sources = Collections.unmodifiableList(new ArrayList(list));
    }

    public void prefetchAll(Context context, Runnable runnable) {
        prefetchAll(context, runnable, 15000L);
    }

    public void prefetchAll(Context context, final Runnable runnable, long j) {
        if (j > 0) {
            if (this.sources.isEmpty()) {
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            }
            final AtomicInteger atomicInteger = new AtomicInteger(this.sources.size());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ScheduledFuture<?> scheduledFutureSchedule = runnable == null ? null : COMPLETION_WATCHDOG.schedule(new Runnable() { // from class: com.tapsdk.tapad.internal.oaid.OaidSourceChain$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    OaidSourceChain.lambda$prefetchAll$1(atomicBoolean, atomicInteger, runnable);
                }
            }, j, TimeUnit.MILLISECONDS);
            for (OaidSource oaidSource : this.sources) {
                final AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
                try {
                    oaidSource.getName();
                    final ScheduledFuture<?> scheduledFuture = scheduledFutureSchedule;
                    try {
                        oaidSource.fetchAsync(context, new OaidSource.OaidFetchCallback() { // from class: com.tapsdk.tapad.internal.oaid.OaidSourceChain$$ExternalSyntheticLambda1
                            @Override // com.tapsdk.tapad.internal.oaid.OaidSource.OaidFetchCallback
                            public final void onComplete(String str) {
                                OaidSourceChain.completeSource(atomicBoolean2, atomicInteger, atomicBoolean, scheduledFuture, runnable);
                            }
                        });
                    } catch (Throwable th) {
                        oaidSource.getName();
                        completeSource(atomicBoolean2, atomicInteger, atomicBoolean, scheduledFutureSchedule, runnable);
                    }
                } catch (Throwable th2) {
                }
            }
            return;
        }
        throw new IllegalArgumentException("completionTimeoutMs must be positive");
    }
}
