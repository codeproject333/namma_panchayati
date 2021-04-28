package com.webpage.PanchayatiDashboard.models;

public class work {
    private String work;
    private String status;
    private String year;
    private String garam;
    private String work_type;
    private String Total;



    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGaram() {
        return garam;
    }

    public void setGaram(String garam) {
        this.garam = garam;
    }

    public String getWork_type() {
        return work_type;
    }

    public void setWork_type(String work_type) {
        this.work_type = work_type;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    @Override
    public String toString() {
        return "work{" +

                ", work='" + work + '\'' +
                ", status='" + status + '\'' +
                ", year='" + year + '\'' +
                ", garam='" + garam + '\'' +
                ", work_type='" + work_type + '\'' +
                ", Total=" + Total +
                '}';
    }
}
