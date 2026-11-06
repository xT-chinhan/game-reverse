package com.tapsdk.tapad.internal.ionia;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
final class IoniaSecurityStore {
    private static final String KEY_CURRENT = "current_version";
    private static final String KEY_PREVIOUS = "previous_version";
    private static final String KEY_ROLLBACK_FLOOR = "rollback_floor";
    private static final String KEY_STAGED = "staged_version";
    private static final String KEY_STAGED_PROCESS = "staged_process";
    private static final String PREFS = "ionia_security_update";
    private static final String PROCESS_ID = UUID.randomUUID().toString();
    private static final String TAG = "IoniaSecurityStore";
    private final SharedPreferences prefs;
    private final File root;

    public static final class Slot {
        final byte[] bytes;
        final boolean candidate;
        final long version;

        public Slot(byte[] bArr, long j, boolean z) {
            this.bytes = bArr;
            this.version = j;
            this.candidate = z;
        }
    }

    public IoniaSecurityStore(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.root = new File(applicationContext.getFilesDir(), "dirichlet/security");
        this.prefs = applicationContext.getSharedPreferences(PREFS, 0);
        migrateLegacySingleComponentSlots();
    }

    public static boolean canStage(long j, long j2, long j3, long j4) {
        return j > 0 && j > j2 && j > j3 && j > j4;
    }

    public static boolean candidateEligible(long j, long j2, long j3, boolean z) {
        return z && j > j2 && j >= j3;
    }

    private static boolean copy(File file, File file2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i == -1) {
                            fileOutputStream.getFD().sync();
                            fileOutputStream.close();
                            fileInputStream.close();
                            return true;
                        }
                        fileOutputStream.write(bArr, 0, i);
                        try {
                            fileInputStream.close();
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                        }
                        throw th;
                    }
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
            e.getMessage();
            return false;
        }
    }

    private boolean ensureRoot() {
        return this.root.isDirectory() || this.root.mkdirs();
    }

    private void migrateLegacySingleComponentSlots() {
        if (this.prefs.contains(KEY_ROLLBACK_FLOOR) || currentVersion() <= 0) {
            return;
        }
        candidateFile().delete();
        currentFile().delete();
        previousFile().delete();
        this.prefs.edit().remove(KEY_CURRENT).remove(KEY_PREVIOUS).remove(KEY_STAGED).remove(KEY_STAGED_PROCESS).putLong(KEY_ROLLBACK_FLOOR, 0L).commit();
    }

    private static byte[] read(File file) {
        if (file != null && file.isFile()) {
            long length = file.length();
            if (length > 0 && length <= 16777216) {
                int i = (int) length;
                byte[] bArr = new byte[i];
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    int i2 = 0;
                    while (i2 < i) {
                        try {
                            int i3 = fileInputStream.read(bArr, i2, i - i2);
                            if (i3 < 0) {
                                fileInputStream.close();
                                return null;
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
                } catch (IOException e) {
                    file.getName();
                    e.getMessage();
                }
            }
        }
        return null;
    }

    private static boolean replace(File file, File file2) {
        File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            return false;
        }
        File file3 = new File(file2.getAbsolutePath() + ".tmp");
        if (file3.exists() && !file3.delete()) {
            return false;
        }
        if (!copy(file, file3)) {
            file3.delete();
            return false;
        }
        file2.delete();
        if (file3.renameTo(file2)) {
            return true;
        }
        file3.delete();
        return false;
    }

    public File candidateFile() {
        return new File(this.root, "candidate.ionia");
    }

    public File currentFile() {
        return new File(this.root, "current.ionia");
    }

    public synchronized Slot currentForLoad() {
        long jCurrentVersion = currentVersion();
        Slot slot = null;
        if (jCurrentVersion > 0 && jCurrentVersion >= rollbackFloor()) {
            byte[] bArr = read(currentFile());
            if (bArr == null) {
                return null;
            }
            slot = new Slot(bArr, jCurrentVersion, false);
        }
        return slot;
    }

    public long currentVersion() {
        return this.prefs.getLong(KEY_CURRENT, 0L);
    }

    public synchronized void markActivated(long j) {
        if (j > 0) {
            if (ensureRoot()) {
                long jCurrentVersion = currentVersion();
                File fileCandidateFile = candidateFile();
                File fileCurrentFile = currentFile();
                File filePreviousFile = previousFile();
                if (j == stagedVersion() && fileCandidateFile.isFile()) {
                    if (fileCurrentFile.isFile()) {
                        filePreviousFile.delete();
                        if (fileCurrentFile.renameTo(filePreviousFile) && jCurrentVersion > 0) {
                            this.prefs.edit().putLong(KEY_PREVIOUS, jCurrentVersion).apply();
                        }
                    }
                    if (!replace(fileCandidateFile, fileCurrentFile)) {
                        if (!fileCurrentFile.isFile() && filePreviousFile.isFile()) {
                            filePreviousFile.renameTo(fileCurrentFile);
                        }
                    }
                }
                if (this.prefs.edit().putLong(KEY_CURRENT, j).putLong(KEY_ROLLBACK_FLOOR, Math.max(rollbackFloor(), j)).remove(KEY_STAGED).remove(KEY_STAGED_PROCESS).remove(KEY_PREVIOUS).commit()) {
                    fileCandidateFile.delete();
                    filePreviousFile.delete();
                }
            }
        }
    }

    public File previousFile() {
        return new File(this.root, "previous.ionia");
    }

    public synchronized void rejectCandidate(long j) {
        if (j != stagedVersion()) {
            return;
        }
        candidateFile().delete();
        this.prefs.edit().remove(KEY_STAGED).remove(KEY_STAGED_PROCESS).apply();
    }

    public long rollbackFloor() {
        return this.prefs.getLong(KEY_ROLLBACK_FLOOR, 0L);
    }

    public synchronized Slot selectForLoad() {
        byte[] bArr;
        long jStagedVersion = stagedVersion();
        long jCurrentVersion = currentVersion();
        long jRollbackFloor = rollbackFloor();
        if (candidateEligible(jStagedVersion, jCurrentVersion, jRollbackFloor, !PROCESS_ID.equals(this.prefs.getString(KEY_STAGED_PROCESS, null)))) {
            byte[] bArr2 = read(candidateFile());
            if (bArr2 != null) {
                return new Slot(bArr2, jStagedVersion, true);
            }
            rejectCandidate(jStagedVersion);
        }
        if (jCurrentVersion <= 0 || jCurrentVersion < jRollbackFloor || (bArr = read(currentFile())) == null) {
            return null;
        }
        return new Slot(bArr, jCurrentVersion, false);
    }

    public synchronized boolean stageCandidate(File file, long j) {
        if (file != null) {
            if (file.isFile() && canStage(j, currentVersion(), stagedVersion(), rollbackFloor())) {
                if (!ensureRoot()) {
                    return false;
                }
                if (!replace(file, candidateFile())) {
                    return false;
                }
                file.delete();
                this.prefs.edit().putLong(KEY_STAGED, j).putString(KEY_STAGED_PROCESS, PROCESS_ID).apply();
                return true;
            }
        }
        return false;
    }

    public long stagedVersion() {
        return this.prefs.getLong(KEY_STAGED, 0L);
    }
}
