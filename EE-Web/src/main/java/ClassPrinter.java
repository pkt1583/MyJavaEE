import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.List;

@Named("classPrinter")
@ApplicationScoped
public class ClassPrinter {
    public List<String> getClasses() {
        List<String> classes = new ArrayList<>();
        Instrumentation instrumentation = InstrumentationHook.getInstrumentation();
        for (Class<?> clazz : instrumentation.getAllLoadedClasses()) {
            StringBuilder classInfo=new StringBuilder();
            classInfo.append("Loaded ").append(clazz.getName()).append(" from classloader ").append(clazz.getClassLoader());
            classes.add(classInfo.toString());
        }
        return classes;
    }

    public ClassPrinter() {

    }
}
