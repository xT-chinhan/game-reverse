package com.taptap.sdk.login.impl.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.taptap.sdk.kit.internal.utils.TapDensityUtilsKt;
import com.taptap.sdk.login.R;
import com.umeng.analytics.pro.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoginToastHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/taptap/sdk/login/impl/utils/LoginToastHelper;", "", "()V", "mainHandler", "Landroid/os/Handler;", "showToast", "", d.R, "Landroid/content/Context;", "message", "", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LoginToastHelper {
    public static final LoginToastHelper INSTANCE = new LoginToastHelper();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    private LoginToastHelper() {
    }

    public final void showToast(final Context context, final String message) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(message, "message");
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            mainHandler.post(new Runnable() { // from class: com.taptap.sdk.login.impl.utils.LoginToastHelper$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LoginToastHelper.showToast$lambda$0(context, message);
                }
            });
            return;
        }
        Toast toast = new Toast(context);
        View toastView = LayoutInflater.from(context).inflate(R.layout.toast_layout, (ViewGroup) null);
        ((TextView) toastView.findViewById(R.id.tv_tap_toast)).setText(message);
        toast.setView(toastView);
        toast.setDuration(0);
        toast.setGravity(49, 0, TapDensityUtilsKt.getDip(50));
        toast.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showToast$lambda$0(Context context, String message) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(message, "$message");
        INSTANCE.showToast(context, message);
    }
}
