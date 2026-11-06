package com.bytedance.sdk.component.panglearmor.xr;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bytedance.sdk.component.panglearmor.c;
import com.umeng.analytics.pro.bv;
import java.lang.reflect.Method;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ms f1322ms;
    private ConnectivityManager ah;
    private volatile int d = -1;
    private TelephonyManager ka;
    private volatile int xr;

    public ms() {
        this.ah = null;
        this.ka = null;
        Context contextD = c.d();
        if (contextD != null) {
            this.ah = (ConnectivityManager) contextD.getSystemService("connectivity");
            this.ka = (TelephonyManager) contextD.getSystemService("phone");
        }
        ms((int) (((ka.ms().ah() / 1000) / 60) / 60));
    }

    public static ms ms() {
        if (f1322ms == null) {
            synchronized (ms.class) {
                if (f1322ms == null) {
                    f1322ms = new ms();
                }
            }
        }
        return f1322ms;
    }

    private static boolean ms(ConnectivityManager connectivityManager) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public void ms(int i) {
        if (i <= 0) {
            this.xr = 1;
        } else if (i > 168) {
            this.xr = 168;
        } else {
            this.xr = i;
        }
    }

    public int[] xr() {
        int[] iArr = new int[this.xr];
        LinkedList<JSONObject> linkedListMs = xr.ms().ms("sp_net");
        if (linkedListMs != null && linkedListMs.size() > 0) {
            int iOptLong = (int) (((linkedListMs.getLast().optLong(bv.aI, 0L) / 1000) / 60) / 60);
            for (JSONObject jSONObject : linkedListMs) {
                long jOptLong = jSONObject.optLong(bv.aI, 0L);
                int iOptInt = jSONObject.optInt("val", 0);
                int i = iOptLong - ((int) (((jOptLong / 1000) / 60) / 60));
                if (i >= 0 && i < this.xr) {
                    iArr[i] = iOptInt;
                }
            }
        }
        return iArr;
    }

    public int[] ah() {
        int[] iArr = new int[this.xr];
        LinkedList<JSONObject> linkedListMs = xr.ms().ms("sp_screen");
        if (linkedListMs != null && linkedListMs.size() > 0) {
            int iCurrentTimeMillis = (int) (((System.currentTimeMillis() / 1000) / 60) / 60);
            for (JSONObject jSONObject : linkedListMs) {
                long jOptLong = jSONObject.optLong(bv.aI, 0L);
                int iOptInt = jSONObject.optInt("val", 0);
                int i = iCurrentTimeMillis - ((int) (((jOptLong / 1000) / 60) / 60));
                if (i >= 0 && i < this.xr) {
                    iArr[i] = iOptInt;
                }
            }
        }
        return iArr;
    }

    public int d() {
        this.d = c();
        return this.d;
    }

    private int c() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = this.ah;
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable() || (activeNetwork = this.ah.getActiveNetwork()) == null || (networkCapabilities = this.ah.getNetworkCapabilities(activeNetwork)) == null) {
                return 0;
            }
            boolean zHasTransport = networkCapabilities.hasTransport(0);
            boolean zHasTransport2 = networkCapabilities.hasTransport(1);
            if (ms(this.ah) && zHasTransport2) {
                return 3;
            }
            if (zHasTransport2) {
                return 1;
            }
            return zHasTransport ? 2 : 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public int ka() {
        TelephonyManager telephonyManager = this.ka;
        if (telephonyManager != null) {
            return telephonyManager.getSimState();
        }
        return -1;
    }
}
