package com.mcto.sspsdk.internal;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class ba {
    public ArrayList a = null;
    public HashMap b = null;

    public final ba a(String str, String str2) {
        if (this.b == null) {
            this.b = new HashMap();
        }
        this.b.put(str, str2);
        return this;
    }
}
