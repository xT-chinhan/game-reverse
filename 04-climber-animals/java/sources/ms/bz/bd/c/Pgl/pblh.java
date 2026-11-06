package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import com.umeng.analytics.pro.ek;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class pblh {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4849ms = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "bec124", new byte[]{67, 117, 31, 70, 8, 48, 114, 75, 32});
    private static final String xr = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "f7ae84", new byte[]{95, 52, 0, 21, ek.n, 34, 119, 19});
    private static final String ah = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "7dcdaf", new byte[]{0, 99, 17, 4, 75, 99, 49, 86});
    private static final String d = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "82ecc3", new byte[]{57, 51});
    private static final String ka = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "4c53cc", new byte[]{45, 118});
    private static final String c = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "8060f6", new byte[]{47, 38});
    private static final String ab = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "ecce5a", new byte[]{121, 96, 8});
    private static final String x = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "929abc", new byte[]{37, 57, 68});
    private static final String ny = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "a49769", new byte[]{115, 57, 88, 70});
    private static final FileFilter ch = new pgla();

    final class pgla implements FileFilter {
        pgla() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            return Pattern.matches((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "05dbaf", new byte[]{34, 39, 2, 45, ek.l, 60, 106, 41}), file.getName());
        }
    }

    private static int ah() {
        try {
            return new File((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "41e8f5", new byte[]{106, 32, ek.m, 95, 22, 38, 50, 6, 61, 107, 32, 32, 89, 95, com.anythink.core.common.s.a.c.b, 49, 35, 21, 57, 39, 38, 35, 3, 3})).listFiles(ch).length;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String ms() {
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap<String, String> mapXr = xr();
            jSONObject.put(ny, ah());
            String str3 = null;
            try {
                str = mapXr.get(f4849ms);
            } catch (Throwable unused) {
                str = null;
            }
            jSONObject.put(d, str == null ? "" : str.trim());
            try {
                str2 = mapXr.get(xr);
            } catch (Throwable unused2) {
                str2 = null;
            }
            jSONObject.put(ka, str2 == null ? "" : str2.trim());
            jSONObject.put(ab, ms((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2b0b92", new byte[]{108, 115, 90, 5, 73, 33, 52, 85, 104, 49, 38, 115, 12, 5, 31, 54, 37, 70, 108, 125, 32, 112, 86, 89, 5, 53, 36, 19, 46, 49, 51, 117, 69, 4, 3, 52, 126, com.anythink.core.common.s.a.c.b, 113, 39, 42, 110, 69, 25, 57, 40, 48, 91, 94, 52, 49, 101, 82})));
            jSONObject.put(x, ms((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "82847e", new byte[]{102, 35, 82, 83, 71, 118, 62, 5, 96, 103, 44, 35, 4, 83, 17, 97, 47, 22, 100, 43, 42, 32, 94, ek.m, 11, 98, 46, 67, 38, 103, 57, 37, 77, 82, ek.k, 99, 116, ek.n, 121, 113, 32, 62, 77, 79, 55, 127, 50, 29, 86, 98, 59, 53, 90})));
            try {
                str3 = mapXr.get(ah);
            } catch (Throwable unused3) {
            }
            jSONObject.put(c, str3 != null ? str3.trim() : "");
        } catch (Throwable unused4) {
        }
        String string = jSONObject.toString();
        return TextUtils.isEmpty(string) ? (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "48a2e4", new byte[]{62, 39}) : string.trim();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0046  */
    /* JADX WARN: Code duplicated, block: B:22:0x005b  */
    private static String ms(String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String line = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f588d0", new byte[]{39});
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
                        return line == null ? (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "657e85", new byte[]{119}) : line.trim();
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

    private static HashMap<String, String> xr() {
        FileReader fileReader;
        HashMap<String, String> map = new HashMap<>();
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "91865f", new byte[]{103, 35, 89, 77, 9, 62, 57, 0, 124, 111, 38, 53, 68}));
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
                            String[] strArrSplit = line.split((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0d97d7", new byte[]{123}), 2);
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
}
