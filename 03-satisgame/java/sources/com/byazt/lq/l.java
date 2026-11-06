package com.byazt.lq;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.byazt.tk.k;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 751, 18})
public class l {
    public static String n;

    /* JADX WARN: Code duplicated, block: B:45:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String n(String str) {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        FileReader fileReader = null;
        try {
            File file = new File("data/data/com.union_test.toutiao/" + str);
            if (!file.exists()) {
                return null;
            }
            FileReader fileReader2 = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader2);
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    } catch (Exception unused) {
                        fileReader = fileReader2;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable unused3) {
                            }
                        }
                        return sb.toString();
                    } catch (Throwable th) {
                        th = th;
                        fileReader = fileReader2;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Throwable unused4) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                                throw th;
                            } catch (Throwable unused5) {
                                throw th;
                            }
                        }
                        throw th;
                    }
                }
                String string = sb.toString();
                try {
                    fileReader2.close();
                } catch (Throwable unused6) {
                }
                try {
                    bufferedReader.close();
                } catch (Throwable unused7) {
                }
                return string;
            } catch (Exception unused8) {
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Exception unused9) {
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
        if (fileReader != null) {
            fileReader.close();
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        return sb.toString();
    }

    public static boolean n() {
        if (k.s()) {
            return com.byazt.vyf.s.cy().pk();
        }
        return false;
    }

    public static String n(String str, String str2) {
        return str.contains("https://api-access.pangolin-sdk-toutiao.com") ? str.replace("https://api-access.pangolin-sdk-toutiao.com", str2) : str;
    }

    public static String qg(String str) {
        try {
            if (!n()) {
                return str;
            }
            String strY = com.byazt.vyf.s.cy().y();
            return TextUtils.isEmpty(strY) ? str : Uri.parse(str).buildUpon().appendQueryParameter(qg(), strY).appendQueryParameter("aid", "5001121").toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static void n(Map<String, String> map) {
        if (n()) {
            map.put("x-app-id", "5001121");
            String strY = com.byazt.vyf.s.cy().y();
            if (TextUtils.isEmpty(strY)) {
                return;
            }
            map.put("x-device-id", strY);
        }
    }

    public static String s(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            String strS = com.byazt.ges.qg.s();
            if (!TextUtils.isEmpty(strS)) {
                strS = strS.replaceAll("\\.", "");
            }
            return Uri.parse(str).buildUpon().appendQueryParameter("sdkVersion", strS).toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static String qg() {
        if (TextUtils.isEmpty(n)) {
            n = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return n;
    }
}
