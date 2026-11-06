package com.mcto.sspsdk.internal;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 {
    public final String a;
    public final int b;
    public HashMap c;

    public e0(String str, int i) {
        this.b = 0;
        if (i == 1 && TextUtils.isEmpty(str)) {
            this.a = "604";
        } else {
            this.a = str;
        }
        this.b = i;
    }
}
