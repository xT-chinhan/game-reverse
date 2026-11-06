package com.tapsdk.tapad.internal.runtime.bundle;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.BuildConfig;
import com.tapsdk.tapad.group.constants.Constants;
import com.tapsdk.tapad.internal.observability.AdnTelemetryHost;
import com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost;
import com.tapsdk.tapad.internal.runtime.download.AndroidDownloadRequest;
import com.umeng.analytics.pro.cc;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class BundleUpdater {
    private static final String STAGING_DIR = "plugin-bundles-staging";
    private static final String TAG = "BundleUpdater";
    private static volatile BundleUpdater sInstance;
    private final Context appContext;
    private final DownloadStarter downloadStarter;
    private final Set<String> inFlight;
    private final BundleRegistry registry;

    public interface ActivationCallback {
        void onActivated(BundleManifest bundleManifest, File file);

        default void onDeferred(BundleManifest bundleManifest) {
        }

        default void onFailed(BundleManifest bundleManifest, String str) {
        }
    }

    public enum ActivationResult {
        ACTIVATED,
        DEFERRED,
        FAILED
    }

    public interface BundleActivator {
        ActivationResult activate(BundleManifest bundleManifest);
    }

    public final class BundleDownloadObserver extends AndroidDownloadHost.Observer {
        private final BundleActivator activator;
        private final ActivationCallback callback;
        private final BundleManifest manifest;
        private final String tag;

        public BundleDownloadObserver(BundleManifest bundleManifest, String str, BundleActivator bundleActivator, ActivationCallback activationCallback) {
            this.manifest = bundleManifest;
            this.tag = str;
            this.activator = bundleActivator;
            this.callback = activationCallback;
        }

        private void activateStagedCandidate(BundleSlotFiles bundleSlotFiles) {
            BundleActivator bundleActivator;
            ActivationResult activationResultActivate;
            if (!BundleId.STYLE.equals(this.manifest.id) || (bundleActivator = this.activator) == null) {
                if ("core".equals(this.manifest.id)) {
                    String str = this.manifest.id;
                    return;
                }
                return;
            }
            try {
                activationResultActivate = bundleActivator.activate(this.manifest);
            } catch (Throwable th) {
                String str2 = this.manifest.id;
                activationResultActivate = ActivationResult.FAILED;
            }
            if (activationResultActivate != ActivationResult.ACTIVATED) {
                if (activationResultActivate != ActivationResult.DEFERRED) {
                    notifyActivationFailure("activation_failed");
                    return;
                }
                ActivationCallback activationCallback = this.callback;
                if (activationCallback != null) {
                    activationCallback.onDeferred(this.manifest);
                    return;
                }
                return;
            }
            File fileCurrent = bundleSlotFiles.current();
            if (fileCurrent.isFile()) {
                long bundleVersionCode = BundleFileHeader.readBundleVersionCode(fileCurrent);
                BundleManifest bundleManifest = this.manifest;
                if (bundleVersionCode == bundleManifest.bundleVersionCode) {
                    ActivationCallback activationCallback2 = this.callback;
                    if (activationCallback2 != null) {
                        activationCallback2.onActivated(bundleManifest, fileCurrent);
                        return;
                    }
                    return;
                }
            }
            notifyActivationFailure("activation_did_not_publish_current");
        }

        private void cleanup() {
            synchronized (BundleUpdater.this) {
                BundleUpdater.this.inFlight.remove(this.tag);
            }
        }

        private void discardInvalid(File file, String str, long j, long j2) {
            String str2 = this.manifest.id;
            file.delete();
            BundleRegistry bundleRegistry = BundleUpdater.this.registry;
            BundleManifest bundleManifest = this.manifest;
            bundleRegistry.recordFailed(bundleManifest.id, bundleManifest.bundleVersionCode);
            HashMap map = new HashMap();
            map.put(MediationConstant.KEY_REASON, str);
            map.put("expected", Double.valueOf(j));
            map.put("actual", Double.valueOf(j2));
            BundleUpdater.track(13, this.manifest, map);
        }

        private void handleComplete(final File file) {
            boolean zBooleanValue;
            if (file == null || !file.exists()) {
                String str = this.manifest.id;
                return;
            }
            if (!TextUtils.isEmpty(this.manifest.sha256)) {
                String strSha256Hex = BundleUpdater.sha256Hex(file);
                if (!BundleUpdater.hashMatches(strSha256Hex, this.manifest.sha256)) {
                    BundleManifest bundleManifest = this.manifest;
                    String str2 = bundleManifest.id;
                    String str3 = bundleManifest.sha256;
                    file.delete();
                    BundleRegistry bundleRegistry = BundleUpdater.this.registry;
                    BundleManifest bundleManifest2 = this.manifest;
                    bundleRegistry.recordFailed(bundleManifest2.id, bundleManifest2.bundleVersionCode);
                    HashMap map = new HashMap();
                    map.put("expected_sha256", this.manifest.sha256);
                    if (strSha256Hex != null) {
                        map.put("actual_sha256", strSha256Hex);
                    }
                    BundleUpdater.track(14, this.manifest, map);
                    return;
                }
            }
            if (this.manifest.sizeBytes > 0) {
                long length = file.length();
                long j = this.manifest.sizeBytes;
                if (length != j) {
                    discardInvalid(file, "size_mismatch", j, file.length());
                    return;
                }
            }
            long bundleVersionCode = BundleFileHeader.readBundleVersionCode(file);
            long j2 = this.manifest.bundleVersionCode;
            if (bundleVersionCode != j2) {
                discardInvalid(file, "version_mismatch", j2, bundleVersionCode);
                return;
            }
            final BundleSlotFiles bundleSlotFiles = new BundleSlotFiles(BundleUpdater.this.appContext, this.manifest.id);
            try {
                synchronized (BundleUpdater.this) {
                    zBooleanValue = ((Boolean) bundleSlotFiles.withExclusiveLock(new BundleSlotFiles.LockedOperation() { // from class: com.tapsdk.tapad.internal.runtime.bundle.BundleUpdater$BundleDownloadObserver$$ExternalSyntheticLambda0
                        @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleSlotFiles.LockedOperation
                        public final Object run() {
                            return this.f$0.m266lambda$handleComplete$0$comtapsdktapadinternalruntimebundleBundleUpdater$BundleDownloadObserver(file, bundleSlotFiles);
                        }
                    })).booleanValue();
                }
                if (zBooleanValue) {
                    activateStagedCandidate(bundleSlotFiles);
                }
            } catch (IOException e) {
                String str4 = this.manifest.id;
                file.delete();
            }
        }

        private void notifyActivationFailure(String str) {
            notifyActivationFailure(this.callback, str);
        }

        private boolean stageDownloadedCandidate(File file, BundleSlotFiles bundleSlotFiles) {
            String downloadSkipReason = BundleUpdater.this.registry.getDownloadSkipReason(this.manifest);
            if (downloadSkipReason != null) {
                file.delete();
                BundleUpdater.this.trackSkipped(this.manifest, downloadSkipReason, "completion_recheck");
                return false;
            }
            File fileCandidate = bundleSlotFiles.candidate();
            File parentFile = fileCandidate.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                String str = this.manifest.id;
                parentFile.toString();
                file.delete();
                return false;
            }
            if (!BundleUpdater.replaceCandidate(file, fileCandidate)) {
                return false;
            }
            BundleRegistry bundleRegistry = BundleUpdater.this.registry;
            BundleManifest bundleManifest = this.manifest;
            bundleRegistry.recordStaged(bundleManifest.id, bundleManifest.bundleVersionCode);
            BundleManifest bundleManifest2 = this.manifest;
            String str2 = bundleManifest2.id;
            long j = bundleManifest2.bundleVersionCode;
            fileCandidate.length();
            BundleUpdater.track(12, this.manifest, null);
            return true;
        }

        @Override // com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost.Observer
        public boolean deliverOnMainThread() {
            return false;
        }

        /* JADX INFO: renamed from: lambda$handleComplete$0$com-tapsdk-tapad-internal-runtime-bundle-BundleUpdater$BundleDownloadObserver, reason: not valid java name */
        /* synthetic */ Boolean m266lambda$handleComplete$0$comtapsdktapadinternalruntimebundleBundleUpdater$BundleDownloadObserver(File file, BundleSlotFiles bundleSlotFiles) {
            return Boolean.valueOf(stageDownloadedCandidate(file, bundleSlotFiles));
        }

        @Override // com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost.Observer
        public void onComplete(int i, int i2, File file) {
            try {
                handleComplete(file);
            } finally {
                cleanup();
            }
        }

        @Override // com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost.Observer
        public void onError(int i, int i2, int i3, String str) {
            String str2 = this.manifest.id;
            HashMap map = new HashMap();
            map.put(Constants.ERROR_CODE_FIELD, Integer.valueOf(i3));
            if (str != null) {
                map.put("error_message", str);
            }
            BundleUpdater.track(13, this.manifest, map);
            cleanup();
        }

        private void notifyActivationFailure(ActivationCallback activationCallback, String str) {
            if (activationCallback != null) {
                activationCallback.onFailed(this.manifest, str);
            }
        }
    }

    public interface DownloadStarter {
        int start(AndroidDownloadRequest androidDownloadRequest, AndroidDownloadHost.Observer observer);
    }

    private BundleUpdater(final Context context) {
        this(context, new DownloadStarter() { // from class: com.tapsdk.tapad.internal.runtime.bundle.BundleUpdater$$ExternalSyntheticLambda0
            @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleUpdater.DownloadStarter
            public final int start(AndroidDownloadRequest androidDownloadRequest, AndroidDownloadHost.Observer observer) {
                return AndroidDownloadHost.get(context).start(androidDownloadRequest, 0, (AndroidDownloadHost.NotificationSpec) null, observer);
            }
        });
    }

    private void activateExistingStyle(BundleManifest bundleManifest, BundleActivator bundleActivator, ActivationCallback activationCallback) {
        ActivationResult activationResultActivate;
        BundleSlotFiles bundleSlotFiles = new BundleSlotFiles(this.appContext, bundleManifest.id);
        try {
            activationResultActivate = bundleActivator.activate(bundleManifest);
        } catch (Throwable th) {
            activationResultActivate = ActivationResult.FAILED;
        }
        if (activationResultActivate != ActivationResult.ACTIVATED) {
            if (activationResultActivate == ActivationResult.DEFERRED) {
                if (activationCallback != null) {
                    activationCallback.onDeferred(bundleManifest);
                    return;
                }
                return;
            } else {
                if (activationCallback != null) {
                    activationCallback.onFailed(bundleManifest, "current_activation_failed");
                    return;
                }
                return;
            }
        }
        File fileCurrent = bundleSlotFiles.current();
        long bundleVersionCode = BundleFileHeader.readBundleVersionCode(fileCurrent);
        if (!fileCurrent.isFile() || bundleVersionCode < bundleManifest.bundleVersionCode) {
            if (activationCallback != null) {
                activationCallback.onFailed(bundleManifest, "current_activation_did_not_publish");
            }
        } else if (activationCallback != null) {
            activationCallback.onActivated(bundleManifest, fileCurrent);
        }
    }

    public static String compatibilitySkipReason(BundleManifest bundleManifest, String str, int i) {
        return BundleManifest.compatibilitySkipReason(bundleManifest, str, i);
    }

    public static BundleUpdater get(Context context) {
        if (sInstance == null) {
            synchronized (BundleUpdater.class) {
                if (sInstance == null) {
                    sInstance = new BundleUpdater(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    public static boolean hashMatches(String str, String str2) {
        return (str == null || str2 == null || !str.equalsIgnoreCase(str2)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean replaceCandidate(File file, File file2) {
        File parentFile = file2.getParentFile();
        if (parentFile != null && (parentFile.isDirectory() || parentFile.mkdirs())) {
            File file3 = new File(parentFile, file2.getName() + ".installing");
            if (file3.exists() && !file3.delete()) {
                return false;
            }
            if (file2.exists() && !file2.delete()) {
                return false;
            }
            if (file.renameTo(file2)) {
                return true;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file3);
                    try {
                        byte[] bArr = new byte[16384];
                        while (true) {
                            int i = fileInputStream.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, i);
                            try {
                                fileInputStream.close();
                            } catch (Throwable th) {
                                th.addSuppressed(th);
                            }
                            throw th;
                        }
                        fileOutputStream.getFD().sync();
                        fileOutputStream.close();
                        fileInputStream.close();
                        if (file3.renameTo(file2)) {
                            file.delete();
                            return true;
                        }
                        file3.delete();
                        return false;
                    } catch (Throwable th2) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                        throw th2;
                    }
                } catch (Throwable th4) {
                    fileInputStream.close();
                    throw th4;
                }
            } catch (IOException e) {
                file.toString();
                file3.toString();
                e.toString();
                file3.delete();
            }
        }
        return false;
    }

    private void scheduleDownload(BundleManifest bundleManifest, BundleActivator bundleActivator, ActivationCallback activationCallback) {
        File fileStagingDir = stagingDir();
        if (!fileStagingDir.exists() && !fileStagingDir.mkdirs()) {
            String str = bundleManifest.id;
            fileStagingDir.toString();
            this.inFlight.remove(taskTagFor(bundleManifest));
            return;
        }
        AndroidDownloadRequest androidDownloadRequestBuild = new AndroidDownloadRequest.Builder().url(bundleManifest.url).fileName(bundleManifest.id + "-" + bundleManifest.bundleVersionCode + ".drch.part").targetDirectory(fileStagingDir.getAbsolutePath()).expectedSize(bundleManifest.sizeBytes).resumable(true).build();
        String strTaskTagFor = taskTagFor(bundleManifest);
        if (this.downloadStarter.start(androidDownloadRequestBuild, new BundleDownloadObserver(bundleManifest, strTaskTagFor, bundleActivator, activationCallback)) > 0) {
            track(11, bundleManifest, null);
            return;
        }
        this.inFlight.remove(strTaskTagFor);
        HashMap map = new HashMap();
        map.put(Constants.ERROR_CODE_FIELD, -1);
        map.put("error_message", "Android rejected bundle transfer");
        track(13, bundleManifest, map);
    }

    public static String sha256Hex(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                byte[] bArr = new byte[16384];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i == -1) {
                        String hex = toHex(messageDigest.digest());
                        fileInputStream.close();
                        return hex;
                    }
                    messageDigest.update(bArr, 0, i);
                    Objects.toString(file);
                    e.toString();
                    return null;
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException | NoSuchAlgorithmException e) {
            Objects.toString(file);
            e.toString();
            return null;
        }
    }

    private File stagingDir() {
        return new File(this.appContext.getFilesDir(), STAGING_DIR);
    }

    private static String taskTagFor(BundleManifest bundleManifest) {
        return "plugin_bundle:" + bundleManifest.id + ":" + bundleManifest.bundleVersionCode;
    }

    private static String toHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(Character.forDigit((b >> 4) & 15, 16));
            sb.append(Character.forDigit(b & cc.m, 16));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void track(int i, BundleManifest bundleManifest, Map<String, Object> map) {
        try {
            HashMap map2 = map != null ? new HashMap(map) : new HashMap();
            map2.put("bundle_id", bundleManifest.id);
            map2.put("bundle_version_code", Double.valueOf(bundleManifest.bundleVersionCode));
            AdnTelemetryHost.reportFact(i, map2);
        } catch (Throwable th) {
            th.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackSkipped(BundleManifest bundleManifest, String str, String str2) {
        if (bundleManifest == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("bundle_id", bundleManifest.id);
        map.put("target_version", Double.valueOf(bundleManifest.bundleVersionCode));
        if (str == null) {
            str = "";
        }
        map.put("skip_code", str);
        if (str2 != null) {
            map.put("skip_detail", str2);
        }
        map.put("active_version", Double.valueOf(this.registry.getActiveBundleVersionCode(bundleManifest.id)));
        map.put("staged_version", Double.valueOf(this.registry.getStagedBundleVersionCode(bundleManifest.id)));
        map.put("floor_version", Double.valueOf(this.registry.getFloor(bundleManifest.id)));
        AdnTelemetryHost.reportFact(10, map);
    }

    public synchronized void maybeUpdate(List<BundleManifest> list) {
        maybeUpdate(list, Collections.EMPTY_SET, null, null);
    }

    public BundleUpdater(Context context, DownloadStarter downloadStarter) {
        this.inFlight = new HashSet();
        this.appContext = context;
        this.registry = BundleRegistry.get(context);
        if (downloadStarter == null) {
            throw new IllegalArgumentException("downloadStarter == null");
        }
        this.downloadStarter = downloadStarter;
    }

    public synchronized void maybeUpdate(List<BundleManifest> list, Set<String> set) {
        maybeUpdate(list, set, null, null);
    }

    public synchronized void maybeUpdate(List<BundleManifest> list, Set<String> set, BundleActivator bundleActivator, ActivationCallback activationCallback) {
        if (list != null) {
            if (!list.isEmpty()) {
                if (set == null) {
                    set = Collections.EMPTY_SET;
                }
                for (BundleManifest bundleManifest : list) {
                    if (bundleManifest != null) {
                        if (set.contains(bundleManifest.id)) {
                            trackSkipped(bundleManifest, "force_embedded", null);
                        } else {
                            String strCompatibilitySkipReason = compatibilitySkipReason(bundleManifest, BuildConfig.DIRICHLET_PLUGIN_HOST_COMPATIBILITY_ID, 50300001);
                            if (strCompatibilitySkipReason != null) {
                                trackSkipped(bundleManifest, strCompatibilitySkipReason, null);
                            } else {
                                String downloadSkipReason = this.registry.getDownloadSkipReason(bundleManifest);
                                if (downloadSkipReason != null) {
                                    if (BundleId.STYLE.equals(bundleManifest.id) && "not_newer".equals(downloadSkipReason) && bundleActivator != null) {
                                        activateExistingStyle(bundleManifest, bundleActivator, activationCallback);
                                    }
                                    trackSkipped(bundleManifest, downloadSkipReason, null);
                                } else if (this.inFlight.add(taskTagFor(bundleManifest))) {
                                    scheduleDownload(bundleManifest, bundleActivator, activationCallback);
                                } else {
                                    trackSkipped(bundleManifest, "in_flight", null);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
