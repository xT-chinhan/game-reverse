package com.byazt.tx;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, 37})
public class pr {
    public static com.byazt.eqw.c pr(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(b.pr(jsonReader, ucVar));
            }
            jsonReader.endArray();
            cz.pr(arrayList);
        } else {
            arrayList.add(new com.byazt.cz.pr(qa.hw(jsonReader, com.byazt.ptr.vk.pr())));
        }
        return new com.byazt.eqw.c(arrayList);
    }

    public static com.byazt.eqw.m<PointF, PointF> hw(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        jsonReader.beginObject();
        com.byazt.eqw.c cVarPr = null;
        boolean z = false;
        com.byazt.eqw.hw hwVarPr = null;
        com.byazt.eqw.hw hwVarPr2 = null;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            switch (jsonReader.nextName()) {
                case "k":
                    cVarPr = pr(jsonReader, ucVar);
                    continue;
                    break;
                case "x":
                    if (jsonReader.peek() == JsonToken.STRING) {
                        z = true;
                        break;
                    } else {
                        hwVarPr = x.pr(jsonReader, ucVar);
                    }
                    break;
                case "y":
                    if (jsonReader.peek() == JsonToken.STRING) {
                        z = true;
                        break;
                    } else {
                        hwVarPr2 = x.pr(jsonReader, ucVar);
                    }
                    break;
            }
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        if (z) {
            ucVar.pr("Lottie doesn't support expressions.");
        }
        if (cVarPr != null) {
            return cVarPr;
        }
        return new com.byazt.eqw.aj(hwVarPr, hwVarPr2);
    }
}
