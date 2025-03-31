package my.rinat.testwithspringcourse.myrunner;

import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import java.util.List;

public class MyRunner extends BlockJUnit4ClassRunner {

    public MyRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @Override
    protected List<FrameworkMethod> getChildren() {
        System.out.println("My implementation of getChildren");
        List<FrameworkMethod> children = super.getChildren();
        System.out.println("children = " + children);
        return children;
    }

    @Override
    protected void runChild(FrameworkMethod method, RunNotifier notifier) {
        System.out.println("My implementation of runChild");
        super.runChild(method, notifier);
    }

    @Override
    protected Description describeChild(FrameworkMethod method) {
        System.out.println("My implementation of describeChild = " + method);
        return super.describeChild(method);
    }
}
