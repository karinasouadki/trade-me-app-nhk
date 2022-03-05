package com.esgi.trademe.use_cases.subscription.domain;


import com.esgi.trademe.use_cases.profile.domain.Profile;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;
import java.util.Map;

public class Subscription {
    @Id
    private String id;
    @DBRef
    private Profile profile;
    private Date startDate;
    private Date endDate;
    private Map<Date, Payment> payments;
}
