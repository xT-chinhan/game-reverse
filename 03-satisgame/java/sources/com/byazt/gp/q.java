package com.byazt.gp;

import android.text.TextUtils;
import android.util.Base64;
import com.anythink.core.common.b.e;
import com.anythink.core.e.d;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 80, 5})
public class q {
    public static volatile q n;
    public volatile Key qg;

    private q() {
        try {
            this.qg = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(com.byazt.qt.qg.n().ic(), 0)));
        } catch (Exception unused) {
        }
    }

    public static q n() {
        if (n == null) {
            synchronized (q.class) {
                if (n == null) {
                    n = new q();
                }
            }
        }
        return n;
    }

    public String n(byte[] bArr) throws Exception {
        byte[] bArrDoFinal;
        if (bArr == null) {
            return null;
        }
        Key keyQg = qg();
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, keyQg);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = length - i;
            if (i3 > 0) {
                if (i3 > 117) {
                    bArrDoFinal = cipher.doFinal(bArr, i, 117);
                } else {
                    bArrDoFinal = cipher.doFinal(bArr, i, i3);
                }
                byteArrayOutputStream.write(bArrDoFinal, 0, bArrDoFinal.length);
                i2++;
                i = i2 * 117;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return Base64.encodeToString(byteArray, 2);
            }
        }
    }

    private Key qg() throws Exception {
        Key keyGeneratePublic;
        Key key = this.qg;
        if (key != null) {
            return key;
        }
        synchronized (this) {
            keyGeneratePublic = this.qg;
            if (keyGeneratePublic == null) {
                keyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(com.byazt.qt.qg.n().ic(), 0)));
                this.qg = keyGeneratePublic;
            }
        }
        return keyGeneratePublic;
    }

    public String n(com.byazt.sg.s sVar) {
        if (sVar == null || MediationConstant.ADN_PANGLE.equals(sVar.lq())) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            n(jSONObject, sVar);
            n(jSONObject, l.n(sVar.lq(), sVar.rf()));
        } catch (JSONException unused) {
        }
        if (jSONObject.length() <= 0) {
            return null;
        }
        try {
            return n(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
        } catch (Exception unused2) {
            return null;
        }
    }

    private void n(JSONObject jSONObject, com.byazt.sg.s sVar) throws JSONException {
        if (jSONObject == null || sVar == null) {
            return;
        }
        n(jSONObject, "t", sVar.ca());
        n(jSONObject, d.a, sVar.tr());
        n(jSONObject, "ic_u", sVar.eq());
        n(jSONObject, "im_u", sVar.ox());
        n(jSONObject, "v_u", sVar.x());
        n(jSONObject, "an", sVar.fl());
        n(jSONObject, "p_n", sVar.jh());
        n(jSONObject, "b_t", sVar.lg());
        n(jSONObject, e.a, sVar.ta());
        n(jSONObject, "v_d", sVar.on());
        n(jSONObject, "aun", sVar.i());
        n(jSONObject, "p_s", sVar.dw());
        n(jSONObject, "p_u", sVar.su());
        n(jSONObject, "v_n", sVar.g());
        n(jSONObject, "d_u", sVar.sh());
        JSONArray jSONArray = new JSONArray();
        List<String> listQh = sVar.qh();
        if (listQh != null && !listQh.isEmpty()) {
            Iterator<String> it = listQh.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
        }
        n(jSONObject, "image_list", jSONArray.toString());
    }

    private void n(JSONObject jSONObject, Map<String, Object> map) throws JSONException {
        Object value;
        boolean z;
        if (jSONObject == null || map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry != null && !TextUtils.isEmpty(entry.getKey()) && entry.getValue() != null && (!((z = (value = entry.getValue()) instanceof String)) || !TextUtils.isEmpty((String) value))) {
                if (z || (value instanceof Number) || (value instanceof Boolean)) {
                    n(jSONObject, entry.getKey(), String.valueOf(value));
                }
            }
        }
    }

    private void n(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (jSONObject == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.putOpt(str, str2);
    }

    private void n(JSONObject jSONObject, String str, double d) throws JSONException {
        if (Double.isNaN(d) || Double.isInfinite(d) || d <= 0.0d) {
            return;
        }
        n(jSONObject, str, String.valueOf(d));
    }

    private void n(JSONObject jSONObject, String str, long j) throws JSONException {
        if (j <= 0) {
            return;
        }
        n(jSONObject, str, String.valueOf(j));
    }
}
