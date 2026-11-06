package com.byazt.ur;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, 86})
public class cd implements dg<Integer> {
    public static final cd n = new cd();

    private cd() {
    }

    @Override // com.byazt.ur.dg
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Integer qg(JsonReader jsonReader, float f) throws IOException {
        return Integer.valueOf(Math.round(um.qg(jsonReader) * f));
    }
}
