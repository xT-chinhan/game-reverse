package com.taptap.sdk.update.download.core.download;

import com.taptap.sdk.update.download.core.Util;
import com.taptap.sdk.update.download.core.cause.ResumeFailedCause;
import com.taptap.sdk.update.download.core.exception.FileBusyAfterRunException;
import com.taptap.sdk.update.download.core.exception.InterruptException;
import com.taptap.sdk.update.download.core.exception.PreAllocateException;
import com.taptap.sdk.update.download.core.exception.ResumeFailedException;
import com.taptap.sdk.update.download.core.exception.ServerCanceledException;
import com.taptap.sdk.update.download.core.file.MultiPointOutputStream;
import java.io.IOException;
import java.net.SocketException;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadCache {
    private volatile boolean fileBusyAfterRun;
    private final MultiPointOutputStream outputStream;
    private volatile boolean preAllocateFailed;
    private volatile boolean preconditionFailed;
    private volatile IOException realCause;
    private String redirectLocation;
    private volatile boolean serverCanceled;
    private volatile boolean unknownError;
    private volatile boolean userCanceled;

    DownloadCache(MultiPointOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    private DownloadCache() {
        this.outputStream = null;
    }

    MultiPointOutputStream getOutputStream() {
        MultiPointOutputStream multiPointOutputStream = this.outputStream;
        if (multiPointOutputStream == null) {
            throw new IllegalArgumentException();
        }
        return multiPointOutputStream;
    }

    void setRedirectLocation(String redirectLocation) {
        this.redirectLocation = redirectLocation;
    }

    String getRedirectLocation() {
        return this.redirectLocation;
    }

    boolean isPreconditionFailed() {
        return this.preconditionFailed;
    }

    public boolean isUserCanceled() {
        return this.userCanceled;
    }

    boolean isServerCanceled() {
        return this.serverCanceled;
    }

    boolean isUnknownError() {
        return this.unknownError;
    }

    boolean isFileBusyAfterRun() {
        return this.fileBusyAfterRun;
    }

    public boolean isPreAllocateFailed() {
        return this.preAllocateFailed;
    }

    IOException getRealCause() {
        return this.realCause;
    }

    ResumeFailedCause getResumeFailedCause() {
        return ((ResumeFailedException) this.realCause).getResumeFailedCause();
    }

    public boolean isInterrupt() {
        return this.preconditionFailed || this.userCanceled || this.serverCanceled || this.unknownError || this.fileBusyAfterRun || this.preAllocateFailed;
    }

    public void setPreconditionFailed(IOException realCause) {
        this.preconditionFailed = true;
        this.realCause = realCause;
    }

    void setUserCanceled() {
        this.userCanceled = true;
    }

    public void setFileBusyAfterRun() {
        this.fileBusyAfterRun = true;
    }

    public void setServerCanceled(IOException realCause) {
        this.serverCanceled = true;
        this.realCause = realCause;
    }

    public void setUnknownError(IOException realCause) {
        this.unknownError = true;
        this.realCause = realCause;
    }

    public void setPreAllocateFailed(IOException realCause) {
        this.preAllocateFailed = true;
        this.realCause = realCause;
    }

    public void catchException(IOException e) {
        if (isUserCanceled()) {
            return;
        }
        if (e instanceof ResumeFailedException) {
            setPreconditionFailed(e);
            return;
        }
        if (e instanceof ServerCanceledException) {
            setServerCanceled(e);
            return;
        }
        if (e == FileBusyAfterRunException.SIGNAL) {
            setFileBusyAfterRun();
            return;
        }
        if (e instanceof PreAllocateException) {
            setPreAllocateFailed(e);
        } else if (e != InterruptException.SIGNAL) {
            setUnknownError(e);
            if (!(e instanceof SocketException)) {
                Util.d("DownloadCache", "catch unknown error " + e);
            }
        }
    }

    static class PreError extends DownloadCache {
        PreError(IOException realCause) {
            super(null);
            setUnknownError(realCause);
        }
    }
}
