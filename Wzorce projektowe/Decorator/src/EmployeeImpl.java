public class EmployeeImpl implements Employee{
    private String name;
    private String surname;
    private boolean hired;

    public EmployeeImpl(String name, String surname){
        this.name = name;
        this.surname=surname;
        this.hired=false;
    }

    @Override
    public void join() {
        this.hired=true;
        System.out.println("Biore sie za zadanie.");
    }

    @Override
    public void terminate() {
        this.hired=false;
        System.out.println("Zad dużo, wychodzę.");
    }

    @Override
    public String toString() {
        return this.name + " " +this.surname;
    }
}
