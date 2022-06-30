import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("PostProcessor.xml");
        context.getBean(NetworkElements.class).printNE();
    }

}
