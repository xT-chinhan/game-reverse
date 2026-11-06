package com.byazt.qok;

import com.byazt.si.v;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_IGNORE_BACKGROUND_RENDERSTALL, 8})
public class s implements v {
    public int n;
    public int qg;
    public com.byazt.dl.s<String, byte[]> s;

    public s(int i, int i2) {
        this.qg = i;
        this.n = i2;
        this.s = new com.byazt.dl.s<String, byte[]>(i) { // from class: com.byazt.qok.s.1
            @Override // com.byazt.dl.s
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public int qg(String str, byte[] bArr) {
                if (bArr == null) {
                    return 0;
                }
                return bArr.length;
            }
        };
    }

    @Override // com.byazt.si.n
    public boolean n(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return false;
        }
        this.s.n(str, bArr);
        return true;
    }

    @Override // com.byazt.si.n
    public byte[] n(String str) {
        return this.s.n(str);
    }

    @Override // com.byazt.si.n
    public void n() {
        n(0.0d);
    }

    @Override // com.byazt.si.n
    public boolean qg(String str) {
        return this.s.n(str) != null;
    }

    @Override // com.byazt.si.n
    public void n(double d) {
        this.s.n((int) (((double) this.qg) * d));
    }
}
