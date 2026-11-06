package com.bytedance.sdk.openadsdk.core.jw;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.OsConstants;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.MotionEventCompat;
import com.anythink.core.common.d.j;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.taptap.sdk.db.constant.Common;
import com.umeng.ccg.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.UByte;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ch {
    private static volatile boolean ah = false;
    private static volatile long ao = 0;
    private static volatile String b = null;
    private static volatile xr le = null;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static String f2685ms = null;
    private static volatile long nw = 0;
    private static volatile d op = null;
    private static volatile long qv = 0;
    private static volatile long re = 0;
    private static volatile String t = null;
    private static volatile long u = 0;
    private static volatile boolean xr = false;
    private static volatile String y;
    private static volatile long zb;
    private static AtomicBoolean d = new AtomicBoolean(false);
    private static AtomicBoolean ka = new AtomicBoolean(false);
    private static AtomicInteger c = new AtomicInteger(-1);
    private static volatile boolean ab = true;
    private static long x = 0;
    private static volatile int ny = -1;
    private static volatile int ch = -1;
    private static volatile String hi = null;
    private static volatile String sl = null;
    private static volatile float ub = -2.0f;
    private static volatile int h = -1;
    private static volatile long i = -1;
    private static volatile long w = System.currentTimeMillis();
    private static volatile int yu = -1;

    public static boolean ms() {
        if (!ab && SystemClock.elapsedRealtime() - x >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            x = SystemClock.elapsedRealtime();
            try {
                PowerManager powerManager = (PowerManager) com.bytedance.sdk.openadsdk.core.re.getContext().getSystemService("power");
                if (powerManager != null) {
                    ab = powerManager.isInteractive();
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.sl.ms(th);
            }
        }
        return ab;
    }

    public static long xr() {
        return w;
    }

    public static void ah() {
        c.set(com.bytedance.sdk.component.utils.u.ah(com.bytedance.sdk.openadsdk.core.re.getContext()));
        d();
        sl();
        u();
        ms(0);
        ms(1);
        ms(false);
        ms((String) null);
    }

    public static int d() {
        if (ny == -1 || ka.getAndSet(false)) {
            ny = com.bytedance.sdk.component.utils.u.xr(com.bytedance.sdk.openadsdk.core.re.getContext());
        }
        return ny;
    }

    public static void ms(Context context) {
        if (xr) {
            return;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                ab = powerManager.isScreenOn();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
        try {
            op = new d();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            context.getApplicationContext().registerReceiver(op, intentFilter);
            xr = true;
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sl.ms(th2);
        }
    }

    public static void ka() {
        try {
            if (xr && op != null) {
                com.bytedance.sdk.openadsdk.core.re.getContext().getApplicationContext().unregisterReceiver(op);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
    }

    static class d extends BroadcastReceiver {
        d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            com.bytedance.sdk.component.utils.x.xr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jw.ch.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.ms(intent);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ms(final Intent intent) {
            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                boolean unused = ch.ab = true;
                com.bytedance.sdk.component.utils.sl.ms("DeviceUtils", a.f);
            } else {
                if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                    boolean unused2 = ch.ab = false;
                    com.bytedance.sdk.component.utils.sl.ms("DeviceUtils", a.g);
                    if (com.bytedance.sdk.openadsdk.core.ch.ub().cv()) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.op.ab.ms(new com.bytedance.sdk.component.ch.ny("updateScreenStatus") { // from class: com.bytedance.sdk.openadsdk.core.jw.ch.d.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.sdk.component.panglearmor.xr.xr.ms().xr(intent.getAction());
                        }
                    });
                    return;
                }
                if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                    long unused3 = ch.w = System.currentTimeMillis();
                }
            }
        }
    }

    public static String ms(String str) {
        if (!TextUtils.isEmpty(b) && !ms(re, 1800000L)) {
            return b;
        }
        String strAh = com.bytedance.sdk.openadsdk.core.ah.d.ms().ah("dev14", 1800000L);
        if (TextUtils.isEmpty(strAh)) {
            if (str == null) {
                str = c();
            }
            b = str;
        } else {
            b = com.bytedance.sdk.component.utils.ms.ah(strAh);
        }
        re = System.currentTimeMillis();
        return b;
    }

    public static String c() {
        if (nw()) {
            return y;
        }
        return b()[0];
    }

    public static String ab() {
        if (nw()) {
            return t;
        }
        return b()[1];
    }

    private static boolean nw() {
        return (d.get() || ms(nw, 1800000L) || TextUtils.isEmpty(y)) ? false : true;
    }

    private static String[] b() {
        String[] strArrRe = {"", ""};
        if (d.getAndSet(false)) {
            strArrRe = re();
        }
        String strAh = com.bytedance.sdk.openadsdk.core.ah.d.ms().ah("dev13", 3600000L);
        String strAh2 = com.bytedance.sdk.openadsdk.core.ah.d.ms().ah("dev15", 3600000L);
        try {
            if (!TextUtils.isEmpty(strAh) || !TextUtils.isEmpty(strAh2)) {
                String strAh3 = com.bytedance.sdk.component.utils.ms.ah(strAh);
                strArrRe[0] = strAh3;
                String strAh4 = com.bytedance.sdk.component.utils.ms.ah(strAh2);
                strArrRe[1] = strAh4;
                y = strAh3;
                t = strAh4;
                nw = System.currentTimeMillis();
            } else {
                strArrRe = re();
                y = strArrRe[0];
                t = strArrRe[1];
                nw = System.currentTimeMillis();
            }
        } catch (Throwable unused) {
        }
        return strArrRe;
    }

    public static JSONArray x() {
        JSONArray jSONArray = new JSONArray();
        try {
            if (NetworkInterface.getNetworkInterfaces() == null) {
                return new JSONArray();
            }
            if (!ch()) {
                return new JSONArray();
            }
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                String name = networkInterface.getName();
                if ("dummy0".equals(name) || "wlan0".equals(name)) {
                    Iterator it = Collections.list(networkInterface.getInetAddresses()).iterator();
                    while (it.hasNext()) {
                        String hostAddress = ((InetAddress) it.next()).getHostAddress();
                        if (!TextUtils.isEmpty(hostAddress)) {
                            if (!(hostAddress.indexOf(58) < 0)) {
                                int iIndexOf = hostAddress.indexOf(37);
                                if ("dummy0".equals(name)) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("type", "client_tun");
                                    if (iIndexOf >= 0) {
                                        hostAddress = hostAddress.substring(0, iIndexOf);
                                    }
                                    jSONObject.put(com.anythink.core.common.e.f.a.d, hostAddress.toUpperCase());
                                    jSONArray.put(jSONObject);
                                } else if ("wlan0".equals(name) || "fe80".equalsIgnoreCase(hostAddress.split("::")[0])) {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("type", "client_anpi");
                                    if (iIndexOf >= 0) {
                                        hostAddress = hostAddress.substring(0, iIndexOf);
                                    }
                                    jSONObject2.put(com.anythink.core.common.e.f.a.d, hostAddress.toUpperCase());
                                    jSONArray.put(jSONObject2);
                                }
                            }
                        }
                    }
                }
            }
            return jSONArray;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    public static String[] ms(boolean z) {
        long j;
        String strAh;
        String strAh2;
        if (nw()) {
            return new String[]{y, t};
        }
        String[] strArrRe = {"", ""};
        String strQv = com.bytedance.sdk.openadsdk.core.ah.d.ms().qv();
        long j2 = 0;
        if (strQv != null) {
            try {
                JSONObject jSONObject = new JSONObject(strQv);
                strAh = com.bytedance.sdk.component.utils.ms.ah(jSONObject.getString(com.anythink.core.common.e.f.a.d));
                try {
                    j = jSONObject.getLong("time");
                } catch (JSONException unused) {
                    j = 0;
                }
            } catch (JSONException unused2) {
                j = 0;
                strAh = null;
                strAh2 = null;
            }
        } else {
            j = 0;
            strAh = null;
        }
        try {
            String strY = com.bytedance.sdk.openadsdk.core.ah.d.ms().y();
            if (strY != null) {
                JSONObject jSONObject2 = new JSONObject(strY);
                strAh2 = com.bytedance.sdk.component.utils.ms.ah(jSONObject2.getString(com.anythink.core.common.e.f.a.d));
                try {
                    j2 = jSONObject2.getLong("time");
                } catch (JSONException unused3) {
                }
            } else {
                strAh2 = null;
            }
        } catch (JSONException unused4) {
        }
        if (strAh != null || strAh2 != null) {
            strArrRe[0] = strAh;
            strArrRe[1] = strAh2;
            if (z) {
                return strArrRe;
            }
        }
        if (d.getAndSet(false)) {
            strArrRe = re();
            if (TextUtils.isEmpty(strArrRe[0]) && TextUtils.isEmpty(strArrRe[1])) {
                if (strAh == null) {
                    strAh = "";
                }
                strArrRe[0] = strAh;
                strArrRe[1] = strAh2 != null ? strAh2 : "";
            }
        } else {
            if (strAh != null && System.currentTimeMillis() - j > 3600000) {
                strAh = null;
            }
            String str = (strAh2 == null || System.currentTimeMillis() - j2 <= 3600000) ? strAh2 : null;
            if (!TextUtils.isEmpty(strAh) || !TextUtils.isEmpty(str)) {
                strArrRe[0] = strAh;
                strArrRe[1] = str;
            } else {
                strArrRe = re();
            }
        }
        y = strArrRe[0];
        t = strArrRe[1];
        nw = System.currentTimeMillis();
        return strArrRe;
    }

    private static String[] re() {
        String[] strArrNy = ny();
        if (TextUtils.isEmpty(strArrNy[0]) && TextUtils.isEmpty(strArrNy[1])) {
            com.bytedance.sdk.openadsdk.core.ah.d.ms().zb("");
        }
        return strArrNy;
    }

    public static void xr(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.ah.d.ms().d("dev14", com.bytedance.sdk.component.utils.ms.xr(str));
        b = str;
        re = System.currentTimeMillis();
    }

    public static String[] ny() {
        String[] strArr = {"", ""};
        if (!ch()) {
            return strArr;
        }
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            boolean z = false;
            boolean z2 = false;
            while (it.hasNext()) {
                for (InetAddress inetAddress : ms((NetworkInterface) it.next())) {
                    boolean z3 = inetAddress instanceof Inet4Address;
                    if (!z3 || !z) {
                        if (z3 || !z2) {
                            if (xr(z3, inetAddress, strArr)) {
                                if (!TextUtils.isEmpty(strArr[0]) && !TextUtils.isEmpty(strArr[1])) {
                                    return strArr;
                                }
                            } else {
                                String hostAddress = inetAddress.getHostAddress();
                                if (!TextUtils.isEmpty(hostAddress) && !hostAddress.startsWith("127")) {
                                    if (z3) {
                                        com.bytedance.sdk.openadsdk.core.ah.d.ms().zb(com.bytedance.sdk.component.utils.ms.xr(hostAddress));
                                        strArr[0] = hostAddress;
                                        if (z2) {
                                            return strArr;
                                        }
                                        z = true;
                                    } else {
                                        int iIndexOf = hostAddress.indexOf(37);
                                        if (iIndexOf >= 0) {
                                            hostAddress = hostAddress.substring(0, iIndexOf);
                                        }
                                        if (ah(hostAddress)) {
                                            com.bytedance.sdk.openadsdk.core.ah.d.ms().u(com.bytedance.sdk.component.utils.ms.xr(hostAddress));
                                            strArr[1] = hostAddress;
                                            if (z) {
                                                return strArr;
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
        } catch (Throwable unused) {
        }
        return strArr;
    }

    private static List<InetAddress> ms(NetworkInterface networkInterface) {
        if (networkInterface == null) {
            return Collections.emptyList();
        }
        try {
            Object objMs = i.ms(networkInterface, "java.net.NetworkInterface", "addrs", null);
            if (!(objMs instanceof InetAddress[])) {
                return Collections.list(networkInterface.getInetAddresses());
            }
            return Arrays.asList((InetAddress[]) objMs);
        } catch (Throwable unused) {
            return Collections.list(networkInterface.getInetAddresses());
        }
    }

    private static boolean ms(boolean z, InetAddress inetAddress, String[] strArr) {
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
        Class<?> cls = Class.forName("libcore.io.Libcore");
        Field declaredField = cls.getDeclaredField("os");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(cls);
        Method method = obj.getClass().getMethod("getnameinfo", InetAddress.class, Integer.TYPE);
        method.setAccessible(true);
        Object objInvoke = method.invoke(obj, inetAddress, Integer.valueOf(OsConstants.NI_NUMERICHOST));
        if (objInvoke == null) {
            return false;
        }
        String strSubstring = (String) objInvoke;
        if (strSubstring.startsWith("127")) {
            return true;
        }
        if (z) {
            strArr[0] = strSubstring;
            return true;
        }
        int iIndexOf = strSubstring.indexOf(37);
        if (iIndexOf >= 0) {
            strSubstring = strSubstring.substring(0, iIndexOf);
        }
        if (!ah(strSubstring)) {
            return true;
        }
        strArr[1] = strSubstring;
        return true;
    }

    private static boolean xr(boolean z, InetAddress inetAddress, String[] strArr) {
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
            String strXr = xr(bArr);
            if (bArr[0] != 127) {
                strArr[0] = strXr;
            }
        } else {
            Field declaredField3 = cls.getDeclaredField("ipaddress");
            declaredField3.setAccessible(true);
            Object obj3 = declaredField3.get(obj);
            if (obj3 instanceof byte[]) {
                String strMs = ms((byte[]) obj3);
                if (!ah(strMs)) {
                    return true;
                }
                strArr[1] = strMs;
            }
        }
        return true;
    }

    private static String ms(byte[] bArr) {
        StringBuilder sb = new StringBuilder(39);
        for (int i2 = 0; i2 < 8; i2++) {
            int i3 = i2 << 1;
            sb.append(Integer.toHexString(((bArr[i3] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (bArr[i3 + 1] & UByte.MAX_VALUE)));
            if (i2 < 7) {
                sb.append(":");
            }
        }
        return sb.toString();
    }

    private static String xr(byte[] bArr) {
        return (bArr[0] & UByte.MAX_VALUE) + j.z + (bArr[1] & UByte.MAX_VALUE) + j.z + (bArr[2] & UByte.MAX_VALUE) + j.z + (bArr[3] & UByte.MAX_VALUE);
    }

    private static boolean ah(String str) {
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

    public static boolean ch() {
        if (!com.bytedance.sdk.openadsdk.core.re.xr().fb()) {
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(com.bytedance.sdk.openadsdk.core.ch.ub().w());
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null && !jSONObjectOptJSONObject.isNull(Common.System.NAME) && "tt_inner_isw".equals(jSONObjectOptJSONObject.optString(Common.System.NAME))) {
                    return jSONObjectOptJSONObject.optBoolean(com.anythink.core.common.e.f.a.d, true);
                }
            }
        } catch (JSONException unused) {
        }
        return true;
    }

    public static boolean xr(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean ah(Context context) {
        try {
            return (context.getResources().getConfiguration().uiMode & 15) == 4;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int ms(Context context, boolean z) {
        if (ch != -1) {
            return ch;
        }
        if (z) {
            String strAh = com.bytedance.sdk.openadsdk.core.ah.d.ms().ah("dev06", 2592000000L);
            try {
                if (!TextUtils.isEmpty(strAh)) {
                    ch = Integer.parseInt(strAh);
                }
            } catch (Exception unused) {
            }
            if (ch != -1) {
                return ch;
            }
        }
        if (ah(context)) {
            ch = 3;
        } else if (xr(context)) {
            ch = 2;
        } else {
            ch = 1;
        }
        if (z) {
            com.bytedance.sdk.openadsdk.core.ah.d.ms().d("dev06", String.valueOf(ch));
        }
        return ch;
    }

    public static void ms(JSONObject jSONObject) throws JSONException {
        if (zb.xr()) {
            jSONObject.putOpt("os_new", "harmony");
            jSONObject.putOpt("harmonyos_api", zb.ka());
            jSONObject.putOpt("harmonyos_version", zb.c());
            jSONObject.putOpt("harmonyos_release_type", zb.ab());
            jSONObject.putOpt("harmonyos_build_version", zb.x());
            jSONObject.putOpt("pure_mode", Integer.valueOf(zb.ms(com.bytedance.sdk.openadsdk.core.re.getContext()) ? 1 : 2));
        } else {
            jSONObject.putOpt("os_new", "android");
        }
        jSONObject.putOpt("rom_name", Build.BRAND);
    }

    public static String hi() {
        String languageTag = Locale.getDefault().toLanguageTag();
        return !TextUtils.isEmpty(languageTag) ? languageTag : "";
    }

    public static float sl() {
        if (ub != -2.0f && !ms(ao, 30000L)) {
            return ub;
        }
        int i2 = -1;
        try {
            Context context = com.bytedance.sdk.openadsdk.core.re.getContext();
            if (context != null) {
                i2 = Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.d("DeviceUtils", th.getMessage());
        }
        if (i2 < 0) {
            ub = -1.0f;
        } else {
            ub = Math.round((i2 / 255.0f) * 10.0f) / 10.0f;
        }
        ao = System.currentTimeMillis();
        return ub;
    }

    public static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static int f2688ms = -1;
        static float xr;

        public static int ms(Context context) {
            com.bytedance.sdk.openadsdk.ms.xr.xr.ms(context);
            return f2688ms;
        }

        public static float xr(Context context) {
            com.bytedance.sdk.openadsdk.ms.xr.xr.xr(context);
            return xr;
        }
    }

    public static void d(Context context) {
        if (ah) {
            return;
        }
        try {
            le = new xr();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            context.getApplicationContext().registerReceiver(le, intentFilter);
            ah = true;
        } catch (Throwable unused) {
        }
    }

    public static void zb() {
        try {
            if (ah && le != null) {
                com.bytedance.sdk.openadsdk.core.re.getContext().getApplicationContext().unregisterReceiver(le);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
    }

    static class xr extends BroadcastReceiver {
        xr() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            if (intent == null) {
                return;
            }
            com.bytedance.sdk.component.utils.x.ah().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jw.ch.xr.1
                @Override // java.lang.Runnable
                public void run() {
                    xr.this.ms(intent);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ms(Intent intent) {
            int intExtra = -1;
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                boolean booleanExtra = intent.getBooleanExtra("present", false);
                if (booleanExtra) {
                    int intExtra2 = intent.getIntExtra("status", -1);
                    if (intExtra2 == -1) {
                        ms.f2688ms = intExtra2;
                    } else if (intExtra2 == 2) {
                        ms.f2688ms = 1;
                    } else {
                        ms.f2688ms = 0;
                    }
                } else {
                    ms.f2688ms = 2;
                }
                ms.xr = (intent.getIntExtra("level", -1) * 100) / intent.getIntExtra("scale", -1);
                if (!com.bytedance.sdk.openadsdk.core.ch.ub().cv()) {
                    com.bytedance.sdk.openadsdk.ms.xr.xr.ms(booleanExtra);
                }
            }
            try {
                intExtra = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);
            } catch (Exception unused) {
            }
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intExtra == 3) {
                com.bytedance.sdk.component.utils.x.ms().post(new com.bytedance.sdk.component.ch.ny("tt_vol") { // from class: com.bytedance.sdk.openadsdk.core.jw.ch.xr.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AudioManager audioManager = (AudioManager) com.bytedance.sdk.openadsdk.core.re.getContext().getSystemService("audio");
                            if (audioManager == null) {
                                return;
                            }
                            int unused2 = ch.yu = audioManager.getStreamVolume(3);
                        } catch (Exception unused3) {
                        }
                    }
                });
            }
        }
    }

    public static int u() {
        if (h != -1 && !ms(qv, 60000L)) {
            return h;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) com.bytedance.sdk.openadsdk.core.re.getContext().getSystemService("accessibility");
        if (accessibilityManager == null) {
            return -1;
        }
        h = accessibilityManager.isEnabled() ? 1 : 0;
        qv = System.currentTimeMillis();
        return h;
    }

    public static void ub() {
        Context context = com.bytedance.sdk.openadsdk.core.re.getContext();
        if (context != null) {
            int iU = f.u();
            com.bytedance.sdk.openadsdk.core.ah.d.ms().ms("cpu_cnt", iU);
            f.f2700ms = iU;
            int iAh = f.ah(f.u());
            com.bytedance.sdk.openadsdk.core.ah.d.ms().ms("cpu_max_freq", iAh);
            f.xr = iAh;
            int iD = f.d(f.u());
            com.bytedance.sdk.openadsdk.core.ah.d.ms().ms("cpu_min_freq", iD);
            f.ah = iD;
            String strD = f.d(context, "MemTotal");
            if (strD != null) {
                com.bytedance.sdk.openadsdk.core.ah.d.ms().xr("total_memory", strD);
                f.d = strD;
            }
            long jY = f.y();
            com.bytedance.sdk.openadsdk.core.ah.d.ms().ms("internal_storage", jY);
            f.ka = jY;
            long jMs = com.bytedance.sdk.component.utils.zb.ms();
            com.bytedance.sdk.openadsdk.core.ah.d.ms().ms("free_storage", jMs);
            f.c = jMs;
            long jB = f.b();
            com.bytedance.sdk.openadsdk.core.ah.d.ms().ms("sdcard_storage", jB);
            f.ab = jB;
            boolean zI = f.i();
            com.bytedance.sdk.openadsdk.core.ah.d.ms().ms("is_root", zI ? 1 : 0);
            f.x = zI ? 1 : 0;
        }
    }

    public static void ka(Context context) {
        com.bytedance.sdk.component.utils.w.ms(new ah(), context);
    }

    static class ah implements com.bytedance.sdk.component.utils.w.ms {
        ah() {
        }

        @Override // com.bytedance.sdk.component.utils.w.ms
        public void ms(Context context, Intent intent, boolean z, int i) {
            if (ch.c.get() == i) {
                return;
            }
            ch.c.set(i);
            ch.d.set(true);
            ch.ka.set(true);
            if (com.bytedance.sdk.openadsdk.core.ch.ub().cv()) {
                return;
            }
            com.bytedance.sdk.component.panglearmor.xr.xr.ms().ms(i);
        }
    }

    public static String ms(int i2) {
        if (i2 == 0 && !TextUtils.isEmpty(hi) && !ms(zb, 60000L)) {
            return hi;
        }
        if (i2 == 1 && !TextUtils.isEmpty(sl) && !ms(u, 60000L)) {
            return sl;
        }
        String strD = d(i2);
        if (i2 == 0) {
            hi = strD;
            zb = System.currentTimeMillis();
        } else if (i2 == 1) {
            sl = strD;
            u = System.currentTimeMillis();
        }
        return strD;
    }

    private static String d(int i2) {
        TelephonyManager telephonyManagerMs;
        List<CellInfo> allCellInfo;
        int dbm;
        WifiInfo wifiInfoXr;
        int iAh = com.bytedance.sdk.component.utils.u.ah(com.bytedance.sdk.openadsdk.core.re.getContext());
        com.bytedance.sdk.openadsdk.core.f.ka kaVarAo = com.bytedance.sdk.openadsdk.core.ch.ub().ao();
        if (iAh == 4) {
            if (i2 == 0) {
                try {
                    return (kaVarAo.d() && (wifiInfoXr = com.bytedance.sdk.openadsdk.core.t.xr()) != null) ? wifiInfoXr.getRssi() + "dBm" : "unknown";
                } catch (Throwable unused) {
                }
            }
            return "unknown";
        }
        if (kaVarAo.ah() && kaVarAo.ms() && i2 == 1) {
            try {
                if (!com.bytedance.sdk.openadsdk.core.t.ao() || (telephonyManagerMs = com.bytedance.sdk.openadsdk.core.t.ms()) == null || (allCellInfo = telephonyManagerMs.getAllCellInfo()) == null) {
                    return "unknown";
                }
                CellInfo cellInfo = allCellInfo.get(0);
                if (cellInfo instanceof CellInfoGsm) {
                    dbm = ((CellInfoGsm) cellInfo).getCellSignalStrength().getDbm();
                } else if (cellInfo instanceof CellInfoCdma) {
                    dbm = ((CellInfoCdma) cellInfo).getCellSignalStrength().getDbm();
                } else if (cellInfo instanceof CellInfoLte) {
                    dbm = ((CellInfoLte) cellInfo).getCellSignalStrength().getDbm();
                } else if (cellInfo instanceof CellInfoWcdma) {
                    dbm = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getDbm();
                } else if (Build.VERSION.SDK_INT >= 29 && (cellInfo instanceof CellInfoNr)) {
                    dbm = ((CellInfoNr) cellInfo).getCellSignalStrength().getDbm();
                } else if (Build.VERSION.SDK_INT >= 29 && (cellInfo instanceof CellInfoTdscdma)) {
                    dbm = ((CellInfoTdscdma) cellInfo).getCellSignalStrength().getDbm();
                }
                return Integer.MIN_VALUE == dbm ? "unknown" : dbm + "dBm";
            } catch (Throwable unused2) {
            }
        }
        return "unknown";
    }

    private static boolean ms(long j, long j2) {
        return System.currentTimeMillis() - j > j2;
    }

    public static JSONObject xr(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", com.bytedance.sdk.openadsdk.core.ch.ub().t());
            jSONObject.put(Common.System.NAME, com.bytedance.sdk.openadsdk.core.ch.ub().nw());
            xr(jSONObject);
            com.bytedance.sdk.openadsdk.ub.xr.ms(jSONObject, i2);
            jSONObject.put("is_paid_app", com.bytedance.sdk.openadsdk.core.ch.ub().b());
            if (!com.bytedance.sdk.openadsdk.core.ah.d.ms().ab(i2)) {
                jSONObject.put("network_speed", com.bytedance.sdk.openadsdk.core.re.ms.ms());
            }
            jSONObject.put("apk_sign", com.bytedance.sdk.openadsdk.core.x.ms.x());
            jSONObject.put("useful_open_sdk", com.bytedance.sdk.openadsdk.core.xr.ms.xr.x.ah().xr());
            jSONObject.put("real_app_name", com.bytedance.sdk.openadsdk.core.x.ms.xr(com.bytedance.sdk.openadsdk.core.re.getContext()));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static void xr(JSONObject jSONObject) {
        try {
            jSONObject.put("package_name", f.ch());
            jSONObject.put("version_code", f.hi());
            jSONObject.put("version", f.sl());
        } catch (Exception unused) {
        }
    }

    public static void ms(long j) {
        if (j == -1 || i == j) {
            return;
        }
        i = j;
        com.bytedance.sdk.openadsdk.core.ah.d.ms().ms("dev19", j);
    }

    public static long ao() {
        if (i != -1) {
            return i;
        }
        return com.bytedance.sdk.openadsdk.core.ah.d.ms().xr("dev19", -1L);
    }

    public static int h() {
        if (yu >= 0) {
            return yu;
        }
        try {
            AudioManager audioManager = (AudioManager) com.bytedance.sdk.openadsdk.core.re.getContext().getSystemService("audio");
            if (audioManager == null) {
                return 0;
            }
            yu = audioManager.getStreamVolume(3);
            return yu;
        } catch (Exception unused) {
            return 0;
        }
    }
}
