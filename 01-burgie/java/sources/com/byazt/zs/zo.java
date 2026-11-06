package com.byazt.zs;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 14, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo implements com.byazt.vkw.nt, Function {
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                pr();
                return null;
            case 2:
                return Boolean.valueOf(hw());
            case 3:
                return Integer.valueOf(hn());
            case 4:
                return pr((byte[]) sparseArray.get(1));
            case 5:
                return hw((byte[]) sparseArray.get(1));
            case 6:
                return pr((String) sparseArray.get(1));
            case 7:
                return hw((String) sparseArray.get(1));
            case 8:
                return hn((String) sparseArray.get(1));
            case 9:
                return x((String) sparseArray.get(1));
            default:
                return null;
        }
    }

    @Override // com.byazt.vkw.nt
    public void pr() {
        com.byazt.yi.w.pr();
    }

    @Override // com.byazt.vkw.nt
    public boolean hw() {
        return com.byazt.yi.w.hw();
    }

    @Override // com.byazt.vkw.nt
    public int hn() {
        return com.byazt.yi.w.hn();
    }

    @Override // com.byazt.vkw.nt
    public byte[] pr(byte[] bArr) {
        return com.byazt.yi.w.pr().pr(bArr);
    }

    @Override // com.byazt.vkw.nt
    public byte[] hw(byte[] bArr) {
        return com.byazt.yi.w.pr().hw(bArr);
    }

    @Override // com.byazt.vkw.nt
    public String pr(String str) {
        return com.byazt.yi.w.pr().pr(str);
    }

    @Override // com.byazt.vkw.nt
    public String hw(String str) {
        return com.byazt.yi.w.pr().hw(str);
    }

    @Override // com.byazt.vkw.nt
    public String hn(String str) {
        com.byazt.yi.w.pr();
        return com.byazt.yi.w.hn(str);
    }

    @Override // com.byazt.vkw.nt
    public String x(String str) {
        com.byazt.yi.w.pr();
        return com.byazt.yi.w.x(str);
    }
}
