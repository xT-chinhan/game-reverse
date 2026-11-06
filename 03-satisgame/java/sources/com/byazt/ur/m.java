package com.byazt.ur;

import android.util.JsonReader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_JITTER_BUFFER_DELAY})
public class m {
    public static com.byazt.aw.fs n(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        jsonReader.beginObject();
        com.byazt.aw.fs.n nVar = null;
        com.byazt.ccr.fs fsVarL = null;
        com.byazt.ccr.q qVarQg = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "o":
                    qVarQg = q.qg(jsonReader, wVar);
                    break;
                case "pt":
                    fsVarL = q.l(jsonReader, wVar);
                    break;
                case "inv":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "mode":
                    String strNextString = jsonReader.nextString();
                    strNextString.hashCode();
                    switch (strNextString) {
                        case "a":
                            nVar = com.byazt.aw.fs.n.MASK_MODE_ADD;
                            break;
                        case "i":
                            wVar.n("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            nVar = com.byazt.aw.fs.n.MASK_MODE_INTERSECT;
                            break;
                        case "n":
                            nVar = com.byazt.aw.fs.n.MASK_MODE_NONE;
                            break;
                        case "s":
                            nVar = com.byazt.aw.fs.n.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            com.byazt.nu.w.qg("Unknown mask mode " + strNextName + ". Defaulting to Add.");
                            nVar = com.byazt.aw.fs.n.MASK_MODE_ADD;
                            break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.byazt.aw.fs(nVar, fsVarL, qVarQg, zNextBoolean);
    }
}
