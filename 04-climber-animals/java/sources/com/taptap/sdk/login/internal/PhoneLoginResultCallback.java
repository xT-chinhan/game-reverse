package com.taptap.sdk.login.internal;

import android.content.Context;
import com.umeng.analytics.pro.g;
import kotlin.Metadata;

/* JADX INFO: compiled from: PhoneLoginResultCallback.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J9\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bH&¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/taptap/sdk/login/internal/PhoneLoginResultCallback;", "", "cancelLogin", "", g.X, "Landroid/content/Context;", "continueWebLogin", "token", "", "preferredLoginType", "scopes", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface PhoneLoginResultCallback {
    void cancelLogin(Context context);

    void continueWebLogin(Context context, String token, String preferredLoginType, String[] scopes);
}
