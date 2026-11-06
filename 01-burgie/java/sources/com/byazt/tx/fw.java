package com.byazt.tx;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, 62})
public class fw implements qn<Integer> {
    public static final fw pr = new fw();

    private fw() {
    }

    @Override // com.byazt.tx.qn
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Integer hw(JsonReader jsonReader, float f) throws IOException {
        double dNextDouble;
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        double dNextDouble2 = jsonReader.nextDouble();
        double dNextDouble3 = jsonReader.nextDouble();
        double dNextDouble4 = jsonReader.nextDouble();
        if (jsonReader.peek() != JsonToken.NUMBER) {
            dNextDouble = 1.0d;
        } else {
            dNextDouble = jsonReader.nextDouble();
        }
        if (z) {
            jsonReader.endArray();
        }
        if (dNextDouble2 <= 1.0d && dNextDouble3 <= 1.0d && dNextDouble4 <= 1.0d) {
            dNextDouble2 *= 255.0d;
            dNextDouble3 *= 255.0d;
            dNextDouble4 *= 255.0d;
            if (dNextDouble <= 1.0d) {
                dNextDouble *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) dNextDouble, (int) dNextDouble2, (int) dNextDouble3, (int) dNextDouble4));
    }
}
