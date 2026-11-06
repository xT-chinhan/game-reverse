package com.byazt.bd;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.byazt.ld.a;
import com.byazt.ld.nt;
import com.byazt.ld.rc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.MARCode;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DOWNLOAD_BYTES, 37})
public class pr {

    public interface hw {
        void pr(int i, String str, Throwable th);

        void pr(nt ntVar, com.byazt.bd.hw hwVar);
    }

    public void pr(com.byazt.vl.hw hwVar, hw hwVar2, int i, int i2, String str) {
        pr(hwVar, hwVar2, i, i2, ImageView.ScaleType.CENTER_INSIDE, str);
    }

    public void pr(com.byazt.vl.hw hwVar, hw hwVar2, int i, int i2, String str, int i3, a aVar, boolean z) {
        pr(hwVar, hwVar2, i, i2, ImageView.ScaleType.CENTER_INSIDE, str, i3, aVar, z);
    }

    public void pr(com.byazt.vl.hw hwVar, final hw hwVar2, int i, int i2, ImageView.ScaleType scaleType, String str) {
        com.byazt.ub.hw.pr(hwVar.pr).hw(hwVar.hw).pr(i).hw(i2).hn(str).pr(Bitmap.Config.RGB_565).pr(scaleType).hw(!TextUtils.isEmpty(str)).pr(new rc() { // from class: com.byazt.bd.pr.1
            @Override // com.byazt.ld.rc
            public void pr(nt ntVar) {
                pr.this.pr(ntVar, hwVar2);
            }

            @Override // com.byazt.ld.rc
            public void pr(int i3, String str2, Throwable th) {
                pr.this.pr(i3, str2, th, hwVar2);
            }
        });
        pr();
    }

    public void pr(com.byazt.vl.hw hwVar, final hw hwVar2, int i, int i2, ImageView.ScaleType scaleType, String str, int i3, a aVar, boolean z) {
        com.byazt.ub.hw.pr(hwVar.pr).hw(hwVar.hw).pr(i).hw(i2).hn(str).pr(Bitmap.Config.RGB_565).pr(scaleType).pr(aVar).pr(z).hw(!TextUtils.isEmpty(str)).pr(new rc() { // from class: com.byazt.bd.pr.2
            @Override // com.byazt.ld.rc
            public void pr(nt ntVar) {
                pr.this.pr(ntVar, hwVar2);
            }

            @Override // com.byazt.ld.rc
            public void pr(int i4, String str2, Throwable th) {
                pr.this.pr(i4, str2, th, hwVar2);
            }
        }, i3);
        pr();
    }

    public void pr(nt ntVar, hw hwVar) {
        if (hwVar != null) {
            Object objHn = ntVar.hn();
            int iPr = pr(ntVar);
            if (objHn instanceof byte[]) {
                hwVar.pr(ntVar, new com.byazt.bd.hw((byte[]) objHn, iPr));
            } else if (objHn instanceof Bitmap) {
                hwVar.pr(ntVar, new com.byazt.bd.hw((Bitmap) objHn, iPr));
            } else {
                hwVar.pr(0, "not bitmap or gif result!", null);
            }
        }
    }

    private int pr(nt ntVar) {
        Map<String, String> mapFw = ntVar.fw();
        if (mapFw != null) {
            try {
                String str = mapFw.get("image_size");
                if (str != null && (str instanceof String)) {
                    return Integer.parseInt(str);
                }
                return 0;
            } catch (Throwable th) {
                return 0;
            }
        }
        return 0;
    }

    public void pr(int i, String str, Throwable th, hw hwVar) {
        if (hwVar != null) {
            hwVar.pr(i, str, th);
        }
    }

    public void pr() {
    }

    public static C0024pr hw() {
        return new C0024pr();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: com.byazt.bd.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DOWNLOAD_BYTES, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public static class C0024pr implements hw {
        @Override // com.byazt.bd.pr.hw
        public void pr(nt ntVar, com.byazt.bd.hw hwVar) {
        }

        @Override // com.byazt.bd.pr.hw
        public void pr(int i, String str, Throwable th) {
        }
    }
}
