package com.taptap.sdk.openlog.di;

import android.content.Context;
import com.taptap.sdk.initializer.api.ModuleInitializer;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import com.taptap.sdk.openlog.TapTapOpenlogSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OpenLogInitializer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/taptap/sdk/openlog/di/OpenLogInitializer;", "Lcom/taptap/sdk/initializer/api/ModuleInitializer;", "delegate", "Lcom/taptap/sdk/openlog/TapTapOpenlogSdk;", "(Lcom/taptap/sdk/openlog/TapTapOpenlogSdk;)V", "initialize", "", "context", "Landroid/content/Context;", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "tap-openlog_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class OpenLogInitializer implements ModuleInitializer {
    private final TapTapOpenlogSdk delegate;

    public OpenLogInitializer(TapTapOpenlogSdk delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // com.taptap.sdk.initializer.api.ModuleInitializer
    public void initialize(Context context, TapTapSdkOptions options) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(options, "options");
        this.delegate.initialize(context, options);
    }
}
