<h1>CSV parser</h1>

Simple CSV parser. You can transform your csv file into another, but with different delimiters and with or without headers.

Example:<br>
Input: <br>
1;"Л.Толстой ""Война и мир"" том 1";1873<br>
2;"Д.Роулинг ""Гарри Поттер и Узник Азкабана""";1999<br>
3;"И.Ильф; Е.Петров ""Двенадцать стульев""";1928<br>
4;"А.Кристи ""Десять негритят""";1939<br>
5;"С.Лем ""Солярис""";1960<br>

; - field delimiter<br>
" - text delimiter

We can set in code<br>
, - field delimiter<br>
' - text delimiter

Output will be:<br>
1,Л.Толстой "Война и мир" том 1,1873<br>
2,Д.Роулинг "Гарри Поттер и Узник Азкабана",1999<br>
3,'И.Ильф, Е.Петров "Двенадцать стульев"',1928<br>
4,А.Кристи "Десять негритят",1939<br>
5,С.Лем "Солярис",1960<br>
