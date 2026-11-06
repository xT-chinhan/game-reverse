package com.byazt.bq;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.MotionEventCompat;
import com.anythink.core.common.d.i;
import com.anythink.core.common.f.e;
import com.byazt.vf.k;
import com.bytedance.JProtect;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
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
@com.byazt.cp.n(n = {0, 1, 290, 26})
public class qg {
    public static n l;
    public static volatile String w;
    public static AtomicBoolean n = new AtomicBoolean(false);
    public static final Map<String, String> qg = new ConcurrentHashMap();
    public static volatile long s = 0;
    public static final AtomicBoolean q = new AtomicBoolean(false);

    public interface n {
        void n(String str);

        void qg(String str);
    }

    public static void n(n nVar) {
        l = nVar;
    }

    @JProtect
    public static String n(com.byazt.vf.n nVar, boolean z, com.byazt.tbi.s sVar) {
        Map<String, String> mapN = n(false, nVar, z, sVar);
        String str = mapN != null ? mapN.get("mac") : "";
        return str == null ? "" : str;
    }

    private static Map<String, String> n(boolean z, com.byazt.vf.n nVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() + 300000;
        if (!z) {
            if (n.get()) {
                s = 0L;
                n.set(false);
            }
            if (jElapsedRealtime - s < 300000) {
                q.set(true);
                return qg;
            }
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                s = jElapsedRealtime;
                q.set(true);
                return null;
            }
            HashMap map = new HashMap();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (networkInterfaceNextElement != null) {
                    map.put(networkInterfaceNextElement.getName(), networkInterfaceNextElement);
                }
            }
            qg(map, nVar);
            n(map, nVar);
            s = jElapsedRealtime;
            q.set(true);
            return qg;
        } catch (Throwable unused) {
        }
    }

    public static Map<String, String> n(boolean z, com.byazt.vf.n nVar, boolean z2, com.byazt.tbi.s sVar) {
        Map<String, String> mapN;
        if (!s(nVar, z2, sVar)) {
            return qg;
        }
        if (q.get()) {
            return n(z, nVar);
        }
        synchronized (qg.class) {
            mapN = n(z, nVar);
        }
        return mapN;
    }

    @JProtect
    public static String[] n(boolean z, AtomicBoolean atomicBoolean, com.byazt.vf.n nVar, boolean z2, com.byazt.tbi.s sVar) {
        String strQ;
        String strQ2;
        long j;
        String[] strArr = {"", ""};
        String strN = fs.n(nVar);
        long j2 = 0;
        try {
            if (TextUtils.isEmpty(strN)) {
                strQ = null;
                j = 0;
            } else {
                JSONObject jSONObject = new JSONObject(strN);
                strQ = ((k) com.byazt.qp.q.n("encrypt_service")).q(jSONObject.getString(e.a.d));
                try {
                    j = jSONObject.getLong("time");
                } catch (JSONException unused) {
                    strQ2 = null;
                    j = 0;
                }
            }
            try {
                String strQg = fs.qg(nVar);
                if (TextUtils.isEmpty(strQg)) {
                    strQ2 = null;
                } else {
                    JSONObject jSONObject2 = new JSONObject(strQg);
                    strQ2 = ((k) com.byazt.qp.q.n("encrypt_service")).q(jSONObject2.getString(e.a.d));
                    try {
                        j2 = jSONObject2.getLong("time");
                    } catch (JSONException unused2) {
                    }
                }
            } catch (JSONException unused3) {
            }
        } catch (JSONException unused4) {
            strQ = null;
            strQ2 = null;
        }
        if (strQ != null || strQ2 != null) {
            strArr[0] = strQ;
            strArr[1] = strQ2;
            if (z) {
                return strArr;
            }
        }
        if (atomicBoolean.getAndSet(false)) {
            String[] strArrW = w(nVar, z2, sVar);
            if (!TextUtils.isEmpty(strArrW[0]) || !TextUtils.isEmpty(strArrW[1])) {
                return strArrW;
            }
            if (strQ == null) {
                strQ = "";
            }
            strArrW[0] = strQ;
            strArrW[1] = strQ2 != null ? strQ2 : "";
            return strArrW;
        }
        if (strQ != null && System.currentTimeMillis() - j > 3600000) {
            strQ = null;
        }
        String str = (strQ2 == null || System.currentTimeMillis() - j2 <= 3600000) ? strQ2 : null;
        if (!TextUtils.isEmpty(strQ) || !TextUtils.isEmpty(str)) {
            strArr[0] = strQ;
            strArr[1] = str;
            return strArr;
        }
        return w(nVar, z2, sVar);
    }

    private static String[] w(com.byazt.vf.n nVar, boolean z, com.byazt.tbi.s sVar) {
        String[] strArrQg = qg(nVar, z, sVar);
        if (TextUtils.isEmpty(strArrQg[0]) && TextUtils.isEmpty(strArrQg[1])) {
            fs.qg("", nVar);
        }
        return strArrQg;
    }

    public static String[] qg(com.byazt.vf.n nVar, boolean z, com.byazt.tbi.s sVar) {
        return x(nVar, z, sVar);
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00fe  */
    private static void n(Map<String, NetworkInterface> map, com.byazt.vf.n nVar) {
        int i;
        Iterator<Map.Entry<String, NetworkInterface>> it;
        String str;
        String hostAddress;
        nVar = nVar;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        JSONArray jSONArray = new JSONArray();
        Iterator<Map.Entry<String, NetworkInterface>> it2 = map.entrySet().iterator();
        String str2 = "";
        String strN = "";
        String strN2 = strN;
        String str3 = strN2;
        while (it2.hasNext()) {
            Map.Entry<String, NetworkInterface> next = it2.next();
            if (next != null) {
                String key = next.getKey();
                NetworkInterface value = next.getValue();
                if (value != null) {
                    try {
                        if (TextUtils.equals(key, "wlan0")) {
                            strN = n(value, nVar);
                        }
                        if (TextUtils.equals(key, "eth0")) {
                            strN2 = n(value, nVar);
                        }
                    } catch (Throwable unused) {
                    }
                    List<InetAddress> listN = n(value);
                    if (listN != null) {
                        for (InetAddress inetAddress : listN) {
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
                                                jSONObject.put(e.a.d, iIndexOf < 0 ? hostAddress2.toUpperCase() : hostAddress2.substring(0, iIndexOf).toUpperCase());
                                                jSONArray.put(jSONObject);
                                            } catch (JSONException unused2) {
                                            }
                                        } catch (JSONException unused3) {
                                            str = str2;
                                        }
                                    } else {
                                        str = str2;
                                        if ("wlan0".equals(key)) {
                                            JSONObject jSONObject2 = new JSONObject();
                                            jSONObject2.put("type", "client_anpi");
                                            jSONObject2.put(e.a.d, iIndexOf < 0 ? hostAddress2.toUpperCase() : hostAddress2.substring(0, iIndexOf).toUpperCase());
                                            jSONArray.put(jSONObject2);
                                        }
                                    }
                                } catch (JSONException unused4) {
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
        Map<String, String> map2 = qg;
        map2.put("enc_ipv4", sb2.toString());
        map2.put("enc_ipv6", sb.toString());
        map2.put("register_ipv6", jSONArray.toString());
        if (!TextUtils.isEmpty(strN)) {
            map2.put("mac", strN);
        } else {
            map2.put("mac", strN2);
        }
        map2.put("zaid_ipv6", TextUtils.isEmpty(str3) ? str4 : str3);
    }

    private static String n(NetworkInterface networkInterface, com.byazt.vf.n nVar) throws SocketException {
        com.byazt.tbi.n nVarCp = nVar.cp();
        if (nVarCp != null && !nVarCp.n(2)) {
            return nVarCp.x();
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

    private static String[] x(com.byazt.vf.n nVar, boolean z, com.byazt.tbi.s sVar) {
        String[] strArr = {"", ""};
        Map<String, String> mapN = n(false, nVar, z, sVar);
        if (mapN != null) {
            strArr[0] = mapN.get("local_ipv4");
            strArr[1] = mapN.get("local_ipv6");
        }
        return strArr;
    }

    private static void qg(Map<String, NetworkInterface> map, com.byazt.vf.n nVar) {
        String[] strArr = {"", ""};
        Iterator<Map.Entry<String, NetworkInterface>> it = map.entrySet().iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            NetworkInterface value = it.next().getValue();
            if (value != null) {
                for (InetAddress inetAddress : n(value)) {
                    boolean z3 = inetAddress instanceof Inet4Address;
                    if (!z3 || !z) {
                        if (z3 || !z2) {
                            if (n(z3, inetAddress, strArr)) {
                                if (!TextUtils.isEmpty(strArr[0]) && !TextUtils.isEmpty(strArr[1])) {
                                    Map<String, String> map2 = qg;
                                    map2.put("local_ipv4", strArr[0]);
                                    map2.put("local_ipv6", strArr[1]);
                                    return;
                                }
                            } else {
                                String hostAddress = inetAddress.getHostAddress();
                                if (!TextUtils.isEmpty(hostAddress) && !hostAddress.startsWith("127")) {
                                    if (z3) {
                                        fs.qg(((k) com.byazt.qp.q.n("encrypt_service")).s(hostAddress), nVar);
                                        strArr[0] = hostAddress;
                                        n nVar2 = l;
                                        if (nVar2 != null) {
                                            nVar2.n(hostAddress);
                                        }
                                        if (z2) {
                                            Map<String, String> map3 = qg;
                                            map3.put("local_ipv4", hostAddress);
                                            map3.put("local_ipv6", strArr[1]);
                                            return;
                                        }
                                        z = true;
                                    } else {
                                        int iIndexOf = hostAddress.indexOf(37);
                                        if (iIndexOf >= 0) {
                                            hostAddress = hostAddress.substring(0, iIndexOf);
                                        }
                                        if (n(hostAddress)) {
                                            fs.s(((k) com.byazt.qp.q.n("encrypt_service")).s(hostAddress), nVar);
                                            strArr[1] = hostAddress;
                                            n nVar3 = l;
                                            if (nVar3 != null) {
                                                nVar3.qg(hostAddress);
                                            }
                                            if (z) {
                                                Map<String, String> map4 = qg;
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

    private static List<InetAddress> n(NetworkInterface networkInterface) {
        if (networkInterface == null) {
            return Collections.emptyList();
        }
        try {
            Object objN = l.n(networkInterface, "java.net.NetworkInterface", "addrs", null);
            if (!(objN instanceof InetAddress[])) {
                return Collections.list(networkInterface.getInetAddresses());
            }
            return Arrays.asList((InetAddress[]) objN);
        } catch (Throwable unused) {
            return Collections.list(networkInterface.getInetAddresses());
        }
    }

    private static boolean n(boolean z, InetAddress inetAddress, String[] strArr) {
        Field declaredField;
        if (z) {
            try {
                if (!TextUtils.isEmpty(strArr[0])) {
                    return true;
                }
            } catch (Throwable unused) {
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
            int iIntValue = obj2 instanceof Integer ? ((Integer) obj2).intValue() : 0;
            byte[] bArr = {(byte) ((iIntValue >>> 24) & 255), (byte) ((iIntValue >>> 16) & 255), (byte) ((iIntValue >>> 8) & 255), (byte) (iIntValue & 255)};
            String strQg = qg(bArr);
            if (bArr[0] != 127) {
                strArr[0] = strQg;
            }
        } else {
            Field declaredField3 = cls.getDeclaredField("ipaddress");
            declaredField3.setAccessible(true);
            Object obj3 = declaredField3.get(obj);
            if (obj3 instanceof byte[]) {
                String strN = n((byte[]) obj3);
                if (!n(strN)) {
                    return true;
                }
                strArr[1] = strN;
            }
        }
        return true;
    }

    private static String n(byte[] bArr) {
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

    private static String qg(byte[] bArr) {
        return (bArr[0] & UByte.MAX_VALUE) + i.E + (bArr[1] & UByte.MAX_VALUE) + i.E + (bArr[2] & UByte.MAX_VALUE) + i.E + (bArr[3] & UByte.MAX_VALUE);
    }

    private static boolean n(String str) {
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

    public static boolean s(com.byazt.vf.n nVar, boolean z, com.byazt.tbi.s sVar) {
        if (!n(sVar)) {
            return false;
        }
        if (!z) {
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(nVar.w());
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && !jSONObjectOptJSONObject.isNull(TapEventParamConstants.PARAM_NAME) && "tt_inner_isw".equals(jSONObjectOptJSONObject.optString(TapEventParamConstants.PARAM_NAME))) {
                    return jSONObjectOptJSONObject.optBoolean(e.a.d, true);
                }
            }
        } catch (JSONException unused) {
        }
        return true;
    }

    public static boolean n(com.byazt.tbi.s sVar) {
        if (!TextUtils.isEmpty(w)) {
            return !TextUtils.equals("0", w);
        }
        Map<String, Object> mapL = sVar.l();
        if (mapL != null) {
            Object obj = mapL.get("uip");
            if (obj instanceof String) {
                String str = (String) obj;
                w = str;
                return !TextUtils.equals("0", str);
            }
        }
        w = "1";
        return true;
    }

    public static boolean q(com.byazt.vf.n nVar, boolean z, com.byazt.tbi.s sVar) {
        Map<String, String> mapN = n(false, nVar, z, sVar);
        return (mapN == null || TextUtils.isEmpty(mapN.get("enc_ipv4"))) ? false : true;
    }

    public static boolean l(com.byazt.vf.n nVar, boolean z, com.byazt.tbi.s sVar) {
        Map<String, String> mapN = n(false, nVar, z, sVar);
        return (mapN == null || TextUtils.isEmpty(mapN.get("enc_ipv6"))) ? false : true;
    }
}
