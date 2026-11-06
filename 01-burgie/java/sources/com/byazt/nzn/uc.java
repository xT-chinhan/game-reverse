package com.byazt.nzn;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, 5})
public final class uc {
    public final String[] pr;

    public uc(String[] strArr) {
        this.pr = strArr;
    }

    public uc(pr prVar) {
        this.pr = (String[]) prVar.pr.toArray(new String[prVar.pr.size()]);
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

    public Map<String, List<String>> hw() {
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

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, 129})
    public static final class pr {
        public final List<String> pr = new ArrayList(20);

        public uc pr() {
            return new uc(this);
        }

        public pr pr(String str, String str2) {
            this.pr.add(str);
            this.pr.add(str2.trim());
            return this;
        }

        public pr hw(String str, String str2) {
            try {
                hn(str, str2);
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
            return pr(str, str2);
        }

        private void hn(String str, String str2) {
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
                    throw new IllegalArgumentException(com.byazt.qm.vk.pr("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char cCharAt2 = str2.charAt(i2);
                if ((cCharAt2 <= 31 && cCharAt2 != '\t') || cCharAt2 >= 127) {
                    throw new IllegalArgumentException(com.byazt.qm.vk.pr("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i2), str, str2));
                }
            }
        }
    }
}
