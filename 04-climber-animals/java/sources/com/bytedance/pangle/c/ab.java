package com.bytedance.pangle.c;

import android.content.SharedPreferences;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.taptap.sdk.compliance.bean.IdentityVerifyStateKt;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes2.dex */
public class ab {
    public static void ms(File file, String str, int i) throws Throwable {
        String str2 = ".dex";
        String str3 = "classes";
        if (!file.exists() || str == null) {
            throw new IOException("Could not check apk info " + file.getAbsolutePath());
        }
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ArrayList arrayList = new ArrayList();
                File file2 = new File(com.bytedance.pangle.ka.ah.ny(str, i));
                ms(file2);
                int i2 = 1;
                int i3 = 1;
                while (true) {
                    Object objValueOf = "";
                    ZipEntry entry = zipFile2.getEntry(str3 + (i3 == i2 ? "" : Integer.valueOf(i3)) + str2);
                    if (entry != null) {
                        StringBuilder sbAppend = new StringBuilder().append(str3);
                        if (i3 != i2) {
                            objValueOf = Integer.valueOf(i3);
                        }
                        ms msVar = new ms(file2, sbAppend.append(objValueOf).append(str2).toString());
                        int i4 = 0;
                        int i5 = 0;
                        while (i4 < 3 && i5 == 0) {
                            try {
                                ms(zipFile2, entry, msVar, str3);
                                i5 = i2;
                            } catch (IOException e) {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to extract entry from " + msVar.getAbsolutePath(), e);
                            }
                            i4++;
                            String str4 = str2;
                            String str5 = str3;
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Extraction " + (i5 != 0 ? "succeeded" : IdentityVerifyStateKt.VERIFY_STATE_FAILED) + " '" + msVar.getAbsolutePath() + "': length " + msVar.length());
                            if (i5 == 0) {
                                msVar.delete();
                                if (msVar.exists()) {
                                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to delete corrupted secondary dex '" + msVar.getPath() + "'");
                                }
                            }
                            str2 = str4;
                            str3 = str5;
                            i2 = 1;
                        }
                        String str6 = str2;
                        String str7 = str3;
                        if (i5 == 0) {
                            throw new IOException("Could not create zip file " + msVar.getAbsolutePath() + " for secondary dex (" + i3 + ")");
                        }
                        arrayList.add(msVar);
                        i3++;
                        str2 = str6;
                        str3 = str7;
                        i2 = 1;
                    } else {
                        ms(str, i, file.getName(), arrayList);
                        com.bytedance.pangle.util.ab.ms(zipFile2);
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                zipFile = zipFile2;
                com.bytedance.pangle.util.ab.ms(zipFile);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String ms(String str, int i) {
        int iXr = xr(str, i);
        StringBuilder sb = new StringBuilder();
        int i2 = 1;
        while (i2 <= iXr) {
            sb.append(new ms(new File(com.bytedance.pangle.ka.ah.ny(str, i)), i2 == 1 ? "classes.dex" : "classes" + i2 + ".dex").getAbsolutePath()).append(":");
            i2++;
        }
        if (sb.length() != 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }

    private static void ms(ZipFile zipFile, ZipEntry zipEntry, ms msVar, String str) throws IOException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File fileCreateTempFile = File.createTempFile("tmp-".concat(String.valueOf(str)), ".dex", msVar.getParentFile());
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileCreateTempFile));
            try {
                byte[] bArr = new byte[1048576];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        break;
                    } else {
                        bufferedOutputStream.write(bArr, 0, i);
                    }
                }
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                if (!fileCreateTempFile.setReadOnly()) {
                    throw new IOException("Failed to mark readonly \"" + fileCreateTempFile.getAbsolutePath() + "\" (tmp of \"" + msVar.getAbsolutePath() + "\")");
                }
                if (!fileCreateTempFile.renameTo(msVar)) {
                    throw new IOException("Failed to rename \"" + fileCreateTempFile.getAbsolutePath() + "\" to \"" + msVar.getAbsolutePath() + "\"");
                }
                ms(inputStream);
                fileCreateTempFile.delete();
            } catch (Throwable th) {
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            ms(inputStream);
            fileCreateTempFile.delete();
            throw th2;
        }
    }

    private static void ms(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to close resource", e);
        }
    }

    private static void ms(File file) {
        File[] fileArrListFiles;
        if (!file.exists() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Trying to delete old file " + file2.getPath() + " of size " + file2.length());
            if (!file2.delete()) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to delete old file " + file2.getPath());
            }
        }
    }

    private static void ms(String str, int i, String str2, List<ms> list) {
        String str3 = str + "-" + i;
        SharedPreferences.Editor editorEdit = ms().edit();
        editorEdit.putInt(str3 + ".dex.number", list.size());
        editorEdit.commit();
    }

    private static SharedPreferences ms() {
        return Zeus.getAppApplication().getSharedPreferences("plugin-multidex.version", 0);
    }

    private static int xr(String str, int i) {
        return ms((str + "-" + i) + ".dex.number");
    }

    private static int ms(String str) {
        return ms().getInt(str, 0);
    }

    private static class ms extends File {
        public ms(File file, String str) {
            super(file, str);
        }
    }
}
