package com.byazt.yd;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.byazt.hcx.aj;
import com.byazt.hcx.m;
import com.byazt.nn.fw;
import com.byazt.vkw.g;
import com.byazt.vkw.qi;
import com.byazt.zs.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIACODEC_DROP_NONREF, 13})
public class hw implements com.byazt.aq.pr {
    public com.byazt.hh.hw hn;
    public final com.byazt.aq.hw hw;
    public final Context pr;

    public hw(Context context, com.byazt.aq.hw hwVar, com.byazt.hh.hw hwVar2) {
        this.pr = context;
        this.hw = hwVar;
        this.hn = hwVar2;
    }

    @Override // com.byazt.aq.pr
    public void pr(String str, List<String> list, boolean z, Map<String, String> map, JSONObject jSONObject) {
        com.byazt.hh.hn hnVarPr = this.hn.pr();
        if (hnVarPr == null || this.pr == null || !hnVarPr.hw()) {
            return;
        }
        qi qiVar = (qi) uc.pr("thread_service");
        if (list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                qiVar.pr().execute(new pr(new hn(UUID.randomUUID().toString() + "_" + System.currentTimeMillis(), it.next(), z, 5, jSONObject, 1), str, map));
            }
        }
    }

    @Override // com.byazt.aq.pr
    public void pr(final String str) {
        com.byazt.hh.hn hnVarPr = this.hn.pr();
        if (hnVarPr == null || !hnVarPr.hw()) {
            return;
        }
        ((qi) uc.pr("thread_service")).pr().execute(new Runnable() { // from class: com.byazt.yd.hw.1
            @Override // java.lang.Runnable
            public void run() {
                hw.this.pr(hw.this.hw.pr(), str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(List<hn> list, String str) {
        if (list != null && !list.isEmpty()) {
            qi qiVar = (qi) uc.pr("thread_service");
            Iterator<hn> it = list.iterator();
            while (it.hasNext()) {
                qiVar.pr().execute(new pr(it.next(), str, null));
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIACODEC_DROP_NONREF, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    private class pr implements Runnable {
        public final String hn;
        public final hn hw;
        public final Map<String, String> x;

        private pr(hn hnVar, String str, Map<String, String> map) {
            this.hw = hnVar;
            this.hn = str;
            this.x = map;
        }

        private String hn(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (str.contains("{TS}") || str.contains("__TS__")) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    str = str.replace("{TS}", String.valueOf(jCurrentTimeMillis)).replace("__TS__", String.valueOf(jCurrentTimeMillis));
                }
                if ((str.contains("{UID}") || str.contains("__UID__")) && !TextUtils.isEmpty(this.hn)) {
                    return str.replace("{UID}", this.hn).replace("__UID__", this.hn);
                }
                return str;
            }
            return str;
        }

        public boolean pr(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("http://") || str.startsWith("https://");
        }

        public String hw(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return str.replace("[ss_random]", String.valueOf(hw.hw().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
                } catch (Exception e) {
                    return str;
                }
            }
            return str;
        }

        @Override // java.lang.Runnable
        public void run() {
            m mVarPr;
            com.byazt.hh.hn hnVarPr = hw.this.hn.pr();
            if (hnVarPr == null || !hnVarPr.hw()) {
                return;
            }
            String strHn = this.hw.hn();
            if (!pr(strHn)) {
                pr(null, hnVarPr, this.hw, strHn, "not http url");
                return;
            }
            if (this.hw.c() == 0) {
                hw.this.hw.delete(this.hw);
                pr(null, hnVarPr, this.hw, strHn, "retry max");
                return;
            }
            try {
                if (this.hw.c() == 5) {
                    hw.this.hw.insert(this.hw);
                }
                g gVar = (g) uc.pr("device_info_new");
                if (!(((g) uc.pr("device_info_new")).pr(60000L) != 0)) {
                    pr(null, hnVarPr, this.hw, strHn, "no net");
                    return;
                }
                String strHn2 = hn(strHn);
                if (this.hw.x()) {
                    strHn2 = hw(strHn2);
                }
                aj ajVarX = com.byazt.nn.x.x(strHn2);
                if (ajVarX == null) {
                    pr(null, hnVarPr, this.hw, strHn2, "no executor");
                    return;
                }
                ajVarX.pr("User-Agent", gVar.hw(false));
                ajVarX.pr("csj_client_source_from", "1");
                if (this.x != null) {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.x.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                    ajVarX.pr("csj_extra_info", jSONObject.toString());
                }
                try {
                    mVarPr = ajVarX.pr();
                } catch (Throwable th) {
                    mVarPr = null;
                }
                if (mVarPr != null && mVarPr.fw()) {
                    hw.this.hw.delete(this.hw);
                    fw.pr("trackurl", "track success : ".concat(String.valueOf(strHn)));
                } else {
                    if (mVarPr != null && mVarPr.pr() == 8848) {
                        fw.pr("trackurl", "block url : " + mVarPr.hw());
                        hw.this.hw.delete(this.hw);
                    }
                    fw.pr("trackurl", "track fail : ".concat(String.valueOf(strHn)));
                    hn hnVar = this.hw;
                    hnVar.pr(hnVar.c() - 1);
                    if (this.hw.c() == 0) {
                        hw.this.hw.delete(this.hw);
                        fw.pr("trackurl", "track fail and delete : ".concat(String.valueOf(strHn)));
                    } else {
                        hw.this.hw.update(this.hw);
                    }
                }
                pr(mVarPr, hnVarPr, this.hw, strHn2, null);
            } catch (Throwable th2) {
            }
        }

        private void pr(m mVar, com.byazt.hh.hn hnVar, hn hnVar2, String str, String str2) {
            try {
                hnVar.pr(this.hw.pr(), pr(mVar, hnVar2, str, str2));
            } catch (Exception e) {
            }
        }

        private JSONObject pr(m mVar, hn hnVar, String str, String str2) {
            JSONObject jSONObject = new JSONObject();
            if (hnVar == null) {
                return jSONObject;
            }
            try {
                jSONObject.put("retry_count", 5 - hnVar.c());
                JSONObject jSONObjectPr = hnVar.pr();
                if (jSONObjectPr != null) {
                    jSONObject.put("track_type", jSONObjectPr.optString("track_type", ""));
                }
                jSONObject.put(BreakpointSQLiteKey.URL, str);
                jSONObject.put("current", System.currentTimeMillis());
                jSONObject.put(Constants.ERROR_MSG_FIELD, str2);
                if (mVar != null) {
                    jSONObject.put("http_code", mVar.pr());
                    String strZo = mVar.zo();
                    if (!TextUtils.isEmpty(strZo)) {
                        if (strZo.length() > 5000) {
                            strZo = strZo.substring(0, 5000);
                        }
                        jSONObject.put("http_response", strZo);
                    }
                    jSONObject.put(TrackAction.SUCCESS, mVar.fw() ? 1 : 0);
                }
            } catch (JSONException e) {
            }
            return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Random hw() {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                return SecureRandom.getInstanceStrong();
            } catch (Throwable th) {
                return new SecureRandom();
            }
        }
        return new SecureRandom();
    }
}
