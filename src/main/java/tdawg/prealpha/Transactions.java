/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdawg.prealpha;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Bryan
 */
public class Transactions {
    private String name;
    private String ticker;
    private HashMap<String, Double> exchangeValues = new HashMap<String, Double>();

    public Transactions(String name, String ticker) {
        this.name = name;
        this.ticker = ticker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public HashMap<String, Double> getExchangeValues() {
        return exchangeValues;
    }

    public void setExchangeValues(HashMap<String, Double> exchangeValues) {
        this.exchangeValues = exchangeValues;
    }
    
    public void defaultValues(){
        String currency = this.name;
        
        switch(currency){
            case "BitCoin":
                this.exchangeValues.put("BTC", 55396.01);
                this.exchangeValues.put("ETH", 20.61);
                this.exchangeValues.put("BNB", 96.95);

                break;
            case "Etherium":
                this.exchangeValues.put("BTC", 0.04);
                this.exchangeValues.put("ETH", 2687.67);
                this.exchangeValues.put("BNB", 4.70);
;
                break;
            case "BinanceCoin":
                this.exchangeValues.put("BTC", 0.01);
                this.exchangeValues.put("ETH", 2687.67);
                this.exchangeValues.put("BNB", 0.21);

                break;                                     
        }
    }
    
    public static ArrayList<Transactions> init(){
        ArrayList<Transactions> currencies = new ArrayList<Transactions>();
        
        currencies.add(new Transactions("BitCoin", "BTC"));
        currencies.add(new Transactions("Ethereum", "ETH"));
        currencies.add(new Transactions("BinanceCoin", "BNB"));
        
        for(int i = 0; i < currencies.size(); i++){
            currencies.get(i).defaultValues();
        }
        return currencies;
    }
    
    public static Double convert(Double amount, Double exchangeValue){
        Double price;
        price = amount * exchangeValue;
        price = Math.round(price * 100d) / 100d;
        
        return price;
    }
    
    
}
