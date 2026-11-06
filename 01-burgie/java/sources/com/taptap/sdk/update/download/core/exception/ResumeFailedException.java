package com.taptap.sdk.update.download.core.exception;

import com.taptap.sdk.update.download.core.cause.ResumeFailedCause;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class ResumeFailedException extends IOException {
    private final ResumeFailedCause resumeFailedCause;

    public ResumeFailedException(ResumeFailedCause cause) {
        super("Resume failed because of " + cause);
        this.resumeFailedCause = cause;
    }

    public ResumeFailedCause getResumeFailedCause() {
        return this.resumeFailedCause;
    }
}
