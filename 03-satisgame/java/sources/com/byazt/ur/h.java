package com.byazt.ur;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, 878})
public class h {
    public static com.byazt.bd.rv n(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        return new com.byazt.bd.rv(wVar, a.n(jsonReader, wVar, com.byazt.nu.tj.n(), t.n, jsonReader.peek() == JsonToken.BEGIN_OBJECT, false));
    }
}
