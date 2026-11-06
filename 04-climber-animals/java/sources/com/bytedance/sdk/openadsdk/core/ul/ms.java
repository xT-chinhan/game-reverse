package com.bytedance.sdk.openadsdk.core.ul;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.common.m.e;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.jw.ch;
import com.bytedance.sdk.openadsdk.core.nw.vy;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.t;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final ms f3580ms = new ms();
    private vy ab;
    private boolean x;
    private String xr = "";
    private String ah = "";
    private String d = "";
    private String ka = "";
    private JSONArray c = new JSONArray();

    public static ms ms() {
        return f3580ms;
    }

    private ms() {
    }

    public void ms(Context context) {
        if (!re.xr().sl()) {
            this.x = false;
            return;
        }
        if (this.x) {
            return;
        }
        try {
            xr();
            d();
            ah();
            xr(context);
            ah(context);
            this.ab = com.bytedance.sdk.openadsdk.core.jw.re.ny();
            this.x = true;
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    public void ms(vy vyVar) {
        this.ab = vyVar;
    }

    private String xr() {
        Enumeration<InetAddress> inetAddresses;
        String hostAddress;
        String str = null;
        if (!ch.ch()) {
            return null;
        }
        try {
            NetworkInterface byName = NetworkInterface.getByName("wlan0");
            if (byName != null && (inetAddresses = byName.getInetAddresses()) != null) {
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if ((inetAddressNextElement instanceof Inet6Address) && inetAddressNextElement.isLinkLocalAddress() && (hostAddress = inetAddressNextElement.getHostAddress()) != null && hostAddress.startsWith("fe80")) {
                        str = hostAddress;
                    }
                }
            }
        } catch (Exception e) {
            sl.ms(e);
        }
        this.xr = TextUtils.isEmpty(str) ? "" : str;
        return str;
    }

    private Long ah() {
        Long.valueOf(-1L);
        Long lValueOf = Long.valueOf(new StatFs(Environment.getExternalStorageDirectory().getPath()).getTotalBytes());
        this.ah = lValueOf.toString();
        return lValueOf;
    }

    private ActivityManager.MemoryInfo xr(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getMemoryInfo(memoryInfo);
        this.d = String.valueOf(memoryInfo.totalMem);
        return memoryInfo;
    }

    private Long d() {
        long jCurrentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        this.ka = String.valueOf(jCurrentTimeMillis);
        return Long.valueOf(jCurrentTimeMillis);
    }

    private JSONArray ah(Context context) {
        JSONArray jSONArray = new JSONArray();
        try {
            HashMap map = new HashMap();
            map.put("com.ss.android.ugc.aweme", "a");
            map.put("com.ss.android.ugc.aweme.lite", "al");
            map.put("com.dragon.read", t.k);
            map.put("com.ss.android.article.news", "n");
            map.put("com.ss.android.article.lite", "nl");
            PackageManager packageManager = context.getPackageManager();
            for (Map.Entry entry : map.entrySet()) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo((String) entry.getKey(), 0);
                    long j = packageInfo.firstInstallTime;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("n", entry.getValue());
                    jSONObject.put("i", j);
                    if (TextUtils.equals((CharSequence) entry.getValue(), "a") || TextUtils.equals((CharSequence) entry.getValue(), "n")) {
                        jSONObject.put("u", packageInfo.lastUpdateTime);
                    }
                    jSONArray.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
            this.c = jSONArray;
        } catch (Throwable unused2) {
        }
        return jSONArray;
    }

    public void ms(JSONObject jSONObject) {
        if (re.xr().sl()) {
            try {
                vy vyVar = this.ab;
                if (vyVar != null) {
                    JSONObject jSONObjectAh = vyVar.ah();
                    jSONObjectAh.put("sl", 0);
                    jSONObject.put(e.bo, jSONObjectAh);
                }
                jSONObject.put("boot_time_sec", this.ka);
                jSONObject.put("memory", this.d);
                jSONObject.put("disk", this.ah);
                jSONObject.put("client_tun", this.xr);
                jSONObject.put("pkg_info", this.c);
            } catch (Exception e) {
                sl.ms(e);
            }
        }
    }
}
