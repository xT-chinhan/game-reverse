package com.taptap.sdk.update.download.core.listener;

import com.taptap.sdk.update.download.DownloadListener;
import com.taptap.sdk.update.download.DownloadTask;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointInfo;
import com.taptap.sdk.update.download.core.cause.EndCause;
import com.taptap.sdk.update.download.core.cause.ResumeFailedCause;
import com.taptap.sdk.update.download.core.listener.assist.Listener4Assist;
import com.taptap.sdk.update.download.core.listener.assist.ListenerAssist;
import com.taptap.sdk.update.download.core.listener.assist.ListenerModelHandler;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DownloadListener4 implements DownloadListener, Listener4Assist.Listener4Callback, ListenerAssist {
    final Listener4Assist assist;

    DownloadListener4(Listener4Assist assist) {
        this.assist = assist;
        assist.setCallback(this);
    }

    public DownloadListener4() {
        this(new Listener4Assist(new Listener4ModelCreator()));
    }

    public void setAssistExtend(Listener4Assist.AssistExtend assistExtend) {
        this.assist.setAssistExtend(assistExtend);
    }

    @Override // com.taptap.sdk.update.download.core.listener.assist.ListenerAssist
    public boolean isAlwaysRecoverAssistModel() {
        return this.assist.isAlwaysRecoverAssistModel();
    }

    @Override // com.taptap.sdk.update.download.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModel(boolean isAlwaysRecoverAssistModel) {
        this.assist.setAlwaysRecoverAssistModel(isAlwaysRecoverAssistModel);
    }

    @Override // com.taptap.sdk.update.download.core.listener.assist.ListenerAssist
    public void setAlwaysRecoverAssistModelIfNotSet(boolean isAlwaysRecoverAssistModel) {
        this.assist.setAlwaysRecoverAssistModelIfNotSet(isAlwaysRecoverAssistModel);
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public void connectTrialStart(DownloadTask task, Map<String, List<String>> requestHeaderFields) {
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public void connectTrialEnd(DownloadTask task, int responseCode, Map<String, List<String>> responseHeaderFields) {
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public final void downloadFromBeginning(DownloadTask task, BreakpointInfo info, ResumeFailedCause cause) {
        this.assist.infoReady(task, info, false);
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public final void downloadFromBreakpoint(DownloadTask task, BreakpointInfo info) {
        this.assist.infoReady(task, info, true);
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public void fetchStart(DownloadTask task, int blockIndex, long contentLength) {
    }

    public void setCurrentOffset(DownloadTask task, long offset) {
        this.assist.setCurrentOffset(task, offset);
    }

    public long getCurrentOffset(DownloadTask task) {
        return this.assist.getCurrentOffset(task);
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public final void fetchProgress(DownloadTask task, int blockIndex, long increaseBytes) {
        this.assist.fetchProgress(task, blockIndex, increaseBytes);
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public void fetchEnd(DownloadTask task, int blockIndex, long contentLength) {
        this.assist.fetchEnd(task, blockIndex);
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public final void taskEnd(DownloadTask task, EndCause cause, Exception realCause) {
        this.assist.taskEnd(task, cause, realCause);
    }

    static class Listener4ModelCreator implements ListenerModelHandler.ModelCreator<Listener4Assist.Listener4Model> {
        Listener4ModelCreator() {
        }

        @Override // com.taptap.sdk.update.download.core.listener.assist.ListenerModelHandler.ModelCreator
        public Listener4Assist.Listener4Model create(int id) {
            return new Listener4Assist.Listener4Model(id);
        }
    }
}
