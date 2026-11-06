package com.bytedance.adsdk.lottie.d;

import android.graphics.Path;
import android.util.JsonReader;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
class ao {
    static com.bytedance.adsdk.lottie.model.xr.ka ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        com.bytedance.adsdk.lottie.model.ms.d dVarXr = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.xr.ab abVar = null;
        com.bytedance.adsdk.lottie.model.ms.ah ahVarMs = null;
        com.bytedance.adsdk.lottie.model.ms.c cVarAh = null;
        com.bytedance.adsdk.lottie.model.ms.c cVarAh2 = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            int iNextInt = -1;
            switch (strNextName) {
                case "e":
                    cVarAh2 = d.ah(jsonReader, cVar);
                    break;
                case "g":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals(com.kuaishou.weapon.p0.t.a)) {
                            ahVarMs = d.ms(jsonReader, cVar, iNextInt);
                        } else if (strNextName2.equals("p")) {
                            iNextInt = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "o":
                    dVarXr = d.xr(jsonReader, cVar);
                    break;
                case "r":
                    fillType = jsonReader.nextInt() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case "s":
                    cVarAh = d.ah(jsonReader, cVar);
                    break;
                case "t":
                    abVar = jsonReader.nextInt() == 1 ? com.bytedance.adsdk.lottie.model.xr.ab.LINEAR : com.bytedance.adsdk.lottie.model.xr.ab.RADIAL;
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.xr.ka(strNextString, abVar, fillType, ahVarMs, dVarXr == null ? new com.bytedance.adsdk.lottie.model.ms.d(Collections.singletonList(new com.bytedance.adsdk.lottie.c.ms(100))) : dVarXr, cVarAh, cVarAh2, null, null, zNextBoolean);
    }
}
