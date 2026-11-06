package com.byazt.di;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AV_NO_SYNC_THRESHOLD, 121})
public final class x {
    public int c;
    public char[] fw;
    public int hn;
    public final int hw;
    public final String pr;
    public int uc;
    public int x;

    public x(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.pr = name;
        this.hw = name.length();
    }

    private String pr() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        char c;
        int i6;
        int i7;
        char c2;
        char c3;
        while (true) {
            i = this.hn;
            i2 = this.hw;
            if (i >= i2 || this.fw[i] != ' ') {
                break;
            }
            this.hn = i + 1;
        }
        if (i == i2) {
            return null;
        }
        this.x = i;
        this.hn = i + 1;
        while (true) {
            i3 = this.hn;
            i4 = this.hw;
            if (i3 >= i4 || (c3 = this.fw[i3]) == '=' || c3 == ' ') {
                break;
            }
            this.hn = i3 + 1;
        }
        if (i3 >= i4) {
            throw new IllegalStateException("Unexpected end of DN: " + this.pr);
        }
        this.c = i3;
        if (this.fw[i3] == ' ') {
            while (true) {
                i6 = this.hn;
                i7 = this.hw;
                if (i6 >= i7 || (c2 = this.fw[i6]) == '=' || c2 != ' ') {
                    break;
                }
                this.hn = i6 + 1;
            }
            if (this.fw[i6] != '=' || i6 == i7) {
                throw new IllegalStateException("Unexpected end of DN: " + this.pr);
            }
        }
        do {
            i5 = this.hn + 1;
            this.hn = i5;
            if (i5 >= this.hw) {
                break;
            }
        } while (this.fw[i5] == ' ');
        int i8 = this.c;
        int i9 = this.x;
        if (i8 - i9 > 4) {
            char[] cArr = this.fw;
            if (cArr[i9 + 3] == '.' && (((c = cArr[i9]) == 'O' || c == 'o') && ((cArr[i9 + 1] == 'I' || cArr[i9 + 1] == 'i') && (cArr[i9 + 2] == 'D' || cArr[i9 + 2] == 'd')))) {
                this.x = i9 + 4;
            }
        }
        char[] cArr2 = this.fw;
        int i10 = this.x;
        return new String(cArr2, i10, i8 - i10);
    }

    private String hw() {
        int i = this.hn + 1;
        this.hn = i;
        this.x = i;
        this.c = i;
        while (true) {
            int i2 = this.hn;
            if (i2 == this.hw) {
                throw new IllegalStateException("Unexpected end of DN: " + this.pr);
            }
            char[] cArr = this.fw;
            char c = cArr[i2];
            if (c == '\"') {
                this.hn = i2 + 1;
                while (true) {
                    int i3 = this.hn;
                    if (i3 >= this.hw || this.fw[i3] != ' ') {
                        break;
                    }
                    this.hn = i3 + 1;
                }
                char[] cArr2 = this.fw;
                int i4 = this.x;
                return new String(cArr2, i4, this.c - i4);
            }
            if (c == '\\') {
                cArr[this.c] = c();
            } else {
                cArr[this.c] = c;
            }
            this.hn++;
            this.c++;
        }
    }

    private String hn() {
        char[] cArr;
        char c;
        int i = this.hn;
        if (i + 4 >= this.hw) {
            throw new IllegalStateException("Unexpected end of DN: " + this.pr);
        }
        this.x = i;
        this.hn = i + 1;
        while (true) {
            int i2 = this.hn;
            if (i2 == this.hw || (c = (cArr = this.fw)[i2]) == '+' || c == ',' || c == ';') {
                this.c = i2;
                break;
            }
            if (c == ' ') {
                this.c = i2;
                this.hn = i2 + 1;
                while (true) {
                    int i3 = this.hn;
                    if (i3 >= this.hw || this.fw[i3] != ' ') {
                        break;
                    }
                    this.hn = i3 + 1;
                }
            } else {
                if (c >= 'A' && c <= 'F') {
                    cArr[i2] = (char) (c + ' ');
                }
                this.hn = i2 + 1;
            }
        }
        int i4 = this.c;
        int i5 = this.x;
        int i6 = i4 - i5;
        if (i6 < 5 || (i6 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.pr);
        }
        int i7 = i6 / 2;
        byte[] bArr = new byte[i7];
        int i8 = i5 + 1;
        for (int i9 = 0; i9 < i7; i9++) {
            bArr[i9] = (byte) pr(i8);
            i8 += 2;
        }
        return new String(this.fw, this.x, i6);
    }

    private String x() {
        int i;
        int i2;
        char c;
        int i3 = this.hn;
        this.x = i3;
        this.c = i3;
        while (true) {
            int i4 = this.hn;
            if (i4 >= this.hw) {
                char[] cArr = this.fw;
                int i5 = this.x;
                return new String(cArr, i5, this.c - i5);
            }
            char[] cArr2 = this.fw;
            char c2 = cArr2[i4];
            switch (c2) {
                case ' ':
                    int i6 = this.c;
                    this.uc = i6;
                    this.hn = i4 + 1;
                    this.c = i6 + 1;
                    cArr2[i6] = ' ';
                    while (true) {
                        i = this.hn;
                        i2 = this.hw;
                        if (i < i2) {
                            char[] cArr3 = this.fw;
                            if (cArr3[i] == ' ') {
                                int i7 = this.c;
                                this.c = i7 + 1;
                                cArr3[i7] = ' ';
                                this.hn = i + 1;
                            }
                        }
                    }
                    if (i == i2 || (c = this.fw[i]) == ',' || c == '+' || c == ';') {
                        char[] cArr4 = this.fw;
                        int i8 = this.x;
                        return new String(cArr4, i8, this.uc - i8);
                    }
                    break;
                case '+':
                case ',':
                case ';':
                    int i9 = this.x;
                    return new String(cArr2, i9, this.c - i9);
                case '\\':
                    int i10 = this.c;
                    this.c = i10 + 1;
                    cArr2[i10] = c();
                    this.hn++;
                    break;
                default:
                    int i11 = this.c;
                    this.c = i11 + 1;
                    cArr2[i11] = c2;
                    this.hn = i4 + 1;
                    break;
            }
        }
    }

    private char c() {
        int i = this.hn + 1;
        this.hn = i;
        if (i == this.hw) {
            throw new IllegalStateException("Unexpected end of DN: " + this.pr);
        }
        char c = this.fw[i];
        switch (c) {
            case ' ':
            case '\"':
            case '#':
            case '%':
            case '*':
            case '+':
            case ',':
            case ';':
            case '<':
            case '=':
            case '>':
            case '\\':
            case '_':
                return c;
            default:
                return uc();
        }
    }

    private char uc() {
        int i;
        int i2;
        int iPr = pr(this.hn);
        this.hn++;
        if (iPr < 128) {
            return (char) iPr;
        }
        if (iPr < 192 || iPr > 247) {
            return '?';
        }
        if (iPr <= 223) {
            i2 = iPr & 31;
            i = 1;
        } else if (iPr <= 239) {
            i = 2;
            i2 = iPr & 15;
        } else {
            i = 3;
            i2 = iPr & 7;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = this.hn + 1;
            this.hn = i4;
            if (i4 == this.hw || this.fw[i4] != '\\') {
                return '?';
            }
            int i5 = i4 + 1;
            this.hn = i5;
            int iPr2 = pr(i5);
            this.hn++;
            if ((iPr2 & MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (iPr2 & 63);
        }
        return (char) i2;
    }

    private int pr(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 >= this.hw) {
            throw new IllegalStateException("Malformed DN: " + this.pr);
        }
        char[] cArr = this.fw;
        char c = cArr[i];
        if (c >= '0' && c <= '9') {
            i2 = c - '0';
        } else if (c >= 'a' && c <= 'f') {
            i2 = c - 'W';
        } else if (c >= 'A' && c <= 'F') {
            i2 = c - '7';
        } else {
            throw new IllegalStateException("Malformed DN: " + this.pr);
        }
        char c2 = cArr[i4];
        if (c2 >= '0' && c2 <= '9') {
            i3 = c2 - '0';
        } else if (c2 >= 'a' && c2 <= 'f') {
            i3 = c2 - 'W';
        } else if (c2 >= 'A' && c2 <= 'F') {
            i3 = c2 - '7';
        } else {
            throw new IllegalStateException("Malformed DN: " + this.pr);
        }
        return (i2 << 4) + i3;
    }

    public String pr(String str) {
        String strHw;
        this.hn = 0;
        this.x = 0;
        this.c = 0;
        this.uc = 0;
        this.fw = this.pr.toCharArray();
        String strPr = pr();
        if (strPr == null) {
            return null;
        }
        do {
            int i = this.hn;
            if (i == this.hw) {
                return null;
            }
            switch (this.fw[i]) {
                case '\"':
                    strHw = hw();
                    break;
                case '#':
                    strHw = hn();
                    break;
                case '+':
                case ',':
                case ';':
                    strHw = "";
                    break;
                default:
                    strHw = x();
                    break;
            }
            if (str.equalsIgnoreCase(strPr)) {
                return strHw;
            }
            int i2 = this.hn;
            if (i2 >= this.hw) {
                return null;
            }
            char c = this.fw[i2];
            if (c != ',' && c != ';' && c != '+') {
                throw new IllegalStateException("Malformed DN: " + this.pr);
            }
            this.hn = i2 + 1;
            strPr = pr();
        } while (strPr != null);
        throw new IllegalStateException("Malformed DN: " + this.pr);
    }
}
