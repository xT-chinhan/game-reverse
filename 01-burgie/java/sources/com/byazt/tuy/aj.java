package com.byazt.tuy;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_OUTFPS_LIST, 61})
public class aj {
    public static StringBuilder pr(StringBuilder sb, String str) {
        sb.append('\"').append(str).append('\"');
        return sb;
    }

    public static StringBuilder pr(StringBuilder sb, String str, String str2) {
        sb.append(str).append(".\"").append(str2).append('\"');
        return sb;
    }

    public static StringBuilder pr(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            sb.append('\"').append(strArr[i]).append('\"');
            if (i < length - 1) {
                sb.append(AbstractJsonLexerKt.COMMA);
            }
        }
        return sb;
    }

    public static StringBuilder pr(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < i - 1) {
                sb.append("?,");
            } else {
                sb.append('?');
            }
        }
        return sb;
    }

    public static StringBuilder hw(StringBuilder sb, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            pr(sb, strArr[i]).append("=?");
            if (i < strArr.length - 1) {
                sb.append(AbstractJsonLexerKt.COMMA);
            }
        }
        return sb;
    }

    public static StringBuilder pr(StringBuilder sb, String str, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            pr(sb, str, strArr[i]).append("=?");
            if (i < strArr.length - 1) {
                sb.append(AbstractJsonLexerKt.COMMA);
            }
        }
        return sb;
    }

    public static String pr(String str, String str2, String[] strArr) {
        StringBuilder sb = new StringBuilder(str);
        sb.append('\"').append(str2).append('\"').append(" (");
        pr(sb, strArr);
        sb.append(") VALUES (");
        pr(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    public static String pr(String str, String[] strArr) {
        String str2 = "\"" + str + '\"';
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append(str2);
        if (strArr != null && strArr.length > 0) {
            sb.append(" WHERE ");
            pr(sb, str2, strArr);
        }
        return sb.toString();
    }

    public static String pr(String str, String[] strArr, String[] strArr2) {
        String str2 = "\"" + str + '\"';
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(str2).append(" SET ");
        hw(sb, strArr);
        if (strArr2 != null && strArr2.length > 0) {
            sb.append(" WHERE ");
            pr(sb, str2, strArr2);
        }
        return sb.toString();
    }

    public static String hw(String str, String[] strArr, String[] strArr2) {
        StringBuilder sb = new StringBuilder("INSERT OR REPLACE INTO ");
        sb.append("\"" + str + '\"').append(" (");
        pr(sb, strArr);
        sb.append(") VALUES (");
        pr(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }
}
