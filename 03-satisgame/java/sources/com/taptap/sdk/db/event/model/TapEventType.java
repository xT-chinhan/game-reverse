package com.taptap.sdk.db.event.model;

import kotlin.Metadata;

/* JADX INFO: compiled from: TapEventType.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/taptap/sdk/db/event/model/TapEventType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "TRACK", "DEVICE_INITIALISE", "DEVICE_UPDATE", "DEVICE_ADD", "USER_INITIALISE", "USER_UPDATE", "USER_ADD", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum TapEventType {
    TRACK("track"),
    DEVICE_INITIALISE("initialise"),
    DEVICE_UPDATE("update"),
    DEVICE_ADD("add"),
    USER_INITIALISE("initialise"),
    USER_UPDATE("update"),
    USER_ADD("add");

    private final String type;

    TapEventType(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }
}
