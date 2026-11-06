package com.tapsdk.tapad.internal.runtime.download;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class AndroidDownloadHost {
    private static final int MAX_CONCURRENT_TRANSFERS = 3;
    private static final long PAUSED_TASK_TTL_MS = TimeUnit.HOURS.toMillis(24);
    private static final String TAG = "AndroidDownloadHost";
    private static volatile AndroidDownloadHost instance;
    private final Context appContext;
    private final File defaultDirectory;
    private final AndroidDownloadNotifications notifications;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final ExecutorService executor = createExecutor();
    private final AtomicInteger nextId = new AtomicInteger(1);
    private final Object taskLock = new Object();
    private final SparseArray<Task> tasks = new SparseArray<>();
    private final Map<String, Task> tasksByTarget = new HashMap();

    /* JADX INFO: loaded from: classes2.dex */
    public static final class NotificationSpec {
        final String iconUrl;
        final String title;

        public NotificationSpec(String str) {
            this(str, "");
        }

        public NotificationSpec(String str, String str2) {
            this.title = str;
            this.iconUrl = str2;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static abstract class Observer {
        public boolean deliverOnMainThread() {
            return true;
        }

        public void onCanceled(int i, int i2) {
        }

        public void onComplete(int i, int i2, File file) {
        }

        public void onError(int i, int i2, int i3, String str) {
        }

        public void onPaused(int i, int i2, float f) {
        }

        public void onProgress(int i, int i2, float f, long j, long j2) {
        }

        public void onResumed(int i, int i2, float f) {
        }

        public void onStarted(int i, int i2) {
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class Subscription {
        final int callbackToken;
        final Observer observer;

        public Subscription(int i, Observer observer) {
            this.callbackToken = i;
            this.observer = observer;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class Task {
        final int id;
        final NotificationSpec notification;
        volatile Subscription subscription;
        final String targetKey;
        final AndroidFileTransfer transfer;

        public Task(int i, String str, int i2, AndroidFileTransfer androidFileTransfer, Observer observer, NotificationSpec notificationSpec) {
            this.id = i;
            this.targetKey = str;
            this.transfer = androidFileTransfer;
            this.notification = notificationSpec;
            this.subscription = new Subscription(i2, observer);
        }

        public void subscribe(int i, Observer observer) {
            this.subscription = new Subscription(i, observer);
        }
    }

    public final class TransferCallback implements AndroidFileTransfer.Callback {
        private final int id;

        public TransferCallback(int i) {
            this.id = i;
        }

        /* JADX INFO: renamed from: lambda$onPaused$4$com-tapsdk-tapad-internal-runtime-download-AndroidDownloadHost$TransferCallback, reason: not valid java name */
        /* synthetic */ void m268lambda$onPaused$4$comtapsdktapadinternalruntimedownloadAndroidDownloadHost$TransferCallback(Task task) {
            if (AndroidDownloadHost.this.find(task.id) == task) {
                AndroidDownloadHost.this.cancel(task.id);
                task.transfer.discardPartialFile();
            }
        }

        @Override // com.tapsdk.tapad.internal.runtime.download.AndroidFileTransfer.Callback
        public void onCanceled(AndroidFileTransfer androidFileTransfer) {
            final Task taskTake = AndroidDownloadHost.this.take(this.id, androidFileTransfer);
            if (taskTake == null) {
                return;
            }
            if (taskTake.notification != null) {
                AndroidDownloadHost.this.notifications.cancel(taskTake.id);
            }
            final Subscription subscription = taskTake.subscription;
            AndroidDownloadHost.this.deliver(subscription, new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost$TransferCallback$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    AndroidDownloadHost.Subscription subscription2 = subscription;
                    subscription2.observer.onCanceled(taskTake.id, subscription2.callbackToken);
                }
            });
        }

        @Override // com.tapsdk.tapad.internal.runtime.download.AndroidFileTransfer.Callback
        public void onComplete(AndroidFileTransfer androidFileTransfer, final File file) {
            final Task taskTake = AndroidDownloadHost.this.take(this.id, androidFileTransfer);
            if (taskTake == null) {
                return;
            }
            if (taskTake.notification != null) {
                AndroidDownloadHost.this.notifications.showComplete(taskTake.id, file);
            }
            final Subscription subscription = taskTake.subscription;
            AndroidDownloadHost.this.deliver(subscription, new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost$TransferCallback$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    AndroidDownloadHost.Subscription subscription2 = subscription;
                    subscription2.observer.onComplete(taskTake.id, subscription2.callbackToken, file);
                }
            });
        }

        @Override // com.tapsdk.tapad.internal.runtime.download.AndroidFileTransfer.Callback
        public void onError(AndroidFileTransfer androidFileTransfer, int i, String str) {
            Task taskFind = AndroidDownloadHost.this.find(this.id);
            if (taskFind == null || taskFind.transfer != androidFileTransfer) {
                return;
            }
            AndroidDownloadHost.this.fail(taskFind, i, str);
        }

        @Override // com.tapsdk.tapad.internal.runtime.download.AndroidFileTransfer.Callback
        public void onPaused(AndroidFileTransfer androidFileTransfer) {
            final Task taskFind = AndroidDownloadHost.this.find(this.id);
            if (taskFind == null || taskFind.transfer != androidFileTransfer) {
                return;
            }
            final float progress = androidFileTransfer.getProgress();
            if (taskFind.notification != null) {
                AndroidDownloadHost.this.notifications.showPaused(taskFind.id, (int) (100.0f * progress));
            }
            final Subscription subscription = taskFind.subscription;
            AndroidDownloadHost.this.deliverActive(taskFind, subscription, new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost$TransferCallback$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AndroidDownloadHost.Subscription subscription2 = subscription;
                    subscription2.observer.onPaused(taskFind.id, subscription2.callbackToken, progress);
                }
            });
            AndroidDownloadHost.this.mainHandler.postAtTime(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost$TransferCallback$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m268lambda$onPaused$4$comtapsdktapadinternalruntimedownloadAndroidDownloadHost$TransferCallback(taskFind);
                }
            }, taskFind, AndroidDownloadHost.PAUSED_TASK_TTL_MS + SystemClock.uptimeMillis());
            if (androidFileTransfer.completePauseCallbackAndConsumePendingResume()) {
                AndroidDownloadHost.this.scheduleResumed(taskFind);
            }
        }

        @Override // com.tapsdk.tapad.internal.runtime.download.AndroidFileTransfer.Callback
        public void onProgress(AndroidFileTransfer androidFileTransfer, final float f, final long j, final long j2, long j3) {
            final Task taskFind = AndroidDownloadHost.this.find(this.id);
            if (taskFind == null || taskFind.transfer != androidFileTransfer) {
                return;
            }
            if (taskFind.notification != null) {
                AndroidDownloadHost.this.notifications.showProgress(taskFind.id, (int) (100.0f * f), j, j2, j3);
            }
            final Subscription subscription = taskFind.subscription;
            AndroidDownloadHost.this.deliverActive(taskFind, subscription, new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost$TransferCallback$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    AndroidDownloadHost.Subscription subscription2 = subscription;
                    subscription2.observer.onProgress(taskFind.id, subscription2.callbackToken, f, j, j2);
                }
            });
        }

        @Override // com.tapsdk.tapad.internal.runtime.download.AndroidFileTransfer.Callback
        public void onStart(AndroidFileTransfer androidFileTransfer) {
            final Task taskFind = AndroidDownloadHost.this.find(this.id);
            if (taskFind == null || taskFind.transfer != androidFileTransfer) {
                return;
            }
            if (taskFind.notification != null) {
                AndroidDownloadHost.this.notifications.showStarted(taskFind.id);
            }
            final Subscription subscription = taskFind.subscription;
            AndroidDownloadHost.this.deliverActive(taskFind, subscription, new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost$TransferCallback$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    AndroidDownloadHost.Subscription subscription2 = subscription;
                    subscription2.observer.onStarted(taskFind.id, subscription2.callbackToken);
                }
            });
        }
    }

    private AndroidDownloadHost(Context context) {
        this.appContext = context;
        this.defaultDirectory = DownloadUtils.getDefaultDownloadDir(context);
        this.notifications = AndroidDownloadNotifications.get(context);
        ApkNotificationReceiver.ensureRegistered(context);
    }

    private static ExecutorService createExecutor() {
        return new ThreadPoolExecutor(3, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost.2
            private final AtomicInteger sequence = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "DirichletTransfer-" + this.sequence.getAndIncrement());
                thread.setPriority(4);
                return thread;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deliver(Subscription subscription, Runnable runnable) {
        if (subscription.observer.deliverOnMainThread()) {
            this.mainHandler.post(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deliverActive(final Task task, Subscription subscription, final Runnable runnable) {
        Runnable runnable2 = new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m267lambda$deliverActive$2$comtapsdktapadinternalruntimedownloadAndroidDownloadHost(task, runnable);
            }
        };
        if (subscription.observer.deliverOnMainThread()) {
            this.mainHandler.post(runnable2);
        } else {
            runnable2.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fail(Task task, final int i, final String str) {
        final Task taskTake = take(task.id, task.transfer);
        if (taskTake == null) {
            return;
        }
        if (taskTake.notification != null) {
            this.notifications.showFailed(taskTake.id, str);
        }
        final Subscription subscription = taskTake.subscription;
        deliver(subscription, new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                AndroidDownloadHost.Subscription subscription2 = subscription;
                subscription2.observer.onError(taskTake.id, subscription2.callbackToken, i, AndroidDownloadHost.safeMessage(str));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task find(int i) {
        Task task;
        synchronized (this.taskLock) {
            task = this.tasks.get(i);
        }
        return task;
    }

    public static AndroidDownloadHost get(Context context) {
        if (instance == null) {
            synchronized (AndroidDownloadHost.class) {
                if (instance == null) {
                    instance = new AndroidDownloadHost(context.getApplicationContext());
                }
            }
        }
        return instance;
    }

    private File resolveTargetFile(AndroidDownloadRequest androidDownloadRequest) {
        if (androidDownloadRequest == null) {
            return null;
        }
        String fileName = androidDownloadRequest.getFileName();
        if (fileName == null || fileName.isEmpty()) {
            fileName = DownloadUtils.extractFileName(androidDownloadRequest.getPrimaryUrl());
        }
        try {
            File canonicalFile = (androidDownloadRequest.getTargetDirectory() == null ? this.defaultDirectory : new File(androidDownloadRequest.getTargetDirectory())).getCanonicalFile();
            File canonicalFile2 = new File(canonicalFile, fileName).getCanonicalFile();
            if (canonicalFile.equals(canonicalFile2.getParentFile())) {
                return canonicalFile2;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private static String safeMessage(String str) {
        return (str == null || str.isEmpty()) ? "Android file transfer failed" : str;
    }

    private boolean schedule(Task task) {
        try {
            this.executor.execute(task.transfer);
            return true;
        } catch (RuntimeException e) {
            int i = task.id;
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleResumed(final Task task) {
        this.mainHandler.removeCallbacksAndMessages(task);
        if (!schedule(task)) {
            fail(task, DownloadUtils.ErrorCode.ERROR_UNKNOWN, "Unable to resume transfer");
            return;
        }
        final float progress = task.transfer.getProgress();
        if (task.notification != null) {
            this.notifications.showProgress(task.id, (int) (100.0f * progress), 0L, 0L, 0L);
        }
        final Subscription subscription = task.subscription;
        deliverActive(task, subscription, new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AndroidDownloadHost.Subscription subscription2 = subscription;
                subscription2.observer.onResumed(task.id, subscription2.callbackToken, progress);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task take(int i, AndroidFileTransfer androidFileTransfer) {
        synchronized (this.taskLock) {
            Task task = this.tasks.get(i);
            if (task != null && (androidFileTransfer == null || task.transfer == androidFileTransfer)) {
                this.tasks.remove(i);
                if (this.tasksByTarget.get(task.targetKey) == task) {
                    this.tasksByTarget.remove(task.targetKey);
                }
                this.mainHandler.removeCallbacksAndMessages(task);
                return task;
            }
            return null;
        }
    }

    public void cancel(int i) {
        Task taskFind = find(i);
        if (taskFind == null) {
            return;
        }
        if (taskFind.notification != null) {
            this.notifications.cancel(i);
        }
        taskFind.transfer.cancel();
    }

    public File findCompletedFile(AndroidDownloadRequest androidDownloadRequest) {
        File fileResolveTargetFile = resolveTargetFile(androidDownloadRequest);
        if (isCompletedFileValid(androidDownloadRequest, fileResolveTargetFile)) {
            return fileResolveTargetFile;
        }
        return null;
    }

    public File getDefaultDirectory() {
        return this.defaultDirectory;
    }

    public boolean isCompletedFileValid(AndroidDownloadRequest androidDownloadRequest, File file) {
        return DownloadUtils.validateFile(androidDownloadRequest, file) == 0;
    }

    /* JADX INFO: renamed from: lambda$deliverActive$2$com-tapsdk-tapad-internal-runtime-download-AndroidDownloadHost, reason: not valid java name */
    /* synthetic */ void m267lambda$deliverActive$2$comtapsdktapadinternalruntimedownloadAndroidDownloadHost(Task task, Runnable runnable) {
        if (find(task.id) == task) {
            runnable.run();
        }
    }

    public void pause(int i) {
        Task taskFind = find(i);
        if (taskFind != null) {
            taskFind.transfer.pause();
        }
    }

    public void resume(int i) {
        Task taskFind = find(i);
        if (taskFind == null || !taskFind.transfer.requestResume()) {
            return;
        }
        scheduleResumed(taskFind);
    }

    public int start(String str, int i, Observer observer) {
        return start(str, i, (NotificationSpec) null, observer);
    }

    public int start(String str, int i, NotificationSpec notificationSpec, Observer observer) {
        try {
            return start(new AndroidDownloadRequest.Builder().url(str).targetDirectory(this.defaultDirectory.getAbsolutePath()).build(), i, notificationSpec, observer);
        } catch (RuntimeException e) {
            return -1;
        }
    }

    public int start(AndroidDownloadRequest androidDownloadRequest, int i, NotificationSpec notificationSpec, Observer observer) {
        File fileResolveTargetFile;
        Observer observer2;
        boolean z;
        if (androidDownloadRequest == null || androidDownloadRequest.getUrlCount() == 0 || (fileResolveTargetFile = resolveTargetFile(androidDownloadRequest)) == null) {
            return -1;
        }
        String path = fileResolveTargetFile.getPath();
        if (observer != null) {
            observer2 = observer;
        } else {
            observer2 = new Observer() { // from class: com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost.1
            };
        }
        synchronized (this.taskLock) {
            Task task = this.tasksByTarget.get(path);
            if (task != null) {
                if (!task.transfer.canAttach()) {
                    return -1;
                }
                task.subscribe(i, observer2);
                z = true;
            } else {
                int andIncrement = this.nextId.getAndIncrement();
                AndroidFileTransfer androidFileTransfer = new AndroidFileTransfer(androidDownloadRequest);
                Task task2 = new Task(andIncrement, path, i, androidFileTransfer, observer2, notificationSpec);
                androidFileTransfer.setCallback(new TransferCallback(andIncrement));
                this.tasks.put(andIncrement, task2);
                this.tasksByTarget.put(path, task2);
                task = task2;
                z = false;
            }
            if (z) {
                fileResolveTargetFile.getName();
                if (task.transfer.isPausedOrPausing()) {
                    resume(task.id);
                }
                return task.id;
            }
            if (!DownloadUtils.isNetworkAvailable(this.appContext)) {
                fail(task, 1001, "Network unavailable");
                return task.id;
            }
            if (!DownloadUtils.hasEnoughStorage(fileResolveTargetFile.getParentFile(), androidDownloadRequest.getExpectedSize(), fileResolveTargetFile.isFile() ? fileResolveTargetFile.length() : 0L)) {
                fail(task, DownloadUtils.ErrorCode.ERROR_STORAGE_INSUFFICIENT, "Insufficient storage for download");
                return task.id;
            }
            if (notificationSpec != null) {
                this.notifications.prepare(task.id, notificationSpec.title, notificationSpec.iconUrl);
            }
            if (!schedule(task)) {
                take(task.id, task.transfer);
                if (notificationSpec == null) {
                    return -1;
                }
                this.notifications.cancel(task.id);
                return -1;
            }
            return task.id;
        }
    }
}
