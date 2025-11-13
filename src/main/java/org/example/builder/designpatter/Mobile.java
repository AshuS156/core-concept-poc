package org.example.builder.designpatter;

public class Mobile{

    private String color;

    private String name;

    private String ram;

    private  String size;

    private Double price;


    private Mobile(Builder builder) {
        this.color = builder.color;
        this.price = builder.price;
        this.ram= builder.ram;
        this.size= builder.size;
        this.name= builder.name;
    }

    static class Builder {

        Builder() {

        }
        private String color;

        private String name;

        private String ram;

        private  String size;

        private Double price;

        public Builder setColor(String color) {
            this.color= color;
            return this;
        }

        public Builder setSize(String size) {
            this.size= size;
            return this;
        }

        public Builder setRam(String ram) {
            this.ram= ram;
            return this;
        }

        public Builder setPrice(Double price) {
            this.price= price;
            return this;
        }
        public Builder setName(String name) {
            this.name= name;
            return this;
        }

        public Mobile buildMobileObject() {
            return new Mobile(this);
        }
    }
}
