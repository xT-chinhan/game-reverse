package com.byazt.ur;

import android.graphics.Path;
import android.util.JsonReader;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, 1759})
public class ae {
    public static com.byazt.aw.k n(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        com.byazt.ccr.q qVar = null;
        String strNextString = null;
        com.byazt.ccr.n nVarX = null;
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
                    nVarX = q.x(jsonReader, wVar);
                    break;
                case "o":
                    qVar = q.qg(jsonReader, wVar);
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
        if (qVar == null) {
            qVar = new com.byazt.ccr.q(Collections.singletonList(new com.byazt.yt.n(100)));
        }
        return new com.byazt.aw.k(strNextString, zNextBoolean, iNextInt == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, nVarX, qVar, zNextBoolean2);
    }
}
