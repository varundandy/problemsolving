package com.datastructures.patterns.patterns.stacks;

import java.util.*;
import java.util.stream.Collectors;

public class ExecutionTimeFunctions {

    public static void main(String args[]) {

        String[] inputs = {"0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"};
        int n = 1;
        List<String> logs = Arrays.stream(inputs).toList();
        List<Integer> result = calculateExecutionTime(n, logs);
        result.stream().forEach(System.out::println);
    }

    public static List<Integer> calculateExecutionTime(int n, List<String> events) {
        Stack<Event> stack = new Stack<>();
        List<Integer> result = new ArrayList<Integer>(Collections.nCopies(n, 0));
        for (String content : events) {
            Event event = new Event(content);
            if (event.getIsStart()) {
                stack.push(event);
            } else {
                Event top = stack.pop();
                result.set(top.getId(), result.get(top.getId()) + (event.getTime() - top.getTime() + 1));
                if (!stack.isEmpty()) {
                    result.set(stack.peek().getId(), result.get(stack.peek().getId()) - (event.getTime() - top.getTime() + 1));
                }
            }
        }
        return result;
    }

    public static class Event {

        private int id;
        private boolean isStart;
        private int time;

        public Event(String content) {
            String[] strs = content.split(":");
            this.id = Integer.valueOf(strs[0]);
            this.isStart = strs[1].equals("start");
            this.time = Integer.valueOf(strs[2]);
        }

        public int getId() {
            return this.id;
        }

        public boolean getIsStart() {
            return this.isStart;
        }

        public int getTime() {
            return this.time;
        }

    }
}
