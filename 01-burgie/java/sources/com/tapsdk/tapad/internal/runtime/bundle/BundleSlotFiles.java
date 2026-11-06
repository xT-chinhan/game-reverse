package com.tapsdk.tapad.internal.runtime.bundle;

import android.content.Context;
import com.tapsdk.tapad.a;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes2.dex */
public final class BundleSlotFiles {
    private static final String BUNDLES_DIR = "dirichlet/bundles";
    private static final Object PROCESS_SLOT_LOCK = new Object();
    private final File legacy;
    private final File root;

    public interface LockedOperation<T> {
        T run();
    }

    public BundleSlotFiles(Context context, String str) {
        if (context == null || !BundleId.isValid(str)) {
            throw new IllegalArgumentException("invalid bundle slot id");
        }
        String strStorageId = BundleId.storageId(str);
        File fileCanonical = canonical(new File(context.getApplicationContext().getFilesDir(), BUNDLES_DIR));
        File fileCanonical2 = canonical(new File(fileCanonical, strStorageId));
        this.root = fileCanonical2;
        File fileCanonical3 = canonical(new File(fileCanonical, a.a(strStorageId, ".drch")));
        this.legacy = fileCanonical3;
        if (!fileCanonical.equals(fileCanonical2.getParentFile()) || !fileCanonical.equals(fileCanonical3.getParentFile())) {
            throw new IllegalArgumentException("bundle slot escaped private bundle directory");
        }
    }

    private static File canonical(File file) {
        try {
            return file.getCanonicalFile();
        } catch (IOException e) {
            throw new IllegalStateException("cannot resolve bundle slot path", e);
        }
    }

    private File child(String str) {
        File fileCanonical = canonical(new File(this.root, str));
        if (this.root.equals(fileCanonical.getParentFile())) {
            return fileCanonical;
        }
        throw new IllegalStateException("bundle slot escaped slot root");
    }

    private static void delete(File file) {
        if (file.exists()) {
            file.delete();
        }
    }

    private boolean isOwnedSlot(File file) {
        if (file == null) {
            return false;
        }
        File fileCanonical = canonical(file);
        return fileCanonical.equals(candidate()) || fileCanonical.equals(current()) || fileCanonical.equals(previous());
    }

    private static boolean move(File file, File file2) {
        File parentFile;
        if (!file.isFile() || (parentFile = file2.getParentFile()) == null || (!parentFile.isDirectory() && !parentFile.mkdirs())) {
            return false;
        }
        if (!file2.exists() || file2.delete()) {
            return file.renameTo(file2);
        }
        return false;
    }

    public File candidate() {
        return child("candidate.drch");
    }

    public File current() {
        return child("current.drch");
    }

    public void discardCandidate() {
        delete(candidate());
    }

    public void discardExternalSlots() {
        delete(candidate());
        delete(current());
        delete(previous());
        delete(this.legacy);
        File[] fileArrListFiles = this.root.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length != 0) {
            return;
        }
        this.root.delete();
    }

    public boolean ensureRoot() {
        return (this.root.isDirectory() || this.root.mkdirs()) && canonical(this.root).equals(this.root);
    }

    public File legacy() {
        return this.legacy;
    }

    public boolean moveLegacyTo(File file) {
        return isOwnedSlot(file) && move(this.legacy, file);
    }

    public File previous() {
        return child("previous.drch");
    }

    public boolean promoteCandidate() {
        File fileCandidate = candidate();
        File fileCurrent = current();
        File filePrevious = previous();
        if (!fileCandidate.isFile() || !ensureRoot()) {
            return false;
        }
        if (!fileCurrent.isFile() || ((!filePrevious.exists() || filePrevious.delete()) && fileCurrent.renameTo(filePrevious))) {
            return fileCandidate.renameTo(fileCurrent);
        }
        return false;
    }

    public boolean restorePreviousToCurrent() {
        File fileCurrent = current();
        File filePrevious = previous();
        return !fileCurrent.exists() && filePrevious.isFile() && filePrevious.renameTo(fileCurrent);
    }

    public File root() {
        return this.root;
    }

    public <T> T withExclusiveLock(LockedOperation<T> lockedOperation) {
        T tRun;
        if (lockedOperation == null) {
            throw new IllegalArgumentException("operation == null");
        }
        synchronized (PROCESS_SLOT_LOCK) {
            if (!ensureRoot()) {
                throw new IOException("cannot create bundle slot root " + this.root);
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(child(".slot.lock"), "rw");
            try {
                FileChannel channel = randomAccessFile.getChannel();
                try {
                    FileLock fileLockLock = channel.lock();
                    try {
                        tRun = lockedOperation.run();
                        if (fileLockLock != null) {
                            fileLockLock.close();
                        }
                        channel.close();
                        randomAccessFile.close();
                    } catch (Throwable th) {
                        if (fileLockLock != null) {
                            try {
                                fileLockLock.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                    }
                    throw th3;
                }
            } catch (Throwable th5) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th6) {
                    th5.addSuppressed(th6);
                }
                throw th5;
            }
        }
        return tRun;
    }
}
