package com.company;

public class Equations {
    String name;
    int answer;
    String timeStart;
    String timeEnd;
    int x;

    public Equations(String name, int answer, String timeStart, String timeEnd, int x) {
        this.name = name;
        this.answer = answer;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.x = x;
    }


      public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
