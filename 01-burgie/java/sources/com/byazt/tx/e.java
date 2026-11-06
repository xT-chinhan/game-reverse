package com.byazt.tx;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, 105})
public class e implements qn<com.byazt.ynb.g> {
    public static final e pr = new e();

    private e() {
    }

    @Override // com.byazt.tx.qn
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public com.byazt.ynb.g hw(JsonReader jsonReader, float f) throws IOException {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> listPr = null;
        List<PointF> listPr2 = null;
        List<PointF> listPr3 = null;
        boolean zNextBoolean = false;
        while (true) {
            if (jsonReader.hasNext()) {
                switch (jsonReader.nextName()) {
                    case "c":
                        zNextBoolean = jsonReader.nextBoolean();
                        break;
                    case "v":
                        listPr = qa.pr(jsonReader, f);
                        break;
                    case "i":
                        listPr2 = qa.pr(jsonReader, f);
                        break;
                    case "o":
                        listPr3 = qa.pr(jsonReader, f);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            } else {
                jsonReader.endObject();
                if (jsonReader.peek() == JsonToken.END_ARRAY) {
                    jsonReader.endArray();
                }
                if (listPr == null || listPr2 == null || listPr3 == null) {
                    throw new IllegalArgumentException("Shape data was missing information.");
                }
                if (listPr.isEmpty()) {
                    return new com.byazt.ynb.g(new PointF(), false, Collections.emptyList());
                }
                int size = listPr.size();
                PointF pointF = listPr.get(0);
                ArrayList arrayList = new ArrayList(size);
                for (int i = 1; i < size; i++) {
                    PointF pointF2 = listPr.get(i);
                    int i2 = i - 1;
                    arrayList.add(new com.byazt.uxi.pr(com.byazt.ptr.aj.pr(listPr.get(i2), listPr3.get(i2)), com.byazt.ptr.aj.pr(pointF2, listPr2.get(i)), pointF2));
                }
                if (zNextBoolean) {
                    PointF pointF3 = listPr.get(0);
                    int i3 = size - 1;
                    arrayList.add(new com.byazt.uxi.pr(com.byazt.ptr.aj.pr(listPr.get(i3), listPr3.get(i3)), com.byazt.ptr.aj.pr(pointF3, listPr2.get(0)), pointF3));
                }
                return new com.byazt.ynb.g(pointF, zNextBoolean, arrayList);
            }
        }
    }
}
