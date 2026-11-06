package com.byazt.tx;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, 1121})
public class ls {
    public static com.byazt.ynb.nt pr(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String strNextString = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "it":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.byazt.ynb.hn hnVarPr = zo.pr(jsonReader, ucVar);
                        if (hnVarPr != null) {
                            arrayList.add(hnVarPr);
                        }
                    }
                    jsonReader.endArray();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.byazt.ynb.nt(strNextString, arrayList, zNextBoolean);
    }
}
