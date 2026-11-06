package com.byazt.ur;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, 1748})
public class fi {
    public static com.byazt.aw.hd n(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        String strNextString = null;
        com.byazt.ccr.fs fsVarL = null;
        int iNextInt = 0;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "ks":
                    fsVarL = q.l(jsonReader, wVar);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "ind":
                    iNextInt = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.byazt.aw.hd(strNextString, iNextInt, fsVarL, zNextBoolean);
    }
}
