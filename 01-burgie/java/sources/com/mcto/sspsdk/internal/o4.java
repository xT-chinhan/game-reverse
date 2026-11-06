package com.mcto.sspsdk.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class o4 implements Runnable {
    public final /* synthetic */ String a;

    public o4(String str) {
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        FileOutputStream fileOutputStream;
        ZipInputStream zipInputStream;
        int iLastIndexOf = this.a.lastIndexOf(".zip");
        if (iLastIndexOf < 0) {
            return;
        }
        String strSubstring = this.a.substring(0, iLastIndexOf);
        File file = new File(strSubstring);
        if (file.exists()) {
            if (p4.b(file) != null) {
                p4.a(new File(this.a));
                return;
            } else {
                p4.a(file);
                n4.a().b(file, "html");
            }
        }
        file.mkdirs();
        ZipInputStream zipInputStream2 = null;
        FileOutputStream fileOutputStream2 = null;
        zipInputStream2 = null;
        try {
            zipInputStream = new ZipInputStream(new FileInputStream(this.a));
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        p4.a(new File(this.a));
                        n4.a().a(file, "html");
                        p4.a(fileOutputStream2);
                        p4.a(zipInputStream);
                        return;
                    }
                    String name = nextEntry.getName();
                    if (nextEntry.isDirectory()) {
                        new File(strSubstring + File.separator + name.substring(0, name.length() - 1)).mkdirs();
                    } else {
                        int iLastIndexOf2 = name.lastIndexOf(47);
                        if (iLastIndexOf2 > 0) {
                            new File(strSubstring + File.separator + name.substring(0, iLastIndexOf2)).mkdirs();
                        }
                        File file2 = new File(strSubstring + File.separator + name);
                        file2.createNewFile();
                        fileOutputStream = new FileOutputStream(file2);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i = zipInputStream.read(bArr);
                                if (i == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, i);
                                fileOutputStream.flush();
                            }
                            p4.a(fileOutputStream);
                            fileOutputStream2 = fileOutputStream;
                        } catch (Exception e) {
                            e = e;
                            zipInputStream2 = zipInputStream;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream2 = fileOutputStream;
                            p4.a(fileOutputStream2);
                            p4.a(zipInputStream);
                            throw th;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    zipInputStream2 = zipInputStream;
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    p4.a(file);
                    r9.a("ssp_splash_m", "unzip file failed: ", e);
                    p4.a(fileOutputStream);
                    p4.a(zipInputStream2);
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    zipInputStream = zipInputStream2;
                    fileOutputStream2 = fileOutputStream;
                    p4.a(fileOutputStream2);
                    p4.a(zipInputStream);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            zipInputStream = zipInputStream2;
            fileOutputStream2 = fileOutputStream;
            p4.a(fileOutputStream2);
            p4.a(zipInputStream);
            throw th;
        }
    }
}
