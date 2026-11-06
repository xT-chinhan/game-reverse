package com.taptap.sdk.db.event.service;

import androidx.core.app.NotificationCompat;
import com.taptap.sdk.core.DBService;
import com.taptap.sdk.core.TapTapPurchasedEvent;
import com.taptap.sdk.db.event.TapPredefinedEvents;
import com.taptap.sdk.db.event.utils.TapEventLogger;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: compiled from: DBServiceImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/taptap/sdk/db/event/service/DBServiceImpl;", "Lcom/taptap/sdk/core/DBService;", "()V", "flush", "", "setAutoEventEnable", "enabled", "", "trackDeviceLogin", "option", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "trackPaymentPurchase", NotificationCompat.CATEGORY_EVENT, "Lcom/taptap/sdk/core/TapTapPurchasedEvent;", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DBServiceImpl implements DBService {
    @Override // com.taptap.sdk.core.DBService
    public void trackPaymentPurchase(TapTapPurchasedEvent event) throws JSONException {
        if (event != null) {
            TapPredefinedEvents.INSTANCE.trackPaymentPurchase(event);
        }
    }

    @Override // com.taptap.sdk.core.DBService
    public void setAutoEventEnable(boolean enabled) {
        TapEventLogger.INSTANCE.setAutoEventEnable$tap_db_release(enabled);
    }

    @Override // com.taptap.sdk.core.DBService
    public void trackDeviceLogin(TapTapSdkOptions option) {
        Intrinsics.checkNotNullParameter(option, "option");
        TapPredefinedEvents.trackDeviceLogin(option.getProperties());
    }

    @Override // com.taptap.sdk.core.DBService
    public void flush() {
        TapEventLogger.INSTANCE.flush$tap_db_release();
    }
}
