package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes3.dex */
public final class pblb implements w0.pgla {

    private static class pgla {
        public ZipEntry hw;
        public ZipFile pr;

        public pgla(ZipFile zipFile, ZipEntry zipEntry) {
            this.pr = zipFile;
            this.hw = zipEntry;
        }
    }

    private static pgla pr(Context context, String[] strArr, String str, y0 y0Var) {
        String[] strArr2;
        String[] strArr3;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i = 0;
        if (Build.VERSION.SDK_INT < 21 || (strArr3 = applicationInfo.splitSourceDirs) == null || strArr3.length == 0) {
            strArr2 = new String[]{applicationInfo.sourceDir};
        } else {
            strArr2 = new String[strArr3.length + 1];
            strArr2[0] = applicationInfo.sourceDir;
            System.arraycopy(strArr3, 0, strArr2, 1, strArr3.length);
        }
        int length = strArr2.length;
        int i2 = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i2 >= length) {
                return null;
            }
            String str2 = strArr2[i2];
            int i3 = i;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException e) {
                    i3 = i4;
                }
            }
            if (zipFile != null) {
                int i5 = i;
                while (true) {
                    int i6 = i5 + 1;
                    if (i5 >= 5) {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException e2) {
                            break;
                        }
                    }
                    int length2 = strArr.length;
                    int i7 = i;
                    while (i7 < length2) {
                        String str3 = "lib" + File.separatorChar + strArr[i7] + File.separatorChar + str;
                        Object[] objArr = new Object[2];
                        objArr[i] = str3;
                        objArr[1] = str2;
                        y0Var.getClass();
                        String.format(Locale.US, "Looking for %s in APK %s...", objArr);
                        ZipEntry entry = zipFile.getEntry(str3);
                        if (entry != null) {
                            return new pgla(zipFile, entry);
                        }
                        i7++;
                        i = 0;
                    }
                    i5 = i6;
                    i = 0;
                }
            }
            i2++;
            i = 0;
        }
    }

    private static void pr(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    private static String[] pr(Context context, String str) {
        String[] strArr;
        String[] strArr2;
        Pattern patternCompile = Pattern.compile("lib" + File.separatorChar + "([^\\" + File.separatorChar + "]*)" + File.separatorChar + str);
        HashSet hashSet = new HashSet();
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (Build.VERSION.SDK_INT < 21 || (strArr2 = applicationInfo.splitSourceDirs) == null || strArr2.length == 0) {
            strArr = new String[]{applicationInfo.sourceDir};
        } else {
            strArr = new String[strArr2.length + 1];
            strArr[0] = applicationInfo.sourceDir;
            System.arraycopy(strArr2, 0, strArr, 1, strArr2.length);
        }
        ZipFile zipFile = null;
        for (String str2 : strArr) {
            try {
                ZipFile zipFile2 = new ZipFile(new File(str2), 1);
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
                while (enumerationEntries.hasMoreElements()) {
                    Matcher matcher = patternCompile.matcher(enumerationEntries.nextElement().getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
                zipFile = zipFile2;
            } catch (IOException e) {
            }
        }
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException e2) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public final void pr(Context context, String[] strArr, String str, File file, y0 y0Var) throws Throwable {
        String[] strArrPr;
        Throwable th;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        pgla pglaVar = null;
        fileOutputStream = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            pgla pglaVarPr = pr(context, strArr, str, y0Var);
            try {
                if (pglaVarPr == null) {
                    try {
                        strArrPr = pr(context, str);
                    } catch (Exception e) {
                        strArrPr = new String[]{e.toString()};
                    }
                    throw new t0(str, strArr, strArrPr);
                }
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (i >= 5) {
                        y0Var.getClass();
                        try {
                            ZipFile zipFile = pglaVarPr.pr;
                            if (zipFile != null) {
                                zipFile.close();
                                return;
                            }
                            return;
                        } catch (IOException e2) {
                            return;
                        }
                    }
                    y0Var.getClass();
                    String.format(Locale.US, "Found %s! Extracting...", str);
                    try {
                        if (file.exists() || file.createNewFile()) {
                            try {
                                inputStream = pglaVarPr.pr.getInputStream(pglaVarPr.hw);
                                try {
                                    fileOutputStream = new FileOutputStream(file);
                                    long j = 0;
                                    try {
                                        byte[] bArr = new byte[4096];
                                        while (true) {
                                            int i3 = inputStream.read(bArr);
                                            if (i3 == -1) {
                                                break;
                                            }
                                            fileOutputStream.write(bArr, 0, i3);
                                            j += (long) i3;
                                        }
                                        fileOutputStream.flush();
                                        fileOutputStream.getFD().sync();
                                        if (j == file.length()) {
                                            pr(inputStream);
                                            pr(fileOutputStream);
                                            file.setReadable(true, false);
                                            file.setExecutable(true, false);
                                            file.setWritable(true);
                                            try {
                                                ZipFile zipFile2 = pglaVarPr.pr;
                                                if (zipFile2 != null) {
                                                    zipFile2.close();
                                                    return;
                                                }
                                                return;
                                            } catch (IOException e3) {
                                                return;
                                            }
                                        }
                                        pr(inputStream);
                                        pr(fileOutputStream);
                                    } catch (FileNotFoundException e4) {
                                        pr(inputStream);
                                        pr(fileOutputStream);
                                    } catch (IOException e5) {
                                        pr(inputStream);
                                        pr(fileOutputStream);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        fileOutputStream2 = fileOutputStream;
                                        pr(inputStream);
                                        pr(fileOutputStream2);
                                        throw th;
                                    }
                                } catch (FileNotFoundException e6) {
                                    fileOutputStream = null;
                                    pr(inputStream);
                                    pr(fileOutputStream);
                                    i = i2;
                                } catch (IOException e7) {
                                    fileOutputStream = null;
                                    pr(inputStream);
                                    pr(fileOutputStream);
                                    i = i2;
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            } catch (FileNotFoundException e8) {
                                inputStream = null;
                                fileOutputStream = null;
                                pr(inputStream);
                                pr(fileOutputStream);
                                i = i2;
                            } catch (IOException e9) {
                                inputStream = null;
                                fileOutputStream = null;
                                pr(inputStream);
                                pr(fileOutputStream);
                                i = i2;
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream = null;
                            }
                        }
                    } catch (IOException e10) {
                    }
                    i = i2;
                }
            } catch (Throwable th5) {
                th = th5;
                pglaVar = pglaVarPr;
                if (pglaVar != null) {
                    try {
                        ZipFile zipFile3 = pglaVar.pr;
                        if (zipFile3 != null) {
                            zipFile3.close();
                        }
                    } catch (IOException e11) {
                    }
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
