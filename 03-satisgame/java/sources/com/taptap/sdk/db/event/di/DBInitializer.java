package com.taptap.sdk.db.event.di;

import android.content.Context;
import com.taptap.sdk.db.event.utils.TapEventLogger;
import com.taptap.sdk.initializer.api.ModuleInitializer;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DBInitializer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/db/event/di/DBInitializer;", "Lcom/taptap/sdk/initializer/api/ModuleInitializer;", "()V", "initialize", "", "context", "Landroid/content/Context;", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DBInitializer implements ModuleInitializer {
    @Override // com.taptap.sdk.initializer.api.ModuleInitializer
    public void initialize(Context context, TapTapSdkOptions options) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(options, "options");
        TapEventLogger.initialize$tap_db_release(context, options);
    }
}
