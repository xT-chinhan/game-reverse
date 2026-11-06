package com.anythink.china.b;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.umeng.analytics.pro.bv;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final String a = "anythink" + File.separator + bv.az;

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

    /* JADX WARN: Code duplicated, block: B:40:0x0083 A[Catch: IOException -> 0x007f, Exception -> 0x009a, TRY_LEAVE, TryCatch #2 {Exception -> 0x009a, blocks: (B:3:0x0001, B:6:0x0008, B:8:0x000e, B:17:0x0059, B:19:0x005e, B:22:0x0063, B:36:0x007b, B:40:0x0083, B:44:0x008a, B:48:0x0092, B:51:0x0099, B:50:0x0096), top: B:57:0x0001, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0092 A[Catch: IOException -> 0x008e, Exception -> 0x009a, TRY_LEAVE, TryCatch #7 {IOException -> 0x008e, blocks: (B:44:0x008a, B:48:0x0092), top: B:63:0x008a, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static File a(Context context, String str, String str2) throws Throwable {
        InputStream inputStreamOpen;
        FileOutputStream fileOutputStream;
        try {
            File fileA = a(context, str);
            if (fileA != null && !TextUtils.isEmpty(str2)) {
                AssetManager assets = context.getAssets();
                File file = new File(fileA.getAbsolutePath(), str2);
                file.getAbsolutePath();
                try {
                    inputStreamOpen = assets.open(a + File.separator + str + File.separator + str2);
                    try {
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i = inputStreamOpen.read(bArr);
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
                                if (inputStreamOpen != null) {
                                    inputStreamOpen.close();
                                }
                            } catch (IOException e2) {
                                e = e2;
                                e.printStackTrace();
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                        if (inputStreamOpen != null) {
                                            inputStreamOpen.close();
                                        }
                                    } catch (IOException e3) {
                                        e = e3;
                                        e.printStackTrace();
                                    }
                                } else if (inputStreamOpen != null) {
                                    inputStreamOpen.close();
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    throw th;
                                }
                            }
                            if (inputStreamOpen != null) {
                                inputStreamOpen.close();
                            }
                            throw th;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        fileOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = null;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (inputStreamOpen != null) {
                            inputStreamOpen.close();
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    e = e6;
                    inputStreamOpen = null;
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    inputStreamOpen = null;
                    fileOutputStream = null;
                }
                return file;
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
            new StringBuilder("getMaxChannelDexFile:").append(file);
            if (file != null && (fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.anythink.china.b.a.1
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
                    new StringBuilder("getMaxChannelDexFile:").append(file2).append(":");
                    file2.exists();
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
                    new StringBuilder("deleteChannelOtherFile:").append(file2.getName()).append(":");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
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
