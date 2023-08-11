grammar Hello;               // 定义文法的名字

s  : 'hello' ID ;            // 匹配关键字hello和标志符
ID : [a-z]+ ;                // 标志符由小写字母组成
WS : [ \t\r\n]+ -> skip ;    // 跳过空格、制表符、回车符和换行符