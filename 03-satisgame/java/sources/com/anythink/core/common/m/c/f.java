package com.anythink.core.common.m.c;

import com.taptap.sdk.kit.internal.http.TapHttpUtil;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public class f implements Serializable, Comparable<f> {
    static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final f b = a(new byte[0]);
    private static final long f = 1;
    final byte[] c;
    transient int d;
    transient String e;

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(f fVar) {
        f fVar2 = fVar;
        int iJ = j();
        int iJ2 = fVar2.j();
        int iMin = Math.min(iJ, iJ2);
        for (int i = 0; i < iMin; i++) {
            int iB = b(i) & UByte.MAX_VALUE;
            int iB2 = fVar2.b(i) & UByte.MAX_VALUE;
            if (iB != iB2) {
                return iB < iB2 ? -1 : 1;
            }
        }
        if (iJ == iJ2) {
            return 0;
        }
        return iJ < iJ2 ? -1 : 1;
    }

    f(byte[] bArr) {
        this.c = bArr;
    }

    public static f a(byte... bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new f((byte[]) bArr.clone());
    }

    private static f a(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        y.a(bArr.length, i, i2);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new f(bArr2);
    }

    private static f a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("data == null");
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return new f(bArr);
    }

    public static f a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        f fVar = new f(str.getBytes(y.a));
        fVar.e = str;
        return fVar;
    }

    public static f a(String str, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        return new f(str.getBytes(charset));
    }

    public String a() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.c, y.a);
        this.e = str2;
        return str2;
    }

    public String a(Charset charset) {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        return new String(this.c, charset);
    }

    public String b() {
        return b.a(this.c);
    }

    public f c() {
        return d(com.anythink.core.common.u.n.a);
    }

    public f d() {
        return d("SHA-1");
    }

    public f e() {
        return d("SHA-256");
    }

    private f n() {
        return d("SHA-512");
    }

    private f d(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.c));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public f a(f fVar) {
        return a(TapHttpUtil.HMAC_SHA1, fVar);
    }

    public f b(f fVar) {
        return a(TapHttpUtil.HMAC_SHA256, fVar);
    }

    private f d(f fVar) {
        return a("HmacSHA512", fVar);
    }

    private f a(String str, f fVar) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(fVar.k(), str));
            return a(mac.doFinal(this.c));
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public String f() {
        return b.b(this.c);
    }

    public static f b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        byte[] bArrA = b.a(str);
        if (bArrA != null) {
            return new f(bArrA);
        }
        return null;
    }

    public String g() {
        byte[] bArr = this.c;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            char[] cArr2 = a;
            cArr[i] = cArr2[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public static f c(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(String.valueOf(str)));
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((a(str.charAt(i2)) << 4) + a(str.charAt(i2 + 1)));
        }
        return a(bArr);
    }

    private static int a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: ".concat(String.valueOf(c)));
            }
        }
        return (c - c2) + 10;
    }

    private static f a(InputStream inputStream, int i) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(i)));
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, i2, i - i2);
            if (i3 == -1) {
                throw new EOFException();
            }
            i2 += i3;
        }
        return new f(bArr);
    }

    public f h() {
        int i = 0;
        while (true) {
            byte[] bArr = this.c;
            if (i >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i];
            if (b2 >= 65 && b2 <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b2 + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b3 = bArr2[i2];
                    if (b3 >= 65 && b3 <= 90) {
                        bArr2[i2] = (byte) (b3 + 32);
                    }
                }
                return new f(bArr2);
            }
            i++;
        }
    }

    public f i() {
        int i = 0;
        while (true) {
            byte[] bArr = this.c;
            if (i >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i];
            if (b2 >= 97 && b2 <= 122) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b2 - 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b3 = bArr2[i2];
                    if (b3 >= 97 && b3 <= 122) {
                        bArr2[i2] = (byte) (b3 - 32);
                    }
                }
                return new f(bArr2);
            }
            i++;
        }
    }

    public f a(int i) {
        return a(i, this.c.length);
    }

    public f a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.c;
        if (i2 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.c.length + ")");
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i == 0 && i2 == bArr.length) {
            return this;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        return new f(bArr2);
    }

    public byte b(int i) {
        return this.c[i];
    }

    public int j() {
        return this.c.length;
    }

    public byte[] k() {
        return (byte[]) this.c.clone();
    }

    byte[] l() {
        return this.c;
    }

    public ByteBuffer m() {
        return ByteBuffer.wrap(this.c).asReadOnlyBuffer();
    }

    public void a(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        outputStream.write(this.c);
    }

    void a(c cVar) {
        byte[] bArr = this.c;
        cVar.c(bArr, 0, bArr.length);
    }

    public boolean a(int i, f fVar, int i2, int i3) {
        return fVar.a(0, this.c, i, i3);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.c;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && y.a(bArr2, i, bArr, i2, i3);
    }

    public final boolean c(f fVar) {
        return a(0, fVar, 0, fVar.j());
    }

    private boolean b(byte[] bArr) {
        return a(0, bArr, 0, bArr.length);
    }

    private boolean e(f fVar) {
        return a(j() - fVar.j(), fVar, 0, fVar.j());
    }

    private boolean c(byte[] bArr) {
        return a(j() - bArr.length, bArr, 0, bArr.length);
    }

    private int f(f fVar) {
        return a(fVar.l(), 0);
    }

    private int a(f fVar, int i) {
        return a(fVar.l(), i);
    }

    private int d(byte[] bArr) {
        return a(bArr, 0);
    }

    public int a(byte[] bArr, int i) {
        int length = this.c.length - bArr.length;
        for (int iMax = Math.max(i, 0); iMax <= length; iMax++) {
            if (y.a(this.c, iMax, bArr, 0, bArr.length)) {
                return iMax;
            }
        }
        return -1;
    }

    private int g(f fVar) {
        return b(fVar.l(), j());
    }

    private int b(f fVar, int i) {
        return b(fVar.l(), i);
    }

    private int e(byte[] bArr) {
        return b(bArr, j());
    }

    public int b(byte[] bArr, int i) {
        for (int iMin = Math.min(i, this.c.length - bArr.length); iMin >= 0; iMin--) {
            if (y.a(this.c, iMin, bArr, 0, bArr.length)) {
                return iMin;
            }
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            int iJ = fVar.j();
            byte[] bArr = this.c;
            if (iJ == bArr.length && fVar.a(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.c);
        this.d = iHashCode;
        return iHashCode;
    }

    private int h(f fVar) {
        int iJ = j();
        int iJ2 = fVar.j();
        int iMin = Math.min(iJ, iJ2);
        for (int i = 0; i < iMin; i++) {
            int iB = b(i) & UByte.MAX_VALUE;
            int iB2 = fVar.b(i) & UByte.MAX_VALUE;
            if (iB != iB2) {
                return iB < iB2 ? -1 : 1;
            }
        }
        if (iJ == iJ2) {
            return 0;
        }
        return iJ < iJ2 ? -1 : 1;
    }

    public String toString() {
        if (this.c.length == 0) {
            return "[size=0]";
        }
        String strA = a();
        int length = strA.length();
        int length2 = 0;
        int i = 0;
        while (true) {
            if (length2 >= length) {
                length2 = strA.length();
                break;
            }
            if (i != 64) {
                int iCodePointAt = strA.codePointAt(length2);
                if ((Character.isISOControl(iCodePointAt) && iCodePointAt != 10 && iCodePointAt != 13) || iCodePointAt == 65533) {
                    length2 = -1;
                    break;
                }
                i++;
                length2 += Character.charCount(iCodePointAt);
            } else {
                break;
            }
        }
        if (length2 == -1) {
            if (this.c.length <= 64) {
                return "[hex=" + g() + "]";
            }
            return "[size=" + this.c.length + " hex=" + a(0, 64).g() + "…]";
        }
        String strReplace = strA.substring(0, length2).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (length2 < strA.length()) {
            return "[size=" + this.c.length + " text=" + strReplace + "…]";
        }
        return "[text=" + strReplace + "]";
    }

    private static int e(String str) {
        int length = str.length();
        int iCharCount = 0;
        int i = 0;
        while (iCharCount < length) {
            if (i == 64) {
                return iCharCount;
            }
            int iCodePointAt = str.codePointAt(iCharCount);
            if ((Character.isISOControl(iCodePointAt) && iCodePointAt != 10 && iCodePointAt != 13) || iCodePointAt == 65533) {
                return -1;
            }
            i++;
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.length();
    }

    private void a(ObjectInputStream objectInputStream) throws IOException {
        int i = objectInputStream.readInt();
        if (objectInputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(i)));
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = objectInputStream.read(bArr, i2, i - i2);
            if (i3 == -1) {
                throw new EOFException();
            }
            i2 += i3;
        }
        f fVar = new f(bArr);
        try {
            Field declaredField = f.class.getDeclaredField("c");
            declaredField.setAccessible(true);
            declaredField.set(this, fVar.c);
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (NoSuchFieldException unused2) {
            throw new AssertionError();
        }
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.c.length);
        objectOutputStream.write(this.c);
    }
}
