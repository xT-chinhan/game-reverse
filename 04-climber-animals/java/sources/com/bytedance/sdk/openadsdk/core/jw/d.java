package com.bytedance.sdk.openadsdk.core.jw;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    private static volatile ah ah = null;
    private static volatile long d = 0;
    private static volatile long ka = 0;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static long f2692ms = 1800000;
    private static long xr = 60000;

    public static ah ms(Context context) {
        return ms(context, !com.bytedance.sdk.openadsdk.core.ah.ms.xr());
    }

    public static ah ms(Context context, boolean z) {
        if ((ah != null && !ms()) || !xr()) {
            return ah;
        }
        String strAh = com.bytedance.sdk.component.utils.ms.ah(com.bytedance.sdk.openadsdk.core.ah.d.ms().d("new_sdk_ad_location", 2147483647L));
        if (strAh != null) {
            try {
                JSONObject jSONObject = new JSONObject(strAh);
                String strOptString = jSONObject.optString("latitude");
                String strOptString2 = jSONObject.optString("longitude");
                long jOptLong = jSONObject.optLong("lbstime");
                if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                    ah = new ah(Float.valueOf(strOptString).floatValue(), Float.valueOf(strOptString2).floatValue(), jOptLong);
                    ka = jOptLong;
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.sl.ms(th);
            }
            if (z) {
                return ah;
            }
        }
        if (ah != null && !ms()) {
            return ah;
        }
        com.bytedance.sdk.openadsdk.core.f.ka kaVarAo = com.bytedance.sdk.openadsdk.core.ch.ub().ao();
        if (!kaVarAo.ms()) {
            com.bytedance.sdk.openadsdk.ao.xr.ah.ah ahVarX = kaVarAo.x();
            if (ahVarX != null) {
                ka = System.currentTimeMillis();
                ah = new ah((float) ahVarX.ms(), (float) ahVarX.xr(), System.currentTimeMillis());
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                if (ah != null) {
                    jSONObject2.put("latitude", Float.toString(ah.f2673ms));
                    jSONObject2.put("longitude", Float.toString(ah.xr));
                    jSONObject2.put("lbstime", ah.ah);
                }
                String string = jSONObject2.toString();
                String strXr = com.bytedance.sdk.component.utils.ms.xr(string);
                com.bytedance.sdk.openadsdk.core.ah.d.ms().d("sdk_ad_location", string);
                com.bytedance.sdk.openadsdk.core.ah.d.ms().d("new_sdk_ad_location", strXr);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
            }
            return ah;
        }
        ka = System.currentTimeMillis();
        d = System.currentTimeMillis();
        final Context context2 = context == null ? com.bytedance.sdk.openadsdk.core.re.getContext() : context.getApplicationContext();
        com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("getLocation c") { // from class: com.bytedance.sdk.openadsdk.core.jw.d.1
            @Override // java.lang.Runnable
            public void run() {
                ah ahVarAh = d.ah(context2);
                long unused = d.d = 0L;
                if (ahVarAh != null) {
                    ah unused2 = d.ah = ahVarAh;
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("latitude", Float.toString(ahVarAh.f2673ms));
                        jSONObject3.put("longitude", Float.toString(ahVarAh.xr));
                        jSONObject3.put("lbstime", ahVarAh.ah);
                        String string2 = jSONObject3.toString();
                        String strXr2 = com.bytedance.sdk.component.utils.ms.xr(string2);
                        com.bytedance.sdk.openadsdk.core.ah.d.ms().d("sdk_ad_location", string2);
                        com.bytedance.sdk.openadsdk.core.ah.d.ms().d("new_sdk_ad_location", strXr2);
                    } catch (JSONException e2) {
                        com.bytedance.sdk.component.utils.sl.ms(e2);
                    }
                }
            }
        });
        return ah;
    }

    private static boolean ms() {
        return System.currentTimeMillis() - ka > f2692ms;
    }

    private static boolean xr() {
        return System.currentTimeMillis() - d > xr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ah ah(final Context context) {
        ah ahVar = null;
        if (!com.bytedance.sdk.openadsdk.core.ch.ub().ao().ms()) {
            try {
                com.bytedance.sdk.openadsdk.ao.xr.ah.ah ahVarAh = ah();
                if (ahVarAh != null) {
                    return new ah(Double.valueOf(ahVarAh.ms()).floatValue(), Double.valueOf(ahVarAh.xr()).floatValue(), System.currentTimeMillis());
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        final LocationManager locationManagerD = d(context);
        if (locationManagerD != null) {
            try {
                Location locationMs = ms(locationManagerD);
                if (locationMs != null && xr(locationMs)) {
                    ahVar = new ah((float) locationMs.getLatitude(), (float) locationMs.getLongitude(), System.currentTimeMillis());
                }
                com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jw.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        d.xr(context, locationManagerD);
                    }
                });
            } catch (Throwable th) {
                if (com.bytedance.sdk.component.utils.sl.ah()) {
                    com.bytedance.sdk.component.utils.sl.ms(th);
                }
            }
        }
        return ahVar;
    }

    private static LocationManager d(Context context) {
        try {
            return (LocationManager) context.getSystemService("location");
        } catch (Exception unused) {
            return null;
        }
    }

    private static Location ms(LocationManager locationManager) {
        Location locationMs = ms(locationManager, "gps");
        if (locationMs == null) {
            locationMs = ms(locationManager, "network");
        }
        return locationMs == null ? ms(locationManager, "passive") : locationMs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Location ms(LocationManager locationManager, String str) {
        try {
            final com.bytedance.sdk.component.ch.x xVar = new com.bytedance.sdk.component.ch.x(new xr(locationManager, str), 1, 2);
            com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("getLastKnownLocation") { // from class: com.bytedance.sdk.openadsdk.core.jw.d.3
                @Override // java.lang.Runnable
                public void run() {
                    xVar.run();
                }
            });
            return (Location) xVar.get(1L, TimeUnit.SECONDS);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static com.bytedance.sdk.openadsdk.ao.xr.ah.ah ah() {
        try {
            final com.bytedance.sdk.component.ch.x xVar = new com.bytedance.sdk.component.ch.x(new ms(), 1, 2);
            com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("getLastKnownLocation") { // from class: com.bytedance.sdk.openadsdk.core.jw.d.4
                @Override // java.lang.Runnable
                public void run() {
                    xVar.run();
                }
            });
            return (com.bytedance.sdk.openadsdk.ao.xr.ah.ah) xVar.get(1L, TimeUnit.SECONDS);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static class xr implements Callable<Location> {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private LocationManager f2699ms;
        private String xr;

        public xr(LocationManager locationManager, String str) {
            this.f2699ms = locationManager;
            this.xr = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Location call() throws Exception {
            System.currentTimeMillis();
            Location lastKnownLocation = this.f2699ms.getLastKnownLocation(this.xr);
            System.currentTimeMillis();
            return lastKnownLocation;
        }
    }

    private static class ms implements Callable<com.bytedance.sdk.openadsdk.ao.xr.ah.ah> {
        private ms() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.bytedance.sdk.openadsdk.ao.xr.ah.ah call() throws Exception {
            return com.bytedance.sdk.openadsdk.core.ch.ub().ao().x();
        }
    }

    private static String xr(LocationManager locationManager) {
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
    public static void xr(Context context, final LocationManager locationManager) {
        if (context == null || locationManager == null) {
            return;
        }
        final LocationListener locationListener = new LocationListener() { // from class: com.bytedance.sdk.openadsdk.core.jw.d.5
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
                    d.xr(location);
                }
                d.xr(locationManager, this);
            }
        };
        try {
            if (TextUtils.isEmpty(xr(locationManager))) {
                return;
            }
            locationManager.requestSingleUpdate("network", locationListener, Looper.myLooper());
            com.bytedance.sdk.component.utils.x.ms().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jw.d.6
                @Override // java.lang.Runnable
                public void run() {
                    d.xr(locationManager, locationListener);
                }
            }, 30000L);
        } catch (Throwable th) {
            if (com.bytedance.sdk.component.utils.sl.ah()) {
                com.bytedance.sdk.component.utils.sl.ms(th);
            }
            xr(locationManager, locationListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(LocationManager locationManager, LocationListener locationListener) {
        if (locationManager == null || locationListener == null) {
            return;
        }
        try {
            locationManager.removeUpdates(locationListener);
        } catch (Throwable th) {
            if (com.bytedance.sdk.component.utils.sl.ah()) {
                com.bytedance.sdk.component.utils.sl.ms(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean xr(Location location) {
        return (location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) ? false : true;
    }
}
