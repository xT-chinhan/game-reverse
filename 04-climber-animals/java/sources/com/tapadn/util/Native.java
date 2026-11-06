package com.tapadn.util;

import com.anythink.core.common.d.j;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public enum Native {
    ;

    private static boolean loaded = false;

    private enum OS {
        WINDOWS("win32", "so"),
        LINUX("linux", "so"),
        MAC("darwin", "dylib"),
        SOLARIS("solaris", "so");

        public final String libExtension;
        public final String name;

        OS(String str, String str2) {
            this.name = str;
            this.libExtension = str2;
        }
    }

    private static String arch() {
        return System.getProperty("os.arch");
    }

    private static void cleanupOldTempLibs() {
        File[] fileArrListFiles = new File(new File(System.getProperty("java.io.tmpdir")).getAbsolutePath()).listFiles(new FilenameFilter() { // from class: com.tapadn.util.Native.1
            private final String searchPattern = "liblz4-java-";

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.startsWith("liblz4-java-") && !str.endsWith(".lck");
            }
        });
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (!new File(file.getAbsolutePath() + ".lck").exists()) {
                    try {
                        file.delete();
                    } catch (SecurityException e) {
                        System.err.println("Failed to delete old temp lib" + e.getMessage());
                    }
                }
            }
        }
    }

    public static synchronized boolean isLoaded() {
        return loaded;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.StringBuilder] */
    public static synchronized void load() {
        Throwable th;
        ?? r0;
        IOException e;
        String str = j.z;
        synchronized (Native.class) {
            if (loaded) {
                return;
            }
            cleanupOldTempLibs();
            try {
                System.loadLibrary("lz4-java");
                loaded = true;
            } catch (UnsatisfiedLinkError unused) {
                String strResourceName = resourceName();
                InputStream resourceAsStream = Native.class.getResourceAsStream(strResourceName);
                if (resourceAsStream == null) {
                    throw new UnsupportedOperationException("Unsupported OS/arch, cannot find " + strResourceName + ". Please try building from source.");
                }
                File file = null;
                try {
                    try {
                        File fileCreateTempFile = File.createTempFile("liblz4-java-", j.z + os().libExtension + ".lck");
                        try {
                            File file2 = new File(fileCreateTempFile.getAbsolutePath().replaceFirst(".lck$", ""));
                            try {
                                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                                try {
                                    byte[] bArr = new byte[4096];
                                    while (true) {
                                        int i = resourceAsStream.read(bArr);
                                        if (i == -1) {
                                            fileOutputStream.close();
                                            System.load(file2.getAbsolutePath());
                                            loaded = true;
                                            file2.deleteOnExit();
                                            fileCreateTempFile.deleteOnExit();
                                            return;
                                        }
                                        fileOutputStream.write(bArr, 0, i);
                                    }
                                } catch (Throwable th2) {
                                    try {
                                        throw th2;
                                    } catch (Throwable th3) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (Throwable th4) {
                                            th2.addSuppressed(th4);
                                        }
                                        throw th3;
                                    }
                                }
                            } catch (IOException e2) {
                                e = e2;
                                throw new ExceptionInInitializerError("Cannot unpack liblz4-java: " + e);
                            } catch (Throwable th5) {
                                th = th5;
                                file = file2;
                                r0 = fileCreateTempFile;
                                if (loaded) {
                                    file.deleteOnExit();
                                    r0.deleteOnExit();
                                } else {
                                    if (file != null && file.exists() && !file.delete()) {
                                        throw new ExceptionInInitializerError("Cannot unpack liblz4-java / cannot delete a temporary native library " + file);
                                    }
                                    if (r0 != 0 && r0.exists() && !r0.delete()) {
                                        throw new ExceptionInInitializerError("Cannot unpack liblz4-java / cannot delete a temporary lock file " + r0);
                                    }
                                }
                                throw th;
                            }
                        } catch (IOException e3) {
                            e = e3;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        r0 = str;
                    }
                } catch (IOException e4) {
                    e = e4;
                } catch (Throwable th7) {
                    th = th7;
                    r0 = 0;
                }
            }
        }
    }

    private static OS os() {
        String property = System.getProperty("os.name");
        if (property.contains("Linux")) {
            return OS.LINUX;
        }
        if (property.contains("Mac")) {
            return OS.MAC;
        }
        if (property.contains("Windows")) {
            return OS.WINDOWS;
        }
        if (property.contains("Solaris") || property.contains("SunOS")) {
            return OS.SOLARIS;
        }
        throw new UnsupportedOperationException("Unsupported operating system: " + property);
    }

    private static String resourceName() {
        OS os = os();
        return "/" + Native.class.getPackage().getName().replace('.', '/') + "/" + os.name + "/" + arch() + "/liblz4-java." + os.libExtension;
    }
}
