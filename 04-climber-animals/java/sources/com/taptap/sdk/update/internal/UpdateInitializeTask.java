package com.taptap.sdk.update.internal;

import android.content.Context;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import com.taptap.sdk.startup.task.InitializeTask;
import com.umeng.analytics.pro.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: compiled from: UpdateInitializeTask.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/update/internal/UpdateInitializeTask;", "Lcom/taptap/sdk/startup/task/InitializeTask;", "()V", "execute", "", g.X, "Landroid/content/Context;", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UpdateInitializeTask implements InitializeTask {
    @Override // com.taptap.sdk.startup.task.InitializeTask
    public void execute(Context context, TapTapSdkOptions options) throws JSONException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(options, "options");
        TapUpdateInternal.INSTANCE.init(options);
    }
}
