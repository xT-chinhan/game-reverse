package com.byazt.eqw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, 20})
public class hn extends g<com.byazt.ynb.x, com.byazt.ynb.x> {
    @Override // com.byazt.eqw.g, com.byazt.eqw.m
    public /* bridge */ /* synthetic */ List hn() {
        return super.hn();
    }

    @Override // com.byazt.eqw.g, com.byazt.eqw.m
    public /* bridge */ /* synthetic */ boolean hw() {
        return super.hw();
    }

    @Override // com.byazt.eqw.g
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public hn(List<com.byazt.cz.pr<com.byazt.ynb.x>> list) {
        super(pr(list));
    }

    private static List<com.byazt.cz.pr<com.byazt.ynb.x>> pr(List<com.byazt.cz.pr<com.byazt.ynb.x>> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, pr(list.get(i)));
        }
        return list;
    }

    private static com.byazt.cz.pr<com.byazt.ynb.x> pr(com.byazt.cz.pr<com.byazt.ynb.x> prVar) {
        com.byazt.ynb.x xVar = prVar.pr;
        com.byazt.ynb.x xVar2 = prVar.hw;
        if (xVar == null || xVar2 == null || xVar.pr().length == xVar2.pr().length) {
            return prVar;
        }
        float[] fArrPr = pr(xVar.pr(), xVar2.pr());
        return prVar.pr(xVar.pr(fArrPr), xVar2.pr(fArrPr));
    }

    public static float[] pr(float[] fArr, float[] fArr2) {
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

    @Override // com.byazt.eqw.m
    public com.byazt.al.pr<com.byazt.ynb.x, com.byazt.ynb.x> pr() {
        return new com.byazt.al.c(this.pr);
    }
}
