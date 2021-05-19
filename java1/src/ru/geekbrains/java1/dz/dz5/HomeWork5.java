package ru.geekbrains.java1.dz.dz5;

public class HomeWork5 {
     public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Гаврилов Алексей Федорович","Директор", "dir_riograd@yandex.ru","89183544312", 135000, 38);
        persArray[1] = new Person("Портнова Ксения Петровна","Секретарь", "sekr_riograd@yandex.ru","89183544313", 25000, 25);
        persArray[2] = new Person("Панкратов Илья Семенович","Менеджер по продажам", "men_riograd@yandex.ru","89183544314", 80000, 29);
        persArray[3] = new Person("Ксенофонтов Аркадий Йосифович","Кладовщик", "sklad_riograd@yandex.ru","89183544315", 40000, 48);
        persArray[4] = new Person("Семенова Анна Карповна","Технический работник", "-","-", 15000, 53);

         for (Person person: persArray) {
             if (person.getAge()>40) person.printInfo();
         }
    }
}
