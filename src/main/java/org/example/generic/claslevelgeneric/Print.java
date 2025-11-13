package org.example.generic.claslevelgeneric;

public class Print<T>{

    private T data;

    private String info;

    public String getInfo(){
        return info;
    }

    public void setInfo(String info){
        this.info = info;
    }

    Print(){

    }
    public Print(T data){
        this.data = data;
    }

    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data = data;
    }

    public void showData(){
        System.out.println("Data: & info " + data + " " + info);
    }

    @Override
    public String toString(){
        return "Print{" +
                "data=" + data +
                '}';
    }

    public static void main(String[] args){
        Print<String> stringPrint = new Print<>("Hello, Generics!");
        stringPrint.showData();

        Print<Integer> integerPrint = new Print<>();
        integerPrint.setData(100);
        integerPrint.setInfo("This is an integer value");
        integerPrint.showData();

        Print<Double> doublePrint = new Print<>(45.67);
        doublePrint.showData();
    }
}
