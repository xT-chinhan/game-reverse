package com.taptap.sdk.db.utils;

import android.util.Log;
import com.taptap.sdk.db.constant.Common;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultPropertiesVerifyFunc.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a:\u0010\u0000\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006¨\u0006\t"}, d2 = {"defaultPropertiesVerifyFunc", "Lkotlin/Function2;", "", "", "", "keyMaxLength", "", "userDeviceValueMaxLength", "otherValueMaxLength", "tap-db_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DefaultPropertiesVerifyFuncKt {
    public static /* synthetic */ Function2 defaultPropertiesVerifyFunc$default(int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = 256;
        }
        if ((i4 & 2) != 0) {
            i2 = 256;
        }
        if ((i4 & 4) != 0) {
            i3 = 4096;
        }
        return defaultPropertiesVerifyFunc(i, i2, i3);
    }

    public static final Function2<String, Object, Boolean> defaultPropertiesVerifyFunc(final int keyMaxLength, final int userDeviceValueMaxLength, final int otherValueMaxLength) {
        return new Function2<String, Object, Boolean>() { // from class: com.taptap.sdk.db.utils.DefaultPropertiesVerifyFuncKt.defaultPropertiesVerifyFunc.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(String key, Object value) {
                String str = key;
                boolean z = false;
                if (!(str == null || str.length() == 0) && key.length() <= keyMaxLength) {
                    int valueMaxLength = Intrinsics.areEqual(key, Common.System.USER_ID) ? true : Intrinsics.areEqual(key, "device_id") ? userDeviceValueMaxLength : otherValueMaxLength;
                    if (!(value instanceof CharSequence)) {
                        if (value instanceof Number ? true : value instanceof Boolean ? true : value instanceof Date) {
                            z = true;
                        }
                    } else if (((CharSequence) value).length() <= valueMaxLength) {
                        z = true;
                    }
                }
                boolean valid = z;
                if (!valid) {
                    Log.e("TapDB", "The error property has been removed, key=" + key + ", value=" + value);
                }
                return Boolean.valueOf(valid);
            }
        };
    }
}
