package com.byazt.ub;

import android.text.TextUtils;
import android.widget.ImageView;
import com.byazt.hg.y;
import com.byazt.ld.g;
import com.byazt.ld.ny;
import com.byazt.wt.s;
import com.byazt.zs.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DASH_ABR, 13})
public class hw {
    public static com.byazt.pfl.pr pr() {
        return new com.byazt.pfl.pr() { // from class: com.byazt.ub.hw.1
            @Override // com.byazt.pfl.pr
            public void pr(ImageView imageView, String str) {
                hw.pr(com.byazt.hb.hn.pr(str)).pr(imageView);
            }
        };
    }

    public static g pr(String str) {
        return pr(hw().pr(str));
    }

    public static g pr(y yVar) {
        return pr(hw().pr(yVar.pr()).pr(yVar.hw()).hw(yVar.hn()).hw(yVar.fw()));
    }

    public static InputStream pr(String str, String str2) {
        return hw().pr(str, str2);
    }

    public static boolean pr(String str, String str2, String str3) {
        ny nyVarHw;
        if (TextUtils.isEmpty(str) || (nyVarHw = hw()) == null) {
            return false;
        }
        try {
            return nyVarHw.hw(str, str2, str3);
        } catch (Throwable th) {
            return false;
        }
    }

    public static ny hw() {
        return (ny) uc.pr("img_service");
    }

    private static g pr(g gVar) {
        if (s.pr()) {
            return gVar.pr(new hn());
        }
        return gVar;
    }
}
