package com.byazt.fp;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.byazt.vkw.nt;
import com.byazt.vkw.qi;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.MARCode;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, 37})
public class pr {
    public static long pr = 1800000;
    public static long hw = 60000;
    public static volatile com.byazt.ux.pr hn = null;
    public static volatile long x = 0;
    public static volatile long c = 0;

    public static com.byazt.apo.pr pr(Context context, boolean z, com.byazt.vkw.pr prVar) {
        return hw(context, z, prVar);
    }

    public static com.byazt.ux.pr hw(Context context, boolean z, com.byazt.vkw.pr prVar) {
        if ((hn != null && !pr()) || !hw()) {
            return hn;
        }
        String strX = ((nt) com.byazt.zs.uc.pr("encrypt_service")).x(zo.hw("new_sdk_ad_location", 2147483647L, prVar));
        if (strX != null) {
            try {
                JSONObject jSONObject = new JSONObject(strX);
                String strOptString = jSONObject.optString("latitude");
                String strOptString2 = jSONObject.optString("longitude");
                long jOptLong = jSONObject.optLong("lbstime");
                if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                    hn = new com.byazt.ux.pr(Float.valueOf(strOptString).floatValue(), Float.valueOf(strOptString2).floatValue(), jOptLong);
                    c = jOptLong;
                }
            } catch (Throwable th) {
            }
            if (z) {
                return hn;
            }
        }
        if (hn != null && !pr()) {
            return hn;
        }
        com.byazt.vlp.hw hwVarW = prVar.w();
        if (!hwVarW.pr()) {
            com.byazt.vlp.c cVarHw = hwVarW.hw();
            if (cVarHw != null) {
                c = System.currentTimeMillis();
                hn = new com.byazt.ux.pr((float) cVarHw.pr(), (float) cVarHw.hw(), System.currentTimeMillis());
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                if (hn != null) {
                    jSONObject2.put("latitude", Float.toString(hn.pr));
                    jSONObject2.put("longitude", Float.toString(hn.hw));
                    jSONObject2.put("lbstime", hn.hn);
                }
                zo.hn("new_sdk_ad_location", ((nt) com.byazt.zs.uc.pr("encrypt_service")).hn(jSONObject2.toString()), prVar);
            } catch (Exception e) {
            }
            return hn;
        }
        c = System.currentTimeMillis();
        x = System.currentTimeMillis();
        hw(context, prVar);
        return hn;
    }

    private static void hw(final Context context, final com.byazt.vkw.pr prVar) {
        ((qi) com.byazt.zs.uc.pr("thread_service")).hw().execute(new com.byazt.xlm.fw("getLocation c") { // from class: com.byazt.fp.pr.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.ux.pr prVarHn = pr.hn(context.getApplicationContext(), prVar);
                long unused = pr.x = 0L;
                if (prVarHn != null) {
                    com.byazt.ux.pr unused2 = pr.hn = prVarHn;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("latitude", Float.toString(prVarHn.pr));
                        jSONObject.put("longitude", Float.toString(prVarHn.hw));
                        jSONObject.put("lbstime", prVarHn.hn);
                        zo.hn("new_sdk_ad_location", ((nt) com.byazt.zs.uc.pr("encrypt_service")).hn(jSONObject.toString()), prVar);
                    } catch (JSONException e) {
                    }
                }
            }
        });
    }

    private static boolean pr() {
        return System.currentTimeMillis() - c > pr;
    }

    private static boolean hw() {
        return System.currentTimeMillis() - x > hw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.byazt.ux.pr hn(final Context context, com.byazt.vkw.pr prVar) {
        com.byazt.ux.pr prVar2 = null;
        if (!prVar.w().pr()) {
            try {
                com.byazt.vlp.c cVarPr = pr(prVar);
                if (cVarPr != null) {
                    return new com.byazt.ux.pr(Double.valueOf(cVarPr.pr()).floatValue(), Double.valueOf(cVarPr.hw()).floatValue(), System.currentTimeMillis());
                }
            } catch (Throwable th) {
            }
            return null;
        }
        final LocationManager locationManagerPr = pr(context);
        if (locationManagerPr != null) {
            try {
                Location locationPr = pr(locationManagerPr);
                if (locationPr != null && hw(locationPr)) {
                    prVar2 = new com.byazt.ux.pr((float) locationPr.getLatitude(), (float) locationPr.getLongitude(), System.currentTimeMillis());
                }
                com.byazt.ca.aj.pr().post(new Runnable() { // from class: com.byazt.fp.pr.2
                    @Override // java.lang.Runnable
                    public void run() {
                        pr.hw(context, locationManagerPr);
                    }
                });
            } catch (Throwable th2) {
            }
        }
        return prVar2;
    }

    private static LocationManager pr(Context context) {
        try {
            return (LocationManager) context.getSystemService("location");
        } catch (Exception e) {
            return null;
        }
    }

    private static Location pr(LocationManager locationManager) {
        Location locationPr = pr(locationManager, "gps");
        if (locationPr == null) {
            locationPr = pr(locationManager, "network");
        }
        if (locationPr == null) {
            return pr(locationManager, "passive");
        }
        return locationPr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Location pr(LocationManager locationManager, String str) {
        try {
            final com.byazt.xlm.uc ucVar = new com.byazt.xlm.uc(new hw(locationManager, str), 1, 2);
            ((qi) com.byazt.zs.uc.pr("thread_service")).hw().execute(new com.byazt.xlm.fw("getLastKnownLocation") { // from class: com.byazt.fp.pr.3
                @Override // java.lang.Runnable
                public void run() {
                    ucVar.run();
                }
            });
            return (Location) ucVar.get(1L, TimeUnit.SECONDS);
        } catch (Throwable th) {
            return null;
        }
    }

    private static com.byazt.vlp.c pr(com.byazt.vkw.pr prVar) {
        try {
            final com.byazt.xlm.uc ucVar = new com.byazt.xlm.uc(new CallableC0070pr(prVar), 1, 2);
            ((qi) com.byazt.zs.uc.pr("thread_service")).hw().execute(new com.byazt.xlm.fw("getLastKnownLocation") { // from class: com.byazt.fp.pr.4
                @Override // java.lang.Runnable
                public void run() {
                    ucVar.run();
                }
            });
            return (com.byazt.vlp.c) ucVar.get(1L, TimeUnit.SECONDS);
        } catch (Throwable th) {
            return null;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE})
    private static class hw implements Callable<Location> {
        public String hw;
        public LocationManager pr;

        public hw(LocationManager locationManager, String str) {
            this.pr = locationManager;
            this.hw = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Location call() throws Exception {
            System.currentTimeMillis();
            Location lastKnownLocation = this.pr.getLastKnownLocation(this.hw);
            System.currentTimeMillis();
            return lastKnownLocation;
        }
    }

    /* JADX INFO: renamed from: com.byazt.fp.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    private static class CallableC0070pr implements Callable<com.byazt.vlp.c> {
        public com.byazt.vkw.pr pr;

        public CallableC0070pr(com.byazt.vkw.pr prVar) {
            this.pr = prVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.byazt.vlp.c call() throws Exception {
            return this.pr.w().hw();
        }
    }

    private static String hw(LocationManager locationManager) {
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
    public static void hw(Context context, final LocationManager locationManager) {
        if (context == null || locationManager == null) {
            return;
        }
        final LocationListener locationListener = new LocationListener() { // from class: com.byazt.fp.pr.5
            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                if (location != null) {
                    pr.hw(location);
                }
                pr.hw(locationManager, this);
            }

            @Override // android.location.LocationListener
            public void onStatusChanged(String str, int i, Bundle bundle) {
            }

            @Override // android.location.LocationListener
            public void onProviderEnabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onProviderDisabled(String str) {
            }
        };
        try {
            String strHw = hw(locationManager);
            if (TextUtils.isEmpty(strHw)) {
                return;
            }
            locationManager.requestSingleUpdate(strHw, locationListener, Looper.myLooper());
            com.byazt.ca.aj.pr().postDelayed(new Runnable() { // from class: com.byazt.fp.pr.6
                @Override // java.lang.Runnable
                public void run() {
                    pr.hw(locationManager, locationListener);
                }
            }, 30000L);
        } catch (Throwable th) {
            hw(locationManager, locationListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(LocationManager locationManager, LocationListener locationListener) {
        if (locationManager == null || locationListener == null) {
            return;
        }
        try {
            locationManager.removeUpdates(locationListener);
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hw(Location location) {
        return (location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) ? false : true;
    }
}
