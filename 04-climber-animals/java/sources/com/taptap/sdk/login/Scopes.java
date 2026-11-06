package com.taptap.sdk.login;

import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: compiled from: Scopes.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/taptap/sdk/login/Scopes;", "", "()V", "SCOPE_BASIC_INFO", "", "SCOPE_EMAIL", "SCOPE_PROFILE", "getSCOPE_PROFILE$annotations", "SCOPE_PUBLIC_PROFILE", "SCOPE_USER_FRIENDS", "tap-login-api_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Scopes {
    public static final Scopes INSTANCE = new Scopes();
    public static final String SCOPE_BASIC_INFO = "basic_info";
    public static final String SCOPE_EMAIL = "email";
    public static final String SCOPE_PROFILE = "public_profile";
    public static final String SCOPE_PUBLIC_PROFILE = "public_profile";
    public static final String SCOPE_USER_FRIENDS = "user_friends";

    @Deprecated(message = "use SCOPE_PUBLIC_PROFILE instead")
    public static /* synthetic */ void getSCOPE_PROFILE$annotations() {
    }

    private Scopes() {
    }
}
