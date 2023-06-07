import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        tasks.add(new Task("Zabij tytana"));
        tasks.add(new Task("Uratuj Erena"));
        tasks.add(new Task("Przejmij tytana pierwotnego"));
        tasks.add(new Task("Zabierz konkordat"));

        TeamMember emp1 = new TeamMember(new EmployeeDecorator(new EmployeeImpl("Mikasa", "Ackermann")));
        Employee emp2 = new TeamMember(new EmployeeDecorator(new EmployeeImpl("Eren", "Yegar")));
        Employee emp3 = new TeamMember(new EmployeeDecorator(new EmployeeImpl("Armin", "Alert")));


        Manager emp6 = new Manager(new EmployeeDecorator(new EmployeeImpl("Zeke","Yegar")));

        emp1.join();
        emp2.join();
        emp3.join();

        emp6.assignTask(tasks.get(0),(TeamMember) emp1 );
        emp6.assignTask(tasks.get(1),(TeamMember) emp2 );
        emp6.assignTask(tasks.get(2),(TeamMember) emp3 );

    }
}
