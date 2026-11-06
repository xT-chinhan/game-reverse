package com.taptap.sdk.login.impl.utils;

import android.app.Activity;
import android.content.Intent;
import com.byazt.ol.TTDownloadField;
import com.taptap.sdk.login.impl.data.model.Actions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClientLoginUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/login/impl/utils/ClientLoginUtils;", "", "()V", "isClientLogin", "", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "action", "Lcom/taptap/sdk/login/impl/data/model/Actions;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ClientLoginUtils {
    public static final ClientLoginUtils INSTANCE = new ClientLoginUtils();

    private ClientLoginUtils() {
    }

    public final boolean isClientLogin(Activity activity, Actions action) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(action, "action");
        Intent intent = new Intent(action.getAction());
        return intent.resolveActivity(activity.getPackageManager()) != null;
    }
}
