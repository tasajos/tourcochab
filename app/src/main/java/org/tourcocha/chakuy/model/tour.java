package org.tourcocha.chakuy.model;

public class tour {

    String datef,detail,locationlat,locationlong,name,order,type,ubicaciontotal,images;

    public tour(){}

    public tour(String datef, String detail, String locationlat, String locationlong, String name, String order, String type,String ubicaciontotal, String images ) {
        this.datef = datef;
        this.detail = detail;
        //this.locationlat = locationlat;
        //this.locationlong = locationlong;
        this.name = name;
        this.order = order;
        this.type = type;
        this.ubicaciontotal = ubicaciontotal;
        this.images = images;
    }

    public String getDatef() {
        return datef;
    }

    public void setDatef(String datef) {
        this.datef = datef;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    //public String getLocationlat() {
      //  return locationlat;
    //}

    //public void setLocationlat(String locationlat) {
      //  this.locationlat = locationlat;
    //}

    //public String getLocationlong() {
      //  return locationlong;
    //}

    //public void setLocationlong(String locationlong) {
      //  this.locationlong = locationlong;
    //}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getUbicaciontotal() {
        return ubicaciontotal;
    }

    public void setUbicaciontotal(String ubicaciontotal) {
        this.ubicaciontotal = ubicaciontotal;
    }
    //private String images;
    public String getImage() {
        return images;
    }

    public void setImage(String images) {
        this.images = images;
    }

}
