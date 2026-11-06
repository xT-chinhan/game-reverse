package com.tapsdk.tapad.internal.download;

import com.tapsdk.tapad.internal.download.core.cause.EndCause;
import com.tapsdk.tapad.internal.download.core.cause.ResumeFailedCause;

/* JADX INFO: loaded from: classes3.dex */
public interface d {
    void a(f fVar);

    void a(f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar);

    void a(f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, ResumeFailedCause resumeFailedCause);

    void a(f fVar, EndCause endCause, Exception exc);
}
