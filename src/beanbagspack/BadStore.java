package beanbagspack;

import java.io.IOException;


/**
 * beanbagspack.BadStore is a minimally compiling, but non-functioning implementor of the
 * beanbagspack.BeanBagStore interface.
 * 
 * @author Jonathan Fieldsend 
 * @version 1.1
 */
public class BadStore implements BeanBagStore
{
    ObjectArrayList stock = new ObjectArrayList();
    private ObjectArrayList reservedBags = new ObjectArrayList();
    private Integer totalSold = 0;
    private int totalRevenue = 0;
    private int reservationCount = 0;

    /**
     *Function to add the Beanbags to the stock
     */
    public void addBeanBags(int num, String manufacturer, String name,//Function to add beanbags to the stock
                            String id, short year, byte month)
    throws IllegalNumberOfBeanBagsAddedException, BeanBagMismatchException,
    IllegalIDException, InvalidMonthException {

        if (month > 12) {
        throw new InvalidMonthException("month number over 12");
    } else if (month < 1) {
        throw new InvalidMonthException("month number under 1");
    }
        if (num < 1) {
            throw new IllegalNumberOfBeanBagsAddedException("number of beanbags less than 1");
        }
        checkID(id);


        stock.add(new Beanbag(num, name, manufacturer, year, month, id, null)); // adding the Beanbags with all the respective properties
    }

    /**
     *Function to add the Beanbags to the stock
     */
    public void addBeanBags(int num, String manufacturer, String name, //Function to add beanbags to the stock
    String id, short year, byte month, String information)
    throws IllegalNumberOfBeanBagsAddedException, BeanBagMismatchException,
    IllegalIDException, InvalidMonthException { {

        if (month > 12) {
            throw new InvalidMonthException("month number over 12");
        } else if (month < 1) {
            throw new InvalidMonthException("month number under 1");
        }
        if (num < 1) {
            throw new IllegalNumberOfBeanBagsAddedException("number of beanbags less than 1");
        }
        checkID(id);
        stock.add(new Beanbag(num, name, manufacturer, year, month, id, information)); // adding the Beanbags with all the respective properties
    }}


    /**
     *Function to set the Beanbags prices
     */
    public void setBeanBagPrice(String id, int priceInPence)
    throws InvalidPriceException, BeanBagIDNotRecognisedException, IllegalIDException { // exception to throw in case of error as defensive programming
        boolean found = false;
        if (priceInPence < 1){
            throw new InvalidPriceException("The price cant be negative");
        }
        else if (stock.size() == 0) {
            throw new BeanBagIDNotRecognisedException("There are no beanbags in stock");
        } else {
            for (int i = 0; i < stock.size(); i++){
                Beanbag obj = (Beanbag) stock.get(i);
                if (obj.id == id){
                    obj.setPriceInPence(priceInPence);
                    stock.remove(i);
                    stock.add(obj);
                    found = true;
                }
            }
            if (found == false){
            throw new BeanBagIDNotRecognisedException("There is no Beanbag with this ID");}
        }

    }

    public void sellBeanBags(int num, String id) throws BeanBagNotInStockException,
    InsufficientStockException, IllegalNumberOfBeanBagsSoldException,
    PriceNotSetException, BeanBagIDNotRecognisedException, IllegalIDException {
        checkID(id);

        for (int i = 0; i < stock.size(); i++)
        {
            Beanbag obj = (Beanbag) stock.get(i);
            if (obj.id == id){
                if(obj.num > num)
                {
                    obj.num -= num;
                    stock.remove(i);
                    stock.add(obj);
                }

                else if(obj.num == num)
                {
                    stock.remove(i);
                }

                else{
                    throw new InsufficientStockException("the number of beanbags to sell is superior to the number of beanbags in stock");
                }
            }
        }
    }

    @Override
    public int reserveBeanBags(int num, String id) throws BeanBagNotInStockException, InsufficientStockException, IllegalNumberOfBeanBagsReservedException, PriceNotSetException, BeanBagIDNotRecognisedException, IllegalIDException {
        return 0;
    }


    public void unreserveBeanBags(int reservationNumber)
    throws ReservationNumberNotRecognisedException { }

    public void sellBeanBags(int reservationNumber)
    throws ReservationNumberNotRecognisedException { }

    public int beanBagsInStock() { return 0; }

    public int reservedBeanBagsInStock() { return 0; }


    /**
     *Function to know how many beanbags are in stock + the price
     */
    public int beanBagsInStock(String id) throws BeanBagIDNotRecognisedException,
    IllegalIDException {
        int totalBeanBag = 0;
        for (int i = 0; i < stock.size(); i++){
            Beanbag obj = (Beanbag) stock.get(i);
            System.out.println("obj id = " + obj.id);
            System.out.println("arg id = " + id);
            if (obj.id == id){

                totalBeanBag += + obj.getPriceInPence();
            }
        }
        return totalBeanBag;
    }

    public void saveStoreContents(String filename) throws IOException { }

    public void loadStoreContents(String filename) throws IOException,
    ClassNotFoundException { }

    public int getNumberOfDifferentBeanBagsInStock() { return 0; }

    public int getNumberOfSoldBeanBags() { return 0; }

    public int getNumberOfSoldBeanBags(String id) throws
    BeanBagIDNotRecognisedException, IllegalIDException { return 0; }

    public int getTotalPriceOfSoldBeanBags() { return 0; }

    public int getTotalPriceOfSoldBeanBags(String id) throws
    BeanBagIDNotRecognisedException, IllegalIDException { return 0; }

    public int getTotalPriceOfReservedBeanBags() { return 0; }

    public String getBeanBagDetails(String id) throws
    BeanBagIDNotRecognisedException, IllegalIDException { return ""; }



    /**
     *Function to set reset all the values
     */
    public void empty() {
            totalRevenue = 0;
            totalSold = 0;
            reservationCount = 0;
            stock = new ObjectArrayList();
            reservedBags = new ObjectArrayList();
        }

    /**
     *Function to set reset sold and revenue values
     */
    public void resetSaleAndCostTracking() {
        totalSold = 0;
        totalRevenue = 0;
    }

    public void replace(String oldId, String replacementId)
    throws BeanBagIDNotRecognisedException, IllegalIDException {
    }


    /**
     *Function to check if the ID is valid
     */
    private void checkID(String id) throws IllegalIDException {
        if (id.length() >= 8){
                throw new IllegalIDException("The ID is not the correct length");
        }
        if (id.length() < 0){
            throw new IllegalIDException("The ID is not the correct length");
        }
    }
}
