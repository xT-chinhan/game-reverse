package com.bytedance.sdk.component.x.xr.ka;

import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.x.ms.d;
import com.bytedance.sdk.component.x.ms.ka;
import com.bytedance.sdk.component.x.ms.ms.c;
import com.bytedance.sdk.component.x.ms.x;
import com.bytedance.sdk.component.x.xr.ah.ah;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements com.bytedance.sdk.component.x.ms.ms.ms<com.bytedance.sdk.component.x.ms.xr> {
    private static final SimpleDateFormat xr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    private ka d;
    private final String ah = "x-pglcypher";

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final boolean f1555ms = xr();

    private String xr(int i) {
        return i >= 4 ? "application/octet-stream" : "application/octet-stream;tt-data=a";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ka ms() {
        if (this.d == null) {
            this.d = com.bytedance.sdk.component.x.xr.ms.ah("csj").ah();
        }
        return this.d;
    }

    public static byte[] xr(JSONObject jSONObject) {
        return jSONObject == null ? new byte[0] : jSONObject.toString().getBytes(StandardCharsets.UTF_8);
    }

    private static boolean xr() {
        try {
            return new File("/system/bin/su").exists() || new File("/system/xbin/su").exists();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.x.ms.ms.ms
    public com.bytedance.sdk.component.x.xr.xr.ah.ms ms(List<com.bytedance.sdk.component.x.ms.xr> list) {
        x xVarU;
        com.bytedance.sdk.component.x.xr.xr.ah.ms msVarMs;
        String strC;
        d dVarD = ms().d();
        Object[] objArr = null;
        Object[] objArr2 = 0;
        Object[] objArr3 = null;
        if (dVarD != null) {
            int i = 0;
            try {
                if (dVarD.ka() && (xVarU = dVarD.u()) != null && list != null && !list.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    String str = "1streqid";
                    String strC2 = "2ndreqid";
                    String str2 = "";
                    int i2 = 0;
                    for (com.bytedance.sdk.component.x.ms.xr xrVar : list) {
                        try {
                            if (TextUtils.equals("show", com.bytedance.sdk.component.x.xr.ah.ms.ms(xrVar, ms()))) {
                                String strMs = com.bytedance.sdk.component.x.xr.ah.ms.ms(xrVar.ab(), this.d);
                                if (i2 == 0) {
                                    strC = com.bytedance.sdk.component.x.xr.ah.ms.c(xrVar, this.d);
                                } else {
                                    strC2 = com.bytedance.sdk.component.x.xr.ah.ms.c(xrVar, this.d);
                                    strC = strC2;
                                }
                                str2 = strMs;
                                str = strC;
                                i2 = 1;
                            }
                            arrayList.add(xrVar);
                        } catch (Throwable th) {
                            th = th;
                            i = i2;
                            try {
                                ah.ah("NetApiImpl", "uploadEvent error" + th.getMessage(), ms());
                                return new com.bytedance.sdk.component.x.xr.xr.ah.ms(false, MediaPlayer.MEDIA_PLAYER_OPTION_MODULE_NAME, th.getMessage(), false, "error");
                            } finally {
                                if (i != 0 && 0 != 0) {
                                    int length = objArr.length;
                                }
                            }
                        }
                    }
                    int iCh = xVarU.ch();
                    if (arrayList.isEmpty()) {
                        return null;
                    }
                    JSONObject jSONObjectMs = xVarU.ms(xr(arrayList), this.f1555ms);
                    byte[] bArrMs = xVarU.ms(jSONObjectMs, iCh);
                    if (bArrMs == null) {
                        JSONObject jSONObjectMs2 = xVarU.ms(jSONObjectMs);
                        bArrMs = xr(jSONObjectMs2);
                        msVarMs = ms(bArrMs, d(jSONObjectMs2), "application/json; charset=utf-8");
                    } else {
                        msVarMs = ms(bArrMs, ms(iCh), xr(iCh));
                    }
                    if (i2 != 0) {
                        int length2 = bArrMs != null ? bArrMs.length : 0;
                        if (msVarMs != null) {
                            com.bytedance.sdk.component.x.xr.ah.ms.ms(msVarMs.f1582ms, msVarMs.xr, msVarMs.ah, str + "|" + strC2, length2, str2);
                        }
                    }
                    return msVarMs;
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    public List<com.bytedance.sdk.component.x.ms.xr> xr(List<com.bytedance.sdk.component.x.ms.xr> list) {
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.sdk.component.x.ms.xr xrVar : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObjectAb = xrVar.ab();
                String strOptString = jSONObjectAb.optString(TTDownloadField.TT_LABEL);
                if (TextUtils.isEmpty(strOptString)) {
                    strOptString = jSONObjectAb.optString(NotificationCompat.CATEGORY_EVENT);
                }
                jSONObject.putOpt(NotificationCompat.CATEGORY_EVENT, strOptString);
                long jOptLong = jSONObjectAb.optLong("event_ts", System.currentTimeMillis());
                jSONObject.putOpt("local_time_ms", Long.valueOf(jOptLong));
                jSONObject.putOpt("datetime", xr.format(new Date(jOptLong)));
                JSONObject jSONObject2 = new JSONObject();
                if (jSONObjectAb.has("params") && jSONObjectAb.has(NotificationCompat.CATEGORY_EVENT)) {
                    jSONObject2 = jSONObjectAb.optJSONObject("params");
                } else {
                    Iterator<String> itKeys = jSONObjectAb.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (!TextUtils.equals(next, TTDownloadField.TT_LABEL)) {
                            jSONObject2.putOpt(next, jSONObjectAb.opt(next));
                        }
                    }
                }
                jSONObject.putOpt("params", jSONObject2);
                com.bytedance.sdk.component.x.xr.d.ms.ms msVar = new com.bytedance.sdk.component.x.xr.d.ms.ms(xrVar.ah(), jSONObject);
                msVar.ms(xrVar.d());
                msVar.xr(xrVar.ka());
                arrayList.add(msVar);
            } catch (Exception e) {
                ah.ah(e.getMessage(), ms());
            }
        }
        return arrayList;
    }

    private Map<String, String> ms(int i) {
        HashMap map = new HashMap();
        if (i >= 4) {
            map.put("Content-Encoding", "union_sdk_encode");
            map.put("x-pglcypher", String.valueOf(i));
        }
        map.put("Content-Type", xr(i));
        return map;
    }

    private Map<String, String> d(JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put("Content-Type", "application/json; charset=utf-8");
        if (c(jSONObject)) {
            map.put("Content-Encoding", "union_sdk_encode");
        }
        return map;
    }

    private com.bytedance.sdk.component.x.xr.xr.ah.ms ms(byte[] bArr, Map<String, String> map, String str) {
        int iKa;
        boolean zAh;
        boolean z;
        String str2;
        try {
            d dVarD = ms().d();
            x xVarU = dVarD.u();
            c cVarKa = xVarU.ka();
            cVarKa.ms(xVarU.c());
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    cVarKa.ms(entry.getKey(), entry.getValue());
                }
            }
            cVarKa.ms(str, bArr);
            cVarKa.ms("User-Agent", dVarD.hi());
            com.bytedance.sdk.component.x.ms.ms.ka kaVarMs = cVarKa.ms();
            if (kaVarMs == null) {
                return new com.bytedance.sdk.component.x.xr.xr.ah.ms(false, MediaPlayer.MEDIA_PLAYER_OPTION_LICENSE_DIR, "RSP IS NULL", false, "error");
            }
            boolean z2 = false;
            if (kaVarMs == null || !kaVarMs.ms() || TextUtils.isEmpty(kaVarMs.xr())) {
                iKa = 0;
                zAh = false;
            } else {
                JSONObject jSONObject = new JSONObject(kaVarMs.xr());
                zAh = ah(jSONObject);
                iKa = ka(jSONObject);
            }
            int iAh = kaVarMs.ah();
            String str3 = kaVarMs.ka() != null ? kaVarMs.ka().get("x-tt-logid") : "error";
            boolean z3 = !zAh && iAh == 200;
            String strD = kaVarMs.d();
            if (strD == null || TextUtils.isEmpty(strD)) {
                strD = "DEFAULT OK";
            }
            if (iKa != 0) {
                str2 = "RSP FAIL";
                z = true;
            } else {
                z2 = zAh;
                iKa = iAh;
                z = z3;
                str2 = strD;
            }
            xr(bArr, map, str);
            return new com.bytedance.sdk.component.x.xr.xr.ah.ms(z2, iKa, str2, z, str3);
        } catch (Throwable th) {
            ah.ah("NetApiImpl", "uploadEvent error" + th.getMessage(), ms());
            return new com.bytedance.sdk.component.x.xr.xr.ah.ms(false, 511, th.getMessage(), false, "error");
        }
    }

    private void xr(byte[] bArr, Map<String, String> map, String str) {
        ka kaVarMs;
        d dVarD;
        x xVarU;
        if (bArr == null || bArr.length == 0 || (kaVarMs = ms()) == null || (dVarD = kaVarMs.d()) == null || (xVarU = dVarD.u()) == null || !xVarU.ms()) {
            return;
        }
        c cVarKa = xVarU.ka();
        cVarKa.ms(xVarU.xr());
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                cVarKa.ms(entry.getKey(), entry.getValue());
            }
        }
        cVarKa.ms(str, bArr);
        cVarKa.ms("User-Agent", dVarD.hi());
        cVarKa.ms(new com.bytedance.sdk.component.x.ms.ms.ah() { // from class: com.bytedance.sdk.component.x.xr.ka.ms.1
            @Override // com.bytedance.sdk.component.x.ms.ms.ah
            public void ms(com.bytedance.sdk.component.x.ms.ms.d dVar, com.bytedance.sdk.component.x.ms.ms.ka kaVar) {
                if (kaVar == null || !kaVar.ms()) {
                    ms.this.ms();
                } else {
                    kaVar.xr();
                    ms.this.ms();
                }
            }

            @Override // com.bytedance.sdk.component.x.ms.ms.ah
            public void ms(com.bytedance.sdk.component.x.ms.ms.d dVar, IOException iOException) {
                iOException.getMessage();
                ms.this.ms();
            }
        });
    }

    public boolean ah(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return jSONObject.optString("message").equalsIgnoreCase("success");
        } catch (Throwable unused) {
            return false;
        }
    }

    private static PublicKey ah() throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKtjHB7PDkflFl5bX4x/25mE9x2/C6kd\n8wVgzXFiC67Jx+meptu1hL54XgnPnI+AvxXhEgN/+DZUmrRPdvB+UZECAwEAAQ==".getBytes(Charset.forName("UTF-8")), 2)));
    }

    private boolean ms(String str, String str2) throws Exception {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(ah().getEncoded()));
        Signature signature = Signature.getInstance("Sha1withRSA");
        signature.initVerify(publicKeyGeneratePublic);
        signature.update(str.getBytes());
        return signature.verify(Base64.decode(str2.getBytes(Charset.forName("UTF-8")), 2));
    }

    private int ka(JSONObject jSONObject) {
        int iIndexOf;
        if (jSONObject == null) {
            return 0;
        }
        try {
            String strOptString = jSONObject.optString("s_sig_ts");
            if (strOptString == null || (iIndexOf = strOptString.indexOf("_")) < 5) {
                return 512;
            }
            String strSubstring = strOptString.substring(0, iIndexOf);
            String strSubstring2 = strOptString.substring(iIndexOf + 1);
            JSONObject jSONObjectNy = ms().d().u().ny();
            if (ms((jSONObjectNy != null ? jSONObjectNy.optString("device_id") : "") + "_" + strSubstring, strSubstring2)) {
                return Math.abs((System.currentTimeMillis() / 1000) - Long.valueOf(strSubstring).longValue()) > 300 ? 513 : 0;
            }
            return 512;
        } catch (Throwable unused) {
            return 512;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.x.ms.ms.ms
    public com.bytedance.sdk.component.x.xr.xr.ah.ms ms(JSONObject jSONObject) {
        x xVarU;
        int i;
        boolean z;
        String str;
        boolean z2;
        int i2;
        int i3;
        d dVarD = ms().d();
        if (dVarD == null || !dVarD.ka() || jSONObject == null || jSONObject.length() <= 0 || (xVarU = dVarD.u()) == null) {
            return null;
        }
        c cVarKa = xVarU.ka();
        cVarKa.ms(xVarU.ab());
        int iCh = xVarU.ch();
        byte[] bArrXr = xVarU.xr(jSONObject, iCh);
        if (bArrXr == null) {
            cVarKa.xr(xVarU.ms(jSONObject).toString());
        } else {
            cVarKa.ms(xr(iCh), bArrXr);
            cVarKa.ms("x-pglcypher", String.valueOf(iCh));
        }
        cVarKa.ms("User-Agent", dVarD.hi());
        String strD = "error unknown";
        int iAh = 0;
        try {
            com.bytedance.sdk.component.x.ms.ms.ka kaVarMs = cVarKa.ms();
            if (kaVarMs == null) {
                return new com.bytedance.sdk.component.x.xr.xr.ah.ms(false, 0, "error unknown", false, "ignore");
            }
            if (!kaVarMs.ms() || TextUtils.isEmpty(kaVarMs.xr())) {
                i3 = 0;
                z = false;
            } else {
                JSONObject jSONObject2 = new JSONObject(kaVarMs.xr());
                int iOptInt = jSONObject2.optInt("code", -1);
                strD = jSONObject2.optString("data", "");
                z = true;
                i3 = iOptInt == 20000 ? 1 : 0;
                if (iOptInt != 60005) {
                    z = false;
                }
            }
            try {
                iAh = kaVarMs.ah();
                if (!kaVarMs.ms()) {
                    strD = kaVarMs.d();
                }
                str = strD;
                i2 = iAh;
                z2 = i3;
            } catch (Throwable unused) {
                i = iAh;
                iAh = i3;
                str = strD;
                z2 = iAh;
                i2 = i;
            }
            return new com.bytedance.sdk.component.x.xr.xr.ah.ms(z2, i2, str, z, "ignore");
        } catch (Throwable unused2) {
            i = 0;
            z = false;
        }
    }

    private boolean c(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() > 0;
    }
}
