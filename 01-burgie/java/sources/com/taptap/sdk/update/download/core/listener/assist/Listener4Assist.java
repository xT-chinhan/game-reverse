package com.taptap.sdk.update.download.core.listener.assist;

import android.util.SparseArray;
import com.taptap.sdk.update.download.DownloadTask;
import com.taptap.sdk.update.download.core.breakpoint.BlockInfo;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointInfo;
import com.taptap.sdk.update.download.core.cause.EndCause;
import com.taptap.sdk.update.download.core.listener.assist.Listener4Assist.Listener4Model;

/* JADX INFO: loaded from: classes3.dex */
public class Listener4Assist<T extends Listener4Model> implements ListenerAssist {
    private AssistExtend assistExtend;
    Listener4Callback callback;
    private final ListenerModelHandler<T> modelHandler;

    public interface AssistExtend {
        boolean dispatchBlockEnd(DownloadTask downloadTask, int i, Listener4Model listener4Model);

        boolean dispatchFetchProgress(DownloadTask downloadTask, int i, long j, Listener4Model listener4Model);

        boolean dispatchInfoReady(DownloadTask downloadTask, BreakpointInfo breakpointInfo, boolean z, Listener4Model listener4Model);

        boolean dispatchTaskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc, Listener4Model listener4Model);
    }

    public interface Listener4Callback {
        void blockEnd(DownloadTask downloadTask, int i, BlockInfo blockInfo);

        void infoReady(DownloadTask downloadTask, BreakpointInfo breakpointInfo, boolean z, Listener4Model listener4Model);

        void progress(DownloadTask downloadTask, long j);

        void progressBlock(DownloadTask downloadTask, int i, long j);

        void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc, Listener4Model listener4Model);
    }

    Listener4Assist(ListenerModelHandler<T> handler) {
        this.modelHandler = handler;
    }

    public Listener4Assist(ListenerModelHandler.ModelCreator<T> creator) {
        this.modelHandler = new ListenerModelHandler<>(creator);
    }

    public void setCallback(Listener4Callback callback) {
        this.callback = callback;
    }

    public void setAssistExtend(AssistExtend assistExtend) {
        this.assistExtend = assistExtend;
    }

    public AssistExtend getAssistExtend() {
        return this.assistExtend;
    }

    public void infoReady(DownloadTask task, BreakpointInfo info, boolean fromBreakpoint) {
        Listener4Callback listener4Callback;
        Listener4Model model = (Listener4Model) this.modelHandler.addAndGetModel(task, info);
        AssistExtend assistExtend = this.assistExtend;
        if ((assistExtend == null || !assistExtend.dispatchInfoReady(task, info, fromBreakpoint, model)) && (listener4Callback = this.callback) != null) {
            listener4Callback.infoReady(task, info, fromBreakpoint, model);
        }
    }

    public void setCurrentOffset(DownloadTask task, long offset) {
        Listener4Model model = (Listener4Model) this.modelHandler.addAndGetModel(task, task.getInfo());
        model.setCurrentOffset(offset);
    }

    public long getCurrentOffset(DownloadTask task) {
        Listener4Model model = (Listener4Model) this.modelHandler.getOrRecoverModel(task, task.getInfo());
        if (model != null) {
            return model.getCurrentOffset();
        }
        return 0L;
    }

    public void fetchProgress(DownloadTask task, int blockIndex, long increaseBytes) {
        Listener4Callback listener4Callback;
        Listener4Model model = (Listener4Model) this.modelHandler.getOrRecoverModel(task, task.getInfo());
        if (model == null || model.blockCurrentOffsetMap.get(blockIndex) == null) {
            return;
        }
        long blockCurrentOffset = model.blockCurrentOffsetMap.get(blockIndex).longValue() + increaseBytes;
        model.blockCurrentOffsetMap.put(blockIndex, Long.valueOf(blockCurrentOffset));
        model.currentOffset += increaseBytes;
        AssistExtend assistExtend = this.assistExtend;
        if ((assistExtend == null || !assistExtend.dispatchFetchProgress(task, blockIndex, increaseBytes, model)) && (listener4Callback = this.callback) != null) {
            listener4Callback.progressBlock(task, blockIndex, blockCurrentOffset);
            this.callback.progress(task, model.currentOffset);
        }
    }

    public void fetchEnd(DownloadTask task, int blockIndex) {
        Listener4Callback listener4Callback;
        Listener4Model model = (Listener4Model) this.modelHandler.getOrRecoverModel(task, task.getInfo());
        if (model == null) {
            return;
        }
        AssistExtend assistExtend = this.assistExtend;
        if ((assistExtend == null || !assistExtend.dispatchBlockEnd(task, blockIndex, model)) && (listener4Callback = this.callback) != null) {
            listener4Callback.blockEnd(task, blockIndex, model.info.getBlock(blockIndex));
        }
    }

    public synchronized void taskEnd(DownloadTask task, EndCause cause, Exception realCause) {
        Listener4Model model = (Listener4Model) this.modelHandler.removeOrCreate(task, task.getInfo());
        AssistExtend assistExtend = this.assistExtend;
        if (assistExtend == null || !assistExtend.dispatchTaskEnd(task, cause, realCause, model)) {
            Listener4Callback listener4Callback = this.callback;
            if (listener4Callback != null) {
                listener4Callback.taskEnd(task, cause, realCause, model);
            }
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

    public static class Listener4Model implements ListenerModelHandler.ListenerModel {
        SparseArray<Long> blockCurrentOffsetMap;
        long currentOffset;
        private final int id;
        BreakpointInfo info;

        public Listener4Model(int id) {
            this.id = id;
        }

        SparseArray<Long> getBlockCurrentOffsetMap() {
            return this.blockCurrentOffsetMap;
        }

        public long getCurrentOffset() {
            return this.currentOffset;
        }

        public void setCurrentOffset(long offset) {
            this.currentOffset = offset;
        }

        public long getBlockCurrentOffset(int blockIndex) {
            return this.blockCurrentOffsetMap.get(blockIndex).longValue();
        }

        public SparseArray<Long> cloneBlockCurrentOffsetMap() {
            return this.blockCurrentOffsetMap.clone();
        }

        public BreakpointInfo getInfo() {
            return this.info;
        }

        @Override // com.taptap.sdk.update.download.core.listener.assist.ListenerModelHandler.ListenerModel
        public int getId() {
            return this.id;
        }

        @Override // com.taptap.sdk.update.download.core.listener.assist.ListenerModelHandler.ListenerModel
        public void onInfoValid(BreakpointInfo info) {
            this.info = info;
            this.currentOffset = info.getTotalOffset();
            SparseArray<Long> blockCurrentOffsetMap = new SparseArray<>();
            int blockCount = info.getBlockCount();
            for (int i = 0; i < blockCount; i++) {
                BlockInfo blockInfo = info.getBlock(i);
                blockCurrentOffsetMap.put(i, Long.valueOf(blockInfo.getCurrentOffset()));
            }
            this.blockCurrentOffsetMap = blockCurrentOffsetMap;
        }
    }
}
