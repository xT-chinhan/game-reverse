package com.bytedance.sdk.component.ah.xr;

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
public final class qv {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final String[] f1136ms;

    qv(ms msVar) {
        this.f1136ms = (String[]) msVar.f1137ms.toArray(new String[msVar.f1137ms.size()]);
    }

    private qv(String[] strArr) {
        this.f1136ms = strArr;
    }

    public String ms(String str) {
        return ms(this.f1136ms, str);
    }

    public int ms() {
        return this.f1136ms.length / 2;
    }

    public String ms(int i) {
        return this.f1136ms[i * 2];
    }

    public String xr(int i) {
        return this.f1136ms[(i * 2) + 1];
    }

    public List<String> xr(String str) {
        int iMs = ms();
        ArrayList arrayList = null;
        for (int i = 0; i < iMs; i++) {
            if (str.equalsIgnoreCase(ms(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(xr(i));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public ms xr() {
        ms msVar = new ms();
        Collections.addAll(msVar.f1137ms, this.f1136ms);
        return msVar;
    }

    public boolean equals(Object obj) {
        return (obj instanceof qv) && Arrays.equals(((qv) obj).f1136ms, this.f1136ms);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f1136ms);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iMs = ms();
        for (int i = 0; i < iMs; i++) {
            sb.append(ms(i)).append(": ").append(xr(i)).append("\n");
        }
        return sb.toString();
    }

    public Map<String, List<String>> ah() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int iMs = ms();
        for (int i = 0; i < iMs; i++) {
            String lowerCase = ms(i).toLowerCase(Locale.US);
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(xr(i));
        }
        return treeMap;
    }

    private static String ms(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static qv ms(String... strArr) {
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
        return new qv(strArr2);
    }

    public static final class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final List<String> f1137ms = new ArrayList(20);

        ms ms(String str) {
            int iIndexOf = str.indexOf(":", 1);
            if (iIndexOf != -1) {
                return xr(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
            }
            if (str.startsWith(":")) {
                return xr("", str.substring(1));
            }
            return xr("", str);
        }

        public ms ms(String str, String str2) {
            try {
                d(str, str2);
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
                    } catch (UnsupportedEncodingException e) {
                        com.bytedance.sdk.component.utils.sl.ms(e);
                        return this;
                    }
                }
                return this;
            }
            return xr(str, str2);
        }

        ms xr(String str, String str2) {
            this.f1137ms.add(str);
            this.f1137ms.add(str2.trim());
            return this;
        }

        public ms xr(String str) {
            int i = 0;
            while (i < this.f1137ms.size()) {
                if (str.equalsIgnoreCase(this.f1137ms.get(i))) {
                    this.f1137ms.remove(i);
                    this.f1137ms.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public ms ah(String str, String str2) {
            try {
                d(str, str2);
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
                    } catch (UnsupportedEncodingException e) {
                        com.bytedance.sdk.component.utils.sl.ms(e);
                        return this;
                    }
                }
                return this;
            }
            xr(str);
            xr(str, str2);
            return this;
        }

        private void d(String str, String str2) {
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
                    throw new IllegalArgumentException(com.bytedance.sdk.component.ah.xr.ms.ah.ms("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char cCharAt2 = str2.charAt(i2);
                if ((cCharAt2 <= 31 && cCharAt2 != '\t') || cCharAt2 >= 127) {
                    throw new IllegalArgumentException(com.bytedance.sdk.component.ah.xr.ms.ah.ms("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i2), str, str2));
                }
            }
        }

        public qv ms() {
            return new qv(this);
        }
    }
}
