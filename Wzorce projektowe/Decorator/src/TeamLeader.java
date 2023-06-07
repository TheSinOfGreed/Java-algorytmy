public class TeamLeader extends EmployeeDecorator{
    public TeamLeader(EmployeeImpl employee){

        super(employee);
    }
    public void planning(){
        System.out.println("planuje");

    }

    public void motivate(){
        System.out.println("motywuje");

    }
}
