package com.byazt.hcx;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1225, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
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
                Object gVar = sparseArray.get(1);
                if (gVar != null) {
                    gVar = new g((Function) gVar);
                }
                this.hw.pr((m) gVar);
                break;
            case 2:
                this.hw.pr(((Integer) sparseArray.get(1)).intValue(), (String) sparseArray.get(2), (Throwable) sparseArray.get(3));
                break;
        }
        return null;
    }

    @Override // com.byazt.hcx.fw
    public void pr(int i, String str, Throwable th) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, str);
        sparseArray.put(3, th);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.hcx.fw
    public void pr(m mVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (mVar != null) {
            mVar = new g(mVar);
        }
        sparseArray.put(1, mVar);
        this.pr.apply(sparseArray);
    }
}
