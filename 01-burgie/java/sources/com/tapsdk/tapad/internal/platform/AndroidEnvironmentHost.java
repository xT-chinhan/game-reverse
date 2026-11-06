package com.tapsdk.tapad.internal.platform;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.player.C;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.tapsdk.tapad.TapAdCustomController;
import com.tapsdk.tapad.internal.ionia.IoniaIdentityManager;
import com.tapsdk.tapad.internal.ionia.IoniaInstalledApps;
import com.tapsdk.tapad.internal.runtime.AndroidDeviceFacts;
import com.tapsdk.tapad.internal.runtime.AndroidPrivacyPolicy;
import com.tapsdk.tapad.internal.runtime.PrivacyFactCache;
import com.tapsdk.tapad.internal.runtime.WasmModule;
import com.tapsdk.tapad.internal.utils.PermissionUtil;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class AndroidEnvironmentHost {
    private static final long LOCATION_MAX_AGE_MS = 300000;
    private static final long LOCATION_TIMEOUT_MS = 15000;
    private static final int MAX_PACKAGE_NAME_CHARS = 256;
    private static final int MAX_VISIBLE_USER_PACKAGES = 512;
    private static volatile TapAdCustomController adnController;
    private final PrivacyFactCache<String> bssidCache;
    private final Context context;
    private volatile LocationSnapshot latestLocation;
    private final PrivacyFactCache<Boolean> locationAttempts;
    private final AtomicLong locationGeneration;
    private LocationManager locationManager;
    private LocationRefresh locationRefresh;
    private final PrivacyFactCache<Boolean> packageAttempts;
    private volatile PackageSnapshot packageSnapshot;
    private final Runnable privacyChanged;
    private volatile boolean released;
    private final PrivacyFactCache<JSONArray> sensorCache;
    private final PrivacyFactCache<String> ssidCache;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final AtomicBoolean packageQueryRunning = new AtomicBoolean();
    private final AtomicLong privacyGeneration = new AtomicLong();

    public final class LocationRefresh implements LocationListener {
        final long generation;
        final int permissionLevel;
        final long ticket;
        final Runnable timeout = new Runnable() { // from class: com.tapsdk.tapad.internal.platform.AndroidEnvironmentHost$LocationRefresh$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.stop();
            }
        };

        public LocationRefresh(long j, long j2, int i) {
            this.ticket = j;
            this.generation = j2;
            this.permissionLevel = i;
        }

        public boolean allowed() {
            return AndroidEnvironmentHost.this.locationRefresh == this && this.generation == AndroidEnvironmentHost.this.locationGeneration.get() && AndroidEnvironmentHost.this.locationAllowed() && this.permissionLevel <= AndroidEnvironmentHost.this.locationPermissionLevel();
        }

        public boolean cache(Location location) {
            LocationSnapshot locationSnapshotFrom;
            if (!allowed() || (locationSnapshotFrom = LocationSnapshot.from(location, this.generation, this.permissionLevel)) == null || !allowed()) {
                return false;
            }
            LocationSnapshot locationSnapshot = AndroidEnvironmentHost.this.latestLocation;
            if (locationSnapshot == null || locationSnapshot.generation != this.generation || !locationSnapshot.isFresh() || locationSnapshot.permissionLevel > this.permissionLevel || locationSnapshotFrom.measuredAtMs >= locationSnapshot.measuredAtMs) {
                AndroidEnvironmentHost.this.latestLocation = locationSnapshotFrom;
            }
            if (!allowed() && AndroidEnvironmentHost.this.latestLocation == locationSnapshotFrom) {
                AndroidEnvironmentHost.this.latestLocation = null;
            }
            return allowed();
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (AndroidEnvironmentHost.this.locationRefresh != this) {
                return;
            }
            if (!allowed()) {
                stop();
            } else if (cache(location)) {
                stop();
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            stop();
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        public void stop() {
            AndroidEnvironmentHost.this.mainHandler.removeCallbacks(this.timeout);
            if (AndroidEnvironmentHost.this.locationRefresh != this) {
                return;
            }
            AndroidEnvironmentHost.this.locationRefresh = null;
            AndroidEnvironmentHost.this.locationAttempts.complete(this.ticket, Boolean.TRUE);
            if (AndroidEnvironmentHost.this.locationManager != null) {
                try {
                    AndroidEnvironmentHost.this.locationManager.removeUpdates(this);
                } catch (Throwable th) {
                }
            }
        }
    }

    public static final class LocationSnapshot {
        final double accuracy;
        final long generation;
        final double latitude;
        final double longitude;
        final long measuredAtMs;
        final int permissionLevel;

        public LocationSnapshot(Location location, long j, long j2, int i) {
            this.latitude = location.getLatitude();
            this.longitude = location.getLongitude();
            this.accuracy = location.hasAccuracy() ? location.getAccuracy() : 0.0d;
            this.measuredAtMs = j;
            this.generation = j2;
            this.permissionLevel = i;
        }

        public static LocationSnapshot from(Location location, long j, int i) {
            long elapsedRealtimeNanos;
            if (location != null && "network".equals(location.getProvider()) && !Double.isNaN(location.getLatitude()) && Math.abs(location.getLatitude()) <= 90.0d && !Double.isNaN(location.getLongitude()) && Math.abs(location.getLongitude()) <= 180.0d && (!location.hasAccuracy() || (!Float.isNaN(location.getAccuracy()) && !Float.isInfinite(location.getAccuracy()) && location.getAccuracy() >= 0.0f))) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                if (location.getElapsedRealtimeNanos() < 0) {
                    return null;
                }
                if (location.getElapsedRealtimeNanos() <= 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (location.getTime() > 0 && location.getTime() <= jCurrentTimeMillis) {
                        long time = jCurrentTimeMillis - location.getTime();
                        if (time > AndroidEnvironmentHost.LOCATION_MAX_AGE_MS) {
                            return null;
                        }
                        elapsedRealtimeNanos = jElapsedRealtime - time;
                    }
                } else {
                    if (location.getElapsedRealtimeNanos() > SystemClock.elapsedRealtimeNanos()) {
                        return null;
                    }
                    elapsedRealtimeNanos = location.getElapsedRealtimeNanos() / C.MICROS_PER_SECOND;
                }
                LocationSnapshot locationSnapshot = new LocationSnapshot(location, elapsedRealtimeNanos, j, i);
                if (locationSnapshot.isFresh()) {
                    return locationSnapshot;
                }
            }
            return null;
        }

        public boolean isFresh() {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.measuredAtMs;
            return jElapsedRealtime >= 0 && jElapsedRealtime <= AndroidEnvironmentHost.LOCATION_MAX_AGE_MS;
        }

        public JSONObject toJson() {
            return new JSONObject().put(d.C, this.latitude).put(d.D, this.longitude).put("accuracy", this.accuracy);
        }
    }

    public static final class PackageSnapshot {
        static final PackageSnapshot EMPTY = new PackageSnapshot(0, Collections.EMPTY_LIST);
        final long accessVersion;
        final List<String> names;

        public PackageSnapshot(long j, List<String> list) {
            this.accessVersion = j;
            this.names = list;
        }
    }

    public AndroidEnvironmentHost(Context context) {
        Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.platform.AndroidEnvironmentHost$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.invalidatePrivateFacts();
            }
        };
        this.privacyChanged = runnable;
        this.locationGeneration = new AtomicLong();
        this.packageAttempts = new PrivacyFactCache<>();
        this.locationAttempts = new PrivacyFactCache<>();
        this.bssidCache = new PrivacyFactCache<>();
        this.ssidCache = new PrivacyFactCache<>();
        this.sensorCache = new PrivacyFactCache<>();
        this.packageSnapshot = PackageSnapshot.EMPTY;
        this.context = context == null ? null : context.getApplicationContext();
        AndroidPrivacyPolicy.addListener(runnable);
    }

    public static void bindAdnController(TapAdCustomController tapAdCustomController) {
        adnController = tapAdCustomController;
        AndroidPrivacyPolicy.configure(tapAdCustomController);
    }

    private static String boundedName(String str) {
        return str == null ? "" : str.substring(0, Math.min(128, str.length()));
    }

    public static JSONObject collectAdRequestIdentifiers(Context context) {
        return AndroidDeviceFacts.collectAdRequestIdentifiers(context, adnController);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray collectSensorInfo() {
        List<Sensor> sensorList;
        JSONArray jSONArray = new JSONArray();
        if (this.context != null && !this.released && AndroidPrivacyPolicy.allowsSensor()) {
            try {
                SensorManager sensorManager = (SensorManager) this.context.getSystemService(an.ac);
                if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null) {
                    for (Sensor sensor : sensorList) {
                        if (sensor != null) {
                            if (jSONArray.length() >= 32 || !AndroidPrivacyPolicy.allowsSensor()) {
                                break;
                                break;
                            }
                            jSONArray.put(new JSONObject().put(Common.System.NAME, boundedName(sensor.getName())).put("vendor", boundedName(sensor.getVendor())).put("type", sensor.getType()).put("version", sensor.getVersion()).put("max_range", sensor.getMaximumRange()).put(an.z, sensor.getResolution()).put("power", sensor.getPower()).put("min_delay", sensor.getMinDelay()));
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
        return jSONArray;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:90:0x0111  */
    /* JADX WARN: Code duplicated, block: B:95:0x0126 A[Catch: JSONException -> 0x0130, TryCatch #2 {JSONException -> 0x0130, blocks: (B:93:0x0120, B:95:0x0126, B:99:0x0134, B:101:0x013a), top: B:109:0x0120 }] */
    private void collectWifi(JSONObject jSONObject, JSONObject jSONObject2) {
        WifiManager wifiManager;
        String str;
        String ssid;
        String bssid;
        boolean z = false;
        boolean z2 = jSONObject.optBoolean("wifi_bssid", false) && AndroidPrivacyPolicy.allowsBssid();
        if (jSONObject.optBoolean("wifi_ssid", false) && AndroidPrivacyPolicy.allowsSsid()) {
            z = true;
        }
        if (this.context == null || this.released) {
            return;
        }
        if (z2 || z) {
            if (!PermissionUtil.checkPermission(this.context, "android.permission.ACCESS_WIFI_STATE") || !PermissionUtil.checkPermission(this.context, "android.permission.ACCESS_FINE_LOCATION")) {
                this.bssidCache.invalidate();
                this.ssidCache.invalidate();
                return;
            }
            long jBegin = z2 ? this.bssidCache.begin(AndroidPrivacyPolicy.collectionIntervalMs()) : 0L;
            long jBegin2 = z ? this.ssidCache.begin(AndroidPrivacyPolicy.collectionIntervalMs()) : 0L;
            if (jBegin == 0 && jBegin2 == 0) {
                wifiManager = null;
            } else {
                try {
                    wifiManager = (WifiManager) this.context.getSystemService(NetworkUtil.NETWORK_TYPE_WIFI);
                } catch (Throwable th) {
                    str = null;
                    PrivacyFactCache<String> privacyFactCache = this.bssidCache;
                    if (!AndroidPrivacyPolicy.allowsBssid()) {
                        str = null;
                    }
                    privacyFactCache.complete(jBegin, str);
                    PrivacyFactCache<String> privacyFactCache2 = this.ssidCache;
                    AndroidPrivacyPolicy.allowsSsid();
                    privacyFactCache2.complete(jBegin2, null);
                    if (z2) {
                        try {
                            if (AndroidPrivacyPolicy.allowsBssid()) {
                                jSONObject2.put("wifi_bssid", this.bssidCache.value());
                            }
                        } catch (JSONException e) {
                            return;
                        }
                    }
                    if (z) {
                        return;
                    } else {
                        return;
                    }
                }
            }
            WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
            str = (connectionInfo == null || jBegin == 0 || !AndroidPrivacyPolicy.allowsBssid() || (bssid = connectionInfo.getBSSID()) == null || bssid.isEmpty() || "02:00:00:00:00:00".equals(bssid)) ? null : bssid;
            if (connectionInfo == null || jBegin2 == 0) {
                ssid = null;
            } else {
                try {
                    if (!AndroidPrivacyPolicy.allowsSsid() || (ssid = connectionInfo.getSSID()) == null || ssid.isEmpty() || "<unknown ssid>".equals(ssid)) {
                        ssid = null;
                    } else if (ssid.length() > 1 && ssid.startsWith("\"") && ssid.endsWith("\"")) {
                        ssid = ssid.substring(1, ssid.length() - 1);
                    }
                } catch (Throwable th2) {
                    PrivacyFactCache<String> privacyFactCache3 = this.bssidCache;
                    if (!AndroidPrivacyPolicy.allowsBssid()) {
                        str = null;
                    }
                    privacyFactCache3.complete(jBegin, str);
                    PrivacyFactCache<String> privacyFactCache4 = this.ssidCache;
                    AndroidPrivacyPolicy.allowsSsid();
                    privacyFactCache4.complete(jBegin2, null);
                }
            }
            PrivacyFactCache<String> privacyFactCache5 = this.bssidCache;
            if (!AndroidPrivacyPolicy.allowsBssid()) {
                str = null;
            }
            privacyFactCache5.complete(jBegin, str);
            this.ssidCache.complete(jBegin2, AndroidPrivacyPolicy.allowsSsid() ? ssid : null);
            if (z2) {
                if (AndroidPrivacyPolicy.allowsBssid()) {
                    jSONObject2.put("wifi_bssid", this.bssidCache.value());
                }
            }
            if (z || !AndroidPrivacyPolicy.allowsSsid()) {
                return;
            }
            jSONObject2.put("wifi_ssid", this.ssidCache.value());
        }
    }

    private List<String> currentUserPackages() {
        PackageSnapshot packageSnapshot = this.packageSnapshot;
        long jInstalledAppsAccessVersion = IoniaIdentityManager.getInstance().installedAppsAccessVersion();
        if (jInstalledAppsAccessVersion != 0 && jInstalledAppsAccessVersion == packageSnapshot.accessVersion) {
            return packageSnapshot.names;
        }
        if (this.packageSnapshot == packageSnapshot) {
            this.packageSnapshot = PackageSnapshot.EMPTY;
        }
        return Collections.EMPTY_LIST;
    }

    private void invalidateLocation() {
        this.locationGeneration.incrementAndGet();
        this.latestLocation = null;
        this.locationAttempts.invalidate();
        this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.platform.AndroidEnvironmentHost$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m188lambda$invalidateLocation$4$comtapsdktapadinternalplatformAndroidEnvironmentHost();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidatePrivateFacts() {
        this.privacyGeneration.incrementAndGet();
        if (this.released || !AndroidPrivacyPolicy.allowsLocation()) {
            invalidateLocation();
        }
        if (this.released || !AndroidPrivacyPolicy.allowsInstalledApps()) {
            this.packageSnapshot = PackageSnapshot.EMPTY;
            this.packageAttempts.invalidate();
        }
        if (this.released || !AndroidPrivacyPolicy.allowsBssid()) {
            this.bssidCache.invalidate();
        }
        if (this.released || !AndroidPrivacyPolicy.allowsSsid()) {
            this.ssidCache.invalidate();
        }
        if (this.released || !AndroidPrivacyPolicy.allowsSensor()) {
            this.sensorCache.invalidate();
        }
    }

    private static boolean isAdRequest(JSONObject jSONObject) {
        if (!jSONObject.optBoolean("adn_request_facts", false)) {
            return false;
        }
        if (jSONObject.has("ad_request")) {
            return jSONObject.optBoolean("ad_request", false);
        }
        Integer num = 1;
        return num.equals(jSONObject.opt("schema_version")) && Boolean.TRUE.equals(jSONObject.opt("location")) && (jSONObject.opt("installed_packages") instanceof Boolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean locationAllowed() {
        return !this.released && this.context != null && AndroidPrivacyPolicy.allowsLocation() && PermissionUtil.checkPermission(this.context, "android.permission.ACCESS_COARSE_LOCATION");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int locationPermissionLevel() {
        Context context = this.context;
        if (context == null) {
            return 0;
        }
        if (PermissionUtil.checkPermission(context, "android.permission.ACCESS_FINE_LOCATION")) {
            return 2;
        }
        return PermissionUtil.checkPermission(this.context, "android.permission.ACCESS_COARSE_LOCATION") ? 1 : 0;
    }

    private void prefetchLocationOnMain() {
        if (!locationAllowed()) {
            invalidateLocation();
            return;
        }
        if (this.locationRefresh != null) {
            return;
        }
        long jBegin = this.locationAttempts.begin(AndroidPrivacyPolicy.collectionIntervalMs());
        if (jBegin == 0) {
            return;
        }
        LocationRefresh locationRefresh = new LocationRefresh(jBegin, this.locationGeneration.get(), locationPermissionLevel());
        this.locationRefresh = locationRefresh;
        try {
            if (this.locationManager == null) {
                this.locationManager = (LocationManager) this.context.getSystemService("location");
            }
            if (this.locationManager == null) {
                locationRefresh.stop();
                return;
            }
            if (!locationRefresh.allowed() || !this.locationManager.isProviderEnabled("network")) {
                locationRefresh.stop();
                return;
            }
            try {
                locationRefresh.cache(this.locationManager.getLastKnownLocation("network"));
            } catch (Throwable th) {
            }
            if (!locationRefresh.allowed()) {
                locationRefresh.stop();
                return;
            }
            this.locationManager.requestLocationUpdates("network", 0L, 0.0f, locationRefresh, Looper.getMainLooper());
            if (this.locationRefresh == locationRefresh) {
                this.mainHandler.postDelayed(locationRefresh.timeout, 15000L);
            }
        } catch (Throwable th2) {
            locationRefresh.stop();
        }
    }

    private void prefetchPackages() {
        if (this.released || !AndroidPrivacyPolicy.allowsInstalledApps()) {
            return;
        }
        final IoniaIdentityManager ioniaIdentityManager = IoniaIdentityManager.getInstance();
        currentUserPackages();
        final long jInstalledAppsAccessVersion = ioniaIdentityManager.installedAppsAccessVersion();
        if (jInstalledAppsAccessVersion != 0 && this.packageQueryRunning.compareAndSet(false, true)) {
            final long jBegin = this.packageAttempts.begin(AndroidPrivacyPolicy.collectionIntervalMs());
            if (jBegin == 0) {
                this.packageQueryRunning.set(false);
                return;
            }
            final long j = this.privacyGeneration.get();
            try {
                ioniaIdentityManager.collectInstalledApps(new WasmModule.SecurityExecPermission() { // from class: com.tapsdk.tapad.internal.platform.AndroidEnvironmentHost$$ExternalSyntheticLambda3
                    @Override // com.tapsdk.tapad.internal.runtime.WasmModule.SecurityExecPermission
                    public final boolean isAllowed() {
                        return this.f$0.m190lambda$prefetchPackages$2$comtapsdktapadinternalplatformAndroidEnvironmentHost(j, jInstalledAppsAccessVersion, ioniaIdentityManager);
                    }
                }, new IoniaInstalledApps.Callback() { // from class: com.tapsdk.tapad.internal.platform.AndroidEnvironmentHost$$ExternalSyntheticLambda4
                    @Override // com.tapsdk.tapad.internal.ionia.IoniaInstalledApps.Callback
                    public final void onResult(IoniaInstalledApps.Result result) {
                        this.f$0.m191lambda$prefetchPackages$3$comtapsdktapadinternalplatformAndroidEnvironmentHost(j, jInstalledAppsAccessVersion, ioniaIdentityManager, jBegin, result);
                    }
                });
            } catch (Throwable th) {
                this.packageAttempts.complete(jBegin, Boolean.FALSE);
                this.packageQueryRunning.set(false);
            }
        }
    }

    public static void refreshAdRequestIdentifierCache(Context context) {
        AndroidDeviceFacts.refreshAdRequestIdentifierCache(context, adnController);
    }

    public static List<String> visibleUserPackageNames(IoniaInstalledApps.Result result) {
        String str;
        if (result == null || result.status != IoniaInstalledApps.Status.OK) {
            return Collections.EMPTY_LIST;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (IoniaInstalledApps.App app : result.apps) {
            if (!app.systemApp && (str = app.packageName) != null && !str.trim().isEmpty() && app.packageName.length() <= 256) {
                linkedHashSet.add(app.packageName);
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashSet);
        Collections.sort(arrayList);
        if (arrayList.size() > 512) {
            arrayList = new ArrayList(arrayList.subList(0, 512));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: renamed from: lambda$invalidateLocation$4$com-tapsdk-tapad-internal-platform-AndroidEnvironmentHost, reason: not valid java name */
    /* synthetic */ void m188lambda$invalidateLocation$4$comtapsdktapadinternalplatformAndroidEnvironmentHost() {
        LocationRefresh locationRefresh = this.locationRefresh;
        if (locationRefresh == null || locationRefresh.generation == this.locationGeneration.get()) {
            return;
        }
        locationRefresh.stop();
    }

    /* JADX INFO: renamed from: lambda$prefetch$0$com-tapsdk-tapad-internal-platform-AndroidEnvironmentHost, reason: not valid java name */
    /* synthetic */ void m189lambda$prefetch$0$comtapsdktapadinternalplatformAndroidEnvironmentHost(long j) {
        if (j == this.locationGeneration.get()) {
            prefetchLocationOnMain();
        }
    }

    /* JADX INFO: renamed from: lambda$prefetchPackages$2$com-tapsdk-tapad-internal-platform-AndroidEnvironmentHost, reason: not valid java name */
    /* synthetic */ boolean m190lambda$prefetchPackages$2$comtapsdktapadinternalplatformAndroidEnvironmentHost(long j, long j2, IoniaIdentityManager ioniaIdentityManager) {
        return !this.released && j == this.privacyGeneration.get() && j2 == ioniaIdentityManager.installedAppsAccessVersion();
    }

    /* JADX INFO: renamed from: lambda$prefetchPackages$3$com-tapsdk-tapad-internal-platform-AndroidEnvironmentHost, reason: not valid java name */
    /* synthetic */ void m191lambda$prefetchPackages$3$comtapsdktapadinternalplatformAndroidEnvironmentHost(long j, long j2, IoniaIdentityManager ioniaIdentityManager, long j3, IoniaInstalledApps.Result result) {
        try {
            if (!this.released && j == this.privacyGeneration.get() && AndroidPrivacyPolicy.allowsInstalledApps() && j2 == ioniaIdentityManager.installedAppsAccessVersion()) {
                this.packageSnapshot = new PackageSnapshot(j2, visibleUserPackageNames(result));
            }
        } finally {
            this.packageAttempts.complete(j3, Boolean.TRUE);
            this.packageQueryRunning.set(false);
        }
    }

    /* JADX INFO: renamed from: lambda$snapshot$1$com-tapsdk-tapad-internal-platform-AndroidEnvironmentHost, reason: not valid java name */
    /* synthetic */ boolean m192lambda$snapshot$1$comtapsdktapadinternalplatformAndroidEnvironmentHost() {
        return !this.released && AndroidPrivacyPolicy.allowsSensor();
    }

    public boolean prefetch(JSONObject jSONObject) {
        if (this.context == null || jSONObject == null || this.released) {
            return false;
        }
        if (!isAdRequest(jSONObject)) {
            return true;
        }
        if (jSONObject.optBoolean("installed_packages", false) && AndroidPrivacyPolicy.allowsInstalledApps()) {
            prefetchPackages();
        } else if (!AndroidPrivacyPolicy.allowsInstalledApps()) {
            this.packageSnapshot = PackageSnapshot.EMPTY;
            this.packageAttempts.invalidate();
        }
        if (!locationAllowed()) {
            invalidateLocation();
        } else if (jSONObject.optBoolean("location", false)) {
            final long j = this.locationGeneration.get();
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.platform.AndroidEnvironmentHost$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m189lambda$prefetch$0$comtapsdktapadinternalplatformAndroidEnvironmentHost(j);
                }
            });
        }
        return true;
    }

    public void release() {
        this.released = true;
        AndroidPrivacyPolicy.removeListener(this.privacyChanged);
        invalidatePrivateFacts();
    }

    public JSONObject snapshot(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null && !this.released) {
            if (jSONObject.optBoolean("adn_request_facts", false)) {
                jSONObject2.put("adn_request_facts", isAdRequest(jSONObject) ? AndroidDeviceFacts.collectAdnRequestFacts(this.context, adnController) : AndroidDeviceFacts.collectAdnBootstrapRequestFacts(this.context, adnController));
            }
            if (isAdRequest(jSONObject)) {
                if (jSONObject.optBoolean("installed_packages", false) && AndroidPrivacyPolicy.allowsInstalledApps()) {
                    jSONObject2.put("installed_packages", new JSONArray((Collection) currentUserPackages()));
                }
                if (!locationAllowed()) {
                    invalidateLocation();
                } else if (jSONObject.optBoolean("location", false)) {
                    LocationSnapshot locationSnapshot = this.latestLocation;
                    if (locationSnapshot != null && locationSnapshot.generation == this.locationGeneration.get() && locationSnapshot.isFresh() && locationSnapshot.permissionLevel <= locationPermissionLevel() && locationAllowed()) {
                        jSONObject2.put("geo", locationSnapshot.toJson());
                    } else if (this.latestLocation == locationSnapshot) {
                        this.latestLocation = null;
                    }
                }
                collectWifi(jSONObject, jSONObject2);
                if (jSONObject.optBoolean("sensors", false) && AndroidPrivacyPolicy.allowsSensor()) {
                    JSONArray jSONArray = this.sensorCache.read(new PrivacyFactCache.Permission() { // from class: com.tapsdk.tapad.internal.platform.AndroidEnvironmentHost$$ExternalSyntheticLambda5
                        @Override // com.tapsdk.tapad.internal.runtime.PrivacyFactCache.Permission
                        public final boolean allowed() {
                            return this.f$0.m192lambda$snapshot$1$comtapsdktapadinternalplatformAndroidEnvironmentHost();
                        }
                    }, AndroidPrivacyPolicy.collectionIntervalMs(), new PrivacyFactCache.Probe() { // from class: com.tapsdk.tapad.internal.platform.AndroidEnvironmentHost$$ExternalSyntheticLambda6
                        @Override // com.tapsdk.tapad.internal.runtime.PrivacyFactCache.Probe
                        public final Object read() {
                            return this.f$0.collectSensorInfo();
                        }
                    });
                    if (AndroidPrivacyPolicy.allowsSensor() && jSONArray != null && jSONArray.length() > 0) {
                        jSONObject2.put("sensors", jSONArray);
                    }
                }
            }
        }
        return jSONObject2;
    }
}
