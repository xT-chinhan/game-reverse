package com.byazt.xa;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CODEC_STOP_TIMEOUT, 213})
public class cz extends hn {
    public final Context c;
    public final zo uc;

    public cz(Context context, zo zoVar) {
        super(true, false);
        this.c = context;
        this.uc = zoVar;
    }

    @Override // com.byazt.xa.hn
    public boolean pr(JSONObject jSONObject) throws JSONException, SecurityException {
        TelephonyManager telephonyManager = (TelephonyManager) this.c.getSystemService("phone");
        if (telephonyManager == null) {
            return false;
        }
        try {
            aj.pr(jSONObject, an.P, telephonyManager.getNetworkOperatorName());
            aj.pr(jSONObject, "mcc_mnc", telephonyManager.getNetworkOperator());
            aj.pr(jSONObject, "udid", this.uc.qn() ? com.byazt.ec.fw.pr(telephonyManager) : this.uc.v());
            return true;
        } catch (Exception e) {
            com.byazt.ec.w.hw(e);
            return false;
        }
    }
}
