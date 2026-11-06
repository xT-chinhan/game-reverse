package com.tapsdk.tapad.model.entities;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialInfo implements Parcelable {
    public static final Parcelable.Creator<MaterialInfo> CREATOR = new a();
    public final String description;
    public List<ImageInfo> imageInfoList;
    public final int materialType;
    public final String subTitle;
    public final String title;
    public List<VideoInfo> videoInfoList;

    static class a implements Parcelable.Creator<MaterialInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MaterialInfo createFromParcel(Parcel parcel) {
            return new MaterialInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MaterialInfo[] newArray(int i) {
            return new MaterialInfo[i];
        }
    }

    protected MaterialInfo(Parcel parcel) {
        this.imageInfoList = new ArrayList();
        this.videoInfoList = new ArrayList();
        this.title = parcel.readString();
        this.subTitle = parcel.readString();
        this.description = parcel.readString();
        this.materialType = parcel.readInt();
        this.imageInfoList = parcel.createTypedArrayList(ImageInfo.CREATOR);
        this.videoInfoList = parcel.createTypedArrayList(VideoInfo.CREATOR);
    }

    public MaterialInfo(TapAdResp.x xVar) {
        this.imageInfoList = new ArrayList();
        this.videoInfoList = new ArrayList();
        this.title = xVar.getTitle();
        this.subTitle = xVar.i0();
        this.description = xVar.getDescription();
        int iOrdinal = -1;
        int iIntValue = ((Integer) com.tapsdk.tapad.internal.j.a.b().a("material_type", Integer.class, -1)).intValue();
        if (iIntValue != -1) {
            iOrdinal = iIntValue;
        } else if (xVar.P0() != null) {
            iOrdinal = xVar.P0().ordinal();
        }
        this.materialType = iOrdinal;
        if (xVar.L5() > 0) {
            Iterator<TapAdResp.p> it = xVar.c5().iterator();
            while (it.hasNext()) {
                this.imageInfoList.add(new ImageInfo(it.next()));
            }
        }
        if (xVar.L0() <= 0) {
            ((Integer) com.tapsdk.tapad.internal.j.a.b().a("exp_set_half_video_ad", Integer.class, -1)).intValue();
            return;
        }
        Iterator<TapAdResp.h0> it2 = xVar.F().iterator();
        while (it2.hasNext()) {
            this.videoInfoList.add(new VideoInfo(it2.next()));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "MaterialInfo{title='" + this.title + "', subTitle='" + this.subTitle + "', description='" + this.description + "', materialType=" + this.materialType + ", imageInfoList=" + this.imageInfoList + ", videoInfoList=" + this.videoInfoList + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.subTitle);
        parcel.writeString(this.description);
        parcel.writeInt(this.materialType);
        parcel.writeTypedList(this.imageInfoList);
        parcel.writeTypedList(this.videoInfoList);
    }
}
