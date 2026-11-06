package com.bytedance.sdk.openadsdk.core.jw;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class jw {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static String f2707ms;

    /* JADX WARN: Code duplicated, block: B:48:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String ms(String str) {
        BufferedReader bufferedReader;
        Exception e;
        FileReader fileReader;
        StringBuilder sb = new StringBuilder();
        FileReader fileReader2 = null;
        try {
            File file = new File("data/data/com.union_test.toutiao/" + str);
            if (!file.exists()) {
                return null;
            }
            fileReader = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader);
                while (true) {
                    try {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line);
                        } catch (Exception e2) {
                            e = e2;
                            com.bytedance.sdk.component.utils.sl.ms(e);
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Throwable unused) {
                                }
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable unused2) {
                                }
                            }
                            return sb.toString();
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                    th = th;
                    fileReader2 = fileReader;
                    if (fileReader2 != null) {
                        try {
                            fileReader2.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            throw th;
                        } catch (Throwable unused4) {
                            throw th;
                        }
                    }
                    throw th;
                }
                String string = sb.toString();
                try {
                    fileReader.close();
                } catch (Throwable unused5) {
                }
                try {
                    bufferedReader.close();
                } catch (Throwable unused6) {
                }
                return string;
            } catch (Exception e3) {
                e = e3;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Exception e4) {
            bufferedReader = null;
            e = e4;
            fileReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
        com.bytedance.sdk.component.utils.sl.ms(e);
        if (fileReader != null) {
            fileReader.close();
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        return sb.toString();
    }

    public static boolean ms() {
        if (com.bytedance.sdk.component.utils.sl.ah()) {
            return com.bytedance.sdk.openadsdk.core.ch.ub().fm();
        }
        return false;
    }

    public static String ms(String str, String str2) {
        return str.contains("https://api-access.pangolin-sdk-toutiao.com") ? str.replace("https://api-access.pangolin-sdk-toutiao.com", str2) : str;
    }

    public static String xr(String str) {
        try {
            if (!ms()) {
                return str;
            }
            String strIl = com.bytedance.sdk.openadsdk.core.ch.ub().il();
            return TextUtils.isEmpty(strIl) ? str : Uri.parse(str).buildUpon().appendQueryParameter(xr(), strIl).appendQueryParameter("aid", "5001121").toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static void ms(Map<String, String> map) {
        if (ms()) {
            map.put("x-app-id", "5001121");
            String strIl = com.bytedance.sdk.openadsdk.core.ch.ub().il();
            if (TextUtils.isEmpty(strIl)) {
                return;
            }
            map.put("x-device-id", strIl);
        }
    }

    public static String xr() {
        if (TextUtils.isEmpty(f2707ms)) {
            f2707ms = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return f2707ms;
    }
}
