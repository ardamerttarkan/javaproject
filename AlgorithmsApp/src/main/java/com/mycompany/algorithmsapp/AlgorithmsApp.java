/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.algorithmsapp;

import java.util.Scanner;

/**
 *
 * @author arda
 */
public class AlgorithmsApp {

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        Scheduler scheduler = new Scheduler();

        System.out.println("Enter number of processes:");
        int numProcesses = scanner.nextInt();

        for (int i = 0; i < numProcesses; i++) {
            System.out.println("Enter process ID, priori    ty, and burst time:");
            int id = scanner.nextInt();
            int priority = scanner.nextInt();
            int burstTime = scanner.nextInt();
            scheduler.addProcess(new Process(id, priority, burstTime));
        }

        System.out.println("Choose scheduling algorithm: 1. Round Robin 2. Priority Scheduling 3. Multi-Level Queue Scheduling");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter time quantum:");
                int quantum = scanner.nextInt();
                scheduler.roundRobin(quantum);
                break;
            case 2:
                scheduler.priorityScheduling();
                break;
            case 3:
                scheduler.multiLevelQueueScheduling();
                break;
            default:
                System.out.println("Invalid choice.");
        }

        scanner.close();
        
    }
}
