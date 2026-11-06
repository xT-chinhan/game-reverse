package com.byazt.tx;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, 108})
public class m {
    public static com.byazt.uxi.x pr(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        String strNextString = null;
        String strNextString2 = null;
        double dNextDouble = 0.0d;
        double dNextDouble2 = 0.0d;
        char cCharAt = 0;
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "ch":
                    cCharAt = jsonReader.nextString().charAt(0);
                    break;
                case "size":
                    dNextDouble = jsonReader.nextDouble();
                    break;
                case "w":
                    dNextDouble2 = jsonReader.nextDouble();
                    break;
                case "style":
                    strNextString = jsonReader.nextString();
                    break;
                case "fFamily":
                    strNextString2 = jsonReader.nextString();
                    break;
                case "data":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if ("shapes".equals(jsonReader.nextName())) {
                            jsonReader.beginArray();
                            while (jsonReader.hasNext()) {
                                arrayList.add((com.byazt.ynb.nt) zo.pr(jsonReader, ucVar));
                            }
                            jsonReader.endArray();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.byazt.uxi.x(arrayList, cCharAt, dNextDouble, dNextDouble2, strNextString, strNextString2);
    }
}
