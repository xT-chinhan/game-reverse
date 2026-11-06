package com.bytedance.adsdk.lottie.d;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class ka {
    static com.bytedance.adsdk.lottie.model.xr.ms ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        com.bytedance.adsdk.lottie.model.xr.ms msVar = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("ef")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.bytedance.adsdk.lottie.model.xr.ms msVarXr = xr(jsonReader, cVar);
                    if (msVarXr != null) {
                        msVar = msVarXr;
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        return msVar;
    }

    private static com.bytedance.adsdk.lottie.model.xr.ms xr(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.lottie.model.xr.ms msVar = null;
        while (true) {
            boolean z = false;
            while (true) {
                if (jsonReader.hasNext()) {
                    String strNextName = jsonReader.nextName();
                    strNextName.hashCode();
                    if (strNextName.equals("v")) {
                        if (z) {
                            msVar = new com.bytedance.adsdk.lottie.model.xr.ms(d.ms(jsonReader, cVar));
                        } else {
                            jsonReader.skipValue();
                        }
                    } else if (strNextName.equals("ty")) {
                        if (jsonReader.nextInt() == 0) {
                            z = true;
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                } else {
                    jsonReader.endObject();
                    return msVar;
                }
            }
        }
    }
}
