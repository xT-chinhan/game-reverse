package com.byazt.i;

import android.text.TextUtils;
import com.byazt.xv.um;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT})
public class hd implements um {
    public final long[] n;

    public hd(String str) {
        this.n = n(str);
    }

    @Override // com.byazt.xv.um
    public long n(int i, int i2) {
        long[] jArr = this.n;
        if (jArr == null || jArr.length <= 0) {
            return 0L;
        }
        int length = i - 1;
        if (length < 0) {
            length = 0;
        }
        if (length > jArr.length - 1) {
            length = jArr.length - 1;
        }
        return jArr[length];
    }

    private long[] n(String str) {
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
        } catch (Throwable unused) {
            return null;
        }
    }
}
