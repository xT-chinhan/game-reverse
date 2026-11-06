package com.byazt.tx;

import android.util.JsonReader;
import android.util.JsonToken;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT})
public class n implements qn<com.byazt.cz.x> {
    public static final n pr = new n();

    private n() {
    }

    @Override // com.byazt.tx.qn
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public com.byazt.cz.x hw(JsonReader jsonReader, float f) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z) {
            jsonReader.endArray();
        }
        return new com.byazt.cz.x((fNextDouble / 100.0f) * f, (fNextDouble2 / 100.0f) * f);
    }
}
