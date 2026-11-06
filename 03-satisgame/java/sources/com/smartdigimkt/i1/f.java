package com.smartdigimkt.i1;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f {
    public static final HashMap a;
    public static final char[] b = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', AbstractJsonLexerKt.UNICODE_ESC, 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    public static final char[] c;
    public static final byte[] d;

    static {
        HashMap map = new HashMap();
        a = map;
        map.put(d.a('m', map, d.a('K', map, d.a('I', map, d.a('O', map, d.a('1', map, d.a('P', map, d.a('9', map, d.a('b', map, d.a('F', map, d.a('2', map, d.a('T', map, d.a('A', map, d.a('B', map, d.a('e', map, d.a('M', map, d.a('X', map, d.a('/', map, d.a('w', map, d.a('s', map, d.a('8', map, d.a('q', map, d.a(AbstractJsonLexerKt.UNICODE_ESC, map, d.a('E', map, d.a('g', map, d.a('r', map, d.a('Q', map, d.a('3', map, d.a('U', map, d.a('0', map, d.a('t', map, d.a('l', map, d.a('6', map, d.a('4', map, d.a('J', map, d.a('h', map, d.a('Y', map, d.a('L', map, d.a('H', map, d.a('D', map, d.a('+', map, d.a('k', map, d.a('5', map, d.a('V', map, d.a('n', map, d.a('Z', map, d.a('x', map, d.a('N', map, d.a('y', map, d.a('G', map, d.a('f', map, d.a('i', map, d.a('W', map, d.a('p', map, d.a('z', map, d.a('R', map, d.a('d', map, d.a('7', map, d.a('c', map, d.a('j', map, d.a('a', map, d.a('o', map, d.a('S', map, d.a('v', map, 'A', 'B'), 'C'), 'D'), 'E'), 'F'), 'G'), 'H'), 'I'), 'J'), 'K'), 'L'), 'M'), 'N'), 'O'), 'P'), 'Q'), 'R'), 'S'), 'T'), 'U'), 'V'), 'W'), 'X'), 'Y'), 'Z'), 'a'), 'b'), 'c'), 'd'), 'e'), 'f'), 'g'), 'h'), 'i'), 'j'), 'k'), 'l'), 'm'), 'n'), 'o'), 'p'), 'q'), 'r'), 's'), 't'), AbstractJsonLexerKt.UNICODE_ESC), 'v'), 'w'), 'x'), 'y'), 'z'), '0'), '1'), '2'), '3'), '4'), '5'), '6'), '7'), '8'), '9'), '+'), '/'), 'C');
        c = new char[64];
        int i = 0;
        int i2 = 0;
        while (true) {
            char[] cArr = b;
            if (i2 >= 64) {
                break;
            }
            c[i2] = ((Character) a.get(Character.valueOf(cArr[i2]))).charValue();
            i2++;
        }
        d = new byte[128];
        int i3 = 0;
        while (true) {
            byte[] bArr = d;
            if (i3 >= bArr.length) {
                break;
            }
            bArr[i3] = 127;
            i3++;
        }
        while (true) {
            char[] cArr2 = c;
            if (i >= cArr2.length) {
                return;
            }
            d[cArr2[i]] = (byte) i;
            i++;
        }
    }

    public static int a(char[] cArr, byte[] bArr, int i) {
        try {
            char c2 = cArr[3];
            char c3 = c2 == '=' ? (char) 2 : (char) 3;
            char c4 = cArr[2];
            if (c4 == '=') {
                c3 = 1;
            }
            byte[] bArr2 = d;
            byte b2 = bArr2[cArr[0]];
            byte b3 = bArr2[cArr[1]];
            byte b4 = bArr2[c4];
            byte b5 = bArr2[c2];
            if (c3 == 1) {
                bArr[i] = (byte) (((b3 >> 4) & 3) | ((b2 << 2) & MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF));
                return 1;
            }
            if (c3 == 2) {
                bArr[i] = (byte) ((3 & (b3 >> 4)) | ((b2 << 2) & MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF));
                bArr[i + 1] = (byte) (((b3 << 4) & MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA) | ((b4 >> 2) & 15));
                return 2;
            }
            if (c3 != 3) {
                throw new RuntimeException("Internal Error");
            }
            bArr[i] = (byte) (((b2 << 2) & MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF) | ((b3 >> 4) & 3));
            bArr[i + 1] = (byte) (((b3 << 4) & MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA) | ((b4 >> 2) & 15));
            bArr[i + 2] = (byte) (((b4 << 6) & MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT) | (b5 & com.anythink.core.common.r.a.c.c));
            return 3;
        } catch (Exception unused) {
            return 0;
        }
    }
}
