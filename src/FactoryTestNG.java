import org.testng.annotations.Factory;

public class FactoryTestNG {
    @Factory()
    public Object[] getTestClasses() {
        Object[] tests = new Object[2];
        tests[0] = new LoginTest();
        tests[1] = new LoginFailTest();
        return tests;
    }
}
