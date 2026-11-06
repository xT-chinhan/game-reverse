package com.byazt.la;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1119, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo implements fw, Function {
    public volatile fw hw;
    public volatile Function pr;

    public zo(fw fwVar) {
        this.hw = fwVar;
    }

    public zo(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return this.hw.pr((JSONObject) sparseArray.get(1));
            default:
                return null;
        }
    }

    @Override // com.byazt.la.fw
    public JSONObject pr(JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, jSONObject);
        return (JSONObject) this.pr.apply(sparseArray);
    }
}
