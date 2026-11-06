package com.tapsdk.tapad.internal.runtime;

import android.content.Context;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.internal.observability.AdnTelemetryHost;
import com.tapsdk.tapad.internal.runtime.bundle.BundleFileHeader;
import com.tapsdk.tapad.internal.runtime.bundle.BundleRegistry;
import com.tapsdk.tapad.internal.runtime.bundle.BundleSlotFiles;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
final class BundleManager {
    private static final String ASSET_DIR = "dirichlet/bundles";
    private static final int BUNDLE_HEADER_SIZE = 80;
    private static final int MAX_BUNDLE_BYTES = 16777216;
    private static final int OFF_BUNDLE_VERSION_CODE = 80;
    static final int SOURCE_CANDIDATE = 3;
    static final int SOURCE_CURRENT = 4;
    static final int SOURCE_DOWNLOADED = 2;
    static final int SOURCE_EMBEDDED = 1;
    static final int SOURCE_PREVIOUS = 5;
    private static final String TAG = "BundleManager";
    private final String bundleId;
    private final Context context;
    private final BundleRegistry registry;
    private final BundleSlotFiles slots;

    public interface Loader {
        boolean load(byte[] bArr, long j, int i);
    }

    public BundleManager(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        this.bundleId = str;
        this.registry = BundleRegistry.get(applicationContext);
        this.slots = new BundleSlotFiles(applicationContext, str);
    }

    private void emitInstall(boolean z, String str, int i, long j, String str2) {
        try {
            HashMap map = new HashMap();
            map.put("bundle_id", this.bundleId);
            map.put("bundle_version_code", Double.valueOf(j));
            map.put("source", str);
            map.put("bytes", Integer.valueOf(i));
            if (str2 != null) {
                map.put(MediationConstant.KEY_REASON, str2);
            }
            AdnTelemetryHost.reportFact(z ? 15 : 16, map);
        } catch (Throwable th) {
            th.toString();
        }
    }

    private boolean installCandidate(Loader loader) {
        File fileCandidate = this.slots.candidate();
        if (!fileCandidate.isFile()) {
            return false;
        }
        long stagedBundleVersionCode = this.registry.getStagedBundleVersionCode(this.bundleId);
        long bundleVersionCode = BundleFileHeader.readBundleVersionCode(fileCandidate);
        if (stagedBundleVersionCode <= 0 || bundleVersionCode != stagedBundleVersionCode || bundleVersionCode < this.registry.getFloor(this.bundleId) || bundleVersionCode <= this.registry.getCurrentBundleVersionCode(this.bundleId)) {
            if (bundleVersionCode > 0) {
                stagedBundleVersionCode = bundleVersionCode;
            }
            rejectCandidate(stagedBundleVersionCode, fileCandidate, "unowned_or_mismatched");
            return false;
        }
        if (this.registry.isFailed(this.bundleId, bundleVersionCode)) {
            this.slots.discardCandidate();
            this.registry.clearStaged(this.bundleId);
            return false;
        }
        byte[] file = readFile(fileCandidate);
        if (file == null || !this.registry.beginActivationAttempt(this.bundleId, bundleVersionCode)) {
            rejectCandidate(bundleVersionCode, fileCandidate, "activation_marker_failed");
            return false;
        }
        if (!loader.load(file, this.registry.getFloor(this.bundleId), 3)) {
            rejectCandidate(bundleVersionCode, fileCandidate, "native_preflight_failed");
            return false;
        }
        if (!this.registry.beginPromotion(this.bundleId, bundleVersionCode, versionOf(this.slots.current()))) {
            emitInstall(true, "candidate_uncommitted", file.length, bundleVersionCode, null);
            return true;
        }
        if (this.slots.promoteCandidate()) {
            this.registry.completePromotion(this.bundleId, bundleVersionCode, versionOf(this.slots.previous()));
        }
        this.registry.recordSelected(this.bundleId, bundleVersionCode);
        emitInstall(true, "candidate", file.length, bundleVersionCode, null);
        return true;
    }

    private boolean installEmbedded(Loader loader, String str) {
        byte[] embedded = readEmbedded();
        if (embedded == null) {
            return false;
        }
        if (!loader.load(embedded, 0L, 1)) {
            emitInstall(false, str, embedded.length, 0L, "native_preflight_failed");
            return false;
        }
        long jVersionOf = versionOf(embedded);
        this.registry.recordSelected(this.bundleId, jVersionOf);
        emitInstall(true, str, embedded.length, jVersionOf, null);
        return true;
    }

    private boolean installExternalOrBaseline(Loader loader) {
        migrateLegacyCache();
        recoverInterruptedActivation();
        if (installCandidate(loader) || installRecordedSlot(loader, this.slots.current(), this.registry.getCurrentBundleVersionCode(this.bundleId), this.registry.getFloor(this.bundleId), 4, "current") || installRecordedSlot(loader, this.slots.previous(), this.registry.getPreviousBundleVersionCode(this.bundleId), 0L, 5, "previous")) {
            return true;
        }
        return installEmbedded(loader, "baseline");
    }

    private boolean installRecordedSlot(Loader loader, File file, long j, long j2, int i, String str) {
        byte[] file2;
        if (j <= 0 || !file.isFile()) {
            return false;
        }
        if (BundleFileHeader.readBundleVersionCode(file) != j) {
            this.registry.recordFailed(this.bundleId, j);
            emitInstall(false, str, safeLength(file), j, "slot_header_mismatch");
            return false;
        }
        if (this.registry.isFailed(this.bundleId, j) || (file2 = readFile(file)) == null) {
            return false;
        }
        if (loader.load(file2, j2, i)) {
            this.registry.recordSelected(this.bundleId, j);
            emitInstall(true, str, file2.length, j, null);
            return true;
        }
        this.registry.recordFailed(this.bundleId, j);
        emitInstall(false, str, file2.length, j, "native_preflight_failed");
        return false;
    }

    private void migrateLegacyCache() {
        File fileLegacy = this.slots.legacy();
        if (!fileLegacy.isFile() || this.slots.current().exists() || this.slots.candidate().exists()) {
            return;
        }
        long jVersionOf = versionOf(fileLegacy);
        if (jVersionOf <= 0) {
            fileLegacy.delete();
            return;
        }
        if (this.registry.getStagedBundleVersionCode(this.bundleId) == jVersionOf) {
            BundleSlotFiles bundleSlotFiles = this.slots;
            bundleSlotFiles.moveLegacyTo(bundleSlotFiles.candidate());
            return;
        }
        long currentBundleVersionCode = this.registry.getCurrentBundleVersionCode(this.bundleId);
        if (currentBundleVersionCode <= 0) {
            currentBundleVersionCode = this.registry.getActiveBundleVersionCode(this.bundleId);
        }
        if (currentBundleVersionCode == jVersionOf || this.registry.getFloor(this.bundleId) == jVersionOf) {
            BundleSlotFiles bundleSlotFiles2 = this.slots;
            if (bundleSlotFiles2.moveLegacyTo(bundleSlotFiles2.current())) {
                this.registry.recordLegacyCurrent(this.bundleId, jVersionOf);
                return;
            }
            return;
        }
        BundleSlotFiles bundleSlotFiles3 = this.slots;
        if (bundleSlotFiles3.moveLegacyTo(bundleSlotFiles3.candidate())) {
            this.registry.recordStaged(this.bundleId, jVersionOf);
        }
    }

    private static byte[] readAll(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[16384];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            if (byteArrayOutputStream.size() + i > 16777216) {
                throw new IOException("bundle exceeds host limit");
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    private byte[] readEmbedded() {
        try {
            InputStream inputStreamOpen = this.context.getAssets().open("dirichlet/bundles/" + this.bundleId + ".drch");
            try {
                byte[] all = readAll(inputStreamOpen);
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                return all;
            } catch (Throwable th) {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            e.toString();
            return null;
        }
    }

    private byte[] readFile(File file) {
        if (file != null && file.isFile() && file.length() > 0 && file.length() <= 16777216) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    byte[] all = readAll(fileInputStream);
                    fileInputStream.close();
                    return all;
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                file.toString();
                e.toString();
            }
        }
        return null;
    }

    private void recoverInterruptedActivation() {
        long promotionVersion = this.registry.getPromotionVersion(this.bundleId);
        if (promotionVersion <= 0) {
            long activationAttemptVersion = this.registry.getActivationAttemptVersion(this.bundleId);
            if (activationAttemptVersion > 0) {
                this.registry.recordFailed(this.bundleId, activationAttemptVersion);
                if (versionOf(this.slots.candidate()) == activationAttemptVersion) {
                    this.slots.discardCandidate();
                    return;
                }
                return;
            }
            return;
        }
        long jVersionOf = versionOf(this.slots.current());
        if (jVersionOf == promotionVersion) {
            this.registry.completePromotion(this.bundleId, promotionVersion, versionOf(this.slots.previous()));
            return;
        }
        if (versionOf(this.slots.candidate()) == promotionVersion && this.slots.promoteCandidate()) {
            this.registry.completePromotion(this.bundleId, promotionVersion, versionOf(this.slots.previous()));
            return;
        }
        long promotionOldCurrentVersion = this.registry.getPromotionOldCurrentVersion(this.bundleId);
        if (jVersionOf > 0 || promotionOldCurrentVersion <= 0 || versionOf(this.slots.previous()) != promotionOldCurrentVersion || !this.slots.restorePreviousToCurrent()) {
            this.registry.recordFailed(this.bundleId, promotionVersion);
            this.slots.discardCandidate();
        } else {
            this.registry.abortPromotionToCurrent(this.bundleId, promotionVersion, promotionOldCurrentVersion);
            this.slots.discardCandidate();
        }
    }

    private void rejectCandidate(long j, File file, String str) {
        int iSafeLength = safeLength(file);
        if (j > 0) {
            this.registry.recordFailed(this.bundleId, j);
        }
        this.slots.discardCandidate();
        this.registry.clearStaged(this.bundleId);
        this.registry.clearActivationAttempt(this.bundleId);
        emitInstall(false, "candidate", iSafeLength, j, str);
    }

    private static int safeLength(File file) {
        if (file == null) {
            return 0;
        }
        return (int) Math.min(2147483647L, Math.max(0L, file.length()));
    }

    private static long versionOf(File file) {
        return BundleFileHeader.readBundleVersionCode(file);
    }

    public boolean activateCandidate(final Loader loader) {
        if (loader == null) {
            return false;
        }
        try {
            return ((Boolean) this.slots.withExclusiveLock(new BundleSlotFiles.LockedOperation() { // from class: com.tapsdk.tapad.internal.runtime.BundleManager$$ExternalSyntheticLambda3
                @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleSlotFiles.LockedOperation
                public final Object run() {
                    return this.f$0.m199lambda$activateCandidate$1$comtapsdktapadinternalruntimeBundleManager(loader);
                }
            })).booleanValue();
        } catch (IOException e) {
            return false;
        }
    }

    public boolean activateCurrent(final Loader loader) {
        if (loader == null) {
            return false;
        }
        try {
            return ((Boolean) this.slots.withExclusiveLock(new BundleSlotFiles.LockedOperation() { // from class: com.tapsdk.tapad.internal.runtime.BundleManager$$ExternalSyntheticLambda0
                @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleSlotFiles.LockedOperation
                public final Object run() {
                    return this.f$0.m200lambda$activateCurrent$2$comtapsdktapadinternalruntimeBundleManager(loader);
                }
            })).booleanValue();
        } catch (IOException e) {
            return false;
        }
    }

    public File cacheFile() {
        return this.slots.candidate();
    }

    public File currentFile() {
        return this.slots.current();
    }

    public void discardCache() {
        try {
            this.slots.withExclusiveLock(new BundleSlotFiles.LockedOperation() { // from class: com.tapsdk.tapad.internal.runtime.BundleManager$$ExternalSyntheticLambda1
                @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleSlotFiles.LockedOperation
                public final Object run() {
                    return this.f$0.m201lambda$discardCache$3$comtapsdktapadinternalruntimeBundleManager();
                }
            });
        } catch (IOException e) {
        }
    }

    public void discardCacheAndStaged() {
        discardCache();
    }

    public boolean install(Loader loader) {
        return install(loader, false, false);
    }

    /* JADX INFO: renamed from: lambda$activateCandidate$1$com-tapsdk-tapad-internal-runtime-BundleManager, reason: not valid java name */
    /* synthetic */ Boolean m199lambda$activateCandidate$1$comtapsdktapadinternalruntimeBundleManager(Loader loader) {
        return Boolean.valueOf(installCandidate(loader));
    }

    /* JADX INFO: renamed from: lambda$activateCurrent$2$com-tapsdk-tapad-internal-runtime-BundleManager, reason: not valid java name */
    /* synthetic */ Boolean m200lambda$activateCurrent$2$comtapsdktapadinternalruntimeBundleManager(Loader loader) {
        return Boolean.valueOf(installRecordedSlot(loader, this.slots.current(), this.registry.getCurrentBundleVersionCode(this.bundleId), this.registry.getFloor(this.bundleId), 4, "current"));
    }

    /* JADX INFO: renamed from: lambda$discardCache$3$com-tapsdk-tapad-internal-runtime-BundleManager, reason: not valid java name */
    /* synthetic */ Object m201lambda$discardCache$3$comtapsdktapadinternalruntimeBundleManager() {
        this.slots.discardExternalSlots();
        this.registry.clearExternalSlots(this.bundleId);
        return null;
    }

    /* JADX INFO: renamed from: lambda$install$0$com-tapsdk-tapad-internal-runtime-BundleManager, reason: not valid java name */
    /* synthetic */ Boolean m202lambda$install$0$comtapsdktapadinternalruntimeBundleManager(Loader loader) {
        return Boolean.valueOf(installExternalOrBaseline(loader));
    }

    public File previousFile() {
        return this.slots.previous();
    }

    private static long versionOf(byte[] bArr) {
        if (bArr != null && bArr.length >= 88) {
            long j = 0;
            for (int i = 0; i < 8; i++) {
                j |= (((long) bArr[i + 80]) & 255) << (i * 8);
            }
            if (j > 0) {
                return j;
            }
        }
        return 0L;
    }

    public boolean install(Loader loader, boolean z) {
        return install(loader, z, false);
    }

    public boolean install(final Loader loader, boolean z, boolean z2) {
        if (z) {
            discardCacheAndStaged();
            return installEmbedded(loader, "forced_baseline");
        }
        if (z2) {
            return installEmbedded(loader, "recovery_baseline");
        }
        try {
            return ((Boolean) this.slots.withExclusiveLock(new BundleSlotFiles.LockedOperation() { // from class: com.tapsdk.tapad.internal.runtime.BundleManager$$ExternalSyntheticLambda2
                @Override // com.tapsdk.tapad.internal.runtime.bundle.BundleSlotFiles.LockedOperation
                public final Object run() {
                    return this.f$0.m202lambda$install$0$comtapsdktapadinternalruntimeBundleManager(loader);
                }
            })).booleanValue();
        } catch (IOException e) {
            return installEmbedded(loader, "slot_lock_failed_baseline");
        }
    }
}
