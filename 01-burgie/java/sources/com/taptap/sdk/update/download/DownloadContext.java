package com.taptap.sdk.update.download;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.taptap.sdk.update.download.core.Util;
import com.taptap.sdk.update.download.core.cause.EndCause;
import com.taptap.sdk.update.download.core.listener.DownloadListener2;
import com.taptap.sdk.update.download.core.listener.DownloadListenerBunch;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadContext {
    private static final Executor SERIAL_EXECUTOR = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkDownload Serial", false));
    private static final String TAG = "DownloadContext";
    final DownloadContextListener contextListener;
    private final QueueSet set;
    volatile boolean started;
    private final DownloadTask[] tasks;
    private Handler uiHandler;

    DownloadContext(DownloadTask[] tasks, DownloadContextListener contextListener, QueueSet set, Handler uiHandler) {
        this(tasks, contextListener, set);
        this.uiHandler = uiHandler;
    }

    DownloadContext(DownloadTask[] tasks, DownloadContextListener contextListener, QueueSet set) {
        this.started = false;
        this.tasks = tasks;
        this.contextListener = contextListener;
        this.set = set;
    }

    public boolean isStarted() {
        return this.started;
    }

    public DownloadTask[] getTasks() {
        return this.tasks;
    }

    public void startOnSerial(DownloadListener listener) {
        start(listener, true);
    }

    public void startOnParallel(DownloadListener listener) {
        start(listener, false);
    }

    public void start(DownloadListener listener, boolean isSerial) {
        final DownloadListener targetListener;
        long startTime = SystemClock.uptimeMillis();
        Util.d(TAG, "start " + isSerial);
        this.started = true;
        if (this.contextListener != null) {
            targetListener = new DownloadListenerBunch.Builder().append(listener).append(new QueueAttachListener(this, this.contextListener, this.tasks.length)).build();
        } else {
            targetListener = listener;
        }
        if (isSerial) {
            final List<DownloadTask> scheduleTaskList = new ArrayList<>();
            Collections.addAll(scheduleTaskList, this.tasks);
            Collections.sort(scheduleTaskList);
            executeOnSerialExecutor(new Runnable() { // from class: com.taptap.sdk.update.download.DownloadContext.1
                @Override // java.lang.Runnable
                public void run() {
                    for (DownloadTask task : scheduleTaskList) {
                        if (!DownloadContext.this.isStarted()) {
                            DownloadContext.this.callbackQueueEndOnSerialLoop(task.isAutoCallbackToUIThread());
                            return;
                        }
                        task.execute(targetListener);
                    }
                }
            });
        } else {
            DownloadTask.enqueue(this.tasks, targetListener);
        }
        Util.d(TAG, "start finish " + isSerial + " " + (SystemClock.uptimeMillis() - startTime) + "ms");
    }

    public AlterContext alter() {
        return new AlterContext(this);
    }

    public void stop() {
        if (this.started) {
            OkDownload.with().downloadDispatcher().cancel(this.tasks);
        }
        this.started = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackQueueEndOnSerialLoop(boolean isAutoCallbackToUIThread) {
        DownloadContextListener downloadContextListener = this.contextListener;
        if (downloadContextListener == null) {
            return;
        }
        if (isAutoCallbackToUIThread) {
            if (this.uiHandler == null) {
                this.uiHandler = new Handler(Looper.getMainLooper());
            }
            this.uiHandler.post(new Runnable() { // from class: com.taptap.sdk.update.download.DownloadContext.2
                @Override // java.lang.Runnable
                public void run() {
                    DownloadContext.this.contextListener.queueEnd(DownloadContext.this);
                }
            });
            return;
        }
        downloadContextListener.queueEnd(this);
    }

    void executeOnSerialExecutor(Runnable runnable) {
        SERIAL_EXECUTOR.execute(runnable);
    }

    public Builder toBuilder() {
        return new Builder(this.set, new ArrayList(Arrays.asList(this.tasks))).setListener(this.contextListener);
    }

    public static class Builder {
        final ArrayList<DownloadTask> boundTaskList;
        private DownloadContextListener listener;
        private final QueueSet set;

        public Builder() {
            this(new QueueSet());
        }

        public Builder(QueueSet set) {
            this(set, new ArrayList());
        }

        public Builder(QueueSet set, ArrayList<DownloadTask> taskArrayList) {
            this.set = set;
            this.boundTaskList = taskArrayList;
        }

        public Builder setListener(DownloadContextListener listener) {
            this.listener = listener;
            return this;
        }

        public Builder bindSetTask(DownloadTask task) {
            int index = this.boundTaskList.indexOf(task);
            if (index >= 0) {
                this.boundTaskList.set(index, task);
            } else {
                this.boundTaskList.add(task);
            }
            return this;
        }

        public DownloadTask bind(String url) {
            if (this.set.uri == null) {
                throw new IllegalArgumentException("If you want to bind only with url, you have to provide parentPath on QueueSet!");
            }
            return bind(new DownloadTask.Builder(url, this.set.uri).setFilenameFromResponse(true));
        }

        public DownloadTask bind(DownloadTask.Builder taskBuilder) {
            if (this.set.headerMapFields != null) {
                taskBuilder.setHeaderMapFields(this.set.headerMapFields);
            }
            if (this.set.readBufferSize != null) {
                taskBuilder.setReadBufferSize(this.set.readBufferSize.intValue());
            }
            if (this.set.flushBufferSize != null) {
                taskBuilder.setFlushBufferSize(this.set.flushBufferSize.intValue());
            }
            if (this.set.syncBufferSize != null) {
                taskBuilder.setSyncBufferSize(this.set.syncBufferSize.intValue());
            }
            if (this.set.wifiRequired != null) {
                taskBuilder.setWifiRequired(this.set.wifiRequired.booleanValue());
            }
            if (this.set.syncBufferIntervalMillis != null) {
                taskBuilder.setSyncBufferIntervalMillis(this.set.syncBufferIntervalMillis.intValue());
            }
            if (this.set.autoCallbackToUIThread != null) {
                taskBuilder.setAutoCallbackToUIThread(this.set.autoCallbackToUIThread.booleanValue());
            }
            if (this.set.minIntervalMillisCallbackProcess != null) {
                taskBuilder.setMinIntervalMillisCallbackProcess(this.set.minIntervalMillisCallbackProcess.intValue());
            }
            if (this.set.passIfAlreadyCompleted != null) {
                taskBuilder.setPassIfAlreadyCompleted(this.set.passIfAlreadyCompleted.booleanValue());
            }
            DownloadTask task = taskBuilder.build();
            if (this.set.tag != null) {
                task.setTag(this.set.tag);
            }
            this.boundTaskList.add(task);
            return task;
        }

        public void unbind(DownloadTask task) {
            this.boundTaskList.remove(task);
        }

        public void unbind(int id) {
            List<DownloadTask> list = (List) this.boundTaskList.clone();
            for (DownloadTask task : list) {
                if (task.getId() == id) {
                    this.boundTaskList.remove(task);
                }
            }
        }

        public DownloadContext build() {
            DownloadTask[] tasks = new DownloadTask[this.boundTaskList.size()];
            return new DownloadContext((DownloadTask[]) this.boundTaskList.toArray(tasks), this.listener, this.set);
        }
    }

    public static class QueueSet {
        private Boolean autoCallbackToUIThread;
        private Integer flushBufferSize;
        private Map<String, List<String>> headerMapFields;
        private Integer minIntervalMillisCallbackProcess;
        private Boolean passIfAlreadyCompleted;
        private Integer readBufferSize;
        private Integer syncBufferIntervalMillis;
        private Integer syncBufferSize;
        private Object tag;
        private Uri uri;
        private Boolean wifiRequired;

        public Map<String, List<String>> getHeaderMapFields() {
            return this.headerMapFields;
        }

        public void setHeaderMapFields(Map<String, List<String>> headerMapFields) {
            this.headerMapFields = headerMapFields;
        }

        public Uri getDirUri() {
            return this.uri;
        }

        public QueueSet setParentPathUri(Uri uri) {
            this.uri = uri;
            return this;
        }

        public QueueSet setParentPathFile(File parentPathFile) {
            if (parentPathFile.isFile()) {
                throw new IllegalArgumentException("parent path only accept directory path");
            }
            this.uri = Uri.fromFile(parentPathFile);
            return this;
        }

        public QueueSet setParentPath(String parentPath) {
            return setParentPathFile(new File(parentPath));
        }

        public int getReadBufferSize() {
            Integer num = this.readBufferSize;
            if (num == null) {
                return 4096;
            }
            return num.intValue();
        }

        public QueueSet setReadBufferSize(int readBufferSize) {
            this.readBufferSize = Integer.valueOf(readBufferSize);
            return this;
        }

        public QueueSet setWifiRequired(Boolean wifiRequired) {
            this.wifiRequired = wifiRequired;
            return this;
        }

        public boolean isWifiRequired() {
            Boolean bool = this.wifiRequired;
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }

        public int getFlushBufferSize() {
            Integer num = this.flushBufferSize;
            if (num == null) {
                return 16384;
            }
            return num.intValue();
        }

        public QueueSet setFlushBufferSize(int flushBufferSize) {
            this.flushBufferSize = Integer.valueOf(flushBufferSize);
            return this;
        }

        public int getSyncBufferSize() {
            Integer num = this.syncBufferSize;
            if (num == null) {
                return 65536;
            }
            return num.intValue();
        }

        public QueueSet setSyncBufferSize(int syncBufferSize) {
            this.syncBufferSize = Integer.valueOf(syncBufferSize);
            return this;
        }

        public int getSyncBufferIntervalMillis() {
            Integer num = this.syncBufferIntervalMillis;
            if (num == null) {
                return DownloadTask.Builder.DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS;
            }
            return num.intValue();
        }

        public QueueSet setSyncBufferIntervalMillis(int syncBufferIntervalMillis) {
            this.syncBufferIntervalMillis = Integer.valueOf(syncBufferIntervalMillis);
            return this;
        }

        public boolean isAutoCallbackToUIThread() {
            Boolean bool = this.autoCallbackToUIThread;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }

        public QueueSet setAutoCallbackToUIThread(Boolean autoCallbackToUIThread) {
            this.autoCallbackToUIThread = autoCallbackToUIThread;
            return this;
        }

        public int getMinIntervalMillisCallbackProcess() {
            Integer num = this.minIntervalMillisCallbackProcess;
            if (num == null) {
                return 3000;
            }
            return num.intValue();
        }

        public QueueSet setMinIntervalMillisCallbackProcess(Integer minIntervalMillisCallbackProcess) {
            this.minIntervalMillisCallbackProcess = minIntervalMillisCallbackProcess;
            return this;
        }

        public Object getTag() {
            return this.tag;
        }

        public QueueSet setTag(Object tag) {
            this.tag = tag;
            return this;
        }

        public boolean isPassIfAlreadyCompleted() {
            Boolean bool = this.passIfAlreadyCompleted;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }

        public QueueSet setPassIfAlreadyCompleted(boolean passIfAlreadyCompleted) {
            this.passIfAlreadyCompleted = Boolean.valueOf(passIfAlreadyCompleted);
            return this;
        }

        public Builder commit() {
            return new Builder(this);
        }
    }

    static class QueueAttachListener extends DownloadListener2 {
        private final DownloadContextListener contextListener;
        private final DownloadContext hostContext;
        private final AtomicInteger remainCount;

        QueueAttachListener(DownloadContext context, DownloadContextListener contextListener, int taskCount) {
            this.remainCount = new AtomicInteger(taskCount);
            this.contextListener = contextListener;
            this.hostContext = context;
        }

        @Override // com.taptap.sdk.update.download.DownloadListener
        public void taskStart(DownloadTask task) {
        }

        @Override // com.taptap.sdk.update.download.DownloadListener
        public void taskEnd(DownloadTask task, EndCause cause, Exception realCause) {
            int remainCount = this.remainCount.decrementAndGet();
            this.contextListener.taskEnd(this.hostContext, task, cause, realCause, remainCount);
            if (remainCount <= 0) {
                this.contextListener.queueEnd(this.hostContext);
                Util.d(DownloadContext.TAG, "taskEnd and remainCount " + remainCount);
            }
        }
    }

    public static class AlterContext {
        private final DownloadContext context;

        AlterContext(DownloadContext context) {
            this.context = context;
        }

        public AlterContext replaceTask(DownloadTask oldTask, DownloadTask newTask) {
            DownloadTask[] tasks = this.context.tasks;
            for (int i = 0; i < tasks.length; i++) {
                DownloadTask task = tasks[i];
                if (task == oldTask) {
                    tasks[i] = newTask;
                }
            }
            return this;
        }
    }
}
