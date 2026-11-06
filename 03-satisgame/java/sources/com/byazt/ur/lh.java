package com.byazt.ur;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, 1475})
public class lh {
    public static com.byazt.aw.d n(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        String strNextString = null;
        com.byazt.ccr.qg qgVarN = null;
        com.byazt.ccr.qg qgVarN2 = null;
        com.byazt.ccr.d dVarN = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "c":
                    qgVarN = q.n(jsonReader, wVar, false);
                    break;
                case "o":
                    qgVarN2 = q.n(jsonReader, wVar, false);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "tr":
                    dVarN = s.n(jsonReader, wVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.byazt.aw.d(strNextString, qgVarN, qgVarN2, dVarN, zNextBoolean);
    }
}
