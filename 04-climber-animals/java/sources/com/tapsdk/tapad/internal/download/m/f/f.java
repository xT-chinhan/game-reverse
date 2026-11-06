package com.tapsdk.tapad.internal.download.m.f;

import com.tapsdk.tapad.internal.download.core.cause.ResumeFailedCause;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class f extends IOException {
    private final ResumeFailedCause a;

    public f(ResumeFailedCause resumeFailedCause) {
        super("Resume failed because of " + resumeFailedCause);
        this.a = resumeFailedCause;
    }

    public ResumeFailedCause a() {
        return this.a;
    }
}
