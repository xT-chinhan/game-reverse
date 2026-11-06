package com.bytedance.adsdk.lottie.d;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
class zb {
    static com.bytedance.adsdk.lottie.model.d ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        double dNextDouble = 0.0d;
        String strNextString = null;
        String strNextString2 = null;
        char cCharAt = 0;
        double dNextDouble2 = 0.0d;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "fFamily":
                    strNextString2 = jsonReader.nextString();
                    break;
                case "w":
                    dNextDouble = jsonReader.nextDouble();
                    break;
                case "ch":
                    cCharAt = jsonReader.nextString().charAt(0);
                    break;
                case "data":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if ("shapes".equals(jsonReader.nextName())) {
                            jsonReader.beginArray();
                            while (jsonReader.hasNext()) {
                                arrayList.add((com.bytedance.adsdk.lottie.model.xr.ao) x.ms(jsonReader, cVar));
                            }
                            jsonReader.endArray();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "size":
                    dNextDouble2 = jsonReader.nextDouble();
                    break;
                case "style":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.lottie.model.d(arrayList, cCharAt, dNextDouble2, dNextDouble, strNextString, strNextString2);
    }
}
