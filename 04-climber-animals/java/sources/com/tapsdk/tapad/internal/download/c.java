package com.tapsdk.tapad.internal.download;

import com.tapsdk.tapad.internal.download.core.cause.EndCause;
import com.tapsdk.tapad.internal.download.core.cause.ResumeFailedCause;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface c {
    void a(f fVar);

    void a(f fVar, int i, int i2, Map<String, List<String>> map);

    void a(f fVar, int i, long j);

    void a(f fVar, int i, Map<String, List<String>> map);

    void a(f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar);

    void a(f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, ResumeFailedCause resumeFailedCause);

    void a(f fVar, EndCause endCause, Exception exc);

    void a(f fVar, Map<String, List<String>> map);

    void b(f fVar, int i, long j);

    void b(f fVar, int i, Map<String, List<String>> map);

    void c(f fVar, int i, long j);
}
