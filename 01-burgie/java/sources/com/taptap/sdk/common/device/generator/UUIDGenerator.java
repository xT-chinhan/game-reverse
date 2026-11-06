package com.taptap.sdk.common.device.generator;

import com.taptap.sdk.kit.internal.TapLogger;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UUIDGenerator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/common/device/generator/UUIDGenerator;", "", "()V", "generate", "", "Companion", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UUIDGenerator {
    private static final String TAG = "UUIDGenerator";

    public final String generate() {
        String deviceId = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(deviceId, "randomUUID().toString()");
        TapLogger.logd(TAG, "Generated device ID from UUID: " + deviceId);
        return deviceId;
    }
}
