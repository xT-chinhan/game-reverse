package com.taptap.sdk.core;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;

/* JADX INFO: compiled from: DBService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&¨\u0006\r"}, d2 = {"Lcom/taptap/sdk/core/DBService;", "", "flush", "", "setAutoEventEnable", "enabled", "", "trackDeviceLogin", "option", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "trackPaymentPurchase", NotificationCompat.CATEGORY_EVENT, "Lcom/taptap/sdk/core/TapTapPurchasedEvent;", "tap-db-api_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface DBService {
    void flush();

    void setAutoEventEnable(boolean enabled);

    void trackDeviceLogin(com.taptap.sdk.initializer.api.option.TapTapSdkOptions option);

    void trackPaymentPurchase(TapTapPurchasedEvent event);
}
