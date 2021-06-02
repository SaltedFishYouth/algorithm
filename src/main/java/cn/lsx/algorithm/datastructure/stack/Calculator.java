package cn.lsx.algorithm.datastructure.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 中序简易计算器
 *
 * @author Administrator
 */
public class Calculator {
    private Stack<Integer> numStack = new Stack<>();
    private Stack<String> symbolStack = new Stack<>();

    public void run(String formula) {
        formula = formula.replace(" ", "");
        List<String> list = Arrays.asList(formula.split(""));
        int val = 0;

        String cacheNum = "";
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);

            //如果是数字直接入数字栈 拼接数字字符串
            if (isNum(s)) {
                cacheNum = cacheNum + s;
                if (i + 1 == list.size() || !isNum(list.get(i + 1))) {
                    numStack.push(Integer.parseInt(cacheNum));
                    cacheNum = "";
                }
                continue;
            }

            if (symbolStack.isEmpty()) {
                symbolStack.push(s);
                continue;
            }

            //如果是右括号 取出栈中的数据计算 直到遇到左括号
            if (CalculatorContext.RIGHT_BRACKET.equals(s)) {
                while (!CalculatorContext.LEFT_BRACKET.equals(symbolStack.peek())) {
                    int num1 = numStack.pop();
                    int num2 = numStack.pop();
                    val = calculate(num1, num2, symbolStack.pop());
                    numStack.push(val);
                }
                //取出左括号
                symbolStack.pop();
                continue;
            }

            //运算符级别比栈顶的小或相等 取出数字栈2位与运算符栈一位计算 并将计算结果压入数字栈 本运算符压入符号栈
            if (getLevel(s) <= getLevel(symbolStack.peek())) {
                int num1 = numStack.pop();
                int num2 = numStack.pop();
                val = calculate(num1, num2, symbolStack.pop());
                numStack.push(val);
                symbolStack.push(s);
                continue;
            }
            //其它直接入栈
            symbolStack.push(s);
        }

        //表达式解析完，顺序取出 计算
        while (!symbolStack.isEmpty()) {
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            val = calculate(num1, num2, symbolStack.pop());
            numStack.push(val);
        }
        Integer pop = numStack.pop();
        System.out.println(formula + "=" + pop);

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

    private int getLevel(String str) {
        if (CalculatorContext.LEFT_BRACKET.equals(str)) {
            return 0;
        }
        if (CalculatorContext.PLUS.equals(str) || CalculatorContext.MINUS.equals(str)) {
            return 1;
        }
        if (CalculatorContext.PRODUCT.equals(str) || CalculatorContext.DIVISION.equals(str)) {
            return 2;
        }
        throw new RuntimeException("无法是别的符号");
    }
}
