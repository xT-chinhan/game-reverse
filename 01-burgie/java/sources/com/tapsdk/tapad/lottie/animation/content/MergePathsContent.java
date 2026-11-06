package com.tapsdk.tapad.lottie.animation.content;

import android.graphics.Path;
import android.os.Build;
import com.tapsdk.tapad.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes3.dex */
public class MergePathsContent implements PathContent, GreedyContent {
    private final MergePaths mergePaths;
    private final String name;
    private final Path firstPath = new Path();
    private final Path remainderPath = new Path();
    private final Path path = new Path();
    private final List<PathContent> pathContents = new ArrayList();

    /* JADX INFO: renamed from: com.tapsdk.tapad.lottie.animation.content.MergePathsContent$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tapsdk$tapad$lottie$model$content$MergePaths$MergePathsMode;

        static {
            int[] iArr = new int[MergePaths.MergePathsMode.values().length];
            $SwitchMap$com$tapsdk$tapad$lottie$model$content$MergePaths$MergePathsMode = iArr;
            try {
                iArr[MergePaths.MergePathsMode.Merge.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$tapsdk$tapad$lottie$model$content$MergePaths$MergePathsMode[MergePaths.MergePathsMode.Add.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$tapsdk$tapad$lottie$model$content$MergePaths$MergePathsMode[MergePaths.MergePathsMode.Subtract.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$tapsdk$tapad$lottie$model$content$MergePaths$MergePathsMode[MergePaths.MergePathsMode.Intersect.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$tapsdk$tapad$lottie$model$content$MergePaths$MergePathsMode[MergePaths.MergePathsMode.ExcludeIntersections.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public MergePathsContent(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.name = mergePaths.getName();
        this.mergePaths = mergePaths;
    }

    private void addPaths() {
        for (int i = 0; i < this.pathContents.size(); i++) {
            this.path.addPath(this.pathContents.get(i).getPath());
        }
    }

    private void opFirstPathWithRest(Path.Op op) {
        this.remainderPath.reset();
        this.firstPath.reset();
        for (int size = this.pathContents.size() - 1; size >= 1; size--) {
            PathContent pathContent = this.pathContents.get(size);
            if (pathContent instanceof ContentGroup) {
                ContentGroup contentGroup = (ContentGroup) pathContent;
                List<PathContent> pathList = contentGroup.getPathList();
                for (int size2 = pathList.size() - 1; size2 >= 0; size2--) {
                    Path path = pathList.get(size2).getPath();
                    path.transform(contentGroup.getTransformationMatrix());
                    this.remainderPath.addPath(path);
                }
            } else {
                this.remainderPath.addPath(pathContent.getPath());
            }
        }
        PathContent pathContent2 = this.pathContents.get(0);
        if (pathContent2 instanceof ContentGroup) {
            ContentGroup contentGroup2 = (ContentGroup) pathContent2;
            List<PathContent> pathList2 = contentGroup2.getPathList();
            for (int i = 0; i < pathList2.size(); i++) {
                Path path2 = pathList2.get(i).getPath();
                path2.transform(contentGroup2.getTransformationMatrix());
                this.firstPath.addPath(path2);
            }
        } else {
            this.firstPath.set(pathContent2.getPath());
        }
        this.path.op(this.firstPath, this.remainderPath, op);
    }

    @Override // com.tapsdk.tapad.lottie.animation.content.GreedyContent
    public void absorbContent(ListIterator<Content> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            Content contentPrevious = listIterator.previous();
            if (contentPrevious instanceof PathContent) {
                this.pathContents.add((PathContent) contentPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // com.tapsdk.tapad.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override // com.tapsdk.tapad.lottie.animation.content.PathContent
    public Path getPath() {
        this.path.reset();
        switch (AnonymousClass1.$SwitchMap$com$tapsdk$tapad$lottie$model$content$MergePaths$MergePathsMode[this.mergePaths.getMode().ordinal()]) {
            case 1:
                addPaths();
                break;
            case 2:
                opFirstPathWithRest(Path.Op.UNION);
                break;
            case 3:
                opFirstPathWithRest(Path.Op.REVERSE_DIFFERENCE);
                break;
            case 4:
                opFirstPathWithRest(Path.Op.INTERSECT);
                break;
            case 5:
                opFirstPathWithRest(Path.Op.XOR);
                break;
        }
        return this.path;
    }

    @Override // com.tapsdk.tapad.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < this.pathContents.size(); i++) {
            this.pathContents.get(i).setContents(list, list2);
        }
    }
}
