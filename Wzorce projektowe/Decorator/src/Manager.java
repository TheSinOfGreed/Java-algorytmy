public class Manager extends EmployeeDecorator {
    public Manager(Employee employee) {

        super(employee);
    }

    public void assignTask(Task task, TeamMember teamMember) {

        System.out.println("Zadanie przypisane ");

        teamMember.performTasks(task);
    }

}
