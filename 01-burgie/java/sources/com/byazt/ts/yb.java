package com.byazt.ts;

import android.text.TextUtils;
import com.byazt.lj.qa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public class yb implements qa {
    public final long[] pr;

    public yb(String str) {
        this.pr = pr(str);
    }

    @Override // com.byazt.lj.qa
    public long pr(int i, int i2) {
        long[] jArr = this.pr;
        if (jArr != null && jArr.length > 0) {
            int length = i - 1;
            if (length < 0) {
                length = 0;
            }
            if (length > jArr.length - 1) {
                length = jArr.length - 1;
            }
            return jArr[length];
        }
        return 0L;
    }

    private long[] pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] strArrSplit = str.split(",");
            if (strArrSplit.length == 0) {
                return null;
            }
            long[] jArr = new long[strArrSplit.length];
            for (int i = 0; i < strArrSplit.length; i++) {
                jArr[i] = Long.parseLong(strArrSplit[i]);
            }
            return jArr;
        } catch (Throwable th) {
            return null;
        }
    }
}
