package com.byazt.fp;

import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.byazt.vkw.nt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.JProtect;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.db.constant.Common;
import java.lang.reflect.Field;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.UByte;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, 13})
public class hw {
    public static pr c;
    public static volatile String uc;
    public static AtomicBoolean pr = new AtomicBoolean(false);
    public static final Map<String, String> hw = new ConcurrentHashMap();
    public static volatile long hn = 0;
    public static final AtomicBoolean x = new AtomicBoolean(false);

    public interface pr {
        void hw(String str);

        void pr(String str);
    }

    public static void pr(pr prVar) {
        c = prVar;
    }

    @JProtect
    public static String pr(com.byazt.vkw.pr prVar, boolean z, com.byazt.vlp.x xVar) {
        String str;
        Map<String, String> mapPr = pr(false, prVar, z, xVar);
        if (mapPr == null) {
            str = "";
        } else {
            str = mapPr.get("mac");
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private static Map<String, String> pr(boolean z, com.byazt.vkw.pr prVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() + 300000;
        if (!z) {
            if (pr.get()) {
                hn = 0L;
                pr.set(false);
            }
            if (jElapsedRealtime - hn < 300000) {
                x.set(true);
                return hw;
            }
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                hn = jElapsedRealtime;
                x.set(true);
                return null;
            }
            HashMap map = new HashMap();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (networkInterfaceNextElement != null) {
                    map.put(networkInterfaceNextElement.getName(), networkInterfaceNextElement);
                }
            }
            hw(map, prVar);
            pr(map, prVar);
            hn = jElapsedRealtime;
            x.set(true);
            return hw;
        } catch (Throwable th) {
        }
    }

    public static Map<String, String> pr(boolean z, com.byazt.vkw.pr prVar, boolean z2, com.byazt.vlp.x xVar) {
        Map<String, String> mapPr;
        if (!hn(prVar, z2, xVar)) {
            return hw;
        }
        if (x.get()) {
            return pr(z, prVar);
        }
        synchronized (hw.class) {
            mapPr = pr(z, prVar);
        }
        return mapPr;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x006d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0073 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x007c  */
    /* JADX WARN: Code duplicated, block: B:44:0x009c  */
    /* JADX WARN: Code duplicated, block: B:53:0x00b7  */
    @JProtect
    public static String[] pr(boolean z, AtomicBoolean atomicBoolean, com.byazt.vkw.pr prVar, boolean z2, com.byazt.vlp.x xVar) {
        long j;
        String strX;
        String strX2;
        String str;
        String[] strArrUc;
        String[] strArr = {"", ""};
        String strPr = zo.pr(prVar);
        long j2 = 0;
        try {
            if (TextUtils.isEmpty(strPr)) {
                j = 0;
                strX2 = null;
            } else {
                JSONObject jSONObject = new JSONObject(strPr);
                strX2 = ((nt) com.byazt.zs.uc.pr("encrypt_service")).x(jSONObject.getString(Constants.VALUE_FIELD));
                try {
                    j = jSONObject.getLong("time");
                } catch (JSONException e) {
                    j = 0;
                    strX = null;
                    if (strX2 == null) {
                        strArr[0] = strX2;
                        strArr[1] = strX;
                        if (z) {
                            return strArr;
                        }
                    } else {
                        strArr[0] = strX2;
                        strArr[1] = strX;
                        if (z) {
                            return strArr;
                        }
                    }
                    if (atomicBoolean.getAndSet(false)) {
                        strArrUc = uc(prVar, z2, xVar);
                        return !TextUtils.isEmpty(strArrUc[0]) ? strArrUc : strArrUc;
                    }
                    if (strX2 != null) {
                        strX2 = null;
                    }
                    if (strX != null) {
                    }
                    if (TextUtils.isEmpty(strX2)) {
                    }
                    strArr[0] = strX2;
                    strArr[1] = str;
                    return strArr;
                }
            }
            try {
                String strHw = zo.hw(prVar);
                if (TextUtils.isEmpty(strHw)) {
                    strX = null;
                } else {
                    JSONObject jSONObject2 = new JSONObject(strHw);
                    strX = ((nt) com.byazt.zs.uc.pr("encrypt_service")).x(jSONObject2.getString(Constants.VALUE_FIELD));
                    try {
                        j2 = jSONObject2.getLong("time");
                    } catch (JSONException e2) {
                    }
                }
            } catch (JSONException e3) {
                strX = null;
            }
        } catch (JSONException e4) {
            j = 0;
            strX = null;
            strX2 = null;
        }
        if (strX2 == null || strX != null) {
            strArr[0] = strX2;
            strArr[1] = strX;
            if (z) {
                return strArr;
            }
        }
        if (atomicBoolean.getAndSet(false)) {
            strArrUc = uc(prVar, z2, xVar);
            if (!TextUtils.isEmpty(strArrUc[0]) && TextUtils.isEmpty(strArrUc[1])) {
                if (strX2 == null) {
                    strX2 = "";
                }
                strArrUc[0] = strX2;
                strArrUc[1] = strX != null ? strX : "";
                return strArrUc;
            }
        }
        if (strX2 != null && System.currentTimeMillis() - j > 3600000) {
            strX2 = null;
        }
        str = (strX != null || System.currentTimeMillis() - j2 <= 3600000) ? strX : null;
        if (TextUtils.isEmpty(strX2) || !TextUtils.isEmpty(str)) {
            strArr[0] = strX2;
            strArr[1] = str;
            return strArr;
        }
        return uc(prVar, z2, xVar);
    }

    private static String[] uc(com.byazt.vkw.pr prVar, boolean z, com.byazt.vlp.x xVar) {
        String[] strArrHw = hw(prVar, z, xVar);
        if (TextUtils.isEmpty(strArrHw[0]) && TextUtils.isEmpty(strArrHw[1])) {
            zo.hw("", prVar);
        }
        return strArrHw;
    }

    public static String[] hw(com.byazt.vkw.pr prVar, boolean z, com.byazt.vlp.x xVar) {
        return fw(prVar, z, xVar);
    }

    private static void pr(Map<String, NetworkInterface> map, com.byazt.vkw.pr prVar) {
        int i;
        Iterator<Map.Entry<String, NetworkInterface>> it;
        String str;
        String hostAddress;
        prVar = prVar;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        JSONArray jSONArray = new JSONArray();
        Iterator<Map.Entry<String, NetworkInterface>> it2 = map.entrySet().iterator();
        String str2 = "";
        String strPr = "";
        String strPr2 = strPr;
        String str3 = strPr2;
        while (it2.hasNext()) {
            Map.Entry<String, NetworkInterface> next = it2.next();
            if (next != null) {
                String key = next.getKey();
                NetworkInterface value = next.getValue();
                if (value != null) {
                    try {
                        if (TextUtils.equals(key, "wlan0")) {
                            strPr = pr(value, prVar);
                        }
                        if (TextUtils.equals(key, "eth0")) {
                            strPr2 = pr(value, prVar);
                        }
                    } catch (Throwable th) {
                    }
                    List<InetAddress> listPr = pr(value);
                    if (listPr != null) {
                        for (InetAddress inetAddress : listPr) {
                            String hostAddress2 = inetAddress.getHostAddress();
                            if (TextUtils.equals(key, "wlan0") && (inetAddress instanceof Inet6Address) && inetAddress.isLinkLocalAddress() && (hostAddress = inetAddress.getHostAddress()) != null && hostAddress.startsWith("fe80")) {
                                str3 = hostAddress;
                            }
                            if (TextUtils.isEmpty(hostAddress2)) {
                                it = it2;
                                str = str2;
                            } else if (hostAddress2.indexOf(58) < 0) {
                                it = it2;
                                str = str2;
                            } else {
                                int iIndexOf = hostAddress2.indexOf(37);
                                try {
                                    it = it2;
                                    if ("dummy0".equals(key)) {
                                        try {
                                            JSONObject jSONObject = new JSONObject();
                                            str = str2;
                                            try {
                                                jSONObject.put("type", "client_tun");
                                                jSONObject.put(Constants.VALUE_FIELD, iIndexOf < 0 ? hostAddress2.toUpperCase() : hostAddress2.substring(0, iIndexOf).toUpperCase());
                                                jSONArray.put(jSONObject);
                                            } catch (JSONException e) {
                                            }
                                        } catch (JSONException e2) {
                                            str = str2;
                                        }
                                    } else {
                                        str = str2;
                                        if ("wlan0".equals(key)) {
                                            JSONObject jSONObject2 = new JSONObject();
                                            jSONObject2.put("type", "client_anpi");
                                            jSONObject2.put(Constants.VALUE_FIELD, iIndexOf < 0 ? hostAddress2.toUpperCase() : hostAddress2.substring(0, iIndexOf).toUpperCase());
                                            jSONArray.put(jSONObject2);
                                        }
                                    }
                                } catch (JSONException e3) {
                                    it = it2;
                                }
                            }
                            if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress() && !TextUtils.isEmpty(hostAddress2)) {
                                if (inetAddress instanceof Inet6Address) {
                                    sb.append(hostAddress2).append(",");
                                } else if (inetAddress instanceof Inet4Address) {
                                    sb2.append(hostAddress2).append(",");
                                }
                            }
                            it2 = it;
                            str2 = str;
                        }
                    }
                }
            }
            it2 = it2;
            str2 = str2;
        }
        String str4 = str2;
        if (TextUtils.isEmpty(sb)) {
            i = 1;
        } else {
            i = 1;
            sb = sb.delete(sb.length() - 1, sb.length());
        }
        if (!TextUtils.isEmpty(sb2)) {
            sb2 = sb2.delete(sb2.length() - i, sb2.length());
        }
        Map<String, String> map2 = hw;
        map2.put("enc_ipv4", sb2.toString());
        map2.put("enc_ipv6", sb.toString());
        map2.put("register_ipv6", jSONArray.toString());
        if (!TextUtils.isEmpty(strPr)) {
            map2.put("mac", strPr);
        } else {
            map2.put("mac", strPr2);
        }
        map2.put("zaid_ipv6", TextUtils.isEmpty(str3) ? str4 : str3);
    }

    private static String pr(NetworkInterface networkInterface, com.byazt.vkw.pr prVar) throws SocketException {
        com.byazt.vlp.hw hwVarW = prVar.w();
        if (hwVarW != null && !hwVarW.pr(2)) {
            return hwVarW.fw();
        }
        byte[] hardwareAddress = networkInterface.getHardwareAddress();
        if (hardwareAddress == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : hardwareAddress) {
            sb.append(String.format("%02X:", Byte.valueOf(b)));
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private static String[] fw(com.byazt.vkw.pr prVar, boolean z, com.byazt.vlp.x xVar) {
        String[] strArr = {"", ""};
        Map<String, String> mapPr = pr(false, prVar, z, xVar);
        if (mapPr != null) {
            strArr[0] = mapPr.get("local_ipv4");
            strArr[1] = mapPr.get("local_ipv6");
        }
        return strArr;
    }

    private static void hw(Map<String, NetworkInterface> map, com.byazt.vkw.pr prVar) {
        String[] strArr = {"", ""};
        Iterator<Map.Entry<String, NetworkInterface>> it = map.entrySet().iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            NetworkInterface value = it.next().getValue();
            if (value != null) {
                for (InetAddress inetAddress : pr(value)) {
                    boolean z3 = inetAddress instanceof Inet4Address;
                    if (!z3 || !z) {
                        if (z3 || !z2) {
                            if (pr(z3, inetAddress, strArr)) {
                                if (!TextUtils.isEmpty(strArr[0]) && !TextUtils.isEmpty(strArr[1])) {
                                    Map<String, String> map2 = hw;
                                    map2.put("local_ipv4", strArr[0]);
                                    map2.put("local_ipv6", strArr[1]);
                                    return;
                                }
                            } else {
                                String hostAddress = inetAddress.getHostAddress();
                                if (!TextUtils.isEmpty(hostAddress) && !hostAddress.startsWith("127")) {
                                    if (z3) {
                                        zo.hw(((nt) com.byazt.zs.uc.pr("encrypt_service")).hn(hostAddress), prVar);
                                        strArr[0] = hostAddress;
                                        pr prVar2 = c;
                                        if (prVar2 != null) {
                                            prVar2.pr(hostAddress);
                                        }
                                        if (!z2) {
                                            z = true;
                                        } else {
                                            Map<String, String> map3 = hw;
                                            map3.put("local_ipv4", hostAddress);
                                            map3.put("local_ipv6", strArr[1]);
                                            return;
                                        }
                                    } else {
                                        int iIndexOf = hostAddress.indexOf(37);
                                        if (iIndexOf >= 0) {
                                            hostAddress = hostAddress.substring(0, iIndexOf);
                                        }
                                        if (pr(hostAddress)) {
                                            zo.hn(((nt) com.byazt.zs.uc.pr("encrypt_service")).hn(hostAddress), prVar);
                                            strArr[1] = hostAddress;
                                            pr prVar3 = c;
                                            if (prVar3 != null) {
                                                prVar3.hw(hostAddress);
                                            }
                                            if (z) {
                                                Map<String, String> map4 = hw;
                                                map4.put("local_ipv4", strArr[0]);
                                                map4.put("local_ipv6", hostAddress);
                                                return;
                                            }
                                            z2 = true;
                                        } else {
                                            continue;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static List<InetAddress> pr(NetworkInterface networkInterface) {
        if (networkInterface == null) {
            return Collections.emptyList();
        }
        try {
            Object objPr = c.pr(networkInterface, "java.net.NetworkInterface", "addrs", null);
            if (!(objPr instanceof InetAddress[])) {
                return Collections.list(networkInterface.getInetAddresses());
            }
            return Arrays.asList((InetAddress[]) objPr);
        } catch (Throwable th) {
            return Collections.list(networkInterface.getInetAddresses());
        }
    }

    private static boolean pr(boolean z, InetAddress inetAddress, String[] strArr) {
        Field declaredField;
        int iIntValue;
        if (z) {
            try {
                if (!TextUtils.isEmpty(strArr[0])) {
                    return true;
                }
            } catch (Throwable th) {
                return false;
            }
        }
        if (!z && !TextUtils.isEmpty(strArr[1])) {
            return true;
        }
        if (z) {
            declaredField = InetAddress.class.getDeclaredField("holder");
        } else {
            declaredField = Inet6Address.class.getDeclaredField("holder6");
        }
        declaredField.setAccessible(true);
        Object obj = declaredField.get(inetAddress);
        Class<?> cls = obj.getClass();
        if (z) {
            Field declaredField2 = cls.getDeclaredField("address");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (!(obj2 instanceof Integer)) {
                iIntValue = 0;
            } else {
                iIntValue = ((Integer) obj2).intValue();
            }
            byte[] bArr = {(byte) ((iIntValue >>> 24) & 255), (byte) ((iIntValue >>> 16) & 255), (byte) ((iIntValue >>> 8) & 255), (byte) (iIntValue & 255)};
            String strHw = hw(bArr);
            if (bArr[0] != 127) {
                strArr[0] = strHw;
            }
        } else {
            Field declaredField3 = cls.getDeclaredField("ipaddress");
            declaredField3.setAccessible(true);
            Object obj3 = declaredField3.get(obj);
            if (obj3 instanceof byte[]) {
                String strPr = pr((byte[]) obj3);
                if (!pr(strPr)) {
                    return true;
                }
                strArr[1] = strPr;
            }
        }
        return true;
    }

    private static String pr(byte[] bArr) {
        StringBuilder sb = new StringBuilder(39);
        for (int i = 0; i < 8; i++) {
            int i2 = i << 1;
            sb.append(Integer.toHexString(((bArr[i2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (bArr[i2 + 1] & UByte.MAX_VALUE)));
            if (i < 7) {
                sb.append(":");
            }
        }
        return sb.toString();
    }

    private static String hw(byte[] bArr) {
        return (bArr[0] & UByte.MAX_VALUE) + "." + (bArr[1] & UByte.MAX_VALUE) + "." + (bArr[2] & UByte.MAX_VALUE) + "." + (bArr[3] & UByte.MAX_VALUE);
    }

    private static boolean pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char cCharAt = str.charAt(0);
        if ((cCharAt != '2' && cCharAt != '3' && cCharAt != '5') || str.length() < 2) {
            return false;
        }
        char cCharAt2 = str.charAt(1);
        if (cCharAt2 >= '0' && cCharAt2 <= '9') {
            return true;
        }
        if (cCharAt2 < 'a' || cCharAt2 > 'f') {
            return cCharAt2 >= 'A' && cCharAt2 <= 'F';
        }
        return true;
    }

    public static boolean hn(com.byazt.vkw.pr prVar, boolean z, com.byazt.vlp.x xVar) {
        if (!pr(xVar)) {
            return false;
        }
        if (!z) {
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(prVar.uc());
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && !jSONObjectOptJSONObject.isNull(Common.System.NAME) && "tt_inner_isw".equals(jSONObjectOptJSONObject.optString(Common.System.NAME))) {
                    return jSONObjectOptJSONObject.optBoolean(Constants.VALUE_FIELD, true);
                }
            }
            return true;
        } catch (JSONException e) {
            return true;
        }
    }

    public static boolean pr(com.byazt.vlp.x xVar) {
        if (!TextUtils.isEmpty(uc)) {
            return !TextUtils.equals("0", uc);
        }
        Map<String, Object> mapC = xVar.c();
        if (mapC != null) {
            Object obj = mapC.get("uip");
            if (obj instanceof String) {
                String str = (String) obj;
                uc = str;
                return !TextUtils.equals("0", str);
            }
        }
        uc = "1";
        return true;
    }

    public static boolean x(com.byazt.vkw.pr prVar, boolean z, com.byazt.vlp.x xVar) {
        Map<String, String> mapPr = pr(false, prVar, z, xVar);
        return (mapPr == null || TextUtils.isEmpty(mapPr.get("enc_ipv4"))) ? false : true;
    }

    public static boolean c(com.byazt.vkw.pr prVar, boolean z, com.byazt.vlp.x xVar) {
        Map<String, String> mapPr = pr(false, prVar, z, xVar);
        return (mapPr == null || TextUtils.isEmpty(mapPr.get("enc_ipv6"))) ? false : true;
    }
}
