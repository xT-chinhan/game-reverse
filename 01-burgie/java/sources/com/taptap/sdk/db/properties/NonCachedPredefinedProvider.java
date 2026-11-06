package com.taptap.sdk.db.properties;

import com.taptap.sdk.db.EventContext;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import com.taptap.sdk.kit.internal.identifier.TapIdentifierUtil;
import com.taptap.sdk.kit.internal.utils.DeviceUtils;
import com.taptap.sdk.kit.internal.utils.NetworkUtil;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NonCachedPredefinedProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/taptap/sdk/db/properties/NonCachedPredefinedProvider;", "", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "(Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;)V", "provide", "", "", d.R, "Lcom/taptap/sdk/db/EventContext;", "isAutomatically", "", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class NonCachedPredefinedProvider {
    private final TapTapSdkOptions options;

    public NonCachedPredefinedProvider(TapTapSdkOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.options = options;
    }

    public final Map<String, Object> provide(EventContext context, boolean isAutomatically) {
        Intrinsics.checkNotNullParameter(context, "context");
        HashMap properties = new HashMap();
        Pair pair = TuplesKt.to("network_type", NetworkUtil.getConnectedType(this.options.getContext()));
        properties.put(pair.getFirst(), pair.getSecond());
        Pair pair2 = TuplesKt.to(Common.Predefined.SUB_MOBILE_TYPE, NetworkUtil.getNetworkType(this.options.getContext()));
        properties.put(pair2.getFirst(), pair2.getSecond());
        int[] size = DeviceUtils.getDeviceSize(this.options.getContext());
        Pair pair3 = TuplesKt.to("width", Integer.valueOf(size[0]));
        properties.put(pair3.getFirst(), pair3.getSecond());
        Pair pair4 = TuplesKt.to("height", Integer.valueOf(size[1]));
        properties.put(pair4.getFirst(), pair4.getSecond());
        Pair pair5 = TuplesKt.to(Common.Predefined.SUB_ROM, Long.valueOf(DeviceUtils.getRemainingRomSize()));
        properties.put(pair5.getFirst(), pair5.getSecond());
        Pair pair6 = TuplesKt.to(Common.Predefined.SUB_RAM, Long.valueOf(DeviceUtils.getRemainingRamSize(this.options.getContext())));
        properties.put(pair6.getFirst(), pair6.getSecond());
        Pair pair7 = TuplesKt.to(Common.Predefined.SUB_LANG_SYSTEM, Locale.getDefault().toLanguageTag());
        properties.put(pair7.getFirst(), pair7.getSecond());
        Pair pair8 = TuplesKt.to("channel", this.options.getChannel());
        properties.put(pair8.getFirst(), pair8.getSecond());
        Pair pair9 = TuplesKt.to(Common.Predefined.OPEN_ID, TapIdentifierUtil.INSTANCE.getOpenId());
        properties.put(pair9.getFirst(), pair9.getSecond());
        Pair pair10 = TuplesKt.to(Common.Predefined.SUB_T_LOG_ID, UUID.randomUUID().toString());
        properties.put(pair10.getFirst(), pair10.getSecond());
        Pair pair11 = TuplesKt.to(Common.Predefined.SUB_SESSION_UUID, context.getSessionId());
        properties.put(pair11.getFirst(), pair11.getSecond());
        Pair pair12 = TuplesKt.to("timestamp", Long.valueOf(System.currentTimeMillis()));
        properties.put(pair12.getFirst(), pair12.getSecond());
        Pair pair13 = TuplesKt.to(Common.Predefined.SUB_EVENT_INDEX, Long.valueOf(context.getEventIndex().incrementAndGet()));
        properties.put(pair13.getFirst(), pair13.getSecond());
        if (isAutomatically) {
            Pair pair14 = TuplesKt.to(Common.Predefined.SUB_IS_AUTOMATICALLY_LOG, true);
            properties.put(pair14.getFirst(), pair14.getSecond());
        }
        return properties;
    }
}
