package com.taptap.sdk.kit.internal.enginebridge;

import com.taptap.sdk.kit.internal.p001const.TrackAction;
import kotlin.Metadata;

/* JADX INFO: compiled from: EngineBridgeResult.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0007\u001a\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"RESULT_ERROR", "", "RESULT_SUCCESS", "generateBridgeFailureResult", "Lcom/taptap/sdk/kit/internal/enginebridge/EngineBridgeResult;", "T", "content", "(Ljava/lang/Object;)Lcom/taptap/sdk/kit/internal/enginebridge/EngineBridgeResult;", "generateBridgeSuccessResult", "tap-common_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class EngineBridgeResultKt {
    public static final int RESULT_ERROR = -1;
    public static final int RESULT_SUCCESS = 0;

    public static final <T> EngineBridgeResult<T> generateBridgeSuccessResult(T t) {
        return new EngineBridgeResult<>(0, TrackAction.SUCCESS, t);
    }

    public static final <T> EngineBridgeResult<T> generateBridgeFailureResult(T t) {
        return new EngineBridgeResult<>(-1, TrackAction.FAIL, t);
    }
}
