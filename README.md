[toc]

# antlr4：实现一门编译到Java字节码的语言

## 引言

TODO

近几天我看到一个项目叫[Creating JVM language](https://juejin.cn/post/6844903671679942663)，目标是开发一门编译到JVM字节码的语言。在此我打算跟着这个项目做一遍，以学习：

1. antlr4的使用
2. `ASM`的使用和JVM字节码指令

这门语言叫做`hant`。[GitHub传送门](https://github.com/Hans774882968/hans-antlr-java)。

环境：
- Windows10
- VSCode快速创建的Maven项目

**作者：[hans774882968](https://blog.csdn.net/hans774882968)以及[hans774882968](https://juejin.cn/user/1464964842528888)以及[hans774882968](https://www.52pojie.cn/home.php?mod=space&uid=1906177)**

## antlr4 hello world（可以跳过）

> ANTLR（ANother Tool for Language Recognition）是用 Java 语言编写的功能强大的语法分析器自动生成工具，由旧金山大学的 Terence Parr 博士等人于 1989 年推出第一代，迭代到现在是第四代，因此一般称之为`antlr4`。该工具本身是 Java 语言的工具，但产出的语法分析器可以是包括 js 和 ts 语言在内的主流编程语言，因此基本上可以认为`antlr4`是当前使用最广泛的一款语法分析器自动生成工具。

> `antlr4`接收 g4 文法作为输入，输出为符合该文法约束的对应目标语言的解析器源代码。更准确地讲，是输出解析器的框架代码，该框架代码在运行时可以自动解析输入文本并生成我们在上一讲提到的AST，但业务项目仍然需要在该框架代码上补充完善业务需求的逻辑。

首先在[antlr官网](https://www.antlr.org/download/antlr-4.13.0-complete.jar)下载jar，并把jar所在路径加入环境变量Path。然后创建文件`src\main\java\com\example\antlr4_hello\Hello.g`：

```
grammar Hello; // 定义文法的名字

s: 'hello' ID; // 匹配关键字hello和标志符
ID: [a-z]+; // 标志符由小写字母组成
WS: [ \t\r\n]+ -> skip; // 跳过空格、制表符、回车符和换行符
```

注意，文件名必须大写，因为我们接下来要生成`.java`的lexer和parser。为了方便，编写一个叫`antlr.ps1`的power shell脚本：

```ps1
java -cp C:\java_project\softs\antlr-4.13.0-complete.jar org.antlr.v4.Tool $args
```

再把`C:\java_project\softs`加入环境变量，就能执行命令来生成`.java`的lexer和parser文件了。

```ps1
antlr src\main\java\com\example\antlr4_hello\Hello.g
```

生成了名称前缀为Hello的8个文件：`src\main\java\com\example\antlr4_hello\HelloBaseListener.java`、`src\main\java\com\example\antlr4_hello\HelloLexer.java`、`src\main\java\com\example\antlr4_hello\HelloListener.java`、`src\main\java\com\example\antlr4_hello\HelloParser.java`、`Hello.tokens  `、`HelloLexer.interp`、`Hello.interp`、`HelloLexer.tokens`

现在开始准备编译由antlr4生成的Java代码。准备一个ps1脚本`antlr-compile.ps1`：

```ps1
javac -cp C:\java_project\softs\antlr-4.13.0-complete.jar $args
```

于是可以使用编译命令：

```ps1
antlr-compile src\main\java\com\example\antlr4_hello\Hello*.java
```

到此，我们已经有一个可以被执行的识别器，只缺一个主程序去触发语言识别。

antlr运行库有提供一个称之为TestRig的测试工具，可以让你不创建主程序就能测试文法。TestRig使用Java反射调用编译后的识别器，它能显示关于识别器如何匹配输入的大量信息。

输入命令：

```ps1
java -cp "C:\java_project\softs\antlr-4.13.0-complete.jar;C:\java_project\hans-antlr-java\src\main\java\com\example\antlr4_hello" org.antlr.v4.gui.TestRig Hello s -tokens
```

注意这条命令把`C:\java_project\hans-antlr-java\src\main\java\com\example\antlr4_hello`也加入了classpath，以兼容`antlr-4.13.0-complete.jar`和`Hello*.java`不同路径的情况。不出意外的话你就可以输入文本了。输入`hello world acmer`按回车，然后`Ctrl+Z`结束输入。于是你就能看到TestRig打印出的token列表了。

```
[@0,0:4='hello',<'hello'>,1:0]
[@1,6:10='world',<ID>,1:6]
[@2,12:16='acmer',<ID>,1:12]
[@3,19:18='<EOF>',<EOF>,2:0]
```

查看AST命令：

```ps1
java -cp "C:\java_project\softs\antlr-4.13.0-complete.jar;C:\java_project\hans-antlr-java\src\main\java\com\example\antlr4_hello" org.antlr.v4.gui.TestRig Hello s -gui
```

和上面一样输入`hello world`，可以看到效果：

![1-antlr_hello_world.jpg](./README_assets/1-antlr_hello_world.jpg)

## VSCode antlr 插件如何关闭自动生成`.antlr`文件夹的功能

antlr插件在点击`.g`文件后会自动生成lexer和parser，并生成`.antlr`文件夹。如何关闭这个功能？只需要设置：

```json
"antlr4.generation": {
    "mode": "none"
}
```

## antlr4 hello world：编程式

`pom.xml`添加依赖：

```xml
<dependency>
    <groupId>org.antlr</groupId>
    <artifactId>antlr4</artifactId>
    <version>4.13.0</version>
</dependency>
```

也可以添加本地依赖：

```xml
<dependency>
    <groupId>org.antlr</groupId>
    <artifactId>v4</artifactId>
    <version>1.0.0</version>
    <scope>system</scope>
    <systemPath>C:\java_project\softs\antlr-4.13.0-complete.jar</systemPath>
</dependency>
```

接着给上一节生成的`.java`文件添加`package com.example.antlr4_hello;`，然后就可以添加测试用例了。`src\test\java\com\example\hans_antlr4\HelloAntlr4Test.java`：

```java
package com.example.hans_antlr4;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;

import com.example.antlr4_hello.HelloLexer;
import com.example.antlr4_hello.HelloParser;

public class HelloAntlr4Test {
    @Test
    public void hello_antlr4_test() {
        HelloLexer lexer = new HelloLexer(CharStreams.fromString("hello world acmer"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HelloParser parser = new HelloParser(tokens);
        ParseTree tree = parser.s();
        String treeString = tree.toStringTree(parser);
        Assert.assertEquals("(s hello world)", treeString);
        System.out.println(treeString);
    }
}
```

`parser.s()`中的`s`是我们在`Hello.g`中定义的规则名。

TODO: 这样改造后就不能通过上一节的命令行来获取gui输出了。

## Part3：1-用 Listener 实现遍历 AST 过程中的自定义操作

这一节正式开始实现`hant`语言。这一节我们需要添加的特性：

- 声明`int`或者`string`类型的变量：`var str = "str"`
- 打印变量：`print str`
- 简单的类型推断
- 支持`java -jar xx.jar hello.hant`编译`hello.hant`，以及`java -jar xx.jar run hello.hant`直接运行`hello.hant`生成的字节码。

这一节的语法规则文件为`src\main\java\com\example\hans_antlr4\parsing\HansAntlr.g`。

```g
grammar HansAntlr;

@header {
package com.example.hans_antlr4.parsing;
}

// RULES
compilationUnit: (variable | print)* EOF;
// root rule - our code consist consist only of variables and prints (see definition below)
variable: VARIABLE ID EQUALS value;
// requires VAR token followed by ID token followed by EQUALS TOKEN ...
print:
	PRINT ID; // print statement must consist of 'print' keyword and ID
value:
	op = NUMBER
	| op = STRING; // must be NUMBER or STRING value (defined below)

// TOKENS
VARIABLE: 'var'; // VARIABLE TOKEN must match exactly 'var'
PRINT: 'print';
EQUALS: '='; // must be '='
NUMBER: [0-9]+; // must consist only of digits
// must be anything in quotes。注意，原作者给出的规则`STRING: '"' .* '"';`中的正则表达式是贪婪模式，我改成了非贪婪模式
STRING: '"' .*? '"';
ID: [a-zA-Z0-9]+; // must be any alphanumeric value
WS: [ \t\n\r]+ -> skip; // special TOKEN for skipping whitespaces
```

使用上一节编写的`antlr.ps1`来生成lexer、parser和listener：`antlr src\main\java\com\example\hans_antlr4\parsing\HansAntlr.g`。

上一节提到，antlr4为我们生成了4个Java文件：

- `src\main\java\com\example\antlr4_hello\HelloBaseListener.java`
- `src\main\java\com\example\antlr4_hello\HelloLexer.java`
- `src\main\java\com\example\antlr4_hello\HelloListener.java`
- `src\main\java\com\example\antlr4_hello\HelloParser.java`

其中：
1. Lexer和Parser都不需要改动。
2. `HelloBaseListener`继承了`HelloListener`，它提供了一些函数，其中形如`enterXyz`，`exitXyz`的函数分别表示进入和离开名为`Xyz`的非终结符时的操作。因此我们只需要在`HelloBaseListener`的`exitXyz`编写自己的逻辑。

`src\main\java\com\example\hans_antlr4\parsing\HansAntlrBaseListener.java`：

```java
@Slf4j
@SuppressWarnings("CheckReturnValue")
public class HansAntlrBaseListener implements HansAntlrListener {
	private Map<String, Variable> variables = new HashMap<>();

	@Override
	public void exitVariable(HansAntlrParser.VariableContext ctx) {
		final TerminalNode varName = ctx.ID();
		final ValueContext varValue = ctx.value();
		if (varValue == null) {
			return;
		}
		final int varType = varValue.getStart().getType();
		final int varIndex = variables.size();
		final String varTextValue = varValue.getText();
		final Variable variable = new Variable(varIndex, varType, varName.getText(), varTextValue);
		variables.put(varName.getText(), variable);
		logVariableDeclarationStatementFound(varName, variable);
	}

    @Override
	public void exitPrint(HansAntlrParser.PrintContext ctx) {
		final TerminalNode varName = ctx.ID();
		if (varName == null) {
			return;
		}
		if (!variables.containsKey(varName.getText())) {
			log.error("ERROR: You are trying to print var '{}' which has not been declared!", varName.getText());
			return;
		}
		final Variable variable = variables.get(varName.getText());
		logPrintStatementFound(varName, variable);
	}

	private void logVariableDeclarationStatementFound(TerminalNode varName, Variable variable) {
		final int line = varName.getSymbol().getLine();
		log.info("OK: Define variable '{}' with type '{}' and value '{}' at line {}",
				variable.getName(), variable.getVarType(), variable.getVarTextValue(), line);
	}

	private void logPrintStatementFound(TerminalNode varName, Variable variable) {
		final int line = varName.getSymbol().getLine();
		final String format = "OK: You instructed to print variable '{}' which has type '{}' value of '{}' at line {}";
		log.info(format, variable.getVarIndex(), variable.getVarType(), variable.getVarTextValue(), line);
	}
}
```

为了方便后续的字节码生成流程，我们抽象出`Variable`表示变量信息。`src\main\java\com\example\hans_antlr4\parsing\Variable.java`：

```java
package com.example.hans_antlr4.parsing;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Variable {
    private int varIndex;
    private int varType;
    private String name;
    private String varTextValue;
}
```

除了BaseListener，我们还需要提供一个ErrorListener。`src\main\java\com\example\hans_antlr4\parsing\HansAntlrErrorListener.java`：

```java
package com.example.hans_antlr4.parsing;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HansAntlrErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e) {
        final String errorFormat = "The program has error at line %d, char %d :(. Details:\n%s";
        final String errorMsg = String.format(errorFormat, line, charPositionInLine, msg);
        log.error(errorMsg);
    }
}
```

接下来我们需要在入口`src\main\java\com\example\hans_antlr4\App.java`显式地调用Lexer、Parser和Listener。

```java
package com.example.hans_antlr4;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class App {
    public static void main(String[] args) {
        HansAntlrLexer lexer = new HansAntlrLexer(CharStreams.fromString("var x1 = 114514\r\n" + //
                "print x1\r\n" +
                "var str = \"hello world\"\r\n" +
                "print str"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HansAntlrParser parser = new HansAntlrParser(tokens);

        HansAntlrBaseListener listener = new HansAntlrBaseListener();
        parser.addParseListener(listener);
        HansAntlrErrorListener errorListener = new HansAntlrErrorListener();
        parser.addErrorListener(errorListener);

        ParseTree tree = parser.compilationUnit();
        String treeString = tree.toStringTree(parser);
        System.out.println(treeString);
    }
}
```

运行可得输出：

```
OK: Define variable 'x1' with type '4' and value '114514' at line 1
OK: You instructed to print variable '0' which has type '4' value of '114514' at line 2
OK: Define variable 'str' with type '5' and value '"hello world"' at line 3
OK: You instructed to print variable '1' which has type '5' value of '"hello world"' at line 4
(compilationUnit (variable var x1 = (value 114514)) (print print x1) (variable var str = (value \"hello world\")) (print print str) <EOF>)
```

## Part3：2-接受文件输入+打包

为了接受文件输入，我们需要改下入口`src\main\java\com\example\hans_antlr4\App.java`：

```java
@Slf4j
public class App {
    private static ARGUMENT_ERRORS getArgumentValidationError(String[] args) {
        if (args.length != 1) {
            return ARGUMENT_ERRORS.NO_FILE;
        }
        String filePath = args[0];
        if (!filePath.endsWith(".hant")) {
            return ARGUMENT_ERRORS.BAD_FILE_EXTENSION;
        }
        return ARGUMENT_ERRORS.NONE;
    }

    public static void parse(String fileAbsolutePath) throws IOException {
        // 显式调用Lexer、Parser和Listener，和上一节一样，在此省略了
    }

    public static void main(String[] args) {
        ARGUMENT_ERRORS argumentError = getArgumentValidationError(args);
        if (argumentError != ARGUMENT_ERRORS.NONE) {
            log.error(argumentError.getMessage());
            return;
        }
        File hantFile = new File(args[0]);
        String fileAbsolutePath = hantFile.getAbsolutePath();
        log.info("trying to parse hant file \"{}\" ...", fileAbsolutePath);
        try {
            parse(fileAbsolutePath);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
```

为了打包出一个“自带干粮”的jar，我们需要使用`maven-assembly-plugin`。`pom.xml`新增：

```xml
<plugins>
    <plugin>
    <artifactId>maven-assembly-plugin</artifactId>
    <configuration>
        <descriptorRefs>
        <descriptorRef>jar-with-dependencies</descriptorRef>
        </descriptorRefs>
        <archive>
        <manifest>
            <mainClass>com.example.hans_antlr4.App</mainClass>
        </manifest>
        </archive>
    </configuration>
    <executions>
        <execution>
        <id>make-assembly</id>
        <phase>package</phase>
        <goals>
            <goal>single</goal>
        </goals>
        </execution>
    </executions>
    </plugin>
</plugins>
```

打包完成后，运行命令

```ps1
java -jar C:\java_project\hans-antlr-java\target\hans_antlr-1.0-SNAPSHOT-jar-with-dependencies.jar C:\java_project\hans-antlr-java\hant_examples\hello.hant
```

即可看到输出。

## Part3：3-生成字节码+写入字节码到`.class`文件

为了支持字节码生成和写入，我们需要修改入口`src\main\java\com\example\hans_antlr4\App.java`：

```java
package com.example.hans_antlr4;
// 省略了一些不重要的 import
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Queue;

import org.apache.commons.lang3.StringUtils;

import com.example.hans_antlr4.bytecode_gen.BytecodeGenerator;
import com.example.hans_antlr4.bytecode_gen.instructions.Instruction;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    private static ARGUMENT_ERRORS getArgumentValidationError(String[] args) {
        if (args.length != 1) {
            return ARGUMENT_ERRORS.NO_FILE;
        }
        String filePath = args[0];
        if (!filePath.endsWith(".hant")) {
            return ARGUMENT_ERRORS.BAD_FILE_EXTENSION;
        }
        return ARGUMENT_ERRORS.NONE;
    }

    private static Queue<Instruction> parse(String fileAbsolutePath) throws IOException {
        CharStream charStream = CharStreams.fromFileName(fileAbsolutePath);
        HansAntlrLexer lexer = new HansAntlrLexer(charStream);
        // 其他语句省略了，只需要知道这里返回了 instructionQueue
        return listener.getInstructionsQueue();
    }

    private static void saveBytecodeToClassFile(String fileAbsolutePath, byte[] byteCode) throws IOException {
        final String classFile = StringUtils.replace(fileAbsolutePath, ".hant", ".class");
        OutputStream os = new FileOutputStream(classFile);
        os.write(byteCode);
        os.close();
    }

    public static void main(String[] args) {
        // 前面的语句省略
        Queue<Instruction> instructionsQueue = null;
        try {
            instructionsQueue = parse(fileAbsolutePath);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        final byte[] byteCode = new BytecodeGenerator().generateBytecode(
                instructionsQueue, StringUtils.remove(fileName, ".hant"));
        try {
            saveBytecodeToClassFile(fileAbsolutePath, byteCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

和字节码生成相关的对象有`Instruction, instructionsQueue, BytecodeGenerator`。我们把字节码生成相关的类都放在`bytecode_gen`文件夹下：

```
SRC\MAIN\JAVA\COM\EXAMPLE\HANS_ANTLR4\BYTECODE_GEN
│  BytecodeGenerator.java
│
└─instructions
        Instruction.java
        PrintVariable.java
        VariableDeclaration.java
```

其中`interface Instruction`表示我们希望生成一条语句的字节码，`PrintVariable`和`VariableDeclaration`表示我们希望生成一条变量定义语句或print语句的字节码，所以后者都要`implements`前者。

遍历AST后，我们就能从 Listener 中拿到`Queue<Instruction> instructionsQueue`。`src\main\java\com\example\hans_antlr4\parsing\HansAntlrBaseListener.java`：

```java
@Slf4j
@SuppressWarnings("CheckReturnValue")
public class HansAntlrBaseListener implements HansAntlrListener {
	private Map<String, Variable> variables = new HashMap<>();
	private Queue<Instruction> instructionsQueue = new ArrayDeque<>();

	public Queue<Instruction> getInstructionsQueue() {
		return instructionsQueue;
	}

    @Override
	public void exitVariable(HansAntlrParser.VariableContext ctx) {
        final TerminalNode varName = ctx.ID();
		final ValueContext varValue = ctx.value();
		if (varValue == null) {
			return;
		}
		final int varType = varValue.getStart().getType();
		final int varIndex = variables.size();
		final String varTextValue = varValue.getText();
		final Variable variable = new Variable(varIndex, varType, varName.getText(), varTextValue);
		variables.put(varName.getText(), variable);
        instructionsQueue.add(new VariableDeclaration(variable));
    }

    @Override
	public void exitPrint(HansAntlrParser.PrintContext ctx) {
        final TerminalNode varName = ctx.ID();
		if (varName == null) {
			return;
		}
		if (!variables.containsKey(varName.getText())) {
			log.error("ERROR: You are trying to print var '{}' which has not been declared!", varName.getText());
			return;
		}
		final Variable variable = variables.get(varName.getText());
		instructionsQueue.add(new PrintVariable(variable));
	}
}
```

接下来我们关注`Instruction`的定义：

```java
package com.example.hans_antlr4.bytecode_gen.instructions;

import org.objectweb.asm.MethodVisitor;

public interface Instruction {
    void apply(MethodVisitor methodVisitor);
}
```

这里选用`ASM`来操作 Java 字节码。这样我们就不用关心非常底层的十六进制数字了。我们只需要知道指令的名字，`ASM`会自动帮我们处理剩下的事情。

`BytecodeGenerator.generateBytecode()`会依次遍历`instructionsQueue`里的`Instruction`，调用`apply`方法来生成字节码，输出`byte[]`。`apply`方法会调用`methodVisitor`的若干visit方法以实现输出字节码的“副作用”。`src\main\java\com\example\hans_antlr4\bytecode_gen\BytecodeGenerator.java`：

```java
package com.example.hans_antlr4.bytecode_gen;

import java.util.Queue;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.bytecode_gen.instructions.Instruction;
import com.example.hans_antlr4.bytecode_gen.instructions.VariableDeclaration;

public class BytecodeGenerator implements Opcodes {
    public byte[] generateBytecode(Queue<Instruction> instructionQueue, String name) {
        ClassWriter cw = new ClassWriter(0);
        MethodVisitor mv;
        // version, access, name, signature, base class, interfaces
        cw.visit(52, ACC_PUBLIC + ACC_SUPER, name, null, "java/lang/Object", null);
        {
            // declare static void main
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            final long localVariablesCount = instructionQueue.stream()
                    .filter(instruction -> instruction instanceof VariableDeclaration)
                    .count();
            final int maxStack = 100; // TODO: do that properly

            // apply instructions generated from traversing parse tree!
            for (Instruction instruction : instructionQueue) {
                instruction.apply(mv);
            }
            mv.visitInsn(RETURN); // add return instruction

            mv.visitMaxs(maxStack, (int) localVariablesCount); // set max stack and max local variables
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
```

为了简单，编译后的类直接继承自`Object`, 包含一个`main`函数。`MethodVisitor`需要提供局部变量以及栈的深度。

至此我们可以梳理出主流程：`App.java Listener 获取到 instructionQueue -> BytecodeGenerator.generateBytecode 输入 instructionQueue ，输出 byte[] -> PrintVariable 和 VariableDeclaration 生成字节码`。

接下来关注`PrintVariable`和`VariableDeclaration`的实现。

```java
@AllArgsConstructor
public class VariableDeclaration implements Instruction, Opcodes {
    Variable variable;

    @Override
    public void apply(MethodVisitor mv) {
        final int type = variable.getVarType();
        if (type == HansAntlrLexer.NUMBER) {
            int val = Integer.valueOf(variable.getVarTextValue());
            mv.visitIntInsn(SIPUSH, val);
            mv.visitVarInsn(ISTORE, variable.getVarIndex());
        }
        if (type == HansAntlrLexer.STRING) {
            mv.visitLdcInsn(variable.getVarTextValue());
            mv.visitVarInsn(ASTORE, variable.getVarIndex());
        }
    }
}

@AllArgsConstructor
public class PrintVariable implements Instruction, Opcodes {
    Variable variable;

    @Override
    public void apply(MethodVisitor mv) {
        int id = variable.getVarIndex();
        int type = variable.getVarType();
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        if (type == HansAntlrLexer.NUMBER) {
            mv.visitVarInsn(ILOAD, id);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
        }
        if (type == HansAntlrLexer.STRING) {
            mv.visitVarInsn(ALOAD, id);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        }
    }
}
```

`VariableDeclaration`：

- visitInsn - 第一个参数是操作符，第二个是操作数
- BIPUSH - 把一个`byte(integer)`入栈，同理`SIPUSH`把两个`byte(integer)`入栈
- ISTORE - int 类型的值出栈，并存储到局部变量中，需要指定局部变量的索引
- ASTORE - 和`ISTORE`功能类似，但是数据类型是索引

`PrintVariable`：

- GETSTATIC - 从java.lang.System.out获得静态属性，类型是 java.io.PrintStream
- ILOAD - 把局部变量入栈，id 是局部变量的索引
- visitMethodInsn - 访问方法指令
- INVOKEVIRTUAL - 触发实例方法（调用 out 的 print 方法，该方法接受一个参数为整数类型，返回为空）
- ALOAD - 和 ILOAD 类似，但是数据类型是引用

我们准备一个`.hant`文件`hant_examples\hello.hant`：

```js
var x1 = 114514
print x1
var str = "hello world"
print str
var str2 = "hello\n支持输出中文~"
print str2
```

运行代码后，即可看到在同一文件夹下生成了`hello.class`。我们可以使用 JDK 自带的`javap`工具来验证生成的字节码的正确性。`javap -v C:\java_project\hans-antlr-java\hant_examples\hello.class`输出：

```
Classfile /C:/java_project/hans-antlr-java/hant_examples/hello.class
  Last modified 2023年8月13日; size 355 bytes
  SHA-256 checksum bae32267cc9d8cd4cd8072df85c2afc3e5f440df014b84446290f58057d40d7d
public class hello
  minor version: 0
  major version: 52
  flags: (0x0021) ACC_PUBLIC, ACC_SUPER
  this_class: #2                          // hello
  super_class: #4                         // java/lang/Object
  interfaces: 0, fields: 0, methods: 1, attributes: 0
Constant pool:
   #1 = Utf8               hello
   #2 = Class              #1             // hello
   #3 = Utf8               java/lang/Object
   #4 = Class              #3             // java/lang/Object
   #5 = Utf8               main
   #6 = Utf8               ([Ljava/lang/String;)V
   #7 = Utf8               java/lang/System
   #8 = Class              #7             // java/lang/System
   #9 = Utf8               out
  #10 = Utf8               Ljava/io/PrintStream;
  #11 = NameAndType        #9:#10         // out:Ljava/io/PrintStream;
  #12 = Fieldref           #8.#11         // java/lang/System.out:Ljava/io/PrintStream;
  #13 = Utf8               java/io/PrintStream
  #14 = Class              #13            // java/io/PrintStream
  #15 = Utf8               println
  #16 = Utf8               (I)V
  #17 = NameAndType        #15:#16        // println:(I)V
  #18 = Methodref          #14.#17        // java/io/PrintStream.println:(I)V
  #19 = Utf8               \"hello world\"
  #20 = String             #19            // \"hello world\"
  #21 = Utf8               (Ljava/lang/String;)V
  #22 = NameAndType        #15:#21        // println:(Ljava/lang/String;)V
  #23 = Methodref          #14.#22        // java/io/PrintStream.println:(Ljava/lang/String;)V
  #24 = Utf8               \"hello\\n支持输出中文~\"
  #25 = String             #24            // \"hello\\n支持输出中文~\"
  #26 = Utf8               Code
{
  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: (0x0009) ACC_PUBLIC, ACC_STATIC
    Code:
      stack=100, locals=3, args_size=1
         0: sipush        -16558
         3: istore_0
         4: getstatic     #12                 // Field java/lang/System.out:Ljava/io/PrintStream;
         7: iload_0
         8: invokevirtual #18                 // Method java/io/PrintStream.println:(I)V
        11: ldc           #20                 // String \"hello world\"
        13: astore_1
        14: getstatic     #12                 // Field java/lang/System.out:Ljava/io/PrintStream;
        17: aload_1
        18: invokevirtual #23                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        21: ldc           #25                 // String \"hello\\n支持输出中文~\"
        23: astore_2
        24: getstatic     #12                 // Field java/lang/System.out:Ljava/io/PrintStream;
        27: aload_2
        28: invokevirtual #23                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        31: return
}
```

运行class文件的命令：

```ps1
java -cp C:\java_project\hans-antlr-java\hant_examples hello
# or 在 C:\java_project\hans-antlr-java\hant_examples 下运行
java hello
```

输出：

```
-16558
"hello world"
"hello\n支持输出中文~"
```

## Part3：4-在命令行直接运行`.hant`代码

在上一节我们已经得到了类的`byte[]`，因此可以直接使用`ClassLoader`加载并运行这个类。首先，我们修改入口，同时支持`java -jar xx.jar hello.hant`和`java -jar xx.jar run hello.hant`：

```java
@Slf4j
public class App {
    private static boolean runMode = false;

    private static ARGUMENT_ERRORS getArgumentValidationError(String[] args) {
        if ((runMode && args.length != 2) || (!runMode && args.length != 1)) {
            return ARGUMENT_ERRORS.NO_FILE;
        }
        String filePath = runMode ? args[1] : args[0];
        if (!filePath.endsWith(".hant")) {
            return ARGUMENT_ERRORS.BAD_FILE_EXTENSION;
        }
        return ARGUMENT_ERRORS.NONE;
    }

    private static void runClass(byte[] byteCode) {
        CodeRunner.run(byteCode);
    }

    public static void main(String[] args) {
        runMode = args[0].equals("run");
        ARGUMENT_ERRORS argumentError = getArgumentValidationError(args);
        if (argumentError != ARGUMENT_ERRORS.NONE) {
            log.error(argumentError.getMessage());
            return;
        }

        String inputFilePath = runMode ? args[1] : args[0];
        File hantFile = new File(inputFilePath);
        // 省略无关代码
        try {
            if (runMode) {
                runClass(byteCode);
            } else {
                saveBytecodeToClassFile(fileAbsolutePath, byteCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

TODO: 这部分代码开始乱了，要整理下~

新增的`src\main\java\com\example\hans_antlr4\CodeRunner.java`从`byte[]`加载类并调用其`main`函数：

```java
package com.example.hans_antlr4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class MyClassLoader extends ClassLoader {
    public Class<?> myDefineClass(byte[] arg1, int arg2, int arg3) {
        return super.defineClass(null, arg1, arg2, arg3);
    }
}

public class CodeRunner {
    public static void run(byte[] byteCode) {
        MyClassLoader cl = new MyClassLoader();
        Class<?> cls = cl.myDefineClass(byteCode, 0, byteCode.length);
        try {
            Method mainMethod = cls.getDeclaredMethod("main", String[].class);
            mainMethod.invoke(null, (Object) new String[] {});
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
```

## 参考资料

1. antlr4简明教程：https://wizardforcel.gitbooks.io/antlr4-short-course/content/getting-started.html
2. Creating JVM language中文翻译：https://juejin.cn/post/6844903671679942663