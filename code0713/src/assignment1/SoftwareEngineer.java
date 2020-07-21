package assignment1;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/13 20:05
 */
public class SoftwareEngineer extends Employee {

    private Integer hot;

    public SoftwareEngineer(Integer id, String name, Double salary, Integer hot) {
        super(id, name, salary);
        this.hot = hot;
    }


    @Override
    public String show() {
        return super.show() + ",hot=" + hot;
    }
    
}
