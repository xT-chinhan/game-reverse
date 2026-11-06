package com.byazt.fz;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1569, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c<K, V> {
    public static Object[] hn;
    public static int hw;
    public static Object[] pr;
    public static int x;
    public int[] c = hw.pr;
    public Object[] uc = hw.hn;
    public int fw = 0;

    private static int pr(int[] iArr, int i, int i2) {
        try {
            return hw.pr(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ConcurrentModificationException();
        }
    }

    public int pr(Object obj, int i) {
        int i2 = this.fw;
        if (i2 == 0) {
            return -1;
        }
        int iPr = pr(this.c, i2, i);
        if (iPr < 0 || obj.equals(this.uc[iPr << 1])) {
            return iPr;
        }
        int i3 = iPr + 1;
        while (i3 < i2 && this.c[i3] == i) {
            if (!obj.equals(this.uc[i3 << 1])) {
                i3++;
            } else {
                return i3;
            }
        }
        for (int i4 = iPr - 1; i4 >= 0 && this.c[i4] == i; i4--) {
            if (obj.equals(this.uc[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    public int pr() {
        int i = this.fw;
        if (i == 0) {
            return -1;
        }
        int iPr = pr(this.c, i, 0);
        if (iPr < 0 || this.uc[iPr << 1] == null) {
            return iPr;
        }
        int i2 = iPr + 1;
        while (i2 < i && this.c[i2] == 0) {
            if (this.uc[i2 << 1] != null) {
                i2++;
            } else {
                return i2;
            }
        }
        for (int i3 = iPr - 1; i3 >= 0 && this.c[i3] == 0; i3--) {
            if (this.uc[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    private void x(int i) {
        if (i == 8) {
            synchronized (pr.class) {
                Object[] objArr = hn;
                if (objArr != null) {
                    this.uc = objArr;
                    hn = (Object[]) objArr[0];
                    this.c = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    x--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (pr.class) {
                Object[] objArr2 = pr;
                if (objArr2 != null) {
                    this.uc = objArr2;
                    pr = (Object[]) objArr2[0];
                    this.c = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    hw--;
                    return;
                }
            }
        }
        this.c = new int[i];
        this.uc = new Object[i << 1];
    }

    private static void pr(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (pr.class) {
                if (x < 10) {
                    objArr[0] = hn;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    hn = objArr;
                    x++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (pr.class) {
                if (hw < 10) {
                    objArr[0] = pr;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    pr = objArr;
                    hw++;
                }
            }
        }
    }

    public void clear() {
        int i = this.fw;
        if (i > 0) {
            int[] iArr = this.c;
            Object[] objArr = this.uc;
            this.c = hw.pr;
            this.uc = hw.hn;
            this.fw = 0;
            pr(iArr, objArr, i);
        }
        if (this.fw > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return pr(obj) >= 0;
    }

    public int pr(Object obj) {
        return obj == null ? pr() : pr(obj, obj.hashCode());
    }

    public int hw(Object obj) {
        int i = this.fw * 2;
        Object[] objArr = this.uc;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return hw(obj) >= 0;
    }

    public V get(Object obj) {
        int iPr = pr(obj);
        if (iPr >= 0) {
            return (V) this.uc[(iPr << 1) + 1];
        }
        return null;
    }

    public K pr(int i) {
        return (K) this.uc[i << 1];
    }

    public V hw(int i) {
        return (V) this.uc[(i << 1) + 1];
    }

    public boolean isEmpty() {
        return this.fw <= 0;
    }

    public V put(K k, V v) {
        int i;
        int iPr;
        int i2 = this.fw;
        if (k == null) {
            iPr = pr();
            i = 0;
        } else {
            int iHashCode = k.hashCode();
            i = iHashCode;
            iPr = pr(k, iHashCode);
        }
        if (iPr >= 0) {
            int i3 = (iPr << 1) + 1;
            Object[] objArr = this.uc;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        int i4 = ~iPr;
        int[] iArr = this.c;
        if (i2 >= iArr.length) {
            int i5 = 4;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 >= 4) {
                i5 = 8;
            }
            Object[] objArr2 = this.uc;
            x(i5);
            if (i2 != this.fw) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.c;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.uc, 0, objArr2.length);
            }
            pr(iArr, objArr2, i2);
        }
        if (i4 < i2) {
            int[] iArr3 = this.c;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.uc;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.fw - i4) << 1);
        }
        int i7 = this.fw;
        if (i2 == i7) {
            int[] iArr4 = this.c;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.uc;
                int i8 = i4 << 1;
                objArr4[i8] = k;
                objArr4[i8 + 1] = v;
                this.fw = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V remove(Object obj) {
        int iPr = pr(obj);
        if (iPr >= 0) {
            return hn(iPr);
        }
        return null;
    }

    public V hn(int i) {
        Object[] objArr = this.uc;
        int i2 = i << 1;
        V v = (V) objArr[i2 + 1];
        int i3 = this.fw;
        int i4 = 0;
        if (i3 <= 1) {
            pr(this.c, objArr, i3);
            this.c = hw.pr;
            this.uc = hw.hn;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.c;
            if (iArr.length > 8 && i3 < iArr.length / 3) {
                x(i3 > 8 ? i3 + (i3 >> 1) : 8);
                if (i3 != this.fw) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.c, 0, i);
                    System.arraycopy(objArr, 0, this.uc, 0, i2);
                }
                if (i < i5) {
                    int i6 = i + 1;
                    int i7 = i5 - i;
                    System.arraycopy(iArr, i6, this.c, i, i7);
                    System.arraycopy(objArr, i6 << 1, this.uc, i2, i7 << 1);
                }
            } else {
                if (i < i5) {
                    int i8 = i + 1;
                    int i9 = i5 - i;
                    System.arraycopy(iArr, i8, iArr, i, i9);
                    Object[] objArr2 = this.uc;
                    System.arraycopy(objArr2, i8 << 1, objArr2, i2, i9 << 1);
                }
                Object[] objArr3 = this.uc;
                int i10 = i5 << 1;
                objArr3[i10] = null;
                objArr3[i10 + 1] = null;
            }
            i4 = i5;
        }
        if (i3 != this.fw) {
            throw new ConcurrentModificationException();
        }
        this.fw = i4;
        return v;
    }

    public int size() {
        return this.fw;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (size() != cVar.size()) {
                return false;
            }
            for (int i = 0; i < this.fw; i++) {
                try {
                    K kPr = pr(i);
                    V vHw = hw(i);
                    Object obj2 = cVar.get(kPr);
                    if (vHw == null) {
                        if (obj2 != null || !cVar.containsKey(kPr)) {
                            return false;
                        }
                    } else if (!vHw.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException e) {
                    return false;
                } catch (NullPointerException e2) {
                    return false;
                }
            }
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.fw; i2++) {
            try {
                K kPr2 = pr(i2);
                V vHw2 = hw(i2);
                Object obj3 = map.get(kPr2);
                if (vHw2 == null) {
                    if (obj3 != null || !map.containsKey(kPr2)) {
                        return false;
                    }
                } else if (!vHw2.equals(obj3)) {
                    return false;
                }
            } catch (ClassCastException e3) {
                return false;
            } catch (NullPointerException e4) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int[] iArr = this.c;
        Object[] objArr = this.uc;
        int i = this.fw;
        int i2 = 1;
        int i3 = 0;
        int iHashCode = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return iHashCode;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.fw * 28);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        for (int i = 0; i < this.fw; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K kPr = pr(i);
            if (kPr != this) {
                sb.append(kPr);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V vHw = hw(i);
            if (vHw != this) {
                sb.append(vHw);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }
}
