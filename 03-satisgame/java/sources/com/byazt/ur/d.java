package com.byazt.ur;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, 113})
public class d implements dg<Float> {
    public static final d n = new d();

    private d() {
    }

    @Override // com.byazt.ur.dg
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Float qg(JsonReader jsonReader, float f) throws IOException {
        return Float.valueOf(um.qg(jsonReader) * f);
    }
}
