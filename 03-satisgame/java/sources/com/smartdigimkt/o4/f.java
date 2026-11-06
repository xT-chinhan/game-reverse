package com.smartdigimkt.o4;

import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface f {
    void a(com.smartdigimkt.z3.a aVar);

    void a(List list);

    default void a(List list, JSONObject jSONObject) {
        a(list);
    }
}
