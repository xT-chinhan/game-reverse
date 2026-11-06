package com.byazt.xa;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.db.constant.Common;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CODEC_STOP_TIMEOUT, 19})
public class ho extends hn {
    public final Context c;
    public final zo uc;

    public ho(Context context, zo zoVar) {
        super(false, false);
        this.c = context;
        this.uc = zoVar;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0026  */
    @Override // com.byazt.xa.hn
    public boolean pr(JSONObject jSONObject) throws JSONException {
        String strIi;
        String string;
        try {
            zo zoVar = this.uc;
            if (zoVar != null) {
                if (zoVar.of()) {
                    strIi = Settings.Secure.getString(this.c.getContentResolver(), Common.Predefined.SUB_ANDROID_ID);
                } else {
                    strIi = this.uc.ii();
                    if (TextUtils.isEmpty(strIi)) {
                        strIi = null;
                    }
                }
            } else {
                strIi = null;
            }
        } catch (Exception e) {
            com.byazt.ec.w.hn("", e);
            strIi = null;
        }
        if (!aj.pr(strIi) || "9774d56d682e549c".equals(strIi)) {
            SharedPreferences sharedPreferencesHw = com.byazt.mg.hw.hw(this.c, "snssdk_openudid", 0);
            String strHw = uc.hw(sharedPreferencesHw.getString("custom_b", null));
            if (!TextUtils.isEmpty(strHw)) {
                string = strHw;
            } else {
                string = sharedPreferencesHw.getString("openudid", null);
            }
            if (aj.pr(string)) {
                strIi = string;
            } else {
                String string2 = new BigInteger(64, new SecureRandom()).toString(16);
                if (string2.charAt(0) == '-') {
                    string2 = string2.substring(1);
                }
                int length = 13 - string2.length();
                if (length > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (length > 0) {
                        sb.append('F');
                        length--;
                    }
                    sb.append(string2);
                    string2 = sb.toString();
                }
                try {
                    string2 = pr("openudid.dat", string2);
                } catch (Exception e2) {
                }
                String strPr = uc.pr(string2);
                SharedPreferences.Editor editorEdit = sharedPreferencesHw.edit();
                editorEdit.putString("custom_b", strPr);
                editorEdit.apply();
                strIi = string2;
            }
        }
        jSONObject.put("openudid", strIi);
        return true;
    }
}
