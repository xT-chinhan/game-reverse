package com.taptap.sdk.kit.internal.extensions;

import com.taptap.sdk.common.network.throwable.ApiErr;
import com.taptap.sdk.common.network.throwable.TapNetworkException;
import com.taptap.sdk.initializer.api.model.RegionType;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.http.TapErrorConstants;
import com.taptap.sdk.kit.internal.http.TapHttpException;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetExt.kt */
/* JADX INFO: loaded from: classes3.dex */
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
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean isServerError(Throwable $this$isServerError) {
        Intrinsics.checkNotNullParameter($this$isServerError, "<this>");
        if ($this$isServerError instanceof TapHttpException.ServerError) {
            int httpCode = ((TapHttpException.ServerError) $this$isServerError).getHttpCode();
            if (500 <= httpCode && httpCode < 600) {
                return true;
            }
        }
        if ($this$isServerError instanceof TapHttpException.NoServerError) {
            int httpCode2 = ((TapHttpException.NoServerError) $this$isServerError).getHttpCode();
            if (500 <= httpCode2 && httpCode2 < 600) {
                return true;
            }
        }
        if ($this$isServerError instanceof TapNetworkException) {
            int code = ((TapNetworkException) $this$isServerError).getErr().getCode();
            if ((500 <= code && code < 600) || Intrinsics.areEqual(((TapNetworkException) $this$isServerError).getErr().getApiErr(), ApiErr.ERROR_SERVER_ERROR.INSTANCE)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isNoHostError(Throwable $this$isNoHostError) {
        Intrinsics.checkNotNullParameter($this$isNoHostError, "<this>");
        return $this$isNoHostError instanceof UnknownHostException;
    }

    public static final boolean isTokenExpired(Throwable $this$isTokenExpired) {
        Integer code;
        Intrinsics.checkNotNullParameter($this$isTokenExpired, "<this>");
        return (($this$isTokenExpired instanceof TapHttpException.ServerError) && Intrinsics.areEqual(((TapHttpException.ServerError) $this$isTokenExpired).getError().getError(), TapErrorConstants.ERROR_BUSINESS_ERROR) && (code = ((TapHttpException.ServerError) $this$isTokenExpired).getError().getCode()) != null && code.intValue() == 200000) || (($this$isTokenExpired instanceof TapNetworkException) && Intrinsics.areEqual(((TapNetworkException) $this$isTokenExpired).getErr().getApiErr(), ApiErr.ERROR_BUSINESS_ERROR.INSTANCE) && ((TapNetworkException) $this$isTokenExpired).getErr().getCode() == 200000);
    }

    public static final boolean isBusinessError(Throwable $this$isBusinessError) {
        Integer code;
        Intrinsics.checkNotNullParameter($this$isBusinessError, "<this>");
        return (($this$isBusinessError instanceof TapHttpException.ServerError) && Intrinsics.areEqual(((TapHttpException.ServerError) $this$isBusinessError).getError().getError(), TapErrorConstants.ERROR_BUSINESS_ERROR) && (code = ((TapHttpException.ServerError) $this$isBusinessError).getError().getCode()) != null && code.intValue() == 200001) || (($this$isBusinessError instanceof TapNetworkException) && Intrinsics.areEqual(((TapNetworkException) $this$isBusinessError).getErr().getApiErr(), ApiErr.ERROR_BUSINESS_ERROR.INSTANCE) && ((TapNetworkException) $this$isBusinessError).getErr().getCode() == 200001);
    }

    public static final String getBaseUrl() {
        if (TapTapKit.INSTANCE.isRND()) {
            return WhenMappings.$EnumSwitchMapping$0[TapTapKit.INSTANCE.getSdkOptions().getRegion().ordinal()] == 1 ? "https://tapsdk.api.xdrnd.cn" : "https://tapsdk.api.xdrnd.com";
        }
        return WhenMappings.$EnumSwitchMapping$0[TapTapKit.INSTANCE.getSdkOptions().getRegion().ordinal()] == 1 ? "https://tapsdk.tapapis.cn" : "https://tapsdk.tapapis.com";
    }
}
