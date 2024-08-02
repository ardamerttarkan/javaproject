package com.mycompany.fileapp;


import com.mycompany.fileapp.File;
import com.mycompany.fileapp.Directory;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author arda
 */
public class VirtualFileSystem {
      private Directory root;
    private int totalSpace;
    private int usedSpace;

    public VirtualFileSystem(int totalSpace) {
        this.root = new Directory("root");
        this.totalSpace = totalSpace;
        this.usedSpace = 0;
    }

    public Directory getRoot() {
        return root;
    }

    public int getTotalSpace() {
        return totalSpace;
    }

    public int getUsedSpace() {
        return usedSpace;
    }

    public boolean createFile(String path, String fileName) {
        Directory dir = navigateToDirectory(path);
        if (dir != null && !dir.getFiles().containsKey(fileName)) {
            dir.addFile(new File(fileName));
            return true;
        }
        return false;
    }

    public boolean createDirectory(String path, String dirName) {
        Directory dir = navigateToDirectory(path);
        if (dir != null && !dir.getDirectories().containsKey(dirName)) {
            dir.addDirectory(new Directory(dirName));
            return true;
        }
        return false;
    }

    public String readFile(String path, String fileName) {
        Directory dir = navigateToDirectory(path);
        if (dir != null && dir.getFiles().containsKey(fileName)) {
            return dir.getFiles().get(fileName).getContent();
        }
        return null;
    }

    public boolean writeFile(String path, String fileName, String content) {
        Directory dir = navigateToDirectory(path);
        if (dir != null && dir.getFiles().containsKey(fileName)) {
            File file = dir.getFiles().get(fileName);
            int newSize = content.length();
            int oldSize = file.getContent().length();
            if (usedSpace - oldSize + newSize <= totalSpace) {
                file.writeContent(content);
                usedSpace = usedSpace - oldSize + newSize;
                return true;
            }
        }
        return false;
    }

    public boolean deleteFile(String path, String fileName) {
        Directory dir = navigateToDirectory(path);
        if (dir != null && dir.getFiles().containsKey(fileName)) {
            File file = dir.getFiles().get(fileName);
            usedSpace -= file.getContent().length();
            dir.removeFile(fileName);
            return true;
        }
        return false;
    }

    public boolean deleteDirectory(String path, String dirName) {
        Directory dir = navigateToDirectory(path);
        if (dir != null && dir.getDirectories().containsKey(dirName)) {
            Directory subDir = dir.getDirectories().get(dirName);
            usedSpace -= calculateDirectorySize(subDir);
            dir.removeDirectory(dirName);
            return true;
        }
        return false;
    }

    public List<String> listDirectory(String path) {
        Directory dir = navigateToDirectory(path);
        if (dir != null) {
            List<String> items = new ArrayList<>();
            items.addAll(dir.getFiles().keySet());
            items.addAll(dir.getDirectories().keySet());
            return items;
        }
        return null;
    }

    private Directory navigateToDirectory(String path) {
        String[] parts = path.split("/");
        Directory current = root;
        for (String part : parts) {
            if (!part.isEmpty()) {
                if (current.getDirectories().containsKey(part)) {
                    current = current.getDirectories().get(part);
                } else {
                    return null;
                }
            }
        }
        return current;
    }

    private int calculateDirectorySize(Directory dir) {
        int size = 0;
        for (File file : dir.getFiles().values()) {
            size += file.getContent().length();
        }
        for (Directory subDir : dir.getDirectories().values()) {
            size += calculateDirectorySize(subDir);
        }
        return size;
    }
    
}
