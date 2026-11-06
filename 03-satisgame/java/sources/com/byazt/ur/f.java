package com.byazt.ur;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, 990})
public class f {
    public static com.byazt.aw.cy n(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
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
                        com.byazt.aw.s sVarN = fs.n(jsonReader, wVar);
                        if (sVarN != null) {
                            arrayList.add(sVarN);
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
        return new com.byazt.aw.cy(strNextString, arrayList, zNextBoolean);
    }
}
