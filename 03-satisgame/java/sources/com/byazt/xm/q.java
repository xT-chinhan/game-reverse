package com.byazt.xm;

import android.os.Bundle;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 5})
public class q {
    public static Bundle n(com.byazt.fd.n nVar) {
        Bundle bundle = new Bundle();
        if (nVar == null) {
            return bundle;
        }
        float fQg = nVar.qg();
        String strS = nVar.s();
        Map<String, Object> mapQ = nVar.q();
        if (mapQ == null) {
            mapQ = new HashMap<>();
        }
        Object obj = mapQ.get(MediationConstant.KEY_EXTRA_INFO);
        if (obj instanceof Bundle) {
            Bundle bundle2 = (Bundle) obj;
            bundle2.putFloat("reward_extra_key_reward_amount", fQg);
            bundle2.putString("reward_extra_key_reward_name", strS);
            return bundle2;
        }
        bundle.putString("reward_extra_key_reward_name", strS);
        bundle.putFloat("reward_extra_key_reward_amount", fQg);
        Object obj2 = mapQ.get(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY);
        if (obj2 instanceof Boolean) {
            bundle.putBoolean(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY, ((Boolean) obj2).booleanValue());
        }
        Object obj3 = mapQ.get("transId");
        if (obj3 instanceof String) {
            bundle.putString("transId", (String) obj3);
        }
        Object obj4 = mapQ.get(MediationConstant.KEY_REASON);
        if (obj4 instanceof Integer) {
            bundle.putInt(MediationConstant.KEY_REASON, ((Integer) obj4).intValue());
        }
        Object obj5 = mapQ.get("gromoreExtra");
        if (obj5 instanceof String) {
            bundle.putString("gromoreExtra", (String) obj5);
        }
        Object obj6 = mapQ.get(MediationConstant.KEY_ERROR_CODE);
        if (obj6 instanceof Integer) {
            bundle.putInt(MediationConstant.KEY_ERROR_CODE, ((Integer) obj6).intValue());
        }
        Object obj7 = mapQ.get(MediationConstant.KEY_ERROR_MSG);
        if (obj7 instanceof String) {
            bundle.putString(MediationConstant.KEY_ERROR_MSG, (String) obj7);
        }
        Object obj8 = mapQ.get(MediationConstant.KEY_ADN_NAME);
        if (!(obj8 instanceof String)) {
            return bundle;
        }
        bundle.putString(MediationConstant.KEY_ADN_NAME, (String) obj8);
        return bundle;
    }
}
