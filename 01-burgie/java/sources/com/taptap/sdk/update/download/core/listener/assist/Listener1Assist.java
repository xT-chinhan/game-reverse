package com.taptap.sdk.update.download.core.listener.assist;

import com.taptap.sdk.update.download.DownloadTask;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointInfo;
import com.taptap.sdk.update.download.core.cause.EndCause;
import com.taptap.sdk.update.download.core.cause.ResumeFailedCause;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public class Listener1Assist implements ListenerAssist, ListenerModelHandler.ModelCreator<Listener1Model> {
    private Listener1Callback callback;
    private final ListenerModelHandler<Listener1Model> modelHandler;

    public interface Listener1Callback {
        void connected(DownloadTask downloadTask, int i, long j, long j2);

        void progress(DownloadTask downloadTask, long j, long j2);

        void retry(DownloadTask downloadTask, ResumeFailedCause resumeFailedCause);

        void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc, Listener1Model listener1Model);

        void taskStart(DownloadTask downloadTask, Listener1Model listener1Model);
    }

    public Listener1Assist() {
        this.modelHandler = new ListenerModelHandler<>(this);
    }

    Listener1Assist(ListenerModelHandler<Listener1Model> handler) {
        this.modelHandler = handler;
    }

    public void setCallback(Listener1Callback callback) {
        this.callback = callback;
    }

    public void taskStart(DownloadTask task) {
        Listener1Model model = (Listener1Model) this.modelHandler.addAndGetModel(task, null);
        Listener1Callback listener1Callback = this.callback;
        if (listener1Callback != null) {
            listener1Callback.taskStart(task, model);
        }
    }

    public void taskEnd(DownloadTask task, EndCause cause, Exception realCause) {
        Listener1Model model = (Listener1Model) this.modelHandler.removeOrCreate(task, task.getInfo());
        Listener1Callback listener1Callback = this.callback;
        if (listener1Callback != null) {
            listener1Callback.taskEnd(task, cause, realCause, model);
        }
    }

    public void downloadFromBeginning(DownloadTask task, BreakpointInfo info, ResumeFailedCause cause) {
        Listener1Callback listener1Callback;
        Listener1Model model = (Listener1Model) this.modelHandler.getOrRecoverModel(task, info);
        if (model == null) {
            return;
        }
        model.onInfoValid(info);
        if (model.isStarted.booleanValue() && (listener1Callback = this.callback) != null) {
            listener1Callback.retry(task, cause);
        }
        model.isStarted = true;
        model.isFromResumed = false;
        model.isFirstConnect = true;
    }

    public void downloadFromBreakpoint(DownloadTask task, BreakpointInfo info) {
        Listener1Model model = (Listener1Model) this.modelHandler.getOrRecoverModel(task, info);
        if (model == null) {
            return;
        }
        model.onInfoValid(info);
        model.isStarted = true;
        model.isFromResumed = true;
        model.isFirstConnect = true;
    }

    public void connectEnd(DownloadTask task) {
        Listener1Model model = (Listener1Model) this.modelHandler.getOrRecoverModel(task, task.getInfo());
        if (model == null) {
            return;
        }
        if (Boolean.TRUE.equals(model.isFromResumed) && Boolean.TRUE.equals(model.isFirstConnect)) {
            model.isFirstConnect = false;
        }
        Listener1Callback listener1Callback = this.callback;
        if (listener1Callback != null) {
            listener1Callback.connected(task, model.blockCount, model.currentOffset.get(), model.totalLength);
        }
    }

    public void fetchProgress(DownloadTask task, long increaseBytes) {
        Listener1Model model = (Listener1Model) this.modelHandler.getOrRecoverModel(task, task.getInfo());
        if (model == null) {
            return;
        }
        model.currentOffset.addAndGet(increaseBytes);
        Listener1Callback listener1Callback = this.callback;
        if (listener1Callback != null) {
            listener1Callback.progress(task, model.currentOffset.get(), model.totalLength);
        }
    }

    @Override // com.taptap.sdk.update.download.core.listener.assist.ListenerAssist
    public boolean isAlwaysRecoverAssistModel() {
        return this.modelHandler.isAlwaysRecoverAssistModel();
    }

    @Override // com.taptap.sdk.update.download.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModel(boolean isAlwaysRecoverAssistModel) {
        this.modelHandler.setAlwaysRecoverAssistModel(isAlwaysRecoverAssistModel);
    }

    @Override // com.taptap.sdk.update.download.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModelIfNotSet(boolean isAlwaysRecoverAssistModel) {
        this.modelHandler.setAlwaysRecoverAssistModelIfNotSet(isAlwaysRecoverAssistModel);
    }

    @Override // com.taptap.sdk.update.download.core.listener.assist.ListenerModelHandler.ModelCreator
    public Listener1Model create(int id) {
        return new Listener1Model(id);
    }

    public static class Listener1Model implements ListenerModelHandler.ListenerModel {
        int blockCount;
        final AtomicLong currentOffset = new AtomicLong();
        final int id;
        volatile Boolean isFirstConnect;
        Boolean isFromResumed;
        Boolean isStarted;
        long totalLength;

        Listener1Model(int id) {
            this.id = id;
        }

        public long getTotalLength() {
            return this.totalLength;
        }

        @Override // com.taptap.sdk.update.download.core.listener.assist.ListenerModelHandler.ListenerModel
        public int getId() {
            return this.id;
        }

        @Override // com.taptap.sdk.update.download.core.listener.assist.ListenerModelHandler.ListenerModel
        public void onInfoValid(BreakpointInfo info) {
            this.blockCount = info.getBlockCount();
            this.totalLength = info.getTotalLength();
            this.currentOffset.set(info.getTotalOffset());
            if (this.isStarted == null) {
                this.isStarted = false;
            }
            if (this.isFromResumed == null) {
                this.isFromResumed = Boolean.valueOf(this.currentOffset.get() > 0);
            }
            if (this.isFirstConnect == null) {
                this.isFirstConnect = true;
            }
        }
    }
}
