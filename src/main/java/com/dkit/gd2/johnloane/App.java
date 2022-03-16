package com.dkit.gd2.johnloane;

import java.lang.reflect.Array;
import java.util.*;

/**
 * OOP CA3
 * @author John Loane
 */
public class App 
{
    public static void main( String[] args )
    {


        //Question 1
        List<Student> students = new ArrayList<>();
        questionOnePartA(students);
        questionOnePartB(students);
        questionOnePartC(students);
        questionOnePartD(students);

        //Question 2
        List<Employee> employees = new ArrayList<>();
        Set<String> uniqueName = new HashSet<>();
        Map<String, Integer> nameAndCount = new HashMap<>();
        Queue<Employee> waitingList = new LinkedList<>();

        questionTwoPartA(employees);
        questionTwoPartB(employees, uniqueName);
        questionTwoPartC(employees, nameAndCount);
        questionTwoPartD(employees,waitingList);

        //Question 3
        List<String> oneHundredStrings = new ArrayList<>();
        List<String> oneHundredStringsWithoutDublicates = new ArrayList<>();

        populateOneHundredStrings(oneHundredStrings);
        questionThreePartA(oneHundredStrings);
        questionThreePartB();

        //Question 4
        compareTwoStudents();
        questionFourPartA();
        questionFourPartB();
        //questionFourPartC();
    }

    //The method below relates to Question 4
    private static void compareTwoStudents()
    {
        Student alex1 = new Student(1, "Alex", 22);
        Student alex2 = new Student(1, "Alex", 22);
        System.out.println("alex1 hashcode = " + alex1.hashCode());
        System.out.println("alex2 hashcode = " + alex2.hashCode());
        System.out.println("Checking equality between alex1 and alex2 = " + alex1.equals(alex2));
    }

    //This is just a helper method to populate the list of strings for question 3. You do not need to read it to answer any of the questions in the CA
    private static void populateOneHundredStrings(List<String> oneHundredStrings)
    {
        Set<String> language = new HashSet<>();
        for(int i=0; i < 100; i++)
        {
            if(i / 10 == 0)
            {
                oneHundredStrings.add("Java");
            }
            else if(i / 10 == 1)
            {
                oneHundredStrings.add("Python");
            }
            else if(i / 10 == 2)
            {
                oneHundredStrings.add("C++");
            }
            else if(i / 10 == 3)
            {
                oneHundredStrings.add("Javascript");
            }
            else if(i / 10 == 4)
            {
                oneHundredStrings.add("Ruby");
            }
            else if(i / 10 == 5)
            {
                oneHundredStrings.add("Golang");
            }
            else if(i / 10 == 6)
            {
                oneHundredStrings.add("C#");
            }
            else if(i / 10 == 7)
            {
                oneHundredStrings.add("C");
            }
            else if(i / 10 == 8)
            {
                oneHundredStrings.add("R");
            }
            else if(i / 10 == 9)
            {
                oneHundredStrings.add("Swift");
            }
        }
    }

    public static void questionOnePartA(List<Student> students){
        Student s1 = new Student(1,"Tanish", 19);
        Student s2 = new Student(2,"John", 20);
        Student s3 = new Student(3,"Roy", 18);
        Student s4 = new Student(4,"James", 21);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
    }
    public static void questionOnePartB(List<Student> students){
        System.out.println("sort by Name");
        Collections.sort(students);
        System.out.println("After sorting: ");
        for(Student s : students)
        {
            System.out.println(s);
        }
    }
    public static void questionOnePartC(List<Student> students){
        System.out.println("sort by Age");
        Collections.sort(students, new AgeComparator());
        for(Student s : students)
        {
            System.out.println(s);
        }
    }
    public static void questionOnePartD(List<Student> students){
        // The time complexity of adding students to an ArrayList is O(1)
        // The space complexity of this operation would be O(n), where n is the number of students to be added.

        // The time complexity of Java's Collections.sort() algorithm (which uses merge sort) is O(nlog(n)).
        // The space complexity of merge sort is O(n), so it depends linearly on the number of elements in the list.
    }
    public static void questionTwoPartA(List<Employee> employees){
        Employee e1 = new Employee("Tomas", "Madigan");
        Employee e2 = new Employee("Ardghal", "Clancy");
        Employee e3 = new Employee("Garvan", "Mullen");
        Employee e4 = new Employee("Keelan", "Conmara");
        Employee e5 = new Employee("John", "Fallon");
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        pickLuckyWinner(employees);
    }
    private static void pickLuckyWinner(List<Employee> employees){

        Random r = new Random();
        int randomName = r.nextInt(employees.size());

        System.out.println("Details of winner: ");
        System.out.println(employees.get(randomName));
    }

    public static void questionTwoPartB(List<Employee> employees, Set<String> uniqueName){
        for(Employee employee : employees)
        {
            uniqueName.add(employee.getFirstName());
        }

        printUniqueNames(uniqueName);
    }
    private static void printUniqueNames(Set<String> uniqueNames)
    {
        System.out.println("Displaying the set of unique first names:");
        for(String name : uniqueNames)
        {
            System.out.println(name);
        }
    }

    public static void questionTwoPartC(List<Employee> employees, Map<String, Integer> nameAndCount){
        for(Employee e : employees)
        {
            String firstName = e.getFirstName();

            if(nameAndCount.containsKey(firstName))
            {
                nameAndCount.put(firstName, nameAndCount.get(firstName) + 1);
            }
            else
            {
                nameAndCount.put(firstName, 1);
            }
        }

        printNameAndCount(nameAndCount);
    }

    private static void printNameAndCount(Map<String, Integer> nameAndCount)
    {
        for(String name : nameAndCount.keySet())
        {
            System.out.println(name + " : " + nameAndCount.get(name));
        }
    }

    public static void questionTwoPartD(List<Employee> employees, Queue<Employee> waitingList){
        System.out.println("\nQuestion 2 Part D:\n");


        waitingList.addAll(employees);

        Employee nextOnWaitingList = getNextOnWaitingList(waitingList);

        int waitingListSize = waitingList.size();

        for(int i = 0; i < waitingListSize; i++)
        {
            System.out.println("The employee that is next on the waiting list is: " + nextOnWaitingList);
        }
    }

    private static Employee getNextOnWaitingList(Queue<Employee> waitingList)
    {
        Employee nextEmployee = waitingList.poll();

        if(nextEmployee == null)
        {
            System.out.println("There are no more employees in the queue.");
            return null;
        }

        return nextEmployee;
    }

    public static void questionThreePartA(List<String> oneHundredStrings){

        Set<String> uniqueStrings = new HashSet<>();

        for(int i = 0; i < oneHundredStrings.size(); i++)
        {
            if(uniqueStrings.contains(oneHundredStrings.get(i)))
            {
                oneHundredStrings.remove(i);
                i--;
            }
            else
            {
                uniqueStrings.add(oneHundredStrings.get(i));
            }

            if(!uniqueStrings.add(oneHundredStrings.get(i)))
            {
                oneHundredStrings.remove(i);
                i--;
            }

        }

    }
    public static void questionThreePartB(){
        // we have used hash set in this to remove duplicates from the list.
        // The time complexity of this solution is O(n), where n is the number of elements in the list.
        //  It is O(n) because we are only iterating through the List once.
    }
    public static void questionFourPartA(){
        //This method returns false as the equals and hashCode methods from the Object class
        //The two Students to be equal if their memory address is equal.
    }
    public static void questionFourPartB(){
        //The hashCode() method from the object class hashes objects based on their memory address.
        //So, their hashCodes are also different because their memory addresses are different.
    }

}
