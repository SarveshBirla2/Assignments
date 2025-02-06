import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.graalvm.polyglot.*;

class A {
    public void print1to10() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Range : " + i);
        }
    }
}

class B {
    public void evenTill50() {
        for (int i = 0; i <= 50; i += 2) {
            System.out.println("Even : " + i);
        }
    }
}

class C {
    public void fibonacciFrom1to1000() {
        int x = 1, y = 1, temp;
        while (x <= 1000) {
            System.out.println("Fibonacci : " + x);
            temp = y;
            y = x;
            x = temp + y;
        }
    }
}

 public class MultithreadingJS {
    public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException {
        A a1 = new A();
        B b1 = new B();
        C c1 = new C();

        try (Context context = Context.create()) {
            ScriptEngineManager mgr = new ScriptEngineManager();
           List<ScriptEngineFactory> list= mgr.getEngineFactories();
           list.forEach((sef)->System.out.println(sef.getEngineName()));
           
            context.getBindings("js").putMember("a1", a1);
            context.getBindings("js").putMember("b1", b1);
            context.getBindings("js").putMember("c1", c1);

            // JavaScript code to call Java methods in separate threads
            
            ScriptEngine engine = mgr.getEngineByName("graal.js");
            engine.eval(new FileReader("C:\\Users\\Wissen\\Desktop\\Assignments\\STS_code\\JsinJava\\src\\main\\java\\demo.js"));
            Invocable inv = (Invocable)engine;

            inv.invokeFunction("runTasks") ;
        }
    }
}

