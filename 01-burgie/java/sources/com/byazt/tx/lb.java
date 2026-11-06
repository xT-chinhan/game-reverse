package com.byazt.tx;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, 48})
public class lb implements qn<Integer> {
    public static final lb pr = new lb();

    private lb() {
    }

    @Override // com.byazt.tx.qn
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Integer hw(JsonReader jsonReader, float f) throws IOException {
        return Integer.valueOf(Math.round(qa.hw(jsonReader) * f));
    }
}
