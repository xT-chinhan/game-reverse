package com.bytedance.adsdk.lottie.d;

import android.graphics.Path;
import android.util.JsonReader;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
class f {
    static com.bytedance.adsdk.lottie.model.xr.ub ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        com.bytedance.adsdk.lottie.model.ms.d dVar = null;
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.ms.ms msVarAb = null;
        boolean zNextBoolean = false;
        boolean zNextBoolean2 = false;
        int iNextInt = 1;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "fillEnabled":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "c":
                    msVarAb = d.ab(jsonReader, cVar);
                    break;
                case "o":
                    dVar = d.xr(jsonReader, cVar);
                    break;
                case "r":
                    iNextInt = jsonReader.nextInt();
                    break;
                case "hd":
                    zNextBoolean2 = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (dVar == null) {
            dVar = new com.bytedance.adsdk.lottie.model.ms.d(Collections.singletonList(new com.bytedance.adsdk.lottie.c.ms(100)));
        }
        return new com.bytedance.adsdk.lottie.model.xr.ub(strNextString, zNextBoolean, iNextInt == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, msVarAb, dVar, zNextBoolean2);
    }
}
