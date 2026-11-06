package com.byazt.wqv;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.byazt.yi.zo;
import com.umeng.analytics.pro.an;
import java.lang.reflect.Method;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 399, 37})
public class pr {
    public static volatile pr pr;
    public TelephonyManager c;
    public ConnectivityManager hn;
    public volatile int hw;
    public volatile int x = -1;

    public pr() {
        this.hn = null;
        this.c = null;
        Context contextHn = zo.hn();
        if (contextHn != null) {
            this.hn = (ConnectivityManager) contextHn.getSystemService("connectivity");
            this.c = (TelephonyManager) contextHn.getSystemService("phone");
        }
        pr((int) (((c.pr().hn() / 1000) / 60) / 60));
    }

    public static pr pr() {
        if (pr == null) {
            synchronized (pr.class) {
                if (pr == null) {
                    pr = new pr();
                }
            }
        }
        return pr;
    }

    private static boolean pr(ConnectivityManager connectivityManager) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception e) {
            return false;
        }
    }

    public void pr(int i) {
        if (i <= 0) {
            this.hw = 1;
        } else if (i > 168) {
            this.hw = 168;
        } else {
            this.hw = i;
        }
    }

    public int[] hw() {
        int[] iArr = new int[this.hw];
        LinkedList<JSONObject> linkedListPr = hw.pr().pr("sp_net");
        if (linkedListPr != null && !linkedListPr.isEmpty()) {
            int iOptLong = (int) (((linkedListPr.get(linkedListPr.size() - 1).optLong(an.aI, 0L) / 1000) / 60) / 60);
            for (JSONObject jSONObject : linkedListPr) {
                long jOptLong = jSONObject.optLong(an.aI, 0L);
                int iOptInt = jSONObject.optInt("val", 0);
                int i = iOptLong - ((int) (((jOptLong / 1000) / 60) / 60));
                if (i >= 0 && i < this.hw) {
                    iArr[i] = iOptInt;
                }
            }
        }
        return iArr;
    }

    public int[] hn() {
        int[] iArr = new int[this.hw];
        LinkedList<JSONObject> linkedListPr = hw.pr().pr("sp_screen");
        if (linkedListPr != null && linkedListPr.size() > 0) {
            int iCurrentTimeMillis = (int) (((System.currentTimeMillis() / 1000) / 60) / 60);
            for (JSONObject jSONObject : linkedListPr) {
                long jOptLong = jSONObject.optLong(an.aI, 0L);
                int iOptInt = jSONObject.optInt("val", 0);
                int i = iCurrentTimeMillis - ((int) (((jOptLong / 1000) / 60) / 60));
                if (i >= 0 && i < this.hw) {
                    iArr[i] = iOptInt;
                }
            }
        }
        return iArr;
    }

    public int x() {
        this.x = uc();
        return this.x;
    }

    private int uc() {
        NetworkCapabilities networkCapabilities;
        NetworkInfo activeNetworkInfo = null;
        try {
            ConnectivityManager connectivityManager = this.hn;
            if (connectivityManager != null) {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            }
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (Build.VERSION.SDK_INT >= 23) {
                    Network activeNetwork = this.hn.getActiveNetwork();
                    if (activeNetwork == null || (networkCapabilities = this.hn.getNetworkCapabilities(activeNetwork)) == null) {
                        return 0;
                    }
                    boolean zHasTransport = networkCapabilities.hasTransport(0);
                    boolean zHasTransport2 = networkCapabilities.hasTransport(1);
                    if (pr(this.hn) && zHasTransport2) {
                        return 3;
                    }
                    if (zHasTransport2) {
                        return 1;
                    }
                    return zHasTransport ? 2 : 0;
                }
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    return pr(this.hn) ? 3 : 1;
                }
                return type == 0 ? 2 : 0;
            }
            return 0;
        } catch (Exception e) {
        }
    }

    public int c() {
        TelephonyManager telephonyManager = this.c;
        if (telephonyManager != null) {
            return telephonyManager.getSimState();
        }
        return -1;
    }
}
