package com.anythink.core.common.h;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ax extends bm {
    JSONObject a;

    public ax(String str, String str2, String str3, Map<String, Object> map, JSONObject jSONObject) {
        super(str, str2, str3, "", map, null, null, null);
        this.a = jSONObject;
        a(2);
    }

    public final JSONObject a() {
        return this.a;
    }
}
