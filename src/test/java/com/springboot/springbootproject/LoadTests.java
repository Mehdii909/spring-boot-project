package com.springboot.springbootproject;

import org.jsmart.zerocode.core.domain.TestMapping;
import org.jsmart.zerocode.core.domain.LoadWith;

import org.jsmart.zerocode.core.domain.TestMappings;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.jsmart.zerocode.jupiter.extension.ParallelLoadExtension;

@ExtendWith({ParallelLoadExtension.class})

public class LoadTests {

    @Test
    @LoadWith("application-config.properties")
    @DisplayName("testing parallel load all database scenarios")
    @TestMappings({
            @TestMapping(testClass = DataBaseTests.class, testMethod = "testCreateProduit"),
            @TestMapping(testClass = DataBaseTests.class, testMethod = "testFindProduit"),
            @TestMapping(testClass = DataBaseTests.class, testMethod = "testUpdateProduit"),

    })


    public void testLoad() {
        // This space remains empty
    }
}
