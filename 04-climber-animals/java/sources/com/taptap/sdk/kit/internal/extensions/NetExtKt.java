package com.taptap.sdk.kit.internal.extensions;

import com.taptap.sdk.initializer.api.model.RegionType;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.http.TapErrorConstants;
import com.taptap.sdk.kit.internal.http.TapHttpException;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetExt.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0002\b\u0004\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0006\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0007\u001a\u00020\u0003*\u00020\u0004¨\u0006\b"}, d2 = {"getBaseUrl", "", "isBusinessError", "", "", "isNoHostError", "isServerError", "isTokenExpired", "tap-common_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class NetExtKt {

    /* JADX INFO: compiled from: NetExt.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RegionType.values().length];
            try {
                iArr[RegionType.CN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean isServerError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        if (th instanceof TapHttpException.ServerError) {
            int httpCode = ((TapHttpException.ServerError) th).getHttpCode();
            if (500 <= httpCode && httpCode < 600) {
                return true;
            }
        }
        if (th instanceof TapHttpException.NoServerError) {
            int httpCode2 = ((TapHttpException.NoServerError) th).getHttpCode();
            if (500 <= httpCode2 && httpCode2 < 600) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isNoHostError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        return th instanceof UnknownHostException;
    }

    public static final boolean isTokenExpired(Throwable th) {
        Integer code;
        Intrinsics.checkNotNullParameter(th, "<this>");
        if (th instanceof TapHttpException.ServerError) {
            TapHttpException.ServerError serverError = (TapHttpException.ServerError) th;
            if (Intrinsics.areEqual(serverError.getError().getError(), TapErrorConstants.ERROR_BUSINESS_ERROR) && (code = serverError.getError().getCode()) != null && code.intValue() == 200000) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isBusinessError(Throwable th) {
        Integer code;
        Intrinsics.checkNotNullParameter(th, "<this>");
        if (th instanceof TapHttpException.ServerError) {
            TapHttpException.ServerError serverError = (TapHttpException.ServerError) th;
            if (Intrinsics.areEqual(serverError.getError().getError(), TapErrorConstants.ERROR_BUSINESS_ERROR) && (code = serverError.getError().getCode()) != null && code.intValue() == 200001) {
                return true;
            }
        }
        return false;
    }

    public static final String getBaseUrl() {
        if (TapTapKit.INSTANCE.isRND()) {
            return WhenMappings.$EnumSwitchMapping$0[TapTapKit.INSTANCE.getSdkOptions().getRegion().ordinal()] == 1 ? "https://tapsdk.api.xdrnd.cn" : "https://tapsdk.api.xdrnd.com";
        }
        return WhenMappings.$EnumSwitchMapping$0[TapTapKit.INSTANCE.getSdkOptions().getRegion().ordinal()] == 1 ? "https://tapsdk.tapapis.cn" : "https://tapsdk.tapapis.com";
    }
}
