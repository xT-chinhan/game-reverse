package com.taptap.sdk.common.device;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DeviceIdValidator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/taptap/sdk/common/device/DeviceIdValidator;", "", "()V", "isValid", "", "deviceId", "", "toDebugString", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DeviceIdValidator {
    public static final DeviceIdValidator INSTANCE = new DeviceIdValidator();

    private DeviceIdValidator() {
    }

    public final boolean isValid(String deviceId) {
        String str = deviceId;
        if (str == null || StringsKt.isBlank(str)) {
            return false;
        }
        for (int i = 0; i < deviceId.length(); i++) {
            char cCharAt = deviceId.charAt(i);
            if (cCharAt < ' ' || cCharAt == 127 || cCharAt == 65533) {
                return false;
            }
        }
        return true;
    }

    public final String toDebugString(String deviceId) {
        String strValueOf;
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        String $this$map$iv = deviceId;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length());
        for (int i = 0; i < $this$map$iv.length(); i++) {
            char item$iv$iv = $this$map$iv.charAt(i);
            if (item$iv$iv < ' ') {
                strValueOf = String.format("\\u%04X", Arrays.copyOf(new Object[]{Integer.valueOf(item$iv$iv)}, 1));
                Intrinsics.checkNotNullExpressionValue(strValueOf, "format(this, *args)");
            } else if (item$iv$iv == 127) {
                strValueOf = "\\u007F";
            } else {
                strValueOf = item$iv$iv == 65533 ? "\\uFFFD" : String.valueOf(item$iv$iv);
            }
            destination$iv$iv.add(strValueOf);
        }
        return CollectionsKt.joinToString$default((List) destination$iv$iv, "", null, null, 0, null, null, 62, null);
    }
}
