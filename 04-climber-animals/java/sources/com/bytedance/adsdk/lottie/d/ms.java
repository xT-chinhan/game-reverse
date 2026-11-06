package com.bytedance.adsdk.lottie.d;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    public static com.bytedance.adsdk.lottie.model.ms.ka ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(yu.ms(jsonReader, cVar));
            }
            jsonReader.endArray();
            nw.ms(arrayList);
        } else {
            arrayList.add(new com.bytedance.adsdk.lottie.c.ms(y.xr(jsonReader, com.bytedance.adsdk.lottie.ka.ny.ms())));
        }
        return new com.bytedance.adsdk.lottie.model.ms.ka(arrayList);
    }

    static com.bytedance.adsdk.lottie.model.ms.zb<PointF, PointF> xr(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.lottie.model.ms.ka kaVarMs = null;
        com.bytedance.adsdk.lottie.model.ms.xr xrVarMs = null;
        com.bytedance.adsdk.lottie.model.ms.xr xrVarMs2 = null;
        boolean z = false;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "k":
                    kaVarMs = ms(jsonReader, cVar);
                    break;
                case "x":
                    if (jsonReader.peek() != JsonToken.STRING) {
                        xrVarMs = d.ms(jsonReader, cVar);
                        break;
                    } else {
                        z = true;
                        jsonReader.skipValue();
                        break;
                    }
                    break;
                case "y":
                    if (jsonReader.peek() != JsonToken.STRING) {
                        xrVarMs2 = d.ms(jsonReader, cVar);
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
            cVar.ms("Lottie doesn't support expressions.");
        }
        return kaVarMs != null ? kaVarMs : new com.bytedance.adsdk.lottie.model.ms.ny(xrVarMs, xrVarMs2);
    }
}
