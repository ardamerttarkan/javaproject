/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.algorithmsapp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author arda
 */
public class Scheduler {
     private List<Process> processes;

    public Scheduler() {
        this.processes = new ArrayList<>();
    }

    public void addProcess(Process process) {
        processes.add(process);
    }

    public void roundRobin(int quantum) {
        Queue<Process> queue = new LinkedList<>(processes);
        while (!queue.isEmpty()) {
            Process process = queue.poll();
            if (process.getBurstTime() > quantum) {
                System.out.println("Executing process: " + process.getId() + " for " + quantum + " units.");
                process.setBurstTime(process.getBurstTime() - quantum);
                queue.add(process);
            } else {
                System.out.println("Executing process: " + process.getId() + " for " + process.getBurstTime() + " units. Process completed.");
            }
        }
    }

    public void priorityScheduling() {
        processes.sort(Comparator.comparingInt(Process::getPriority));
        for (Process process : processes) {
            System.out.println("Executing process: " + process.getId() + " with priority " + process.getPriority());
        }
    }

    public void multiLevelQueueScheduling() {
        // Simplified example with two levels: high priority and low priority
        Queue<Process> highPriorityQueue = new LinkedList<>();
        Queue<Process> lowPriorityQueue = new LinkedList<>();

        for (Process process : processes) {
            if (process.getPriority() <= 5) {
                highPriorityQueue.add(process);
            } else {
                lowPriorityQueue.add(process);
            }
        }

        System.out.println("Executing high priority processes:");
        while (!highPriorityQueue.isEmpty()) {
            Process process = highPriorityQueue.poll();
            System.out.println("Executing process: " + process.getId() + " with priority " + process.getPriority());
        }

        System.out.println("Executing low priority processes:");
        while (!lowPriorityQueue.isEmpty()) {
            Process process = lowPriorityQueue.poll();
            System.out.println("Executing process: " + process.getId() + " with priority " + process.getPriority());
        }
    }
    
}
