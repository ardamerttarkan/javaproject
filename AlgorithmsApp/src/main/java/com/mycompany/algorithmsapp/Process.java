/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.algorithmsapp;

/**
 *
 * @author arda
 */
public class Process {
     private int id;
    private int priority;
    private int burstTime;

    public Process(int id, int priority, int burstTime) {
        this.id = id;
        this.priority = priority;
        this.burstTime = burstTime;
    }

    public int getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    @Override
    public String toString() {
        return "Process{" +
                "id=" + id +
                ", priority=" + priority +
                ", burstTime=" + burstTime +
                '}';
    }
    
}
