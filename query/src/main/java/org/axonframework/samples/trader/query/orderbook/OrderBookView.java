/*
 * Copyright (c) 2010-2012. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.axonframework.samples.trader.query.orderbook;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jettro Coenradie
 */
@Entity
public class OrderBookView {

    @Id
    @javax.persistence.Id
    private String identifier;
    private String companyIdentifier;
    private String companyName;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "ORDERENTRY_SELL", joinColumns = @JoinColumn(name = "ORDERBOOK_ID"), inverseJoinColumns = @JoinColumn(name = "ORDER_ID"))
    private List<OrderView> sellOrders = new ArrayList<>();
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "ORDERENTRY_BUY", joinColumns = @JoinColumn(name = "ORDERBOOK_ID"), inverseJoinColumns = @JoinColumn(name = "ORDER_ID"))
    private List<OrderView> buyOrders = new ArrayList<>();

    public List<OrderView> sellOrders() {
        return sellOrders;
    }

    public List<OrderView> buyOrders() {
        return buyOrders;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCompanyIdentifier() {
        return companyIdentifier;
    }

    public void setCompanyIdentifier(String companyIdentifier) {
        this.companyIdentifier = companyIdentifier;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<OrderView> getBuyOrders() {
        return buyOrders;
    }

    public void setBuyOrders(List<OrderView> buyOrders) {
        this.buyOrders = buyOrders;
    }

    public List<OrderView> getSellOrders() {
        return sellOrders;
    }

    public void setSellOrders(List<OrderView> sellOrders) {
        this.sellOrders = sellOrders;
    }
}
