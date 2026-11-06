package com.taptap.sdk.update.download.core.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkPolicyException extends IOException {
    public NetworkPolicyException() {
        super("Only allows downloading this task on the wifi network type!");
    }
}
