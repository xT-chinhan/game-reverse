package com.byazt.nzn;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, 50})
public final class vk {
    public final String c;
    public final String hn;
    public final String uc;
    public final String x;
    public static final Pattern pr = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    public static final Pattern hw = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    public vk(String str, String str2, String str3, String str4) {
        this.hn = str;
        this.x = str2;
        this.c = str3;
        this.uc = str4;
    }

    public static vk pr(String str) {
        Matcher matcher = pr.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = hw.matcher(str);
        String str2 = null;
        for (int iEnd = matcher.end(); iEnd < str.length(); iEnd = matcher2.end()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            if ("charset".equalsIgnoreCase(matcher2.group(1))) {
                String strGroup = matcher2.group(2);
                if (strGroup != null) {
                    if (strGroup.startsWith("'") && strGroup.endsWith("'") && strGroup.length() > 2) {
                        strGroup = strGroup.substring(1, strGroup.length() - 1);
                    }
                } else {
                    strGroup = matcher2.group(3);
                }
                if (str2 != null && !str2.equalsIgnoreCase(strGroup)) {
                    return null;
                }
                str2 = strGroup;
            }
        }
        return new vk(str, lowerCase, lowerCase2, str2);
    }

    public String pr() {
        return this.x;
    }

    public String hw() {
        return this.c;
    }

    public Charset hn() {
        return pr((Charset) null);
    }

    public Charset pr(Charset charset) {
        try {
            String str = this.uc;
            return str != null ? Charset.forName(str) : charset;
        } catch (IllegalArgumentException e) {
            return charset;
        }
    }

    public String toString() {
        return this.hn;
    }

    public boolean equals(Object obj) {
        return (obj instanceof vk) && ((vk) obj).hn.equals(this.hn);
    }

    public int hashCode() {
        return this.hn.hashCode();
    }
}
