package com.byazt.apo;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSIONS, 13})
public class hw implements pr, Function {
    public volatile pr hw;
    public volatile Function pr;

    public hw(pr prVar) {
        this.hw = prVar;
    }

    public hw(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (((Integer) ((SparseArray) obj).get(0)).intValue()) {
            case 1:
                return Float.valueOf(this.hw.pr());
            case 2:
                return Float.valueOf(this.hw.hw());
            case 3:
                return Long.valueOf(this.hw.hn());
            default:
                return null;
        }
    }

    @Override // com.byazt.apo.pr
    public long hn() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.apo.pr
    public float hw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Float) this.pr.apply(sparseArray)).floatValue();
    }

    @Override // com.byazt.apo.pr
    public float pr() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return ((Float) this.pr.apply(sparseArray)).floatValue();
    }
}
