public class EmployeeDecorator implements Employee{
    private Employee employee;

    public EmployeeDecorator(Employee employee){
        this.employee=employee;
    }
    @Override
    public void join() {
        employee.join();
    }
    @Override
    public void terminate() {
        employee.terminate();
    }
    public EmployeeImpl getEmployee() {
        return  (EmployeeImpl) employee;
    }
    public void setEmployee(EmployeeImpl employee) {
        this.employee = employee;
    }
}
