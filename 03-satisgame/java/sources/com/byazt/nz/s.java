package com.byazt.nz;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 549, 8})
public class s implements com.byazt.uyu.n {
    @Override // com.byazt.uyu.n
    public Object n(Class cls, String str) {
        if (TextUtils.isEmpty(str)) {
            return ' ';
        }
        return Character.valueOf(str.charAt(0));
    }
}
