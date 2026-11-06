package com.byazt.ur;

import android.util.JsonReader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa {
    public static com.byazt.ld.q n(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        double dNextDouble = 0.0d;
        String strNextString = null;
        String strNextString2 = null;
        char cCharAt = 0;
        double dNextDouble2 = 0.0d;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "fFamily":
                    strNextString2 = jsonReader.nextString();
                    break;
                case "w":
                    dNextDouble = jsonReader.nextDouble();
                    break;
                case "ch":
                    cCharAt = jsonReader.nextString().charAt(0);
                    break;
                case "data":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if ("shapes".equals(jsonReader.nextName())) {
                            jsonReader.beginArray();
                            while (jsonReader.hasNext()) {
                                arrayList.add((com.byazt.aw.cy) fs.n(jsonReader, wVar));
                            }
                            jsonReader.endArray();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "size":
                    dNextDouble2 = jsonReader.nextDouble();
                    break;
                case "style":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.byazt.ld.q(arrayList, cCharAt, dNextDouble2, dNextDouble, strNextString, strNextString2);
    }
}
