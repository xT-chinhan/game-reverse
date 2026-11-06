package com.byazt.wt;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public class yb {

    public interface pr {
        void pr();

        void pr(com.byazt.bd.hw hwVar, com.byazt.ld.nt ntVar);
    }

    public static void pr(com.byazt.vl.hw hwVar, int i, int i2, final pr prVar, String str, int i3, com.byazt.ld.a aVar, boolean z) {
        com.byazt.ca.ho.hw("splashLoadAd", " getImageBytes url ".concat(String.valueOf(hwVar)));
        com.byazt.pk.uc.pr().hn().pr(hwVar, new com.byazt.bd.pr.hw() { // from class: com.byazt.wt.yb.1
            @Override // com.byazt.bd.pr.hw
            public void pr(com.byazt.ld.nt ntVar, com.byazt.bd.hw hwVar2) {
                pr prVar2;
                if (hwVar2.x() && (prVar2 = prVar) != null) {
                    prVar2.pr(hwVar2, ntVar);
                    return;
                }
                pr prVar3 = prVar;
                if (prVar3 != null) {
                    prVar3.pr();
                }
            }

            @Override // com.byazt.bd.pr.hw
            public void pr(int i4, String str2, Throwable th) {
                pr prVar2 = prVar;
                if (prVar2 != null) {
                    prVar2.pr();
                }
            }
        }, i, i2, str, i3, aVar, z);
    }

    public static Drawable pr(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return new ColorDrawable(0);
        }
        try {
            return new BitmapDrawable(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
        } catch (Throwable th) {
            return new ColorDrawable(0);
        }
    }
}
