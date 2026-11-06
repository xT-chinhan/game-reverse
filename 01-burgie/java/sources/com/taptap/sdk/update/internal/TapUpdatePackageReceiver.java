package com.taptap.sdk.update.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.extensions.SysExtKt;
import com.taptap.sdk.update.dialog.TapUpdateDialogManager;
import com.umeng.analytics.pro.d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapUpdatePackageReceiver.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/update/internal/TapUpdatePackageReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", d.R, "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapUpdatePackageReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Object objM534constructorimpl;
        if (context == null || intent == null || intent.getAction() == null || !Intrinsics.areEqual(intent.getAction(), "android.intent.action.PACKAGE_ADDED")) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            TapUpdatePackageReceiver tapUpdatePackageReceiver = this;
            Uri data = intent.getData();
            String pkgName = data != null ? data.getSchemeSpecificPart() : null;
            if (Intrinsics.areEqual(pkgName, SysExtKt.PACKAGE_NAME_CN) && SysExtKt.isTapInstalled()) {
                TapUpdateDialogManager.INSTANCE.installSuccess(context);
            }
            objM534constructorimpl = Result.m534constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM534constructorimpl = Result.m534constructorimpl(ResultKt.createFailure(th));
        }
        Throwable it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
        if (it != null) {
            TapLogger.e$default("package install check failed, cause: " + it.getMessage(), null, 2, null);
        }
    }
}
