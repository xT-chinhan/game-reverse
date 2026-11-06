package com.anythink.core.common.m.b.a.j;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes.dex */
final class d {
    private final String a;
    private final int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private char[] g;

    private d(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.a = name;
        this.b = name.length();
    }

    private String a() {
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
            i = this.c;
            i2 = this.b;
            if (i >= i2 || this.g[i] != ' ') {
                break;
            }
            this.c = i + 1;
        }
        if (i == i2) {
            return null;
        }
        this.d = i;
        this.c = i + 1;
        while (true) {
            i3 = this.c;
            i4 = this.b;
            if (i3 >= i4 || (c3 = this.g[i3]) == '=' || c3 == ' ') {
                break;
            }
            this.c = i3 + 1;
        }
        if (i3 >= i4) {
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
        }
        this.e = i3;
        if (this.g[i3] == ' ') {
            while (true) {
                i6 = this.c;
                i7 = this.b;
                if (i6 >= i7 || (c2 = this.g[i6]) == '=' || c2 != ' ') {
                    break;
                }
                this.c = i6 + 1;
            }
            if (this.g[i6] != '=' || i6 == i7) {
                throw new IllegalStateException("Unexpected end of DN: " + this.a);
            }
        }
        do {
            i5 = this.c + 1;
            this.c = i5;
            if (i5 >= this.b) {
                break;
            }
        } while (this.g[i5] == ' ');
        int i8 = this.e;
        int i9 = this.d;
        if (i8 - i9 > 4) {
            char[] cArr = this.g;
            if (cArr[i9 + 3] == '.' && (((c = cArr[i9]) == 'O' || c == 'o') && ((cArr[i9 + 1] == 'I' || cArr[i9 + 1] == 'i') && (cArr[i9 + 2] == 'D' || cArr[i9 + 2] == 'd')))) {
                this.d = i9 + 4;
            }
        }
        char[] cArr2 = this.g;
        int i10 = this.d;
        return new String(cArr2, i10, this.e - i10);
    }

    private String b() {
        int i = this.c + 1;
        this.c = i;
        this.d = i;
        this.e = i;
        while (true) {
            int i2 = this.c;
            if (i2 == this.b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.a);
            }
            char[] cArr = this.g;
            char c = cArr[i2];
            if (c == '\"') {
                this.c = i2 + 1;
                while (true) {
                    int i3 = this.c;
                    if (i3 >= this.b || this.g[i3] != ' ') {
                        break;
                    }
                    this.c = i3 + 1;
                }
                char[] cArr2 = this.g;
                int i4 = this.d;
                return new String(cArr2, i4, this.e - i4);
            }
            if (c == '\\') {
                cArr[this.e] = e();
            } else {
                cArr[this.e] = c;
            }
            this.c++;
            this.e++;
        }
    }

    private String c() {
        char[] cArr;
        char c;
        int i = this.c;
        if (i + 4 >= this.b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
        }
        this.d = i;
        this.c = i + 1;
        while (true) {
            int i2 = this.c;
            if (i2 == this.b || (c = (cArr = this.g)[i2]) == '+' || c == ',' || c == ';') {
                this.e = i2;
                break;
            }
            if (c == ' ') {
                this.e = i2;
                this.c = i2 + 1;
                while (true) {
                    int i3 = this.c;
                    if (i3 >= this.b || this.g[i3] != ' ') {
                        break;
                    }
                    this.c = i3 + 1;
                }
            } else {
                if (c >= 'A' && c <= 'F') {
                    cArr[i2] = (char) (c + ' ');
                }
                this.c = i2 + 1;
            }
        }
        int i4 = this.e;
        int i5 = this.d;
        int i6 = i4 - i5;
        if (i6 < 5 || (i6 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
        }
        int i7 = i6 / 2;
        byte[] bArr = new byte[i7];
        int i8 = i5 + 1;
        for (int i9 = 0; i9 < i7; i9++) {
            bArr[i9] = (byte) a(i8);
            i8 += 2;
        }
        return new String(this.g, this.d, i6);
    }

    private String d() {
        int i;
        int i2;
        char c;
        int i3 = this.c;
        this.d = i3;
        this.e = i3;
        while (true) {
            int i4 = this.c;
            if (i4 >= this.b) {
                char[] cArr = this.g;
                int i5 = this.d;
                return new String(cArr, i5, this.e - i5);
            }
            char[] cArr2 = this.g;
            char c2 = cArr2[i4];
            if (c2 != ' ') {
                if (c2 != ';') {
                    if (c2 == '\\') {
                        int i6 = this.e;
                        this.e = i6 + 1;
                        cArr2[i6] = e();
                        this.c++;
                    } else if (c2 != '+' && c2 != ',') {
                        int i7 = this.e;
                        this.e = i7 + 1;
                        cArr2[i7] = c2;
                        this.c = i4 + 1;
                    }
                }
                char[] cArr3 = this.g;
                int i8 = this.d;
                return new String(cArr3, i8, this.e - i8);
            }
            int i9 = this.e;
            this.f = i9;
            this.c = i4 + 1;
            this.e = i9 + 1;
            cArr2[i9] = ' ';
            while (true) {
                i = this.c;
                i2 = this.b;
                if (i >= i2) {
                    break;
                }
                char[] cArr4 = this.g;
                if (cArr4[i] != ' ') {
                    break;
                }
                int i10 = this.e;
                this.e = i10 + 1;
                cArr4[i10] = ' ';
                this.c = i + 1;
            }
            if (i == i2 || (c = this.g[i]) == ',' || c == '+' || c == ';') {
                char[] cArr5 = this.g;
                int i11 = this.d;
                return new String(cArr5, i11, this.f - i11);
            }
        }
    }

    private char e() {
        int i = this.c + 1;
        this.c = i;
        if (i == this.b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
        }
        char c = this.g[i];
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
                        return f();
                }
        }
    }

    private char f() {
        int i;
        int i2;
        int iA = a(this.c);
        this.c++;
        if (iA < 128) {
            return (char) iA;
        }
        if (iA < 192 || iA > 247) {
            return '?';
        }
        if (iA <= 223) {
            i = iA & 31;
            i2 = 1;
        } else if (iA <= 239) {
            i = iA & 15;
            i2 = 2;
        } else {
            i = iA & 7;
            i2 = 3;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.c + 1;
            this.c = i4;
            if (i4 == this.b || this.g[i4] != '\\') {
                return '?';
            }
            int i5 = i4 + 1;
            this.c = i5;
            int iA2 = a(i5);
            this.c++;
            if ((iA2 & MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT) != 128) {
                return '?';
            }
            i = (i << 6) + (iA2 & 63);
        }
        return (char) i;
    }

    private int a(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 >= this.b) {
            throw new IllegalStateException("Malformed DN: " + this.a);
        }
        char[] cArr = this.g;
        char c = cArr[i];
        if (c >= '0' && c <= '9') {
            i2 = c - '0';
        } else if (c >= 'a' && c <= 'f') {
            i2 = c - 'W';
        } else {
            if (c < 'A' || c > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.a);
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
                throw new IllegalStateException("Malformed DN: " + this.a);
            }
            i3 = c2 - '7';
        }
        return (i2 << 4) + i3;
    }

    private String a(String str) {
        String str2;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = this.a.toCharArray();
        String strA = a();
        if (strA == null) {
            return null;
        }
        do {
            int i = this.c;
            if (i == this.b) {
                return null;
            }
            char c = this.g[i];
            if (c == '\"') {
                int i2 = i + 1;
                this.c = i2;
                this.d = i2;
                this.e = i2;
                while (true) {
                    int i3 = this.c;
                    if (i3 == this.b) {
                        throw new IllegalStateException("Unexpected end of DN: " + this.a);
                    }
                    char[] cArr = this.g;
                    char c2 = cArr[i3];
                    if (c2 == '\"') {
                        this.c = i3 + 1;
                        while (true) {
                            int i4 = this.c;
                            if (i4 >= this.b || this.g[i4] != ' ') {
                                break;
                            }
                            this.c = i4 + 1;
                        }
                        char[] cArr2 = this.g;
                        int i5 = this.d;
                        str2 = new String(cArr2, i5, this.e - i5);
                        break;
                    }
                    if (c2 == '\\') {
                        cArr[this.e] = e();
                    } else {
                        cArr[this.e] = c2;
                    }
                    this.c++;
                    this.e++;
                }
            } else if (c == '#') {
                str2 = c();
            } else {
                str2 = (c == '+' || c == ',' || c == ';') ? "" : d();
            }
            if (str.equalsIgnoreCase(strA)) {
                return str2;
            }
            int i6 = this.c;
            if (i6 >= this.b) {
                return null;
            }
            char c3 = this.g[i6];
            if (c3 != ',' && c3 != ';' && c3 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.a);
            }
            this.c = i6 + 1;
            strA = a();
        } while (strA != null);
        throw new IllegalStateException("Malformed DN: " + this.a);
    }
}
