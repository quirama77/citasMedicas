package com.citasmedicas.citas.entities;

import java.util.List;

public class CountClient {

    private int total;
    private Client client;

    public CountClient(int total, Client client) {
        this.total = total;
        this.client = client;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
