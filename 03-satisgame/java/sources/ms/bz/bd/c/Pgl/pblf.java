package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class pblf {
    private static final String n = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "cac0e6", new byte[]{66, 113, 31, 71, 95, 50, 115, 79, 32});
    private static final String qg = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "e5b548", new byte[]{92, 54, 3, 69, 28, 46, 116, 17});
    private static final String s = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "438922", new byte[]{3, 52, 74, 89, 24, 55, 50, 1});
    private static final String q = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "1d0148", new byte[]{48, 101});
    private static final String l = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "2d33b0", new byte[]{43, 113});
    private static final String w = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "08277f", new byte[]{39, 46});
    private static final String x = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "c392a4", new byte[]{127, 48, 82});
    private static final String fs = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "d3b8b1", new byte[]{120, 56, 31});
    private static final String rv = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "13b360", new byte[]{35, 62, 3, 66});
    private static final FileFilter tj = new pgla();

    final class pgla implements FileFilter {
        pgla() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            return Pattern.matches((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f7a6df", new byte[]{116, 37, 7, 121, 11, 60, 60, 43}), file.getName());
        }
    }

    public static String n() {
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap<String, String> mapQg = qg();
            jSONObject.put(rv, s());
            String str3 = null;
            try {
                str = mapQg.get(n);
            } catch (Throwable unused) {
                str = null;
            }
            jSONObject.put(q, str == null ? "" : str.trim());
            try {
                str2 = mapQg.get(qg);
            } catch (Throwable unused2) {
                str2 = null;
            }
            jSONObject.put(l, str2 == null ? "" : str2.trim());
            jSONObject.put(x, n((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "af6617", new byte[]{com.anythink.core.common.r.a.c.c, 119, 92, 81, 65, 36, 103, 81, 110, 101, 117, 119, 10, 81, 23, 51, 118, 66, 106, 41, 115, 116, 80, 13, 13, 48, 119, 23, 40, 101, 96, 113, 67, 80, 11, 49, 45, 68, 119, 115, 121, 106, 67, 77, 49, 45, 99, 95, 88, 96, 98, 97, 84})));
            jSONObject.put(fs, n((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e63847", new byte[]{59, 39, 89, 95, 68, 36, 99, 1, 107, 107, 113, 39, 15, 95, 18, 51, 114, 18, 111, 39, 119, 36, 85, 3, 8, 48, 115, 71, 45, 107, 100, 33, 70, 94, 14, 49, 41, 20, 114, 125, 125, 58, 70, 67, 52, 45, 111, 25, 93, 110, 102, 49, 81})));
            try {
                str3 = mapQg.get(s);
            } catch (Throwable unused3) {
            }
            jSONObject.put(w, str3 != null ? str3.trim() : "");
        } catch (Throwable unused4) {
        }
        String string = jSONObject.toString();
        return TextUtils.isEmpty(string) ? (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "535290", new byte[]{com.anythink.core.common.r.a.c.c, 44}) : string.trim();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0046  */
    /* JADX WARN: Code duplicated, block: B:22:0x0059  */
    private static String n(String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String line = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4d9ecb", new byte[]{117});
            }
            fileReader = new FileReader(file);
            try {
                try {
                    bufferedReader = new BufferedReader(fileReader);
                    try {
                        line = bufferedReader.readLine();
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable unused2) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable unused3) {
                            }
                        }
                        if (fileReader != null) {
                        }
                        return line == null ? (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "414bea", new byte[]{117}) : line.trim();
                    }
                } catch (Throwable unused4) {
                    bufferedReader = null;
                }
                fileReader.close();
            } catch (Throwable unused5) {
            }
            if (line == null) {
            }
        } catch (Throwable unused6) {
            fileReader = null;
            bufferedReader = null;
        }
    }

    private static HashMap<String, String> qg() {
        FileReader fileReader;
        HashMap<String, String> map = new HashMap<>();
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "969453", new byte[]{103, 36, 88, 79, 9, 107, 57, 7, 125, 109, 38, 50, 69}));
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader);
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            try {
                                break;
                            } catch (Throwable unused) {
                            }
                        } else {
                            String[] strArrSplit = line.split((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "eb57a4", new byte[]{46}), 2);
                            if (strArrSplit.length >= 2) {
                                String strTrim = strArrSplit[0].trim();
                                String strTrim2 = strArrSplit[1].trim();
                                if (map.get(strTrim) == null) {
                                    map.put(strTrim, strTrim2);
                                } else {
                                    continue;
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable unused3) {
                            }
                        }
                        if (fileReader != null) {
                        }
                        return map;
                    }
                }
                bufferedReader2.close();
            } catch (Throwable unused4) {
            }
        } catch (Throwable unused5) {
            fileReader = null;
        }
        try {
            fileReader.close();
        } catch (Throwable unused6) {
        }
        return map;
    }

    private static int s() {
        try {
            return new File((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d5ea82", new byte[]{58, 36, 15, 6, 72, 33, 98, 2, 61, 50, 112, 36, 89, 6, 30, 54, 115, 17, 57, 126, 118, 39, 3, 90})).listFiles(tj).length;
        } catch (Throwable unused) {
            return -1;
        }
    }
}
