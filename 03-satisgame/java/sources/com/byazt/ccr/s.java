package com.byazt.ccr;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE, 8})
public class s extends sz<com.byazt.aw.q, com.byazt.aw.q> {
    @Override // com.byazt.ccr.sz, com.byazt.ccr.oa
    public /* bridge */ /* synthetic */ boolean qg() {
        return super.qg();
    }

    @Override // com.byazt.ccr.sz, com.byazt.ccr.oa
    public /* bridge */ /* synthetic */ List s() {
        return super.s();
    }

    @Override // com.byazt.ccr.sz
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public s(List<com.byazt.yt.n<com.byazt.aw.q>> list) {
        super(n(list));
    }

    private static List<com.byazt.yt.n<com.byazt.aw.q>> n(List<com.byazt.yt.n<com.byazt.aw.q>> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, n(list.get(i)));
        }
        return list;
    }

    private static com.byazt.yt.n<com.byazt.aw.q> n(com.byazt.yt.n<com.byazt.aw.q> nVar) {
        com.byazt.aw.q qVar = nVar.n;
        com.byazt.aw.q qVar2 = nVar.qg;
        if (qVar == null || qVar2 == null || qVar.n().length == qVar2.n().length) {
            return nVar;
        }
        float[] fArrN = n(qVar.n(), qVar2.n());
        return nVar.n(qVar.n(fArrN), qVar2.n(fArrN));
    }

    public static float[] n(float[] fArr, float[] fArr2) {
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        Arrays.sort(fArr3);
        float f = Float.NaN;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            float f2 = fArr3[i2];
            if (f2 != f) {
                fArr3[i] = f2;
                i++;
                f = fArr3[i2];
            }
        }
        return Arrays.copyOfRange(fArr3, 0, i);
    }

    @Override // com.byazt.ccr.oa
    public com.byazt.bd.n<com.byazt.aw.q, com.byazt.aw.q> n() {
        return new com.byazt.bd.l(this.n);
    }
}
