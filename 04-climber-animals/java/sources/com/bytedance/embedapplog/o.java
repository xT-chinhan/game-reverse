package com.bytedance.embedapplog;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
final class o {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static ce<String> f510ms = new ce<String>() { // from class: com.bytedance.embedapplog.o.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.ce
        /* JADX INFO: renamed from: ah, reason: merged with bridge method [inline-methods] */
        public String ms(Object... objArr) {
            SharedPreferences sharedPreferences = (SharedPreferences) objArr[0];
            String string = sharedPreferences.getString("cdid", "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            String string2 = UUID.randomUUID().toString();
            sharedPreferences.edit().putString("cdid", string2).apply();
            return string2;
        }
    };

    static String ms(SharedPreferences sharedPreferences) {
        return f510ms.xr(sharedPreferences);
    }
}
