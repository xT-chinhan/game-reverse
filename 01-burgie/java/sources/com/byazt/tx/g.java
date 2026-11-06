package com.byazt.tx;

import android.util.JsonReader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public class g {
    public static com.byazt.uxi.hn pr(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        String strNextString = null;
        String strNextString2 = null;
        float fNextDouble = 0.0f;
        String strNextString3 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "fFamily":
                    strNextString = jsonReader.nextString();
                    break;
                case "fName":
                    strNextString3 = jsonReader.nextString();
                    break;
                case "fStyle":
                    strNextString2 = jsonReader.nextString();
                    break;
                case "ascent":
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.byazt.uxi.hn(strNextString, strNextString3, strNextString2, fNextDouble);
    }
}
