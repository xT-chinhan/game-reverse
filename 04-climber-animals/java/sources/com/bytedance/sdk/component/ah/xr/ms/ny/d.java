package com.bytedance.sdk.component.ah.xr.ms.ny;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes2.dex */
final class d {
    private char[] ab;
    private int ah;
    private int c;
    private int d;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final String f1118ms;
    private final int xr;

    d(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f1118ms = name;
        this.xr = name.length();
    }

    private String ms() {
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
            i = this.ah;
            i2 = this.xr;
            if (i >= i2 || this.ab[i] != ' ') {
                break;
            }
            this.ah = i + 1;
        }
        if (i == i2) {
            return null;
        }
        this.d = i;
        this.ah = i + 1;
        while (true) {
            i3 = this.ah;
            i4 = this.xr;
            if (i3 >= i4 || (c3 = this.ab[i3]) == '=' || c3 == ' ') {
                break;
            }
            this.ah = i3 + 1;
        }
        if (i3 >= i4) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f1118ms);
        }
        this.ka = i3;
        if (this.ab[i3] == ' ') {
            while (true) {
                i6 = this.ah;
                i7 = this.xr;
                if (i6 >= i7 || (c2 = this.ab[i6]) == '=' || c2 != ' ') {
                    break;
                }
                this.ah = i6 + 1;
            }
            if (this.ab[i6] != '=' || i6 == i7) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f1118ms);
            }
        }
        do {
            i5 = this.ah + 1;
            this.ah = i5;
            if (i5 >= this.xr) {
                break;
            }
        } while (this.ab[i5] == ' ');
        int i8 = this.ka;
        int i9 = this.d;
        if (i8 - i9 > 4) {
            char[] cArr = this.ab;
            if (cArr[i9 + 3] == '.' && (((c = cArr[i9]) == 'O' || c == 'o') && ((cArr[i9 + 1] == 'I' || cArr[i9 + 1] == 'i') && (cArr[i9 + 2] == 'D' || cArr[i9 + 2] == 'd')))) {
                this.d = i9 + 4;
            }
        }
        char[] cArr2 = this.ab;
        int i10 = this.d;
        return new String(cArr2, i10, this.ka - i10);
    }

    private String xr() {
        int i = this.ah + 1;
        this.ah = i;
        this.d = i;
        this.ka = i;
        while (true) {
            int i2 = this.ah;
            if (i2 == this.xr) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f1118ms);
            }
            char[] cArr = this.ab;
            char c = cArr[i2];
            if (c == '\"') {
                this.ah = i2 + 1;
                while (true) {
                    int i3 = this.ah;
                    if (i3 >= this.xr || this.ab[i3] != ' ') {
                        break;
                    }
                    this.ah = i3 + 1;
                }
                char[] cArr2 = this.ab;
                int i4 = this.d;
                return new String(cArr2, i4, this.ka - i4);
            }
            if (c == '\\') {
                cArr[this.ka] = ka();
            } else {
                cArr[this.ka] = c;
            }
            this.ah++;
            this.ka++;
        }
    }

    private String ah() {
        char[] cArr;
        char c;
        int i = this.ah;
        if (i + 4 >= this.xr) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f1118ms);
        }
        this.d = i;
        this.ah = i + 1;
        while (true) {
            int i2 = this.ah;
            if (i2 == this.xr || (c = (cArr = this.ab)[i2]) == '+' || c == ',' || c == ';') {
                this.ka = i2;
                break;
            }
            if (c == ' ') {
                this.ka = i2;
                this.ah = i2 + 1;
                while (true) {
                    int i3 = this.ah;
                    if (i3 >= this.xr || this.ab[i3] != ' ') {
                        break;
                    }
                    this.ah = i3 + 1;
                }
            } else {
                if (c >= 'A' && c <= 'F') {
                    cArr[i2] = (char) (c + ' ');
                }
                this.ah = i2 + 1;
            }
        }
        int i4 = this.ka;
        int i5 = this.d;
        int i6 = i4 - i5;
        if (i6 < 5 || (i6 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f1118ms);
        }
        int i7 = i6 / 2;
        byte[] bArr = new byte[i7];
        int i8 = i5 + 1;
        for (int i9 = 0; i9 < i7; i9++) {
            bArr[i9] = (byte) ms(i8);
            i8 += 2;
        }
        return new String(this.ab, this.d, i6);
    }

    private String d() {
        int i;
        int i2;
        char c;
        int i3 = this.ah;
        this.d = i3;
        this.ka = i3;
        while (true) {
            int i4 = this.ah;
            if (i4 >= this.xr) {
                char[] cArr = this.ab;
                int i5 = this.d;
                return new String(cArr, i5, this.ka - i5);
            }
            char[] cArr2 = this.ab;
            char c2 = cArr2[i4];
            if (c2 != ' ') {
                if (c2 != ';') {
                    if (c2 == '\\') {
                        int i6 = this.ka;
                        this.ka = i6 + 1;
                        cArr2[i6] = ka();
                        this.ah++;
                    } else if (c2 != '+' && c2 != ',') {
                        int i7 = this.ka;
                        this.ka = i7 + 1;
                        cArr2[i7] = c2;
                        this.ah = i4 + 1;
                    }
                }
                char[] cArr3 = this.ab;
                int i8 = this.d;
                return new String(cArr3, i8, this.ka - i8);
            }
            int i9 = this.ka;
            this.c = i9;
            this.ah = i4 + 1;
            this.ka = i9 + 1;
            cArr2[i9] = ' ';
            while (true) {
                i = this.ah;
                i2 = this.xr;
                if (i >= i2) {
                    break;
                }
                char[] cArr4 = this.ab;
                if (cArr4[i] != ' ') {
                    break;
                }
                int i10 = this.ka;
                this.ka = i10 + 1;
                cArr4[i10] = ' ';
                this.ah = i + 1;
            }
            if (i == i2 || (c = this.ab[i]) == ',' || c == '+' || c == ';') {
                char[] cArr5 = this.ab;
                int i11 = this.d;
                return new String(cArr5, i11, this.c - i11);
            }
        }
    }

    private char ka() {
        int i = this.ah + 1;
        this.ah = i;
        if (i == this.xr) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f1118ms);
        }
        char c = this.ab[i];
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
                        return c();
                }
        }
    }

    private char c() {
        int i;
        int i2;
        int iMs = ms(this.ah);
        this.ah++;
        if (iMs < 128) {
            return (char) iMs;
        }
        if (iMs < 192 || iMs > 247) {
            return '?';
        }
        if (iMs <= 223) {
            i = iMs & 31;
            i2 = 1;
        } else if (iMs <= 239) {
            i = iMs & 15;
            i2 = 2;
        } else {
            i = iMs & 7;
            i2 = 3;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.ah + 1;
            this.ah = i4;
            if (i4 == this.xr || this.ab[i4] != '\\') {
                return '?';
            }
            int i5 = i4 + 1;
            this.ah = i5;
            int iMs2 = ms(i5);
            this.ah++;
            if ((iMs2 & MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT) != 128) {
                return '?';
            }
            i = (i << 6) + (iMs2 & 63);
        }
        return (char) i;
    }

    private int ms(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 >= this.xr) {
            throw new IllegalStateException("Malformed DN: " + this.f1118ms);
        }
        char[] cArr = this.ab;
        char c = cArr[i];
        if (c >= '0' && c <= '9') {
            i2 = c - '0';
        } else if (c >= 'a' && c <= 'f') {
            i2 = c - 'W';
        } else {
            if (c < 'A' || c > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f1118ms);
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
                throw new IllegalStateException("Malformed DN: " + this.f1118ms);
            }
            i3 = c2 - '7';
        }
        return (i2 << 4) + i3;
    }

    public String ms(String str) {
        String strXr;
        this.ah = 0;
        this.d = 0;
        this.ka = 0;
        this.c = 0;
        this.ab = this.f1118ms.toCharArray();
        String strMs = ms();
        if (strMs == null) {
            return null;
        }
        do {
            int i = this.ah;
            if (i == this.xr) {
                return null;
            }
            char c = this.ab[i];
            if (c == '\"') {
                strXr = xr();
            } else if (c == '#') {
                strXr = ah();
            } else {
                strXr = (c == '+' || c == ',' || c == ';') ? "" : d();
            }
            if (str.equalsIgnoreCase(strMs)) {
                return strXr;
            }
            int i2 = this.ah;
            if (i2 >= this.xr) {
                return null;
            }
            char c2 = this.ab[i2];
            if (c2 != ',' && c2 != ';' && c2 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f1118ms);
            }
            this.ah = i2 + 1;
            strMs = ms();
        } while (strMs != null);
        throw new IllegalStateException("Malformed DN: " + this.f1118ms);
    }
}
