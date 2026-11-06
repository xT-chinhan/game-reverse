package com.byazt.qok;

import android.graphics.Bitmap;
import com.byazt.si.lh;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_IGNORE_BACKGROUND_RENDERSTALL, 26})
public class qg implements lh {
    public int n;
    public int qg;
    public com.byazt.dl.s<String, Bitmap> s;

    public qg(int i, int i2) {
        this.qg = i;
        this.n = i2;
        this.s = new com.byazt.dl.s<String, Bitmap>(i) { // from class: com.byazt.qok.qg.1
            @Override // com.byazt.dl.s
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public int qg(String str, Bitmap bitmap) {
                if (bitmap == null) {
                    return 0;
                }
                return qg.n(bitmap);
            }
        };
    }

    @Override // com.byazt.si.n
    public boolean n(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            return false;
        }
        this.s.n(str, bitmap);
        return true;
    }

    @Override // com.byazt.si.n
    public Bitmap n(String str) {
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

    public static int n(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getAllocationByteCount();
    }
}
