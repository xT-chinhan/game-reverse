package com.anythink.china.c;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.anythink.core.common.u.n;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final String a = "anythink" + File.separator + "pl";

    private static File a(Context context) {
        try {
            File file = new File(context.getFilesDir(), a);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static File a(Context context, String str) {
        try {
            File fileA = a(context);
            if (fileA == null) {
                return null;
            }
            File file = new File(fileA.getAbsolutePath(), str);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String b(Context context, String str) {
        try {
            ArrayList arrayList = new ArrayList(Arrays.asList(context.getAssets().list(a + File.separator + str)));
            if (arrayList.isEmpty()) {
                return "";
            }
            String str2 = (String) arrayList.get(0);
            return !TextUtils.isEmpty(str2) ? str2 : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0080 A[Catch: IOException -> 0x007c, Exception -> 0x0097, TRY_LEAVE, TryCatch #4 {Exception -> 0x0097, blocks: (B:3:0x0001, B:6:0x0008, B:8:0x000e, B:17:0x0056, B:19:0x005b, B:22:0x0060, B:36:0x0078, B:40:0x0080, B:44:0x0087, B:48:0x008f, B:51:0x0096, B:50:0x0093), top: B:58:0x0001, inners: #8 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public static File a(Context context, String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        try {
            File fileA = a(context, str);
            if (fileA != null && !TextUtils.isEmpty(str2)) {
                try {
                    AssetManager assets = context.getAssets();
                    File file = new File(fileA.getAbsolutePath(), str2);
                    try {
                        context = assets.open(a + File.separator + ((String) str) + File.separator + str2);
                        try {
                            fileOutputStream = new FileOutputStream(file);
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i = context.read(bArr);
                                    if (i > 0) {
                                        fileOutputStream.write(bArr, 0, i);
                                    } else {
                                        try {
                                            break;
                                        } catch (IOException e) {
                                            e = e;
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                fileOutputStream.close();
                                if (context != 0) {
                                    context.close();
                                }
                            } catch (IOException e2) {
                                e = e2;
                                e.printStackTrace();
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                        if (context != 0) {
                                            context.close();
                                        }
                                    } catch (IOException e3) {
                                        e = e3;
                                        e.printStackTrace();
                                    }
                                } else if (context != 0) {
                                    context.close();
                                }
                            }
                        } catch (IOException e4) {
                            e = e4;
                            fileOutputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            str = 0;
                            if (str != 0) {
                                try {
                                    str.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                    throw th;
                                }
                            }
                            if (context != 0) {
                                context.close();
                            }
                            throw th;
                        }
                    } catch (IOException e6) {
                        e = e6;
                        context = 0;
                        fileOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        context = 0;
                        str = 0;
                    }
                    return file;
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        return null;
    }

    public static File b(Context context, String str, final String str2) {
        File file;
        File[] fileArrListFiles;
        try {
            File fileA = a(context);
            if (fileA == null) {
                return null;
            }
            File[] fileArrListFiles2 = fileA.listFiles();
            if (fileArrListFiles2 == null) {
                file = null;
                break;
            }
            int length = fileArrListFiles2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    file = null;
                    break;
                }
                file = fileArrListFiles2[i];
                if (file.isDirectory() && file.getName().equals(str)) {
                    break;
                }
                i++;
            }
            if (file != null && (fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.anythink.china.c.a.1
                @Override // java.io.FileFilter
                public final boolean accept(File file2) {
                    return file2 != null && file2.getName().startsWith(str2) && file2.getName().endsWith(".jar");
                }
            })) != null && fileArrListFiles.length > 0) {
                long j = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < fileArrListFiles.length; i3++) {
                    long j2 = Long.parseLong(fileArrListFiles[i3].getName().replaceAll(".jar", "").split("-")[2]);
                    if (j2 >= j) {
                        i2 = i3;
                        j = j2;
                    }
                }
                File file2 = fileArrListFiles[i2];
                if (file2 != null) {
                    return file2;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void a(Context context, String str, File file) {
        File[] fileArrListFiles;
        try {
            File fileA = a(context, str);
            if (fileA == null || !fileA.isDirectory() || (fileArrListFiles = fileA.listFiles()) == null) {
                return;
            }
            for (File file2 : fileArrListFiles) {
                if (!file2.getName().equals(file.getName())) {
                    file2.delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(n.a);
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i != -1) {
                    messageDigest.update(bArr, 0, i);
                } else {
                    fileInputStream.close();
                    return a(messageDigest.digest());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b)));
        }
        return sb.toString();
    }
}
