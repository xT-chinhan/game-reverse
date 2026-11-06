package com.byazt.zqc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.byazt.tka.tj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Method;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_START_TIME, 19})
public class n {
    public static volatile n n;
    public TelephonyManager l;
    public volatile int q = -1;
    public volatile int qg;
    public ConnectivityManager s;

    public n() {
        this.s = null;
        this.l = null;
        Context contextS = tj.s();
        if (contextS != null) {
            this.s = (ConnectivityManager) contextS.getSystemService("connectivity");
            this.l = (TelephonyManager) contextS.getSystemService("phone");
        }
        n((int) (((l.n().s() / 1000) / 60) / 60));
    }

    public static n n() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n();
                }
            }
        }
        return n;
    }

    private static boolean n(ConnectivityManager connectivityManager) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public void n(int i) {
        if (i <= 0) {
            this.qg = 1;
        } else if (i > 168) {
            this.qg = 168;
        } else {
            this.qg = i;
        }
    }

    public int[] qg() {
        int[] iArr = new int[this.qg];
        LinkedList<JSONObject> linkedListN = qg.n().n("sp_net");
        if (linkedListN != null && !linkedListN.isEmpty()) {
            int iOptLong = (int) (((linkedListN.get(linkedListN.size() - 1).optLong("t", 0L) / 1000) / 60) / 60);
            for (JSONObject jSONObject : linkedListN) {
                long jOptLong = jSONObject.optLong("t", 0L);
                int iOptInt = jSONObject.optInt("val", 0);
                int i = iOptLong - ((int) (((jOptLong / 1000) / 60) / 60));
                if (i >= 0 && i < this.qg) {
                    iArr[i] = iOptInt;
                }
            }
        }
        return iArr;
    }

    public int[] s() {
        int[] iArr = new int[this.qg];
        LinkedList<JSONObject> linkedListN = qg.n().n("sp_screen");
        if (linkedListN != null && linkedListN.size() > 0) {
            int iCurrentTimeMillis = (int) (((System.currentTimeMillis() / 1000) / 60) / 60);
            for (JSONObject jSONObject : linkedListN) {
                long jOptLong = jSONObject.optLong("t", 0L);
                int iOptInt = jSONObject.optInt("val", 0);
                int i = iCurrentTimeMillis - ((int) (((jOptLong / 1000) / 60) / 60));
                if (i >= 0 && i < this.qg) {
                    iArr[i] = iOptInt;
                }
            }
        }
        return iArr;
    }

    public int q() {
        this.q = w();
        return this.q;
    }

    private int w() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = this.s;
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable() || (activeNetwork = this.s.getActiveNetwork()) == null || (networkCapabilities = this.s.getNetworkCapabilities(activeNetwork)) == null) {
                return 0;
            }
            boolean zHasTransport = networkCapabilities.hasTransport(0);
            boolean zHasTransport2 = networkCapabilities.hasTransport(1);
            if (n(this.s) && zHasTransport2) {
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

    public int l() {
        TelephonyManager telephonyManager = this.l;
        if (telephonyManager != null) {
            return telephonyManager.getSimState();
        }
        return -1;
    }
}
