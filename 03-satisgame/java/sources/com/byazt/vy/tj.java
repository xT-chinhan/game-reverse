package com.byazt.vy;

import android.text.TextUtils;
import android.util.Base64;
import com.anythink.core.common.l.f;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;
import javax.crypto.Cipher;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1431, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj {
    public static boolean n() {
        Map<String, Object> mapHu = com.byazt.qt.n.d().hu();
        Map<String, Object> mapM = com.byazt.qt.n.d().m();
        if (mapHu != null) {
            try {
                if (mapHu.get("eefo") instanceof Boolean) {
                    return ((Boolean) mapHu.get("eefo")).booleanValue();
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        if (mapM == null || !(mapM.get("eefo") instanceof Boolean)) {
            return false;
        }
        return ((Boolean) mapM.get("eefo")).booleanValue();
    }

    public static String n(com.byazt.mj.s sVar) {
        if (sVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MediationConstant.EXTRA_ADN_NAME, sVar.rv());
            jSONObject.put("custom_adn_name", sVar.tj());
            jSONObject.put("slot_id", sVar.cp());
            jSONObject.put("level_tag", sVar.k());
            jSONObject.put("ecpm", sVar.oa());
            jSONObject.put("bidding_type", sVar.cy());
            jSONObject.put("error_msg", sVar.hd());
            jSONObject.put("request_id", sVar.cd());
            jSONObject.put("ad_rit_type", sVar.qg());
            jSONObject.put("ad_sub_rit_type", sVar.s());
            jSONObject.put("segment_id", sVar.q());
            jSONObject.put(f.J, sVar.x());
            jSONObject.put("channel", sVar.l());
            jSONObject.put("sub_channel", sVar.w());
            jSONObject.put("scenario_id", sVar.fs());
        } catch (JSONException unused) {
        }
        String string = jSONObject.toString();
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            String strN = n(16);
            String strQg = qg(string, strN);
            String strN2 = n(strN, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA7aAsZzOAmVVuIl0EZtpY\nPkJGdr82VIOzPBDYNEOBK0tfk/oSWyY8yZDpeYuhNuSPySmhaN8Apn3HGfL1Eq6t\nSE3OdAovRJjnilU/5ugSM/nr5yMy6WRvJUskvQ9F3PF9MLez8ZJxVDb4tgUXjq2S\n1QKSP+NwAKdY+P/H8SD5evamqCpvzO1IwpqznNI2HGAo/Kdm5OQ+Yq47A31dDUSH\nVF/TTzTfae8j6lanqgz9DmFs+kqoy253aXlz8H0z8J3VpmOGvnOUiS00Hg5SILV0\nsoXtS9JKK/V3gXmbXWyFvZhuIvLqk3C8AdyZuDdy1GAI3GjI4wjtiMd11zSTECrV\ntQIDAQAB");
            return String.format("%04d", Integer.valueOf(strN2.length())) + strN2 + strQg;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static String n(String str, String str2) {
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str2, 0)));
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(1, publicKeyGeneratePublic);
            return Base64.encodeToString(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)), 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String qg(String str, String str2) {
        try {
            return n.n(str.getBytes(StandardCharsets.UTF_8), str2);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String n(int i) {
        StringBuilder sb = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i2 = 0; i2 < i; i2++) {
            int iNextInt = secureRandom.nextInt(3);
            if (iNextInt == 0) {
                sb.append(secureRandom.nextInt(10));
            } else if (iNextInt == 1) {
                sb.append((char) (secureRandom.nextInt(25) + 65));
            } else if (iNextInt == 2) {
                sb.append((char) (secureRandom.nextInt(25) + 97));
            }
        }
        return sb.toString();
    }
}
