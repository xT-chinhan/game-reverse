package com.byazt.ur;

import android.util.JsonReader;
import com.anythink.core.e.b;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, 101})
public class fs {
    public static com.byazt.aw.s n(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        com.byazt.aw.s sVarN;
        String strNextString;
        jsonReader.beginObject();
        byte b = 2;
        int iNextInt = 2;
        while (true) {
            sVarN = null;
            if (!jsonReader.hasNext()) {
                strNextString = null;
                break;
            }
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals(com.anythink.core.e.d.a)) {
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
                b = !strNextString.equals("el") ? (byte) -1 : (byte) 0;
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
                b = !strNextString.equals(b.a.C) ? (byte) -1 : (byte) 11;
                break;
            case 3705:
                b = !strNextString.equals("tm") ? (byte) -1 : (byte) 12;
                break;
            case 3710:
                b = !strNextString.equals("tr") ? (byte) -1 : (byte) 13;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                sVarN = w.n(jsonReader, wVar, iNextInt);
                break;
            case 1:
                sVarN = ae.n(jsonReader, wVar);
                break;
            case 2:
                sVarN = cy.n(jsonReader, wVar);
                break;
            case 3:
                sVarN = f.n(jsonReader, wVar);
                break;
            case 4:
                sVarN = hd.n(jsonReader, wVar);
                break;
            case 5:
                sVarN = hu.n(jsonReader);
                wVar.n("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case 6:
                sVarN = ln.n(jsonReader, wVar);
                break;
            case 7:
                sVarN = v.n(jsonReader, wVar);
                break;
            case 8:
                sVarN = lh.n(jsonReader, wVar);
                break;
            case 9:
                sVarN = fi.n(jsonReader, wVar);
                break;
            case 10:
                sVarN = bb.n(jsonReader, wVar, iNextInt);
                break;
            case 11:
                sVarN = df.n(jsonReader, wVar);
                break;
            case 12:
                sVarN = oj.n(jsonReader, wVar);
                break;
            case 13:
                sVarN = s.n(jsonReader, wVar);
                break;
            default:
                com.byazt.nu.w.qg("Unknown shape type ".concat(String.valueOf(strNextString)));
                break;
        }
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return sVarN;
    }
}
