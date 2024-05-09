package deu.se.ood.beans.ch07;

import lombok.Getter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Getter
public class FileListBean {
    private String dirName;
    private List<String> relativeFileList = new ArrayList<>();
    private List<String> absoluteFileList = new ArrayList<>();

    public void setDirName(String dirName) {
        this.dirName = dirName;
        readDirectory();
    }

    private void readDirectory() {
        File dir = new File(dirName);

        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for(File file : files) {
                relativeFileList.add(file.getName());
                absoluteFileList.add(file.getAbsolutePath());
            }
        }
    }
}
