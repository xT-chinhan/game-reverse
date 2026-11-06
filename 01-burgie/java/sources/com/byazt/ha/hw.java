package com.byazt.ha;

import com.byazt.tki.aj;
import com.byazt.tki.c;
import com.byazt.tki.g;
import com.byazt.tki.k;
import com.byazt.tki.lb;
import com.byazt.tki.m;
import com.byazt.tki.qa;
import com.byazt.tki.uc;
import com.byazt.tki.w;
import com.byazt.tki.yb;
import com.byazt.tki.zo;
import com.byazt.yiq.hn;
import com.byazt.yiq.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DNS_START_TIME, 13})
public class hw {
    public static com.byazt.awu.pr pr(List<com.byazt.awu.pr> list, String str, int i) {
        hn(list, str, i);
        Deque<com.byazt.awu.pr> dequePr = pr(hw(list, str, i));
        if (dequePr.size() != 1) {
            throw new IllegalStateException();
        }
        return dequePr.getFirst();
    }

    private static Deque<com.byazt.awu.pr> pr(Deque<com.byazt.awu.pr> deque) {
        LinkedList linkedList = new LinkedList();
        for (com.byazt.awu.pr prVar : deque) {
            if (!linkedList.isEmpty() && ((com.byazt.awu.pr) linkedList.peekLast()).pr() == hn.COLON) {
                linkedList.pollLast();
                com.byazt.awu.pr prVar2 = (com.byazt.awu.pr) linkedList.pollLast();
                if (((com.byazt.awu.pr) linkedList.pollLast()).pr() != hn.QUESTION) {
                    throw new IllegalStateException();
                }
                com.byazt.awu.pr prVar3 = (com.byazt.awu.pr) linkedList.pollLast();
                qa qaVar = new qa();
                qaVar.pr(prVar3);
                qaVar.hw(prVar2);
                qaVar.hn(prVar);
                linkedList.addLast(qaVar);
            } else {
                linkedList.addLast(prVar);
            }
        }
        return linkedList;
    }

    private static Deque<com.byazt.awu.pr> hw(List<com.byazt.awu.pr> list, String str, int i) {
        LinkedList<com.byazt.awu.pr> linkedList = new LinkedList(list);
        int i2 = 5;
        while (i2 > 0) {
            LinkedList linkedList2 = new LinkedList();
            for (com.byazt.awu.pr prVar : linkedList) {
                if (!linkedList2.isEmpty() && hn.pr(((com.byazt.awu.pr) linkedList2.peekLast()).pr()) && ((hn) ((com.byazt.awu.pr) linkedList2.peekLast()).pr()).hw() == i2) {
                    com.byazt.awu.pr prVar2 = (com.byazt.awu.pr) linkedList2.pollLast();
                    com.byazt.awu.pr prVar3 = (com.byazt.awu.pr) linkedList2.pollLast();
                    if (!hn.pr(prVar3.pr()) && !hn.pr(prVar.pr())) {
                        linkedList2.addLast(pr(prVar3, prVar2, prVar));
                    } else {
                        throw new IllegalArgumentException(str.substring(0, i));
                    }
                } else {
                    linkedList2.addLast(prVar);
                }
            }
            i2--;
            linkedList = linkedList2;
        }
        return linkedList;
    }

    private static void hn(List<com.byazt.awu.pr> list, String str, int i) {
        Iterator<com.byazt.awu.pr> it = list.iterator();
        while (it.hasNext()) {
            if (x.pr(it.next().pr())) {
                throw new IllegalArgumentException(str.substring(0, i));
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.ha.hw$1, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DNS_START_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_LAZY_SEEK})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] pr;

        static {
            int[] iArr = new int[hn.values().length];
            pr = iArr;
            try {
                iArr[hn.MINUS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pr[hn.PLUS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                pr[hn.DIVISION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                pr[hn.MULTI.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                pr[hn.MOD.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                pr[hn.EQ.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                pr[hn.NOT_EQ.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                pr[hn.GT.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                pr[hn.LT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                pr[hn.GT_EQ.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                pr[hn.LT_EQ.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                pr[hn.DOUBLE_AMP.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                pr[hn.DOUBLE_BAR.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
        }
    }

    private static com.byazt.awu.pr pr(com.byazt.awu.pr prVar, com.byazt.awu.pr prVar2, com.byazt.awu.pr prVar3) {
        yb wVar;
        switch (AnonymousClass1.pr[((hn) prVar2.pr()).ordinal()]) {
            case 1:
                wVar = new w();
                break;
            case 2:
                wVar = new lb();
                break;
            case 3:
                wVar = new com.byazt.tki.pr();
                break;
            case 4:
                wVar = new m();
                break;
            case 5:
                wVar = new k();
                break;
            case 6:
                wVar = new com.byazt.tki.x();
                break;
            case 7:
                wVar = new g();
                break;
            case 8:
                wVar = new uc();
                break;
            case 9:
                wVar = new aj();
                break;
            case 10:
                wVar = new c();
                break;
            case 11:
                wVar = new zo();
                break;
            case 12:
                wVar = new com.byazt.tki.hw();
                break;
            case 13:
                wVar = new com.byazt.tki.hn();
                break;
            default:
                throw new UnsupportedOperationException(prVar2.pr().toString());
        }
        wVar.pr(prVar);
        wVar.hw(prVar3);
        return wVar;
    }

    public static boolean pr(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
            return !(obj instanceof Number) || ((Number) obj).floatValue() >= 0.0f;
        }
        return false;
    }
}
