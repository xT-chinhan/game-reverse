package com.byazt.dc;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_SPILT_VOICE_WRITE, 5})
public class q {
    public final Function<SparseArray<Object>, Object> n;

    public q(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.n.qg : function;
    }

    public void n(JSONObject jSONObject) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 145101);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, jSONObject);
        this.n.apply(sparseArray);
    }

    public void qg(JSONObject jSONObject) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 145102);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, jSONObject);
        this.n.apply(sparseArray);
    }

    public void s(JSONObject jSONObject) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 145103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, jSONObject);
        this.n.apply(sparseArray);
    }

    public void n() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 145104);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }
}
