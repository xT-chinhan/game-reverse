package com.byazt.tx;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, 250})
public class k implements qn<Float> {
    public static final k pr = new k();

    private k() {
    }

    @Override // com.byazt.tx.qn
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Float hw(JsonReader jsonReader, float f) throws IOException {
        return Float.valueOf(qa.hw(jsonReader) * f);
    }
}
