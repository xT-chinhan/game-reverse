package com.taptap.sdk.kit.internal;

import com.taptap.sdk.initializer.api.model.RegionType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: TapSDKHost.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/taptap/sdk/kit/internal/TapSDKHost;", "", "()V", "getApiHost", "", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapSDKHost {
    public static final TapSDKHost INSTANCE = new TapSDKHost();

    private TapSDKHost() {
    }

    public final String getApiHost() {
        boolean isRND = TapTapKit.INSTANCE.isRND();
        RegionType region = TapTapKit.INSTANCE.getRegionType$tap_common_release();
        if (isRND) {
            return region == RegionType.GLOBAL ? "tapsdk.api.xdrnd.com" : "tapsdk.api.xdrnd.cn";
        }
        if (isRND) {
            throw new NoWhenBranchMatchedException();
        }
        return region == RegionType.GLOBAL ? "tapsdk.tapapis.com" : "tapsdk.tapapis.cn";
    }
}
