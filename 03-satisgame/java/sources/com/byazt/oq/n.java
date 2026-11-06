package com.byazt.oq;

import com.byazt.cy.fs;
import com.byazt.nq.x;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2407, 19})
public class n extends x {
    public com.byazt.xll.qg n;

    public n(com.byazt.xll.qg qgVar) {
        this.n = qgVar;
    }

    @Override // com.byazt.nq.x
    public void n() {
        com.byazt.xll.qg qgVar = this.n;
        if (qgVar != null) {
            qgVar.x();
        }
    }

    @Override // com.byazt.nq.s
    public boolean l() {
        com.byazt.xll.qg qgVar = this.n;
        if (qgVar != null) {
            return qgVar.n();
        }
        return false;
    }

    @Override // com.byazt.nq.s
    public List<com.byazt.nq.qg> w() {
        if (this.n != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < this.n.qg().size(); i++) {
                linkedList.add(new fs(this.n.qg().get(i)));
            }
            return linkedList;
        }
        return new LinkedList();
    }

    @Override // com.byazt.nq.s
    public List<com.byazt.nq.n> x() {
        if (this.n != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < this.n.s().size(); i++) {
                linkedList.add(new com.byazt.cy.x(this.n.s().get(i)));
            }
            return linkedList;
        }
        return new LinkedList();
    }

    @Override // com.byazt.nq.s
    public com.byazt.nq.n fs() {
        if (this.n != null) {
            return new com.byazt.cy.x(this.n.q());
        }
        return new com.byazt.cy.x(null);
    }

    @Override // com.byazt.nq.s
    public List<com.byazt.nq.n> rv() {
        if (this.n != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < this.n.l().size(); i++) {
                linkedList.add(new com.byazt.cy.x(this.n.l().get(i)));
            }
            return linkedList;
        }
        return new LinkedList();
    }

    @Override // com.byazt.nq.s
    public com.byazt.nq.n tj() {
        if (this.n != null) {
            return new com.byazt.cy.x(this.n.w());
        }
        return new com.byazt.cy.x(null);
    }
}
