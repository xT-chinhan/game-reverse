package com.taptap.sdk.initializer.api;

import android.content.Context;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import kotlin.Metadata;

/* JADX INFO: compiled from: ModuleInitializer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/taptap/sdk/initializer/api/ModuleInitializer;", "", "initialize", "", "context", "Landroid/content/Context;", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "tap-initializer-api_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface ModuleInitializer {
    void initialize(Context context, TapTapSdkOptions options);
}
