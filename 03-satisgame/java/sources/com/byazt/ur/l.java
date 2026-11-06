package com.byazt.ur;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, 18})
public class l {
    public static com.byazt.aw.n n(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        com.byazt.aw.n nVar = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("ef")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.byazt.aw.n nVarQg = qg(jsonReader, wVar);
                    if (nVarQg != null) {
                        nVar = nVarQg;
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        return nVar;
    }

    private static com.byazt.aw.n qg(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        jsonReader.beginObject();
        com.byazt.aw.n nVar = null;
        while (true) {
            boolean z = false;
            while (true) {
                if (jsonReader.hasNext()) {
                    String strNextName = jsonReader.nextName();
                    strNextName.hashCode();
                    if (strNextName.equals("v")) {
                        if (z) {
                            nVar = new com.byazt.aw.n(q.n(jsonReader, wVar));
                        } else {
                            jsonReader.skipValue();
                        }
                    } else if (strNextName.equals("ty")) {
                        if (jsonReader.nextInt() == 0) {
                            z = true;
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                } else {
                    jsonReader.endObject();
                    return nVar;
                }
            }
        }
    }
}
