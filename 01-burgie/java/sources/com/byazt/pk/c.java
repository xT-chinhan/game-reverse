package com.byazt.pk;

import android.content.Context;
import android.location.Address;
import com.byazt.sd.iu;
import com.byazt.wt.nt;
import com.byazt.wt.y;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_BEGIN_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements com.byazt.ry.hw {
    public Context hn;
    public String pr = "sp_multi_ttadnet_config";
    public com.byazt.cr.c hw = y.pr("sp_multi_ttadnet_config");

    public c(Context context) {
        this.hn = context;
    }

    @Override // com.byazt.ry.hw
    public Context getContext() {
        return this.hn;
    }

    @Override // com.byazt.ry.hw
    public Address pr(Context context) {
        return null;
    }

    @Override // com.byazt.ry.hw
    public int pr() {
        return Integer.parseInt("1371");
    }

    @Override // com.byazt.ry.hw
    public String hw() {
        return "openadsdk";
    }

    @Override // com.byazt.ry.hw
    public String hn() {
        return "android";
    }

    @Override // com.byazt.ry.hw
    public int x() {
        return iu.x;
    }

    @Override // com.byazt.ry.hw
    public String c() {
        return nt.pr();
    }

    @Override // com.byazt.ry.hw
    public String pr(Context context, String str, String str2) {
        return this.hw.hw(str, str2);
    }

    @Override // com.byazt.ry.hw
    public void pr(Context context, Map<String, ?> map) {
        if (map != null) {
            try {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        this.hw.pr(entry.getKey(), ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        this.hw.pr(entry.getKey(), ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        this.hw.pr(entry.getKey(), ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        this.hw.pr(entry.getKey(), ((Boolean) value).booleanValue());
                    } else if (value instanceof String) {
                        this.hw.pr(entry.getKey(), (String) value);
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.byazt.ry.hw
    public String[] uc() {
        return new String[]{"tnc3-bjlgy.zijieapi.com", "tnc3-alisc1.zijieapi.com", "tnc3-aliec2.zijieapi.com"};
    }
}
