package com.taptap.sdk.login.impl.utils;

import com.taptap.sdk.initializer.api.model.RegionType;
import kotlin.Metadata;

/* JADX INFO: compiled from: WebViewUriProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/login/impl/utils/WebViewUriProvider;", "", "()V", "provide", "", "isRND", "", "regionType", "Lcom/taptap/sdk/initializer/api/model/RegionType;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class WebViewUriProvider {
    public static final WebViewUriProvider INSTANCE = new WebViewUriProvider();

    /* JADX INFO: compiled from: WebViewUriProvider.kt */
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

    private WebViewUriProvider() {
    }

    public final String provide(boolean isRND, RegionType regionType) {
        if (isRND) {
            return (regionType != null ? WhenMappings.$EnumSwitchMapping$0[regionType.ordinal()] : -1) == 1 ? "https://accounts.xdrnd.cn/authorize" : "https://accounts-io.xdrnd.com/authorize";
        }
        return (regionType != null ? WhenMappings.$EnumSwitchMapping$0[regionType.ordinal()] : -1) == 1 ? "https://accounts.taptap.cn/authorize" : "https://www.taptapauth.com/authorize";
    }
}
