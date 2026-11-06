package com.taptap.sdk.rep.enginebridge;

import com.taptap.sdk.kit.internal.enginebridge.EngineBridgeCallback;
import com.taptap.sdk.kit.internal.enginebridge.IEngineBridgeService;
import com.taptap.sdk.kit.internal.enginebridge.annotation.EngineBridgeMethod;
import com.taptap.sdk.kit.internal.enginebridge.annotation.EngineBridgeParams;
import com.taptap.sdk.kit.internal.enginebridge.annotation.EngineBridgeService;
import kotlin.Metadata;

/* JADX INFO: compiled from: BridgeRepService.kt */
/* JADX INFO: loaded from: classes3.dex */
@EngineBridgeService("BridgeRepService")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Lcom/taptap/sdk/rep/enginebridge/BridgeRepService;", "Lcom/taptap/sdk/kit/internal/enginebridge/IEngineBridgeService;", "open", "", "openUrl", "", "callback", "Lcom/taptap/sdk/kit/internal/enginebridge/EngineBridgeCallback;", "tap-rep_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface BridgeRepService extends IEngineBridgeService {
    @EngineBridgeMethod("open")
    void open(@EngineBridgeParams("openUrl") String openUrl, EngineBridgeCallback callback);
}
