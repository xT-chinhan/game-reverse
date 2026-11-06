package com.taptap.sdk.login.internal.handlers.client;

import com.taptap.sdk.initializer.api.model.RegionType;
import com.taptap.sdk.login.internal.bean.LoginRequest;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IntentHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/taptap/sdk/login/internal/handlers/client/IntentHelper;", "", "()V", "getAction", "", "request", "Lcom/taptap/sdk/login/internal/bean/LoginRequest;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class IntentHelper {
    public static final IntentHelper INSTANCE = new IntentHelper();

    /* JADX INFO: compiled from: IntentHelper.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RegionType.values().length];
            try {
                iArr[RegionType.CN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RegionType.GLOBAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private IntentHelper() {
    }

    public final String getAction(LoginRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        int i = WhenMappings.$EnumSwitchMapping$0[request.getRegionType().ordinal()];
        if (i == 1) {
            return "com.taptap.sdk.action";
        }
        if (i == 2) {
            return "com.taptap.global.sdk.action";
        }
        throw new NoWhenBranchMatchedException();
    }
}
