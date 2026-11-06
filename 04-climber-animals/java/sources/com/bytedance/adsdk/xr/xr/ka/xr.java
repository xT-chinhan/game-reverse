package com.bytedance.adsdk.xr.xr.ka;

import com.bytedance.adsdk.xr.xr.d.ah;
import com.bytedance.adsdk.xr.xr.d.d;
import com.bytedance.adsdk.xr.xr.xr.ms.c;
import com.bytedance.adsdk.xr.xr.xr.ms.h;
import com.bytedance.adsdk.xr.xr.xr.ms.hi;
import com.bytedance.adsdk.xr.xr.xr.ms.ka;
import com.bytedance.adsdk.xr.xr.xr.ms.ny;
import com.bytedance.adsdk.xr.xr.xr.ms.qv;
import com.bytedance.adsdk.xr.xr.xr.ms.sl;
import com.bytedance.adsdk.xr.xr.xr.ms.u;
import com.bytedance.adsdk.xr.xr.xr.ms.x;
import com.bytedance.adsdk.xr.xr.xr.ms.y;
import com.bytedance.adsdk.xr.xr.xr.ms.zb;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public static com.bytedance.adsdk.xr.xr.xr.ms ms(List<com.bytedance.adsdk.xr.xr.xr.ms> list, String str, int i) {
        ah(list, str, i);
        Deque<com.bytedance.adsdk.xr.xr.xr.ms> dequeMs = ms(xr(list, str, i));
        if (dequeMs.size() != 1) {
            throw new IllegalStateException();
        }
        return dequeMs.getFirst();
    }

    private static Deque<com.bytedance.adsdk.xr.xr.xr.ms> ms(Deque<com.bytedance.adsdk.xr.xr.xr.ms> deque) {
        LinkedList linkedList = new LinkedList();
        for (com.bytedance.adsdk.xr.xr.xr.ms msVar : deque) {
            if (!linkedList.isEmpty() && ((com.bytedance.adsdk.xr.xr.xr.ms) linkedList.peekLast()).ms() == ah.COLON) {
                linkedList.pollLast();
                com.bytedance.adsdk.xr.xr.xr.ms msVar2 = (com.bytedance.adsdk.xr.xr.xr.ms) linkedList.pollLast();
                if (((com.bytedance.adsdk.xr.xr.xr.ms) linkedList.pollLast()).ms() != ah.QUESTION) {
                    throw new IllegalStateException();
                }
                com.bytedance.adsdk.xr.xr.xr.ms msVar3 = (com.bytedance.adsdk.xr.xr.xr.ms) linkedList.pollLast();
                y yVar = new y();
                yVar.ms(msVar3);
                yVar.xr(msVar2);
                yVar.ah(msVar);
                linkedList.addLast(yVar);
            } else {
                linkedList.addLast(msVar);
            }
        }
        return linkedList;
    }

    private static Deque<com.bytedance.adsdk.xr.xr.xr.ms> xr(List<com.bytedance.adsdk.xr.xr.xr.ms> list, String str, int i) {
        LinkedList<com.bytedance.adsdk.xr.xr.xr.ms> linkedList = new LinkedList(list);
        int i2 = 5;
        while (i2 > 0) {
            LinkedList linkedList2 = new LinkedList();
            for (com.bytedance.adsdk.xr.xr.xr.ms msVar : linkedList) {
                if (!linkedList2.isEmpty() && ah.ms(((com.bytedance.adsdk.xr.xr.xr.ms) linkedList2.peekLast()).ms()) && ((ah) ((com.bytedance.adsdk.xr.xr.xr.ms) linkedList2.peekLast()).ms()).xr() == i2) {
                    com.bytedance.adsdk.xr.xr.xr.ms msVar2 = (com.bytedance.adsdk.xr.xr.xr.ms) linkedList2.pollLast();
                    com.bytedance.adsdk.xr.xr.xr.ms msVar3 = (com.bytedance.adsdk.xr.xr.xr.ms) linkedList2.pollLast();
                    if (!ah.ms(msVar3.ms()) && !ah.ms(msVar.ms())) {
                        linkedList2.addLast(ms(msVar3, msVar2, msVar));
                    } else {
                        throw new IllegalArgumentException(str.substring(0, i));
                    }
                } else {
                    linkedList2.addLast(msVar);
                }
            }
            i2--;
            linkedList = linkedList2;
        }
        return linkedList;
    }

    private static void ah(List<com.bytedance.adsdk.xr.xr.xr.ms> list, String str, int i) {
        Iterator<com.bytedance.adsdk.xr.xr.xr.ms> it = list.iterator();
        while (it.hasNext()) {
            if (d.ms(it.next().ms())) {
                throw new IllegalArgumentException(str.substring(0, i));
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.xr.xr.ka.xr$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final /* synthetic */ int[] f462ms;

        static {
            int[] iArr = new int[ah.values().length];
            f462ms = iArr;
            try {
                iArr[ah.MINUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f462ms[ah.PLUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f462ms[ah.DIVISION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f462ms[ah.MULTI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f462ms[ah.MOD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f462ms[ah.EQ.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f462ms[ah.NOT_EQ.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f462ms[ah.GT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f462ms[ah.LT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f462ms[ah.GT_EQ.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f462ms[ah.LT_EQ.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f462ms[ah.DOUBLE_AMP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f462ms[ah.DOUBLE_BAR.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    private static com.bytedance.adsdk.xr.xr.xr.ms ms(com.bytedance.adsdk.xr.xr.xr.ms msVar, com.bytedance.adsdk.xr.xr.xr.ms msVar2, com.bytedance.adsdk.xr.xr.xr.ms msVar3) {
        h hiVar;
        switch (AnonymousClass1.f462ms[((ah) msVar2.ms()).ordinal()]) {
            case 1:
                hiVar = new hi();
                break;
            case 2:
                hiVar = new qv();
                break;
            case 3:
                hiVar = new com.bytedance.adsdk.xr.xr.xr.ms.ms();
                break;
            case 4:
                hiVar = new zb();
                break;
            case 5:
                hiVar = new sl();
                break;
            case 6:
                hiVar = new com.bytedance.adsdk.xr.xr.xr.ms.d();
                break;
            case 7:
                hiVar = new u();
                break;
            case 8:
                hiVar = new c();
                break;
            case 9:
                hiVar = new ny();
                break;
            case 10:
                hiVar = new ka();
                break;
            case 11:
                hiVar = new x();
                break;
            case 12:
                hiVar = new com.bytedance.adsdk.xr.xr.xr.ms.xr();
                break;
            case 13:
                hiVar = new com.bytedance.adsdk.xr.xr.xr.ms.ah();
                break;
            default:
                throw new UnsupportedOperationException(msVar2.ms().toString());
        }
        hiVar.ms(msVar);
        hiVar.xr(msVar3);
        return hiVar;
    }

    public static boolean ms(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
            return !(obj instanceof Number) || ((Number) obj).floatValue() >= 0.0f;
        }
        return false;
    }
}
