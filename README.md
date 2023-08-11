[toc]

# antlr4：实现一门编译到Java字节码的语言

## 引言

TODO

## antlr4 hello world

创建文件`src\main\java\com\example\antlr4_hello\Hello.g`：

```
grammar Hello;               // 定义文法的名字

s  : 'hello' ID ;            // 匹配关键字hello和标志符
ID : [a-z]+ ;                // 标志符由小写字母组成
WS : [ \t\r\n]+ -> skip ;    // 跳过空格、制表符、回车符和换行符
```

注意，文件名必须大写，因为我们接下来要生成`.java`的lexer和parser。为了方便，编写一个叫`antlr.ps1`的power shell脚本：

```ps1
param(
    [Parameter()]
    [string]$p1
)

java -cp C:\java_project\softs\antlr-4.13.0-complete.jar org.antlr.v4.Tool $p1
```

再把`C:\java_project\softs`加入环境变量，就能执行命令来生成`.java`的lexer和parser文件了。

```ps1
antlr src\main\java\com\example\antlr4_hello\Hello.g
```

生成了名称前缀为Hello的8个文件：`src\main\java\com\example\antlr4_hello\HelloBaseListener.java`、`src\main\java\com\example\antlr4_hello\HelloLexer.java`、`src\main\java\com\example\antlr4_hello\HelloListener.java`、`src\main\java\com\example\antlr4_hello\HelloParser.java`、`Hello.tokens  `、`HelloLexer.interp`、`Hello.interp`、`HelloLexer.tokens`

现在开始准备编译由antlr4生成的Java代码。准备一个ps1脚本`antlr-compile.ps1`：

```ps1
param(
    [Parameter()]
    [string]$p1
)

javac -cp C:\java_project\softs\antlr-4.13.0-complete.jar $p1
```

于是可以使用编译命令：

```ps1
antlr-compile src\main\java\com\example\antlr4_hello\Hello*.java
```

到此，我们已经有一个可以被执行的识别器，只缺一个主程序去触发语言识别。

antlr运行库有提供一个称之为TestRig的测试工具，可以让你不创建主程序就能测试文法。TestRig使用Java反射调用编译后的识别器，它能显示关于识别器如何匹配输入的大量信息。

输入命令：

```ps1
java -cp "C:\java_project\softs\antlr-4.13.0-complete.jar;C:\java_project\hans_antlr\src\main\java\com\example\antlr4_hello" org.antlr.v4.gui.TestRig Hello s -tokens
```

注意这条命令把`C:\java_project\hans_antlr\src\main\java\com\example\antlr4_hello`也加入了classpath，以兼容`antlr-4.13.0-complete.jar`和`Hello*.java`不同路径的情况。不出意外的话你就可以输入文本了。输入`hello world acmer`按回车，然后`Ctrl+Z`结束输入。于是你就能看到TestRig打印出的token列表了。

```
[@0,0:4='hello',<'hello'>,1:0]
[@1,6:10='world',<ID>,1:6]
[@2,12:16='acmer',<ID>,1:12]
[@3,19:18='<EOF>',<EOF>,2:0]
```

查看AST命令：

```ps1
java -cp "C:\java_project\softs\antlr-4.13.0-complete.jar;C:\java_project\hans_antlr\src\main\java\com\example\antlr4_hello" org.antlr.v4.gui.TestRig Hello s -gui
```

和上面一样输入`hello world`，可以看到效果：

![1-antlr_hello_world.jpg](./README_assets/1-antlr_hello_world.jpg)

## antlr4 hello world：编程式

`pom.xml`添加本地依赖：

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
    public void shouldAnswerWithTrue() {
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

## 参考资料

1. antlr4简明教程：https://wizardforcel.gitbooks.io/antlr4-short-course/content/getting-started.html