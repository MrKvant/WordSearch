# WordSearch
Консольное приложение для поиска слова в файле.

### Параметры:
```-i``` -исходный файл формата CSV.

```-q``` -строка поиска(Может быть регулярным выражением).

```-o``` -файл результата.

### Файл результата может быть двух типов:
+ CSV
+ TXT

### Пример входного CSV:

```csv
two one cat
two girls fox
result grep sometimes
fear cap one
```
### Пример выходных файлов:

#### java -jar wordsearch.jar -i input.csv -q one -o out.csv

##### out.csv
```csv
one girls grep cap
cat fox sometimes one
```
##### out.txt

```csv
one
girls
grep
cap
cat
fox
sometimes
one
```

```
Для того чтобы запустить программу, нужно скачать её из папки target/wordsearch.jar
```

