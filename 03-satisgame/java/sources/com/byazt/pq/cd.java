package com.byazt.pq;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 109, 86})
public final class cd {
    public final String[] n;

    public cd(n nVar) {
        this.n = (String[]) nVar.n.toArray(new String[nVar.n.size()]);
    }

    private cd(String[] strArr) {
        this.n = strArr;
    }

    public String n(String str) {
        return n(this.n, str);
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

    public List<String> qg(String str) {
        int iN = n();
        ArrayList arrayList = null;
        for (int i = 0; i < iN; i++) {
            if (str.equalsIgnoreCase(n(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(qg(i));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public n qg() {
        n nVar = new n();
        Collections.addAll(nVar.n, this.n);
        return nVar;
    }

    public boolean equals(Object obj) {
        return (obj instanceof cd) && Arrays.equals(((cd) obj).n, this.n);
    }

    public int hashCode() {
        return Arrays.hashCode(this.n);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iN = n();
        for (int i = 0; i < iN; i++) {
            sb.append(n(i)).append(": ").append(qg(i)).append("\n");
        }
        return sb.toString();
    }

    public Map<String, List<String>> s() {
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

    private static String n(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static cd n(String... strArr) {
        if (strArr == null) {
            throw new NullPointerException("namesAndValues == null");
        }
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (int i = 0; i < strArr2.length; i++) {
            String str = strArr2[i];
            if (str == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i] = str.trim();
        }
        for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
            String str2 = strArr2[i2];
            String str3 = strArr2[i2 + 1];
            if (str2.length() == 0 || str2.indexOf(0) != -1 || str3.indexOf(0) != -1) {
                throw new IllegalArgumentException("Unexpected header: " + str2 + ": " + str3);
            }
        }
        return new cd(strArr2);
    }

    @com.byazt.cp.n(n = {0, 1, 109, 1424})
    public static final class n {
        public final List<String> n = new ArrayList(20);

        public n n(String str) {
            int iIndexOf = str.indexOf(":", 1);
            if (iIndexOf != -1) {
                return qg(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
            }
            if (str.startsWith(":")) {
                return qg("", str.substring(1));
            }
            return qg("", str);
        }

        public n n(String str, String str2) {
            try {
                q(str, str2);
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
            return qg(str, str2);
        }

        public n qg(String str, String str2) {
            this.n.add(str);
            this.n.add(str2.trim());
            return this;
        }

        public n qg(String str) {
            int i = 0;
            while (i < this.n.size()) {
                if (str.equalsIgnoreCase(this.n.get(i))) {
                    this.n.remove(i);
                    this.n.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public n s(String str, String str2) {
            try {
                q(str, str2);
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
                    }
                }
                return this;
            }
            qg(str);
            qg(str, str2);
            return this;
        }

        private void q(String str, String str2) {
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
                    throw new IllegalArgumentException(com.byazt.zho.s.n("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char cCharAt2 = str2.charAt(i2);
                if ((cCharAt2 <= 31 && cCharAt2 != '\t') || cCharAt2 >= 127) {
                    throw new IllegalArgumentException(com.byazt.zho.s.n("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i2), str, str2));
                }
            }
        }

        public cd n() {
            return new cd(this);
        }
    }
}
