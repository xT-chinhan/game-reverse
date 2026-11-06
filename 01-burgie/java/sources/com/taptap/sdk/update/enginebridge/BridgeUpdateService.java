package com.taptap.sdk.update.enginebridge;

import android.app.Activity;
import com.byazt.ol.TTDownloadField;
import com.taptap.sdk.kit.internal.enginebridge.EngineBridgeCallback;
import com.taptap.sdk.kit.internal.enginebridge.IEngineBridgeService;
import com.taptap.sdk.kit.internal.enginebridge.annotation.EngineBridgeMethod;
import com.taptap.sdk.kit.internal.enginebridge.annotation.EngineBridgeService;
import kotlin.Metadata;

/* JADX INFO: compiled from: BridgeUpdateService.kt */
/* JADX INFO: loaded from: classes3.dex */
@EngineBridgeService("BridgeUpdateService")
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/update/enginebridge/BridgeUpdateService;", "Lcom/taptap/sdk/kit/internal/enginebridge/IEngineBridgeService;", "checkForceUpdate", "", "updateGame", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "callback", "Lcom/taptap/sdk/kit/internal/enginebridge/EngineBridgeCallback;", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface BridgeUpdateService extends IEngineBridgeService {
    @EngineBridgeMethod("checkForceUpdate")
    void checkForceUpdate();

    @EngineBridgeMethod("updateGame")
    void updateGame(Activity activity, EngineBridgeCallback callback);
}
