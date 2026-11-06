package com.taptap.sdk.update.download.core.listener.assist;

import android.util.SparseArray;
import com.taptap.sdk.update.download.DownloadTask;
import com.taptap.sdk.update.download.SpeedCalculator;
import com.taptap.sdk.update.download.core.breakpoint.BlockInfo;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointInfo;
import com.taptap.sdk.update.download.core.cause.EndCause;

/* JADX INFO: loaded from: classes3.dex */
public class Listener4SpeedAssistExtend implements Listener4Assist.AssistExtend, ListenerModelHandler.ModelCreator<Listener4SpeedModel> {
    private Listener4SpeedCallback callback;

    public interface Listener4SpeedCallback {
        void blockEnd(DownloadTask downloadTask, int i, BlockInfo blockInfo, SpeedCalculator speedCalculator);

        void infoReady(DownloadTask downloadTask, BreakpointInfo breakpointInfo, boolean z, Listener4SpeedModel listener4SpeedModel);

        void progress(DownloadTask downloadTask, long j, SpeedCalculator speedCalculator);

        void progressBlock(DownloadTask downloadTask, int i, long j, SpeedCalculator speedCalculator);

        void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc, SpeedCalculator speedCalculator);
    }

    public void setCallback(Listener4SpeedCallback callback) {
        this.callback = callback;
    }

    @Override // com.taptap.sdk.update.download.core.listener.assist.Listener4Assist.AssistExtend
    public boolean dispatchInfoReady(DownloadTask task, BreakpointInfo info, boolean fromBreakpoint, Listener4Assist.Listener4Model model) {
        Listener4SpeedCallback listener4SpeedCallback = this.callback;
        if (listener4SpeedCallback != null) {
            listener4SpeedCallback.infoReady(task, info, fromBreakpoint, (Listener4SpeedModel) model);
            return true;
        }
        return true;
    }

    @Override // com.taptap.sdk.update.download.core.listener.assist.Listener4Assist.AssistExtend
    public boolean dispatchFetchProgress(DownloadTask task, int blockIndex, long increaseBytes, Listener4Assist.Listener4Model model) {
        Listener4SpeedModel speedModel = (Listener4SpeedModel) model;
        speedModel.blockSpeeds.get(blockIndex).downloading(increaseBytes);
        speedModel.taskSpeed.downloading(increaseBytes);
        Listener4SpeedCallback listener4SpeedCallback = this.callback;
        if (listener4SpeedCallback != null) {
            listener4SpeedCallback.progressBlock(task, blockIndex, model.blockCurrentOffsetMap.get(blockIndex).longValue(), speedModel.getBlockSpeed(blockIndex));
            this.callback.progress(task, model.currentOffset, speedModel.taskSpeed);
            return true;
        }
        return true;
    }

    @Override // com.taptap.sdk.update.download.core.listener.assist.Listener4Assist.AssistExtend
    public boolean dispatchBlockEnd(DownloadTask task, int blockIndex, Listener4Assist.Listener4Model model) {
        Listener4SpeedModel speedModel = (Listener4SpeedModel) model;
        speedModel.blockSpeeds.get(blockIndex).endTask();
        Listener4SpeedCallback listener4SpeedCallback = this.callback;
        if (listener4SpeedCallback != null) {
            listener4SpeedCallback.blockEnd(task, blockIndex, model.info.getBlock(blockIndex), speedModel.getBlockSpeed(blockIndex));
            return true;
        }
        return true;
    }

    @Override // com.taptap.sdk.update.download.core.listener.assist.Listener4Assist.AssistExtend
    public boolean dispatchTaskEnd(DownloadTask task, EndCause cause, Exception realCause, Listener4Assist.Listener4Model model) {
        SpeedCalculator speedCalculator;
        Listener4SpeedModel speedModel = (Listener4SpeedModel) model;
        if (speedModel.taskSpeed != null) {
            speedCalculator = speedModel.taskSpeed;
            speedCalculator.endTask();
        } else {
            speedCalculator = new SpeedCalculator();
        }
        Listener4SpeedCallback listener4SpeedCallback = this.callback;
        if (listener4SpeedCallback != null) {
            listener4SpeedCallback.taskEnd(task, cause, realCause, speedCalculator);
            return true;
        }
        return true;
    }

    @Override // com.taptap.sdk.update.download.core.listener.assist.ListenerModelHandler.ModelCreator
    public Listener4SpeedModel create(int id) {
        return new Listener4SpeedModel(id);
    }

    public static class Listener4SpeedModel extends Listener4Assist.Listener4Model {
        SparseArray<SpeedCalculator> blockSpeeds;
        SpeedCalculator taskSpeed;

        public SpeedCalculator getTaskSpeed() {
            return this.taskSpeed;
        }

        public SpeedCalculator getBlockSpeed(int blockIndex) {
            return this.blockSpeeds.get(blockIndex);
        }

        public Listener4SpeedModel(int id) {
            super(id);
        }

        @Override // com.taptap.sdk.update.download.core.listener.assist.Listener4Assist.Listener4Model, com.taptap.sdk.update.download.core.listener.assist.ListenerModelHandler.ListenerModel
        public void onInfoValid(BreakpointInfo info) {
            super.onInfoValid(info);
            this.taskSpeed = new SpeedCalculator();
            this.blockSpeeds = new SparseArray<>();
            int blockCount = info.getBlockCount();
            for (int i = 0; i < blockCount; i++) {
                this.blockSpeeds.put(i, new SpeedCalculator());
            }
        }
    }
}
