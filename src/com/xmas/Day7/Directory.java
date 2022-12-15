package com.xmas.Day7;

import java.util.ArrayList;
import java.util.HashMap;

public class Directory {
    private final HashMap<String, Directory> childDirs = new HashMap<>();
    private final ArrayList<File> files = new ArrayList<>();
    private final String name;
    private final Directory headDirectory;
    private int size;

    public Directory(String name, Directory headDirectory) {
        this.name = name;
        this.headDirectory = headDirectory;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public Directory getHeadDirectory() {
        return headDirectory;
    }

    public void addDirectory(Directory dir) {
        childDirs.put(dir.getName(), dir);
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void setSize() {
        for (File file : files)
            size += file.size();

        for (Directory dir : childDirs.values()) {
            dir.setSize();
            size += dir.getSize();
        }
    }

    public Directory findDir(String name) {
        return childDirs.get(name);
    }


    public void findSmallDirs(int n) {
        if (size <= n)
            Day7.total += size;

        for (Directory dir : childDirs.values())
            dir.findSmallDirs(n);

    }

    public void getRidOfSmallestDir(long currentTotal) {
        if (Day7.smallestDirSize == null && size + currentTotal >= 30000000)
            Day7.smallestDirSize = (long) size;
        else if (size + currentTotal >= 30000000 && (long) size < Day7.smallestDirSize)
            Day7.smallestDirSize = (long) size;

        for (Directory dir : childDirs.values())
            dir.getRidOfSmallestDir(currentTotal);


    }
}
