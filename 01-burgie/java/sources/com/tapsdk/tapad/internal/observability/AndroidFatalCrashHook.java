package com.tapsdk.tapad.internal.observability;

/* JADX INFO: loaded from: classes2.dex */
final class AndroidFatalCrashHook {
    private static final String TAG = "AndroidFatalCrashHook";
    private static volatile boolean installed;
    private static final Object INSTALL_LOCK = new Object();
    private static final ThreadLocal<Boolean> HANDLING_EXCEPTION = new ThreadLocal<>();

    public interface ThrowableRecorder {
        void record(Throwable th);
    }

    private AndroidFatalCrashHook() {
    }

    public static Thread.UncaughtExceptionHandler createUncaughtHandler(final Thread.UncaughtExceptionHandler uncaughtExceptionHandler, final ThrowableRecorder throwableRecorder) {
        return new Thread.UncaughtExceptionHandler() { // from class: com.tapsdk.tapad.internal.observability.AndroidFatalCrashHook$$ExternalSyntheticLambda0
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, Throwable th) {
                AndroidFatalCrashHook.lambda$createUncaughtHandler$0(throwableRecorder, uncaughtExceptionHandler, thread, th);
            }
        };
    }

    public static void install(ThrowableRecorder throwableRecorder) {
        if (throwableRecorder == null) {
            return;
        }
        synchronized (INSTALL_LOCK) {
            if (installed) {
                return;
            }
            Thread.setDefaultUncaughtExceptionHandler(createUncaughtHandler(Thread.getDefaultUncaughtExceptionHandler(), throwableRecorder));
            installed = true;
        }
    }

    static /* synthetic */ void lambda$createUncaughtHandler$0(ThrowableRecorder throwableRecorder, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Thread thread, Throwable th) {
        Boolean bool = Boolean.TRUE;
        ThreadLocal<Boolean> threadLocal = HANDLING_EXCEPTION;
        if (bool.equals(threadLocal.get())) {
            return;
        }
        threadLocal.set(bool);
        try {
            if (!(th instanceof OutOfMemoryError) && throwableRecorder != null) {
                throwableRecorder.record(th);
            }
            if (uncaughtExceptionHandler != null) {
                try {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                } finally {
                    HANDLING_EXCEPTION.remove();
                }
            }
        } catch (Throwable th2) {
            if (uncaughtExceptionHandler != null) {
                try {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                } finally {
                    HANDLING_EXCEPTION.remove();
                }
            }
        }
    }
}
