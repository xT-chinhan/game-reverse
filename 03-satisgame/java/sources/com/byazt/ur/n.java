package com.byazt.ur;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, 19})
public class n {
    public static com.byazt.ccr.l n(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(h.n(jsonReader, wVar));
            }
            jsonReader.endArray();
            py.n(arrayList);
        } else {
            arrayList.add(new com.byazt.yt.n(um.qg(jsonReader, com.byazt.nu.tj.n())));
        }
        return new com.byazt.ccr.l(arrayList);
    }

    public static com.byazt.ccr.oa<PointF, PointF> qg(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        jsonReader.beginObject();
        com.byazt.ccr.l lVarN = null;
        com.byazt.ccr.qg qgVarN = null;
        com.byazt.ccr.qg qgVarN2 = null;
        boolean z = false;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "k":
                    lVarN = n(jsonReader, wVar);
                    break;
                case "x":
                    if (jsonReader.peek() != JsonToken.STRING) {
                        qgVarN = q.n(jsonReader, wVar);
                        break;
                    } else {
                        z = true;
                        jsonReader.skipValue();
                        break;
                    }
                    break;
                case "y":
                    if (jsonReader.peek() != JsonToken.STRING) {
                        qgVarN2 = q.n(jsonReader, wVar);
                        break;
                    } else {
                        z = true;
                        jsonReader.skipValue();
                        break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            wVar.n("Lottie doesn't support expressions.");
        }
        return lVarN != null ? lVarN : new com.byazt.ccr.rv(qgVarN, qgVarN2);
    }
}
