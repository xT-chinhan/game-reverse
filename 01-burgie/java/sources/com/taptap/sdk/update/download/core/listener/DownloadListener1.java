package com.taptap.sdk.update.download.core.listener;

import com.taptap.sdk.update.download.DownloadListener;
import com.taptap.sdk.update.download.DownloadTask;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointInfo;
import com.taptap.sdk.update.download.core.cause.EndCause;
import com.taptap.sdk.update.download.core.cause.ResumeFailedCause;
import com.taptap.sdk.update.download.core.listener.assist.Listener1Assist;
import com.taptap.sdk.update.download.core.listener.assist.ListenerAssist;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DownloadListener1 implements DownloadListener, Listener1Assist.Listener1Callback, ListenerAssist {
    final Listener1Assist assist;

    DownloadListener1(Listener1Assist assist) {
        this.assist = assist;
        assist.setCallback(this);
    }

    public DownloadListener1() {
        this(new Listener1Assist());
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
    public final void taskStart(DownloadTask task) {
        this.assist.taskStart(task);
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public void connectTrialStart(DownloadTask task, Map<String, List<String>> requestHeaderFields) {
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public void connectTrialEnd(DownloadTask task, int responseCode, Map<String, List<String>> responseHeaderFields) {
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public void downloadFromBeginning(DownloadTask task, BreakpointInfo info, ResumeFailedCause cause) {
        this.assist.downloadFromBeginning(task, info, cause);
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public void downloadFromBreakpoint(DownloadTask task, BreakpointInfo info) {
        this.assist.downloadFromBreakpoint(task, info);
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public void connectStart(DownloadTask task, int blockIndex, Map<String, List<String>> requestHeaderFields) {
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public void connectEnd(DownloadTask task, int blockIndex, int responseCode, Map<String, List<String>> responseHeaderFields) {
        this.assist.connectEnd(task);
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public void fetchStart(DownloadTask task, int blockIndex, long contentLength) {
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public void fetchProgress(DownloadTask task, int blockIndex, long increaseBytes) {
        this.assist.fetchProgress(task, increaseBytes);
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public void fetchEnd(DownloadTask task, int blockIndex, long contentLength) {
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public final void taskEnd(DownloadTask task, EndCause cause, Exception realCause) {
        this.assist.taskEnd(task, cause, realCause);
    }
}
