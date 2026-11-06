package com.byazt.ihe;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 588, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo implements fw.pr, Function {
    public volatile fw.pr hw;
    public volatile Function pr;

    public zo(fw.pr prVar) {
        this.hw = prVar;
    }

    public zo(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                Object ajVar = sparseArray.get(1);
                if (ajVar != null) {
                    ajVar = new aj((Function) ajVar);
                }
                this.hw.pr((fw) ajVar);
                break;
            case 2:
                Object ajVar2 = sparseArray.get(1);
                Object obj2 = sparseArray.get(2);
                if (ajVar2 != null) {
                    ajVar2 = new aj((Function) ajVar2);
                }
                this.hw.pr((fw) ajVar2, ((Long) obj2).longValue());
                break;
            case 3:
                Object ajVar3 = sparseArray.get(1);
                if (ajVar3 != null) {
                    ajVar3 = new aj((Function) ajVar3);
                }
                this.hw.hn((fw) ajVar3);
                break;
            case 4:
                Object ajVar4 = sparseArray.get(1);
                Object xVar = sparseArray.get(2);
                if (ajVar4 != null) {
                    ajVar4 = new aj((Function) ajVar4);
                }
                if (xVar != null) {
                    xVar = new x((Function) xVar);
                }
                this.hw.pr((fw) ajVar4, (hn) xVar);
                break;
            case 5:
                Object ajVar5 = sparseArray.get(1);
                Object obj3 = sparseArray.get(2);
                if (ajVar5 != null) {
                    ajVar5 = new aj((Function) ajVar5);
                }
                this.hw.pr((fw) ajVar5, ((Boolean) obj3).booleanValue());
                break;
            case 6:
                Object ajVar6 = sparseArray.get(1);
                if (ajVar6 != null) {
                    ajVar6 = new aj((Function) ajVar6);
                }
                this.hw.x((fw) ajVar6);
                break;
            case 7:
                Object ajVar7 = sparseArray.get(1);
                Object obj4 = sparseArray.get(2);
                Object obj5 = sparseArray.get(3);
                if (ajVar7 != null) {
                    ajVar7 = new aj((Function) ajVar7);
                }
                this.hw.pr((fw) ajVar7, ((Integer) obj4).intValue(), ((Integer) obj5).intValue());
                break;
            case 8:
                Object ajVar8 = sparseArray.get(1);
                Object obj6 = sparseArray.get(2);
                Object obj7 = sparseArray.get(3);
                Object obj8 = sparseArray.get(4);
                if (ajVar8 != null) {
                    ajVar8 = new aj((Function) ajVar8);
                }
                this.hw.pr((fw) ajVar8, ((Integer) obj6).intValue(), ((Integer) obj7).intValue(), ((Integer) obj8).intValue());
                break;
            case 9:
                Object ajVar9 = sparseArray.get(1);
                Object obj9 = sparseArray.get(2);
                if (ajVar9 != null) {
                    ajVar9 = new aj((Function) ajVar9);
                }
                this.hw.pr((fw) ajVar9, ((Integer) obj9).intValue());
                break;
            case 10:
                Object ajVar10 = sparseArray.get(1);
                Object obj10 = sparseArray.get(2);
                if (ajVar10 != null) {
                    ajVar10 = new aj((Function) ajVar10);
                }
                this.hw.hw((fw) ajVar10, ((Integer) obj10).intValue());
                break;
            case 11:
                Object ajVar11 = sparseArray.get(1);
                Object obj11 = sparseArray.get(2);
                Object obj12 = sparseArray.get(3);
                if (ajVar11 != null) {
                    ajVar11 = new aj((Function) ajVar11);
                }
                this.hw.pr((fw) ajVar11, ((Long) obj11).longValue(), ((Long) obj12).longValue());
                break;
            case 12:
                Object ajVar12 = sparseArray.get(1);
                Object obj13 = sparseArray.get(2);
                Object obj14 = sparseArray.get(3);
                if (ajVar12 != null) {
                    ajVar12 = new aj((Function) ajVar12);
                }
                this.hw.pr((fw) ajVar12, (JSONObject) obj13, (String) obj14);
                break;
            case 13:
                Object ajVar13 = sparseArray.get(1);
                if (ajVar13 != null) {
                    ajVar13 = new aj((Function) ajVar13);
                }
                this.hw.c((fw) ajVar13);
                break;
            case 14:
                Object ajVar14 = sparseArray.get(1);
                if (ajVar14 != null) {
                    ajVar14 = new aj((Function) ajVar14);
                }
                this.hw.uc((fw) ajVar14);
                break;
            case 15:
                Object ajVar15 = sparseArray.get(1);
                if (ajVar15 != null) {
                    ajVar15 = new aj((Function) ajVar15);
                }
                this.hw.hw((fw) ajVar15);
                break;
        }
        return null;
    }

    @Override // com.byazt.ihe.fw.pr
    public void c(fw fwVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        if (fwVar != null) {
            fwVar = new aj(fwVar);
        }
        sparseArray.put(1, fwVar);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw.pr
    public void hn(fw fwVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        if (fwVar != null) {
            fwVar = new aj(fwVar);
        }
        sparseArray.put(1, fwVar);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw.pr
    public void hw(fw fwVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        if (fwVar != null) {
            fwVar = new aj(fwVar);
        }
        sparseArray.put(1, fwVar);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw.pr
    public void hw(fw fwVar, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        if (fwVar != null) {
            fwVar = new aj(fwVar);
        }
        sparseArray.put(1, fwVar);
        sparseArray.put(2, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw.pr
    public void pr(fw fwVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (fwVar != null) {
            fwVar = new aj(fwVar);
        }
        sparseArray.put(1, fwVar);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw.pr
    public void pr(fw fwVar, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        if (fwVar != null) {
            fwVar = new aj(fwVar);
        }
        sparseArray.put(1, fwVar);
        sparseArray.put(2, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw.pr
    public void pr(fw fwVar, int i, int i2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        if (fwVar != null) {
            fwVar = new aj(fwVar);
        }
        sparseArray.put(1, fwVar);
        sparseArray.put(2, Integer.valueOf(i));
        sparseArray.put(3, Integer.valueOf(i2));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw.pr
    public void pr(fw fwVar, int i, int i2, int i3) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        if (fwVar != null) {
            fwVar = new aj(fwVar);
        }
        sparseArray.put(1, fwVar);
        sparseArray.put(2, Integer.valueOf(i));
        sparseArray.put(3, Integer.valueOf(i2));
        sparseArray.put(4, Integer.valueOf(i3));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw.pr
    public void pr(fw fwVar, long j) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        if (fwVar != null) {
            fwVar = new aj(fwVar);
        }
        sparseArray.put(1, fwVar);
        sparseArray.put(2, Long.valueOf(j));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw.pr
    public void pr(fw fwVar, long j, long j2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        if (fwVar != null) {
            fwVar = new aj(fwVar);
        }
        sparseArray.put(1, fwVar);
        sparseArray.put(2, Long.valueOf(j));
        sparseArray.put(3, Long.valueOf(j2));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw.pr
    public void pr(fw fwVar, hn hnVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        if (fwVar != null) {
            fwVar = new aj(fwVar);
        }
        sparseArray.put(1, fwVar);
        if (hnVar != null) {
            hnVar = new x(hnVar);
        }
        sparseArray.put(2, hnVar);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw.pr
    public void pr(fw fwVar, JSONObject jSONObject, String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        if (fwVar != null) {
            fwVar = new aj(fwVar);
        }
        sparseArray.put(1, fwVar);
        sparseArray.put(2, jSONObject);
        sparseArray.put(3, str);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw.pr
    public void pr(fw fwVar, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        if (fwVar != null) {
            fwVar = new aj(fwVar);
        }
        sparseArray.put(1, fwVar);
        sparseArray.put(2, Boolean.valueOf(z));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw.pr
    public void uc(fw fwVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        if (fwVar != null) {
            fwVar = new aj(fwVar);
        }
        sparseArray.put(1, fwVar);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.fw.pr
    public void x(fw fwVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        if (fwVar != null) {
            fwVar = new aj(fwVar);
        }
        sparseArray.put(1, fwVar);
        this.pr.apply(sparseArray);
    }
}
