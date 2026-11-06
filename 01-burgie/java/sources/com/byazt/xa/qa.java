package com.byazt.xa;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CODEC_STOP_TIMEOUT, 101})
public class qa extends hn {
    public final Context c;

    public qa(Context context) {
        super(true, false);
        this.c = context;
    }

    @Override // com.byazt.xa.hn
    public boolean pr(JSONObject jSONObject) throws JSONException {
        PackageInfo packageInfo;
        Signature signature;
        String strHw = null;
        try {
            packageInfo = this.c.getPackageManager().getPackageInfo(this.c.getPackageName(), 64);
        } catch (Throwable th) {
            com.byazt.ec.w.hw(th);
            packageInfo = null;
        }
        if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0 && (signature = packageInfo.signatures[0]) != null) {
            strHw = com.byazt.ec.hn.hw(signature.toByteArray());
        }
        if (strHw != null) {
            jSONObject.put("sig_hash", strHw);
            return true;
        }
        return true;
    }
}
