package com.taptap.sdk.login.internal.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.taptap.sdk.kit.internal.utils.TapDensityUtilsKt;
import com.taptap.sdk.login.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoginToastHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/login/internal/ui/LoginToastHelper;", "", "()V", "showToast", "", "context", "Landroid/content/Context;", "message", "", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LoginToastHelper {
    public static final LoginToastHelper INSTANCE = new LoginToastHelper();

    private LoginToastHelper() {
    }

    public final void showToast(Context context, String message) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(message, "message");
        Toast toast = new Toast(context);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.toast_layout, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.tv_tap_toast)).setText(message);
        toast.setView(viewInflate);
        toast.setDuration(0);
        toast.setGravity(49, 0, TapDensityUtilsKt.getDip(50));
        toast.show();
    }
}
