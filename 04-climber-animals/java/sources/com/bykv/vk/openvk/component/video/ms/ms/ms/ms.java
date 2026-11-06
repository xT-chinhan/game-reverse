package com.bykv.vk.openvk.component.video.ms.ms.ms;

import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.ah.d;
import com.bytedance.sdk.component.utils.sl;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ms implements com.bykv.vk.openvk.component.video.api.ms.xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f54ms = "video_reward_full";
    private String xr = "video_brand";
    private String ah = "video_splash";
    private String d = "video_default";
    private String ka = null;
    private String c = null;
    private String ab = null;
    private String x = null;
    private String ny = null;

    @Override // com.bykv.vk.openvk.component.video.api.ms.xr
    public void ms(String str) {
        this.ka = str;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms.xr
    public String d() {
        if (this.ny == null) {
            this.ny = this.ka + File.separator + this.d;
            File file = new File(this.ny);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.ny;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms.xr
    public String ms() {
        if (this.c == null) {
            this.c = this.ka + File.separator + this.f54ms;
            File file = new File(this.c);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.c;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms.xr
    public String xr() {
        if (this.ab == null) {
            this.ab = this.ka + File.separator + this.xr;
            File file = new File(this.ab);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.ab;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms.xr
    public String ah() {
        if (this.x == null) {
            this.x = this.ka + File.separator + this.ah;
            File file = new File(this.x);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.x;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms.xr
    public synchronized void ka() {
        com.bykv.vk.openvk.component.video.api.c.ah.ms("Exec clear video cache ");
        com.bykv.vk.openvk.component.video.api.c.ah.ms(this.ka);
        Set<String> setAb = null;
        for (com.bykv.vk.openvk.component.video.api.ms.ms msVar : c()) {
            File[] fileArrMs = msVar.ms();
            if (fileArrMs != null && fileArrMs.length >= msVar.xr()) {
                if (setAb == null) {
                    setAb = ab();
                }
                int iXr = msVar.xr() - 2;
                if (iXr < 0) {
                    iXr = 0;
                }
                ms(msVar.ms(), iXr, setAb);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms.xr
    public boolean ms(d dVar) {
        if (TextUtils.isEmpty(dVar.ka()) || TextUtils.isEmpty(dVar.h())) {
            return false;
        }
        return new File(dVar.ka(), dVar.h()).exists();
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms.xr
    public long xr(d dVar) {
        if (TextUtils.isEmpty(dVar.ka()) || TextUtils.isEmpty(dVar.h())) {
            return 0L;
        }
        return com.bykv.vk.openvk.component.video.ms.ka.ah.ms(dVar.ka(), dVar.h());
    }

    private static void ms(File[] fileArr, int i, Set<String> set) {
        if (i >= 0 && fileArr != null) {
            try {
                if (fileArr.length > i) {
                    List listAsList = Arrays.asList(fileArr);
                    Collections.sort(listAsList, new Comparator<File>() { // from class: com.bykv.vk.openvk.component.video.ms.ms.ms.ms.1
                        @Override // java.util.Comparator
                        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
                        public int compare(File file, File file2) {
                            long jLastModified = file2.lastModified() - file.lastModified();
                            if (jLastModified == 0) {
                                return 0;
                            }
                            return jLastModified < 0 ? -1 : 1;
                        }
                    });
                    while (i < listAsList.size()) {
                        File file = (File) listAsList.get(i);
                        if (set != null && !set.contains(file.getAbsolutePath())) {
                            ((File) listAsList.get(i)).delete();
                        }
                        i++;
                    }
                }
            } catch (Throwable th) {
                sl.ms(th);
            }
        }
    }

    private List<com.bykv.vk.openvk.component.video.api.ms.ms> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.bykv.vk.openvk.component.video.api.ms.ms(new File(ms()).listFiles(), com.bykv.vk.openvk.component.video.ms.ms.ah()));
        arrayList.add(new com.bykv.vk.openvk.component.video.api.ms.ms(new File(ah()).listFiles(), com.bykv.vk.openvk.component.video.ms.ms.xr()));
        arrayList.add(new com.bykv.vk.openvk.component.video.api.ms.ms(new File(xr()).listFiles(), com.bykv.vk.openvk.component.video.ms.ms.d()));
        arrayList.add(new com.bykv.vk.openvk.component.video.api.ms.ms(new File(d()).listFiles(), com.bykv.vk.openvk.component.video.ms.ms.ka()));
        return arrayList;
    }

    private Set<String> ab() {
        HashSet hashSet = new HashSet();
        for (com.bykv.vk.openvk.component.video.ms.ms.ms msVar : com.bykv.vk.openvk.component.video.ms.ms.ms.f53ms.values()) {
            if (msVar != null && msVar.ms() != null) {
                d dVarMs = msVar.ms();
                hashSet.add(com.bykv.vk.openvk.component.video.ms.ka.ah.xr(dVarMs.ka(), dVarMs.h()).getAbsolutePath());
                hashSet.add(com.bykv.vk.openvk.component.video.ms.ka.ah.ah(dVarMs.ka(), dVarMs.h()).getAbsolutePath());
            }
        }
        for (com.bykv.vk.openvk.component.video.ms.ms.xr.xr xrVar : com.bykv.vk.openvk.component.video.ms.ms.xr.ah.f57ms.values()) {
            if (xrVar != null && xrVar.ms() != null) {
                d dVarMs2 = xrVar.ms();
                hashSet.add(com.bykv.vk.openvk.component.video.ms.ka.ah.xr(dVarMs2.ka(), dVarMs2.h()).getAbsolutePath());
                hashSet.add(com.bykv.vk.openvk.component.video.ms.ka.ah.ah(dVarMs2.ka(), dVarMs2.h()).getAbsolutePath());
            }
        }
        return hashSet;
    }
}
