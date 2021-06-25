package com.example.freshinsights.model;

import lombok.Getter;
import lombok.Setter;
import java.math.BigInteger;

@Getter
@Setter
public class Consumer {
    BigInteger id;
    String email;
    String event;

    @Override
    public String toString()
    {
        return "Consumer{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", event='" + event + '\'' +
                '}';
    }
}
