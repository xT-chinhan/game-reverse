package com.kwad.components.core.proxy.launchdialog;

import androidx.lifecycle.Lifecycle;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private final long WA = System.currentTimeMillis();
    private final Lifecycle.Event Wz;

    public d(Lifecycle.Event event) {
        this.Wz = event;
    }

    public final String toString() {
        return "LifecycleStamp{mEvent=" + this.Wz + ", mEventTimestamp=" + this.WA + AbstractJsonLexerKt.END_OBJ;
    }

    public final Lifecycle.Event sa() {
        return this.Wz;
    }

    public final long sb() {
        return this.WA;
    }
}
