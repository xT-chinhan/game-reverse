package com.byazt.ii;

import android.text.TextUtils;
import com.byazt.gs.uc;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1490, 37})
public class pr {
    public static String[] pr(File file) throws Throwable {
        String strPr;
        String str;
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                boolean z2 = false;
                boolean z3 = false;
                while (enumerationEntries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    if (zipEntryNextElement.getName().startsWith("META-INF/")) {
                        if (zipEntryNextElement.getName().endsWith("MANIFEST.MF")) {
                            z3 = true;
                        } else if (zipEntryNextElement.getName().endsWith(".SF")) {
                            z = true;
                        } else if (zipEntryNextElement.getName().endsWith(".RSA")) {
                            z2 = true;
                        }
                        arrayList.add(Long.valueOf(zipEntryNextElement.getCrc()));
                    }
                }
                Collections.sort(arrayList, Collections.reverseOrder());
                StringBuilder sb = new StringBuilder();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    sb.append((Long) it.next());
                }
                if (z3 && z && z2) {
                    strPr = uc.pr(sb.toString());
                    str = "";
                } else {
                    str = "without v1 signature.";
                    strPr = "";
                }
                hn.pr(zipFile2);
            } catch (Exception e) {
                zipFile = zipFile2;
                hn.pr(zipFile);
                strPr = "";
                str = strPr;
            } catch (Throwable th) {
                th = th;
                zipFile = zipFile2;
                hn.pr(zipFile);
                throw th;
            }
        } catch (Exception e2) {
        } catch (Throwable th2) {
            th = th2;
        }
        String[] strArr = new String[3];
        strArr[0] = strPr;
        strArr[1] = TextUtils.isEmpty(strPr) ? "" : "V1";
        strArr[2] = str;
        return strArr;
    }
}
