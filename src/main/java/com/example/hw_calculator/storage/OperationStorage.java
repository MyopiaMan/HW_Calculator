package com.example.hw_calculator.storage;

import java.util.List;

public interface OperationStorage {
    void save();
    List<?> findAll();

}
