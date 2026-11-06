package com.bytedance.sdk.component.hi.ka.ms.ms;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements com.bytedance.sdk.component.hi.ka.ms.ms {
    @Override // com.bytedance.sdk.component.hi.ka.ms.ms
    public Object ms(Class cls, String str) {
        if (TextUtils.isEmpty(str)) {
            return ' ';
        }
        return Character.valueOf(str.charAt(0));
    }
}
