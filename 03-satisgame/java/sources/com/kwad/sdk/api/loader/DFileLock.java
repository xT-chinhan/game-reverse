package com.kwad.sdk.api.loader;

import android.content.Context;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes3.dex */
public class DFileLock {
    private static DFileLock instance = new DFileLock();
    private static final String pidFile = "locfile";

    interface LockCallback {
        void run(FileLock fileLock);
    }

    public interface LockListener {
        void onComplete(boolean z);
    }

    private DFileLock() {
    }

    public DFileLock getInstance() {
        return instance;
    }

    public void tryLockFile(Context context, final LockListener lockListener) throws Throwable {
        File file = new File(context.getApplicationInfo().dataDir, pidFile);
        if (!file.exists()) {
            lockListener.onComplete(true);
            try {
                if (file.createNewFile()) {
                    lockFile(file, false, new LockCallback() { // from class: com.kwad.sdk.api.loader.DFileLock.1
                        @Override // com.kwad.sdk.api.loader.DFileLock.LockCallback
                        public void run(FileLock fileLock) {
                        }
                    });
                    return;
                }
                return;
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        lockFile(file, true, new LockCallback() { // from class: com.kwad.sdk.api.loader.DFileLock.2
            @Override // com.kwad.sdk.api.loader.DFileLock.LockCallback
            public void run(FileLock fileLock) {
                if (fileLock == null) {
                    lockListener.onComplete(false);
                } else {
                    lockListener.onComplete(true);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v7 */
    private void lockFile(File file, boolean z, LockCallback lockCallback) throws Throwable {
        FileOutputStream fileOutputStream;
        FileChannel channel;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    channel = fileOutputStream.getChannel();
                    try {
                        FileLock fileLockTryLock = z ? channel.tryLock() : channel.lock();
                        if (lockCallback != null) {
                            lockCallback.run(fileLockTryLock);
                        }
                        if (channel != null) {
                            try {
                                channel.close();
                            } catch (Throwable unused) {
                            }
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        e.printStackTrace();
                        if (lockCallback != null) {
                            lockCallback.run(null);
                        }
                        if (channel != null) {
                            try {
                                channel.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        if (fileOutputStream == null) {
                            return;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        if (lockCallback != null) {
                            lockCallback.run(null);
                        }
                        if (channel != null) {
                            try {
                                channel.close();
                            } catch (Throwable unused3) {
                            }
                        }
                        if (fileOutputStream == null) {
                            return;
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    channel = null;
                } catch (IOException e4) {
                    e = e4;
                    channel = null;
                } catch (Throwable th) {
                    th = th;
                    file = 0;
                    if (lockCallback != null) {
                        lockCallback.run(null);
                    }
                    if (file != 0) {
                        try {
                            file.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    if (fileOutputStream == null) {
                        throw th;
                    }
                    try {
                        fileOutputStream.close();
                        throw th;
                    } catch (Throwable unused5) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            channel = null;
            fileOutputStream = null;
        } catch (IOException e6) {
            e = e6;
            channel = null;
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            file = 0;
            fileOutputStream = null;
        }
        try {
            fileOutputStream.close();
        } catch (Throwable unused6) {
        }
    }
}
