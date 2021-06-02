package cn.lsx.algorithm.datastructure;

import cn.lsx.algorithm.datastructure.stack.Calculator;
import org.junit.Test;

/**
 * @author linShengxi
 * @date 2021/6/2
 */

public class CalculatorTest {
    @Test
    public void calculator(){
        Calculator calculator = new Calculator();
        calculator.run("5*2+2*(1+1)/(5-3)+2");
    }
}
