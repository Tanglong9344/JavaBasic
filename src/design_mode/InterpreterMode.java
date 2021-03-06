package design_mode;

import java.util.ArrayList;
import java.util.List;

/**
 * 解释器模式
 * 给定一个语言，定义它的文法的一种表示并定义一个解释器
 * 这个解释器使用该表示来解释语言中的句子。
 *
 * 如果一种类型的问题发生的频率足够高，
 * 那么可能·就值得将该问题的各个实例表述为一个简单语言中的句子
 * 这样就可以构建一个解释器，该解释器通过解释这些句子来解决该问题。
 *
 * 通常当有一个语言需要解释执行并且可以将改语言中的句子表示为一个
 * 抽象语法树时，可使用解释器模式。
 *
 * 优点：
 * 可以很容易地改变和扩展语法，因为该模式使用类来表示文法规则，
 * 可以使用继承来改变或扩展文法。
 * 因为定义抽象语法树中各个节点的类的实现大体类似，使得该模式
 * 比较容易实现。
 *
 * 不足：
 * 解释器模式为文法中的每一条规则至少定义了一个类，因此包含许多规则的文法可能难以管理和维护。
 * 这个时候，可以考虑使用其他技术如语法分析程序或编译器生成器进行处理。
 *
 * @author 唐龙
 *
 */
public class InterpreterMode {
	//This is a test
	public static void main(String[] args) {
		//上下文对象
		ContextExpression ctx=new ContextExpression();
		//表达式对象列表
		List<Expression> exps=new ArrayList<Expression>();
		//添加表达式
		exps.add(new TerminalExpression());
		exps.add(new NonTerminalExpression());
		exps.add(new TerminalExpression());
		exps.forEach(exp->exp.interprete(ctx));
	}
}

//抽象表达式类
abstract class Expression{
	public abstract void interprete(ContextExpression ContextExpression);
}

//终结符表达式类(实现文法中与终结符相关的操作)
class TerminalExpression extends Expression{
	@Override
	public void interprete(ContextExpression ContextExpression) {
		System.out.println("终结符表达式。");
	}
}

//非终结符表达式类(实现文法中与非终结符相关的操作)
class NonTerminalExpression extends Expression{
	@Override
	public void interprete(ContextExpression ContextExpression) {
		System.out.println("非终结符表达式。");
	}
}

//解释器之外的一切全局信息
class ContextExpression{
	//输入输出(未实现)
	private String input;
	private String output;

	//getter and setter
	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}
}