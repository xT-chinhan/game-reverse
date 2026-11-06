package com.byazt.vkw;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1069, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo implements fw.pr, Function {
    public volatile fw.pr hw;
    public volatile Function pr;

    public zo(fw.pr prVar) {
        this.hw = prVar;
    }

    public zo(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                this.hw.pr((JSONObject) sparseArray.get(1));
                break;
        }
        return null;
    }

    @Override // com.byazt.vkw.fw.pr
    public void pr(JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, jSONObject);
        this.pr.apply(sparseArray);
    }
}
