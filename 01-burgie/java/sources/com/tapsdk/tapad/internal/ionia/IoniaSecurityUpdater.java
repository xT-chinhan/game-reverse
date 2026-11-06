package com.tapsdk.tapad.internal.ionia;

import android.content.Context;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost;
import com.tapsdk.tapad.internal.runtime.download.AndroidDownloadRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
final class IoniaSecurityUpdater {
    private static final String STAGING_DIR = "dirichlet/security-staging";
    private static final String TAG = "IoniaSecurityUpdater";
    private static volatile IoniaSecurityUpdater sInstance;
    private final Context appContext;
    private final AndroidDownloadHost downloadHost;
    private volatile boolean inFlight;
    private final IoniaSecurityStore store;

    public final class Observer extends AndroidDownloadHost.Observer {
        private final IoniaSecurityUpdate update;

        public Observer(IoniaSecurityUpdate ioniaSecurityUpdate) {
            this.update = ioniaSecurityUpdate;
        }

        private void handleComplete(File file) {
            if (file == null || !file.exists()) {
                return;
            }
            if (this.update.sizeBytes > 0 && file.length() != this.update.sizeBytes) {
                file.length();
                file.delete();
                return;
            }
            if (!this.update.sha256.equals(IoniaSecurityUpdater.sha256Hex(file))) {
                String str = this.update.sha256;
                file.delete();
                return;
            }
            try {
                DirichletRuntime.IoniaSecurityPackage ioniaSecurityPackageExtractIoniaSecurityPackage = DirichletRuntime.getInstance().extractIoniaSecurityPackage(IoniaSecurityUpdater.readAll(file), IoniaSecurityUpdater.this.store.rollbackFloor());
                if (ioniaSecurityPackageExtractIoniaSecurityPackage == null || ioniaSecurityPackageExtractIoniaSecurityPackage.wasm.length == 0 || ioniaSecurityPackageExtractIoniaSecurityPackage.dex.length == 0) {
                    long j = this.update.bundleVersionCode;
                    file.delete();
                } else {
                    if (ioniaSecurityPackageExtractIoniaSecurityPackage.version != this.update.bundleVersionCode) {
                        file.delete();
                        return;
                    }
                    if (!IoniaSecurityUpdater.this.store.stageCandidate(file, this.update.bundleVersionCode)) {
                        long j2 = this.update.bundleVersionCode;
                        file.delete();
                    } else {
                        long j3 = this.update.bundleVersionCode;
                        int length = ioniaSecurityPackageExtractIoniaSecurityPackage.wasm.length;
                        int length2 = ioniaSecurityPackageExtractIoniaSecurityPackage.dex.length;
                    }
                }
            } catch (IOException e) {
                file.delete();
            }
        }

        @Override // com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost.Observer
        public boolean deliverOnMainThread() {
            return false;
        }

        @Override // com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost.Observer
        public void onComplete(int i, int i2, File file) {
            try {
                handleComplete(file);
            } finally {
                IoniaSecurityUpdater.this.inFlight = false;
            }
        }

        @Override // com.tapsdk.tapad.internal.runtime.download.AndroidDownloadHost.Observer
        public void onError(int i, int i2, int i3, String str) {
            long j = this.update.bundleVersionCode;
            IoniaSecurityUpdater.this.inFlight = false;
        }
    }

    private IoniaSecurityUpdater(Context context) {
        this.appContext = context;
        this.store = new IoniaSecurityStore(context);
        this.downloadHost = AndroidDownloadHost.get(context);
    }

    public static IoniaSecurityUpdater get(Context context) {
        if (sInstance == null) {
            synchronized (IoniaSecurityUpdater.class) {
                if (sInstance == null) {
                    sInstance = new IoniaSecurityUpdater(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] readAll(File file) throws IOException {
        long length = file.length();
        if (length <= 0 || length > 16777216) {
            throw new IOException("invalid package size " + length);
        }
        int i = (int) length;
        byte[] bArr = new byte[i];
        FileInputStream fileInputStream = new FileInputStream(file);
        int i2 = 0;
        while (i2 < i) {
            try {
                int i3 = fileInputStream.read(bArr, i2, i - i2);
                if (i3 < 0) {
                    throw new IOException("short read");
                }
                i2 += i3;
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        fileInputStream.close();
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String sha256Hex(File file) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, i);
                }
                fileInputStream.close();
                byte[] bArrDigest = messageDigest.digest();
                StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
                for (byte b : bArrDigest) {
                    sb.append(String.format("%02x", Byte.valueOf(b)));
                }
                return sb.toString();
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException | NoSuchAlgorithmException e) {
            return "";
        }
    }

    public synchronized void maybeUpdate(IoniaSecurityUpdate ioniaSecurityUpdate) {
        if (ioniaSecurityUpdate != null) {
            if (ioniaSecurityUpdate.skipReason() == null) {
                if (ioniaSecurityUpdate.bundleVersionCode > Math.max(this.store.rollbackFloor(), Math.max(this.store.currentVersion(), this.store.stagedVersion())) && !this.inFlight) {
                    File file = new File(this.appContext.getFilesDir(), STAGING_DIR);
                    if (!file.exists() && !file.mkdirs()) {
                        file.toString();
                        return;
                    }
                    AndroidDownloadRequest androidDownloadRequestBuild = new AndroidDownloadRequest.Builder().url(ioniaSecurityUpdate.url).fileName("ionia-" + ioniaSecurityUpdate.bundleVersionCode + ".part").targetDirectory(file.getAbsolutePath()).expectedSize(ioniaSecurityUpdate.sizeBytes).resumable(true).build();
                    this.inFlight = true;
                    if (this.downloadHost.start(androidDownloadRequestBuild, 0, (AndroidDownloadHost.NotificationSpec) null, new Observer(ioniaSecurityUpdate)) <= 0) {
                        this.inFlight = false;
                    }
                }
            }
        }
    }
}
