package com.tapsdk.tapad.group.adapter;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface AdapterAdSession {
    void destroy();

    default Map<String, Object> getMetadata() {
        return Collections.EMPTY_MAP;
    }

    default long getPrice() {
        return 0L;
    }

    default boolean isValid() {
        return true;
    }

    default void sendLoss(long j, String str, String str2) {
    }

    default void sendWin(long j, long j2, String str) {
    }

    void setEventSink(AdapterAdEventSink adapterAdEventSink);
}
