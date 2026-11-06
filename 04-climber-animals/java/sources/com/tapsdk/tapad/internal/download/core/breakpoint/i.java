package com.tapsdk.tapad.internal.download.core.breakpoint;

import com.tapsdk.tapad.internal.download.core.cause.EndCause;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface i extends g {
    void a(int i, EndCause endCause, Exception exc);

    void a(c cVar, int i, long j) throws IOException;

    void b(int i);

    boolean c(int i);

    boolean e(int i);

    c g(int i);
}
