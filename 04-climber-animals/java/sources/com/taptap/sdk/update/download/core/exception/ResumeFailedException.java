package com.taptap.sdk.update.download.core.exception;

import com.taptap.sdk.update.download.core.cause.ResumeFailedCause;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class ResumeFailedException extends IOException {
    private final ResumeFailedCause resumeFailedCause;

    public ResumeFailedException(ResumeFailedCause resumeFailedCause) {
        super("Resume failed because of " + resumeFailedCause);
        this.resumeFailedCause = resumeFailedCause;
    }

    public ResumeFailedCause getResumeFailedCause() {
        return this.resumeFailedCause;
    }
}
