package day8.oop2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapExample {
    static List<Employee> workers = List.of(new Employee(1, "Jordan"),
            new Employee(2, "Coco"),
            new Employee(3, "Comtin"),
            new Employee(4, "Yoda"));
    static Map<Integer, Employee> workerMap = new HashMap<>();

    static {
        for (Employee worker : workers) {   // m
            workerMap.put(worker.getEmpNo(), worker);
        }
    }

    public static void main(String[] args) {
        Employee emp1 = findWorkerByEmpNo(1);   //1
        Employee emp2 = findWorkerByEmpNo(2);   //1
        Employee emp3 = findWorkerByEmpNo(3);   //1
        Employee emp4 = findWorkerByEmpNo(4);   //1
        System.out.println(emp4);
    }

    private static Employee findWorkerByEmpNo(Integer empNo) {
//        for (Employee worker : workers) {
//            if (worker.getEmpNo().equals(empNo)) {
//                return worker;
//            }
//        }
//        return null;      //리스트 순회하는 비용이 크다. 줄이는 방법 -> map 이용하기.
        Map<Integer, Employee> map = new HashMap<>();
//        for (Employee worker : workers) {
//            map.put(worker.getEmpNo(), worker);
//        }     //  좀 더 줄이는 방법. 위에서 1번 돌기.
//        return map.get(empNo);
        return workerMap.get(empNo);
    }

    static class Employee implements Comparable<Employee> {
        private Integer empNo;
        private String name;

        public Employee(Integer empNo, String name) {
            this.empNo = empNo;
            this.name = name;
        }

        public Integer getEmpNo() {
            return empNo;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "empNo=" + empNo +
                    ", name='" + name + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Employee o) {
            return this.empNo - o.empNo;
        }
    }
}

