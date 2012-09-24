package com.zople.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@Named
@RequestScoped
public class TableBean implements Serializable {
    
    private LazyDataModel lazyData;
    private final static String[] colors;
    private final static String[] manufacturers;
    private List<Car> cars;
    public TableBean(){
        System.out.println("sssss");
        lazyData=new LazyDataModel(){

            @Override
            public List load(int first, int pageSize, String sortField, SortOrder sortOrder, Map filters) {
                System.out.print(first);
                System.out.print(pageSize);
                List<Car> list=new ArrayList<Car>();
                populateRandomCars(list,78);
                this.setRowCount(78);
                this.setPageSize(pageSize);
                this.setRowIndex(first);
                return list;
              
            }
        };
    
    }
    
    
    
    
    static {
        colors = new String[10];
        colors[0] = "Black";
        colors[1] = "White";
        colors[2] = "Green";
        colors[3] = "Red";
        colors[4] = "Blue";
        colors[5] = "Orange";
        colors[6] = "Silver";
        colors[7] = "Yellow";
        colors[8] = "Brown";
        colors[9] = "Maroon";

        manufacturers = new String[10];
        manufacturers[0] = "Mercedes";
        manufacturers[1] = "BMW";
        manufacturers[2] = "Volvo";
        manufacturers[3] = "Audi";
        manufacturers[4] = "Renault";
        manufacturers[5] = "Opel";
        manufacturers[6] = "Volkswagen";
        manufacturers[7] = "Chrysler";
        manufacturers[8] = "Ferrari";
        manufacturers[9] = "Ford";
    }
    private void populateRandomCars(List<Car> list, int size) {
        for (int i = 0; i < size; i++) {
            list.add(new Car(getRandomModel(), getRandomYear(), getRandomManufacturer(), getRandomColor()));
        }
    }
    
    private int getRandomYear() {
        return (int) (Math.random() * 50 + 1960);
    }

    private String getRandomColor() {
        return colors[(int) (Math.random() * 10)];
    }

    private String getRandomManufacturer() {
        return manufacturers[(int) (Math.random() * 10)];
    }

    public List<Car> getCars() {
        return cars;
    }

    public LazyDataModel getLazyData() {
        return lazyData;
    }

    public void setLazyData(LazyDataModel lazyData) {
        this.lazyData = lazyData;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    private String getRandomModel() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
