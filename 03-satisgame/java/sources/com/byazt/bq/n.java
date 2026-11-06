package com.byazt.bq;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.byazt.vf.k;
import com.byazt.vf.wo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 290, 19})
public class n {
    public static volatile long l = 0;
    public static long n = 1800000;
    public static volatile long q = 0;
    public static long qg = 60000;
    public static volatile com.byazt.tr.n s;

    public static com.byazt.hsi.n n(Context context, boolean z, com.byazt.vf.n nVar) {
        return qg(context, z, nVar);
    }

    public static com.byazt.tr.n qg(Context context, boolean z, com.byazt.vf.n nVar) {
        if ((s != null && !n()) || !qg()) {
            return s;
        }
        String strQ = ((k) com.byazt.qp.q.n("encrypt_service")).q(fs.qg("new_sdk_ad_location", 2147483647L, nVar));
        if (strQ != null) {
            try {
                JSONObject jSONObject = new JSONObject(strQ);
                String strOptString = jSONObject.optString("latitude");
                String strOptString2 = jSONObject.optString("longitude");
                long jOptLong = jSONObject.optLong("lbstime");
                if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                    s = new com.byazt.tr.n(Float.valueOf(strOptString).floatValue(), Float.valueOf(strOptString2).floatValue(), jOptLong);
                    l = jOptLong;
                }
            } catch (Throwable unused) {
            }
            if (z) {
                return s;
            }
        }
        if (s != null && !n()) {
            return s;
        }
        com.byazt.tbi.n nVarCp = nVar.cp();
        if (!nVarCp.n()) {
            com.byazt.tbi.q qVarQg = nVarCp.qg();
            if (qVarQg != null) {
                l = System.currentTimeMillis();
                s = new com.byazt.tr.n((float) qVarQg.n(), (float) qVarQg.qg(), System.currentTimeMillis());
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                if (s != null) {
                    jSONObject2.put("latitude", Float.toString(s.n));
                    jSONObject2.put("longitude", Float.toString(s.qg));
                    jSONObject2.put("lbstime", s.s);
                }
                fs.s("new_sdk_ad_location", ((k) com.byazt.qp.q.n("encrypt_service")).s(jSONObject2.toString()), nVar);
            } catch (Exception unused2) {
            }
            return s;
        }
        l = System.currentTimeMillis();
        q = System.currentTimeMillis();
        qg(context, nVar);
        return s;
    }

    private static void qg(final Context context, final com.byazt.vf.n nVar) {
        ((wo) com.byazt.qp.q.n("thread_service")).qg().execute(new com.byazt.qit.x("getLocation c") { // from class: com.byazt.bq.n.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tr.n nVarS = n.s(context.getApplicationContext(), nVar);
                long unused = n.q = 0L;
                if (nVarS != null) {
                    com.byazt.tr.n unused2 = n.s = nVarS;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("latitude", Float.toString(nVarS.n));
                        jSONObject.put("longitude", Float.toString(nVarS.qg));
                        jSONObject.put("lbstime", nVarS.s);
                        fs.s("new_sdk_ad_location", ((k) com.byazt.qp.q.n("encrypt_service")).s(jSONObject.toString()), nVar);
                    } catch (JSONException unused3) {
                    }
                }
            }
        });
    }

    private static boolean n() {
        return System.currentTimeMillis() - l > n;
    }

    private static boolean qg() {
        return System.currentTimeMillis() - q > qg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.byazt.tr.n s(final Context context, com.byazt.vf.n nVar) {
        com.byazt.tr.n nVar2 = null;
        if (!nVar.cp().n()) {
            try {
                com.byazt.tbi.q qVarN = n(nVar);
                if (qVarN != null) {
                    return new com.byazt.tr.n(Double.valueOf(qVarN.n()).floatValue(), Double.valueOf(qVarN.qg()).floatValue(), System.currentTimeMillis());
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        final LocationManager locationManagerN = n(context);
        if (locationManagerN != null) {
            try {
                Location locationN = n(locationManagerN);
                if (locationN != null && qg(locationN)) {
                    nVar2 = new com.byazt.tr.n((float) locationN.getLatitude(), (float) locationN.getLongitude(), System.currentTimeMillis());
                }
                com.byazt.tk.rv.n().post(new Runnable() { // from class: com.byazt.bq.n.2
                    @Override // java.lang.Runnable
                    public void run() {
                        n.qg(context, locationManagerN);
                    }
                });
            } catch (Throwable unused2) {
            }
        }
        return nVar2;
    }

    private static LocationManager n(Context context) {
        try {
            return (LocationManager) context.getSystemService("location");
        } catch (Exception unused) {
            return null;
        }
    }

    private static Location n(LocationManager locationManager) {
        Location locationN = n(locationManager, "gps");
        if (locationN == null) {
            locationN = n(locationManager, "network");
        }
        return locationN == null ? n(locationManager, "passive") : locationN;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Location n(LocationManager locationManager, String str) {
        try {
            final com.byazt.qit.w wVar = new com.byazt.qit.w(new qg(locationManager, str), 1, 2);
            ((wo) com.byazt.qp.q.n("thread_service")).qg().execute(new com.byazt.qit.x("getLastKnownLocation") { // from class: com.byazt.bq.n.3
                @Override // java.lang.Runnable
                public void run() {
                    wVar.run();
                }
            });
            return (Location) wVar.get(1L, TimeUnit.SECONDS);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static com.byazt.tbi.q n(com.byazt.vf.n nVar) {
        try {
            final com.byazt.qit.w wVar = new com.byazt.qit.w(new CallableC0147n(nVar), 1, 2);
            ((wo) com.byazt.qp.q.n("thread_service")).qg().execute(new com.byazt.qit.x("getLastKnownLocation") { // from class: com.byazt.bq.n.4
                @Override // java.lang.Runnable
                public void run() {
                    wVar.run();
                }
            });
            return (com.byazt.tbi.q) wVar.get(1L, TimeUnit.SECONDS);
        } catch (Throwable unused) {
            return null;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 290, 226})
    private static class qg implements Callable<Location> {
        public LocationManager n;
        public String qg;

        public qg(LocationManager locationManager, String str) {
            this.n = locationManager;
            this.qg = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Location call() throws Exception {
            System.currentTimeMillis();
            Location lastKnownLocation = this.n.getLastKnownLocation(this.qg);
            System.currentTimeMillis();
            return lastKnownLocation;
        }
    }

    /* JADX INFO: renamed from: com.byazt.bq.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 290, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private static class CallableC0147n implements Callable<com.byazt.tbi.q> {
        public com.byazt.vf.n n;

        public CallableC0147n(com.byazt.vf.n nVar) {
            this.n = nVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.byazt.tbi.q call() throws Exception {
            return this.n.cp().qg();
        }
    }

    private static String qg(LocationManager locationManager) {
        if (locationManager.isProviderEnabled("gps")) {
            return "gps";
        }
        if (locationManager.isProviderEnabled("network")) {
            return "network";
        }
        if (locationManager.isProviderEnabled("passive")) {
            return "passive";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(Context context, final LocationManager locationManager) {
        if (context == null || locationManager == null) {
            return;
        }
        final LocationListener locationListener = new LocationListener() { // from class: com.byazt.bq.n.5
            @Override // android.location.LocationListener
            public void onProviderDisabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onProviderEnabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onStatusChanged(String str, int i, Bundle bundle) {
            }

            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                if (location != null) {
                    n.qg(location);
                }
                n.qg(locationManager, this);
            }
        };
        try {
            String strQg = qg(locationManager);
            if (TextUtils.isEmpty(strQg)) {
                return;
            }
            locationManager.requestSingleUpdate(strQg, locationListener, Looper.myLooper());
            com.byazt.tk.rv.n().postDelayed(new Runnable() { // from class: com.byazt.bq.n.6
                @Override // java.lang.Runnable
                public void run() {
                    n.qg(locationManager, locationListener);
                }
            }, 30000L);
        } catch (Throwable unused) {
            qg(locationManager, locationListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(LocationManager locationManager, LocationListener locationListener) {
        if (locationManager == null || locationListener == null) {
            return;
        }
        try {
            locationManager.removeUpdates(locationListener);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean qg(Location location) {
        return (location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) ? false : true;
    }
}
