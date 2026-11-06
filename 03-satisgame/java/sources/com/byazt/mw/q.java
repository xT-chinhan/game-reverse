package com.byazt.mw;

import android.content.Context;
import android.location.Address;
import com.byazt.lk.l;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, 5})
public class q implements com.byazt.xl.s {
    public com.byazt.gwu.s qg;
    public String n = "sp_multi_ttadnet_config";
    public Context s = rv.getContext();

    @Override // com.byazt.xl.s
    public Address n(Context context) {
        return null;
    }

    @Override // com.byazt.xl.s
    public String qg() {
        return "openadsdk";
    }

    @Override // com.byazt.xl.s
    public String s() {
        return "android";
    }

    private com.byazt.gwu.s x() {
        if (this.qg == null) {
            this.qg = l.qg(com.byazt.vgx.s.q(), this.n, 0, com.byazt.p001if.n.n());
        }
        return this.qg;
    }

    @Override // com.byazt.xl.s
    public Context getContext() {
        if (this.s == null) {
            this.s = rv.getContext();
        }
        return this.s;
    }

    @Override // com.byazt.xl.s
    public int n() {
        return Integer.parseInt("1371");
    }

    @Override // com.byazt.xl.s
    public int q() {
        return tj.l;
    }

    @Override // com.byazt.xl.s
    public String l() {
        return com.byazt.ehw.l.n();
    }

    @Override // com.byazt.xl.s
    public String n(Context context, String str, String str2) {
        return x().qg(str, str2);
    }

    @Override // com.byazt.xl.s
    public void n(Context context, Map<String, ?> map) {
        try {
            com.byazt.gwu.s sVarX = x();
            if (map != null) {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        sVarX.n(entry.getKey(), ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        sVarX.n(entry.getKey(), ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        sVarX.n(entry.getKey(), ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        sVarX.n(entry.getKey(), ((Boolean) value).booleanValue());
                    } else if (value instanceof String) {
                        sVarX.n(entry.getKey(), (String) value);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.xl.s
    public String[] w() {
        return new String[]{"tnc3-bjlgy.zijieapi.com", "tnc3-alisc1.zijieapi.com", "tnc3-aliec2.zijieapi.com"};
    }
}
