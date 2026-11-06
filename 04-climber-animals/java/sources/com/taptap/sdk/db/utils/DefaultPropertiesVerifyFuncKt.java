package com.taptap.sdk.db.utils;

import android.util.Log;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: DefaultPropertiesVerifyFunc.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u001a&\u0010\u0000\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"defaultPropertiesVerifyFunc", "Lkotlin/Function2;", "", "", "", "maxLength", "", "tap-db_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DefaultPropertiesVerifyFuncKt {
    public static /* synthetic */ Function2 defaultPropertiesVerifyFunc$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 256;
        }
        return defaultPropertiesVerifyFunc(i);
    }

    public static final Function2<String, Object, Boolean> defaultPropertiesVerifyFunc(final int i) {
        return new Function2<String, Object, Boolean>() { // from class: com.taptap.sdk.db.utils.DefaultPropertiesVerifyFuncKt.defaultPropertiesVerifyFunc.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Code duplicated, block: B:18:0x002c  */
            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(String str, Object obj) {
                String str2 = str;
                boolean z = false;
                if (!(str2 == null || str2.length() == 0) && str.length() <= i) {
                    if (!(obj instanceof CharSequence)) {
                        if (obj instanceof Number ? true : obj instanceof Boolean ? true : obj instanceof Date) {
                            z = true;
                        }
                    } else if (((CharSequence) obj).length() <= i) {
                        z = true;
                    }
                }
                if (!z) {
                    Log.e("TapDB", "The error property has been removed, key=" + str + ", value=" + obj);
                }
                return Boolean.valueOf(z);
            }
        };
    }
}
