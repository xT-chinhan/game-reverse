package com.byazt.jx;

import android.text.TextUtils;
import com.byazt.lm.ho;
import com.byazt.vkw.nt;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.tapsdk.tapad.group.constants.Constants;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC, 62})
public class fw implements x {
    public hn pr;

    public fw(hn hnVar) {
        this.pr = hnVar;
    }

    @Override // com.byazt.jx.x
    public boolean pr(final com.byazt.vo.pr prVar) {
        if (!this.pr.hn()) {
            return false;
        }
        long jX = this.pr.x();
        final com.byazt.rkl.hw hwVarPr = ho.pr();
        if (hwVarPr == null || !pr(1440L, this.pr.fw())) {
            return false;
        }
        com.byazt.ca.aj.pr().postDelayed(new Runnable() { // from class: com.byazt.jx.fw.1
            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap();
                map.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, prVar.pr());
                map.put("app_icon_url", prVar.hw());
                map.put("event_id", Integer.valueOf(prVar.x()));
                map.put("package_name", prVar.hn());
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt(Constants.VALUE_FIELD, prVar.zo());
                    jSONObject.putOpt("log_extra", prVar.c());
                    jSONObject.putOpt("tag", prVar.fw());
                    jSONObject.putOpt("download_url", prVar.vk());
                    jSONObject.putOpt("save_path", prVar.aj());
                } catch (Exception e) {
                }
                boolean zHw = ls.hw(prVar.hn());
                map.put("event_token", ((nt) com.byazt.zs.uc.pr("encrypt_service")).hn(jSONObject.toString()));
                hwVarPr.pr(zHw ? 102 : 101, map);
            }
        }, jX * 1000);
        return true;
    }

    @Override // com.byazt.jx.x
    public boolean hw(com.byazt.vo.pr prVar) {
        return false;
    }

    public boolean pr(long j, int i) {
        try {
            Long lValueOf = -1L;
            boolean z = true;
            try {
                lValueOf = Long.valueOf(j * 60 * 1000);
            } catch (Exception e) {
                Object[] objArr = {"error", e.getMessage()};
                i = -1;
            }
            if (lValueOf.longValue() >= 0 && i >= 0 && lValueOf.longValue() != 0 && i != 0) {
                String strPr = pr();
                StringBuilder sb = new StringBuilder();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (TextUtils.isEmpty(strPr)) {
                    sb.append(jCurrentTimeMillis);
                    pr(sb.toString());
                    return true;
                }
                String[] strArrSplit = strPr.split("_");
                int length = strArrSplit.length;
                if (length < i) {
                    Long.parseLong(strArrSplit[length - 1]);
                    for (String str : strArrSplit) {
                        sb.append(str).append("_");
                    }
                    sb.append(jCurrentTimeMillis);
                    pr(sb.toString());
                    return true;
                }
                int i2 = length - i;
                if (jCurrentTimeMillis - Long.valueOf(Long.parseLong(strArrSplit[i2])).longValue() <= lValueOf.longValue()) {
                    z = false;
                }
                for (int i3 = i2; i3 < length; i3++) {
                    String str2 = strArrSplit[i3];
                    if (i3 != i2 && !TextUtils.isEmpty(str2)) {
                        sb.append(str2).append("_");
                    }
                }
                sb.append(jCurrentTimeMillis);
                pr(sb.toString());
                return z;
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    public static String pr() {
        return com.byazt.sd.hw.pr().hw("notification_b", "");
    }

    public static void pr(String str) {
        com.byazt.sd.hw.pr().pr("notification_b", str);
    }
}
