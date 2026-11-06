package com.byazt.jv;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 48})
public final class lb {
    public final String[] pr;

    public lb(pr prVar) {
        this.pr = (String[]) prVar.pr.toArray(new String[prVar.pr.size()]);
    }

    private lb(String[] strArr) {
        this.pr = strArr;
    }

    public String pr(String str) {
        return pr(this.pr, str);
    }

    public int pr() {
        return this.pr.length / 2;
    }

    public String pr(int i) {
        return this.pr[i * 2];
    }

    public String hw(int i) {
        return this.pr[(i * 2) + 1];
    }

    public List<String> hw(String str) {
        int iPr = pr();
        ArrayList arrayList = null;
        for (int i = 0; i < iPr; i++) {
            if (str.equalsIgnoreCase(pr(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(hw(i));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public pr hw() {
        pr prVar = new pr();
        Collections.addAll(prVar.pr, this.pr);
        return prVar;
    }

    public boolean equals(Object obj) {
        return (obj instanceof lb) && Arrays.equals(((lb) obj).pr, this.pr);
    }

    public int hashCode() {
        return Arrays.hashCode(this.pr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iPr = pr();
        for (int i = 0; i < iPr; i++) {
            sb.append(pr(i)).append(": ").append(hw(i)).append("\n");
        }
        return sb.toString();
    }

    public Map<String, List<String>> hn() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int iPr = pr();
        for (int i = 0; i < iPr; i++) {
            String lowerCase = pr(i).toLowerCase(Locale.US);
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(hw(i));
        }
        return treeMap;
    }

    private static String pr(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static lb pr(String... strArr) {
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
        return new lb(strArr2);
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 855})
    public static final class pr {
        public final List<String> pr = new ArrayList(20);

        public pr pr(String str) {
            int iIndexOf = str.indexOf(":", 1);
            if (iIndexOf != -1) {
                return hw(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
            }
            if (str.startsWith(":")) {
                return hw("", str.substring(1));
            }
            return hw("", str);
        }

        public pr pr(String str, String str2) {
            try {
                x(str, str2);
            } catch (Throwable th) {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return this;
                }
                try {
                    StringBuilder sb = new StringBuilder();
                    int length = str2.length();
                    for (int i = 0; i < length; i++) {
                        char cCharAt = str2.charAt(i);
                        if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                            sb.append(URLEncoder.encode(String.valueOf(cCharAt), Key.STRING_CHARSET_NAME));
                        } else {
                            sb.append(cCharAt);
                        }
                    }
                    str2 = sb.toString();
                } catch (UnsupportedEncodingException e) {
                    return this;
                }
            }
            return hw(str, str2);
        }

        public pr hw(String str, String str2) {
            this.pr.add(str);
            this.pr.add(str2.trim());
            return this;
        }

        public pr hw(String str) {
            int i = 0;
            while (i < this.pr.size()) {
                if (str.equalsIgnoreCase(this.pr.get(i))) {
                    this.pr.remove(i);
                    this.pr.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public pr hn(String str, String str2) {
            try {
                x(str, str2);
            } catch (Throwable th) {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return this;
                }
                try {
                    StringBuilder sb = new StringBuilder();
                    int length = str2.length();
                    for (int i = 0; i < length; i++) {
                        char cCharAt = str2.charAt(i);
                        if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                            sb.append(URLEncoder.encode(String.valueOf(cCharAt), Key.STRING_CHARSET_NAME));
                        } else {
                            sb.append(cCharAt);
                        }
                    }
                    str2 = sb.toString();
                } catch (UnsupportedEncodingException e) {
                    return this;
                }
            }
            hw(str);
            hw(str, str2);
            return this;
        }

        private void x(String str, String str2) {
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
                    throw new IllegalArgumentException(com.byazt.xx.hn.pr("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char cCharAt2 = str2.charAt(i2);
                if ((cCharAt2 <= 31 && cCharAt2 != '\t') || cCharAt2 >= 127) {
                    throw new IllegalArgumentException(com.byazt.xx.hn.pr("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i2), str, str2));
                }
            }
        }

        public lb pr() {
            return new lb(this);
        }
    }
}
