package com.byazt.jn;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1490, 26})
public final class qg {
    public int l;
    public final String n;
    public int q;
    public final int qg;
    public int s;
    public int w;
    public char[] x;

    public qg(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.n = name;
        this.qg = name.length();
    }

    private String n() {
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
            i = this.s;
            i2 = this.qg;
            if (i >= i2 || this.x[i] != ' ') {
                break;
            }
            this.s = i + 1;
        }
        if (i == i2) {
            return null;
        }
        this.q = i;
        this.s = i + 1;
        while (true) {
            i3 = this.s;
            i4 = this.qg;
            if (i3 >= i4 || (c3 = this.x[i3]) == '=' || c3 == ' ') {
                break;
            }
            this.s = i3 + 1;
        }
        if (i3 >= i4) {
            throw new IllegalStateException("Unexpected end of DN: " + this.n);
        }
        this.l = i3;
        if (this.x[i3] == ' ') {
            while (true) {
                i6 = this.s;
                i7 = this.qg;
                if (i6 >= i7 || (c2 = this.x[i6]) == '=' || c2 != ' ') {
                    break;
                }
                this.s = i6 + 1;
            }
            if (this.x[i6] != '=' || i6 == i7) {
                throw new IllegalStateException("Unexpected end of DN: " + this.n);
            }
        }
        do {
            i5 = this.s + 1;
            this.s = i5;
            if (i5 >= this.qg) {
                break;
            }
        } while (this.x[i5] == ' ');
        int i8 = this.l;
        int i9 = this.q;
        if (i8 - i9 > 4) {
            char[] cArr = this.x;
            if (cArr[i9 + 3] == '.' && (((c = cArr[i9]) == 'O' || c == 'o') && ((cArr[i9 + 1] == 'I' || cArr[i9 + 1] == 'i') && (cArr[i9 + 2] == 'D' || cArr[i9 + 2] == 'd')))) {
                this.q = i9 + 4;
            }
        }
        char[] cArr2 = this.x;
        int i10 = this.q;
        return new String(cArr2, i10, this.l - i10);
    }

    private String qg() {
        int i = this.s + 1;
        this.s = i;
        this.q = i;
        this.l = i;
        while (true) {
            int i2 = this.s;
            if (i2 == this.qg) {
                throw new IllegalStateException("Unexpected end of DN: " + this.n);
            }
            char[] cArr = this.x;
            char c = cArr[i2];
            if (c == '\"') {
                this.s = i2 + 1;
                while (true) {
                    int i3 = this.s;
                    if (i3 >= this.qg || this.x[i3] != ' ') {
                        break;
                    }
                    this.s = i3 + 1;
                }
                char[] cArr2 = this.x;
                int i4 = this.q;
                return new String(cArr2, i4, this.l - i4);
            }
            if (c == '\\') {
                cArr[this.l] = l();
            } else {
                cArr[this.l] = c;
            }
            this.s++;
            this.l++;
        }
    }

    private String s() {
        char[] cArr;
        char c;
        int i = this.s;
        if (i + 4 >= this.qg) {
            throw new IllegalStateException("Unexpected end of DN: " + this.n);
        }
        this.q = i;
        this.s = i + 1;
        while (true) {
            int i2 = this.s;
            if (i2 == this.qg || (c = (cArr = this.x)[i2]) == '+' || c == ',' || c == ';') {
                this.l = i2;
                break;
            }
            if (c == ' ') {
                this.l = i2;
                this.s = i2 + 1;
                while (true) {
                    int i3 = this.s;
                    if (i3 >= this.qg || this.x[i3] != ' ') {
                        break;
                    }
                    this.s = i3 + 1;
                }
            } else {
                if (c >= 'A' && c <= 'F') {
                    cArr[i2] = (char) (c + ' ');
                }
                this.s = i2 + 1;
            }
        }
        int i4 = this.l;
        int i5 = this.q;
        int i6 = i4 - i5;
        if (i6 < 5 || (i6 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.n);
        }
        int i7 = i6 / 2;
        byte[] bArr = new byte[i7];
        int i8 = i5 + 1;
        for (int i9 = 0; i9 < i7; i9++) {
            bArr[i9] = (byte) n(i8);
            i8 += 2;
        }
        return new String(this.x, this.q, i6);
    }

    private String q() {
        int i;
        int i2;
        char c;
        int i3 = this.s;
        this.q = i3;
        this.l = i3;
        while (true) {
            int i4 = this.s;
            if (i4 >= this.qg) {
                char[] cArr = this.x;
                int i5 = this.q;
                return new String(cArr, i5, this.l - i5);
            }
            char[] cArr2 = this.x;
            char c2 = cArr2[i4];
            if (c2 != ' ') {
                if (c2 != ';') {
                    if (c2 == '\\') {
                        int i6 = this.l;
                        this.l = i6 + 1;
                        cArr2[i6] = l();
                        this.s++;
                    } else if (c2 != '+' && c2 != ',') {
                        int i7 = this.l;
                        this.l = i7 + 1;
                        cArr2[i7] = c2;
                        this.s = i4 + 1;
                    }
                }
                char[] cArr3 = this.x;
                int i8 = this.q;
                return new String(cArr3, i8, this.l - i8);
            }
            int i9 = this.l;
            this.w = i9;
            this.s = i4 + 1;
            this.l = i9 + 1;
            cArr2[i9] = ' ';
            while (true) {
                i = this.s;
                i2 = this.qg;
                if (i >= i2) {
                    break;
                }
                char[] cArr4 = this.x;
                if (cArr4[i] != ' ') {
                    break;
                }
                int i10 = this.l;
                this.l = i10 + 1;
                cArr4[i10] = ' ';
                this.s = i + 1;
            }
            if (i == i2 || (c = this.x[i]) == ',' || c == '+' || c == ';') {
                char[] cArr5 = this.x;
                int i11 = this.q;
                return new String(cArr5, i11, this.w - i11);
            }
        }
    }

    private char l() {
        int i = this.s + 1;
        this.s = i;
        if (i == this.qg) {
            throw new IllegalStateException("Unexpected end of DN: " + this.n);
        }
        char c = this.x[i];
        if (c == ' ' || c == '%' || c == '\\' || c == '_' || c == '\"' || c == '#') {
            return c;
        }
        switch (c) {
            case '*':
            case '+':
            case ',':
                return c;
            default:
                switch (c) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        return c;
                    default:
                        return w();
                }
        }
    }

    private char w() {
        int i;
        int i2;
        int iN = n(this.s);
        this.s++;
        if (iN < 128) {
            return (char) iN;
        }
        if (iN < 192 || iN > 247) {
            return '?';
        }
        if (iN <= 223) {
            i = iN & 31;
            i2 = 1;
        } else if (iN <= 239) {
            i = iN & 15;
            i2 = 2;
        } else {
            i = iN & 7;
            i2 = 3;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.s + 1;
            this.s = i4;
            if (i4 == this.qg || this.x[i4] != '\\') {
                return '?';
            }
            int i5 = i4 + 1;
            this.s = i5;
            int iN2 = n(i5);
            this.s++;
            if ((iN2 & MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT) != 128) {
                return '?';
            }
            i = (i << 6) + (iN2 & 63);
        }
        return (char) i;
    }

    private int n(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 >= this.qg) {
            throw new IllegalStateException("Malformed DN: " + this.n);
        }
        char[] cArr = this.x;
        char c = cArr[i];
        if (c >= '0' && c <= '9') {
            i2 = c - '0';
        } else if (c >= 'a' && c <= 'f') {
            i2 = c - 'W';
        } else {
            if (c < 'A' || c > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.n);
            }
            i2 = c - '7';
        }
        char c2 = cArr[i4];
        if (c2 >= '0' && c2 <= '9') {
            i3 = c2 - '0';
        } else if (c2 >= 'a' && c2 <= 'f') {
            i3 = c2 - 'W';
        } else {
            if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.n);
            }
            i3 = c2 - '7';
        }
        return (i2 << 4) + i3;
    }

    public String n(String str) {
        String strQg;
        this.s = 0;
        this.q = 0;
        this.l = 0;
        this.w = 0;
        this.x = this.n.toCharArray();
        String strN = n();
        if (strN == null) {
            return null;
        }
        do {
            int i = this.s;
            if (i == this.qg) {
                return null;
            }
            char c = this.x[i];
            if (c == '\"') {
                strQg = qg();
            } else if (c == '#') {
                strQg = s();
            } else {
                strQg = (c == '+' || c == ',' || c == ';') ? "" : q();
            }
            if (str.equalsIgnoreCase(strN)) {
                return strQg;
            }
            int i2 = this.s;
            if (i2 >= this.qg) {
                return null;
            }
            char c2 = this.x[i2];
            if (c2 != ',' && c2 != ';' && c2 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.n);
            }
            this.s = i2 + 1;
            strN = n();
        } while (strN != null);
        throw new IllegalStateException("Malformed DN: " + this.n);
    }
}
