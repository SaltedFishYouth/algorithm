package cn.lsx.algorithm.datastructure.stack;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰计算器
 * 1.从左到右扫描、数字直接入栈
 * 2.是运算符时，取出栈顶的两位数字与当前的运算符计算，并将计算结果入栈
 *
 * 中序转后续
 * 1.初始化两个栈 运算符栈和中间结果栈
 * 2.从左到右扫描中缀表达式
 * 3.遇到操作数时，压入中间结果栈
 * 4.遇到运算符时，比较运算符栈栈顶的符号
 *
 * @author linShengxi
 * @date 2021/6/2
 */

public class Calcstra {
    private Stack<Integer> stack = new Stack<>();

    public void run(String formula){
        List<String> list = Arrays.asList(formula.split(" "));
        int size = list.size();

        for (int i = 0; i < size; i++) {
            String s = list.get(i);

            //如果是数字直接入栈
            if (isNum(s)){
                stack.push(Integer.parseInt(s));
                continue;
            }

            Integer num1 = stack.pop();
            Integer num2 = stack.pop();
            int calculate = calculate(num1, num2, s);
            stack.push(calculate);
        }

        System.out.println(formula+"="+stack.pop());
    }

    private int calculate(int num1, int num2, String symbol) {
        switch (symbol) {
            case CalculatorContext.PLUS:
                return num1 + num2;
            case CalculatorContext.MINUS:
                return num2 - num1;
            case CalculatorContext.PRODUCT:
                return num1 * num2;
            case CalculatorContext.DIVISION:
                return num2 / num1;
            default:
                throw new RuntimeException("未知符号");
        }
    }

    private boolean isNum(String str) {
        return str.matches("\\d+");
    }
}
