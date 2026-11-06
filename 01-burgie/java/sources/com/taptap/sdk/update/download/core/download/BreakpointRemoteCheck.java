package com.taptap.sdk.update.download.core.download;

import com.taptap.sdk.update.download.DownloadTask;
import com.taptap.sdk.update.download.OkDownload;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointInfo;
import com.taptap.sdk.update.download.core.cause.ResumeFailedCause;
import com.taptap.sdk.update.download.core.exception.FileBusyAfterRunException;
import com.taptap.sdk.update.download.core.exception.ServerCanceledException;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class BreakpointRemoteCheck {
    private boolean acceptRange;
    ResumeFailedCause failedCause;
    private final BreakpointInfo info;
    private long instanceLength;
    private boolean resumable;
    private final DownloadTask task;

    public BreakpointRemoteCheck(DownloadTask task, BreakpointInfo info) {
        this.task = task;
        this.info = info;
    }

    public String toString() {
        return "acceptRange[" + this.acceptRange + "] resumable[" + this.resumable + "] failedCause[" + this.failedCause + "] instanceLength[" + this.instanceLength + "] " + super.toString();
    }

    public ResumeFailedCause getCause() {
        return this.failedCause;
    }

    public ResumeFailedCause getCauseOrThrow() {
        ResumeFailedCause resumeFailedCause = this.failedCause;
        if (resumeFailedCause == null) {
            throw new IllegalStateException("No cause find with resumable: " + this.resumable);
        }
        return resumeFailedCause;
    }

    public boolean isResumable() {
        return this.resumable;
    }

    public boolean isAcceptRange() {
        return this.acceptRange;
    }

    public long getInstanceLength() {
        return this.instanceLength;
    }

    public void check() throws IOException {
        DownloadStrategy downloadStrategy = OkDownload.with().downloadStrategy();
        ConnectTrial connectTrial = createConnectTrial();
        connectTrial.executeTrial();
        boolean isAcceptRange = connectTrial.isAcceptRange();
        boolean isChunked = connectTrial.isChunked();
        long instanceLength = connectTrial.getInstanceLength();
        String responseEtag = connectTrial.getResponseEtag();
        String responseFilename = connectTrial.getResponseFilename();
        int responseCode = connectTrial.getResponseCode();
        downloadStrategy.validFilenameFromResponse(responseFilename, this.task, this.info);
        this.info.setChunked(isChunked);
        this.info.setEtag(responseEtag);
        if (!OkDownload.with().downloadDispatcher().isFileConflictAfterRun(this.task)) {
            ResumeFailedCause resumeFailedCause = downloadStrategy.getPreconditionFailedCause(responseCode, this.info.getTotalOffset() != 0, this.info, responseEtag);
            boolean z = resumeFailedCause == null;
            this.resumable = z;
            this.failedCause = resumeFailedCause;
            this.instanceLength = instanceLength;
            this.acceptRange = isAcceptRange;
            if (isTrialSpecialPass(responseCode, instanceLength, z)) {
                return;
            }
            if (downloadStrategy.isServerCanceled(responseCode, this.info.getTotalOffset() != 0)) {
                throw new ServerCanceledException(responseCode, this.info.getTotalOffset());
            }
            return;
        }
        throw FileBusyAfterRunException.SIGNAL;
    }

    boolean isTrialSpecialPass(int responseCode, long instanceLength, boolean isResumable) {
        if (responseCode == 416 && instanceLength >= 0 && isResumable) {
            return true;
        }
        return false;
    }

    ConnectTrial createConnectTrial() {
        return new ConnectTrial(this.task, this.info);
    }
}
