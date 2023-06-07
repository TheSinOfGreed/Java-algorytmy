import java.util.List;

public class TeamMember extends EmployeeDecorator {

    public TeamMember(Employee employee){
        super(employee);
    }

    public void performTasks(Task task){
        while(task.getProgress()!=100){
            task.setProgress(task.getProgress()+1);
            if(task.getProgress()%5==0){
                System.out.println("Pracuje nad zadaniem, aktualny progress: "+task.getProgress());
            }

        }
    }

    @Override
    public EmployeeImpl getEmployee() {

        return super.getEmployee();
    }
}
