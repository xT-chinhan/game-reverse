package com.byazt.tbt;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1089, 13})
public final class w {
    public final String[] n;

    public w(String[] strArr) {
        this.n = strArr;
    }

    public w(n nVar) {
        this.n = (String[]) nVar.n.toArray(new String[nVar.n.size()]);
    }

    public int n() {
        return this.n.length / 2;
    }

    public String n(int i) {
        return this.n[i * 2];
    }

    public String qg(int i) {
        return this.n[(i * 2) + 1];
    }

    public Map<String, List<String>> qg() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int iN = n();
        for (int i = 0; i < iN; i++) {
            String lowerCase = n(i).toLowerCase(Locale.US);
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(qg(i));
        }
        return treeMap;
    }

    @com.byazt.cp.n(n = {0, 1, 1089, 108})
    public static final class n {
        public final List<String> n = new ArrayList(20);

        public w n() {
            return new w(this);
        }

        public n n(String str, String str2) {
            this.n.add(str);
            this.n.add(str2.trim());
            return this;
        }

        public n qg(String str, String str2) {
            try {
                s(str, str2);
            } catch (Throwable unused) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        int length = str2.length();
                        for (int i = 0; i < length; i++) {
                            char cCharAt = str2.charAt(i);
                            if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                                sb.append(URLEncoder.encode(String.valueOf(cCharAt), "UTF-8"));
                            } else {
                                sb.append(cCharAt);
                            }
                        }
                        str2 = sb.toString();
                    } catch (UnsupportedEncodingException unused2) {
                        return this;
                    }
                }
                return this;
            }
            return n(str, str2);
        }

        private void s(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt <= ' ' || cCharAt >= 127) {
                    throw new IllegalArgumentException(com.byazt.equ.tj.n("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char cCharAt2 = str2.charAt(i2);
                if ((cCharAt2 <= 31 && cCharAt2 != '\t') || cCharAt2 >= 127) {
                    throw new IllegalArgumentException(com.byazt.equ.tj.n("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i2), str, str2));
                }
            }
        }
    }
}
