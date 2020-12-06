<h1>CSV parser</h1>

Simple CSV parser. You can transform your csv file into another, but with different delimiters and with or without headers.

Example:
Input: 
1;"Л.Толстой ""Война и мир"" том 1";1873
2;"Д.Роулинг ""Гарри Поттер и Узник Азкабана""";1999
3;"И.Ильф; Е.Петров ""Двенадцать стульев""";1928
4;"А.Кристи ""Десять негритят""";1939
5;"С.Лем ""Солярис""";1960

; - delimiter symbol
" - quotation symbol

We can set in code
, - delimiter symbol
' - quotation symbol

Output will be:
1,Л.Толстой "Война и мир" том 1,1873
2,Д.Роулинг "Гарри Поттер и Узник Азкабана",1999
3,'И.Ильф, Е.Петров "Двенадцать стульев"',1928
4,А.Кристи "Десять негритят",1939
5,С.Лем "Солярис",1960

