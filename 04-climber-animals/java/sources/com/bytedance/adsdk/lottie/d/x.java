package com.bytedance.adsdk.lottie.d;

import android.util.JsonReader;
import com.umeng.analytics.pro.ek;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class x {
    static com.bytedance.adsdk.lottie.model.xr.ah ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        com.bytedance.adsdk.lottie.model.xr.ah ahVarMs;
        String strNextString;
        jsonReader.beginObject();
        byte b = 2;
        int iNextInt = 2;
        while (true) {
            ahVarMs = null;
            if (!jsonReader.hasNext()) {
                strNextString = null;
                break;
            }
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("d")) {
                iNextInt = jsonReader.nextInt();
            } else {
                if (strNextName.equals("ty")) {
                    strNextString = jsonReader.nextString();
                    break;
                }
                jsonReader.skipValue();
            }
        }
        if (strNextString == null) {
            return null;
        }
        strNextString.hashCode();
        switch (strNextString.hashCode()) {
            case 3239:
                b = !strNextString.equals(com.kuaishou.weapon.p0.t.n) ? (byte) -1 : (byte) 0;
                break;
            case 3270:
                b = !strNextString.equals("fl") ? (byte) -1 : (byte) 1;
                break;
            case 3295:
                if (!strNextString.equals("gf")) {
                    b = -1;
                }
                break;
            case 3307:
                b = !strNextString.equals("gr") ? (byte) -1 : (byte) 3;
                break;
            case 3308:
                b = !strNextString.equals("gs") ? (byte) -1 : (byte) 4;
                break;
            case 3488:
                b = !strNextString.equals("mm") ? (byte) -1 : (byte) 5;
                break;
            case 3633:
                b = !strNextString.equals("rc") ? (byte) -1 : (byte) 6;
                break;
            case 3634:
                b = !strNextString.equals("rd") ? (byte) -1 : (byte) 7;
                break;
            case 3646:
                b = !strNextString.equals("rp") ? (byte) -1 : (byte) 8;
                break;
            case 3669:
                b = !strNextString.equals("sh") ? (byte) -1 : (byte) 9;
                break;
            case 3679:
                b = !strNextString.equals("sr") ? (byte) -1 : (byte) 10;
                break;
            case 3681:
                b = !strNextString.equals("st") ? (byte) -1 : (byte) 11;
                break;
            case 3705:
                b = !strNextString.equals("tm") ? (byte) -1 : (byte) 12;
                break;
            case 3710:
                b = !strNextString.equals("tr") ? (byte) -1 : ek.k;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                ahVarMs = c.ms(jsonReader, cVar, iNextInt);
                break;
            case 1:
                ahVarMs = f.ms(jsonReader, cVar);
                break;
            case 2:
                ahVarMs = ao.ms(jsonReader, cVar);
                break;
            case 3:
                ahVarMs = ul.ms(jsonReader, cVar);
                break;
            case 4:
                ahVarMs = h.ms(jsonReader, cVar);
                break;
            case 5:
                ahVarMs = w.ms(jsonReader);
                cVar.ms("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case 6:
                ahVarMs = g.ms(jsonReader, cVar);
                break;
            case 7:
                ahVarMs = p.ms(jsonReader, cVar);
                break;
            case 8:
                ahVarMs = of.ms(jsonReader, cVar);
                break;
            case 9:
                ahVarMs = az.ms(jsonReader, cVar);
                break;
            case 10:
                ahVarMs = cv.ms(jsonReader, cVar, iNextInt);
                break;
            case 11:
                ahVarMs = m.ms(jsonReader, cVar);
                break;
            case 12:
                ahVarMs = lm.ms(jsonReader, cVar);
                break;
            case 13:
                ahVarMs = ah.ms(jsonReader, cVar);
                break;
            default:
                com.bytedance.adsdk.lottie.ka.ka.xr("Unknown shape type ".concat(String.valueOf(strNextString)));
                break;
        }
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return ahVarMs;
    }
}
