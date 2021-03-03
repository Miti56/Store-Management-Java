package beanbagspack;


import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BadStore store = new BadStore();

        store.addBeanBags(15,"leo","red","7", (short)2019, (byte) 11,"infoi");
        store.setBeanBagPrice("7",15);
        System.out.println(store.beanBagsInStock("7"));
        store.sellBeanBags(12,"7");
        System.out.println(store.beanBagsInStock("7"));

    }
}
