/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fileapp;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author arda
 */
public class FileApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter total disk space (in bytes): ");
        int totalSpace = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        VirtualFileSystem vfs = new VirtualFileSystem(totalSpace);
        System.out.println("Virtual File System created with total space: " + vfs.getTotalSpace() + " bytes");

        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine();
            String[] parts = command.split(" ");
            String action = parts[0];

            switch (action) {
                case "createFile":
                    if (parts.length == 3) {
                        String path = parts[1];
                        String fileName = parts[2];
                        if (vfs.createFile(path, fileName)) {
                            System.out.println("File created successfully.");
                        } else {
                            System.out.println("Failed to create file.");
                        }
                    } else {
                        System.out.println("Usage: createFile <path> <fileName>");
                    }
                    break;
                case "createDirectory":
                    if (parts.length == 3) {
                        String path = parts[1];
                        String dirName = parts[2];
                        if (vfs.createDirectory(path, dirName)) {
                            System.out.println("Directory created successfully.");
                        } else {
                            System.out.println("Failed to create directory.");
                        }
                    } else {
                        System.out.println("Usage: createDirectory <path> <dirName>");
                    }
                    break;
                case "readFile":
                    if (parts.length == 3) {
                        String path = parts[1];
                        String fileName = parts[2];
                        String content = vfs.readFile(path, fileName);
                        if (content != null) {
                            System.out.println("File content: " + content);
                        } else {
                            System.out.println("Failed to read file.");
                        }
                    } else {
                        System.out.println("Usage: readFile <path> <fileName>");
                    }
                    break;
                case "writeFile":
                    if (parts.length == 4) {
                        String path = parts[1];
                        String fileName = parts[2];
                        String content = parts[3];
                        if (vfs.writeFile(path, fileName, content)) {
                            System.out.println("File written successfully.");
                        } else {
                            System.out.println("Failed to write file.");
                        }
                    } else {
                        System.out.println("Usage: writeFile <path> <fileName> <content>");
                    }
                    break;
                case "deleteFile":
                    if (parts.length == 3) {
                        String path = parts[1];
                        String fileName = parts[2];
                        if (vfs.deleteFile(path, fileName)) {
                            System.out.println("File deleted successfully.");
                        } else {
                            System.out.println("Failed to delete file.");
                        }
                    } else {
                        System.out.println("Usage: deleteFile <path> <fileName>");
                    }
                    break;
                case "deleteDirectory":
                    if (parts.length == 3) {
                        String path = parts[1];
                        String dirName = parts[2];
                        if (vfs.deleteDirectory(path, dirName)) {
                            System.out.println("Directory deleted successfully.");
                        } else {
                            System.out.println("Failed to delete directory.");
                        }
                    } else {
                        System.out.println("Usage: deleteDirectory <path> <dirName>");
                    }
                    break;
                case "listDirectory":
                    if (parts.length == 2) {
                        String path = parts[1];
                        List<String> items = vfs.listDirectory(path);
                        if (items != null) {
                            System.out.println("Directory contents: " + items);
                        } else {
                            System.out.println("Failed to list directory.");
                        }
                    } else {
                        System.out.println("Usage: listDirectory <path>");
                    }
                    break;
                case "exit":
                    scanner.close();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Unknown command.");
                    break;
            }
        }
    }
}
