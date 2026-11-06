package com.byazt.dr;

import com.byazt.mn.q;
import com.byazt.mn.s;
import com.byazt.uc.cd;
import com.byazt.uc.cp;
import com.byazt.uc.d;
import com.byazt.uc.fs;
import com.byazt.uc.hd;
import com.byazt.uc.l;
import com.byazt.uc.oa;
import com.byazt.uc.rv;
import com.byazt.uc.sz;
import com.byazt.uc.um;
import com.byazt.uc.w;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2045, 26})
public class qg {
    public static com.byazt.uk.n n(List<com.byazt.uk.n> list, String str, int i) {
        s(list, str, i);
        Deque<com.byazt.uk.n> dequeN = n(qg(list, str, i));
        if (dequeN.size() != 1) {
            throw new IllegalStateException();
        }
        return dequeN.getFirst();
    }

    private static Deque<com.byazt.uk.n> n(Deque<com.byazt.uk.n> deque) {
        LinkedList linkedList = new LinkedList();
        for (com.byazt.uk.n nVar : deque) {
            if (!linkedList.isEmpty() && ((com.byazt.uk.n) linkedList.peekLast()).n() == s.COLON) {
                linkedList.pollLast();
                com.byazt.uk.n nVar2 = (com.byazt.uk.n) linkedList.pollLast();
                if (((com.byazt.uk.n) linkedList.pollLast()).n() != s.QUESTION) {
                    throw new IllegalStateException();
                }
                com.byazt.uk.n nVar3 = (com.byazt.uk.n) linkedList.pollLast();
                um umVar = new um();
                umVar.n(nVar3);
                umVar.qg(nVar2);
                umVar.s(nVar);
                linkedList.addLast(umVar);
            } else {
                linkedList.addLast(nVar);
            }
        }
        return linkedList;
    }

    private static Deque<com.byazt.uk.n> qg(List<com.byazt.uk.n> list, String str, int i) {
        LinkedList<com.byazt.uk.n> linkedList = new LinkedList(list);
        int i2 = 5;
        while (i2 > 0) {
            LinkedList linkedList2 = new LinkedList();
            for (com.byazt.uk.n nVar : linkedList) {
                if (!linkedList2.isEmpty() && s.n(((com.byazt.uk.n) linkedList2.peekLast()).n()) && ((s) ((com.byazt.uk.n) linkedList2.peekLast()).n()).qg() == i2) {
                    com.byazt.uk.n nVar2 = (com.byazt.uk.n) linkedList2.pollLast();
                    com.byazt.uk.n nVar3 = (com.byazt.uk.n) linkedList2.pollLast();
                    if (!s.n(nVar3.n()) && !s.n(nVar.n())) {
                        linkedList2.addLast(n(nVar3, nVar2, nVar));
                    } else {
                        throw new IllegalArgumentException(str.substring(0, i));
                    }
                } else {
                    linkedList2.addLast(nVar);
                }
            }
            i2--;
            linkedList = linkedList2;
        }
        return linkedList;
    }

    private static void s(List<com.byazt.uk.n> list, String str, int i) {
        Iterator<com.byazt.uk.n> it = list.iterator();
        while (it.hasNext()) {
            if (q.n(it.next().n())) {
                throw new IllegalArgumentException(str.substring(0, i));
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.dr.qg$1, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, 2045, 51})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] n;

        static {
            int[] iArr = new int[s.values().length];
            n = iArr;
            try {
                iArr[s.MINUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                n[s.PLUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                n[s.DIVISION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                n[s.MULTI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                n[s.MOD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                n[s.EQ.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                n[s.NOT_EQ.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                n[s.GT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                n[s.LT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                n[s.GT_EQ.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                n[s.LT_EQ.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                n[s.DOUBLE_AMP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                n[s.DOUBLE_BAR.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    private static com.byazt.uk.n n(com.byazt.uk.n nVar, com.byazt.uk.n nVar2, com.byazt.uk.n nVar3) {
        hd cpVar;
        switch (AnonymousClass1.n[((s) nVar2.n()).ordinal()]) {
            case 1:
                cpVar = new cp();
                break;
            case 2:
                cpVar = new cd();
                break;
            case 3:
                cpVar = new com.byazt.uc.n();
                break;
            case 4:
                cpVar = new oa();
                break;
            case 5:
                cpVar = new d();
                break;
            case 6:
                cpVar = new com.byazt.uc.q();
                break;
            case 7:
                cpVar = new sz();
                break;
            case 8:
                cpVar = new w();
                break;
            case 9:
                cpVar = new rv();
                break;
            case 10:
                cpVar = new l();
                break;
            case 11:
                cpVar = new fs();
                break;
            case 12:
                cpVar = new com.byazt.uc.qg();
                break;
            case 13:
                cpVar = new com.byazt.uc.s();
                break;
            default:
                throw new UnsupportedOperationException(nVar2.n().toString());
        }
        cpVar.n(nVar);
        cpVar.qg(nVar3);
        return cpVar;
    }

    public static boolean n(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
            return !(obj instanceof Number) || ((Number) obj).floatValue() >= 0.0f;
        }
        return false;
    }
}
