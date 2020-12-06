<h1>CSV parser</h1>

Simple CSV parser. You can transform your csv file into another, but with different delimiters and with or without headers.<br/>
<br/>
Example:<br/>
Input: <br/>
1;"Л.Толстой ""Война и мир"" том 1";1873<br/>
2;"Д.Роулинг ""Гарри Поттер и Узник Азкабана""";1999<br/>
3;"И.Ильф; Е.Петров ""Двенадцать стульев""";1928<br/>
4;"А.Кристи ""Десять негритят""";1939<br/>
5;"С.Лем ""Солярис""";1960<br/>
<br/>
; - delimiter symbol<br/>
" - quotation symbol<br/>
<br/>
We can set in code<br/>
, - delimiter symbol<br/>
' - quotation symbol<br/>
<br/>
Output will be:<br/>
1,Л.Толстой "Война и мир" том 1,1873<br/>
2,Д.Роулинг "Гарри Поттер и Узник Азкабана",1999<br/>
3,'И.Ильф, Е.Петров "Двенадцать стульев"',1928<br/>
4,А.Кристи "Десять негритят",1939<br/>
5,С.Лем "Солярис",1960<br/>

Input and Output files and delimiters are set in work.properties
