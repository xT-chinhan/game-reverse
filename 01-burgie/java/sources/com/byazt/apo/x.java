package com.byazt.apo;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSIONS, 121})
public class x implements hn, Function {
    public volatile hn hw;
    public volatile Function pr;

    public x(hn hnVar) {
        this.hw = hnVar;
    }

    public x(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                this.hw.pr((Context) sparseArray.get(1), (Intent) sparseArray.get(2), ((Boolean) sparseArray.get(3)).booleanValue(), ((Integer) sparseArray.get(4)).intValue());
                break;
        }
        return null;
    }

    @Override // com.byazt.apo.hn
    public void pr(Context context, Intent intent, boolean z, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, context);
        sparseArray.put(2, intent);
        sparseArray.put(3, Boolean.valueOf(z));
        sparseArray.put(4, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }
}
