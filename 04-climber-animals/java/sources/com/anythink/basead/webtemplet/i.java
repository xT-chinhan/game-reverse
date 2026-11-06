package com.anythink.basead.webtemplet;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class i {
    int a;
    Map<String, Object> b;

    i(int i, Map<String, Object> map) {
        this.a = i;
        this.b = map != null ? new HashMap(map) : null;
    }
}
