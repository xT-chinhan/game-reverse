package com.byazt.zho;

import com.byazt.pq.bb;
import com.byazt.pq.cd;
import com.byazt.pq.cp;
import com.byazt.pq.lh;
import com.byazt.pq.tj;
import com.byazt.sqs.x;
import java.net.Socket;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1548, 19})
public abstract class n {
    public static n n;

    public abstract int n(bb.n nVar);

    public abstract com.byazt.sqs.q n(tj tjVar);

    public abstract com.byazt.sqs.s n(tj tjVar, com.byazt.pq.n nVar, x xVar, lh lhVar);

    public abstract Socket n(tj tjVar, com.byazt.pq.n nVar, x xVar);

    public abstract void n(cd.n nVar, String str);

    public abstract void n(cd.n nVar, String str, String str2);

    public abstract void n(cp cpVar, SSLSocket sSLSocket, boolean z);

    public abstract boolean n(com.byazt.pq.n nVar, com.byazt.pq.n nVar2);

    public abstract boolean n(tj tjVar, com.byazt.sqs.s sVar);

    public abstract void qg(tj tjVar, com.byazt.sqs.s sVar);
}
