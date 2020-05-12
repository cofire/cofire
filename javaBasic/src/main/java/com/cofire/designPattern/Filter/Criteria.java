package com.cofire.designPattern.Filter;

import java.util.List;

public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}