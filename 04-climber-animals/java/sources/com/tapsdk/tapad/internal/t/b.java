package com.tapsdk.tapad.internal.t;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static final int d = 64;
    public static final String e = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+-";
    private String a;
    private char[] b;
    private HashMap<Character, Integer> c;

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.t.b$b, reason: collision with other inner class name */
    static class C0633b {
        static b a = new b();

        C0633b() {
        }
    }

    private b() {
        b(e);
    }

    public b(String str) {
        b(str);
    }

    public static b b() {
        return C0633b.a;
    }

    public String a() {
        return this.a;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0041  */
    /* JADX WARN: Code duplicated, block: B:32:0x0043 A[SYNTHETIC] */
    public String a(byte[] bArr) throws UnsupportedEncodingException {
        char c;
        byte b;
        StringBuilder sb = new StringBuilder();
        int i = 2;
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length) {
            int i4 = bArr[i2];
            if (i == 2) {
                i3 = (byte) ((i4 >> 2) & 63);
                i4 <<= 4;
            } else if (i == 4) {
                i3 = (byte) ((i3 == true ? 1 : 0) | ((byte) ((i4 >> 4) & 15)));
                i4 <<= 2;
            } else {
                if (i == 6) {
                    i3 = (byte) ((i3 == true ? 1 : 0) | ((byte) ((i4 >> 6) & 3)));
                } else if (i == 0) {
                    b = 0;
                } else {
                    b = i3 == true ? 1 : 0;
                    i3 = i4;
                }
                i = (i + 2) % 8;
                if (i == 0) {
                    i2--;
                }
                sb.append(this.b[i3]);
                i2++;
                i3 = b;
            }
            b = (byte) (i4 & 63);
            i = (i + 2) % 8;
            if (i == 0) {
                i2--;
            }
            sb.append(this.b[i3]);
            i2++;
            i3 = b;
        }
        if (i3 == 0) {
            if (sb.length() < ((int) Math.ceil((((double) bArr.length) * 8.0d) / 6.0d))) {
                c = this.b[0];
            }
            return sb.toString();
        }
        c = this.b[i3 == true ? 1 : 0];
        sb.append(c);
        return sb.toString();
    }

    public byte[] a(String str) {
        int iFloor = (int) Math.floor((((double) str.length()) * 6.0d) / 8.0d);
        byte[] bArr = new byte[iFloor];
        int i = 2;
        int i2 = 0;
        for (int i3 = 0; i3 < iFloor; i3++) {
            byte bIntValue = (byte) this.c.get(Character.valueOf(str.charAt(i2))).intValue();
            bArr[i3] = bIntValue;
            bArr[i3] = (byte) (bIntValue << i);
            int i4 = i2 + 1;
            bArr[i3] = (byte) (((byte) (((byte) this.c.get(Character.valueOf(str.charAt(i4))).intValue()) >> (6 - i))) | bArr[i3]);
            i = (i + 2) % 8;
            if (i == 0) {
                i += 2;
                i2 = i4;
            }
            i2++;
        }
        return bArr;
    }

    public void b(String str) {
        if (str.length() != 64) {
            throw new c("The charset must be 64 characters long.");
        }
        this.a = str;
        this.b = str.toCharArray();
        this.c = new HashMap<>();
        int i = 0;
        while (true) {
            char[] cArr = this.b;
            if (i >= cArr.length) {
                break;
            }
            this.c.put(Character.valueOf(cArr[i]), Integer.valueOf(i));
            i++;
        }
        if (this.c.size() != 64) {
            throw new c("The charset must contain 64 unique characters.");
        }
    }
}
