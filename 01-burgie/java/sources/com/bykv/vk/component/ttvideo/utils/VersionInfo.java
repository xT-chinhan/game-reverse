package com.bykv.vk.component.ttvideo.utils;

import android.os.Build;
import java.io.BufferedReader;
import java.io.FileReader;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class VersionInfo {
    private static String[] mVersion;

    /* JADX WARN: Code duplicated, block: B:26:0x004d A[Catch: all -> 0x0051, TRY_LEAVE, TryCatch #0 {all -> 0x0051, blocks: (B:9:0x002e, B:11:0x0033, B:26:0x004d, B:24:0x0047, B:8:0x002b, B:20:0x0040), top: B:34:0x0010, inners: #1, #2 }] */
    public static String[] getVersion() {
        FileReader fileReader;
        if (mVersion == null) {
            String[] strArr = {AbstractJsonLexerKt.NULL, AbstractJsonLexerKt.NULL, AbstractJsonLexerKt.NULL, AbstractJsonLexerKt.NULL};
            BufferedReader bufferedReader = null;
            try {
                try {
                    fileReader = new FileReader("/proc/version");
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(fileReader, 8192);
                        try {
                            strArr[0] = bufferedReader2.readLine().split("\\s+")[2];
                            try {
                                bufferedReader2.close();
                                fileReader.close();
                            } catch (Throwable th) {
                                fileReader.close();
                            }
                        } catch (Throwable th2) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                    if (fileReader != null) {
                                        fileReader.close();
                                    }
                                } catch (Throwable th3) {
                                    if (fileReader != null) {
                                        fileReader.close();
                                    }
                                }
                            } else if (fileReader != null) {
                                fileReader.close();
                            }
                        }
                    } catch (Throwable th4) {
                    }
                } catch (Throwable th5) {
                }
            } catch (Throwable th6) {
                fileReader = null;
            }
            strArr[1] = Build.VERSION.RELEASE;
            strArr[2] = Build.MODEL;
            strArr[3] = Build.DISPLAY;
            mVersion = strArr;
        }
        return mVersion;
    }
}
