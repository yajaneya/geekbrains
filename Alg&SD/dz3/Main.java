package ru.geekbrains.Alg_SD.dz.dz3;

public class Main {
    public static void main(String[] args) {

        /* Тест стека */
        Stack st = new Stack(3);
        st.insert(5);
        st.insert(15);
        st.insert(23);
        st.insert(0);
        st.insert(1000);
        st.display();
        st.remove();
        st.display();
        st.remove();
        st.display();
        st.remove();
        st.display();
        st.remove();
        st.display();
        st.remove();


        /* Тест очереди */
        Queue q = new Queue(5);
        q.insert(12);
        q.insert(13);
        q.insert(14);
        q.insert(15);
        q.insert(16);
        q.remove();
        q.remove();
        q.remove();
        q.insert(17);
        q.insert(18);
        System.out.println(q.getFront());
        System.out.println(q.getRear());
        q.display();
    }
}
