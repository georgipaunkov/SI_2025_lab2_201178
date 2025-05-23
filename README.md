# SI_2025_lab2_201234

**Георги Паунков 201178**

-----

## Одговори

### 2.Control Flow Graph

![CFG Image](https://i.imgur.com/JoVTMNJ.png)

Алтернатива (Github Repo):  
[https://github.com/georgipaunkov/SI_2025_lab2_201178/blob/master/siDomasna2.png](https://github.com/georgipaunkov/SI_2025_lab2_201178/blob/master/siDomasna2.png)

### 3.Пресметка на цикломатската комплексност и објаснување

**Цикломатската комплексност е 9**

**M=D(одлуки во кодот)+1**
**M=8+1**
**Oва ни кажува дека имаме 9 независни патеки односно ни требаат минимум 9 тест случаи за тестирање**

### 4.Пишење на тест случаи според Every Statement

**Mораме да имаме минимум 3 тест случаи**

``
void test_item_bezPopust_bezOdbivanje() {``

    Item item = new Item("Jabolko", 2, 100, 0.0); // 2 x 100 = 200
    String card = "1234567890123456";
    double rez = SILab2.checkCart(List.of(item), card);
    tvrdenjeZaEdnakvost(200, rez);
``}
``

``void test_itemSoPopust_iOdbivanje() {``

    Item item = new Item("TV", 1, 400, 0.25); // 400 - 30 = 370; 400 * 0.75 = 300
    String card = "1111222233334444";
    double rez = SILab2.checkCart(List.of(item), card);
    tvrdenjeZaEdnakvost(270, rez); // 300 - 30 = 270
``}``

``void test_nevalidnaKartica_FrlaException() {``

    Item item = new Item("Leb", 1, 50, 0.0);
    RuntimeException ex = ThrowsEx(RuntimeException.class, () ->
        SILab2.checkCart(List.of(item), "12345INVALIDCARD")
    );
    tvrdenjeTocnost(ex.getMessage().contains("Invalid character"));
``}``

**Tест 1 - Проверуваме дали item-от е валиден,нема попуст,нема одбивање,и картицата е валидна**</br>
**Тест 2 - price >300-->sum-=30,discount>0-->со оваа  пресметуваме попуст, и картицата е валидна**</br>
**Тест 3 - Валиден item,но невалидна картица имаме букви во неа и фрла исклучок**

### 5.Multiple Condition критериум


**Имаме 3 услови во if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10)**

Услов 1: item.getPrice() > 300</br>
Услов 2: item.getDiscount() > 0</br>
Услов 3: item.getQuantity() > 10</br>

**Имаме ||-или што значи дека треба да ја тестираме секоја можност на условите 1,2,3 истите можат да бидат 1 или 0 --> 2на3 степен бидејки се 3 услови со 2 краја значи минимално тест случаеви мораме да имаме 8**


**1-true 0-false**

<b>1.price=100,discount=0,quantity=2 --> 0,0,0 --> Сите услови се неточни</br>
2.price=350,discount=0,quantity=2 --> 1,0,0 --> price>300 е доволно за да помине</br>
3.price=100,discount=50,quantity=2 --> 0,1,0 --> discount>0 e доволно за да помине</br>
4.price=100,discount=0,quantity=15 --> 0,0,1 --> quantity>10 е доволно за да помине</br>
5.price=500,discount=20,quantity=2 --> 1,1,0 --> price&discount условите се точни</br>
6.price=400,discount=0,quantity=20 --> 1,0,1 --> price&quantity условите се точни</br>
7.price=100,discount=50,quantity=20 --> 0,1,1 --> discount&quantity условите се точни</br>
8.price=1000,discount=80,quantity=30 --> 1,1,1 --> сите услови се точни</br></b>



