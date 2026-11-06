package com.byazt.ej;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsIsDownloadSource, 101})
public class fs implements x.n, Function {
    public volatile Function n;
    public volatile x.n qg;

    public fs(x.n nVar) {
        this.qg = nVar;
    }

    public fs(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                Object rvVar = sparseArray.get(1);
                if (rvVar != null) {
                    rvVar = new rv((Function) rvVar);
                }
                this.qg.n((x) rvVar);
                break;
            case 2:
                Object rvVar2 = sparseArray.get(1);
                Object obj2 = sparseArray.get(2);
                if (rvVar2 != null) {
                    rvVar2 = new rv((Function) rvVar2);
                }
                this.qg.n((x) rvVar2, ((Long) obj2).longValue());
                break;
            case 3:
                Object rvVar3 = sparseArray.get(1);
                if (rvVar3 != null) {
                    rvVar3 = new rv((Function) rvVar3);
                }
                this.qg.s((x) rvVar3);
                break;
            case 4:
                Object rvVar4 = sparseArray.get(1);
                Object qVar = sparseArray.get(2);
                if (rvVar4 != null) {
                    rvVar4 = new rv((Function) rvVar4);
                }
                if (qVar != null) {
                    qVar = new q((Function) qVar);
                }
                this.qg.n((x) rvVar4, (s) qVar);
                break;
            case 5:
                Object rvVar5 = sparseArray.get(1);
                Object obj3 = sparseArray.get(2);
                if (rvVar5 != null) {
                    rvVar5 = new rv((Function) rvVar5);
                }
                this.qg.n((x) rvVar5, ((Boolean) obj3).booleanValue());
                break;
            case 6:
                Object rvVar6 = sparseArray.get(1);
                if (rvVar6 != null) {
                    rvVar6 = new rv((Function) rvVar6);
                }
                this.qg.q((x) rvVar6);
                break;
            case 7:
                Object rvVar7 = sparseArray.get(1);
                Object obj4 = sparseArray.get(2);
                Object obj5 = sparseArray.get(3);
                if (rvVar7 != null) {
                    rvVar7 = new rv((Function) rvVar7);
                }
                this.qg.n((x) rvVar7, ((Integer) obj4).intValue(), ((Integer) obj5).intValue());
                break;
            case 8:
                Object rvVar8 = sparseArray.get(1);
                Object obj6 = sparseArray.get(2);
                Object obj7 = sparseArray.get(3);
                Object obj8 = sparseArray.get(4);
                if (rvVar8 != null) {
                    rvVar8 = new rv((Function) rvVar8);
                }
                this.qg.n((x) rvVar8, ((Integer) obj6).intValue(), ((Integer) obj7).intValue(), ((Integer) obj8).intValue());
                break;
            case 9:
                Object rvVar9 = sparseArray.get(1);
                Object obj9 = sparseArray.get(2);
                if (rvVar9 != null) {
                    rvVar9 = new rv((Function) rvVar9);
                }
                this.qg.n((x) rvVar9, ((Integer) obj9).intValue());
                break;
            case 10:
                Object rvVar10 = sparseArray.get(1);
                Object obj10 = sparseArray.get(2);
                if (rvVar10 != null) {
                    rvVar10 = new rv((Function) rvVar10);
                }
                this.qg.qg((x) rvVar10, ((Integer) obj10).intValue());
                break;
            case 11:
                Object rvVar11 = sparseArray.get(1);
                Object obj11 = sparseArray.get(2);
                Object obj12 = sparseArray.get(3);
                if (rvVar11 != null) {
                    rvVar11 = new rv((Function) rvVar11);
                }
                this.qg.n((x) rvVar11, ((Long) obj11).longValue(), ((Long) obj12).longValue());
                break;
            case 12:
                Object rvVar12 = sparseArray.get(1);
                Object obj13 = sparseArray.get(2);
                Object obj14 = sparseArray.get(3);
                if (rvVar12 != null) {
                    rvVar12 = new rv((Function) rvVar12);
                }
                this.qg.n((x) rvVar12, (JSONObject) obj13, (String) obj14);
                break;
            case 13:
                Object rvVar13 = sparseArray.get(1);
                if (rvVar13 != null) {
                    rvVar13 = new rv((Function) rvVar13);
                }
                this.qg.l((x) rvVar13);
                break;
            case 14:
                Object rvVar14 = sparseArray.get(1);
                if (rvVar14 != null) {
                    rvVar14 = new rv((Function) rvVar14);
                }
                this.qg.w((x) rvVar14);
                break;
            case 15:
                Object rvVar15 = sparseArray.get(1);
                if (rvVar15 != null) {
                    rvVar15 = new rv((Function) rvVar15);
                }
                this.qg.qg((x) rvVar15);
                break;
        }
        return null;
    }

    public boolean equals(Object obj) {
        Object obj2;
        if (obj == null) {
            return false;
        }
        if (this.n != null) {
            obj2 = this.n;
        } else {
            if (this.qg == null) {
                return super.equals(obj);
            }
            obj2 = this.qg;
        }
        return obj.equals(obj2);
    }

    public int hashCode() {
        Object obj;
        if (this.n != null) {
            obj = this.n;
        } else {
            if (this.qg == null) {
                return super.hashCode();
            }
            obj = this.qg;
        }
        return obj.hashCode();
    }

    @Override // com.byazt.ej.x.n
    public void l(x xVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        if (xVar != null) {
            xVar = new rv(xVar);
        }
        sparseArray.put(1, xVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x.n
    public void n(x xVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (xVar != null) {
            xVar = new rv(xVar);
        }
        sparseArray.put(1, xVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x.n
    public void n(x xVar, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        if (xVar != null) {
            xVar = new rv(xVar);
        }
        sparseArray.put(1, xVar);
        sparseArray.put(2, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x.n
    public void n(x xVar, int i, int i2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        if (xVar != null) {
            xVar = new rv(xVar);
        }
        sparseArray.put(1, xVar);
        sparseArray.put(2, Integer.valueOf(i));
        sparseArray.put(3, Integer.valueOf(i2));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x.n
    public void n(x xVar, int i, int i2, int i3) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        if (xVar != null) {
            xVar = new rv(xVar);
        }
        sparseArray.put(1, xVar);
        sparseArray.put(2, Integer.valueOf(i));
        sparseArray.put(3, Integer.valueOf(i2));
        sparseArray.put(4, Integer.valueOf(i3));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x.n
    public void n(x xVar, long j) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        if (xVar != null) {
            xVar = new rv(xVar);
        }
        sparseArray.put(1, xVar);
        sparseArray.put(2, Long.valueOf(j));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x.n
    public void n(x xVar, long j, long j2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        if (xVar != null) {
            xVar = new rv(xVar);
        }
        sparseArray.put(1, xVar);
        sparseArray.put(2, Long.valueOf(j));
        sparseArray.put(3, Long.valueOf(j2));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x.n
    public void n(x xVar, s sVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        if (xVar != null) {
            xVar = new rv(xVar);
        }
        sparseArray.put(1, xVar);
        if (sVar != null) {
            sVar = new q(sVar);
        }
        sparseArray.put(2, sVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x.n
    public void n(x xVar, JSONObject jSONObject, String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        if (xVar != null) {
            xVar = new rv(xVar);
        }
        sparseArray.put(1, xVar);
        sparseArray.put(2, jSONObject);
        sparseArray.put(3, str);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x.n
    public void n(x xVar, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        if (xVar != null) {
            xVar = new rv(xVar);
        }
        sparseArray.put(1, xVar);
        sparseArray.put(2, Boolean.valueOf(z));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x.n
    public void q(x xVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        if (xVar != null) {
            xVar = new rv(xVar);
        }
        sparseArray.put(1, xVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x.n
    public void qg(x xVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        if (xVar != null) {
            xVar = new rv(xVar);
        }
        sparseArray.put(1, xVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x.n
    public void qg(x xVar, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        if (xVar != null) {
            xVar = new rv(xVar);
        }
        sparseArray.put(1, xVar);
        sparseArray.put(2, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x.n
    public void s(x xVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        if (xVar != null) {
            xVar = new rv(xVar);
        }
        sparseArray.put(1, xVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.x.n
    public void w(x xVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        if (xVar != null) {
            xVar = new rv(xVar);
        }
        sparseArray.put(1, xVar);
        this.n.apply(sparseArray);
    }
}
