package com.byazt.ur;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, 110})
public class sz {
    public static com.byazt.ld.s n(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        String strNextString = null;
        String strNextString2 = null;
        float fNextDouble = 0.0f;
        String strNextString3 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "fFamily":
                    strNextString = jsonReader.nextString();
                    break;
                case "ascent":
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case "fStyle":
                    strNextString2 = jsonReader.nextString();
                    break;
                case "fName":
                    strNextString3 = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.byazt.ld.s(strNextString, strNextString3, strNextString2, fNextDouble);
    }
}
