package com.byazt.ur;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, 793})
public class hu {
    public static com.byazt.aw.rv n(JsonReader jsonReader) throws IOException {
        String strNextString = null;
        com.byazt.aw.rv.n nVarN = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "mm":
                    nVarN = com.byazt.aw.rv.n.n(jsonReader.nextInt());
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.byazt.aw.rv(strNextString, nVarN, zNextBoolean);
    }
}
