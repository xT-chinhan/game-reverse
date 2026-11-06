package com.taptap.sdk.update.download.core.listener;

import com.taptap.sdk.update.download.DownloadListener;
import com.taptap.sdk.update.download.DownloadTask;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointInfo;
import com.taptap.sdk.update.download.core.cause.ResumeFailedCause;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DownloadListener2 implements DownloadListener {
    @Override // com.taptap.sdk.update.download.DownloadListener
    public void connectTrialStart(DownloadTask task, Map<String, List<String>> requestHeaderFields) {
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public void connectTrialEnd(DownloadTask task, int responseCode, Map<String, List<String>> responseHeaderFields) {
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public void downloadFromBeginning(DownloadTask task, BreakpointInfo info, ResumeFailedCause cause) {
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public void downloadFromBreakpoint(DownloadTask task, BreakpointInfo info) {
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public void connectStart(DownloadTask task, int blockIndex, Map<String, List<String>> requestHeaderFields) {
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public void connectEnd(DownloadTask task, int blockIndex, int responseCode, Map<String, List<String>> responseHeaderFields) {
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public void fetchStart(DownloadTask task, int blockIndex, long contentLength) {
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public void fetchProgress(DownloadTask task, int blockIndex, long increaseBytes) {
    }

    @Override // com.taptap.sdk.update.download.DownloadListener
    public void fetchEnd(DownloadTask task, int blockIndex, long contentLength) {
    }
}
