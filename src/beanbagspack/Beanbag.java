package beanbagspack;

public class Beanbag {
    int num;        //number of bean bags added
    String id;  //Respective ID for each beanbag
    String name;    //Name of the beanbags
    String manufacturer; //Manufacturer details
    String freeTextComponent;   //Option to add text
    //String variation;
    String reservationNumber;   //Reservation number
    short year; //Year manufactured
    byte month; //Month manufactured
    private int priceInPence;   //Price Beanbag
    public boolean reserved = false;
    public int reservationnum;
    private int totalNumberSold;
    private int totalRevenueFromBag;
    private int totalReserved;


    public Beanbag(int num, String name, String manufacturer, short year, byte month, String id, String freeTextComponent) {
        this.num = num;
        this.name = name;
        this.manufacturer = manufacturer;
        this.freeTextComponent = freeTextComponent;
        this.year = year;
        this.month = month;
        this.id = id;
        this.totalNumberSold = 0;
        this.totalRevenueFromBag = 0;
        this.totalReserved = 0;
//
//        if (month > 12) {
//            throw new InvalidMonthException("month number over 12");
//        } else if (month < 1) {
//            throw new InvalidMonthException("month number under 1");
//        }
//        if (num < 1) {
//            throw new IllegalNumberOfBeanBagsAddedException("number of beanbags less than 1");
//        }
//        this.id = toString();
//    }

//    static void addBeanBags(int num, String manufacturer, String name,
//                            String id, short year, byte month, String information) throws Exception {
//
//        if (month > 12) {
//            throw new InvalidMonthException("month number over 12");
//        } else if (month < 1) {
//            throw new InvalidMonthException("month number under 1");
//        }
//        if (num < 1) {
//            throw new IllegalNumberOfBeanBagsAddedException("number of beanbags less than 1");
//        }
//        if ()

    }

    public void setPriceInPence(int priceInPence) {
        this.priceInPence = priceInPence;
    }

    public int getPriceInPence() {
        return priceInPence;
    }

    public void increaseNumber(int num){ //function to increase number sales
        this.num += num;
    }

    public void decreaseNumber(int num){ //function to decrease number sales
        this.num -= num;
    }

    public String getID(){
        return this.id;
    }

    public int getNumberSold(){
        return this.totalNumberSold;
    }

    public int getTotalRevenue(){
        return this.totalRevenueFromBag;
    }
    public int getTotalReserved(){
        return this.totalReserved;
    }
}
