package com.byazt.xa;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.bumptech.glide.load.Key;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CODEC_STOP_TIMEOUT, 5})
public class uc extends hn {
    public final Context c;

    public uc(Context context) {
        super(false, false);
        this.c = context;
    }

    @Override // com.byazt.xa.hn
    public boolean pr(JSONObject jSONObject) throws JSONException {
        SharedPreferences sharedPreferencesHw = com.byazt.mg.hw.hw(this.c, "snssdk_openudid", 0);
        String strHw = hw(sharedPreferencesHw.getString("custom_a", null));
        if (TextUtils.isEmpty(strHw)) {
            strHw = sharedPreferencesHw.getString("clientudid", null);
        }
        if (!aj.pr(strHw)) {
            try {
                strHw = UUID.randomUUID().toString();
                strHw = pr("clientudid.dat", strHw);
            } catch (Exception e) {
            }
            String strPr = pr(strHw);
            SharedPreferences.Editor editorEdit = sharedPreferencesHw.edit();
            editorEdit.putString("custom_a", strPr);
            editorEdit.apply();
        }
        jSONObject.put("clientudid", strHw);
        return true;
    }

    public static String pr(String str) {
        if (!TextUtils.isEmpty(str) && Build.VERSION.SDK_INT >= 8) {
            try {
                return Base64.encodeToString(str.getBytes(Key.STRING_CHARSET_NAME), 0);
            } catch (UnsupportedEncodingException e) {
            }
        }
        return str;
    }

    public static String hw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 8) {
            try {
                return new String(Base64.decode(str.getBytes(Key.STRING_CHARSET_NAME), 0));
            } catch (UnsupportedEncodingException e) {
            }
        }
        return str;
    }
}
