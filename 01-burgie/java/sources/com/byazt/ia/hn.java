package com.byazt.ia;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1575, 20})
public class hn implements com.byazt.jq.pr {
    @Override // com.byazt.jq.pr
    public Object pr(Class cls, String str) {
        if (TextUtils.isEmpty(str)) {
            return ' ';
        }
        return Character.valueOf(str.charAt(0));
    }
}
