package com.bytedance.adsdk.lottie.d;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
class ul {
    static com.bytedance.adsdk.lottie.model.xr.ao ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String strNextString = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "it":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.bytedance.adsdk.lottie.model.xr.ah ahVarMs = x.ms(jsonReader, cVar);
                        if (ahVarMs != null) {
                            arrayList.add(ahVarMs);
                        }
                    }
                    jsonReader.endArray();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.xr.ao(strNextString, arrayList, zNextBoolean);
    }
}
