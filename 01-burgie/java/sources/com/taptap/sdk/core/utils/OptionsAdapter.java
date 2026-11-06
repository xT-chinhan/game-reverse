package com.taptap.sdk.core.utils;

import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.initializer.TapTapSdkInitializer;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: OptionsAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¨\u0006\b"}, d2 = {"Lcom/taptap/sdk/core/utils/OptionsAdapter;", "", "()V", "adapt", "Lcom/taptap/sdk/initializer/TapTapSdkInitializer$Builder;", "options", "", "", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class OptionsAdapter {
    public static final OptionsAdapter INSTANCE = new OptionsAdapter();

    private OptionsAdapter() {
    }

    public final TapTapSdkInitializer.Builder adapt(TapTapSdkInitializer.Builder $this$adapt, List<String> options) {
        Intrinsics.checkNotNullParameter($this$adapt, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Iterable $this$fold$iv = CollectionsKt.filterNotNull(options);
        HashMap map = new HashMap();
        for (Object element$iv : $this$fold$iv) {
            String option = (String) element$iv;
            map.putAll(JSONUtils.INSTANCE.toMap(new JSONObject(option)));
        }
        Object obj = map.get("enableToast");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        $this$adapt.setEnableToast(bool != null ? bool.booleanValue() : true);
        Object obj2 = map.get("showSwitchAccount");
        Boolean bool2 = obj2 instanceof Boolean ? (Boolean) obj2 : null;
        $this$adapt.setShowSwitchAccount(bool2 != null ? bool2.booleanValue() : true);
        Object obj3 = map.get("useAgeRange");
        Boolean bool3 = obj3 instanceof Boolean ? (Boolean) obj3 : null;
        $this$adapt.setUseAgeRange(bool3 != null ? bool3.booleanValue() : true);
        Object obj4 = map.get("channel");
        $this$adapt.setChannel(obj4 instanceof String ? (String) obj4 : null);
        Object obj5 = map.get("autoIAPEventEnabled");
        Boolean bool4 = obj5 instanceof Boolean ? (Boolean) obj5 : null;
        $this$adapt.setAutoIAPEventEnabled(bool4 != null ? bool4.booleanValue() : false);
        Object obj6 = map.get("overrideBuiltInParameters");
        Boolean bool5 = obj6 instanceof Boolean ? (Boolean) obj6 : null;
        $this$adapt.setOverrideBuiltInParameters(bool5 != null ? bool5.booleanValue() : false);
        Object obj7 = map.get(Common.Predefined.PROPERTIES);
        String jsonStr = obj7 instanceof String ? (String) obj7 : null;
        $this$adapt.setProperties(jsonStr != null ? new JSONObject(jsonStr) : null);
        Object obj8 = map.get("disableAutoLogDeviceLogin");
        Boolean bool6 = obj8 instanceof Boolean ? (Boolean) obj8 : null;
        $this$adapt.disableAutoLogDeviceLogin(bool6 != null ? bool6.booleanValue() : false);
        Object obj9 = map.get("disableReflectionOAID");
        Boolean bool7 = obj9 instanceof Boolean ? (Boolean) obj9 : null;
        $this$adapt.disableReflectionOAID(bool7 != null ? bool7.booleanValue() : true);
        Object obj10 = map.get("oaidCert");
        $this$adapt.setOAIDCert(obj10 instanceof String ? (String) obj10 : null);
        Object obj11 = map.get("enableTapTapEvent");
        Boolean bool8 = obj11 instanceof Boolean ? (Boolean) obj11 : null;
        $this$adapt.setTapEventEnable(bool8 != null ? bool8.booleanValue() : true);
        return $this$adapt;
    }
}
