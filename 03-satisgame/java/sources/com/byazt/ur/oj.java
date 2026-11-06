package com.byazt.ur;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, 1642})
public class oj {
    public static com.byazt.aw.um n(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        String strNextString = null;
        com.byazt.aw.um.n nVarN = null;
        com.byazt.ccr.qg qgVarN = null;
        com.byazt.ccr.qg qgVarN2 = null;
        com.byazt.ccr.qg qgVarN3 = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "e":
                    qgVarN2 = q.n(jsonReader, wVar, false);
                    break;
                case "m":
                    nVarN = com.byazt.aw.um.n.n(jsonReader.nextInt());
                    break;
                case "o":
                    qgVarN3 = q.n(jsonReader, wVar, false);
                    break;
                case "s":
                    qgVarN = q.n(jsonReader, wVar, false);
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
        return new com.byazt.aw.um(strNextString, nVarN, qgVarN, qgVarN2, qgVarN3, zNextBoolean);
    }
}
