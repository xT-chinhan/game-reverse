package com.anythink.basead.exoplayer.j.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class k {
    private final Map<String, Object> a = new HashMap();
    private final List<String> b = new ArrayList();

    public final k a(String str, String str2) {
        return a(str, (Object) str2);
    }

    public final k a(String str, long j) {
        return a(str, Long.valueOf(j));
    }

    private k a(String str, byte[] bArr) {
        return a(str, (Object) Arrays.copyOf(bArr, bArr.length));
    }

    public final k a(String str) {
        this.b.add(str);
        this.a.remove(str);
        return this;
    }

    public final List<String> a() {
        return Collections.unmodifiableList(new ArrayList(this.b));
    }

    public final Map<String, Object> b() {
        HashMap map = new HashMap(this.a);
        for (Map.Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(Arrays.copyOf(bArr, bArr.length));
            }
        }
        return Collections.unmodifiableMap(map);
    }

    private k a(String str, Object obj) {
        this.a.put((String) com.anythink.basead.exoplayer.k.a.a(str), com.anythink.basead.exoplayer.k.a.a(obj));
        this.b.remove(str);
        return this;
    }
}
