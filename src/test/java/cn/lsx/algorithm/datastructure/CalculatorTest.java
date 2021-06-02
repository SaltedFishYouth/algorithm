package cn.lsx.algorithm.datastructure;

import cn.lsx.algorithm.datastructure.stack.Calcstra;
import cn.lsx.algorithm.datastructure.stack.Calculator;
import org.junit.Test;

/**
 * @author linShengxi
 * @date 2021/6/2
 */

public class CalculatorTest {
    @Test
    public void calculatorTest(){
        Calculator calculator = new Calculator();
        calculator.run("50*2+2*(1+1)/(5-3)+3");
    }

    @Test
    public void calcstraTest(){
        Calcstra calcstra = new Calcstra();
        calcstra.run("3 4 + 5 * 6 -");
    }
}
